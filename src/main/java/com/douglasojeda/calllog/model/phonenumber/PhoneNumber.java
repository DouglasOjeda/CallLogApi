package com.douglasojeda.calllog.model.phonenumber;

import com.douglasojeda.calllog.model.user.User;
import jakarta.persistence.*;

/**
 * Represents a phone number in the call log system.
 */
@Entity
@Table(name = "phone_numbers")
public class PhoneNumber {
    @Id
    private long phoneNumberId;
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    public PhoneNumber() {}

    public PhoneNumber(long phoneNumberId, String phoneNumber, User owner) {
        this.phoneNumberId = phoneNumberId;
        this.phoneNumber = phoneNumber;
        this.owner = owner;
    }

    // Getters and setters below

    public long getPhoneNumberId() {
        return phoneNumberId;
    }

    public void setPhoneNumberId(long phoneNumberId) {
        this.phoneNumberId = phoneNumberId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
