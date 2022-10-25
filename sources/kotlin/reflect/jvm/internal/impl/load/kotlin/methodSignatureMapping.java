package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType */
/* loaded from: classes4.dex */
public abstract class methodSignatureMapping {
    public static final Companion Companion = new Companion(null);
    private static final Primitive BOOLEAN = new Primitive(JvmPrimitiveType.BOOLEAN);
    private static final Primitive CHAR = new Primitive(JvmPrimitiveType.CHAR);
    private static final Primitive BYTE = new Primitive(JvmPrimitiveType.BYTE);
    private static final Primitive SHORT = new Primitive(JvmPrimitiveType.SHORT);
    private static final Primitive INT = new Primitive(JvmPrimitiveType.INT);
    private static final Primitive FLOAT = new Primitive(JvmPrimitiveType.FLOAT);
    private static final Primitive LONG = new Primitive(JvmPrimitiveType.LONG);
    private static final Primitive DOUBLE = new Primitive(JvmPrimitiveType.DOUBLE);

    public /* synthetic */ methodSignatureMapping(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private methodSignatureMapping() {
    }

    /* compiled from: methodSignatureMapping.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType$Primitive */
    /* loaded from: classes4.dex */
    public static final class Primitive extends methodSignatureMapping {
        private final JvmPrimitiveType jvmPrimitiveType;

        public Primitive(JvmPrimitiveType jvmPrimitiveType) {
            super(null);
            this.jvmPrimitiveType = jvmPrimitiveType;
        }

        public final JvmPrimitiveType getJvmPrimitiveType() {
            return this.jvmPrimitiveType;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType$Object */
    /* loaded from: classes4.dex */
    public static final class Object extends methodSignatureMapping {
        private final String internalName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Object(String internalName) {
            super(null);
            Intrinsics.checkNotNullParameter(internalName, "internalName");
            this.internalName = internalName;
        }

        public final String getInternalName() {
            return this.internalName;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType$Array */
    /* loaded from: classes4.dex */
    public static final class Array extends methodSignatureMapping {
        private final methodSignatureMapping elementType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Array(methodSignatureMapping elementType) {
            super(null);
            Intrinsics.checkNotNullParameter(elementType, "elementType");
            this.elementType = elementType;
        }

        public final methodSignatureMapping getElementType() {
            return this.elementType;
        }
    }

    public String toString() {
        return JvmTypeFactoryImpl.INSTANCE.toString(this);
    }

    /* compiled from: methodSignatureMapping.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType$Companion */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Primitive getBOOLEAN$descriptors_jvm() {
            return methodSignatureMapping.BOOLEAN;
        }

        public final Primitive getCHAR$descriptors_jvm() {
            return methodSignatureMapping.CHAR;
        }

        public final Primitive getBYTE$descriptors_jvm() {
            return methodSignatureMapping.BYTE;
        }

        public final Primitive getSHORT$descriptors_jvm() {
            return methodSignatureMapping.SHORT;
        }

        public final Primitive getINT$descriptors_jvm() {
            return methodSignatureMapping.INT;
        }

        public final Primitive getFLOAT$descriptors_jvm() {
            return methodSignatureMapping.FLOAT;
        }

        public final Primitive getLONG$descriptors_jvm() {
            return methodSignatureMapping.LONG;
        }

        public final Primitive getDOUBLE$descriptors_jvm() {
            return methodSignatureMapping.DOUBLE;
        }
    }
}
