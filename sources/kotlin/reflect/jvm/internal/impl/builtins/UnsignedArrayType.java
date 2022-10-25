package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum UBYTEARRAY uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:289)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: UnsignedType.kt */
/* loaded from: classes4.dex */
public final class UnsignedArrayType {
    private static final /* synthetic */ UnsignedArrayType[] $VALUES;
    public static final UnsignedArrayType UBYTEARRAY;
    public static final UnsignedArrayType UINTARRAY;
    public static final UnsignedArrayType ULONGARRAY;
    public static final UnsignedArrayType USHORTARRAY;
    private final ClassId classId;
    private final Name typeName;

    private static final /* synthetic */ UnsignedArrayType[] $values() {
        return new UnsignedArrayType[]{UBYTEARRAY, USHORTARRAY, UINTARRAY, ULONGARRAY};
    }

    public static UnsignedArrayType valueOf(String str) {
        return (UnsignedArrayType) Enum.valueOf(UnsignedArrayType.class, str);
    }

    public static UnsignedArrayType[] values() {
        return (UnsignedArrayType[]) $VALUES.clone();
    }

    private UnsignedArrayType(String str, int i, ClassId classId) {
        this.classId = classId;
        Name shortClassName = classId.getShortClassName();
        Intrinsics.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
        this.typeName = shortClassName;
    }

    static {
        ClassId fromString = ClassId.fromString("kotlin/UByteArray");
        Intrinsics.checkNotNullExpressionValue(fromString, "fromString(\"kotlin/UByteArray\")");
        UBYTEARRAY = new UnsignedArrayType("UBYTEARRAY", 0, fromString);
        ClassId fromString2 = ClassId.fromString("kotlin/UShortArray");
        Intrinsics.checkNotNullExpressionValue(fromString2, "fromString(\"kotlin/UShortArray\")");
        USHORTARRAY = new UnsignedArrayType("USHORTARRAY", 1, fromString2);
        ClassId fromString3 = ClassId.fromString("kotlin/UIntArray");
        Intrinsics.checkNotNullExpressionValue(fromString3, "fromString(\"kotlin/UIntArray\")");
        UINTARRAY = new UnsignedArrayType("UINTARRAY", 2, fromString3);
        ClassId fromString4 = ClassId.fromString("kotlin/ULongArray");
        Intrinsics.checkNotNullExpressionValue(fromString4, "fromString(\"kotlin/ULongArray\")");
        ULONGARRAY = new UnsignedArrayType("ULONGARRAY", 3, fromString4);
        $VALUES = $values();
    }

    public final Name getTypeName() {
        return this.typeName;
    }
}
