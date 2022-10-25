package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaClassMemberScope.kt */
/* loaded from: classes4.dex */
public final class LazyJavaClassMemberScope$nestedClasses$1 extends Lambda implements Function1<Name, ClassDescriptorBase> {

    /* renamed from: $c */
    final /* synthetic */ LazyJavaResolverContext f10649$c;
    final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope$nestedClasses$1(LazyJavaClassMemberScope lazyJavaClassMemberScope, LazyJavaResolverContext lazyJavaResolverContext) {
        super(1);
        this.this$0 = lazyJavaClassMemberScope;
        this.f10649$c = lazyJavaResolverContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ClassDescriptorBase invoke(Name name) {
        NotNullLazyValue notNullLazyValue;
        JavaClass javaClass;
        NotNullLazyValue notNullLazyValue2;
        Intrinsics.checkNotNullParameter(name, "name");
        notNullLazyValue = this.this$0.nestedClassIndex;
        EnumEntrySyntheticClassDescriptor enumEntrySyntheticClassDescriptor = null;
        if (!((Set) notNullLazyValue.invoke()).contains(name)) {
            notNullLazyValue2 = this.this$0.enumEntryIndex;
            JavaField javaField = (JavaField) ((Map) notNullLazyValue2.invoke()).get(name);
            if (javaField != null) {
                enumEntrySyntheticClassDescriptor = EnumEntrySyntheticClassDescriptor.create(this.f10649$c.getStorageManager(), this.this$0.getOwnerDescriptor(), name, this.f10649$c.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1(this.this$0)), LazyJavaAnnotationsKt.resolveAnnotations(this.f10649$c, javaField), this.f10649$c.getComponents().getSourceElementFactory().source(javaField));
            }
            return enumEntrySyntheticClassDescriptor;
        }
        JavaClassFinder finder = this.f10649$c.getComponents().getFinder();
        ClassId classId = DescriptorUtils.getClassId(this.this$0.getOwnerDescriptor());
        Intrinsics.checkNotNull(classId);
        ClassId createNestedClassId = classId.createNestedClassId(name);
        Intrinsics.checkNotNullExpressionValue(createNestedClassId, "ownerDescriptor.classId!…createNestedClassId(name)");
        javaClass = this.this$0.jClass;
        JavaClass findClass = finder.findClass(new JavaClassFinder.Request(createNestedClassId, null, javaClass, 2, null));
        if (findClass != null) {
            LazyJavaResolverContext lazyJavaResolverContext = this.f10649$c;
            JavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor(lazyJavaResolverContext, this.this$0.getOwnerDescriptor(), findClass, null, 8, null);
            lazyJavaResolverContext.getComponents().getJavaClassesTracker().reportClass(lazyJavaClassDescriptor);
            enumEntrySyntheticClassDescriptor = lazyJavaClassDescriptor;
        }
        return enumEntrySyntheticClassDescriptor;
    }
}
