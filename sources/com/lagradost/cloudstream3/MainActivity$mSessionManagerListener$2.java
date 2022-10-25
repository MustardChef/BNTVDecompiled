package com.lagradost.cloudstream3;

import com.lagradost.cloudstream3.MainActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;

/* compiled from: MainActivity.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/MainActivity$SessionManagerListenerImpl;", "Lcom/lagradost/cloudstream3/MainActivity;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
final class MainActivity$mSessionManagerListener$2 extends Lambda implements Functions<MainActivity.SessionManagerListenerImpl> {
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$mSessionManagerListener$2(MainActivity mainActivity) {
        super(0);
        this.this$0 = mainActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Functions
    public final MainActivity.SessionManagerListenerImpl invoke() {
        return new MainActivity.SessionManagerListenerImpl();
    }
}
