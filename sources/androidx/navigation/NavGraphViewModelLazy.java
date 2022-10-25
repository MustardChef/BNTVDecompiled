package androidx.navigation;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazy;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(m108d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\u001a>\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0087\bø\u0001\u0000\u001aP\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0010\b\n\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0087\bø\u0001\u0000\u001a<\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0087\bø\u0001\u0000\u001aN\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0010\b\n\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e²\u0006\u0016\u0010\u000f\u001a\u00020\u0010\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u008a\u0084\u0002²\u0006\u0016\u0010\u000f\u001a\u00020\u0010\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u008a\u0084\u0002²\u0006\u0016\u0010\u000f\u001a\u00020\u0010\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u008a\u0084\u0002²\u0006\u0016\u0010\u000f\u001a\u00020\u0010\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u008a\u0084\u0002"}, m107d2 = {"navGraphViewModels", "Lkotlin/Lazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/Fragment;", "navGraphId", "", "factoryProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "extrasProducer", "Landroidx/lifecycle/viewmodel/CreationExtras;", "navGraphRoute", "", "navigation-fragment_release", "backStackEntry", "Landroidx/navigation/NavBackStackEntry;"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: androidx.navigation.NavGraphViewModelLazyKt */
/* loaded from: classes.dex */
public final class NavGraphViewModelLazy {
    public static /* synthetic */ Lazy navGraphViewModels$default(Fragment fragment, int i, Functions functions, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            functions = null;
        }
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Lazy lazy = LazyKt.lazy(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$2(fragment, i));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1(lazy);
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        NavGraphViewModelLazyKt$navGraphViewModels$1 navGraphViewModelLazyKt$navGraphViewModels$1 = new NavGraphViewModelLazyKt$navGraphViewModels$1(lazy);
        if (functions == null) {
            functions = new NavGraphViewModelLazyKt$navGraphViewModels$2(lazy);
        }
        return FragmentViewModelLazy.createViewModelLazy(fragment, orCreateKotlinClass, navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1, navGraphViewModelLazyKt$navGraphViewModels$1, functions);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by navGraphViewModels that takes a CreationExtras producer")
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> navGraphViewModels(Fragment fragment, int i, Functions<? extends ViewModelProvider.Factory> functions) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Lazy lazy = LazyKt.lazy(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$2(fragment, i));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1(lazy);
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        NavGraphViewModelLazyKt$navGraphViewModels$1 navGraphViewModelLazyKt$navGraphViewModels$1 = new NavGraphViewModelLazyKt$navGraphViewModels$1(lazy);
        if (functions == null) {
            functions = new NavGraphViewModelLazyKt$navGraphViewModels$2(lazy);
        }
        return FragmentViewModelLazy.createViewModelLazy(fragment, orCreateKotlinClass, navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1, navGraphViewModelLazyKt$navGraphViewModels$1, functions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: navGraphViewModels$lambda-0  reason: not valid java name */
    public static final NavBackStackEntry m8511navGraphViewModels$lambda0(Lazy<NavBackStackEntry> lazy) {
        return lazy.getValue();
    }

    public static /* synthetic */ Lazy navGraphViewModels$default(Fragment fragment, int i, Functions functions, Functions functions2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            functions = null;
        }
        if ((i2 & 4) != 0) {
            functions2 = null;
        }
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Lazy lazy = LazyKt.lazy(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$4(fragment, i));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$2 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$2 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$2(lazy);
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        NavGraphViewModelLazyKt$navGraphViewModels$3 navGraphViewModelLazyKt$navGraphViewModels$3 = new NavGraphViewModelLazyKt$navGraphViewModels$3(functions, lazy);
        if (functions2 == null) {
            functions2 = new NavGraphViewModelLazyKt$navGraphViewModels$4(lazy);
        }
        return FragmentViewModelLazy.createViewModelLazy(fragment, orCreateKotlinClass, navGraphViewModelLazyKt$navGraphViewModels$storeProducer$2, navGraphViewModelLazyKt$navGraphViewModels$3, functions2);
    }

    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> navGraphViewModels(Fragment fragment, int i, Functions<? extends CreationExtras> functions, Functions<? extends ViewModelProvider.Factory> functions2) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Lazy lazy = LazyKt.lazy(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$4(fragment, i));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$2 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$2 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$2(lazy);
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        NavGraphViewModelLazyKt$navGraphViewModels$3 navGraphViewModelLazyKt$navGraphViewModels$3 = new NavGraphViewModelLazyKt$navGraphViewModels$3(functions, lazy);
        if (functions2 == null) {
            functions2 = new NavGraphViewModelLazyKt$navGraphViewModels$4(lazy);
        }
        return FragmentViewModelLazy.createViewModelLazy(fragment, orCreateKotlinClass, navGraphViewModelLazyKt$navGraphViewModels$storeProducer$2, navGraphViewModelLazyKt$navGraphViewModels$3, functions2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: navGraphViewModels$lambda-1  reason: not valid java name */
    public static final NavBackStackEntry m8512navGraphViewModels$lambda1(Lazy<NavBackStackEntry> lazy) {
        return lazy.getValue();
    }

    public static /* synthetic */ Lazy navGraphViewModels$default(Fragment fragment, String navGraphRoute, Functions functions, int i, Object obj) {
        if ((i & 2) != 0) {
            functions = null;
        }
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(navGraphRoute, "navGraphRoute");
        Lazy lazy = LazyKt.lazy(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$6(fragment, navGraphRoute));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$3 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$3 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$3(lazy);
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        NavGraphViewModelLazyKt$navGraphViewModels$5 navGraphViewModelLazyKt$navGraphViewModels$5 = new NavGraphViewModelLazyKt$navGraphViewModels$5(lazy);
        if (functions == null) {
            functions = new NavGraphViewModelLazyKt$navGraphViewModels$6(lazy);
        }
        return FragmentViewModelLazy.createViewModelLazy(fragment, orCreateKotlinClass, navGraphViewModelLazyKt$navGraphViewModels$storeProducer$3, navGraphViewModelLazyKt$navGraphViewModels$5, functions);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by navGraphViewModels that takes a CreationExtras producer")
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> navGraphViewModels(Fragment fragment, String navGraphRoute, Functions<? extends ViewModelProvider.Factory> functions) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(navGraphRoute, "navGraphRoute");
        Lazy lazy = LazyKt.lazy(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$6(fragment, navGraphRoute));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$3 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$3 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$3(lazy);
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        NavGraphViewModelLazyKt$navGraphViewModels$5 navGraphViewModelLazyKt$navGraphViewModels$5 = new NavGraphViewModelLazyKt$navGraphViewModels$5(lazy);
        if (functions == null) {
            functions = new NavGraphViewModelLazyKt$navGraphViewModels$6(lazy);
        }
        return FragmentViewModelLazy.createViewModelLazy(fragment, orCreateKotlinClass, navGraphViewModelLazyKt$navGraphViewModels$storeProducer$3, navGraphViewModelLazyKt$navGraphViewModels$5, functions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: navGraphViewModels$lambda-2  reason: not valid java name */
    public static final NavBackStackEntry m8513navGraphViewModels$lambda2(Lazy<NavBackStackEntry> lazy) {
        return lazy.getValue();
    }

    public static /* synthetic */ Lazy navGraphViewModels$default(Fragment fragment, String navGraphRoute, Functions functions, Functions functions2, int i, Object obj) {
        if ((i & 2) != 0) {
            functions = null;
        }
        if ((i & 4) != 0) {
            functions2 = null;
        }
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(navGraphRoute, "navGraphRoute");
        Lazy lazy = LazyKt.lazy(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$8(fragment, navGraphRoute));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$4 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$4 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$4(lazy);
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        NavGraphViewModelLazyKt$navGraphViewModels$7 navGraphViewModelLazyKt$navGraphViewModels$7 = new NavGraphViewModelLazyKt$navGraphViewModels$7(functions, lazy);
        if (functions2 == null) {
            functions2 = new NavGraphViewModelLazyKt$navGraphViewModels$8(lazy);
        }
        return FragmentViewModelLazy.createViewModelLazy(fragment, orCreateKotlinClass, navGraphViewModelLazyKt$navGraphViewModels$storeProducer$4, navGraphViewModelLazyKt$navGraphViewModels$7, functions2);
    }

    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> navGraphViewModels(Fragment fragment, String navGraphRoute, Functions<? extends CreationExtras> functions, Functions<? extends ViewModelProvider.Factory> functions2) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(navGraphRoute, "navGraphRoute");
        Lazy lazy = LazyKt.lazy(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$8(fragment, navGraphRoute));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$4 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$4 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$4(lazy);
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        NavGraphViewModelLazyKt$navGraphViewModels$7 navGraphViewModelLazyKt$navGraphViewModels$7 = new NavGraphViewModelLazyKt$navGraphViewModels$7(functions, lazy);
        if (functions2 == null) {
            functions2 = new NavGraphViewModelLazyKt$navGraphViewModels$8(lazy);
        }
        return FragmentViewModelLazy.createViewModelLazy(fragment, orCreateKotlinClass, navGraphViewModelLazyKt$navGraphViewModels$storeProducer$4, navGraphViewModelLazyKt$navGraphViewModels$7, functions2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: navGraphViewModels$lambda-3  reason: not valid java name */
    public static final NavBackStackEntry m8514navGraphViewModels$lambda3(Lazy<NavBackStackEntry> lazy) {
        return lazy.getValue();
    }
}
