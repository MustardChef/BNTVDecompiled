package com.google.ads.interactivemedia.p034v3.internal;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bhe */
/* loaded from: classes2.dex */
public final class bhe implements WildcardType, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    private final Type f5715a;

    /* renamed from: b */
    private final Type f5716b;

    public bhe(Type[] typeArr, Type[] typeArr2) {
        int length = typeArr2.length;
        axd.m4404h(length <= 1);
        axd.m4404h(typeArr.length == 1);
        if (length == 1) {
            axd.m4403i(typeArr2[0]);
            bhf.m3686i(typeArr2[0]);
            axd.m4404h(typeArr[0] == Object.class);
            this.f5716b = bhf.m3691d(typeArr2[0]);
            this.f5715a = Object.class;
            return;
        }
        axd.m4403i(typeArr[0]);
        bhf.m3686i(typeArr[0]);
        this.f5716b = null;
        this.f5715a = bhf.m3691d(typeArr[0]);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && bhf.m3684k(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.f5716b;
        return type != null ? new Type[]{type} : bhf.f5717a;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.f5715a};
    }

    public final int hashCode() {
        Type type = this.f5716b;
        return (type != null ? type.hashCode() + 31 : 1) ^ (this.f5715a.hashCode() + 31);
    }

    public final String toString() {
        Type type = this.f5716b;
        if (type != null) {
            String valueOf = String.valueOf(bhf.m3693b(type));
            return valueOf.length() != 0 ? "? super ".concat(valueOf) : new String("? super ");
        }
        Type type2 = this.f5715a;
        if (type2 == Object.class) {
            return "?";
        }
        String valueOf2 = String.valueOf(bhf.m3693b(type2));
        return valueOf2.length() != 0 ? "? extends ".concat(valueOf2) : new String("? extends ");
    }
}
