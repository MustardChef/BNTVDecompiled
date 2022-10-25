package com.discord.panels;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.discord.panels.PanelState;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OverlappingPanelsLayout.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u0011\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0006\b\u0016\u0018\u0000 w2\u00020\u0001:\u0005wxyz{B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020=H\u0002J\u0018\u0010>\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020=H\u0002J\u0006\u0010@\u001a\u00020)J\u0012\u0010@\u001a\u00020)2\b\b\u0002\u0010A\u001a\u00020!H\u0002J\u0018\u0010B\u001a\u00020\u001a2\u0006\u0010C\u001a\u00020\u000e2\u0006\u0010D\u001a\u00020\u000eH\u0002J\b\u0010E\u001a\u00020,H\u0002J\b\u0010F\u001a\u00020\u0017H\u0002J\u0010\u0010G\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u000eH\u0002J\b\u0010I\u001a\u00020,H\u0002J\b\u0010J\u001a\u00020\u0017H\u0002J\u0006\u0010K\u001a\u00020,J\u0018\u0010L\u001a\u00020\u001a2\u0006\u0010C\u001a\u00020\u000e2\u0006\u0010D\u001a\u00020\u000eH\u0002J\u0010\u0010M\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020=H\u0002J\u0018\u0010N\u001a\u00020)2\u0006\u0010C\u001a\u00020\u000e2\u0006\u0010D\u001a\u00020\u000eH\u0002J\u000e\u0010O\u001a\u00020)2\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010P\u001a\u00020)H\u0002J\u000e\u0010Q\u001a\u00020)2\u0006\u00100\u001a\u00020\u001aJ\b\u0010R\u001a\u00020)H\u0002J\b\u0010S\u001a\u00020)H\u0002J\u0012\u0010T\u001a\u00020)2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010U\u001a\u00020!2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010V\u001a\u00020!2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010W\u001a\u00020!2\u0006\u0010<\u001a\u00020=H\u0016J0\u0010X\u001a\u00020)2\u0006\u0010Y\u001a\u00020!2\u0006\u0010Z\u001a\u00020\t2\u0006\u0010[\u001a\u00020\t2\u0006\u0010\\\u001a\u00020\t2\u0006\u0010]\u001a\u00020\tH\u0014J\u0010\u0010^\u001a\u00020!2\u0006\u0010<\u001a\u00020=H\u0016J\u0006\u0010_\u001a\u00020)J\u0012\u0010_\u001a\u00020)2\b\b\u0002\u0010A\u001a\u00020!H\u0002J\u0010\u0010`\u001a\u00020)2\u0006\u0010a\u001a\u00020,H\u0002J\u0006\u0010b\u001a\u00020)J\u0012\u0010b\u001a\u00020)2\b\b\u0002\u0010A\u001a\u00020!H\u0002J\u001f\u0010c\u001a\u00020)2\u0012\u0010d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0e\"\u00020\u001d¢\u0006\u0002\u0010fJ\u001f\u0010g\u001a\u00020)2\u0012\u0010d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0e\"\u00020\u001d¢\u0006\u0002\u0010fJ\b\u0010h\u001a\u00020)H\u0002J\b\u0010i\u001a\u00020)H\u0002J\u0014\u0010j\u001a\u00020)2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u000e\u0010k\u001a\u00020)2\u0006\u0010l\u001a\u00020\u0017J\u000e\u0010m\u001a\u00020)2\u0006\u0010l\u001a\u00020\u0017J\u000e\u0010n\u001a\u00020)2\u0006\u0010o\u001a\u00020!J\u0010\u0010p\u001a\u00020!2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010q\u001a\u00020)2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010r\u001a\u00020)2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010s\u001a\u00020)2\u0006\u0010D\u001a\u00020\u000eH\u0002J$\u0010t\u001a\u00020)2\u0006\u0010D\u001a\u00020\u000e2\b\b\u0002\u0010A\u001a\u00020!2\b\b\u0002\u0010u\u001a\u00020vH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006|"}, m107d2 = {"Lcom/discord/panels/OverlappingPanelsLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "centerPanel", "Landroid/view/View;", "centerPanelAnimationEndX", "", "centerPanelDiffX", "centerPanelXAnimator", "Landroid/animation/ValueAnimator;", "childGestureRegions", "", "Landroid/graphics/Rect;", "endPanel", "endPanelLockState", "Lcom/discord/panels/OverlappingPanelsLayout$LockState;", "endPanelOpenedCenterPanelX", "endPanelState", "Lcom/discord/panels/PanelState;", "endPanelStateListeners", "Ljava/util/ArrayList;", "Lcom/discord/panels/OverlappingPanelsLayout$PanelStateListener;", "Lkotlin/collections/ArrayList;", "homeGestureFromBottomThreshold", "isHomeSystemGesture", "", "isLeftToRight", "isScrollingHorizontally", "isSystemGestureNavigationPossible", "minFlingPxPerSecond", "nonFullScreenSidePanelWidth", "pendingUpdate", "Lkotlin/Function0;", "", "scrollingSlopPx", "selectedPanel", "Lcom/discord/panels/OverlappingPanelsLayout$Panel;", "startPanel", "startPanelLockState", "startPanelOpenedCenterPanelX", "startPanelState", "startPanelStateListeners", "swipeDirection", "Lcom/discord/panels/OverlappingPanelsLayout$SwipeDirection;", "useFullWidthForStartPanel", "velocityTracker", "Landroid/view/VelocityTracker;", "wasActionDownOnClosedCenterPanel", "xFromInterceptActionDown", "yFromInterceptActionDown", "calculateDistanceX", "startX", "event", "Landroid/view/MotionEvent;", "calculateDistanceY", "startY", "closePanels", "isFling", "getEndPanelState", "previousX", "x", "getLeftPanel", "getLeftPanelLockState", "getNormalizedX", "targetedX", "getRightPanel", "getRightPanelLockState", "getSelectedPanel", "getStartPanelState", "getTargetedX", "handleCenterPanelX", "handleEndPanelState", "handleEndPanelWidthUpdate", "handleStartPanelState", "handleStartPanelWidthUpdate", "initPanels", "initialize", "isTouchingCenterPanelWhileSidePanelOpen", "isTouchingChildGestureRegion", "onInterceptTouchEvent", "onLayout", "changed", "left", ViewHierarchyConstants.DIMENSION_TOP_KEY, TtmlNode.RIGHT, "bottom", "onTouchEvent", "openEndPanel", "openPanel", "panel", "openStartPanel", "registerEndPanelStateListeners", "panelStateListenerArgs", "", "([Lcom/discord/panels/OverlappingPanelsLayout$PanelStateListener;)V", "registerStartPanelStateListeners", "resetEndPanelWidth", "resetStartPanelWidth", "setChildGestureRegions", "setEndPanelLockState", "lockState", "setStartPanelLockState", "setStartPanelUseFullPortraitWidth", "useFullPortraitWidth", "shouldHandleActionMoveEvent", "snapOpenOrClose", "translateCenterPanel", "updateCenterPanelX", "updateCenterPanelXWithAnimation", "animationDurationMs", "", "Companion", "LockState", "Panel", "PanelStateListener", "SwipeDirection", "overlapping_panels_release"}, m106k = 1, m105mv = {1, 1, 16})
/* loaded from: classes.dex */
public class OverlappingPanelsLayout extends FrameLayout {
    public static final Companion Companion = new Companion(null);
    private static final long SIDE_PANEL_CLOSE_DURATION_MS = 200;
    private static final long SIDE_PANEL_OPEN_DURATION_MS = 250;
    private HashMap _$_findViewCache;
    private View centerPanel;
    private float centerPanelAnimationEndX;
    private float centerPanelDiffX;
    private ValueAnimator centerPanelXAnimator;
    private List<Rect> childGestureRegions;
    private View endPanel;
    private LockState endPanelLockState;
    private float endPanelOpenedCenterPanelX;
    private PanelState endPanelState;
    private final ArrayList<PanelStateListener> endPanelStateListeners;
    private float homeGestureFromBottomThreshold;
    private boolean isHomeSystemGesture;
    private boolean isLeftToRight;
    private boolean isScrollingHorizontally;
    private final boolean isSystemGestureNavigationPossible;
    private float minFlingPxPerSecond;
    private int nonFullScreenSidePanelWidth;
    private Functions<Unit> pendingUpdate;
    private float scrollingSlopPx;
    private Panel selectedPanel;
    private View startPanel;
    private LockState startPanelLockState;
    private float startPanelOpenedCenterPanelX;
    private PanelState startPanelState;
    private final ArrayList<PanelStateListener> startPanelStateListeners;
    private SwipeDirection swipeDirection;
    private boolean useFullWidthForStartPanel;
    private VelocityTracker velocityTracker;
    private boolean wasActionDownOnClosedCenterPanel;
    private float xFromInterceptActionDown;
    private float yFromInterceptActionDown;

    /* compiled from: OverlappingPanelsLayout.kt */
    @Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m107d2 = {"Lcom/discord/panels/OverlappingPanelsLayout$LockState;", "", "(Ljava/lang/String;I)V", "OPEN", "CLOSE", "UNLOCKED", "overlapping_panels_release"}, m106k = 1, m105mv = {1, 1, 16})
    /* loaded from: classes.dex */
    public enum LockState {
        OPEN,
        CLOSE,
        UNLOCKED
    }

    /* compiled from: OverlappingPanelsLayout.kt */
    @Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m107d2 = {"Lcom/discord/panels/OverlappingPanelsLayout$Panel;", "", "(Ljava/lang/String;I)V", "START", "CENTER", "END", "overlapping_panels_release"}, m106k = 1, m105mv = {1, 1, 16})
    /* loaded from: classes.dex */
    public enum Panel {
        START,
        CENTER,
        END
    }

    /* compiled from: OverlappingPanelsLayout.kt */
    @Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m107d2 = {"Lcom/discord/panels/OverlappingPanelsLayout$PanelStateListener;", "", "onPanelStateChange", "", "panelState", "Lcom/discord/panels/PanelState;", "overlapping_panels_release"}, m106k = 1, m105mv = {1, 1, 16})
    /* loaded from: classes.dex */
    public interface PanelStateListener {
        void onPanelStateChange(PanelState panelState);
    }

    /* compiled from: OverlappingPanelsLayout.kt */
    @Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m107d2 = {"Lcom/discord/panels/OverlappingPanelsLayout$SwipeDirection;", "", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "overlapping_panels_release"}, m106k = 1, m105mv = {1, 1, 16})
    /* loaded from: classes.dex */
    public enum SwipeDirection {
        LEFT,
        RIGHT
    }

    @Metadata(m109bv = {1, 0, 3}, m106k = 3, m105mv = {1, 1, 16})
    /* loaded from: classes.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Panel.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Panel.START.ordinal()] = 1;
            iArr[Panel.END.ordinal()] = 2;
            iArr[Panel.CENTER.ordinal()] = 3;
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    public static final /* synthetic */ View access$getCenterPanel$p(OverlappingPanelsLayout overlappingPanelsLayout) {
        View view = overlappingPanelsLayout.centerPanel;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerPanel");
        }
        return view;
    }

    public static final /* synthetic */ View access$getStartPanel$p(OverlappingPanelsLayout overlappingPanelsLayout) {
        View view = overlappingPanelsLayout.startPanel;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startPanel");
        }
        return view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlappingPanelsLayout(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.isLeftToRight = true;
        this.startPanelOpenedCenterPanelX = FloatCompanionObject.INSTANCE.getMIN_VALUE();
        this.endPanelOpenedCenterPanelX = FloatCompanionObject.INSTANCE.getMAX_VALUE();
        this.startPanelStateListeners = new ArrayList<>();
        this.endPanelStateListeners = new ArrayList<>();
        this.selectedPanel = Panel.CENTER;
        this.startPanelLockState = LockState.UNLOCKED;
        this.endPanelLockState = LockState.UNLOCKED;
        this.startPanelState = PanelState.Closed.INSTANCE;
        this.endPanelState = PanelState.Closed.INSTANCE;
        this.childGestureRegions = CollectionsKt.emptyList();
        this.isSystemGestureNavigationPossible = Build.VERSION.SDK_INT >= 29;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlappingPanelsLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.isLeftToRight = true;
        this.startPanelOpenedCenterPanelX = FloatCompanionObject.INSTANCE.getMIN_VALUE();
        this.endPanelOpenedCenterPanelX = FloatCompanionObject.INSTANCE.getMAX_VALUE();
        this.startPanelStateListeners = new ArrayList<>();
        this.endPanelStateListeners = new ArrayList<>();
        this.selectedPanel = Panel.CENTER;
        this.startPanelLockState = LockState.UNLOCKED;
        this.endPanelLockState = LockState.UNLOCKED;
        this.startPanelState = PanelState.Closed.INSTANCE;
        this.endPanelState = PanelState.Closed.INSTANCE;
        this.childGestureRegions = CollectionsKt.emptyList();
        this.isSystemGestureNavigationPossible = Build.VERSION.SDK_INT >= 29;
        initialize(attributeSet);
    }

    public /* synthetic */ OverlappingPanelsLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlappingPanelsLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.isLeftToRight = true;
        this.startPanelOpenedCenterPanelX = FloatCompanionObject.INSTANCE.getMIN_VALUE();
        this.endPanelOpenedCenterPanelX = FloatCompanionObject.INSTANCE.getMAX_VALUE();
        this.startPanelStateListeners = new ArrayList<>();
        this.endPanelStateListeners = new ArrayList<>();
        this.selectedPanel = Panel.CENTER;
        this.startPanelLockState = LockState.UNLOCKED;
        this.endPanelLockState = LockState.UNLOCKED;
        this.startPanelState = PanelState.Closed.INSTANCE;
        this.endPanelState = PanelState.Closed.INSTANCE;
        this.childGestureRegions = CollectionsKt.emptyList();
        this.isSystemGestureNavigationPossible = Build.VERSION.SDK_INT >= 29;
        initialize(attributeSet);
    }

    public /* synthetic */ OverlappingPanelsLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void initialize(AttributeSet attributeSet) {
        int i;
        LocaleProvider localeProvider = LocaleProvider.INSTANCE;
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        this.isLeftToRight = TextUtils.getLayoutDirectionFromLocale(localeProvider.getPrimaryLocale(context)) == 0;
        this.scrollingSlopPx = getResources().getDimension(C1901R.dimen.overlapping_panels_scroll_slop);
        this.homeGestureFromBottomThreshold = getResources().getDimension(C1901R.dimen.overlapping_panels_home_gesture_from_bottom_threshold);
        this.minFlingPxPerSecond = getResources().getDimension(C1901R.dimen.overlapping_panels_min_fling_dp_per_second);
        Resources resources = getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        if (resources.getConfiguration().orientation == 1) {
            Resources resources2 = getResources();
            Intrinsics.checkExpressionValueIsNotNull(resources2, "resources");
            i = resources2.getDisplayMetrics().widthPixels;
        } else {
            Resources resources3 = getResources();
            Intrinsics.checkExpressionValueIsNotNull(resources3, "resources");
            i = resources3.getDisplayMetrics().heightPixels;
        }
        this.nonFullScreenSidePanelWidth = (int) ((i - getResources().getDimension(C1901R.dimen.overlapping_panels_margin_between_panels)) - getResources().getDimension(C1901R.dimen.overlapping_panels_closed_center_panel_visible_width));
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1901R.styleable.OverlappingPanelsLayout, 0, 0);
        try {
            this.nonFullScreenSidePanelWidth = Math.min(this.nonFullScreenSidePanelWidth, (int) obtainStyledAttributes.getDimension(C1901R.styleable.OverlappingPanelsLayout_maxSidePanelNonFullScreenWidth, Integer.MAX_VALUE));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getChildCount() == 3 && this.centerPanel == null) {
            initPanels();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        int actionMasked = event.getActionMasked();
        boolean z = false;
        if (actionMasked == 0) {
            this.isScrollingHorizontally = false;
            this.wasActionDownOnClosedCenterPanel = isTouchingCenterPanelWhileSidePanelOpen(event);
            View view = this.centerPanel;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("centerPanel");
            }
            this.centerPanelDiffX = view.getX() - event.getRawX();
            this.xFromInterceptActionDown = event.getX();
            float y = event.getY();
            this.yFromInterceptActionDown = y;
            Resources resources = getResources();
            Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
            if (Math.abs(y - resources.getDisplayMetrics().heightPixels) < this.homeGestureFromBottomThreshold && this.isSystemGestureNavigationPossible) {
                z = true;
            }
            this.isHomeSystemGesture = z;
            VelocityTracker velocityTracker = this.velocityTracker;
            if (velocityTracker == null) {
                VelocityTracker obtain = VelocityTracker.obtain();
                this.velocityTracker = obtain;
                if (obtain != null) {
                    obtain.addMovement(event);
                }
            } else if (velocityTracker != null) {
                velocityTracker.clear();
            }
            return this.wasActionDownOnClosedCenterPanel;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (!this.isScrollingHorizontally) {
                    float calculateDistanceX = calculateDistanceX(this.xFromInterceptActionDown, event);
                    float calculateDistanceY = calculateDistanceY(this.yFromInterceptActionDown, event);
                    boolean isTouchingChildGestureRegion = isTouchingChildGestureRegion(event);
                    if (Math.abs(calculateDistanceX) <= this.scrollingSlopPx || Math.abs(calculateDistanceX) <= Math.abs(calculateDistanceY) || isTouchingChildGestureRegion) {
                        return false;
                    }
                    this.isScrollingHorizontally = true;
                }
            } else if (actionMasked != 3) {
                return this.wasActionDownOnClosedCenterPanel;
            }
        }
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.recycle();
        }
        this.velocityTracker = null;
        return this.isScrollingHorizontally || this.wasActionDownOnClosedCenterPanel;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        if (this.isHomeSystemGesture) {
            return false;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        return false;
                    }
                } else if (isTouchingChildGestureRegion(event)) {
                    return false;
                } else {
                    float calculateDistanceX = calculateDistanceX(this.xFromInterceptActionDown, event);
                    if (Math.abs(calculateDistanceX) > this.scrollingSlopPx && this.swipeDirection == null) {
                        this.swipeDirection = calculateDistanceX > ((float) 0) ? SwipeDirection.RIGHT : SwipeDirection.LEFT;
                    }
                    VelocityTracker velocityTracker = this.velocityTracker;
                    if (velocityTracker != null) {
                        velocityTracker.addMovement(event);
                    }
                    if (shouldHandleActionMoveEvent(event)) {
                        translateCenterPanel(event);
                    }
                }
            }
            if (this.wasActionDownOnClosedCenterPanel && Math.abs(event.getX() - this.xFromInterceptActionDown) < this.scrollingSlopPx && !this.isScrollingHorizontally) {
                closePanels();
            } else {
                VelocityTracker velocityTracker2 = this.velocityTracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(event);
                }
                snapOpenOrClose(event);
            }
            this.wasActionDownOnClosedCenterPanel = false;
            this.isScrollingHorizontally = false;
            this.swipeDirection = null;
        }
        return true;
    }

    public final void openStartPanel() {
        openStartPanel(false);
    }

    public final void openEndPanel() {
        openEndPanel(false);
    }

    public final void closePanels() {
        closePanels(false);
    }

    public final void setStartPanelLockState(LockState lockState) {
        Intrinsics.checkParameterIsNotNull(lockState, "lockState");
        this.startPanelLockState = lockState;
        if (lockState == LockState.OPEN) {
            openStartPanel();
        }
    }

    public final void setEndPanelLockState(LockState lockState) {
        Intrinsics.checkParameterIsNotNull(lockState, "lockState");
        this.endPanelLockState = lockState;
        if (lockState == LockState.OPEN) {
            openEndPanel();
        }
    }

    public final void setStartPanelUseFullPortraitWidth(boolean z) {
        this.useFullWidthForStartPanel = z;
        resetStartPanelWidth();
    }

    public final void setChildGestureRegions(List<Rect> childGestureRegions) {
        Intrinsics.checkParameterIsNotNull(childGestureRegions, "childGestureRegions");
        this.childGestureRegions = childGestureRegions;
    }

    public final void registerStartPanelStateListeners(PanelStateListener... panelStateListenerArgs) {
        Intrinsics.checkParameterIsNotNull(panelStateListenerArgs, "panelStateListenerArgs");
        for (PanelStateListener panelStateListener : panelStateListenerArgs) {
            this.startPanelStateListeners.add(panelStateListener);
        }
    }

    public final void registerEndPanelStateListeners(PanelStateListener... panelStateListenerArgs) {
        Intrinsics.checkParameterIsNotNull(panelStateListenerArgs, "panelStateListenerArgs");
        for (PanelStateListener panelStateListener : panelStateListenerArgs) {
            this.endPanelStateListeners.add(panelStateListener);
        }
    }

    public final Panel getSelectedPanel() {
        return this.selectedPanel;
    }

    public final void handleStartPanelState(PanelState startPanelState) {
        Intrinsics.checkParameterIsNotNull(startPanelState, "startPanelState");
        PanelState panelState = this.startPanelState;
        if (Intrinsics.areEqual(startPanelState, PanelState.Opened.INSTANCE) && (!Intrinsics.areEqual(panelState, PanelState.Opened.INSTANCE))) {
            openStartPanel();
        } else if (Intrinsics.areEqual(startPanelState, PanelState.Closed.INSTANCE) && Intrinsics.areEqual(panelState, PanelState.Opened.INSTANCE)) {
            closePanels();
        }
        this.startPanelState = startPanelState;
    }

    public final void handleEndPanelState(PanelState endPanelState) {
        Intrinsics.checkParameterIsNotNull(endPanelState, "endPanelState");
        PanelState panelState = this.endPanelState;
        if (Intrinsics.areEqual(endPanelState, PanelState.Opened.INSTANCE) && (!Intrinsics.areEqual(panelState, PanelState.Opened.INSTANCE))) {
            openEndPanel();
        } else if ((endPanelState instanceof PanelState.Closed) && Intrinsics.areEqual(panelState, PanelState.Opened.INSTANCE)) {
            closePanels();
        }
        this.endPanelState = endPanelState;
    }

    private final void resetStartPanelWidth() {
        if (this.startPanel != null) {
            View view = this.startPanel;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startPanel");
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = this.useFullWidthForStartPanel ? -1 : this.nonFullScreenSidePanelWidth;
            View view2 = this.startPanel;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startPanel");
            }
            view2.setLayoutParams(layoutParams);
        }
    }

    private final void resetEndPanelWidth() {
        View view = this.endPanel;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endPanel");
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = this.nonFullScreenSidePanelWidth;
        View view2 = this.endPanel;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endPanel");
        }
        view2.setLayoutParams(layoutParams);
    }

    private final void openPanel(Panel panel) {
        int i = WhenMappings.$EnumSwitchMapping$0[panel.ordinal()];
        if (i == 1) {
            openStartPanel(false);
        } else if (i == 2) {
            openEndPanel(false);
        } else if (i != 3) {
        } else {
            closePanels(false);
        }
    }

    static /* synthetic */ void openStartPanel$default(OverlappingPanelsLayout overlappingPanelsLayout, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openStartPanel");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        overlappingPanelsLayout.openStartPanel(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openStartPanel(boolean z) {
        if (this.centerPanel == null) {
            this.pendingUpdate = new OverlappingPanelsLayout$openStartPanel$2(this, z);
        } else if (this.startPanelLockState == LockState.OPEN) {
            updateCenterPanelX(this.startPanelOpenedCenterPanelX);
        } else {
            updateCenterPanelXWithAnimation(this.startPanelOpenedCenterPanelX, z, SIDE_PANEL_OPEN_DURATION_MS);
        }
    }

    static /* synthetic */ void openEndPanel$default(OverlappingPanelsLayout overlappingPanelsLayout, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openEndPanel");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        overlappingPanelsLayout.openEndPanel(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openEndPanel(boolean z) {
        if (this.centerPanel == null) {
            this.pendingUpdate = new OverlappingPanelsLayout$openEndPanel$2(this, z);
        } else {
            updateCenterPanelXWithAnimation(this.endPanelOpenedCenterPanelX, z, SIDE_PANEL_OPEN_DURATION_MS);
        }
    }

    static /* synthetic */ void closePanels$default(OverlappingPanelsLayout overlappingPanelsLayout, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: closePanels");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        overlappingPanelsLayout.closePanels(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closePanels(boolean z) {
        if (this.centerPanel == null) {
            this.pendingUpdate = new OverlappingPanelsLayout$closePanels$2(this, z);
        } else {
            updateCenterPanelXWithAnimation(0.0f, z, 200L);
        }
    }

    private final void snapOpenOrClose(MotionEvent motionEvent) {
        float targetedX = getTargetedX(motionEvent);
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.computeCurrentVelocity(1000);
        }
        VelocityTracker velocityTracker2 = this.velocityTracker;
        float xVelocity = velocityTracker2 != null ? velocityTracker2.getXVelocity() : FloatCompanionObject.INSTANCE.getMIN_VALUE();
        boolean z = false;
        boolean z2 = Math.abs(xVelocity) > this.minFlingPxPerSecond;
        if (!this.isLeftToRight ? xVelocity < 0 : xVelocity > 0) {
            z = true;
        }
        if (z2) {
            if (z) {
                if (this.selectedPanel == Panel.END) {
                    closePanels(true);
                    return;
                } else if (this.selectedPanel == Panel.CENTER) {
                    openStartPanel(true);
                    return;
                }
            } else if (this.selectedPanel == Panel.START) {
                closePanels(true);
                return;
            } else if (this.selectedPanel == Panel.CENTER) {
                openEndPanel(true);
                return;
            }
        }
        float max = Math.max(this.startPanelOpenedCenterPanelX, this.endPanelOpenedCenterPanelX);
        float min = Math.min(this.startPanelOpenedCenterPanelX, this.endPanelOpenedCenterPanelX);
        float f = 2;
        if (targetedX > max / f) {
            openPanel(getLeftPanel());
        } else if (targetedX < min / f) {
            openPanel(getRightPanel());
        } else {
            closePanels();
        }
    }

    private final Panel getLeftPanel() {
        return this.isLeftToRight ? Panel.START : Panel.END;
    }

    private final Panel getRightPanel() {
        return this.isLeftToRight ? Panel.END : Panel.START;
    }

    private final LockState getLeftPanelLockState() {
        return this.isLeftToRight ? this.startPanelLockState : this.endPanelLockState;
    }

    private final LockState getRightPanelLockState() {
        return this.isLeftToRight ? this.endPanelLockState : this.startPanelLockState;
    }

    private final void translateCenterPanel(MotionEvent motionEvent) {
        updateCenterPanelX(getNormalizedX(getTargetedX(motionEvent)));
    }

    private final float getNormalizedX(float f) {
        if (this.startPanelLockState == LockState.OPEN) {
            return this.startPanelOpenedCenterPanelX;
        }
        if (this.endPanelLockState == LockState.OPEN) {
            return this.endPanelOpenedCenterPanelX;
        }
        float f2 = 0.0f;
        float max = (getLeftPanelLockState() == LockState.CLOSE || (this.selectedPanel == Panel.CENTER && this.swipeDirection == SwipeDirection.LEFT)) ? 0.0f : Math.max(this.startPanelOpenedCenterPanelX, this.endPanelOpenedCenterPanelX);
        if (getRightPanelLockState() != LockState.CLOSE && (this.selectedPanel != Panel.CENTER || this.swipeDirection != SwipeDirection.RIGHT)) {
            f2 = Math.min(this.startPanelOpenedCenterPanelX, this.endPanelOpenedCenterPanelX);
        }
        return f > max ? max : f < f2 ? f2 : f;
    }

    private final boolean shouldHandleActionMoveEvent(MotionEvent motionEvent) {
        float normalizedX = getNormalizedX(getTargetedX(motionEvent));
        View view = this.centerPanel;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerPanel");
        }
        float abs = Math.abs(normalizedX - view.getX());
        Resources resources = getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return normalizedX == 0.0f || normalizedX == this.startPanelOpenedCenterPanelX || normalizedX == this.endPanelOpenedCenterPanelX || ((abs > resources.getDisplayMetrics().density ? 1 : (abs == resources.getDisplayMetrics().density ? 0 : -1)) > 0);
    }

    private final float getTargetedX(MotionEvent motionEvent) {
        return motionEvent.getRawX() + this.centerPanelDiffX;
    }

    private final float calculateDistanceX(float f, MotionEvent motionEvent) {
        return motionEvent.getX() - f;
    }

    private final float calculateDistanceY(float f, MotionEvent motionEvent) {
        return motionEvent.getY() - f;
    }

    static /* synthetic */ void updateCenterPanelXWithAnimation$default(OverlappingPanelsLayout overlappingPanelsLayout, float f, boolean z, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateCenterPanelXWithAnimation");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            j = SIDE_PANEL_OPEN_DURATION_MS;
        }
        overlappingPanelsLayout.updateCenterPanelXWithAnimation(f, z, j);
    }

    private final void updateCenterPanelXWithAnimation(float f, boolean z, long j) {
        View view = this.centerPanel;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerPanel");
        }
        float x = view.getX();
        ValueAnimator valueAnimator = this.centerPanelXAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        float normalizedX = getNormalizedX(f);
        this.centerPanelAnimationEndX = normalizedX;
        if (z) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(x, normalizedX);
            ofFloat.setInterpolator(new LinearOutSlowInInterpolator());
            ofFloat.setDuration(j);
            this.centerPanelXAnimator = ofFloat;
            if (ofFloat != null) {
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.discord.panels.OverlappingPanelsLayout$updateCenterPanelXWithAnimation$2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator animator) {
                        OverlappingPanelsLayout overlappingPanelsLayout = OverlappingPanelsLayout.this;
                        Intrinsics.checkExpressionValueIsNotNull(animator, "animator");
                        Object animatedValue = animator.getAnimatedValue();
                        if (animatedValue == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
                        }
                        overlappingPanelsLayout.updateCenterPanelX(((Float) animatedValue).floatValue());
                    }
                });
            }
        } else {
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(x, normalizedX);
            ofFloat2.setInterpolator(new FastOutSlowInInterpolator());
            ofFloat2.setDuration(j);
            this.centerPanelXAnimator = ofFloat2;
            if (ofFloat2 != null) {
                ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.discord.panels.OverlappingPanelsLayout$updateCenterPanelXWithAnimation$4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator animator) {
                        OverlappingPanelsLayout overlappingPanelsLayout = OverlappingPanelsLayout.this;
                        Intrinsics.checkExpressionValueIsNotNull(animator, "animator");
                        Object animatedValue = animator.getAnimatedValue();
                        if (animatedValue == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
                        }
                        overlappingPanelsLayout.updateCenterPanelX(((Float) animatedValue).floatValue());
                    }
                });
            }
        }
        ValueAnimator valueAnimator2 = this.centerPanelXAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCenterPanelX(float f) {
        View view = this.centerPanel;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerPanel");
        }
        float x = view.getX();
        View view2 = this.centerPanel;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerPanel");
        }
        view2.setX(f);
        handleCenterPanelX(x, f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
        if (r1.getX() <= 0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
        if (r1.getX() < 0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
        if (r1.getX() >= 0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006b, code lost:
        if (r1.getX() > 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006d, code lost:
        r1 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void handleCenterPanelX(float r11, float r12) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.discord.panels.OverlappingPanelsLayout.handleCenterPanelX(float, float):void");
    }

    private final PanelState getStartPanelState(float f, float f2) {
        boolean z = this.isLeftToRight;
        if (!z || f2 > 0.0f) {
            if (!z && f2 >= 0.0f) {
                return PanelState.Closed.INSTANCE;
            }
            if (f2 == this.startPanelOpenedCenterPanelX) {
                return PanelState.Opened.INSTANCE;
            }
            if (!z || f2 <= f) {
                if (!z && f2 < f) {
                    return PanelState.Opening.INSTANCE;
                }
                return PanelState.Closing.INSTANCE;
            }
            return PanelState.Opening.INSTANCE;
        }
        return PanelState.Closed.INSTANCE;
    }

    private final PanelState getEndPanelState(float f, float f2) {
        boolean z = this.isLeftToRight;
        if (!z || f2 < 0.0f) {
            if (!z && f2 <= 0.0f) {
                return PanelState.Closed.INSTANCE;
            }
            if (f2 == this.endPanelOpenedCenterPanelX) {
                return PanelState.Opened.INSTANCE;
            }
            if (!z || f2 >= f) {
                if (!z && f2 > f) {
                    return PanelState.Opening.INSTANCE;
                }
                return PanelState.Closing.INSTANCE;
            }
            return PanelState.Opening.INSTANCE;
        }
        return PanelState.Closed.INSTANCE;
    }

    private final void initPanels() {
        View childAt = getChildAt(0);
        Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(0)");
        this.startPanel = childAt;
        View childAt2 = getChildAt(1);
        Intrinsics.checkExpressionValueIsNotNull(childAt2, "getChildAt(1)");
        this.centerPanel = childAt2;
        View childAt3 = getChildAt(2);
        Intrinsics.checkExpressionValueIsNotNull(childAt3, "getChildAt(2)");
        this.endPanel = childAt3;
        View view = this.startPanel;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startPanel");
        }
        view.setVisibility(4);
        View view2 = this.startPanel;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startPanel");
        }
        view2.setElevation(0.0f);
        View view3 = this.centerPanel;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerPanel");
        }
        view3.setVisibility(0);
        View view4 = this.centerPanel;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerPanel");
        }
        view4.setElevation(0.0f);
        View view5 = this.endPanel;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endPanel");
        }
        view5.setVisibility(4);
        View view6 = this.endPanel;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endPanel");
        }
        view6.setElevation(0.0f);
        resetStartPanelWidth();
        resetEndPanelWidth();
        handleStartPanelWidthUpdate();
        handleEndPanelWidthUpdate();
        Functions<Unit> functions = this.pendingUpdate;
        if (functions != null) {
            functions.invoke();
        }
        this.pendingUpdate = null;
        View view7 = this.startPanel;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startPanel");
        }
        view7.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.discord.panels.OverlappingPanelsLayout$initPanels$1
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view8, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                boolean z;
                boolean z2;
                z = OverlappingPanelsLayout.this.isLeftToRight;
                if (!z || i3 == i7) {
                    z2 = OverlappingPanelsLayout.this.isLeftToRight;
                    if (z2 || i == i5) {
                        return;
                    }
                    OverlappingPanelsLayout.this.handleStartPanelWidthUpdate();
                    return;
                }
                OverlappingPanelsLayout.this.handleStartPanelWidthUpdate();
            }
        });
        View view8 = this.endPanel;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endPanel");
        }
        view8.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.discord.panels.OverlappingPanelsLayout$initPanels$2
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view9, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                boolean z;
                boolean z2;
                z = OverlappingPanelsLayout.this.isLeftToRight;
                if (!z || i == i5) {
                    z2 = OverlappingPanelsLayout.this.isLeftToRight;
                    if (z2 || i3 == i7) {
                        return;
                    }
                    OverlappingPanelsLayout.this.handleEndPanelWidthUpdate();
                    return;
                }
                OverlappingPanelsLayout.this.handleEndPanelWidthUpdate();
            }
        });
    }

    private final boolean isTouchingCenterPanelWhileSidePanelOpen(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        View view = this.centerPanel;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerPanel");
        }
        float x2 = view.getX();
        float max = Math.max(this.startPanelOpenedCenterPanelX, this.endPanelOpenedCenterPanelX);
        float min = Math.min(this.startPanelOpenedCenterPanelX, this.endPanelOpenedCenterPanelX);
        View view2 = this.centerPanel;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerPanel");
        }
        float width = view2.getWidth() + min;
        boolean z = x > max;
        boolean z2 = x < width;
        boolean z3 = x2 == max;
        boolean z4 = x2 == min;
        if (z3 && z) {
            return true;
        }
        return z4 && z2;
    }

    private final boolean isTouchingChildGestureRegion(MotionEvent motionEvent) {
        boolean z;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        Iterator<T> it = this.childGestureRegions.iterator();
        do {
            z = false;
            if (!it.hasNext()) {
                return false;
            }
            Rect rect = (Rect) it.next();
            boolean z2 = rawX >= ((float) rect.left) && rawX <= ((float) rect.right);
            boolean z3 = rawY <= ((float) rect.bottom) && rawY >= ((float) rect.top);
            if (z2 && z3) {
                z = true;
                continue;
            }
        } while (!z);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleStartPanelWidthUpdate() {
        float f = this.startPanelOpenedCenterPanelX;
        float dimension = getResources().getDimension(C1901R.dimen.overlapping_panels_margin_between_panels);
        View view = this.startPanel;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startPanel");
        }
        float width = view.getWidth() + dimension;
        this.startPanelOpenedCenterPanelX = width;
        if (!this.isLeftToRight) {
            width = -width;
        }
        this.startPanelOpenedCenterPanelX = width;
        View view2 = this.centerPanel;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerPanel");
        }
        if (view2.getX() == f || this.centerPanelAnimationEndX == f) {
            openStartPanel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleEndPanelWidthUpdate() {
        float f = this.endPanelOpenedCenterPanelX;
        float dimension = getResources().getDimension(C1901R.dimen.overlapping_panels_margin_between_panels);
        View view = this.endPanel;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endPanel");
        }
        float f2 = -(view.getWidth() + dimension);
        this.endPanelOpenedCenterPanelX = f2;
        if (!this.isLeftToRight) {
            f2 = -f2;
        }
        this.endPanelOpenedCenterPanelX = f2;
        View view2 = this.centerPanel;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerPanel");
        }
        if (view2.getX() == f || this.centerPanelAnimationEndX == f) {
            openEndPanel();
        }
    }

    /* compiled from: OverlappingPanelsLayout.kt */
    @Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m107d2 = {"Lcom/discord/panels/OverlappingPanelsLayout$Companion;", "", "()V", "SIDE_PANEL_CLOSE_DURATION_MS", "", "SIDE_PANEL_OPEN_DURATION_MS", "overlapping_panels_release"}, m106k = 1, m105mv = {1, 1, 16})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
