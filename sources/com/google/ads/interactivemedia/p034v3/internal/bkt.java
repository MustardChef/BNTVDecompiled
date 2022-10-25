package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bkt */
/* loaded from: classes2.dex */
public final class bkt {

    /* renamed from: a */
    final Class f5958a;

    /* renamed from: b */
    final Type f5959b;

    /* renamed from: c */
    final int f5960c;

    protected bkt() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            this.f5959b = bhf.m3691d(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
            throw null;
        }
        throw new RuntimeException("Missing type parameter.");
    }

    /* renamed from: a */
    public static bkt m3602a(Class cls) {
        return new bkt(cls);
    }

    /* renamed from: b */
    public static bkt m3601b(Type type) {
        return new bkt(type);
    }

    /* renamed from: c */
    public final Class m3600c() {
        return this.f5958a;
    }

    /* renamed from: d */
    public final Type m3599d() {
        return this.f5959b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof bkt) && bhf.m3684k(this.f5959b, ((bkt) obj).f5959b);
    }

    public final int hashCode() {
        return this.f5960c;
    }

    public final String toString() {
        return bhf.m3693b(this.f5959b);
    }

    bkt(Type type) {
        axd.m4403i(type);
        Type m3691d = bhf.m3691d(type);
        this.f5959b = m3691d;
        this.f5958a = bhf.m3694a(m3691d);
        this.f5960c = m3691d.hashCode();
    }
}
