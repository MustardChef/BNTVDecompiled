package com.google.android.gms.internal.p038firebaseauthapi;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyk */
/* loaded from: classes3.dex */
public class zzyk extends zzyj {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyk(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzym
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzym) && zzc() == ((zzym) obj).zzc()) {
            if (zzc() == 0) {
                return true;
            }
            if (obj instanceof zzyk) {
                zzyk zzykVar = (zzyk) obj;
                int zzs = zzs();
                int zzs2 = zzykVar.zzs();
                if (zzs == 0 || zzs2 == 0 || zzs == zzs2) {
                    int zzc = zzc();
                    if (zzc > zzykVar.zzc()) {
                        int zzc2 = zzc();
                        StringBuilder sb = new StringBuilder(40);
                        sb.append("Length too large: ");
                        sb.append(zzc);
                        sb.append(zzc2);
                        throw new IllegalArgumentException(sb.toString());
                    } else if (zzc > zzykVar.zzc()) {
                        int zzc3 = zzykVar.zzc();
                        StringBuilder sb2 = new StringBuilder(59);
                        sb2.append("Ran off end of other: ");
                        sb2.append(0);
                        sb2.append(", ");
                        sb2.append(zzc);
                        sb2.append(", ");
                        sb2.append(zzc3);
                        throw new IllegalArgumentException(sb2.toString());
                    } else if (zzykVar instanceof zzyk) {
                        byte[] bArr = this.zza;
                        byte[] bArr2 = zzykVar.zza;
                        zzykVar.zzd();
                        int i = 0;
                        int i2 = 0;
                        while (i < zzc) {
                            if (bArr[i] != bArr2[i2]) {
                                return false;
                            }
                            i++;
                            i2++;
                        }
                        return true;
                    } else {
                        return zzykVar.zzf(0, zzc).equals(zzf(0, zzc));
                    }
                }
                return false;
            }
            return obj.equals(this);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzym
    public byte zza(int i) {
        return this.zza[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzym
    public byte zzb(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzym
    public int zzc() {
        return this.zza.length;
    }

    protected int zzd() {
        return 0;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzym
    protected void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, 0, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzym
    public final zzym zzf(int i, int i2) {
        int zzt = zzt(0, i2, zzc());
        return zzt == 0 ? zzym.zzb : new zzyf(this.zza, 0, zzt);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzym
    public final void zzg(zzya zzyaVar) throws IOException {
        zzyaVar.zza(this.zza, 0, zzc());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzym
    protected final String zzh(Charset charset) {
        return new String(this.zza, 0, zzc(), charset);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzym
    public final boolean zzi() {
        return zzaci.zzb(this.zza, 0, zzc());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzym
    protected final int zzj(int i, int i2, int i3) {
        return zzzu.zzh(i, this.zza, 0, i3);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzym
    public final zzyp zzk() {
        return zzyp.zzs(this.zza, 0, zzc(), true);
    }
}
