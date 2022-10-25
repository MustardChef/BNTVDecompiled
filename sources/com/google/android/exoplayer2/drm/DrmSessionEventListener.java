package com.google.android.exoplayer2.drm;

import android.os.Handler;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public interface DrmSessionEventListener {

    /* renamed from: com.google.android.exoplayer2.drm.DrmSessionEventListener$-CC  reason: invalid class name */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC {
        public static void $default$onDrmKeysLoaded(DrmSessionEventListener drmSessionEventListener, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        }

        public static void $default$onDrmKeysRemoved(DrmSessionEventListener drmSessionEventListener, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        }

        public static void $default$onDrmKeysRestored(DrmSessionEventListener drmSessionEventListener, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        }

        @Deprecated
        public static void $default$onDrmSessionAcquired(DrmSessionEventListener drmSessionEventListener, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        }

        public static void $default$onDrmSessionAcquired(DrmSessionEventListener drmSessionEventListener, int i, MediaSource.MediaPeriodId mediaPeriodId, int i2) {
        }

        public static void $default$onDrmSessionManagerError(DrmSessionEventListener drmSessionEventListener, int i, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
        }

        public static void $default$onDrmSessionReleased(DrmSessionEventListener drmSessionEventListener, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        }
    }

    void onDrmKeysLoaded(int i, MediaSource.MediaPeriodId mediaPeriodId);

    void onDrmKeysRemoved(int i, MediaSource.MediaPeriodId mediaPeriodId);

    void onDrmKeysRestored(int i, MediaSource.MediaPeriodId mediaPeriodId);

    @Deprecated
    void onDrmSessionAcquired(int i, MediaSource.MediaPeriodId mediaPeriodId);

    void onDrmSessionAcquired(int i, MediaSource.MediaPeriodId mediaPeriodId, int i2);

    void onDrmSessionManagerError(int i, MediaSource.MediaPeriodId mediaPeriodId, Exception exc);

    void onDrmSessionReleased(int i, MediaSource.MediaPeriodId mediaPeriodId);

    /* loaded from: classes2.dex */
    public static class EventDispatcher {
        private final CopyOnWriteArrayList<ListenerAndHandler> listenerAndHandlers;
        public final MediaSource.MediaPeriodId mediaPeriodId;
        public final int windowIndex;

        public EventDispatcher() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        private EventDispatcher(CopyOnWriteArrayList<ListenerAndHandler> copyOnWriteArrayList, int i, MediaSource.MediaPeriodId mediaPeriodId) {
            this.listenerAndHandlers = copyOnWriteArrayList;
            this.windowIndex = i;
            this.mediaPeriodId = mediaPeriodId;
        }

        public EventDispatcher withParameters(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            return new EventDispatcher(this.listenerAndHandlers, i, mediaPeriodId);
        }

        public void addEventListener(Handler handler, DrmSessionEventListener drmSessionEventListener) {
            Assertions.checkNotNull(handler);
            Assertions.checkNotNull(drmSessionEventListener);
            this.listenerAndHandlers.add(new ListenerAndHandler(handler, drmSessionEventListener));
        }

        public void removeEventListener(DrmSessionEventListener drmSessionEventListener) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                if (next.listener == drmSessionEventListener) {
                    this.listenerAndHandlers.remove(next);
                }
            }
        }

        public void drmSessionAcquired(final int i) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final DrmSessionEventListener drmSessionEventListener = next.listener;
                Util.postOrRun(next.handler, new Runnable() { // from class: com.google.android.exoplayer2.drm.-$$Lambda$DrmSessionEventListener$EventDispatcher$xLBvWT_5jMYrnZeEFJL0zYPleFg
                    @Override // java.lang.Runnable
                    public final void run() {
                        DrmSessionEventListener.EventDispatcher.this.m405xb124957e(drmSessionEventListener, i);
                    }
                });
            }
        }

        /* renamed from: lambda$drmSessionAcquired$0$DrmSessionEventListener$EventDispatcher */
        public /* synthetic */ void m405xb124957e(DrmSessionEventListener drmSessionEventListener, int i) {
            drmSessionEventListener.onDrmSessionAcquired(this.windowIndex, this.mediaPeriodId);
            drmSessionEventListener.onDrmSessionAcquired(this.windowIndex, this.mediaPeriodId, i);
        }

        public void drmKeysLoaded() {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final DrmSessionEventListener drmSessionEventListener = next.listener;
                Util.postOrRun(next.handler, new Runnable() { // from class: com.google.android.exoplayer2.drm.-$$Lambda$DrmSessionEventListener$EventDispatcher$VS4q-9oF8IRPGvxstW7pqSGMYR4
                    @Override // java.lang.Runnable
                    public final void run() {
                        DrmSessionEventListener.EventDispatcher.this.lambda$drmKeysLoaded$1$DrmSessionEventListener$EventDispatcher(drmSessionEventListener);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$drmKeysLoaded$1$DrmSessionEventListener$EventDispatcher(DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.onDrmKeysLoaded(this.windowIndex, this.mediaPeriodId);
        }

        public void drmSessionManagerError(final Exception exc) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final DrmSessionEventListener drmSessionEventListener = next.listener;
                Util.postOrRun(next.handler, new Runnable() { // from class: com.google.android.exoplayer2.drm.-$$Lambda$DrmSessionEventListener$EventDispatcher$eIlxixoq5EOGzuz7iie-NWOglWE
                    @Override // java.lang.Runnable
                    public final void run() {
                        DrmSessionEventListener.EventDispatcher.this.m404xf6fa3d4d(drmSessionEventListener, exc);
                    }
                });
            }
        }

        /* renamed from: lambda$drmSessionManagerError$2$DrmSessionEventListener$EventDispatcher */
        public /* synthetic */ void m404xf6fa3d4d(DrmSessionEventListener drmSessionEventListener, Exception exc) {
            drmSessionEventListener.onDrmSessionManagerError(this.windowIndex, this.mediaPeriodId, exc);
        }

        public void drmKeysRestored() {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final DrmSessionEventListener drmSessionEventListener = next.listener;
                Util.postOrRun(next.handler, new Runnable() { // from class: com.google.android.exoplayer2.drm.-$$Lambda$DrmSessionEventListener$EventDispatcher$c4cPBl_Z-DrC5MJRv-wOn14Vn00
                    @Override // java.lang.Runnable
                    public final void run() {
                        DrmSessionEventListener.EventDispatcher.this.lambda$drmKeysRestored$3$DrmSessionEventListener$EventDispatcher(drmSessionEventListener);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$drmKeysRestored$3$DrmSessionEventListener$EventDispatcher(DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.onDrmKeysRestored(this.windowIndex, this.mediaPeriodId);
        }

        public void drmKeysRemoved() {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final DrmSessionEventListener drmSessionEventListener = next.listener;
                Util.postOrRun(next.handler, new Runnable() { // from class: com.google.android.exoplayer2.drm.-$$Lambda$DrmSessionEventListener$EventDispatcher$VPDG80VEycbvsI4byl49iBfpehI
                    @Override // java.lang.Runnable
                    public final void run() {
                        DrmSessionEventListener.EventDispatcher.this.lambda$drmKeysRemoved$4$DrmSessionEventListener$EventDispatcher(drmSessionEventListener);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$drmKeysRemoved$4$DrmSessionEventListener$EventDispatcher(DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.onDrmKeysRemoved(this.windowIndex, this.mediaPeriodId);
        }

        public void drmSessionReleased() {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final DrmSessionEventListener drmSessionEventListener = next.listener;
                Util.postOrRun(next.handler, new Runnable() { // from class: com.google.android.exoplayer2.drm.-$$Lambda$DrmSessionEventListener$EventDispatcher$Go5N0OXEIhSEKTymQYW4yGQpa2E
                    @Override // java.lang.Runnable
                    public final void run() {
                        DrmSessionEventListener.EventDispatcher.this.m403xd1e970b2(drmSessionEventListener);
                    }
                });
            }
        }

        /* renamed from: lambda$drmSessionReleased$5$DrmSessionEventListener$EventDispatcher */
        public /* synthetic */ void m403xd1e970b2(DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.onDrmSessionReleased(this.windowIndex, this.mediaPeriodId);
        }

        /* loaded from: classes2.dex */
        private static final class ListenerAndHandler {
            public Handler handler;
            public DrmSessionEventListener listener;

            public ListenerAndHandler(Handler handler, DrmSessionEventListener drmSessionEventListener) {
                this.handler = handler;
                this.listener = drmSessionEventListener;
            }
        }
    }
}
