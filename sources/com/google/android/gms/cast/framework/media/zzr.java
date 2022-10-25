package com.google.android.gms.cast.framework.media;

import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzr extends TimerTask {
    final /* synthetic */ MediaQueue zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzr(MediaQueue mediaQueue) {
        this.zza = mediaQueue;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        MediaQueue.zze(this.zza);
    }
}
