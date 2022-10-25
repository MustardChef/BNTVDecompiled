package com.lagradost.cloudstream3.p041ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.lagradost.cloudstream3.widget.BetterRecyclerView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AutofitRecyclerView.kt */
@Metadata(m108d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR$\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/AutofitRecyclerView;", "Lcom/lagradost/cloudstream3/widget/BetterRecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "columnWidth", "", "enableLoadmore", "", "getEnableLoadmore", "()Z", "setEnableLoadmore", "(Z)V", "itemWidth", "getItemWidth", "()I", "manager", "Lcom/lagradost/cloudstream3/ui/GrdLayoutManager;", "noMore", "getNoMore", "setNoMore", "value", "spanCount", "getSpanCount", "setSpanCount", "(I)V", "loadMoreComplete", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.AutofitRecyclerView */
/* loaded from: classes.dex */
public final class AutofitRecyclerView extends BetterRecyclerView {
    public Map<Integer, View> _$_findViewCache;
    private int columnWidth;
    private boolean enableLoadmore;
    private final GrdLayoutManager manager;
    private boolean noMore;
    private int spanCount;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AutofitRecyclerView(Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    public final void loadMoreComplete() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutofitRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        GrdLayoutManager grdLayoutManager = new GrdLayoutManager(context, 2);
        this.manager = grdLayoutManager;
        this.columnWidth = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843031});
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttributes(attrs, attrsArray)");
            this.columnWidth = obtainStyledAttributes.getDimensionPixelSize(0, -1);
            obtainStyledAttributes.recycle();
        }
        setLayoutManager(grdLayoutManager);
        grdLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.lagradost.cloudstream3.ui.AutofitRecyclerView.1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                RecyclerView.Adapter adapter = AutofitRecyclerView.this.getAdapter();
                boolean z = false;
                if (adapter != null && adapter.getItemCount() == i + 1) {
                    z = true;
                }
                if (z && AutofitRecyclerView.this.getEnableLoadmore()) {
                    return AutofitRecyclerView.this.manager.getSpanCount();
                }
                return 1;
            }
        });
    }

    public /* synthetic */ AutofitRecyclerView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final boolean getEnableLoadmore() {
        return this.enableLoadmore;
    }

    public final void setEnableLoadmore(boolean z) {
        this.enableLoadmore = z;
    }

    public final boolean getNoMore() {
        return this.noMore;
    }

    public final void setNoMore(boolean z) {
        this.noMore = z;
    }

    public final int getSpanCount() {
        return this.spanCount;
    }

    public final void setSpanCount(int i) {
        this.spanCount = i;
        if (i > 0) {
            this.manager.setSpanCount(i);
        }
    }

    public final int getItemWidth() {
        return getMeasuredWidth() / this.manager.getSpanCount();
    }
}
