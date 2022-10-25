package com.google.android.gms.cast.framework.media;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public abstract class zzc extends com.google.android.gms.internal.cast.zzb implements zzd {
    public zzc() {
        super("com.google.android.gms.cast.framework.media.IImagePicker");
    }

    @Override // com.google.android.gms.internal.cast.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            WebImage zze = zze((MediaMetadata) com.google.android.gms.internal.cast.zzc.zzc(parcel, MediaMetadata.CREATOR), parcel.readInt());
            parcel2.writeNoException();
            com.google.android.gms.internal.cast.zzc.zze(parcel2, zze);
        } else if (i == 2) {
            IObjectWrapper zzf = zzf();
            parcel2.writeNoException();
            com.google.android.gms.internal.cast.zzc.zzf(parcel2, zzf);
        } else if (i == 3) {
            parcel2.writeNoException();
            parcel2.writeInt(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        } else if (i != 4) {
            return false;
        } else {
            WebImage zzg = zzg((MediaMetadata) com.google.android.gms.internal.cast.zzc.zzc(parcel, MediaMetadata.CREATOR), (ImageHints) com.google.android.gms.internal.cast.zzc.zzc(parcel, ImageHints.CREATOR));
            parcel2.writeNoException();
            com.google.android.gms.internal.cast.zzc.zze(parcel2, zzg);
        }
        return true;
    }
}
