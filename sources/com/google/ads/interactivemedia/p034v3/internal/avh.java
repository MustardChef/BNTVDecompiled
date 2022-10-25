package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.avh */
/* loaded from: classes2.dex */
public class avh {

    /* renamed from: a */
    Object[] f5172a;

    /* renamed from: b */
    int f5173b;

    public avh() {
        this(4);
    }

    /* renamed from: f */
    private final void m4506f(int i) {
        int i2 = i + i;
        Object[] objArr = this.f5172a;
        int length = objArr.length;
        if (i2 > length) {
            this.f5172a = Arrays.copyOf(objArr, ava.m4527a(length, i2));
        }
    }

    /* renamed from: a */
    public avh mo4491a(Object obj, Object obj2) {
        m4506f(this.f5173b + 1);
        axd.m4415G(obj, obj2);
        Object[] objArr = this.f5172a;
        int i = this.f5173b;
        int i2 = i + i;
        objArr[i2] = obj;
        objArr[i2 + 1] = obj2;
        this.f5173b = i + 1;
        return this;
    }

    @Deprecated
    /* renamed from: b */
    public avj mo4490b() {
        return mo4489c();
    }

    /* renamed from: c */
    public avj mo4489c() {
        return awv.m4441k(this.f5173b, this.f5172a);
    }

    /* renamed from: d */
    public void mo4488d(Map.Entry entry) {
        mo4491a(entry.getKey(), entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    public final void m4507e(Iterable iterable) {
        if (iterable instanceof Collection) {
            m4506f(this.f5173b + iterable.size());
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            mo4488d((Map.Entry) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public avh(int i) {
        this.f5172a = new Object[i + i];
        this.f5173b = 0;
    }
}
