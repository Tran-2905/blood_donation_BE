package com.royce.blood_donation.services.OTP;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
@RequiredArgsConstructor
public class EmailServce implements IEmailService {
    private final JavaMailSender mailSender;

    private final OtpStorageService otpStorageService;



    @Override
    public void sendOtp(String email) {
        String otp = generateOtp();
        otpStorageService.storeOtp(email, otp);

//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(email);
//        message.setSubject("Your OTP Code");
//        message.setText("Your OTP is: " + otp + "\nIt is valid for 5 minutes.");

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(email);
            helper.setSubject("Blood Donation System - OTP Verification");

            String htmlContent = String.format("""
    <div style="background-color:#ffffff;padding:30px;color:#333;font-family:sans-serif;border:1px solid #e53935;max-width:520px;margin:auto;border-radius:8px;">
        <div style="text-align:center;">
            <!-- Vòng tròn đỏ với icon trái tim trắng -->
            <div style="width:60px;height:60px;border-radius:50%%;background-color:#f44336;margin:auto;margin-bottom:16px;display:flex;align-items:center;justify-content:center;">
                <svg xmlns="http://www.w3.org/2000/svg" width="28" height="28" fill="none" stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                    <path d="M19 14c1.49-1.46 3-3.21 3-5.5A5.5 5.5 0 0 0 16.5 3c-1.76 0-3 .5-4.5 2-1.5-1.5-2.74-2-4.5-2A5.5 5.5 0 0 0 2 8.5c0 2.3 1.5 4.05 3 5.5l7 7Z"/>
                </svg>
            </div>
            <h2 style="color:#e53935;margin:0;">BloodDonationSystem</h2>
            <p style="margin-top:4px;color:#888;">Hệ thống kết nối người hiến máu</p>
        </div>

        <div style="margin-top:30px;">
            <h3 style="color:#e53935;text-align:center;">Xác minh đăng nhập</h3>
            <p style="text-align:center;">Chúng tôi đã nhận được yêu cầu đăng nhập hoặc xác minh tài khoản. Vui lòng sử dụng mã OTP bên dưới:</p>
            <div style="background-color:#fbe9e7;padding:20px;border-radius:10px;text-align:center;margin:20px 0;">
                <p style="margin:0;color:#d84315;">MÃ XÁC THỰC</p>
                <h1 style="color:#e53935;font-size:36px;margin:5px 0;">%s</h1>
            </div>
            <p style="text-align:center;color:#d32f2f;font-weight:bold;">Mã có hiệu lực trong 5 phút</p>
        </div>

        <p style="font-size:13px;color:#888;text-align:center;margin-top:30px;">
            Nếu bạn không thực hiện yêu cầu này, hãy bỏ qua email này và đảm bảo tài khoản của bạn được an toàn.
        </p>
        <hr style="border:none;border-top:1px solid #eee;margin:30px 0;">
        <p style="font-size:12px;color:#999;text-align:center;">
            ⚠️ Không chia sẻ mã này cho bất kỳ ai. Hệ thống sẽ không bao giờ yêu cầu mã OTP qua điện thoại hoặc email.
        </p>
    </div>
""", otp);
            helper.setText(htmlContent, true); // `true` to send as HTML

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send OTP email", e);
        }
    }

    private String generateOtp() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000)); // 6-digit OTP
    }
}
