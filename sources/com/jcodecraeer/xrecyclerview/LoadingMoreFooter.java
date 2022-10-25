package com.jcodecraeer.xrecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.jcodecraeer.xrecyclerview.progressindicator.AVLoadingIndicatorView;

/* loaded from: classes3.dex */
public class LoadingMoreFooter extends LinearLayout {
    public static final int STATE_COMPLETE = 1;
    public static final int STATE_LOADING = 0;
    public static final int STATE_NOMORE = 2;
    private String loadingDoneHint;
    private String loadingHint;
    private TextView mText;
    private String noMoreHint;
    private SimpleViewSwitcher progressCon;
    private AVLoadingIndicatorView progressView;

    public LoadingMoreFooter(Context context) {
        super(context);
        initView();
    }

    public LoadingMoreFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public void destroy() {
        this.progressCon = null;
        AVLoadingIndicatorView aVLoadingIndicatorView = this.progressView;
        if (aVLoadingIndicatorView != null) {
            aVLoadingIndicatorView.destroy();
            this.progressView = null;
        }
    }

    public void setLoadingHint(String str) {
        this.loadingHint = str;
    }

    public void setNoMoreHint(String str) {
        this.noMoreHint = str;
    }

    public void setLoadingDoneHint(String str) {
        this.loadingDoneHint = str;
    }

    public void initView() {
        setGravity(17);
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        SimpleViewSwitcher simpleViewSwitcher = new SimpleViewSwitcher(getContext());
        this.progressCon = simpleViewSwitcher;
        simpleViewSwitcher.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        AVLoadingIndicatorView aVLoadingIndicatorView = new AVLoadingIndicatorView(getContext());
        this.progressView = aVLoadingIndicatorView;
        aVLoadingIndicatorView.setIndicatorColor(-4868683);
        this.progressView.setIndicatorId(22);
        this.progressCon.setView(this.progressView);
        addView(this.progressCon);
        TextView textView = new TextView(getContext());
        this.mText = textView;
        textView.setText(getContext().getString(C4702R.string.listview_loading));
        String str = this.loadingHint;
        if (str == null || str.equals("")) {
            this.loadingHint = (String) getContext().getText(C4702R.string.listview_loading);
        }
        String str2 = this.noMoreHint;
        if (str2 == null || str2.equals("")) {
            this.noMoreHint = (String) getContext().getText(C4702R.string.nomore_loading);
        }
        String str3 = this.loadingDoneHint;
        if (str3 == null || str3.equals("")) {
            this.loadingDoneHint = (String) getContext().getText(C4702R.string.loading_done);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins((int) getResources().getDimension(C4702R.dimen.textandiconmargin), 0, 0, 0);
        this.mText.setLayoutParams(layoutParams);
        addView(this.mText);
    }

    public void setProgressStyle(int i) {
        if (i == -1) {
            this.progressCon.setView(new ProgressBar(getContext(), null, 16842871));
            return;
        }
        AVLoadingIndicatorView aVLoadingIndicatorView = new AVLoadingIndicatorView(getContext());
        this.progressView = aVLoadingIndicatorView;
        aVLoadingIndicatorView.setIndicatorColor(-4868683);
        this.progressView.setIndicatorId(i);
        this.progressCon.setView(this.progressView);
    }

    public void setState(int i) {
        if (i == 0) {
            this.progressCon.setVisibility(0);
            this.mText.setText(this.loadingHint);
            setVisibility(0);
        } else if (i == 1) {
            this.mText.setText(this.loadingDoneHint);
            setVisibility(8);
        } else if (i != 2) {
        } else {
            this.mText.setText(this.noMoreHint);
            this.progressCon.setVisibility(8);
            setVisibility(0);
        }
    }
}
