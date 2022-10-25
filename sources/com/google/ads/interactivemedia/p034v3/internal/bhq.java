package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.math.BigDecimal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bhq */
/* loaded from: classes2.dex */
public final class bhq extends Number {

    /* renamed from: a */
    private final String f5743a;

    public bhq(String str) {
        this.f5743a = str;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() throws ObjectStreamException {
        return new BigDecimal(this.f5743a);
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.f5743a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof bhq) {
            String str = this.f5743a;
            String str2 = ((bhq) obj).f5743a;
            return str == str2 || str.equals(str2);
        }
        return false;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.f5743a);
    }

    public final int hashCode() {
        return this.f5743a.hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        try {
            try {
                return Integer.parseInt(this.f5743a);
            } catch (NumberFormatException unused) {
                return new BigDecimal(this.f5743a).intValue();
            }
        } catch (NumberFormatException unused2) {
            return (int) Long.parseLong(this.f5743a);
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        try {
            return Long.parseLong(this.f5743a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f5743a).longValue();
        }
    }

    public final String toString() {
        return this.f5743a;
    }
}
