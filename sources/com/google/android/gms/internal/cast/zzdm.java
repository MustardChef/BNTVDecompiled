package com.google.android.gms.internal.cast;

import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public abstract class zzdm<E> extends zzdg<E> implements Set<E> {
    @NullableDecl
    private transient zzdk<E> zza;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return zzdt.zza(this);
    }

    @Override // com.google.android.gms.internal.cast.zzdg, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zza */
    public abstract zzdu<E> iterator();

    @Override // com.google.android.gms.internal.cast.zzdg
    public zzdk<E> zze() {
        zzdk<E> zzdkVar = this.zza;
        if (zzdkVar == null) {
            zzdk<E> zzh = zzh();
            this.zza = zzh;
            return zzh;
        }
        return zzdkVar;
    }

    zzdk<E> zzh() {
        return zzdk.zzj(toArray());
    }
}
