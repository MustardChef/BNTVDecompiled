package com.google.android.gms.internal.cast;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.collection.SimpleArrayMap;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public class zzcj extends AnimatorListenerAdapter {
    private final SimpleArrayMap<Animator, Boolean> zza = new SimpleArrayMap<>();

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.zza.put(animator, true);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.zza.put(animator, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zza(Animator animator) {
        return this.zza.containsKey(animator) && this.zza.get(animator).booleanValue();
    }
}
