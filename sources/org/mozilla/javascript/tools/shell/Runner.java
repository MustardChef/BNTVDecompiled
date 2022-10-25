package org.mozilla.javascript.tools.shell;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextAction;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;

/* compiled from: Global.java */
/* loaded from: classes5.dex */
class Runner implements Runnable, ContextAction {
    private Object[] args;

    /* renamed from: f */
    private Function f10796f;
    ContextFactory factory;

    /* renamed from: s */
    private Script f10797s;
    private Scriptable scope;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Runner(Scriptable scriptable, Function function, Object[] objArr) {
        this.scope = scriptable;
        this.f10796f = function;
        this.args = objArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Runner(Scriptable scriptable, Script script) {
        this.scope = scriptable;
        this.f10797s = script;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.factory.call(this);
    }

    @Override // org.mozilla.javascript.ContextAction
    public Object run(Context context) {
        Function function = this.f10796f;
        if (function != null) {
            Scriptable scriptable = this.scope;
            return function.call(context, scriptable, scriptable, this.args);
        }
        return this.f10797s.exec(context, this.scope);
    }
}
