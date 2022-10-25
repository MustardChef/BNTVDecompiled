package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class TypeNameIdResolver extends TypeIdResolverBase {
    protected final boolean _caseInsensitive;
    protected final MapperConfig<?> _config;
    protected final Map<String, JavaType> _idToType;
    protected final ConcurrentHashMap<String, String> _typeToId;

    protected TypeNameIdResolver(MapperConfig<?> mapperConfig, JavaType javaType, ConcurrentHashMap<String, String> concurrentHashMap, HashMap<String, JavaType> hashMap) {
        super(javaType, mapperConfig.getTypeFactory());
        this._config = mapperConfig;
        this._typeToId = concurrentHashMap;
        this._idToType = hashMap;
        this._caseInsensitive = mapperConfig.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_VALUES);
    }

    public static TypeNameIdResolver construct(MapperConfig<?> mapperConfig, JavaType javaType, Collection<NamedType> collection, boolean z, boolean z2) {
        HashMap hashMap;
        ConcurrentHashMap concurrentHashMap;
        if (z == z2) {
            throw new IllegalArgumentException();
        }
        if (z) {
            concurrentHashMap = new ConcurrentHashMap();
            hashMap = null;
        } else {
            hashMap = new HashMap();
            concurrentHashMap = new ConcurrentHashMap(4);
        }
        boolean isEnabled = mapperConfig.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_VALUES);
        if (collection != null) {
            for (NamedType namedType : collection) {
                Class<?> type = namedType.getType();
                String name = namedType.hasName() ? namedType.getName() : _defaultTypeId(type);
                if (z) {
                    concurrentHashMap.put(type.getName(), name);
                }
                if (z2) {
                    if (isEnabled) {
                        name = name.toLowerCase();
                    }
                    JavaType javaType2 = (JavaType) hashMap.get(name);
                    if (javaType2 == null || !type.isAssignableFrom(javaType2.getRawClass())) {
                        hashMap.put(name, mapperConfig.constructType(type));
                    }
                }
            }
        }
        return new TypeNameIdResolver(mapperConfig, javaType, concurrentHashMap, hashMap);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeIdResolver
    public JsonTypeInfo.EnumC2273Id getMechanism() {
        return JsonTypeInfo.EnumC2273Id.NAME;
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeIdResolver
    public String idFromValue(Object obj) {
        return idFromClass(obj.getClass());
    }

    protected String idFromClass(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        String name = cls.getName();
        String str = this._typeToId.get(name);
        if (str == null) {
            Class<?> rawClass = this._typeFactory.constructType(cls).getRawClass();
            if (this._config.isAnnotationProcessingEnabled()) {
                str = this._config.getAnnotationIntrospector().findTypeName(this._config.introspectClassAnnotations(rawClass).getClassInfo());
            }
            if (str == null) {
                str = _defaultTypeId(rawClass);
            }
            this._typeToId.put(name, str);
        }
        return str;
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeIdResolver
    public String idFromValueAndType(Object obj, Class<?> cls) {
        if (obj == null) {
            return idFromClass(cls);
        }
        return idFromValue(obj);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase, com.fasterxml.jackson.databind.jsontype.TypeIdResolver
    public JavaType typeFromId(DatabindContext databindContext, String str) {
        return _typeFromId(str);
    }

    protected JavaType _typeFromId(String str) {
        if (this._caseInsensitive) {
            str = str.toLowerCase();
        }
        return this._idToType.get(str);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase, com.fasterxml.jackson.databind.jsontype.TypeIdResolver
    public String getDescForKnownTypeIds() {
        TreeSet treeSet = new TreeSet();
        for (Map.Entry<String, JavaType> entry : this._idToType.entrySet()) {
            if (entry.getValue().isConcrete()) {
                treeSet.add(entry.getKey());
            }
        }
        return treeSet.toString();
    }

    public String toString() {
        return String.format("[%s; id-to-type=%s]", getClass().getName(), this._idToType);
    }

    protected static String _defaultTypeId(Class<?> cls) {
        String name = cls.getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf < 0 ? name : name.substring(lastIndexOf + 1);
    }
}
