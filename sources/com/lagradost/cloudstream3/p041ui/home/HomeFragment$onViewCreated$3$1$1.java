package com.lagradost.cloudstream3.p041ui.home;

import com.lagradost.cloudstream3.TvType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeFragment.kt */
@Metadata(m108d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003H\n¢\u0006\u0002\b\u0007"}, m107d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", "", "Lcom/lagradost/cloudstream3/TvType;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.home.HomeFragment$onViewCreated$3$1$1 */
/* loaded from: classes3.dex */
public final class HomeFragment$onViewCreated$3$1$1 extends Lambda implements Function1<Tuples<? extends Integer, ? extends List<? extends TvType>>, CharSequence> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeFragment$onViewCreated$3$1$1(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(Tuples<Integer, ? extends List<? extends TvType>> it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String string = this.this$0.getString(it.getFirst().intValue());
        Intrinsics.checkNotNullExpressionValue(string, "getString(it.first)");
        return string;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Tuples<? extends Integer, ? extends List<? extends TvType>> tuples) {
        return invoke2((Tuples<Integer, ? extends List<? extends TvType>>) tuples);
    }
}
