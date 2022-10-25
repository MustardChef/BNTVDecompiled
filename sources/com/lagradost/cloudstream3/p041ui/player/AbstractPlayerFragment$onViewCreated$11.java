package com.lagradost.cloudstream3.p041ui.player;

import com.lagradost.cloudstream3.p041ui.subtitles.SaveCaptionStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractPlayerFragment.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.AbstractPlayerFragment$onViewCreated$11 */
/* loaded from: classes3.dex */
public /* synthetic */ class AbstractPlayerFragment$onViewCreated$11 extends FunctionReferenceImpl implements Function1<SaveCaptionStyle, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractPlayerFragment$onViewCreated$11(Object obj) {
        super(1, obj, AbstractPlayerFragment.class, "onSubStyleChanged", "onSubStyleChanged(Lcom/lagradost/cloudstream3/ui/subtitles/SaveCaptionStyle;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SaveCaptionStyle saveCaptionStyle) {
        invoke2(saveCaptionStyle);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SaveCaptionStyle p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((AbstractPlayerFragment) this.receiver).onSubStyleChanged(p0);
    }
}
