package com.lagradost.cloudstream3.p041ui.player;

import android.view.KeyEvent;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FullScreenPlayer.kt */
@Metadata(m108d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, m107d2 = {"<anonymous>", "", "eventNav", "Lkotlin/Pair;", "Landroid/view/KeyEvent;", "invoke", "(Lkotlin/Pair;)Ljava/lang/Boolean;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.FullScreenPlayer$onViewCreated$2 */
/* loaded from: classes3.dex */
public final class FullScreenPlayer$onViewCreated$2 extends Lambda implements Function1<Tuples<? extends KeyEvent, ? extends Boolean>, Boolean> {
    final /* synthetic */ FullScreenPlayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullScreenPlayer$onViewCreated$2(FullScreenPlayer fullScreenPlayer) {
        super(1);
        this.this$0 = fullScreenPlayer;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Tuples<? extends KeyEvent, ? extends Boolean> tuples) {
        return invoke2((Tuples<? extends KeyEvent, Boolean>) tuples);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Boolean invoke2(Tuples<? extends KeyEvent, Boolean> eventNav) {
        Intrinsics.checkNotNullParameter(eventNav, "eventNav");
        KeyEvent component1 = eventNav.component1();
        return Boolean.valueOf(component1 != null ? this.this$0.handleKeyEvent(component1, eventNav.component2().booleanValue()) : false);
    }
}
