package androidx.navigation.p007ui;

import androidx.navigation.NavController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, m107d2 = {"setupWithNavController", "", "Lcom/google/android/material/navigation/NavigationView;", "navController", "Landroidx/navigation/NavController;", "navigation-ui_release"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: androidx.navigation.ui.NavigationViewKt */
/* loaded from: classes.dex */
public final class NavigationView {
    public static final void setupWithNavController(com.google.android.material.navigation.NavigationView navigationView, NavController navController) {
        Intrinsics.checkNotNullParameter(navigationView, "<this>");
        Intrinsics.checkNotNullParameter(navController, "navController");
        NavigationUI.setupWithNavController(navigationView, navController);
    }
}
