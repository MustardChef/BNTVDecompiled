package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.p033io.SerializedString;
import com.fasterxml.jackson.core.util.InternCache;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class PropertyName implements Serializable {
    private static final String _NO_NAME = "";
    private static final String _USE_DEFAULT = "";
    private static final long serialVersionUID = 1;
    protected SerializableString _encodedSimple;
    protected final String _namespace;
    protected final String _simpleName;
    public static final PropertyName USE_DEFAULT = new PropertyName("", null);
    public static final PropertyName NO_NAME = new PropertyName(new String(""), null);

    public PropertyName(String str) {
        this(str, null);
    }

    public PropertyName(String str, String str2) {
        this._simpleName = ClassUtil.nonNullString(str);
        this._namespace = str2;
    }

    protected Object readResolve() {
        String str;
        return (this._namespace == null && ((str = this._simpleName) == null || "".equals(str))) ? USE_DEFAULT : this;
    }

    public static PropertyName construct(String str) {
        if (str == null || str.isEmpty()) {
            return USE_DEFAULT;
        }
        return new PropertyName(InternCache.instance.intern(str), null);
    }

    public static PropertyName construct(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null && str.isEmpty()) {
            return USE_DEFAULT;
        }
        return new PropertyName(InternCache.instance.intern(str), str2);
    }

    public PropertyName internSimpleName() {
        String intern;
        return (this._simpleName.isEmpty() || (intern = InternCache.instance.intern(this._simpleName)) == this._simpleName) ? this : new PropertyName(intern, this._namespace);
    }

    public PropertyName withSimpleName(String str) {
        if (str == null) {
            str = "";
        }
        return str.equals(this._simpleName) ? this : new PropertyName(str, this._namespace);
    }

    public PropertyName withNamespace(String str) {
        if (str == null) {
            if (this._namespace == null) {
                return this;
            }
        } else if (str.equals(this._namespace)) {
            return this;
        }
        return new PropertyName(this._simpleName, str);
    }

    public String getSimpleName() {
        return this._simpleName;
    }

    public SerializableString simpleAsEncoded(MapperConfig<?> mapperConfig) {
        SerializableString compileString;
        SerializableString serializableString = this._encodedSimple;
        if (serializableString == null) {
            if (mapperConfig == null) {
                compileString = new SerializedString(this._simpleName);
            } else {
                compileString = mapperConfig.compileString(this._simpleName);
            }
            SerializableString serializableString2 = compileString;
            this._encodedSimple = serializableString2;
            return serializableString2;
        }
        return serializableString;
    }

    public String getNamespace() {
        return this._namespace;
    }

    public boolean hasSimpleName() {
        return !this._simpleName.isEmpty();
    }

    public boolean hasSimpleName(String str) {
        return this._simpleName.equals(str);
    }

    public boolean hasNamespace() {
        return this._namespace != null;
    }

    public boolean isEmpty() {
        return this._namespace == null && this._simpleName.isEmpty();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            PropertyName propertyName = (PropertyName) obj;
            String str = this._simpleName;
            if (str == null) {
                if (propertyName._simpleName != null) {
                    return false;
                }
            } else if (!str.equals(propertyName._simpleName)) {
                return false;
            }
            String str2 = this._namespace;
            if (str2 == null) {
                return propertyName._namespace == null;
            }
            return str2.equals(propertyName._namespace);
        }
        return false;
    }

    public int hashCode() {
        String str = this._namespace;
        if (str == null) {
            return this._simpleName.hashCode();
        }
        return str.hashCode() ^ this._simpleName.hashCode();
    }

    public String toString() {
        if (this._namespace == null) {
            return this._simpleName;
        }
        return "{" + this._namespace + "}" + this._simpleName;
    }
}
