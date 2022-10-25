package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.util.Consumer;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.drm.-$$Lambda$bKbtDH-u_QKCKrOHwO53RHdbHaY  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$bKbtDHu_QKCKrOHwO53RHdbHaY implements Consumer {
    public static final /* synthetic */ $$Lambda$bKbtDHu_QKCKrOHwO53RHdbHaY INSTANCE = new $$Lambda$bKbtDHu_QKCKrOHwO53RHdbHaY();

    private /* synthetic */ $$Lambda$bKbtDHu_QKCKrOHwO53RHdbHaY() {
    }

    @Override // com.google.android.exoplayer2.util.Consumer
    public final void accept(Object obj) {
        ((DrmSessionEventListener.EventDispatcher) obj).drmKeysRestored();
    }
}
