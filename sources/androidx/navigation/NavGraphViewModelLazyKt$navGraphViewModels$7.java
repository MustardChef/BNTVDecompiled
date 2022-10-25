package androidx.navigation;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;

/* compiled from: NavGraphViewModelLazy.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 176)
/* loaded from: classes.dex */
public final class NavGraphViewModelLazyKt$navGraphViewModels$7 extends Lambda implements Functions<CreationExtras> {
    final /* synthetic */ Lazy<NavBackStackEntry> $backStackEntry$delegate;
    final /* synthetic */ Functions<CreationExtras> $extrasProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NavGraphViewModelLazyKt$navGraphViewModels$7(Functions<? extends CreationExtras> functions, Lazy<NavBackStackEntry> lazy) {
        super(0);
        this.$extrasProducer = functions;
        this.$backStackEntry$delegate = lazy;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Functions
    public final CreationExtras invoke() {
        NavBackStackEntry m8514navGraphViewModels$lambda3;
        CreationExtras invoke;
        Functions<CreationExtras> functions = this.$extrasProducer;
        if (functions == null || (invoke = functions.invoke()) == null) {
            m8514navGraphViewModels$lambda3 = NavGraphViewModelLazy.m8514navGraphViewModels$lambda3(this.$backStackEntry$delegate);
            return m8514navGraphViewModels$lambda3.getDefaultViewModelCreationExtras();
        }
        return invoke;
    }
}
