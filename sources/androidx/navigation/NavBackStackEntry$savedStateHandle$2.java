package androidx.navigation;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NavBackStackEntry.kt */
@Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "Landroidx/lifecycle/SavedStateHandle;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes.dex */
public final class NavBackStackEntry$savedStateHandle$2 extends Lambda implements Functions<SavedStateHandle> {
    final /* synthetic */ NavBackStackEntry this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavBackStackEntry$savedStateHandle$2(NavBackStackEntry navBackStackEntry) {
        super(0);
        this.this$0 = navBackStackEntry;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Functions
    public final SavedStateHandle invoke() {
        boolean z;
        LifecycleRegistry lifecycleRegistry;
        z = this.this$0.savedStateRegistryAttached;
        if (z) {
            lifecycleRegistry = this.this$0.lifecycle;
            if (!(lifecycleRegistry.getCurrentState() != Lifecycle.State.DESTROYED)) {
                throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle after the NavBackStackEntry is destroyed.".toString());
            }
            NavBackStackEntry navBackStackEntry = this.this$0;
            return ((NavBackStackEntry.SavedStateViewModel) new ViewModelProvider(navBackStackEntry, new NavBackStackEntry.NavResultSavedStateFactory(navBackStackEntry)).get(NavBackStackEntry.SavedStateViewModel.class)).getHandle();
        }
        throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).".toString());
    }
}
