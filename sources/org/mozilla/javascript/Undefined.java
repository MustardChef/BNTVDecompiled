package org.mozilla.javascript;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class Undefined implements Serializable {
    public static final Object instance = new Undefined();
    static final long serialVersionUID = 9195680630202616767L;

    private Undefined() {
    }

    public Object readResolve() {
        return instance;
    }
}
