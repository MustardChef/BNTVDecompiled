package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.annotationArguments;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument */
/* loaded from: classes4.dex */
public abstract class ReflectJavaAnnotationArguments implements annotationArguments {
    public static final Factory Factory = new Factory(null);
    private final Name name;

    public /* synthetic */ ReflectJavaAnnotationArguments(Name name, DefaultConstructorMarker defaultConstructorMarker) {
        this(name);
    }

    private ReflectJavaAnnotationArguments(Name name) {
        this.name = name;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.annotationArguments
    public Name getName() {
        return this.name;
    }

    /* compiled from: ReflectJavaAnnotationArguments.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument$Factory */
    /* loaded from: classes4.dex */
    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Factory() {
        }

        public final ReflectJavaAnnotationArguments create(Object value, Name name) {
            Intrinsics.checkNotNullParameter(value, "value");
            return reflectClassUtil.isEnumClassOrSpecializedEnumEntryClass(value.getClass()) ? new ReflectJavaEnumValueAnnotationArgument(name, (Enum) value) : value instanceof Annotation ? new ReflectJavaAnnotationAsAnnotationArgument(name, (Annotation) value) : value instanceof Object[] ? new ReflectJavaArrayAnnotationArgument(name, (Object[]) value) : value instanceof Class ? new ReflectJavaClassObjectAnnotationArgument(name, (Class) value) : new ReflectJavaLiteralAnnotationArgument(name, value);
        }
    }
}
