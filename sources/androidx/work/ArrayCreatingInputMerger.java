package androidx.work;

import androidx.work.Data;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class ArrayCreatingInputMerger extends InputMerger {
    @Override // androidx.work.InputMerger
    public Data merge(List<Data> inputs) {
        Data.Builder builder = new Data.Builder();
        HashMap hashMap = new HashMap();
        for (Data data : inputs) {
            for (Map.Entry<String, Object> entry : data.getKeyValueMap().entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                Class<?> cls = value.getClass();
                Object obj = hashMap.get(key);
                if (obj == null) {
                    if (!cls.isArray()) {
                        value = createArrayFor(value);
                    }
                } else {
                    Class<?> cls2 = obj.getClass();
                    if (cls2.equals(cls)) {
                        if (cls2.isArray()) {
                            value = concatenateArrays(obj, value);
                        } else {
                            value = concatenateNonArrays(obj, value);
                        }
                    } else if (cls2.isArray() && cls2.getComponentType().equals(cls)) {
                        value = concatenateArrayAndNonArray(obj, value);
                    } else if (cls.isArray() && cls.getComponentType().equals(cls2)) {
                        value = concatenateArrayAndNonArray(value, obj);
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                hashMap.put(key, value);
            }
        }
        builder.putAll(hashMap);
        return builder.build();
    }

    private Object concatenateArrays(Object array1, Object array2) {
        int length = Array.getLength(array1);
        int length2 = Array.getLength(array2);
        Object newInstance = Array.newInstance(array1.getClass().getComponentType(), length + length2);
        System.arraycopy(array1, 0, newInstance, 0, length);
        System.arraycopy(array2, 0, newInstance, length, length2);
        return newInstance;
    }

    private Object concatenateNonArrays(Object obj1, Object obj2) {
        Object newInstance = Array.newInstance(obj1.getClass(), 2);
        Array.set(newInstance, 0, obj1);
        Array.set(newInstance, 1, obj2);
        return newInstance;
    }

    private Object concatenateArrayAndNonArray(Object array, Object obj) {
        int length = Array.getLength(array);
        Object newInstance = Array.newInstance(obj.getClass(), length + 1);
        System.arraycopy(array, 0, newInstance, 0, length);
        Array.set(newInstance, length, obj);
        return newInstance;
    }

    private Object createArrayFor(Object obj) {
        Object newInstance = Array.newInstance(obj.getClass(), 1);
        Array.set(newInstance, 0, obj);
        return newInstance;
    }
}
