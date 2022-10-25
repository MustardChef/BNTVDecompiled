package com.facebook.internal.logging;

import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public interface ExternalLog extends Serializable {
    JSONObject convertToJSONObject();

    String getEventName();

    LogCategory getLogCategory();
}
