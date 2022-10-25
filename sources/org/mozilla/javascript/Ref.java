package org.mozilla.javascript;

import java.io.Serializable;

/* loaded from: classes5.dex */
public abstract class Ref implements Serializable {
    static final long serialVersionUID = 4044540354730911424L;

    public boolean delete(Context context) {
        return false;
    }

    public abstract Object get(Context context);

    public boolean has(Context context) {
        return true;
    }

    public abstract Object set(Context context, Object obj);
}
