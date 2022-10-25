package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: AnnotationDescriptor.kt */
/* loaded from: classes4.dex */
public interface AnnotationDescriptor {
    Map<Name, ConstantValue<?>> getAllValueArguments();

    FqName getFqName();

    SourceElement getSource();

    KotlinType getType();

    /* compiled from: AnnotationDescriptor.kt */
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static FqName getFqName(AnnotationDescriptor annotationDescriptor) {
            ClassDescriptor annotationClass = DescriptorUtils.getAnnotationClass(annotationDescriptor);
            if (annotationClass != null) {
                if (ErrorUtils.isError(annotationClass)) {
                    annotationClass = null;
                }
                if (annotationClass != null) {
                    return DescriptorUtils.fqNameOrNull(annotationClass);
                }
                return null;
            }
            return null;
        }
    }
}
