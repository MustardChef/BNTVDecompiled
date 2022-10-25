package com.google.android.gms.cast.framework.media;

import android.graphics.Bitmap;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
final class zzm implements com.google.android.gms.cast.framework.media.internal.zza {
    final /* synthetic */ zzo zza;
    final /* synthetic */ MediaNotificationService zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(MediaNotificationService mediaNotificationService, zzo zzoVar) {
        this.zzb = mediaNotificationService;
        this.zza = zzoVar;
    }

    @Override // com.google.android.gms.cast.framework.media.internal.zza
    public final void zza(Bitmap bitmap) {
        zzo zzoVar = this.zza;
        zzoVar.zzb = bitmap;
        this.zzb.zzn = zzoVar;
        this.zzb.zzj();
    }
}
