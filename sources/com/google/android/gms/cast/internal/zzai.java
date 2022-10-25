package com.google.android.gms.cast.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.cast.zzbz;
import com.google.android.gms.internal.cast.zzcb;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzai {
    public static final Api.ClientKey<zzw> zza = new Api.ClientKey<>();
    public static final Api.ClientKey<zzx> zzb = new Api.ClientKey<>();
    public static final Api.ClientKey<zzcb> zzc = new Api.ClientKey<>();
    public static final Api.ClientKey<zzbz> zzd = new Api.ClientKey<>();
    public static final Api.ClientKey zze = new Api.ClientKey();
    public static final Api.ClientKey zzf = new Api.ClientKey();
    public static final Charset zzg;
    public static final String zzh;

    static {
        Charset charset = null;
        try {
            charset = Charset.forName("UTF-8");
        } catch (IllegalCharsetNameException | UnsupportedCharsetException unused) {
        }
        zzg = charset;
        zzh = CastUtils.zzd("com.google.cast.multizone");
    }
}
