package com.lagradost.cloudstream3.p041ui.subtitles;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: SubtitlesFragment.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.subtitles.SubtitlesFragment$onViewCreated$2 */
/* loaded from: classes4.dex */
/* synthetic */ class SubtitlesFragment$onViewCreated$2 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SubtitlesFragment$onViewCreated$2(Object obj) {
        super(1, obj, SubtitlesFragment.class, "onDialogDismissed", "onDialogDismissed(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ((SubtitlesFragment) this.receiver).onDialogDismissed(i);
    }
}
