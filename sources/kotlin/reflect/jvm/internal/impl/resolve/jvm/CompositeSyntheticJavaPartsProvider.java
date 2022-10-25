package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: SyntheticJavaPartsProvider.kt */
/* loaded from: classes4.dex */
public final class CompositeSyntheticJavaPartsProvider implements SyntheticJavaPartsProvider {
    private final List<SyntheticJavaPartsProvider> inner;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeSyntheticJavaPartsProvider(List<? extends SyntheticJavaPartsProvider> inner) {
        Intrinsics.checkNotNullParameter(inner, "inner");
        this.inner = inner;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public List<Name> getMethodNames(ClassDescriptor thisDescriptor) {
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        ArrayList arrayList = new ArrayList();
        for (SyntheticJavaPartsProvider syntheticJavaPartsProvider : this.inner) {
            CollectionsKt.addAll(arrayList, syntheticJavaPartsProvider.getMethodNames(thisDescriptor));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateMethods(ClassDescriptor thisDescriptor, Name name, Collection<SimpleFunctionDescriptor> result) {
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(result, "result");
        for (SyntheticJavaPartsProvider syntheticJavaPartsProvider : this.inner) {
            syntheticJavaPartsProvider.generateMethods(thisDescriptor, name, result);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public List<Name> getStaticFunctionNames(ClassDescriptor thisDescriptor) {
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        ArrayList arrayList = new ArrayList();
        for (SyntheticJavaPartsProvider syntheticJavaPartsProvider : this.inner) {
            CollectionsKt.addAll(arrayList, syntheticJavaPartsProvider.getStaticFunctionNames(thisDescriptor));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateStaticFunctions(ClassDescriptor thisDescriptor, Name name, Collection<SimpleFunctionDescriptor> result) {
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(result, "result");
        for (SyntheticJavaPartsProvider syntheticJavaPartsProvider : this.inner) {
            syntheticJavaPartsProvider.generateStaticFunctions(thisDescriptor, name, result);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateConstructors(ClassDescriptor thisDescriptor, List<ClassConstructorDescriptor> result) {
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(result, "result");
        for (SyntheticJavaPartsProvider syntheticJavaPartsProvider : this.inner) {
            syntheticJavaPartsProvider.generateConstructors(thisDescriptor, result);
        }
    }
}
