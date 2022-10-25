package com.lagradost.cloudstream3.p041ui.home;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lagradost.cloudstream3.p041ui.AutofitRecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: HomeFragment.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", TtmlNode.TAG_SPAN, "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.home.HomeFragment$Companion$loadHomepageList$spanListener$1 */
/* loaded from: classes3.dex */
final class HomeFragment$Companion$loadHomepageList$spanListener$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ AutofitRecyclerView $recycle;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeFragment$Companion$loadHomepageList$spanListener$1(AutofitRecyclerView autofitRecyclerView) {
        super(1);
        this.$recycle = autofitRecyclerView;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        this.$recycle.setSpanCount(i);
    }
}
