package org.acra.sender;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.facebook.applinks.AppLinkData;
import com.google.android.exoplayer2.offline.DownloadService;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.config.CoreConfiguration;
import org.acra.file.CrashReportFileNameParser;
import org.acra.file.ReportLocator;
import org.acra.log.ACRALog;
import org.acra.util.ToastSender;

/* compiled from: SendingConductor.kt */
@Metadata(m108d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m107d2 = {"Lorg/acra/sender/SendingConductor;", "", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "(Landroid/content/Context;Lorg/acra/config/CoreConfiguration;)V", "locator", "Lorg/acra/file/ReportLocator;", "getSenderInstances", "", "Lorg/acra/sender/ReportSender;", DownloadService.KEY_FOREGROUND, "", "sendReports", "", AppLinkData.ARGUMENTS_EXTRAS_KEY, "Landroid/os/Bundle;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class SendingConductor {
    private final CoreConfiguration config;
    private final Context context;
    private final ReportLocator locator;

    public SendingConductor(Context context, CoreConfiguration config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.context = context;
        this.config = config;
        this.locator = new ReportLocator(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendReports$lambda-3  reason: not valid java name */
    public static final void m10742sendReports$lambda3(SendingConductor this$0, String toast) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(toast, "$toast");
        ToastSender toastSender = ToastSender.INSTANCE;
        ToastSender.sendToast(this$0.context, toast, 1);
    }

    public final void sendReports(boolean z, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        if (ACRA.DEV_LOGGING) {
            ACRA.log.mo69d(ACRA.LOG_TAG, "About to start sending reports from SenderService");
        }
        try {
            List mutableList = CollectionsKt.toMutableList((Collection) getSenderInstances(z));
            if (mutableList.isEmpty()) {
                if (ACRA.DEV_LOGGING) {
                    ACRA.log.mo69d(ACRA.LOG_TAG, "No ReportSenders configured - adding NullSender");
                }
                mutableList.add(new NullSender());
            }
            File[] approvedReports = this.locator.getApprovedReports();
            ReportDistributor reportDistributor = new ReportDistributor(this.context, this.config, mutableList, extras);
            CrashReportFileNameParser crashReportFileNameParser = new CrashReportFileNameParser();
            int length = approvedReports.length;
            int i = 0;
            int i2 = 0;
            boolean z2 = false;
            while (i < length) {
                File file = approvedReports[i];
                i++;
                String name = file.getName();
                Intrinsics.checkNotNullExpressionValue(name, "report.name");
                boolean z3 = !crashReportFileNameParser.isSilent(name);
                if (!extras.getBoolean(LegacySenderService.EXTRA_ONLY_SEND_SILENT_REPORTS) || !z3) {
                    z2 |= z3;
                    if (i2 >= 5) {
                        break;
                    } else if (reportDistributor.distribute(file)) {
                        i2++;
                    }
                }
            }
            final String reportSendSuccessToast = i2 > 0 ? this.config.getReportSendSuccessToast() : this.config.getReportSendFailureToast();
            if (z2) {
                if (reportSendSuccessToast.length() > 0) {
                    if (ACRA.DEV_LOGGING) {
                        ACRALog aCRALog = ACRA.log;
                        String str = ACRA.LOG_TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("About to show ");
                        sb.append(i2 > 0 ? "success" : "failure");
                        sb.append(" toast");
                        aCRALog.mo69d(str, sb.toString());
                    }
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: org.acra.sender.-$$Lambda$SendingConductor$oGqXh_vHsUSRRepOXQGH3b-ddUg
                        @Override // java.lang.Runnable
                        public final void run() {
                            SendingConductor.m10742sendReports$lambda3(SendingConductor.this, reportSendSuccessToast);
                        }
                    });
                }
            }
        } catch (Exception e) {
            ACRA.log.mo66e(ACRA.LOG_TAG, "", e);
        }
        if (ACRA.DEV_LOGGING) {
            ACRA.log.mo69d(ACRA.LOG_TAG, "Finished sending reports from SenderService");
        }
    }

    public final List<ReportSender> getSenderInstances(boolean z) {
        if (ACRA.DEV_LOGGING) {
            ACRA.log.mo69d(ACRA.LOG_TAG, "Using PluginLoader to find ReportSender factories");
        }
        List loadEnabled = this.config.getPluginLoader().loadEnabled(this.config, ReportSenderFactory.class);
        if (ACRA.DEV_LOGGING) {
            ACRA.log.mo69d(ACRA.LOG_TAG, Intrinsics.stringPlus("reportSenderFactories : ", loadEnabled));
        }
        List<ReportSenderFactory> list = loadEnabled;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ReportSenderFactory reportSenderFactory : list) {
            ReportSender create = reportSenderFactory.create(this.context, this.config);
            if (ACRA.DEV_LOGGING) {
                ACRA.log.mo69d(ACRA.LOG_TAG, Intrinsics.stringPlus("Adding reportSender : ", create));
            }
            arrayList.add(create);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (z == ((ReportSender) obj).requiresForeground()) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }
}
