package androidx.navigation.fragment;

import androidx.navigation.NavController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m107d2 = {"findNavController", "Landroidx/navigation/NavController;", "Landroidx/fragment/app/Fragment;", "navigation-fragment_release"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: androidx.navigation.fragment.FragmentKt */
/* loaded from: classes.dex */
public final class Fragment {
    public static final NavController findNavController(androidx.fragment.app.Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        return NavHostFragment.Companion.findNavController(fragment);
    }
}
