package org.acra.sender;

import android.content.Context;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.data.CrashReportData;
import org.acra.sender.ReportSender;

/* compiled from: NullSender.kt */
@Metadata(m108d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, m107d2 = {"Lorg/acra/sender/NullSender;", "Lorg/acra/sender/ReportSender;", "()V", "send", "", "context", "Landroid/content/Context;", "errorContent", "Lorg/acra/data/CrashReportData;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public class NullSender implements ReportSender {
    @Override // org.acra.sender.ReportSender
    public /* synthetic */ boolean requiresForeground() {
        return ReportSender.CC.$default$requiresForeground(this);
    }

    @Override // org.acra.sender.ReportSender
    public /* synthetic */ void send(Context context, CrashReportData crashReportData, Bundle bundle) {
        ReportSender.CC.$default$send(this, context, crashReportData, bundle);
    }

    @Override // org.acra.sender.ReportSender
    public void send(Context context, CrashReportData errorContent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(errorContent, "errorContent");
        ACRA.log.mo61w(ACRA.LOG_TAG, Intrinsics.stringPlus(context.getPackageName(), " reports will NOT be sent - no valid ReportSender was found!"));
    }
}
