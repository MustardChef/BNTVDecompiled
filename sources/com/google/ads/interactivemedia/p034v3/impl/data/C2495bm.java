package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.internal.brf;
import com.google.ads.interactivemedia.p034v3.internal.brh;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.bm */
/* loaded from: classes2.dex */
public final class C2495bm {
    public int errorCode;
    public String errorMessage;
    public String innerError;
    public String type;

    public Map<String, String> constructMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", this.type);
        hashMap.put("errorCode", String.valueOf(this.errorCode));
        hashMap.put("errorMessage", this.errorMessage);
        String str = this.innerError;
        if (str != null) {
            hashMap.put("innerError", str);
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return brf.m2729c(this, obj, new String[0]);
    }

    public int hashCode() {
        return brh.m2722a(this, new String[0]);
    }

    public String toString() {
        return String.format("Log[type=%s, errorCode=%s, errorMessage=%s, innerError=%s]", this.type, Integer.valueOf(this.errorCode), this.errorMessage, this.innerError);
    }
}
