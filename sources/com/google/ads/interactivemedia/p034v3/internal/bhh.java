package com.google.ads.interactivemedia.p034v3.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bhh */
/* loaded from: classes2.dex */
final class bhh implements bhz {

    /* renamed from: a */
    final /* synthetic */ Class f5719a;

    /* renamed from: b */
    final /* synthetic */ Type f5720b;

    /* renamed from: c */
    private final bie f5721c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bhh(Class cls, Type type) {
        bie bidVar;
        this.f5719a = cls;
        this.f5720b = type;
        try {
            Class<?> cls2 = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls2.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            bidVar = new bia(cls2.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    bidVar = new bib(declaredMethod2, intValue);
                } catch (Exception unused2) {
                    bidVar = new bid();
                }
            } catch (Exception unused3) {
                Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod3.setAccessible(true);
                bidVar = new bic(declaredMethod3);
            }
        }
        this.f5721c = bidVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bhz
    /* renamed from: a */
    public final Object mo3659a() {
        try {
            return this.f5721c.mo3642a(this.f5719a);
        } catch (Exception e) {
            String valueOf = String.valueOf(this.f5720b);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 119);
            sb.append("Unable to invoke no-args constructor for ");
            sb.append(valueOf);
            sb.append(". Registering an InstanceCreator with Gson for this type may fix this problem.");
            throw new RuntimeException(sb.toString(), e);
        }
    }
}
