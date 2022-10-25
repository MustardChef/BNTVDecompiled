package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.JacksonFeature;

/* loaded from: classes2.dex */
public final class JacksonFeatureSet<F extends JacksonFeature> {
    protected int _enabled;

    protected JacksonFeatureSet(int i) {
        this._enabled = i;
    }

    public static <F extends JacksonFeature> JacksonFeatureSet<F> fromDefaults(F[] fArr) {
        if (fArr.length > 31) {
            throw new IllegalArgumentException(String.format("Can not use type `%s` with JacksonFeatureSet: too many entries (%d > 31)", fArr[0].getClass().getName(), Integer.valueOf(fArr.length)));
        }
        int i = 0;
        for (F f : fArr) {
            if (f.enabledByDefault()) {
                i |= f.getMask();
            }
        }
        return new JacksonFeatureSet<>(i);
    }

    public static <F extends JacksonFeature> JacksonFeatureSet<F> fromBitmask(int i) {
        return new JacksonFeatureSet<>(i);
    }

    public JacksonFeatureSet<F> with(F f) {
        int mask = f.getMask() | this._enabled;
        return mask == this._enabled ? this : new JacksonFeatureSet<>(mask);
    }

    public JacksonFeatureSet<F> without(F f) {
        int i = (~f.getMask()) & this._enabled;
        return i == this._enabled ? this : new JacksonFeatureSet<>(i);
    }

    public boolean isEnabled(F f) {
        return (f.getMask() & this._enabled) != 0;
    }

    public int asBitmask() {
        return this._enabled;
    }
}
