package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KClasses.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public /* synthetic */ class KClasses$isSubclassOf$1 extends PropertyReference1 {
    public static final KClasses$isSubclassOf$1 INSTANCE = new KClasses$isSubclassOf$1();

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "superclasses";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getSuperclasses(Lkotlin/reflect/KClass;)Ljava/util/List;";
    }

    /* synthetic */ KClasses$isSubclassOf$1() {
    }

    @Override // kotlin.reflect.KProperty1
    public Object get(Object obj) {
        return KClasses.getSuperclasses((KClass) obj);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinPackage(KClasses.class, "kotlin-reflection");
    }
}
