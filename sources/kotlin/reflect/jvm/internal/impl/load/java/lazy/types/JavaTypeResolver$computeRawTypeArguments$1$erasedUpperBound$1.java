package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JavaTypeResolver.kt */
/* loaded from: classes4.dex */
public final class JavaTypeResolver$computeRawTypeArguments$1$erasedUpperBound$1 extends Lambda implements Functions<KotlinType> {
    final /* synthetic */ JavaTypeAttributes $attr;
    final /* synthetic */ TypeConstructor $constructor;
    final /* synthetic */ JavaClassifierType $javaType;
    final /* synthetic */ TypeParameterDescriptor $parameter;
    final /* synthetic */ JavaTypeResolver this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaTypeResolver$computeRawTypeArguments$1$erasedUpperBound$1(JavaTypeResolver javaTypeResolver, TypeParameterDescriptor typeParameterDescriptor, JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes, TypeConstructor typeConstructor) {
        super(0);
        this.this$0 = javaTypeResolver;
        this.$parameter = typeParameterDescriptor;
        this.$javaType = javaClassifierType;
        this.$attr = javaTypeAttributes;
        this.$constructor = typeConstructor;
    }

    @Override // kotlin.jvm.functions.Functions
    public final KotlinType invoke() {
        TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;
        typeParameterUpperBoundEraser = this.this$0.typeParameterUpperBoundEraser;
        TypeParameterDescriptor typeParameterDescriptor = this.$parameter;
        boolean isRaw = this.$javaType.isRaw();
        JavaTypeAttributes javaTypeAttributes = this.$attr;
        ClassifierDescriptor declarationDescriptor = this.$constructor.getDeclarationDescriptor();
        KotlinType erasedUpperBound$descriptors_jvm = typeParameterUpperBoundEraser.getErasedUpperBound$descriptors_jvm(typeParameterDescriptor, isRaw, javaTypeAttributes.withDefaultType(declarationDescriptor != null ? declarationDescriptor.getDefaultType() : null));
        Intrinsics.checkNotNullExpressionValue(erasedUpperBound$descriptors_jvm, "typeParameterUpperBoundE…efaultType)\n            )");
        return erasedUpperBound$descriptors_jvm;
    }
}
