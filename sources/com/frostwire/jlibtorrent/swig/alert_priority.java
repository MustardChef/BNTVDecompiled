package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public final class alert_priority {
    public static final alert_priority alert_priority_critical;
    public static final alert_priority alert_priority_high;
    public static final alert_priority alert_priority_normal;
    private static int swigNext;
    private static alert_priority[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        alert_priority alert_priorityVar = new alert_priority("alert_priority_normal", libtorrent_jni.alert_priority_normal_get());
        alert_priority_normal = alert_priorityVar;
        alert_priority alert_priorityVar2 = new alert_priority("alert_priority_high");
        alert_priority_high = alert_priorityVar2;
        alert_priority alert_priorityVar3 = new alert_priority("alert_priority_critical");
        alert_priority_critical = alert_priorityVar3;
        swigValues = new alert_priority[]{alert_priorityVar, alert_priorityVar2, alert_priorityVar3};
        swigNext = 0;
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static alert_priority swigToEnum(int i) {
        alert_priority[] alert_priorityVarArr = swigValues;
        if (i < alert_priorityVarArr.length && i >= 0 && alert_priorityVarArr[i].swigValue == i) {
            return alert_priorityVarArr[i];
        }
        int i2 = 0;
        while (true) {
            alert_priority[] alert_priorityVarArr2 = swigValues;
            if (i2 < alert_priorityVarArr2.length) {
                if (alert_priorityVarArr2[i2].swigValue == i) {
                    return alert_priorityVarArr2[i2];
                }
                i2++;
            } else {
                throw new IllegalArgumentException("No enum " + alert_priority.class + " with value " + i);
            }
        }
    }

    private alert_priority(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private alert_priority(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private alert_priority(String str, alert_priority alert_priorityVar) {
        this.swigName = str;
        int i = alert_priorityVar.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
