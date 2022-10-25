package com.google.android.gms.internal.cast;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
final class zzap implements com.google.android.gms.cast.framework.media.internal.zza {
    final /* synthetic */ zzaq zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzap(zzaq zzaqVar) {
        this.zza = zzaqVar;
    }

    @Override // com.google.android.gms.cast.framework.media.internal.zza
    public final void zza(Bitmap bitmap) {
        ImageView imageView;
        if (bitmap != null) {
            imageView = this.zza.zza;
            imageView.setImageBitmap(bitmap);
        }
    }
}
