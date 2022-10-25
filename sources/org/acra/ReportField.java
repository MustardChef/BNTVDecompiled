package org.acra;

import java.util.Arrays;
import kotlin.Metadata;

/* compiled from: ReportField.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b+\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+¨\u0006,"}, m107d2 = {"Lorg/acra/ReportField;", "", "(Ljava/lang/String;I)V", "REPORT_ID", "APP_VERSION_CODE", "APP_VERSION_NAME", "PACKAGE_NAME", "FILE_PATH", "PHONE_MODEL", "ANDROID_VERSION", "BUILD", "BRAND", "PRODUCT", "TOTAL_MEM_SIZE", "AVAILABLE_MEM_SIZE", "BUILD_CONFIG", "CUSTOM_DATA", "STACK_TRACE", "STACK_TRACE_HASH", "INITIAL_CONFIGURATION", "CRASH_CONFIGURATION", "DISPLAY", "USER_COMMENT", "USER_APP_START_DATE", "USER_CRASH_DATE", "DUMPSYS_MEMINFO", "DROPBOX", "LOGCAT", "EVENTSLOG", "RADIOLOG", "IS_SILENT", "DEVICE_ID", "INSTALLATION_ID", "USER_EMAIL", "DEVICE_FEATURES", "ENVIRONMENT", "SETTINGS_SYSTEM", "SETTINGS_SECURE", "SETTINGS_GLOBAL", "SHARED_PREFERENCES", "APPLICATION_LOG", "MEDIA_CODEC_LIST", "THREAD_DETAILS", "USER_IP", "acra-javacore"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public enum ReportField {
    REPORT_ID,
    APP_VERSION_CODE,
    APP_VERSION_NAME,
    PACKAGE_NAME,
    FILE_PATH,
    PHONE_MODEL,
    ANDROID_VERSION,
    BUILD,
    BRAND,
    PRODUCT,
    TOTAL_MEM_SIZE,
    AVAILABLE_MEM_SIZE,
    BUILD_CONFIG,
    CUSTOM_DATA,
    STACK_TRACE,
    STACK_TRACE_HASH,
    INITIAL_CONFIGURATION,
    CRASH_CONFIGURATION,
    DISPLAY,
    USER_COMMENT,
    USER_APP_START_DATE,
    USER_CRASH_DATE,
    DUMPSYS_MEMINFO,
    DROPBOX,
    LOGCAT,
    EVENTSLOG,
    RADIOLOG,
    IS_SILENT,
    DEVICE_ID,
    INSTALLATION_ID,
    USER_EMAIL,
    DEVICE_FEATURES,
    ENVIRONMENT,
    SETTINGS_SYSTEM,
    SETTINGS_SECURE,
    SETTINGS_GLOBAL,
    SHARED_PREFERENCES,
    APPLICATION_LOG,
    MEDIA_CODEC_LIST,
    THREAD_DETAILS,
    USER_IP;

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static ReportField[] valuesCustom() {
        ReportField[] valuesCustom = values();
        return (ReportField[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }
}
