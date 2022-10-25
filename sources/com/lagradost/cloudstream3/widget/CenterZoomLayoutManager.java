package com.lagradost.cloudstream3.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CenterZoomLayoutManager.kt */
@Metadata(m108d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B+\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nB!\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u0011J$\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\n\u0010\u001f\u001a\u00060 R\u00020!2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\"\u001a\u00020\u00112\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00110\u0010J+\u0010$\u001a\u00020\u00112\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00072\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\u00112\b\b\u0002\u0010(\u001a\u00020\rR\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u001c\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, m107d2 = {"Lcom/lagradost/cloudstream3/widget/CenterZoomLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;)V", "orientation", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "itemListener", "Lkotlin/Function1;", "", "lastViewIndex", "Ljava/lang/Integer;", "mShrinkAmount", "", "mShrinkDistance", "snapChild", "waitForSnap", "onLayoutCompleted", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/recyclerview/widget/RecyclerView$State;", "removeOnSizeListener", "scrollHorizontallyBy", "dx", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "setOnSizeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "snap", "callback", "(Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "updateSize", "forceUpdate", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class CenterZoomLayoutManager extends LinearLayoutManager {
    private Function1<? super Integer, Unit> itemListener;
    private Integer lastViewIndex;
    private final float mShrinkAmount;
    private final float mShrinkDistance;
    private Integer snapChild;
    private Function1<? super Integer, Unit> waitForSnap;

    public CenterZoomLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mShrinkAmount = 0.15f;
        this.mShrinkDistance = 0.9f;
    }

    public CenterZoomLayoutManager(Context context) {
        super(context);
        this.mShrinkAmount = 0.15f;
        this.mShrinkDistance = 0.9f;
    }

    public CenterZoomLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
        this.mShrinkAmount = 0.15f;
        this.mShrinkDistance = 0.9f;
    }

    public static /* synthetic */ void updateSize$default(CenterZoomLayoutManager centerZoomLayoutManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        centerZoomLayoutManager.updateSize(z);
    }

    public final void updateSize(boolean z) {
        float f;
        Exception e;
        Integer num;
        float width = getWidth() / 2.0f;
        float f2 = this.mShrinkDistance * width;
        float f3 = 1.0f - this.mShrinkAmount;
        int childCount = getChildCount();
        Integer num2 = null;
        float f4 = 0.0f;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                try {
                    f = (((f3 - 1.0f) * (Math.min(f2, Math.abs(width - ((getDecoratedRight(childAt) + getDecoratedLeft(childAt)) / 2.0f))) - 0.0f)) / (f2 - 0.0f)) + 1.0f;
                    childAt.setScaleX(f);
                    childAt.setScaleY(f);
                } catch (Exception e2) {
                    f = f4;
                    e = e2;
                }
                if (f > f4 && (num = (Integer) childAt.getTag()) != null) {
                    try {
                        num2 = Integer.valueOf(num.intValue());
                    } catch (Exception e3) {
                        e = e3;
                        ArchComponentExt.logError(e);
                        f4 = f;
                    }
                    f4 = f;
                }
            }
        }
        if (num2 != null) {
            int intValue = num2.intValue();
            Integer num3 = this.lastViewIndex;
            if (num3 == null || num3.intValue() != intValue || z) {
                this.lastViewIndex = Integer.valueOf(intValue);
                Function1<? super Integer, Unit> function1 = this.itemListener;
                if (function1 != null) {
                    function1.invoke(Integer.valueOf(intValue));
                }
            }
        }
    }

    public final void setOnSizeListener(Function1<? super Integer, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.lastViewIndex = null;
        this.itemListener = listener;
    }

    public final void removeOnSizeListener() {
        this.itemListener = null;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        int[] calculateDistanceToFinalSnap;
        super.onLayoutCompleted(state);
        if (this.waitForSnap != null) {
            Integer num = this.snapChild;
            View childAt = getChildAt(num != null ? num.intValue() : 1);
            if (childAt != null && (calculateDistanceToFinalSnap = new LinearSnapHelper().calculateDistanceToFinalSnap(this, childAt)) != null) {
                int i = calculateDistanceToFinalSnap[0];
                Function1<? super Integer, Unit> function1 = this.waitForSnap;
                if (function1 != null) {
                    function1.invoke(Integer.valueOf(i));
                }
                this.waitForSnap = null;
            }
        }
        updateSize$default(this, false, 1, null);
    }

    public static /* synthetic */ void snap$default(CenterZoomLayoutManager centerZoomLayoutManager, Integer num, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        centerZoomLayoutManager.snap(num, function1);
    }

    public final void snap(Integer num, Function1<? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.waitForSnap = callback;
        this.snapChild = num;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        if (getOrientation() == 0) {
            int scrollHorizontallyBy = super.scrollHorizontallyBy(i, recycler, state);
            updateSize$default(this, false, 1, null);
            return scrollHorizontallyBy;
        }
        return 0;
    }
}
