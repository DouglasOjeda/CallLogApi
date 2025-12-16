package com.douglasojeda.calllog.model.call;

/**
 * Represents the lifecycle status of a call in the call logging system.
 *
 * <p>A call typically moves through these states in order:
 * {@link #QUEUED} → {@link #RINGING} → {@link #IN_PROGRESS} → {@link #COMPLETED}.
 * Some calls may instead end in {@link #NO_ANSWER}, {@link #BUSY},
 * {@link #FAILED}, or {@link #CANCELED}.</p>
 */
public enum CallStatus {

    /** Call has been accepted by the system but not yet sent to the carrier or destination. */
    QUEUED,

    /** Call is ringing at the destination endpoint. */
    RINGING,

    /** Call has been answered and is currently in progress. */
    IN_PROGRESS,

    /** Call completed successfully and ended normally. */
    COMPLETED,

    /** Call failed due to an error (e.g. network, routing, or internal failure). */
    FAILED,

    /** Call reached the destination but was not answered before timing out. */
    NO_ANSWER,

    /** Call could not be completed because the destination was busy. */
    BUSY,

    /** Call was actively canceled before it was answered (e.g. caller hung up). */
    CANCELED
}
