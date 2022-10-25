package org.mozilla.javascript;

/* loaded from: classes5.dex */
public interface ConstProperties {
    void defineConst(String str, Scriptable scriptable);

    boolean isConst(String str);

    void putConst(String str, Scriptable scriptable, Object obj);
}
