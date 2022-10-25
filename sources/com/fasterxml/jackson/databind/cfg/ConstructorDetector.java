package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class ConstructorDetector implements Serializable {
    private static final long serialVersionUID = 1;
    protected final boolean _allowJDKTypeCtors;
    protected final boolean _requireCtorAnnotation;
    protected final SingleArgConstructor _singleArgMode;
    public static final ConstructorDetector DEFAULT = new ConstructorDetector(SingleArgConstructor.HEURISTIC);
    public static final ConstructorDetector USE_PROPERTIES_BASED = new ConstructorDetector(SingleArgConstructor.PROPERTIES);
    public static final ConstructorDetector USE_DELEGATING = new ConstructorDetector(SingleArgConstructor.DELEGATING);
    public static final ConstructorDetector EXPLICIT_ONLY = new ConstructorDetector(SingleArgConstructor.REQUIRE_MODE);

    /* loaded from: classes2.dex */
    public enum SingleArgConstructor {
        DELEGATING,
        PROPERTIES,
        HEURISTIC,
        REQUIRE_MODE
    }

    protected ConstructorDetector(SingleArgConstructor singleArgConstructor, boolean z, boolean z2) {
        this._singleArgMode = singleArgConstructor;
        this._requireCtorAnnotation = z;
        this._allowJDKTypeCtors = z2;
    }

    protected ConstructorDetector(SingleArgConstructor singleArgConstructor) {
        this(singleArgConstructor, false, false);
    }

    public ConstructorDetector withSingleArgMode(SingleArgConstructor singleArgConstructor) {
        return new ConstructorDetector(singleArgConstructor, this._requireCtorAnnotation, this._allowJDKTypeCtors);
    }

    public ConstructorDetector withRequireAnnotation(boolean z) {
        return new ConstructorDetector(this._singleArgMode, z, this._allowJDKTypeCtors);
    }

    public ConstructorDetector withAllowJDKTypeConstructors(boolean z) {
        return new ConstructorDetector(this._singleArgMode, this._requireCtorAnnotation, z);
    }

    public SingleArgConstructor singleArgMode() {
        return this._singleArgMode;
    }

    public boolean requireCtorAnnotation() {
        return this._requireCtorAnnotation;
    }

    public boolean allowJDKTypeConstructors() {
        return this._allowJDKTypeCtors;
    }

    public boolean singleArgCreatorDefaultsToDelegating() {
        return this._singleArgMode == SingleArgConstructor.DELEGATING;
    }

    public boolean singleArgCreatorDefaultsToProperties() {
        return this._singleArgMode == SingleArgConstructor.PROPERTIES;
    }

    public boolean shouldIntrospectorImplicitConstructors(Class<?> cls) {
        if (this._requireCtorAnnotation) {
            return false;
        }
        return this._allowJDKTypeCtors || !ClassUtil.isJDKClass(cls) || Throwable.class.isAssignableFrom(cls);
    }
}
