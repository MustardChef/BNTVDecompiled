package androidx.activity;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(m108d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\bø\u0001\u0000\u001aF\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0010\b\n\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, m107d2 = {"viewModels", "Lkotlin/Lazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Landroidx/activity/ComponentActivity;", "factoryProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "extrasProducer", "Landroidx/lifecycle/viewmodel/CreationExtras;", "activity-ktx_release"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: androidx.activity.ActivityViewModelLazyKt */
/* loaded from: classes.dex */
public final class ActivityViewModelLazy {
    public static /* synthetic */ Lazy viewModels$default(ComponentActivity componentActivity, Functions functions, int i, Object obj) {
        if ((i & 1) != 0) {
            functions = null;
        }
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        if (functions == null) {
            functions = new ActivityViewModelLazyKt$viewModels$factoryPromise$1(componentActivity);
        }
        Intrinsics.reifiedOperationMarker(4, "VM");
        return new ViewModelLazy(Reflection.getOrCreateKotlinClass(ViewModel.class), new ActivityViewModelLazyKt$viewModels$1(componentActivity), functions, new ActivityViewModelLazyKt$viewModels$2(componentActivity));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by viewModels that takes a CreationExtras")
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> viewModels(ComponentActivity componentActivity, Functions<? extends ViewModelProvider.Factory> functions) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        if (functions == null) {
            functions = new ActivityViewModelLazyKt$viewModels$factoryPromise$1(componentActivity);
        }
        Intrinsics.reifiedOperationMarker(4, "VM");
        return new ViewModelLazy(Reflection.getOrCreateKotlinClass(ViewModel.class), new ActivityViewModelLazyKt$viewModels$1(componentActivity), functions, new ActivityViewModelLazyKt$viewModels$2(componentActivity));
    }

    public static /* synthetic */ Lazy viewModels$default(ComponentActivity componentActivity, Functions functions, Functions functions2, int i, Object obj) {
        if ((i & 1) != 0) {
            functions = null;
        }
        if ((i & 2) != 0) {
            functions2 = null;
        }
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        if (functions2 == null) {
            functions2 = new ActivityViewModelLazyKt$viewModels$factoryPromise$2(componentActivity);
        }
        Intrinsics.reifiedOperationMarker(4, "VM");
        return new ViewModelLazy(Reflection.getOrCreateKotlinClass(ViewModel.class), new ActivityViewModelLazyKt$viewModels$3(componentActivity), functions2, new ActivityViewModelLazyKt$viewModels$4(functions, componentActivity));
    }

    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> viewModels(ComponentActivity componentActivity, Functions<? extends CreationExtras> functions, Functions<? extends ViewModelProvider.Factory> functions2) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        if (functions2 == null) {
            functions2 = new ActivityViewModelLazyKt$viewModels$factoryPromise$2(componentActivity);
        }
        Intrinsics.reifiedOperationMarker(4, "VM");
        return new ViewModelLazy(Reflection.getOrCreateKotlinClass(ViewModel.class), new ActivityViewModelLazyKt$viewModels$3(componentActivity), functions2, new ActivityViewModelLazyKt$viewModels$4(functions, componentActivity));
    }
}
