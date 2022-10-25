package androidx.navigation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NavController.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "Landroidx/navigation/NavDestination;", "destination", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes.dex */
public final class NavController$popBackStackInternal$3 extends Lambda implements Function1<NavDestination, NavDestination> {
    public static final NavController$popBackStackInternal$3 INSTANCE = new NavController$popBackStackInternal$3();

    NavController$popBackStackInternal$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final NavDestination invoke(NavDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        NavGraph parent = destination.getParent();
        boolean z = false;
        if (parent != null && parent.getStartDestinationId() == destination.getId()) {
            z = true;
        }
        if (z) {
            return destination.getParent();
        }
        return null;
    }
}
