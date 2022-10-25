package com.lagradost.cloudstream3;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.acra.config.CoreConfiguration;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderFactory;

/* compiled from: AcraApplication.kt */
@Metadata(m108d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000b"}, m107d2 = {"Lcom/lagradost/cloudstream3/CustomSenderFactory;", "Lorg/acra/sender/ReportSenderFactory;", "()V", "create", "Lorg/acra/sender/ReportSender;", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "enabled", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class CustomSenderFactory implements ReportSenderFactory {
    @Override // org.acra.plugins.Plugin
    public boolean enabled(CoreConfiguration config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return true;
    }

    @Override // org.acra.sender.ReportSenderFactory
    public ReportSender create(Context context, CoreConfiguration config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        return new CustomReportSender();
    }
}
