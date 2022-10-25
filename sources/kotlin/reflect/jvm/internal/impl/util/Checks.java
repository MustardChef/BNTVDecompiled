package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.CheckResult;
import kotlin.text.Regex;

/* compiled from: modifierChecks.kt */
/* loaded from: classes4.dex */
public final class Checks {
    private final Function1<FunctionDescriptor, String> additionalCheck;
    private final Check[] checks;
    private final Name name;
    private final Collection<Name> nameList;
    private final Regex regex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: modifierChecks.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.util.Checks$2 */
    /* loaded from: classes4.dex */
    public static final class C52652 extends Lambda implements Function1 {
        public static final C52652 INSTANCE = new C52652();

        C52652() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Void invoke(FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "$this$null");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: modifierChecks.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.util.Checks$3 */
    /* loaded from: classes4.dex */
    public static final class C52663 extends Lambda implements Function1 {
        public static final C52663 INSTANCE = new C52663();

        C52663() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Void invoke(FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "$this$null");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: modifierChecks.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.util.Checks$4 */
    /* loaded from: classes4.dex */
    public static final class C52674 extends Lambda implements Function1 {
        public static final C52674 INSTANCE = new C52674();

        C52674() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Void invoke(FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "$this$null");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Checks(Name name, Regex regex, Collection<Name> collection, Function1<? super FunctionDescriptor, String> function1, Check... checkArr) {
        this.name = name;
        this.regex = regex;
        this.nameList = collection;
        this.additionalCheck = function1;
        this.checks = checkArr;
    }

    public final boolean isApplicable(FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        if (this.name == null || Intrinsics.areEqual(functionDescriptor.getName(), this.name)) {
            if (this.regex != null) {
                String asString = functionDescriptor.getName().asString();
                Intrinsics.checkNotNullExpressionValue(asString, "functionDescriptor.name.asString()");
                if (!this.regex.matches(asString)) {
                    return false;
                }
            }
            Collection<Name> collection = this.nameList;
            return collection == null || collection.contains(functionDescriptor.getName());
        }
        return false;
    }

    public final CheckResult checkAll(FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        for (Check check : this.checks) {
            String invoke = check.invoke(functionDescriptor);
            if (invoke != null) {
                return new CheckResult.IllegalSignature(invoke);
            }
        }
        String invoke2 = this.additionalCheck.invoke(functionDescriptor);
        if (invoke2 != null) {
            return new CheckResult.IllegalSignature(invoke2);
        }
        return CheckResult.SuccessCheck.INSTANCE;
    }

    public /* synthetic */ Checks(Name name, Check[] checkArr, C52652 c52652, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(name, checkArr, (i & 4) != 0 ? C52652.INSTANCE : c52652);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Checks(Name name, Check[] checks, Function1<? super FunctionDescriptor, String> additionalChecks) {
        this(name, (Regex) null, (Collection<Name>) null, additionalChecks, (Check[]) Arrays.copyOf(checks, checks.length));
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(checks, "checks");
        Intrinsics.checkNotNullParameter(additionalChecks, "additionalChecks");
    }

    public /* synthetic */ Checks(Regex regex, Check[] checkArr, C52663 c52663, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(regex, checkArr, (i & 4) != 0 ? C52663.INSTANCE : c52663);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Checks(Regex regex, Check[] checks, Function1<? super FunctionDescriptor, String> additionalChecks) {
        this((Name) null, regex, (Collection<Name>) null, additionalChecks, (Check[]) Arrays.copyOf(checks, checks.length));
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(checks, "checks");
        Intrinsics.checkNotNullParameter(additionalChecks, "additionalChecks");
    }

    public /* synthetic */ Checks(Collection collection, Check[] checkArr, C52674 c52674, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(collection, checkArr, (i & 4) != 0 ? C52674.INSTANCE : c52674);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Checks(Collection<Name> nameList, Check[] checks, Function1<? super FunctionDescriptor, String> additionalChecks) {
        this((Name) null, (Regex) null, nameList, additionalChecks, (Check[]) Arrays.copyOf(checks, checks.length));
        Intrinsics.checkNotNullParameter(nameList, "nameList");
        Intrinsics.checkNotNullParameter(checks, "checks");
        Intrinsics.checkNotNullParameter(additionalChecks, "additionalChecks");
    }
}
