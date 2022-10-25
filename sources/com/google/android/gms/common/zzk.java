package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes2.dex */
abstract class zzk extends zzi {
    private static final WeakReference<byte[]> zzb = new WeakReference<>(null);
    private WeakReference<byte[]> zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(byte[] bArr) {
        super(bArr);
        this.zza = zzb;
    }

    protected abstract byte[] zzb();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.zzi
    public final byte[] zzc() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.zza.get();
            if (bArr == null) {
                bArr = zzb();
                this.zza = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }
}
