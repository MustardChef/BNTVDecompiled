package org.mozilla.javascript;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.mozilla.javascript.TopLevel;
import org.mozilla.javascript.ast.AstRoot;
import org.mozilla.javascript.ast.ScriptNode;
import org.mozilla.javascript.debug.DebuggableScript;
import org.mozilla.javascript.debug.Debugger;
import org.mozilla.javascript.xml.XMLLib;

/* loaded from: classes5.dex */
public class Context {
    public static final int FEATURE_DYNAMIC_SCOPE = 7;
    public static final int FEATURE_E4X = 6;
    public static final int FEATURE_ENHANCED_JAVA_ACCESS = 13;
    public static final int FEATURE_LOCATION_INFORMATION_IN_ERROR = 10;
    public static final int FEATURE_MEMBER_EXPR_AS_FUNCTION_NAME = 2;
    public static final int FEATURE_NON_ECMA_GET_YEAR = 1;
    public static final int FEATURE_PARENT_PROTO_PROPERTIES = 5;
    public static final int FEATURE_PARENT_PROTO_PROPRTIES = 5;
    public static final int FEATURE_RESERVED_KEYWORD_AS_IDENTIFIER = 3;
    public static final int FEATURE_STRICT_EVAL = 9;
    public static final int FEATURE_STRICT_MODE = 11;
    public static final int FEATURE_STRICT_VARS = 8;
    public static final int FEATURE_TO_STRING_AS_SOURCE = 4;
    public static final int FEATURE_WARNING_AS_ERROR = 12;
    public static final int VERSION_1_0 = 100;
    public static final int VERSION_1_1 = 110;
    public static final int VERSION_1_2 = 120;
    public static final int VERSION_1_3 = 130;
    public static final int VERSION_1_4 = 140;
    public static final int VERSION_1_5 = 150;
    public static final int VERSION_1_6 = 160;
    public static final int VERSION_1_7 = 170;
    public static final int VERSION_1_8 = 180;
    public static final int VERSION_DEFAULT = 0;
    public static final int VERSION_UNKNOWN = -1;
    public static final String errorReporterProperty = "error reporter";
    private static String implementationVersion = null;
    public static final String languageVersionProperty = "language version";
    Set<String> activationNames;
    private ClassLoader applicationClassLoader;
    XMLLib cachedXMLLib;
    private ClassShutter classShutter;
    NativeCall currentActivationCall;
    Debugger debugger;
    private Object debuggerData;
    private int enterCount;
    private ErrorReporter errorReporter;
    private final ContextFactory factory;
    public boolean generateObserverCount;
    private boolean generatingDebug;
    private boolean generatingDebugChanged;
    private boolean generatingSource;
    private boolean hasClassShutter;
    int instructionCount;
    int instructionThreshold;
    Object interpreterSecurityDomain;
    boolean isContinuationsTopCall;
    ObjToIntMap iterating;
    Object lastInterpreterFrame;
    private Locale locale;
    private int maximumInterpreterStackDepth;
    private int optimizationLevel;
    ObjArray previousInterpreterInvocations;
    private Object propertyListeners;
    RegExpProxy regExpProxy;
    int scratchIndex;
    Scriptable scratchScriptable;
    long scratchUint32;
    private Object sealKey;
    private boolean sealed;
    private SecurityController securityController;
    private Map<Object, Object> threadLocalMap;
    Scriptable topCallScope;
    boolean useDynamicScope;
    int version;
    private WrapFactory wrapFactory;
    public static final Object[] emptyArgs = ScriptRuntime.emptyArgs;
    private static Class<?> codegenClass = Kit.classOrNull("org.mozilla.javascript.optimizer.Codegen");
    private static Class<?> interpreterClass = Kit.classOrNull("org.mozilla.javascript.Interpreter");

    /* loaded from: classes5.dex */
    public interface ClassShutterSetter {
        ClassShutter getClassShutter();

        void setClassShutter(ClassShutter classShutter);
    }

    public static boolean isValidLanguageVersion(int i) {
        return i == 0 || i == 100 || i == 110 || i == 120 || i == 130 || i == 140 || i == 150 || i == 160 || i == 170 || i == 180;
    }

    public static boolean isValidOptimizationLevel(int i) {
        return -1 <= i && i <= 9;
    }

    public static void setCachingEnabled(boolean z) {
    }

    public Context() {
        this(ContextFactory.getGlobal());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context(ContextFactory contextFactory) {
        this.generatingSource = true;
        this.generateObserverCount = false;
        if (contextFactory == null) {
            throw new IllegalArgumentException("factory == null");
        }
        this.factory = contextFactory;
        this.version = 0;
        this.optimizationLevel = codegenClass == null ? -1 : 0;
        this.maximumInterpreterStackDepth = Integer.MAX_VALUE;
    }

    public static Context getCurrentContext() {
        return VMBridge.instance.getContext(VMBridge.instance.getThreadContextHelper());
    }

    public static Context enter() {
        return enter(null);
    }

    public static Context enter(Context context) {
        return enter(context, ContextFactory.getGlobal());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Context enter(Context context, ContextFactory contextFactory) {
        Object threadContextHelper = VMBridge.instance.getThreadContextHelper();
        Context context2 = VMBridge.instance.getContext(threadContextHelper);
        if (context2 == null) {
            if (context == null) {
                context = contextFactory.makeContext();
                if (context.enterCount != 0) {
                    throw new IllegalStateException("factory.makeContext() returned Context instance already associated with some thread");
                }
                contextFactory.onContextCreated(context);
                if (contextFactory.isSealed() && !context.isSealed()) {
                    context.seal(null);
                }
            } else if (context.enterCount != 0) {
                throw new IllegalStateException("can not use Context instance already associated with some thread");
            }
            VMBridge.instance.setContext(threadContextHelper, context);
            context2 = context;
        }
        context2.enterCount++;
        return context2;
    }

    public static void exit() {
        Object threadContextHelper = VMBridge.instance.getThreadContextHelper();
        Context context = VMBridge.instance.getContext(threadContextHelper);
        if (context == null) {
            throw new IllegalStateException("Calling Context.exit without previous Context.enter");
        }
        if (context.enterCount < 1) {
            Kit.codeBug();
        }
        int i = context.enterCount - 1;
        context.enterCount = i;
        if (i == 0) {
            VMBridge.instance.setContext(threadContextHelper, null);
            context.factory.onContextReleased(context);
        }
    }

    public static Object call(ContextAction contextAction) {
        return call(ContextFactory.getGlobal(), contextAction);
    }

    public static Object call(ContextFactory contextFactory, final Callable callable, final Scriptable scriptable, final Scriptable scriptable2, final Object[] objArr) {
        if (contextFactory == null) {
            contextFactory = ContextFactory.getGlobal();
        }
        return call(contextFactory, new ContextAction() { // from class: org.mozilla.javascript.Context.1
            @Override // org.mozilla.javascript.ContextAction
            public Object run(Context context) {
                return Callable.this.call(context, scriptable, scriptable2, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object call(ContextFactory contextFactory, ContextAction contextAction) {
        try {
            return contextAction.run(enter(null, contextFactory));
        } finally {
            exit();
        }
    }

    public static void addContextListener(ContextListener contextListener) {
        if ("org.mozilla.javascript.tools.debugger.Main".equals(contextListener.getClass().getName())) {
            try {
                contextListener.getClass().getMethod("attachTo", Kit.classOrNull("org.mozilla.javascript.ContextFactory")).invoke(contextListener, ContextFactory.getGlobal());
                return;
            } catch (Exception e) {
                RuntimeException runtimeException = new RuntimeException();
                Kit.initCause(runtimeException, e);
                throw runtimeException;
            }
        }
        ContextFactory.getGlobal().addListener(contextListener);
    }

    public static void removeContextListener(ContextListener contextListener) {
        ContextFactory.getGlobal().addListener(contextListener);
    }

    public final ContextFactory getFactory() {
        return this.factory;
    }

    public final boolean isSealed() {
        return this.sealed;
    }

    public final void seal(Object obj) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.sealed = true;
        this.sealKey = obj;
    }

    public final void unseal(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        if (this.sealKey != obj) {
            throw new IllegalArgumentException();
        }
        if (!this.sealed) {
            throw new IllegalStateException();
        }
        this.sealed = false;
        this.sealKey = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void onSealedMutation() {
        throw new IllegalStateException();
    }

    public final int getLanguageVersion() {
        return this.version;
    }

    public void setLanguageVersion(int i) {
        int i2;
        if (this.sealed) {
            onSealedMutation();
        }
        checkLanguageVersion(i);
        Object obj = this.propertyListeners;
        if (obj != null && i != (i2 = this.version)) {
            firePropertyChangeImpl(obj, languageVersionProperty, Integer.valueOf(i2), Integer.valueOf(i));
        }
        this.version = i;
    }

    public static void checkLanguageVersion(int i) {
        if (isValidLanguageVersion(i)) {
            return;
        }
        throw new IllegalArgumentException("Bad language version: " + i);
    }

    public final String getImplementationVersion() {
        if (implementationVersion == null) {
            implementationVersion = ScriptRuntime.getMessage0("implementation.version");
        }
        return implementationVersion;
    }

    public final ErrorReporter getErrorReporter() {
        ErrorReporter errorReporter = this.errorReporter;
        return errorReporter == null ? DefaultErrorReporter.instance : errorReporter;
    }

    public final ErrorReporter setErrorReporter(ErrorReporter errorReporter) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (errorReporter == null) {
            throw new IllegalArgumentException();
        }
        ErrorReporter errorReporter2 = getErrorReporter();
        if (errorReporter == errorReporter2) {
            return errorReporter2;
        }
        Object obj = this.propertyListeners;
        if (obj != null) {
            firePropertyChangeImpl(obj, errorReporterProperty, errorReporter2, errorReporter);
        }
        this.errorReporter = errorReporter;
        return errorReporter2;
    }

    public final Locale getLocale() {
        if (this.locale == null) {
            this.locale = Locale.getDefault();
        }
        return this.locale;
    }

    public final Locale setLocale(Locale locale) {
        if (this.sealed) {
            onSealedMutation();
        }
        Locale locale2 = this.locale;
        this.locale = locale;
        return locale2;
    }

    public final void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.propertyListeners = Kit.addListener(this.propertyListeners, propertyChangeListener);
    }

    public final void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.propertyListeners = Kit.removeListener(this.propertyListeners, propertyChangeListener);
    }

    final void firePropertyChange(String str, Object obj, Object obj2) {
        Object obj3 = this.propertyListeners;
        if (obj3 != null) {
            firePropertyChangeImpl(obj3, str, obj, obj2);
        }
    }

    private void firePropertyChangeImpl(Object obj, String str, Object obj2, Object obj3) {
        int i = 0;
        while (true) {
            Object listener = Kit.getListener(obj, i);
            if (listener == null) {
                return;
            }
            if (listener instanceof PropertyChangeListener) {
                ((PropertyChangeListener) listener).propertyChange(new PropertyChangeEvent(this, str, obj2, obj3));
            }
            i++;
        }
    }

    public static void reportWarning(String str, String str2, int i, String str3, int i2) {
        Context context = getContext();
        if (context.hasFeature(12)) {
            reportError(str, str2, i, str3, i2);
        } else {
            context.getErrorReporter().warning(str, str2, i, str3, i2);
        }
    }

    public static void reportWarning(String str) {
        int[] iArr = {0};
        reportWarning(str, getSourcePositionFromStack(iArr), iArr[0], null, 0);
    }

    public static void reportWarning(String str, Throwable th) {
        int[] iArr = {0};
        String sourcePositionFromStack = getSourcePositionFromStack(iArr);
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        printWriter.println(str);
        th.printStackTrace(printWriter);
        printWriter.flush();
        reportWarning(stringWriter.toString(), sourcePositionFromStack, iArr[0], null, 0);
    }

    public static void reportError(String str, String str2, int i, String str3, int i2) {
        Context currentContext = getCurrentContext();
        if (currentContext != null) {
            currentContext.getErrorReporter().error(str, str2, i, str3, i2);
            return;
        }
        throw new EvaluatorException(str, str2, i, str3, i2);
    }

    public static void reportError(String str) {
        int[] iArr = {0};
        reportError(str, getSourcePositionFromStack(iArr), iArr[0], null, 0);
    }

    public static EvaluatorException reportRuntimeError(String str, String str2, int i, String str3, int i2) {
        Context currentContext = getCurrentContext();
        if (currentContext != null) {
            return currentContext.getErrorReporter().runtimeError(str, str2, i, str3, i2);
        }
        throw new EvaluatorException(str, str2, i, str3, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static EvaluatorException reportRuntimeError0(String str) {
        return reportRuntimeError(ScriptRuntime.getMessage0(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static EvaluatorException reportRuntimeError1(String str, Object obj) {
        return reportRuntimeError(ScriptRuntime.getMessage1(str, obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static EvaluatorException reportRuntimeError2(String str, Object obj, Object obj2) {
        return reportRuntimeError(ScriptRuntime.getMessage2(str, obj, obj2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static EvaluatorException reportRuntimeError3(String str, Object obj, Object obj2, Object obj3) {
        return reportRuntimeError(ScriptRuntime.getMessage3(str, obj, obj2, obj3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static EvaluatorException reportRuntimeError4(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        return reportRuntimeError(ScriptRuntime.getMessage4(str, obj, obj2, obj3, obj4));
    }

    public static EvaluatorException reportRuntimeError(String str) {
        int[] iArr = {0};
        return reportRuntimeError(str, getSourcePositionFromStack(iArr), iArr[0], null, 0);
    }

    public final ScriptableObject initStandardObjects() {
        return initStandardObjects(null, false);
    }

    public final Scriptable initStandardObjects(ScriptableObject scriptableObject) {
        return initStandardObjects(scriptableObject, false);
    }

    public ScriptableObject initStandardObjects(ScriptableObject scriptableObject, boolean z) {
        return ScriptRuntime.initStandardObjects(this, scriptableObject, z);
    }

    public static Object getUndefinedValue() {
        return Undefined.instance;
    }

    public final Object evaluateString(Scriptable scriptable, String str, String str2, int i, Object obj) {
        Script compileString = compileString(str, str2, i, obj);
        if (compileString != null) {
            return compileString.exec(this, scriptable);
        }
        return null;
    }

    public final Object evaluateReader(Scriptable scriptable, Reader reader, String str, int i, Object obj) throws IOException {
        Script compileReader = compileReader(scriptable, reader, str, i, obj);
        if (compileReader != null) {
            return compileReader.exec(this, scriptable);
        }
        return null;
    }

    public Object executeScriptWithContinuations(Script script, Scriptable scriptable) throws ContinuationPending {
        if (script instanceof InterpretedFunction) {
            InterpretedFunction interpretedFunction = (InterpretedFunction) script;
            if (interpretedFunction.isScript()) {
                return callFunctionWithContinuations(interpretedFunction, scriptable, ScriptRuntime.emptyArgs);
            }
        }
        throw new IllegalArgumentException("Script argument was not a script or was not created by interpreted mode ");
    }

    public Object callFunctionWithContinuations(Callable callable, Scriptable scriptable, Object[] objArr) throws ContinuationPending {
        if (!(callable instanceof InterpretedFunction)) {
            throw new IllegalArgumentException("Function argument was not created by interpreted mode ");
        }
        if (ScriptRuntime.hasTopCall(this)) {
            throw new IllegalStateException("Cannot have any pending top calls when executing a script with continuations");
        }
        this.isContinuationsTopCall = true;
        return ScriptRuntime.doTopCall(callable, this, scriptable, scriptable, objArr);
    }

    public ContinuationPending captureContinuation() {
        return new ContinuationPending(Interpreter.captureContinuation(this));
    }

    public Object resumeContinuation(Object obj, Scriptable scriptable, Object obj2) throws ContinuationPending {
        return Interpreter.restartContinuation((NativeContinuation) obj, this, scriptable, new Object[]{obj2});
    }

    public final boolean stringIsCompilableUnit(String str) {
        boolean z;
        CompilerEnvirons compilerEnvirons = new CompilerEnvirons();
        compilerEnvirons.initFromContext(this);
        compilerEnvirons.setGeneratingSource(false);
        Parser parser = new Parser(compilerEnvirons, DefaultErrorReporter.instance);
        try {
            parser.parse(str, (String) null, 1);
            z = false;
        } catch (EvaluatorException unused) {
            z = true;
        }
        return (z && parser.eof()) ? false : true;
    }

    public final Script compileReader(Scriptable scriptable, Reader reader, String str, int i, Object obj) throws IOException {
        return compileReader(reader, str, i, obj);
    }

    public final Script compileReader(Reader reader, String str, int i, Object obj) throws IOException {
        return (Script) compileImpl(null, reader, null, str, i < 0 ? 0 : i, obj, false, null, null);
    }

    public final Script compileString(String str, String str2, int i, Object obj) {
        return compileString(str, null, null, str2, i < 0 ? 0 : i, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Script compileString(String str, Evaluator evaluator, ErrorReporter errorReporter, String str2, int i, Object obj) {
        try {
            return (Script) compileImpl(null, null, str, str2, i, obj, false, evaluator, errorReporter);
        } catch (IOException unused) {
            throw new RuntimeException();
        }
    }

    public final Function compileFunction(Scriptable scriptable, String str, String str2, int i, Object obj) {
        return compileFunction(scriptable, str, null, null, str2, i, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Function compileFunction(Scriptable scriptable, String str, Evaluator evaluator, ErrorReporter errorReporter, String str2, int i, Object obj) {
        try {
            return (Function) compileImpl(scriptable, null, str, str2, i, obj, true, evaluator, errorReporter);
        } catch (IOException unused) {
            throw new RuntimeException();
        }
    }

    public final String decompileScript(Script script, int i) {
        return ((NativeFunction) script).decompile(i, 0);
    }

    public final String decompileFunction(Function function, int i) {
        if (function instanceof BaseFunction) {
            return ((BaseFunction) function).decompile(i, 0);
        }
        return "function " + function.getClassName() + "() {\n\t[native code]\n}\n";
    }

    public final String decompileFunctionBody(Function function, int i) {
        return function instanceof BaseFunction ? ((BaseFunction) function).decompile(i, 1) : "[native code]\n";
    }

    public Scriptable newObject(Scriptable scriptable) {
        NativeObject nativeObject = new NativeObject();
        ScriptRuntime.setBuiltinProtoAndParent(nativeObject, scriptable, TopLevel.Builtins.Object);
        return nativeObject;
    }

    public Scriptable newObject(Scriptable scriptable, String str) {
        return newObject(scriptable, str, ScriptRuntime.emptyArgs);
    }

    public Scriptable newObject(Scriptable scriptable, String str, Object[] objArr) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        Function existingCtor = ScriptRuntime.getExistingCtor(this, topLevelScope, str);
        if (objArr == null) {
            objArr = ScriptRuntime.emptyArgs;
        }
        return existingCtor.construct(this, topLevelScope, objArr);
    }

    public Scriptable newArray(Scriptable scriptable, int i) {
        NativeArray nativeArray = new NativeArray(i);
        ScriptRuntime.setBuiltinProtoAndParent(nativeArray, scriptable, TopLevel.Builtins.Array);
        return nativeArray;
    }

    public Scriptable newArray(Scriptable scriptable, Object[] objArr) {
        if (objArr.getClass().getComponentType() != ScriptRuntime.ObjectClass) {
            throw new IllegalArgumentException();
        }
        NativeArray nativeArray = new NativeArray(objArr);
        ScriptRuntime.setBuiltinProtoAndParent(nativeArray, scriptable, TopLevel.Builtins.Array);
        return nativeArray;
    }

    public final Object[] getElements(Scriptable scriptable) {
        return ScriptRuntime.getArrayElements(scriptable);
    }

    public static boolean toBoolean(Object obj) {
        return ScriptRuntime.toBoolean(obj);
    }

    public static double toNumber(Object obj) {
        return ScriptRuntime.toNumber(obj);
    }

    public static String toString(Object obj) {
        return ScriptRuntime.toString(obj);
    }

    public static Scriptable toObject(Object obj, Scriptable scriptable) {
        return ScriptRuntime.toObject(scriptable, obj);
    }

    public static Scriptable toObject(Object obj, Scriptable scriptable, Class<?> cls) {
        return ScriptRuntime.toObject(scriptable, obj);
    }

    public static Object javaToJS(Object obj, Scriptable scriptable) {
        if ((obj instanceof String) || (obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof Scriptable)) {
            return obj;
        }
        if (obj instanceof Character) {
            return String.valueOf(((Character) obj).charValue());
        }
        Context context = getContext();
        return context.getWrapFactory().wrap(context, scriptable, obj, null);
    }

    public static Object jsToJava(Object obj, Class<?> cls) throws EvaluatorException {
        return NativeJavaObject.coerceTypeImpl(cls, obj);
    }

    public static Object toType(Object obj, Class<?> cls) throws IllegalArgumentException {
        try {
            return jsToJava(obj, cls);
        } catch (EvaluatorException e) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(e.getMessage());
            Kit.initCause(illegalArgumentException, e);
            throw illegalArgumentException;
        }
    }

    public static RuntimeException throwAsScriptRuntimeEx(Throwable th) {
        Context context;
        while (th instanceof InvocationTargetException) {
            th = ((InvocationTargetException) th).getTargetException();
        }
        if ((th instanceof Error) && ((context = getContext()) == null || !context.hasFeature(13))) {
            throw ((Error) th);
        }
        if (th instanceof RhinoException) {
            throw ((RhinoException) th);
        }
        throw new WrappedException(th);
    }

    public final boolean isGeneratingDebug() {
        return this.generatingDebug;
    }

    public final void setGeneratingDebug(boolean z) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.generatingDebugChanged = true;
        if (z && getOptimizationLevel() > 0) {
            setOptimizationLevel(0);
        }
        this.generatingDebug = z;
    }

    public final boolean isGeneratingSource() {
        return this.generatingSource;
    }

    public final void setGeneratingSource(boolean z) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.generatingSource = z;
    }

    public final int getOptimizationLevel() {
        return this.optimizationLevel;
    }

    public final void setOptimizationLevel(int i) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (i == -2) {
            i = -1;
        }
        checkOptimizationLevel(i);
        this.optimizationLevel = codegenClass != null ? i : -1;
    }

    public static void checkOptimizationLevel(int i) {
        if (isValidOptimizationLevel(i)) {
            return;
        }
        throw new IllegalArgumentException("Optimization level outside [-1..9]: " + i);
    }

    public final int getMaximumInterpreterStackDepth() {
        return this.maximumInterpreterStackDepth;
    }

    public final void setMaximumInterpreterStackDepth(int i) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (this.optimizationLevel != -1) {
            throw new IllegalStateException("Cannot set maximumInterpreterStackDepth when optimizationLevel != -1");
        }
        if (i < 1) {
            throw new IllegalArgumentException("Cannot set maximumInterpreterStackDepth to less than 1");
        }
        this.maximumInterpreterStackDepth = i;
    }

    public final void setSecurityController(SecurityController securityController) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (securityController == null) {
            throw new IllegalArgumentException();
        }
        if (this.securityController != null) {
            throw new SecurityException("Can not overwrite existing SecurityController object");
        }
        if (SecurityController.hasGlobal()) {
            throw new SecurityException("Can not overwrite existing global SecurityController object");
        }
        this.securityController = securityController;
    }

    public final synchronized void setClassShutter(ClassShutter classShutter) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (classShutter == null) {
            throw new IllegalArgumentException();
        }
        if (this.hasClassShutter) {
            throw new SecurityException("Cannot overwrite existing ClassShutter object");
        }
        this.classShutter = classShutter;
        this.hasClassShutter = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized ClassShutter getClassShutter() {
        return this.classShutter;
    }

    public final synchronized ClassShutterSetter getClassShutterSetter() {
        if (this.hasClassShutter) {
            return null;
        }
        this.hasClassShutter = true;
        return new ClassShutterSetter() { // from class: org.mozilla.javascript.Context.2
            @Override // org.mozilla.javascript.Context.ClassShutterSetter
            public void setClassShutter(ClassShutter classShutter) {
                Context.this.classShutter = classShutter;
            }

            @Override // org.mozilla.javascript.Context.ClassShutterSetter
            public ClassShutter getClassShutter() {
                return Context.this.classShutter;
            }
        };
    }

    public final Object getThreadLocal(Object obj) {
        Map<Object, Object> map = this.threadLocalMap;
        if (map == null) {
            return null;
        }
        return map.get(obj);
    }

    public final synchronized void putThreadLocal(Object obj, Object obj2) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (this.threadLocalMap == null) {
            this.threadLocalMap = new HashMap();
        }
        this.threadLocalMap.put(obj, obj2);
    }

    public final void removeThreadLocal(Object obj) {
        if (this.sealed) {
            onSealedMutation();
        }
        Map<Object, Object> map = this.threadLocalMap;
        if (map == null) {
            return;
        }
        map.remove(obj);
    }

    public final void setWrapFactory(WrapFactory wrapFactory) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (wrapFactory == null) {
            throw new IllegalArgumentException();
        }
        this.wrapFactory = wrapFactory;
    }

    public final WrapFactory getWrapFactory() {
        if (this.wrapFactory == null) {
            this.wrapFactory = new WrapFactory();
        }
        return this.wrapFactory;
    }

    public final Debugger getDebugger() {
        return this.debugger;
    }

    public final Object getDebuggerContextData() {
        return this.debuggerData;
    }

    public final void setDebugger(Debugger debugger, Object obj) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.debugger = debugger;
        this.debuggerData = obj;
    }

    public static DebuggableScript getDebuggableView(Script script) {
        if (script instanceof NativeFunction) {
            return ((NativeFunction) script).getDebuggableView();
        }
        return null;
    }

    public boolean hasFeature(int i) {
        return getFactory().hasFeature(this, i);
    }

    public XMLLib.Factory getE4xImplementationFactory() {
        return getFactory().getE4xImplementationFactory();
    }

    public final int getInstructionObserverThreshold() {
        return this.instructionThreshold;
    }

    public final void setInstructionObserverThreshold(int i) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        this.instructionThreshold = i;
        setGenerateObserverCount(i > 0);
    }

    public void setGenerateObserverCount(boolean z) {
        this.generateObserverCount = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void observeInstructionCount(int i) {
        getFactory().observeInstructionCount(this, i);
    }

    public GeneratedClassLoader createClassLoader(ClassLoader classLoader) {
        return getFactory().createClassLoader(classLoader);
    }

    public final ClassLoader getApplicationClassLoader() {
        if (this.applicationClassLoader == null) {
            ContextFactory factory = getFactory();
            ClassLoader applicationClassLoader = factory.getApplicationClassLoader();
            if (applicationClassLoader == null) {
                ClassLoader currentThreadClassLoader = VMBridge.instance.getCurrentThreadClassLoader();
                if (currentThreadClassLoader != null && Kit.testIfCanLoadRhinoClasses(currentThreadClassLoader)) {
                    return currentThreadClassLoader;
                }
                Class<?> cls = factory.getClass();
                if (cls != ScriptRuntime.ContextFactoryClass) {
                    applicationClassLoader = cls.getClassLoader();
                } else {
                    applicationClassLoader = getClass().getClassLoader();
                }
            }
            this.applicationClassLoader = applicationClassLoader;
        }
        return this.applicationClassLoader;
    }

    public final void setApplicationClassLoader(ClassLoader classLoader) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (classLoader == null) {
            this.applicationClassLoader = null;
        } else if (!Kit.testIfCanLoadRhinoClasses(classLoader)) {
            throw new IllegalArgumentException("Loader can not resolve Rhino classes");
        } else {
            this.applicationClassLoader = classLoader;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        Context currentContext = getCurrentContext();
        if (currentContext != null) {
            return currentContext;
        }
        throw new RuntimeException("No Context associated with current Thread");
    }

    private Object compileImpl(Scriptable scriptable, Reader reader, String str, String str2, int i, Object obj, boolean z, Evaluator evaluator, ErrorReporter errorReporter) throws IOException {
        AstRoot parse;
        if (str2 == null) {
            str2 = "unnamed script";
        }
        if (obj != null && getSecurityController() == null) {
            throw new IllegalArgumentException("securityDomain should be null if setSecurityController() was never called");
        }
        if (!((reader == null) ^ (str == null))) {
            Kit.codeBug();
        }
        if (!((scriptable == null) ^ z)) {
            Kit.codeBug();
        }
        CompilerEnvirons compilerEnvirons = new CompilerEnvirons();
        compilerEnvirons.initFromContext(this);
        if (errorReporter == null) {
            errorReporter = compilerEnvirons.getErrorReporter();
        }
        if (this.debugger != null && reader != null) {
            str = Kit.readReader(reader);
            reader = null;
        }
        Parser parser = new Parser(compilerEnvirons, errorReporter);
        if (z) {
            parser.calledByCompileFunction = true;
        }
        if (str != null) {
            parse = parser.parse(str, str2, i);
        } else {
            parse = parser.parse(reader, str2, i);
        }
        if (z && (parse.getFirstChild() == null || parse.getFirstChild().getType() != 109)) {
            throw new IllegalArgumentException("compileFunction only accepts source with single JS function: " + str);
        }
        ScriptNode transformTree = new IRFactory(compilerEnvirons, errorReporter).transformTree(parse);
        if (evaluator == null) {
            evaluator = createCompiler();
        }
        Object compile = evaluator.compile(compilerEnvirons, transformTree, transformTree.getEncodedSource(), z);
        if (this.debugger != null) {
            if (str == null) {
                Kit.codeBug();
            }
            if (compile instanceof DebuggableScript) {
                notifyDebugger_r(this, (DebuggableScript) compile, str);
            } else {
                throw new RuntimeException("NOT SUPPORTED");
            }
        }
        if (z) {
            return evaluator.createFunctionObject(this, scriptable, compile, obj);
        }
        return evaluator.createScriptObject(compile, obj);
    }

    private static void notifyDebugger_r(Context context, DebuggableScript debuggableScript, String str) {
        context.debugger.handleCompilationDone(context, debuggableScript, str);
        for (int i = 0; i != debuggableScript.getFunctionCount(); i++) {
            notifyDebugger_r(context, debuggableScript.getFunction(i), str);
        }
    }

    private Evaluator createCompiler() {
        Class<?> cls;
        Evaluator evaluator = (this.optimizationLevel < 0 || (cls = codegenClass) == null) ? null : (Evaluator) Kit.newInstanceOrNull(cls);
        return evaluator == null ? createInterpreter() : evaluator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Evaluator createInterpreter() {
        return (Evaluator) Kit.newInstanceOrNull(interpreterClass);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getSourcePositionFromStack(int[] iArr) {
        Evaluator createInterpreter;
        Context currentContext = getCurrentContext();
        if (currentContext == null) {
            return null;
        }
        if (currentContext.lastInterpreterFrame != null && (createInterpreter = createInterpreter()) != null) {
            return createInterpreter.getSourcePositionFromStack(currentContext, iArr);
        }
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        new RuntimeException().printStackTrace(new PrintWriter(charArrayWriter));
        String charArrayWriter2 = charArrayWriter.toString();
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < charArrayWriter2.length(); i4++) {
            char charAt = charArrayWriter2.charAt(i4);
            if (charAt == ':') {
                i3 = i4;
            } else if (charAt == '(') {
                i = i4;
            } else if (charAt == ')') {
                i2 = i4;
            } else if (charAt == '\n' && i != -1 && i2 != -1 && i3 != -1 && i < i3 && i3 < i2) {
                String substring = charArrayWriter2.substring(i + 1, i3);
                if (!substring.endsWith(".java")) {
                    try {
                        iArr[0] = Integer.parseInt(charArrayWriter2.substring(i3 + 1, i2));
                        if (iArr[0] < 0) {
                            iArr[0] = 0;
                        }
                        return substring;
                    } catch (NumberFormatException unused) {
                    }
                }
                i = -1;
                i2 = -1;
                i3 = -1;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegExpProxy getRegExpProxy() {
        Class<?> classOrNull;
        if (this.regExpProxy == null && (classOrNull = Kit.classOrNull("org.mozilla.javascript.regexp.RegExpImpl")) != null) {
            this.regExpProxy = (RegExpProxy) Kit.newInstanceOrNull(classOrNull);
        }
        return this.regExpProxy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isVersionECMA1() {
        int i = this.version;
        return i == 0 || i >= 130;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SecurityController getSecurityController() {
        SecurityController global = SecurityController.global();
        return global != null ? global : this.securityController;
    }

    public final boolean isGeneratingDebugChanged() {
        return this.generatingDebugChanged;
    }

    public void addActivationName(String str) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (this.activationNames == null) {
            this.activationNames = new HashSet();
        }
        this.activationNames.add(str);
    }

    public final boolean isActivationNeeded(String str) {
        Set<String> set = this.activationNames;
        return set != null && set.contains(str);
    }

    public void removeActivationName(String str) {
        if (this.sealed) {
            onSealedMutation();
        }
        Set<String> set = this.activationNames;
        if (set != null) {
            set.remove(str);
        }
    }
}
