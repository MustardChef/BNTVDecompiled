package com.lagradost.cloudstream3.p041ui;

import com.lagradost.cloudstream3.p041ui.result.ResultEpisode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ControllerActivity.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.SelectSourceController$1$3$loadMirror$2 */
/* loaded from: classes.dex */
public final class SelectSourceController$1$3$loadMirror$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ ResultEpisode $epData;
    final /* synthetic */ MetadataHolder $holder;
    final /* synthetic */ int $index;
    final /* synthetic */ SelectSourceController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectSourceController$1$3$loadMirror$2(int i, MetadataHolder metadataHolder, ResultEpisode resultEpisode, SelectSourceController selectSourceController) {
        super(1);
        this.$index = i;
        this.$holder = metadataHolder;
        this.$epData = resultEpisode;
        this.this$0 = selectSourceController;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        SelectSourceController.m8608lambda11$lambda10$loadMirror(this.$holder, this.$epData, this.this$0, this.$index + 1);
    }
}
