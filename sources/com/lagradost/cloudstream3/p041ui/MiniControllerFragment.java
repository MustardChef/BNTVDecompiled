package com.lagradost.cloudstream3.p041ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m108d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/MyMiniControllerFragment;", "Lcom/google/android/gms/cast/framework/media/widget/MiniControllerFragment;", "()V", "currentColor", "", "getCurrentColor", "()I", "setCurrentColor", "(I)V", "onInflate", "", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "bundle", "Landroid/os/Bundle;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "savedInstanceState", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.MyMiniControllerFragment */
/* loaded from: classes.dex */
public final class MiniControllerFragment extends com.google.android.gms.cast.framework.media.widget.MiniControllerFragment {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private int currentColor;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final int getCurrentColor() {
        return this.currentColor;
    }

    public final void setCurrentColor(int i) {
        this.currentColor = i;
    }

    @Override // com.google.android.gms.cast.framework.media.widget.MiniControllerFragment, androidx.fragment.app.Fragment
    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4761R.styleable.CustomCast, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…yleable.CustomCast, 0, 0)");
        if (obtainStyledAttributes.hasValue(0)) {
            this.currentColor = obtainStyledAttributes.getColor(0, 0);
        }
        obtainStyledAttributes.recycle();
        super.onInflate(context, attributeSet, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        try {
            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.container_all);
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.container_current);
            Context context = getContext();
            if (context != null) {
                if (progressBar != null) {
                    progressBar.setBackgroundColor(UIHelper.INSTANCE.adjustAlpha(UIHelper.INSTANCE.colorFromAttribute(context, R.attr.colorPrimary), 0.35f));
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UIHelper.INSTANCE.getToPx(2));
                if (progressBar != null) {
                    progressBar.setLayoutParams(layoutParams);
                }
                int i = this.currentColor;
                if (i != 0 && relativeLayout != null) {
                    relativeLayout.setBackgroundColor(i);
                }
            }
            View childAt = linearLayout != null ? linearLayout.getChildAt(0) : null;
            if (childAt == null) {
                return;
            }
            childAt.setAlpha(0.0f);
        } catch (Exception unused) {
        }
    }
}
