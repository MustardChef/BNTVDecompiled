package androidx.fragment.app;

import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: FragmentViewModelLazy.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 176)
/* loaded from: classes.dex */
public final class FragmentViewModelLazyKt$viewModels$4 extends Lambda implements Functions<ViewModelProvider.Factory> {
    final /* synthetic */ Lazy<ViewModelStoreOwner> $owner$delegate;
    final /* synthetic */ Fragment $this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FragmentViewModelLazyKt$viewModels$4(Fragment fragment, Lazy<? extends ViewModelStoreOwner> lazy) {
        super(0);
        this.$this_viewModels = fragment;
        this.$owner$delegate = lazy;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Functions
    public final ViewModelProvider.Factory invoke() {
        ViewModelStoreOwner m8497viewModels$lambda0;
        ViewModelProvider.Factory defaultViewModelProviderFactory;
        m8497viewModels$lambda0 = FragmentViewModelLazy.m8497viewModels$lambda0(this.$owner$delegate);
        HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = m8497viewModels$lambda0 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) m8497viewModels$lambda0 : null;
        if (hasDefaultViewModelProviderFactory == null || (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) == null) {
            defaultViewModelProviderFactory = this.$this_viewModels.getDefaultViewModelProviderFactory();
        }
        Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
        return defaultViewModelProviderFactory;
    }
}
