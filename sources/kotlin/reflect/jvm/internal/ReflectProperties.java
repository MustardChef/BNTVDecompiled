package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Functions;

/* loaded from: classes4.dex */
public class ReflectProperties {
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        objArr[0] = "initializer";
        objArr[1] = "kotlin/reflect/jvm/internal/ReflectProperties";
        if (i == 1 || i == 2) {
            objArr[2] = "lazySoft";
        } else {
            objArr[2] = "lazy";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    /* loaded from: classes4.dex */
    public static abstract class Val<T> {
        private static final Object NULL_VALUE = new Object() { // from class: kotlin.reflect.jvm.internal.ReflectProperties.Val.1
        };

        public abstract T invoke();

        public final T getValue(Object obj, Object obj2) {
            return invoke();
        }

        protected Object escape(T t) {
            return t == null ? NULL_VALUE : t;
        }

        /* JADX WARN: Multi-variable type inference failed */
        protected T unescape(Object obj) {
            if (obj == NULL_VALUE) {
                return null;
            }
            return obj;
        }
    }

    /* loaded from: classes4.dex */
    public static class LazyVal<T> extends Val<T> {
        private final Functions<T> initializer;
        private volatile Object value;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", "<init>"));
        }

        public LazyVal(Functions<T> functions) {
            if (functions == null) {
                $$$reportNull$$$0(0);
            }
            this.value = null;
            this.initializer = functions;
        }

        @Override // kotlin.reflect.jvm.internal.ReflectProperties.Val, kotlin.jvm.functions.Functions
        public T invoke() {
            Object obj = this.value;
            if (obj != null) {
                return unescape(obj);
            }
            T invoke = this.initializer.invoke();
            this.value = escape(invoke);
            return invoke;
        }
    }

    /* loaded from: classes4.dex */
    public static class LazySoftVal<T> extends Val<T> implements Functions<T> {
        private final Functions<T> initializer;
        private volatile SoftReference<Object> value;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
        }

        public LazySoftVal(T t, Functions<T> functions) {
            if (functions == null) {
                $$$reportNull$$$0(0);
            }
            this.value = null;
            this.initializer = functions;
            if (t != null) {
                this.value = new SoftReference<>(escape(t));
            }
        }

        @Override // kotlin.reflect.jvm.internal.ReflectProperties.Val, kotlin.jvm.functions.Functions
        public T invoke() {
            Object obj;
            SoftReference<Object> softReference = this.value;
            if (softReference != null && (obj = softReference.get()) != null) {
                return unescape(obj);
            }
            T invoke = this.initializer.invoke();
            this.value = new SoftReference<>(escape(invoke));
            return invoke;
        }
    }

    public static <T> LazyVal<T> lazy(Functions<T> functions) {
        if (functions == null) {
            $$$reportNull$$$0(0);
        }
        return new LazyVal<>(functions);
    }

    public static <T> LazySoftVal<T> lazySoft(T t, Functions<T> functions) {
        if (functions == null) {
            $$$reportNull$$$0(1);
        }
        return new LazySoftVal<>(t, functions);
    }

    public static <T> LazySoftVal<T> lazySoft(Functions<T> functions) {
        if (functions == null) {
            $$$reportNull$$$0(2);
        }
        return lazySoft(null, functions);
    }
}
