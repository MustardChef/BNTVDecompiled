package androidx.fragment.app;

import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;

/* compiled from: FragmentViewModelLazy.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStoreOwner;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 176)
/* loaded from: classes.dex */
public final class FragmentViewModelLazyKt$viewModels$owner$4 extends Lambda implements Functions<ViewModelStoreOwner> {
    final /* synthetic */ Functions<ViewModelStoreOwner> $ownerProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FragmentViewModelLazyKt$viewModels$owner$4(Functions<? extends ViewModelStoreOwner> functions) {
        super(0);
        this.$ownerProducer = functions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Functions
    public final ViewModelStoreOwner invoke() {
        return this.$ownerProducer.invoke();
    }
}