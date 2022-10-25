package org.acra.config;

import android.content.Context;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ReportField;
import org.acra.attachment.AttachmentUriProvider;
import org.acra.data.StringFormat;
import org.acra.file.Directory;
import org.acra.plugins.PluginLoader;

/* compiled from: CoreConfigurationBuilder.kt */
@Metadata(m108d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b'\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010|\u001a\u00020}H\u0016J'\u0010~\u001a\u0002H\u007f\"\b\b\u0000\u0010\u007f*\u00020\u00012\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u0002H\u007f0(H\u0007¢\u0006\u0003\u0010\u0081\u0001J\u0011\u0010\u0082\u0001\u001a\n\u0012\u0005\u0012\u00030\u0084\u00010\u0083\u0001H\u0007J\n\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0007J\u0011\u0010\u0087\u0001\u001a\u00020\u00002\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001J\u0019\u0010\u0088\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020]2\u0007\u0010\u008a\u0001\u001a\u00020\u0011J\u000e\u0010\u008b\u0001\u001a\t\u0012\u0004\u0012\u00020]0\u0083\u0001J!\u0010\u008c\u0001\u001a\u00020\u00002\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0003\u0010\u008d\u0001J!\u0010\u008e\u0001\u001a\u00020\u00002\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0003\u0010\u008d\u0001J\u000f\u0010\u008f\u0001\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u000f\u0010\u0090\u0001\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0007J\u000f\u0010\u0091\u0001\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cJ\u000f\u0010\u0092\u0001\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"J\u0017\u0010\u0093\u0001\u001a\u00020\u00002\u000e\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0(J!\u0010\u0094\u0001\u001a\u00020\u00002\u0012\u0010.\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0003\u0010\u008d\u0001J\u0013\u0010\u0095\u0001\u001a\u00020\u00002\n\u00101\u001a\u0006\u0012\u0002\b\u00030(J\u000f\u0010\u0096\u0001\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u0011J\u000f\u0010\u0097\u0001\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\"J\u000f\u0010\u0098\u0001\u001a\u00020\u00002\u0006\u0010D\u001a\u00020\u0011J!\u0010\u0099\u0001\u001a\u00020\u00002\u0012\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0003\u0010\u008d\u0001J!\u0010\u009a\u0001\u001a\u00020\u00002\u0012\u0010J\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0003\u0010\u008d\u0001J\u000f\u0010\u009b\u0001\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u0011J!\u0010\u009c\u0001\u001a\u00020\u00002\u0012\u0010P\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0003\u0010\u008d\u0001J\u000f\u0010\u009d\u0001\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\u0011J\u000f\u0010\u009e\u0001\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0011J\u000f\u0010\u009f\u0001\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\u0011J!\u0010 \u0001\u001a\u00020\u00002\u0012\u0010\\\u001a\n\u0012\u0006\b\u0001\u0012\u00020]0\u0006\"\u00020]¢\u0006\u0003\u0010¡\u0001J\u000f\u0010¢\u0001\u001a\u00020\u00002\u0006\u0010c\u001a\u00020dJ\u000f\u0010£\u0001\u001a\u00020\u00002\u0006\u0010i\u001a\u00020\u0007J\u000f\u0010¤\u0001\u001a\u00020\u00002\u0006\u0010l\u001a\u00020\u0007J\u0012\u0010¥\u0001\u001a\u00020\u00002\t\b\u0001\u0010¦\u0001\u001a\u00020\"J\u0012\u0010§\u0001\u001a\u00020\u00002\t\b\u0001\u0010¨\u0001\u001a\u00020\"J\u0017\u0010©\u0001\u001a\u00020\u00002\u000e\u0010o\u001a\n\u0012\u0006\b\u0001\u0012\u00020p0(J\u000f\u0010ª\u0001\u001a\u00020\u00002\u0006\u0010s\u001a\u00020\u0011J\u000f\u0010«\u0001\u001a\u00020\u00002\u0006\u0010v\u001a\u00020\u0007J\u000f\u0010¬\u0001\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u0011R$\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b/\u0010\t\"\u0004\b0\u0010\u000bR\u001e\u00101\u001a\u0006\u0012\u0002\b\u00030(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010+\"\u0004\b3\u0010-R\u001a\u00104\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u0010\u0004R\u001a\u00108\u001a\u000209X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0013\"\u0004\b@\u0010\u0015R\u001a\u0010A\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010$\"\u0004\bC\u0010&R\u001a\u0010D\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0013\"\u0004\bF\u0010\u0015R$\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\bH\u0010\t\"\u0004\bI\u0010\u000bR$\u0010J\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\bK\u0010\t\"\u0004\bL\u0010\u000bR\u001a\u0010M\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0013\"\u0004\bO\u0010\u0015R$\u0010P\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\bQ\u0010\t\"\u0004\bR\u0010\u000bR\u001a\u0010S\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0013\"\u0004\bU\u0010\u0015R\u001a\u0010V\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0013\"\u0004\bX\u0010\u0015R\u001a\u0010Y\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0013\"\u0004\b[\u0010\u0015R$\u0010\\\u001a\n\u0012\u0006\b\u0001\u0012\u00020]0\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010b\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001a\u0010c\u001a\u00020dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001a\u0010i\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u0018\"\u0004\bk\u0010\u001aR\u001a\u0010l\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u0018\"\u0004\bn\u0010\u001aR\"\u0010o\u001a\n\u0012\u0006\b\u0001\u0012\u00020p0(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010+\"\u0004\br\u0010-R\u001a\u0010s\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\u0013\"\u0004\bu\u0010\u0015R\u001a\u0010v\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010\u0018\"\u0004\bx\u0010\u001aR\u001a\u0010y\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\u0013\"\u0004\b{\u0010\u0015¨\u0006\u00ad\u0001"}, m107d2 = {"Lorg/acra/config/CoreConfigurationBuilder;", "Lorg/acra/config/ConfigurationBuilder;", "arg0", "Landroid/content/Context;", "(Landroid/content/Context;)V", "additionalDropBoxTags", "", "", "getAdditionalDropBoxTags", "()[Ljava/lang/String;", "setAdditionalDropBoxTags", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "additionalSharedPreferences", "getAdditionalSharedPreferences", "setAdditionalSharedPreferences", "alsoReportToAndroidFramework", "", "getAlsoReportToAndroidFramework", "()Z", "setAlsoReportToAndroidFramework", "(Z)V", "applicationLogFile", "getApplicationLogFile", "()Ljava/lang/String;", "setApplicationLogFile", "(Ljava/lang/String;)V", "applicationLogFileDir", "Lorg/acra/file/Directory;", "getApplicationLogFileDir", "()Lorg/acra/file/Directory;", "setApplicationLogFileDir", "(Lorg/acra/file/Directory;)V", "applicationLogFileLines", "", "getApplicationLogFileLines", "()I", "setApplicationLogFileLines", "(I)V", "attachmentUriProvider", "Ljava/lang/Class;", "Lorg/acra/attachment/AttachmentUriProvider;", "getAttachmentUriProvider", "()Ljava/lang/Class;", "setAttachmentUriProvider", "(Ljava/lang/Class;)V", "attachmentUris", "getAttachmentUris", "setAttachmentUris", "buildConfigClass", "getBuildConfigClass", "setBuildConfigClass", "context", "getContext", "()Landroid/content/Context;", "setContext", "delegate", "Lorg/acra/config/BaseCoreConfigurationBuilder;", "getDelegate", "()Lorg/acra/config/BaseCoreConfigurationBuilder;", "setDelegate", "(Lorg/acra/config/BaseCoreConfigurationBuilder;)V", "deleteUnapprovedReportsOnApplicationStart", "getDeleteUnapprovedReportsOnApplicationStart", "setDeleteUnapprovedReportsOnApplicationStart", "dropboxCollectionMinutes", "getDropboxCollectionMinutes", "setDropboxCollectionMinutes", "enabled", "getEnabled", "setEnabled", "excludeMatchingSettingsKeys", "getExcludeMatchingSettingsKeys", "setExcludeMatchingSettingsKeys", "excludeMatchingSharedPreferencesKeys", "getExcludeMatchingSharedPreferencesKeys", "setExcludeMatchingSharedPreferencesKeys", "includeDropBoxSystemTags", "getIncludeDropBoxSystemTags", "setIncludeDropBoxSystemTags", "logcatArguments", "getLogcatArguments", "setLogcatArguments", "logcatFilterByPid", "getLogcatFilterByPid", "setLogcatFilterByPid", "logcatReadNonBlocking", "getLogcatReadNonBlocking", "setLogcatReadNonBlocking", "parallel", "getParallel", "setParallel", "reportContent", "Lorg/acra/ReportField;", "getReportContent", "()[Lorg/acra/ReportField;", "setReportContent", "([Lorg/acra/ReportField;)V", "[Lorg/acra/ReportField;", "reportFormat", "Lorg/acra/data/StringFormat;", "getReportFormat", "()Lorg/acra/data/StringFormat;", "setReportFormat", "(Lorg/acra/data/StringFormat;)V", "reportSendFailureToast", "getReportSendFailureToast", "setReportSendFailureToast", "reportSendSuccessToast", "getReportSendSuccessToast", "setReportSendSuccessToast", "retryPolicyClass", "Lorg/acra/config/RetryPolicy;", "getRetryPolicyClass", "setRetryPolicyClass", "sendReportsInDevMode", "getSendReportsInDevMode", "setSendReportsInDevMode", "sharedPreferencesName", "getSharedPreferencesName", "setSharedPreferencesName", "stopServicesOnCrash", "getStopServicesOnCrash", "setStopServicesOnCrash", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lorg/acra/config/CoreConfiguration;", "getPluginConfigurationBuilder", "R", "c", "(Ljava/lang/Class;)Lorg/acra/config/ConfigurationBuilder;", "pluginConfigurations", "", "Lorg/acra/config/Configuration;", "pluginLoader", "Lorg/acra/plugins/PluginLoader;", "setPluginLoader", "setReportField", "field", "enable", "transformReportContent", "withAdditionalDropBoxTags", "([Ljava/lang/String;)Lorg/acra/config/CoreConfigurationBuilder;", "withAdditionalSharedPreferences", "withAlsoReportToAndroidFramework", "withApplicationLogFile", "withApplicationLogFileDir", "withApplicationLogFileLines", "withAttachmentUriProvider", "withAttachmentUris", "withBuildConfigClass", "withDeleteUnapprovedReportsOnApplicationStart", "withDropboxCollectionMinutes", "withEnabled", "withExcludeMatchingSettingsKeys", "withExcludeMatchingSharedPreferencesKeys", "withIncludeDropBoxSystemTags", "withLogcatArguments", "withLogcatFilterByPid", "withLogcatReadNonBlocking", "withParallel", "withReportContent", "([Lorg/acra/ReportField;)Lorg/acra/config/CoreConfigurationBuilder;", "withReportFormat", "withReportSendFailureToast", "withReportSendSuccessToast", "withResReportSendFailureToast", "resReportSendFailureToast", "withResReportSendSuccessToast", "resReportSendSuccessToast", "withRetryPolicyClass", "withSendReportsInDevMode", "withSharedPreferencesName", "withStopServicesOnCrash", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class CoreConfigurationBuilder implements ConfigurationBuilder {
    private String[] additionalDropBoxTags;
    private String[] additionalSharedPreferences;
    private boolean alsoReportToAndroidFramework;
    private String applicationLogFile;
    private Directory applicationLogFileDir;
    private int applicationLogFileLines;
    private Class<? extends AttachmentUriProvider> attachmentUriProvider;
    private String[] attachmentUris;
    private Class<?> buildConfigClass;
    private Context context;
    private BaseCoreConfigurationBuilder delegate;
    private boolean deleteUnapprovedReportsOnApplicationStart;
    private int dropboxCollectionMinutes;
    private boolean enabled;
    private String[] excludeMatchingSettingsKeys;
    private String[] excludeMatchingSharedPreferencesKeys;
    private boolean includeDropBoxSystemTags;
    private String[] logcatArguments;
    private boolean logcatFilterByPid;
    private boolean logcatReadNonBlocking;
    private boolean parallel;
    private ReportField[] reportContent;
    private StringFormat reportFormat;
    private String reportSendFailureToast;
    private String reportSendSuccessToast;
    private Class<? extends RetryPolicy> retryPolicyClass;
    private boolean sendReportsInDevMode;
    private String sharedPreferencesName;
    private boolean stopServicesOnCrash;

    /* JADX WARN: Code restructure failed: missing block: B:136:0x0169, code lost:
        if (r5 == null) goto L102;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CoreConfigurationBuilder(android.content.Context r10) {
        /*
            Method dump skipped, instructions count: 445
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.acra.config.CoreConfigurationBuilder.<init>(android.content.Context):void");
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final String getSharedPreferencesName() {
        return this.sharedPreferencesName;
    }

    public final void setSharedPreferencesName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sharedPreferencesName = str;
    }

    public final boolean getIncludeDropBoxSystemTags() {
        return this.includeDropBoxSystemTags;
    }

    public final void setIncludeDropBoxSystemTags(boolean z) {
        this.includeDropBoxSystemTags = z;
    }

    public final String[] getAdditionalDropBoxTags() {
        return this.additionalDropBoxTags;
    }

    public final void setAdditionalDropBoxTags(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.additionalDropBoxTags = strArr;
    }

    public final int getDropboxCollectionMinutes() {
        return this.dropboxCollectionMinutes;
    }

    public final void setDropboxCollectionMinutes(int i) {
        this.dropboxCollectionMinutes = i;
    }

    public final String[] getLogcatArguments() {
        return this.logcatArguments;
    }

    public final void setLogcatArguments(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.logcatArguments = strArr;
    }

    public final ReportField[] getReportContent() {
        return this.reportContent;
    }

    public final void setReportContent(ReportField[] reportFieldArr) {
        Intrinsics.checkNotNullParameter(reportFieldArr, "<set-?>");
        this.reportContent = reportFieldArr;
    }

    public final boolean getDeleteUnapprovedReportsOnApplicationStart() {
        return this.deleteUnapprovedReportsOnApplicationStart;
    }

    public final void setDeleteUnapprovedReportsOnApplicationStart(boolean z) {
        this.deleteUnapprovedReportsOnApplicationStart = z;
    }

    public final boolean getAlsoReportToAndroidFramework() {
        return this.alsoReportToAndroidFramework;
    }

    public final void setAlsoReportToAndroidFramework(boolean z) {
        this.alsoReportToAndroidFramework = z;
    }

    public final String[] getAdditionalSharedPreferences() {
        return this.additionalSharedPreferences;
    }

    public final void setAdditionalSharedPreferences(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.additionalSharedPreferences = strArr;
    }

    public final boolean getLogcatFilterByPid() {
        return this.logcatFilterByPid;
    }

    public final void setLogcatFilterByPid(boolean z) {
        this.logcatFilterByPid = z;
    }

    public final boolean getLogcatReadNonBlocking() {
        return this.logcatReadNonBlocking;
    }

    public final void setLogcatReadNonBlocking(boolean z) {
        this.logcatReadNonBlocking = z;
    }

    public final boolean getSendReportsInDevMode() {
        return this.sendReportsInDevMode;
    }

    public final void setSendReportsInDevMode(boolean z) {
        this.sendReportsInDevMode = z;
    }

    public final String[] getExcludeMatchingSharedPreferencesKeys() {
        return this.excludeMatchingSharedPreferencesKeys;
    }

    public final void setExcludeMatchingSharedPreferencesKeys(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.excludeMatchingSharedPreferencesKeys = strArr;
    }

    public final String[] getExcludeMatchingSettingsKeys() {
        return this.excludeMatchingSettingsKeys;
    }

    public final void setExcludeMatchingSettingsKeys(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.excludeMatchingSettingsKeys = strArr;
    }

    public final Class<?> getBuildConfigClass() {
        return this.buildConfigClass;
    }

    public final void setBuildConfigClass(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<set-?>");
        this.buildConfigClass = cls;
    }

    public final String getApplicationLogFile() {
        return this.applicationLogFile;
    }

    public final void setApplicationLogFile(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.applicationLogFile = str;
    }

    public final int getApplicationLogFileLines() {
        return this.applicationLogFileLines;
    }

    public final void setApplicationLogFileLines(int i) {
        this.applicationLogFileLines = i;
    }

    public final Directory getApplicationLogFileDir() {
        return this.applicationLogFileDir;
    }

    public final void setApplicationLogFileDir(Directory directory) {
        Intrinsics.checkNotNullParameter(directory, "<set-?>");
        this.applicationLogFileDir = directory;
    }

    public final Class<? extends RetryPolicy> getRetryPolicyClass() {
        return this.retryPolicyClass;
    }

    public final void setRetryPolicyClass(Class<? extends RetryPolicy> cls) {
        Intrinsics.checkNotNullParameter(cls, "<set-?>");
        this.retryPolicyClass = cls;
    }

    public final boolean getStopServicesOnCrash() {
        return this.stopServicesOnCrash;
    }

    public final void setStopServicesOnCrash(boolean z) {
        this.stopServicesOnCrash = z;
    }

    public final String[] getAttachmentUris() {
        return this.attachmentUris;
    }

    public final void setAttachmentUris(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.attachmentUris = strArr;
    }

    public final Class<? extends AttachmentUriProvider> getAttachmentUriProvider() {
        return this.attachmentUriProvider;
    }

    public final void setAttachmentUriProvider(Class<? extends AttachmentUriProvider> cls) {
        Intrinsics.checkNotNullParameter(cls, "<set-?>");
        this.attachmentUriProvider = cls;
    }

    public final String getReportSendSuccessToast() {
        return this.reportSendSuccessToast;
    }

    public final void setReportSendSuccessToast(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.reportSendSuccessToast = str;
    }

    public final String getReportSendFailureToast() {
        return this.reportSendFailureToast;
    }

    public final void setReportSendFailureToast(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.reportSendFailureToast = str;
    }

    public final StringFormat getReportFormat() {
        return this.reportFormat;
    }

    public final void setReportFormat(StringFormat stringFormat) {
        Intrinsics.checkNotNullParameter(stringFormat, "<set-?>");
        this.reportFormat = stringFormat;
    }

    public final boolean getParallel() {
        return this.parallel;
    }

    public final void setParallel(boolean z) {
        this.parallel = z;
    }

    public final BaseCoreConfigurationBuilder getDelegate() {
        return this.delegate;
    }

    public final void setDelegate(BaseCoreConfigurationBuilder baseCoreConfigurationBuilder) {
        Intrinsics.checkNotNullParameter(baseCoreConfigurationBuilder, "<set-?>");
        this.delegate = baseCoreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withEnabled(boolean z) {
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setEnabled(z);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withSharedPreferencesName(String sharedPreferencesName) {
        Intrinsics.checkNotNullParameter(sharedPreferencesName, "sharedPreferencesName");
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setSharedPreferencesName(sharedPreferencesName);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withIncludeDropBoxSystemTags(boolean z) {
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setIncludeDropBoxSystemTags(z);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withAdditionalDropBoxTags(String... additionalDropBoxTags) {
        Intrinsics.checkNotNullParameter(additionalDropBoxTags, "additionalDropBoxTags");
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setAdditionalDropBoxTags(additionalDropBoxTags);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withDropboxCollectionMinutes(int i) {
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setDropboxCollectionMinutes(i);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withLogcatArguments(String... logcatArguments) {
        Intrinsics.checkNotNullParameter(logcatArguments, "logcatArguments");
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setLogcatArguments(logcatArguments);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withReportContent(ReportField... reportContent) {
        Intrinsics.checkNotNullParameter(reportContent, "reportContent");
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setReportContent(reportContent);
        return coreConfigurationBuilder;
    }

    public final List<ReportField> transformReportContent() {
        return this.delegate.transformReportContent(this.reportContent);
    }

    public final CoreConfigurationBuilder withDeleteUnapprovedReportsOnApplicationStart(boolean z) {
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setDeleteUnapprovedReportsOnApplicationStart(z);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withAlsoReportToAndroidFramework(boolean z) {
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setAlsoReportToAndroidFramework(z);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withAdditionalSharedPreferences(String... additionalSharedPreferences) {
        Intrinsics.checkNotNullParameter(additionalSharedPreferences, "additionalSharedPreferences");
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setAdditionalSharedPreferences(additionalSharedPreferences);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withLogcatFilterByPid(boolean z) {
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setLogcatFilterByPid(z);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withLogcatReadNonBlocking(boolean z) {
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setLogcatReadNonBlocking(z);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withSendReportsInDevMode(boolean z) {
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setSendReportsInDevMode(z);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withExcludeMatchingSharedPreferencesKeys(String... excludeMatchingSharedPreferencesKeys) {
        Intrinsics.checkNotNullParameter(excludeMatchingSharedPreferencesKeys, "excludeMatchingSharedPreferencesKeys");
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setExcludeMatchingSharedPreferencesKeys(excludeMatchingSharedPreferencesKeys);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withExcludeMatchingSettingsKeys(String... excludeMatchingSettingsKeys) {
        Intrinsics.checkNotNullParameter(excludeMatchingSettingsKeys, "excludeMatchingSettingsKeys");
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setExcludeMatchingSettingsKeys(excludeMatchingSettingsKeys);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withBuildConfigClass(Class<?> buildConfigClass) {
        Intrinsics.checkNotNullParameter(buildConfigClass, "buildConfigClass");
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setBuildConfigClass(buildConfigClass);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withApplicationLogFile(String applicationLogFile) {
        Intrinsics.checkNotNullParameter(applicationLogFile, "applicationLogFile");
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setApplicationLogFile(applicationLogFile);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withApplicationLogFileLines(int i) {
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setApplicationLogFileLines(i);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withApplicationLogFileDir(Directory applicationLogFileDir) {
        Intrinsics.checkNotNullParameter(applicationLogFileDir, "applicationLogFileDir");
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setApplicationLogFileDir(applicationLogFileDir);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withRetryPolicyClass(Class<? extends RetryPolicy> retryPolicyClass) {
        Intrinsics.checkNotNullParameter(retryPolicyClass, "retryPolicyClass");
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setRetryPolicyClass(retryPolicyClass);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withStopServicesOnCrash(boolean z) {
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setStopServicesOnCrash(z);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withAttachmentUris(String... attachmentUris) {
        Intrinsics.checkNotNullParameter(attachmentUris, "attachmentUris");
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setAttachmentUris(attachmentUris);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withAttachmentUriProvider(Class<? extends AttachmentUriProvider> attachmentUriProvider) {
        Intrinsics.checkNotNullParameter(attachmentUriProvider, "attachmentUriProvider");
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setAttachmentUriProvider(attachmentUriProvider);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withReportSendSuccessToast(String reportSendSuccessToast) {
        Intrinsics.checkNotNullParameter(reportSendSuccessToast, "reportSendSuccessToast");
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setReportSendSuccessToast(reportSendSuccessToast);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withResReportSendSuccessToast(int i) {
        String string = this.context.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(resReportSendSuccessToast)");
        this.reportSendSuccessToast = string;
        return this;
    }

    public final CoreConfigurationBuilder withReportSendFailureToast(String reportSendFailureToast) {
        Intrinsics.checkNotNullParameter(reportSendFailureToast, "reportSendFailureToast");
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setReportSendFailureToast(reportSendFailureToast);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withResReportSendFailureToast(int i) {
        String string = this.context.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(resReportSendFailureToast)");
        this.reportSendFailureToast = string;
        return this;
    }

    public final CoreConfigurationBuilder withReportFormat(StringFormat reportFormat) {
        Intrinsics.checkNotNullParameter(reportFormat, "reportFormat");
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setReportFormat(reportFormat);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder withParallel(boolean z) {
        CoreConfigurationBuilder coreConfigurationBuilder = this;
        coreConfigurationBuilder.setParallel(z);
        return coreConfigurationBuilder;
    }

    public final CoreConfigurationBuilder setPluginLoader(PluginLoader pluginLoader) {
        Intrinsics.checkNotNullParameter(pluginLoader, "pluginLoader");
        this.delegate.setPluginLoader(pluginLoader);
        return this;
    }

    public final PluginLoader pluginLoader() {
        return this.delegate.pluginLoader();
    }

    public final CoreConfigurationBuilder setReportField(ReportField field, boolean z) {
        Intrinsics.checkNotNullParameter(field, "field");
        this.delegate.setReportField(field, z);
        return this;
    }

    public final List<Configuration> pluginConfigurations() {
        return this.delegate.pluginConfigurations();
    }

    public final <R extends ConfigurationBuilder> R getPluginConfigurationBuilder(Class<R> c) {
        Intrinsics.checkNotNullParameter(c, "c");
        return (R) this.delegate.getPluginConfigurationBuilder(c);
    }

    @Override // org.acra.config.ConfigurationBuilder
    public CoreConfiguration build() throws ACRAConfigurationException {
        if (this.enabled) {
            ClassValidator classValidator = ClassValidator.INSTANCE;
            ClassValidator.check(this.retryPolicyClass);
            ClassValidator classValidator2 = ClassValidator.INSTANCE;
            ClassValidator.check(this.attachmentUriProvider);
        }
        this.delegate.preBuild();
        return new CoreConfiguration(this);
    }
}
