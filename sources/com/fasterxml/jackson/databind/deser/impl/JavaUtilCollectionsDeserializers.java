package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class JavaUtilCollectionsDeserializers {
    private static final String PREFIX_JAVA_UTIL_ARRAYS = "java.util.Arrays$";
    private static final String PREFIX_JAVA_UTIL_COLLECTIONS = "java.util.Collections$";
    private static final String PREFIX_JAVA_UTIL_IMMUTABLE_COLL = "java.util.ImmutableCollections$";
    public static final int TYPE_AS_LIST = 11;
    private static final int TYPE_SINGLETON_LIST = 2;
    private static final int TYPE_SINGLETON_MAP = 3;
    private static final int TYPE_SINGLETON_SET = 1;
    private static final int TYPE_SYNC_COLLECTION = 8;
    private static final int TYPE_SYNC_LIST = 9;
    private static final int TYPE_SYNC_MAP = 10;
    private static final int TYPE_SYNC_SET = 7;
    private static final int TYPE_UNMODIFIABLE_LIST = 5;
    private static final int TYPE_UNMODIFIABLE_MAP = 6;
    private static final int TYPE_UNMODIFIABLE_SET = 4;

    public static JsonDeserializer<?> findForCollection(DeserializationContext deserializationContext, JavaType javaType) throws JsonMappingException {
        JavaUtilCollectionsConverter converter;
        String name = javaType.getRawClass().getName();
        if (name.startsWith("java.util.")) {
            String _findUtilCollectionsTypeName = _findUtilCollectionsTypeName(name);
            if (_findUtilCollectionsTypeName != null) {
                String _findUnmodifiableTypeName = _findUnmodifiableTypeName(_findUtilCollectionsTypeName);
                if (_findUnmodifiableTypeName != null) {
                    if (_findUnmodifiableTypeName.endsWith("Set")) {
                        converter = converter(4, javaType, Set.class);
                    } else {
                        if (_findUnmodifiableTypeName.endsWith("List")) {
                            converter = converter(5, javaType, List.class);
                        }
                        converter = null;
                    }
                } else {
                    String _findSingletonTypeName = _findSingletonTypeName(_findUtilCollectionsTypeName);
                    if (_findSingletonTypeName != null) {
                        if (_findSingletonTypeName.endsWith("Set")) {
                            converter = converter(1, javaType, Set.class);
                        } else {
                            if (_findSingletonTypeName.endsWith("List")) {
                                converter = converter(2, javaType, List.class);
                            }
                            converter = null;
                        }
                    } else {
                        String _findSyncTypeName = _findSyncTypeName(_findUtilCollectionsTypeName);
                        if (_findSyncTypeName != null) {
                            if (_findSyncTypeName.endsWith("Set")) {
                                converter = converter(7, javaType, Set.class);
                            } else if (_findSyncTypeName.endsWith("List")) {
                                converter = converter(9, javaType, List.class);
                            } else if (_findSyncTypeName.endsWith("Collection")) {
                                converter = converter(8, javaType, Collection.class);
                            }
                        }
                        converter = null;
                    }
                }
                if (converter == null) {
                    return null;
                }
                return new StdDelegatingDeserializer(converter);
            }
            String _findUtilArrayTypeName = _findUtilArrayTypeName(name);
            if (_findUtilArrayTypeName != null) {
                if (_findUtilArrayTypeName.contains("List")) {
                    return new StdDelegatingDeserializer(converter(5, javaType, List.class));
                }
                return null;
            }
            String _findUtilCollectionsImmutableTypeName = _findUtilCollectionsImmutableTypeName(name);
            if (_findUtilCollectionsImmutableTypeName == null || !_findUtilCollectionsImmutableTypeName.contains("List")) {
                return null;
            }
            return new StdDelegatingDeserializer(converter(11, javaType, List.class));
        }
        return null;
    }

    public static JsonDeserializer<?> findForMap(DeserializationContext deserializationContext, JavaType javaType) throws JsonMappingException {
        JavaUtilCollectionsConverter converter;
        String name = javaType.getRawClass().getName();
        String _findUtilCollectionsTypeName = _findUtilCollectionsTypeName(name);
        if (_findUtilCollectionsTypeName != null) {
            String _findUnmodifiableTypeName = _findUnmodifiableTypeName(_findUtilCollectionsTypeName);
            if (_findUnmodifiableTypeName != null) {
                if (_findUnmodifiableTypeName.contains("Map")) {
                    converter = converter(6, javaType, Map.class);
                }
                converter = null;
            } else {
                String _findSingletonTypeName = _findSingletonTypeName(_findUtilCollectionsTypeName);
                if (_findSingletonTypeName != null) {
                    if (_findSingletonTypeName.contains("Map")) {
                        converter = converter(3, javaType, Map.class);
                    }
                    converter = null;
                } else {
                    String _findSyncTypeName = _findSyncTypeName(_findUtilCollectionsTypeName);
                    if (_findSyncTypeName != null && _findSyncTypeName.contains("Map")) {
                        converter = converter(10, javaType, Map.class);
                    }
                    converter = null;
                }
            }
        } else {
            String _findUtilCollectionsImmutableTypeName = _findUtilCollectionsImmutableTypeName(name);
            if (_findUtilCollectionsImmutableTypeName != null && _findUtilCollectionsImmutableTypeName.contains("Map")) {
                converter = converter(6, javaType, Map.class);
            }
            converter = null;
        }
        if (converter == null) {
            return null;
        }
        return new StdDelegatingDeserializer(converter);
    }

    static JavaUtilCollectionsConverter converter(int i, JavaType javaType, Class<?> cls) {
        return new JavaUtilCollectionsConverter(i, javaType.findSuperType(cls));
    }

    private static String _findUtilArrayTypeName(String str) {
        if (str.startsWith(PREFIX_JAVA_UTIL_ARRAYS)) {
            return str.substring(17);
        }
        return null;
    }

    private static String _findUtilCollectionsTypeName(String str) {
        if (str.startsWith(PREFIX_JAVA_UTIL_COLLECTIONS)) {
            return str.substring(22);
        }
        return null;
    }

    private static String _findUtilCollectionsImmutableTypeName(String str) {
        if (str.startsWith(PREFIX_JAVA_UTIL_IMMUTABLE_COLL)) {
            return str.substring(31);
        }
        return null;
    }

    private static String _findSingletonTypeName(String str) {
        if (str.startsWith("Singleton")) {
            return str.substring(9);
        }
        return null;
    }

    private static String _findSyncTypeName(String str) {
        if (str.startsWith("Synchronized")) {
            return str.substring(12);
        }
        return null;
    }

    private static String _findUnmodifiableTypeName(String str) {
        if (str.startsWith("Unmodifiable")) {
            return str.substring(12);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class JavaUtilCollectionsConverter implements Converter<Object, Object> {
        private final JavaType _inputType;
        private final int _kind;

        JavaUtilCollectionsConverter(int i, JavaType javaType) {
            this._inputType = javaType;
            this._kind = i;
        }

        @Override // com.fasterxml.jackson.databind.util.Converter
        public Object convert(Object obj) {
            if (obj == null) {
                return null;
            }
            switch (this._kind) {
                case 1:
                    Set set = (Set) obj;
                    _checkSingleton(set.size());
                    return Collections.singleton(set.iterator().next());
                case 2:
                    List list = (List) obj;
                    _checkSingleton(list.size());
                    return Collections.singletonList(list.get(0));
                case 3:
                    Map map = (Map) obj;
                    _checkSingleton(map.size());
                    Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
                    return Collections.singletonMap(entry.getKey(), entry.getValue());
                case 4:
                    return Collections.unmodifiableSet((Set) obj);
                case 5:
                    return Collections.unmodifiableList((List) obj);
                case 6:
                    return Collections.unmodifiableMap((Map) obj);
                case 7:
                    return Collections.synchronizedSet((Set) obj);
                case 8:
                    return Collections.synchronizedCollection((Collection) obj);
                case 9:
                    return Collections.synchronizedList((List) obj);
                case 10:
                    return Collections.synchronizedMap((Map) obj);
                default:
                    return obj;
            }
        }

        @Override // com.fasterxml.jackson.databind.util.Converter
        public JavaType getInputType(TypeFactory typeFactory) {
            return this._inputType;
        }

        @Override // com.fasterxml.jackson.databind.util.Converter
        public JavaType getOutputType(TypeFactory typeFactory) {
            return this._inputType;
        }

        private void _checkSingleton(int i) {
            if (i == 1) {
                return;
            }
            throw new IllegalArgumentException("Can not deserialize Singleton container from " + i + " entries");
        }
    }
}
