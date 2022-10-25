package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bkl */
/* loaded from: classes2.dex */
final class bkl extends bkk {

    /* renamed from: a */
    private static Class f5942a;

    /* renamed from: b */
    private final Object f5943b;

    /* renamed from: c */
    private final Field f5944c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bkl() {
        Object obj;
        Field field = null;
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f5942a = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            obj = declaredField.get(null);
        } catch (Exception unused) {
            obj = null;
        }
        this.f5943b = obj;
        try {
            field = AccessibleObject.class.getDeclaredField("override");
        } catch (Exception unused2) {
        }
        this.f5944c = field;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkk
    /* renamed from: a */
    public final void mo3606a(AccessibleObject accessibleObject) {
        if (this.f5943b != null && this.f5944c != null) {
            try {
                f5942a.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.f5943b, accessibleObject, Long.valueOf(((Long) f5942a.getMethod("objectFieldOffset", Field.class).invoke(this.f5943b, this.f5944c)).longValue()), true);
                return;
            } catch (Exception unused) {
            }
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e) {
            String valueOf = String.valueOf(accessibleObject);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 154);
            sb.append("Gson couldn't modify fields for ");
            sb.append(valueOf);
            sb.append("\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.");
            throw new bgn(sb.toString(), e);
        }
    }
}
