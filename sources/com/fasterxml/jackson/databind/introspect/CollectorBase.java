package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/* loaded from: classes2.dex */
class CollectorBase {
    protected final AnnotationIntrospector _intr;
    protected static final AnnotationMap[] NO_ANNOTATION_MAPS = new AnnotationMap[0];
    protected static final Annotation[] NO_ANNOTATIONS = new Annotation[0];

    /* JADX INFO: Access modifiers changed from: protected */
    public CollectorBase(AnnotationIntrospector annotationIntrospector) {
        this._intr = annotationIntrospector;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AnnotationCollector collectAnnotations(Annotation[] annotationArr) {
        AnnotationCollector emptyCollector = AnnotationCollector.emptyCollector();
        for (Annotation annotation : annotationArr) {
            emptyCollector = emptyCollector.addOrOverride(annotation);
            if (this._intr.isAnnotationBundle(annotation)) {
                emptyCollector = collectFromBundle(emptyCollector, annotation);
            }
        }
        return emptyCollector;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AnnotationCollector collectAnnotations(AnnotationCollector annotationCollector, Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            annotationCollector = annotationCollector.addOrOverride(annotation);
            if (this._intr.isAnnotationBundle(annotation)) {
                annotationCollector = collectFromBundle(annotationCollector, annotation);
            }
        }
        return annotationCollector;
    }

    protected final AnnotationCollector collectFromBundle(AnnotationCollector annotationCollector, Annotation annotation) {
        Annotation[] findClassAnnotations;
        for (Annotation annotation2 : ClassUtil.findClassAnnotations(annotation.annotationType())) {
            if (!_ignorableAnnotation(annotation2)) {
                if (this._intr.isAnnotationBundle(annotation2)) {
                    if (!annotationCollector.isPresent(annotation2)) {
                        annotationCollector = collectFromBundle(annotationCollector.addOrOverride(annotation2), annotation2);
                    }
                } else {
                    annotationCollector = annotationCollector.addOrOverride(annotation2);
                }
            }
        }
        return annotationCollector;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AnnotationCollector collectDefaultAnnotations(AnnotationCollector annotationCollector, Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            if (!annotationCollector.isPresent(annotation)) {
                annotationCollector = annotationCollector.addOrOverride(annotation);
                if (this._intr.isAnnotationBundle(annotation)) {
                    annotationCollector = collectDefaultFromBundle(annotationCollector, annotation);
                }
            }
        }
        return annotationCollector;
    }

    protected final AnnotationCollector collectDefaultFromBundle(AnnotationCollector annotationCollector, Annotation annotation) {
        Annotation[] findClassAnnotations;
        for (Annotation annotation2 : ClassUtil.findClassAnnotations(annotation.annotationType())) {
            if (!_ignorableAnnotation(annotation2) && !annotationCollector.isPresent(annotation2)) {
                annotationCollector = annotationCollector.addOrOverride(annotation2);
                if (this._intr.isAnnotationBundle(annotation2)) {
                    annotationCollector = collectFromBundle(annotationCollector, annotation2);
                }
            }
        }
        return annotationCollector;
    }

    protected static final boolean _ignorableAnnotation(Annotation annotation) {
        return (annotation instanceof Target) || (annotation instanceof Retention);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnnotationMap _emptyAnnotationMap() {
        return new AnnotationMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnnotationMap[] _emptyAnnotationMaps(int i) {
        if (i == 0) {
            return NO_ANNOTATION_MAPS;
        }
        AnnotationMap[] annotationMapArr = new AnnotationMap[i];
        for (int i2 = 0; i2 < i; i2++) {
            annotationMapArr[i2] = _emptyAnnotationMap();
        }
        return annotationMapArr;
    }
}
