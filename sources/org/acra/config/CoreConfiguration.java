package org.acra.config;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ReportField;
import org.acra.attachment.AttachmentUriProvider;
import org.acra.data.StringFormat;
import org.acra.file.Directory;
import org.acra.plugins.PluginLoader;

/* compiled from: CoreConfiguration.kt */
@Metadata(m108d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010*\u001a\u00020\u000fH\u0016R\u001b\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001b\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\u001e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001b\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b#\u0010\nR\u0015\u0010$\u001a\u0006\u0012\u0002\b\u00030\u001e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010&\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0011R\u0011\u0010(\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0011\u0010*\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0011R\u001b\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b-\u0010\nR\u001b\u0010.\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b/\u0010\nR\u0011\u00100\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0011R\u001b\u00102\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b3\u0010\nR\u0011\u00104\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0011R\u0011\u00106\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0011R\u0011\u00108\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0011R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00020;¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010>\u001a\u00020?¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020C0;¢\u0006\b\n\u0000\u001a\u0004\bD\u0010=R\u0011\u0010E\u001a\u00020F¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0011\u0010I\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u0014R\u0011\u0010K\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u0014R\u0019\u0010M\u001a\n\u0012\u0006\b\u0001\u0012\u00020N0\u001e¢\u0006\b\n\u0000\u001a\u0004\bO\u0010!R\u0011\u0010P\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0011R\u0011\u0010R\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0014R\u0011\u0010T\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0011¨\u0006V"}, m107d2 = {"Lorg/acra/config/CoreConfiguration;", "Ljava/io/Serializable;", "Lorg/acra/config/Configuration;", "arg0", "Lorg/acra/config/CoreConfigurationBuilder;", "(Lorg/acra/config/CoreConfigurationBuilder;)V", "additionalDropBoxTags", "", "", "getAdditionalDropBoxTags", "()[Ljava/lang/String;", "[Ljava/lang/String;", "additionalSharedPreferences", "getAdditionalSharedPreferences", "alsoReportToAndroidFramework", "", "getAlsoReportToAndroidFramework", "()Z", "applicationLogFile", "getApplicationLogFile", "()Ljava/lang/String;", "applicationLogFileDir", "Lorg/acra/file/Directory;", "getApplicationLogFileDir", "()Lorg/acra/file/Directory;", "applicationLogFileLines", "", "getApplicationLogFileLines", "()I", "attachmentUriProvider", "Ljava/lang/Class;", "Lorg/acra/attachment/AttachmentUriProvider;", "getAttachmentUriProvider", "()Ljava/lang/Class;", "attachmentUris", "getAttachmentUris", "buildConfigClass", "getBuildConfigClass", "deleteUnapprovedReportsOnApplicationStart", "getDeleteUnapprovedReportsOnApplicationStart", "dropboxCollectionMinutes", "getDropboxCollectionMinutes", "enabled", "getEnabled", "excludeMatchingSettingsKeys", "getExcludeMatchingSettingsKeys", "excludeMatchingSharedPreferencesKeys", "getExcludeMatchingSharedPreferencesKeys", "includeDropBoxSystemTags", "getIncludeDropBoxSystemTags", "logcatArguments", "getLogcatArguments", "logcatFilterByPid", "getLogcatFilterByPid", "logcatReadNonBlocking", "getLogcatReadNonBlocking", "parallel", "getParallel", "pluginConfigurations", "", "getPluginConfigurations", "()Ljava/util/List;", "pluginLoader", "Lorg/acra/plugins/PluginLoader;", "getPluginLoader", "()Lorg/acra/plugins/PluginLoader;", "reportContent", "Lorg/acra/ReportField;", "getReportContent", "reportFormat", "Lorg/acra/data/StringFormat;", "getReportFormat", "()Lorg/acra/data/StringFormat;", "reportSendFailureToast", "getReportSendFailureToast", "reportSendSuccessToast", "getReportSendSuccessToast", "retryPolicyClass", "Lorg/acra/config/RetryPolicy;", "getRetryPolicyClass", "sendReportsInDevMode", "getSendReportsInDevMode", "sharedPreferencesName", "getSharedPreferencesName", "stopServicesOnCrash", "getStopServicesOnCrash", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class CoreConfiguration implements Serializable, Configuration {
    private final String[] additionalDropBoxTags;
    private final String[] additionalSharedPreferences;
    private final boolean alsoReportToAndroidFramework;
    private final String applicationLogFile;
    private final Directory applicationLogFileDir;
    private final int applicationLogFileLines;
    private final Class<? extends AttachmentUriProvider> attachmentUriProvider;
    private final String[] attachmentUris;
    private final Class<?> buildConfigClass;
    private final boolean deleteUnapprovedReportsOnApplicationStart;
    private final int dropboxCollectionMinutes;
    private final boolean enabled;
    private final String[] excludeMatchingSettingsKeys;
    private final String[] excludeMatchingSharedPreferencesKeys;
    private final boolean includeDropBoxSystemTags;
    private final String[] logcatArguments;
    private final boolean logcatFilterByPid;
    private final boolean logcatReadNonBlocking;
    private final boolean parallel;
    private final List<Configuration> pluginConfigurations;
    private final PluginLoader pluginLoader;
    private final List<ReportField> reportContent;
    private final StringFormat reportFormat;
    private final String reportSendFailureToast;
    private final String reportSendSuccessToast;
    private final Class<? extends RetryPolicy> retryPolicyClass;
    private final boolean sendReportsInDevMode;
    private final String sharedPreferencesName;
    private final boolean stopServicesOnCrash;

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getSharedPreferencesName() {
        return this.sharedPreferencesName;
    }

    public final boolean getIncludeDropBoxSystemTags() {
        return this.includeDropBoxSystemTags;
    }

    public final String[] getAdditionalDropBoxTags() {
        return this.additionalDropBoxTags;
    }

    public final int getDropboxCollectionMinutes() {
        return this.dropboxCollectionMinutes;
    }

    public final String[] getLogcatArguments() {
        return this.logcatArguments;
    }

    public final List<ReportField> getReportContent() {
        return this.reportContent;
    }

    public final boolean getDeleteUnapprovedReportsOnApplicationStart() {
        return this.deleteUnapprovedReportsOnApplicationStart;
    }

    public final boolean getAlsoReportToAndroidFramework() {
        return this.alsoReportToAndroidFramework;
    }

    public final String[] getAdditionalSharedPreferences() {
        return this.additionalSharedPreferences;
    }

    public final boolean getLogcatFilterByPid() {
        return this.logcatFilterByPid;
    }

    public final boolean getLogcatReadNonBlocking() {
        return this.logcatReadNonBlocking;
    }

    public final boolean getSendReportsInDevMode() {
        return this.sendReportsInDevMode;
    }

    public final String[] getExcludeMatchingSharedPreferencesKeys() {
        return this.excludeMatchingSharedPreferencesKeys;
    }

    public final String[] getExcludeMatchingSettingsKeys() {
        return this.excludeMatchingSettingsKeys;
    }

    public final Class<?> getBuildConfigClass() {
        return this.buildConfigClass;
    }

    public final String getApplicationLogFile() {
        return this.applicationLogFile;
    }

    public final int getApplicationLogFileLines() {
        return this.applicationLogFileLines;
    }

    public final Directory getApplicationLogFileDir() {
        return this.applicationLogFileDir;
    }

    public final Class<? extends RetryPolicy> getRetryPolicyClass() {
        return this.retryPolicyClass;
    }

    public final boolean getStopServicesOnCrash() {
        return this.stopServicesOnCrash;
    }

    public final String[] getAttachmentUris() {
        return this.attachmentUris;
    }

    public final Class<? extends AttachmentUriProvider> getAttachmentUriProvider() {
        return this.attachmentUriProvider;
    }

    public final String getReportSendSuccessToast() {
        return this.reportSendSuccessToast;
    }

    public final String getReportSendFailureToast() {
        return this.reportSendFailureToast;
    }

    public final StringFormat getReportFormat() {
        return this.reportFormat;
    }

    public final boolean getParallel() {
        return this.parallel;
    }

    public final PluginLoader getPluginLoader() {
        return this.pluginLoader;
    }

    public final List<Configuration> getPluginConfigurations() {
        return this.pluginConfigurations;
    }

    public CoreConfiguration(CoreConfigurationBuilder arg0) {
        Intrinsics.checkNotNullParameter(arg0, "arg0");
        this.enabled = arg0.getEnabled();
        this.sharedPreferencesName = arg0.getSharedPreferencesName();
        this.includeDropBoxSystemTags = arg0.getIncludeDropBoxSystemTags();
        this.additionalDropBoxTags = arg0.getAdditionalDropBoxTags();
        this.dropboxCollectionMinutes = arg0.getDropboxCollectionMinutes();
        this.logcatArguments = arg0.getLogcatArguments();
        this.reportContent = arg0.transformReportContent();
        this.deleteUnapprovedReportsOnApplicationStart = arg0.getDeleteUnapprovedReportsOnApplicationStart();
        this.alsoReportToAndroidFramework = arg0.getAlsoReportToAndroidFramework();
        this.additionalSharedPreferences = arg0.getAdditionalSharedPreferences();
        this.logcatFilterByPid = arg0.getLogcatFilterByPid();
        this.logcatReadNonBlocking = arg0.getLogcatReadNonBlocking();
        this.sendReportsInDevMode = arg0.getSendReportsInDevMode();
        this.excludeMatchingSharedPreferencesKeys = arg0.getExcludeMatchingSharedPreferencesKeys();
        this.excludeMatchingSettingsKeys = arg0.getExcludeMatchingSettingsKeys();
        this.buildConfigClass = arg0.getBuildConfigClass();
        this.applicationLogFile = arg0.getApplicationLogFile();
        this.applicationLogFileLines = arg0.getApplicationLogFileLines();
        this.applicationLogFileDir = arg0.getApplicationLogFileDir();
        this.retryPolicyClass = arg0.getRetryPolicyClass();
        this.stopServicesOnCrash = arg0.getStopServicesOnCrash();
        this.attachmentUris = arg0.getAttachmentUris();
        this.attachmentUriProvider = arg0.getAttachmentUriProvider();
        this.reportSendSuccessToast = arg0.getReportSendSuccessToast();
        this.reportSendFailureToast = arg0.getReportSendFailureToast();
        this.reportFormat = arg0.getReportFormat();
        this.parallel = arg0.getParallel();
        this.pluginLoader = arg0.pluginLoader();
        this.pluginConfigurations = arg0.pluginConfigurations();
    }

    @Override // org.acra.config.Configuration
    public boolean enabled() {
        return this.enabled;
    }
}
