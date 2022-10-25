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
public @interface JsonIncludeProperties {
    String[] value() default {};

    /* loaded from: classes2.dex */
    public static class Value implements JacksonAnnotationValue<JsonIncludeProperties>, Serializable {
        protected static final Value ALL = new Value(null);
        private static final long serialVersionUID = 1;
        protected final Set<String> _included;

        protected Value(Set<String> set) {
            this._included = set;
        }

        public static Value from(JsonIncludeProperties jsonIncludeProperties) {
            if (jsonIncludeProperties == null) {
                return ALL;
            }
            return new Value(_asSet(jsonIncludeProperties.value()));
        }

        public static Value all() {
            return ALL;
        }

        @Override // com.fasterxml.jackson.annotation.JacksonAnnotationValue
        public Class<JsonIncludeProperties> valueFor() {
            return JsonIncludeProperties.class;
        }

        public Set<String> getIncluded() {
            return this._included;
        }

        public Value withOverrides(Value value) {
            Set<String> included;
            if (value == null || (included = value.getIncluded()) == null) {
                return this;
            }
            if (this._included == null) {
                return value;
            }
            HashSet hashSet = new HashSet();
            for (String str : included) {
                if (this._included.contains(str)) {
                    hashSet.add(str);
                }
            }
            return new Value(hashSet);
        }

        public String toString() {
            return String.format("JsonIncludeProperties.Value(included=%s)", this._included);
        }

        public int hashCode() {
            Set<String> set = this._included;
            if (set == null) {
                return 0;
            }
            return set.size();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return obj != null && obj.getClass() == getClass() && _equals(this._included, ((Value) obj)._included);
        }

        private static boolean _equals(Set<String> set, Set<String> set2) {
            if (set == null) {
                return set2 == null;
            }
            return set.equals(set2);
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
    }
}
