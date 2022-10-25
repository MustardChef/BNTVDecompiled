package com.fasterxml.jackson.databind.cfg;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class MutableCoercionConfig extends CoercionConfig implements Serializable {
    private static final long serialVersionUID = 1;

    public MutableCoercionConfig() {
    }

    protected MutableCoercionConfig(MutableCoercionConfig mutableCoercionConfig) {
        super(mutableCoercionConfig);
    }

    public MutableCoercionConfig copy() {
        return new MutableCoercionConfig(this);
    }

    public MutableCoercionConfig setCoercion(CoercionInputShape coercionInputShape, CoercionAction coercionAction) {
        this._coercionsByShape[coercionInputShape.ordinal()] = coercionAction;
        return this;
    }

    public MutableCoercionConfig setAcceptBlankAsEmpty(Boolean bool) {
        this._acceptBlankAsEmpty = bool;
        return this;
    }
}
