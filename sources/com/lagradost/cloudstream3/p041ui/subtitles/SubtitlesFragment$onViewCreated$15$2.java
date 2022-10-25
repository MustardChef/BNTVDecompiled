package com.lagradost.cloudstream3.p041ui.subtitles;

import com.lagradost.cloudstream3.AcraApplication;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubtitlesFragment.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "indexList", "", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.subtitles.SubtitlesFragment$onViewCreated$15$2 */
/* loaded from: classes4.dex */
public final class SubtitlesFragment$onViewCreated$15$2 extends Lambda implements Function1<List<? extends Integer>, Unit> {
    final /* synthetic */ List<String> $lang639_1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubtitlesFragment$onViewCreated$15$2(List<String> list) {
        super(1);
        this.$lang639_1 = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Integer> list) {
        invoke2((List<Integer>) list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<Integer> indexList) {
        Intrinsics.checkNotNullParameter(indexList, "indexList");
        AcraApplication.Companion companion = AcraApplication.Companion;
        List<Integer> list = indexList;
        List<String> list2 = this.$lang639_1;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Number number : list) {
            arrayList.add(list2.get(number.intValue()));
        }
        companion.setKey(SubtitlesFragmentKt.SUBTITLE_DOWNLOAD_KEY, CollectionsKt.toList(arrayList));
    }
}
