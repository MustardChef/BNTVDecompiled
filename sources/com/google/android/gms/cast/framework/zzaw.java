package com.google.android.gms.cast.framework;

import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
final class zzaw extends zzam {
    final /* synthetic */ SessionProvider zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzaw(SessionProvider sessionProvider, zzav zzavVar) {
        this.zza = sessionProvider;
    }

    @Override // com.google.android.gms.cast.framework.zzan
    public final IObjectWrapper zzb(String str) {
        Session createSession = this.zza.createSession(str);
        if (createSession == null) {
            return null;
        }
        return createSession.zzj();
    }

    @Override // com.google.android.gms.cast.framework.zzan
    public final boolean zzc() {
        return this.zza.isSessionRecoverable();
    }

    @Override // com.google.android.gms.cast.framework.zzan
    public final String zzd() {
        return this.zza.getCategory();
    }
}
