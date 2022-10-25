package com.google.android.gms.internal.cast;

import android.view.Choreographer;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public abstract class zzcp {
    private Runnable zza;
    private Choreographer.FrameCallback zzb;

    public abstract void zza(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Choreographer.FrameCallback zzb() {
        if (this.zzb == null) {
            this.zzb = new Choreographer.FrameCallback(this) { // from class: com.google.android.gms.internal.cast.zzcn
                private final zzcp zza;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zza = this;
                }

                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j) {
                    this.zza.zza(j);
                }
            };
        }
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Runnable zzc() {
        if (this.zza == null) {
            this.zza = new Runnable(this) { // from class: com.google.android.gms.internal.cast.zzco
                private final zzcp zza;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zza = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zza(System.nanoTime());
                }
            };
        }
        return this.zza;
    }
}
