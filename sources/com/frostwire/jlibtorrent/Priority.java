package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.byte_vector;
import com.frostwire.jlibtorrent.swig.int_vector;

/* loaded from: classes2.dex */
public enum Priority {
    IGNORE(0),
    NORMAL(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7);
    
    private final int swigValue;

    Priority(int i) {
        this.swigValue = i;
    }

    public int swig() {
        return this.swigValue;
    }

    public static Priority fromSwig(int i) {
        Priority[] priorityArr;
        for (Priority priority : (Priority[]) Priority.class.getEnumConstants()) {
            if (priority.swig() == i) {
                return priority;
            }
        }
        throw new IllegalArgumentException("Invalid native value");
    }

    public static Priority[] array(Priority priority, int i) {
        Priority[] priorityArr = new Priority[i];
        for (int i2 = 0; i2 < i; i2++) {
            priorityArr[i2] = priority;
        }
        return priorityArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int_vector array2vector(Priority[] priorityArr) {
        int_vector int_vectorVar = new int_vector();
        for (Priority priority : priorityArr) {
            int_vectorVar.push_back(priority.swig());
        }
        return int_vectorVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte_vector array2byte_vector(Priority[] priorityArr) {
        byte_vector byte_vectorVar = new byte_vector();
        for (Priority priority : priorityArr) {
            byte_vectorVar.push_back((byte) priority.swig());
        }
        return byte_vectorVar;
    }
}
