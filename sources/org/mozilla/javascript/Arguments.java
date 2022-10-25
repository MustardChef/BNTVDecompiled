package org.mozilla.javascript;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class Arguments extends IdScriptableObject {
    private static final String FTAG = "Arguments";
    private static final int Id_callee = 1;
    private static final int Id_caller = 3;
    private static final int Id_constructor = 4;
    private static final int Id_length = 2;
    private static final int MAX_INSTANCE_ID = 4;
    static final long serialVersionUID = 4275508002492040609L;
    private NativeCall activation;
    private Object[] args;
    private Object calleeObj;
    private Object callerObj;
    private Object constructor;
    private Object lengthObj;

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return FTAG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public String getInstanceIdName(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return "constructor";
                }
                return "caller";
            }
            return SessionDescription.ATTR_LENGTH;
        }
        return "callee";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int getMaxInstanceId() {
        return 4;
    }

    public Arguments(NativeCall nativeCall) {
        this.activation = nativeCall;
        Scriptable parentScope = nativeCall.getParentScope();
        setParentScope(parentScope);
        setPrototype(ScriptableObject.getObjectPrototype(parentScope));
        Object[] objArr = nativeCall.originalArgs;
        this.args = objArr;
        this.lengthObj = Integer.valueOf(objArr.length);
        NativeFunction nativeFunction = nativeCall.function;
        this.calleeObj = nativeFunction;
        this.constructor = getProperty(getTopLevelScope(parentScope), "Object");
        int languageVersion = nativeFunction.getLanguageVersion();
        if (languageVersion <= 130 && languageVersion != 0) {
            this.callerObj = null;
        } else {
            this.callerObj = NOT_FOUND;
        }
    }

    private Object arg(int i) {
        if (i >= 0) {
            Object[] objArr = this.args;
            if (objArr.length > i) {
                return objArr[i];
            }
        }
        return NOT_FOUND;
    }

    private void putIntoActivation(int i, Object obj) {
        String paramOrVarName = this.activation.function.getParamOrVarName(i);
        Scriptable scriptable = this.activation;
        scriptable.put(paramOrVarName, scriptable, obj);
    }

    private Object getFromActivation(int i) {
        String paramOrVarName = this.activation.function.getParamOrVarName(i);
        Scriptable scriptable = this.activation;
        return scriptable.get(paramOrVarName, scriptable);
    }

    private void replaceArg(int i, Object obj) {
        if (sharedWithActivation(i)) {
            putIntoActivation(i, obj);
        }
        synchronized (this) {
            if (this.args == this.activation.originalArgs) {
                this.args = (Object[]) this.args.clone();
            }
            this.args[i] = obj;
        }
    }

    private void removeArg(int i) {
        synchronized (this) {
            if (this.args[i] != NOT_FOUND) {
                if (this.args == this.activation.originalArgs) {
                    this.args = (Object[]) this.args.clone();
                }
                this.args[i] = NOT_FOUND;
            }
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        if (arg(i) != NOT_FOUND) {
            return true;
        }
        return super.has(i, scriptable);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        Object arg = arg(i);
        if (arg == NOT_FOUND) {
            return super.get(i, scriptable);
        }
        return sharedWithActivation(i) ? getFromActivation(i) : arg;
    }

    private boolean sharedWithActivation(int i) {
        NativeFunction nativeFunction = this.activation.function;
        int paramCount = nativeFunction.getParamCount();
        if (i < paramCount) {
            if (i < paramCount - 1) {
                String paramOrVarName = nativeFunction.getParamOrVarName(i);
                for (int i2 = i + 1; i2 < paramCount; i2++) {
                    if (paramOrVarName.equals(nativeFunction.getParamOrVarName(i2))) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        if (arg(i) == NOT_FOUND) {
            super.put(i, scriptable, obj);
        } else {
            replaceArg(i, obj);
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void delete(int i) {
        if (i >= 0 && i < this.args.length) {
            removeArg(i);
        }
        super.delete(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int findInstanceIdInfo(String str) {
        String str2;
        int i;
        int length = str.length();
        int i2 = 0;
        if (length == 6) {
            char charAt = str.charAt(5);
            if (charAt == 'e') {
                str2 = "callee";
                i = 1;
            } else if (charAt == 'h') {
                str2 = SessionDescription.ATTR_LENGTH;
                i = 2;
            } else {
                if (charAt == 'r') {
                    str2 = "caller";
                    i = 3;
                }
                str2 = null;
                i = 0;
            }
        } else {
            if (length == 11) {
                str2 = "constructor";
                i = 4;
            }
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            i2 = i;
        }
        if (i2 == 0) {
            return super.findInstanceIdInfo(str);
        }
        if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4) {
            throw new IllegalStateException();
        }
        return instanceIdInfo(2, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public Object getInstanceIdValue(int i) {
        Scriptable scriptable;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return this.constructor;
                    }
                    return super.getInstanceIdValue(i);
                }
                Object obj = this.callerObj;
                if (obj == UniqueTag.NULL_VALUE) {
                    return null;
                }
                return (obj != null || (scriptable = this.activation.parentActivationCall) == null) ? obj : scriptable.get("arguments", scriptable);
            }
            return this.lengthObj;
        }
        return this.calleeObj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public void setInstanceIdValue(int i, Object obj) {
        if (i == 1) {
            this.calleeObj = obj;
        } else if (i == 2) {
            this.lengthObj = obj;
        } else if (i == 3) {
            if (obj == null) {
                obj = UniqueTag.NULL_VALUE;
            }
            this.callerObj = obj;
        } else if (i == 4) {
            this.constructor = obj;
        } else {
            super.setInstanceIdValue(i, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject
    public Object[] getIds(boolean z) {
        int intValue;
        Object[] ids = super.getIds(z);
        Object[] objArr = this.args;
        if (objArr.length != 0) {
            int length = objArr.length;
            boolean[] zArr = new boolean[length];
            int length2 = objArr.length;
            for (int i = 0; i != ids.length; i++) {
                Object obj = ids[i];
                if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) >= 0 && intValue < this.args.length && !zArr[intValue]) {
                    zArr[intValue] = true;
                    length2--;
                }
            }
            if (!z) {
                for (int i2 = 0; i2 < length; i2++) {
                    if (!zArr[i2] && super.has(i2, this)) {
                        zArr[i2] = true;
                        length2--;
                    }
                }
            }
            if (length2 != 0) {
                Object[] objArr2 = new Object[ids.length + length2];
                System.arraycopy(ids, 0, objArr2, length2, ids.length);
                int i3 = 0;
                for (int i4 = 0; i4 != this.args.length; i4++) {
                    if (!zArr[i4]) {
                        objArr2[i3] = Integer.valueOf(i4);
                        i3++;
                    }
                }
                if (i3 != length2) {
                    Kit.codeBug();
                }
                return objArr2;
            }
            return ids;
        }
        return ids;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject
    public ScriptableObject getOwnPropertyDescriptor(Context context, Object obj) {
        double number = ScriptRuntime.toNumber(obj);
        int i = (int) number;
        if (number != i) {
            return super.getOwnPropertyDescriptor(context, obj);
        }
        Object arg = arg(i);
        if (arg == NOT_FOUND) {
            return super.getOwnPropertyDescriptor(context, obj);
        }
        if (sharedWithActivation(i)) {
            arg = getFromActivation(i);
        }
        if (super.has(i, this)) {
            ScriptableObject ownPropertyDescriptor = super.getOwnPropertyDescriptor(context, obj);
            ownPropertyDescriptor.put("value", ownPropertyDescriptor, arg);
            return ownPropertyDescriptor;
        }
        Scriptable parentScope = getParentScope();
        if (parentScope == null) {
            parentScope = this;
        }
        return buildDataDescriptor(parentScope, arg, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.ScriptableObject
    public void defineOwnProperty(Context context, Object obj, ScriptableObject scriptableObject, boolean z) {
        super.defineOwnProperty(context, obj, scriptableObject, z);
        double number = ScriptRuntime.toNumber(obj);
        int i = (int) number;
        if (number == i && arg(i) != NOT_FOUND) {
            if (isAccessorDescriptor(scriptableObject)) {
                removeArg(i);
                return;
            }
            Object property = getProperty(scriptableObject, "value");
            if (property == NOT_FOUND) {
                return;
            }
            replaceArg(i, property);
            if (isFalse(getProperty(scriptableObject, "writable"))) {
                removeArg(i);
            }
        }
    }
}
