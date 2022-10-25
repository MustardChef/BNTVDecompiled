package com.google.android.gms.cast.framework;

import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class CastState {
    public static final int CONNECTED = 4;
    public static final int CONNECTING = 3;
    public static final int NOT_CONNECTED = 2;
    public static final int NO_DEVICES_AVAILABLE = 1;

    private CastState() {
    }

    public static String toString(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? String.format(Locale.ROOT, "UNKNOWN_STATE(%d)", Integer.valueOf(i)) : "CONNECTED" : "CONNECTING" : "NOT_CONNECTED" : "NO_DEVICES_AVAILABLE";
    }
}
