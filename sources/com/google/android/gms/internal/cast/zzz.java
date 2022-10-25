package com.google.android.gms.internal.cast;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
final class zzz extends AnimatorListenerAdapter {
    final /* synthetic */ zzaa zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzz(zzaa zzaaVar) {
        this.zza = zzaaVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        zzac.zza(this.zza.zza);
    }
}
