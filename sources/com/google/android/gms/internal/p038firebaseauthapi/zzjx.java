package com.google.android.gms.internal.p038firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjx */
/* loaded from: classes3.dex */
public final class zzjx implements zzag {
    private final zzki zza;
    private final zzay zzb;
    private final int zzc;

    public zzjx(zzki zzkiVar, zzay zzayVar, int i) {
        this.zza = zzkiVar;
        this.zzb = zzayVar;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzag
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzag
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzc;
        if (length < i) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, length - i);
        this.zzb.zza(Arrays.copyOfRange(bArr, length - this.zzc, length), zzjm.zzb(bArr2, copyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8)));
        return this.zza.zza(copyOfRange);
    }
}
