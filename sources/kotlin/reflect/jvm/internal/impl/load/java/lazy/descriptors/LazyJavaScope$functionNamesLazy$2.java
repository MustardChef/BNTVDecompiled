package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;

/* compiled from: LazyJavaScope.kt */
/* loaded from: classes4.dex */
final class LazyJavaScope$functionNamesLazy$2 extends Lambda implements Functions<Set<? extends Name>> {
    final /* synthetic */ LazyJavaScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaScope$functionNamesLazy$2(LazyJavaScope lazyJavaScope) {
        super(0);
        this.this$0 = lazyJavaScope;
    }

    @Override // kotlin.jvm.functions.Functions
    public final Set<? extends Name> invoke() {
        return this.this$0.computeFunctionNames(DescriptorKindFilter.FUNCTIONS, null);
    }
}
