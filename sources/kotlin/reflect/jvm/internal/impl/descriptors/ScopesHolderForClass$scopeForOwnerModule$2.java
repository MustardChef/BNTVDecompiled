package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScopesHolderForClass.kt */
/* loaded from: classes4.dex */
public final class ScopesHolderForClass$scopeForOwnerModule$2 extends Lambda implements Functions<T> {
    final /* synthetic */ ScopesHolderForClass<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScopesHolderForClass$scopeForOwnerModule$2(ScopesHolderForClass<T> scopesHolderForClass) {
        super(0);
        this.this$0 = scopesHolderForClass;
    }

    /* JADX WARN: Incorrect return type in method signature: ()TT; */
    @Override // kotlin.jvm.functions.Functions
    public final MemberScope invoke() {
        Function1 function1;
        KotlinTypeRefiner kotlinTypeRefiner;
        function1 = ((ScopesHolderForClass) this.this$0).scopeFactory;
        kotlinTypeRefiner = ((ScopesHolderForClass) this.this$0).kotlinTypeRefinerForOwnerModule;
        return (MemberScope) function1.invoke(kotlinTypeRefiner);
    }
}
