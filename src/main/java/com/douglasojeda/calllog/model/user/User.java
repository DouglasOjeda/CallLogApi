package com.douglasojeda.calllog.model.user;

import jakarta.persistence.*;

import java.util.List;

/**
 * Represents a user in the call log system, including their display name,
 * associated contacts, call history, and phone numbers.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String displayName;

    @ManyToMany
    @JoinTable(
            name = "user_contacts",
            joinColumns = @JoinColumn(name = "user_id"),          // FK to this User
            inverseJoinColumns = @JoinColumn(name = "contact_id") // FK to contact User
    )
    private List<User> contacts;

    public User() {

    }

    public User(Long userId, String displayName, List<User> contacts) {
        this.userId = userId;
        this.displayName = displayName;
        this.contacts = contacts;
    }

    // Getters and setters below

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<User> getContacts() {
        return contacts;
    }

    public void setContacts(List<User> contacts) {
        this.contacts = contacts;
    }
}
