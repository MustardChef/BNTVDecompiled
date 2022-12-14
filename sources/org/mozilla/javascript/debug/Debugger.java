package org.mozilla.javascript.debug;

import org.mozilla.javascript.Context;

/* loaded from: classes5.dex */
public interface Debugger {
    DebugFrame getFrame(Context context, DebuggableScript debuggableScript);

    void handleCompilationDone(Context context, DebuggableScript debuggableScript, String str);
}
