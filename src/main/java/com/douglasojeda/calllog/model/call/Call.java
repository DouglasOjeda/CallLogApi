package com.douglasojeda.calllog.model.call;

import com.douglasojeda.calllog.model.phonenumber.PhoneNumber;
import com.douglasojeda.calllog.model.user.User;
import jakarta.persistence.*;

/**
 * Represents a single call in the call log system, including participants,
 * phone numbers, timestamps, and current status.
 */
@Entity
@Table(name = "calls")
public class Call {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long callId;
    private String createdAt;
    private String answeredAt;
    private String endedAt;

    @Enumerated(EnumType.STRING)
    private CallStatus status;

    @ManyToOne
    @JoinColumn(name = "caller_id")
    private User caller;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private User recipient;

    @ManyToOne
    @JoinColumn(name = "from_number_id")
    private PhoneNumber fromNumber;
    @ManyToOne
    @JoinColumn(name = "to_number_id")
    private PhoneNumber toNumber;

    public Call() {}

    public Call(Long callId, String createdAt, String answeredAt, String endedAt, CallStatus status, User caller,
                User recipient, PhoneNumber fromNumber, PhoneNumber toNumber) {
        this.callId = callId;
        this.createdAt = createdAt;
        this.answeredAt = answeredAt;
        this.endedAt = endedAt;
        this.status = status;
        this.caller = caller;
        this.recipient = recipient;
        this.fromNumber = fromNumber;
        this.toNumber = toNumber;
    }

    // Getters and setters below

    public Long getCallId() {
        return callId;
    }

    public void setCallId(Long callId) {
        this.callId = callId;
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
