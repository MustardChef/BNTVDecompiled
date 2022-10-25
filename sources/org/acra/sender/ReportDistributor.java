package org.acra.sender;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.applinks.AppLinkData;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.config.CoreConfiguration;
import org.acra.config.RetryPolicy;
import org.acra.data.CrashReportData;
import org.acra.file.CrashReportPersister;
import org.acra.log.ACRALog;
import org.acra.util.IOUtils;
import org.acra.util.InstanceCreator;
import org.json.JSONException;

/* compiled from: ReportDistributor.kt */
@Metadata(m108d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m107d2 = {"Lorg/acra/sender/ReportDistributor;", "", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "reportSenders", "", "Lorg/acra/sender/ReportSender;", AppLinkData.ARGUMENTS_EXTRAS_KEY, "Landroid/os/Bundle;", "(Landroid/content/Context;Lorg/acra/config/CoreConfiguration;Ljava/util/List;Landroid/os/Bundle;)V", "isDebuggable", "", "()Z", "distribute", "reportFile", "Ljava/io/File;", "sendCrashReport", "", "errorContent", "Lorg/acra/data/CrashReportData;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ReportDistributor {
    private final CoreConfiguration config;
    private final Context context;
    private final Bundle extras;
    private final List<ReportSender> reportSenders;

    /* JADX WARN: Multi-variable type inference failed */
    public ReportDistributor(Context context, CoreConfiguration config, List<? extends ReportSender> reportSenders, Bundle extras) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportSenders, "reportSenders");
        Intrinsics.checkNotNullParameter(extras, "extras");
        this.context = context;
        this.config = config;
        this.reportSenders = reportSenders;
        this.extras = extras;
    }

    private final void sendCrashReport(CrashReportData crashReportData) throws ReportSenderException {
        if (!isDebuggable() || this.config.getSendReportsInDevMode()) {
            LinkedList<RetryPolicy.FailedSender> linkedList = new LinkedList();
            for (ReportSender reportSender : this.reportSenders) {
                try {
                    if (ACRA.DEV_LOGGING) {
                        ACRA.log.mo69d(ACRA.LOG_TAG, Intrinsics.stringPlus("Sending report using ", reportSender.getClass().getName()));
                    }
                    reportSender.send(this.context, crashReportData, this.extras);
                    if (ACRA.DEV_LOGGING) {
                        ACRA.log.mo69d(ACRA.LOG_TAG, Intrinsics.stringPlus("Sent report using ", reportSender.getClass().getName()));
                    }
                } catch (ReportSenderException e) {
                    linkedList.add(new RetryPolicy.FailedSender(reportSender, e));
                }
            }
            if (!linkedList.isEmpty()) {
                InstanceCreator instanceCreator = InstanceCreator.INSTANCE;
                if (((RetryPolicy) InstanceCreator.create(this.config.getRetryPolicyClass(), ReportDistributor$sendCrashReport$4.INSTANCE)).shouldRetrySend(this.reportSenders, linkedList)) {
                    throw new ReportSenderException("Policy marked this task as incomplete. ACRA will try to send this report again.", ((RetryPolicy.FailedSender) linkedList.get(0)).getException());
                }
                ACRALog aCRALog = ACRA.log;
                String str = ACRA.LOG_TAG;
                StringBuilder sb = new StringBuilder("ReportSenders of classes [");
                for (RetryPolicy.FailedSender failedSender : linkedList) {
                    sb.append(failedSender.getSender().getClass().getName());
                    sb.append(", ");
                }
                sb.append("] failed, but Policy marked this task as complete. ACRA will not send this report again.");
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
                aCRALog.mo61w(str, sb2);
            } else if (ACRA.DEV_LOGGING) {
                ACRA.log.mo69d(ACRA.LOG_TAG, "Report was sent by all senders");
            }
        }
    }

    private final boolean isDebuggable() {
        try {
            return (this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 0).flags & 2) > 0;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final boolean distribute(File reportFile) {
        Intrinsics.checkNotNullParameter(reportFile, "reportFile");
        ACRA.log.mo65i(ACRA.LOG_TAG, Intrinsics.stringPlus("Sending report ", reportFile));
        try {
            sendCrashReport(new CrashReportPersister().load(reportFile));
            IOUtils iOUtils = IOUtils.INSTANCE;
            IOUtils.deleteFile(reportFile);
            return true;
        } catch (IOException e) {
            ACRA.log.mo66e(ACRA.LOG_TAG, Intrinsics.stringPlus("Failed to send crash reports for ", reportFile), e);
            IOUtils iOUtils2 = IOUtils.INSTANCE;
            IOUtils.deleteFile(reportFile);
            return false;
        } catch (RuntimeException e2) {
            ACRA.log.mo66e(ACRA.LOG_TAG, Intrinsics.stringPlus("Failed to send crash reports for ", reportFile), e2);
            IOUtils iOUtils3 = IOUtils.INSTANCE;
            IOUtils.deleteFile(reportFile);
            return false;
        } catch (ReportSenderException e3) {
            ACRA.log.mo66e(ACRA.LOG_TAG, Intrinsics.stringPlus("Failed to send crash reports for ", reportFile), e3);
            return false;
        } catch (JSONException e4) {
            ACRA.log.mo66e(ACRA.LOG_TAG, Intrinsics.stringPlus("Failed to send crash reports for ", reportFile), e4);
            IOUtils iOUtils4 = IOUtils.INSTANCE;
            IOUtils.deleteFile(reportFile);
            return false;
        }
    }
}
