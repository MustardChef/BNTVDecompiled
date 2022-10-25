package com.google.android.gms.internal.cast;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public class zznw extends zznv {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznw(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.cast.zzny
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzny) && zzc() == ((zzny) obj).zzc()) {
            if (zzc() == 0) {
                return true;
            }
            if (obj instanceof zznw) {
                zznw zznwVar = (zznw) obj;
                int zzl = zzl();
                int zzl2 = zznwVar.zzl();
                if (zzl == 0 || zzl2 == 0 || zzl == zzl2) {
                    int zzc = zzc();
                    if (zzc > zznwVar.zzc()) {
                        int zzc2 = zzc();
                        StringBuilder sb = new StringBuilder(40);
                        sb.append("Length too large: ");
                        sb.append(zzc);
                        sb.append(zzc2);
                        throw new IllegalArgumentException(sb.toString());
                    } else if (zzc > zznwVar.zzc()) {
                        int zzc3 = zznwVar.zzc();
                        StringBuilder sb2 = new StringBuilder(59);
                        sb2.append("Ran off end of other: 0, ");
                        sb2.append(zzc);
                        sb2.append(", ");
                        sb2.append(zzc3);
                        throw new IllegalArgumentException(sb2.toString());
                    } else if (zznwVar instanceof zznw) {
                        byte[] bArr = this.zza;
                        byte[] bArr2 = zznwVar.zza;
                        zznwVar.zzd();
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
                        return zznwVar.zze(0, zzc).equals(zze(0, zzc));
                    }
                }
                return false;
            }
            return obj.equals(this);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.cast.zzny
    public byte zza(int i) {
        return this.zza[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.cast.zzny
    public byte zzb(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.cast.zzny
    public int zzc() {
        return this.zza.length;
    }

    protected int zzd() {
        return 0;
    }

    @Override // com.google.android.gms.internal.cast.zzny
    public final zzny zze(int i, int i2) {
        zzm(0, i2, zzc());
        return i2 == 0 ? zzny.zzb : new zznt(this.zza, 0, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.cast.zzny
    public final void zzf(zznp zznpVar) throws IOException {
        ((zzod) zznpVar).zzp(this.zza, 0, zzc());
    }

    @Override // com.google.android.gms.internal.cast.zzny
    protected final String zzg(Charset charset) {
        return new String(this.zza, 0, zzc(), charset);
    }

    @Override // com.google.android.gms.internal.cast.zzny
    public final boolean zzh() {
        return zzrl.zzb(this.zza, 0, zzc());
    }

    @Override // com.google.android.gms.internal.cast.zzny
    protected final int zzi(int i, int i2, int i3) {
        return zzpb.zzh(i, this.zza, 0, i3);
    }
}
