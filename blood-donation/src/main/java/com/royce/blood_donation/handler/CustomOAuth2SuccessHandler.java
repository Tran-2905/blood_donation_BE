package com.royce.blood_donation.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.royce.blood_donation.models.User;
import com.royce.blood_donation.services.JWTService;
import com.royce.blood_donation.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@RequiredArgsConstructor
@Component
public class CustomOAuth2SuccessHandler implements AuthenticationSuccessHandler {
    private final UserService userService;
    private final JWTService jwtService;
    private final ObjectMapper objectMapper;

    @Value("${frontend.redirect-url}")
    private String redirectUrl;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();

        // 1. Lấy thông tin từ Google
        String email = oAuth2User.getAttribute("email");
        String googleId = oAuth2User.getAttribute("sub");
        String firstName = oAuth2User.getAttribute("given_name");
        String lastName = oAuth2User.getAttribute("family_name");

        // 2. Tạo hoặc tìm user trong hệ thống
        User user = userService.findOrCreateUserFromOAuth(email, googleId, firstName, lastName);

        // 3. Sinh JWT token
        String accessToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

        // 4. Chuẩn bị payload gửi về frontend
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("accessToken", accessToken);
        responseBody.put("refreshToken", refreshToken);
        responseBody.put("user", Map.of(
                "userId", user.getId(),
                "email", user.getEmail(),
                "firstName", user.getFirstName(),
                "lastName", user.getLastName(),
                "role", user.getRole()
        ));

        // 5. Gửi payload về cửa sổ Angular bằng postMessage
        String html = "<html><body><script>" +
                "window.opener.postMessage(" + objectMapper.writeValueAsString(responseBody) + ", '*');" +
                "window.close();" +
                "</script></body></html>";

        response.setContentType("text/html");
        response.getWriter().write(html);
    }
}
