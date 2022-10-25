package com.google.android.gms.internal.p038firebaseauthapi;

import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabv */
/* loaded from: classes3.dex */
final class zzabv implements Iterator<String> {
    final Iterator<String> zza;
    final /* synthetic */ zzabw zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabv(zzabw zzabwVar) {
        zzaab zzaabVar;
        this.zzb = zzabwVar;
        zzaabVar = zzabwVar.zza;
        this.zza = zzaabVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ String next() {
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
