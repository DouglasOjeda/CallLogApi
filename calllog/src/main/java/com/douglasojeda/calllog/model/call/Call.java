package com.douglasojeda.calllog.model.call;

import com.douglasojeda.calllog.model.phonenumber.PhoneNumber;
import com.douglasojeda.calllog.model.user.User;

/**
 * Represents a single call in the call log system, including participants,
 * phone numbers, timestamps, and current status.
 */
public class Call {
    /** Unique identifier for this call record. */
    private long id;
    private String createdAt;
    private String answeredAt;
    private String endedAt;
    private CallStatus status;
    private User caller;
    private User recipient;
    private PhoneNumber fromNumber;
    private PhoneNumber toNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAnsweredAt() {
        return answeredAt;
    }

    public void setAnsweredAt(String answeredAt) {
        this.answeredAt = answeredAt;
    }

    public String getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(String endedAt) {
        this.endedAt = endedAt;
    }

    public CallStatus getStatus() {
        return status;
    }

    public void setStatus(CallStatus status) {
        this.status = status;
    }

    public User getCaller() {
        return caller;
    }

    public void setCaller(User caller) {
        this.caller = caller;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public PhoneNumber getFromNumber() {
        return fromNumber;
    }

    public void setFromNumber(PhoneNumber fromNumber) {
        this.fromNumber = fromNumber;
    }

    public PhoneNumber getToNumber() {
        return toNumber;
    }

    public void setToNumber(PhoneNumber toNumber) {
        this.toNumber = toNumber;
    }
}
