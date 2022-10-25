package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class AnnotatedFieldCollector extends CollectorBase {
    private final boolean _collectAnnotations;
    private final ClassIntrospector.MixInResolver _mixInResolver;
    private final TypeFactory _typeFactory;

    AnnotatedFieldCollector(AnnotationIntrospector annotationIntrospector, TypeFactory typeFactory, ClassIntrospector.MixInResolver mixInResolver, boolean z) {
        super(annotationIntrospector);
        this._typeFactory = typeFactory;
        this._mixInResolver = annotationIntrospector == null ? null : mixInResolver;
        this._collectAnnotations = z;
    }

    public static List<AnnotatedField> collectFields(AnnotationIntrospector annotationIntrospector, TypeResolutionContext typeResolutionContext, ClassIntrospector.MixInResolver mixInResolver, TypeFactory typeFactory, JavaType javaType, boolean z) {
        return new AnnotatedFieldCollector(annotationIntrospector, typeFactory, mixInResolver, z).collect(typeResolutionContext, javaType);
    }

    List<AnnotatedField> collect(TypeResolutionContext typeResolutionContext, JavaType javaType) {
        Map<String, FieldBuilder> _findFields = _findFields(typeResolutionContext, javaType, null);
        if (_findFields == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(_findFields.size());
        for (FieldBuilder fieldBuilder : _findFields.values()) {
            arrayList.add(fieldBuilder.build());
        }
        return arrayList;
    }

    private Map<String, FieldBuilder> _findFields(TypeResolutionContext typeResolutionContext, JavaType javaType, Map<String, FieldBuilder> map) {
        Field[] declaredFields;
        ClassIntrospector.MixInResolver mixInResolver;
        Class<?> findMixInClassFor;
        JavaType superClass = javaType.getSuperClass();
        if (superClass == null) {
            return map;
        }
        Class<?> rawClass = javaType.getRawClass();
        Map<String, FieldBuilder> _findFields = _findFields(new TypeResolutionContext.Basic(this._typeFactory, superClass.getBindings()), superClass, map);
        for (Field field : rawClass.getDeclaredFields()) {
            if (_isIncludableField(field)) {
                if (_findFields == null) {
                    _findFields = new LinkedHashMap<>();
                }
                FieldBuilder fieldBuilder = new FieldBuilder(typeResolutionContext, field);
                if (this._collectAnnotations) {
                    fieldBuilder.annotations = collectAnnotations(fieldBuilder.annotations, field.getDeclaredAnnotations());
                }
                _findFields.put(field.getName(), fieldBuilder);
            }
        }
        if (_findFields != null && (mixInResolver = this._mixInResolver) != null && (findMixInClassFor = mixInResolver.findMixInClassFor(rawClass)) != null) {
            _addFieldMixIns(findMixInClassFor, rawClass, _findFields);
        }
        return _findFields;
    }

    private void _addFieldMixIns(Class<?> cls, Class<?> cls2, Map<String, FieldBuilder> map) {
        Field[] declaredFields;
        FieldBuilder fieldBuilder;
        for (Class<?> cls3 : ClassUtil.findSuperClasses(cls, cls2, true)) {
            for (Field field : cls3.getDeclaredFields()) {
                if (_isIncludableField(field) && (fieldBuilder = map.get(field.getName())) != null) {
                    fieldBuilder.annotations = collectAnnotations(fieldBuilder.annotations, field.getDeclaredAnnotations());
                }
            }
        }
    }

    private boolean _isIncludableField(Field field) {
        return (field.isSynthetic() || Modifier.isStatic(field.getModifiers())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class FieldBuilder {
        public AnnotationCollector annotations = AnnotationCollector.emptyCollector();
        public final Field field;
        public final TypeResolutionContext typeContext;

        public FieldBuilder(TypeResolutionContext typeResolutionContext, Field field) {
            this.typeContext = typeResolutionContext;
            this.field = field;
        }

        public AnnotatedField build() {
            return new AnnotatedField(this.typeContext, this.field, this.annotations.asAnnotationMap());
        }
    }
}
