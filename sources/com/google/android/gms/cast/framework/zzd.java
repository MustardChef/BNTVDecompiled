package com.google.android.gms.cast.framework;

import com.google.android.datatransport.Transformer;
import com.google.android.gms.internal.cast.zzkt;
import com.google.android.gms.internal.cast.zzof;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class zzd implements Transformer {
    static final Transformer zza = new zzd();

    private zzd() {
    }

    @Override // com.google.android.datatransport.Transformer
    public final Object apply(Object obj) {
        zzkt zzktVar = (zzkt) obj;
        try {
            byte[] bArr = new byte[zzktVar.zzr()];
            zzof zzt = zzof.zzt(bArr);
            zzktVar.zzq(zzt);
            zzt.zzC();
            return bArr;
        } catch (IOException e) {
            String name = zzktVar.getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a byte array threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }
}
