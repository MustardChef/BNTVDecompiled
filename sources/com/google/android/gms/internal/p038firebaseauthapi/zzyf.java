package com.google.android.gms.internal.p038firebaseauthapi;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyf */
/* loaded from: classes3.dex */
public final class zzyf extends zzyk {
    private final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyf(byte[] bArr, int i, int i2) {
        super(bArr);
        zzt(0, i2, bArr.length);
        this.zzc = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyk, com.google.android.gms.internal.p038firebaseauthapi.zzym
    public final byte zzb(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyk, com.google.android.gms.internal.p038firebaseauthapi.zzym
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyk
    protected final int zzd() {
        return 0;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyk, com.google.android.gms.internal.p038firebaseauthapi.zzym
    protected final void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, 0, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyk, com.google.android.gms.internal.p038firebaseauthapi.zzym
    public final byte zza(int i) {
        int i2 = this.zzc;
        if (((i2 - (i + 1)) | i) < 0) {
            if (i < 0) {
                StringBuilder sb = new StringBuilder(22);
                sb.append("Index < 0: ");
                sb.append(i);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Index > length: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
        return this.zza[i];
    }
}
