package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public final class metric_type_t {
    public static final metric_type_t counter;
    public static final metric_type_t gauge;
    private static int swigNext;
    private static metric_type_t[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        metric_type_t metric_type_tVar = new metric_type_t("counter");
        counter = metric_type_tVar;
        metric_type_t metric_type_tVar2 = new metric_type_t("gauge");
        gauge = metric_type_tVar2;
        swigValues = new metric_type_t[]{metric_type_tVar, metric_type_tVar2};
        swigNext = 0;
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static metric_type_t swigToEnum(int i) {
        metric_type_t[] metric_type_tVarArr = swigValues;
        if (i < metric_type_tVarArr.length && i >= 0 && metric_type_tVarArr[i].swigValue == i) {
            return metric_type_tVarArr[i];
        }
        int i2 = 0;
        while (true) {
            metric_type_t[] metric_type_tVarArr2 = swigValues;
            if (i2 < metric_type_tVarArr2.length) {
                if (metric_type_tVarArr2[i2].swigValue == i) {
                    return metric_type_tVarArr2[i2];
                }
                i2++;
            } else {
                throw new IllegalArgumentException("No enum " + metric_type_t.class + " with value " + i);
            }
        }
    }

    private metric_type_t(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private metric_type_t(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private metric_type_t(String str, metric_type_t metric_type_tVar) {
        this.swigName = str;
        int i = metric_type_tVar.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
