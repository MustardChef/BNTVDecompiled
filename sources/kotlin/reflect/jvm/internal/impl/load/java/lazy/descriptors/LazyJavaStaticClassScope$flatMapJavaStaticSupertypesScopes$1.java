package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.sequences.SequencesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaStaticClassScope.kt */
/* loaded from: classes4.dex */
public final class LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1<N> implements DFS.Neighbors {
    public static final LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1<N> INSTANCE = new LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1<>();

    LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LazyJavaStaticClassScope.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1$1 */
    /* loaded from: classes4.dex */
    public static final class C51001 extends Lambda implements Function1<KotlinType, ClassDescriptor> {
        public static final C51001 INSTANCE = new C51001();

        C51001() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ClassDescriptor invoke(KotlinType kotlinType) {
            ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor instanceof ClassDescriptor) {
                return (ClassDescriptor) declarationDescriptor;
            }
            return null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
    public final Iterable<ClassDescriptor> getNeighbors(ClassDescriptor classDescriptor) {
        Collection<KotlinType> mo10322getSupertypes = classDescriptor.getTypeConstructor().mo10322getSupertypes();
        Intrinsics.checkNotNullExpressionValue(mo10322getSupertypes, "it.typeConstructor.supertypes");
        return SequencesKt.asIterable(SequencesKt.mapNotNull(CollectionsKt.asSequence(mo10322getSupertypes), C51001.INSTANCE));
    }
}
