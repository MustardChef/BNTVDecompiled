package com.jcodecraeer.xrecyclerview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blankj.utilcode.util.CacheUtils;
import com.jcodecraeer.xrecyclerview.progressindicator.AVLoadingIndicatorView;
import java.util.Date;

/* loaded from: classes3.dex */
public class ArrowRefreshHeader extends LinearLayout implements BaseRefreshHeader {
    private static final int ROTATE_ANIM_DURATION = 180;
    private static final String XR_REFRESH_KEY = "XR_REFRESH_KEY";
    private static final String XR_REFRESH_TIME_KEY = "XR_REFRESH_TIME_KEY";
    private String customRefreshPsKey;
    private ImageView mArrowImageView;
    private LinearLayout mContainer;
    private LinearLayout mHeaderRefreshTimeContainer;
    private TextView mHeaderTimeView;
    public int mMeasuredHeight;
    private SimpleViewSwitcher mProgressBar;
    private Animation mRotateDownAnim;
    private Animation mRotateUpAnim;
    private int mState;
    private TextView mStatusTextView;
    private AVLoadingIndicatorView progressView;

    public void destroy() {
        this.mProgressBar = null;
        AVLoadingIndicatorView aVLoadingIndicatorView = this.progressView;
        if (aVLoadingIndicatorView != null) {
            aVLoadingIndicatorView.destroy();
            this.progressView = null;
        }
        Animation animation = this.mRotateUpAnim;
        if (animation != null) {
            animation.cancel();
            this.mRotateUpAnim = null;
        }
        Animation animation2 = this.mRotateDownAnim;
        if (animation2 != null) {
            animation2.cancel();
            this.mRotateDownAnim = null;
        }
    }

    public ArrowRefreshHeader(Context context) {
        super(context);
        this.mState = 0;
        this.customRefreshPsKey = null;
        initView();
    }

    public ArrowRefreshHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.customRefreshPsKey = null;
        initView();
    }

    public void setRefreshTimeVisible(boolean z) {
        LinearLayout linearLayout = this.mHeaderRefreshTimeContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(z ? 0 : 8);
        }
    }

    public void setXrRefreshTimeKey(String str) {
        if (str != null) {
            this.customRefreshPsKey = str;
        }
    }

    private void initView() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(C4702R.C4706layout.listview_header, (ViewGroup) null);
        this.mContainer = linearLayout;
        this.mHeaderRefreshTimeContainer = (LinearLayout) linearLayout.findViewById(C4702R.C4705id.header_refresh_time_container);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        setLayoutParams(layoutParams);
        setPadding(0, 0, 0, 0);
        addView(this.mContainer, new LinearLayout.LayoutParams(-1, 0));
        setGravity(80);
        this.mArrowImageView = (ImageView) findViewById(C4702R.C4705id.listview_header_arrow);
        this.mStatusTextView = (TextView) findViewById(C4702R.C4705id.refresh_status_textview);
        this.mProgressBar = (SimpleViewSwitcher) findViewById(C4702R.C4705id.listview_header_progressbar);
        AVLoadingIndicatorView aVLoadingIndicatorView = new AVLoadingIndicatorView(getContext());
        this.progressView = aVLoadingIndicatorView;
        aVLoadingIndicatorView.setIndicatorColor(-4868683);
        this.progressView.setIndicatorId(22);
        SimpleViewSwitcher simpleViewSwitcher = this.mProgressBar;
        if (simpleViewSwitcher != null) {
            simpleViewSwitcher.setView(this.progressView);
        }
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateUpAnim = rotateAnimation;
        rotateAnimation.setDuration(180L);
        this.mRotateUpAnim.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateDownAnim = rotateAnimation2;
        rotateAnimation2.setDuration(180L);
        this.mRotateDownAnim.setFillAfter(true);
        this.mHeaderTimeView = (TextView) findViewById(C4702R.C4705id.last_refresh_time);
        measure(-2, -2);
        this.mMeasuredHeight = getMeasuredHeight();
    }

    public void setProgressStyle(int i) {
        if (i == -1) {
            SimpleViewSwitcher simpleViewSwitcher = this.mProgressBar;
            if (simpleViewSwitcher != null) {
                simpleViewSwitcher.setView(new ProgressBar(getContext(), null, 16842871));
                return;
            }
            return;
        }
        AVLoadingIndicatorView aVLoadingIndicatorView = new AVLoadingIndicatorView(getContext());
        this.progressView = aVLoadingIndicatorView;
        aVLoadingIndicatorView.setIndicatorColor(-4868683);
        this.progressView.setIndicatorId(i);
        this.mProgressBar.setView(this.progressView);
    }

    public void setArrowImageView(int i) {
        this.mArrowImageView.setImageResource(i);
    }

    public void setState(int i) {
        if (i == this.mState) {
            return;
        }
        if (i == 2) {
            this.mArrowImageView.clearAnimation();
            this.mArrowImageView.setVisibility(4);
            SimpleViewSwitcher simpleViewSwitcher = this.mProgressBar;
            if (simpleViewSwitcher != null) {
                simpleViewSwitcher.setVisibility(0);
            }
            smoothScrollTo(this.mMeasuredHeight);
        } else if (i == 3) {
            this.mArrowImageView.setVisibility(4);
            SimpleViewSwitcher simpleViewSwitcher2 = this.mProgressBar;
            if (simpleViewSwitcher2 != null) {
                simpleViewSwitcher2.setVisibility(4);
            }
        } else {
            this.mArrowImageView.setVisibility(0);
            SimpleViewSwitcher simpleViewSwitcher3 = this.mProgressBar;
            if (simpleViewSwitcher3 != null) {
                simpleViewSwitcher3.setVisibility(4);
            }
        }
        this.mHeaderTimeView.setText(friendlyTime(getLastRefreshTime()));
        if (i == 0) {
            if (this.mState == 1) {
                this.mArrowImageView.startAnimation(this.mRotateDownAnim);
            }
            if (this.mState == 2) {
                this.mArrowImageView.clearAnimation();
            }
            this.mStatusTextView.setText(C4702R.string.listview_header_hint_normal);
        } else if (i != 1) {
            if (i == 2) {
                this.mStatusTextView.setText(C4702R.string.refreshing);
            } else if (i == 3) {
                this.mStatusTextView.setText(C4702R.string.refresh_done);
            }
        } else if (this.mState != 1) {
            this.mArrowImageView.clearAnimation();
            this.mArrowImageView.startAnimation(this.mRotateUpAnim);
            this.mStatusTextView.setText(C4702R.string.listview_header_hint_release);
        }
        this.mState = i;
    }

    public int getState() {
        return this.mState;
    }

    private long getLastRefreshTime() {
        String str = this.customRefreshPsKey;
        if (str == null) {
            str = XR_REFRESH_KEY;
        }
        return getContext().getSharedPreferences(str, 32768).getLong(XR_REFRESH_TIME_KEY, new Date().getTime());
    }

    private void saveLastRefreshTime(long j) {
        String str = this.customRefreshPsKey;
        if (str == null) {
            str = XR_REFRESH_KEY;
        }
        getContext().getSharedPreferences(str, 32768).edit().putLong(XR_REFRESH_TIME_KEY, j).commit();
    }

    @Override // com.jcodecraeer.xrecyclerview.BaseRefreshHeader
    public void refreshComplete() {
        this.mHeaderTimeView.setText(friendlyTime(getLastRefreshTime()));
        saveLastRefreshTime(System.currentTimeMillis());
        setState(3);
        new Handler().postDelayed(new Runnable() { // from class: com.jcodecraeer.xrecyclerview.ArrowRefreshHeader.1
            @Override // java.lang.Runnable
            public void run() {
                ArrowRefreshHeader.this.reset();
            }
        }, 200L);
    }

    public void setVisibleHeight(int i) {
        if (i < 0) {
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mContainer.getLayoutParams();
        layoutParams.height = i;
        this.mContainer.setLayoutParams(layoutParams);
    }

    public int getVisibleHeight() {
        return ((LinearLayout.LayoutParams) this.mContainer.getLayoutParams()).height;
    }

    @Override // com.jcodecraeer.xrecyclerview.BaseRefreshHeader
    public void onMove(float f) {
        if (getVisibleHeight() > 0 || f > 0.0f) {
            setVisibleHeight(((int) f) + getVisibleHeight());
            if (this.mState <= 1) {
                if (getVisibleHeight() > this.mMeasuredHeight) {
                    setState(1);
                } else {
                    setState(0);
                }
            }
        }
    }

    @Override // com.jcodecraeer.xrecyclerview.BaseRefreshHeader
    public boolean releaseAction() {
        boolean z;
        getVisibleHeight();
        if (getVisibleHeight() <= this.mMeasuredHeight || this.mState >= 2) {
            z = false;
        } else {
            setState(2);
            z = true;
        }
        if (this.mState != 2) {
            smoothScrollTo(0);
        }
        if (this.mState == 2) {
            smoothScrollTo(this.mMeasuredHeight);
        }
        return z;
    }

    public void reset() {
        smoothScrollTo(0);
        new Handler().postDelayed(new Runnable() { // from class: com.jcodecraeer.xrecyclerview.ArrowRefreshHeader.2
            @Override // java.lang.Runnable
            public void run() {
                ArrowRefreshHeader.this.setState(0);
            }
        }, 500L);
    }

    private void smoothScrollTo(int i) {
        ValueAnimator ofInt = ValueAnimator.ofInt(getVisibleHeight(), i);
        ofInt.setDuration(300L).start();
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.jcodecraeer.xrecyclerview.ArrowRefreshHeader.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ArrowRefreshHeader.this.setVisibleHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.start();
    }

    public static String friendlyTime(Date date) {
        return friendlyTime(date.getTime());
    }

    public static String friendlyTime(long j) {
        int currentTimeMillis = (int) ((System.currentTimeMillis() - j) / 1000);
        if (currentTimeMillis == 0) {
            return "刚刚";
        }
        if (currentTimeMillis > 0 && currentTimeMillis < 60) {
            return currentTimeMillis + "秒前";
        } else if (currentTimeMillis >= 60 && currentTimeMillis < 3600) {
            return Math.max(currentTimeMillis / 60, 1) + "分钟前";
        } else if (currentTimeMillis >= 3600 && currentTimeMillis < 86400) {
            return (currentTimeMillis / CacheUtils.TIME_HOUR) + "小时前";
        } else if (currentTimeMillis >= 86400 && currentTimeMillis < 2592000) {
            int i = currentTimeMillis / CacheUtils.TIME_DAY;
            return i + "天前";
        } else if (currentTimeMillis >= 2592000 && currentTimeMillis < 31104000) {
            return (currentTimeMillis / 2592000) + "月前";
        } else {
            return (currentTimeMillis / 31104000) + "年前";
        }
    }
}
