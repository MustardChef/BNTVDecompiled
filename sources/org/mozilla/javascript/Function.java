package org.mozilla.javascript;

/* loaded from: classes5.dex */
public interface Function extends Scriptable, Callable {
    Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr);

    Scriptable construct(Context context, Scriptable scriptable, Object[] objArr);
}
