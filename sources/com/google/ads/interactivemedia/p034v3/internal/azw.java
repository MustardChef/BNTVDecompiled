package com.google.ads.interactivemedia.p034v3.internal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.azw */
/* loaded from: classes2.dex */
public final class azw {

    /* renamed from: a */
    private final ConcurrentMap f5338a = new ConcurrentHashMap();

    /* renamed from: b */
    private azu f5339b;

    /* renamed from: c */
    private final Class f5340c;

    private azw(Class cls) {
        this.f5340c = cls;
    }

    /* renamed from: c */
    public static azw m4255c(Class cls) {
        return new azw(cls);
    }

    /* renamed from: a */
    public final azu m4257a(Object obj, bef befVar) throws GeneralSecurityException {
        byte[] array;
        if (befVar.m3918e() != bec.f5548b) {
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
        int i = ben.f5590a;
        int m3917f = befVar.m3917f();
        int i2 = m3917f - 2;
        if (m3917f == 0) {
            throw null;
        }
        if (i2 == 1) {
            array = ByteBuffer.allocate(5).put((byte) 1).putInt(befVar.m3922a()).array();
        } else {
            if (i2 != 2) {
                if (i2 == 3) {
                    array = azd.f5319a;
                } else if (i2 != 4) {
                    throw new GeneralSecurityException("unknown output prefix type");
                }
            }
            array = ByteBuffer.allocate(5).put((byte) 0).putInt(befVar.m3922a()).array();
        }
        int m3918e = befVar.m3918e();
        int m3917f2 = befVar.m3917f();
        befVar.m3922a();
        azu azuVar = new azu(obj, array, m3918e, m3917f2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(azuVar);
        azv azvVar = new azv(azuVar.m4260b());
        List list = (List) this.f5338a.put(azvVar, Collections.unmodifiableList(arrayList));
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            arrayList2.add(azuVar);
            this.f5338a.put(azvVar, Collections.unmodifiableList(arrayList2));
        }
        return azuVar;
    }

    /* renamed from: b */
    public final azu m4256b() {
        return this.f5339b;
    }

    /* renamed from: d */
    public final Class m4254d() {
        return this.f5340c;
    }

    /* renamed from: e */
    public final void m4253e(azu azuVar) {
        if (azuVar.m4259c() != bec.f5548b) {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        }
        List list = (List) this.f5338a.get(new azv(azuVar.m4260b()));
        if (list == null) {
            list = Collections.emptyList();
        }
        if (!list.isEmpty()) {
            this.f5339b = azuVar;
            return;
        }
        throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
    }
}
