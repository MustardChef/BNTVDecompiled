package org.mozilla.javascript.commonjs.module.provider;

import java.net.URI;
import java.util.LinkedList;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.commonjs.module.ModuleScript;
import org.mozilla.javascript.commonjs.module.ModuleScriptProvider;

/* loaded from: classes5.dex */
public class MultiModuleScriptProvider implements ModuleScriptProvider {
    private final ModuleScriptProvider[] providers;

    public MultiModuleScriptProvider(Iterable<? extends ModuleScriptProvider> iterable) {
        LinkedList linkedList = new LinkedList();
        for (ModuleScriptProvider moduleScriptProvider : iterable) {
            linkedList.add(moduleScriptProvider);
        }
        this.providers = (ModuleScriptProvider[]) linkedList.toArray(new ModuleScriptProvider[linkedList.size()]);
    }

    @Override // org.mozilla.javascript.commonjs.module.ModuleScriptProvider
    public ModuleScript getModuleScript(Context context, String str, URI uri, URI uri2, Scriptable scriptable) throws Exception {
        for (ModuleScriptProvider moduleScriptProvider : this.providers) {
            ModuleScript moduleScript = moduleScriptProvider.getModuleScript(context, str, uri, uri2, scriptable);
            if (moduleScript != null) {
                return moduleScript;
            }
        }
        return null;
    }
}
