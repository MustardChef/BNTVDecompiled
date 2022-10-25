package org.acra.scheduler;

import android.content.Context;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.config.CoreConfiguration;
import org.acra.file.ReportLocator;
import org.acra.log.ACRALog;
import org.acra.sender.LegacySenderService;

/* compiled from: SchedulerStarter.kt */
@Metadata(m108d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, m107d2 = {"Lorg/acra/scheduler/SchedulerStarter;", "", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "(Landroid/content/Context;Lorg/acra/config/CoreConfiguration;)V", "locator", "Lorg/acra/file/ReportLocator;", "senderScheduler", "Lorg/acra/scheduler/SenderScheduler;", "getSenderScheduler", "()Lorg/acra/scheduler/SenderScheduler;", "scheduleReports", "", "report", "Ljava/io/File;", LegacySenderService.EXTRA_ONLY_SEND_SILENT_REPORTS, "", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class SchedulerStarter {
    private final ReportLocator locator;
    private final SenderScheduler senderScheduler;

    public SchedulerStarter(Context context, CoreConfiguration config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.locator = new ReportLocator(context);
        List loadEnabled = config.getPluginLoader().loadEnabled(config, SenderSchedulerFactory.class);
        if (loadEnabled.isEmpty()) {
            this.senderScheduler = new DefaultSenderScheduler(context, config);
            return;
        }
        this.senderScheduler = ((SenderSchedulerFactory) loadEnabled.get(0)).create(context, config);
        if (loadEnabled.size() > 1) {
            ACRA.log.mo61w(ACRA.LOG_TAG, Intrinsics.stringPlus("More than one SenderScheduler found. Will use only ", getSenderScheduler().getClass().getSimpleName()));
        }
    }

    public final SenderScheduler getSenderScheduler() {
        return this.senderScheduler;
    }

    public final void scheduleReports(File file, boolean z) {
        if (file != null) {
            if (ACRA.DEV_LOGGING) {
                ACRALog aCRALog = ACRA.log;
                String str = ACRA.LOG_TAG;
                aCRALog.mo69d(str, "Mark " + ((Object) file.getName()) + " as approved.");
            }
            File file2 = new File(this.locator.getApprovedFolder(), file.getName());
            if (!file.renameTo(file2)) {
                ACRALog aCRALog2 = ACRA.log;
                String str2 = ACRA.LOG_TAG;
                aCRALog2.mo61w(str2, "Could not rename approved report from " + file + " to " + file2);
            }
        }
        if (ACRA.DEV_LOGGING) {
            ACRA.log.mo69d(ACRA.LOG_TAG, "Schedule report sending");
        }
        this.senderScheduler.scheduleReportSending(z);
    }
}
