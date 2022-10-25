package org.acra.builder;

import android.content.Context;
import android.os.Debug;
import android.os.Looper;
import android.os.StrictMode;
import java.io.File;
import java.lang.Thread;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.ACRAConstants;
import org.acra.ReportField;
import org.acra.config.CoreConfiguration;
import org.acra.config.ReportingAdministrator;
import org.acra.data.CrashReportData;
import org.acra.data.CrashReportDataFactory;
import org.acra.file.CrashReportPersister;
import org.acra.file.ReportLocator;
import org.acra.interaction.ReportInteractionExecutor;
import org.acra.log.ACRALog;
import org.acra.scheduler.SchedulerStarter;
import org.acra.sender.LegacySenderService;
import org.acra.util.ProcessFinisher;
import org.acra.util.ToastSender;

/* compiled from: ReportExecutor.kt */
@Metadata(m108d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u001a\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0016\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001eJ\u0018\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, m107d2 = {"Lorg/acra/builder/ReportExecutor;", "", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "crashReportDataFactory", "Lorg/acra/data/CrashReportDataFactory;", "defaultExceptionHandler", "Ljava/lang/Thread$UncaughtExceptionHandler;", "processFinisher", "Lorg/acra/util/ProcessFinisher;", "schedulerStarter", "Lorg/acra/scheduler/SchedulerStarter;", "lastActivityManager", "Lorg/acra/builder/LastActivityManager;", "(Landroid/content/Context;Lorg/acra/config/CoreConfiguration;Lorg/acra/data/CrashReportDataFactory;Ljava/lang/Thread$UncaughtExceptionHandler;Lorg/acra/util/ProcessFinisher;Lorg/acra/scheduler/SchedulerStarter;Lorg/acra/builder/LastActivityManager;)V", "isEnabled", "", "()Z", "setEnabled", "(Z)V", "reportingAdministrators", "", "Lorg/acra/config/ReportingAdministrator;", "endApplication", "", "uncaughtExceptionThread", "Ljava/lang/Thread;", "th", "", "execute", "reportBuilder", "Lorg/acra/builder/ReportBuilder;", "getReportFileName", "Ljava/io/File;", "crashData", "Lorg/acra/data/CrashReportData;", "handReportToDefaultExceptionHandler", "t", "e", "saveCrashReportFile", "file", "sendReport", "report", LegacySenderService.EXTRA_ONLY_SEND_SILENT_REPORTS, "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ReportExecutor {
    private final CoreConfiguration config;
    private final Context context;
    private final CrashReportDataFactory crashReportDataFactory;
    private final Thread.UncaughtExceptionHandler defaultExceptionHandler;
    private boolean isEnabled;
    private final LastActivityManager lastActivityManager;
    private final ProcessFinisher processFinisher;
    private final List<ReportingAdministrator> reportingAdministrators;
    private final SchedulerStarter schedulerStarter;

    public ReportExecutor(Context context, CoreConfiguration config, CrashReportDataFactory crashReportDataFactory, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, ProcessFinisher processFinisher, SchedulerStarter schedulerStarter, LastActivityManager lastActivityManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(crashReportDataFactory, "crashReportDataFactory");
        Intrinsics.checkNotNullParameter(processFinisher, "processFinisher");
        Intrinsics.checkNotNullParameter(schedulerStarter, "schedulerStarter");
        Intrinsics.checkNotNullParameter(lastActivityManager, "lastActivityManager");
        this.context = context;
        this.config = config;
        this.crashReportDataFactory = crashReportDataFactory;
        this.defaultExceptionHandler = uncaughtExceptionHandler;
        this.processFinisher = processFinisher;
        this.schedulerStarter = schedulerStarter;
        this.lastActivityManager = lastActivityManager;
        this.reportingAdministrators = config.getPluginLoader().loadEnabled(config, ReportingAdministrator.class);
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public final void handReportToDefaultExceptionHandler(Thread t, Throwable e) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(e, "e");
        if (this.defaultExceptionHandler != null) {
            ACRALog aCRALog = ACRA.log;
            String str = ACRA.LOG_TAG;
            aCRALog.mo65i(str, "ACRA is disabled for " + ((Object) this.context.getPackageName()) + " - forwarding uncaught Exception on to default ExceptionHandler");
            this.defaultExceptionHandler.uncaughtException(t, e);
            return;
        }
        ACRALog aCRALog2 = ACRA.log;
        String str2 = ACRA.LOG_TAG;
        aCRALog2.mo67e(str2, "ACRA is disabled for " + ((Object) this.context.getPackageName()) + " - no default ExceptionHandler");
        ACRALog aCRALog3 = ACRA.log;
        String str3 = ACRA.LOG_TAG;
        aCRALog3.mo66e(str3, "ACRA caught a " + ((Object) e.getClass().getSimpleName()) + " for " + ((Object) this.context.getPackageName()), e);
    }

    public final void execute(ReportBuilder reportBuilder) {
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        if (!this.isEnabled) {
            ACRA.log.mo61w(ACRA.LOG_TAG, "ACRA is disabled. Report not sent.");
            return;
        }
        CrashReportData crashReportData = null;
        ReportingAdministrator reportingAdministrator = null;
        for (ReportingAdministrator reportingAdministrator2 : this.reportingAdministrators) {
            try {
                if (!reportingAdministrator2.shouldStartCollecting(this.context, this.config, reportBuilder)) {
                    reportingAdministrator = reportingAdministrator2;
                }
            } catch (Exception e) {
                ACRA.log.mo60w(ACRA.LOG_TAG, "ReportingAdministrator " + ((Object) reportingAdministrator2.getClass().getName()) + " threw exception", e);
            }
        }
        if (reportingAdministrator == null) {
            crashReportData = this.crashReportDataFactory.createCrashData(reportBuilder);
            for (ReportingAdministrator reportingAdministrator3 : this.reportingAdministrators) {
                try {
                    if (!reportingAdministrator3.shouldSendReport(this.context, this.config, crashReportData)) {
                        reportingAdministrator = reportingAdministrator3;
                    }
                } catch (Exception e2) {
                    ACRA.log.mo60w(ACRA.LOG_TAG, "ReportingAdministrator " + ((Object) reportingAdministrator3.getClass().getName()) + " threw exception", e2);
                }
            }
        } else if (ACRA.DEV_LOGGING) {
            ACRA.log.mo69d(ACRA.LOG_TAG, Intrinsics.stringPlus("Not collecting crash report because of ReportingAdministrator ", reportingAdministrator.getClass().getName()));
        }
        boolean z = true;
        if (reportBuilder.isEndApplication()) {
            boolean z2 = true;
            for (ReportingAdministrator reportingAdministrator4 : this.reportingAdministrators) {
                try {
                    if (!reportingAdministrator4.shouldFinishActivity(this.context, this.config, this.lastActivityManager)) {
                        z2 = false;
                    }
                } catch (Exception e3) {
                    ACRA.log.mo60w(ACRA.LOG_TAG, "ReportingAdministrator " + ((Object) reportingAdministrator4.getClass().getName()) + " threw exception", e3);
                }
            }
            if (z2) {
                this.processFinisher.finishLastActivity(reportBuilder.getUncaughtExceptionThread());
            }
        }
        if (reportingAdministrator == null) {
            StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
            Intrinsics.checkNotNull(crashReportData);
            File reportFileName = getReportFileName(crashReportData);
            saveCrashReportFile(reportFileName, crashReportData);
            ReportInteractionExecutor reportInteractionExecutor = new ReportInteractionExecutor(this.context, this.config);
            if (reportBuilder.isSendSilently()) {
                sendReport(reportFileName, reportInteractionExecutor.hasInteractions());
            } else if (reportInteractionExecutor.performInteractions(reportFileName)) {
                sendReport(reportFileName, false);
            }
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        } else {
            if (ACRA.DEV_LOGGING) {
                ACRA.log.mo69d(ACRA.LOG_TAG, Intrinsics.stringPlus("Not sending crash report because of ReportingAdministrator ", reportingAdministrator.getClass().getName()));
            }
            try {
                reportingAdministrator.notifyReportDropped(this.context, this.config);
            } catch (Exception e4) {
                ACRA.log.mo60w(ACRA.LOG_TAG, "ReportingAdministrator " + ((Object) reportingAdministrator.getClass().getName()) + " threw exeption", e4);
            }
        }
        if (ACRA.DEV_LOGGING) {
            ACRA.log.mo69d(ACRA.LOG_TAG, Intrinsics.stringPlus("Wait for Interactions + worker ended. Kill Application ? ", Boolean.valueOf(reportBuilder.isEndApplication())));
        }
        if (reportBuilder.isEndApplication()) {
            for (ReportingAdministrator reportingAdministrator5 : this.reportingAdministrators) {
                try {
                    if (!reportingAdministrator5.shouldKillApplication(this.context, this.config, reportBuilder, crashReportData)) {
                        z = false;
                    }
                } catch (Exception e5) {
                    ACRA.log.mo60w(ACRA.LOG_TAG, "ReportingAdministrator " + ((Object) reportingAdministrator5.getClass().getName()) + " threw exception", e5);
                }
            }
            if (z) {
                if (Debug.isDebuggerConnected()) {
                    new Thread(new Runnable() { // from class: org.acra.builder.-$$Lambda$ReportExecutor$tmhFMjTAX6sHGBAOFP68vLMFmls
                        @Override // java.lang.Runnable
                        public final void run() {
                            ReportExecutor.m10732execute$lambda12(ReportExecutor.this, r2);
                        }
                    }).start();
                    ACRA.log.mo61w(ACRA.LOG_TAG, "Warning: Acra may behave differently with a debugger attached");
                    return;
                }
                Thread uncaughtExceptionThread = reportBuilder.getUncaughtExceptionThread();
                RuntimeException exception = reportBuilder.getException();
                if (exception == null) {
                    exception = new RuntimeException();
                }
                endApplication(uncaughtExceptionThread, exception);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: execute$lambda-12  reason: not valid java name */
    public static final void m10732execute$lambda12(ReportExecutor this$0, String warning) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(warning, "$warning");
        Looper.prepare();
        ToastSender toastSender = ToastSender.INSTANCE;
        ToastSender.sendToast(this$0.context, warning, 1);
        Looper.loop();
    }

    private final void endApplication(Thread thread, Throwable th) {
        boolean alsoReportToAndroidFramework = this.config.getAlsoReportToAndroidFramework();
        if (thread == null || !alsoReportToAndroidFramework || this.defaultExceptionHandler == null) {
            this.processFinisher.endApplication();
            return;
        }
        if (ACRA.DEV_LOGGING) {
            ACRA.log.mo69d(ACRA.LOG_TAG, "Handing Exception on to default ExceptionHandler");
        }
        this.defaultExceptionHandler.uncaughtException(thread, th);
    }

    private final void sendReport(File file, boolean z) {
        if (this.isEnabled) {
            this.schedulerStarter.scheduleReports(file, z);
        } else {
            ACRA.log.mo61w(ACRA.LOG_TAG, "Would be sending reports, but ACRA is disabled");
        }
    }

    private final File getReportFileName(CrashReportData crashReportData) {
        String string = crashReportData.getString(ReportField.USER_CRASH_DATE);
        String string2 = crashReportData.getString(ReportField.IS_SILENT);
        StringBuilder sb = new StringBuilder();
        sb.append((Object) string);
        sb.append((string2 == null || !Boolean.parseBoolean(string2)) ? "" : ACRAConstants.SILENT_SUFFIX);
        sb.append(ACRAConstants.REPORTFILE_EXTENSION);
        return new File(new ReportLocator(this.context).getUnapprovedFolder(), sb.toString());
    }

    private final void saveCrashReportFile(File file, CrashReportData crashReportData) {
        try {
            if (ACRA.DEV_LOGGING) {
                ACRA.log.mo69d(ACRA.LOG_TAG, Intrinsics.stringPlus("Writing crash report file ", file));
            }
            new CrashReportPersister().store(crashReportData, file);
        } catch (Exception e) {
            ACRA.log.mo66e(ACRA.LOG_TAG, "An error occurred while writing the report file...", e);
        }
    }
}
