package org.mozilla.javascript;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes5.dex */
public abstract class IdScriptableObject extends ScriptableObject implements IdFunctionCall {
    private transient PrototypeValues prototypeValues;

    /* JADX INFO: Access modifiers changed from: protected */
    public static int instanceIdInfo(int i, int i2) {
        return (i << 16) | i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int findInstanceIdInfo(String str) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getMaxInstanceId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class PrototypeValues implements Serializable {
        private static final int NAME_SLOT = 1;
        private static final int SLOT_SPAN = 2;
        static final long serialVersionUID = 3038645279153854371L;
        private short[] attributeArray;
        private IdFunctionObject constructor;
        private short constructorAttrs;
        int constructorId;
        private int maxId;
        private IdScriptableObject obj;
        private Object[] valueArray;

        PrototypeValues(IdScriptableObject idScriptableObject, int i) {
            if (idScriptableObject == null) {
                throw new IllegalArgumentException();
            }
            if (i < 1) {
                throw new IllegalArgumentException();
            }
            this.obj = idScriptableObject;
            this.maxId = i;
        }

        final int getMaxId() {
            return this.maxId;
        }

        final void initValue(int i, String str, Object obj, int i2) {
            if (1 > i || i > this.maxId) {
                throw new IllegalArgumentException();
            }
            if (str == null) {
                throw new IllegalArgumentException();
            }
            if (obj == Scriptable.NOT_FOUND) {
                throw new IllegalArgumentException();
            }
            ScriptableObject.checkValidAttributes(i2);
            if (this.obj.findPrototypeId(str) != i) {
                throw new IllegalArgumentException(str);
            }
            if (i == this.constructorId) {
                if (!(obj instanceof IdFunctionObject)) {
                    throw new IllegalArgumentException("consructor should be initialized with IdFunctionObject");
                }
                this.constructor = (IdFunctionObject) obj;
                this.constructorAttrs = (short) i2;
                return;
            }
            initSlot(i, str, obj, i2);
        }

        private void initSlot(int i, String str, Object obj, int i2) {
            Object[] objArr = this.valueArray;
            if (objArr == null) {
                throw new IllegalStateException();
            }
            if (obj == null) {
                obj = UniqueTag.NULL_VALUE;
            }
            int i3 = i - 1;
            int i4 = i3 * 2;
            synchronized (this) {
                if (objArr[i4] == null) {
                    objArr[i4] = obj;
                    objArr[i4 + 1] = str;
                    this.attributeArray[i3] = (short) i2;
                } else if (!str.equals(objArr[i4 + 1])) {
                    throw new IllegalStateException();
                }
            }
        }

        final IdFunctionObject createPrecachedConstructor() {
            if (this.constructorId != 0) {
                throw new IllegalStateException();
            }
            int findPrototypeId = this.obj.findPrototypeId("constructor");
            this.constructorId = findPrototypeId;
            if (findPrototypeId == 0) {
                throw new IllegalStateException("No id for constructor property");
            }
            this.obj.initPrototypeId(findPrototypeId);
            IdFunctionObject idFunctionObject = this.constructor;
            if (idFunctionObject == null) {
                throw new IllegalStateException(this.obj.getClass().getName() + ".initPrototypeId() did not initialize id=" + this.constructorId);
            }
            idFunctionObject.initFunction(this.obj.getClassName(), ScriptableObject.getTopLevelScope(this.obj));
            this.constructor.markAsConstructor(this.obj);
            return this.constructor;
        }

        final int findId(String str) {
            return this.obj.findPrototypeId(str);
        }

        final boolean has(int i) {
            Object obj;
            Object[] objArr = this.valueArray;
            return objArr == null || (obj = objArr[(i - 1) * 2]) == null || obj != Scriptable.NOT_FOUND;
        }

        final Object get(int i) {
            Object ensureId = ensureId(i);
            if (ensureId == UniqueTag.NULL_VALUE) {
                return null;
            }
            return ensureId;
        }

        final void set(int i, Scriptable scriptable, Object obj) {
            if (obj == Scriptable.NOT_FOUND) {
                throw new IllegalArgumentException();
            }
            ensureId(i);
            int i2 = i - 1;
            if ((this.attributeArray[i2] & 1) == 0) {
                if (scriptable == this.obj) {
                    if (obj == null) {
                        obj = UniqueTag.NULL_VALUE;
                    }
                    int i3 = i2 * 2;
                    synchronized (this) {
                        this.valueArray[i3] = obj;
                    }
                    return;
                }
                scriptable.put((String) this.valueArray[(i2 * 2) + 1], scriptable, obj);
            }
        }

        final void delete(int i) {
            ensureId(i);
            int i2 = i - 1;
            if ((this.attributeArray[i2] & 4) == 0) {
                int i3 = i2 * 2;
                synchronized (this) {
                    this.valueArray[i3] = Scriptable.NOT_FOUND;
                    this.attributeArray[i2] = 0;
                }
            }
        }

        final int getAttributes(int i) {
            ensureId(i);
            return this.attributeArray[i - 1];
        }

        final void setAttributes(int i, int i2) {
            ScriptableObject.checkValidAttributes(i2);
            ensureId(i);
            synchronized (this) {
                this.attributeArray[i - 1] = (short) i2;
            }
        }

        final Object[] getNames(boolean z, Object[] objArr) {
            Object[] objArr2 = null;
            int i = 0;
            for (int i2 = 1; i2 <= this.maxId; i2++) {
                Object ensureId = ensureId(i2);
                if ((z || (this.attributeArray[i2 - 1] & 2) == 0) && ensureId != Scriptable.NOT_FOUND) {
                    String str = (String) this.valueArray[((i2 - 1) * 2) + 1];
                    if (objArr2 == null) {
                        objArr2 = new Object[this.maxId];
                    }
                    objArr2[i] = str;
                    i++;
                }
            }
            if (i == 0) {
                return objArr;
            }
            if (objArr == null || objArr.length == 0) {
                if (i != objArr2.length) {
                    Object[] objArr3 = new Object[i];
                    System.arraycopy(objArr2, 0, objArr3, 0, i);
                    return objArr3;
                }
                return objArr2;
            }
            int length = objArr.length;
            Object[] objArr4 = new Object[length + i];
            System.arraycopy(objArr, 0, objArr4, 0, length);
            System.arraycopy(objArr2, 0, objArr4, length, i);
            return objArr4;
        }

        private Object ensureId(int i) {
            Object[] objArr = this.valueArray;
            if (objArr == null) {
                synchronized (this) {
                    objArr = this.valueArray;
                    if (objArr == null) {
                        int i2 = this.maxId;
                        Object[] objArr2 = new Object[i2 * 2];
                        this.valueArray = objArr2;
                        this.attributeArray = new short[i2];
                        objArr = objArr2;
                    }
                }
            }
            int i3 = (i - 1) * 2;
            Object obj = objArr[i3];
            if (obj == null) {
                int i4 = this.constructorId;
                if (i == i4) {
                    initSlot(i4, "constructor", this.constructor, this.constructorAttrs);
                    this.constructor = null;
                } else {
                    this.obj.initPrototypeId(i);
                }
                obj = objArr[i3];
                if (obj == null) {
                    throw new IllegalStateException(this.obj.getClass().getName() + ".initPrototypeId(int id) did not initialize id=" + i);
                }
            }
            return obj;
        }
    }

    public IdScriptableObject() {
    }

    public IdScriptableObject(Scriptable scriptable, Scriptable scriptable2) {
        super(scriptable, scriptable2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object defaultGet(String str) {
        return super.get(str, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void defaultPut(String str, Object obj) {
        super.put(str, this, obj);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        int findId;
        int findInstanceIdInfo = findInstanceIdInfo(str);
        if (findInstanceIdInfo != 0) {
            if (((findInstanceIdInfo >>> 16) & 4) != 0) {
                return true;
            }
            return NOT_FOUND != getInstanceIdValue(65535 & findInstanceIdInfo);
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues != null && (findId = prototypeValues.findId(str)) != 0) {
            return this.prototypeValues.has(findId);
        }
        return super.has(str, scriptable);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        int findId;
        Object obj;
        Object instanceIdValue;
        Object obj2 = super.get(str, scriptable);
        if (obj2 != NOT_FOUND) {
            return obj2;
        }
        int findInstanceIdInfo = findInstanceIdInfo(str);
        if (findInstanceIdInfo == 0 || (instanceIdValue = getInstanceIdValue(findInstanceIdInfo & 65535)) == NOT_FOUND) {
            PrototypeValues prototypeValues = this.prototypeValues;
            return (prototypeValues == null || (findId = prototypeValues.findId(str)) == 0 || (obj = this.prototypeValues.get(findId)) == NOT_FOUND) ? NOT_FOUND : obj;
        }
        return instanceIdValue;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        int findId;
        int findInstanceIdInfo = findInstanceIdInfo(str);
        if (findInstanceIdInfo != 0) {
            if (scriptable == this && isSealed()) {
                throw Context.reportRuntimeError1("msg.modify.sealed", str);
            }
            if (((findInstanceIdInfo >>> 16) & 1) == 0) {
                if (scriptable == this) {
                    setInstanceIdValue(65535 & findInstanceIdInfo, obj);
                    return;
                } else {
                    scriptable.put(str, scriptable, obj);
                    return;
                }
            }
            return;
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues != null && (findId = prototypeValues.findId(str)) != 0) {
            if (scriptable == this && isSealed()) {
                throw Context.reportRuntimeError1("msg.modify.sealed", str);
            }
            this.prototypeValues.set(findId, scriptable, obj);
            return;
        }
        super.put(str, scriptable, obj);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void delete(String str) {
        int findId;
        int findInstanceIdInfo = findInstanceIdInfo(str);
        if (findInstanceIdInfo != 0 && !isSealed()) {
            if (((findInstanceIdInfo >>> 16) & 4) == 0) {
                setInstanceIdValue(65535 & findInstanceIdInfo, NOT_FOUND);
                return;
            }
            return;
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues != null && (findId = prototypeValues.findId(str)) != 0) {
            if (isSealed()) {
                return;
            }
            this.prototypeValues.delete(findId);
            return;
        }
        super.delete(str);
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public int getAttributes(String str) {
        int findId;
        int findInstanceIdInfo = findInstanceIdInfo(str);
        if (findInstanceIdInfo != 0) {
            return findInstanceIdInfo >>> 16;
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues != null && (findId = prototypeValues.findId(str)) != 0) {
            return this.prototypeValues.getAttributes(findId);
        }
        return super.getAttributes(str);
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public void setAttributes(String str, int i) {
        int findId;
        ScriptableObject.checkValidAttributes(i);
        int findInstanceIdInfo = findInstanceIdInfo(str);
        if (findInstanceIdInfo != 0) {
            int i2 = 65535 & findInstanceIdInfo;
            if (i != (findInstanceIdInfo >>> 16)) {
                setInstanceIdAttributes(i2, i);
                return;
            }
            return;
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues != null && (findId = prototypeValues.findId(str)) != 0) {
            this.prototypeValues.setAttributes(findId, i);
        } else {
            super.setAttributes(str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.ScriptableObject
    public Object[] getIds(boolean z) {
        Object[] ids = super.getIds(z);
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues != null) {
            ids = prototypeValues.getNames(z, ids);
        }
        int maxInstanceId = getMaxInstanceId();
        if (maxInstanceId != 0) {
            Object[] objArr = null;
            int i = 0;
            while (maxInstanceId != 0) {
                String instanceIdName = getInstanceIdName(maxInstanceId);
                int findInstanceIdInfo = findInstanceIdInfo(instanceIdName);
                if (findInstanceIdInfo != 0) {
                    int i2 = findInstanceIdInfo >>> 16;
                    if (((i2 & 4) != 0 || NOT_FOUND != getInstanceIdValue(maxInstanceId)) && (z || (i2 & 2) == 0)) {
                        if (i == 0) {
                            objArr = new Object[maxInstanceId];
                        }
                        objArr[i] = instanceIdName;
                        i++;
                    }
                }
                maxInstanceId--;
            }
            if (i != 0) {
                if (ids.length == 0 && objArr.length == i) {
                    return objArr;
                }
                Object[] objArr2 = new Object[ids.length + i];
                System.arraycopy(ids, 0, objArr2, 0, ids.length);
                System.arraycopy(objArr, 0, objArr2, ids.length, i);
                return objArr2;
            }
            return ids;
        }
        return ids;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getInstanceIdName(int i) {
        throw new IllegalArgumentException(String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object getInstanceIdValue(int i) {
        throw new IllegalStateException(String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setInstanceIdValue(int i, Object obj) {
        throw new IllegalStateException(String.valueOf(i));
    }

    protected void setInstanceIdAttributes(int i, int i2) {
        throw ScriptRuntime.constructError("InternalError", "Changing attributes not supported for " + getClassName() + " " + getInstanceIdName(i) + " property");
    }

    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        throw idFunctionObject.unknown();
    }

    public final IdFunctionObject exportAsJSClass(int i, Scriptable scriptable, boolean z) {
        if (scriptable != this && scriptable != null) {
            setParentScope(scriptable);
            setPrototype(getObjectPrototype(scriptable));
        }
        activatePrototypeMap(i);
        IdFunctionObject createPrecachedConstructor = this.prototypeValues.createPrecachedConstructor();
        if (z) {
            sealObject();
        }
        fillConstructorProperties(createPrecachedConstructor);
        if (z) {
            createPrecachedConstructor.sealObject();
        }
        createPrecachedConstructor.exportAsScopeProperty();
        return createPrecachedConstructor;
    }

    public final boolean hasPrototypeMap() {
        return this.prototypeValues != null;
    }

    public final void activatePrototypeMap(int i) {
        PrototypeValues prototypeValues = new PrototypeValues(this, i);
        synchronized (this) {
            if (this.prototypeValues != null) {
                throw new IllegalStateException();
            }
            this.prototypeValues = prototypeValues;
        }
    }

    public final void initPrototypeMethod(Object obj, int i, String str, int i2) {
        this.prototypeValues.initValue(i, str, newIdFunction(obj, i, str, i2, ScriptableObject.getTopLevelScope(this)), 2);
    }

    public final void initPrototypeConstructor(IdFunctionObject idFunctionObject) {
        int i = this.prototypeValues.constructorId;
        if (i == 0) {
            throw new IllegalStateException();
        }
        if (idFunctionObject.methodId() != i) {
            throw new IllegalArgumentException();
        }
        if (isSealed()) {
            idFunctionObject.sealObject();
        }
        this.prototypeValues.initValue(i, "constructor", idFunctionObject, 2);
    }

    public final void initPrototypeValue(int i, String str, Object obj, int i2) {
        this.prototypeValues.initValue(i, str, obj, i2);
    }

    protected void initPrototypeId(int i) {
        throw new IllegalStateException(String.valueOf(i));
    }

    protected int findPrototypeId(String str) {
        throw new IllegalStateException(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addIdFunctionProperty(Scriptable scriptable, Object obj, int i, String str, int i2) {
        newIdFunction(obj, i, str, i2, ScriptableObject.getTopLevelScope(scriptable)).addAsProperty(scriptable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static EcmaError incompatibleCallError(IdFunctionObject idFunctionObject) {
        throw ScriptRuntime.typeError1("msg.incompat.call", idFunctionObject.getFunctionName());
    }

    private IdFunctionObject newIdFunction(Object obj, int i, String str, int i2, Scriptable scriptable) {
        IdFunctionObject idFunctionObject = new IdFunctionObject(this, obj, i, str, i2, scriptable);
        if (isSealed()) {
            idFunctionObject.sealObject();
        }
        return idFunctionObject;
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public void defineOwnProperty(Context context, Object obj, ScriptableObject scriptableObject) {
        int findId;
        if (obj instanceof String) {
            String str = (String) obj;
            int findInstanceIdInfo = findInstanceIdInfo(str);
            if (findInstanceIdInfo != 0) {
                int i = 65535 & findInstanceIdInfo;
                if (isAccessorDescriptor(scriptableObject)) {
                    delete(i);
                } else {
                    checkPropertyDefinition(scriptableObject);
                    checkPropertyChange(str, getOwnPropertyDescriptor(context, obj), scriptableObject);
                    int i2 = findInstanceIdInfo >>> 16;
                    Object property = getProperty(scriptableObject, "value");
                    if (property != NOT_FOUND && (i2 & 1) == 0 && !sameValue(property, getInstanceIdValue(i))) {
                        setInstanceIdValue(i, property);
                    }
                    setAttributes(str, applyDescriptorToAttributeBitset(i2, scriptableObject));
                    return;
                }
            }
            PrototypeValues prototypeValues = this.prototypeValues;
            if (prototypeValues != null && (findId = prototypeValues.findId(str)) != 0) {
                if (isAccessorDescriptor(scriptableObject)) {
                    this.prototypeValues.delete(findId);
                } else {
                    checkPropertyDefinition(scriptableObject);
                    checkPropertyChange(str, getOwnPropertyDescriptor(context, obj), scriptableObject);
                    int attributes = this.prototypeValues.getAttributes(findId);
                    Object property2 = getProperty(scriptableObject, "value");
                    if (property2 != NOT_FOUND && (attributes & 1) == 0 && !sameValue(property2, this.prototypeValues.get(findId))) {
                        this.prototypeValues.set(findId, this, property2);
                    }
                    this.prototypeValues.setAttributes(findId, applyDescriptorToAttributeBitset(attributes, scriptableObject));
                    return;
                }
            }
        }
        super.defineOwnProperty(context, obj, scriptableObject);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.ScriptableObject
    public ScriptableObject getOwnPropertyDescriptor(Context context, Object obj) {
        ScriptableObject ownPropertyDescriptor = super.getOwnPropertyDescriptor(context, obj);
        return (ownPropertyDescriptor == null && (obj instanceof String)) ? getBuiltInDescriptor((String) obj) : ownPropertyDescriptor;
    }

    private ScriptableObject getBuiltInDescriptor(String str) {
        int findId;
        Scriptable parentScope = getParentScope();
        if (parentScope == null) {
            parentScope = this;
        }
        int findInstanceIdInfo = findInstanceIdInfo(str);
        if (findInstanceIdInfo != 0) {
            return buildDataDescriptor(parentScope, getInstanceIdValue(65535 & findInstanceIdInfo), findInstanceIdInfo >>> 16);
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues == null || (findId = prototypeValues.findId(str)) == 0) {
            return null;
        }
        return buildDataDescriptor(parentScope, this.prototypeValues.get(findId), this.prototypeValues.getAttributes(findId));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt != 0) {
            activatePrototypeMap(readInt);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        PrototypeValues prototypeValues = this.prototypeValues;
        objectOutputStream.writeInt(prototypeValues != null ? prototypeValues.getMaxId() : 0);
    }
}
