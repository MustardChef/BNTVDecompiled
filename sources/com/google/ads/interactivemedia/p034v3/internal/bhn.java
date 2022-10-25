package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.impl.data.C2476au;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bhn */
/* loaded from: classes2.dex */
public final class bhn implements Cloneable, bgz {

    /* renamed from: a */
    public static final bhn f5735a = new bhn();

    /* renamed from: b */
    private final double f5736b = -1.0d;

    /* renamed from: c */
    private final int f5737c = 136;

    /* renamed from: d */
    private final boolean f5738d = true;

    /* renamed from: e */
    private List f5739e = Collections.emptyList();

    /* renamed from: f */
    private final List f5740f = Collections.emptyList();

    /* renamed from: f */
    private final boolean m3675f(Class cls) {
        return m3673h(cls);
    }

    /* renamed from: g */
    private final boolean m3674g(Class cls, boolean z) {
        for (C2476au c2476au : z ? this.f5739e : this.f5740f) {
        }
        return false;
    }

    /* renamed from: h */
    private final boolean m3673h(Class cls) {
        return (Enum.class.isAssignableFrom(cls) || m3672i(cls) || (!cls.isAnonymousClass() && !cls.isLocalClass())) ? false : true;
    }

    /* renamed from: i */
    private static final boolean m3672i(Class cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgz
    /* renamed from: a */
    public final bgy mo3604a(bgh bghVar, bkt bktVar) {
        boolean z;
        boolean z2;
        Class m3600c = bktVar.m3600c();
        boolean m3675f = m3675f(m3600c);
        if (m3675f) {
            z = true;
        } else {
            m3674g(m3600c, true);
            z = false;
        }
        if (m3675f) {
            z2 = true;
        } else {
            m3674g(m3600c, false);
            z2 = false;
        }
        if (z || z2) {
            return new bhm(this, z2, z, bghVar, bktVar);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final bhn clone() {
        try {
            return (bhn) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: c */
    public final boolean m3678c(Class cls, boolean z) {
        if (m3675f(cls)) {
            return true;
        }
        m3674g(cls, z);
        return false;
    }

    /* renamed from: d */
    public final boolean m3677d(Field field, boolean z) {
        if ((field.getModifiers() & 136) != 0 || field.isSynthetic() || m3673h(field.getType())) {
            return true;
        }
        List<C2476au> list = z ? this.f5739e : this.f5740f;
        if (list.isEmpty()) {
            return false;
        }
        bfy bfyVar = new bfy(field);
        for (C2476au c2476au : list) {
            if (C2476au.m6003a(bfyVar)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public final bhn m3676e(C2476au c2476au) {
        bhn clone = clone();
        ArrayList arrayList = new ArrayList(this.f5739e);
        clone.f5739e = arrayList;
        arrayList.add(c2476au);
        return clone;
    }
}
