package com.google.android.gms.internal.cast;

import com.google.android.gms.internal.cast.zznl;
import com.google.android.gms.internal.cast.zznm;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public abstract class zznm<MessageType extends zznm<MessageType, BuilderType>, BuilderType extends zznl<MessageType, BuilderType>> implements zzpy {
    protected int zza = 0;

    @Override // com.google.android.gms.internal.cast.zzpy
    public final zzny zzm() {
        try {
            int zzr = zzr();
            zzny zznyVar = zzny.zzb;
            byte[] bArr = new byte[zzr];
            zzof zzt = zzof.zzt(bArr);
            zzq(zzt);
            zzt.zzC();
            return new zznw(bArr);
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ByteString threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zzn() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zzo(int i) {
        throw null;
    }
}
