package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.util.Check;

/* compiled from: modifierChecks.kt */
/* loaded from: classes4.dex */
public abstract class ReturnsCheck implements Check {
    private final String description;
    private final String name;
    private final Function1<KotlinBuiltIns, KotlinType> type;

    public /* synthetic */ ReturnsCheck(String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ReturnsCheck(String str, Function1<? super KotlinBuiltIns, ? extends KotlinType> function1) {
        this.name = str;
        this.type = function1;
        this.description = "must return " + str;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String invoke(FunctionDescriptor functionDescriptor) {
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String getDescription() {
        return this.description;
    }

    /* compiled from: modifierChecks.kt */
    /* loaded from: classes4.dex */
    public static final class ReturnsBoolean extends ReturnsCheck {
        public static final ReturnsBoolean INSTANCE = new ReturnsBoolean();

        /* compiled from: modifierChecks.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck$ReturnsBoolean$1 */
        /* loaded from: classes4.dex */
        static final class C52681 extends Lambda implements Function1<KotlinBuiltIns, KotlinType> {
            public static final C52681 INSTANCE = new C52681();

            C52681() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final KotlinType invoke(KotlinBuiltIns kotlinBuiltIns) {
                Intrinsics.checkNotNullParameter(kotlinBuiltIns, "$this$null");
                SimpleType booleanType = kotlinBuiltIns.getBooleanType();
                Intrinsics.checkNotNullExpressionValue(booleanType, "booleanType");
                return booleanType;
            }
        }

        private ReturnsBoolean() {
            super("Boolean", C52681.INSTANCE, null);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        return Intrinsics.areEqual(functionDescriptor.getReturnType(), this.type.invoke(DescriptorUtils.getBuiltIns(functionDescriptor)));
    }

    /* compiled from: modifierChecks.kt */
    /* loaded from: classes4.dex */
    public static final class ReturnsInt extends ReturnsCheck {
        public static final ReturnsInt INSTANCE = new ReturnsInt();

        /* compiled from: modifierChecks.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck$ReturnsInt$1 */
        /* loaded from: classes4.dex */
        static final class C52691 extends Lambda implements Function1<KotlinBuiltIns, KotlinType> {
            public static final C52691 INSTANCE = new C52691();

            C52691() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final KotlinType invoke(KotlinBuiltIns kotlinBuiltIns) {
                Intrinsics.checkNotNullParameter(kotlinBuiltIns, "$this$null");
                SimpleType intType = kotlinBuiltIns.getIntType();
                Intrinsics.checkNotNullExpressionValue(intType, "intType");
                return intType;
            }
        }

        private ReturnsInt() {
            super("Int", C52691.INSTANCE, null);
        }
    }

    /* compiled from: modifierChecks.kt */
    /* loaded from: classes4.dex */
    public static final class ReturnsUnit extends ReturnsCheck {
        public static final ReturnsUnit INSTANCE = new ReturnsUnit();

        /* compiled from: modifierChecks.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck$ReturnsUnit$1 */
        /* loaded from: classes4.dex */
        static final class C52701 extends Lambda implements Function1<KotlinBuiltIns, KotlinType> {
            public static final C52701 INSTANCE = new C52701();

            C52701() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final KotlinType invoke(KotlinBuiltIns kotlinBuiltIns) {
                Intrinsics.checkNotNullParameter(kotlinBuiltIns, "$this$null");
                SimpleType unitType = kotlinBuiltIns.getUnitType();
                Intrinsics.checkNotNullExpressionValue(unitType, "unitType");
                return unitType;
            }
        }

        private ReturnsUnit() {
            super("Unit", C52701.INSTANCE, null);
        }
    }
}
