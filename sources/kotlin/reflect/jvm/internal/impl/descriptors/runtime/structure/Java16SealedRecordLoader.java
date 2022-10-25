package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReflectJavaClass.kt */
/* loaded from: classes4.dex */
final class Java16SealedRecordLoader {
    public static final Java16SealedRecordLoader INSTANCE = new Java16SealedRecordLoader();
    private static Cache _cache;

    /* compiled from: ReflectJavaClass.kt */
    /* loaded from: classes4.dex */
    public static final class Cache {
        private final Method getPermittedSubclasses;
        private final Method getRecordComponents;
        private final Method isRecord;
        private final Method isSealed;

        public Cache(Method method, Method method2, Method method3, Method method4) {
            this.isSealed = method;
            this.getPermittedSubclasses = method2;
            this.isRecord = method3;
            this.getRecordComponents = method4;
        }

        public final Method isSealed() {
            return this.isSealed;
        }

        public final Method getGetPermittedSubclasses() {
            return this.getPermittedSubclasses;
        }

        public final Method isRecord() {
            return this.isRecord;
        }

        public final Method getGetRecordComponents() {
            return this.getRecordComponents;
        }
    }

    private Java16SealedRecordLoader() {
    }

    private final Cache buildCache() {
        try {
            return new Cache(Class.class.getMethod("isSealed", new Class[0]), Class.class.getMethod("getPermittedSubclasses", new Class[0]), Class.class.getMethod("isRecord", new Class[0]), Class.class.getMethod("getRecordComponents", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return new Cache(null, null, null, null);
        }
    }

    private final Cache initCache() {
        Cache cache = _cache;
        if (cache == null) {
            Cache buildCache = buildCache();
            _cache = buildCache;
            return buildCache;
        }
        return cache;
    }

    public final Boolean loadIsSealed(Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Method isSealed = initCache().isSealed();
        if (isSealed == null) {
            return null;
        }
        Object invoke = isSealed.invoke(clazz, new Object[0]);
        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.Boolean");
        return Boolean.valueOf(((Boolean) invoke).booleanValue());
    }

    public final Class<?>[] loadGetPermittedSubclasses(Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Method getPermittedSubclasses = initCache().getGetPermittedSubclasses();
        if (getPermittedSubclasses == null) {
            return null;
        }
        Object invoke = getPermittedSubclasses.invoke(clazz, new Object[0]);
        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
        return (Class[]) invoke;
    }

    public final Boolean loadIsRecord(Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Method isRecord = initCache().isRecord();
        if (isRecord == null) {
            return null;
        }
        Object invoke = isRecord.invoke(clazz, new Object[0]);
        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.Boolean");
        return Boolean.valueOf(((Boolean) invoke).booleanValue());
    }

    public final Object[] loadGetRecordComponents(Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Method getRecordComponents = initCache().getGetRecordComponents();
        if (getRecordComponents == null) {
            return null;
        }
        return (Object[]) getRecordComponents.invoke(clazz, new Object[0]);
    }
}
