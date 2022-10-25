package androidx.lifecycle;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: SavedStateHandleSupport.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "Landroidx/lifecycle/SavedStateHandlesVM;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes.dex */
final class SavedStateHandleSupport$savedStateHandlesVM$1$1 extends Lambda implements Function1<CreationExtras, SavedStateHandlesVM> {
    public static final SavedStateHandleSupport$savedStateHandlesVM$1$1 INSTANCE = new SavedStateHandleSupport$savedStateHandlesVM$1$1();

    SavedStateHandleSupport$savedStateHandlesVM$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final SavedStateHandlesVM invoke(CreationExtras initializer) {
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        return new SavedStateHandlesVM();
    }
}
