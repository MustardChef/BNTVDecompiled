package com.google.android.gms.cast.internal;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public class zzp {
    protected final Logger zza;
    private final String zzb;
    private zzao zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzp(String str, String str2, String str3) {
        CastUtils.throwIfInvalidNamespace(str);
        this.zzb = str;
        Logger logger = new Logger("MediaControlChannel");
        this.zza = logger;
        if (TextUtils.isEmpty(null)) {
            return;
        }
        logger.zza(null);
    }

    public final String zzd() {
        return this.zzb;
    }

    public final void zze(zzao zzaoVar) {
        this.zzc = zzaoVar;
        if (zzaoVar == null) {
            zzh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzf(String str, long j, String str2) throws IllegalStateException {
        zzao zzaoVar = this.zzc;
        if (zzaoVar == null) {
            this.zza.m367e("Attempt to send text message without a sink", new Object[0]);
        } else {
            zzaoVar.zzb(this.zzb, str, j, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long zzg() {
        zzao zzaoVar = this.zzc;
        if (zzaoVar == null) {
            this.zza.m367e("Attempt to generate requestId without a sink", new Object[0]);
            return 0L;
        }
        return zzaoVar.zzc();
    }

    public void zzh() {
        throw null;
    }
}
