package com.google.ads.interactivemedia.p034v3.internal;

import android.media.AudioTrack;
import android.os.ConditionVariable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.jo */
/* loaded from: classes2.dex */
public final class C2815jo extends Thread {

    /* renamed from: a */
    final /* synthetic */ AudioTrack f7701a;

    /* renamed from: b */
    final /* synthetic */ C2824jx f7702b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2815jo(C2824jx c2824jx, AudioTrack audioTrack) {
        super("ExoPlayer:AudioTrackReleaseThread");
        this.f7702b = c2824jx;
        this.f7701a = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ConditionVariable conditionVariable;
        try {
            this.f7701a.flush();
            this.f7701a.release();
        } finally {
            conditionVariable = this.f7702b.f7758g;
            conditionVariable.open();
        }
    }
}
