package org.mozilla.javascript;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class ObjToIntMap implements Serializable {

    /* renamed from: A */
    private static final int f10727A = -1640531527;
    private static final Object DELETED = new Object();
    private static final boolean check = false;
    static final long serialVersionUID = -1542220580748809402L;
    private int keyCount;
    private transient Object[] keys;
    private transient int occupiedCount;
    private int power;
    private transient int[] values;

    private static int tableLookupStep(int i, int i2, int i3) {
        int i4 = 32 - (i3 * 2);
        if (i4 >= 0) {
            i >>>= i4;
        } else {
            i2 >>>= -i4;
        }
        return (i & i2) | 1;
    }

    /* loaded from: classes5.dex */
    public static class Iterator {
        private int cursor;
        private Object[] keys;
        ObjToIntMap master;
        private int remaining;
        private int[] values;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Iterator(ObjToIntMap objToIntMap) {
            this.master = objToIntMap;
        }

        final void init(Object[] objArr, int[] iArr, int i) {
            this.keys = objArr;
            this.values = iArr;
            this.cursor = -1;
            this.remaining = i;
        }

        public void start() {
            this.master.initIterator(this);
            next();
        }

        public boolean done() {
            return this.remaining < 0;
        }

        public void next() {
            if (this.remaining == -1) {
                Kit.codeBug();
            }
            if (this.remaining == 0) {
                this.remaining = -1;
                this.cursor = -1;
                return;
            }
            int i = this.cursor;
            while (true) {
                this.cursor = i + 1;
                Object obj = this.keys[this.cursor];
                if (obj == null || obj == ObjToIntMap.DELETED) {
                    i = this.cursor;
                } else {
                    this.remaining--;
                    return;
                }
            }
        }

        public Object getKey() {
            Object obj = this.keys[this.cursor];
            if (obj == UniqueTag.NULL_VALUE) {
                return null;
            }
            return obj;
        }

        public int getValue() {
            return this.values[this.cursor];
        }

        public void setValue(int i) {
            this.values[this.cursor] = i;
        }
    }

    public ObjToIntMap() {
        this(4);
    }

    public ObjToIntMap(int i) {
        if (i < 0) {
            Kit.codeBug();
        }
        int i2 = 2;
        while ((1 << i2) < (i * 4) / 3) {
            i2++;
        }
        this.power = i2;
    }

    public boolean isEmpty() {
        return this.keyCount == 0;
    }

    public int size() {
        return this.keyCount;
    }

    public boolean has(Object obj) {
        if (obj == null) {
            obj = UniqueTag.NULL_VALUE;
        }
        return findIndex(obj) >= 0;
    }

    public int get(Object obj, int i) {
        if (obj == null) {
            obj = UniqueTag.NULL_VALUE;
        }
        int findIndex = findIndex(obj);
        return findIndex >= 0 ? this.values[findIndex] : i;
    }

    public int getExisting(Object obj) {
        if (obj == null) {
            obj = UniqueTag.NULL_VALUE;
        }
        int findIndex = findIndex(obj);
        if (findIndex >= 0) {
            return this.values[findIndex];
        }
        Kit.codeBug();
        return 0;
    }

    public void put(Object obj, int i) {
        if (obj == null) {
            obj = UniqueTag.NULL_VALUE;
        }
        this.values[ensureIndex(obj)] = i;
    }

    public Object intern(Object obj) {
        boolean z;
        if (obj == null) {
            obj = UniqueTag.NULL_VALUE;
            z = true;
        } else {
            z = false;
        }
        int ensureIndex = ensureIndex(obj);
        this.values[ensureIndex] = 0;
        if (z) {
            return null;
        }
        return this.keys[ensureIndex];
    }

    public void remove(Object obj) {
        if (obj == null) {
            obj = UniqueTag.NULL_VALUE;
        }
        int findIndex = findIndex(obj);
        if (findIndex >= 0) {
            this.keys[findIndex] = DELETED;
            this.keyCount--;
        }
    }

    public void clear() {
        int length = this.keys.length;
        while (length != 0) {
            length--;
            this.keys[length] = null;
        }
        this.keyCount = 0;
        this.occupiedCount = 0;
    }

    public Iterator newIterator() {
        return new Iterator(this);
    }

    final void initIterator(Iterator iterator) {
        iterator.init(this.keys, this.values, this.keyCount);
    }

    public Object[] getKeys() {
        Object[] objArr = new Object[this.keyCount];
        getKeys(objArr, 0);
        return objArr;
    }

    public void getKeys(Object[] objArr, int i) {
        int i2 = this.keyCount;
        int i3 = 0;
        while (i2 != 0) {
            Object obj = this.keys[i3];
            if (obj != null && obj != DELETED) {
                if (obj == UniqueTag.NULL_VALUE) {
                    obj = null;
                }
                objArr[i] = obj;
                i++;
                i2--;
            }
            i3++;
        }
    }

    private int findIndex(Object obj) {
        if (this.keys != null) {
            int hashCode = obj.hashCode();
            int i = f10727A * hashCode;
            int i2 = this.power;
            int i3 = i >>> (32 - i2);
            Object obj2 = this.keys[i3];
            if (obj2 != null) {
                int i4 = 1 << i2;
                if (obj2 != obj && (this.values[i4 + i3] != hashCode || !obj2.equals(obj))) {
                    int i5 = i4 - 1;
                    int tableLookupStep = tableLookupStep(i, i5, this.power);
                    while (true) {
                        i3 = (i3 + tableLookupStep) & i5;
                        Object obj3 = this.keys[i3];
                        if (obj3 != null) {
                            if (obj3 == obj || (this.values[i4 + i3] == hashCode && obj3.equals(obj))) {
                                break;
                            }
                        } else {
                            return -1;
                        }
                    }
                }
                return i3;
            }
            return -1;
        }
        return -1;
    }

    private int insertNewKey(Object obj, int i) {
        int i2 = f10727A * i;
        int i3 = this.power;
        int i4 = i2 >>> (32 - i3);
        int i5 = 1 << i3;
        if (this.keys[i4] != null) {
            int i6 = i5 - 1;
            int tableLookupStep = tableLookupStep(i2, i6, i3);
            do {
                i4 = (i4 + tableLookupStep) & i6;
            } while (this.keys[i4] != null);
            this.keys[i4] = obj;
            this.values[i5 + i4] = i;
            this.occupiedCount++;
            this.keyCount++;
            return i4;
        }
        this.keys[i4] = obj;
        this.values[i5 + i4] = i;
        this.occupiedCount++;
        this.keyCount++;
        return i4;
    }

    private void rehashTable() {
        Object[] objArr = this.keys;
        if (objArr == null) {
            int i = 1 << this.power;
            this.keys = new Object[i];
            this.values = new int[i * 2];
            return;
        }
        int i2 = this.keyCount;
        if (i2 * 2 >= this.occupiedCount) {
            this.power++;
        }
        int i3 = 1 << this.power;
        int[] iArr = this.values;
        int length = objArr.length;
        this.keys = new Object[i3];
        this.values = new int[i3 * 2];
        int i4 = 0;
        this.keyCount = 0;
        this.occupiedCount = 0;
        while (i2 != 0) {
            Object obj = objArr[i4];
            if (obj != null && obj != DELETED) {
                this.values[insertNewKey(obj, iArr[length + i4])] = iArr[i4];
                i2--;
            }
            i4++;
        }
    }

    private int ensureIndex(Object obj) {
        int i;
        int hashCode = obj.hashCode();
        Object[] objArr = this.keys;
        if (objArr != null) {
            int i2 = f10727A * hashCode;
            int i3 = this.power;
            i = i2 >>> (32 - i3);
            Object obj2 = objArr[i];
            if (obj2 != null) {
                int i4 = 1 << i3;
                if (obj2 != obj && (this.values[i4 + i] != hashCode || !obj2.equals(obj))) {
                    r2 = obj2 == DELETED ? i : -1;
                    int i5 = i4 - 1;
                    int tableLookupStep = tableLookupStep(i2, i5, this.power);
                    while (true) {
                        i = (i + tableLookupStep) & i5;
                        Object obj3 = this.keys[i];
                        if (obj3 != null) {
                            if (obj3 == obj || (this.values[i4 + i] == hashCode && obj3.equals(obj))) {
                                break;
                            } else if (obj3 == DELETED && r2 < 0) {
                                r2 = i;
                            }
                        } else {
                            break;
                        }
                    }
                }
                return i;
            }
        } else {
            i = -1;
        }
        if (r2 < 0) {
            if (this.keys != null) {
                int i6 = this.occupiedCount;
                if (i6 * 4 < (1 << this.power) * 3) {
                    this.occupiedCount = i6 + 1;
                    r2 = i;
                }
            }
            rehashTable();
            return insertNewKey(obj, hashCode);
        }
        this.keys[r2] = obj;
        this.values[(1 << this.power) + r2] = hashCode;
        this.keyCount++;
        return r2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int i = this.keyCount;
        int i2 = 0;
        while (i != 0) {
            Object obj = this.keys[i2];
            if (obj != null && obj != DELETED) {
                i--;
                objectOutputStream.writeObject(obj);
                objectOutputStream.writeInt(this.values[i2]);
            }
            i2++;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int i = this.keyCount;
        if (i != 0) {
            this.keyCount = 0;
            int i2 = 1 << this.power;
            this.keys = new Object[i2];
            this.values = new int[i2 * 2];
            for (int i3 = 0; i3 != i; i3++) {
                Object readObject = objectInputStream.readObject();
                this.values[insertNewKey(readObject, readObject.hashCode())] = objectInputStream.readInt();
            }
        }
    }
}
