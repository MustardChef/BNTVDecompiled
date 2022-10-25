package org.mozilla.javascript.commonjs.module;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.cast.MediaTrack;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.mozilla.javascript.BaseFunction;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

/* loaded from: classes5.dex */
public class Require extends BaseFunction {
    private static final ThreadLocal<Map<String, Scriptable>> loadingModuleInterfaces = new ThreadLocal<>();
    private static final long serialVersionUID = 1;
    private Scriptable mainExports;
    private final ModuleScriptProvider moduleScriptProvider;
    private final Scriptable nativeScope;
    private final Scriptable paths;
    private final Script postExec;
    private final Script preExec;
    private final boolean sandboxed;
    private String mainModuleId = null;
    private final Map<String, Scriptable> exportedModuleInterfaces = new ConcurrentHashMap();
    private final Object loadLock = new Object();

    @Override // org.mozilla.javascript.BaseFunction
    public int getArity() {
        return 1;
    }

    @Override // org.mozilla.javascript.BaseFunction
    public String getFunctionName() {
        return "require";
    }

    @Override // org.mozilla.javascript.BaseFunction
    public int getLength() {
        return 1;
    }

    public Require(Context context, Scriptable scriptable, ModuleScriptProvider moduleScriptProvider, Script script, Script script2, boolean z) {
        this.moduleScriptProvider = moduleScriptProvider;
        this.nativeScope = scriptable;
        this.sandboxed = z;
        this.preExec = script;
        this.postExec = script2;
        setPrototype(ScriptableObject.getFunctionPrototype(scriptable));
        if (!z) {
            Scriptable newArray = context.newArray(scriptable, 0);
            this.paths = newArray;
            defineReadOnlyProperty(this, "paths", newArray);
            return;
        }
        this.paths = null;
    }

    public Scriptable requireMain(Context context, String str) {
        String str2 = this.mainModuleId;
        if (str2 != null) {
            if (!str2.equals(str)) {
                throw new IllegalStateException("Main module already set to " + this.mainModuleId);
            }
            return this.mainExports;
        }
        try {
            if (this.moduleScriptProvider.getModuleScript(context, str, null, null, this.paths) != null) {
                this.mainExports = getExportedModuleInterface(context, str, null, null, true);
            } else if (!this.sandboxed) {
                URI uri = null;
                try {
                    uri = new URI(str);
                } catch (URISyntaxException unused) {
                }
                if (uri == null || !uri.isAbsolute()) {
                    File file = new File(str);
                    if (!file.isFile()) {
                        Scriptable scriptable = this.nativeScope;
                        throw ScriptRuntime.throwError(context, scriptable, "Module \"" + str + "\" not found.");
                    }
                    uri = file.toURI();
                }
                URI uri2 = uri;
                this.mainExports = getExportedModuleInterface(context, uri2.toString(), uri2, null, true);
            }
            this.mainModuleId = str;
            return this.mainExports;
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public void install(Scriptable scriptable) {
        ScriptableObject.putProperty(scriptable, "require", this);
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        URI uri;
        URI uri2;
        if (objArr == null || objArr.length < 1) {
            throw ScriptRuntime.throwError(context, scriptable, "require() needs one argument");
        }
        String str = (String) Context.jsToJava(objArr[0], String.class);
        if (!str.startsWith("./") && !str.startsWith("../")) {
            uri = null;
            uri2 = null;
        } else if (!(scriptable2 instanceof ModuleScope)) {
            throw ScriptRuntime.throwError(context, scriptable, "Can't resolve relative module ID \"" + str + "\" when require() is used outside of a module");
        } else {
            ModuleScope moduleScope = (ModuleScope) scriptable2;
            URI base = moduleScope.getBase();
            URI uri3 = moduleScope.getUri();
            URI resolve = uri3.resolve(str);
            if (base == null) {
                str = resolve.toString();
            } else {
                str = base.relativize(uri3).resolve(str).toString();
                if (str.charAt(0) == '.') {
                    if (this.sandboxed) {
                        throw ScriptRuntime.throwError(context, scriptable, "Module \"" + str + "\" is not contained in sandbox.");
                    }
                    str = resolve.toString();
                }
            }
            uri = resolve;
            uri2 = base;
        }
        return getExportedModuleInterface(context, str, uri, uri2, false);
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function
    public Scriptable construct(Context context, Scriptable scriptable, Object[] objArr) {
        throw ScriptRuntime.throwError(context, scriptable, "require() can not be invoked as a constructor");
    }

    private Scriptable getExportedModuleInterface(Context context, String str, URI uri, URI uri2, boolean z) {
        Scriptable scriptable;
        Scriptable scriptable2 = this.exportedModuleInterfaces.get(str);
        if (scriptable2 != null) {
            if (z) {
                throw new IllegalStateException("Attempt to set main module after it was loaded");
            }
            return scriptable2;
        }
        ThreadLocal<Map<String, Scriptable>> threadLocal = loadingModuleInterfaces;
        Map<String, Scriptable> map = threadLocal.get();
        if (map == null || (scriptable = map.get(str)) == null) {
            synchronized (this.loadLock) {
                Scriptable scriptable3 = this.exportedModuleInterfaces.get(str);
                if (scriptable3 != null) {
                    return scriptable3;
                }
                ModuleScript module = getModule(context, str, uri, uri2);
                if (this.sandboxed && !module.isSandboxed()) {
                    Scriptable scriptable4 = this.nativeScope;
                    throw ScriptRuntime.throwError(context, scriptable4, "Module \"" + str + "\" is not contained in sandbox.");
                }
                Scriptable newObject = context.newObject(this.nativeScope);
                boolean z2 = map == null;
                if (z2) {
                    map = new HashMap<>();
                    threadLocal.set(map);
                }
                map.put(str, newObject);
                try {
                    Scriptable executeModuleScript = executeModuleScript(context, str, newObject, module, z);
                    if (newObject != executeModuleScript) {
                        map.put(str, executeModuleScript);
                        newObject = executeModuleScript;
                    }
                    if (z2) {
                        this.exportedModuleInterfaces.putAll(map);
                        threadLocal.set(null);
                    }
                    return newObject;
                } catch (RuntimeException e) {
                    map.remove(str);
                    throw e;
                }
            }
        }
        return scriptable;
    }

    private Scriptable executeModuleScript(Context context, String str, Scriptable scriptable, ModuleScript moduleScript, boolean z) {
        ScriptableObject scriptableObject = (ScriptableObject) context.newObject(this.nativeScope);
        URI uri = moduleScript.getUri();
        URI base = moduleScript.getBase();
        defineReadOnlyProperty(scriptableObject, "id", str);
        if (!this.sandboxed) {
            defineReadOnlyProperty(scriptableObject, ShareConstants.MEDIA_URI, uri.toString());
        }
        Scriptable moduleScope = new ModuleScope(this.nativeScope, uri, base);
        moduleScope.put("exports", moduleScope, scriptable);
        moduleScope.put("module", moduleScope, scriptableObject);
        scriptableObject.put("exports", scriptableObject, scriptable);
        install(moduleScope);
        if (z) {
            defineReadOnlyProperty(this, MediaTrack.ROLE_MAIN, scriptableObject);
        }
        executeOptionalScript(this.preExec, context, moduleScope);
        moduleScript.getScript().exec(context, moduleScope);
        executeOptionalScript(this.postExec, context, moduleScope);
        return ScriptRuntime.toObject(this.nativeScope, ScriptableObject.getProperty(scriptableObject, "exports"));
    }

    private static void executeOptionalScript(Script script, Context context, Scriptable scriptable) {
        if (script != null) {
            script.exec(context, scriptable);
        }
    }

    private static void defineReadOnlyProperty(ScriptableObject scriptableObject, String str, Object obj) {
        ScriptableObject.putProperty(scriptableObject, str, obj);
        scriptableObject.setAttributes(str, 5);
    }

    private ModuleScript getModule(Context context, String str, URI uri, URI uri2) {
        try {
            ModuleScript moduleScript = this.moduleScriptProvider.getModuleScript(context, str, uri, uri2, this.paths);
            if (moduleScript != null) {
                return moduleScript;
            }
            Scriptable scriptable = this.nativeScope;
            throw ScriptRuntime.throwError(context, scriptable, "Module \"" + str + "\" not found.");
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw Context.throwAsScriptRuntimeEx(e2);
        }
    }
}
