package com.google.android.gms.internal.cast;

import android.app.Activity;
import android.view.ViewGroup;
import com.google.android.gms.cast.framework.IntroductoryOverlay;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
final class zzv implements Runnable {
    final /* synthetic */ zzx zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzv(zzx zzxVar) {
        this.zza = zzxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        Activity activity;
        IntroductoryOverlay.OnOverlayDismissedListener onOverlayDismissedListener;
        IntroductoryOverlay.OnOverlayDismissedListener onOverlayDismissedListener2;
        z = this.zza.zza.zzg;
        if (z) {
            activity = this.zza.zza.zzb;
            ((ViewGroup) activity.getWindow().getDecorView()).removeView(this.zza.zza);
            onOverlayDismissedListener = this.zza.zza.zzc;
            if (onOverlayDismissedListener != null) {
                onOverlayDismissedListener2 = this.zza.zza.zzc;
                onOverlayDismissedListener2.onOverlayDismissed();
            }
            this.zza.zza.zzg();
        }
    }
}
