package androidx.navigation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NavController.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "entry", "Landroidx/navigation/NavBackStackEntry;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes.dex */
public final class NavController$popBackStackInternal$2 extends Lambda implements Function1<NavBackStackEntry, Unit> {
    final /* synthetic */ Ref.BooleanRef $popped;
    final /* synthetic */ Ref.BooleanRef $receivedPop;
    final /* synthetic */ boolean $saveState;
    final /* synthetic */ ArrayDeque<NavBackStackEntryState> $savedState;
    final /* synthetic */ NavController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavController$popBackStackInternal$2(Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, NavController navController, boolean z, ArrayDeque<NavBackStackEntryState> arrayDeque) {
        super(1);
        this.$receivedPop = booleanRef;
        this.$popped = booleanRef2;
        this.this$0 = navController;
        this.$saveState = z;
        this.$savedState = arrayDeque;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(NavBackStackEntry navBackStackEntry) {
        invoke2(navBackStackEntry);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(NavBackStackEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        this.$receivedPop.element = true;
        this.$popped.element = true;
        this.this$0.popEntryFromBackStack(entry, this.$saveState, this.$savedState);
    }
}
