package com.google.android.gms.internal.p038firebaseauthapi;

import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbb */
/* loaded from: classes3.dex */
final class zzbb implements Comparable<zzbb> {
    private final byte[] zza;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(zzbb zzbbVar) {
        zzbb zzbbVar2 = zzbbVar;
        int length = this.zza.length;
        int length2 = zzbbVar2.zza.length;
        if (length != length2) {
            return length - length2;
        }
        int i = 0;
        while (true) {
            byte[] bArr = this.zza;
            if (i >= bArr.length) {
                return 0;
            }
            byte b = bArr[i];
            byte b2 = zzbbVar2.zza[i];
            if (b != b2) {
                return b - b2;
            }
            i++;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzbb) {
            return Arrays.equals(this.zza, ((zzbb) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        return zzkh.zza(this.zza);
    }
}
