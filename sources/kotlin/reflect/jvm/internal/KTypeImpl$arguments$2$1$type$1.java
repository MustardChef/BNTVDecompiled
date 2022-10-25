package kotlin.reflect.jvm.internal;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KTypeImpl.kt */
@Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<no name provided>", "Ljava/lang/reflect/Type;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class KTypeImpl$arguments$2$1$type$1 extends Lambda implements Functions<Type> {

    /* renamed from: $i */
    final /* synthetic */ int f10640$i;
    final /* synthetic */ Lazy<List<Type>> $parameterizedTypeArguments$delegate;
    final /* synthetic */ KTypeImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public KTypeImpl$arguments$2$1$type$1(KTypeImpl kTypeImpl, int i, Lazy<? extends List<? extends Type>> lazy) {
        super(0);
        this.this$0 = kTypeImpl;
        this.f10640$i = i;
        this.$parameterizedTypeArguments$delegate = lazy;
    }

    @Override // kotlin.jvm.functions.Functions
    public final Type invoke() {
        List m10314invoke$lambda0;
        Type javaType = this.this$0.getJavaType();
        if (javaType instanceof Class) {
            Class cls = (Class) javaType;
            Class componentType = cls.isArray() ? cls.getComponentType() : Object.class;
            Intrinsics.checkNotNullExpressionValue(componentType, "{\n                      …                        }");
            return componentType;
        } else if (javaType instanceof GenericArrayType) {
            if (this.f10640$i != 0) {
                throw new KotlinReflectionInternalError("Array type has been queried for a non-0th argument: " + this.this$0);
            }
            Type genericComponentType = ((GenericArrayType) javaType).getGenericComponentType();
            Intrinsics.checkNotNullExpressionValue(genericComponentType, "{\n                      …                        }");
            return genericComponentType;
        } else if (javaType instanceof ParameterizedType) {
            m10314invoke$lambda0 = KTypeImpl$arguments$2.m10314invoke$lambda0(this.$parameterizedTypeArguments$delegate);
            Type type = (Type) m10314invoke$lambda0.get(this.f10640$i);
            if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                Type[] lowerBounds = wildcardType.getLowerBounds();
                Intrinsics.checkNotNullExpressionValue(lowerBounds, "argument.lowerBounds");
                Type type2 = (Type) ArraysKt.firstOrNull(lowerBounds);
                if (type2 == null) {
                    Type[] upperBounds = wildcardType.getUpperBounds();
                    Intrinsics.checkNotNullExpressionValue(upperBounds, "argument.upperBounds");
                    type = (Type) ArraysKt.first(upperBounds);
                } else {
                    type = type2;
                }
            }
            Intrinsics.checkNotNullExpressionValue(type, "{\n                      …                        }");
            return type;
        } else {
            throw new KotlinReflectionInternalError("Non-generic type has been queried for arguments: " + this.this$0);
        }
    }
}
