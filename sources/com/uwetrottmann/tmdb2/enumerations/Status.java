package com.uwetrottmann.tmdb2.enumerations;

import com.facebook.internal.AnalyticsEvents;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public enum Status {
    RUMORED("Rumored"),
    PLANNED("Planned"),
    IN_PRODUCTION("In Production"),
    POST_PRODUCTION("Post Production"),
    RELEASED("Released"),
    CANCELLED(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED);
    
    private static final Map<String, Status> STRING_MAPPING = new HashMap();
    public final String value;

    static {
        Status[] values;
        for (Status status : values()) {
            STRING_MAPPING.put(status.toString().toUpperCase(), status);
        }
    }

    Status(String str) {
        this.value = str;
    }

    public static Status fromValue(String str) {
        return STRING_MAPPING.get(str.toUpperCase());
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
