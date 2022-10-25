package org.acra.scheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.facebook.applinks.AppLinkData;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.acra.config.CoreConfiguration;
import org.acra.sender.JobSenderService;
import org.acra.sender.LegacySenderService;
import org.acra.sender.SendingConductor;
import org.acra.util.IOUtils;
import org.acra.util.bundle;

/* compiled from: DefaultSenderScheduler.kt */
@Metadata(m108d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0004J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0015J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m107d2 = {"Lorg/acra/scheduler/DefaultSenderScheduler;", "Lorg/acra/scheduler/SenderScheduler;", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "(Landroid/content/Context;Lorg/acra/config/CoreConfiguration;)V", "configureExtras", "", AppLinkData.ARGUMENTS_EXTRAS_KEY, "Landroid/os/Bundle;", "configureJob", "job", "Landroid/app/job/JobInfo$Builder;", "scheduleReportSending", LegacySenderService.EXTRA_ONLY_SEND_SILENT_REPORTS, "", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public class DefaultSenderScheduler implements SenderScheduler {
    private final CoreConfiguration config;
    private final Context context;

    protected final void configureExtras(Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
    }

    public DefaultSenderScheduler(Context context, CoreConfiguration config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.context = context;
        this.config = config;
    }

    @Override // org.acra.scheduler.SenderScheduler
    public void scheduleReportSending(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString(LegacySenderService.EXTRA_ACRA_CONFIG, IOUtils.INSTANCE.serialize(this.config));
        bundle.putBoolean(LegacySenderService.EXTRA_ONLY_SEND_SILENT_REPORTS, z);
        configureExtras(bundle);
        SendingConductor sendingConductor = new SendingConductor(this.context, this.config);
        if (!sendingConductor.getSenderInstances(false).isEmpty()) {
            if (Build.VERSION.SDK_INT >= 22) {
                Object systemService = this.context.getSystemService("jobscheduler");
                Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.job.JobScheduler");
                JobInfo.Builder builder = new JobInfo.Builder(0, new ComponentName(this.context, JobSenderService.class)).setExtras(bundle.toPersistableBundle(bundle));
                Intrinsics.checkNotNullExpressionValue(builder, "builder");
                configureJob(builder);
                ((JobScheduler) systemService).schedule(builder.build());
            } else {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setComponent(new ComponentName(this.context, LegacySenderService.class));
                this.context.startService(intent);
            }
        }
        if (!sendingConductor.getSenderInstances(true).isEmpty()) {
            sendingConductor.sendReports(true, bundle);
        }
    }

    protected void configureJob(JobInfo.Builder job) {
        Intrinsics.checkNotNullParameter(job, "job");
        job.setOverrideDeadline(0L);
    }
}
