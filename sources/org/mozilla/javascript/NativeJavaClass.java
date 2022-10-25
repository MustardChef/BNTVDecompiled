package org.mozilla.javascript;

import java.lang.reflect.Array;
import java.util.Map;
import kotlin.text.Typography;

/* loaded from: classes5.dex */
public class NativeJavaClass extends NativeJavaObject implements Function {
    static final String javaClassPropertyName = "__javaObject__";
    static final long serialVersionUID = -6460763940409461664L;
    private Map<String, FieldAndMethods> staticFieldAndMethods;

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "JavaClass";
    }

    public NativeJavaClass() {
    }

    public NativeJavaClass(Scriptable scriptable, Class<?> cls) {
        this(scriptable, cls, false);
    }

    public NativeJavaClass(Scriptable scriptable, Class<?> cls, boolean z) {
        super(scriptable, cls, null, z);
    }

    @Override // org.mozilla.javascript.NativeJavaObject
    protected void initMembers() {
        Class cls = (Class) this.javaObject;
        this.members = JavaMembers.lookupClass(this.parent, cls, cls, this.isAdapter);
        this.staticFieldAndMethods = this.members.getFieldAndMethodsObjects(this, cls, true);
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        return this.members.has(str, true) || javaClassPropertyName.equals(str);
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        FieldAndMethods fieldAndMethods;
        if (str.equals("prototype")) {
            return null;
        }
        Map<String, FieldAndMethods> map = this.staticFieldAndMethods;
        if (map == null || (fieldAndMethods = map.get(str)) == null) {
            if (this.members.has(str, true)) {
                return this.members.get(this, str, this.javaObject, true);
            }
            Context context = Context.getContext();
            Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
            WrapFactory wrapFactory = context.getWrapFactory();
            if (javaClassPropertyName.equals(str)) {
                return wrapFactory.wrap(context, topLevelScope, this.javaObject, ScriptRuntime.ClassClass);
            }
            Class<?> findNestedClass = findNestedClass(getClassObject(), str);
            if (findNestedClass != null) {
                Scriptable wrapJavaClass = wrapFactory.wrapJavaClass(context, topLevelScope, findNestedClass);
                wrapJavaClass.setParentScope(this);
                return wrapJavaClass;
            }
            throw this.members.reportMemberNotFound(str);
        }
        return fieldAndMethods;
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        this.members.put(this, str, this.javaObject, obj, true);
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        return this.members.getIds(true);
    }

    public Class<?> getClassObject() {
        return (Class) super.unwrap();
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        if (cls == null || cls == ScriptRuntime.StringClass) {
            return toString();
        }
        if (cls == ScriptRuntime.BooleanClass) {
            return Boolean.TRUE;
        }
        return cls == ScriptRuntime.NumberClass ? ScriptRuntime.NaNobj : this;
    }

    @Override // org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (objArr.length == 1 && (objArr[0] instanceof Scriptable)) {
            Class<?> classObject = getClassObject();
            Scriptable scriptable3 = (Scriptable) objArr[0];
            do {
                if ((scriptable3 instanceof Wrapper) && classObject.isInstance(((Wrapper) scriptable3).unwrap())) {
                    return scriptable3;
                }
                scriptable3 = scriptable3.getPrototype();
            } while (scriptable3 != null);
            return construct(context, scriptable, objArr);
        }
        return construct(context, scriptable, objArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0086, code lost:
        if (r6 == null) goto L26;
     */
    @Override // org.mozilla.javascript.Function
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.mozilla.javascript.Scriptable construct(org.mozilla.javascript.Context r6, org.mozilla.javascript.Scriptable r7, java.lang.Object[] r8) {
        /*
            r5 = this;
            java.lang.Class r0 = r5.getClassObject()
            int r1 = r0.getModifiers()
            boolean r2 = java.lang.reflect.Modifier.isInterface(r1)
            if (r2 != 0) goto L36
            boolean r1 = java.lang.reflect.Modifier.isAbstract(r1)
            if (r1 != 0) goto L36
            org.mozilla.javascript.JavaMembers r1 = r5.members
            org.mozilla.javascript.NativeJavaMethod r1 = r1.ctors
            int r2 = r1.findCachedFunction(r6, r8)
            if (r2 < 0) goto L27
            org.mozilla.javascript.MemberBox[] r0 = r1.methods
            r0 = r0[r2]
            org.mozilla.javascript.Scriptable r6 = constructSpecific(r6, r7, r8, r0)
            return r6
        L27:
            java.lang.String r6 = org.mozilla.javascript.NativeJavaMethod.scriptSignature(r8)
            java.lang.String r7 = r0.getName()
            java.lang.String r8 = "msg.no.java.ctor"
            org.mozilla.javascript.EvaluatorException r6 = org.mozilla.javascript.Context.reportRuntimeError2(r8, r7, r6)
            throw r6
        L36:
            int r1 = r8.length
            if (r1 == 0) goto L96
            org.mozilla.javascript.Scriptable r1 = org.mozilla.javascript.ScriptableObject.getTopLevelScope(r5)
            java.lang.String r2 = "Dalvik"
            java.lang.String r3 = "java.vm.name"
            java.lang.String r3 = java.lang.System.getProperty(r3)     // Catch: java.lang.Exception -> L81
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> L81
            r3 = 0
            if (r2 == 0) goto L66
            boolean r2 = r0.isInterface()     // Catch: java.lang.Exception -> L81
            if (r2 == 0) goto L66
            r8 = r8[r3]     // Catch: java.lang.Exception -> L81
            org.mozilla.javascript.ScriptableObject r8 = org.mozilla.javascript.ScriptableObject.ensureScriptableObject(r8)     // Catch: java.lang.Exception -> L81
            java.lang.Object r8 = createInterfaceAdapter(r0, r8)     // Catch: java.lang.Exception -> L81
            org.mozilla.javascript.WrapFactory r1 = r6.getWrapFactory()     // Catch: java.lang.Exception -> L81
            r2 = 0
            org.mozilla.javascript.Scriptable r6 = r1.wrapAsJavaObject(r6, r7, r8, r2)     // Catch: java.lang.Exception -> L81
            return r6
        L66:
            java.lang.String r7 = "JavaAdapter"
            java.lang.Object r7 = r1.get(r7, r1)     // Catch: java.lang.Exception -> L81
            java.lang.Object r2 = org.mozilla.javascript.NativeJavaClass.NOT_FOUND     // Catch: java.lang.Exception -> L81
            if (r7 == r2) goto L89
            org.mozilla.javascript.Function r7 = (org.mozilla.javascript.Function) r7     // Catch: java.lang.Exception -> L81
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L81
            r2[r3] = r5     // Catch: java.lang.Exception -> L81
            r4 = 1
            r8 = r8[r3]     // Catch: java.lang.Exception -> L81
            r2[r4] = r8     // Catch: java.lang.Exception -> L81
            org.mozilla.javascript.Scriptable r6 = r7.construct(r6, r1, r2)     // Catch: java.lang.Exception -> L81
            return r6
        L81:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            if (r6 == 0) goto L89
            goto L8b
        L89:
            java.lang.String r6 = ""
        L8b:
            java.lang.String r7 = r0.getName()
            java.lang.String r8 = "msg.cant.instantiate"
            org.mozilla.javascript.EvaluatorException r6 = org.mozilla.javascript.Context.reportRuntimeError2(r8, r6, r7)
            throw r6
        L96:
            java.lang.String r6 = "msg.adapter.zero.args"
            org.mozilla.javascript.EvaluatorException r6 = org.mozilla.javascript.Context.reportRuntimeError0(r6)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeJavaClass.construct(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, java.lang.Object[]):org.mozilla.javascript.Scriptable");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Scriptable constructSpecific(Context context, Scriptable scriptable, Object[] objArr, MemberBox memberBox) {
        Object constructInternal = constructInternal(objArr, memberBox);
        return context.getWrapFactory().wrapNewObject(context, ScriptableObject.getTopLevelScope(scriptable), constructInternal);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object constructInternal(Object[] objArr, MemberBox memberBox) {
        Object[] objArr2;
        Object obj;
        Class<?>[] clsArr = memberBox.argTypes;
        int i = 0;
        if (memberBox.vararg) {
            objArr2 = new Object[clsArr.length];
            for (int i2 = 0; i2 < clsArr.length - 1; i2++) {
                objArr2[i2] = Context.jsToJava(objArr[i2], clsArr[i2]);
            }
            if (objArr.length == clsArr.length && (objArr[objArr.length - 1] == null || (objArr[objArr.length - 1] instanceof NativeArray) || (objArr[objArr.length - 1] instanceof NativeJavaArray))) {
                obj = Context.jsToJava(objArr[objArr.length - 1], clsArr[clsArr.length - 1]);
            } else {
                Class<?> componentType = clsArr[clsArr.length - 1].getComponentType();
                Object newInstance = Array.newInstance(componentType, (objArr.length - clsArr.length) + 1);
                while (i < Array.getLength(newInstance)) {
                    Array.set(newInstance, i, Context.jsToJava(objArr[(clsArr.length - 1) + i], componentType));
                    i++;
                }
                obj = newInstance;
            }
            objArr2[clsArr.length - 1] = obj;
        } else {
            objArr2 = objArr;
            while (i < objArr2.length) {
                Object obj2 = objArr2[i];
                Object jsToJava = Context.jsToJava(obj2, clsArr[i]);
                if (jsToJava != obj2) {
                    if (objArr2 == objArr) {
                        objArr2 = (Object[]) objArr.clone();
                    }
                    objArr2[i] = jsToJava;
                }
                i++;
            }
        }
        return memberBox.newInstance(objArr2);
    }

    public String toString() {
        return "[JavaClass " + getClassObject().getName() + "]";
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public boolean hasInstance(Scriptable scriptable) {
        if (!(scriptable instanceof Wrapper) || (scriptable instanceof NativeJavaClass)) {
            return false;
        }
        return getClassObject().isInstance(((Wrapper) scriptable).unwrap());
    }

    private static Class<?> findNestedClass(Class<?> cls, String str) {
        String str2 = cls.getName() + Typography.dollar + str;
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            return Kit.classOrNull(str2);
        }
        return Kit.classOrNull(classLoader, str2);
    }
}
