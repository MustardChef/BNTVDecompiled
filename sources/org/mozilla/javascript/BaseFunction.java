package org.mozilla.javascript;

import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;

/* loaded from: classes5.dex */
public class BaseFunction extends IdScriptableObject implements Function {
    private static final Object FUNCTION_TAG = "Function";
    private static final int Id_apply = 4;
    private static final int Id_arguments = 5;
    private static final int Id_arity = 2;
    private static final int Id_bind = 6;
    private static final int Id_call = 5;
    private static final int Id_constructor = 1;
    private static final int Id_length = 1;
    private static final int Id_name = 3;
    private static final int Id_prototype = 4;
    private static final int Id_toSource = 3;
    private static final int Id_toString = 2;
    private static final int MAX_INSTANCE_ID = 5;
    private static final int MAX_PROTOTYPE_ID = 6;
    static final long serialVersionUID = 5311394446546053859L;
    private Object prototypeProperty;
    private int prototypePropertyAttributes;

    public int getArity() {
        return 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Function";
    }

    public String getFunctionName() {
        return "";
    }

    public int getLength() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int getMaxInstanceId() {
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init(Scriptable scriptable, boolean z) {
        BaseFunction baseFunction = new BaseFunction();
        baseFunction.prototypePropertyAttributes = 7;
        baseFunction.exportAsJSClass(6, scriptable, z);
    }

    public BaseFunction() {
        this.prototypePropertyAttributes = 6;
    }

    public BaseFunction(Scriptable scriptable, Scriptable scriptable2) {
        super(scriptable, scriptable2);
        this.prototypePropertyAttributes = 6;
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public String getTypeOf() {
        return avoidObjectDetection() ? "undefined" : "function";
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean hasInstance(Scriptable scriptable) {
        Object property = ScriptableObject.getProperty(this, "prototype");
        if (property instanceof Scriptable) {
            return ScriptRuntime.jsDelegatesTo(scriptable, (Scriptable) property);
        }
        throw ScriptRuntime.typeError1("msg.instanceof.bad.prototype", getFunctionName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int findInstanceIdInfo(String str) {
        String str2;
        int i;
        int length = str.length();
        int i2 = 6;
        if (length == 4) {
            str2 = "name";
            i = 3;
        } else if (length == 5) {
            str2 = "arity";
            i = 2;
        } else if (length != 6) {
            if (length == 9) {
                char charAt = str.charAt(0);
                if (charAt == 'a') {
                    str2 = "arguments";
                    i = 5;
                } else if (charAt == 'p') {
                    str2 = "prototype";
                    i = 4;
                }
            }
            str2 = null;
            i = 0;
        } else {
            str2 = SessionDescription.ATTR_LENGTH;
            i = 1;
        }
        if (str2 != null && str2 != str && !str2.equals(str)) {
            i = 0;
        }
        if (i == 0) {
            return super.findInstanceIdInfo(str);
        }
        if (i == 1 || i == 2 || i == 3) {
            i2 = 7;
        } else if (i != 4) {
            if (i != 5) {
                throw new IllegalStateException();
            }
        } else if (!hasPrototypeProperty()) {
            return 0;
        } else {
            i2 = this.prototypePropertyAttributes;
        }
        return instanceIdInfo(i2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public String getInstanceIdName(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? super.getInstanceIdName(i) : "arguments" : "prototype" : "name" : "arity" : SessionDescription.ATTR_LENGTH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public Object getInstanceIdValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            return getArguments();
                        }
                        return super.getInstanceIdValue(i);
                    }
                    return getPrototypeProperty();
                }
                return getFunctionName();
            }
            return ScriptRuntime.wrapInt(getArity());
        }
        return ScriptRuntime.wrapInt(getLength());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public void setInstanceIdValue(int i, Object obj) {
        if (i == 1 || i == 2 || i == 3) {
            return;
        }
        if (i == 4) {
            if ((this.prototypePropertyAttributes & 1) == 0) {
                if (obj == null) {
                    obj = UniqueTag.NULL_VALUE;
                }
                this.prototypeProperty = obj;
            }
        } else if (i == 5) {
            if (obj == NOT_FOUND) {
                Kit.codeBug();
            }
            defaultPut("arguments", obj);
        } else {
            super.setInstanceIdValue(i, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        idFunctionObject.setPrototype(this);
        super.fillConstructorProperties(idFunctionObject);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        int i2 = 1;
        switch (i) {
            case 1:
                str = "constructor";
                break;
            case 2:
                str = "toString";
                break;
            case 3:
                str = "toSource";
                break;
            case 4:
                i2 = 2;
                str = "apply";
                break;
            case 5:
                str = NotificationCompat.CATEGORY_CALL;
                break;
            case 6:
                str = "bind";
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(FUNCTION_TAG, i, str, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isApply(IdFunctionObject idFunctionObject) {
        return idFunctionObject.hasTag(FUNCTION_TAG) && idFunctionObject.methodId() == 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isApplyOrCall(IdFunctionObject idFunctionObject) {
        if (idFunctionObject.hasTag(FUNCTION_TAG)) {
            int methodId = idFunctionObject.methodId();
            return methodId == 4 || methodId == 5;
        }
        return false;
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        int int32;
        Scriptable scriptable3;
        Object[] objArr2;
        if (!idFunctionObject.hasTag(FUNCTION_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        int i = 0;
        switch (methodId) {
            case 1:
                return jsConstructor(context, scriptable, objArr);
            case 2:
                return realFunction(scriptable2, idFunctionObject).decompile(ScriptRuntime.toInt32(objArr, 0), 0);
            case 3:
                BaseFunction realFunction = realFunction(scriptable2, idFunctionObject);
                int i2 = 2;
                if (objArr.length != 0 && (int32 = ScriptRuntime.toInt32(objArr[0])) >= 0) {
                    i = int32;
                    i2 = 0;
                }
                return realFunction.decompile(i, i2);
            case 4:
            case 5:
                return ScriptRuntime.applyOrCall(methodId == 4, context, scriptable, scriptable2, objArr);
            case 6:
                if (!(scriptable2 instanceof Callable)) {
                    throw ScriptRuntime.notFunctionError(scriptable2);
                }
                Callable callable = (Callable) scriptable2;
                int length = objArr.length;
                if (length > 0) {
                    Scriptable objectOrNull = ScriptRuntime.toObjectOrNull(context, objArr[0], scriptable);
                    int i3 = length - 1;
                    Object[] objArr3 = new Object[i3];
                    System.arraycopy(objArr, 1, objArr3, 0, i3);
                    scriptable3 = objectOrNull;
                    objArr2 = objArr3;
                } else {
                    scriptable3 = null;
                    objArr2 = ScriptRuntime.emptyArgs;
                }
                return new BoundFunction(context, scriptable, callable, scriptable3, objArr2);
            default:
                throw new IllegalArgumentException(String.valueOf(methodId));
        }
    }

    private BaseFunction realFunction(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        Object defaultValue = scriptable.getDefaultValue(ScriptRuntime.FunctionClass);
        if (defaultValue instanceof BaseFunction) {
            return (BaseFunction) defaultValue;
        }
        throw ScriptRuntime.typeError1("msg.incompat.call", idFunctionObject.getFunctionName());
    }

    public void setImmunePrototypeProperty(Object obj) {
        if ((this.prototypePropertyAttributes & 1) != 0) {
            throw new IllegalStateException();
        }
        if (obj == null) {
            obj = UniqueTag.NULL_VALUE;
        }
        this.prototypeProperty = obj;
        this.prototypePropertyAttributes = 7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Scriptable getClassPrototype() {
        Object prototypeProperty = getPrototypeProperty();
        if (prototypeProperty instanceof Scriptable) {
            return (Scriptable) prototypeProperty;
        }
        return ScriptableObject.getObjectPrototype(this);
    }

    @Override // org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return Undefined.instance;
    }

    @Override // org.mozilla.javascript.Function
    public Scriptable construct(Context context, Scriptable scriptable, Object[] objArr) {
        Scriptable parentScope;
        Scriptable classPrototype;
        Scriptable createObject = createObject(context, scriptable);
        if (createObject != null) {
            Object call = call(context, scriptable, createObject, objArr);
            return call instanceof Scriptable ? (Scriptable) call : createObject;
        }
        Object call2 = call(context, scriptable, null, objArr);
        if (!(call2 instanceof Scriptable)) {
            throw new IllegalStateException("Bad implementaion of call as constructor, name=" + getFunctionName() + " in " + getClass().getName());
        }
        Scriptable scriptable2 = (Scriptable) call2;
        if (scriptable2.getPrototype() == null && scriptable2 != (classPrototype = getClassPrototype())) {
            scriptable2.setPrototype(classPrototype);
        }
        if (scriptable2.getParentScope() != null || scriptable2 == (parentScope = getParentScope())) {
            return scriptable2;
        }
        scriptable2.setParentScope(parentScope);
        return scriptable2;
    }

    public Scriptable createObject(Context context, Scriptable scriptable) {
        NativeObject nativeObject = new NativeObject();
        nativeObject.setPrototype(getClassPrototype());
        nativeObject.setParentScope(getParentScope());
        return nativeObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String decompile(int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = (i2 & 1) != 0;
        if (!z) {
            stringBuffer.append("function ");
            stringBuffer.append(getFunctionName());
            stringBuffer.append("() {\n\t");
        }
        stringBuffer.append("[native code, arity=");
        stringBuffer.append(getArity());
        stringBuffer.append("]\n");
        if (!z) {
            stringBuffer.append("}\n");
        }
        return stringBuffer.toString();
    }

    protected boolean hasPrototypeProperty() {
        return this.prototypeProperty != null || (this instanceof NativeFunction);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object getPrototypeProperty() {
        Object obj = this.prototypeProperty;
        if (obj == null) {
            if (this instanceof NativeFunction) {
                return setupDefaultPrototype();
            }
            return Undefined.instance;
        } else if (obj == UniqueTag.NULL_VALUE) {
            return null;
        } else {
            return obj;
        }
    }

    private synchronized Object setupDefaultPrototype() {
        Object obj = this.prototypeProperty;
        if (obj != null) {
            return obj;
        }
        NativeObject nativeObject = new NativeObject();
        nativeObject.defineProperty("constructor", this, 2);
        this.prototypeProperty = nativeObject;
        Scriptable objectPrototype = getObjectPrototype(this);
        if (objectPrototype != nativeObject) {
            nativeObject.setPrototype(objectPrototype);
        }
        return nativeObject;
    }

    private Object getArguments() {
        Object defaultGet = defaultGet("arguments");
        if (defaultGet != NOT_FOUND) {
            return defaultGet;
        }
        Scriptable findFunctionActivation = ScriptRuntime.findFunctionActivation(Context.getContext(), this);
        if (findFunctionActivation == null) {
            return null;
        }
        return findFunctionActivation.get("arguments", findFunctionActivation);
    }

    private static Object jsConstructor(Context context, Scriptable scriptable, Object[] objArr) {
        int i;
        int length = objArr.length;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("function ");
        if (context.getLanguageVersion() != 120) {
            stringBuffer.append("anonymous");
        }
        stringBuffer.append('(');
        int i2 = 0;
        while (true) {
            i = length - 1;
            if (i2 >= i) {
                break;
            }
            if (i2 > 0) {
                stringBuffer.append(',');
            }
            stringBuffer.append(ScriptRuntime.toString(objArr[i2]));
            i2++;
        }
        stringBuffer.append(") {");
        if (length != 0) {
            stringBuffer.append(ScriptRuntime.toString(objArr[i]));
        }
        stringBuffer.append("\n}");
        String stringBuffer2 = stringBuffer.toString();
        int[] iArr = new int[1];
        String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
        if (sourcePositionFromStack == null) {
            iArr[0] = 1;
            sourcePositionFromStack = "<eval'ed string>";
        }
        String makeUrlForGeneratedScript = ScriptRuntime.makeUrlForGeneratedScript(false, sourcePositionFromStack, iArr[0]);
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        ErrorReporter forEval = DefaultErrorReporter.forEval(context.getErrorReporter());
        Evaluator createInterpreter = Context.createInterpreter();
        if (createInterpreter == null) {
            throw new JavaScriptException("Interpreter not present", sourcePositionFromStack, iArr[0]);
        }
        return context.compileFunction(topLevelScope, stringBuffer2, createInterpreter, forEval, makeUrlForGeneratedScript, 1, null);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 3;
        if (length == 4) {
            char charAt = str.charAt(0);
            if (charAt == 'b') {
                i = 6;
                str2 = "bind";
            } else {
                if (charAt == 'c') {
                    str2 = NotificationCompat.CATEGORY_CALL;
                    i = 5;
                }
                str2 = null;
                i = 0;
            }
        } else if (length == 5) {
            str2 = "apply";
            i = 4;
        } else if (length != 8) {
            if (length == 11) {
                i = 1;
                str2 = "constructor";
            }
            str2 = null;
            i = 0;
        } else {
            char charAt2 = str.charAt(3);
            if (charAt2 == 'o') {
                str2 = "toSource";
            } else {
                if (charAt2 == 't') {
                    i = 2;
                    str2 = "toString";
                }
                str2 = null;
                i = 0;
            }
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }
}
