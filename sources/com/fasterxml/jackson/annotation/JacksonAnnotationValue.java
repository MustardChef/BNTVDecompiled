package com.fasterxml.jackson.annotation;

import java.lang.annotation.Annotation;

/* loaded from: classes2.dex */
public interface JacksonAnnotationValue<A extends Annotation> {
    Class<A> valueFor();
}
