package org.mozilla.javascript;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.lang.reflect.Array;

/* loaded from: classes5.dex */
public class NativeJavaArray extends NativeJavaObject {
    static final long serialVersionUID = -924022554283675333L;
    Object array;
    Class<?> cls;
    int length;

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "JavaArray";
    }

    public static NativeJavaArray wrap(Scriptable scriptable, Object obj) {
        return new NativeJavaArray(scriptable, obj);
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Wrapper
    public Object unwrap() {
        return this.array;
    }

    public NativeJavaArray(Scriptable scriptable, Object obj) {
        super(scriptable, null, ScriptRuntime.ObjectClass);
        Class<?> cls = obj.getClass();
        if (!cls.isArray()) {
            throw new RuntimeException("Array expected");
        }
        this.array = obj;
        this.length = Array.getLength(obj);
        this.cls = cls.getComponentType();
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        return str.equals(SessionDescription.ATTR_LENGTH) || super.has(str, scriptable);
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        return i >= 0 && i < this.length;
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        if (str.equals(SessionDescription.ATTR_LENGTH)) {
            return Integer.valueOf(this.length);
        }
        Object obj = super.get(str, scriptable);
        if (obj != NOT_FOUND || ScriptableObject.hasProperty(getPrototype(), str)) {
            return obj;
        }
        throw Context.reportRuntimeError2("msg.java.member.not.found", this.array.getClass().getName(), str);
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        if (i >= 0 && i < this.length) {
            Context context = Context.getContext();
            return context.getWrapFactory().wrap(context, this, Array.get(this.array, i), this.cls);
        }
        return Undefined.instance;
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        if (!str.equals(SessionDescription.ATTR_LENGTH)) {
            throw Context.reportRuntimeError1("msg.java.array.member.not.found", str);
        }
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        if (i >= 0 && i < this.length) {
            Array.set(this.array, i, Context.jsToJava(obj, this.cls));
            return;
        }
        throw Context.reportRuntimeError2("msg.java.array.index.out.of.bounds", String.valueOf(i), String.valueOf(this.length - 1));
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        if (cls == null || cls == ScriptRuntime.StringClass) {
            return this.array.toString();
        }
        if (cls == ScriptRuntime.BooleanClass) {
            return Boolean.TRUE;
        }
        return cls == ScriptRuntime.NumberClass ? ScriptRuntime.NaNobj : this;
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        int i = this.length;
        Object[] objArr = new Object[i];
        while (true) {
            i--;
            if (i < 0) {
                return objArr;
            }
            objArr[i] = Integer.valueOf(i);
        }
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public boolean hasInstance(Scriptable scriptable) {
        if (scriptable instanceof Wrapper) {
            return this.cls.isInstance(((Wrapper) scriptable).unwrap());
        }
        return false;
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public Scriptable getPrototype() {
        if (this.prototype == null) {
            this.prototype = ScriptableObject.getArrayPrototype(getParentScope());
        }
        return this.prototype;
    }
}
