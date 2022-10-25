package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractSignatureParts.kt */
/* loaded from: classes4.dex */
public final class AbstractSignatureParts$toIndexed$1$1 extends Lambda implements Function1<AbstractSignatureParts.TypeAndDefaultQualifiers, Iterable<? extends AbstractSignatureParts.TypeAndDefaultQualifiers>> {
    final /* synthetic */ TypeSystemContext $this_with;
    final /* synthetic */ AbstractSignatureParts<TAnnotation> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractSignatureParts$toIndexed$1$1(AbstractSignatureParts<TAnnotation> abstractSignatureParts, TypeSystemContext typeSystemContext) {
        super(1);
        this.this$0 = abstractSignatureParts;
        this.$this_with = typeSystemContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Iterable<AbstractSignatureParts.TypeAndDefaultQualifiers> invoke(AbstractSignatureParts.TypeAndDefaultQualifiers it) {
        TypeConstructorMarker typeConstructor;
        List<TypeParameterMarker> parameters;
        JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers;
        AbstractSignatureParts.TypeAndDefaultQualifiers typeAndDefaultQualifiers;
        FlexibleTypeMarker asFlexibleType;
        Intrinsics.checkNotNullParameter(it, "it");
        ArrayList arrayList = null;
        if (this.this$0.getSkipRawTypeArguments()) {
            KotlinTypeMarker type = it.getType();
            if (((type == null || (asFlexibleType = this.$this_with.asFlexibleType(type)) == null) ? null : this.$this_with.asRawType(asFlexibleType)) != null) {
                return null;
            }
        }
        KotlinTypeMarker type2 = it.getType();
        if (type2 != null && (typeConstructor = this.$this_with.typeConstructor(type2)) != null && (parameters = this.$this_with.getParameters(typeConstructor)) != null) {
            List<TypeParameterMarker> list = parameters;
            List<TypeArgumentMarker> arguments = this.$this_with.getArguments(it.getType());
            TypeSystemContext typeSystemContext = this.$this_with;
            AbstractSignatureParts<TAnnotation> abstractSignatureParts = this.this$0;
            Iterator<T> it2 = list.iterator();
            Iterator<T> it3 = arguments.iterator();
            ArrayList arrayList2 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(list, 10), CollectionsKt.collectionSizeOrDefault(arguments, 10)));
            while (it2.hasNext() && it3.hasNext()) {
                Object next = it2.next();
                TypeArgumentMarker typeArgumentMarker = (TypeArgumentMarker) it3.next();
                TypeParameterMarker typeParameterMarker = (TypeParameterMarker) next;
                if (typeSystemContext.isStarProjection(typeArgumentMarker)) {
                    typeAndDefaultQualifiers = new AbstractSignatureParts.TypeAndDefaultQualifiers(null, it.getDefaultQualifiers(), typeParameterMarker);
                } else {
                    KotlinTypeMarker type3 = typeSystemContext.getType(typeArgumentMarker);
                    extractAndMergeDefaultQualifiers = abstractSignatureParts.extractAndMergeDefaultQualifiers(type3, it.getDefaultQualifiers());
                    typeAndDefaultQualifiers = new AbstractSignatureParts.TypeAndDefaultQualifiers(type3, extractAndMergeDefaultQualifiers, typeParameterMarker);
                }
                arrayList2.add(typeAndDefaultQualifiers);
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }
}
