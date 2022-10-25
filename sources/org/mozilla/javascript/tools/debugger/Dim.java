package org.mozilla.javascript.tools.debugger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.mozilla.javascript.Callable;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextAction;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.ImporterTopLevel;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.NativeCall;
import org.mozilla.javascript.ObjArray;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.SecurityUtilities;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.debug.DebugFrame;
import org.mozilla.javascript.debug.DebuggableObject;
import org.mozilla.javascript.debug.DebuggableScript;
import org.mozilla.javascript.debug.Debugger;

/* loaded from: classes5.dex */
public class Dim {
    public static final int BREAK = 4;
    public static final int EXIT = 5;

    /* renamed from: GO */
    public static final int f10782GO = 3;
    private static final int IPROXY_COMPILE_SCRIPT = 2;
    private static final int IPROXY_DEBUG = 0;
    private static final int IPROXY_EVAL_SCRIPT = 3;
    private static final int IPROXY_LISTEN = 1;
    private static final int IPROXY_OBJECT_IDS = 7;
    private static final int IPROXY_OBJECT_PROPERTY = 6;
    private static final int IPROXY_OBJECT_TO_STRING = 5;
    private static final int IPROXY_STRING_IS_COMPILABLE = 4;
    public static final int STEP_INTO = 1;
    public static final int STEP_OUT = 2;
    public static final int STEP_OVER = 0;
    private boolean breakFlag;
    private boolean breakOnEnter;
    private boolean breakOnExceptions;
    private boolean breakOnReturn;
    private GuiCallback callback;
    private ContextFactory contextFactory;
    private StackFrame evalFrame;
    private String evalRequest;
    private String evalResult;
    private boolean insideInterruptLoop;
    private volatile ContextData interruptedContextData;
    private DimIProxy listener;
    private ScopeProvider scopeProvider;
    private SourceProvider sourceProvider;
    private int frameIndex = -1;
    private Object monitor = new Object();
    private Object eventThreadMonitor = new Object();
    private volatile int returnValue = -1;
    private final Map<String, SourceInfo> urlToSourceInfo = Collections.synchronizedMap(new HashMap());
    private final Map<String, FunctionSource> functionNames = Collections.synchronizedMap(new HashMap());
    private final Map<DebuggableScript, FunctionSource> functionToSource = Collections.synchronizedMap(new HashMap());

    public void setGuiCallback(GuiCallback guiCallback) {
        this.callback = guiCallback;
    }

    public void setBreak() {
        this.breakFlag = true;
    }

    public void setScopeProvider(ScopeProvider scopeProvider) {
        this.scopeProvider = scopeProvider;
    }

    public void setSourceProvider(SourceProvider sourceProvider) {
        this.sourceProvider = sourceProvider;
    }

    public void contextSwitch(int i) {
        this.frameIndex = i;
    }

    public void setBreakOnExceptions(boolean z) {
        this.breakOnExceptions = z;
    }

    public void setBreakOnEnter(boolean z) {
        this.breakOnEnter = z;
    }

    public void setBreakOnReturn(boolean z) {
        this.breakOnReturn = z;
    }

    public void attachTo(ContextFactory contextFactory) {
        detach();
        this.contextFactory = contextFactory;
        DimIProxy dimIProxy = new DimIProxy(1);
        this.listener = dimIProxy;
        contextFactory.addListener(dimIProxy);
    }

    public void detach() {
        DimIProxy dimIProxy = this.listener;
        if (dimIProxy != null) {
            this.contextFactory.removeListener(dimIProxy);
            this.contextFactory = null;
            this.listener = null;
        }
    }

    public void dispose() {
        detach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FunctionSource getFunctionSource(DebuggableScript debuggableScript) {
        String loadSource;
        FunctionSource functionSource = functionSource(debuggableScript);
        if (functionSource != null) {
            return functionSource;
        }
        String normalizedUrl = getNormalizedUrl(debuggableScript);
        if (sourceInfo(normalizedUrl) != null || debuggableScript.isGeneratedScript() || (loadSource = loadSource(normalizedUrl)) == null) {
            return functionSource;
        }
        DebuggableScript debuggableScript2 = debuggableScript;
        while (true) {
            DebuggableScript parent = debuggableScript2.getParent();
            if (parent == null) {
                registerTopScript(debuggableScript2, loadSource);
                return functionSource(debuggableScript);
            }
            debuggableScript2 = parent;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005b -> B:26:0x0098). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0075 -> B:26:0x0098). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0087 -> B:26:0x0098). Please submit an issue!!! */
    private String loadSource(String str) {
        InputStream fileInputStream;
        String systemProperty;
        int indexOf = str.indexOf(35);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        String str2 = null;
        try {
        } catch (IOException e) {
            System.err.println("Failed to load source from " + str + ": " + e);
        }
        if (str.indexOf(58) < 0) {
            if (str.startsWith("~/") && (systemProperty = SecurityUtilities.getSystemProperty("user.home")) != null) {
                File file = new File(new File(systemProperty), str.substring(2));
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    str2 = Kit.readReader(new InputStreamReader(fileInputStream));
                    fileInputStream.close();
                    return str2;
                }
            }
            File file2 = new File(str);
            if (file2.exists()) {
                fileInputStream = new FileInputStream(file2);
                str2 = Kit.readReader(new InputStreamReader(fileInputStream));
                fileInputStream.close();
                return str2;
            }
            if (str.startsWith("//")) {
                str = "http:" + str;
            } else if (str.startsWith("/")) {
                str = "http://127.0.0.1" + str;
            } else {
                str = "http://" + str;
            }
        }
        fileInputStream = new URL(str).openStream();
        str2 = Kit.readReader(new InputStreamReader(fileInputStream));
        fileInputStream.close();
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerTopScript(DebuggableScript debuggableScript, String str) {
        int i;
        String source;
        if (!debuggableScript.isTopLevel()) {
            throw new IllegalArgumentException();
        }
        String normalizedUrl = getNormalizedUrl(debuggableScript);
        DebuggableScript[] allFunctions = getAllFunctions(debuggableScript);
        SourceProvider sourceProvider = this.sourceProvider;
        if (sourceProvider != null && (source = sourceProvider.getSource(debuggableScript)) != null) {
            str = source;
        }
        SourceInfo sourceInfo = new SourceInfo(str, allFunctions, normalizedUrl);
        synchronized (this.urlToSourceInfo) {
            SourceInfo sourceInfo2 = this.urlToSourceInfo.get(normalizedUrl);
            if (sourceInfo2 != null) {
                sourceInfo.copyBreakpointsFrom(sourceInfo2);
            }
            this.urlToSourceInfo.put(normalizedUrl, sourceInfo);
            for (int i2 = 0; i2 != sourceInfo.functionSourcesTop(); i2++) {
                FunctionSource functionSource = sourceInfo.functionSource(i2);
                String name = functionSource.name();
                if (name.length() != 0) {
                    this.functionNames.put(name, functionSource);
                }
            }
        }
        synchronized (this.functionToSource) {
            for (i = 0; i != allFunctions.length; i++) {
                this.functionToSource.put(allFunctions[i], sourceInfo.functionSource(i));
            }
        }
        this.callback.updateSourceText(sourceInfo);
    }

    private FunctionSource functionSource(DebuggableScript debuggableScript) {
        return this.functionToSource.get(debuggableScript);
    }

    public String[] functionNames() {
        String[] strArr;
        synchronized (this.urlToSourceInfo) {
            strArr = (String[]) this.functionNames.keySet().toArray(new String[this.functionNames.size()]);
        }
        return strArr;
    }

    public FunctionSource functionSourceByName(String str) {
        return this.functionNames.get(str);
    }

    public SourceInfo sourceInfo(String str) {
        return this.urlToSourceInfo.get(str);
    }

    private String getNormalizedUrl(DebuggableScript debuggableScript) {
        String sourceName = debuggableScript.getSourceName();
        if (sourceName == null) {
            return "<stdin>";
        }
        int length = sourceName.length();
        StringBuffer stringBuffer = null;
        int i = 0;
        while (true) {
            int indexOf = sourceName.indexOf(35, i);
            if (indexOf < 0) {
                break;
            }
            int i2 = indexOf + 1;
            int i3 = i2;
            while (i3 != length) {
                char charAt = sourceName.charAt(i3);
                if ('0' > charAt || charAt > '9') {
                    break;
                }
                i3++;
            }
            String str = "(eval)";
            if (i3 == i2 || !"(eval)".regionMatches(0, sourceName, i3, 6)) {
                str = null;
            } else {
                i = i3 + 6;
            }
            if (str == null) {
                break;
            }
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
                stringBuffer.append(sourceName.substring(0, indexOf));
            }
            stringBuffer.append(str);
        }
        if (stringBuffer != null) {
            if (i != length) {
                stringBuffer.append(sourceName.substring(i));
            }
            return stringBuffer.toString();
        }
        return sourceName;
    }

    private static DebuggableScript[] getAllFunctions(DebuggableScript debuggableScript) {
        ObjArray objArray = new ObjArray();
        collectFunctions_r(debuggableScript, objArray);
        DebuggableScript[] debuggableScriptArr = new DebuggableScript[objArray.size()];
        objArray.toArray(debuggableScriptArr);
        return debuggableScriptArr;
    }

    private static void collectFunctions_r(DebuggableScript debuggableScript, ObjArray objArray) {
        objArray.add(debuggableScript);
        for (int i = 0; i != debuggableScript.getFunctionCount(); i++) {
            collectFunctions_r(debuggableScript.getFunction(i), objArray);
        }
    }

    public void clearAllBreakpoints() {
        for (SourceInfo sourceInfo : this.urlToSourceInfo.values()) {
            sourceInfo.removeAllBreakpoints();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBreakpointHit(StackFrame stackFrame, Context context) {
        this.breakFlag = false;
        interrupted(context, stackFrame, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleExceptionThrown(Context context, Throwable th, StackFrame stackFrame) {
        if (this.breakOnExceptions) {
            ContextData contextData = stackFrame.contextData();
            if (contextData.lastProcessedException != th) {
                interrupted(context, stackFrame, th);
                contextData.lastProcessedException = th;
            }
        }
    }

    public ContextData currentContextData() {
        return this.interruptedContextData;
    }

    public void setReturnValue(int i) {
        synchronized (this.monitor) {
            this.returnValue = i;
            this.monitor.notify();
        }
    }

    /* renamed from: go */
    public void m46go() {
        synchronized (this.monitor) {
            this.returnValue = 3;
            this.monitor.notifyAll();
        }
    }

    public String eval(String str) {
        ContextData currentContextData;
        String str2 = "undefined";
        if (str == null || (currentContextData = currentContextData()) == null || this.frameIndex >= currentContextData.frameCount()) {
            return "undefined";
        }
        StackFrame frame = currentContextData.getFrame(this.frameIndex);
        if (currentContextData.eventThreadFlag) {
            return do_eval(Context.getCurrentContext(), frame, str);
        }
        synchronized (this.monitor) {
            if (this.insideInterruptLoop) {
                this.evalRequest = str;
                this.evalFrame = frame;
                this.monitor.notify();
                do {
                    try {
                        this.monitor.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                } while (this.evalRequest != null);
                str2 = this.evalResult;
            }
        }
        return str2;
    }

    public void compileScript(String str, String str2) {
        DimIProxy dimIProxy = new DimIProxy(2);
        dimIProxy.url = str;
        dimIProxy.text = str2;
        dimIProxy.withContext();
    }

    public void evalScript(String str, String str2) {
        DimIProxy dimIProxy = new DimIProxy(3);
        dimIProxy.url = str;
        dimIProxy.text = str2;
        dimIProxy.withContext();
    }

    public String objectToString(Object obj) {
        DimIProxy dimIProxy = new DimIProxy(5);
        dimIProxy.object = obj;
        dimIProxy.withContext();
        return dimIProxy.stringResult;
    }

    public boolean stringIsCompilableUnit(String str) {
        DimIProxy dimIProxy = new DimIProxy(4);
        dimIProxy.text = str;
        dimIProxy.withContext();
        return dimIProxy.booleanResult;
    }

    public Object getObjectProperty(Object obj, Object obj2) {
        DimIProxy dimIProxy = new DimIProxy(6);
        dimIProxy.object = obj;
        dimIProxy.f10783id = obj2;
        dimIProxy.withContext();
        return dimIProxy.objectResult;
    }

    public Object[] getObjectIds(Object obj) {
        DimIProxy dimIProxy = new DimIProxy(7);
        dimIProxy.object = obj;
        dimIProxy.withContext();
        return dimIProxy.objectArrayResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object getObjectPropertyImpl(Context context, Object obj, Object obj2) {
        Scriptable scriptable = (Scriptable) obj;
        if (obj2 instanceof String) {
            String str = (String) obj2;
            if (str.equals("this")) {
                return scriptable;
            }
            if (str.equals("__proto__")) {
                return scriptable.getPrototype();
            }
            if (str.equals("__parent__")) {
                return scriptable.getParentScope();
            }
            Object property = ScriptableObject.getProperty(scriptable, str);
            return property == ScriptableObject.NOT_FOUND ? Undefined.instance : property;
        }
        Object property2 = ScriptableObject.getProperty(scriptable, ((Integer) obj2).intValue());
        return property2 == ScriptableObject.NOT_FOUND ? Undefined.instance : property2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] getObjectIdsImpl(Context context, Object obj) {
        Object[] ids;
        if (!(obj instanceof Scriptable) || obj == Undefined.instance) {
            return Context.emptyArgs;
        }
        Scriptable scriptable = (Scriptable) obj;
        if (scriptable instanceof DebuggableObject) {
            ids = ((DebuggableObject) scriptable).getAllIds();
        } else {
            ids = scriptable.getIds();
        }
        Scriptable prototype = scriptable.getPrototype();
        Scriptable parentScope = scriptable.getParentScope();
        char c = 1;
        int i = prototype != null ? 1 : 0;
        if (parentScope != null) {
            i++;
        }
        if (i != 0) {
            Object[] objArr = new Object[ids.length + i];
            System.arraycopy(ids, 0, objArr, i, ids.length);
            if (prototype != null) {
                objArr[0] = "__proto__";
            } else {
                c = 0;
            }
            if (parentScope != null) {
                objArr[c] = "__parent__";
            }
            return objArr;
        }
        return ids;
    }

    private void interrupted(Context context, StackFrame stackFrame, Throwable th) {
        boolean z;
        int i;
        ContextData contextData = stackFrame.contextData();
        boolean isGuiEventThread = this.callback.isGuiEventThread();
        contextData.eventThreadFlag = isGuiEventThread;
        synchronized (this.eventThreadMonitor) {
            if (isGuiEventThread) {
                z = this.interruptedContextData != null;
            } else {
                while (this.interruptedContextData != null) {
                    try {
                        this.eventThreadMonitor.wait();
                    } catch (InterruptedException unused) {
                        return;
                    }
                }
            }
            this.interruptedContextData = contextData;
        }
        if (z) {
            return;
        }
        if (this.interruptedContextData == null) {
            Kit.codeBug();
        }
        try {
            this.frameIndex = contextData.frameCount() - 1;
            String thread = Thread.currentThread().toString();
            String th2 = th == null ? null : th.toString();
            if (!isGuiEventThread) {
                synchronized (this.monitor) {
                    if (this.insideInterruptLoop) {
                        Kit.codeBug();
                    }
                    this.insideInterruptLoop = true;
                    this.evalRequest = null;
                    this.returnValue = -1;
                    this.callback.enterInterrupt(stackFrame, thread, th2);
                    while (true) {
                        try {
                            this.monitor.wait();
                            String str = this.evalRequest;
                            if (str != null) {
                                this.evalResult = null;
                                this.evalResult = do_eval(context, this.evalFrame, str);
                                this.evalRequest = null;
                                this.evalFrame = null;
                                this.monitor.notify();
                            } else if (this.returnValue != -1) {
                                break;
                            }
                        } catch (InterruptedException unused2) {
                            Thread.currentThread().interrupt();
                            i = -1;
                        }
                    }
                    i = this.returnValue;
                    this.insideInterruptLoop = false;
                }
            } else {
                this.returnValue = -1;
                this.callback.enterInterrupt(stackFrame, thread, th2);
                while (this.returnValue == -1) {
                    try {
                        this.callback.dispatchNextGuiEvent();
                    } catch (InterruptedException unused3) {
                    }
                }
                i = this.returnValue;
            }
            if (i == 0) {
                contextData.breakNextLine = true;
                contextData.stopAtFrameDepth = contextData.frameCount();
            } else if (i != 1) {
                if (i == 2 && contextData.frameCount() > 1) {
                    contextData.breakNextLine = true;
                    contextData.stopAtFrameDepth = contextData.frameCount() - 1;
                }
            } else {
                contextData.breakNextLine = true;
                contextData.stopAtFrameDepth = -1;
            }
            synchronized (this.eventThreadMonitor) {
                this.interruptedContextData = null;
                this.eventThreadMonitor.notifyAll();
            }
        } catch (Throwable th3) {
            synchronized (this.eventThreadMonitor) {
                this.interruptedContextData = null;
                this.eventThreadMonitor.notifyAll();
                throw th3;
            }
        }
    }

    private static String do_eval(Context context, StackFrame stackFrame, String str) {
        String str2 = "";
        Debugger debugger = context.getDebugger();
        Object debuggerContextData = context.getDebuggerContextData();
        int optimizationLevel = context.getOptimizationLevel();
        context.setDebugger(null, null);
        context.setOptimizationLevel(-1);
        context.setGeneratingDebug(false);
        try {
            try {
                Object call = ((Callable) context.compileString(str, "", 0, null)).call(context, stackFrame.scope, stackFrame.thisObj, ScriptRuntime.emptyArgs);
                if (call != Undefined.instance) {
                    str2 = ScriptRuntime.toString(call);
                }
            } catch (Exception e) {
                str2 = e.getMessage();
            }
            return str2 == null ? "null" : str2;
        } finally {
            context.setGeneratingDebug(true);
            context.setOptimizationLevel(optimizationLevel);
            context.setDebugger(debugger, debuggerContextData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class DimIProxy implements ContextAction, ContextFactory.Listener, Debugger {
        private boolean booleanResult;
        private Dim dim;

        /* renamed from: id */
        private Object f10783id;
        private Object object;
        private Object[] objectArrayResult;
        private Object objectResult;
        private String stringResult;
        private String text;
        private int type;
        private String url;

        private DimIProxy(Dim dim, int i) {
            this.dim = dim;
            this.type = i;
        }

        @Override // org.mozilla.javascript.ContextAction
        public Object run(Context context) {
            switch (this.type) {
                case 2:
                    context.compileString(this.text, this.url, 1, null);
                    break;
                case 3:
                    Scriptable scope = this.dim.scopeProvider != null ? this.dim.scopeProvider.getScope() : null;
                    if (scope == null) {
                        scope = new ImporterTopLevel(context);
                    }
                    context.evaluateString(scope, this.text, this.url, 1, null);
                    break;
                case 4:
                    this.booleanResult = context.stringIsCompilableUnit(this.text);
                    break;
                case 5:
                    if (this.object == Undefined.instance) {
                        this.stringResult = "undefined";
                        break;
                    } else {
                        Object obj = this.object;
                        if (obj == null) {
                            this.stringResult = "null";
                            break;
                        } else if (obj instanceof NativeCall) {
                            this.stringResult = "[object Call]";
                            break;
                        } else {
                            this.stringResult = Context.toString(obj);
                            break;
                        }
                    }
                case 6:
                    this.objectResult = this.dim.getObjectPropertyImpl(context, this.object, this.f10783id);
                    break;
                case 7:
                    this.objectArrayResult = this.dim.getObjectIdsImpl(context, this.object);
                    break;
                default:
                    throw Kit.codeBug();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void withContext() {
            this.dim.contextFactory.call(this);
        }

        @Override // org.mozilla.javascript.ContextFactory.Listener
        public void contextCreated(Context context) {
            if (this.type != 1) {
                Kit.codeBug();
            }
            context.setDebugger(new DimIProxy(this.dim, 0), new ContextData());
            context.setGeneratingDebug(true);
            context.setOptimizationLevel(-1);
        }

        @Override // org.mozilla.javascript.ContextFactory.Listener
        public void contextReleased(Context context) {
            if (this.type != 1) {
                Kit.codeBug();
            }
        }

        @Override // org.mozilla.javascript.debug.Debugger
        public DebugFrame getFrame(Context context, DebuggableScript debuggableScript) {
            if (this.type != 0) {
                Kit.codeBug();
            }
            FunctionSource functionSource = this.dim.getFunctionSource(debuggableScript);
            if (functionSource == null) {
                return null;
            }
            return new StackFrame(context, this.dim, functionSource);
        }

        @Override // org.mozilla.javascript.debug.Debugger
        public void handleCompilationDone(Context context, DebuggableScript debuggableScript, String str) {
            if (this.type != 0) {
                Kit.codeBug();
            }
            if (debuggableScript.isTopLevel()) {
                this.dim.registerTopScript(debuggableScript, str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class ContextData {
        private boolean breakNextLine;
        private boolean eventThreadFlag;
        private Throwable lastProcessedException;
        private ObjArray frameStack = new ObjArray();
        private int stopAtFrameDepth = -1;

        public static ContextData get(Context context) {
            return (ContextData) context.getDebuggerContextData();
        }

        public int frameCount() {
            return this.frameStack.size();
        }

        public StackFrame getFrame(int i) {
            return (StackFrame) this.frameStack.get((this.frameStack.size() - i) - 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pushFrame(StackFrame stackFrame) {
            this.frameStack.push(stackFrame);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void popFrame() {
            this.frameStack.pop();
        }
    }

    /* loaded from: classes5.dex */
    public static class StackFrame implements DebugFrame {
        private boolean[] breakpoints;
        private ContextData contextData;
        private Dim dim;
        private FunctionSource fsource;
        private int lineNumber;
        private Scriptable scope;
        private Scriptable thisObj;

        private StackFrame(Context context, Dim dim, FunctionSource functionSource) {
            this.dim = dim;
            this.contextData = ContextData.get(context);
            this.fsource = functionSource;
            this.breakpoints = functionSource.sourceInfo().breakpoints;
            this.lineNumber = functionSource.firstLine();
        }

        @Override // org.mozilla.javascript.debug.DebugFrame
        public void onEnter(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
            this.contextData.pushFrame(this);
            this.scope = scriptable;
            this.thisObj = scriptable2;
            if (this.dim.breakOnEnter) {
                this.dim.handleBreakpointHit(this, context);
            }
        }

        @Override // org.mozilla.javascript.debug.DebugFrame
        public void onLineChange(Context context, int i) {
            this.lineNumber = i;
            if (!this.breakpoints[i] && !this.dim.breakFlag) {
                boolean z = this.contextData.breakNextLine;
                if (z && this.contextData.stopAtFrameDepth >= 0) {
                    z = this.contextData.frameCount() <= this.contextData.stopAtFrameDepth;
                }
                if (!z) {
                    return;
                }
                this.contextData.stopAtFrameDepth = -1;
                this.contextData.breakNextLine = false;
            }
            this.dim.handleBreakpointHit(this, context);
        }

        @Override // org.mozilla.javascript.debug.DebugFrame
        public void onExceptionThrown(Context context, Throwable th) {
            this.dim.handleExceptionThrown(context, th, this);
        }

        @Override // org.mozilla.javascript.debug.DebugFrame
        public void onExit(Context context, boolean z, Object obj) {
            if (this.dim.breakOnReturn && !z) {
                this.dim.handleBreakpointHit(this, context);
            }
            this.contextData.popFrame();
        }

        @Override // org.mozilla.javascript.debug.DebugFrame
        public void onDebuggerStatement(Context context) {
            this.dim.handleBreakpointHit(this, context);
        }

        public SourceInfo sourceInfo() {
            return this.fsource.sourceInfo();
        }

        public ContextData contextData() {
            return this.contextData;
        }

        public Object scope() {
            return this.scope;
        }

        public Object thisObj() {
            return this.thisObj;
        }

        public String getUrl() {
            return this.fsource.sourceInfo().url();
        }

        public int getLineNumber() {
            return this.lineNumber;
        }

        public String getFunctionName() {
            return this.fsource.name();
        }
    }

    /* loaded from: classes5.dex */
    public static class FunctionSource {
        private int firstLine;
        private String name;
        private SourceInfo sourceInfo;

        private FunctionSource(SourceInfo sourceInfo, int i, String str) {
            if (str == null) {
                throw new IllegalArgumentException();
            }
            this.sourceInfo = sourceInfo;
            this.firstLine = i;
            this.name = str;
        }

        public SourceInfo sourceInfo() {
            return this.sourceInfo;
        }

        public int firstLine() {
            return this.firstLine;
        }

        public String name() {
            return this.name;
        }
    }

    /* loaded from: classes5.dex */
    public static class SourceInfo {
        private static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
        private boolean[] breakableLines;
        private boolean[] breakpoints;
        private FunctionSource[] functionSources;
        private String source;
        private String url;

        private SourceInfo(String str, DebuggableScript[] debuggableScriptArr, String str2) {
            this.source = str;
            this.url = str2;
            int length = debuggableScriptArr.length;
            int[][] iArr = new int[length];
            for (int i = 0; i != length; i++) {
                iArr[i] = debuggableScriptArr[i].getLineNumbers();
            }
            int[] iArr2 = new int[length];
            int i2 = 0;
            int i3 = 0;
            int i4 = -1;
            while (true) {
                if (i2 == length) {
                    break;
                }
                int[] iArr3 = iArr[i2];
                if (iArr3 == null || iArr3.length == 0) {
                    iArr2[i2] = -1;
                } else {
                    int i5 = iArr3[0];
                    int i6 = i5;
                    for (int i7 = 1; i7 != iArr3.length; i7++) {
                        int i8 = iArr3[i7];
                        if (i8 < i5) {
                            i5 = i8;
                        } else if (i8 > i6) {
                            i6 = i8;
                        }
                    }
                    iArr2[i2] = i5;
                    if (i3 > i4) {
                        i3 = i5;
                    } else {
                        i3 = i5 < i3 ? i5 : i3;
                        if (i6 <= i4) {
                        }
                    }
                    i4 = i6;
                }
                i2++;
            }
            if (i3 > i4) {
                boolean[] zArr = EMPTY_BOOLEAN_ARRAY;
                this.breakableLines = zArr;
                this.breakpoints = zArr;
            } else if (i3 < 0) {
                throw new IllegalStateException(String.valueOf(i3));
            } else {
                int i9 = i4 + 1;
                this.breakableLines = new boolean[i9];
                this.breakpoints = new boolean[i9];
                for (int i10 = 0; i10 != length; i10++) {
                    int[] iArr4 = iArr[i10];
                    if (iArr4 != null && iArr4.length != 0) {
                        for (int i11 = 0; i11 != iArr4.length; i11++) {
                            this.breakableLines[iArr4[i11]] = true;
                        }
                    }
                }
            }
            this.functionSources = new FunctionSource[length];
            for (int i12 = 0; i12 != length; i12++) {
                String functionName = debuggableScriptArr[i12].getFunctionName();
                if (functionName == null) {
                    functionName = "";
                }
                this.functionSources[i12] = new FunctionSource(this, iArr2[i12], functionName);
            }
        }

        public String source() {
            return this.source;
        }

        public String url() {
            return this.url;
        }

        public int functionSourcesTop() {
            return this.functionSources.length;
        }

        public FunctionSource functionSource(int i) {
            return this.functionSources[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void copyBreakpointsFrom(SourceInfo sourceInfo) {
            int length = sourceInfo.breakpoints.length;
            boolean[] zArr = this.breakpoints;
            if (length > zArr.length) {
                length = zArr.length;
            }
            for (int i = 0; i != length; i++) {
                if (sourceInfo.breakpoints[i]) {
                    this.breakpoints[i] = true;
                }
            }
        }

        public boolean breakableLine(int i) {
            boolean[] zArr = this.breakableLines;
            return i < zArr.length && zArr[i];
        }

        public boolean breakpoint(int i) {
            if (!breakableLine(i)) {
                throw new IllegalArgumentException(String.valueOf(i));
            }
            boolean[] zArr = this.breakpoints;
            return i < zArr.length && zArr[i];
        }

        public boolean breakpoint(int i, boolean z) {
            boolean z2;
            if (!breakableLine(i)) {
                throw new IllegalArgumentException(String.valueOf(i));
            }
            synchronized (this.breakpoints) {
                boolean[] zArr = this.breakpoints;
                if (zArr[i] != z) {
                    zArr[i] = z;
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            return z2;
        }

        public void removeAllBreakpoints() {
            synchronized (this.breakpoints) {
                int i = 0;
                while (true) {
                    boolean[] zArr = this.breakpoints;
                    if (i != zArr.length) {
                        zArr[i] = false;
                        i++;
                    }
                }
            }
        }
    }
}
