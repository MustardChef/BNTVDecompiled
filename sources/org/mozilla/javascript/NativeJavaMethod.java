package org.mozilla.javascript;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes5.dex */
public class NativeJavaMethod extends BaseFunction {
    private static final int PREFERENCE_AMBIGUOUS = 3;
    private static final int PREFERENCE_EQUAL = 0;
    private static final int PREFERENCE_FIRST_ARG = 1;
    private static final int PREFERENCE_SECOND_ARG = 2;
    private static final boolean debug = false;
    static final long serialVersionUID = -3440381785576412928L;
    private String functionName;
    MemberBox[] methods;
    private transient LinkedList<ResolvedOverload> overloadCache;

    private static void printDebug(String str, MemberBox memberBox, Object[] objArr) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeJavaMethod(MemberBox[] memberBoxArr) {
        this.functionName = memberBoxArr[0].getName();
        this.methods = memberBoxArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeJavaMethod(MemberBox[] memberBoxArr, String str) {
        this.functionName = str;
        this.methods = memberBoxArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeJavaMethod(MemberBox memberBox, String str) {
        this.functionName = str;
        this.methods = new MemberBox[]{memberBox};
    }

    public NativeJavaMethod(Method method, String str) {
        this(new MemberBox(method), str);
    }

    @Override // org.mozilla.javascript.BaseFunction
    public String getFunctionName() {
        return this.functionName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String scriptSignature(Object[] objArr) {
        String javaSignature;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i != objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                javaSignature = "null";
            } else if (obj instanceof Boolean) {
                javaSignature = TypedValues.Custom.S_BOOLEAN;
            } else if (obj instanceof String) {
                javaSignature = TypedValues.Custom.S_STRING;
            } else if (obj instanceof Number) {
                javaSignature = "number";
            } else if (obj instanceof Scriptable) {
                if (obj instanceof Undefined) {
                    javaSignature = "undefined";
                } else if (obj instanceof Wrapper) {
                    javaSignature = ((Wrapper) obj).unwrap().getClass().getName();
                } else {
                    javaSignature = obj instanceof Function ? "function" : "object";
                }
            } else {
                javaSignature = JavaMembers.javaSignature(obj.getClass());
            }
            if (i != 0) {
                stringBuffer.append(',');
            }
            stringBuffer.append(javaSignature);
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.BaseFunction
    public String decompile(int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = (i2 & 1) != 0;
        if (!z) {
            stringBuffer.append("function ");
            stringBuffer.append(getFunctionName());
            stringBuffer.append("() {");
        }
        stringBuffer.append("/*\n");
        stringBuffer.append(toString());
        stringBuffer.append(z ? "*/\n" : "*/}\n");
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        int length = this.methods.length;
        for (int i = 0; i != length; i++) {
            if (this.methods[i].isMethod()) {
                Method method = this.methods[i].method();
                stringBuffer.append(JavaMembers.javaSignature(method.getReturnType()));
                stringBuffer.append(' ');
                stringBuffer.append(method.getName());
            } else {
                stringBuffer.append(this.methods[i].getName());
            }
            stringBuffer.append(JavaMembers.liveConnectSignature(this.methods[i].argTypes));
            stringBuffer.append('\n');
        }
        return stringBuffer.toString();
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object[] objArr2;
        Object obj;
        Object obj2;
        if (this.methods.length == 0) {
            throw new RuntimeException("No methods defined for call");
        }
        int findCachedFunction = findCachedFunction(context, objArr);
        int i = 0;
        if (findCachedFunction < 0) {
            Class<?> declaringClass = this.methods[0].method().getDeclaringClass();
            throw Context.reportRuntimeError1("msg.java.no_such_method", declaringClass.getName() + '.' + getFunctionName() + '(' + scriptSignature(objArr) + ')');
        }
        MemberBox memberBox = this.methods[findCachedFunction];
        Class<?>[] clsArr = memberBox.argTypes;
        if (memberBox.vararg) {
            objArr2 = new Object[clsArr.length];
            for (int i2 = 0; i2 < clsArr.length - 1; i2++) {
                objArr2[i2] = Context.jsToJava(objArr[i2], clsArr[i2]);
            }
            if (objArr.length == clsArr.length && (objArr[objArr.length - 1] == null || (objArr[objArr.length - 1] instanceof NativeArray) || (objArr[objArr.length - 1] instanceof NativeJavaArray))) {
                obj2 = Context.jsToJava(objArr[objArr.length - 1], clsArr[clsArr.length - 1]);
            } else {
                Class<?> componentType = clsArr[clsArr.length - 1].getComponentType();
                Object newInstance = Array.newInstance(componentType, (objArr.length - clsArr.length) + 1);
                while (i < Array.getLength(newInstance)) {
                    Array.set(newInstance, i, Context.jsToJava(objArr[(clsArr.length - 1) + i], componentType));
                    i++;
                }
                obj2 = newInstance;
            }
            objArr2[clsArr.length - 1] = obj2;
        } else {
            objArr2 = objArr;
            while (i < objArr2.length) {
                Object obj3 = objArr2[i];
                Object jsToJava = Context.jsToJava(obj3, clsArr[i]);
                if (jsToJava != obj3) {
                    if (objArr == objArr2) {
                        objArr2 = (Object[]) objArr2.clone();
                    }
                    objArr2[i] = jsToJava;
                }
                i++;
            }
        }
        if (!memberBox.isStatic()) {
            Class<?> declaringClass2 = memberBox.getDeclaringClass();
            for (Scriptable scriptable3 = scriptable2; scriptable3 != null; scriptable3 = scriptable3.getPrototype()) {
                if (scriptable3 instanceof Wrapper) {
                    Object unwrap = ((Wrapper) scriptable3).unwrap();
                    if (declaringClass2.isInstance(unwrap)) {
                        obj = unwrap;
                    }
                }
            }
            throw Context.reportRuntimeError3("msg.nonjava.method", getFunctionName(), ScriptRuntime.toString(scriptable2), declaringClass2.getName());
        }
        obj = null;
        Object invoke = memberBox.invoke(obj, objArr2);
        Class<?> returnType = memberBox.method().getReturnType();
        Object wrap = context.getWrapFactory().wrap(context, scriptable, invoke, returnType);
        return (wrap == null && returnType == Void.TYPE) ? Undefined.instance : wrap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int findCachedFunction(Context context, Object[] objArr) {
        MemberBox[] memberBoxArr = this.methods;
        if (memberBoxArr.length > 1) {
            LinkedList<ResolvedOverload> linkedList = this.overloadCache;
            if (linkedList != null) {
                Iterator<ResolvedOverload> it = linkedList.iterator();
                while (it.hasNext()) {
                    ResolvedOverload next = it.next();
                    if (next.matches(objArr)) {
                        return next.index;
                    }
                }
            } else {
                this.overloadCache = new LinkedList<>();
            }
            int findFunction = findFunction(context, this.methods, objArr);
            if (this.overloadCache.size() < this.methods.length * 2) {
                synchronized (this.overloadCache) {
                    ResolvedOverload resolvedOverload = new ResolvedOverload(objArr, findFunction);
                    if (!this.overloadCache.contains(resolvedOverload)) {
                        this.overloadCache.addFirst(resolvedOverload);
                    }
                }
            }
            return findFunction;
        }
        return findFunction(context, memberBoxArr, objArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x009c, code lost:
        if ((r14.member().getModifiers() & r5) == 0) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int findFunction(org.mozilla.javascript.Context r17, org.mozilla.javascript.MemberBox[] r18, java.lang.Object[] r19) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeJavaMethod.findFunction(org.mozilla.javascript.Context, org.mozilla.javascript.MemberBox[], java.lang.Object[]):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0041, code lost:
        if (r4.isAssignableFrom(r3) != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int preferSignature(java.lang.Object[] r9, java.lang.Class<?>[] r10, boolean r11, java.lang.Class<?>[] r12, boolean r13) {
        /*
            r0 = 0
            r1 = 0
        L2:
            int r2 = r9.length
            if (r0 >= r2) goto L4c
            r2 = 1
            if (r11 == 0) goto L10
            int r3 = r10.length
            if (r0 < r3) goto L10
            int r3 = r10.length
            int r3 = r3 - r2
            r3 = r10[r3]
            goto L12
        L10:
            r3 = r10[r0]
        L12:
            if (r13 == 0) goto L1c
            int r4 = r12.length
            if (r0 < r4) goto L1c
            int r4 = r12.length
            int r4 = r4 - r2
            r4 = r12[r4]
            goto L1e
        L1c:
            r4 = r12[r0]
        L1e:
            if (r3 != r4) goto L21
            goto L49
        L21:
            r5 = r9[r0]
            int r6 = org.mozilla.javascript.NativeJavaObject.getConversionWeight(r5, r3)
            int r5 = org.mozilla.javascript.NativeJavaObject.getConversionWeight(r5, r4)
            r7 = 2
            r8 = 3
            if (r6 >= r5) goto L30
            goto L45
        L30:
            if (r6 <= r5) goto L34
        L32:
            r2 = 2
            goto L45
        L34:
            if (r6 != 0) goto L44
            boolean r5 = r3.isAssignableFrom(r4)
            if (r5 == 0) goto L3d
            goto L32
        L3d:
            boolean r3 = r4.isAssignableFrom(r3)
            if (r3 == 0) goto L44
            goto L45
        L44:
            r2 = 3
        L45:
            r1 = r1 | r2
            if (r1 != r8) goto L49
            goto L4c
        L49:
            int r0 = r0 + 1
            goto L2
        L4c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeJavaMethod.preferSignature(java.lang.Object[], java.lang.Class[], boolean, java.lang.Class[], boolean):int");
    }
}
