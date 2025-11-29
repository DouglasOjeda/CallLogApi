package com.douglasojeda.calllog.model.phonenumber;

import com.douglasojeda.calllog.model.user.User;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

/**
 * Represents a phone number in the call log system.
 */
@Entity
@Table(name = "phone_numbers")
public class PhoneNumber {
    @Id
    private long id;
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    public PhoneNumber(long id, String phoneNumber, User owner) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.owner = owner;
    }

    public PhoneNumber() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
