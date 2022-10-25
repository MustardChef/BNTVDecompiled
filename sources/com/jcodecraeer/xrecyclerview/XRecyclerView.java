package com.jcodecraeer.xrecyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.google.android.material.appbar.AppBarLayout;
import com.jcodecraeer.xrecyclerview.AppBarStateChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class XRecyclerView extends RecyclerView {
    private static final int HEADER_INIT_INDEX = 10002;
    private static final int TYPE_FOOTER = 10001;
    private static final int TYPE_REFRESH_HEADER = 10000;
    private static List<Integer> sHeaderTypes = new ArrayList();
    private AppBarStateChangeListener.State appbarState;
    private float dragRate;
    private CustomFooterViewCallBack footerViewCallBack;
    private boolean isLoadingData;
    private boolean isNoMore;
    private int limitNumberToCallLoadMore;
    private boolean loadingMoreEnabled;
    private final RecyclerView.AdapterDataObserver mDataObserver;
    private View mEmptyView;
    private View mFootView;
    private ArrayList<View> mHeaderViews;
    private float mLastY;
    private LoadingListener mLoadingListener;
    private int mLoadingMoreProgressStyle;
    private ArrowRefreshHeader mRefreshHeader;
    private int mRefreshProgressStyle;
    private WrapAdapter mWrapAdapter;
    private boolean pullRefreshEnabled;
    private ScrollAlphaChangeListener scrollAlphaChangeListener;
    private int scrollDyCounter;

    /* loaded from: classes3.dex */
    public interface LoadingListener {
        void onLoadMore();

        void onRefresh();
    }

    /* loaded from: classes3.dex */
    public interface ScrollAlphaChangeListener {
        void onAlphaChange(int i);

        int setLimitHeight();
    }

    public XRecyclerView(Context context) {
        this(context, null);
    }

    public XRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isLoadingData = false;
        this.isNoMore = false;
        this.mRefreshProgressStyle = -1;
        this.mLoadingMoreProgressStyle = -1;
        this.mHeaderViews = new ArrayList<>();
        this.mLastY = -1.0f;
        this.dragRate = 3.0f;
        this.pullRefreshEnabled = true;
        this.loadingMoreEnabled = true;
        this.mDataObserver = new DataObserver();
        this.appbarState = AppBarStateChangeListener.State.EXPANDED;
        this.limitNumberToCallLoadMore = 1;
        this.scrollDyCounter = 0;
        init();
    }

    private void init() {
        if (this.pullRefreshEnabled) {
            ArrowRefreshHeader arrowRefreshHeader = new ArrowRefreshHeader(getContext());
            this.mRefreshHeader = arrowRefreshHeader;
            arrowRefreshHeader.setProgressStyle(this.mRefreshProgressStyle);
        }
        LoadingMoreFooter loadingMoreFooter = new LoadingMoreFooter(getContext());
        loadingMoreFooter.setProgressStyle(this.mLoadingMoreProgressStyle);
        this.mFootView = loadingMoreFooter;
        loadingMoreFooter.setVisibility(8);
    }

    public void destroy() {
        ArrayList<View> arrayList = this.mHeaderViews;
        if (arrayList != null) {
            arrayList.clear();
            this.mHeaderViews = null;
        }
        View view = this.mFootView;
        if (view instanceof LoadingMoreFooter) {
            ((LoadingMoreFooter) view).destroy();
            this.mFootView = null;
        }
        ArrowRefreshHeader arrowRefreshHeader = this.mRefreshHeader;
        if (arrowRefreshHeader != null) {
            arrowRefreshHeader.destroy();
            this.mRefreshHeader = null;
        }
    }

    public ArrowRefreshHeader getDefaultRefreshHeaderView() {
        ArrowRefreshHeader arrowRefreshHeader = this.mRefreshHeader;
        if (arrowRefreshHeader == null) {
            return null;
        }
        return arrowRefreshHeader;
    }

    public LoadingMoreFooter getDefaultFootView() {
        View view = this.mFootView;
        if (view != null && (view instanceof LoadingMoreFooter)) {
            return (LoadingMoreFooter) view;
        }
        return null;
    }

    public void setLimitNumberToCallLoadMore(int i) {
        this.limitNumberToCallLoadMore = i;
    }

    public View getFootView() {
        return this.mFootView;
    }

    public void setFootViewText(String str, String str2) {
        View view = this.mFootView;
        if (view instanceof LoadingMoreFooter) {
            ((LoadingMoreFooter) view).setLoadingHint(str);
            ((LoadingMoreFooter) this.mFootView).setNoMoreHint(str2);
        }
    }

    public void addHeaderView(View view) {
        List<Integer> list;
        ArrayList<View> arrayList = this.mHeaderViews;
        if (arrayList == null || (list = sHeaderTypes) == null) {
            return;
        }
        list.add(Integer.valueOf(arrayList.size() + HEADER_INIT_INDEX));
        this.mHeaderViews.add(view);
        WrapAdapter wrapAdapter = this.mWrapAdapter;
        if (wrapAdapter != null) {
            wrapAdapter.notifyDataSetChanged();
        }
    }

    public void removeHeaderView(View view) {
        ArrayList<View> arrayList = this.mHeaderViews;
        if (arrayList == null || sHeaderTypes == null || view == null) {
            return;
        }
        Iterator<View> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            View next = it.next();
            if (next == view) {
                this.mHeaderViews.remove(next);
                break;
            }
        }
        WrapAdapter wrapAdapter = this.mWrapAdapter;
        if (wrapAdapter != null) {
            wrapAdapter.notifyDataSetChanged();
        }
    }

    public void removeAllHeaderView() {
        ArrayList<View> arrayList = this.mHeaderViews;
        if (arrayList == null || sHeaderTypes == null) {
            return;
        }
        arrayList.clear();
        WrapAdapter wrapAdapter = this.mWrapAdapter;
        if (wrapAdapter != null) {
            wrapAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getHeaderViewByType(int i) {
        ArrayList<View> arrayList;
        if (isHeaderType(i) && (arrayList = this.mHeaderViews) != null) {
            return arrayList.get(i - 10002);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHeaderType(int i) {
        ArrayList<View> arrayList = this.mHeaderViews;
        return arrayList != null && sHeaderTypes != null && arrayList.size() > 0 && sHeaderTypes.contains(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isReservedItemViewType(int i) {
        return i == 10000 || i == TYPE_FOOTER || sHeaderTypes.contains(Integer.valueOf(i));
    }

    public void setFootView(View view, CustomFooterViewCallBack customFooterViewCallBack) {
        if (view == null || customFooterViewCallBack == null) {
            return;
        }
        this.mFootView = view;
        this.footerViewCallBack = customFooterViewCallBack;
    }

    public void setRefreshTimeSpKeyName(String str) {
        ArrowRefreshHeader arrowRefreshHeader = this.mRefreshHeader;
        if (arrowRefreshHeader != null) {
            arrowRefreshHeader.setXrRefreshTimeKey(str);
        }
    }

    public void loadMoreComplete() {
        this.isLoadingData = false;
        View view = this.mFootView;
        if (view instanceof LoadingMoreFooter) {
            ((LoadingMoreFooter) view).setState(1);
            return;
        }
        CustomFooterViewCallBack customFooterViewCallBack = this.footerViewCallBack;
        if (customFooterViewCallBack != null) {
            customFooterViewCallBack.onLoadMoreComplete(view);
        }
    }

    public void setNoMore(boolean z) {
        this.isLoadingData = false;
        this.isNoMore = z;
        View view = this.mFootView;
        if (view instanceof LoadingMoreFooter) {
            ((LoadingMoreFooter) view).setState(z ? 2 : 1);
            return;
        }
        CustomFooterViewCallBack customFooterViewCallBack = this.footerViewCallBack;
        if (customFooterViewCallBack != null) {
            customFooterViewCallBack.onSetNoMore(view, z);
        }
    }

    public void refresh() {
        if (!this.pullRefreshEnabled || this.mLoadingListener == null) {
            return;
        }
        this.mRefreshHeader.setState(2);
        this.mLoadingListener.onRefresh();
    }

    public void reset() {
        setNoMore(false);
        loadMoreComplete();
        refreshComplete();
    }

    public void refreshComplete() {
        ArrowRefreshHeader arrowRefreshHeader = this.mRefreshHeader;
        if (arrowRefreshHeader != null) {
            arrowRefreshHeader.refreshComplete();
        }
        setNoMore(false);
    }

    public void setRefreshHeader(ArrowRefreshHeader arrowRefreshHeader) {
        this.mRefreshHeader = arrowRefreshHeader;
    }

    public void setPullRefreshEnabled(boolean z) {
        this.pullRefreshEnabled = z;
    }

    public void setLoadingMoreEnabled(boolean z) {
        this.loadingMoreEnabled = z;
        if (z) {
            return;
        }
        View view = this.mFootView;
        if (view instanceof LoadingMoreFooter) {
            ((LoadingMoreFooter) view).setState(1);
        }
    }

    public void setRefreshProgressStyle(int i) {
        this.mRefreshProgressStyle = i;
        ArrowRefreshHeader arrowRefreshHeader = this.mRefreshHeader;
        if (arrowRefreshHeader != null) {
            arrowRefreshHeader.setProgressStyle(i);
        }
    }

    public void setLoadingMoreProgressStyle(int i) {
        this.mLoadingMoreProgressStyle = i;
        View view = this.mFootView;
        if (view instanceof LoadingMoreFooter) {
            ((LoadingMoreFooter) view).setProgressStyle(i);
        }
    }

    public void setArrowImageView(int i) {
        ArrowRefreshHeader arrowRefreshHeader = this.mRefreshHeader;
        if (arrowRefreshHeader != null) {
            arrowRefreshHeader.setArrowImageView(i);
        }
    }

    public void setDragRate(float f) {
        if (f <= 0.5d) {
            return;
        }
        this.dragRate = f;
    }

    @Deprecated
    public void setEmptyView(View view) {
        this.mEmptyView = view;
        this.mDataObserver.onChanged();
    }

    @Deprecated
    public View getEmptyView() {
        return this.mEmptyView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        WrapAdapter wrapAdapter = new WrapAdapter(adapter);
        this.mWrapAdapter = wrapAdapter;
        super.setAdapter(wrapAdapter);
        adapter.registerAdapterDataObserver(this.mDataObserver);
        this.mDataObserver.onChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public RecyclerView.Adapter getAdapter() {
        WrapAdapter wrapAdapter = this.mWrapAdapter;
        if (wrapAdapter != null) {
            return wrapAdapter.getOriginalAdapter();
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        if (this.mWrapAdapter == null || !(layoutManager instanceof GridLayoutManager)) {
            return;
        }
        final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.jcodecraeer.xrecyclerview.XRecyclerView.1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                if (XRecyclerView.this.mWrapAdapter.isHeader(i) || XRecyclerView.this.mWrapAdapter.isFooter(i) || XRecyclerView.this.mWrapAdapter.isRefreshHeader(i)) {
                    return gridLayoutManager.getSpanCount();
                }
                return 1;
            }
        });
    }

    public <T> void notifyItemRemoved(List<T> list, int i) {
        if (this.mWrapAdapter.adapter == null) {
            return;
        }
        int headers_includingRefreshCount = getHeaders_includingRefreshCount();
        this.mWrapAdapter.adapter.notifyItemRemoved(i + headers_includingRefreshCount);
        this.mWrapAdapter.adapter.notifyItemRangeChanged(headers_includingRefreshCount, list.size(), new Object());
    }

    public <T> void notifyItemInserted(List<T> list, int i) {
        if (this.mWrapAdapter.adapter == null) {
            return;
        }
        int headers_includingRefreshCount = getHeaders_includingRefreshCount();
        this.mWrapAdapter.adapter.notifyItemInserted(i + headers_includingRefreshCount);
        this.mWrapAdapter.adapter.notifyItemRangeChanged(headers_includingRefreshCount, list.size(), new Object());
    }

    public void notifyItemChanged(int i) {
        if (this.mWrapAdapter.adapter == null) {
            return;
        }
        this.mWrapAdapter.adapter.notifyItemChanged(i + getHeaders_includingRefreshCount());
    }

    public void notifyItemChanged(int i, Object obj) {
        if (this.mWrapAdapter.adapter == null) {
            return;
        }
        this.mWrapAdapter.adapter.notifyItemChanged(i + getHeaders_includingRefreshCount(), obj);
    }

    private int getHeaders_includingRefreshCount() {
        WrapAdapter wrapAdapter = this.mWrapAdapter;
        if (wrapAdapter == null) {
            return 0;
        }
        return wrapAdapter.getHeadersCount() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        int findLastVisibleItemPosition;
        super.onScrollStateChanged(i);
        if (i != 0 || this.mLoadingListener == null || this.isLoadingData || !this.loadingMoreEnabled) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            findLastVisibleItemPosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
            staggeredGridLayoutManager.findLastVisibleItemPositions(iArr);
            findLastVisibleItemPosition = findMax(iArr);
        } else {
            findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        int itemCount = layoutManager.getItemCount() + getHeaders_includingRefreshCount();
        ArrowRefreshHeader arrowRefreshHeader = this.mRefreshHeader;
        int state = arrowRefreshHeader != null ? arrowRefreshHeader.getState() : 3;
        if (layoutManager.getChildCount() <= 0 || findLastVisibleItemPosition < itemCount - this.limitNumberToCallLoadMore || itemCount < layoutManager.getChildCount() || this.isNoMore || state >= 2) {
            return;
        }
        this.isLoadingData = true;
        View view = this.mFootView;
        if (view instanceof LoadingMoreFooter) {
            ((LoadingMoreFooter) view).setState(0);
        } else {
            CustomFooterViewCallBack customFooterViewCallBack = this.footerViewCallBack;
            if (customFooterViewCallBack != null) {
                customFooterViewCallBack.onLoadingMore(view);
            }
        }
        this.mLoadingListener.onLoadMore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ArrowRefreshHeader arrowRefreshHeader;
        ArrowRefreshHeader arrowRefreshHeader2;
        LoadingListener loadingListener;
        if (this.mLastY == -1.0f) {
            this.mLastY = motionEvent.getRawY();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mLastY = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = motionEvent.getRawY() - this.mLastY;
            this.mLastY = motionEvent.getRawY();
            if (isOnTop() && this.pullRefreshEnabled && this.appbarState == AppBarStateChangeListener.State.EXPANDED && (arrowRefreshHeader = this.mRefreshHeader) != null) {
                arrowRefreshHeader.onMove(rawY / this.dragRate);
                if (this.mRefreshHeader.getVisibleHeight() > 0 && this.mRefreshHeader.getState() < 2) {
                    return false;
                }
            }
        } else {
            this.mLastY = -1.0f;
            if (isOnTop() && this.pullRefreshEnabled && this.appbarState == AppBarStateChangeListener.State.EXPANDED && (arrowRefreshHeader2 = this.mRefreshHeader) != null && arrowRefreshHeader2.releaseAction() && (loadingListener = this.mLoadingListener) != null) {
                loadingListener.onRefresh();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    private int findMax(int[] iArr) {
        int i = iArr[0];
        for (int i2 : iArr) {
            if (i2 > i) {
                i = i2;
            }
        }
        return i;
    }

    private boolean isOnTop() {
        ArrowRefreshHeader arrowRefreshHeader = this.mRefreshHeader;
        return (arrowRefreshHeader == null || arrowRefreshHeader.getParent() == null) ? false : true;
    }

    /* loaded from: classes3.dex */
    private class DataObserver extends RecyclerView.AdapterDataObserver {
        private DataObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            if (XRecyclerView.this.mWrapAdapter != null) {
                XRecyclerView.this.mWrapAdapter.notifyDataSetChanged();
            }
            if (XRecyclerView.this.mWrapAdapter == null || XRecyclerView.this.mEmptyView == null) {
                return;
            }
            int headersCount = XRecyclerView.this.mWrapAdapter.getHeadersCount() + 1;
            if (XRecyclerView.this.loadingMoreEnabled) {
                headersCount++;
            }
            if (XRecyclerView.this.mWrapAdapter.getItemCount() == headersCount) {
                XRecyclerView.this.mEmptyView.setVisibility(0);
                XRecyclerView.this.setVisibility(8);
                return;
            }
            XRecyclerView.this.mEmptyView.setVisibility(8);
            XRecyclerView.this.setVisibility(0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            XRecyclerView.this.mWrapAdapter.notifyItemRangeInserted(i, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            XRecyclerView.this.mWrapAdapter.notifyItemRangeChanged(i, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            XRecyclerView.this.mWrapAdapter.notifyItemRangeChanged(i, i2, obj);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            XRecyclerView.this.mWrapAdapter.notifyItemRangeRemoved(i, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            XRecyclerView.this.mWrapAdapter.notifyItemMoved(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class WrapAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private RecyclerView.Adapter adapter;

        public boolean isRefreshHeader(int i) {
            return i == 0;
        }

        public WrapAdapter(RecyclerView.Adapter adapter) {
            this.adapter = adapter;
        }

        public RecyclerView.Adapter getOriginalAdapter() {
            return this.adapter;
        }

        public boolean isHeader(int i) {
            return XRecyclerView.this.mHeaderViews != null && i >= 1 && i < XRecyclerView.this.mHeaderViews.size() + 1;
        }

        public boolean isFooter(int i) {
            return XRecyclerView.this.loadingMoreEnabled && i == getItemCount() - 1;
        }

        public int getHeadersCount() {
            if (XRecyclerView.this.mHeaderViews == null) {
                return 0;
            }
            return XRecyclerView.this.mHeaderViews.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i != 10000) {
                if (XRecyclerView.this.isHeaderType(i)) {
                    return new SimpleViewHolder(XRecyclerView.this.getHeaderViewByType(i));
                }
                if (i == XRecyclerView.TYPE_FOOTER) {
                    return new SimpleViewHolder(XRecyclerView.this.mFootView);
                }
                return this.adapter.onCreateViewHolder(viewGroup, i);
            }
            return new SimpleViewHolder(XRecyclerView.this.mRefreshHeader);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (isHeader(i) || isRefreshHeader(i)) {
                return;
            }
            int headersCount = i - (getHeadersCount() + 1);
            RecyclerView.Adapter adapter = this.adapter;
            if (adapter == null || headersCount >= adapter.getItemCount()) {
                return;
            }
            this.adapter.onBindViewHolder(viewHolder, headersCount);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
            if (isHeader(i) || isRefreshHeader(i)) {
                return;
            }
            int headersCount = i - (getHeadersCount() + 1);
            RecyclerView.Adapter adapter = this.adapter;
            if (adapter == null || headersCount >= adapter.getItemCount()) {
                return;
            }
            if (list.isEmpty()) {
                this.adapter.onBindViewHolder(viewHolder, headersCount);
            } else {
                this.adapter.onBindViewHolder(viewHolder, headersCount, list);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int headersCount;
            int i = XRecyclerView.this.loadingMoreEnabled ? 2 : 1;
            if (this.adapter != null) {
                headersCount = getHeadersCount() + this.adapter.getItemCount();
            } else {
                headersCount = getHeadersCount();
            }
            return headersCount + i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            int headersCount = i - (getHeadersCount() + 1);
            if (isRefreshHeader(i)) {
                return 10000;
            }
            if (isHeader(i)) {
                return ((Integer) XRecyclerView.sHeaderTypes.get(i - 1)).intValue();
            } else if (isFooter(i)) {
                return XRecyclerView.TYPE_FOOTER;
            } else {
                RecyclerView.Adapter adapter = this.adapter;
                if (adapter == null || headersCount >= adapter.getItemCount()) {
                    return 0;
                }
                int itemViewType = this.adapter.getItemViewType(headersCount);
                if (XRecyclerView.this.isReservedItemViewType(itemViewType)) {
                    throw new IllegalStateException("XRecyclerView require itemViewType in adapter should be less than 10000 ");
                }
                return itemViewType;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            int headersCount;
            if (this.adapter == null || i < getHeadersCount() + 1 || (headersCount = i - (getHeadersCount() + 1)) >= this.adapter.getItemCount()) {
                return -1L;
            }
            return this.adapter.getItemId(headersCount);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.jcodecraeer.xrecyclerview.XRecyclerView.WrapAdapter.1
                    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                    public int getSpanSize(int i) {
                        if (WrapAdapter.this.isHeader(i) || WrapAdapter.this.isFooter(i) || WrapAdapter.this.isRefreshHeader(i)) {
                            return gridLayoutManager.getSpanCount();
                        }
                        return 1;
                    }
                });
            }
            this.adapter.onAttachedToRecyclerView(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
            this.adapter.onDetachedFromRecyclerView(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            super.onViewAttachedToWindow(viewHolder);
            ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
            if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) && (isHeader(viewHolder.getLayoutPosition()) || isRefreshHeader(viewHolder.getLayoutPosition()) || isFooter(viewHolder.getLayoutPosition()))) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
            }
            this.adapter.onViewAttachedToWindow(viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
            this.adapter.onViewDetachedFromWindow(viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            this.adapter.onViewRecycled(viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
            return this.adapter.onFailedToRecycleView(viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
            this.adapter.unregisterAdapterDataObserver(adapterDataObserver);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
            this.adapter.registerAdapterDataObserver(adapterDataObserver);
        }

        /* loaded from: classes3.dex */
        private class SimpleViewHolder extends RecyclerView.ViewHolder {
            public SimpleViewHolder(View view) {
                super(view);
            }
        }
    }

    public void setLoadingListener(LoadingListener loadingListener) {
        this.mLoadingListener = loadingListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        AppBarLayout appBarLayout;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        while (parent != null && !(parent instanceof CoordinatorLayout)) {
            parent = parent.getParent();
        }
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount() - 1;
            while (true) {
                if (childCount < 0) {
                    appBarLayout = null;
                    break;
                }
                View childAt = coordinatorLayout.getChildAt(childCount);
                if (childAt instanceof AppBarLayout) {
                    appBarLayout = (AppBarLayout) childAt;
                    break;
                }
                childCount--;
            }
            if (appBarLayout != null) {
                appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarStateChangeListener() { // from class: com.jcodecraeer.xrecyclerview.XRecyclerView.2
                    @Override // com.jcodecraeer.xrecyclerview.AppBarStateChangeListener
                    public void onStateChanged(AppBarLayout appBarLayout2, AppBarStateChangeListener.State state) {
                        XRecyclerView.this.appbarState = state;
                    }
                });
            }
        }
    }

    /* loaded from: classes3.dex */
    public class DividerItemDecoration extends RecyclerView.ItemDecoration {
        private Drawable mDivider;
        private int mOrientation;

        public DividerItemDecoration(Drawable drawable) {
            this.mDivider = drawable;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            int i = this.mOrientation;
            if (i == 0) {
                drawHorizontalDividers(canvas, recyclerView);
            } else if (i == 1) {
                drawVerticalDividers(canvas, recyclerView);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            if (recyclerView.getChildAdapterPosition(view) <= XRecyclerView.this.mWrapAdapter.getHeadersCount() + 1) {
                return;
            }
            int orientation = ((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation();
            this.mOrientation = orientation;
            if (orientation == 0) {
                rect.left = this.mDivider.getIntrinsicWidth();
            } else if (orientation == 1) {
                rect.top = this.mDivider.getIntrinsicHeight();
            }
        }

        private void drawHorizontalDividers(Canvas canvas, RecyclerView recyclerView) {
            int paddingTop = recyclerView.getPaddingTop();
            int height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount - 1; i++) {
                View childAt = recyclerView.getChildAt(i);
                int right = childAt.getRight() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).rightMargin;
                this.mDivider.setBounds(right, paddingTop, this.mDivider.getIntrinsicWidth() + right, height);
                this.mDivider.draw(canvas);
            }
        }

        private void drawVerticalDividers(Canvas canvas, RecyclerView recyclerView) {
            int paddingLeft = recyclerView.getPaddingLeft();
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount - 1; i++) {
                View childAt = recyclerView.getChildAt(i);
                int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                this.mDivider.setBounds(paddingLeft, bottom, width, this.mDivider.getIntrinsicHeight() + bottom);
                this.mDivider.draw(canvas);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i) {
        super.scrollToPosition(i);
        if (i == 0) {
            this.scrollDyCounter = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrolled(int i, int i2) {
        super.onScrolled(i, i2);
        ScrollAlphaChangeListener scrollAlphaChangeListener = this.scrollAlphaChangeListener;
        if (scrollAlphaChangeListener == null) {
            return;
        }
        int limitHeight = scrollAlphaChangeListener.setLimitHeight();
        int i3 = this.scrollDyCounter + i2;
        this.scrollDyCounter = i3;
        if (i3 <= 0) {
            this.scrollAlphaChangeListener.onAlphaChange(0);
        } else if (i3 <= limitHeight && i3 > 0) {
            this.scrollAlphaChangeListener.onAlphaChange((int) ((i3 / limitHeight) * 255.0f));
        } else {
            this.scrollAlphaChangeListener.onAlphaChange(255);
        }
    }

    public void setScrollAlphaChangeListener(ScrollAlphaChangeListener scrollAlphaChangeListener) {
        this.scrollAlphaChangeListener = scrollAlphaChangeListener;
    }
}
