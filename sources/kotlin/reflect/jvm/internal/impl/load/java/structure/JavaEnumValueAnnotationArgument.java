package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: annotationArguments.kt */
/* loaded from: classes4.dex */
public interface JavaEnumValueAnnotationArgument extends annotationArguments {
    Name getEntryName();

    ClassId getEnumClassId();
}
