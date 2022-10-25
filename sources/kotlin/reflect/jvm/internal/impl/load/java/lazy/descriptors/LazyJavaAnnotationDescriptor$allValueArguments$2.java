package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Map;
import kotlin.Tuples;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.structure.annotationArguments;
import kotlin.reflect.jvm.internal.impl.load.java.structure.javaElements;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaAnnotationDescriptor.kt */
/* loaded from: classes4.dex */
public final class LazyJavaAnnotationDescriptor$allValueArguments$2 extends Lambda implements Functions<Map<Name, ? extends ConstantValue<?>>> {
    final /* synthetic */ LazyJavaAnnotationDescriptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaAnnotationDescriptor$allValueArguments$2(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        super(0);
        this.this$0 = lazyJavaAnnotationDescriptor;
    }

    @Override // kotlin.jvm.functions.Functions
    public final Map<Name, ? extends ConstantValue<?>> invoke() {
        javaElements javaelements;
        ConstantValue resolveAnnotationArgument;
        javaelements = this.this$0.javaAnnotation;
        LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor = this.this$0;
        ArrayList arrayList = new ArrayList();
        for (annotationArguments annotationarguments : javaelements.getArguments()) {
            Name name = annotationarguments.getName();
            if (name == null) {
                name = JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME;
            }
            resolveAnnotationArgument = lazyJavaAnnotationDescriptor.resolveAnnotationArgument(annotationarguments);
            Tuples m100to = resolveAnnotationArgument != null ? TuplesKt.m100to(name, resolveAnnotationArgument) : null;
            if (m100to != null) {
                arrayList.add(m100to);
            }
        }
        return MapsKt.toMap(arrayList);
    }
}
