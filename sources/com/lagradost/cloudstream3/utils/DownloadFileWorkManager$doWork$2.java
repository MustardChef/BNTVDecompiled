package com.lagradost.cloudstream3.utils;

import android.app.Notification;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadFileWorkManager.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public /* synthetic */ class DownloadFileWorkManager$doWork$2 extends FunctionReferenceImpl implements Function2<Integer, Notification, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DownloadFileWorkManager$doWork$2(Object obj) {
        super(2, obj, DownloadFileWorkManager.class, "handleNotification", "handleNotification(ILandroid/app/Notification;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Notification notification) {
        invoke(num.intValue(), notification);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, Notification p1) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        ((DownloadFileWorkManager) this.receiver).handleNotification(i, p1);
    }
}
