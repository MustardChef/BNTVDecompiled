package org.mozilla.javascript;

/* loaded from: classes5.dex */
public final class NativeGenerator extends IdScriptableObject {
    public static final int GENERATOR_CLOSE = 2;
    public static final int GENERATOR_SEND = 0;
    private static final Object GENERATOR_TAG = "Generator";
    public static final int GENERATOR_THROW = 1;
    private static final int Id___iterator__ = 5;
    private static final int Id_close = 1;
    private static final int Id_next = 2;
    private static final int Id_send = 3;
    private static final int Id_throw = 4;
    private static final int MAX_PROTOTYPE_ID = 5;
    private static final long serialVersionUID = 1645892441041347273L;
    private boolean firstTime = true;
    private NativeFunction function;
    private int lineNumber;
    private String lineSource;
    private boolean locked;
    private Object savedState;

    /* loaded from: classes5.dex */
    public static class GeneratorClosedException extends RuntimeException {
        private static final long serialVersionUID = 2561315658662379681L;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Generator";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NativeGenerator init(ScriptableObject scriptableObject, boolean z) {
        NativeGenerator nativeGenerator = new NativeGenerator();
        if (scriptableObject != null) {
            nativeGenerator.setParentScope(scriptableObject);
            nativeGenerator.setPrototype(getObjectPrototype(scriptableObject));
        }
        nativeGenerator.activatePrototypeMap(5);
        if (z) {
            nativeGenerator.sealObject();
        }
        if (scriptableObject != null) {
            scriptableObject.associateValue(GENERATOR_TAG, nativeGenerator);
        }
        return nativeGenerator;
    }

    private NativeGenerator() {
    }

    public NativeGenerator(Scriptable scriptable, NativeFunction nativeFunction, Object obj) {
        this.function = nativeFunction;
        this.savedState = obj;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        setParentScope(topLevelScope);
        setPrototype((NativeGenerator) ScriptableObject.getTopScopeValue(topLevelScope, GENERATOR_TAG));
    }

    /* loaded from: classes5.dex */
    private static class CloseGeneratorAction implements ContextAction {
        private NativeGenerator generator;

        CloseGeneratorAction(NativeGenerator nativeGenerator) {
            this.generator = nativeGenerator;
        }

        @Override // org.mozilla.javascript.ContextAction
        public Object run(Context context) {
            return ScriptRuntime.doTopCall(new Callable() { // from class: org.mozilla.javascript.NativeGenerator.CloseGeneratorAction.1
                @Override // org.mozilla.javascript.Callable
                public Object call(Context context2, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
                    return ((NativeGenerator) scriptable2).resume(context2, scriptable, 2, new GeneratorClosedException());
                }
            }, context, ScriptableObject.getTopLevelScope(this.generator), this.generator, null);
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 1;
        if (i == 1) {
            str = "close";
        } else if (i != 2) {
            if (i == 3) {
                str2 = "send";
            } else if (i == 4) {
                str2 = "throw";
            } else if (i != 5) {
                throw new IllegalArgumentException(String.valueOf(i));
            } else {
                str = NativeIterator.ITERATOR_PROPERTY_NAME;
            }
            str = str2;
            i2 = 0;
        } else {
            str = "next";
        }
        initPrototypeMethod(GENERATOR_TAG, i, str, i2);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(GENERATOR_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        if (!(scriptable2 instanceof NativeGenerator)) {
            throw incompatibleCallError(idFunctionObject);
        }
        NativeGenerator nativeGenerator = (NativeGenerator) scriptable2;
        if (methodId != 1) {
            if (methodId == 2) {
                nativeGenerator.firstTime = false;
                return nativeGenerator.resume(context, scriptable, 0, Undefined.instance);
            } else if (methodId != 3) {
                if (methodId == 4) {
                    return nativeGenerator.resume(context, scriptable, 1, objArr.length > 0 ? objArr[0] : Undefined.instance);
                } else if (methodId == 5) {
                    return scriptable2;
                } else {
                    throw new IllegalArgumentException(String.valueOf(methodId));
                }
            } else {
                Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
                if (nativeGenerator.firstTime && !obj.equals(Undefined.instance)) {
                    throw ScriptRuntime.typeError0("msg.send.newborn");
                }
                return nativeGenerator.resume(context, scriptable, 0, obj);
            }
        }
        return nativeGenerator.resume(context, scriptable, 2, new GeneratorClosedException());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object resume(Context context, Scriptable scriptable, int i, Object obj) {
        if (this.savedState == null) {
            if (i == 2) {
                return Undefined.instance;
            }
            if (i != 1) {
                obj = NativeIterator.getStopIterationObject(scriptable);
            }
            throw new JavaScriptException(obj, this.lineSource, this.lineNumber);
        }
        try {
            try {
                synchronized (this) {
                    if (this.locked) {
                        throw ScriptRuntime.typeError0("msg.already.exec.gen");
                    }
                    this.locked = true;
                }
                Object resumeGenerator = this.function.resumeGenerator(context, scriptable, i, this.savedState, obj);
                synchronized (this) {
                    this.locked = false;
                }
                if (i == 2) {
                    this.savedState = null;
                }
                return resumeGenerator;
            } catch (GeneratorClosedException unused) {
                Object obj2 = Undefined.instance;
                synchronized (this) {
                    this.locked = false;
                    if (i == 2) {
                        this.savedState = null;
                    }
                    return obj2;
                }
            } catch (RhinoException e) {
                this.lineNumber = e.lineNumber();
                this.lineSource = e.lineSource();
                this.savedState = null;
                throw e;
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.locked = false;
                if (i == 2) {
                    this.savedState = null;
                }
                throw th;
            }
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 5;
        if (length == 4) {
            char charAt = str.charAt(0);
            if (charAt == 'n') {
                i = 2;
                str2 = "next";
            } else {
                if (charAt == 's') {
                    i = 3;
                    str2 = "send";
                }
                str2 = null;
                i = 0;
            }
        } else if (length == 5) {
            char charAt2 = str.charAt(0);
            if (charAt2 == 'c') {
                i = 1;
                str2 = "close";
            } else {
                if (charAt2 == 't') {
                    str2 = "throw";
                    i = 4;
                }
                str2 = null;
                i = 0;
            }
        } else {
            if (length == 12) {
                str2 = NativeIterator.ITERATOR_PROPERTY_NAME;
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
