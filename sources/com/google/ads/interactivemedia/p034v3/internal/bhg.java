package com.google.ads.interactivemedia.p034v3.internal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bhg */
/* loaded from: classes2.dex */
final class bhg implements bhz {

    /* renamed from: a */
    private final /* synthetic */ int f5718a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bhg(int i) {
        this.f5718a = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bhz
    /* renamed from: a */
    public final Object mo3659a() {
        switch (this.f5718a) {
            case 0:
                return new TreeMap();
            case 1:
                return new ConcurrentHashMap();
            case 2:
                return new LinkedHashMap();
            case 3:
                return new bhy();
            case 4:
                return new TreeSet();
            case 5:
                return new LinkedHashSet();
            case 6:
                return new ArrayDeque();
            case 7:
                return new ArrayList();
            default:
                return new ConcurrentSkipListMap();
        }
    }
}
