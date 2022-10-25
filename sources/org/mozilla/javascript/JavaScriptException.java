package org.mozilla.javascript;

/* loaded from: classes5.dex */
public class JavaScriptException extends RhinoException {
    static final long serialVersionUID = -7666130513694669293L;
    private Object value;

    public JavaScriptException(Object obj) {
        this(obj, "", 0);
    }

    public JavaScriptException(Object obj, String str, int i) {
        recordErrorOrigin(str, i, null, 0);
        this.value = obj;
        if ((obj instanceof NativeError) && Context.getContext().hasFeature(10)) {
            NativeError nativeError = (NativeError) obj;
            if (!nativeError.has("fileName", nativeError)) {
                nativeError.put("fileName", nativeError, str);
            }
            if (!nativeError.has("lineNumber", nativeError)) {
                nativeError.put("lineNumber", nativeError, Integer.valueOf(i));
            }
            nativeError.setStackProvider(this);
        }
    }

    @Override // org.mozilla.javascript.RhinoException
    public String details() {
        Object obj = this.value;
        if (obj == null) {
            return "null";
        }
        if (obj instanceof NativeError) {
            return obj.toString();
        }
        try {
            return ScriptRuntime.toString(obj);
        } catch (RuntimeException unused) {
            Object obj2 = this.value;
            if (obj2 instanceof Scriptable) {
                return ScriptRuntime.defaultObjectToString((Scriptable) obj2);
            }
            return obj2.toString();
        }
    }

    public Object getValue() {
        return this.value;
    }

    public String getSourceName() {
        return sourceName();
    }

    public int getLineNumber() {
        return lineNumber();
    }
}
