package androidx.navigation;

import androidx.navigation.Navigator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Navigator.kt */
@Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "Landroidx/navigation/NavBackStackEntry;", "D", "Landroidx/navigation/NavDestination;", "backStackEntry", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes.dex */
public final class Navigator$navigate$1 extends Lambda implements Function1<NavBackStackEntry, NavBackStackEntry> {
    final /* synthetic */ NavOptions $navOptions;
    final /* synthetic */ Navigator.Extras $navigatorExtras;
    final /* synthetic */ Navigator<D> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Navigator$navigate$1(Navigator<D> navigator, NavOptions navOptions, Navigator.Extras extras) {
        super(1);
        this.this$0 = navigator;
        this.$navOptions = navOptions;
        this.$navigatorExtras = extras;
    }

    @Override // kotlin.jvm.functions.Function1
    public final NavBackStackEntry invoke(NavBackStackEntry backStackEntry) {
        NavDestination navigate;
        Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
        NavDestination destination = backStackEntry.getDestination();
        if (!(destination instanceof NavDestination)) {
            destination = null;
        }
        if (destination != null && (navigate = this.this$0.navigate(destination, backStackEntry.getArguments(), this.$navOptions, this.$navigatorExtras)) != null) {
            return Intrinsics.areEqual(navigate, destination) ? backStackEntry : this.this$0.getState().createBackStackEntry(navigate, navigate.addInDefaultArgs(backStackEntry.getArguments()));
        }
        return null;
    }
}
