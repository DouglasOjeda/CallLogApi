package com.douglasojeda.calllog.model.user;

import com.douglasojeda.calllog.model.call.Call;
import com.douglasojeda.calllog.model.phonenumber.PhoneNumber;

import java.util.List;

/**
 * Represents a user in the call log system, including their display name,
 * associated contacts, call history, and phone numbers.
 */
public class User {

    /** Unique identifier for this user. */
    private long id;

    private String displayName;
    private User contacts;
    private List<Call> callLog;
    private List<PhoneNumber> phoneNumbers;

    public User(long id, String displayName, User contacts, List<Call> callLog, List<PhoneNumber> phoneNumbers) {
        this.id = id;
        this.displayName = displayName;
        this.contacts = contacts;
        this.callLog = callLog;
        this.phoneNumbers = phoneNumbers;
    }

    // Getters and setters below

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public User getContacts() {
        return contacts;
    }

    public void setContacts(User contacts) {
        this.contacts = contacts;
    }

    public List<Call> getCallLog() {
        return callLog;
    }

    public void setCallLog(List<Call> callLog) {
        this.callLog = callLog;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
