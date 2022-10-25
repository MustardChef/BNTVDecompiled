package org.acra.reporter;

import android.app.Application;
import android.content.SharedPreferences;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.lang.Thread;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.ErrorReporter;
import org.acra.builder.LastActivityManager;
import org.acra.builder.ReportBuilder;
import org.acra.builder.ReportExecutor;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportDataFactory;
import org.acra.log.ACRALog;
import org.acra.prefs.SharedPreferencesFactory;
import org.acra.scheduler.SchedulerStarter;
import org.acra.scheduler.SenderScheduler;
import org.acra.startup.StartupProcessorExecutor;
import org.acra.util.ProcessFinisher;

/* compiled from: ErrorReporterImpl.kt */
@Metadata(m108d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001c\u001a\u00020\u000fH\u0016J\u0012\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\tH\u0016J\u0012\u0010!\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010%\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000fH\u0016J\u0012\u0010'\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001c\u001a\u00020\u000fH\u0016J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0006\u0010,\u001a\u00020\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, m107d2 = {"Lorg/acra/reporter/ErrorReporterImpl;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "Lorg/acra/ErrorReporter;", "context", "Landroid/app/Application;", "config", "Lorg/acra/config/CoreConfiguration;", "enabled", "", "supportedAndroidVersion", "checkReportsOnApplicationStart", "(Landroid/app/Application;Lorg/acra/config/CoreConfiguration;ZZZ)V", "customData", "", "", "defaultExceptionHandler", "reportExecutor", "Lorg/acra/builder/ReportExecutor;", "reportScheduler", "Lorg/acra/scheduler/SenderScheduler;", "getReportScheduler", "()Lorg/acra/scheduler/SenderScheduler;", "schedulerStarter", "Lorg/acra/scheduler/SchedulerStarter;", "clearCustomData", "", "getCustomData", SDKConstants.PARAM_KEY, "handleException", "e", "", "endApplication", "handleSilentException", "onSharedPreferenceChanged", "sharedPreferences", "Landroid/content/SharedPreferences;", "putCustomData", "value", "removeCustomData", "setEnabled", "uncaughtException", "t", "Ljava/lang/Thread;", "unregister", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ErrorReporterImpl implements Thread.UncaughtExceptionHandler, SharedPreferences.OnSharedPreferenceChangeListener, ErrorReporter {
    private final Application context;
    private final Map<String, String> customData;
    private final Thread.UncaughtExceptionHandler defaultExceptionHandler;
    private final ReportExecutor reportExecutor;
    private final SchedulerStarter schedulerStarter;
    private final boolean supportedAndroidVersion;

    public ErrorReporterImpl(Application context, CoreConfiguration config, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.context = context;
        this.supportedAndroidVersion = z2;
        this.customData = new HashMap();
        CrashReportDataFactory crashReportDataFactory = new CrashReportDataFactory(context, config);
        crashReportDataFactory.collectStartUp();
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Intrinsics.checkNotNull(defaultUncaughtExceptionHandler);
        this.defaultExceptionHandler = defaultUncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler(this);
        LastActivityManager lastActivityManager = new LastActivityManager(context);
        ProcessFinisher processFinisher = new ProcessFinisher(context, config, lastActivityManager);
        SchedulerStarter schedulerStarter = new SchedulerStarter(context, config);
        this.schedulerStarter = schedulerStarter;
        ReportExecutor reportExecutor = new ReportExecutor(context, config, crashReportDataFactory, defaultUncaughtExceptionHandler, processFinisher, schedulerStarter, lastActivityManager);
        this.reportExecutor = reportExecutor;
        reportExecutor.setEnabled(z);
        if (z3) {
            new StartupProcessorExecutor(context, config, schedulerStarter).processReports(z);
        }
    }

    @Override // org.acra.ErrorReporter
    public String putCustomData(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return this.customData.put(key, value);
    }

    @Override // org.acra.ErrorReporter
    public String removeCustomData(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.customData.remove(key);
    }

    @Override // org.acra.ErrorReporter
    public void clearCustomData() {
        this.customData.clear();
    }

    @Override // org.acra.ErrorReporter
    public String getCustomData(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.customData.get(key);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread t, Throwable e) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(e, "e");
        if (!this.reportExecutor.isEnabled()) {
            this.reportExecutor.handReportToDefaultExceptionHandler(t, e);
            return;
        }
        try {
            ACRALog aCRALog = ACRA.log;
            String str = ACRA.LOG_TAG;
            aCRALog.mo66e(str, "ACRA caught a " + ((Object) e.getClass().getSimpleName()) + " for " + ((Object) this.context.getPackageName()), e);
            if (ACRA.DEV_LOGGING) {
                ACRA.log.mo69d(ACRA.LOG_TAG, "Building report");
            }
            new ReportBuilder().uncaughtExceptionThread(t).exception(e).customData(this.customData).endApplication().build(this.reportExecutor);
        } catch (Exception e2) {
            ACRA.log.mo66e(ACRA.LOG_TAG, "ACRA failed to capture the error - handing off to native error reporter", e2);
            this.reportExecutor.handReportToDefaultExceptionHandler(t, e);
        }
    }

    @Override // org.acra.ErrorReporter
    public void handleSilentException(Throwable th) {
        new ReportBuilder().exception(th).customData(this.customData).sendSilently().build(this.reportExecutor);
    }

    @Override // org.acra.ErrorReporter
    public void setEnabled(boolean z) {
        if (!this.supportedAndroidVersion) {
            ACRA.log.mo61w(ACRA.LOG_TAG, "ACRA requires ICS or greater. ACRA is disabled and will NOT catch crashes or send messages.");
            return;
        }
        ACRALog aCRALog = ACRA.log;
        String str = ACRA.LOG_TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("ACRA is ");
        sb.append(z ? "enabled" : "disabled");
        sb.append(" for ");
        sb.append((Object) this.context.getPackageName());
        aCRALog.mo65i(str, sb.toString());
        this.reportExecutor.setEnabled(z);
    }

    @Override // org.acra.ErrorReporter
    public void handleException(Throwable th, boolean z) {
        ReportBuilder reportBuilder = new ReportBuilder();
        reportBuilder.exception(th).customData(this.customData);
        if (z) {
            reportBuilder.endApplication();
        }
        reportBuilder.build(this.reportExecutor);
    }

    @Override // org.acra.ErrorReporter
    public void handleException(Throwable th) {
        handleException(th, false);
    }

    @Override // org.acra.ErrorReporter
    public SenderScheduler getReportScheduler() {
        return this.schedulerStarter.getSenderScheduler();
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        if (Intrinsics.areEqual(ACRA.PREF_DISABLE_ACRA, str) || Intrinsics.areEqual(ACRA.PREF_ENABLE_ACRA, str)) {
            setEnabled(SharedPreferencesFactory.Companion.shouldEnableACRA(sharedPreferences));
        }
    }

    public final void unregister() {
        Thread.setDefaultUncaughtExceptionHandler(this.defaultExceptionHandler);
    }
}
