package org.acra.startup;

import android.content.Context;
import android.os.Handler;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.config.CoreConfiguration;
import org.acra.file.CrashReportFileNameParser;
import org.acra.file.ReportLocator;
import org.acra.interaction.ReportInteractionExecutor;
import org.acra.scheduler.SchedulerStarter;

/* compiled from: StartupProcessorExecutor.kt */
@Metadata(m108d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m107d2 = {"Lorg/acra/startup/StartupProcessorExecutor;", "", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "schedulerStarter", "Lorg/acra/scheduler/SchedulerStarter;", "(Landroid/content/Context;Lorg/acra/config/CoreConfiguration;Lorg/acra/scheduler/SchedulerStarter;)V", "fileNameParser", "Lorg/acra/file/CrashReportFileNameParser;", "reportLocator", "Lorg/acra/file/ReportLocator;", "processReports", "", "isAcraEnabled", "", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class StartupProcessorExecutor {
    private final CoreConfiguration config;
    private final Context context;
    private final CrashReportFileNameParser fileNameParser;
    private final ReportLocator reportLocator;
    private final SchedulerStarter schedulerStarter;

    public StartupProcessorExecutor(Context context, CoreConfiguration config, SchedulerStarter schedulerStarter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(schedulerStarter, "schedulerStarter");
        this.context = context;
        this.config = config;
        this.schedulerStarter = schedulerStarter;
        this.reportLocator = new ReportLocator(context);
        this.fileNameParser = new CrashReportFileNameParser();
    }

    public final void processReports(final boolean z) {
        final Calendar calendar = Calendar.getInstance();
        new Handler(this.context.getMainLooper()).post(new Runnable() { // from class: org.acra.startup.-$$Lambda$StartupProcessorExecutor$eTQ3rPTtg3GKDjm-U6ll8RO4GjM
            @Override // java.lang.Runnable
            public final void run() {
                StartupProcessorExecutor.m10744processReports$lambda5(StartupProcessorExecutor.this, calendar, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: processReports$lambda-5  reason: not valid java name */
    public static final void m10744processReports$lambda5(final StartupProcessorExecutor this$0, final Calendar calendar, final boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new Thread(new Runnable() { // from class: org.acra.startup.-$$Lambda$StartupProcessorExecutor$o2NE53IEwtcT_aLpWXA2a4JC9OE
            @Override // java.lang.Runnable
            public final void run() {
                StartupProcessorExecutor.m10745processReports$lambda5$lambda4(StartupProcessorExecutor.this, calendar, z);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: processReports$lambda-5$lambda-4  reason: not valid java name */
    public static final void m10745processReports$lambda5$lambda4(StartupProcessorExecutor this$0, Calendar calendar, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        File[] unapprovedReports = this$0.reportLocator.getUnapprovedReports();
        ArrayList arrayList = new ArrayList(unapprovedReports.length);
        for (File file : unapprovedReports) {
            arrayList.add(new Report(file, false));
        }
        ArrayList arrayList2 = arrayList;
        File[] approvedReports = this$0.reportLocator.getApprovedReports();
        ArrayList arrayList3 = new ArrayList(approvedReports.length);
        for (File file2 : approvedReports) {
            arrayList3.add(new Report(file2, true));
        }
        List<Report> plus = CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList3);
        for (StartupProcessor startupProcessor : this$0.config.getPluginLoader().loadEnabled(this$0.config, StartupProcessor.class)) {
            startupProcessor.processReports(this$0.context, this$0.config, plus);
        }
        boolean z2 = false;
        for (Report report : plus) {
            CrashReportFileNameParser crashReportFileNameParser = this$0.fileNameParser;
            String name = report.getFile().getName();
            Intrinsics.checkNotNullExpressionValue(name, "report.file.name");
            if (crashReportFileNameParser.getTimestamp(name).before(calendar)) {
                if (report.getDelete()) {
                    if (!report.getFile().delete()) {
                        ACRA.log.mo61w(ACRA.LOG_TAG, Intrinsics.stringPlus("Could not delete report ", report.getFile()));
                    }
                } else if (report.getApproved()) {
                    z2 = true;
                } else if (report.getApprove() && z) {
                    new ReportInteractionExecutor(this$0.context, this$0.config).performInteractions(report.getFile());
                }
            }
        }
        if (z2 && z) {
            this$0.schedulerStarter.scheduleReports(null, false);
        }
    }
}
