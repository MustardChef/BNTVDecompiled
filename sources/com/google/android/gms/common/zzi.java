package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.exoplayer2.C3282C;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes2.dex */
public abstract class zzi extends com.google.android.gms.common.internal.zzx {
    private final int zza;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzi(byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 25);
        this.zza = Arrays.hashCode(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static byte[] zzf(String str) {
        try {
            return str.getBytes(C3282C.ISO88591_NAME);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        IObjectWrapper zzd;
        if (obj != null && (obj instanceof com.google.android.gms.common.internal.zzy)) {
            try {
                com.google.android.gms.common.internal.zzy zzyVar = (com.google.android.gms.common.internal.zzy) obj;
                if (zzyVar.zze() == this.zza && (zzd = zzyVar.zzd()) != null) {
                    return Arrays.equals(zzc(), (byte[]) ObjectWrapper.unwrap(zzd));
                }
                return false;
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] zzc();

    @Override // com.google.android.gms.common.internal.zzy
    public final IObjectWrapper zzd() {
        return ObjectWrapper.wrap(zzc());
    }

    @Override // com.google.android.gms.common.internal.zzy
    public final int zze() {
        return this.zza;
    }
}
