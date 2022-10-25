package com.jcodecraeer.xrecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import java.util.Objects;

/* loaded from: classes3.dex */
public class StickyScrollLinearLayout extends LinearLayout implements NestedScrollingParent {
    private static final String TAG = "StickyScrollLayout";
    private RecyclerView.LayoutManager layoutManager;
    private View mContentView;
    private OverScroller mScroller;
    private View mTabView;
    private View mTopView;
    private int mTopViewHeight;
    private VelocityTracker mVelocityTracker;
    private int targetFirstVisiblePosition;

    /* loaded from: classes3.dex */
    public interface StickyScrollInitInterface {
        View setContentView();

        View setTabView();

        View setTopView();
    }

    public StickyScrollLinearLayout(Context context) {
        super(context);
        this.layoutManager = null;
        this.targetFirstVisiblePosition = 1;
        init(context);
    }

    public StickyScrollLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.layoutManager = null;
        this.targetFirstVisiblePosition = 1;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        this.mScroller = new OverScroller(context);
    }

    public void setInitInterface(StickyScrollInitInterface stickyScrollInitInterface) {
        Objects.requireNonNull(stickyScrollInitInterface, "initInterface can not be null!");
        View topView = stickyScrollInitInterface.setTopView();
        this.mTopView = topView;
        if (topView != null) {
            getTopViewHeight();
        }
        this.mTabView = stickyScrollInitInterface.setTabView();
        View contentView = stickyScrollInitInterface.setContentView();
        this.mContentView = contentView;
        if (contentView == null) {
            return;
        }
        setTotalHeight();
        requestLayout();
    }

    public View getContentView() {
        return this.mContentView;
    }

    public void setTargetFirstVisiblePosition(int i) {
        this.targetFirstVisiblePosition = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        Log.e(TAG, "onStartNestedScroll " + view.toString() + "  " + view2.toString());
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        Log.e(TAG, "onNestedScrollAccepted");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        Log.e(TAG, "onStopNestedScroll " + view.toString());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        Log.e(TAG, "onNestedScroll " + i2 + InternalFrame.f9677ID + i4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int findFirstCompletelyVisibleItemPosition;
        if (!(view instanceof XRecyclerView)) {
            throw new UnsupportedOperationException("insert your content must is XRecyclerView!");
        }
        RecyclerView.LayoutManager layoutManager = ((RecyclerView) view).getLayoutManager();
        this.layoutManager = layoutManager;
        if (layoutManager instanceof GridLayoutManager) {
            findFirstCompletelyVisibleItemPosition = ((GridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            int[] iArr2 = new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()];
            ((StaggeredGridLayoutManager) this.layoutManager).findFirstCompletelyVisibleItemPositions(iArr2);
            findFirstCompletelyVisibleItemPosition = iArr2[0];
        } else {
            findFirstCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        }
        if (findFirstCompletelyVisibleItemPosition < 0) {
            return;
        }
        int scrollY = getScrollY();
        boolean z = i2 > 0 && scrollY < this.mTopViewHeight;
        Log.e(TAG, "mTopViewHeight == " + this.mTopViewHeight + "\ndy == " + i2 + "\nscrollY == " + scrollY + "\nhiddenTop && showTop " + z);
        if (!z) {
            z = i2 < 0 && scrollY >= 0 && (!ViewCompat.canScrollVertically(view, -1) || findFirstCompletelyVisibleItemPosition == this.targetFirstVisiblePosition);
            Log.e(TAG, "mTopViewHeight == " + this.mTopViewHeight + "\ndy == " + i2 + "\nscrollY == " + scrollY + "\nfirstVisiblePosition " + findFirstCompletelyVisibleItemPosition);
        }
        if (z) {
            scrollBy(0, i2);
            iArr[1] = i2;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        Log.e(TAG, "onNestedFling");
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        Log.e(TAG, "onNestedPreFling");
        if (getScrollY() >= this.mTopViewHeight) {
            return false;
        }
        fling((int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        Log.e(TAG, "getNestedScrollAxes");
        return 0;
    }

    @Deprecated
    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    public void destroy() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mTabView == null || this.mTopView == null || this.mContentView == null) {
            return;
        }
        setTotalHeight();
    }

    private void setTotalHeight() {
        this.mContentView.getLayoutParams().height = getMeasuredHeight() - this.mTabView.getMeasuredHeight();
        setMeasuredDimension(getMeasuredWidth(), this.mTopView.getMeasuredHeight() + this.mTabView.getMeasuredHeight() + this.mContentView.getMeasuredHeight());
    }

    private void getTopViewHeight() {
        View view = this.mTopView;
        if (view == null) {
            return;
        }
        this.mTopViewHeight = view.getMeasuredHeight();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        getTopViewHeight();
    }

    public void fling(int i) {
        this.mScroller.fling(0, getScrollY(), 0, i, 0, 0, 0, this.mTopViewHeight);
        invalidate();
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        int i3 = this.mTopViewHeight;
        if (i2 > i3) {
            i2 = i3;
        }
        if (i2 != getScrollY()) {
            super.scrollTo(i, i2);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(0, this.mScroller.getCurrY());
            invalidate();
        }
    }
}
