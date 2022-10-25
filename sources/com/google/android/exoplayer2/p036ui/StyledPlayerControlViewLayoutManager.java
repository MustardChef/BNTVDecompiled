package com.google.android.exoplayer2.p036ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager */
/* loaded from: classes2.dex */
public final class StyledPlayerControlViewLayoutManager {
    private static final long ANIMATION_INTERVAL_MS = 2000;
    private static final long DURATION_FOR_HIDING_ANIMATION_MS = 250;
    private static final long DURATION_FOR_SHOWING_ANIMATION_MS = 250;
    private static final int UX_STATE_ALL_VISIBLE = 0;
    private static final int UX_STATE_ANIMATING_HIDE = 3;
    private static final int UX_STATE_ANIMATING_SHOW = 4;
    private static final int UX_STATE_NONE_VISIBLE = 2;
    private static final int UX_STATE_ONLY_PROGRESS_VISIBLE = 1;
    private final ViewGroup basicControls;
    private final ViewGroup bottomBar;
    private final ViewGroup centerControls;
    private final View controlsBackground;
    private final ViewGroup extraControls;
    private final ViewGroup extraControlsScrollView;
    private final AnimatorSet hideAllBarsAnimator;
    private final AnimatorSet hideMainBarAnimator;
    private final AnimatorSet hideProgressBarAnimator;
    private boolean isMinimalMode;
    private final ViewGroup minimalControls;
    private boolean needToShowBars;
    private final ValueAnimator overflowHideAnimator;
    private final ValueAnimator overflowShowAnimator;
    private final View overflowShowButton;
    private final AnimatorSet showAllBarsAnimator;
    private final AnimatorSet showMainBarAnimator;
    private final StyledPlayerControlView styledPlayerControlView;
    private final View timeBar;
    private final ViewGroup timeView;
    private final Runnable showAllBarsRunnable = new Runnable() { // from class: com.google.android.exoplayer2.ui.-$$Lambda$StyledPlayerControlViewLayoutManager$vJBNlG93jz_b-Seh008BUkzw9D4
        @Override // java.lang.Runnable
        public final void run() {
            StyledPlayerControlViewLayoutManager.this.showAllBars();
        }
    };
    private final Runnable hideAllBarsRunnable = new Runnable() { // from class: com.google.android.exoplayer2.ui.-$$Lambda$StyledPlayerControlViewLayoutManager$Uyxy2Z5tryCJnBj0GA3SSrWvvRI
        @Override // java.lang.Runnable
        public final void run() {
            StyledPlayerControlViewLayoutManager.this.hideAllBars();
        }
    };
    private final Runnable hideProgressBarRunnable = new Runnable() { // from class: com.google.android.exoplayer2.ui.-$$Lambda$StyledPlayerControlViewLayoutManager$akKKMYLY_2Y8Uy3G__gXPajPJw4
        @Override // java.lang.Runnable
        public final void run() {
            StyledPlayerControlViewLayoutManager.this.hideProgressBar();
        }
    };
    private final Runnable hideMainBarRunnable = new Runnable() { // from class: com.google.android.exoplayer2.ui.-$$Lambda$StyledPlayerControlViewLayoutManager$mZy_nJWmidRaMg4VLdhkc5z6g28
        @Override // java.lang.Runnable
        public final void run() {
            StyledPlayerControlViewLayoutManager.this.hideMainBar();
        }
    };
    private final Runnable hideControllerRunnable = new Runnable() { // from class: com.google.android.exoplayer2.ui.-$$Lambda$StyledPlayerControlViewLayoutManager$VKNe7w6AWMvw7j806Pu7FvZ8CcU
        @Override // java.lang.Runnable
        public final void run() {
            StyledPlayerControlViewLayoutManager.this.hideController();
        }
    };
    private final View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.google.android.exoplayer2.ui.-$$Lambda$StyledPlayerControlViewLayoutManager$Vs5assiPBGhh1Xvnalr4DNIJOIQ
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            StyledPlayerControlViewLayoutManager.this.onLayoutChange(view, i, i2, i3, i4, i5, i6, i7, i8);
        }
    };
    private boolean animationEnabled = true;
    private int uxState = 0;
    private final List<View> shownButtons = new ArrayList();

    public StyledPlayerControlViewLayoutManager(final StyledPlayerControlView styledPlayerControlView) {
        this.styledPlayerControlView = styledPlayerControlView;
        this.controlsBackground = styledPlayerControlView.findViewById(C3559R.C3562id.exo_controls_background);
        this.centerControls = (ViewGroup) styledPlayerControlView.findViewById(C3559R.C3562id.exo_center_controls);
        this.minimalControls = (ViewGroup) styledPlayerControlView.findViewById(C3559R.C3562id.exo_minimal_controls);
        ViewGroup viewGroup = (ViewGroup) styledPlayerControlView.findViewById(C3559R.C3562id.exo_bottom_bar);
        this.bottomBar = viewGroup;
        this.timeView = (ViewGroup) styledPlayerControlView.findViewById(C3559R.C3562id.exo_time);
        View findViewById = styledPlayerControlView.findViewById(C3559R.C3562id.exo_progress);
        this.timeBar = findViewById;
        this.basicControls = (ViewGroup) styledPlayerControlView.findViewById(C3559R.C3562id.exo_basic_controls);
        this.extraControls = (ViewGroup) styledPlayerControlView.findViewById(C3559R.C3562id.exo_extra_controls);
        this.extraControlsScrollView = (ViewGroup) styledPlayerControlView.findViewById(C3559R.C3562id.exo_extra_controls_scroll_view);
        View findViewById2 = styledPlayerControlView.findViewById(C3559R.C3562id.exo_overflow_show);
        this.overflowShowButton = findViewById2;
        View findViewById3 = styledPlayerControlView.findViewById(C3559R.C3562id.exo_overflow_hide);
        if (findViewById2 != null && findViewById3 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.-$$Lambda$StyledPlayerControlViewLayoutManager$cowlG_ChsG0MJipiWwZoUTotDpE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StyledPlayerControlViewLayoutManager.this.onOverflowButtonClick(view);
                }
            });
            findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.-$$Lambda$StyledPlayerControlViewLayoutManager$cowlG_ChsG0MJipiWwZoUTotDpE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StyledPlayerControlViewLayoutManager.this.onOverflowButtonClick(view);
                }
            });
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.-$$Lambda$StyledPlayerControlViewLayoutManager$Z0c6J0eVTE_HygSVCukZ8eh1z4Y
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                StyledPlayerControlViewLayoutManager.this.lambda$new$0$StyledPlayerControlViewLayoutManager(valueAnimator);
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (!(StyledPlayerControlViewLayoutManager.this.timeBar instanceof DefaultTimeBar) || StyledPlayerControlViewLayoutManager.this.isMinimalMode) {
                    return;
                }
                ((DefaultTimeBar) StyledPlayerControlViewLayoutManager.this.timeBar).hideScrubber(250L);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (StyledPlayerControlViewLayoutManager.this.controlsBackground != null) {
                    StyledPlayerControlViewLayoutManager.this.controlsBackground.setVisibility(4);
                }
                if (StyledPlayerControlViewLayoutManager.this.centerControls != null) {
                    StyledPlayerControlViewLayoutManager.this.centerControls.setVisibility(4);
                }
                if (StyledPlayerControlViewLayoutManager.this.minimalControls != null) {
                    StyledPlayerControlViewLayoutManager.this.minimalControls.setVisibility(4);
                }
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.-$$Lambda$StyledPlayerControlViewLayoutManager$M0SOemxfC91i1PxYVH9CZAMN-T0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                StyledPlayerControlViewLayoutManager.this.lambda$new$1$StyledPlayerControlViewLayoutManager(valueAnimator);
            }
        });
        ofFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (StyledPlayerControlViewLayoutManager.this.controlsBackground != null) {
                    StyledPlayerControlViewLayoutManager.this.controlsBackground.setVisibility(0);
                }
                if (StyledPlayerControlViewLayoutManager.this.centerControls != null) {
                    StyledPlayerControlViewLayoutManager.this.centerControls.setVisibility(0);
                }
                if (StyledPlayerControlViewLayoutManager.this.minimalControls != null) {
                    StyledPlayerControlViewLayoutManager.this.minimalControls.setVisibility(StyledPlayerControlViewLayoutManager.this.isMinimalMode ? 0 : 4);
                }
                if (!(StyledPlayerControlViewLayoutManager.this.timeBar instanceof DefaultTimeBar) || StyledPlayerControlViewLayoutManager.this.isMinimalMode) {
                    return;
                }
                ((DefaultTimeBar) StyledPlayerControlViewLayoutManager.this.timeBar).showScrubber(250L);
            }
        });
        Resources resources = styledPlayerControlView.getResources();
        float dimension = resources.getDimension(C3559R.dimen.exo_styled_bottom_bar_height) - resources.getDimension(C3559R.dimen.exo_styled_progress_bar_height);
        float dimension2 = resources.getDimension(C3559R.dimen.exo_styled_bottom_bar_height);
        AnimatorSet animatorSet = new AnimatorSet();
        this.hideMainBarAnimator = animatorSet;
        animatorSet.setDuration(250L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.setUxState(3);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.setUxState(1);
                if (StyledPlayerControlViewLayoutManager.this.needToShowBars) {
                    styledPlayerControlView.post(StyledPlayerControlViewLayoutManager.this.showAllBarsRunnable);
                    StyledPlayerControlViewLayoutManager.this.needToShowBars = false;
                }
            }
        });
        animatorSet.play(ofFloat).with(ofTranslationY(0.0f, dimension, findViewById)).with(ofTranslationY(0.0f, dimension, viewGroup));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.hideProgressBarAnimator = animatorSet2;
        animatorSet2.setDuration(250L);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.setUxState(3);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.setUxState(2);
                if (StyledPlayerControlViewLayoutManager.this.needToShowBars) {
                    styledPlayerControlView.post(StyledPlayerControlViewLayoutManager.this.showAllBarsRunnable);
                    StyledPlayerControlViewLayoutManager.this.needToShowBars = false;
                }
            }
        });
        animatorSet2.play(ofTranslationY(dimension, dimension2, findViewById)).with(ofTranslationY(dimension, dimension2, viewGroup));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.hideAllBarsAnimator = animatorSet3;
        animatorSet3.setDuration(250L);
        animatorSet3.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.setUxState(3);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.setUxState(2);
                if (StyledPlayerControlViewLayoutManager.this.needToShowBars) {
                    styledPlayerControlView.post(StyledPlayerControlViewLayoutManager.this.showAllBarsRunnable);
                    StyledPlayerControlViewLayoutManager.this.needToShowBars = false;
                }
            }
        });
        animatorSet3.play(ofFloat).with(ofTranslationY(0.0f, dimension2, findViewById)).with(ofTranslationY(0.0f, dimension2, viewGroup));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.showMainBarAnimator = animatorSet4;
        animatorSet4.setDuration(250L);
        animatorSet4.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.setUxState(4);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.setUxState(0);
            }
        });
        animatorSet4.play(ofFloat2).with(ofTranslationY(dimension, 0.0f, findViewById)).with(ofTranslationY(dimension, 0.0f, viewGroup));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.showAllBarsAnimator = animatorSet5;
        animatorSet5.setDuration(250L);
        animatorSet5.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.setUxState(4);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.setUxState(0);
            }
        });
        animatorSet5.play(ofFloat2).with(ofTranslationY(dimension2, 0.0f, findViewById)).with(ofTranslationY(dimension2, 0.0f, viewGroup));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.overflowShowAnimator = ofFloat3;
        ofFloat3.setDuration(250L);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.-$$Lambda$StyledPlayerControlViewLayoutManager$bLNGlFgEeAM8s00dnj4oM6Y1JCg
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                StyledPlayerControlViewLayoutManager.this.lambda$new$2$StyledPlayerControlViewLayoutManager(valueAnimator);
            }
        });
        ofFloat3.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (StyledPlayerControlViewLayoutManager.this.extraControlsScrollView != null) {
                    StyledPlayerControlViewLayoutManager.this.extraControlsScrollView.setVisibility(0);
                    StyledPlayerControlViewLayoutManager.this.extraControlsScrollView.setTranslationX(StyledPlayerControlViewLayoutManager.this.extraControlsScrollView.getWidth());
                    StyledPlayerControlViewLayoutManager.this.extraControlsScrollView.scrollTo(StyledPlayerControlViewLayoutManager.this.extraControlsScrollView.getWidth(), 0);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (StyledPlayerControlViewLayoutManager.this.basicControls != null) {
                    StyledPlayerControlViewLayoutManager.this.basicControls.setVisibility(4);
                }
            }
        });
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.overflowHideAnimator = ofFloat4;
        ofFloat4.setDuration(250L);
        ofFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.-$$Lambda$StyledPlayerControlViewLayoutManager$w16R9T047Gf8_1zeIhVq75pS9uY
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                StyledPlayerControlViewLayoutManager.this.lambda$new$3$StyledPlayerControlViewLayoutManager(valueAnimator);
            }
        });
        ofFloat4.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (StyledPlayerControlViewLayoutManager.this.basicControls != null) {
                    StyledPlayerControlViewLayoutManager.this.basicControls.setVisibility(0);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (StyledPlayerControlViewLayoutManager.this.extraControlsScrollView != null) {
                    StyledPlayerControlViewLayoutManager.this.extraControlsScrollView.setVisibility(4);
                }
            }
        });
    }

    public /* synthetic */ void lambda$new$0$StyledPlayerControlViewLayoutManager(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.controlsBackground;
        if (view != null) {
            view.setAlpha(floatValue);
        }
        ViewGroup viewGroup = this.centerControls;
        if (viewGroup != null) {
            viewGroup.setAlpha(floatValue);
        }
        ViewGroup viewGroup2 = this.minimalControls;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(floatValue);
        }
    }

    public /* synthetic */ void lambda$new$1$StyledPlayerControlViewLayoutManager(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.controlsBackground;
        if (view != null) {
            view.setAlpha(floatValue);
        }
        ViewGroup viewGroup = this.centerControls;
        if (viewGroup != null) {
            viewGroup.setAlpha(floatValue);
        }
        ViewGroup viewGroup2 = this.minimalControls;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(floatValue);
        }
    }

    public /* synthetic */ void lambda$new$2$StyledPlayerControlViewLayoutManager(ValueAnimator valueAnimator) {
        animateOverflow(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public /* synthetic */ void lambda$new$3$StyledPlayerControlViewLayoutManager(ValueAnimator valueAnimator) {
        animateOverflow(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public void show() {
        if (!this.styledPlayerControlView.isVisible()) {
            this.styledPlayerControlView.setVisibility(0);
            this.styledPlayerControlView.updateAll();
            this.styledPlayerControlView.requestPlayPauseFocus();
        }
        showAllBars();
    }

    public void hide() {
        int i = this.uxState;
        if (i == 3 || i == 2) {
            return;
        }
        removeHideCallbacks();
        if (!this.animationEnabled) {
            hideController();
        } else if (this.uxState == 1) {
            hideProgressBar();
        } else {
            hideAllBars();
        }
    }

    public void hideImmediately() {
        int i = this.uxState;
        if (i == 3 || i == 2) {
            return;
        }
        removeHideCallbacks();
        hideController();
    }

    public void setAnimationEnabled(boolean z) {
        this.animationEnabled = z;
    }

    public boolean isAnimationEnabled() {
        return this.animationEnabled;
    }

    public void resetHideCallbacks() {
        if (this.uxState == 3) {
            return;
        }
        removeHideCallbacks();
        int showTimeoutMs = this.styledPlayerControlView.getShowTimeoutMs();
        if (showTimeoutMs > 0) {
            if (!this.animationEnabled) {
                postDelayedRunnable(this.hideControllerRunnable, showTimeoutMs);
            } else if (this.uxState == 1) {
                postDelayedRunnable(this.hideProgressBarRunnable, 2000L);
            } else {
                postDelayedRunnable(this.hideMainBarRunnable, showTimeoutMs);
            }
        }
    }

    public void removeHideCallbacks() {
        this.styledPlayerControlView.removeCallbacks(this.hideControllerRunnable);
        this.styledPlayerControlView.removeCallbacks(this.hideAllBarsRunnable);
        this.styledPlayerControlView.removeCallbacks(this.hideMainBarRunnable);
        this.styledPlayerControlView.removeCallbacks(this.hideProgressBarRunnable);
    }

    public void onAttachedToWindow() {
        this.styledPlayerControlView.addOnLayoutChangeListener(this.onLayoutChangeListener);
    }

    public void onDetachedFromWindow() {
        this.styledPlayerControlView.removeOnLayoutChangeListener(this.onLayoutChangeListener);
    }

    public boolean isFullyVisible() {
        return this.uxState == 0 && this.styledPlayerControlView.isVisible();
    }

    public void setShowButton(View view, boolean z) {
        if (view == null) {
            return;
        }
        if (!z) {
            view.setVisibility(8);
            this.shownButtons.remove(view);
            return;
        }
        if (this.isMinimalMode && shouldHideInMinimalMode(view)) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
        this.shownButtons.add(view);
    }

    public boolean getShowButton(View view) {
        return view != null && this.shownButtons.contains(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUxState(int i) {
        int i2 = this.uxState;
        this.uxState = i;
        if (i == 2) {
            this.styledPlayerControlView.setVisibility(8);
        } else if (i2 == 2) {
            this.styledPlayerControlView.setVisibility(0);
        }
        if (i2 != i) {
            this.styledPlayerControlView.notifyOnVisibilityChange();
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view = this.controlsBackground;
        if (view != null) {
            view.layout(0, 0, i3 - i, i4 - i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        boolean useMinimalMode = useMinimalMode();
        if (this.isMinimalMode != useMinimalMode) {
            this.isMinimalMode = useMinimalMode;
            view.post(new Runnable() { // from class: com.google.android.exoplayer2.ui.-$$Lambda$StyledPlayerControlViewLayoutManager$0VsVklQz4qFTXkhePiUPYh2Z8k4
                @Override // java.lang.Runnable
                public final void run() {
                    StyledPlayerControlViewLayoutManager.this.updateLayoutForSizeChange();
                }
            });
        }
        boolean z = i3 - i != i7 - i5;
        if (this.isMinimalMode || !z) {
            return;
        }
        view.post(new Runnable() { // from class: com.google.android.exoplayer2.ui.-$$Lambda$StyledPlayerControlViewLayoutManager$CnpNsEg4DfUNVCHU5L7Emt1LsvY
            @Override // java.lang.Runnable
            public final void run() {
                StyledPlayerControlViewLayoutManager.this.onLayoutWidthChanged();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOverflowButtonClick(View view) {
        resetHideCallbacks();
        if (view.getId() == C3559R.C3562id.exo_overflow_show) {
            this.overflowShowAnimator.start();
        } else if (view.getId() == C3559R.C3562id.exo_overflow_hide) {
            this.overflowHideAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAllBars() {
        if (!this.animationEnabled) {
            setUxState(0);
            resetHideCallbacks();
            return;
        }
        int i = this.uxState;
        if (i == 1) {
            this.showMainBarAnimator.start();
        } else if (i == 2) {
            this.showAllBarsAnimator.start();
        } else if (i == 3) {
            this.needToShowBars = true;
        } else if (i == 4) {
            return;
        }
        resetHideCallbacks();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideAllBars() {
        this.hideAllBarsAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgressBar() {
        this.hideProgressBarAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideMainBar() {
        this.hideMainBarAnimator.start();
        postDelayedRunnable(this.hideProgressBarRunnable, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideController() {
        setUxState(2);
    }

    private static ObjectAnimator ofTranslationY(float f, float f2, View view) {
        return ObjectAnimator.ofFloat(view, "translationY", f, f2);
    }

    private void postDelayedRunnable(Runnable runnable, long j) {
        if (j >= 0) {
            this.styledPlayerControlView.postDelayed(runnable, j);
        }
    }

    private void animateOverflow(float f) {
        ViewGroup viewGroup = this.extraControlsScrollView;
        if (viewGroup != null) {
            this.extraControlsScrollView.setTranslationX((int) (viewGroup.getWidth() * (1.0f - f)));
        }
        ViewGroup viewGroup2 = this.timeView;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f);
        }
        ViewGroup viewGroup3 = this.basicControls;
        if (viewGroup3 != null) {
            viewGroup3.setAlpha(1.0f - f);
        }
    }

    private boolean useMinimalMode() {
        int width = (this.styledPlayerControlView.getWidth() - this.styledPlayerControlView.getPaddingLeft()) - this.styledPlayerControlView.getPaddingRight();
        int height = (this.styledPlayerControlView.getHeight() - this.styledPlayerControlView.getPaddingBottom()) - this.styledPlayerControlView.getPaddingTop();
        int widthWithMargins = getWidthWithMargins(this.centerControls);
        ViewGroup viewGroup = this.centerControls;
        int paddingLeft = widthWithMargins - (viewGroup != null ? viewGroup.getPaddingLeft() + this.centerControls.getPaddingRight() : 0);
        int heightWithMargins = getHeightWithMargins(this.centerControls);
        ViewGroup viewGroup2 = this.centerControls;
        return width <= Math.max(paddingLeft, getWidthWithMargins(this.timeView) + getWidthWithMargins(this.overflowShowButton)) || height <= (heightWithMargins - (viewGroup2 != null ? viewGroup2.getPaddingTop() + this.centerControls.getPaddingBottom() : 0)) + (getHeightWithMargins(this.bottomBar) * 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayoutForSizeChange() {
        ViewGroup viewGroup = this.minimalControls;
        if (viewGroup != null) {
            viewGroup.setVisibility(this.isMinimalMode ? 0 : 4);
        }
        View view = this.timeBar;
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.styledPlayerControlView.getResources().getDimensionPixelSize(C3559R.dimen.exo_styled_progress_margin_bottom);
            if (this.isMinimalMode) {
                dimensionPixelSize = 0;
            }
            marginLayoutParams.bottomMargin = dimensionPixelSize;
            this.timeBar.setLayoutParams(marginLayoutParams);
            View view2 = this.timeBar;
            if (view2 instanceof DefaultTimeBar) {
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view2;
                if (this.isMinimalMode) {
                    defaultTimeBar.hideScrubber(true);
                } else {
                    int i = this.uxState;
                    if (i == 1) {
                        defaultTimeBar.hideScrubber(false);
                    } else if (i != 3) {
                        defaultTimeBar.showScrubber();
                    }
                }
            }
        }
        for (View view3 : this.shownButtons) {
            view3.setVisibility((this.isMinimalMode && shouldHideInMinimalMode(view3)) ? 4 : 0);
        }
    }

    private boolean shouldHideInMinimalMode(View view) {
        int id = view.getId();
        return id == C3559R.C3562id.exo_bottom_bar || id == C3559R.C3562id.exo_prev || id == C3559R.C3562id.exo_next || id == C3559R.C3562id.exo_rew || id == C3559R.C3562id.exo_rew_with_amount || id == C3559R.C3562id.exo_ffwd || id == C3559R.C3562id.exo_ffwd_with_amount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLayoutWidthChanged() {
        int i;
        if (this.basicControls == null || this.extraControls == null) {
            return;
        }
        int width = (this.styledPlayerControlView.getWidth() - this.styledPlayerControlView.getPaddingLeft()) - this.styledPlayerControlView.getPaddingRight();
        while (true) {
            if (this.extraControls.getChildCount() <= 1) {
                break;
            }
            int childCount = this.extraControls.getChildCount() - 2;
            View childAt = this.extraControls.getChildAt(childCount);
            this.extraControls.removeViewAt(childCount);
            this.basicControls.addView(childAt, 0);
        }
        View view = this.overflowShowButton;
        if (view != null) {
            view.setVisibility(8);
        }
        int widthWithMargins = getWidthWithMargins(this.timeView);
        int childCount2 = this.basicControls.getChildCount() - 1;
        for (int i2 = 0; i2 < childCount2; i2++) {
            widthWithMargins += getWidthWithMargins(this.basicControls.getChildAt(i2));
        }
        if (widthWithMargins > width) {
            View view2 = this.overflowShowButton;
            if (view2 != null) {
                view2.setVisibility(0);
                widthWithMargins += getWidthWithMargins(this.overflowShowButton);
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < childCount2; i3++) {
                View childAt2 = this.basicControls.getChildAt(i3);
                widthWithMargins -= getWidthWithMargins(childAt2);
                arrayList.add(childAt2);
                if (widthWithMargins <= width) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.basicControls.removeViews(0, arrayList.size());
            for (i = 0; i < arrayList.size(); i++) {
                this.extraControls.addView((View) arrayList.get(i), this.extraControls.getChildCount() - 1);
            }
            return;
        }
        ViewGroup viewGroup = this.extraControlsScrollView;
        if (viewGroup == null || viewGroup.getVisibility() != 0 || this.overflowHideAnimator.isStarted()) {
            return;
        }
        this.overflowShowAnimator.cancel();
        this.overflowHideAnimator.start();
    }

    private static int getWidthWithMargins(View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            return width + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        }
        return width;
    }

    private static int getHeightWithMargins(View view) {
        if (view == null) {
            return 0;
        }
        int height = view.getHeight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            return height + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        return height;
    }
}
