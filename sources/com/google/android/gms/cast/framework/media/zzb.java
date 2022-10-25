package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzb extends com.google.android.gms.internal.cast.zza implements zzd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.media.IImagePicker");
    }

    @Override // com.google.android.gms.cast.framework.media.zzd
    public final WebImage zze(MediaMetadata mediaMetadata, int i) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.cast.framework.media.zzd
    public final IObjectWrapper zzf() throws RemoteException {
        Parcel zzb = zzb(2, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzb.readStrongBinder());
        zzb.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.cast.framework.media.zzd
    public final WebImage zzg(MediaMetadata mediaMetadata, ImageHints imageHints) throws RemoteException {
        throw null;
    }
}
