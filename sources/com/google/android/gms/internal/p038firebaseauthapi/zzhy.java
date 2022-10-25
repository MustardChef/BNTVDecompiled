package com.google.android.gms.internal.p038firebaseauthapi;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhy */
/* loaded from: classes3.dex */
public final class zzhy extends zzzk<zzib, zzhy> implements zzaas {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private zzhy() {
        /*
            r1 = this;
            com.google.android.gms.internal.firebase-auth-api.zzib r0 = com.google.android.gms.internal.p038firebaseauthapi.zzib.zzg()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p038firebaseauthapi.zzhy.<init>():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ zzhy(com.google.android.gms.internal.p038firebaseauthapi.zzhx r1) {
        /*
            r0 = this;
            com.google.android.gms.internal.firebase-auth-api.zzib r1 = com.google.android.gms.internal.p038firebaseauthapi.zzib.zzg()
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p038firebaseauthapi.zzhy.<init>(com.google.android.gms.internal.firebase-auth-api.zzhx):void");
    }

    public final zzhy zza(int i) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzib) this.zza).zzb = i;
        return this;
    }

    public final List<zzia> zzb() {
        return Collections.unmodifiableList(((zzib) this.zza).zzb());
    }

    public final int zzc() {
        return ((zzib) this.zza).zzc();
    }

    public final zzia zzd(int i) {
        return ((zzib) this.zza).zzd(i);
    }

    public final zzhy zze(zzia zziaVar) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        zzib.zzi((zzib) this.zza, zziaVar);
        return this;
    }
}
