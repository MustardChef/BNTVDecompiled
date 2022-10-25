package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;

/* compiled from: JvmFlags.kt */
/* loaded from: classes4.dex */
public final class JvmFlags {
    private static final Flags.BooleanFlagField IS_COMPILED_IN_COMPATIBILITY_MODE;
    private static final Flags.BooleanFlagField IS_COMPILED_IN_JVM_DEFAULT_MODE;
    public static final JvmFlags INSTANCE = new JvmFlags();
    private static final Flags.BooleanFlagField IS_MOVED_FROM_INTERFACE_COMPANION = Flags.FlagField.booleanFirst();

    private JvmFlags() {
    }

    static {
        Flags.BooleanFlagField booleanFirst = Flags.FlagField.booleanFirst();
        IS_COMPILED_IN_JVM_DEFAULT_MODE = booleanFirst;
        IS_COMPILED_IN_COMPATIBILITY_MODE = Flags.FlagField.booleanAfter(booleanFirst);
    }

    public final Flags.BooleanFlagField getIS_MOVED_FROM_INTERFACE_COMPANION() {
        return IS_MOVED_FROM_INTERFACE_COMPANION;
    }
}
