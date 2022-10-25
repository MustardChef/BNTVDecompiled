package com.lagradost.cloudstream3.p041ui.player;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractPlayerFragment.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.AbstractPlayerFragment$onViewCreated$4 */
/* loaded from: classes3.dex */
public /* synthetic */ class AbstractPlayerFragment$onViewCreated$4 extends FunctionReferenceImpl implements Functions<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractPlayerFragment$onViewCreated$4(Object obj) {
        super(0, obj, AbstractPlayerFragment.class, "requestAudioFocus", "requestAudioFocus()V", 0);
    }

    @Override // kotlin.jvm.functions.Functions
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Functions
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((AbstractPlayerFragment) this.receiver).requestAudioFocus();
    }
}
