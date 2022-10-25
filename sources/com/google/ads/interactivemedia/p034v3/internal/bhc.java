package com.google.ads.interactivemedia.p034v3.internal;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bhc */
/* loaded from: classes2.dex */
public final class bhc implements GenericArrayType, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    private final Type f5711a;

    public bhc(Type type) {
        this.f5711a = bhf.m3691d(type);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && bhf.m3684k(this, (GenericArrayType) obj);
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.f5711a;
    }

    public final int hashCode() {
        return this.f5711a.hashCode();
    }

    public final String toString() {
        return String.valueOf(bhf.m3693b(this.f5711a)).concat(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
    }
}
