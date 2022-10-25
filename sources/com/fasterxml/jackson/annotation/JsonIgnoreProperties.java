package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface JsonIgnoreProperties {
    boolean allowGetters() default false;

    boolean allowSetters() default false;

    boolean ignoreUnknown() default false;

    String[] value() default {};

    /* loaded from: classes2.dex */
    public static class Value implements JacksonAnnotationValue<JsonIgnoreProperties>, Serializable {
        protected static final Value EMPTY = new Value(Collections.emptySet(), false, false, false, true);
        private static final long serialVersionUID = 1;
        protected final boolean _allowGetters;
        protected final boolean _allowSetters;
        protected final boolean _ignoreUnknown;
        protected final Set<String> _ignored;
        protected final boolean _merge;

        protected Value(Set<String> set, boolean z, boolean z2, boolean z3, boolean z4) {
            if (set == null) {
                this._ignored = Collections.emptySet();
            } else {
                this._ignored = set;
            }
            this._ignoreUnknown = z;
            this._allowGetters = z2;
            this._allowSetters = z3;
            this._merge = z4;
        }

        public static Value from(JsonIgnoreProperties jsonIgnoreProperties) {
            if (jsonIgnoreProperties == null) {
                return EMPTY;
            }
            return construct(_asSet(jsonIgnoreProperties.value()), jsonIgnoreProperties.ignoreUnknown(), jsonIgnoreProperties.allowGetters(), jsonIgnoreProperties.allowSetters(), false);
        }

        public static Value construct(Set<String> set, boolean z, boolean z2, boolean z3, boolean z4) {
            if (_empty(set, z, z2, z3, z4)) {
                return EMPTY;
            }
            return new Value(set, z, z2, z3, z4);
        }

        public static Value empty() {
            return EMPTY;
        }

        public static Value merge(Value value, Value value2) {
            return value == null ? value2 : value.withOverrides(value2);
        }

        public static Value mergeAll(Value... valueArr) {
            Value value = null;
            for (Value value2 : valueArr) {
                if (value2 != null) {
                    if (value != null) {
                        value2 = value.withOverrides(value2);
                    }
                    value = value2;
                }
            }
            return value;
        }

        public static Value forIgnoredProperties(Set<String> set) {
            return EMPTY.withIgnored(set);
        }

        public static Value forIgnoredProperties(String... strArr) {
            if (strArr.length == 0) {
                return EMPTY;
            }
            return EMPTY.withIgnored(_asSet(strArr));
        }

        public static Value forIgnoreUnknown(boolean z) {
            if (z) {
                return EMPTY.withIgnoreUnknown();
            }
            return EMPTY.withoutIgnoreUnknown();
        }

        public Value withOverrides(Value value) {
            if (value == null || value == EMPTY) {
                return this;
            }
            if (value._merge) {
                if (_equals(this, value)) {
                    return this;
                }
                boolean z = false;
                return construct(_merge(this._ignored, value._ignored), this._ignoreUnknown || value._ignoreUnknown, this._allowGetters || value._allowGetters, (this._allowSetters || value._allowSetters) ? true : true, true);
            }
            return value;
        }

        public Value withIgnored(Set<String> set) {
            return construct(set, this._ignoreUnknown, this._allowGetters, this._allowSetters, this._merge);
        }

        public Value withIgnored(String... strArr) {
            return construct(_asSet(strArr), this._ignoreUnknown, this._allowGetters, this._allowSetters, this._merge);
        }

        public Value withoutIgnored() {
            return construct(null, this._ignoreUnknown, this._allowGetters, this._allowSetters, this._merge);
        }

        public Value withIgnoreUnknown() {
            return this._ignoreUnknown ? this : construct(this._ignored, true, this._allowGetters, this._allowSetters, this._merge);
        }

        public Value withoutIgnoreUnknown() {
            return !this._ignoreUnknown ? this : construct(this._ignored, false, this._allowGetters, this._allowSetters, this._merge);
        }

        public Value withAllowGetters() {
            return this._allowGetters ? this : construct(this._ignored, this._ignoreUnknown, true, this._allowSetters, this._merge);
        }

        public Value withoutAllowGetters() {
            return !this._allowGetters ? this : construct(this._ignored, this._ignoreUnknown, false, this._allowSetters, this._merge);
        }

        public Value withAllowSetters() {
            return this._allowSetters ? this : construct(this._ignored, this._ignoreUnknown, this._allowGetters, true, this._merge);
        }

        public Value withoutAllowSetters() {
            return !this._allowSetters ? this : construct(this._ignored, this._ignoreUnknown, this._allowGetters, false, this._merge);
        }

        public Value withMerge() {
            return this._merge ? this : construct(this._ignored, this._ignoreUnknown, this._allowGetters, this._allowSetters, true);
        }

        public Value withoutMerge() {
            return !this._merge ? this : construct(this._ignored, this._ignoreUnknown, this._allowGetters, this._allowSetters, false);
        }

        @Override // com.fasterxml.jackson.annotation.JacksonAnnotationValue
        public Class<JsonIgnoreProperties> valueFor() {
            return JsonIgnoreProperties.class;
        }

        protected Object readResolve() {
            return _empty(this._ignored, this._ignoreUnknown, this._allowGetters, this._allowSetters, this._merge) ? EMPTY : this;
        }

        public Set<String> getIgnored() {
            return this._ignored;
        }

        public Set<String> findIgnoredForSerialization() {
            if (this._allowGetters) {
                return Collections.emptySet();
            }
            return this._ignored;
        }

        public Set<String> findIgnoredForDeserialization() {
            if (this._allowSetters) {
                return Collections.emptySet();
            }
            return this._ignored;
        }

        public boolean getIgnoreUnknown() {
            return this._ignoreUnknown;
        }

        public boolean getAllowGetters() {
            return this._allowGetters;
        }

        public boolean getAllowSetters() {
            return this._allowSetters;
        }

        public boolean getMerge() {
            return this._merge;
        }

        public String toString() {
            return String.format("JsonIgnoreProperties.Value(ignored=%s,ignoreUnknown=%s,allowGetters=%s,allowSetters=%s,merge=%s)", this._ignored, Boolean.valueOf(this._ignoreUnknown), Boolean.valueOf(this._allowGetters), Boolean.valueOf(this._allowSetters), Boolean.valueOf(this._merge));
        }

        public int hashCode() {
            return this._ignored.size() + (this._ignoreUnknown ? 1 : -3) + (this._allowGetters ? 3 : -7) + (this._allowSetters ? 7 : -11) + (this._merge ? 11 : -13);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return obj != null && obj.getClass() == getClass() && _equals(this, (Value) obj);
        }

        private static boolean _equals(Value value, Value value2) {
            return value._ignoreUnknown == value2._ignoreUnknown && value._merge == value2._merge && value._allowGetters == value2._allowGetters && value._allowSetters == value2._allowSetters && value._ignored.equals(value2._ignored);
        }

        private static Set<String> _asSet(String[] strArr) {
            if (strArr == null || strArr.length == 0) {
                return Collections.emptySet();
            }
            HashSet hashSet = new HashSet(strArr.length);
            for (String str : strArr) {
                hashSet.add(str);
            }
            return hashSet;
        }

        private static Set<String> _merge(Set<String> set, Set<String> set2) {
            if (set.isEmpty()) {
                return set2;
            }
            if (set2.isEmpty()) {
                return set;
            }
            HashSet hashSet = new HashSet(set.size() + set2.size());
            hashSet.addAll(set);
            hashSet.addAll(set2);
            return hashSet;
        }

        private static boolean _empty(Set<String> set, boolean z, boolean z2, boolean z3, boolean z4) {
            Value value = EMPTY;
            if (z == value._ignoreUnknown && z2 == value._allowGetters && z3 == value._allowSetters && z4 == value._merge) {
                return set == null || set.size() == 0;
            }
            return false;
        }
    }
}
