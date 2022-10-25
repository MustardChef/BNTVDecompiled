package com.lagradost.cloudstream3.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lagradost.cloudstream3.C4761R;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FlowLayout.kt */
@Metadata(m108d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001 B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0011\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J0\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0014J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006!"}, m107d2 = {"Lcom/lagradost/cloudstream3/widget/FlowLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "c", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "itemSpacing", "", "getItemSpacing", "()I", "setItemSpacing", "(I)V", "checkLayoutParams", "", TtmlNode.TAG_P, "Landroid/view/ViewGroup$LayoutParams;", "generateDefaultLayoutParams", "Lcom/lagradost/cloudstream3/widget/FlowLayout$LayoutParams;", "generateLayoutParams", "onLayout", "", "b", "left", ViewHierarchyConstants.DIMENSION_TOP_KEY, TtmlNode.RIGHT, "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "LayoutParams", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class FlowLayout extends ViewGroup {
    public Map<Integer, View> _$_findViewCache;
    private int itemSpacing;

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

    public final int getItemSpacing() {
        return this.itemSpacing;
    }

    public final void setItemSpacing(int i) {
        this.itemSpacing = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLayout(Context context) {
        super(context);
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLayout(Context c, AttributeSet attributeSet) {
        super(c, attributeSet);
        Intrinsics.checkNotNullParameter(c, "c");
        this._$_findViewCache = new LinkedHashMap();
        TypedArray obtainStyledAttributes = c.obtainStyledAttributes(attributeSet, C4761R.styleable.FlowLayout_Layout);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "c.obtainStyledAttributes…leable.FlowLayout_Layout)");
        this.itemSpacing = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i3 < childCount) {
            View child = getChildAt(i3);
            measureChild(child, i, i2);
            int measuredWidth = child.getMeasuredWidth();
            int measuredHeight = child.getMeasuredHeight();
            int i8 = i4 + measuredWidth;
            Intrinsics.checkNotNullExpressionValue(child, "child");
            ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
            if (((i8 - (layoutParams instanceof ViewGroup.MarginLayoutParams ? MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) layoutParams) : 0)) - child.getPaddingEnd()) - this.itemSpacing > size) {
                i5 = Math.max(i5, i4);
                i7 += measuredHeight;
                i4 = 0;
            }
            int i9 = i4 + measuredWidth;
            int i10 = measuredWidth == 0 ? 0 : this.itemSpacing;
            i6 = Math.max(i6, measuredHeight + i7);
            ViewGroup.LayoutParams layoutParams2 = child.getLayoutParams();
            Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type com.lagradost.cloudstream3.widget.FlowLayout.LayoutParams");
            LayoutParams layoutParams3 = (LayoutParams) layoutParams2;
            layoutParams3.setX(i4);
            layoutParams3.setY(i7);
            i3++;
            i4 = i9 + i10;
        }
        setMeasuredDimension(ViewGroup.resolveSize(Math.max(i4, i5), i), ViewGroup.resolveSize(i6, i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type com.lagradost.cloudstream3.widget.FlowLayout.LayoutParams");
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            childAt.layout(layoutParams2.getX(), layoutParams2.getY(), layoutParams2.getX() + childAt.getMeasuredWidth(), layoutParams2.getY() + childAt.getMeasuredHeight());
        }
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new LayoutParams(context, attrs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        Intrinsics.checkNotNullParameter(p, "p");
        return new LayoutParams(p);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        Intrinsics.checkNotNullParameter(p, "p");
        return p instanceof LayoutParams;
    }

    /* compiled from: FlowLayout.kt */
    @Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0019\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nB\u0011\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\fB\u0011\b\u0010\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013¨\u0006\u001a"}, m107d2 = {"Lcom/lagradost/cloudstream3/widget/FlowLayout$LayoutParams;", "Landroid/view/ViewGroup$MarginLayoutParams;", "c", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "(II)V", "source", "(Landroid/view/ViewGroup$MarginLayoutParams;)V", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/ViewGroup$LayoutParams;)V", "spacing", "getSpacing", "()I", "setSpacing", "(I)V", "x", "getX", "setX", "y", "getY", "setY", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class LayoutParams extends ViewGroup.MarginLayoutParams {
        private int spacing;

        /* renamed from: x */
        private int f10038x;

        /* renamed from: y */
        private int f10039y;

        public final int getSpacing() {
            return this.spacing;
        }

        public final void setSpacing(int i) {
            this.spacing = i;
        }

        public final int getX() {
            return this.f10038x;
        }

        public final void setX(int i) {
            this.f10038x = i;
        }

        public final int getY() {
            return this.f10039y;
        }

        public final void setY(int i) {
            this.f10039y = i;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context c, AttributeSet attributeSet) {
            super(c, attributeSet);
            Intrinsics.checkNotNullParameter(c, "c");
            this.spacing = -1;
            TypedArray obtainStyledAttributes = c.obtainStyledAttributes(attributeSet, C4761R.styleable.FlowLayout_Layout);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "c.obtainStyledAttributes…leable.FlowLayout_Layout)");
            this.spacing = 0;
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.spacing = -1;
            this.spacing = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.spacing = -1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.spacing = -1;
        }
    }
}
