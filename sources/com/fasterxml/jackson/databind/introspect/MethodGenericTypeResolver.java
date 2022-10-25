package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes2.dex */
final class MethodGenericTypeResolver {
    MethodGenericTypeResolver() {
    }

    public static TypeResolutionContext narrowMethodTypeParameters(Method method, JavaType javaType, TypeFactory typeFactory, TypeResolutionContext typeResolutionContext) {
        TypeBindings bindMethodTypeParameters = bindMethodTypeParameters(method, javaType, typeResolutionContext);
        return bindMethodTypeParameters == null ? typeResolutionContext : new TypeResolutionContext.Basic(typeFactory, bindMethodTypeParameters);
    }

    static TypeBindings bindMethodTypeParameters(Method method, JavaType javaType, TypeResolutionContext typeResolutionContext) {
        JavaType boundType;
        TypeVariable<?> findByName;
        TypeVariable<Method>[] typeParameters = method.getTypeParameters();
        if (typeParameters.length == 0 || javaType.getBindings().isEmpty()) {
            return null;
        }
        Type genericReturnType = method.getGenericReturnType();
        if (genericReturnType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
            if (Objects.equals(javaType.getRawClass(), parameterizedType.getRawType())) {
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                ArrayList arrayList = new ArrayList(typeParameters.length);
                ArrayList arrayList2 = new ArrayList(typeParameters.length);
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    TypeVariable<?> maybeGetTypeVariable = maybeGetTypeVariable(actualTypeArguments[i]);
                    if (maybeGetTypeVariable != null) {
                        String name = maybeGetTypeVariable.getName();
                        if (name == null || (boundType = javaType.getBindings().getBoundType(i)) == null || (findByName = findByName(typeParameters, name)) == null) {
                            return null;
                        }
                        if (pessimisticallyValidateBounds(typeResolutionContext, boundType, findByName.getBounds())) {
                            int indexOf = arrayList.indexOf(name);
                            if (indexOf != -1) {
                                JavaType javaType2 = (JavaType) arrayList2.get(indexOf);
                                if (boundType.equals(javaType2)) {
                                    continue;
                                } else {
                                    boolean isTypeOrSubTypeOf = javaType2.isTypeOrSubTypeOf(boundType.getRawClass());
                                    boolean isTypeOrSubTypeOf2 = boundType.isTypeOrSubTypeOf(javaType2.getRawClass());
                                    if (!isTypeOrSubTypeOf && !isTypeOrSubTypeOf2) {
                                        return null;
                                    }
                                    if ((isTypeOrSubTypeOf ^ isTypeOrSubTypeOf2) && isTypeOrSubTypeOf2) {
                                        arrayList2.set(indexOf, boundType);
                                    }
                                }
                            } else {
                                arrayList.add(name);
                                arrayList2.add(boundType);
                            }
                        } else {
                            continue;
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                return TypeBindings.create(arrayList, arrayList2);
            }
            return null;
        }
        return null;
    }

    private static TypeVariable<?> maybeGetTypeVariable(Type type) {
        if (type instanceof TypeVariable) {
            return (TypeVariable) type;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length != 0) {
                return null;
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length == 1) {
                return maybeGetTypeVariable(upperBounds[0]);
            }
        }
        return null;
    }

    private static ParameterizedType maybeGetParameterizedType(Type type) {
        if (type instanceof ParameterizedType) {
            return (ParameterizedType) type;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length != 0) {
                return null;
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length == 1) {
                return maybeGetParameterizedType(upperBounds[0]);
            }
        }
        return null;
    }

    private static boolean pessimisticallyValidateBounds(TypeResolutionContext typeResolutionContext, JavaType javaType, Type[] typeArr) {
        for (Type type : typeArr) {
            if (!pessimisticallyValidateBound(typeResolutionContext, javaType, type)) {
                return false;
            }
        }
        return true;
    }

    private static boolean pessimisticallyValidateBound(TypeResolutionContext typeResolutionContext, JavaType javaType, Type type) {
        if (javaType.isTypeOrSubTypeOf(typeResolutionContext.resolveType(type).getRawClass())) {
            ParameterizedType maybeGetParameterizedType = maybeGetParameterizedType(type);
            if (maybeGetParameterizedType == null || !Objects.equals(javaType.getRawClass(), maybeGetParameterizedType.getRawType())) {
                return true;
            }
            Type[] actualTypeArguments = maybeGetParameterizedType.getActualTypeArguments();
            TypeBindings bindings = javaType.getBindings();
            if (bindings.size() != actualTypeArguments.length) {
                return false;
            }
            for (int i = 0; i < bindings.size(); i++) {
                if (!pessimisticallyValidateBound(typeResolutionContext, bindings.getBoundType(i), actualTypeArguments[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static TypeVariable<?> findByName(TypeVariable<?>[] typeVariableArr, String str) {
        if (typeVariableArr != null && str != null) {
            for (TypeVariable<?> typeVariable : typeVariableArr) {
                if (str.equals(typeVariable.getName())) {
                    return typeVariable;
                }
            }
        }
        return null;
    }
}
