package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
final class zzeq extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzem zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeq(zzem zzemVar) {
        this.zza = zzemVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return this.zza.zzf();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@NullableDecl Object obj) {
        int zza;
        Map zzb = this.zza.zzb();
        if (zzb != null) {
            return zzb.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            zza = this.zza.zza(entry.getKey());
            if (zza != -1 && zzdz.zza(this.zza.zzc[zza], entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@NullableDecl Object obj) {
        int zzi;
        Object obj2;
        Map zzb = this.zza.zzb();
        if (zzb != null) {
            return zzb.entrySet().remove(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (this.zza.zza()) {
                return false;
            }
            zzi = this.zza.zzi();
            Object key = entry.getKey();
            Object value = entry.getValue();
            obj2 = this.zza.zze;
            int zza = zzex.zza(key, value, zzi, obj2, this.zza.zza, this.zza.zzb, this.zza.zzc);
            if (zza == -1) {
                return false;
            }
            this.zza.zza(zza, zzi);
            zzem.zzd(this.zza);
            this.zza.zzc();
            return true;
        }
        return false;
    }
}
