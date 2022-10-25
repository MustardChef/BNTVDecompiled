package com.google.android.gms.internal.p038firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbc */
/* loaded from: classes3.dex */
public final class zzbc<P> {
    private final ConcurrentMap<zzbb, List<zzba<P>>> zza = new ConcurrentHashMap();
    private zzba<P> zzb;
    private final Class<P> zzc;

    private zzbc(Class<P> cls) {
        this.zzc = cls;
    }

    public static <P> zzbc<P> zzb(Class<P> cls) {
        return new zzbc<>(cls);
    }

    public final List<zzba<P>> zza(byte[] bArr) {
        List<zzba<P>> list = this.zza.get(new zzbb(bArr, null));
        return list != null ? list : Collections.emptyList();
    }

    public final void zzc(zzba<P> zzbaVar) {
        if (zzbaVar.zzb() != zzhq.ENABLED) {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        }
        if (!zza(zzbaVar.zzd()).isEmpty()) {
            this.zzb = zzbaVar;
            return;
        }
        throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
    }

    public final zzba<P> zzd(P p, zzia zziaVar) throws GeneralSecurityException {
        byte[] array;
        if (zziaVar.zzc() != zzhq.ENABLED) {
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
        zziu zziuVar = zziu.UNKNOWN_PREFIX;
        int ordinal = zziaVar.zze().ordinal();
        if (ordinal == 1) {
            array = ByteBuffer.allocate(5).put((byte) 1).putInt(zziaVar.zzd()).array();
        } else {
            if (ordinal != 2) {
                if (ordinal == 3) {
                    array = zzaj.zza;
                } else if (ordinal != 4) {
                    throw new GeneralSecurityException("unknown output prefix type");
                }
            }
            array = ByteBuffer.allocate(5).put((byte) 0).putInt(zziaVar.zzd()).array();
        }
        zzba<P> zzbaVar = new zzba<>(p, array, zziaVar.zzc(), zziaVar.zze(), zziaVar.zzd());
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzbaVar);
        zzbb zzbbVar = new zzbb(zzbaVar.zzd(), null);
        List<zzba<P>> put = this.zza.put(zzbbVar, Collections.unmodifiableList(arrayList));
        if (put != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(put);
            arrayList2.add(zzbaVar);
            this.zza.put(zzbbVar, Collections.unmodifiableList(arrayList2));
        }
        return zzbaVar;
    }

    public final Class<P> zze() {
        return this.zzc;
    }
}
