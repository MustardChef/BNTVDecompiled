package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpecialNames.kt */
/* loaded from: classes4.dex */
public final class SpecialNames {
    public static final Name ANONYMOUS;
    public static final Name DEFAULT_NAME_FOR_COMPANION_OBJECT;
    public static final Name DESTRUCT;
    public static final Name IMPLICIT_SET_PARAMETER;
    public static final Name INIT;
    public static final SpecialNames INSTANCE = new SpecialNames();
    public static final Name ITERATOR;
    public static final Name LOCAL;
    public static final Name NO_NAME_PROVIDED;
    public static final Name ROOT_PACKAGE;
    public static final Name SAFE_IDENTIFIER_FOR_NO_NAME;
    public static final Name THIS;
    public static final Name UNARY;
    public static final Name UNDERSCORE_FOR_UNUSED_VAR;

    private SpecialNames() {
    }

    static {
        Name special = Name.special("<no name provided>");
        Intrinsics.checkNotNullExpressionValue(special, "special(\"<no name provided>\")");
        NO_NAME_PROVIDED = special;
        Name special2 = Name.special("<root package>");
        Intrinsics.checkNotNullExpressionValue(special2, "special(\"<root package>\")");
        ROOT_PACKAGE = special2;
        Name identifier = Name.identifier("Companion");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"Companion\")");
        DEFAULT_NAME_FOR_COMPANION_OBJECT = identifier;
        Name identifier2 = Name.identifier("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(\"no_name_in_P…_4cd0_b7f5_b46aa3cd5d40\")");
        SAFE_IDENTIFIER_FOR_NO_NAME = identifier2;
        Name special3 = Name.special("<anonymous>");
        Intrinsics.checkNotNullExpressionValue(special3, "special(ANONYMOUS_STRING)");
        ANONYMOUS = special3;
        Name special4 = Name.special("<unary>");
        Intrinsics.checkNotNullExpressionValue(special4, "special(\"<unary>\")");
        UNARY = special4;
        Name special5 = Name.special("<this>");
        Intrinsics.checkNotNullExpressionValue(special5, "special(\"<this>\")");
        THIS = special5;
        Name special6 = Name.special("<init>");
        Intrinsics.checkNotNullExpressionValue(special6, "special(\"<init>\")");
        INIT = special6;
        Name special7 = Name.special("<iterator>");
        Intrinsics.checkNotNullExpressionValue(special7, "special(\"<iterator>\")");
        ITERATOR = special7;
        Name special8 = Name.special("<destruct>");
        Intrinsics.checkNotNullExpressionValue(special8, "special(\"<destruct>\")");
        DESTRUCT = special8;
        Name special9 = Name.special("<local>");
        Intrinsics.checkNotNullExpressionValue(special9, "special(\"<local>\")");
        LOCAL = special9;
        Name special10 = Name.special("<unused var>");
        Intrinsics.checkNotNullExpressionValue(special10, "special(\"<unused var>\")");
        UNDERSCORE_FOR_UNUSED_VAR = special10;
        Name special11 = Name.special("<set-?>");
        Intrinsics.checkNotNullExpressionValue(special11, "special(\"<set-?>\")");
        IMPLICIT_SET_PARAMETER = special11;
    }

    @JvmStatic
    public static final Name safeIdentifier(Name name) {
        return (name == null || name.isSpecial()) ? SAFE_IDENTIFIER_FOR_NO_NAME : name;
    }

    public final boolean isSafeIdentifier(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String asString = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        return (asString.length() > 0) && !name.isSpecial();
    }
}
