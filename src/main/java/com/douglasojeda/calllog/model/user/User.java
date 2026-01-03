package com.douglasojeda.calllog.model.user;

import jakarta.persistence.*;

import java.util.ArrayList;
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
            inverseJoinColumns = @JoinColumn(name = "contact_id"), // FK to contact User
            uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "contact_id"})
    )
    private List<User> contacts = new ArrayList<>();

    protected User() {

    }

    public User(String displayName) {
        this.displayName = displayName;
    }

    // Field modification

    public Long getUserId() {
        return userId;
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
        this.contacts = (contacts == null) ? new ArrayList<>() : contacts;
    }

    public void addContact(User contact) {
        if (contact == null || contact.getUserId() == null)
            return;
        boolean exists = contacts.stream()
                .anyMatch(u -> u.getUserId() != null && u.getUserId().equals(contact.getUserId()));
        if (!exists)
            contacts.add(contact);
    }

    public void removeContact(User contact) {
        if (contact == null || contact.getUserId() == null) return;
        contacts.removeIf(u -> u.getUserId() != null && u.getUserId().equals(contact.getUserId()));
    }
}
