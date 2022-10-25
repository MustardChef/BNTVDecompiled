package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;

/* compiled from: LazyScopeAdapter.kt */
/* loaded from: classes4.dex */
final class LazyScopeAdapter$lazyScope$1 extends Lambda implements Functions<MemberScope> {
    final /* synthetic */ Functions<MemberScope> $getScope;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyScopeAdapter$lazyScope$1(Functions<? extends MemberScope> functions) {
        super(0);
        this.$getScope = functions;
    }

    @Override // kotlin.jvm.functions.Functions
    public final MemberScope invoke() {
        MemberScope invoke = this.$getScope.invoke();
        return invoke instanceof AbstractScopeAdapter ? ((AbstractScopeAdapter) invoke).getActualScope() : invoke;
    }
}
