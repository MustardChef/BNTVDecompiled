package com.google.ads.interactivemedia.p034v3.internal;

import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.reflect.Field;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.arm */
/* loaded from: classes2.dex */
public final class arm extends ark {

    /* renamed from: a */
    private final Object f4937a;

    private arm(Object obj) {
        this.f4937a = obj;
    }

    /* renamed from: c */
    public static arl m4733c(Object obj) {
        return new arm(obj);
    }

    /* renamed from: d */
    public static Object m4732d(arl arlVar) {
        if (arlVar instanceof arm) {
            return ((arm) arlVar).f4937a;
        }
        IBinder asBinder = arlVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i == 1) {
            if (!((Field) Preconditions.checkNotNull(field)).isAccessible()) {
                field.setAccessible(true);
                try {
                    return field.get(asBinder);
                } catch (IllegalAccessException e) {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
                } catch (NullPointerException e2) {
                    throw new IllegalArgumentException("Binder object is null.", e2);
                }
            }
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        int length = declaredFields.length;
        StringBuilder sb = new StringBuilder(64);
        sb.append("Unexpected number of IObjectWrapper declared fields: ");
        sb.append(length);
        throw new IllegalArgumentException(sb.toString());
    }
}
