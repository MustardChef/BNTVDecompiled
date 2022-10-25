package kotlin.reflect.jvm.internal.impl.builtins.functions;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;

/* compiled from: FunctionClassKind.kt */
/* loaded from: classes4.dex */
public enum FunctionClassKind {
    Function(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, "Function", false, false),
    SuspendFunction(StandardNames.COROUTINES_PACKAGE_FQ_NAME, "SuspendFunction", true, false),
    KFunction(StandardNames.KOTLIN_REFLECT_FQ_NAME, "KFunction", false, true),
    KSuspendFunction(StandardNames.KOTLIN_REFLECT_FQ_NAME, "KSuspendFunction", true, true);
    
    public static final Companion Companion = new Companion(null);
    private final String classNamePrefix;
    private final boolean isReflectType;
    private final boolean isSuspendType;
    private final FqName packageFqName;

    FunctionClassKind(FqName fqName, String str, boolean z, boolean z2) {
        this.packageFqName = fqName;
        this.classNamePrefix = str;
        this.isSuspendType = z;
        this.isReflectType = z2;
    }

    public final FqName getPackageFqName() {
        return this.packageFqName;
    }

    public final String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    public final Name numberedClassName(int i) {
        Name identifier = Name.identifier(this.classNamePrefix + i);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"$classNamePrefix$arity\")");
        return identifier;
    }

    /* compiled from: FunctionClassKind.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FunctionClassKind byClassNamePrefix(FqName packageFqName, String className) {
            FunctionClassKind[] values;
            Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
            Intrinsics.checkNotNullParameter(className, "className");
            for (FunctionClassKind functionClassKind : FunctionClassKind.values()) {
                if (Intrinsics.areEqual(functionClassKind.getPackageFqName(), packageFqName) && StringsKt.startsWith$default(className, functionClassKind.getClassNamePrefix(), false, 2, (Object) null)) {
                    return functionClassKind;
                }
            }
            return null;
        }

        /* compiled from: FunctionClassKind.kt */
        /* loaded from: classes4.dex */
        public static final class KindWithArity {
            private final int arity;
            private final FunctionClassKind kind;

            public final FunctionClassKind component1() {
                return this.kind;
            }

            public final int component2() {
                return this.arity;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof KindWithArity) {
                    KindWithArity kindWithArity = (KindWithArity) obj;
                    return this.kind == kindWithArity.kind && this.arity == kindWithArity.arity;
                }
                return false;
            }

            public int hashCode() {
                return (this.kind.hashCode() * 31) + this.arity;
            }

            public String toString() {
                return "KindWithArity(kind=" + this.kind + ", arity=" + this.arity + ')';
            }

            public KindWithArity(FunctionClassKind kind, int i) {
                Intrinsics.checkNotNullParameter(kind, "kind");
                this.kind = kind;
                this.arity = i;
            }

            public final FunctionClassKind getKind() {
                return this.kind;
            }
        }

        public final KindWithArity parseClassName(String className, FqName packageFqName) {
            Intrinsics.checkNotNullParameter(className, "className");
            Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
            FunctionClassKind byClassNamePrefix = byClassNamePrefix(packageFqName, className);
            if (byClassNamePrefix == null) {
                return null;
            }
            String substring = className.substring(byClassNamePrefix.getClassNamePrefix().length());
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            Integer num = toInt(substring);
            if (num != null) {
                return new KindWithArity(byClassNamePrefix, num.intValue());
            }
            return null;
        }

        @JvmStatic
        public final FunctionClassKind getFunctionalClassKind(String className, FqName packageFqName) {
            Intrinsics.checkNotNullParameter(className, "className");
            Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
            KindWithArity parseClassName = parseClassName(className, packageFqName);
            if (parseClassName != null) {
                return parseClassName.getKind();
            }
            return null;
        }

        private final Integer toInt(String str) {
            if (str.length() == 0) {
                return null;
            }
            int length = str.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                int charAt = str.charAt(i2) - '0';
                if (!(charAt >= 0 && charAt < 10)) {
                    return null;
                }
                i = (i * 10) + charAt;
            }
            return Integer.valueOf(i);
        }
    }
}
