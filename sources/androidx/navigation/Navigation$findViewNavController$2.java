package androidx.navigation;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Navigation.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "Landroidx/navigation/NavController;", "it", "Landroid/view/View;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes.dex */
public final class Navigation$findViewNavController$2 extends Lambda implements Function1<View, NavController> {
    public static final Navigation$findViewNavController$2 INSTANCE = new Navigation$findViewNavController$2();

    Navigation$findViewNavController$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final NavController invoke(View it) {
        NavController viewNavController;
        Intrinsics.checkNotNullParameter(it, "it");
        viewNavController = Navigation.INSTANCE.getViewNavController(it);
        return viewNavController;
    }
}
