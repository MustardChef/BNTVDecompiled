package org.mozilla.javascript;

/* loaded from: classes5.dex */
public class IdFunctionObject extends BaseFunction {
    static final long serialVersionUID = -5332312783643935019L;
    private int arity;
    private String functionName;
    private final IdFunctionCall idcall;
    private final int methodId;
    private final Object tag;
    private boolean useCallAsConstructor;

    public IdFunctionObject(IdFunctionCall idFunctionCall, Object obj, int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        this.idcall = idFunctionCall;
        this.tag = obj;
        this.methodId = i;
        this.arity = i2;
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
    }

    public IdFunctionObject(IdFunctionCall idFunctionCall, Object obj, int i, String str, int i2, Scriptable scriptable) {
        super(scriptable, null);
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.idcall = idFunctionCall;
        this.tag = obj;
        this.methodId = i;
        this.arity = i2;
        this.functionName = str;
    }

    public void initFunction(String str, Scriptable scriptable) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (scriptable == null) {
            throw new IllegalArgumentException();
        }
        this.functionName = str;
        setParentScope(scriptable);
    }

    public final boolean hasTag(Object obj) {
        return obj == null ? this.tag == null : obj.equals(this.tag);
    }

    public final int methodId() {
        return this.methodId;
    }

    public final void markAsConstructor(Scriptable scriptable) {
        this.useCallAsConstructor = true;
        setImmunePrototypeProperty(scriptable);
    }

    public final void addAsProperty(Scriptable scriptable) {
        ScriptableObject.defineProperty(scriptable, this.functionName, this, 2);
    }

    public void exportAsScopeProperty() {
        addAsProperty(getParentScope());
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Scriptable getPrototype() {
        Scriptable prototype = super.getPrototype();
        if (prototype == null) {
            Scriptable functionPrototype = getFunctionPrototype(getParentScope());
            setPrototype(functionPrototype);
            return functionPrototype;
        }
        return prototype;
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return this.idcall.execIdCall(this, context, scriptable, scriptable2, objArr);
    }

    @Override // org.mozilla.javascript.BaseFunction
    public Scriptable createObject(Context context, Scriptable scriptable) {
        if (this.useCallAsConstructor) {
            return null;
        }
        throw ScriptRuntime.typeError1("msg.not.ctor", this.functionName);
    }

    @Override // org.mozilla.javascript.BaseFunction
    String decompile(int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = (i2 & 1) != 0;
        if (!z) {
            stringBuffer.append("function ");
            stringBuffer.append(getFunctionName());
            stringBuffer.append("() { ");
        }
        stringBuffer.append("[native code for ");
        IdFunctionCall idFunctionCall = this.idcall;
        if (idFunctionCall instanceof Scriptable) {
            stringBuffer.append(((Scriptable) idFunctionCall).getClassName());
            stringBuffer.append('.');
        }
        stringBuffer.append(getFunctionName());
        stringBuffer.append(", arity=");
        stringBuffer.append(getArity());
        stringBuffer.append(z ? "]\n" : "] }\n");
        return stringBuffer.toString();
    }

    @Override // org.mozilla.javascript.BaseFunction
    public int getArity() {
        return this.arity;
    }

    @Override // org.mozilla.javascript.BaseFunction
    public int getLength() {
        return getArity();
    }

    @Override // org.mozilla.javascript.BaseFunction
    public String getFunctionName() {
        String str = this.functionName;
        return str == null ? "" : str;
    }

    public final RuntimeException unknown() {
        return new IllegalArgumentException("BAD FUNCTION ID=" + this.methodId + " MASTER=" + this.idcall);
    }
}
