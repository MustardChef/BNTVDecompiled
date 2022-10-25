package com.discord.panels;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PanelsChildGestureRegionObserver.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001:\u0002 !B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0007JP\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\rH\u0002J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\bH\u0007J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0007J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, m107d2 = {"Lcom/discord/panels/PanelsChildGestureRegionObserver;", "Landroid/view/View$OnLayoutChangeListener;", "()V", "gestureRegionsListeners", "", "Lcom/discord/panels/PanelsChildGestureRegionObserver$GestureRegionsListener;", "viewIdToGestureRegionMap", "", "", "Landroid/graphics/Rect;", "viewIdToListenerMap", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "addGestureRegionsUpdateListener", "", "gestureRegionsListener", "onLayoutChange", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "left", ViewHierarchyConstants.DIMENSION_TOP_KEY, TtmlNode.RIGHT, "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "publishGestureRegionsUpdate", "register", "remove", "viewId", "removeGestureRegionsUpdateListener", "unregister", "GestureRegionsListener", "Provider", "overlapping_panels_release"}, m106k = 1, m105mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class PanelsChildGestureRegionObserver implements View.OnLayoutChangeListener {
    private final Map<Integer, Rect> viewIdToGestureRegionMap = new LinkedHashMap();
    private final Map<Integer, ViewTreeObserver.OnScrollChangedListener> viewIdToListenerMap = new LinkedHashMap();
    private final Set<GestureRegionsListener> gestureRegionsListeners = new LinkedHashSet();

    /* compiled from: PanelsChildGestureRegionObserver.kt */
    @Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, m107d2 = {"Lcom/discord/panels/PanelsChildGestureRegionObserver$GestureRegionsListener;", "", "onGestureRegionsUpdate", "", "gestureRegions", "", "Landroid/graphics/Rect;", "overlapping_panels_release"}, m106k = 1, m105mv = {1, 1, 16})
    /* loaded from: classes.dex */
    public interface GestureRegionsListener {
        void onGestureRegionsUpdate(List<Rect> list);
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i9 = iArr[0];
        int i10 = iArr[1];
        this.viewIdToGestureRegionMap.put(Integer.valueOf(view.getId()), new Rect(i9, i10, i3 + i9, i4 + i10));
        publishGestureRegionsUpdate();
    }

    public final void register(final View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        view.addOnLayoutChangeListener(this);
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.discord.panels.PanelsChildGestureRegionObserver$register$listener$1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                PanelsChildGestureRegionObserver panelsChildGestureRegionObserver = PanelsChildGestureRegionObserver.this;
                View view2 = view;
                panelsChildGestureRegionObserver.onLayoutChange(view2, view2.getLeft(), view.getTop(), view.getRight(), view.getBottom(), 0, 0, 0, 0);
            }
        };
        view.getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
        this.viewIdToListenerMap.put(Integer.valueOf(view.getId()), onScrollChangedListener);
    }

    @Deprecated(message = "Use unregister instead", replaceWith = @ReplaceWith(expression = "unregister(view)", imports = {}))
    public final void remove(int i) {
        this.viewIdToGestureRegionMap.remove(Integer.valueOf(i));
        publishGestureRegionsUpdate();
    }

    public final void unregister(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        ViewTreeObserver.OnScrollChangedListener remove = this.viewIdToListenerMap.remove(Integer.valueOf(view.getId()));
        if (remove != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(remove);
        }
        view.removeOnLayoutChangeListener(this);
        this.viewIdToGestureRegionMap.remove(Integer.valueOf(view.getId()));
        publishGestureRegionsUpdate();
    }

    public final void addGestureRegionsUpdateListener(GestureRegionsListener gestureRegionsListener) {
        Intrinsics.checkParameterIsNotNull(gestureRegionsListener, "gestureRegionsListener");
        gestureRegionsListener.onGestureRegionsUpdate(CollectionsKt.toList(this.viewIdToGestureRegionMap.values()));
        this.gestureRegionsListeners.add(gestureRegionsListener);
    }

    public final void removeGestureRegionsUpdateListener(GestureRegionsListener gestureRegionsListener) {
        Intrinsics.checkParameterIsNotNull(gestureRegionsListener, "gestureRegionsListener");
        this.gestureRegionsListeners.remove(gestureRegionsListener);
    }

    private final void publishGestureRegionsUpdate() {
        List<Rect> list = CollectionsKt.toList(this.viewIdToGestureRegionMap.values());
        for (GestureRegionsListener gestureRegionsListener : this.gestureRegionsListeners) {
            gestureRegionsListener.onGestureRegionsUpdate(list);
        }
    }

    /* compiled from: PanelsChildGestureRegionObserver.kt */
    @Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m107d2 = {"Lcom/discord/panels/PanelsChildGestureRegionObserver$Provider;", "", "()V", "observerWeakRef", "Ljava/lang/ref/WeakReference;", "Lcom/discord/panels/PanelsChildGestureRegionObserver;", "get", "overlapping_panels_release"}, m106k = 1, m105mv = {1, 1, 16})
    /* loaded from: classes.dex */
    public static final class Provider {
        public static final Provider INSTANCE = new Provider();
        private static WeakReference<PanelsChildGestureRegionObserver> observerWeakRef = new WeakReference<>(null);

        private Provider() {
        }

        @JvmStatic
        public static final PanelsChildGestureRegionObserver get() {
            PanelsChildGestureRegionObserver panelsChildGestureRegionObserver = observerWeakRef.get();
            if (panelsChildGestureRegionObserver == null) {
                PanelsChildGestureRegionObserver panelsChildGestureRegionObserver2 = new PanelsChildGestureRegionObserver();
                observerWeakRef = new WeakReference<>(panelsChildGestureRegionObserver2);
                return panelsChildGestureRegionObserver2;
            }
            return panelsChildGestureRegionObserver;
        }
    }
}
