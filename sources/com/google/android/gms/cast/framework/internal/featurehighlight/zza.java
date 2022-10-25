package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zza extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ zzh zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(zzh zzhVar) {
        this.zza = zzhVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        boolean contains;
        zzg zzgVar;
        OuterHighlightDrawable outerHighlightDrawable;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        contains = this.zza.zzc.contains(Math.round(x), Math.round(y));
        if (contains) {
            outerHighlightDrawable = this.zza.zzd;
            if (outerHighlightDrawable.zzf(x, y)) {
                return true;
            }
        }
        zzgVar = this.zza.zzk;
        zzgVar.zzb();
        return true;
    }
}
