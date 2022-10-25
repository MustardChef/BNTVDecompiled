package org.mozilla.javascript;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.mozilla.javascript.TopLevel;
import org.mozilla.javascript.annotations.JSFunction;
import org.mozilla.javascript.annotations.JSGetter;
import org.mozilla.javascript.annotations.JSSetter;
import org.mozilla.javascript.annotations.JSStaticFunction;
import org.mozilla.javascript.debug.DebuggableObject;

/* loaded from: classes5.dex */
public abstract class ScriptableObject implements Scriptable, Serializable, DebuggableObject, ConstProperties {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CONST = 13;
    public static final int DONTENUM = 2;
    public static final int EMPTY = 0;
    private static final int INITIAL_SLOT_SIZE = 4;
    public static final int PERMANENT = 4;
    public static final int READONLY = 1;
    private static final int SLOT_CONVERT_ACCESSOR_TO_DATA = 5;
    private static final int SLOT_MODIFY = 2;
    private static final int SLOT_MODIFY_CONST = 3;
    private static final int SLOT_MODIFY_GETTER_SETTER = 4;
    private static final int SLOT_QUERY = 1;
    public static final int UNINITIALIZED_CONST = 8;
    static final long serialVersionUID = 2829861078851942586L;
    private volatile Map<Object, Object> associatedValues;
    private int count;
    private transient Slot firstAdded;
    private boolean isExtensible = true;
    private transient Slot lastAdded;
    private Scriptable parentScopeObject;
    private Scriptable prototypeObject;
    private transient Slot[] slots;

    private static int getSlotIndex(int i, int i2) {
        return (i - 1) & i2;
    }

    public boolean avoidObjectDetection() {
        return false;
    }

    @Override // org.mozilla.javascript.Scriptable
    public abstract String getClassName();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class Slot implements Serializable {
        private static final long serialVersionUID = -6090581677123995491L;
        private volatile short attributes;
        int indexOrHash;
        String name;
        transient Slot next;
        volatile transient Slot orderedNext;
        volatile Object value;
        volatile transient boolean wasDeleted;

        Slot(String str, int i, int i2) {
            this.name = str;
            this.indexOrHash = i;
            this.attributes = (short) i2;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            String str = this.name;
            if (str != null) {
                this.indexOrHash = str.hashCode();
            }
        }

        boolean setValue(Object obj, Scriptable scriptable, Scriptable scriptable2) {
            if ((this.attributes & 1) != 0) {
                return true;
            }
            if (scriptable == scriptable2) {
                this.value = obj;
                return true;
            }
            return false;
        }

        Object getValue(Scriptable scriptable) {
            return this.value;
        }

        int getAttributes() {
            return this.attributes;
        }

        synchronized void setAttributes(int i) {
            ScriptableObject.checkValidAttributes(i);
            this.attributes = (short) i;
        }

        void markDeleted() {
            this.wasDeleted = true;
            this.value = null;
            this.name = null;
        }

        ScriptableObject getPropertyDescriptor(Context context, Scriptable scriptable) {
            return ScriptableObject.buildDataDescriptor(scriptable, this.value, this.attributes);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ScriptableObject buildDataDescriptor(Scriptable scriptable, Object obj, int i) {
        NativeObject nativeObject = new NativeObject();
        ScriptRuntime.setBuiltinProtoAndParent(nativeObject, scriptable, TopLevel.Builtins.Object);
        nativeObject.defineProperty("value", obj, 0);
        nativeObject.defineProperty("writable", Boolean.valueOf((i & 1) == 0), 0);
        nativeObject.defineProperty("enumerable", Boolean.valueOf((i & 2) == 0), 0);
        nativeObject.defineProperty("configurable", Boolean.valueOf((i & 4) == 0), 0);
        return nativeObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class GetterSlot extends Slot {
        static final long serialVersionUID = -4900574849788797588L;
        Object getter;
        Object setter;

        GetterSlot(String str, int i, int i2) {
            super(str, i, i2);
        }

        @Override // org.mozilla.javascript.ScriptableObject.Slot
        ScriptableObject getPropertyDescriptor(Context context, Scriptable scriptable) {
            int attributes = getAttributes();
            NativeObject nativeObject = new NativeObject();
            ScriptRuntime.setBuiltinProtoAndParent(nativeObject, scriptable, TopLevel.Builtins.Object);
            nativeObject.defineProperty("enumerable", Boolean.valueOf((attributes & 2) == 0), 0);
            nativeObject.defineProperty("configurable", Boolean.valueOf((attributes & 4) == 0), 0);
            Object obj = this.getter;
            if (obj != null) {
                nativeObject.defineProperty("get", obj, 0);
            }
            Object obj2 = this.setter;
            if (obj2 != null) {
                nativeObject.defineProperty("set", obj2, 0);
            }
            return nativeObject;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.mozilla.javascript.ScriptableObject.Slot
        boolean setValue(Object obj, Scriptable scriptable, Scriptable scriptable2) {
            Object[] objArr;
            if (this.setter == null) {
                if (this.getter != null) {
                    if (Context.getContext().hasFeature(11)) {
                        throw ScriptRuntime.typeError1("msg.set.prop.no.setter", this.name);
                    }
                    return true;
                }
                return super.setValue(obj, scriptable, scriptable2);
            }
            Context context = Context.getContext();
            Object obj2 = this.setter;
            if (obj2 instanceof MemberBox) {
                MemberBox memberBox = (MemberBox) obj2;
                Class<?>[] clsArr = memberBox.argTypes;
                Object convertArg = FunctionObject.convertArg(context, scriptable2, obj, FunctionObject.getTypeTag(clsArr[clsArr.length - 1]));
                if (memberBox.delegateTo == null) {
                    objArr = new Object[]{convertArg};
                } else {
                    Object[] objArr2 = {scriptable2, convertArg};
                    scriptable2 = memberBox.delegateTo;
                    objArr = objArr2;
                }
                memberBox.invoke(scriptable2, objArr);
            } else if (obj2 instanceof Function) {
                Function function = (Function) obj2;
                function.call(context, function.getParentScope(), scriptable2, new Object[]{obj});
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.mozilla.javascript.ScriptableObject.Slot
        Object getValue(Scriptable scriptable) {
            Object[] objArr;
            Object obj = this.getter;
            if (obj != null) {
                if (obj instanceof MemberBox) {
                    MemberBox memberBox = (MemberBox) obj;
                    if (memberBox.delegateTo == null) {
                        objArr = ScriptRuntime.emptyArgs;
                    } else {
                        Object[] objArr2 = {scriptable};
                        scriptable = memberBox.delegateTo;
                        objArr = objArr2;
                    }
                    return memberBox.invoke(scriptable, objArr);
                } else if (obj instanceof Function) {
                    Function function = (Function) obj;
                    return function.call(Context.getContext(), function.getParentScope(), scriptable, ScriptRuntime.emptyArgs);
                }
            }
            Object obj2 = this.value;
            if (obj2 instanceof LazilyLoadedCtor) {
                LazilyLoadedCtor lazilyLoadedCtor = (LazilyLoadedCtor) obj2;
                try {
                    lazilyLoadedCtor.init();
                    return lazilyLoadedCtor.getValue();
                } finally {
                    this.value = lazilyLoadedCtor.getValue();
                }
            }
            return obj2;
        }

        @Override // org.mozilla.javascript.ScriptableObject.Slot
        void markDeleted() {
            super.markDeleted();
            this.getter = null;
            this.setter = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class RelinkedSlot extends Slot {
        final Slot slot;

        RelinkedSlot(Slot slot) {
            super(slot.name, slot.indexOrHash, slot.attributes);
            this.slot = ScriptableObject.unwrapSlot(slot);
        }

        @Override // org.mozilla.javascript.ScriptableObject.Slot
        boolean setValue(Object obj, Scriptable scriptable, Scriptable scriptable2) {
            return this.slot.setValue(obj, scriptable, scriptable2);
        }

        @Override // org.mozilla.javascript.ScriptableObject.Slot
        Object getValue(Scriptable scriptable) {
            return this.slot.getValue(scriptable);
        }

        @Override // org.mozilla.javascript.ScriptableObject.Slot
        ScriptableObject getPropertyDescriptor(Context context, Scriptable scriptable) {
            return this.slot.getPropertyDescriptor(context, scriptable);
        }

        @Override // org.mozilla.javascript.ScriptableObject.Slot
        int getAttributes() {
            return this.slot.getAttributes();
        }

        @Override // org.mozilla.javascript.ScriptableObject.Slot
        void setAttributes(int i) {
            this.slot.setAttributes(i);
        }

        @Override // org.mozilla.javascript.ScriptableObject.Slot
        void markDeleted() {
            super.markDeleted();
            this.slot.markDeleted();
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.slot);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkValidAttributes(int i) {
        if ((i & (-16)) != 0) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    public ScriptableObject() {
    }

    public ScriptableObject(Scriptable scriptable, Scriptable scriptable2) {
        if (scriptable == null) {
            throw new IllegalArgumentException();
        }
        this.parentScopeObject = scriptable;
        this.prototypeObject = scriptable2;
    }

    public String getTypeOf() {
        return avoidObjectDetection() ? "undefined" : "object";
    }

    @Override // org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        return getSlot(str, 0, 1) != null;
    }

    @Override // org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        return getSlot((String) null, i, 1) != null;
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        Slot slot = getSlot(str, 0, 1);
        if (slot == null) {
            return Scriptable.NOT_FOUND;
        }
        return slot.getValue(scriptable);
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        Slot slot = getSlot((String) null, i, 1);
        if (slot == null) {
            return Scriptable.NOT_FOUND;
        }
        return slot.getValue(scriptable);
    }

    @Override // org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        if (putImpl(str, 0, scriptable, obj)) {
            return;
        }
        if (scriptable == this) {
            throw Kit.codeBug();
        }
        scriptable.put(str, scriptable, obj);
    }

    @Override // org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        if (putImpl(null, i, scriptable, obj)) {
            return;
        }
        if (scriptable == this) {
            throw Kit.codeBug();
        }
        scriptable.put(i, scriptable, obj);
    }

    @Override // org.mozilla.javascript.Scriptable
    public void delete(String str) {
        checkNotSealed(str, 0);
        removeSlot(str, 0);
    }

    @Override // org.mozilla.javascript.Scriptable
    public void delete(int i) {
        checkNotSealed(null, i);
        removeSlot(null, i);
    }

    @Override // org.mozilla.javascript.ConstProperties
    public void putConst(String str, Scriptable scriptable, Object obj) {
        if (putConstImpl(str, 0, scriptable, obj, 1)) {
            return;
        }
        if (scriptable == this) {
            throw Kit.codeBug();
        }
        if (scriptable instanceof ConstProperties) {
            ((ConstProperties) scriptable).putConst(str, scriptable, obj);
        } else {
            scriptable.put(str, scriptable, obj);
        }
    }

    @Override // org.mozilla.javascript.ConstProperties
    public void defineConst(String str, Scriptable scriptable) {
        if (putConstImpl(str, 0, scriptable, Undefined.instance, 8)) {
            return;
        }
        if (scriptable == this) {
            throw Kit.codeBug();
        }
        if (scriptable instanceof ConstProperties) {
            ((ConstProperties) scriptable).defineConst(str, scriptable);
        }
    }

    @Override // org.mozilla.javascript.ConstProperties
    public boolean isConst(String str) {
        Slot slot = getSlot(str, 0, 1);
        return slot != null && (slot.getAttributes() & 5) == 5;
    }

    public final int getAttributes(String str, Scriptable scriptable) {
        return getAttributes(str);
    }

    public final int getAttributes(int i, Scriptable scriptable) {
        return getAttributes(i);
    }

    public final void setAttributes(String str, Scriptable scriptable, int i) {
        setAttributes(str, i);
    }

    public void setAttributes(int i, Scriptable scriptable, int i2) {
        setAttributes(i, i2);
    }

    public int getAttributes(String str) {
        return findAttributeSlot(str, 0, 1).getAttributes();
    }

    public int getAttributes(int i) {
        return findAttributeSlot(null, i, 1).getAttributes();
    }

    public void setAttributes(String str, int i) {
        checkNotSealed(str, 0);
        findAttributeSlot(str, 0, 2).setAttributes(i);
    }

    public void setAttributes(int i, int i2) {
        checkNotSealed(null, i);
        findAttributeSlot(null, i, 2).setAttributes(i2);
    }

    public void setGetterOrSetter(String str, int i, Callable callable, boolean z) {
        setGetterOrSetter(str, i, callable, z, false);
    }

    private void setGetterOrSetter(String str, int i, Callable callable, boolean z, boolean z2) {
        GetterSlot getterSlot;
        if (str != null && i != 0) {
            throw new IllegalArgumentException(str);
        }
        if (!z2) {
            checkNotSealed(str, i);
        }
        if (isExtensible()) {
            getterSlot = (GetterSlot) getSlot(str, i, 4);
        } else {
            Slot unwrapSlot = unwrapSlot(getSlot(str, i, 1));
            if (!(unwrapSlot instanceof GetterSlot)) {
                return;
            }
            getterSlot = (GetterSlot) unwrapSlot;
        }
        if (!z2 && (getterSlot.getAttributes() & 1) != 0) {
            throw Context.reportRuntimeError1("msg.modify.readonly", str);
        }
        if (z) {
            getterSlot.setter = callable;
        } else {
            getterSlot.getter = callable;
        }
        getterSlot.value = Undefined.instance;
    }

    public Object getGetterOrSetter(String str, int i, boolean z) {
        if (str != null && i != 0) {
            throw new IllegalArgumentException(str);
        }
        Slot unwrapSlot = unwrapSlot(getSlot(str, i, 1));
        if (unwrapSlot == null) {
            return null;
        }
        if (unwrapSlot instanceof GetterSlot) {
            GetterSlot getterSlot = (GetterSlot) unwrapSlot;
            Object obj = z ? getterSlot.setter : getterSlot.getter;
            return obj != null ? obj : Undefined.instance;
        }
        return Undefined.instance;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isGetterOrSetter(String str, int i, boolean z) {
        Slot unwrapSlot = unwrapSlot(getSlot(str, i, 1));
        if (unwrapSlot instanceof GetterSlot) {
            if (!z || ((GetterSlot) unwrapSlot).setter == null) {
                return (z || ((GetterSlot) unwrapSlot).getter == null) ? false : true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addLazilyInitializedValue(String str, int i, LazilyLoadedCtor lazilyLoadedCtor, int i2) {
        if (str != null && i != 0) {
            throw new IllegalArgumentException(str);
        }
        checkNotSealed(str, i);
        GetterSlot getterSlot = (GetterSlot) getSlot(str, i, 4);
        getterSlot.setAttributes(i2);
        getterSlot.getter = null;
        getterSlot.setter = null;
        getterSlot.value = lazilyLoadedCtor;
    }

    @Override // org.mozilla.javascript.Scriptable
    public Scriptable getPrototype() {
        return this.prototypeObject;
    }

    @Override // org.mozilla.javascript.Scriptable
    public void setPrototype(Scriptable scriptable) {
        this.prototypeObject = scriptable;
    }

    @Override // org.mozilla.javascript.Scriptable
    public Scriptable getParentScope() {
        return this.parentScopeObject;
    }

    @Override // org.mozilla.javascript.Scriptable
    public void setParentScope(Scriptable scriptable) {
        this.parentScopeObject = scriptable;
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        return getIds(false);
    }

    public Object[] getAllIds() {
        return getIds(true);
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        return getDefaultValue(this, cls);
    }

    public static Object getDefaultValue(Scriptable scriptable, Class<?> cls) {
        String str;
        String str2;
        Object[] objArr;
        Context context = null;
        int i = 0;
        while (true) {
            str = "undefined";
            if (i < 2) {
                boolean z = cls != ScriptRuntime.StringClass ? i == 1 : i == 0;
                if (z) {
                    objArr = ScriptRuntime.emptyArgs;
                    str2 = "toString";
                } else {
                    Object[] objArr2 = new Object[1];
                    if (cls != null) {
                        if (cls == ScriptRuntime.StringClass) {
                            str = TypedValues.Custom.S_STRING;
                        } else if (cls == ScriptRuntime.ScriptableClass) {
                            str = "object";
                        } else if (cls == ScriptRuntime.FunctionClass) {
                            str = "function";
                        } else if (cls == ScriptRuntime.BooleanClass || cls == Boolean.TYPE) {
                            str = TypedValues.Custom.S_BOOLEAN;
                        } else if (cls != ScriptRuntime.NumberClass && cls != ScriptRuntime.ByteClass && cls != Byte.TYPE && cls != ScriptRuntime.ShortClass && cls != Short.TYPE && cls != ScriptRuntime.IntegerClass && cls != Integer.TYPE && cls != ScriptRuntime.FloatClass && cls != Float.TYPE && cls != ScriptRuntime.DoubleClass && cls != Double.TYPE) {
                            throw Context.reportRuntimeError1("msg.invalid.type", cls.toString());
                        } else {
                            str = "number";
                        }
                    }
                    objArr2[0] = str;
                    str2 = "valueOf";
                    objArr = objArr2;
                }
                Object property = getProperty(scriptable, str2);
                if (property instanceof Function) {
                    Function function = (Function) property;
                    if (context == null) {
                        context = Context.getContext();
                    }
                    Object call = function.call(context, function.getParentScope(), scriptable, objArr);
                    if (call == null) {
                        continue;
                    } else if ((call instanceof Scriptable) && cls != ScriptRuntime.ScriptableClass && cls != ScriptRuntime.FunctionClass) {
                        if (z && (call instanceof Wrapper)) {
                            Object unwrap = ((Wrapper) call).unwrap();
                            if (unwrap instanceof String) {
                                return unwrap;
                            }
                        }
                    }
                }
                i++;
            } else {
                throw ScriptRuntime.typeError1("msg.default.value", cls != null ? cls.getName() : "undefined");
            }
        }
    }

    @Override // org.mozilla.javascript.Scriptable
    public boolean hasInstance(Scriptable scriptable) {
        return ScriptRuntime.jsDelegatesTo(scriptable, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object equivalentValues(Object obj) {
        return this == obj ? Boolean.TRUE : Scriptable.NOT_FOUND;
    }

    public static <T extends Scriptable> void defineClass(Scriptable scriptable, Class<T> cls) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        defineClass(scriptable, cls, false, false);
    }

    public static <T extends Scriptable> void defineClass(Scriptable scriptable, Class<T> cls, boolean z) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        defineClass(scriptable, cls, z, false);
    }

    public static <T extends Scriptable> String defineClass(Scriptable scriptable, Class<T> cls, boolean z, boolean z2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        BaseFunction buildClassCtor = buildClassCtor(scriptable, cls, z, z2);
        if (buildClassCtor == null) {
            return null;
        }
        String className = buildClassCtor.getClassPrototype().getClassName();
        defineProperty(scriptable, className, buildClassCtor, 2);
        return className;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0207, code lost:
        if (r4 == null) goto L94;
     */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02ac A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T extends org.mozilla.javascript.Scriptable> org.mozilla.javascript.BaseFunction buildClassCtor(org.mozilla.javascript.Scriptable r24, java.lang.Class<T> r25, boolean r26, boolean r27) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 748
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptableObject.buildClassCtor(org.mozilla.javascript.Scriptable, java.lang.Class, boolean, boolean):org.mozilla.javascript.BaseFunction");
    }

    private static Member findAnnotatedMember(AccessibleObject[] accessibleObjectArr, Class<? extends Annotation> cls) {
        for (AccessibleObject accessibleObject : accessibleObjectArr) {
            if (accessibleObject.isAnnotationPresent(cls)) {
                return (Member) accessibleObject;
            }
        }
        return null;
    }

    private static Method findSetterMethod(Method[] methodArr, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("set");
        sb.append(Character.toUpperCase(str.charAt(0)));
        sb.append(str.substring(1));
        String sb2 = sb.toString();
        for (Method method : methodArr) {
            JSSetter jSSetter = (JSSetter) method.getAnnotation(JSSetter.class);
            if (jSSetter != null && (str.equals(jSSetter.value()) || ("".equals(jSSetter.value()) && sb2.equals(method.getName())))) {
                return method;
            }
        }
        String str3 = str2 + str;
        for (Method method2 : methodArr) {
            if (str3.equals(method2.getName())) {
                return method2;
            }
        }
        return null;
    }

    private static String getPropertyName(String str, String str2, Annotation annotation) {
        if (str2 != null) {
            return str.substring(str2.length());
        }
        String str3 = null;
        if (annotation instanceof JSGetter) {
            str3 = ((JSGetter) annotation).value();
            if ((str3 == null || str3.length() == 0) && str.length() > 3 && str.startsWith("get")) {
                str3 = str.substring(3);
                if (Character.isUpperCase(str3.charAt(0))) {
                    if (str3.length() == 1) {
                        str3 = str3.toLowerCase();
                    } else if (!Character.isUpperCase(str3.charAt(1))) {
                        str3 = Character.toLowerCase(str3.charAt(0)) + str3.substring(1);
                    }
                }
            }
        } else if (annotation instanceof JSFunction) {
            str3 = ((JSFunction) annotation).value();
        } else if (annotation instanceof JSStaticFunction) {
            str3 = ((JSStaticFunction) annotation).value();
        }
        return (str3 == null || str3.length() == 0) ? str : str3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T extends Scriptable> Class<T> extendsScriptable(Class<?> cls) {
        if (ScriptRuntime.ScriptableClass.isAssignableFrom(cls)) {
            return cls;
        }
        return null;
    }

    public void defineProperty(String str, Object obj, int i) {
        checkNotSealed(str, 0);
        put(str, this, obj);
        setAttributes(str, i);
    }

    public static void defineProperty(Scriptable scriptable, String str, Object obj, int i) {
        if (!(scriptable instanceof ScriptableObject)) {
            scriptable.put(str, scriptable, obj);
        } else {
            ((ScriptableObject) scriptable).defineProperty(str, obj, i);
        }
    }

    public static void defineConstProperty(Scriptable scriptable, String str) {
        if (scriptable instanceof ConstProperties) {
            ((ConstProperties) scriptable).defineConst(str, scriptable);
        } else {
            defineProperty(scriptable, str, Undefined.instance, 13);
        }
    }

    public void defineProperty(String str, Class<?> cls, int i) {
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException();
        }
        char[] cArr = new char[length + 3];
        str.getChars(0, length, cArr, 3);
        cArr[3] = Character.toUpperCase(cArr[3]);
        cArr[0] = 'g';
        cArr[1] = 'e';
        cArr[2] = 't';
        String str2 = new String(cArr);
        cArr[0] = 's';
        String str3 = new String(cArr);
        Method[] methodList = FunctionObject.getMethodList(cls);
        Method findSingleMethod = FunctionObject.findSingleMethod(methodList, str2);
        Method findSingleMethod2 = FunctionObject.findSingleMethod(methodList, str3);
        if (findSingleMethod2 == null) {
            i |= 1;
        }
        int i2 = i;
        if (findSingleMethod2 == null) {
            findSingleMethod2 = null;
        }
        defineProperty(str, null, findSingleMethod, findSingleMethod2, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
        if (r5 == org.mozilla.javascript.ScriptRuntime.ScriptableObjectClass) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
        if (r4 != false) goto L49;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void defineProperty(java.lang.String r9, java.lang.Object r10, java.lang.reflect.Method r11, java.lang.reflect.Method r12, int r13) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            r2 = 1
            if (r11 == 0) goto L4d
            org.mozilla.javascript.MemberBox r3 = new org.mozilla.javascript.MemberBox
            r3.<init>(r11)
            int r4 = r11.getModifiers()
            boolean r4 = java.lang.reflect.Modifier.isStatic(r4)
            if (r4 != 0) goto L1c
            if (r10 == 0) goto L18
            r4 = 1
            goto L19
        L18:
            r4 = 0
        L19:
            r3.delegateTo = r10
            goto L21
        L1c:
            java.lang.Class r4 = java.lang.Void.TYPE
            r3.delegateTo = r4
            r4 = 1
        L21:
            java.lang.Class[] r5 = r11.getParameterTypes()
            int r6 = r5.length
            java.lang.String r7 = "msg.bad.getter.parms"
            if (r6 != 0) goto L31
            if (r4 == 0) goto L2f
            java.lang.String r7 = "msg.obj.getter.parms"
            goto L41
        L2f:
            r7 = r0
            goto L41
        L31:
            int r6 = r5.length
            if (r6 != r2) goto L41
            r5 = r5[r1]
            java.lang.Class<org.mozilla.javascript.Scriptable> r6 = org.mozilla.javascript.ScriptRuntime.ScriptableClass
            if (r5 == r6) goto L3f
            java.lang.Class<?> r6 = org.mozilla.javascript.ScriptRuntime.ScriptableObjectClass
            if (r5 == r6) goto L3f
            goto L41
        L3f:
            if (r4 != 0) goto L2f
        L41:
            if (r7 != 0) goto L44
            goto L4e
        L44:
            java.lang.String r9 = r11.toString()
            org.mozilla.javascript.EvaluatorException r9 = org.mozilla.javascript.Context.reportRuntimeError1(r7, r9)
            throw r9
        L4d:
            r3 = r0
        L4e:
            if (r12 == 0) goto Lb1
            java.lang.Class r11 = r12.getReturnType()
            java.lang.Class r4 = java.lang.Void.TYPE
            if (r11 != r4) goto La6
            org.mozilla.javascript.MemberBox r11 = new org.mozilla.javascript.MemberBox
            r11.<init>(r12)
            int r4 = r12.getModifiers()
            boolean r4 = java.lang.reflect.Modifier.isStatic(r4)
            if (r4 != 0) goto L6f
            if (r10 == 0) goto L6b
            r4 = 1
            goto L6c
        L6b:
            r4 = 0
        L6c:
            r11.delegateTo = r10
            goto L74
        L6f:
            java.lang.Class r10 = java.lang.Void.TYPE
            r11.delegateTo = r10
            r4 = 1
        L74:
            java.lang.Class[] r10 = r12.getParameterTypes()
            int r5 = r10.length
            if (r5 != r2) goto L80
            if (r4 == 0) goto L99
            java.lang.String r0 = "msg.setter2.expected"
            goto L99
        L80:
            int r2 = r10.length
            r5 = 2
            if (r2 != r5) goto L97
            r10 = r10[r1]
            java.lang.Class<org.mozilla.javascript.Scriptable> r2 = org.mozilla.javascript.ScriptRuntime.ScriptableClass
            if (r10 == r2) goto L91
            java.lang.Class<?> r2 = org.mozilla.javascript.ScriptRuntime.ScriptableObjectClass
            if (r10 == r2) goto L91
            java.lang.String r10 = "msg.setter2.parms"
            goto L95
        L91:
            if (r4 != 0) goto L99
            java.lang.String r10 = "msg.setter1.parms"
        L95:
            r0 = r10
            goto L99
        L97:
            java.lang.String r0 = "msg.setter.parms"
        L99:
            if (r0 != 0) goto L9d
            r0 = r11
            goto Lb1
        L9d:
            java.lang.String r9 = r12.toString()
            org.mozilla.javascript.EvaluatorException r9 = org.mozilla.javascript.Context.reportRuntimeError1(r0, r9)
            throw r9
        La6:
            java.lang.String r9 = r12.toString()
            java.lang.String r10 = "msg.setter.return"
            org.mozilla.javascript.EvaluatorException r9 = org.mozilla.javascript.Context.reportRuntimeError1(r10, r9)
            throw r9
        Lb1:
            r10 = 4
            org.mozilla.javascript.ScriptableObject$Slot r9 = r8.getSlot(r9, r1, r10)
            org.mozilla.javascript.ScriptableObject$GetterSlot r9 = (org.mozilla.javascript.ScriptableObject.GetterSlot) r9
            r9.setAttributes(r13)
            r9.getter = r3
            r9.setter = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptableObject.defineProperty(java.lang.String, java.lang.Object, java.lang.reflect.Method, java.lang.reflect.Method, int):void");
    }

    public void defineOwnProperties(Context context, ScriptableObject scriptableObject) {
        Object[] ids = scriptableObject.getIds();
        for (Object obj : ids) {
            checkPropertyDefinition(ensureScriptableObject(scriptableObject.get(obj)));
        }
        for (Object obj2 : ids) {
            defineOwnProperty(context, obj2, (ScriptableObject) scriptableObject.get(obj2));
        }
    }

    public void defineOwnProperty(Context context, Object obj, ScriptableObject scriptableObject) {
        checkPropertyDefinition(scriptableObject);
        defineOwnProperty(context, obj, scriptableObject, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void defineOwnProperty(Context context, Object obj, ScriptableObject scriptableObject, boolean z) {
        int applyDescriptorToAttributeBitset;
        Slot slot = getSlot(context, obj, 1);
        boolean z2 = slot == null;
        if (z) {
            checkPropertyChange(ScriptRuntime.toString(obj), slot == null ? null : slot.getPropertyDescriptor(context, this), scriptableObject);
        }
        boolean isAccessorDescriptor = isAccessorDescriptor(scriptableObject);
        if (slot == null) {
            slot = getSlot(context, obj, isAccessorDescriptor ? 4 : 2);
            applyDescriptorToAttributeBitset = applyDescriptorToAttributeBitset(7, scriptableObject);
        } else {
            applyDescriptorToAttributeBitset = applyDescriptorToAttributeBitset(slot.getAttributes(), scriptableObject);
        }
        Slot unwrapSlot = unwrapSlot(slot);
        if (isAccessorDescriptor) {
            if (!(unwrapSlot instanceof GetterSlot)) {
                unwrapSlot = getSlot(context, obj, 4);
            }
            GetterSlot getterSlot = (GetterSlot) unwrapSlot;
            Object property = getProperty(scriptableObject, "get");
            if (property != NOT_FOUND) {
                getterSlot.getter = property;
            }
            Object property2 = getProperty(scriptableObject, "set");
            if (property2 != NOT_FOUND) {
                getterSlot.setter = property2;
            }
            getterSlot.value = Undefined.instance;
            getterSlot.setAttributes(applyDescriptorToAttributeBitset);
            return;
        }
        if ((unwrapSlot instanceof GetterSlot) && isDataDescriptor(scriptableObject)) {
            unwrapSlot = getSlot(context, obj, 5);
        }
        Object property3 = getProperty(scriptableObject, "value");
        if (property3 != NOT_FOUND) {
            unwrapSlot.value = property3;
        } else if (z2) {
            unwrapSlot.value = Undefined.instance;
        }
        unwrapSlot.setAttributes(applyDescriptorToAttributeBitset);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkPropertyDefinition(ScriptableObject scriptableObject) {
        Object property = getProperty(scriptableObject, "get");
        if (property != NOT_FOUND && property != Undefined.instance && !(property instanceof Callable)) {
            throw ScriptRuntime.notFunctionError(property);
        }
        Object property2 = getProperty(scriptableObject, "set");
        if (property2 != NOT_FOUND && property2 != Undefined.instance && !(property2 instanceof Callable)) {
            throw ScriptRuntime.notFunctionError(property2);
        }
        if (isDataDescriptor(scriptableObject) && isAccessorDescriptor(scriptableObject)) {
            throw ScriptRuntime.typeError0("msg.both.data.and.accessor.desc");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkPropertyChange(String str, ScriptableObject scriptableObject, ScriptableObject scriptableObject2) {
        if (scriptableObject == null) {
            if (!isExtensible()) {
                throw ScriptRuntime.typeError0("msg.not.extensible");
            }
        } else if (isFalse(scriptableObject.get("configurable", scriptableObject))) {
            if (isTrue(getProperty(scriptableObject2, "configurable"))) {
                throw ScriptRuntime.typeError1("msg.change.configurable.false.to.true", str);
            }
            if (isTrue(scriptableObject.get("enumerable", scriptableObject)) != isTrue(getProperty(scriptableObject2, "enumerable"))) {
                throw ScriptRuntime.typeError1("msg.change.enumerable.with.configurable.false", str);
            }
            boolean isDataDescriptor = isDataDescriptor(scriptableObject2);
            boolean isAccessorDescriptor = isAccessorDescriptor(scriptableObject2);
            if (isDataDescriptor || isAccessorDescriptor) {
                if (isDataDescriptor && isDataDescriptor(scriptableObject)) {
                    if (isFalse(scriptableObject.get("writable", scriptableObject))) {
                        if (isTrue(getProperty(scriptableObject2, "writable"))) {
                            throw ScriptRuntime.typeError1("msg.change.writable.false.to.true.with.configurable.false", str);
                        }
                        if (!sameValue(getProperty(scriptableObject2, "value"), scriptableObject.get("value", scriptableObject))) {
                            throw ScriptRuntime.typeError1("msg.change.value.with.writable.false", str);
                        }
                    }
                } else if (isAccessorDescriptor && isAccessorDescriptor(scriptableObject)) {
                    if (!sameValue(getProperty(scriptableObject2, "set"), scriptableObject.get("set", scriptableObject))) {
                        throw ScriptRuntime.typeError1("msg.change.setter.with.configurable.false", str);
                    }
                    if (!sameValue(getProperty(scriptableObject2, "get"), scriptableObject.get("get", scriptableObject))) {
                        throw ScriptRuntime.typeError1("msg.change.getter.with.configurable.false", str);
                    }
                } else if (isDataDescriptor(scriptableObject)) {
                    throw ScriptRuntime.typeError1("msg.change.property.data.to.accessor.with.configurable.false", str);
                } else {
                    throw ScriptRuntime.typeError1("msg.change.property.accessor.to.data.with.configurable.false", str);
                }
            }
        }
    }

    protected static boolean isTrue(Object obj) {
        return obj != NOT_FOUND && ScriptRuntime.toBoolean(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isFalse(Object obj) {
        return !isTrue(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean sameValue(Object obj, Object obj2) {
        if (obj == NOT_FOUND) {
            return true;
        }
        if (obj2 == NOT_FOUND) {
            obj2 = Undefined.instance;
        }
        if ((obj2 instanceof Number) && (obj instanceof Number)) {
            double doubleValue = ((Number) obj2).doubleValue();
            double doubleValue2 = ((Number) obj).doubleValue();
            if (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2)) {
                return true;
            }
            if (doubleValue == 0.0d && Double.doubleToLongBits(doubleValue) != Double.doubleToLongBits(doubleValue2)) {
                return false;
            }
        }
        return ScriptRuntime.shallowEq(obj2, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int applyDescriptorToAttributeBitset(int i, ScriptableObject scriptableObject) {
        Object property = getProperty(scriptableObject, "enumerable");
        if (property != NOT_FOUND) {
            i = ScriptRuntime.toBoolean(property) ? i & (-3) : i | 2;
        }
        Object property2 = getProperty(scriptableObject, "writable");
        if (property2 != NOT_FOUND) {
            i = ScriptRuntime.toBoolean(property2) ? i & (-2) : i | 1;
        }
        Object property3 = getProperty(scriptableObject, "configurable");
        return property3 != NOT_FOUND ? ScriptRuntime.toBoolean(property3) ? i & (-5) : i | 4 : i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isDataDescriptor(ScriptableObject scriptableObject) {
        return hasProperty(scriptableObject, "value") || hasProperty(scriptableObject, "writable");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAccessorDescriptor(ScriptableObject scriptableObject) {
        return hasProperty(scriptableObject, "get") || hasProperty(scriptableObject, "set");
    }

    protected boolean isGenericDescriptor(ScriptableObject scriptableObject) {
        return (isDataDescriptor(scriptableObject) || isAccessorDescriptor(scriptableObject)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Scriptable ensureScriptable(Object obj) {
        if (!(obj instanceof Scriptable)) {
            throw ScriptRuntime.typeError1("msg.arg.not.object", ScriptRuntime.typeof(obj));
        }
        return (Scriptable) obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ScriptableObject ensureScriptableObject(Object obj) {
        if (!(obj instanceof ScriptableObject)) {
            throw ScriptRuntime.typeError1("msg.arg.not.object", ScriptRuntime.typeof(obj));
        }
        return (ScriptableObject) obj;
    }

    public void defineFunctionProperties(String[] strArr, Class<?> cls, int i) {
        Method[] methodList = FunctionObject.getMethodList(cls);
        for (String str : strArr) {
            Method findSingleMethod = FunctionObject.findSingleMethod(methodList, str);
            if (findSingleMethod == null) {
                throw Context.reportRuntimeError2("msg.method.not.found", str, cls.getName());
            }
            defineProperty(str, new FunctionObject(str, findSingleMethod, this), i);
        }
    }

    public static Scriptable getObjectPrototype(Scriptable scriptable) {
        return TopLevel.getBuiltinPrototype(getTopLevelScope(scriptable), TopLevel.Builtins.Object);
    }

    public static Scriptable getFunctionPrototype(Scriptable scriptable) {
        return TopLevel.getBuiltinPrototype(getTopLevelScope(scriptable), TopLevel.Builtins.Function);
    }

    public static Scriptable getArrayPrototype(Scriptable scriptable) {
        return TopLevel.getBuiltinPrototype(getTopLevelScope(scriptable), TopLevel.Builtins.Array);
    }

    public static Scriptable getClassPrototype(Scriptable scriptable, String str) {
        Object obj;
        Object property = getProperty(getTopLevelScope(scriptable), str);
        if (property instanceof BaseFunction) {
            obj = ((BaseFunction) property).getPrototypeProperty();
        } else {
            if (property instanceof Scriptable) {
                Scriptable scriptable2 = (Scriptable) property;
                obj = scriptable2.get("prototype", scriptable2);
            }
            return null;
        }
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        return null;
    }

    public static Scriptable getTopLevelScope(Scriptable scriptable) {
        while (true) {
            Scriptable parentScope = scriptable.getParentScope();
            if (parentScope == null) {
                return scriptable;
            }
            scriptable = parentScope;
        }
    }

    public boolean isExtensible() {
        return this.isExtensible;
    }

    public void preventExtensions() {
        this.isExtensible = false;
    }

    public synchronized void sealObject() {
        if (this.count >= 0) {
            for (Slot slot = this.firstAdded; slot != null; slot = slot.orderedNext) {
                Object obj = slot.value;
                if (obj instanceof LazilyLoadedCtor) {
                    LazilyLoadedCtor lazilyLoadedCtor = (LazilyLoadedCtor) obj;
                    lazilyLoadedCtor.init();
                    slot.value = lazilyLoadedCtor.getValue();
                }
            }
            this.count = ~this.count;
        }
    }

    public final boolean isSealed() {
        return this.count < 0;
    }

    private void checkNotSealed(String str, int i) {
        if (isSealed()) {
            if (str == null) {
                str = Integer.toString(i);
            }
            throw Context.reportRuntimeError1("msg.modify.sealed", str);
        }
    }

    public static Object getProperty(Scriptable scriptable, String str) {
        Object obj;
        Scriptable scriptable2 = scriptable;
        do {
            obj = scriptable2.get(str, scriptable);
            if (obj != Scriptable.NOT_FOUND) {
                break;
            }
            scriptable2 = scriptable2.getPrototype();
        } while (scriptable2 != null);
        return obj;
    }

    public static <T> T getTypedProperty(Scriptable scriptable, int i, Class<T> cls) {
        Object property = getProperty(scriptable, i);
        if (property == Scriptable.NOT_FOUND) {
            property = null;
        }
        return cls.cast(Context.jsToJava(property, cls));
    }

    public static Object getProperty(Scriptable scriptable, int i) {
        Object obj;
        Scriptable scriptable2 = scriptable;
        do {
            obj = scriptable2.get(i, scriptable);
            if (obj != Scriptable.NOT_FOUND) {
                break;
            }
            scriptable2 = scriptable2.getPrototype();
        } while (scriptable2 != null);
        return obj;
    }

    public static <T> T getTypedProperty(Scriptable scriptable, String str, Class<T> cls) {
        Object property = getProperty(scriptable, str);
        if (property == Scriptable.NOT_FOUND) {
            property = null;
        }
        return cls.cast(Context.jsToJava(property, cls));
    }

    public static boolean hasProperty(Scriptable scriptable, String str) {
        return getBase(scriptable, str) != null;
    }

    public static void redefineProperty(Scriptable scriptable, String str, boolean z) {
        Scriptable base = getBase(scriptable, str);
        if (base == null) {
            return;
        }
        if ((base instanceof ConstProperties) && ((ConstProperties) base).isConst(str)) {
            throw Context.reportRuntimeError1("msg.const.redecl", str);
        }
        if (z) {
            throw Context.reportRuntimeError1("msg.var.redecl", str);
        }
    }

    public static boolean hasProperty(Scriptable scriptable, int i) {
        return getBase(scriptable, i) != null;
    }

    public static void putProperty(Scriptable scriptable, String str, Object obj) {
        Scriptable base = getBase(scriptable, str);
        if (base == null) {
            base = scriptable;
        }
        base.put(str, scriptable, obj);
    }

    public static void putConstProperty(Scriptable scriptable, String str, Object obj) {
        Scriptable base = getBase(scriptable, str);
        if (base == null) {
            base = scriptable;
        }
        if (base instanceof ConstProperties) {
            ((ConstProperties) base).putConst(str, scriptable, obj);
        }
    }

    public static void putProperty(Scriptable scriptable, int i, Object obj) {
        Scriptable base = getBase(scriptable, i);
        if (base == null) {
            base = scriptable;
        }
        base.put(i, scriptable, obj);
    }

    public static boolean deleteProperty(Scriptable scriptable, String str) {
        Scriptable base = getBase(scriptable, str);
        if (base == null) {
            return true;
        }
        base.delete(str);
        return !base.has(str, scriptable);
    }

    public static boolean deleteProperty(Scriptable scriptable, int i) {
        Scriptable base = getBase(scriptable, i);
        if (base == null) {
            return true;
        }
        base.delete(i);
        return !base.has(i, scriptable);
    }

    public static Object[] getPropertyIds(Scriptable scriptable) {
        if (scriptable == null) {
            return ScriptRuntime.emptyArgs;
        }
        Object[] ids = scriptable.getIds();
        ObjToIntMap objToIntMap = null;
        while (true) {
            scriptable = scriptable.getPrototype();
            if (scriptable == null) {
                break;
            }
            Object[] ids2 = scriptable.getIds();
            if (ids2.length != 0) {
                if (objToIntMap == null) {
                    if (ids.length == 0) {
                        ids = ids2;
                    } else {
                        objToIntMap = new ObjToIntMap(ids.length + ids2.length);
                        for (int i = 0; i != ids.length; i++) {
                            objToIntMap.intern(ids[i]);
                        }
                        ids = null;
                    }
                }
                for (int i2 = 0; i2 != ids2.length; i2++) {
                    objToIntMap.intern(ids2[i2]);
                }
            }
        }
        return objToIntMap != null ? objToIntMap.getKeys() : ids;
    }

    public static Object callMethod(Scriptable scriptable, String str, Object[] objArr) {
        return callMethod(null, scriptable, str, objArr);
    }

    public static Object callMethod(Context context, Scriptable scriptable, String str, Object[] objArr) {
        Object property = getProperty(scriptable, str);
        if (!(property instanceof Function)) {
            throw ScriptRuntime.notFunctionError(scriptable, str);
        }
        Function function = (Function) property;
        Scriptable topLevelScope = getTopLevelScope(scriptable);
        if (context != null) {
            return function.call(context, topLevelScope, scriptable, objArr);
        }
        return Context.call(null, function, topLevelScope, scriptable, objArr);
    }

    private static Scriptable getBase(Scriptable scriptable, String str) {
        while (!scriptable.has(str, scriptable) && (scriptable = scriptable.getPrototype()) != null) {
        }
        return scriptable;
    }

    private static Scriptable getBase(Scriptable scriptable, int i) {
        while (!scriptable.has(i, scriptable) && (scriptable = scriptable.getPrototype()) != null) {
        }
        return scriptable;
    }

    public final Object getAssociatedValue(Object obj) {
        Map<Object, Object> map = this.associatedValues;
        if (map == null) {
            return null;
        }
        return map.get(obj);
    }

    public static Object getTopScopeValue(Scriptable scriptable, Object obj) {
        Object associatedValue;
        Scriptable topLevelScope = getTopLevelScope(scriptable);
        do {
            if ((topLevelScope instanceof ScriptableObject) && (associatedValue = ((ScriptableObject) topLevelScope).getAssociatedValue(obj)) != null) {
                return associatedValue;
            }
            topLevelScope = topLevelScope.getPrototype();
        } while (topLevelScope != null);
        return null;
    }

    public final synchronized Object associateValue(Object obj, Object obj2) {
        Map map;
        if (obj2 == null) {
            throw new IllegalArgumentException();
        }
        map = this.associatedValues;
        if (map == null) {
            map = new HashMap();
            this.associatedValues = map;
        }
        return Kit.initHash(map, obj, obj2);
    }

    private boolean putImpl(String str, int i, Scriptable scriptable, Object obj) {
        Slot slot;
        if (this != scriptable) {
            slot = getSlot(str, i, 1);
            if (slot == null) {
                return false;
            }
        } else if (!this.isExtensible) {
            slot = getSlot(str, i, 1);
            if (slot == null) {
                return true;
            }
        } else {
            if (this.count < 0) {
                checkNotSealed(str, i);
            }
            slot = getSlot(str, i, 2);
        }
        return slot.setValue(obj, this, scriptable);
    }

    private boolean putConstImpl(String str, int i, Scriptable scriptable, Object obj, int i2) {
        Slot slot;
        if (this != scriptable) {
            slot = getSlot(str, i, 1);
            if (slot == null) {
                return false;
            }
        } else if (!isExtensible()) {
            slot = getSlot(str, i, 1);
            if (slot == null) {
                return true;
            }
        } else {
            checkNotSealed(str, i);
            Slot unwrapSlot = unwrapSlot(getSlot(str, i, 3));
            int attributes = unwrapSlot.getAttributes();
            if ((attributes & 1) != 0) {
                if ((attributes & 8) != 0) {
                    unwrapSlot.value = obj;
                    if (i2 != 8) {
                        unwrapSlot.setAttributes(attributes & (-9));
                    }
                }
                return true;
            }
            throw Context.reportRuntimeError1("msg.var.redecl", str);
        }
        return slot.setValue(obj, this, scriptable);
    }

    private Slot findAttributeSlot(String str, int i, int i2) {
        Slot slot = getSlot(str, i, i2);
        if (slot == null) {
            if (str == null) {
                str = Integer.toString(i);
            }
            throw Context.reportRuntimeError1("msg.prop.not.found", str);
        }
        return slot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Slot unwrapSlot(Slot slot) {
        return slot instanceof RelinkedSlot ? ((RelinkedSlot) slot).slot : slot;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x004f, code lost:
        if (r0 != null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.mozilla.javascript.ScriptableObject.Slot getSlot(java.lang.String r5, int r6, int r7) {
        /*
            r4 = this;
            org.mozilla.javascript.ScriptableObject$Slot[] r0 = r4.slots
            r1 = 1
            if (r0 != 0) goto L9
            if (r7 != r1) goto L9
            r5 = 0
            return r5
        L9:
            if (r5 == 0) goto Lf
            int r6 = r5.hashCode()
        Lf:
            if (r0 == 0) goto L52
            int r2 = r0.length
            int r2 = getSlotIndex(r2, r6)
            r0 = r0[r2]
        L18:
            if (r0 == 0) goto L2e
            java.lang.String r2 = r0.name
            int r3 = r0.indexOrHash
            if (r6 != r3) goto L2b
            if (r2 == r5) goto L2e
            if (r5 == 0) goto L2b
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L2b
            goto L2e
        L2b:
            org.mozilla.javascript.ScriptableObject$Slot r0 = r0.next
            goto L18
        L2e:
            if (r7 == r1) goto L51
            r1 = 2
            if (r7 == r1) goto L4f
            r1 = 3
            if (r7 == r1) goto L4f
            r1 = 4
            if (r7 == r1) goto L46
            r1 = 5
            if (r7 == r1) goto L3d
            goto L52
        L3d:
            org.mozilla.javascript.ScriptableObject$Slot r0 = unwrapSlot(r0)
            boolean r1 = r0 instanceof org.mozilla.javascript.ScriptableObject.GetterSlot
            if (r1 != 0) goto L52
            return r0
        L46:
            org.mozilla.javascript.ScriptableObject$Slot r0 = unwrapSlot(r0)
            boolean r1 = r0 instanceof org.mozilla.javascript.ScriptableObject.GetterSlot
            if (r1 == 0) goto L52
            return r0
        L4f:
            if (r0 == 0) goto L52
        L51:
            return r0
        L52:
            org.mozilla.javascript.ScriptableObject$Slot r5 = r4.createSlot(r5, r6, r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptableObject.getSlot(java.lang.String, int, int):org.mozilla.javascript.ScriptableObject$Slot");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
        r6 = unwrapSlot(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
        if (r11 != 4) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
        if ((r6 instanceof org.mozilla.javascript.ScriptableObject.GetterSlot) != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
        r11 = new org.mozilla.javascript.ScriptableObject.GetterSlot(r9, r10, r6.getAttributes());
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
        if (r11 != 5) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0051, code lost:
        if ((r6 instanceof org.mozilla.javascript.ScriptableObject.GetterSlot) == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
        r11 = new org.mozilla.javascript.ScriptableObject.Slot(r9, r10, r6.getAttributes());
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
        r11.value = r6.value;
        r11.next = r4.next;
        r9 = r8.lastAdded;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r9 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0068, code lost:
        r9.orderedNext = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006c, code lost:
        if (r8.firstAdded != null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006e, code lost:
        r8.firstAdded = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0070, code lost:
        r8.lastAdded = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0072, code lost:
        if (r5 != r4) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0074, code lost:
        r0[r1] = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0077, code lost:
        r5.next = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0079, code lost:
        r4.markDeleted();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007d, code lost:
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007e, code lost:
        if (r11 != 3) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0082, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0084, code lost:
        return r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized org.mozilla.javascript.ScriptableObject.Slot createSlot(java.lang.String r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptableObject.createSlot(java.lang.String, int, int):org.mozilla.javascript.ScriptableObject$Slot");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x003c, code lost:
        if ((r2.getAttributes() & 4) != 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003e, code lost:
        r6.count--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
        if (r3 != r2) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:
        r0[r1] = r2.next;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004b, code lost:
        r3.next = r2.next;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004f, code lost:
        r7 = unwrapSlot(r2);
        r8 = r6.firstAdded;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0055, code lost:
        if (r7 != r8) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
        r8 = null;
        r6.firstAdded = r7.orderedNext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005f, code lost:
        if (r8.orderedNext == r7) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0061, code lost:
        r8 = r8.orderedNext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0064, code lost:
        r8.orderedNext = r7.orderedNext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006a, code lost:
        if (r7 != r6.lastAdded) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006c, code lost:
        r6.lastAdded = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006e, code lost:
        r2.markDeleted();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void removeSlot(java.lang.String r7, int r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r7 == 0) goto Lb
            int r8 = r7.hashCode()     // Catch: java.lang.Throwable -> L8
            goto Lb
        L8:
            r7 = move-exception
            goto L73
        Lb:
            org.mozilla.javascript.ScriptableObject$Slot[] r0 = r6.slots     // Catch: java.lang.Throwable -> L8
            int r1 = r6.count     // Catch: java.lang.Throwable -> L8
            if (r1 == 0) goto L71
            int r1 = r0.length     // Catch: java.lang.Throwable -> L8
            int r1 = getSlotIndex(r1, r8)     // Catch: java.lang.Throwable -> L8
            r2 = r0[r1]     // Catch: java.lang.Throwable -> L8
            r3 = r2
        L19:
            if (r2 == 0) goto L34
            int r4 = r2.indexOrHash     // Catch: java.lang.Throwable -> L8
            if (r4 != r8) goto L2e
            java.lang.String r4 = r2.name     // Catch: java.lang.Throwable -> L8
            if (r4 == r7) goto L34
            if (r7 == 0) goto L2e
            java.lang.String r4 = r2.name     // Catch: java.lang.Throwable -> L8
            boolean r4 = r7.equals(r4)     // Catch: java.lang.Throwable -> L8
            if (r4 == 0) goto L2e
            goto L34
        L2e:
            org.mozilla.javascript.ScriptableObject$Slot r3 = r2.next     // Catch: java.lang.Throwable -> L8
            r5 = r3
            r3 = r2
            r2 = r5
            goto L19
        L34:
            if (r2 == 0) goto L71
            int r7 = r2.getAttributes()     // Catch: java.lang.Throwable -> L8
            r7 = r7 & 4
            if (r7 != 0) goto L71
            int r7 = r6.count     // Catch: java.lang.Throwable -> L8
            int r7 = r7 + (-1)
            r6.count = r7     // Catch: java.lang.Throwable -> L8
            if (r3 != r2) goto L4b
            org.mozilla.javascript.ScriptableObject$Slot r7 = r2.next     // Catch: java.lang.Throwable -> L8
            r0[r1] = r7     // Catch: java.lang.Throwable -> L8
            goto L4f
        L4b:
            org.mozilla.javascript.ScriptableObject$Slot r7 = r2.next     // Catch: java.lang.Throwable -> L8
            r3.next = r7     // Catch: java.lang.Throwable -> L8
        L4f:
            org.mozilla.javascript.ScriptableObject$Slot r7 = unwrapSlot(r2)     // Catch: java.lang.Throwable -> L8
            org.mozilla.javascript.ScriptableObject$Slot r8 = r6.firstAdded     // Catch: java.lang.Throwable -> L8
            if (r7 != r8) goto L5d
            r8 = 0
            org.mozilla.javascript.ScriptableObject$Slot r0 = r7.orderedNext     // Catch: java.lang.Throwable -> L8
            r6.firstAdded = r0     // Catch: java.lang.Throwable -> L8
            goto L68
        L5d:
            org.mozilla.javascript.ScriptableObject$Slot r0 = r8.orderedNext     // Catch: java.lang.Throwable -> L8
            if (r0 == r7) goto L64
            org.mozilla.javascript.ScriptableObject$Slot r8 = r8.orderedNext     // Catch: java.lang.Throwable -> L8
            goto L5d
        L64:
            org.mozilla.javascript.ScriptableObject$Slot r0 = r7.orderedNext     // Catch: java.lang.Throwable -> L8
            r8.orderedNext = r0     // Catch: java.lang.Throwable -> L8
        L68:
            org.mozilla.javascript.ScriptableObject$Slot r0 = r6.lastAdded     // Catch: java.lang.Throwable -> L8
            if (r7 != r0) goto L6e
            r6.lastAdded = r8     // Catch: java.lang.Throwable -> L8
        L6e:
            r2.markDeleted()     // Catch: java.lang.Throwable -> L8
        L71:
            monitor-exit(r6)
            return
        L73:
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptableObject.removeSlot(java.lang.String, int):void");
    }

    private static void copyTable(Slot[] slotArr, Slot[] slotArr2, int i) {
        if (i == 0) {
            throw Kit.codeBug();
        }
        int length = slotArr2.length;
        int length2 = slotArr.length;
        while (true) {
            length2--;
            Slot slot = slotArr[length2];
            while (slot != null) {
                addKnownAbsentSlot(slotArr2, slot.next == null ? slot : new RelinkedSlot(slot), getSlotIndex(length, slot.indexOrHash));
                slot = slot.next;
                i--;
                if (i == 0) {
                    return;
                }
            }
        }
    }

    private static void addKnownAbsentSlot(Slot[] slotArr, Slot slot, int i) {
        if (slotArr[i] == null) {
            slotArr[i] = slot;
            return;
        }
        Slot slot2 = slotArr[i];
        Slot slot3 = slot2.next;
        while (true) {
            Slot slot4 = slot3;
            Slot slot5 = slot2;
            slot2 = slot4;
            if (slot2 != null) {
                slot3 = slot2.next;
            } else {
                slot5.next = slot;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object[] getIds(boolean z) {
        Slot[] slotArr = this.slots;
        Object[] objArr = ScriptRuntime.emptyArgs;
        if (slotArr == null) {
            return objArr;
        }
        Slot slot = this.firstAdded;
        while (slot != null && slot.wasDeleted) {
            slot = slot.orderedNext;
        }
        int i = 0;
        while (slot != null) {
            if (z || (slot.getAttributes() & 2) == 0) {
                if (i == 0) {
                    objArr = new Object[slotArr.length];
                }
                int i2 = i + 1;
                objArr[i] = slot.name != null ? slot.name : Integer.valueOf(slot.indexOrHash);
                i = i2;
            }
            slot = slot.orderedNext;
            while (slot != null && slot.wasDeleted) {
                slot = slot.orderedNext;
            }
        }
        if (i == objArr.length) {
            return objArr;
        }
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }

    private synchronized void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int i = this.count;
        if (i < 0) {
            i = ~i;
        }
        if (i == 0) {
            objectOutputStream.writeInt(0);
        } else {
            objectOutputStream.writeInt(this.slots.length);
            Slot slot = this.firstAdded;
            while (slot != null && slot.wasDeleted) {
                slot = slot.orderedNext;
            }
            this.firstAdded = slot;
            while (slot != null) {
                objectOutputStream.writeObject(slot);
                Slot slot2 = slot.orderedNext;
                while (slot2 != null && slot2.wasDeleted) {
                    slot2 = slot2.orderedNext;
                }
                slot.orderedNext = slot2;
                slot = slot2;
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt != 0) {
            if (((readInt - 1) & readInt) != 0) {
                if (readInt > 1073741824) {
                    throw new RuntimeException("Property table overflow");
                }
                int i = 4;
                while (i < readInt) {
                    i <<= 1;
                }
                readInt = i;
            }
            this.slots = new Slot[readInt];
            int i2 = this.count;
            if (i2 < 0) {
                i2 = ~i2;
            }
            Slot slot = null;
            for (int i3 = 0; i3 != i2; i3++) {
                Slot slot2 = (Slot) objectInputStream.readObject();
                this.lastAdded = slot2;
                if (i3 == 0) {
                    this.firstAdded = slot2;
                } else {
                    slot.orderedNext = slot2;
                }
                addKnownAbsentSlot(this.slots, this.lastAdded, getSlotIndex(readInt, this.lastAdded.indexOrHash));
                slot = this.lastAdded;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ScriptableObject getOwnPropertyDescriptor(Context context, Object obj) {
        Slot slot = getSlot(context, obj, 1);
        if (slot == null) {
            return null;
        }
        Scriptable parentScope = getParentScope();
        if (parentScope == null) {
            parentScope = this;
        }
        return slot.getPropertyDescriptor(context, parentScope);
    }

    protected Slot getSlot(Context context, Object obj, int i) {
        String stringIdOrIndex = ScriptRuntime.toStringIdOrIndex(context, obj);
        if (stringIdOrIndex == null) {
            return getSlot((String) null, ScriptRuntime.lastIndexResult(context), i);
        }
        return getSlot(stringIdOrIndex, 0, i);
    }

    public int size() {
        int i = this.count;
        return i < 0 ? ~i : i;
    }

    public boolean isEmpty() {
        int i = this.count;
        return i == 0 || i == -1;
    }

    public Object get(Object obj) {
        Object obj2;
        if (obj instanceof String) {
            obj2 = get((String) obj, this);
        } else {
            obj2 = obj instanceof Number ? get(((Number) obj).intValue(), this) : null;
        }
        if (obj2 == Scriptable.NOT_FOUND || obj2 == Undefined.instance) {
            return null;
        }
        return obj2 instanceof Wrapper ? ((Wrapper) obj2).unwrap() : obj2;
    }
}
