package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: findClassInModule.kt */
/* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1 */
/* loaded from: classes4.dex */
public /* synthetic */ class C5060x24bfe126 extends FunctionReference implements Function1<ClassId, ClassId> {
    public static final C5060x24bfe126 INSTANCE = new C5060x24bfe126();

    C5060x24bfe126() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "getOuterClassId";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ClassId.class);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ClassId invoke(ClassId p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return p0.getOuterClassId();
    }
}
