package com.google.android.gms.internal.p038firebaseauthapi;

import android.content.Context;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import com.google.android.gms.stats.CodePackage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;
import javax.crypto.KeyGenerator;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdj */
/* loaded from: classes3.dex */
public final class zzdj {
    private zzau zze;
    private zzdo zzf = null;
    private zzav zza = null;
    private String zzb = null;
    private zzag zzc = null;
    private zzap zzd = null;

    private final zzag zzh() throws GeneralSecurityException {
        String str;
        String str2;
        String str3;
        if (Build.VERSION.SDK_INT >= 23) {
            zzdn zzdnVar = new zzdn();
            boolean zzc = zzdnVar.zzc(this.zzb);
            if (!zzc) {
                try {
                    String str4 = this.zzb;
                    if (new zzdn().zzc(str4)) {
                        throw new IllegalArgumentException(String.format("cannot generate a new key %s because it already exists; please delete it with deleteKey() and try again", str4));
                    }
                    String zzc2 = zzkr.zzc("android-keystore://", str4);
                    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                    keyGenerator.init(new KeyGenParameterSpec.Builder(zzc2, 3).setKeySize(256).setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").build());
                    keyGenerator.generateKey();
                } catch (GeneralSecurityException | ProviderException e) {
                    str2 = zzdk.zzb;
                    Log.w(str2, "cannot use Android Keystore, it'll be disabled", e);
                    return null;
                }
            }
            try {
                return zzdnVar.zzb(this.zzb);
            } catch (GeneralSecurityException | ProviderException e2) {
                if (zzc) {
                    throw new KeyStoreException(String.format("the master key %s exists but is unusable", this.zzb), e2);
                }
                str3 = zzdk.zzb;
                Log.w(str3, "cannot use Android Keystore, it'll be disabled", e2);
                return null;
            }
        }
        str = zzdk.zzb;
        Log.w(str, "Android Keystore requires at least Android M");
        return null;
    }

    private final zzau zzi() throws GeneralSecurityException, IOException {
        String str;
        zzag zzagVar = this.zzc;
        if (zzagVar != null) {
            try {
                return zzau.zza(zzat.zzi(this.zzf, zzagVar));
            } catch (zzzw | GeneralSecurityException e) {
                str = zzdk.zzb;
                Log.w(str, "cannot decrypt keyset: ", e);
            }
        }
        return zzau.zza(zzai.zzb(this.zzf));
    }

    public final zzdj zza(Context context, String str, String str2) throws IOException {
        if (context == null) {
            throw new IllegalArgumentException("need an Android context");
        }
        this.zzf = new zzdo(context, "GenericIdpKeyset", str2);
        this.zza = new zzdp(context, "GenericIdpKeyset", str2);
        return this;
    }

    public final zzdj zzb(String str) {
        if (str.startsWith("android-keystore://")) {
            this.zzb = str;
            return this;
        }
        throw new IllegalArgumentException("key URI must start with android-keystore://");
    }

    @Deprecated
    public final zzdj zzc(zzht zzhtVar) {
        String zza = zzhtVar.zza();
        byte[] zzp = zzhtVar.zzb().zzp();
        zziu zzc = zzhtVar.zzc();
        int i = zzdk.zza;
        zziu zziuVar = zziu.UNKNOWN_PREFIX;
        int ordinal = zzc.ordinal();
        int i2 = 4;
        if (ordinal == 1) {
            i2 = 1;
        } else if (ordinal == 2) {
            i2 = 2;
        } else if (ordinal == 3) {
            i2 = 3;
        } else if (ordinal != 4) {
            throw new IllegalArgumentException("Unknown output prefix type");
        }
        this.zzd = zzap.zzb(zza, zzp, i2);
        return this;
    }

    public final synchronized zzdk zzd() throws GeneralSecurityException, IOException {
        String str;
        zzau zzb;
        if (this.zzb != null) {
            this.zzc = zzh();
        }
        try {
            zzb = zzi();
        } catch (FileNotFoundException e) {
            str = zzdk.zzb;
            Log.w(str, "keyset not found, will generate a new one", e);
            if (this.zzd != null) {
                zzb = zzau.zzb();
                zzb.zzd(this.zzd);
                zzb.zzf(zzb.zzc().zzc().zza(0).zza());
                if (this.zzc != null) {
                    zzb.zzc().zzd(this.zza, this.zzc);
                } else {
                    zzai.zza(zzb.zzc(), this.zza);
                }
            } else {
                throw new GeneralSecurityException("cannot read or generate keyset");
            }
        }
        this.zze = zzb;
        return new zzdk(this, null);
    }
}
