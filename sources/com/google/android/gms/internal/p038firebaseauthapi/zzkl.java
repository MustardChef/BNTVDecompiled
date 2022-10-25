package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.Key;
import javax.crypto.Mac;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkl */
/* loaded from: classes3.dex */
public final class zzkl extends ThreadLocal<Mac> {
    final /* synthetic */ zzkm zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkl(zzkm zzkmVar) {
        this.zza = zzkmVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    /* renamed from: zza */
    public final Mac initialValue() {
        String str;
        Key key;
        try {
            zzjy<zzkd, Mac> zzjyVar = zzjy.zzb;
            str = this.zza.zzb;
            Mac zza = zzjyVar.zza(str);
            key = this.zza.zzc;
            zza.init(key);
            return zza;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
