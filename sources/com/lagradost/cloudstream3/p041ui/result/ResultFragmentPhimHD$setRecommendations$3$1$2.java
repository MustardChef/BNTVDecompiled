package com.lagradost.cloudstream3.p041ui.result;

import com.lagradost.cloudstream3.SearchResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResultFragmentPhimHD.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD$setRecommendations$3$1$2 */
/* loaded from: classes4.dex */
public final class ResultFragmentPhimHD$setRecommendations$3$1$2 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ List<String> $apiNames;
    final /* synthetic */ List<SearchResponse> $rec;
    final /* synthetic */ ResultFragmentPhimHD this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ResultFragmentPhimHD$setRecommendations$3$1$2(ResultFragmentPhimHD resultFragmentPhimHD, List<? extends SearchResponse> list, List<String> list2) {
        super(1);
        this.this$0 = resultFragmentPhimHD;
        this.$rec = list;
        this.$apiNames = list2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        this.this$0.setRecommendations(this.$rec, this.$apiNames.get(i));
    }
}
