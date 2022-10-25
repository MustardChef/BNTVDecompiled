package com.google.android.gms.internal.cast;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
final class zzpt {
    public static final int zza(int i, Object obj, Object obj2) {
        zzps zzpsVar = (zzps) obj;
        zzpr zzprVar = (zzpr) obj2;
        if (zzpsVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzpsVar.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            entry.getKey();
            entry.getValue();
            throw null;
        }
        return 0;
    }
}
