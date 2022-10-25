package com.jcodecraeer.xrecyclerview;

import android.view.View;

/* loaded from: classes3.dex */
public interface CustomFooterViewCallBack {
    void onLoadMoreComplete(View view);

    void onLoadingMore(View view);

    void onSetNoMore(View view, boolean z);
}
