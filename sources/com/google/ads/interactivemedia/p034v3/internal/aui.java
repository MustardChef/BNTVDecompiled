package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aui */
/* loaded from: classes2.dex */
abstract class aui implements awh {

    /* renamed from: a */
    private transient Set f5108a;

    /* renamed from: b */
    private transient Collection f5109b;

    /* renamed from: c */
    private transient Map f5110c;

    /* renamed from: e */
    abstract Collection mo4573e();

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof awh) {
            return mo4460w().equals(((awh) obj).mo4460w());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public Iterator mo4572f() {
        throw null;
    }

    public final int hashCode() {
        return mo4460w().hashCode();
    }

    /* renamed from: j */
    abstract Map mo4454j();

    /* renamed from: l */
    abstract Set mo4453l();

    public final String toString() {
        return mo4460w().toString();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.awh
    /* renamed from: u */
    public void mo4462u(Object obj, Object obj2) {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.awh
    /* renamed from: v */
    public final Collection mo4461v() {
        Collection collection = this.f5109b;
        if (collection == null) {
            Collection mo4573e = mo4573e();
            this.f5109b = mo4573e;
            return mo4573e;
        }
        return collection;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.awh
    /* renamed from: w */
    public final Map mo4460w() {
        Map map = this.f5110c;
        if (map == null) {
            Map mo4454j = mo4454j();
            this.f5110c = mo4454j;
            return mo4454j;
        }
        return map;
    }

    /* renamed from: x */
    public final Set m4571x() {
        Set set = this.f5108a;
        if (set == null) {
            Set mo4453l = mo4453l();
            this.f5108a = mo4453l;
            return mo4453l;
        }
        return set;
    }
}
