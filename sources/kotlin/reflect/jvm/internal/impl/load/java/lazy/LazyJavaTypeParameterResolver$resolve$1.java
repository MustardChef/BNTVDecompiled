package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: resolvers.kt */
/* loaded from: classes4.dex */
public final class LazyJavaTypeParameterResolver$resolve$1 extends Lambda implements Function1<JavaTypeParameter, LazyJavaTypeParameterDescriptor> {
    final /* synthetic */ resolvers this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaTypeParameterResolver$resolve$1(resolvers resolversVar) {
        super(1);
        this.this$0 = resolversVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final LazyJavaTypeParameterDescriptor invoke(JavaTypeParameter typeParameter) {
        Map map;
        LazyJavaResolverContext lazyJavaResolverContext;
        DeclarationDescriptor declarationDescriptor;
        int i;
        DeclarationDescriptor declarationDescriptor2;
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        map = this.this$0.typeParameters;
        Integer num = (Integer) map.get(typeParameter);
        if (num != null) {
            resolvers resolversVar = this.this$0;
            int intValue = num.intValue();
            lazyJavaResolverContext = resolversVar.f10644c;
            LazyJavaResolverContext child = context.child(lazyJavaResolverContext, resolversVar);
            declarationDescriptor = resolversVar.containingDeclaration;
            LazyJavaResolverContext copyWithNewDefaultTypeQualifiers = context.copyWithNewDefaultTypeQualifiers(child, declarationDescriptor.getAnnotations());
            i = resolversVar.typeParametersIndexOffset;
            int i2 = i + intValue;
            declarationDescriptor2 = resolversVar.containingDeclaration;
            return new LazyJavaTypeParameterDescriptor(copyWithNewDefaultTypeQualifiers, typeParameter, i2, declarationDescriptor2);
        }
        return null;
    }
}
