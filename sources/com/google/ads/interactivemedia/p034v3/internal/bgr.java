package com.google.ads.interactivemedia.p034v3.internal;

import java.math.BigInteger;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bgr */
/* loaded from: classes2.dex */
public final class bgr extends bgm {

    /* renamed from: a */
    private final Object f5699a;

    public bgr(Boolean bool) {
        this.f5699a = bool;
    }

    public bgr(Number number) {
        this.f5699a = number;
    }

    public bgr(String str) {
        axd.m4403i(str);
        this.f5699a = str;
    }

    /* renamed from: g */
    private static boolean m3703g(bgr bgrVar) {
        Object obj = bgrVar.f5699a;
        if (obj instanceof Number) {
            Number number = (Number) obj;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }
        return false;
    }

    /* renamed from: a */
    public final Number m3709a() {
        Object obj = this.f5699a;
        return obj instanceof String ? new bhq((String) obj) : (Number) obj;
    }

    /* renamed from: b */
    public final String m3708b() {
        if (m3705e()) {
            return m3709a().toString();
        }
        if (m3706d()) {
            return ((Boolean) this.f5699a).toString();
        }
        return (String) this.f5699a;
    }

    /* renamed from: c */
    public final boolean m3707c() {
        if (m3706d()) {
            return ((Boolean) this.f5699a).booleanValue();
        }
        return Boolean.parseBoolean(m3708b());
    }

    /* renamed from: d */
    public final boolean m3706d() {
        return this.f5699a instanceof Boolean;
    }

    /* renamed from: e */
    public final boolean m3705e() {
        return this.f5699a instanceof Number;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        bgr bgrVar = (bgr) obj;
        if (m3703g(this) && m3703g(bgrVar)) {
            return m3709a().longValue() == bgrVar.m3709a().longValue();
        }
        Object obj2 = this.f5699a;
        if (!(obj2 instanceof Number) || !(bgrVar.f5699a instanceof Number)) {
            return obj2.equals(bgrVar.f5699a);
        }
        double doubleValue = m3709a().doubleValue();
        double doubleValue2 = bgrVar.m3709a().doubleValue();
        if (doubleValue != doubleValue2) {
            return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
        }
        return true;
    }

    /* renamed from: f */
    public final boolean m3704f() {
        return this.f5699a instanceof String;
    }

    public final int hashCode() {
        long doubleToLongBits;
        if (m3703g(this)) {
            doubleToLongBits = m3709a().longValue();
        } else {
            Object obj = this.f5699a;
            if (obj instanceof Number) {
                doubleToLongBits = Double.doubleToLongBits(m3709a().doubleValue());
            } else {
                return obj.hashCode();
            }
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }
}
