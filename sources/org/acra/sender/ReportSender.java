package org.acra.sender;

import android.content.Context;
import android.os.Bundle;
import com.facebook.applinks.AppLinkData;
import kotlin.Metadata;
import kotlin.jvm.JvmDefault;
import kotlin.jvm.internal.Intrinsics;
import org.acra.data.CrashReportData;

/* compiled from: ReportSender.kt */
@Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017¨\u0006\f"}, m107d2 = {"Lorg/acra/sender/ReportSender;", "", "requiresForeground", "", "send", "", "context", "Landroid/content/Context;", "errorContent", "Lorg/acra/data/CrashReportData;", AppLinkData.ARGUMENTS_EXTRAS_KEY, "Landroid/os/Bundle;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public interface ReportSender {
    @JvmDefault
    boolean requiresForeground();

    @JvmDefault
    void send(Context context, CrashReportData crashReportData) throws ReportSenderException;

    @JvmDefault
    void send(Context context, CrashReportData crashReportData, Bundle bundle) throws ReportSenderException;

    /* compiled from: ReportSender.kt */
    /* renamed from: org.acra.sender.ReportSender$-CC  reason: invalid class name */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC {
        @JvmDefault
        public static boolean $default$requiresForeground(ReportSender reportSender) {
            return false;
        }

        @JvmDefault
        public static void $default$send(ReportSender reportSender, Context context, CrashReportData errorContent) throws ReportSenderException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(errorContent, "errorContent");
        }

        @JvmDefault
        public static void $default$send(ReportSender _this, Context context, CrashReportData errorContent, Bundle extras) throws ReportSenderException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(errorContent, "errorContent");
            Intrinsics.checkNotNullParameter(extras, "extras");
            _this.send(context, errorContent);
        }
    }
}
