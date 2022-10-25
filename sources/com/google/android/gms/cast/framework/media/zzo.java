package com.google.android.gms.cast.framework.media;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.images.WebImage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzo {
    public final Uri zza;
    public Bitmap zzb;

    public zzo(WebImage webImage) {
        this.zza = webImage == null ? null : webImage.getUrl();
    }
}
