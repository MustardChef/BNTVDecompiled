package com.fasterxml.jackson.databind.jsontype;

import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class NamedType implements Serializable {
    private static final long serialVersionUID = 1;
    protected final Class<?> _class;
    protected final int _hashCode;
    protected String _name;

    public NamedType(Class<?> cls) {
        this(cls, null);
    }

    public NamedType(Class<?> cls, String str) {
        this._class = cls;
        this._hashCode = cls.getName().hashCode() + (str == null ? 0 : str.hashCode());
        setName(str);
    }

    public Class<?> getType() {
        return this._class;
    }

    public String getName() {
        return this._name;
    }

    public void setName(String str) {
        this._name = (str == null || str.isEmpty()) ? null : null;
    }

    public boolean hasName() {
        return this._name != null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            NamedType namedType = (NamedType) obj;
            return this._class == namedType._class && Objects.equals(this._name, namedType._name);
        }
        return false;
    }

    public int hashCode() {
        return this._hashCode;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("[NamedType, class ");
        sb.append(this._class.getName());
        sb.append(", name: ");
        if (this._name == null) {
            str = "null";
        } else {
            str = "'" + this._name + "'";
        }
        sb.append(str);
        sb.append("]");
        return sb.toString();
    }
}
