package com.google.android.gms.cast.framework.media;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public interface zzd extends IInterface {
    WebImage zze(MediaMetadata mediaMetadata, int i) throws RemoteException;

    IObjectWrapper zzf() throws RemoteException;

    WebImage zzg(MediaMetadata mediaMetadata, ImageHints imageHints) throws RemoteException;
}
