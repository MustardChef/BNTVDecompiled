package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
final class zzj extends zzc {
    final /* synthetic */ ImagePicker zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzj(ImagePicker imagePicker, zzi zziVar) {
        this.zza = imagePicker;
    }

    @Override // com.google.android.gms.cast.framework.media.zzd
    public final WebImage zze(MediaMetadata mediaMetadata, int i) {
        return this.zza.onPickImage(mediaMetadata, i);
    }

    @Override // com.google.android.gms.cast.framework.media.zzd
    public final IObjectWrapper zzf() {
        return ObjectWrapper.wrap(this.zza);
    }

    @Override // com.google.android.gms.cast.framework.media.zzd
    public final WebImage zzg(MediaMetadata mediaMetadata, ImageHints imageHints) {
        return this.zza.onPickImage(mediaMetadata, imageHints);
    }
}
