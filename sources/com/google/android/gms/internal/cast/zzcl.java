package com.google.android.gms.internal.cast;

import android.animation.Animator;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzcl extends zzcj {
    protected final Animator zza;
    private int zzc;
    private final zzcp zzd = new zzck(this);
    private final int zzb = -1;

    private zzcl(Animator animator, int i, Runnable runnable) {
        this.zza = animator;
    }

    public static void zzb(Animator animator, int i, Runnable runnable) {
        animator.addListener(new zzcl(animator, -1, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int zzc(zzcl zzclVar) {
        int i = zzclVar.zzc;
        zzclVar.zzc = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean zzd(zzcl zzclVar) {
        return zzclVar.zzb != -1 && zzclVar.zzc >= 0;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (zza(animator)) {
            return;
        }
        zzcs.zzb().zza(this.zzd);
    }
}
