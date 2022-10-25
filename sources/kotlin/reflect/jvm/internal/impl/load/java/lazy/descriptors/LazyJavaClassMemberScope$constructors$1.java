package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.signatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaClassMemberScope.kt */
/* loaded from: classes4.dex */
public final class LazyJavaClassMemberScope$constructors$1 extends Lambda implements Functions<List<? extends ClassConstructorDescriptor>> {

    /* renamed from: $c */
    final /* synthetic */ LazyJavaResolverContext f10648$c;
    final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope$constructors$1(LazyJavaClassMemberScope lazyJavaClassMemberScope, LazyJavaResolverContext lazyJavaResolverContext) {
        super(0);
        this.this$0 = lazyJavaClassMemberScope;
        this.f10648$c = lazyJavaResolverContext;
    }

    @Override // kotlin.jvm.functions.Functions
    public final List<? extends ClassConstructorDescriptor> invoke() {
        JavaClass javaClass;
        JavaClass javaClass2;
        ClassConstructorDescriptor createDefaultConstructor;
        ClassConstructorDescriptor createDefaultRecordConstructor;
        JavaClass javaClass3;
        JavaClassConstructorDescriptor resolveConstructor;
        javaClass = this.this$0.jClass;
        Collection<JavaConstructor> constructors = javaClass.getConstructors();
        ArrayList arrayList = new ArrayList(constructors.size());
        for (JavaConstructor javaConstructor : constructors) {
            resolveConstructor = this.this$0.resolveConstructor(javaConstructor);
            arrayList.add(resolveConstructor);
        }
        javaClass2 = this.this$0.jClass;
        if (javaClass2.isRecord()) {
            createDefaultRecordConstructor = this.this$0.createDefaultRecordConstructor();
            boolean z = false;
            String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(createDefaultRecordConstructor, false, false, 2, null);
            ArrayList<ClassConstructorDescriptor> arrayList2 = arrayList;
            if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                for (ClassConstructorDescriptor classConstructorDescriptor : arrayList2) {
                    if (Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmDescriptor$default(classConstructorDescriptor, false, false, 2, null), computeJvmDescriptor$default)) {
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                arrayList.add(createDefaultRecordConstructor);
                JavaResolverCache javaResolverCache = this.f10648$c.getComponents().getJavaResolverCache();
                javaClass3 = this.this$0.jClass;
                javaResolverCache.recordConstructor(javaClass3, createDefaultRecordConstructor);
            }
        }
        this.f10648$c.getComponents().getSyntheticPartsProvider().generateConstructors(this.this$0.getOwnerDescriptor(), arrayList);
        signatureEnhancement signatureEnhancement = this.f10648$c.getComponents().getSignatureEnhancement();
        LazyJavaResolverContext lazyJavaResolverContext = this.f10648$c;
        List list = arrayList;
        LazyJavaClassMemberScope lazyJavaClassMemberScope = this.this$0;
        if (list.isEmpty()) {
            createDefaultConstructor = lazyJavaClassMemberScope.createDefaultConstructor();
            list = CollectionsKt.listOfNotNull(createDefaultConstructor);
        }
        return CollectionsKt.toList(signatureEnhancement.enhanceSignatures(lazyJavaResolverContext, list));
    }
}
