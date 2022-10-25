package com.lagradost.cloudstream3.p041ui.player;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.PreferenceManager;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.p036ui.DefaultTimeBar;
import com.google.android.exoplayer2.p036ui.SubtitleView;
import com.google.android.material.button.MaterialButton;
import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.p041ui.subtitles.SaveCaptionStyle;
import com.lagradost.cloudstream3.utils.DataStore;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.cloudstream3.utils.SingleSelectionHelper;
import com.lagradost.cloudstream3.utils.UIHelper;
import com.lagradost.cloudstream3.utils.Vector2;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Standard;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FullScreenPlayer.kt */
@Metadata(m108d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b3\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0016\u0018\u0000 \u008b\u00012\u00020\u0001:\u0004\u008b\u0001\u008c\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010T\u001a\u00020UH\u0004J\b\u0010V\u001a\u00020UH\u0004J-\u0010W\u001a\u0004\u0018\u00010\u000b2\b\u0010X\u001a\u0004\u0018\u00010\u000b2\b\u0010Y\u001a\u0004\u0018\u00010\u00172\b\u0010Z\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010[J\b\u0010\\\u001a\u00020UH\u0004J\b\u0010]\u001a\u00020UH\u0004J\b\u0010^\u001a\u00020UH\u0016J\b\u0010_\u001a\u00020UH\u0002J\u000f\u0010`\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010aJ\u0018\u0010b\u001a\u00020!2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020!H\u0002J\u001c\u0010f\u001a\u00020!2\b\u0010g\u001a\u0004\u0018\u00010h2\b\u0010c\u001a\u0004\u0018\u00010iH\u0003J\u0018\u0010j\u001a\u00020!2\u0006\u0010k\u001a\u00020\u00122\u0006\u0010l\u001a\u00020\u0012H\u0002J\b\u0010m\u001a\u00020UH\u0002J\b\u0010n\u001a\u00020UH\u0016J\b\u0010o\u001a\u00020UH\u0016J\u001a\u0010p\u001a\u00020U2\u0006\u0010g\u001a\u00020h2\b\u0010q\u001a\u0004\u0018\u00010rH\u0017J-\u0010s\u001a\u00020U2\u0006\u0010t\u001a\u00020u2\b\u0010v\u001a\u0004\u0018\u00010\u000b2\f\u0010w\u001a\b\u0012\u0004\u0012\u00020U0xH\u0016¢\u0006\u0002\u0010yJ\u0006\u0010z\u001a\u00020UJ\u0006\u0010{\u001a\u00020UJ\b\u0010|\u001a\u00020UH\u0002J\u0010\u0010}\u001a\u00020U2\u0006\u0010~\u001a\u00020\u0012H\u0002J\u0011\u0010\u007f\u001a\u00020U2\u0007\u0010\u0080\u0001\u001a\u00020\u0012H\u0002J\t\u0010\u0081\u0001\u001a\u00020UH\u0016J\t\u0010\u0082\u0001\u001a\u00020UH\u0002J\t\u0010\u0083\u0001\u001a\u00020UH\u0002J\t\u0010\u0084\u0001\u001a\u00020UH\u0002J\t\u0010\u0085\u0001\u001a\u00020UH\u0016J\t\u0010\u0086\u0001\u001a\u00020UH\u0002J\t\u0010\u0087\u0001\u001a\u00020UH\u0002J\t\u0010\u0088\u0001\u001a\u00020UH\u0004J\t\u0010\u0089\u0001\u001a\u00020UH\u0002J\t\u0010\u008a\u0001\u001a\u00020UH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001dX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020!X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001a\u0010)\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020!X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020!X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%R\u001a\u00102\u001a\u00020!X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010#\"\u0004\b3\u0010%R\u001a\u00104\u001a\u00020!X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010#\"\u0004\b5\u0010%R\u001a\u00106\u001a\u00020!X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010#\"\u0004\b8\u0010%R\u0012\u00109\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010:R\u001a\u0010;\u001a\u00020!X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010#\"\u0004\b=\u0010%R\u001a\u0010>\u001a\u00020!X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010#\"\u0004\b@\u0010%R\u0014\u0010A\u001a\u00020\u00058DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u000eR\u0014\u0010C\u001a\u00020\u00058DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bD\u0010\u000eR\u0012\u0010E\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010:R$\u0010G\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020\u000b8D@DX\u0084\u000e¢\u0006\f\u001a\u0004\bH\u0010+\"\u0004\bI\u0010-R\u001a\u0010J\u001a\u00020!X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010#\"\u0004\bL\u0010%R\u001a\u0010M\u001a\u00020!X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010#\"\u0004\bO\u0010%R\u001a\u0010P\u001a\u00020!X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010#\"\u0004\bR\u0010%R\u0014\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u008d\u0001"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/FullScreenPlayer;", "Lcom/lagradost/cloudstream3/ui/player/AbstractPlayerFragment;", "()V", "brightnessIcons", "", "", "currentClickCount", "currentDoubleTapIndex", "currentLastTouchAction", "Lcom/lagradost/cloudstream3/ui/player/FullScreenPlayer$TouchAction;", "currentLastTouchEndTime", "", "currentPrefQuality", "getCurrentPrefQuality", "()I", "setCurrentPrefQuality", "(I)V", "currentRequestedBrightness", "", "currentRequestedVolume", "currentTapIndex", "currentTouchAction", "currentTouchLast", "Lcom/lagradost/cloudstream3/utils/Vector2;", "currentTouchStart", "currentTouchStartPlayerTime", "Ljava/lang/Long;", "currentTouchStartTime", "displayMetrics", "Landroid/util/DisplayMetrics;", "getDisplayMetrics", "()Landroid/util/DisplayMetrics;", "doubleTapEnabled", "", "getDoubleTapEnabled", "()Z", "setDoubleTapEnabled", "(Z)V", "doubleTapPauseEnabled", "getDoubleTapPauseEnabled", "setDoubleTapPauseEnabled", "fastForwardTime", "getFastForwardTime", "()J", "setFastForwardTime", "(J)V", "fullscreenNotch", "isCurrentTouchValid", "isFullScreenPlayer", "setFullScreenPlayer", "isLocked", "setLocked", "isShowing", "setShowing", "lockRotation", "getLockRotation", "setLockRotation", "navigationBarHeight", "Ljava/lang/Integer;", "playBackSpeedEnabled", "getPlayBackSpeedEnabled", "setPlayBackSpeedEnabled", "playerResizeEnabled", "getPlayerResizeEnabled", "setPlayerResizeEnabled", "screenHeight", "getScreenHeight", "screenWidth", "getScreenWidth", "statusBarHeight", "value", "subtitleDelay", "getSubtitleDelay", "setSubtitleDelay", "swipeHorizontalEnabled", "getSwipeHorizontalEnabled", "setSwipeHorizontalEnabled", "swipeVerticalEnabled", "getSwipeVerticalEnabled", "setSwipeVerticalEnabled", "useTrueSystemBrightness", "getUseTrueSystemBrightness", "setUseTrueSystemBrightness", "volumeIcons", "animateLayoutChanges", "", "autoHide", "calculateNewTime", "startTime", "touchStart", "touchEnd", "(Ljava/lang/Long;Lcom/lagradost/cloudstream3/utils/Vector2;Lcom/lagradost/cloudstream3/utils/Vector2;)Ljava/lang/Long;", "enterFullscreen", "exitFullscreen", "exitedPipMode", "fastForward", "getBrightness", "()Ljava/lang/Float;", "handleKeyEvent", "event", "Landroid/view/KeyEvent;", "hasNavigated", "handleMotionEvent", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "Landroid/view/MotionEvent;", "isValidTouch", "rawX", "rawY", "onClickChange", "onDestroy", "onResume", "onViewCreated", "savedInstanceState", "Landroid/os/Bundle;", "openOnlineSubPicker", "context", "Landroid/content/Context;", "imdbId", "dismissCallback", "Lkotlin/Function0;", "(Landroid/content/Context;Ljava/lang/Long;Lkotlin/jvm/functions/Function0;)V", "resetFastForwardText", "resetRewindText", "rewind", "setBrightness", "brightness", "setPlayBackSpeed", "speed", "showMirrorsDialogue", "showSpeedDialog", "showSubtitleOffsetDialog", "skipOp", "subtitlesChanged", "toggleLock", "toggleShowDelayed", "uiReset", "updateLockUI", "updateUIVisibility", "Companion", "TouchAction", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.FullScreenPlayer */
/* loaded from: classes3.dex */
public class FullScreenPlayer extends AbstractPlayerFragment {
    public static final Companion Companion = new Companion(null);
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final List<Integer> brightnessIcons;
    private int currentClickCount;
    private int currentDoubleTapIndex;
    private TouchAction currentLastTouchAction;
    private long currentLastTouchEndTime;
    private int currentPrefQuality;
    private float currentRequestedBrightness;
    private float currentRequestedVolume;
    private int currentTapIndex;
    private TouchAction currentTouchAction;
    private Vector2 currentTouchLast;
    private Vector2 currentTouchStart;
    private Long currentTouchStartPlayerTime;
    private Long currentTouchStartTime;
    private final DisplayMetrics displayMetrics;
    private boolean doubleTapEnabled;
    private boolean doubleTapPauseEnabled;
    private long fastForwardTime;
    private final boolean fullscreenNotch;
    private boolean isCurrentTouchValid;
    private boolean isFullScreenPlayer;
    private boolean isLocked;
    private boolean isShowing;
    private boolean lockRotation;
    private Integer navigationBarHeight;
    private boolean playBackSpeedEnabled;
    private boolean playerResizeEnabled;
    private Integer statusBarHeight;
    private boolean swipeHorizontalEnabled;
    private boolean swipeVerticalEnabled;
    private boolean useTrueSystemBrightness;
    private final List<Integer> volumeIcons;

    /* compiled from: FullScreenPlayer.kt */
    @Metadata(m108d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/FullScreenPlayer$TouchAction;", "", "(Ljava/lang/String;I)V", "Brightness", "Volume", "Time", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.player.FullScreenPlayer$TouchAction */
    /* loaded from: classes3.dex */
    public enum TouchAction {
        Brightness,
        Volume,
        Time
    }

    /* compiled from: FullScreenPlayer.kt */
    @Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.player.FullScreenPlayer$WhenMappings */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TouchAction.values().length];
            iArr[TouchAction.Time.ordinal()] = 1;
            iArr[TouchAction.Brightness.ordinal()] = 2;
            iArr[TouchAction.Volume.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
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

    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public FullScreenPlayer() {
        super(null, 1, null);
        this.lockRotation = true;
        this.isFullScreenPlayer = true;
        this.currentPrefQuality = Qualities.P2160.getValue();
        this.fastForwardTime = 10000L;
        this.doubleTapPauseEnabled = true;
        this.useTrueSystemBrightness = true;
        this.fullscreenNotch = true;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "getSystem().displayMetrics");
        this.displayMetrics = displayMetrics;
        this.brightnessIcons = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf((int) R.drawable.sun_1), Integer.valueOf((int) R.drawable.sun_2), Integer.valueOf((int) R.drawable.sun_3), Integer.valueOf((int) R.drawable.sun_4), Integer.valueOf((int) R.drawable.sun_5), Integer.valueOf((int) R.drawable.sun_6)});
        this.volumeIcons = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf((int) R.drawable.ic_baseline_volume_mute_24), Integer.valueOf((int) R.drawable.ic_baseline_volume_down_24), Integer.valueOf((int) R.drawable.ic_baseline_volume_up_24)});
        this.currentRequestedBrightness = 1.0f;
    }

    protected boolean getLockRotation() {
        return this.lockRotation;
    }

    protected void setLockRotation(boolean z) {
        this.lockRotation = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isFullScreenPlayer() {
        return this.isFullScreenPlayer;
    }

    protected void setFullScreenPlayer(boolean z) {
        this.isFullScreenPlayer = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isShowing() {
        return this.isShowing;
    }

    protected final void setShowing(boolean z) {
        this.isShowing = z;
    }

    protected final boolean isLocked() {
        return this.isLocked;
    }

    protected final void setLocked(boolean z) {
        this.isLocked = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getCurrentPrefQuality() {
        return this.currentPrefQuality;
    }

    protected final void setCurrentPrefQuality(int i) {
        this.currentPrefQuality = i;
    }

    protected final long getFastForwardTime() {
        return this.fastForwardTime;
    }

    protected final void setFastForwardTime(long j) {
        this.fastForwardTime = j;
    }

    protected final boolean getSwipeHorizontalEnabled() {
        return this.swipeHorizontalEnabled;
    }

    protected final void setSwipeHorizontalEnabled(boolean z) {
        this.swipeHorizontalEnabled = z;
    }

    protected final boolean getSwipeVerticalEnabled() {
        return this.swipeVerticalEnabled;
    }

    protected final void setSwipeVerticalEnabled(boolean z) {
        this.swipeVerticalEnabled = z;
    }

    protected final boolean getPlayBackSpeedEnabled() {
        return this.playBackSpeedEnabled;
    }

    protected final void setPlayBackSpeedEnabled(boolean z) {
        this.playBackSpeedEnabled = z;
    }

    protected final boolean getPlayerResizeEnabled() {
        return this.playerResizeEnabled;
    }

    protected final void setPlayerResizeEnabled(boolean z) {
        this.playerResizeEnabled = z;
    }

    protected final boolean getDoubleTapEnabled() {
        return this.doubleTapEnabled;
    }

    protected final void setDoubleTapEnabled(boolean z) {
        this.doubleTapEnabled = z;
    }

    protected final boolean getDoubleTapPauseEnabled() {
        return this.doubleTapPauseEnabled;
    }

    protected final void setDoubleTapPauseEnabled(boolean z) {
        this.doubleTapPauseEnabled = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setSubtitleDelay(long j) {
        try {
            getPlayer().setSubtitleOffset(-j);
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }

    protected final long getSubtitleDelay() {
        try {
            return -getPlayer().getSubtitleOffset();
        } catch (Exception e) {
            ArchComponentExt.logError(e);
            return 0L;
        }
    }

    protected final boolean getUseTrueSystemBrightness() {
        return this.useTrueSystemBrightness;
    }

    protected final void setUseTrueSystemBrightness(boolean z) {
        this.useTrueSystemBrightness = z;
    }

    protected final DisplayMetrics getDisplayMetrics() {
        return this.displayMetrics;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getScreenWidth() {
        return Math.max(this.displayMetrics.widthPixels, this.displayMetrics.heightPixels);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getScreenHeight() {
        return Math.min(this.displayMetrics.widthPixels, this.displayMetrics.heightPixels);
    }

    public void showMirrorsDialogue() {
        throw new Standard(null, 1, null);
    }

    public void openOnlineSubPicker(Context context, Long l, Functions<Unit> dismissCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dismissCallback, "dismissCallback");
        throw new Standard(null, 1, null);
    }

    private final boolean isValidTouch(float f, float f2) {
        Integer num = this.statusBarHeight;
        return f2 > ((float) (num != null ? num.intValue() : 0)) && f < ((float) getScreenWidth());
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
    public void exitedPipMode() {
        animateLayoutChanges();
    }

    protected final void animateLayoutChanges() {
        float toPx;
        LinearLayout linearLayout;
        if (this.isShowing) {
            updateUIVisibility();
        } else {
            FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_holder);
            if (frameLayout != null) {
                frameLayout.postDelayed(new Runnable() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$FullScreenPlayer$QpWlN67hNthTRFUu-cGOqFmxqxo
                    @Override // java.lang.Runnable
                    public final void run() {
                        FullScreenPlayer.m8670animateLayoutChanges$lambda0(FullScreenPlayer.this);
                    }
                }, 200L);
            }
        }
        float f = this.isShowing ? 0.0f : -UIHelper.INSTANCE.getToPx(50);
        TextView textView = (TextView) _$_findCachedViewById(C4761R.C4764id.player_video_title);
        if (textView != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, "translationY", f);
            ofFloat.setDuration(200L);
            ofFloat.start();
        }
        TextView textView2 = (TextView) _$_findCachedViewById(C4761R.C4764id.player_video_title_rez);
        if (textView2 != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView2, "translationY", f);
            ofFloat2.setDuration(200L);
            ofFloat2.start();
        }
        float toPx2 = this.isShowing ? 0.0f : UIHelper.INSTANCE.getToPx(50);
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C4761R.C4764id.bottom_player_bar);
        if (linearLayout2 != null) {
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(linearLayout2, "translationY", toPx2);
            ofFloat3.setDuration(200L);
            ofFloat3.start();
        }
        float f2 = this.isShowing ? 1.0f : 0.0f;
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f - f2, f2);
        alphaAnimation.setDuration(100L);
        alphaAnimation.setFillAfter(true);
        SubtitleView subView = getSubView();
        SaveCaptionStyle subStyle = getSubStyle();
        if (subView != null && subStyle != null) {
            if (this.isShowing) {
                toPx = (((LinearLayout) _$_findCachedViewById(C4761R.C4764id.bottom_player_bar)) != null ? linearLayout.getHeight() : 0.0f) + UIHelper.INSTANCE.getToPx(40);
            } else {
                toPx = UIHelper.INSTANCE.getToPx(subStyle.getElevation());
            }
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(subView, "translationY", -toPx);
            ofFloat4.setDuration(200L);
            ofFloat4.start();
        }
        float f3 = this.isShowing ? 0.0f : -UIHelper.INSTANCE.getToPx(50);
        ImageView imageView = (ImageView) _$_findCachedViewById(C4761R.C4764id.player_open_source);
        if (imageView != null) {
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(imageView, "translationY", f3);
            ofFloat5.setDuration(200L);
            ofFloat5.start();
        }
        if (!this.isLocked) {
            FrameLayout frameLayout2 = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_ffwd_holder);
            if (frameLayout2 != null) {
                frameLayout2.setAlpha(1.0f);
            }
            FrameLayout frameLayout3 = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_rew_holder);
            if (frameLayout3 != null) {
                frameLayout3.setAlpha(1.0f);
            }
            View _$_findCachedViewById = _$_findCachedViewById(C4761R.C4764id.shadow_overlay);
            if (_$_findCachedViewById != null) {
                _$_findCachedViewById.setVisibility(0);
            }
            View _$_findCachedViewById2 = _$_findCachedViewById(C4761R.C4764id.shadow_overlay);
            if (_$_findCachedViewById2 != null) {
                _$_findCachedViewById2.startAnimation(alphaAnimation);
            }
            FrameLayout frameLayout4 = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_ffwd_holder);
            if (frameLayout4 != null) {
                frameLayout4.startAnimation(alphaAnimation);
            }
            FrameLayout frameLayout5 = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_rew_holder);
            if (frameLayout5 != null) {
                frameLayout5.startAnimation(alphaAnimation);
            }
            ImageView imageView2 = (ImageView) _$_findCachedViewById(C4761R.C4764id.player_pause_play);
            if (imageView2 != null) {
                imageView2.startAnimation(alphaAnimation);
            }
        }
        LinearLayout linearLayout3 = (LinearLayout) _$_findCachedViewById(C4761R.C4764id.bottom_player_bar);
        if (linearLayout3 != null) {
            linearLayout3.startAnimation(alphaAnimation);
        }
        ImageView imageView3 = (ImageView) _$_findCachedViewById(C4761R.C4764id.player_open_source);
        if (imageView3 != null) {
            imageView3.startAnimation(alphaAnimation);
        }
        FrameLayout frameLayout6 = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_top_holder);
        if (frameLayout6 != null) {
            frameLayout6.startAnimation(alphaAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: animateLayoutChanges$lambda-0  reason: not valid java name */
    public static final void m8670animateLayoutChanges$lambda0(FullScreenPlayer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateUIVisibility();
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
    public void subtitlesChanged() {
        MaterialButton materialButton = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.player_subtitle_offset_btt);
        if (materialButton == null) {
            return;
        }
        materialButton.setVisibility(getPlayer().getCurrentPreferredSubtitle() == null ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void enterFullscreen() {
        FragmentActivity activity;
        Window window;
        if (isFullScreenPlayer()) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                UIHelper.INSTANCE.hideSystemUI(activity2);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.fullscreenNotch) {
                FragmentActivity activity3 = getActivity();
                WindowManager.LayoutParams attributes = (activity3 == null || (window = activity3.getWindow()) == null) ? null : window.getAttributes();
                if (attributes != null) {
                    attributes.layoutInDisplayCutoutMode = 1;
                }
                FragmentActivity activity4 = getActivity();
                Window window2 = activity4 != null ? activity4.getWindow() : null;
                if (window2 != null) {
                    window2.setAttributes(attributes);
                }
            }
        }
        if (!getLockRotation() || (activity = getActivity()) == null) {
            return;
        }
        activity.setRequestedOrientation(6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void exitFullscreen() {
        Window window;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            UIHelper.INSTANCE.showSystemUI(activity);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.setRequestedOrientation(2);
        }
        FragmentActivity activity3 = getActivity();
        WindowManager.LayoutParams attributes = (activity3 == null || (window = activity3.getWindow()) == null) ? null : window.getAttributes();
        if (attributes != null) {
            attributes.screenBrightness = -1.0f;
        }
        if (Build.VERSION.SDK_INT >= 28 && attributes != null) {
            attributes.layoutInDisplayCutoutMode = 0;
        }
        FragmentActivity activity4 = getActivity();
        Window window2 = activity4 != null ? activity4.getWindow() : null;
        if (window2 == null) {
            return;
        }
        window2.setAttributes(attributes);
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment, androidx.fragment.app.Fragment
    public void onResume() {
        enterFullscreen();
        super.onResume();
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        exitFullscreen();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setPlayBackSpeed(float f) {
        try {
            AcraApplication.Companion.setKey("playback_speed", Float.valueOf(f));
            MaterialButton materialButton = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.player_speed_btt);
            if (materialButton != null) {
                String string = getString(R.string.player_speed_text_format);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.player_speed_text_format)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                materialButton.setText(StringsKt.replace$default(format, ".0x", "x", false, 4, (Object) null));
            }
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
        getPlayer().setPlaybackSpeed(f);
    }

    private final void skipOp() {
        getPlayer().seekTime(85000L);
    }

    private final void showSubtitleOffsetDialog() {
        Context context = getContext();
        if (context != null) {
            final AlertDialog create = new AlertDialog.Builder(context, R.style.AlertDialogCustom).setView(R.layout.subtitle_offset).create();
            Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
            create.show();
            final long subtitleDelay = getSubtitleDelay();
            View findViewById = create.findViewById(R.id.apply_btt);
            Intrinsics.checkNotNull(findViewById);
            TextView textView = (TextView) findViewById;
            View findViewById2 = create.findViewById(R.id.cancel_btt);
            Intrinsics.checkNotNull(findViewById2);
            TextView textView2 = (TextView) findViewById2;
            View findViewById3 = create.findViewById(R.id.subtitle_offset_input);
            Intrinsics.checkNotNull(findViewById3);
            final EditText editText = (EditText) findViewById3;
            View findViewById4 = create.findViewById(R.id.subtitle_offset_subtract);
            Intrinsics.checkNotNull(findViewById4);
            ImageView imageView = (ImageView) findViewById4;
            View findViewById5 = create.findViewById(R.id.subtitle_offset_add);
            Intrinsics.checkNotNull(findViewById5);
            ImageView imageView2 = (ImageView) findViewById5;
            View findViewById6 = create.findViewById(R.id.subtitle_offset_sub_title);
            Intrinsics.checkNotNull(findViewById6);
            final TextView textView3 = (TextView) findViewById6;
            editText.addTextChangedListener(new TextWatcher() { // from class: com.lagradost.cloudstream3.ui.player.FullScreenPlayer$showSubtitleOffsetDialog$lambda-18$$inlined$doOnTextChanged$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    String obj;
                    Long longOrNull;
                    String string;
                    String string2;
                    if (charSequence == null || (obj = charSequence.toString()) == null || (longOrNull = StringsKt.toLongOrNull(obj)) == null) {
                        return;
                    }
                    long longValue = longOrNull.longValue();
                    FullScreenPlayer.this.setSubtitleDelay(longValue);
                    String str = null;
                    int i4 = (longValue > 0L ? 1 : (longValue == 0L ? 0 : -1));
                    if (i4 > 0) {
                        Context context2 = FullScreenPlayer.this.getContext();
                        if (context2 != null && (string2 = context2.getString(R.string.subtitle_offset_extra_hint_later_format)) != null) {
                            str = String.format(string2, Arrays.copyOf(new Object[]{Long.valueOf(longValue)}, 1));
                            Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
                        }
                    } else if (i4 < 0) {
                        Context context3 = FullScreenPlayer.this.getContext();
                        if (context3 != null && (string = context3.getString(R.string.subtitle_offset_extra_hint_before_format)) != null) {
                            str = String.format(string, Arrays.copyOf(new Object[]{Long.valueOf(-longValue)}, 1));
                            Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
                        }
                    } else if (i4 == 0) {
                        Context context4 = FullScreenPlayer.this.getContext();
                        if (context4 != null) {
                            str = context4.getString(R.string.subtitle_offset_extra_hint_none_format);
                        }
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        textView3.setText(str);
                    }
                }
            });
            Editable.Factory factory = Editable.Factory.getInstance();
            editText.setText(factory != null ? factory.newEditable(String.valueOf(subtitleDelay)) : null);
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$FullScreenPlayer$PRJJPcbD7iyfn9YM3S7NRSU9VJ8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FullScreenPlayer.m8699showSubtitleOffsetDialog$lambda18$lambda13(r1, editText, view);
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$FullScreenPlayer$jAhh9uFTPUTs5apdnD0-DLw7WNY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FullScreenPlayer.m8700showSubtitleOffsetDialog$lambda18$lambda14(r1, editText, view);
                }
            });
            create.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$FullScreenPlayer$-nJFYUNzhHNGg2Xn8W3gMOBf6Eg
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    FullScreenPlayer.m8701showSubtitleOffsetDialog$lambda18$lambda15(FullScreenPlayer.this, dialogInterface);
                }
            });
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$FullScreenPlayer$fVDzd_bEio765n8zSNt4YM1LYu8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FullScreenPlayer.m8702showSubtitleOffsetDialog$lambda18$lambda16(AlertDialog.this, this, view);
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$FullScreenPlayer$qC1Di7UO3RH15PUC2wbwrdcBkLg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FullScreenPlayer.m8703showSubtitleOffsetDialog$lambda18$lambda17(FullScreenPlayer.this, subtitleDelay, create, view);
                }
            });
        }
    }

    /* renamed from: showSubtitleOffsetDialog$lambda-18$changeBy  reason: not valid java name */
    private static final void m8698showSubtitleOffsetDialog$lambda18$changeBy(EditText editText, long j) {
        String obj;
        Long longOrNull;
        Editable text = editText.getText();
        long longValue = ((text == null || (obj = text.toString()) == null || (longOrNull = StringsKt.toLongOrNull(obj)) == null) ? 0L : longOrNull.longValue()) + j;
        Editable.Factory factory = Editable.Factory.getInstance();
        editText.setText(factory != null ? factory.newEditable(String.valueOf(longValue)) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showSubtitleOffsetDialog$lambda-18$lambda-13  reason: not valid java name */
    public static final void m8699showSubtitleOffsetDialog$lambda18$lambda13(long j, EditText input, View view) {
        Intrinsics.checkNotNullParameter(input, "$input");
        m8698showSubtitleOffsetDialog$lambda18$changeBy(input, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showSubtitleOffsetDialog$lambda-18$lambda-14  reason: not valid java name */
    public static final void m8700showSubtitleOffsetDialog$lambda18$lambda14(long j, EditText input, View view) {
        Intrinsics.checkNotNullParameter(input, "$input");
        m8698showSubtitleOffsetDialog$lambda18$changeBy(input, -j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showSubtitleOffsetDialog$lambda-18$lambda-15  reason: not valid java name */
    public static final void m8701showSubtitleOffsetDialog$lambda18$lambda15(FullScreenPlayer this$0, DialogInterface dialogInterface) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isFullScreenPlayer() || (activity = this$0.getActivity()) == null) {
            return;
        }
        UIHelper.INSTANCE.hideSystemUI(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showSubtitleOffsetDialog$lambda-18$lambda-16  reason: not valid java name */
    public static final void m8702showSubtitleOffsetDialog$lambda18$lambda16(AlertDialog dialog, FullScreenPlayer this$0, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UIHelper.INSTANCE.dismissSafe(dialog, this$0.getActivity());
        this$0.getPlayer().seekTime(1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showSubtitleOffsetDialog$lambda-18$lambda-17  reason: not valid java name */
    public static final void m8703showSubtitleOffsetDialog$lambda18$lambda17(FullScreenPlayer this$0, long j, AlertDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.setSubtitleDelay(j);
        UIHelper.INSTANCE.dismissSafe(dialog, this$0.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSpeedDialog() {
        List<String> listOf = CollectionsKt.listOf((Object[]) new String[]{"0.5x", "0.75x", "0.85x", "1x", "1.15x", "1.25x", "1.4x", "1.5x", "1.75x", "2x"});
        List listOf2 = CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(0.5f), Float.valueOf(0.75f), Float.valueOf(0.85f), Float.valueOf(1.0f), Float.valueOf(1.15f), Float.valueOf(1.25f), Float.valueOf(1.4f), Float.valueOf(1.5f), Float.valueOf(1.75f), Float.valueOf(2.0f)});
        int indexOf = listOf2.indexOf(Float.valueOf(getPlayer().getPlaybackSpeed()));
        FragmentActivity activity = getActivity();
        if (activity != null) {
            String string = activity.getString(R.string.player_speed);
            Intrinsics.checkNotNullExpressionValue(string, "act.getString(R.string.player_speed)");
            SingleSelectionHelper.INSTANCE.showDialog(activity, listOf, indexOf, string, false, new FullScreenPlayer$showSpeedDialog$1$1(this), new FullScreenPlayer$showSpeedDialog$1$2(this, listOf2));
        }
    }

    public final void resetRewindText() {
        TextView textView = (TextView) _$_findCachedViewById(C4761R.C4764id.exo_rew_text);
        if (textView == null) {
            return;
        }
        String string = getString(R.string.rew_text_regular_format);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.rew_text_regular_format)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Long.valueOf(this.fastForwardTime / 1000)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        textView.setText(format);
    }

    public final void resetFastForwardText() {
        TextView textView = (TextView) _$_findCachedViewById(C4761R.C4764id.exo_ffwd_text);
        if (textView == null) {
            return;
        }
        String string = getString(R.string.ffw_text_regular_format);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.ffw_text_regular_format)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Long.valueOf(this.fastForwardTime / 1000)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        textView.setText(format);
    }

    private final void rewind() {
        try {
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C4761R.C4764id.player_center_menu);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_rew_holder);
            if (frameLayout != null) {
                frameLayout.setAlpha(1.0f);
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_left);
            ImageButton imageButton = (ImageButton) _$_findCachedViewById(C4761R.C4764id.exo_rew);
            if (imageButton != null) {
                imageButton.startAnimation(loadAnimation);
            }
            Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.go_left);
            loadAnimation2.setAnimationListener(new FullScreenPlayer$rewind$1(this));
            TextView textView = (TextView) _$_findCachedViewById(C4761R.C4764id.exo_rew_text);
            if (textView != null) {
                textView.startAnimation(loadAnimation2);
            }
            TextView textView2 = (TextView) _$_findCachedViewById(C4761R.C4764id.exo_rew_text);
            if (textView2 != null) {
                String string = getString(R.string.rew_text_format);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.rew_text_format)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Long.valueOf(this.fastForwardTime / 1000)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                textView2.setText(format);
            }
            getPlayer().seekTime(-this.fastForwardTime);
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }

    private final void fastForward() {
        try {
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C4761R.C4764id.player_center_menu);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_ffwd_holder);
            if (frameLayout != null) {
                frameLayout.setAlpha(1.0f);
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_right);
            ImageButton imageButton = (ImageButton) _$_findCachedViewById(C4761R.C4764id.exo_ffwd);
            if (imageButton != null) {
                imageButton.startAnimation(loadAnimation);
            }
            Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.go_right);
            loadAnimation2.setAnimationListener(new FullScreenPlayer$fastForward$1(this));
            TextView textView = (TextView) _$_findCachedViewById(C4761R.C4764id.exo_ffwd_text);
            if (textView != null) {
                textView.startAnimation(loadAnimation2);
            }
            TextView textView2 = (TextView) _$_findCachedViewById(C4761R.C4764id.exo_ffwd_text);
            if (textView2 != null) {
                String string = getString(R.string.ffw_text_format);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.ffw_text_format)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Long.valueOf(this.fastForwardTime / 1000)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                textView2.setText(format);
            }
            getPlayer().seekTime(this.fastForwardTime);
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClickChange() {
        FragmentActivity activity;
        boolean z = !this.isShowing;
        this.isShowing = z;
        if (z) {
            FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_intro_play);
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            autoHide();
        }
        if (isFullScreenPlayer() && (activity = getActivity()) != null) {
            UIHelper.INSTANCE.hideSystemUI(activity);
        }
        animateLayoutChanges();
        ImageView imageView = (ImageView) _$_findCachedViewById(C4761R.C4764id.player_pause_play);
        if (imageView != null) {
            imageView.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggleLock() {
        FrameLayout frameLayout;
        if (!this.isShowing) {
            onClickChange();
        }
        boolean z = !this.isLocked;
        this.isLocked = z;
        if (z && this.isShowing && (frameLayout = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_holder)) != null) {
            frameLayout.postDelayed(new Runnable() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$FullScreenPlayer$U8UtHF7pn0WE8H6lFbBH_thU1E8
                @Override // java.lang.Runnable
                public final void run() {
                    FullScreenPlayer.m8704toggleLock$lambda20(FullScreenPlayer.this);
                }
            }, 200L);
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(((TextView) _$_findCachedViewById(C4761R.C4764id.player_video_title)).getAlpha(), this.isLocked ? 0.0f : 1.0f);
        alphaAnimation.setDuration(100L);
        alphaAnimation.setFillAfter(true);
        updateUIVisibility();
        ImageView imageView = (ImageView) _$_findCachedViewById(C4761R.C4764id.player_pause_play);
        if (imageView != null) {
            imageView.startAnimation(alphaAnimation);
        }
        FrameLayout frameLayout2 = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_ffwd_holder);
        if (frameLayout2 != null) {
            frameLayout2.startAnimation(alphaAnimation);
        }
        FrameLayout frameLayout3 = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_rew_holder);
        if (frameLayout3 != null) {
            frameLayout3.startAnimation(alphaAnimation);
        }
        TextView textView = (TextView) _$_findCachedViewById(C4761R.C4764id.player_video_title_rez);
        if (textView != null) {
            textView.startAnimation(alphaAnimation);
        }
        MaterialButton materialButton = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.player_episode_filler);
        if (materialButton != null) {
            materialButton.startAnimation(alphaAnimation);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(C4761R.C4764id.player_video_title);
        if (textView2 != null) {
            textView2.startAnimation(alphaAnimation);
        }
        FrameLayout frameLayout4 = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_top_holder);
        if (frameLayout4 != null) {
            frameLayout4.startAnimation(alphaAnimation);
        }
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C4761R.C4764id.player_lock_holder);
        if (linearLayout != null) {
            linearLayout.startAnimation(alphaAnimation);
        }
        View _$_findCachedViewById = _$_findCachedViewById(C4761R.C4764id.shadow_overlay);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setVisibility(0);
        }
        View _$_findCachedViewById2 = _$_findCachedViewById(C4761R.C4764id.shadow_overlay);
        if (_$_findCachedViewById2 != null) {
            _$_findCachedViewById2.startAnimation(alphaAnimation);
        }
        updateLockUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toggleLock$lambda-20  reason: not valid java name */
    public static final void m8704toggleLock$lambda20(FullScreenPlayer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isLocked && this$0.isShowing) {
            this$0.onClickChange();
        }
    }

    private final void updateUIVisibility() {
        boolean z = this.isLocked || !this.isShowing;
        Context context = getContext();
        boolean z2 = (context == null || PreferenceManager.getDefaultSharedPreferences(context).getInt(getString(R.string.prefer_limit_title_key), 0) >= 0) ? z : true;
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C4761R.C4764id.player_lock_holder);
        if (linearLayout != null) {
            linearLayout.setVisibility(z ? 8 : 0);
        }
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C4761R.C4764id.player_video_bar);
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(z ? 8 : 0);
        }
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_pause_play_holder);
        if (frameLayout != null) {
            frameLayout.setVisibility(z ? 8 : 0);
        }
        ImageView imageView = (ImageView) _$_findCachedViewById(C4761R.C4764id.player_pause_play);
        if (imageView != null) {
            imageView.setVisibility(z ? 8 : 0);
        }
        FrameLayout frameLayout2 = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_top_holder);
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(z ? 8 : 0);
        }
        TextView textView = (TextView) _$_findCachedViewById(C4761R.C4764id.player_video_title);
        if (textView != null) {
            textView.setVisibility(z2 ? 8 : 0);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(C4761R.C4764id.player_video_title_rez);
        if (textView2 != null) {
            textView2.setVisibility(z ? 8 : 0);
        }
        MaterialButton materialButton = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.player_episode_filler);
        if (materialButton != null) {
            materialButton.setVisibility(z ? 8 : 0);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C4761R.C4764id.player_center_menu);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(z ? 8 : 0);
        }
        MaterialButton materialButton2 = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.player_lock);
        if (materialButton2 != null) {
            materialButton2.setVisibility(true ^ this.isShowing ? 8 : 0);
        }
        FrameLayout frameLayout3 = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_go_back_holder);
        if (frameLayout3 == null) {
            return;
        }
        frameLayout3.setVisibility(z ? 8 : 0);
    }

    private final void updateLockUI() {
        Integer num;
        MaterialButton materialButton = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.player_lock);
        if (materialButton != null) {
            materialButton.setIconResource(this.isLocked ? R.drawable.video_locked : R.drawable.video_unlocked);
        }
        if (getLayout() == R.layout.fragment_player) {
            if (this.isLocked) {
                Context context = getContext();
                num = context != null ? Integer.valueOf(UIHelper.INSTANCE.colorFromAttribute(context, R.attr.colorPrimary)) : null;
            } else {
                num = -1;
            }
            if (num != null) {
                MaterialButton materialButton2 = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.player_lock);
                if (materialButton2 != null) {
                    materialButton2.setTextColor(num.intValue());
                }
                MaterialButton materialButton3 = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.player_lock);
                if (materialButton3 != null) {
                    materialButton3.setIconTint(ColorStateList.valueOf(num.intValue()));
                }
                MaterialButton materialButton4 = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.player_lock);
                if (materialButton4 == null) {
                    return;
                }
                materialButton4.setRippleColor(ColorStateList.valueOf(Color.argb(50, (num.intValue() >> 16) & 255, (num.intValue() >> 8) & 255, num.intValue() & 255)));
            }
        }
    }

    protected final void autoHide() {
        final int i = this.currentTapIndex + 1;
        this.currentTapIndex = i;
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_holder);
        if (frameLayout != null) {
            frameLayout.postDelayed(new Runnable() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$FullScreenPlayer$MSgFXNZ8ucRdzaGJcRxymRisV1o
                @Override // java.lang.Runnable
                public final void run() {
                    FullScreenPlayer.m8671autoHide$lambda23(FullScreenPlayer.this, i);
                }
            }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: autoHide$lambda-23  reason: not valid java name */
    public static final void m8671autoHide$lambda23(FullScreenPlayer this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isCurrentTouchValid && this$0.isShowing && i == this$0.currentTapIndex && this$0.getPlayer().getIsPlaying()) {
            this$0.onClickChange();
        }
    }

    private final void toggleShowDelayed() {
        if (this.doubleTapEnabled || this.doubleTapPauseEnabled) {
            final int i = this.currentDoubleTapIndex;
            FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_holder);
            if (frameLayout != null) {
                frameLayout.postDelayed(new Runnable() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$FullScreenPlayer$oWTQYrBYZHUU3m8c5I1B1NtAuVg
                    @Override // java.lang.Runnable
                    public final void run() {
                        FullScreenPlayer.m8705toggleShowDelayed$lambda24(i, this);
                    }
                }, 200L);
                return;
            }
            return;
        }
        onClickChange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toggleShowDelayed$lambda-24  reason: not valid java name */
    public static final void m8705toggleShowDelayed$lambda24(int i, FullScreenPlayer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i == this$0.currentDoubleTapIndex) {
            this$0.onClickChange();
        }
    }

    /* compiled from: FullScreenPlayer.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/FullScreenPlayer$Companion;", "", "()V", "convertTimeToString", "", "sec", "", "forceLetters", "inp", "letters", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.player.FullScreenPlayer$Companion */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        static /* synthetic */ String forceLetters$default(Companion companion, long j, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 2;
            }
            return companion.forceLetters(j, i);
        }

        private final String forceLetters(long j, int i) {
            int length = i - String.valueOf(j).length();
            if (length > 0) {
                return StringsKt.repeat("0", length) + j;
            }
            return String.valueOf(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String convertTimeToString(long j) {
            long j2;
            String str;
            long j3 = j % 60;
            long ceil = ((int) Math.ceil((j - j3) / 60.0d)) % 60;
            long ceil2 = (long) Math.ceil((j2 - ceil) / 60.0d);
            StringBuilder sb = new StringBuilder();
            String str2 = "";
            int i = (ceil2 > 0L ? 1 : (ceil2 == 0L ? 0 : -1));
            if (i > 0) {
                str = forceLetters$default(this, ceil2, 0, 2, null) + ':';
            } else {
                str = "";
            }
            sb.append(str);
            if (ceil >= 0 || i >= 0) {
                str2 = forceLetters$default(this, ceil, 0, 2, null) + ':';
            }
            sb.append(str2);
            sb.append(forceLetters$default(this, j3, 0, 2, null));
            return sb.toString();
        }
    }

    private final Long calculateNewTime(Long l, Vector2 vector2, Vector2 vector22) {
        if (vector2 != null && vector22 != null && l != null) {
            float x = ((vector22.getX() - vector2.getX()) * 2.0f) / getScreenWidth();
            Long duration = getPlayer().getDuration();
            if (duration != null) {
                long longValue = duration.longValue();
                return Long.valueOf(Math.max(Math.min(l.longValue() + (((float) longValue) * x * x * (x < 0.0f ? -1 : 1)), longValue), 0L));
            }
        }
        return null;
    }

    private final Float getBrightness() {
        Context context;
        Window window;
        WindowManager.LayoutParams attributes;
        r1 = null;
        r1 = null;
        Float f = null;
        if (this.useTrueSystemBrightness) {
            try {
                return Float.valueOf(Settings.System.getInt(getContext() != null ? context.getContentResolver() : null, "screen_brightness") / 255.0f);
            } catch (Exception unused) {
                this.useTrueSystemBrightness = false;
                return getBrightness();
            }
        }
        try {
            FragmentActivity activity = getActivity();
            if (activity != null && (window = activity.getWindow()) != null && (attributes = window.getAttributes()) != null) {
                f = Float.valueOf(attributes.screenBrightness);
            }
        } catch (Exception e) {
            ArchComponentExt.logError(e);
            f = null;
        }
        return f;
    }

    private final void setBrightness(float f) {
        Window window;
        if (this.useTrueSystemBrightness) {
            try {
                Context context = getContext();
                Settings.System.putInt(context != null ? context.getContentResolver() : null, "screen_brightness_mode", 0);
                Context context2 = getContext();
                Settings.System.putInt(context2 != null ? context2.getContentResolver() : null, "screen_brightness", (int) (255 * f));
                return;
            } catch (Exception unused) {
                this.useTrueSystemBrightness = false;
                setBrightness(f);
                return;
            }
        }
        try {
            FragmentActivity activity = getActivity();
            WindowManager.LayoutParams attributes = (activity == null || (window = activity.getWindow()) == null) ? null : window.getAttributes();
            if (attributes != null) {
                attributes.screenBrightness = f;
            }
            FragmentActivity activity2 = getActivity();
            Window window2 = activity2 != null ? activity2.getWindow() : null;
            if (window2 == null) {
                return;
            }
            window2.setAttributes(attributes);
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }

    private final boolean handleMotionEvent(View view, MotionEvent motionEvent) {
        AudioManager audioManager;
        Long l;
        Long calculateNewTime;
        Long calculateNewTime2;
        TouchAction touchAction;
        if (motionEvent == null || view == null) {
            return false;
        }
        Vector2 vector2 = new Vector2(motionEvent.getX(), motionEvent.getY());
        Vector2 vector22 = this.currentTouchStart;
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_intro_play);
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            boolean isValidTouch = isValidTouch(vector2.getX(), vector2.getY());
            this.isCurrentTouchValid = isValidTouch;
            if (isValidTouch) {
                this.currentTouchStartTime = Long.valueOf(System.currentTimeMillis());
                this.currentTouchStart = vector2;
                this.currentTouchLast = vector2;
                this.currentTouchStartPlayerTime = getPlayer().getPosition();
                Float brightness = getBrightness();
                if (brightness != null) {
                    this.currentRequestedBrightness = brightness.floatValue();
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                }
                FragmentActivity activity = getActivity();
                Object systemService = activity != null ? activity.getSystemService("audio") : null;
                if ((systemService instanceof AudioManager ? (AudioManager) systemService : null) != null) {
                    this.currentRequestedVolume = audioManager.getStreamVolume(3) / audioManager.getStreamMaxVolume(3);
                    Unit unit3 = Unit.INSTANCE;
                    Unit unit4 = Unit.INSTANCE;
                }
            }
        } else if (action == 1) {
            if (this.isCurrentTouchValid && !this.isLocked && isFullScreenPlayer() && this.swipeHorizontalEnabled && this.currentTouchAction == TouchAction.Time && (l = this.currentTouchStartPlayerTime) != null && (calculateNewTime = calculateNewTime(l, vector22, vector2)) != null) {
                long longValue = calculateNewTime.longValue();
                if (Math.abs(longValue - l.longValue()) > FullScreenPlayerKt.MINIMUM_SEEK_TIME) {
                    getPlayer().seekTo(longValue);
                }
                Unit unit5 = Unit.INSTANCE;
                Unit unit6 = Unit.INSTANCE;
            }
            Long l2 = this.currentTouchStartTime;
            Long valueOf = l2 != null ? Long.valueOf(l2.longValue() - System.currentTimeMillis()) : null;
            if (this.isCurrentTouchValid && this.currentTouchAction == null && this.currentLastTouchAction == null && valueOf != null && valueOf.longValue() < 200) {
                if (!this.isLocked && System.currentTimeMillis() - this.currentLastTouchEndTime < 200) {
                    int i = this.currentClickCount + 1;
                    this.currentClickCount = i;
                    if (i >= 1) {
                        this.currentDoubleTapIndex++;
                        if (this.doubleTapPauseEnabled && isFullScreenPlayer()) {
                            if (vector2.getX() < (getScreenWidth() / 2) - (getScreenWidth() * 0.15d)) {
                                if (this.doubleTapEnabled) {
                                    rewind();
                                }
                            } else if (vector2.getX() > (getScreenWidth() / 2) + (getScreenWidth() * 0.15d)) {
                                if (this.doubleTapEnabled) {
                                    fastForward();
                                }
                            } else {
                                getPlayer().handleEvent(CSPlayerEvent.PlayPauseToggle);
                            }
                        } else if (this.doubleTapEnabled && isFullScreenPlayer()) {
                            if (vector2.getX() < getScreenWidth() / 2) {
                                rewind();
                            } else {
                                fastForward();
                            }
                        }
                    }
                } else {
                    this.currentClickCount = 0;
                    toggleShowDelayed();
                }
            } else {
                this.currentClickCount = 0;
            }
            autoHide();
            this.isCurrentTouchValid = false;
            this.currentTouchStart = null;
            this.currentLastTouchAction = this.currentTouchAction;
            this.currentTouchAction = null;
            this.currentTouchStartPlayerTime = null;
            this.currentTouchLast = null;
            this.currentTouchStartTime = null;
            TextView textView = (TextView) _$_findCachedViewById(C4761R.C4764id.player_time_text);
            if (textView != null) {
                textView.setVisibility(8);
            }
            RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(C4761R.C4764id.player_progressbar_left_holder);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(C4761R.C4764id.player_progressbar_right_holder);
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            }
            this.currentLastTouchEndTime = System.currentTimeMillis();
        } else if (action == 2 && vector22 != null && this.isCurrentTouchValid && !this.isLocked && isFullScreenPlayer()) {
            if (this.currentTouchAction == null) {
                Vector2 minus = vector22.minus(vector2);
                if (this.swipeVerticalEnabled && Math.abs((minus.getY() * 100) / getScreenHeight()) > 2.0f) {
                    if (vector22.getX() < getScreenWidth() / 2) {
                        if (this.isShowing) {
                            this.isShowing = false;
                            animateLayoutChanges();
                        }
                        touchAction = TouchAction.Brightness;
                    } else {
                        touchAction = TouchAction.Volume;
                    }
                    this.currentTouchAction = touchAction;
                }
                if (this.swipeHorizontalEnabled && Math.abs((minus.getX() * 100) / getScreenHeight()) > 2.0f) {
                    this.currentTouchAction = TouchAction.Time;
                }
            }
            Vector2 vector23 = this.currentTouchLast;
            if (vector23 != null) {
                float y = (vector23.minus(vector2).getY() * 2.0f) / getScreenHeight();
                TextView textView2 = (TextView) _$_findCachedViewById(C4761R.C4764id.player_time_text);
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                RelativeLayout relativeLayout3 = (RelativeLayout) _$_findCachedViewById(C4761R.C4764id.player_progressbar_left_holder);
                if (relativeLayout3 != null) {
                    relativeLayout3.setVisibility(8);
                }
                RelativeLayout relativeLayout4 = (RelativeLayout) _$_findCachedViewById(C4761R.C4764id.player_progressbar_right_holder);
                if (relativeLayout4 != null) {
                    relativeLayout4.setVisibility(8);
                }
                TouchAction touchAction2 = this.currentTouchAction;
                int i2 = touchAction2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[touchAction2.ordinal()];
                if (i2 == 1) {
                    Long l3 = this.currentTouchStartPlayerTime;
                    Long valueOf2 = l3 != null ? Long.valueOf((l3.longValue() / 1000) * 1000) : null;
                    if (valueOf2 != null && (calculateNewTime2 = calculateNewTime(valueOf2, vector22, vector2)) != null) {
                        long longValue2 = calculateNewTime2.longValue();
                        long longValue3 = longValue2 - valueOf2.longValue();
                        TextView textView3 = (TextView) _$_findCachedViewById(C4761R.C4764id.player_time_text);
                        if (textView3 != null) {
                            StringBuilder sb = new StringBuilder();
                            Companion companion = Companion;
                            long j = 1000;
                            sb.append(companion.convertTimeToString(longValue2 / j));
                            sb.append(" [");
                            sb.append(Math.abs(longValue3) < 1000 ? "" : longValue3 > 0 ? "+" : "-");
                            sb.append(companion.convertTimeToString(Math.abs(longValue3 / j)));
                            sb.append(']');
                            textView3.setText(sb.toString());
                        }
                        TextView player_time_text = (TextView) _$_findCachedViewById(C4761R.C4764id.player_time_text);
                        if (player_time_text != null) {
                            Intrinsics.checkNotNullExpressionValue(player_time_text, "player_time_text");
                            player_time_text.setVisibility(0);
                        }
                        Unit unit7 = Unit.INSTANCE;
                        Unit unit8 = Unit.INSTANCE;
                    }
                    Unit unit9 = Unit.INSTANCE;
                } else if (i2 == 2) {
                    RelativeLayout relativeLayout5 = (RelativeLayout) _$_findCachedViewById(C4761R.C4764id.player_progressbar_right_holder);
                    if (relativeLayout5 != null) {
                        relativeLayout5.setVisibility(0);
                    }
                    float f = this.currentRequestedBrightness;
                    float min = Math.min(1.0f, Math.max(y + f, 0.0f));
                    this.currentRequestedBrightness = min;
                    if (!(f == min)) {
                        setBrightness(min);
                    }
                    ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C4761R.C4764id.player_progressbar_right);
                    if (progressBar != null) {
                        progressBar.setMax(AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND);
                    }
                    ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C4761R.C4764id.player_progressbar_right);
                    if (progressBar2 != null) {
                        progressBar2.setProgress(Math.max(2000, (int) (this.currentRequestedBrightness * 100000.0f)));
                    }
                    ImageView imageView = (ImageView) _$_findCachedViewById(C4761R.C4764id.player_progressbar_right_icon);
                    if (imageView != null) {
                        List<Integer> list = this.brightnessIcons;
                        imageView.setImageResource(list.get(Math.min(list.size() - 1, Math.max(0, (int) Math.rint(this.currentRequestedBrightness * (this.brightnessIcons.size() - 1))))).intValue());
                        Unit unit10 = Unit.INSTANCE;
                    }
                } else if (i2 == 3) {
                    FragmentActivity activity2 = getActivity();
                    Object systemService2 = activity2 != null ? activity2.getSystemService("audio") : null;
                    AudioManager audioManager2 = systemService2 instanceof AudioManager ? (AudioManager) systemService2 : null;
                    if (audioManager2 != null) {
                        RelativeLayout player_progressbar_left_holder = (RelativeLayout) _$_findCachedViewById(C4761R.C4764id.player_progressbar_left_holder);
                        if (player_progressbar_left_holder != null) {
                            Intrinsics.checkNotNullExpressionValue(player_progressbar_left_holder, "player_progressbar_left_holder");
                            player_progressbar_left_holder.setVisibility(0);
                        }
                        int streamMaxVolume = audioManager2.getStreamMaxVolume(3);
                        int streamVolume = audioManager2.getStreamVolume(3);
                        this.currentRequestedVolume = Math.min(1.0f, Math.max(this.currentRequestedVolume + y, 0.0f));
                        ProgressBar progressBar3 = (ProgressBar) _$_findCachedViewById(C4761R.C4764id.player_progressbar_left);
                        if (progressBar3 != null) {
                            progressBar3.setMax(AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND);
                        }
                        ProgressBar progressBar4 = (ProgressBar) _$_findCachedViewById(C4761R.C4764id.player_progressbar_left);
                        if (progressBar4 != null) {
                            progressBar4.setProgress(Math.max(2000, (int) (this.currentRequestedVolume * 100000.0f)));
                        }
                        ImageView imageView2 = (ImageView) _$_findCachedViewById(C4761R.C4764id.player_progressbar_left_icon);
                        if (imageView2 != null) {
                            List<Integer> list2 = this.volumeIcons;
                            imageView2.setImageResource(list2.get(Math.min(list2.size() - 1, Math.max(0, (int) Math.rint(this.currentRequestedVolume * (this.volumeIcons.size() - 1))))).intValue());
                            Unit unit11 = Unit.INSTANCE;
                        }
                        int rint = (int) Math.rint(this.currentRequestedVolume * streamMaxVolume);
                        if (rint != streamVolume) {
                            audioManager2.adjustStreamVolume(3, rint >= streamVolume ? 1 : -1, 0);
                        }
                        Unit unit12 = Unit.INSTANCE;
                        Unit unit13 = Unit.INSTANCE;
                    }
                } else {
                    Unit unit14 = Unit.INSTANCE;
                }
            }
        }
        this.currentTouchLast = vector2;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean handleKeyEvent(KeyEvent keyEvent, boolean z) {
        if (z) {
            autoHide();
        } else {
            int keyCode = keyEvent.getKeyCode();
            if (keyEvent.getAction() == 0) {
                switch (keyCode) {
                    case 19:
                        if (!this.isShowing) {
                            onClickChange();
                            return true;
                        }
                        break;
                    case 21:
                        if (!this.isShowing && !this.isLocked) {
                            getPlayer().seekTime(-10000L);
                            return true;
                        }
                        ImageView imageView = (ImageView) _$_findCachedViewById(C4761R.C4764id.player_pause_play);
                        if (imageView != null && imageView.isFocused()) {
                            getPlayer().seekTime(-30000L);
                            return true;
                        }
                        break;
                    case 22:
                        if (!this.isShowing && !this.isLocked) {
                            getPlayer().seekTime(10000L);
                            return true;
                        }
                        ImageView imageView2 = (ImageView) _$_findCachedViewById(C4761R.C4764id.player_pause_play);
                        if (imageView2 != null && imageView2.isFocused()) {
                            getPlayer().seekTime(30000L);
                            return true;
                        }
                        break;
                    case 23:
                        if (!this.isShowing) {
                            if (!this.isLocked) {
                                getPlayer().handleEvent(CSPlayerEvent.PlayPauseToggle);
                            }
                            onClickChange();
                            return true;
                        }
                        break;
                }
            }
            if (keyCode != 4) {
                if (keyCode != 19 && keyCode != 20) {
                    switch (keyCode) {
                    }
                }
                if (!this.isShowing) {
                    return true;
                }
                autoHide();
            } else if (this.isShowing) {
                onClickChange();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void uiReset() {
        this.isLocked = false;
        this.isShowing = false;
        MaterialButton materialButton = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.player_skip_episode);
        if (materialButton != null) {
            materialButton.setVisibility(8);
        }
        MaterialButton materialButton2 = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.player_skip_op);
        if (materialButton2 != null) {
            materialButton2.setVisibility(8);
        }
        View _$_findCachedViewById = _$_findCachedViewById(C4761R.C4764id.shadow_overlay);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setVisibility(8);
        }
        updateLockUI();
        updateUIVisibility();
        animateLayoutChanges();
        resetFastForwardText();
        resetRewindText();
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Context context = AcraApplication.Companion.getContext();
        Object obj = null;
        if (context != null) {
            DataStore dataStore = DataStore.INSTANCE;
            try {
                String string = dataStore.getSharedPrefs(context).getString("playback_speed", null);
                if (string != null) {
                    Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                    Object readValue = dataStore.getMapper().readValue(string, Float.class);
                    Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                    obj = readValue;
                }
            } catch (Exception unused) {
            }
        }
        Float f = (Float) obj;
        setPlayBackSpeed(f != null ? f.floatValue() : 1.0f);
        CommonActivity.INSTANCE.setPlayerEventListener(new FullScreenPlayer$onViewCreated$1(this, view));
        CommonActivity.INSTANCE.setKeyEventListener(new FullScreenPlayer$onViewCreated$2(this));
        try {
            Context context2 = getContext();
            int i = 0;
            if (context2 != null) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context2);
                this.fastForwardTime = defaultSharedPreferences.getInt(context2.getString(R.string.double_tap_seek_time_key), 10) * 1000;
                this.navigationBarHeight = Integer.valueOf(UIHelper.INSTANCE.getNavigationBarHeight(context2));
                this.statusBarHeight = Integer.valueOf(UIHelper.INSTANCE.getStatusBarHeight(context2));
                this.swipeHorizontalEnabled = defaultSharedPreferences.getBoolean(context2.getString(R.string.swipe_enabled_key), true);
                this.swipeVerticalEnabled = defaultSharedPreferences.getBoolean(context2.getString(R.string.swipe_vertical_enabled_key), true);
                this.playBackSpeedEnabled = defaultSharedPreferences.getBoolean(context2.getString(R.string.playback_speed_enabled_key), false);
                this.playerResizeEnabled = defaultSharedPreferences.getBoolean(context2.getString(R.string.player_resize_enabled_key), true);
                this.doubleTapEnabled = defaultSharedPreferences.getBoolean(context2.getString(R.string.double_tap_enabled_key), false);
                this.doubleTapPauseEnabled = defaultSharedPreferences.getBoolean(context2.getString(R.string.double_tap_pause_enabled_key), false);
                this.currentPrefQuality = defaultSharedPreferences.getInt(context2.getString(R.string.quality_pref_key), this.currentPrefQuality);
            }
            MaterialButton materialButton = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.player_speed_btt);
            if (materialButton != null) {
                materialButton.setVisibility(this.playBackSpeedEnabled ? 0 : 8);
            }
            MaterialButton materialButton2 = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.player_resize_btt);
            if (materialButton2 != null) {
                MaterialButton materialButton3 = materialButton2;
                if (!this.playerResizeEnabled) {
                    i = 8;
                }
                materialButton3.setVisibility(i);
            }
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
        ImageView imageView = (ImageView) _$_findCachedViewById(C4761R.C4764id.player_pause_play);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$FullScreenPlayer$XJq3j5FEck1UOsT-uNdlVV0HpNg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FullScreenPlayer.m8684onViewCreated$lambda32(FullScreenPlayer.this, view2);
                }
            });
        }
        MaterialButton materialButton4 = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.player_resize_btt);
        if (materialButton4 != null) {
            materialButton4.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$FullScreenPlayer$O3kSYdMmlC3jdPFC2GfYjZE1y7k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FullScreenPlayer.m8685onViewCreated$lambda33(FullScreenPlayer.this, view2);
                }
            });
        }
        MaterialButton materialButton5 = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.player_speed_btt);
        if (materialButton5 != null) {
            materialButton5.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$FullScreenPlayer$chc5sdLeqWx3NaKfJpaeuPL7n2M
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FullScreenPlayer.m8686onViewCreated$lambda34(FullScreenPlayer.this, view2);
                }
            });
        }
        MaterialButton materialButton6 = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.player_skip_op);
        if (materialButton6 != null) {
            materialButton6.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$FullScreenPlayer$h6MBXdMhKv0-AcBtwwhKzWGjCgQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FullScreenPlayer.m8687onViewCreated$lambda35(FullScreenPlayer.this, view2);
                }
            });
        }
        MaterialButton materialButton7 = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.player_skip_episode);
        if (materialButton7 != null) {
            materialButton7.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$FullScreenPlayer$gsUt4Vl1HTBVOaiGC-eDlA6TgXw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FullScreenPlayer.m8688onViewCreated$lambda36(FullScreenPlayer.this, view2);
                }
            });
        }
        MaterialButton materialButton8 = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.player_lock);
        if (materialButton8 != null) {
            materialButton8.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$FullScreenPlayer$JcBbnZm_GFo5fo0CAoIWHpXNSiM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FullScreenPlayer.m8689onViewCreated$lambda37(FullScreenPlayer.this, view2);
                }
            });
        }
        MaterialButton materialButton9 = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.player_subtitle_offset_btt);
        if (materialButton9 != null) {
            materialButton9.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$FullScreenPlayer$ayi9FvFYIZnSICbdUOZtXA-uxXY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FullScreenPlayer.m8690onViewCreated$lambda38(FullScreenPlayer.this, view2);
                }
            });
        }
        ImageButton imageButton = (ImageButton) _$_findCachedViewById(C4761R.C4764id.exo_rew);
        if (imageButton != null) {
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$FullScreenPlayer$7JUM-EzHYYo4-uaqJ9JItQfec8U
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FullScreenPlayer.m8691onViewCreated$lambda39(FullScreenPlayer.this, view2);
                }
            });
        }
        ImageButton imageButton2 = (ImageButton) _$_findCachedViewById(C4761R.C4764id.exo_ffwd);
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$FullScreenPlayer$Tww4BAAFrq5-soxnNoTY8lnKATE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FullScreenPlayer.m8692onViewCreated$lambda40(FullScreenPlayer.this, view2);
                }
            });
        }
        ImageView imageView2 = (ImageView) _$_findCachedViewById(C4761R.C4764id.player_go_back);
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$FullScreenPlayer$-Kd1Cu2VJXoAIXotSKsZEao7OkA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FullScreenPlayer.m8693onViewCreated$lambda41(FullScreenPlayer.this, view2);
                }
            });
        }
        MaterialButton materialButton10 = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.player_sources_btt);
        if (materialButton10 != null) {
            materialButton10.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$FullScreenPlayer$5PJMQYrNCp3pqXqchMYiuKagrSM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FullScreenPlayer.m8694onViewCreated$lambda42(FullScreenPlayer.this, view2);
                }
            });
        }
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_intro_play);
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$FullScreenPlayer$KJGmE-yACQ-YB7ZY6a5Tc5cR5j8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FullScreenPlayer.m8695onViewCreated$lambda43(FullScreenPlayer.this, view2);
                }
            });
        }
        FrameLayout frameLayout2 = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_holder);
        if (frameLayout2 != null) {
            frameLayout2.setOnTouchListener(new View.OnTouchListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$FullScreenPlayer$_Kd-RTFixOohT8tE5bav6XrqtSI
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    boolean m8696onViewCreated$lambda44;
                    m8696onViewCreated$lambda44 = FullScreenPlayer.m8696onViewCreated$lambda44(FullScreenPlayer.this, view2, motionEvent);
                    return m8696onViewCreated$lambda44;
                }
            });
        }
        DefaultTimeBar defaultTimeBar = (DefaultTimeBar) _$_findCachedViewById(C4761R.C4764id.exo_progress);
        if (defaultTimeBar != null) {
            defaultTimeBar.setOnTouchListener(new View.OnTouchListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$FullScreenPlayer$A0PGtbjGTJOOblTAXwu4O3mwktQ
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    boolean m8697onViewCreated$lambda45;
                    m8697onViewCreated$lambda45 = FullScreenPlayer.m8697onViewCreated$lambda45(FullScreenPlayer.this, view2, motionEvent);
                    return m8697onViewCreated$lambda45;
                }
            });
        }
        try {
            uiReset();
        } catch (Exception e2) {
            ArchComponentExt.logError(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-32  reason: not valid java name */
    public static final void m8684onViewCreated$lambda32(FullScreenPlayer this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.autoHide();
        this$0.getPlayer().handleEvent(CSPlayerEvent.PlayPauseToggle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-33  reason: not valid java name */
    public static final void m8685onViewCreated$lambda33(FullScreenPlayer this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.autoHide();
        this$0.nextResize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-34  reason: not valid java name */
    public static final void m8686onViewCreated$lambda34(FullScreenPlayer this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.autoHide();
        this$0.showSpeedDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-35  reason: not valid java name */
    public static final void m8687onViewCreated$lambda35(FullScreenPlayer this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.autoHide();
        this$0.skipOp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-36  reason: not valid java name */
    public static final void m8688onViewCreated$lambda36(FullScreenPlayer this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.autoHide();
        this$0.getPlayer().handleEvent(CSPlayerEvent.NextEpisode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-37  reason: not valid java name */
    public static final void m8689onViewCreated$lambda37(FullScreenPlayer this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.autoHide();
        this$0.toggleLock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-38  reason: not valid java name */
    public static final void m8690onViewCreated$lambda38(FullScreenPlayer this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showSubtitleOffsetDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-39  reason: not valid java name */
    public static final void m8691onViewCreated$lambda39(FullScreenPlayer this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.autoHide();
        this$0.rewind();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-40  reason: not valid java name */
    public static final void m8692onViewCreated$lambda40(FullScreenPlayer this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.autoHide();
        this$0.fastForward();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-41  reason: not valid java name */
    public static final void m8693onViewCreated$lambda41(FullScreenPlayer this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            UIHelper.INSTANCE.popCurrentPage(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-42  reason: not valid java name */
    public static final void m8694onViewCreated$lambda42(FullScreenPlayer this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showMirrorsDialogue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-43  reason: not valid java name */
    public static final void m8695onViewCreated$lambda43(FullScreenPlayer this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrameLayout frameLayout = (FrameLayout) this$0._$_findCachedViewById(C4761R.C4764id.player_intro_play);
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        this$0.getPlayer().handleEvent(CSPlayerEvent.Play);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-44  reason: not valid java name */
    public static final boolean m8696onViewCreated$lambda44(FullScreenPlayer this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.handleMotionEvent(view, motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-45  reason: not valid java name */
    public static final boolean m8697onViewCreated$lambda45(FullScreenPlayer this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int action = motionEvent.getAction();
        if (action == 0) {
            this$0.currentTapIndex++;
            return false;
        }
        if (action != 1) {
            if (action == 2) {
                this$0.currentTapIndex++;
                return false;
            } else if (action != 3 && action != 12) {
                return false;
            }
        }
        this$0.autoHide();
        return false;
    }
}
