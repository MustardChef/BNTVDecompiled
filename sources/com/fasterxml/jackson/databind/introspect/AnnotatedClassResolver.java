package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class AnnotatedClassResolver {
    private final TypeBindings _bindings;
    private final Class<?> _class;
    private final boolean _collectAnnotations;
    private final MapperConfig<?> _config;
    private final AnnotationIntrospector _intr;
    private final ClassIntrospector.MixInResolver _mixInResolver;
    private final Class<?> _primaryMixin;
    private final JavaType _type;
    private static final Annotations NO_ANNOTATIONS = AnnotationCollector.emptyAnnotations();
    private static final Class<?> CLS_OBJECT = Object.class;
    private static final Class<?> CLS_ENUM = Enum.class;
    private static final Class<?> CLS_LIST = List.class;
    private static final Class<?> CLS_MAP = Map.class;

    AnnotatedClassResolver(MapperConfig<?> mapperConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        this._config = mapperConfig;
        this._type = javaType;
        Class<?> rawClass = javaType.getRawClass();
        this._class = rawClass;
        this._mixInResolver = mixInResolver;
        this._bindings = javaType.getBindings();
        AnnotationIntrospector annotationIntrospector = mapperConfig.isAnnotationProcessingEnabled() ? mapperConfig.getAnnotationIntrospector() : null;
        this._intr = annotationIntrospector;
        this._primaryMixin = mixInResolver != null ? mixInResolver.findMixInClassFor(rawClass) : null;
        this._collectAnnotations = (annotationIntrospector == null || (ClassUtil.isJDKClass(rawClass) && javaType.isContainerType())) ? false : true;
    }

    AnnotatedClassResolver(MapperConfig<?> mapperConfig, Class<?> cls, ClassIntrospector.MixInResolver mixInResolver) {
        this._config = mapperConfig;
        this._type = null;
        this._class = cls;
        this._mixInResolver = mixInResolver;
        this._bindings = TypeBindings.emptyBindings();
        if (mapperConfig == null) {
            this._intr = null;
            this._primaryMixin = null;
        } else {
            this._intr = mapperConfig.isAnnotationProcessingEnabled() ? mapperConfig.getAnnotationIntrospector() : null;
            this._primaryMixin = mixInResolver != null ? mixInResolver.findMixInClassFor(cls) : null;
        }
        this._collectAnnotations = this._intr != null;
    }

    public static AnnotatedClass resolve(MapperConfig<?> mapperConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        if (javaType.isArrayType() && skippableArray(mapperConfig, javaType.getRawClass())) {
            return createArrayType(mapperConfig, javaType.getRawClass());
        }
        return new AnnotatedClassResolver(mapperConfig, javaType, mixInResolver).resolveFully();
    }

    public static AnnotatedClass resolveWithoutSuperTypes(MapperConfig<?> mapperConfig, Class<?> cls) {
        return resolveWithoutSuperTypes(mapperConfig, cls, mapperConfig);
    }

    public static AnnotatedClass resolveWithoutSuperTypes(MapperConfig<?> mapperConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        if (javaType.isArrayType() && skippableArray(mapperConfig, javaType.getRawClass())) {
            return createArrayType(mapperConfig, javaType.getRawClass());
        }
        return new AnnotatedClassResolver(mapperConfig, javaType, mixInResolver).resolveWithoutSuperTypes();
    }

    public static AnnotatedClass resolveWithoutSuperTypes(MapperConfig<?> mapperConfig, Class<?> cls, ClassIntrospector.MixInResolver mixInResolver) {
        if (cls.isArray() && skippableArray(mapperConfig, cls)) {
            return createArrayType(mapperConfig, cls);
        }
        return new AnnotatedClassResolver(mapperConfig, cls, mixInResolver).resolveWithoutSuperTypes();
    }

    private static boolean skippableArray(MapperConfig<?> mapperConfig, Class<?> cls) {
        return mapperConfig == null || mapperConfig.findMixInClassFor(cls) == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnnotatedClass createPrimordial(Class<?> cls) {
        return new AnnotatedClass(cls);
    }

    static AnnotatedClass createArrayType(MapperConfig<?> mapperConfig, Class<?> cls) {
        return new AnnotatedClass(cls);
    }

    AnnotatedClass resolveFully() {
        ArrayList arrayList = new ArrayList(8);
        if (!this._type.hasRawClass(Object.class)) {
            if (this._type.isInterface()) {
                _addSuperInterfaces(this._type, arrayList, false);
            } else {
                _addSuperTypes(this._type, arrayList, false);
            }
        }
        return new AnnotatedClass(this._type, this._class, arrayList, this._primaryMixin, resolveClassAnnotations(arrayList), this._bindings, this._intr, this._mixInResolver, this._config.getTypeFactory(), this._collectAnnotations);
    }

    AnnotatedClass resolveWithoutSuperTypes() {
        List<JavaType> emptyList = Collections.emptyList();
        return new AnnotatedClass(null, this._class, emptyList, this._primaryMixin, resolveClassAnnotations(emptyList), this._bindings, this._intr, this._mixInResolver, this._config.getTypeFactory(), this._collectAnnotations);
    }

    private static void _addSuperTypes(JavaType javaType, List<JavaType> list, boolean z) {
        Class<?> rawClass = javaType.getRawClass();
        if (rawClass == CLS_OBJECT || rawClass == CLS_ENUM) {
            return;
        }
        if (z) {
            if (_contains(list, rawClass)) {
                return;
            }
            list.add(javaType);
        }
        for (JavaType javaType2 : javaType.getInterfaces()) {
            _addSuperInterfaces(javaType2, list, true);
        }
        JavaType superClass = javaType.getSuperClass();
        if (superClass != null) {
            _addSuperTypes(superClass, list, true);
        }
    }

    private static void _addSuperInterfaces(JavaType javaType, List<JavaType> list, boolean z) {
        Class<?> rawClass = javaType.getRawClass();
        if (z) {
            if (_contains(list, rawClass)) {
                return;
            }
            list.add(javaType);
            if (rawClass == CLS_LIST || rawClass == CLS_MAP) {
                return;
            }
        }
        for (JavaType javaType2 : javaType.getInterfaces()) {
            _addSuperInterfaces(javaType2, list, true);
        }
    }

    private static boolean _contains(List<JavaType> list, Class<?> cls) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).getRawClass() == cls) {
                return true;
            }
        }
        return false;
    }

    private Annotations resolveClassAnnotations(List<JavaType> list) {
        if (this._intr == null) {
            return NO_ANNOTATIONS;
        }
        ClassIntrospector.MixInResolver mixInResolver = this._mixInResolver;
        boolean z = mixInResolver != null && (!(mixInResolver instanceof SimpleMixInResolver) || ((SimpleMixInResolver) mixInResolver).hasMixIns());
        if (!z && !this._collectAnnotations) {
            return NO_ANNOTATIONS;
        }
        AnnotationCollector emptyCollector = AnnotationCollector.emptyCollector();
        Class<?> cls = this._primaryMixin;
        if (cls != null) {
            emptyCollector = _addClassMixIns(emptyCollector, this._class, cls);
        }
        if (this._collectAnnotations) {
            emptyCollector = _addAnnotationsIfNotPresent(emptyCollector, ClassUtil.findClassAnnotations(this._class));
        }
        for (JavaType javaType : list) {
            if (z) {
                Class<?> rawClass = javaType.getRawClass();
                emptyCollector = _addClassMixIns(emptyCollector, rawClass, this._mixInResolver.findMixInClassFor(rawClass));
            }
            if (this._collectAnnotations) {
                emptyCollector = _addAnnotationsIfNotPresent(emptyCollector, ClassUtil.findClassAnnotations(javaType.getRawClass()));
            }
        }
        if (z) {
            emptyCollector = _addClassMixIns(emptyCollector, Object.class, this._mixInResolver.findMixInClassFor(Object.class));
        }
        return emptyCollector.asAnnotations();
    }

    private AnnotationCollector _addClassMixIns(AnnotationCollector annotationCollector, Class<?> cls, Class<?> cls2) {
        if (cls2 != null) {
            annotationCollector = _addAnnotationsIfNotPresent(annotationCollector, ClassUtil.findClassAnnotations(cls2));
            for (Class<?> cls3 : ClassUtil.findSuperClasses(cls2, cls, false)) {
                annotationCollector = _addAnnotationsIfNotPresent(annotationCollector, ClassUtil.findClassAnnotations(cls3));
            }
        }
        return annotationCollector;
    }

    private AnnotationCollector _addAnnotationsIfNotPresent(AnnotationCollector annotationCollector, Annotation[] annotationArr) {
        if (annotationArr != null) {
            for (Annotation annotation : annotationArr) {
                if (!annotationCollector.isPresent(annotation)) {
                    annotationCollector = annotationCollector.addOrOverride(annotation);
                    if (this._intr.isAnnotationBundle(annotation)) {
                        annotationCollector = _addFromBundleIfNotPresent(annotationCollector, annotation);
                    }
                }
            }
        }
        return annotationCollector;
    }

    private AnnotationCollector _addFromBundleIfNotPresent(AnnotationCollector annotationCollector, Annotation annotation) {
        Annotation[] findClassAnnotations;
        for (Annotation annotation2 : ClassUtil.findClassAnnotations(annotation.annotationType())) {
            if (!(annotation2 instanceof Target) && !(annotation2 instanceof Retention) && !annotationCollector.isPresent(annotation2)) {
                annotationCollector = annotationCollector.addOrOverride(annotation2);
                if (this._intr.isAnnotationBundle(annotation2)) {
                    annotationCollector = _addFromBundleIfNotPresent(annotationCollector, annotation2);
                }
            }
        }
        return annotationCollector;
    }
}
