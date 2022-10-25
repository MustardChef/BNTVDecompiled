package com.fasterxml.jackson.databind.type;

import java.util.Collection;
import java.util.Map;

/* loaded from: classes2.dex */
public enum LogicalType {
    Array,
    Collection,
    Map,
    POJO,
    Untyped,
    Integer,
    Float,
    Boolean,
    Enum,
    Textual,
    Binary,
    DateTime,
    OtherScalar;

    public static LogicalType fromClass(Class<?> cls, LogicalType logicalType) {
        if (cls.isEnum()) {
            return Enum;
        }
        if (cls.isArray()) {
            if (cls == byte[].class) {
                return Binary;
            }
            return Array;
        } else if (Collection.class.isAssignableFrom(cls)) {
            return Collection;
        } else {
            if (Map.class.isAssignableFrom(cls)) {
                return Map;
            }
            return cls == String.class ? Textual : logicalType;
        }
    }
}
