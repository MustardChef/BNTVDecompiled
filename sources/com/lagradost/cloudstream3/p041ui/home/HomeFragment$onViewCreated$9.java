package com.lagradost.cloudstream3.p041ui.home;

import android.content.Context;
import com.google.android.material.button.MaterialButton;
import com.lagradost.cloudstream3.p041ui.WatchType;
import com.lagradost.cloudstream3.utils.DataStore;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: HomeFragment.kt */
@Metadata(m108d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001e\u0010\u0002\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, m107d2 = {"<anonymous>", "", "availableWatchStatusTypes", "Lkotlin/Pair;", "Ljava/util/EnumSet;", "Lcom/lagradost/cloudstream3/ui/WatchType;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.home.HomeFragment$onViewCreated$9 */
/* loaded from: classes3.dex */
final class HomeFragment$onViewCreated$9 extends Lambda implements Function1<Tuples<? extends EnumSet<WatchType>, ? extends EnumSet<WatchType>>, Unit> {
    final /* synthetic */ List<Tuples<MaterialButton, WatchType>> $toggleList;
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HomeFragment$onViewCreated$9(HomeFragment homeFragment, List<? extends Tuples<? extends MaterialButton, ? extends WatchType>> list) {
        super(1);
        this.this$0 = homeFragment;
        this.$toggleList = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Tuples<? extends EnumSet<WatchType>, ? extends EnumSet<WatchType>> tuples) {
        invoke2(tuples);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Tuples<? extends EnumSet<WatchType>, ? extends EnumSet<WatchType>> availableWatchStatusTypes) {
        Intrinsics.checkNotNullParameter(availableWatchStatusTypes, "availableWatchStatusTypes");
        Context context = this.this$0.getContext();
        if (context != null) {
            DataStore dataStore = DataStore.INSTANCE;
            EnumSet<WatchType> first = availableWatchStatusTypes.getFirst();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(first, 10));
            for (WatchType watchType : first) {
                arrayList.add(Integer.valueOf(watchType.getInternalId()));
            }
            dataStore.setKey(context, HomeFragmentKt.HOME_BOOKMARK_VALUE_LIST, CollectionsKt.toIntArray(arrayList));
        }
        for (Tuples<MaterialButton, WatchType> tuples : this.$toggleList) {
            WatchType second = tuples.getSecond();
            MaterialButton first2 = tuples.getFirst();
            if (first2 != null) {
                first2.setVisibility(availableWatchStatusTypes.getSecond().contains(second) ? 0 : 8);
                first2.setSelected(availableWatchStatusTypes.getFirst().contains(second));
            }
        }
    }
}
