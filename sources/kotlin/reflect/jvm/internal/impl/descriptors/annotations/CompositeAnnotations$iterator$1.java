package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;

/* compiled from: Annotations.kt */
/* loaded from: classes4.dex */
final class CompositeAnnotations$iterator$1 extends Lambda implements Function1<Annotations, Sequence<? extends AnnotationDescriptor>> {
    public static final CompositeAnnotations$iterator$1 INSTANCE = new CompositeAnnotations$iterator$1();

    CompositeAnnotations$iterator$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Sequence<AnnotationDescriptor> invoke(Annotations it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return CollectionsKt.asSequence(it);
    }
}
