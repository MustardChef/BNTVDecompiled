package com.google.ads.interactivemedia.p034v3.internal;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ok */
/* loaded from: classes2.dex */
final class C2946ok extends LinkedHashMap {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C2946ok() {
        super(5, 1.0f, false);
    }

    @Override // java.util.LinkedHashMap
    protected final boolean removeEldestEntry(Map.Entry entry) {
        return size() > 4;
    }
}
