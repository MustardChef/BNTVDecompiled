package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztv */
/* loaded from: classes3.dex */
public final class zztv extends zzpl implements Api.ApiOptions.HasOptions {
    private final String zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zztv(String str, zztt zzttVar) {
        this.zzb = Preconditions.checkNotEmpty(str, "A valid API key must be provided");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zztv) {
            zztv zztvVar = (zztv) obj;
            return Objects.equal(this.zzb, zztvVar.zzb) && this.zza == zztvVar.zza;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb) + (1 ^ (this.zza ? 1 : 0));
    }

    public final String zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzpl
    /* renamed from: zzc */
    public final zztv zza() {
        return new zztv(Preconditions.checkNotEmpty(this.zzb), null);
    }
}
