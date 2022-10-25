package org.mozilla.javascript;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class FunctionObject extends BaseFunction {
    public static final int JAVA_BOOLEAN_TYPE = 3;
    public static final int JAVA_DOUBLE_TYPE = 4;
    public static final int JAVA_INT_TYPE = 2;
    public static final int JAVA_OBJECT_TYPE = 6;
    public static final int JAVA_SCRIPTABLE_TYPE = 5;
    public static final int JAVA_STRING_TYPE = 1;
    public static final int JAVA_UNSUPPORTED_TYPE = 0;
    private static final short VARARGS_CTOR = -2;
    private static final short VARARGS_METHOD = -1;
    private static boolean sawSecurityException = false;
    static final long serialVersionUID = -5332312783643935019L;
    private String functionName;
    private transient boolean hasVoidReturn;
    private boolean isStatic;
    MemberBox member;
    private int parmsLength;
    private transient int returnTypeTag;
    private transient byte[] typeTags;

    public FunctionObject(String str, Member member, Scriptable scriptable) {
        if (member instanceof Constructor) {
            this.member = new MemberBox((Constructor) member);
            this.isStatic = true;
        } else {
            MemberBox memberBox = new MemberBox((Method) member);
            this.member = memberBox;
            this.isStatic = memberBox.isStatic();
        }
        String name = this.member.getName();
        this.functionName = str;
        Class<?>[] clsArr = this.member.argTypes;
        int length = clsArr.length;
        if (length == 4 && (clsArr[1].isArray() || clsArr[2].isArray())) {
            if (clsArr[1].isArray()) {
                if (!this.isStatic || clsArr[0] != ScriptRuntime.ContextClass || clsArr[1].getComponentType() != ScriptRuntime.ObjectClass || clsArr[2] != ScriptRuntime.FunctionClass || clsArr[3] != Boolean.TYPE) {
                    throw Context.reportRuntimeError1("msg.varargs.ctor", name);
                }
                this.parmsLength = -2;
            } else if (!this.isStatic || clsArr[0] != ScriptRuntime.ContextClass || clsArr[1] != ScriptRuntime.ScriptableClass || clsArr[2].getComponentType() != ScriptRuntime.ObjectClass || clsArr[3] != ScriptRuntime.FunctionClass) {
                throw Context.reportRuntimeError1("msg.varargs.fun", name);
            } else {
                this.parmsLength = -1;
            }
        } else {
            this.parmsLength = length;
            if (length > 0) {
                this.typeTags = new byte[length];
                for (int i = 0; i != length; i++) {
                    int typeTag = getTypeTag(clsArr[i]);
                    if (typeTag == 0) {
                        throw Context.reportRuntimeError2("msg.bad.parms", clsArr[i].getName(), name);
                    }
                    this.typeTags[i] = (byte) typeTag;
                }
            }
        }
        if (this.member.isMethod()) {
            Class<?> returnType = this.member.method().getReturnType();
            if (returnType == Void.TYPE) {
                this.hasVoidReturn = true;
            } else {
                this.returnTypeTag = getTypeTag(returnType);
            }
        } else {
            Class<?> declaringClass = this.member.getDeclaringClass();
            if (!ScriptRuntime.ScriptableClass.isAssignableFrom(declaringClass)) {
                throw Context.reportRuntimeError1("msg.bad.ctor.return", declaringClass.getName());
            }
        }
        ScriptRuntime.setFunctionProtoAndParent(this, scriptable);
    }

    public static int getTypeTag(Class<?> cls) {
        if (cls == ScriptRuntime.StringClass) {
            return 1;
        }
        if (cls == ScriptRuntime.IntegerClass || cls == Integer.TYPE) {
            return 2;
        }
        if (cls == ScriptRuntime.BooleanClass || cls == Boolean.TYPE) {
            return 3;
        }
        if (cls == ScriptRuntime.DoubleClass || cls == Double.TYPE) {
            return 4;
        }
        if (ScriptRuntime.ScriptableClass.isAssignableFrom(cls)) {
            return 5;
        }
        return cls == ScriptRuntime.ObjectClass ? 6 : 0;
    }

    public static Object convertArg(Context context, Scriptable scriptable, Object obj, int i) {
        switch (i) {
            case 1:
                return obj instanceof String ? obj : ScriptRuntime.toString(obj);
            case 2:
                return obj instanceof Integer ? obj : Integer.valueOf(ScriptRuntime.toInt32(obj));
            case 3:
                return obj instanceof Boolean ? obj : ScriptRuntime.toBoolean(obj) ? Boolean.TRUE : Boolean.FALSE;
            case 4:
                return obj instanceof Double ? obj : new Double(ScriptRuntime.toNumber(obj));
            case 5:
                return ScriptRuntime.toObjectOrNull(context, obj, scriptable);
            case 6:
                return obj;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override // org.mozilla.javascript.BaseFunction
    public int getArity() {
        int i = this.parmsLength;
        if (i < 0) {
            return 1;
        }
        return i;
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

    public Member getMethodOrConstructor() {
        if (this.member.isMethod()) {
            return this.member.method();
        }
        return this.member.ctor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Method findSingleMethod(Method[] methodArr, String str) {
        int length = methodArr.length;
        Method method = null;
        for (int i = 0; i != length; i++) {
            Method method2 = methodArr[i];
            if (method2 != null && str.equals(method2.getName())) {
                if (method != null) {
                    throw Context.reportRuntimeError2("msg.no.overload", str, method2.getDeclaringClass().getName());
                }
                method = method2;
            }
        }
        return method;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0010  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Method[] getMethodList(java.lang.Class<?> r6) {
        /*
            r0 = 0
            boolean r1 = org.mozilla.javascript.FunctionObject.sawSecurityException     // Catch: java.lang.SecurityException -> La
            if (r1 != 0) goto Ld
            java.lang.reflect.Method[] r1 = r6.getDeclaredMethods()     // Catch: java.lang.SecurityException -> La
            goto Le
        La:
            r1 = 1
            org.mozilla.javascript.FunctionObject.sawSecurityException = r1
        Ld:
            r1 = r0
        Le:
            if (r1 != 0) goto L14
            java.lang.reflect.Method[] r1 = r6.getMethods()
        L14:
            r2 = 0
            r3 = 0
            r4 = 0
        L17:
            int r5 = r1.length
            if (r3 >= r5) goto L3b
            boolean r5 = org.mozilla.javascript.FunctionObject.sawSecurityException
            if (r5 == 0) goto L27
            r5 = r1[r3]
            java.lang.Class r5 = r5.getDeclaringClass()
            if (r5 == r6) goto L36
            goto L33
        L27:
            r5 = r1[r3]
            int r5 = r5.getModifiers()
            boolean r5 = java.lang.reflect.Modifier.isPublic(r5)
            if (r5 != 0) goto L36
        L33:
            r1[r3] = r0
            goto L38
        L36:
            int r4 = r4 + 1
        L38:
            int r3 = r3 + 1
            goto L17
        L3b:
            java.lang.reflect.Method[] r6 = new java.lang.reflect.Method[r4]
            r0 = 0
        L3e:
            int r3 = r1.length
            if (r2 >= r3) goto L4f
            r3 = r1[r2]
            if (r3 == 0) goto L4c
            int r3 = r0 + 1
            r4 = r1[r2]
            r6[r0] = r4
            r0 = r3
        L4c:
            int r2 = r2 + 1
            goto L3e
        L4f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.FunctionObject.getMethodList(java.lang.Class):java.lang.reflect.Method[]");
    }

    public void addAsConstructor(Scriptable scriptable, Scriptable scriptable2) {
        initAsConstructor(scriptable, scriptable2);
        defineProperty(scriptable, scriptable2.getClassName(), this, 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initAsConstructor(Scriptable scriptable, Scriptable scriptable2) {
        ScriptRuntime.setFunctionProtoAndParent(this, scriptable);
        setImmunePrototypeProperty(scriptable2);
        scriptable2.setParentScope(this);
        defineProperty(scriptable2, "constructor", this, 7);
        setParentScope(scriptable);
    }

    public static Object convertArg(Context context, Scriptable scriptable, Object obj, Class<?> cls) {
        int typeTag = getTypeTag(cls);
        if (typeTag == 0) {
            throw Context.reportRuntimeError1("msg.cant.convert", cls.getName());
        }
        return convertArg(context, scriptable, obj, typeTag);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object call(org.mozilla.javascript.Context r9, org.mozilla.javascript.Scriptable r10, org.mozilla.javascript.Scriptable r11, java.lang.Object[] r12) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.FunctionObject.call(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.Object[]):java.lang.Object");
    }

    @Override // org.mozilla.javascript.BaseFunction
    public Scriptable createObject(Context context, Scriptable scriptable) {
        if (this.member.isCtor() || this.parmsLength == -2) {
            return null;
        }
        try {
            Scriptable scriptable2 = (Scriptable) this.member.getDeclaringClass().newInstance();
            scriptable2.setPrototype(getClassPrototype());
            scriptable2.setParentScope(getParentScope());
            return scriptable2;
        } catch (Exception e) {
            throw Context.throwAsScriptRuntimeEx(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isVarArgsMethod() {
        return this.parmsLength == -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isVarArgsConstructor() {
        return this.parmsLength == -2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        if (this.parmsLength > 0) {
            Class<?>[] clsArr = this.member.argTypes;
            this.typeTags = new byte[this.parmsLength];
            for (int i = 0; i != this.parmsLength; i++) {
                this.typeTags[i] = (byte) getTypeTag(clsArr[i]);
            }
        }
        if (this.member.isMethod()) {
            Class<?> returnType = this.member.method().getReturnType();
            if (returnType == Void.TYPE) {
                this.hasVoidReturn = true;
            } else {
                this.returnTypeTag = getTypeTag(returnType);
            }
        }
    }
}
