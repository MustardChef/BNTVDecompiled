package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.exifinterface.media.ExifInterface;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.methodSignatureMapping;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt;

/* compiled from: methodSignatureMapping.kt */
/* loaded from: classes4.dex */
final class JvmTypeFactoryImpl implements JvmTypeFactory<methodSignatureMapping> {
    public static final JvmTypeFactoryImpl INSTANCE = new JvmTypeFactoryImpl();

    /* compiled from: methodSignatureMapping.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PrimitiveType.values().length];
            iArr[PrimitiveType.BOOLEAN.ordinal()] = 1;
            iArr[PrimitiveType.CHAR.ordinal()] = 2;
            iArr[PrimitiveType.BYTE.ordinal()] = 3;
            iArr[PrimitiveType.SHORT.ordinal()] = 4;
            iArr[PrimitiveType.INT.ordinal()] = 5;
            iArr[PrimitiveType.FLOAT.ordinal()] = 6;
            iArr[PrimitiveType.LONG.ordinal()] = 7;
            iArr[PrimitiveType.DOUBLE.ordinal()] = 8;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private JvmTypeFactoryImpl() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public methodSignatureMapping boxType(methodSignatureMapping possiblyPrimitiveType) {
        Intrinsics.checkNotNullParameter(possiblyPrimitiveType, "possiblyPrimitiveType");
        if (possiblyPrimitiveType instanceof methodSignatureMapping.Primitive) {
            methodSignatureMapping.Primitive primitive = (methodSignatureMapping.Primitive) possiblyPrimitiveType;
            if (primitive.getJvmPrimitiveType() != null) {
                String internalName = JvmClassName.byFqNameWithoutInnerClasses(primitive.getJvmPrimitiveType().getWrapperFqName()).getInternalName();
                Intrinsics.checkNotNullExpressionValue(internalName, "byFqNameWithoutInnerClas…apperFqName).internalName");
                return createObjectType(internalName);
            }
            return possiblyPrimitiveType;
        }
        return possiblyPrimitiveType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public methodSignatureMapping createFromString(String representation) {
        JvmPrimitiveType jvmPrimitiveType;
        Intrinsics.checkNotNullParameter(representation, "representation");
        String str = representation;
        str.length();
        char charAt = representation.charAt(0);
        JvmPrimitiveType[] values = JvmPrimitiveType.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                jvmPrimitiveType = null;
                break;
            }
            jvmPrimitiveType = values[i];
            if (jvmPrimitiveType.getDesc().charAt(0) == charAt) {
                break;
            }
            i++;
        }
        if (jvmPrimitiveType != null) {
            return new methodSignatureMapping.Primitive(jvmPrimitiveType);
        }
        if (charAt == 'V') {
            return new methodSignatureMapping.Primitive(null);
        }
        if (charAt == '[') {
            String substring = representation.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return new methodSignatureMapping.Array(createFromString(substring));
        }
        if (charAt == 'L') {
            StringsKt.endsWith$default((CharSequence) str, ';', false, 2, (Object) null);
        }
        String substring2 = representation.substring(1, representation.length() - 1);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
        return new methodSignatureMapping.Object(substring2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public methodSignatureMapping createPrimitiveType(PrimitiveType primitiveType) {
        Intrinsics.checkNotNullParameter(primitiveType, "primitiveType");
        switch (WhenMappings.$EnumSwitchMapping$0[primitiveType.ordinal()]) {
            case 1:
                return methodSignatureMapping.Companion.getBOOLEAN$descriptors_jvm();
            case 2:
                return methodSignatureMapping.Companion.getCHAR$descriptors_jvm();
            case 3:
                return methodSignatureMapping.Companion.getBYTE$descriptors_jvm();
            case 4:
                return methodSignatureMapping.Companion.getSHORT$descriptors_jvm();
            case 5:
                return methodSignatureMapping.Companion.getINT$descriptors_jvm();
            case 6:
                return methodSignatureMapping.Companion.getFLOAT$descriptors_jvm();
            case 7:
                return methodSignatureMapping.Companion.getLONG$descriptors_jvm();
            case 8:
                return methodSignatureMapping.Companion.getDOUBLE$descriptors_jvm();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public methodSignatureMapping createObjectType(String internalName) {
        Intrinsics.checkNotNullParameter(internalName, "internalName");
        return new methodSignatureMapping.Object(internalName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public String toString(methodSignatureMapping type) {
        String desc;
        Intrinsics.checkNotNullParameter(type, "type");
        if (type instanceof methodSignatureMapping.Array) {
            return '[' + toString(((methodSignatureMapping.Array) type).getElementType());
        } else if (type instanceof methodSignatureMapping.Primitive) {
            JvmPrimitiveType jvmPrimitiveType = ((methodSignatureMapping.Primitive) type).getJvmPrimitiveType();
            return (jvmPrimitiveType == null || (desc = jvmPrimitiveType.getDesc()) == null) ? ExifInterface.GPS_MEASUREMENT_INTERRUPTED : desc;
        } else if (type instanceof methodSignatureMapping.Object) {
            return 'L' + ((methodSignatureMapping.Object) type).getInternalName() + ';';
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public methodSignatureMapping getJavaLangClassType() {
        return createObjectType("java/lang/Class");
    }
}
