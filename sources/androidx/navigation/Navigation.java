package androidx.navigation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.core.app.ActivityCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* compiled from: Navigation.kt */
@Metadata(m108d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001e\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0007¨\u0006\u0017"}, m107d2 = {"Landroidx/navigation/Navigation;", "", "()V", "createNavigateOnClickListener", "Landroid/view/View$OnClickListener;", "directions", "Landroidx/navigation/NavDirections;", "resId", "", "args", "Landroid/os/Bundle;", "findNavController", "Landroidx/navigation/NavController;", "activity", "Landroid/app/Activity;", "viewId", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "findViewNavController", "getViewNavController", "setViewNavController", "", "controller", "navigation-runtime_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes.dex */
public final class Navigation {
    public static final Navigation INSTANCE = new Navigation();

    @JvmStatic
    public static final View.OnClickListener createNavigateOnClickListener(int i) {
        return createNavigateOnClickListener$default(i, null, 2, null);
    }

    private Navigation() {
    }

    @JvmStatic
    public static final NavController findNavController(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        View requireViewById = ActivityCompat.requireViewById(activity, i);
        Intrinsics.checkNotNullExpressionValue(requireViewById, "requireViewById<View>(activity, viewId)");
        NavController findViewNavController = INSTANCE.findViewNavController(requireViewById);
        if (findViewNavController != null) {
            return findViewNavController;
        }
        throw new IllegalStateException("Activity " + activity + " does not have a NavController set on " + i);
    }

    @JvmStatic
    public static final NavController findNavController(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        NavController findViewNavController = INSTANCE.findViewNavController(view);
        if (findViewNavController != null) {
            return findViewNavController;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }

    public static /* synthetic */ View.OnClickListener createNavigateOnClickListener$default(int i, Bundle bundle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bundle = null;
        }
        return createNavigateOnClickListener(i, bundle);
    }

    @JvmStatic
    public static final View.OnClickListener createNavigateOnClickListener(final int i, final Bundle bundle) {
        return new View.OnClickListener() { // from class: androidx.navigation.-$$Lambda$Navigation$s_bwV9_VikLOnxf2KHwQhOcLT-8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Navigation.m8515createNavigateOnClickListener$lambda0(i, bundle, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createNavigateOnClickListener$lambda-0  reason: not valid java name */
    public static final void m8515createNavigateOnClickListener$lambda0(int i, Bundle bundle, View view) {
        Intrinsics.checkNotNullExpressionValue(view, "view");
        findNavController(view).navigate(i, bundle);
    }

    @JvmStatic
    public static final View.OnClickListener createNavigateOnClickListener(final NavDirections directions) {
        Intrinsics.checkNotNullParameter(directions, "directions");
        return new View.OnClickListener() { // from class: androidx.navigation.-$$Lambda$Navigation$n4vFZf_Sdw82zoIfu80PNoKmKVk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Navigation.m8516createNavigateOnClickListener$lambda1(NavDirections.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createNavigateOnClickListener$lambda-1  reason: not valid java name */
    public static final void m8516createNavigateOnClickListener$lambda1(NavDirections directions, View view) {
        Intrinsics.checkNotNullParameter(directions, "$directions");
        Intrinsics.checkNotNullExpressionValue(view, "view");
        findNavController(view).navigate(directions);
    }

    @JvmStatic
    public static final void setViewNavController(View view, NavController navController) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTag(C0618R.C0619id.nav_controller_view_tag, navController);
    }

    private final NavController findViewNavController(View view) {
        return (NavController) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.generateSequence(view, Navigation$findViewNavController$1.INSTANCE), Navigation$findViewNavController$2.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavController getViewNavController(View view) {
        Object tag = view.getTag(C0618R.C0619id.nav_controller_view_tag);
        if (tag instanceof WeakReference) {
            return (NavController) ((WeakReference) tag).get();
        }
        if (tag instanceof NavController) {
            return (NavController) tag;
        }
        return null;
    }
}
