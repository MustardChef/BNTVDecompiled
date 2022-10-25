package com.lagradost.cloudstream3.p041ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ControllerActivity.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.SelectSourceController$onMediaStatusUpdated$1$1$1 */
/* loaded from: classes.dex */
public final class SelectSourceController$onMediaStatusUpdated$1$1$1 extends Lambda implements Function1<Boolean, Unit> {
    public static final SelectSourceController$onMediaStatusUpdated$1$1$1 INSTANCE = new SelectSourceController$onMediaStatusUpdated$1$1$1();

    SelectSourceController$onMediaStatusUpdated$1$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        System.out.println((Object) "FAILED TO LOAD NEXT ITEM");
    }
}
