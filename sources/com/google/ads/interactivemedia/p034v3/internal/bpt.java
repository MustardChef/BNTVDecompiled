package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bpt */
/* loaded from: classes2.dex */
public abstract class bpt {

    /* renamed from: a */
    final Unsafe f6398a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bpt(Unsafe unsafe) {
        this.f6398a = unsafe;
    }

    /* renamed from: a */
    public abstract byte mo2934a(long j);

    /* renamed from: b */
    public abstract double mo2933b(Object obj, long j);

    /* renamed from: c */
    public abstract float mo2932c(Object obj, long j);

    /* renamed from: d */
    public abstract void mo2931d(long j, byte[] bArr, long j2, long j3);

    /* renamed from: e */
    public abstract void mo2930e(Object obj, long j, boolean z);

    /* renamed from: f */
    public abstract void mo2929f(Object obj, long j, byte b);

    /* renamed from: g */
    public abstract void mo2928g(Object obj, long j, double d);

    /* renamed from: h */
    public abstract void mo2927h(Object obj, long j, float f);

    /* renamed from: i */
    public abstract boolean mo2926i(Object obj, long j);

    /* renamed from: j */
    public final int m2925j(Class cls) {
        return this.f6398a.arrayBaseOffset(cls);
    }

    /* renamed from: k */
    public final int m2924k(Class cls) {
        return this.f6398a.arrayIndexScale(cls);
    }

    /* renamed from: l */
    public final int m2923l(Object obj, long j) {
        return this.f6398a.getInt(obj, j);
    }

    /* renamed from: m */
    public final long m2922m(Object obj, long j) {
        return this.f6398a.getLong(obj, j);
    }

    /* renamed from: n */
    public final long m2921n(Field field) {
        return this.f6398a.objectFieldOffset(field);
    }

    /* renamed from: o */
    public final Object m2920o(Object obj, long j) {
        return this.f6398a.getObject(obj, j);
    }

    /* renamed from: p */
    public final void m2919p(Object obj, long j, int i) {
        this.f6398a.putInt(obj, j, i);
    }

    /* renamed from: q */
    public final void m2918q(Object obj, long j, long j2) {
        this.f6398a.putLong(obj, j, j2);
    }

    /* renamed from: r */
    public final void m2917r(Object obj, long j, Object obj2) {
        this.f6398a.putObject(obj, j, obj2);
    }

    /* renamed from: s */
    public final boolean m2916s() {
        Unsafe unsafe = this.f6398a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("arrayIndexScale", Class.class);
                cls.getMethod("getInt", Object.class, Long.TYPE);
                cls.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                cls.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
                cls.getMethod("getObject", Object.class, Long.TYPE);
                cls.getMethod("putObject", Object.class, Long.TYPE, Object.class);
                return true;
            } catch (Throwable th) {
                Logger.getLogger(bpu.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
            }
        }
        return false;
    }

    /* renamed from: t */
    public final boolean m2915t() {
        Field m2908G;
        Unsafe unsafe = this.f6398a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                m2908G = bpu.m2908G();
                return m2908G != null;
            } catch (Throwable th) {
                Logger.getLogger(bpu.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
            }
        }
        return false;
    }
}
