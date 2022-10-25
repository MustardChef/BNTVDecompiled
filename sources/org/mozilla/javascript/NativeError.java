package org.mozilla.javascript;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class NativeError extends IdScriptableObject {
    private static final Object ERROR_TAG = "Error";
    private static final int Id_constructor = 1;
    private static final int Id_toSource = 3;
    private static final int Id_toString = 2;
    private static final int MAX_PROTOTYPE_ID = 3;
    static final long serialVersionUID = -5338413581437645187L;
    private RhinoException stackProvider;

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Error";
    }

    NativeError() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init(Scriptable scriptable, boolean z) {
        NativeError nativeError = new NativeError();
        ScriptableObject.putProperty(nativeError, "name", "Error");
        ScriptableObject.putProperty(nativeError, "message", "");
        ScriptableObject.putProperty(nativeError, "fileName", "");
        ScriptableObject.putProperty((Scriptable) nativeError, "lineNumber", (Object) 0);
        nativeError.exportAsJSClass(3, scriptable, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NativeError make(Context context, Scriptable scriptable, IdFunctionObject idFunctionObject, Object[] objArr) {
        NativeError nativeError = new NativeError();
        nativeError.setPrototype((Scriptable) idFunctionObject.get("prototype", idFunctionObject));
        nativeError.setParentScope(scriptable);
        int length = objArr.length;
        if (length >= 1) {
            ScriptableObject.putProperty(nativeError, "message", ScriptRuntime.toString(objArr[0]));
            if (length >= 2) {
                ScriptableObject.putProperty(nativeError, "fileName", objArr[1]);
                if (length >= 3) {
                    ScriptableObject.putProperty(nativeError, "lineNumber", Integer.valueOf(ScriptRuntime.toInt32(objArr[2])));
                }
            }
        }
        return nativeError;
    }

    public String toString() {
        Object js_toString = js_toString(this);
        return js_toString instanceof String ? (String) js_toString : super.toString();
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        int i2 = 0;
        if (i == 1) {
            str = "constructor";
            i2 = 1;
        } else if (i == 2) {
            str = "toString";
        } else if (i != 3) {
            throw new IllegalArgumentException(String.valueOf(i));
        } else {
            str = "toSource";
        }
        initPrototypeMethod(ERROR_TAG, i, str, i2);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(ERROR_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        if (methodId != 1) {
            if (methodId != 2) {
                if (methodId == 3) {
                    return js_toSource(context, scriptable, scriptable2);
                }
                throw new IllegalArgumentException(String.valueOf(methodId));
            }
            return js_toString(scriptable2);
        }
        return make(context, scriptable, idFunctionObject, objArr);
    }

    public void setStackProvider(RhinoException rhinoException) {
        if (this.stackProvider == null) {
            this.stackProvider = rhinoException;
            try {
                defineProperty("stack", null, NativeError.class.getMethod("getStack", new Class[0]), NativeError.class.getMethod("setStack", Object.class), 0);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Object getStack() {
        RhinoException rhinoException = this.stackProvider;
        Object scriptStackTrace = rhinoException == null ? NOT_FOUND : rhinoException.getScriptStackTrace();
        setStack(scriptStackTrace);
        return scriptStackTrace;
    }

    public void setStack(Object obj) {
        if (this.stackProvider != null) {
            this.stackProvider = null;
            delete("stack");
        }
        put("stack", this, obj);
    }

    private static Object js_toString(Scriptable scriptable) {
        Object property = ScriptableObject.getProperty(scriptable, "name");
        String scriptRuntime = (property == NOT_FOUND || property == Undefined.instance) ? "Error" : ScriptRuntime.toString(property);
        Object property2 = ScriptableObject.getProperty(scriptable, "message");
        if (property2 == NOT_FOUND || property2 == Undefined.instance) {
            return Undefined.instance;
        }
        return scriptRuntime + ": " + ScriptRuntime.toString(property2);
    }

    private static String js_toSource(Context context, Scriptable scriptable, Scriptable scriptable2) {
        int int32;
        Object property = ScriptableObject.getProperty(scriptable2, "name");
        Object property2 = ScriptableObject.getProperty(scriptable2, "message");
        Object property3 = ScriptableObject.getProperty(scriptable2, "fileName");
        Object property4 = ScriptableObject.getProperty(scriptable2, "lineNumber");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("(new ");
        if (property == NOT_FOUND) {
            property = Undefined.instance;
        }
        stringBuffer.append(ScriptRuntime.toString(property));
        stringBuffer.append("(");
        if (property2 != NOT_FOUND || property3 != NOT_FOUND || property4 != NOT_FOUND) {
            if (property2 == NOT_FOUND) {
                property2 = "";
            }
            stringBuffer.append(ScriptRuntime.uneval(context, scriptable, property2));
            if (property3 != NOT_FOUND || property4 != NOT_FOUND) {
                stringBuffer.append(", ");
                if (property3 == NOT_FOUND) {
                    property3 = "";
                }
                stringBuffer.append(ScriptRuntime.uneval(context, scriptable, property3));
                if (property4 != NOT_FOUND && (int32 = ScriptRuntime.toInt32(property4)) != 0) {
                    stringBuffer.append(", ");
                    stringBuffer.append(ScriptRuntime.toString(int32));
                }
            }
        }
        stringBuffer.append("))");
        return stringBuffer.toString();
    }

    private static String getString(Scriptable scriptable, String str) {
        Object property = ScriptableObject.getProperty(scriptable, str);
        return property == NOT_FOUND ? "" : ScriptRuntime.toString(property);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 3;
        if (length == 8) {
            char charAt = str.charAt(3);
            if (charAt == 'o') {
                str2 = "toSource";
            } else {
                if (charAt == 't') {
                    i = 2;
                    str2 = "toString";
                }
                str2 = null;
                i = 0;
            }
        } else {
            if (length == 11) {
                i = 1;
                str2 = "constructor";
            }
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }
}
