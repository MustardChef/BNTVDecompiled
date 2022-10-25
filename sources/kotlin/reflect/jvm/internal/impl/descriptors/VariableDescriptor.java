package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;

/* loaded from: classes4.dex */
public interface VariableDescriptor extends ValueDescriptor {
    ConstantValue<?> getCompileTimeInitializer();

    boolean isConst();

    boolean isLateInit();

    boolean isVar();
}
