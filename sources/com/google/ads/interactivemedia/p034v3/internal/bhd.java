package com.google.ads.interactivemedia.p034v3.internal;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bhd */
/* loaded from: classes2.dex */
public final class bhd implements ParameterizedType, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    private final Type f5712a;

    /* renamed from: b */
    private final Type f5713b;

    /* renamed from: c */
    private final Type[] f5714c;

    public bhd(Type type, Type type2, Type... typeArr) {
        if (type2 instanceof Class) {
            Class cls = (Class) type2;
            boolean z = true;
            boolean z2 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
            if (type == null && !z2) {
                z = false;
            }
            axd.m4404h(z);
        }
        this.f5712a = type == null ? null : bhf.m3691d(type);
        this.f5713b = bhf.m3691d(type2);
        Type[] typeArr2 = (Type[]) typeArr.clone();
        this.f5714c = typeArr2;
        int length = typeArr2.length;
        for (int i = 0; i < length; i++) {
            axd.m4403i(this.f5714c[i]);
            bhf.m3686i(this.f5714c[i]);
            Type[] typeArr3 = this.f5714c;
            typeArr3[i] = bhf.m3691d(typeArr3[i]);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && bhf.m3684k(this, (ParameterizedType) obj);
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return (Type[]) this.f5714c.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.f5712a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f5713b;
    }

    public final int hashCode() {
        int hashCode = Arrays.hashCode(this.f5714c) ^ this.f5713b.hashCode();
        Type type = this.f5712a;
        return hashCode ^ (type != null ? type.hashCode() : 0);
    }

    public final String toString() {
        int length = this.f5714c.length;
        if (length == 0) {
            return bhf.m3693b(this.f5713b);
        }
        StringBuilder sb = new StringBuilder((length + 1) * 30);
        sb.append(bhf.m3693b(this.f5713b));
        sb.append("<");
        sb.append(bhf.m3693b(this.f5714c[0]));
        for (int i = 1; i < length; i++) {
            sb.append(", ");
            sb.append(bhf.m3693b(this.f5714c[i]));
        }
        sb.append(">");
        return sb.toString();
    }
}
