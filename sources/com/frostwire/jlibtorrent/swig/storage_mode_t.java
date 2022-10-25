package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public final class storage_mode_t {
    public static final storage_mode_t storage_mode_allocate;
    public static final storage_mode_t storage_mode_sparse;
    private static int swigNext;
    private static storage_mode_t[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        storage_mode_t storage_mode_tVar = new storage_mode_t("storage_mode_allocate");
        storage_mode_allocate = storage_mode_tVar;
        storage_mode_t storage_mode_tVar2 = new storage_mode_t("storage_mode_sparse");
        storage_mode_sparse = storage_mode_tVar2;
        swigValues = new storage_mode_t[]{storage_mode_tVar, storage_mode_tVar2};
        swigNext = 0;
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static storage_mode_t swigToEnum(int i) {
        storage_mode_t[] storage_mode_tVarArr = swigValues;
        if (i < storage_mode_tVarArr.length && i >= 0 && storage_mode_tVarArr[i].swigValue == i) {
            return storage_mode_tVarArr[i];
        }
        int i2 = 0;
        while (true) {
            storage_mode_t[] storage_mode_tVarArr2 = swigValues;
            if (i2 < storage_mode_tVarArr2.length) {
                if (storage_mode_tVarArr2[i2].swigValue == i) {
                    return storage_mode_tVarArr2[i2];
                }
                i2++;
            } else {
                throw new IllegalArgumentException("No enum " + storage_mode_t.class + " with value " + i);
            }
        }
    }

    private storage_mode_t(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private storage_mode_t(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private storage_mode_t(String str, storage_mode_t storage_mode_tVar) {
        this.swigName = str;
        int i = storage_mode_tVar.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
