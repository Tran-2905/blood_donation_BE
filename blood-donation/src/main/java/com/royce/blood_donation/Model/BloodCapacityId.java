package com.royce.blood_donation.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;
@Data
@Embeddable
public class BloodCapacityId implements Serializable {
    @Column(name = "donor_blood_type_id")
    private int donorBloodTypeId;

    @Column(name = "recipient_blood_type_id")
    private int recipientBloodTypeId;

    @Column(name = "component_id")
    private int componentId;

    // bắt buộc phải có equals() và hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BloodCapacityId)) return false;
        BloodCapacityId that = (BloodCapacityId) o;
        return donorBloodTypeId == that.donorBloodTypeId &&
                recipientBloodTypeId == that.recipientBloodTypeId &&
                componentId == that.componentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(donorBloodTypeId, recipientBloodTypeId, componentId);
    }
}
