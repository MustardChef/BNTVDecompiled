package com.google.android.gms.internal.p038firebaseauthapi;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabl */
/* loaded from: classes3.dex */
final class zzabl implements Iterator<Map.Entry> {
    final /* synthetic */ zzabn zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator<Map.Entry> zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzabl(zzabn zzabnVar, zzabg zzabgVar) {
        this.zza = zzabnVar;
    }

    private final Iterator<Map.Entry> zza() {
        Map map;
        if (this.zzd == null) {
            map = this.zza.zzc;
            this.zzd = map.entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i = this.zzb + 1;
        list = this.zza.zzb;
        if (i >= list.size()) {
            map = this.zza.zzc;
            return !map.isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Map.Entry next() {
        List list;
        Object next;
        List list2;
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        list = this.zza.zzb;
        if (i < list.size()) {
            list2 = this.zza.zzb;
            next = list2.get(this.zzb);
        } else {
            next = zza().next();
        }
        return (Map.Entry) next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (this.zzc) {
            this.zzc = false;
            this.zza.zzm();
            int i = this.zzb;
            list = this.zza.zzb;
            if (i < list.size()) {
                zzabn zzabnVar = this.zza;
                int i2 = this.zzb;
                this.zzb = i2 - 1;
                zzabnVar.zzk(i2);
                return;
            }
            zza().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
