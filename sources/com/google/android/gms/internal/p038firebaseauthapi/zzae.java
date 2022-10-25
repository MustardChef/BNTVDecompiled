package com.google.android.gms.internal.p038firebaseauthapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzae */
/* loaded from: classes3.dex */
public final class zzae {
    private final zzp zza;
    private final zzad zzb;

    private zzae(zzad zzadVar) {
        zzo zzoVar = zzo.zza;
        this.zzb = zzadVar;
        this.zza = zzoVar;
    }

    public static zzae zza(char c) {
        return new zzae(new zzz(new zzm('.')));
    }

    public static zzae zzb(String str) {
        zzs zzb = zzx.zzb("[.-]");
        if (!(!((zzt) zzb.zza("")).zza.matches())) {
            throw new IllegalArgumentException(zzaf.zzc("The pattern may not match the empty string: %s", zzb));
        }
        return new zzae(new zzab(zzb));
    }

    public final List<String> zzc(CharSequence charSequence) {
        Objects.requireNonNull(charSequence);
        Iterator<String> zza = this.zzb.zza(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (zza.hasNext()) {
            arrayList.add(zza.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
