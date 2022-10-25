package org.mozilla.javascript;

import com.fasterxml.jackson.core.JsonPointer;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import org.mozilla.classfile.ClassFileWriter;
import org.mozilla.javascript.ObjToIntMap;

/* loaded from: classes5.dex */
public final class JavaAdapter implements IdFunctionCall {
    private static final Object FTAG = "JavaAdapter";
    private static final int Id_JavaAdapter = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class JavaAdapterSignature {
        Class<?>[] interfaces;
        ObjToIntMap names;
        Class<?> superClass;

        JavaAdapterSignature(Class<?> cls, Class<?>[] clsArr, ObjToIntMap objToIntMap) {
            this.superClass = cls;
            this.interfaces = clsArr;
            this.names = objToIntMap;
        }

        public boolean equals(Object obj) {
            if (obj instanceof JavaAdapterSignature) {
                JavaAdapterSignature javaAdapterSignature = (JavaAdapterSignature) obj;
                if (this.superClass != javaAdapterSignature.superClass) {
                    return false;
                }
                Class<?>[] clsArr = this.interfaces;
                Class<?>[] clsArr2 = javaAdapterSignature.interfaces;
                if (clsArr != clsArr2) {
                    if (clsArr.length == clsArr2.length) {
                        int i = 0;
                        while (true) {
                            Class<?>[] clsArr3 = this.interfaces;
                            if (i >= clsArr3.length) {
                                break;
                            } else if (clsArr3[i] != javaAdapterSignature.interfaces[i]) {
                                return false;
                            } else {
                                i++;
                            }
                        }
                    } else {
                        return false;
                    }
                }
                if (this.names.size() != javaAdapterSignature.names.size()) {
                    return false;
                }
                ObjToIntMap.Iterator iterator = new ObjToIntMap.Iterator(this.names);
                iterator.start();
                while (!iterator.done()) {
                    int value = iterator.getValue();
                    if (value != javaAdapterSignature.names.get((String) iterator.getKey(), value + 1)) {
                        return false;
                    }
                    iterator.next();
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.superClass.hashCode() + Arrays.hashCode(this.interfaces)) ^ this.names.size();
        }
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        IdFunctionObject idFunctionObject = new IdFunctionObject(new JavaAdapter(), FTAG, 1, "JavaAdapter", 1, scriptable);
        idFunctionObject.markAsConstructor(null);
        if (z) {
            idFunctionObject.sealObject();
        }
        idFunctionObject.exportAsScopeProperty();
    }

    @Override // org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (idFunctionObject.hasTag(FTAG) && idFunctionObject.methodId() == 1) {
            return js_createAdapter(context, scriptable, objArr);
        }
        throw idFunctionObject.unknown();
    }

    public static Object convertResult(Object obj, Class<?> cls) {
        if (obj != Undefined.instance || cls == ScriptRuntime.ObjectClass || cls == ScriptRuntime.StringClass) {
            return Context.jsToJava(obj, cls);
        }
        return null;
    }

    public static Scriptable createAdapterWrapper(Scriptable scriptable, Object obj) {
        NativeJavaObject nativeJavaObject = new NativeJavaObject(ScriptableObject.getTopLevelScope(scriptable), obj, null, true);
        nativeJavaObject.setPrototype(scriptable);
        return nativeJavaObject;
    }

    public static Object getAdapterSelf(Class<?> cls, Object obj) throws NoSuchFieldException, IllegalAccessException {
        return cls.getDeclaredField("self").get(obj);
    }

    static Object js_createAdapter(Context context, Scriptable scriptable, Object[] objArr) {
        Object newInstance;
        int length = objArr.length;
        if (length == 0) {
            throw ScriptRuntime.typeError0("msg.adapter.zero.args");
        }
        int i = 0;
        while (i < length - 1) {
            Object obj = objArr[i];
            if (obj instanceof NativeObject) {
                break;
            } else if (!(obj instanceof NativeJavaClass)) {
                throw ScriptRuntime.typeError2("msg.not.java.class.arg", String.valueOf(i), ScriptRuntime.toString(obj));
            } else {
                i++;
            }
        }
        Class<?> cls = null;
        Class[] clsArr = new Class[i];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Class<?> classObject = ((NativeJavaClass) objArr[i3]).getClassObject();
            if (classObject.isInterface()) {
                clsArr[i2] = classObject;
                i2++;
            } else if (cls != null) {
                throw ScriptRuntime.typeError2("msg.only.one.super", cls.getName(), classObject.getName());
            } else {
                cls = classObject;
            }
        }
        if (cls == null) {
            cls = ScriptRuntime.ObjectClass;
        }
        Class[] clsArr2 = new Class[i2];
        System.arraycopy(clsArr, 0, clsArr2, 0, i2);
        Scriptable ensureScriptable = ScriptableObject.ensureScriptable(objArr[i]);
        Class<?> adapterClass = getAdapterClass(scriptable, cls, clsArr2, ensureScriptable);
        int i4 = (length - i) - 1;
        try {
            if (i4 > 0) {
                Object[] objArr2 = new Object[i4 + 2];
                objArr2[0] = ensureScriptable;
                objArr2[1] = context.getFactory();
                System.arraycopy(objArr, i + 1, objArr2, 2, i4);
                NativeJavaMethod nativeJavaMethod = new NativeJavaClass(scriptable, adapterClass, true).members.ctors;
                int findCachedFunction = nativeJavaMethod.findCachedFunction(context, objArr2);
                if (findCachedFunction < 0) {
                    throw Context.reportRuntimeError2("msg.no.java.ctor", adapterClass.getName(), NativeJavaMethod.scriptSignature(objArr));
                }
                newInstance = NativeJavaClass.constructInternal(objArr2, nativeJavaMethod.methods[findCachedFunction]);
            } else {
                newInstance = adapterClass.getConstructor(ScriptRuntime.ScriptableClass, ScriptRuntime.ContextFactoryClass).newInstance(ensureScriptable, context.getFactory());
            }
            Object adapterSelf = getAdapterSelf(adapterClass, newInstance);
            if (adapterSelf instanceof Wrapper) {
                Object unwrap = ((Wrapper) adapterSelf).unwrap();
                if (unwrap instanceof Scriptable) {
                    if (unwrap instanceof ScriptableObject) {
                        ScriptRuntime.setObjectProtoAndParent((ScriptableObject) unwrap, scriptable);
                    }
                    return unwrap;
                }
            }
            return adapterSelf;
        } catch (Exception e) {
            throw Context.throwAsScriptRuntimeEx(e);
        }
    }

    public static void writeAdapterObject(Object obj, ObjectOutputStream objectOutputStream) throws IOException {
        Class<?> cls = obj.getClass();
        objectOutputStream.writeObject(cls.getSuperclass().getName());
        Class<?>[] interfaces = cls.getInterfaces();
        String[] strArr = new String[interfaces.length];
        for (int i = 0; i < interfaces.length; i++) {
            strArr[i] = interfaces[i].getName();
        }
        objectOutputStream.writeObject(strArr);
        try {
            objectOutputStream.writeObject(cls.getField("delegee").get(obj));
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            throw new IOException();
        }
    }

    public static Object readAdapterObject(Scriptable scriptable, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Context currentContext = Context.getCurrentContext();
        ContextFactory factory = currentContext != null ? currentContext.getFactory() : null;
        Class<?> cls = Class.forName((String) objectInputStream.readObject());
        String[] strArr = (String[]) objectInputStream.readObject();
        Class[] clsArr = new Class[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            clsArr[i] = Class.forName(strArr[i]);
        }
        Scriptable scriptable2 = (Scriptable) objectInputStream.readObject();
        try {
            return getAdapterClass(scriptable, cls, clsArr, scriptable2).getConstructor(ScriptRuntime.ContextFactoryClass, ScriptRuntime.ScriptableClass, ScriptRuntime.ScriptableClass).newInstance(factory, scriptable2, scriptable);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            throw new ClassNotFoundException("adapter");
        }
    }

    private static ObjToIntMap getObjectFunctionNames(Scriptable scriptable) {
        Object[] propertyIds = ScriptableObject.getPropertyIds(scriptable);
        ObjToIntMap objToIntMap = new ObjToIntMap(propertyIds.length);
        for (int i = 0; i != propertyIds.length; i++) {
            if (propertyIds[i] instanceof String) {
                String str = (String) propertyIds[i];
                Object property = ScriptableObject.getProperty(scriptable, str);
                if (property instanceof Function) {
                    int int32 = ScriptRuntime.toInt32(ScriptableObject.getProperty((Function) property, SessionDescription.ATTR_LENGTH));
                    if (int32 < 0) {
                        int32 = 0;
                    }
                    objToIntMap.put(str, int32);
                }
            }
        }
        return objToIntMap;
    }

    private static Class<?> getAdapterClass(Scriptable scriptable, Class<?> cls, Class<?>[] clsArr, Scriptable scriptable2) {
        ClassCache classCache = ClassCache.get(scriptable);
        Map<JavaAdapterSignature, Class<?>> interfaceAdapterCacheMap = classCache.getInterfaceAdapterCacheMap();
        ObjToIntMap objectFunctionNames = getObjectFunctionNames(scriptable2);
        JavaAdapterSignature javaAdapterSignature = new JavaAdapterSignature(cls, clsArr, objectFunctionNames);
        Class<?> cls2 = interfaceAdapterCacheMap.get(javaAdapterSignature);
        if (cls2 == null) {
            String str = "adapter" + classCache.newClassSerialNumber();
            cls2 = loadAdapterClass(str, createAdapterCode(objectFunctionNames, str, cls, clsArr, null));
            if (classCache.isCachingEnabled()) {
                interfaceAdapterCacheMap.put(javaAdapterSignature, cls2);
            }
        }
        return cls2;
    }

    public static byte[] createAdapterCode(ObjToIntMap objToIntMap, String str, Class<?> cls, Class<?>[] clsArr, String str2) {
        Method[] methodArr;
        int i;
        Method[] methodArr2;
        ClassFileWriter classFileWriter = new ClassFileWriter(str, cls.getName(), "<adapter>");
        classFileWriter.addField("factory", "Lorg/mozilla/javascript/ContextFactory;", (short) 17);
        classFileWriter.addField("delegee", "Lorg/mozilla/javascript/Scriptable;", (short) 17);
        classFileWriter.addField("self", "Lorg/mozilla/javascript/Scriptable;", (short) 17);
        int length = clsArr == null ? 0 : clsArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (clsArr[i2] != null) {
                classFileWriter.addInterface(clsArr[i2].getName());
            }
        }
        String replace = cls.getName().replace('.', JsonPointer.SEPARATOR);
        for (Constructor<?> constructor : cls.getConstructors()) {
            generateCtor(classFileWriter, str, replace, constructor);
        }
        generateSerialCtor(classFileWriter, str, replace);
        if (str2 != null) {
            generateEmptyCtor(classFileWriter, str, replace, str2);
        }
        ObjToIntMap objToIntMap2 = new ObjToIntMap();
        ObjToIntMap objToIntMap3 = new ObjToIntMap();
        for (int i3 = 0; i3 < length; i3++) {
            Method[] methods = clsArr[i3].getMethods();
            int i4 = 0;
            while (i4 < methods.length) {
                Method method = methods[i4];
                int modifiers = method.getModifiers();
                if (!Modifier.isStatic(modifiers) && !Modifier.isFinal(modifiers)) {
                    String name = method.getName();
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (!objToIntMap.has(name)) {
                        try {
                            cls.getMethod(name, parameterTypes);
                        } catch (NoSuchMethodException unused) {
                        }
                    }
                    String str3 = name + getMethodSignature(method, parameterTypes);
                    if (!objToIntMap2.has(str3)) {
                        i = i4;
                        methodArr2 = methods;
                        generateMethod(classFileWriter, str, name, parameterTypes, method.getReturnType(), true);
                        objToIntMap2.put(str3, 0);
                        objToIntMap3.put(name, 0);
                        i4 = i + 1;
                        methods = methodArr2;
                    }
                }
                i = i4;
                methodArr2 = methods;
                i4 = i + 1;
                methods = methodArr2;
            }
        }
        int i5 = 0;
        for (Method[] overridableMethods = getOverridableMethods(cls); i5 < overridableMethods.length; overridableMethods = methodArr) {
            Method method2 = overridableMethods[i5];
            boolean isAbstract = Modifier.isAbstract(method2.getModifiers());
            String name2 = method2.getName();
            if (isAbstract || objToIntMap.has(name2)) {
                Class<?>[] parameterTypes2 = method2.getParameterTypes();
                String methodSignature = getMethodSignature(method2, parameterTypes2);
                String str4 = name2 + methodSignature;
                if (!objToIntMap2.has(str4)) {
                    methodArr = overridableMethods;
                    generateMethod(classFileWriter, str, name2, parameterTypes2, method2.getReturnType(), true);
                    objToIntMap2.put(str4, 0);
                    objToIntMap3.put(name2, 0);
                    if (!isAbstract) {
                        generateSuper(classFileWriter, str, replace, name2, methodSignature, parameterTypes2, method2.getReturnType());
                        i5++;
                    }
                    i5++;
                }
            }
            methodArr = overridableMethods;
            i5++;
        }
        ObjToIntMap.Iterator iterator = new ObjToIntMap.Iterator(objToIntMap);
        iterator.start();
        while (!iterator.done()) {
            String str5 = (String) iterator.getKey();
            if (!objToIntMap3.has(str5)) {
                int value = iterator.getValue();
                Class[] clsArr2 = new Class[value];
                for (int i6 = 0; i6 < value; i6++) {
                    clsArr2[i6] = ScriptRuntime.ObjectClass;
                }
                generateMethod(classFileWriter, str, str5, clsArr2, ScriptRuntime.ObjectClass, false);
            }
            iterator.next();
        }
        return classFileWriter.toByteArray();
    }

    static Method[] getOverridableMethods(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            appendOverridableMethods(cls2, arrayList, hashSet);
        }
        while (cls != null) {
            for (Class<?> cls3 : cls.getInterfaces()) {
                appendOverridableMethods(cls3, arrayList, hashSet);
            }
            cls = cls.getSuperclass();
        }
        return (Method[]) arrayList.toArray(new Method[arrayList.size()]);
    }

    private static void appendOverridableMethods(Class<?> cls, ArrayList<Method> arrayList, HashSet<String> hashSet) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            String str = declaredMethods[i].getName() + getMethodSignature(declaredMethods[i], declaredMethods[i].getParameterTypes());
            if (!hashSet.contains(str)) {
                int modifiers = declaredMethods[i].getModifiers();
                if (!Modifier.isStatic(modifiers)) {
                    if (Modifier.isFinal(modifiers)) {
                        hashSet.add(str);
                    } else if (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers)) {
                        arrayList.add(declaredMethods[i]);
                        hashSet.add(str);
                    }
                }
            }
        }
    }

    static Class<?> loadAdapterClass(String str, byte[] bArr) {
        ProtectionDomain scriptProtectionDomain;
        Class<?> staticSecurityDomainClass = SecurityController.getStaticSecurityDomainClass();
        if (staticSecurityDomainClass == CodeSource.class || staticSecurityDomainClass == ProtectionDomain.class) {
            scriptProtectionDomain = SecurityUtilities.getScriptProtectionDomain();
            if (scriptProtectionDomain == null) {
                scriptProtectionDomain = JavaAdapter.class.getProtectionDomain();
            }
            if (staticSecurityDomainClass == CodeSource.class) {
                if (scriptProtectionDomain != null) {
                    scriptProtectionDomain = scriptProtectionDomain.getCodeSource();
                }
            }
            GeneratedClassLoader createLoader = SecurityController.createLoader(null, scriptProtectionDomain);
            Class<?> defineClass = createLoader.defineClass(str, bArr);
            createLoader.linkClass(defineClass);
            return defineClass;
        }
        scriptProtectionDomain = null;
        GeneratedClassLoader createLoader2 = SecurityController.createLoader(null, scriptProtectionDomain);
        Class<?> defineClass2 = createLoader2.defineClass(str, bArr);
        createLoader2.linkClass(defineClass2);
        return defineClass2;
    }

    public static Function getFunction(Scriptable scriptable, String str) {
        Object property = ScriptableObject.getProperty(scriptable, str);
        if (property == Scriptable.NOT_FOUND) {
            return null;
        }
        if (!(property instanceof Function)) {
            throw ScriptRuntime.notFunctionError(property, str);
        }
        return (Function) property;
    }

    public static Object callMethod(ContextFactory contextFactory, final Scriptable scriptable, final Function function, final Object[] objArr, final long j) {
        if (function == null) {
            return Undefined.instance;
        }
        if (contextFactory == null) {
            contextFactory = ContextFactory.getGlobal();
        }
        final Scriptable parentScope = function.getParentScope();
        if (j == 0) {
            return Context.call(contextFactory, function, parentScope, scriptable, objArr);
        }
        Context currentContext = Context.getCurrentContext();
        if (currentContext != null) {
            return doCall(currentContext, parentScope, scriptable, function, objArr, j);
        }
        return contextFactory.call(new ContextAction() { // from class: org.mozilla.javascript.JavaAdapter.1
            @Override // org.mozilla.javascript.ContextAction
            public Object run(Context context) {
                return JavaAdapter.doCall(context, Scriptable.this, scriptable, function, objArr, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object doCall(Context context, Scriptable scriptable, Scriptable scriptable2, Function function, Object[] objArr, long j) {
        for (int i = 0; i != objArr.length; i++) {
            if (0 != ((1 << i) & j)) {
                Object obj = objArr[i];
                if (!(obj instanceof Scriptable)) {
                    objArr[i] = context.getWrapFactory().wrap(context, scriptable, obj, null);
                }
            }
        }
        return function.call(context, scriptable, scriptable2, objArr);
    }

    public static Scriptable runScript(final Script script) {
        return (Scriptable) ContextFactory.getGlobal().call(new ContextAction() { // from class: org.mozilla.javascript.JavaAdapter.2
            @Override // org.mozilla.javascript.ContextAction
            public Object run(Context context) {
                ScriptableObject global = ScriptRuntime.getGlobal(context);
                Script.this.exec(context, global);
                return global;
            }
        });
    }

    private static void generateCtor(ClassFileWriter classFileWriter, String str, String str2, Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        short s = 3;
        if (parameterTypes.length == 0) {
            classFileWriter.startMethod("<init>", "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/ContextFactory;)V", (short) 1);
            classFileWriter.add(42);
            classFileWriter.addInvoke(183, str2, "<init>", "()V");
        } else {
            StringBuilder sb = new StringBuilder("(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/ContextFactory;");
            int length = sb.length();
            for (Class<?> cls : parameterTypes) {
                appendTypeString(sb, cls);
            }
            sb.append(")V");
            classFileWriter.startMethod("<init>", sb.toString(), (short) 1);
            classFileWriter.add(42);
            for (Class<?> cls2 : parameterTypes) {
                s = (short) (s + generatePushParam(classFileWriter, s, cls2));
            }
            sb.delete(1, length);
            classFileWriter.addInvoke(183, str2, "<init>", sb.toString());
        }
        classFileWriter.add(42);
        classFileWriter.add(43);
        classFileWriter.add(181, str, "delegee", "Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.add(42);
        classFileWriter.add(44);
        classFileWriter.add(181, str, "factory", "Lorg/mozilla/javascript/ContextFactory;");
        classFileWriter.add(42);
        classFileWriter.add(43);
        classFileWriter.add(42);
        classFileWriter.addInvoke(184, "org/mozilla/javascript/JavaAdapter", "createAdapterWrapper", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.add(181, str, "self", "Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.add(177);
        classFileWriter.stopMethod(s);
    }

    private static void generateSerialCtor(ClassFileWriter classFileWriter, String str, String str2) {
        classFileWriter.startMethod("<init>", "(Lorg/mozilla/javascript/ContextFactory;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;)V", (short) 1);
        classFileWriter.add(42);
        classFileWriter.addInvoke(183, str2, "<init>", "()V");
        classFileWriter.add(42);
        classFileWriter.add(43);
        classFileWriter.add(181, str, "factory", "Lorg/mozilla/javascript/ContextFactory;");
        classFileWriter.add(42);
        classFileWriter.add(44);
        classFileWriter.add(181, str, "delegee", "Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.add(42);
        classFileWriter.add(45);
        classFileWriter.add(181, str, "self", "Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.add(177);
        classFileWriter.stopMethod((short) 4);
    }

    private static void generateEmptyCtor(ClassFileWriter classFileWriter, String str, String str2, String str3) {
        classFileWriter.startMethod("<init>", "()V", (short) 1);
        classFileWriter.add(42);
        classFileWriter.addInvoke(183, str2, "<init>", "()V");
        classFileWriter.add(42);
        classFileWriter.add(1);
        classFileWriter.add(181, str, "factory", "Lorg/mozilla/javascript/ContextFactory;");
        classFileWriter.add(187, str3);
        classFileWriter.add(89);
        classFileWriter.addInvoke(183, str3, "<init>", "()V");
        classFileWriter.addInvoke(184, "org/mozilla/javascript/JavaAdapter", "runScript", "(Lorg/mozilla/javascript/Script;)Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.add(76);
        classFileWriter.add(42);
        classFileWriter.add(43);
        classFileWriter.add(181, str, "delegee", "Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.add(42);
        classFileWriter.add(43);
        classFileWriter.add(42);
        classFileWriter.addInvoke(184, "org/mozilla/javascript/JavaAdapter", "createAdapterWrapper", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.add(181, str, "self", "Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.add(177);
        classFileWriter.stopMethod((short) 2);
    }

    static void generatePushWrappedArgs(ClassFileWriter classFileWriter, Class<?>[] clsArr, int i) {
        classFileWriter.addPush(i);
        classFileWriter.add(189, "java/lang/Object");
        int i2 = 1;
        for (int i3 = 0; i3 != clsArr.length; i3++) {
            classFileWriter.add(89);
            classFileWriter.addPush(i3);
            i2 += generateWrapArg(classFileWriter, i2, clsArr[i3]);
            classFileWriter.add(83);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0068, code lost:
        if (r9 != 's') goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int generateWrapArg(org.mozilla.classfile.ClassFileWriter r7, int r8, java.lang.Class<?> r9) {
        /*
            boolean r0 = r9.isPrimitive()
            r1 = 1
            if (r0 != 0) goto Le
            r9 = 25
            r7.add(r9, r8)
            goto L95
        Le:
            java.lang.Class r0 = java.lang.Boolean.TYPE
            java.lang.String r2 = "<init>"
            r3 = 183(0xb7, float:2.56E-43)
            r4 = 89
            r5 = 187(0xbb, float:2.62E-43)
            r6 = 21
            if (r9 != r0) goto L2d
            java.lang.String r9 = "java/lang/Boolean"
            r7.add(r5, r9)
            r7.add(r4)
            r7.add(r6, r8)
            java.lang.String r8 = "(Z)V"
            r7.addInvoke(r3, r9, r2, r8)
            goto L95
        L2d:
            java.lang.Class r0 = java.lang.Character.TYPE
            if (r9 != r0) goto L40
            r7.add(r6, r8)
            r8 = 184(0xb8, float:2.58E-43)
            java.lang.String r9 = "java/lang/String"
            java.lang.String r0 = "valueOf"
            java.lang.String r2 = "(C)Ljava/lang/String;"
            r7.addInvoke(r8, r9, r0, r2)
            goto L95
        L40:
            java.lang.String r0 = "java/lang/Double"
            r7.add(r5, r0)
            r7.add(r4)
            java.lang.String r9 = r9.getName()
            r4 = 0
            char r9 = r9.charAt(r4)
            r4 = 98
            r5 = 2
            if (r9 == r4) goto L88
            r4 = 100
            if (r9 == r4) goto L81
            r4 = 102(0x66, float:1.43E-43)
            if (r9 == r4) goto L76
            r4 = 105(0x69, float:1.47E-43)
            if (r9 == r4) goto L88
            r4 = 108(0x6c, float:1.51E-43)
            if (r9 == r4) goto L6b
            r4 = 115(0x73, float:1.61E-43)
            if (r9 == r4) goto L88
            goto L90
        L6b:
            r9 = 22
            r7.add(r9, r8)
            r8 = 138(0x8a, float:1.93E-43)
            r7.add(r8)
            goto L86
        L76:
            r9 = 23
            r7.add(r9, r8)
            r8 = 141(0x8d, float:1.98E-43)
            r7.add(r8)
            goto L90
        L81:
            r9 = 24
            r7.add(r9, r8)
        L86:
            r1 = 2
            goto L90
        L88:
            r7.add(r6, r8)
            r8 = 135(0x87, float:1.89E-43)
            r7.add(r8)
        L90:
            java.lang.String r8 = "(D)V"
            r7.addInvoke(r3, r0, r2, r8)
        L95:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.JavaAdapter.generateWrapArg(org.mozilla.classfile.ClassFileWriter, int, java.lang.Class):int");
    }

    static void generateReturnResult(ClassFileWriter classFileWriter, Class<?> cls, boolean z) {
        if (cls == Void.TYPE) {
            classFileWriter.add(87);
            classFileWriter.add(177);
        } else if (cls == Boolean.TYPE) {
            classFileWriter.addInvoke(184, "org/mozilla/javascript/Context", "toBoolean", "(Ljava/lang/Object;)Z");
            classFileWriter.add(172);
        } else if (cls == Character.TYPE) {
            classFileWriter.addInvoke(184, "org/mozilla/javascript/Context", "toString", "(Ljava/lang/Object;)Ljava/lang/String;");
            classFileWriter.add(3);
            classFileWriter.addInvoke(182, "java/lang/String", "charAt", "(I)C");
            classFileWriter.add(172);
        } else if (cls.isPrimitive()) {
            classFileWriter.addInvoke(184, "org/mozilla/javascript/Context", "toNumber", "(Ljava/lang/Object;)D");
            char charAt = cls.getName().charAt(0);
            if (charAt != 'b') {
                if (charAt == 'd') {
                    classFileWriter.add(175);
                    return;
                } else if (charAt == 'f') {
                    classFileWriter.add(144);
                    classFileWriter.add(174);
                    return;
                } else if (charAt != 'i') {
                    if (charAt == 'l') {
                        classFileWriter.add(143);
                        classFileWriter.add(173);
                        return;
                    } else if (charAt != 's') {
                        throw new RuntimeException("Unexpected return type " + cls.toString());
                    }
                }
            }
            classFileWriter.add(142);
            classFileWriter.add(172);
        } else {
            String name = cls.getName();
            if (z) {
                classFileWriter.addLoadConstant(name);
                classFileWriter.addInvoke(184, "java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;");
                classFileWriter.addInvoke(184, "org/mozilla/javascript/JavaAdapter", "convertResult", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;");
            }
            classFileWriter.add(192, name);
            classFileWriter.add(176);
        }
    }

    private static void generateMethod(ClassFileWriter classFileWriter, String str, String str2, Class<?>[] clsArr, Class<?> cls, boolean z) {
        StringBuilder sb = new StringBuilder();
        int appendMethodSignature = appendMethodSignature(clsArr, cls, sb);
        classFileWriter.startMethod(str2, sb.toString(), (short) 1);
        classFileWriter.add(42);
        classFileWriter.add(180, str, "factory", "Lorg/mozilla/javascript/ContextFactory;");
        classFileWriter.add(42);
        classFileWriter.add(180, str, "self", "Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.add(42);
        classFileWriter.add(180, str, "delegee", "Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.addPush(str2);
        classFileWriter.addInvoke(184, "org/mozilla/javascript/JavaAdapter", "getFunction", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Lorg/mozilla/javascript/Function;");
        generatePushWrappedArgs(classFileWriter, clsArr, clsArr.length);
        if (clsArr.length > 64) {
            throw Context.reportRuntimeError0("JavaAdapter can not subclass methods with more then 64 arguments.");
        }
        long j = 0;
        for (int i = 0; i != clsArr.length; i++) {
            if (!clsArr[i].isPrimitive()) {
                j |= 1 << i;
            }
        }
        classFileWriter.addPush(j);
        classFileWriter.addInvoke(184, "org/mozilla/javascript/JavaAdapter", "callMethod", "(Lorg/mozilla/javascript/ContextFactory;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Function;[Ljava/lang/Object;J)Ljava/lang/Object;");
        generateReturnResult(classFileWriter, cls, z);
        classFileWriter.stopMethod((short) appendMethodSignature);
    }

    private static int generatePushParam(ClassFileWriter classFileWriter, int i, Class<?> cls) {
        if (!cls.isPrimitive()) {
            classFileWriter.addALoad(i);
            return 1;
        }
        char charAt = cls.getName().charAt(0);
        if (charAt != 'f') {
            if (charAt != 'i') {
                if (charAt == 'l') {
                    classFileWriter.addLLoad(i);
                    return 2;
                } else if (charAt != 's' && charAt != 'z') {
                    switch (charAt) {
                        case 'b':
                        case 'c':
                            break;
                        case 'd':
                            classFileWriter.addDLoad(i);
                            return 2;
                        default:
                            throw Kit.codeBug();
                    }
                }
            }
            classFileWriter.addILoad(i);
            return 1;
        }
        classFileWriter.addFLoad(i);
        return 1;
    }

    private static void generatePopResult(ClassFileWriter classFileWriter, Class<?> cls) {
        if (cls.isPrimitive()) {
            char charAt = cls.getName().charAt(0);
            if (charAt != 'f') {
                if (charAt != 'i') {
                    if (charAt == 'l') {
                        classFileWriter.add(173);
                        return;
                    } else if (charAt != 's' && charAt != 'z') {
                        switch (charAt) {
                            case 'b':
                            case 'c':
                                break;
                            case 'd':
                                classFileWriter.add(175);
                                return;
                            default:
                                return;
                        }
                    }
                }
                classFileWriter.add(172);
                return;
            }
            classFileWriter.add(174);
            return;
        }
        classFileWriter.add(176);
    }

    private static void generateSuper(ClassFileWriter classFileWriter, String str, String str2, String str3, String str4, Class<?>[] clsArr, Class<?> cls) {
        classFileWriter.startMethod("super$" + str3, str4, (short) 1);
        classFileWriter.add(25, 0);
        int i = 1;
        for (Class<?> cls2 : clsArr) {
            i += generatePushParam(classFileWriter, i, cls2);
        }
        classFileWriter.addInvoke(183, str2, str3, str4);
        if (!cls.equals(Void.TYPE)) {
            generatePopResult(classFileWriter, cls);
        } else {
            classFileWriter.add(177);
        }
        classFileWriter.stopMethod((short) (i + 1));
    }

    private static String getMethodSignature(Method method, Class<?>[] clsArr) {
        StringBuilder sb = new StringBuilder();
        appendMethodSignature(clsArr, method.getReturnType(), sb);
        return sb.toString();
    }

    static int appendMethodSignature(Class<?>[] clsArr, Class<?> cls, StringBuilder sb) {
        sb.append('(');
        int length = clsArr.length + 1;
        for (Class<?> cls2 : clsArr) {
            appendTypeString(sb, cls2);
            if (cls2 == Long.TYPE || cls2 == Double.TYPE) {
                length++;
            }
        }
        sb.append(')');
        appendTypeString(sb, cls);
        return length;
    }

    private static StringBuilder appendTypeString(StringBuilder sb, Class<?> cls) {
        char upperCase;
        while (cls.isArray()) {
            sb.append('[');
            cls = cls.getComponentType();
        }
        if (cls.isPrimitive()) {
            if (cls == Boolean.TYPE) {
                upperCase = 'Z';
            } else {
                upperCase = cls == Long.TYPE ? 'J' : Character.toUpperCase(cls.getName().charAt(0));
            }
            sb.append(upperCase);
        } else {
            sb.append('L');
            sb.append(cls.getName().replace('.', JsonPointer.SEPARATOR));
            sb.append(';');
        }
        return sb;
    }

    static int[] getArgsToConvert(Class<?>[] clsArr) {
        int i = 0;
        for (int i2 = 0; i2 != clsArr.length; i2++) {
            if (!clsArr[i2].isPrimitive()) {
                i++;
            }
        }
        if (i == 0) {
            return null;
        }
        int[] iArr = new int[i];
        int i3 = 0;
        for (int i4 = 0; i4 != clsArr.length; i4++) {
            if (!clsArr[i4].isPrimitive()) {
                iArr[i3] = i4;
                i3++;
            }
        }
        return iArr;
    }
}
