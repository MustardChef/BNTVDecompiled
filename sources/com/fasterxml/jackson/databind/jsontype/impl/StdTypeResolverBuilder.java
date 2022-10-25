package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.util.Collection;

/* loaded from: classes2.dex */
public class StdTypeResolverBuilder implements TypeResolverBuilder<StdTypeResolverBuilder> {
    protected TypeIdResolver _customIdResolver;
    protected Class<?> _defaultImpl;
    protected JsonTypeInfo.EnumC2273Id _idType;
    protected JsonTypeInfo.EnumC2272As _includeAs;
    protected boolean _typeIdVisible;
    protected String _typeProperty;

    protected boolean allowPrimitiveTypes(MapperConfig<?> mapperConfig, JavaType javaType) {
        return false;
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder
    public /* bridge */ /* synthetic */ StdTypeResolverBuilder defaultImpl(Class cls) {
        return defaultImpl2((Class<?>) cls);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder
    public /* bridge */ /* synthetic */ StdTypeResolverBuilder withDefaultImpl(Class cls) {
        return withDefaultImpl2((Class<?>) cls);
    }

    public StdTypeResolverBuilder() {
        this._typeIdVisible = false;
    }

    protected StdTypeResolverBuilder(JsonTypeInfo.EnumC2273Id enumC2273Id, JsonTypeInfo.EnumC2272As enumC2272As, String str) {
        this._typeIdVisible = false;
        this._idType = enumC2273Id;
        this._includeAs = enumC2272As;
        this._typeProperty = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StdTypeResolverBuilder(StdTypeResolverBuilder stdTypeResolverBuilder, Class<?> cls) {
        this._typeIdVisible = false;
        this._idType = stdTypeResolverBuilder._idType;
        this._includeAs = stdTypeResolverBuilder._includeAs;
        this._typeProperty = stdTypeResolverBuilder._typeProperty;
        this._typeIdVisible = stdTypeResolverBuilder._typeIdVisible;
        this._customIdResolver = stdTypeResolverBuilder._customIdResolver;
        this._defaultImpl = cls;
    }

    public static StdTypeResolverBuilder noTypeInfoBuilder() {
        return new StdTypeResolverBuilder().init(JsonTypeInfo.EnumC2273Id.NONE, (TypeIdResolver) null);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder
    public StdTypeResolverBuilder init(JsonTypeInfo.EnumC2273Id enumC2273Id, TypeIdResolver typeIdResolver) {
        if (enumC2273Id == null) {
            throw new IllegalArgumentException("idType cannot be null");
        }
        this._idType = enumC2273Id;
        this._customIdResolver = typeIdResolver;
        this._typeProperty = enumC2273Id.getDefaultPropertyName();
        return this;
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder
    public TypeSerializer buildTypeSerializer(SerializationConfig serializationConfig, JavaType javaType, Collection<NamedType> collection) {
        if (this._idType == JsonTypeInfo.EnumC2273Id.NONE) {
            return null;
        }
        if (!javaType.isPrimitive() || allowPrimitiveTypes(serializationConfig, javaType)) {
            TypeIdResolver idResolver = idResolver(serializationConfig, javaType, subTypeValidator(serializationConfig), collection, true, false);
            if (this._idType == JsonTypeInfo.EnumC2273Id.DEDUCTION) {
                return new AsExistingPropertyTypeSerializer(idResolver, null, this._typeProperty);
            }
            int i = C23071.$SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$As[this._includeAs.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                return new AsExistingPropertyTypeSerializer(idResolver, null, this._typeProperty);
                            }
                            throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this._includeAs);
                        }
                        return new AsExternalTypeSerializer(idResolver, null, this._typeProperty);
                    }
                    return new AsWrapperTypeSerializer(idResolver, null);
                }
                return new AsPropertyTypeSerializer(idResolver, null, this._typeProperty);
            }
            return new AsArrayTypeSerializer(idResolver, null);
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder
    public TypeDeserializer buildTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, Collection<NamedType> collection) {
        if (this._idType == JsonTypeInfo.EnumC2273Id.NONE) {
            return null;
        }
        if (!javaType.isPrimitive() || allowPrimitiveTypes(deserializationConfig, javaType)) {
            TypeIdResolver idResolver = idResolver(deserializationConfig, javaType, verifyBaseTypeValidity(deserializationConfig, javaType), collection, false, true);
            JavaType defineDefaultImpl = defineDefaultImpl(deserializationConfig, javaType);
            if (this._idType == JsonTypeInfo.EnumC2273Id.DEDUCTION) {
                return new AsDeductionTypeDeserializer(javaType, idResolver, defineDefaultImpl, deserializationConfig, collection);
            }
            int i = C23071.$SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$As[this._includeAs.ordinal()];
            if (i == 1) {
                return new AsArrayTypeDeserializer(javaType, idResolver, this._typeProperty, this._typeIdVisible, defineDefaultImpl);
            }
            if (i != 2) {
                if (i == 3) {
                    return new AsWrapperTypeDeserializer(javaType, idResolver, this._typeProperty, this._typeIdVisible, defineDefaultImpl);
                }
                if (i == 4) {
                    return new AsExternalTypeDeserializer(javaType, idResolver, this._typeProperty, this._typeIdVisible, defineDefaultImpl);
                }
                if (i != 5) {
                    throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this._includeAs);
                }
            }
            return new AsPropertyTypeDeserializer(javaType, idResolver, this._typeProperty, this._typeIdVisible, defineDefaultImpl, this._includeAs);
        }
        return null;
    }

    protected JavaType defineDefaultImpl(DeserializationConfig deserializationConfig, JavaType javaType) {
        Class<?> cls = this._defaultImpl;
        if (cls != null) {
            if (cls == Void.class || cls == NoClass.class) {
                return deserializationConfig.getTypeFactory().constructType(this._defaultImpl);
            }
            if (javaType.hasRawClass(cls)) {
                return javaType;
            }
            if (javaType.isTypeOrSuperTypeOf(this._defaultImpl)) {
                return deserializationConfig.getTypeFactory().constructSpecializedType(javaType, this._defaultImpl);
            }
            if (javaType.hasRawClass(this._defaultImpl)) {
                return javaType;
            }
        }
        if (!deserializationConfig.isEnabled(MapperFeature.USE_BASE_TYPE_AS_DEFAULT_IMPL) || javaType.isAbstract()) {
            return null;
        }
        return javaType;
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder
    public StdTypeResolverBuilder inclusion(JsonTypeInfo.EnumC2272As enumC2272As) {
        if (enumC2272As == null) {
            throw new IllegalArgumentException("includeAs cannot be null");
        }
        this._includeAs = enumC2272As;
        return this;
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder
    public StdTypeResolverBuilder typeProperty(String str) {
        if (str == null || str.isEmpty()) {
            str = this._idType.getDefaultPropertyName();
        }
        this._typeProperty = str;
        return this;
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder
    /* renamed from: defaultImpl  reason: avoid collision after fix types in other method */
    public StdTypeResolverBuilder defaultImpl2(Class<?> cls) {
        this._defaultImpl = cls;
        return this;
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder
    public StdTypeResolverBuilder typeIdVisibility(boolean z) {
        this._typeIdVisible = z;
        return this;
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder
    /* renamed from: withDefaultImpl  reason: avoid collision after fix types in other method */
    public StdTypeResolverBuilder withDefaultImpl2(Class<?> cls) {
        if (this._defaultImpl == cls) {
            return this;
        }
        ClassUtil.verifyMustOverride(StdTypeResolverBuilder.class, this, "withDefaultImpl");
        return new StdTypeResolverBuilder(this, cls);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder
    public Class<?> getDefaultImpl() {
        return this._defaultImpl;
    }

    public String getTypeProperty() {
        return this._typeProperty;
    }

    public boolean isTypeIdVisible() {
        return this._typeIdVisible;
    }

    protected TypeIdResolver idResolver(MapperConfig<?> mapperConfig, JavaType javaType, PolymorphicTypeValidator polymorphicTypeValidator, Collection<NamedType> collection, boolean z, boolean z2) {
        TypeIdResolver typeIdResolver = this._customIdResolver;
        if (typeIdResolver != null) {
            return typeIdResolver;
        }
        if (this._idType == null) {
            throw new IllegalStateException("Cannot build, 'init()' not yet called");
        }
        int i = C23071.$SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$Id[this._idType.ordinal()];
        if (i == 1 || i == 2) {
            return ClassNameIdResolver.construct(javaType, mapperConfig, polymorphicTypeValidator);
        }
        if (i != 3) {
            if (i != 4) {
                if (i == 5) {
                    return null;
                }
                throw new IllegalStateException("Do not know how to construct standard type id resolver for idType: " + this._idType);
            }
            return TypeNameIdResolver.construct(mapperConfig, javaType, collection, z, z2);
        }
        return MinimalClassNameIdResolver.construct(javaType, mapperConfig, polymorphicTypeValidator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder$1 */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C23071 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$As;
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$Id;

        static {
            int[] iArr = new int[JsonTypeInfo.EnumC2273Id.values().length];
            $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$Id = iArr;
            try {
                iArr[JsonTypeInfo.EnumC2273Id.DEDUCTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$Id[JsonTypeInfo.EnumC2273Id.CLASS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$Id[JsonTypeInfo.EnumC2273Id.MINIMAL_CLASS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$Id[JsonTypeInfo.EnumC2273Id.NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$Id[JsonTypeInfo.EnumC2273Id.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$Id[JsonTypeInfo.EnumC2273Id.CUSTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[JsonTypeInfo.EnumC2272As.values().length];
            $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$As = iArr2;
            try {
                iArr2[JsonTypeInfo.EnumC2272As.WRAPPER_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$As[JsonTypeInfo.EnumC2272As.PROPERTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$As[JsonTypeInfo.EnumC2272As.WRAPPER_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$As[JsonTypeInfo.EnumC2272As.EXTERNAL_PROPERTY.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$As[JsonTypeInfo.EnumC2272As.EXISTING_PROPERTY.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public PolymorphicTypeValidator subTypeValidator(MapperConfig<?> mapperConfig) {
        return mapperConfig.getPolymorphicTypeValidator();
    }

    protected PolymorphicTypeValidator verifyBaseTypeValidity(MapperConfig<?> mapperConfig, JavaType javaType) {
        PolymorphicTypeValidator subTypeValidator = subTypeValidator(mapperConfig);
        if (this._idType == JsonTypeInfo.EnumC2273Id.CLASS || this._idType == JsonTypeInfo.EnumC2273Id.MINIMAL_CLASS) {
            PolymorphicTypeValidator.Validity validateBaseType = subTypeValidator.validateBaseType(mapperConfig, javaType);
            if (validateBaseType == PolymorphicTypeValidator.Validity.DENIED) {
                return reportInvalidBaseType(mapperConfig, javaType, subTypeValidator);
            }
            if (validateBaseType == PolymorphicTypeValidator.Validity.ALLOWED) {
                return LaissezFaireSubTypeValidator.instance;
            }
        }
        return subTypeValidator;
    }

    protected PolymorphicTypeValidator reportInvalidBaseType(MapperConfig<?> mapperConfig, JavaType javaType, PolymorphicTypeValidator polymorphicTypeValidator) {
        throw new IllegalArgumentException(String.format("Configured `PolymorphicTypeValidator` (of type %s) denied resolution of all subtypes of base type %s", ClassUtil.classNameOf(polymorphicTypeValidator), ClassUtil.classNameOf(javaType.getRawClass())));
    }
}
