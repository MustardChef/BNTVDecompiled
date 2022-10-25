package com.facebook.internal.logging;

import java.io.Serializable;

/* loaded from: classes.dex */
public class LogEvent implements Serializable {
    private static final long serialVersionUID = 1;
    private String eventName;
    private LogCategory logCategory;

    public LogEvent(String str, LogCategory logCategory) {
        this.eventName = str;
        this.logCategory = logCategory;
    }

    public String getEventName() {
        return this.eventName;
    }

    public LogCategory getLogCategory() {
        return this.logCategory;
    }

    public String upperCaseEventName() {
        String upperCase = this.eventName.toUpperCase();
        this.eventName = upperCase;
        return upperCase;
    }
}
