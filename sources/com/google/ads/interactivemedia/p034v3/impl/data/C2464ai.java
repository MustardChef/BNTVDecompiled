package com.google.ads.interactivemedia.p034v3.impl.data;

import android.net.Uri;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.ai */
/* loaded from: classes2.dex */
public final /* synthetic */ class C2464ai {
    /* renamed from: a */
    public static Map m6017a(Uri uri) {
        if (uri == null || uri.isOpaque()) {
            throw new UnsupportedOperationException("This isn't a hierarchical URI.");
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null || encodedQuery.length() == 0) {
            return Collections.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int indexOf = encodedQuery.indexOf(35);
        int i = 0;
        if (indexOf == -1) {
            indexOf = encodedQuery.length();
        }
        do {
            int indexOf2 = encodedQuery.indexOf(38, i);
            if (indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            int indexOf3 = encodedQuery.indexOf(61, i);
            if (indexOf3 > indexOf2 || indexOf3 == -1) {
                indexOf3 = indexOf2;
            }
            linkedHashMap.put(encodedQuery.substring(i, indexOf3), indexOf3 < indexOf2 ? encodedQuery.substring(indexOf3 + 1, indexOf2) : "");
            i = indexOf2 + 1;
        } while (i < indexOf);
        return Collections.unmodifiableMap(linkedHashMap);
    }
}
