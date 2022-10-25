package org.mozilla.javascript.debug;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

/* loaded from: classes5.dex */
public interface DebugFrame {
    void onDebuggerStatement(Context context);

    void onEnter(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr);

    void onExceptionThrown(Context context, Throwable th);

    void onExit(Context context, boolean z, Object obj);

    void onLineChange(Context context, int i);
}
