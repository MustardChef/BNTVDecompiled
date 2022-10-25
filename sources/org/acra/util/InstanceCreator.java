package org.acra.util;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;

/* compiled from: InstanceCreator.kt */
@Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00040\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\bH\u0007¢\u0006\u0002\u0010\tJ'\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\u0010\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00040\u0006H\u0007¢\u0006\u0002\u0010\nJ*\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00040\u000b\"\u0004\b\u0000\u0010\u00042\u0014\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00040\u00060\rH\u0007¨\u0006\u000e"}, m107d2 = {"Lorg/acra/util/InstanceCreator;", "", "()V", "create", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "fallback", "Lkotlin/Function0;", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "(Ljava/lang/Class;)Ljava/lang/Object;", "", "classes", "", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class InstanceCreator {
    public static final InstanceCreator INSTANCE = new InstanceCreator();

    private InstanceCreator() {
    }

    @JvmStatic
    public static final <T> T create(Class<? extends T> clazz, Functions<? extends T> fallback) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        T t = (T) create(clazz);
        return t == null ? fallback.invoke() : t;
    }

    @JvmStatic
    public static final <T> T create(Class<? extends T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        try {
            return clazz.newInstance();
        } catch (IllegalAccessException e) {
            ACRA.log.mo66e(ACRA.LOG_TAG, Intrinsics.stringPlus("Failed to create instance of class ", clazz.getName()), e);
            return null;
        } catch (InstantiationException e2) {
            ACRA.log.mo66e(ACRA.LOG_TAG, Intrinsics.stringPlus("Failed to create instance of class ", clazz.getName()), e2);
            return null;
        }
    }

    @JvmStatic
    public static final <T> List<T> create(Collection<? extends Class<? extends T>> classes) {
        Intrinsics.checkNotNullParameter(classes, "classes");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = classes.iterator();
        while (it.hasNext()) {
            Object create = create((Class) it.next());
            if (create != null) {
                arrayList.add(create);
            }
        }
        return arrayList;
    }
}
