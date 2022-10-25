package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ConfigOverrides implements Serializable {
    private static final long serialVersionUID = 1;
    protected JsonInclude.Value _defaultInclusion;
    protected Boolean _defaultLeniency;
    protected Boolean _defaultMergeable;
    protected JsonSetter.Value _defaultSetterInfo;
    protected Map<Class<?>, MutableConfigOverride> _overrides;
    protected VisibilityChecker<?> _visibilityChecker;

    public ConfigOverrides() {
        this(null, JsonInclude.Value.empty(), JsonSetter.Value.empty(), VisibilityChecker.Std.defaultInstance(), null, null);
    }

    protected ConfigOverrides(Map<Class<?>, MutableConfigOverride> map, JsonInclude.Value value, JsonSetter.Value value2, VisibilityChecker<?> visibilityChecker, Boolean bool, Boolean bool2) {
        this._overrides = map;
        this._defaultInclusion = value;
        this._defaultSetterInfo = value2;
        this._visibilityChecker = visibilityChecker;
        this._defaultMergeable = bool;
        this._defaultLeniency = bool2;
    }

    @Deprecated
    protected ConfigOverrides(Map<Class<?>, MutableConfigOverride> map, JsonInclude.Value value, JsonSetter.Value value2, VisibilityChecker<?> visibilityChecker, Boolean bool) {
        this(map, value, value2, visibilityChecker, bool, null);
    }

    public ConfigOverrides copy() {
        Map<Class<?>, MutableConfigOverride> _newMap;
        if (this._overrides == null) {
            _newMap = null;
        } else {
            _newMap = _newMap();
            for (Map.Entry<Class<?>, MutableConfigOverride> entry : this._overrides.entrySet()) {
                _newMap.put(entry.getKey(), entry.getValue().copy());
            }
        }
        return new ConfigOverrides(_newMap, this._defaultInclusion, this._defaultSetterInfo, this._visibilityChecker, this._defaultMergeable, this._defaultLeniency);
    }

    public ConfigOverride findOverride(Class<?> cls) {
        Map<Class<?>, MutableConfigOverride> map = this._overrides;
        if (map == null) {
            return null;
        }
        return map.get(cls);
    }

    public MutableConfigOverride findOrCreateOverride(Class<?> cls) {
        if (this._overrides == null) {
            this._overrides = _newMap();
        }
        MutableConfigOverride mutableConfigOverride = this._overrides.get(cls);
        if (mutableConfigOverride == null) {
            MutableConfigOverride mutableConfigOverride2 = new MutableConfigOverride();
            this._overrides.put(cls, mutableConfigOverride2);
            return mutableConfigOverride2;
        }
        return mutableConfigOverride;
    }

    public JsonFormat.Value findFormatDefaults(Class<?> cls) {
        MutableConfigOverride mutableConfigOverride;
        JsonFormat.Value format;
        Map<Class<?>, MutableConfigOverride> map = this._overrides;
        if (map != null && (mutableConfigOverride = map.get(cls)) != null && (format = mutableConfigOverride.getFormat()) != null) {
            return !format.hasLenient() ? format.withLenient(this._defaultLeniency) : format;
        }
        Boolean bool = this._defaultLeniency;
        if (bool == null) {
            return JsonFormat.Value.empty();
        }
        return JsonFormat.Value.forLeniency(bool.booleanValue());
    }

    public JsonInclude.Value getDefaultInclusion() {
        return this._defaultInclusion;
    }

    public JsonSetter.Value getDefaultSetterInfo() {
        return this._defaultSetterInfo;
    }

    public Boolean getDefaultMergeable() {
        return this._defaultMergeable;
    }

    public Boolean getDefaultLeniency() {
        return this._defaultLeniency;
    }

    public VisibilityChecker<?> getDefaultVisibility() {
        return this._visibilityChecker;
    }

    public void setDefaultInclusion(JsonInclude.Value value) {
        this._defaultInclusion = value;
    }

    public void setDefaultSetterInfo(JsonSetter.Value value) {
        this._defaultSetterInfo = value;
    }

    public void setDefaultMergeable(Boolean bool) {
        this._defaultMergeable = bool;
    }

    public void setDefaultLeniency(Boolean bool) {
        this._defaultLeniency = bool;
    }

    public void setDefaultVisibility(VisibilityChecker<?> visibilityChecker) {
        this._visibilityChecker = visibilityChecker;
    }

    protected Map<Class<?>, MutableConfigOverride> _newMap() {
        return new HashMap();
    }
}
