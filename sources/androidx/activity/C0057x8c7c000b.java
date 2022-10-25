package androidx.activity;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ViewTreeOnBackPressedDispatcherOwner.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "Landroidx/activity/OnBackPressedDispatcherOwner;", "it", "Landroid/view/View;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: androidx.activity.ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2 */
/* loaded from: classes.dex */
final class C0057x8c7c000b extends Lambda implements Function1<View, OnBackPressedDispatcherOwner> {
    public static final C0057x8c7c000b INSTANCE = new C0057x8c7c000b();

    C0057x8c7c000b() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final OnBackPressedDispatcherOwner invoke(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object tag = it.getTag(C0054R.C0055id.view_tree_on_back_pressed_dispatcher_owner);
        if (tag instanceof OnBackPressedDispatcherOwner) {
            return (OnBackPressedDispatcherOwner) tag;
        }
        return null;
    }
}
