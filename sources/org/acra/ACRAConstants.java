package org.acra;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ACRAConstants.kt */
@Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m107d2 = {"Lorg/acra/ACRAConstants;", "", "()V", "APPROVED_SUFFIX", "", "DATE_TIME_FORMAT_STRING", "DEFAULT_BUFFER_SIZE_IN_BYTES", "", "DEFAULT_CERTIFICATE_TYPE", "DEFAULT_LOG_LINES", "DEFAULT_REPORT_FIELDS", "", "Lorg/acra/ReportField;", "[Lorg/acra/ReportField;", "DEFAULT_RES_VALUE", "DEFAULT_STRING_VALUE", "MAX_SEND_REPORTS", "NOT_AVAILABLE", "NULL_VALUE", "REPORTFILE_EXTENSION", "SILENT_SUFFIX", "UTF8", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ACRAConstants {
    public static final String APPROVED_SUFFIX = "-approved";
    public static final String DATE_TIME_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ";
    public static final int DEFAULT_BUFFER_SIZE_IN_BYTES = 8192;
    public static final String DEFAULT_CERTIFICATE_TYPE = "X.509";
    public static final int DEFAULT_LOG_LINES = 100;
    public static final int DEFAULT_RES_VALUE = 0;
    public static final String DEFAULT_STRING_VALUE = "";
    public static final int MAX_SEND_REPORTS = 5;
    public static final String NOT_AVAILABLE = "N/A";
    public static final String NULL_VALUE = "ACRA-NULL-STRING";
    public static final String REPORTFILE_EXTENSION = ".stacktrace";
    public static final String UTF8 = "UTF-8";
    public static final ACRAConstants INSTANCE = new ACRAConstants();
    public static final String SILENT_SUFFIX = Intrinsics.stringPlus("-", ReportField.IS_SILENT);
    public static final ReportField[] DEFAULT_REPORT_FIELDS = {ReportField.REPORT_ID, ReportField.APP_VERSION_CODE, ReportField.APP_VERSION_NAME, ReportField.PACKAGE_NAME, ReportField.FILE_PATH, ReportField.PHONE_MODEL, ReportField.BRAND, ReportField.PRODUCT, ReportField.ANDROID_VERSION, ReportField.BUILD, ReportField.TOTAL_MEM_SIZE, ReportField.AVAILABLE_MEM_SIZE, ReportField.BUILD_CONFIG, ReportField.CUSTOM_DATA, ReportField.IS_SILENT, ReportField.STACK_TRACE, ReportField.INITIAL_CONFIGURATION, ReportField.CRASH_CONFIGURATION, ReportField.DISPLAY, ReportField.USER_COMMENT, ReportField.USER_EMAIL, ReportField.USER_APP_START_DATE, ReportField.USER_CRASH_DATE, ReportField.DUMPSYS_MEMINFO, ReportField.LOGCAT, ReportField.INSTALLATION_ID, ReportField.DEVICE_FEATURES, ReportField.ENVIRONMENT, ReportField.SHARED_PREFERENCES};

    private ACRAConstants() {
    }
}
