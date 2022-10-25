package com.lagradost.cloudstream3.p041ui.result;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bongngotv2.R;
import com.discord.panels.PanelsChildGestureRegionObserver;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer;
import com.lagradost.cloudstream3.p041ui.player.SubtitleData;
import com.lagradost.cloudstream3.utils.IOnBackPressed;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResultTrailerPlayer.kt */
@Metadata(m108d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\b\u0016\u0018\u0000 52\u00020\u00012\u00020\u00022\u00020\u0003:\u00015B\u0005¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0016J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\b\u0010 \u001a\u00020\u0006H\u0016J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#H\u0016J\u0016\u0010$\u001a\u00020\u00182\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u001aH\u0016J\u001a\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001c\u0010,\u001a\u00020\u00182\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u001c\u0010.\u001a\u00020\u00182\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002000\u0011H\u0016J\b\u00101\u001a\u00020\u0018H\u0016J\b\u00102\u001a\u00020\u0018H\u0016J\u0010\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u0006H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\u00020\u0006X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u00066"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/result/ResultTrailerPlayer;", "Lcom/lagradost/cloudstream3/ui/player/FullScreenPlayer;", "Lcom/discord/panels/PanelsChildGestureRegionObserver$GestureRegionsListener;", "Lcom/lagradost/cloudstream3/utils/IOnBackPressed;", "()V", "hasPipModeSupport", "", "getHasPipModeSupport", "()Z", "setHasPipModeSupport", "(Z)V", "isFullScreenPlayer", "setFullScreenPlayer", "lockRotation", "getLockRotation", "setLockRotation", "playerWidthHeight", "Lkotlin/Pair;", "", "getPlayerWidthHeight", "()Lkotlin/Pair;", "setPlayerWidthHeight", "(Lkotlin/Pair;)V", "embeddedSubtitlesFetched", "", "subtitles", "", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "exitedPipMode", "fixPlayerSize", "nextEpisode", "nextMirror", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onGestureRegionsUpdate", "gestureRegions", "Landroid/graphics/Rect;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "playerDimensionsLoaded", "widthHeight", "playerPositionChanged", "posDur", "", "prevEpisode", "subtitlesChanged", "updateFullscreen", "fullscreen", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultTrailerPlayer */
/* loaded from: classes4.dex */
public class ResultTrailerPlayer extends FullScreenPlayer implements PanelsChildGestureRegionObserver.GestureRegionsListener, IOnBackPressed {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "RESULT_TRAILER";
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private boolean hasPipModeSupport;
    private boolean isFullScreenPlayer;
    private boolean lockRotation;
    private Tuples<Integer, Integer> playerWidthHeight;

    @Override // com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer, com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer, com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
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

    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
    public void embeddedSubtitlesFetched(List<SubtitleData> subtitles) {
        Intrinsics.checkNotNullParameter(subtitles, "subtitles");
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer, com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
    public void exitedPipMode() {
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
    public void nextEpisode() {
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
    public void nextMirror() {
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer, com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onGestureRegionsUpdate(List<Rect> gestureRegions) {
        Intrinsics.checkNotNullParameter(gestureRegions, "gestureRegions");
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
    public void playerPositionChanged(Tuples<Long, Long> posDur) {
        Intrinsics.checkNotNullParameter(posDur, "posDur");
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
    public void prevEpisode() {
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer, com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
    public void subtitlesChanged() {
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer
    protected boolean getLockRotation() {
        return this.lockRotation;
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer
    protected void setLockRotation(boolean z) {
        this.lockRotation = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer
    public boolean isFullScreenPlayer() {
        return this.isFullScreenPlayer;
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer
    protected void setFullScreenPlayer(boolean z) {
        this.isFullScreenPlayer = z;
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
    protected boolean getHasPipModeSupport() {
        return this.hasPipModeSupport;
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
    protected void setHasPipModeSupport(boolean z) {
        this.hasPipModeSupport = z;
    }

    /* compiled from: ResultTrailerPlayer.kt */
    @Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/result/ResultTrailerPlayer$Companion;", "", "()V", "TAG", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.ResultTrailerPlayer$Companion */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final Tuples<Integer, Integer> getPlayerWidthHeight() {
        return this.playerWidthHeight;
    }

    public final void setPlayerWidthHeight(Tuples<Integer, Integer> tuples) {
        this.playerWidthHeight = tuples;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        uiReset();
        fixPlayerSize();
    }

    private final void fixPlayerSize() {
        Resources resources;
        Configuration configuration;
        int screenHeight;
        Tuples<Integer, Integer> tuples = this.playerWidthHeight;
        if (tuples != null) {
            int intValue = tuples.component1().intValue();
            int intValue2 = tuples.component2().intValue();
            Context context = getContext();
            if (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null) {
                return;
            }
            if (configuration.orientation == 2) {
                screenHeight = getScreenWidth();
            } else {
                screenHeight = getScreenHeight();
            }
            ShimmerFrameLayout result_trailer_loading = (ShimmerFrameLayout) _$_findCachedViewById(C4761R.C4764id.result_trailer_loading);
            if (result_trailer_loading != null) {
                Intrinsics.checkNotNullExpressionValue(result_trailer_loading, "result_trailer_loading");
                result_trailer_loading.setVisibility(8);
            }
            ConstraintLayout player_background = (ConstraintLayout) _$_findCachedViewById(C4761R.C4764id.player_background);
            if (player_background != null) {
                Intrinsics.checkNotNullExpressionValue(player_background, "player_background");
                player_background.setVisibility(0);
                player_background.setLayoutParams(new FrameLayout.LayoutParams(-1, isFullScreenPlayer() ? -1 : (screenHeight * intValue2) / intValue));
            }
        }
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
    public void playerDimensionsLoaded(Tuples<Integer, Integer> widthHeight) {
        Intrinsics.checkNotNullParameter(widthHeight, "widthHeight");
        this.playerWidthHeight = widthHeight;
        fixPlayerSize();
    }

    private final void updateFullscreen(boolean z) {
        setFullScreenPlayer(z);
        setLockRotation(z);
        ImageView imageView = (ImageView) _$_findCachedViewById(C4761R.C4764id.player_fullscreen);
        if (imageView != null) {
            imageView.setImageResource(z ? R.drawable.baseline_fullscreen_exit_24 : R.drawable.baseline_fullscreen_24);
        }
        uiReset();
        if (z) {
            enterFullscreen();
            FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.result_top_bar);
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            FrameLayout frameLayout2 = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.result_fullscreen_holder);
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            FrameLayout frameLayout3 = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.result_main_holder);
            if (frameLayout3 != null) {
                frameLayout3.setVisibility(8);
            }
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C4761R.C4764id.player_background);
            if (constraintLayout != null) {
                ViewGroup viewGroup = (ViewGroup) constraintLayout.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(constraintLayout);
                }
                FrameLayout frameLayout4 = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.result_fullscreen_holder);
                if (frameLayout4 != null) {
                    frameLayout4.addView(constraintLayout);
                }
            }
        } else {
            FrameLayout frameLayout5 = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.result_top_bar);
            if (frameLayout5 != null) {
                frameLayout5.setVisibility(0);
            }
            FrameLayout frameLayout6 = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.result_fullscreen_holder);
            if (frameLayout6 != null) {
                frameLayout6.setVisibility(8);
            }
            FrameLayout frameLayout7 = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.result_main_holder);
            if (frameLayout7 != null) {
                frameLayout7.setVisibility(0);
            }
            ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(C4761R.C4764id.player_background);
            if (constraintLayout2 != null) {
                ViewGroup viewGroup2 = (ViewGroup) constraintLayout2.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(constraintLayout2);
                }
                FrameLayout frameLayout8 = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.result_smallscreen_holder);
                if (frameLayout8 != null) {
                    frameLayout8.addView(constraintLayout2);
                }
            }
            exitFullscreen();
        }
        fixPlayerSize();
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer, com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ImageView imageView = (ImageView) _$_findCachedViewById(C4761R.C4764id.player_fullscreen);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$ResultTrailerPlayer$DL8qyoDoYwpQycoF2T-FKREnD6I
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ResultTrailerPlayer.m8865onViewCreated$lambda4(ResultTrailerPlayer.this, view2);
                }
            });
        }
        updateFullscreen(isFullScreenPlayer());
        uiReset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-4  reason: not valid java name */
    public static final void m8865onViewCreated$lambda4(ResultTrailerPlayer this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateFullscreen(!this$0.isFullScreenPlayer());
    }

    @Override // com.lagradost.cloudstream3.utils.IOnBackPressed
    public boolean onBackPressed() {
        if (isFullScreenPlayer()) {
            updateFullscreen(false);
            return false;
        }
        return true;
    }
}
