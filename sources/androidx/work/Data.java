package androidx.work;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class Data {
    public static final int MAX_DATA_BYTES = 10240;
    Map<String, Object> mValues;
    private static final String TAG = Logger.tagWithPrefix("Data");
    public static final Data EMPTY = new Builder().build();

    Data() {
    }

    public Data(Data other) {
        this.mValues = new HashMap(other.mValues);
    }

    public Data(Map<String, ?> values) {
        this.mValues = new HashMap(values);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        Object obj = this.mValues.get(key);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : defaultValue;
    }

    public boolean[] getBooleanArray(String key) {
        Object obj = this.mValues.get(key);
        if (obj instanceof Boolean[]) {
            return convertToPrimitiveArray((Boolean[]) obj);
        }
        return null;
    }

    public byte getByte(String key, byte defaultValue) {
        Object obj = this.mValues.get(key);
        return obj instanceof Byte ? ((Byte) obj).byteValue() : defaultValue;
    }

    public byte[] getByteArray(String key) {
        Object obj = this.mValues.get(key);
        if (obj instanceof Byte[]) {
            return convertToPrimitiveArray((Byte[]) obj);
        }
        return null;
    }

    public int getInt(String key, int defaultValue) {
        Object obj = this.mValues.get(key);
        return obj instanceof Integer ? ((Integer) obj).intValue() : defaultValue;
    }

    public int[] getIntArray(String key) {
        Object obj = this.mValues.get(key);
        if (obj instanceof Integer[]) {
            return convertToPrimitiveArray((Integer[]) obj);
        }
        return null;
    }

    public long getLong(String key, long defaultValue) {
        Object obj = this.mValues.get(key);
        return obj instanceof Long ? ((Long) obj).longValue() : defaultValue;
    }

    public long[] getLongArray(String key) {
        Object obj = this.mValues.get(key);
        if (obj instanceof Long[]) {
            return convertToPrimitiveArray((Long[]) obj);
        }
        return null;
    }

    public float getFloat(String key, float defaultValue) {
        Object obj = this.mValues.get(key);
        return obj instanceof Float ? ((Float) obj).floatValue() : defaultValue;
    }

    public float[] getFloatArray(String key) {
        Object obj = this.mValues.get(key);
        if (obj instanceof Float[]) {
            return convertToPrimitiveArray((Float[]) obj);
        }
        return null;
    }

    public double getDouble(String key, double defaultValue) {
        Object obj = this.mValues.get(key);
        return obj instanceof Double ? ((Double) obj).doubleValue() : defaultValue;
    }

    public double[] getDoubleArray(String key) {
        Object obj = this.mValues.get(key);
        if (obj instanceof Double[]) {
            return convertToPrimitiveArray((Double[]) obj);
        }
        return null;
    }

    public String getString(String key) {
        Object obj = this.mValues.get(key);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public String[] getStringArray(String key) {
        Object obj = this.mValues.get(key);
        if (obj instanceof String[]) {
            return (String[]) obj;
        }
        return null;
    }

    public Map<String, Object> getKeyValueMap() {
        return Collections.unmodifiableMap(this.mValues);
    }

    public byte[] toByteArray() {
        return toByteArrayInternal(this);
    }

    public <T> boolean hasKeyWithValueOfType(String key, Class<T> klass) {
        Object obj = this.mValues.get(key);
        return obj != null && klass.isAssignableFrom(obj.getClass());
    }

    public int size() {
        return this.mValues.size();
    }

    public static byte[] toByteArrayInternal(Data data) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeInt(data.size());
                    for (Map.Entry<String, Object> entry : data.mValues.entrySet()) {
                        objectOutputStream2.writeUTF(entry.getKey());
                        objectOutputStream2.writeObject(entry.getValue());
                    }
                    try {
                        objectOutputStream2.close();
                    } catch (IOException e) {
                        Log.e(TAG, "Error in Data#toByteArray: ", e);
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        Log.e(TAG, "Error in Data#toByteArray: ", e2);
                    }
                    if (byteArrayOutputStream.size() > 10240) {
                        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                    }
                    return byteArrayOutputStream.toByteArray();
                } catch (IOException e3) {
                    e = e3;
                    objectOutputStream = objectOutputStream2;
                    Log.e(TAG, "Error in Data#toByteArray: ", e);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e4) {
                            Log.e(TAG, "Error in Data#toByteArray: ", e4);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e5) {
                        Log.e(TAG, "Error in Data#toByteArray: ", e5);
                    }
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e6) {
                            Log.e(TAG, "Error in Data#toByteArray: ", e6);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e7) {
                        Log.e(TAG, "Error in Data#toByteArray: ", e7);
                    }
                    throw th;
                }
            } catch (IOException e8) {
                e = e8;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x005d -> B:36:0x0062). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static androidx.work.Data fromByteArray(byte[] r7) {
        /*
            java.lang.String r0 = "Error in Data#fromByteArray: "
            int r1 = r7.length
            r2 = 10240(0x2800, float:1.4349E-41)
            if (r1 > r2) goto L80
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
            r2.<init>(r7)
            r7 = 0
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L3d java.lang.ClassNotFoundException -> L41 java.io.IOException -> L43
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L3d java.lang.ClassNotFoundException -> L41 java.io.IOException -> L43
            int r7 = r3.readInt()     // Catch: java.lang.ClassNotFoundException -> L39 java.io.IOException -> L3b java.lang.Throwable -> L68
        L1b:
            if (r7 <= 0) goto L2b
            java.lang.String r4 = r3.readUTF()     // Catch: java.lang.ClassNotFoundException -> L39 java.io.IOException -> L3b java.lang.Throwable -> L68
            java.lang.Object r5 = r3.readObject()     // Catch: java.lang.ClassNotFoundException -> L39 java.io.IOException -> L3b java.lang.Throwable -> L68
            r1.put(r4, r5)     // Catch: java.lang.ClassNotFoundException -> L39 java.io.IOException -> L3b java.lang.Throwable -> L68
            int r7 = r7 + (-1)
            goto L1b
        L2b:
            r3.close()     // Catch: java.io.IOException -> L2f
            goto L35
        L2f:
            r7 = move-exception
            java.lang.String r3 = androidx.work.Data.TAG
            android.util.Log.e(r3, r0, r7)
        L35:
            r2.close()     // Catch: java.io.IOException -> L5c
            goto L62
        L39:
            r7 = move-exception
            goto L47
        L3b:
            r7 = move-exception
            goto L47
        L3d:
            r1 = move-exception
            r3 = r7
            r7 = r1
            goto L69
        L41:
            r3 = move-exception
            goto L44
        L43:
            r3 = move-exception
        L44:
            r6 = r3
            r3 = r7
            r7 = r6
        L47:
            java.lang.String r4 = androidx.work.Data.TAG     // Catch: java.lang.Throwable -> L68
            android.util.Log.e(r4, r0, r7)     // Catch: java.lang.Throwable -> L68
            if (r3 == 0) goto L58
            r3.close()     // Catch: java.io.IOException -> L52
            goto L58
        L52:
            r7 = move-exception
            java.lang.String r3 = androidx.work.Data.TAG
            android.util.Log.e(r3, r0, r7)
        L58:
            r2.close()     // Catch: java.io.IOException -> L5c
            goto L62
        L5c:
            r7 = move-exception
            java.lang.String r2 = androidx.work.Data.TAG
            android.util.Log.e(r2, r0, r7)
        L62:
            androidx.work.Data r7 = new androidx.work.Data
            r7.<init>(r1)
            return r7
        L68:
            r7 = move-exception
        L69:
            if (r3 == 0) goto L75
            r3.close()     // Catch: java.io.IOException -> L6f
            goto L75
        L6f:
            r1 = move-exception
            java.lang.String r3 = androidx.work.Data.TAG
            android.util.Log.e(r3, r0, r1)
        L75:
            r2.close()     // Catch: java.io.IOException -> L79
            goto L7f
        L79:
            r1 = move-exception
            java.lang.String r2 = androidx.work.Data.TAG
            android.util.Log.e(r2, r0, r1)
        L7f:
            throw r7
        L80:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.fromByteArray(byte[]):androidx.work.Data");
    }

    public boolean equals(Object o) {
        boolean z;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Data data = (Data) o;
        Set<String> keySet = this.mValues.keySet();
        if (keySet.equals(data.mValues.keySet())) {
            for (String str : keySet) {
                Object obj = this.mValues.get(str);
                Object obj2 = data.mValues.get(str);
                if (obj == null || obj2 == null) {
                    if (obj == obj2) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                } else if ((obj instanceof Object[]) && (obj2 instanceof Object[])) {
                    z = Arrays.deepEquals((Object[]) obj, (Object[]) obj2);
                    continue;
                } else {
                    z = obj.equals(obj2);
                    continue;
                }
                if (!z) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.mValues.hashCode() * 31;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        if (!this.mValues.isEmpty()) {
            for (String str : this.mValues.keySet()) {
                sb.append(str);
                sb.append(" : ");
                Object obj = this.mValues.get(str);
                if (obj instanceof Object[]) {
                    sb.append(Arrays.toString((Object[]) obj));
                } else {
                    sb.append(obj);
                }
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static Boolean[] convertPrimitiveBooleanArray(boolean[] value) {
        Boolean[] boolArr = new Boolean[value.length];
        for (int i = 0; i < value.length; i++) {
            boolArr[i] = Boolean.valueOf(value[i]);
        }
        return boolArr;
    }

    public static Byte[] convertPrimitiveByteArray(byte[] value) {
        Byte[] bArr = new Byte[value.length];
        for (int i = 0; i < value.length; i++) {
            bArr[i] = Byte.valueOf(value[i]);
        }
        return bArr;
    }

    public static Integer[] convertPrimitiveIntArray(int[] value) {
        Integer[] numArr = new Integer[value.length];
        for (int i = 0; i < value.length; i++) {
            numArr[i] = Integer.valueOf(value[i]);
        }
        return numArr;
    }

    public static Long[] convertPrimitiveLongArray(long[] value) {
        Long[] lArr = new Long[value.length];
        for (int i = 0; i < value.length; i++) {
            lArr[i] = Long.valueOf(value[i]);
        }
        return lArr;
    }

    public static Float[] convertPrimitiveFloatArray(float[] value) {
        Float[] fArr = new Float[value.length];
        for (int i = 0; i < value.length; i++) {
            fArr[i] = Float.valueOf(value[i]);
        }
        return fArr;
    }

    public static Double[] convertPrimitiveDoubleArray(double[] value) {
        Double[] dArr = new Double[value.length];
        for (int i = 0; i < value.length; i++) {
            dArr[i] = Double.valueOf(value[i]);
        }
        return dArr;
    }

    public static boolean[] convertToPrimitiveArray(Boolean[] array) {
        boolean[] zArr = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            zArr[i] = array[i].booleanValue();
        }
        return zArr;
    }

    public static byte[] convertToPrimitiveArray(Byte[] array) {
        byte[] bArr = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            bArr[i] = array[i].byteValue();
        }
        return bArr;
    }

    public static int[] convertToPrimitiveArray(Integer[] array) {
        int[] iArr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            iArr[i] = array[i].intValue();
        }
        return iArr;
    }

    public static long[] convertToPrimitiveArray(Long[] array) {
        long[] jArr = new long[array.length];
        for (int i = 0; i < array.length; i++) {
            jArr[i] = array[i].longValue();
        }
        return jArr;
    }

    public static float[] convertToPrimitiveArray(Float[] array) {
        float[] fArr = new float[array.length];
        for (int i = 0; i < array.length; i++) {
            fArr[i] = array[i].floatValue();
        }
        return fArr;
    }

    public static double[] convertToPrimitiveArray(Double[] array) {
        double[] dArr = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            dArr[i] = array[i].doubleValue();
        }
        return dArr;
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private Map<String, Object> mValues = new HashMap();

        public Builder putBoolean(String key, boolean value) {
            this.mValues.put(key, Boolean.valueOf(value));
            return this;
        }

        public Builder putBooleanArray(String key, boolean[] value) {
            this.mValues.put(key, Data.convertPrimitiveBooleanArray(value));
            return this;
        }

        public Builder putByte(String key, byte value) {
            this.mValues.put(key, Byte.valueOf(value));
            return this;
        }

        public Builder putByteArray(String key, byte[] value) {
            this.mValues.put(key, Data.convertPrimitiveByteArray(value));
            return this;
        }

        public Builder putInt(String key, int value) {
            this.mValues.put(key, Integer.valueOf(value));
            return this;
        }

        public Builder putIntArray(String key, int[] value) {
            this.mValues.put(key, Data.convertPrimitiveIntArray(value));
            return this;
        }

        public Builder putLong(String key, long value) {
            this.mValues.put(key, Long.valueOf(value));
            return this;
        }

        public Builder putLongArray(String key, long[] value) {
            this.mValues.put(key, Data.convertPrimitiveLongArray(value));
            return this;
        }

        public Builder putFloat(String key, float value) {
            this.mValues.put(key, Float.valueOf(value));
            return this;
        }

        public Builder putFloatArray(String key, float[] value) {
            this.mValues.put(key, Data.convertPrimitiveFloatArray(value));
            return this;
        }

        public Builder putDouble(String key, double value) {
            this.mValues.put(key, Double.valueOf(value));
            return this;
        }

        public Builder putDoubleArray(String key, double[] value) {
            this.mValues.put(key, Data.convertPrimitiveDoubleArray(value));
            return this;
        }

        public Builder putString(String key, String value) {
            this.mValues.put(key, value);
            return this;
        }

        public Builder putStringArray(String key, String[] value) {
            this.mValues.put(key, value);
            return this;
        }

        public Builder putAll(Data data) {
            putAll(data.mValues);
            return this;
        }

        public Builder putAll(Map<String, Object> values) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public Builder put(String key, Object value) {
            if (value == null) {
                this.mValues.put(key, null);
            } else {
                Class<?> cls = value.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    this.mValues.put(key, value);
                } else if (cls == boolean[].class) {
                    this.mValues.put(key, Data.convertPrimitiveBooleanArray((boolean[]) value));
                } else if (cls == byte[].class) {
                    this.mValues.put(key, Data.convertPrimitiveByteArray((byte[]) value));
                } else if (cls == int[].class) {
                    this.mValues.put(key, Data.convertPrimitiveIntArray((int[]) value));
                } else if (cls == long[].class) {
                    this.mValues.put(key, Data.convertPrimitiveLongArray((long[]) value));
                } else if (cls == float[].class) {
                    this.mValues.put(key, Data.convertPrimitiveFloatArray((float[]) value));
                } else if (cls == double[].class) {
                    this.mValues.put(key, Data.convertPrimitiveDoubleArray((double[]) value));
                } else {
                    throw new IllegalArgumentException(String.format("Key %s has invalid type %s", key, cls));
                }
            }
            return this;
        }

        public Data build() {
            Data data = new Data(this.mValues);
            Data.toByteArrayInternal(data);
            return data;
        }
    }
}
