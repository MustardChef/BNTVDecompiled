package org.mozilla.javascript;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.mozilla.javascript.TopLevel;

/* loaded from: classes5.dex */
public class NativeArray extends IdScriptableObject implements List {
    private static final int ConstructorId_concat = -13;
    private static final int ConstructorId_every = -17;
    private static final int ConstructorId_filter = -18;
    private static final int ConstructorId_forEach = -19;
    private static final int ConstructorId_indexOf = -15;
    private static final int ConstructorId_isArray = -24;
    private static final int ConstructorId_join = -5;
    private static final int ConstructorId_lastIndexOf = -16;
    private static final int ConstructorId_map = -20;
    private static final int ConstructorId_pop = -9;
    private static final int ConstructorId_push = -8;
    private static final int ConstructorId_reduce = -22;
    private static final int ConstructorId_reduceRight = -23;
    private static final int ConstructorId_reverse = -6;
    private static final int ConstructorId_shift = -10;
    private static final int ConstructorId_slice = -14;
    private static final int ConstructorId_some = -21;
    private static final int ConstructorId_sort = -7;
    private static final int ConstructorId_splice = -12;
    private static final int ConstructorId_unshift = -11;
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private static final double GROW_FACTOR = 1.5d;
    private static final int Id_concat = 13;
    private static final int Id_constructor = 1;
    private static final int Id_every = 17;
    private static final int Id_filter = 18;
    private static final int Id_forEach = 19;
    private static final int Id_indexOf = 15;
    private static final int Id_join = 5;
    private static final int Id_lastIndexOf = 16;
    private static final int Id_length = 1;
    private static final int Id_map = 20;
    private static final int Id_pop = 9;
    private static final int Id_push = 8;
    private static final int Id_reduce = 22;
    private static final int Id_reduceRight = 23;
    private static final int Id_reverse = 6;
    private static final int Id_shift = 10;
    private static final int Id_slice = 14;
    private static final int Id_some = 21;
    private static final int Id_sort = 7;
    private static final int Id_splice = 12;
    private static final int Id_toLocaleString = 3;
    private static final int Id_toSource = 4;
    private static final int Id_toString = 2;
    private static final int Id_unshift = 11;
    private static final int MAX_INSTANCE_ID = 1;
    private static final int MAX_PRE_GROW_SIZE = 1431655764;
    private static final int MAX_PROTOTYPE_ID = 23;
    static final long serialVersionUID = 7331366857676127338L;
    private Object[] dense;
    private boolean denseOnly;
    private long length;
    private int lengthAttr;
    private static final Object ARRAY_TAG = "Array";
    private static final Integer NEGATIVE_ONE = -1;
    private static int maximumInitialCapacity = 10000;

    private static long toSliceIndex(double d, long j) {
        if (d < 0.0d) {
            d += j;
            if (d < 0.0d) {
                return 0L;
            }
        } else if (d > j) {
            return j;
        }
        return (long) d;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Array";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int getMaxInstanceId() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init(Scriptable scriptable, boolean z) {
        new NativeArray(0L).exportAsJSClass(23, scriptable, z);
    }

    static int getMaximumInitialCapacity() {
        return maximumInitialCapacity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setMaximumInitialCapacity(int i) {
        maximumInitialCapacity = i;
    }

    public NativeArray(long j) {
        this.lengthAttr = 6;
        boolean z = j <= ((long) maximumInitialCapacity);
        this.denseOnly = z;
        if (z) {
            int i = (int) j;
            Object[] objArr = new Object[i < 10 ? 10 : i];
            this.dense = objArr;
            Arrays.fill(objArr, Scriptable.NOT_FOUND);
        }
        this.length = j;
    }

    public NativeArray(Object[] objArr) {
        this.lengthAttr = 6;
        this.denseOnly = true;
        this.dense = objArr;
        this.length = objArr.length;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void setInstanceIdAttributes(int i, int i2) {
        if (i == 1) {
            this.lengthAttr = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int findInstanceIdInfo(String str) {
        if (str.equals(SessionDescription.ATTR_LENGTH)) {
            return instanceIdInfo(this.lengthAttr, 1);
        }
        return super.findInstanceIdInfo(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public String getInstanceIdName(int i) {
        return i == 1 ? SessionDescription.ATTR_LENGTH : super.getInstanceIdName(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public Object getInstanceIdValue(int i) {
        if (i == 1) {
            return ScriptRuntime.wrapNumber(this.length);
        }
        return super.getInstanceIdValue(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public void setInstanceIdValue(int i, Object obj) {
        if (i == 1) {
            setLength(obj);
        } else {
            super.setInstanceIdValue(i, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        Object obj = ARRAY_TAG;
        addIdFunctionProperty(idFunctionObject, obj, -5, "join", 1);
        addIdFunctionProperty(idFunctionObject, obj, -6, "reverse", 0);
        addIdFunctionProperty(idFunctionObject, obj, -7, "sort", 1);
        addIdFunctionProperty(idFunctionObject, obj, -8, "push", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_pop, "pop", 0);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_shift, "shift", 0);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_unshift, "unshift", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_splice, "splice", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_concat, "concat", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_slice, "slice", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_indexOf, "indexOf", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_lastIndexOf, "lastIndexOf", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_every, "every", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_filter, "filter", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_forEach, "forEach", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_map, "map", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_some, "some", 1);
        addIdFunctionProperty(idFunctionObject, obj, -22, "reduce", 1);
        addIdFunctionProperty(idFunctionObject, obj, -23, "reduceRight", 1);
        addIdFunctionProperty(idFunctionObject, obj, -24, "isArray", 1);
        super.fillConstructorProperties(idFunctionObject);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 1;
        switch (i) {
            case 1:
                str = "constructor";
                break;
            case 2:
                str = "toString";
                i2 = 0;
                break;
            case 3:
                str = "toLocaleString";
                i2 = 0;
                break;
            case 4:
                str = "toSource";
                i2 = 0;
                break;
            case 5:
                str = "join";
                break;
            case 6:
                str = "reverse";
                i2 = 0;
                break;
            case 7:
                str = "sort";
                break;
            case 8:
                str = "push";
                break;
            case 9:
                str = "pop";
                i2 = 0;
                break;
            case 10:
                str = "shift";
                i2 = 0;
                break;
            case 11:
                str = "unshift";
                break;
            case 12:
                str2 = "splice";
                str = str2;
                i2 = 2;
                break;
            case 13:
                str = "concat";
                break;
            case 14:
                str2 = "slice";
                str = str2;
                i2 = 2;
                break;
            case 15:
                str = "indexOf";
                break;
            case 16:
                str = "lastIndexOf";
                break;
            case 17:
                str = "every";
                break;
            case 18:
                str = "filter";
                break;
            case 19:
                str = "forEach";
                break;
            case 20:
                str = "map";
                break;
            case 21:
                str = "some";
                break;
            case 22:
                str = "reduce";
                break;
            case 23:
                str = "reduceRight";
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(ARRAY_TAG, i, str, i2);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(ARRAY_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        Scriptable scriptable3 = scriptable2;
        Object[] objArr2 = objArr;
        int methodId = idFunctionObject.methodId();
        while (true) {
            int i = 0;
            switch (methodId) {
                case -24:
                    return Boolean.valueOf((objArr2.length <= 0 || !(objArr2[0] instanceof NativeArray)) ? false : false);
                case -23:
                case -22:
                case ConstructorId_some /* -21 */:
                case ConstructorId_map /* -20 */:
                case ConstructorId_forEach /* -19 */:
                case ConstructorId_filter /* -18 */:
                case ConstructorId_every /* -17 */:
                case ConstructorId_lastIndexOf /* -16 */:
                case ConstructorId_indexOf /* -15 */:
                case ConstructorId_slice /* -14 */:
                case ConstructorId_concat /* -13 */:
                case ConstructorId_splice /* -12 */:
                case ConstructorId_unshift /* -11 */:
                case ConstructorId_shift /* -10 */:
                case ConstructorId_pop /* -9 */:
                case -8:
                case -7:
                case -6:
                case -5:
                    if (objArr2.length > 0) {
                        Scriptable object = ScriptRuntime.toObject(scriptable, objArr2[0]);
                        int length = objArr2.length - 1;
                        Object[] objArr3 = new Object[length];
                        while (i < length) {
                            int i2 = i + 1;
                            objArr3[i] = objArr2[i2];
                            i = i2;
                        }
                        objArr2 = objArr3;
                        scriptable3 = object;
                    }
                    methodId = -methodId;
                default:
                    switch (methodId) {
                        case 1:
                            if (!(scriptable3 == null)) {
                                return idFunctionObject.construct(context, scriptable, objArr2);
                            }
                            return jsConstructor(context, scriptable, objArr2);
                        case 2:
                            return toStringHelper(context, scriptable, scriptable3, context.hasFeature(4), false);
                        case 3:
                            return toStringHelper(context, scriptable, scriptable3, false, true);
                        case 4:
                            return toStringHelper(context, scriptable, scriptable3, true, false);
                        case 5:
                            return js_join(context, scriptable3, objArr2);
                        case 6:
                            return js_reverse(context, scriptable3, objArr2);
                        case 7:
                            return js_sort(context, scriptable, scriptable3, objArr2);
                        case 8:
                            return js_push(context, scriptable3, objArr2);
                        case 9:
                            return js_pop(context, scriptable3, objArr2);
                        case 10:
                            return js_shift(context, scriptable3, objArr2);
                        case 11:
                            return js_unshift(context, scriptable3, objArr2);
                        case 12:
                            return js_splice(context, scriptable, scriptable3, objArr2);
                        case 13:
                            return js_concat(context, scriptable, scriptable3, objArr2);
                        case 14:
                            return js_slice(context, scriptable3, objArr2);
                        case 15:
                            return indexOfHelper(context, scriptable3, objArr2, false);
                        case 16:
                            return indexOfHelper(context, scriptable3, objArr2, true);
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                            return iterativeMethod(context, methodId, scriptable, scriptable3, objArr2);
                        case 22:
                        case 23:
                            return reduceMethod(context, methodId, scriptable, scriptable3, objArr2);
                        default:
                            throw new IllegalArgumentException(String.valueOf(methodId));
                    }
            }
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        if (!this.denseOnly && isGetterOrSetter(null, i, false)) {
            return super.get(i, scriptable);
        }
        Object[] objArr = this.dense;
        if (objArr != null && i >= 0 && i < objArr.length) {
            return objArr[i];
        }
        return super.get(i, scriptable);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        if (!this.denseOnly && isGetterOrSetter(null, i, false)) {
            return super.has(i, scriptable);
        }
        Object[] objArr = this.dense;
        if (objArr == null || i < 0 || i >= objArr.length) {
            return super.has(i, scriptable);
        }
        return objArr[i] != NOT_FOUND;
    }

    private static long toArrayIndex(Object obj) {
        if (obj instanceof String) {
            return toArrayIndex((String) obj);
        }
        if (obj instanceof Number) {
            return toArrayIndex(((Number) obj).doubleValue());
        }
        return -1L;
    }

    private static long toArrayIndex(String str) {
        long arrayIndex = toArrayIndex(ScriptRuntime.toNumber(str));
        if (Long.toString(arrayIndex).equals(str)) {
            return arrayIndex;
        }
        return -1L;
    }

    private static long toArrayIndex(double d) {
        if (d == d) {
            long uint32 = ScriptRuntime.toUint32(d);
            if (uint32 != d || uint32 == 4294967295L) {
                return -1L;
            }
            return uint32;
        }
        return -1L;
    }

    private static int toDenseIndex(Object obj) {
        long arrayIndex = toArrayIndex(obj);
        if (0 > arrayIndex || arrayIndex >= 2147483647L) {
            return -1;
        }
        return (int) arrayIndex;
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        super.put(str, scriptable, obj);
        if (scriptable == this) {
            long arrayIndex = toArrayIndex(str);
            if (arrayIndex >= this.length) {
                this.length = arrayIndex + 1;
                this.denseOnly = false;
            }
        }
    }

    private boolean ensureCapacity(int i) {
        Object[] objArr = this.dense;
        if (i > objArr.length) {
            if (i > MAX_PRE_GROW_SIZE) {
                this.denseOnly = false;
                return false;
            }
            int max = Math.max(i, (int) (objArr.length * GROW_FACTOR));
            Object[] objArr2 = new Object[max];
            Object[] objArr3 = this.dense;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            Arrays.fill(objArr2, this.dense.length, max, Scriptable.NOT_FOUND);
            this.dense = objArr2;
            return true;
        }
        return true;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        if (scriptable == this && !isSealed() && this.dense != null && i >= 0 && (this.denseOnly || !isGetterOrSetter(null, i, true))) {
            Object[] objArr = this.dense;
            if (i < objArr.length) {
                objArr[i] = obj;
                long j = i;
                if (this.length <= j) {
                    this.length = j + 1;
                    return;
                }
                return;
            } else if (this.denseOnly && i < objArr.length * GROW_FACTOR && ensureCapacity(i + 1)) {
                this.dense[i] = obj;
                this.length = i + 1;
                return;
            } else {
                this.denseOnly = false;
            }
        }
        super.put(i, scriptable, obj);
        if (scriptable == this && (this.lengthAttr & 1) == 0) {
            long j2 = i;
            if (this.length <= j2) {
                this.length = j2 + 1;
            }
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void delete(int i) {
        Object[] objArr = this.dense;
        if (objArr != null && i >= 0 && i < objArr.length && !isSealed() && (this.denseOnly || !isGetterOrSetter(null, i, true))) {
            this.dense[i] = NOT_FOUND;
        } else {
            super.delete(i);
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        Object[] ids = super.getIds();
        Object[] objArr = this.dense;
        if (objArr == null) {
            return ids;
        }
        int length = objArr.length;
        long j = this.length;
        if (length > j) {
            length = (int) j;
        }
        if (length == 0) {
            return ids;
        }
        int length2 = ids.length;
        Object[] objArr2 = new Object[length + length2];
        int i = 0;
        for (int i2 = 0; i2 != length; i2++) {
            if (this.dense[i2] != NOT_FOUND) {
                objArr2[i] = Integer.valueOf(i2);
                i++;
            }
        }
        if (i != length) {
            Object[] objArr3 = new Object[i + length2];
            System.arraycopy(objArr2, 0, objArr3, 0, i);
            objArr2 = objArr3;
        }
        System.arraycopy(ids, 0, objArr2, i, length2);
        return objArr2;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.debug.DebuggableObject
    public Object[] getAllIds() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(getIds()));
        linkedHashSet.addAll(Arrays.asList(super.getAllIds()));
        return linkedHashSet.toArray();
    }

    public Integer[] getIndexIds() {
        Object[] ids = getIds();
        ArrayList arrayList = new ArrayList(ids.length);
        for (Object obj : ids) {
            int int32 = ScriptRuntime.toInt32(obj);
            if (int32 >= 0 && ScriptRuntime.toString(int32).equals(ScriptRuntime.toString(obj))) {
                arrayList.add(Integer.valueOf(int32));
            }
        }
        return (Integer[]) arrayList.toArray(new Integer[arrayList.size()]);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        if (cls == ScriptRuntime.NumberClass && Context.getContext().getLanguageVersion() == 120) {
            return Long.valueOf(this.length);
        }
        return super.getDefaultValue(cls);
    }

    private ScriptableObject defaultIndexPropertyDescriptor(Object obj) {
        Scriptable parentScope = getParentScope();
        if (parentScope == null) {
            parentScope = this;
        }
        NativeObject nativeObject = new NativeObject();
        ScriptRuntime.setBuiltinProtoAndParent(nativeObject, parentScope, TopLevel.Builtins.Object);
        nativeObject.defineProperty("value", obj, 0);
        nativeObject.defineProperty("writable", (Object) true, 0);
        nativeObject.defineProperty("enumerable", (Object) true, 0);
        nativeObject.defineProperty("configurable", (Object) true, 0);
        return nativeObject;
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public int getAttributes(int i) {
        Object[] objArr = this.dense;
        if (objArr == null || i < 0 || i >= objArr.length || objArr[i] == NOT_FOUND) {
            return super.getAttributes(i);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject
    public ScriptableObject getOwnPropertyDescriptor(Context context, Object obj) {
        int denseIndex;
        if (this.dense != null && (denseIndex = toDenseIndex(obj)) >= 0) {
            Object[] objArr = this.dense;
            if (denseIndex < objArr.length && objArr[denseIndex] != NOT_FOUND) {
                return defaultIndexPropertyDescriptor(this.dense[denseIndex]);
            }
        }
        return super.getOwnPropertyDescriptor(context, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.ScriptableObject
    public void defineOwnProperty(Context context, Object obj, ScriptableObject scriptableObject, boolean z) {
        Object[] objArr = this.dense;
        if (objArr != null) {
            this.dense = null;
            this.denseOnly = false;
            for (int i = 0; i < objArr.length; i++) {
                if (objArr[i] != NOT_FOUND) {
                    put(i, this, objArr[i]);
                }
            }
        }
        long arrayIndex = toArrayIndex(obj);
        if (arrayIndex >= this.length) {
            this.length = arrayIndex + 1;
        }
        super.defineOwnProperty(context, obj, scriptableObject, z);
    }

    private static Object jsConstructor(Context context, Scriptable scriptable, Object[] objArr) {
        if (objArr.length == 0) {
            return new NativeArray(0L);
        }
        if (context.getLanguageVersion() == 120) {
            return new NativeArray(objArr);
        }
        Object obj = objArr[0];
        if (objArr.length > 1 || !(obj instanceof Number)) {
            return new NativeArray(objArr);
        }
        long uint32 = ScriptRuntime.toUint32(obj);
        if (uint32 != ((Number) obj).doubleValue()) {
            throw ScriptRuntime.constructError("RangeError", ScriptRuntime.getMessage0("msg.arraylength.bad"));
        }
        return new NativeArray(uint32);
    }

    public long getLength() {
        return this.length;
    }

    public long jsGet_length() {
        return getLength();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDenseOnly(boolean z) {
        if (z && !this.denseOnly) {
            throw new IllegalArgumentException();
        }
        this.denseOnly = z;
    }

    private void setLength(Object obj) {
        Object[] ids;
        if ((this.lengthAttr & 1) != 0) {
            return;
        }
        double number = ScriptRuntime.toNumber(obj);
        long uint32 = ScriptRuntime.toUint32(number);
        double d = uint32;
        if (d != number) {
            throw ScriptRuntime.constructError("RangeError", ScriptRuntime.getMessage0("msg.arraylength.bad"));
        }
        if (this.denseOnly) {
            long j = this.length;
            if (uint32 < j) {
                Object[] objArr = this.dense;
                Arrays.fill(objArr, (int) uint32, objArr.length, NOT_FOUND);
                this.length = uint32;
                return;
            } else if (uint32 < 1431655764 && d < j * GROW_FACTOR && ensureCapacity((int) uint32)) {
                this.length = uint32;
                return;
            } else {
                this.denseOnly = false;
            }
        }
        long j2 = this.length;
        if (uint32 < j2) {
            if (j2 - uint32 > 4096) {
                for (Object obj2 : getIds()) {
                    if (obj2 instanceof String) {
                        String str = (String) obj2;
                        if (toArrayIndex(str) >= uint32) {
                            delete(str);
                        }
                    } else {
                        int intValue = ((Integer) obj2).intValue();
                        if (intValue >= uint32) {
                            delete(intValue);
                        }
                    }
                }
            } else {
                for (long j3 = uint32; j3 < this.length; j3++) {
                    deleteElem(this, j3);
                }
            }
        }
        this.length = uint32;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLengthProperty(Context context, Scriptable scriptable) {
        if (scriptable instanceof NativeString) {
            return ((NativeString) scriptable).getLength();
        }
        if (scriptable instanceof NativeArray) {
            return ((NativeArray) scriptable).getLength();
        }
        return ScriptRuntime.toUint32(ScriptRuntime.getObjectProp(scriptable, SessionDescription.ATTR_LENGTH, context));
    }

    private static Object setLengthProperty(Context context, Scriptable scriptable, long j) {
        return ScriptRuntime.setObjectProp(scriptable, SessionDescription.ATTR_LENGTH, (Object) ScriptRuntime.wrapNumber(j), context);
    }

    private static void deleteElem(Scriptable scriptable, long j) {
        int i = (int) j;
        if (i == j) {
            scriptable.delete(i);
        } else {
            scriptable.delete(Long.toString(j));
        }
    }

    private static Object getElem(Context context, Scriptable scriptable, long j) {
        if (j > 2147483647L) {
            return ScriptRuntime.getObjectProp(scriptable, Long.toString(j), context);
        }
        return ScriptRuntime.getObjectIndex(scriptable, (int) j, context);
    }

    private static Object getRawElem(Scriptable scriptable, long j) {
        if (j > 2147483647L) {
            return ScriptableObject.getProperty(scriptable, Long.toString(j));
        }
        return ScriptableObject.getProperty(scriptable, (int) j);
    }

    private static void setElem(Context context, Scriptable scriptable, long j, Object obj) {
        if (j > 2147483647L) {
            ScriptRuntime.setObjectProp(scriptable, Long.toString(j), obj, context);
        } else {
            ScriptRuntime.setObjectIndex(scriptable, (int) j, obj, context);
        }
    }

    private static void setRawElem(Context context, Scriptable scriptable, long j, Object obj) {
        if (obj == NOT_FOUND) {
            deleteElem(scriptable, j);
        } else {
            setElem(context, scriptable, j, obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String toStringHelper(org.mozilla.javascript.Context r18, org.mozilla.javascript.Scriptable r19, org.mozilla.javascript.Scriptable r20, boolean r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeArray.toStringHelper(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, boolean, boolean):java.lang.String");
    }

    private static String js_join(Context context, Scriptable scriptable, Object[] objArr) {
        Object obj;
        long lengthProperty = getLengthProperty(context, scriptable);
        int i = (int) lengthProperty;
        if (lengthProperty != i) {
            throw Context.reportRuntimeError1("msg.arraylength.too.big", String.valueOf(lengthProperty));
        }
        int i2 = 0;
        String scriptRuntime = (objArr.length < 1 || objArr[0] == Undefined.instance) ? "," : ScriptRuntime.toString(objArr[0]);
        if (scriptable instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly) {
                StringBuilder sb = new StringBuilder();
                while (i2 < i) {
                    if (i2 != 0) {
                        sb.append(scriptRuntime);
                    }
                    Object[] objArr2 = nativeArray.dense;
                    if (i2 < objArr2.length && (obj = objArr2[i2]) != null && obj != Undefined.instance && obj != Scriptable.NOT_FOUND) {
                        sb.append(ScriptRuntime.toString(obj));
                    }
                    i2++;
                }
                return sb.toString();
            }
        }
        if (i == 0) {
            return "";
        }
        String[] strArr = new String[i];
        int i3 = 0;
        for (int i4 = 0; i4 != i; i4++) {
            Object elem = getElem(context, scriptable, i4);
            if (elem != null && elem != Undefined.instance) {
                String scriptRuntime2 = ScriptRuntime.toString(elem);
                i3 += scriptRuntime2.length();
                strArr[i4] = scriptRuntime2;
            }
        }
        StringBuilder sb2 = new StringBuilder(i3 + ((i - 1) * scriptRuntime.length()));
        while (i2 != i) {
            if (i2 != 0) {
                sb2.append(scriptRuntime);
            }
            String str = strArr[i2];
            if (str != null) {
                sb2.append(str);
            }
            i2++;
        }
        return sb2.toString();
    }

    private static Scriptable js_reverse(Context context, Scriptable scriptable, Object[] objArr) {
        if (scriptable instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly) {
                int i = 0;
                for (int i2 = ((int) nativeArray.length) - 1; i < i2; i2--) {
                    Object[] objArr2 = nativeArray.dense;
                    Object obj = objArr2[i];
                    objArr2[i] = objArr2[i2];
                    objArr2[i2] = obj;
                    i++;
                }
                return scriptable;
            }
        }
        long lengthProperty = getLengthProperty(context, scriptable);
        long j = lengthProperty / 2;
        for (long j2 = 0; j2 < j; j2++) {
            long j3 = (lengthProperty - j2) - 1;
            Object rawElem = getRawElem(scriptable, j2);
            setRawElem(context, scriptable, j2, getRawElem(scriptable, j3));
            setRawElem(context, scriptable, j3, rawElem);
        }
        return scriptable;
    }

    private static Scriptable js_sort(final Context context, final Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Comparator<Object> comparator;
        if (objArr.length > 0 && Undefined.instance != objArr[0]) {
            final Callable valueFunctionAndThis = ScriptRuntime.getValueFunctionAndThis(objArr[0], context);
            final Scriptable lastStoredScriptable = ScriptRuntime.lastStoredScriptable(context);
            final Object[] objArr2 = new Object[2];
            comparator = new Comparator<Object>() { // from class: org.mozilla.javascript.NativeArray.1
                @Override // java.util.Comparator
                public int compare(Object obj, Object obj2) {
                    if (obj == obj2) {
                        return 0;
                    }
                    if (obj2 == Undefined.instance || obj2 == Scriptable.NOT_FOUND) {
                        return -1;
                    }
                    if (obj == Undefined.instance || obj == Scriptable.NOT_FOUND) {
                        return 1;
                    }
                    Object[] objArr3 = objArr2;
                    objArr3[0] = obj;
                    objArr3[1] = obj2;
                    double number = ScriptRuntime.toNumber(valueFunctionAndThis.call(context, scriptable, lastStoredScriptable, objArr3));
                    if (number < 0.0d) {
                        return -1;
                    }
                    return number > 0.0d ? 1 : 0;
                }
            };
        } else {
            comparator = new Comparator<Object>() { // from class: org.mozilla.javascript.NativeArray.2
                @Override // java.util.Comparator
                public int compare(Object obj, Object obj2) {
                    if (obj == obj2) {
                        return 0;
                    }
                    if (obj2 == Undefined.instance || obj2 == Scriptable.NOT_FOUND) {
                        return -1;
                    }
                    if (obj == Undefined.instance || obj == Scriptable.NOT_FOUND) {
                        return 1;
                    }
                    return ScriptRuntime.toString(obj).compareTo(ScriptRuntime.toString(obj2));
                }
            };
        }
        int lengthProperty = (int) getLengthProperty(context, scriptable2);
        Object[] objArr3 = new Object[lengthProperty];
        for (int i = 0; i != lengthProperty; i++) {
            objArr3[i] = getElem(context, scriptable2, i);
        }
        Arrays.sort(objArr3, comparator);
        for (int i2 = 0; i2 < lengthProperty; i2++) {
            setElem(context, scriptable2, i2, objArr3[i2]);
        }
        return scriptable2;
    }

    private static Object js_push(Context context, Scriptable scriptable, Object[] objArr) {
        int i = 0;
        if (scriptable instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly && nativeArray.ensureCapacity(((int) nativeArray.length) + objArr.length)) {
                while (i < objArr.length) {
                    Object[] objArr2 = nativeArray.dense;
                    long j = nativeArray.length;
                    nativeArray.length = 1 + j;
                    objArr2[(int) j] = objArr[i];
                    i++;
                }
                return ScriptRuntime.wrapNumber(nativeArray.length);
            }
        }
        long lengthProperty = getLengthProperty(context, scriptable);
        while (i < objArr.length) {
            setElem(context, scriptable, i + lengthProperty, objArr[i]);
            i++;
        }
        return context.getLanguageVersion() == 120 ? objArr.length == 0 ? Undefined.instance : objArr[objArr.length - 1] : setLengthProperty(context, scriptable, lengthProperty + objArr.length);
    }

    private static Object js_pop(Context context, Scriptable scriptable, Object[] objArr) {
        Object obj;
        if (scriptable instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly) {
                long j = nativeArray.length;
                if (j > 0) {
                    long j2 = j - 1;
                    nativeArray.length = j2;
                    Object[] objArr2 = nativeArray.dense;
                    Object obj2 = objArr2[(int) j2];
                    objArr2[(int) j2] = NOT_FOUND;
                    return obj2;
                }
            }
        }
        long lengthProperty = getLengthProperty(context, scriptable);
        if (lengthProperty > 0) {
            lengthProperty--;
            obj = getElem(context, scriptable, lengthProperty);
        } else {
            obj = Undefined.instance;
        }
        setLengthProperty(context, scriptable, lengthProperty);
        return obj;
    }

    private static Object js_shift(Context context, Scriptable scriptable, Object[] objArr) {
        Object obj;
        if (scriptable instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly) {
                long j = nativeArray.length;
                if (j > 0) {
                    long j2 = j - 1;
                    nativeArray.length = j2;
                    Object[] objArr2 = nativeArray.dense;
                    Object obj2 = objArr2[0];
                    System.arraycopy(objArr2, 1, objArr2, 0, (int) j2);
                    nativeArray.dense[(int) nativeArray.length] = NOT_FOUND;
                    return obj2 == NOT_FOUND ? Undefined.instance : obj2;
                }
            }
        }
        long lengthProperty = getLengthProperty(context, scriptable);
        if (lengthProperty > 0) {
            lengthProperty--;
            obj = getElem(context, scriptable, 0L);
            if (lengthProperty > 0) {
                for (long j3 = 1; j3 <= lengthProperty; j3++) {
                    setRawElem(context, scriptable, j3 - 1, getRawElem(scriptable, j3));
                }
            }
        } else {
            obj = Undefined.instance;
        }
        setLengthProperty(context, scriptable, lengthProperty);
        return obj;
    }

    private static Object js_unshift(Context context, Scriptable scriptable, Object[] objArr) {
        int i = 0;
        if (scriptable instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly && nativeArray.ensureCapacity(((int) nativeArray.length) + objArr.length)) {
                Object[] objArr2 = nativeArray.dense;
                System.arraycopy(objArr2, 0, objArr2, objArr.length, (int) nativeArray.length);
                while (i < objArr.length) {
                    nativeArray.dense[i] = objArr[i];
                    i++;
                }
                long length = nativeArray.length + objArr.length;
                nativeArray.length = length;
                return ScriptRuntime.wrapNumber(length);
            }
        }
        long lengthProperty = getLengthProperty(context, scriptable);
        int length2 = objArr.length;
        if (objArr.length > 0) {
            if (lengthProperty > 0) {
                for (long j = lengthProperty - 1; j >= 0; j--) {
                    setRawElem(context, scriptable, length2 + j, getRawElem(scriptable, j));
                }
            }
            while (i < objArr.length) {
                setElem(context, scriptable, i, objArr[i]);
                i++;
            }
            return setLengthProperty(context, scriptable, lengthProperty + objArr.length);
        }
        return ScriptRuntime.wrapNumber(lengthProperty);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x013f A[LOOP:1: B:71:0x013d->B:72:0x013f, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Object js_splice(org.mozilla.javascript.Context r25, org.mozilla.javascript.Scriptable r26, org.mozilla.javascript.Scriptable r27, java.lang.Object[] r28) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeArray.js_splice(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.Object[]):java.lang.Object");
    }

    private static Scriptable js_concat(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        long j;
        Scriptable topLevelScope = getTopLevelScope(scriptable);
        Function existingCtor = ScriptRuntime.getExistingCtor(context, topLevelScope, "Array");
        Scriptable construct = existingCtor.construct(context, topLevelScope, ScriptRuntime.emptyArgs);
        int i = 0;
        if ((scriptable2 instanceof NativeArray) && (construct instanceof NativeArray)) {
            NativeArray nativeArray = (NativeArray) scriptable2;
            NativeArray nativeArray2 = (NativeArray) construct;
            if (nativeArray.denseOnly && nativeArray2.denseOnly) {
                int i2 = (int) nativeArray.length;
                boolean z = true;
                for (int i3 = 0; i3 < objArr.length && z; i3++) {
                    if (objArr[i3] instanceof NativeArray) {
                        NativeArray nativeArray3 = (NativeArray) objArr[i3];
                        boolean z2 = nativeArray3.denseOnly;
                        i2 = (int) (i2 + nativeArray3.length);
                        z = z2;
                    } else {
                        i2++;
                    }
                }
                if (z && nativeArray2.ensureCapacity(i2)) {
                    System.arraycopy(nativeArray.dense, 0, nativeArray2.dense, 0, (int) nativeArray.length);
                    int i4 = (int) nativeArray.length;
                    for (int i5 = 0; i5 < objArr.length && z; i5++) {
                        if (objArr[i5] instanceof NativeArray) {
                            NativeArray nativeArray4 = (NativeArray) objArr[i5];
                            System.arraycopy(nativeArray4.dense, 0, nativeArray2.dense, i4, (int) nativeArray4.length);
                            i4 += (int) nativeArray4.length;
                        } else {
                            nativeArray2.dense[i4] = objArr[i5];
                            i4++;
                        }
                    }
                    nativeArray2.length = i2;
                    return construct;
                }
            }
        }
        long j2 = 0;
        if (ScriptRuntime.instanceOf(scriptable2, existingCtor, context)) {
            long lengthProperty = getLengthProperty(context, scriptable2);
            j = 0;
            while (j < lengthProperty) {
                Object rawElem = getRawElem(scriptable2, j);
                if (rawElem != NOT_FOUND) {
                    setElem(context, construct, j, rawElem);
                }
                j++;
            }
        } else {
            setElem(context, construct, 0L, scriptable2);
            j = 1;
        }
        while (i < objArr.length) {
            if (ScriptRuntime.instanceOf(objArr[i], existingCtor, context)) {
                Scriptable scriptable3 = (Scriptable) objArr[i];
                long lengthProperty2 = getLengthProperty(context, scriptable3);
                while (j2 < lengthProperty2) {
                    Object rawElem2 = getRawElem(scriptable3, j2);
                    if (rawElem2 != NOT_FOUND) {
                        setElem(context, construct, j, rawElem2);
                    }
                    j2++;
                    j++;
                }
            } else {
                setElem(context, construct, j, objArr[i]);
                j++;
            }
            i++;
            j2 = 0;
        }
        setLengthProperty(context, construct, j);
        return construct;
    }

    private Scriptable js_slice(Context context, Scriptable scriptable, Object[] objArr) {
        long sliceIndex;
        Scriptable newArray = context.newArray(getTopLevelScope(this), 0);
        long lengthProperty = getLengthProperty(context, scriptable);
        if (objArr.length == 0) {
            sliceIndex = 0;
        } else {
            sliceIndex = toSliceIndex(ScriptRuntime.toInteger(objArr[0]), lengthProperty);
            if (objArr.length != 1) {
                lengthProperty = toSliceIndex(ScriptRuntime.toInteger(objArr[1]), lengthProperty);
            }
        }
        for (long j = sliceIndex; j < lengthProperty; j++) {
            Object rawElem = getRawElem(scriptable, j);
            if (rawElem != NOT_FOUND) {
                setElem(context, newArray, j - sliceIndex, rawElem);
            }
        }
        setLengthProperty(context, newArray, Math.max(0L, lengthProperty - sliceIndex));
        return newArray;
    }

    private Object indexOfHelper(Context context, Scriptable scriptable, Object[] objArr, boolean z) {
        long integer;
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        long lengthProperty = getLengthProperty(context, scriptable);
        if (z) {
            if (objArr.length < 2) {
                integer = lengthProperty - 1;
            } else {
                integer = (long) ScriptRuntime.toInteger(objArr[1]);
                if (integer >= lengthProperty) {
                    integer = lengthProperty - 1;
                } else if (integer < 0) {
                    integer += lengthProperty;
                }
                if (integer < 0) {
                    return NEGATIVE_ONE;
                }
            }
        } else if (objArr.length < 2) {
            integer = 0;
        } else {
            integer = (long) ScriptRuntime.toInteger(objArr[1]);
            if (integer < 0) {
                integer += lengthProperty;
                if (integer < 0) {
                    integer = 0;
                }
            }
            if (integer > lengthProperty - 1) {
                return NEGATIVE_ONE;
            }
        }
        if (scriptable instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly) {
                if (!z) {
                    int i = (int) integer;
                    while (true) {
                        long j = i;
                        if (j >= lengthProperty) {
                            break;
                        } else if (nativeArray.dense[i] != Scriptable.NOT_FOUND && ScriptRuntime.shallowEq(nativeArray.dense[i], obj)) {
                            return Long.valueOf(j);
                        } else {
                            i++;
                        }
                    }
                } else {
                    for (int i2 = (int) integer; i2 >= 0; i2--) {
                        if (nativeArray.dense[i2] != Scriptable.NOT_FOUND && ScriptRuntime.shallowEq(nativeArray.dense[i2], obj)) {
                            return Long.valueOf(i2);
                        }
                    }
                }
                return NEGATIVE_ONE;
            }
        }
        if (z) {
            while (integer >= 0) {
                Object rawElem = getRawElem(scriptable, integer);
                if (rawElem != NOT_FOUND && ScriptRuntime.shallowEq(rawElem, obj)) {
                    return Long.valueOf(integer);
                }
                integer--;
            }
        } else {
            while (integer < lengthProperty) {
                Object rawElem2 = getRawElem(scriptable, integer);
                if (rawElem2 != NOT_FOUND && ScriptRuntime.shallowEq(rawElem2, obj)) {
                    return Long.valueOf(integer);
                }
                integer++;
            }
        }
        return NEGATIVE_ONE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Object iterativeMethod(Context context, int i, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        long j;
        long j2;
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        if (obj == null || !(obj instanceof Function)) {
            throw ScriptRuntime.notFunctionError(obj);
        }
        Function function = (Function) obj;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(function);
        Scriptable object = (objArr.length < 2 || objArr[1] == null || objArr[1] == Undefined.instance) ? topLevelScope : ScriptRuntime.toObject(context, scriptable, objArr[1]);
        long lengthProperty = getLengthProperty(context, scriptable2);
        Scriptable newArray = context.newArray(scriptable, i == 20 ? (int) lengthProperty : 0);
        long j3 = 0;
        long j4 = 0;
        while (j3 < lengthProperty) {
            Object[] objArr2 = new Object[3];
            Object rawElem = getRawElem(scriptable2, j3);
            if (rawElem != Scriptable.NOT_FOUND) {
                objArr2[0] = rawElem;
                objArr2[1] = Long.valueOf(j3);
                objArr2[2] = scriptable2;
                Object call = function.call(context, topLevelScope, object, objArr2);
                switch (i) {
                    case 17:
                        j = lengthProperty;
                        j2 = j4;
                        if (!ScriptRuntime.toBoolean(call)) {
                            return Boolean.FALSE;
                        }
                        break;
                    case 18:
                        if (ScriptRuntime.toBoolean(call)) {
                            j = lengthProperty;
                            long j5 = j4;
                            j4 = j5 + 1;
                            setElem(context, newArray, j5, objArr2[0]);
                            continue;
                            j3++;
                            lengthProperty = j;
                        }
                        break;
                    case 20:
                        setElem(context, newArray, j3, call);
                        break;
                    case 21:
                        if (ScriptRuntime.toBoolean(call)) {
                            return Boolean.TRUE;
                        }
                        break;
                }
                j4 = j2;
                j3++;
                lengthProperty = j;
            }
            j = lengthProperty;
            j2 = j4;
            j4 = j2;
            j3++;
            lengthProperty = j;
        }
        switch (i) {
            case 17:
                return Boolean.TRUE;
            case 18:
            case 20:
                return newArray;
            case 19:
            default:
                return Undefined.instance;
            case 21:
                return Boolean.FALSE;
        }
    }

    private Object reduceMethod(Context context, int i, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        if (obj == null || !(obj instanceof Function)) {
            throw ScriptRuntime.notFunctionError(obj);
        }
        Function function = (Function) obj;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(function);
        long lengthProperty = getLengthProperty(context, scriptable2);
        boolean z = i == 22;
        Object obj2 = objArr.length > 1 ? objArr[1] : Scriptable.NOT_FOUND;
        for (long j = 0; j < lengthProperty; j++) {
            long j2 = z ? j : (lengthProperty - 1) - j;
            Object rawElem = getRawElem(scriptable2, j2);
            if (rawElem != Scriptable.NOT_FOUND) {
                obj2 = obj2 == Scriptable.NOT_FOUND ? rawElem : function.call(context, topLevelScope, topLevelScope, new Object[]{obj2, rawElem, Long.valueOf(j2), scriptable2});
            }
        }
        if (obj2 != Scriptable.NOT_FOUND) {
            return obj2;
        }
        throw ScriptRuntime.typeError0("msg.empty.array.reduce");
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) > -1;
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return toArray(ScriptRuntime.emptyArgs);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        long j = this.length;
        if (j > 2147483647L) {
            throw new IllegalStateException();
        }
        int i = (int) j;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = get(i2);
        }
        return objArr;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        for (Object obj : collection) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.mozilla.javascript.ScriptableObject, java.util.List, java.util.Collection
    public int size() {
        long j = this.length;
        if (j <= 2147483647L) {
            return (int) j;
        }
        throw new IllegalStateException();
    }

    public Object get(long j) {
        if (j < 0 || j >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        Object rawElem = getRawElem(this, j);
        if (rawElem == Scriptable.NOT_FOUND || rawElem == Undefined.instance) {
            return null;
        }
        return rawElem instanceof Wrapper ? ((Wrapper) rawElem).unwrap() : rawElem;
    }

    @Override // java.util.List
    public Object get(int i) {
        return get(i);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        long j = this.length;
        if (j <= 2147483647L) {
            int i = (int) j;
            int i2 = 0;
            if (obj == null) {
                while (i2 < i) {
                    if (get(i2) == null) {
                        return i2;
                    }
                    i2++;
                }
                return -1;
            }
            while (i2 < i) {
                if (obj.equals(get(i2))) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        long j = this.length;
        if (j <= 2147483647L) {
            int i = (int) j;
            if (obj == null) {
                for (int i2 = i - 1; i2 >= 0; i2--) {
                    if (get(i2) == null) {
                        return i2;
                    }
                }
                return -1;
            }
            for (int i3 = i - 1; i3 >= 0; i3--) {
                if (obj.equals(get(i3))) {
                    return i3;
                }
            }
            return -1;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i) {
        long j = this.length;
        if (j <= 2147483647L) {
            int i2 = (int) j;
            if (i < 0 || i > i2) {
                throw new IndexOutOfBoundsException("Index: " + i);
            }
            return new ListIterator(i, i2) { // from class: org.mozilla.javascript.NativeArray.3
                int cursor;
                final /* synthetic */ int val$len;
                final /* synthetic */ int val$start;

                {
                    this.val$start = i;
                    this.val$len = i2;
                    this.cursor = i;
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public boolean hasNext() {
                    return this.cursor < this.val$len;
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public Object next() {
                    int i3 = this.cursor;
                    if (i3 == this.val$len) {
                        throw new NoSuchElementException();
                    }
                    NativeArray nativeArray = NativeArray.this;
                    this.cursor = i3 + 1;
                    return nativeArray.get(i3);
                }

                @Override // java.util.ListIterator
                public boolean hasPrevious() {
                    return this.cursor > 0;
                }

                @Override // java.util.ListIterator
                public Object previous() {
                    int i3 = this.cursor;
                    if (i3 == 0) {
                        throw new NoSuchElementException();
                    }
                    NativeArray nativeArray = NativeArray.this;
                    int i4 = i3 - 1;
                    this.cursor = i4;
                    return nativeArray.get(i4);
                }

                @Override // java.util.ListIterator
                public int nextIndex() {
                    return this.cursor;
                }

                @Override // java.util.ListIterator
                public int previousIndex() {
                    return this.cursor - 1;
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.ListIterator
                public void add(Object obj) {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.ListIterator
                public void set(Object obj) {
                    throw new UnsupportedOperationException();
                }
            };
        }
        throw new IllegalStateException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 3;
        if (length == 11) {
            char charAt = str.charAt(0);
            if (charAt == 'c') {
                str2 = "constructor";
                i = 1;
            } else if (charAt == 'l') {
                i = 16;
                str2 = "lastIndexOf";
            } else {
                if (charAt == 'r') {
                    i = 23;
                    str2 = "reduceRight";
                }
                str2 = null;
                i = 0;
            }
        } else if (length != 14) {
            switch (length) {
                case 3:
                    char charAt2 = str.charAt(0);
                    if (charAt2 == 'm') {
                        if (str.charAt(2) == 'p' && str.charAt(1) == 'a') {
                            return 20;
                        }
                    } else if (charAt2 == 'p' && str.charAt(2) == 'p' && str.charAt(1) == 'o') {
                        return 9;
                    }
                    str2 = null;
                    i = 0;
                    break;
                case 4:
                    char charAt3 = str.charAt(2);
                    if (charAt3 == 'i') {
                        i = 5;
                        str2 = "join";
                        break;
                    } else if (charAt3 == 'm') {
                        i = 21;
                        str2 = "some";
                        break;
                    } else if (charAt3 == 'r') {
                        i = 7;
                        str2 = "sort";
                        break;
                    } else {
                        if (charAt3 == 's') {
                            i = 8;
                            str2 = "push";
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    }
                case 5:
                    char charAt4 = str.charAt(1);
                    if (charAt4 != 'h') {
                        if (charAt4 != 'l') {
                            if (charAt4 == 'v') {
                                i = 17;
                                str2 = "every";
                                break;
                            }
                            str2 = null;
                            i = 0;
                            break;
                        } else {
                            str2 = "slice";
                            i = 14;
                            break;
                        }
                    } else {
                        i = 10;
                        str2 = "shift";
                        break;
                    }
                case 6:
                    char charAt5 = str.charAt(0);
                    if (charAt5 != 'c') {
                        if (charAt5 != 'f') {
                            if (charAt5 != 's') {
                                if (charAt5 == 'r') {
                                    i = 22;
                                    str2 = "reduce";
                                    break;
                                }
                                str2 = null;
                                i = 0;
                                break;
                            } else {
                                i = 12;
                                str2 = "splice";
                                break;
                            }
                        } else {
                            i = 18;
                            str2 = "filter";
                            break;
                        }
                    } else {
                        i = 13;
                        str2 = "concat";
                        break;
                    }
                case 7:
                    char charAt6 = str.charAt(0);
                    if (charAt6 == 'f') {
                        i = 19;
                        str2 = "forEach";
                        break;
                    } else if (charAt6 == 'i') {
                        i = 15;
                        str2 = "indexOf";
                        break;
                    } else if (charAt6 == 'r') {
                        i = 6;
                        str2 = "reverse";
                        break;
                    } else {
                        if (charAt6 == 'u') {
                            str2 = "unshift";
                            i = 11;
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    }
                case 8:
                    char charAt7 = str.charAt(3);
                    if (charAt7 != 'o') {
                        if (charAt7 == 't') {
                            str2 = "toString";
                            i = 2;
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        i = 4;
                        str2 = "toSource";
                        break;
                    }
                default:
                    str2 = null;
                    i = 0;
                    break;
            }
        } else {
            str2 = "toLocaleString";
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }
}
