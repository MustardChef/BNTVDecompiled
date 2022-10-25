package com.google.android.gms.cast;

import com.google.android.gms.common.api.CommonStatusCodes;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class CastStatusCodes extends CommonStatusCodes {
    public static final int APPLICATION_NOT_FOUND = 2004;
    public static final int APPLICATION_NOT_RUNNING = 2005;
    public static final int AUTHENTICATION_FAILED = 2000;
    public static final int CANCELED = 2002;
    public static final int DEVICE_CONNECTION_SUSPENDED = 2016;
    public static final int ERROR_CAST_PLATFORM_INCOMPATIBLE = 2110;
    public static final int ERROR_CAST_PLATFORM_NOT_CONNECTED = 2113;
    public static final int ERROR_DEVICE_ID_FLAGS_NOT_SET = 2115;
    public static final int ERROR_HOST_NOT_ALLOWED = 2112;
    public static final int ERROR_NO_CAST_CONFIGURATION = 2114;
    public static final int ERROR_SERVICE_CREATION_FAILED = 2200;
    public static final int ERROR_SERVICE_DISCONNECTED = 2201;
    public static final int ERROR_STOPPING_SERVICE_FAILED = 2202;
    public static final int ERROR_URL_INSEURE = 2111;
    public static final int FAILED = 2100;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 14;
    public static final int INVALID_REQUEST = 2001;
    public static final int MEDIA_ERROR = 2104;
    public static final int MESSAGE_SEND_BUFFER_TOO_FULL = 2007;
    public static final int MESSAGE_TOO_LARGE = 2006;
    public static final int NETWORK_ERROR = 7;
    public static final int NOT_ALLOWED = 2003;
    public static final int REPLACED = 2103;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 15;
    public static final int UNKNOWN_ERROR = 13;

    private CastStatusCodes() {
    }

    public static String getStatusCodeString(int i) {
        if (i >= -999 && i <= 999) {
            return i != 0 ? i != 7 ? i != 14 ? i != 15 ? CommonStatusCodes.getStatusCodeString(i) : "TIMEOUT" : "INTERRUPTED" : "NETWORK_ERROR" : "SUCCESS";
        } else if (i >= 2000 && i <= 2099) {
            if (i != 2015) {
                switch (i) {
                    case 2000:
                        return "AUTHENTICATION_FAILED";
                    case 2001:
                        return "INVALID_REQUEST";
                    case 2002:
                        return "CANCELED";
                    case 2003:
                        return "NOT_ALLOWED";
                    case 2004:
                        return "APPLICATION_NOT_FOUND";
                    case 2005:
                        return "APPLICATION_NOT_RUNNING";
                    case 2006:
                        return "MESSAGE_TOO_LARGE";
                    case 2007:
                        return "MESSAGE_SEND_BUFFER_TOO_FULL";
                    default:
                        return String.format(Locale.ROOT, "%s %d", "Common cast status code", Integer.valueOf(i));
                }
            }
            return "TCP_PROBER_FAIL_TO_VERIFY_DEVICE";
        } else if (i < 2100 || i > 2109) {
            if (i < 2105 || i > 2159) {
                if (i < 2200 || i > 2219) {
                    if (i < 2250 || i > 2279) {
                        if (i < 2300 || i > 2309) {
                            if (i < 2310 || i > 2319) {
                                if (i < 2350 || i > 2359) {
                                    if (i < 2400 || i > 2419) {
                                        if (i < 2450 || i > 2469) {
                                            if (i < 2470 || i > 2479) {
                                                return (i < 2490 || i > 2499) ? String.format(Locale.ROOT, "Unknown cast status code %d", Integer.valueOf(i)) : String.format(Locale.ROOT, "%s %d", "Cast media loading status code", Integer.valueOf(i));
                                            }
                                            return String.format(Locale.ROOT, "%s %d", "Cast application status code", Integer.valueOf(i));
                                        }
                                        return String.format(Locale.ROOT, "%s %d", "Cast nearby casting status code", Integer.valueOf(i));
                                    }
                                    return String.format(Locale.ROOT, "%s %d", "Cast relay casting status code", Integer.valueOf(i));
                                }
                                return String.format(Locale.ROOT, "%s %d", "Cast multizone device status code", Integer.valueOf(i));
                            }
                            return String.format(Locale.ROOT, "%s %d", "Endpoint switch status code", Integer.valueOf(i));
                        }
                        return String.format(Locale.ROOT, "%s %d", "Cast service status code", Integer.valueOf(i));
                    }
                    return String.format(Locale.ROOT, "%s %d", "Cast socket status code", Integer.valueOf(i));
                }
                return String.format(Locale.ROOT, "%s %d", "Cast remote display status code", Integer.valueOf(i));
            }
            return String.format(Locale.ROOT, "%s %d", "Cast session status code", Integer.valueOf(i));
        } else {
            return String.format(Locale.ROOT, "%s %d", "Media control channel status code", Integer.valueOf(i));
        }
    }
}
