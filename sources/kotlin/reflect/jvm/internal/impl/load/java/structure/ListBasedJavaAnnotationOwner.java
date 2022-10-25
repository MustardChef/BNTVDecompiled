package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: javaElements.kt */
/* loaded from: classes4.dex */
public interface ListBasedJavaAnnotationOwner extends JavaAnnotationOwner {

    /* compiled from: javaElements.kt */
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static javaElements findAnnotation(ListBasedJavaAnnotationOwner listBasedJavaAnnotationOwner, FqName fqName) {
            Object obj;
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            Iterator<T> it = listBasedJavaAnnotationOwner.getAnnotations().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                ClassId classId = ((javaElements) next).getClassId();
                if (Intrinsics.areEqual(classId != null ? classId.asSingleFqName() : null, fqName)) {
                    obj = next;
                    break;
                }
            }
            return (javaElements) obj;
        }
    }
}
