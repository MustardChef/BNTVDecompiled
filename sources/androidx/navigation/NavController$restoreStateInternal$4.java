package androidx.navigation;

import android.os.Bundle;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NavController.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "entry", "Landroidx/navigation/NavBackStackEntry;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes.dex */
public final class NavController$restoreStateInternal$4 extends Lambda implements Function1<NavBackStackEntry, Unit> {
    final /* synthetic */ Bundle $args;
    final /* synthetic */ List<NavBackStackEntry> $entries;
    final /* synthetic */ Ref.IntRef $lastNavigatedIndex;
    final /* synthetic */ Ref.BooleanRef $navigated;
    final /* synthetic */ NavController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavController$restoreStateInternal$4(Ref.BooleanRef booleanRef, List<NavBackStackEntry> list, Ref.IntRef intRef, NavController navController, Bundle bundle) {
        super(1);
        this.$navigated = booleanRef;
        this.$entries = list;
        this.$lastNavigatedIndex = intRef;
        this.this$0 = navController;
        this.$args = bundle;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(NavBackStackEntry navBackStackEntry) {
        invoke2(navBackStackEntry);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(NavBackStackEntry entry) {
        List<NavBackStackEntry> emptyList;
        Intrinsics.checkNotNullParameter(entry, "entry");
        this.$navigated.element = true;
        int indexOf = this.$entries.indexOf(entry);
        if (indexOf != -1) {
            int i = indexOf + 1;
            emptyList = this.$entries.subList(this.$lastNavigatedIndex.element, i);
            this.$lastNavigatedIndex.element = i;
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        this.this$0.addEntryToBackStack(entry.getDestination(), this.$args, entry, emptyList);
    }
}
