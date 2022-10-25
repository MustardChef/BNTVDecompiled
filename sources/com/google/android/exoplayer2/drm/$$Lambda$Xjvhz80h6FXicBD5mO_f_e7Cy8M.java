package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.util.Consumer;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.drm.-$$Lambda$Xjvhz80h6FXicBD5mO_f_e7Cy8M  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$Xjvhz80h6FXicBD5mO_f_e7Cy8M implements Consumer {
    public static final /* synthetic */ $$Lambda$Xjvhz80h6FXicBD5mO_f_e7Cy8M INSTANCE = new $$Lambda$Xjvhz80h6FXicBD5mO_f_e7Cy8M();

    private /* synthetic */ $$Lambda$Xjvhz80h6FXicBD5mO_f_e7Cy8M() {
    }

    @Override // com.google.android.exoplayer2.util.Consumer
    public final void accept(Object obj) {
        ((DrmSessionEventListener.EventDispatcher) obj).drmKeysLoaded();
    }
}
