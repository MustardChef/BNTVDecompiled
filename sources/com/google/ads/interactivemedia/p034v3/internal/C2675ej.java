package com.google.ads.interactivemedia.p034v3.internal;

import android.media.AudioManager;
import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ej */
/* loaded from: classes2.dex */
public final class C2675ej implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ C2677el f7106a;

    /* renamed from: b */
    private final Handler f7107b;

    public C2675ej(C2677el c2677el, Handler handler) {
        this.f7106a = c2677el;
        this.f7107b = handler;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(final int i) {
        this.f7107b.post(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.ei
            @Override // java.lang.Runnable
            public final void run() {
                C2675ej c2675ej = C2675ej.this;
                C2677el.m2436c(c2675ej.f7106a, i);
            }
        });
    }
}
