package androidx.navigation.fragment;

import android.view.View;
import androidx.navigation.fragment.FragmentNavigator;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m108d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003\"\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m107d2 = {"FragmentNavigatorExtras", "Landroidx/navigation/fragment/FragmentNavigator$Extras;", "sharedElements", "", "Lkotlin/Pair;", "Landroid/view/View;", "", "([Lkotlin/Pair;)Landroidx/navigation/fragment/FragmentNavigator$Extras;", "navigation-fragment_release"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: androidx.navigation.fragment.FragmentNavigatorExtrasKt */
/* loaded from: classes.dex */
public final class FragmentNavigatorExtras {
    public static final FragmentNavigator.Extras FragmentNavigatorExtras(Tuples<? extends View, String>... sharedElements) {
        Intrinsics.checkNotNullParameter(sharedElements, "sharedElements");
        FragmentNavigator.Extras.Builder builder = new FragmentNavigator.Extras.Builder();
        for (Tuples<? extends View, String> tuples : sharedElements) {
            builder.addSharedElement(tuples.component1(), tuples.component2());
        }
        return builder.build();
    }
}
