package androidx.activity;

import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m108d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m107d2 = {"Landroidx/activity/Api19Impl;", "", "()V", "isAttachedToWindow", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "activity-ktx_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: androidx.activity.Api19Impl */
/* loaded from: classes.dex */
public final class PipHintTracker {
    public static final PipHintTracker INSTANCE = new PipHintTracker();

    private PipHintTracker() {
    }

    public final boolean isAttachedToWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return view.isAttachedToWindow();
    }
}
