package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import com.fasterxml.jackson.databind.introspect.AnnotatedAndMetadata;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.EnumResolver;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes2.dex */
public class StdKeyDeserializers implements KeyDeserializers, Serializable {
    private static final long serialVersionUID = 1;

    public static KeyDeserializer constructEnumKeyDeserializer(EnumResolver enumResolver) {
        return new StdKeyDeserializer.EnumKD(enumResolver, null);
    }

    public static KeyDeserializer constructEnumKeyDeserializer(EnumResolver enumResolver, AnnotatedMethod annotatedMethod) {
        return new StdKeyDeserializer.EnumKD(enumResolver, annotatedMethod);
    }

    public static KeyDeserializer constructDelegatingKeyDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, JsonDeserializer<?> jsonDeserializer) {
        return new StdKeyDeserializer.DelegatingKD(javaType.getRawClass(), jsonDeserializer);
    }

    public static KeyDeserializer findStringBasedKeyDeserializer(DeserializationConfig deserializationConfig, JavaType javaType) throws JsonMappingException {
        BeanDescription introspectForCreation = deserializationConfig.introspectForCreation(javaType);
        AnnotatedAndMetadata<AnnotatedConstructor, JsonCreator.Mode> _findStringConstructor = _findStringConstructor(introspectForCreation);
        if (_findStringConstructor != null && _findStringConstructor.metadata != null) {
            return _constructCreatorKeyDeserializer(deserializationConfig, _findStringConstructor.annotated);
        }
        List<AnnotatedAndMetadata<AnnotatedMethod, JsonCreator.Mode>> factoryMethodsWithMode = introspectForCreation.getFactoryMethodsWithMode();
        factoryMethodsWithMode.removeIf($$Lambda$StdKeyDeserializers$xVGb6Sq2oL8MuEXNAomNCn9Xupc.INSTANCE);
        AnnotatedMethod _findExplicitStringFactoryMethod = _findExplicitStringFactoryMethod(factoryMethodsWithMode);
        if (_findExplicitStringFactoryMethod != null) {
            return _constructCreatorKeyDeserializer(deserializationConfig, _findExplicitStringFactoryMethod);
        }
        if (_findStringConstructor != null) {
            return _constructCreatorKeyDeserializer(deserializationConfig, _findStringConstructor.annotated);
        }
        if (factoryMethodsWithMode.isEmpty()) {
            return null;
        }
        return _constructCreatorKeyDeserializer(deserializationConfig, factoryMethodsWithMode.get(0).annotated);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$findStringBasedKeyDeserializer$0(AnnotatedAndMetadata annotatedAndMetadata) {
        return (((AnnotatedMethod) annotatedAndMetadata.annotated).getParameterCount() == 1 && ((AnnotatedMethod) annotatedAndMetadata.annotated).getRawParameterType(0) == String.class && annotatedAndMetadata.metadata != JsonCreator.Mode.PROPERTIES) ? false : true;
    }

    private static KeyDeserializer _constructCreatorKeyDeserializer(DeserializationConfig deserializationConfig, AnnotatedMember annotatedMember) {
        if (annotatedMember instanceof AnnotatedConstructor) {
            Constructor<?> annotated = ((AnnotatedConstructor) annotatedMember).getAnnotated();
            if (deserializationConfig.canOverrideAccessModifiers()) {
                ClassUtil.checkAndFixAccess(annotated, deserializationConfig.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            }
            return new StdKeyDeserializer.StringCtorKeyDeserializer(annotated);
        }
        Method annotated2 = ((AnnotatedMethod) annotatedMember).getAnnotated();
        if (deserializationConfig.canOverrideAccessModifiers()) {
            ClassUtil.checkAndFixAccess(annotated2, deserializationConfig.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return new StdKeyDeserializer.StringFactoryKeyDeserializer(annotated2);
    }

    private static AnnotatedAndMetadata<AnnotatedConstructor, JsonCreator.Mode> _findStringConstructor(BeanDescription beanDescription) {
        for (AnnotatedAndMetadata<AnnotatedConstructor, JsonCreator.Mode> annotatedAndMetadata : beanDescription.getConstructorsWithMode()) {
            AnnotatedConstructor annotatedConstructor = annotatedAndMetadata.annotated;
            if (annotatedConstructor.getParameterCount() == 1 && String.class == annotatedConstructor.getRawParameterType(0)) {
                return annotatedAndMetadata;
            }
        }
        return null;
    }

    private static AnnotatedMethod _findExplicitStringFactoryMethod(List<AnnotatedAndMetadata<AnnotatedMethod, JsonCreator.Mode>> list) throws JsonMappingException {
        AnnotatedMethod annotatedMethod = null;
        for (AnnotatedAndMetadata<AnnotatedMethod, JsonCreator.Mode> annotatedAndMetadata : list) {
            if (annotatedAndMetadata.metadata != null) {
                if (annotatedMethod == null) {
                    annotatedMethod = annotatedAndMetadata.annotated;
                } else {
                    Class<?> declaringClass = annotatedAndMetadata.annotated.getDeclaringClass();
                    throw new IllegalArgumentException("Multiple suitable annotated Creator factory methods to be used as the Key deserializer for type " + ClassUtil.nameOf(declaringClass));
                }
            }
        }
        return annotatedMethod;
    }

    @Override // com.fasterxml.jackson.databind.deser.KeyDeserializers
    public KeyDeserializer findKeyDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, BeanDescription beanDescription) throws JsonMappingException {
        Class<?> rawClass = javaType.getRawClass();
        if (rawClass.isPrimitive()) {
            rawClass = ClassUtil.wrapperType(rawClass);
        }
        return StdKeyDeserializer.forType(rawClass);
    }
}
