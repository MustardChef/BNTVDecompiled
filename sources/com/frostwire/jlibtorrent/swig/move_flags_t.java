package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public final class move_flags_t {
    public static final move_flags_t always_replace_files;
    public static final move_flags_t dont_replace;
    public static final move_flags_t fail_if_exist;
    private static int swigNext;
    private static move_flags_t[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        move_flags_t move_flags_tVar = new move_flags_t("always_replace_files");
        always_replace_files = move_flags_tVar;
        move_flags_t move_flags_tVar2 = new move_flags_t("fail_if_exist");
        fail_if_exist = move_flags_tVar2;
        move_flags_t move_flags_tVar3 = new move_flags_t("dont_replace");
        dont_replace = move_flags_tVar3;
        swigValues = new move_flags_t[]{move_flags_tVar, move_flags_tVar2, move_flags_tVar3};
        swigNext = 0;
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static move_flags_t swigToEnum(int i) {
        move_flags_t[] move_flags_tVarArr = swigValues;
        if (i < move_flags_tVarArr.length && i >= 0 && move_flags_tVarArr[i].swigValue == i) {
            return move_flags_tVarArr[i];
        }
        int i2 = 0;
        while (true) {
            move_flags_t[] move_flags_tVarArr2 = swigValues;
            if (i2 < move_flags_tVarArr2.length) {
                if (move_flags_tVarArr2[i2].swigValue == i) {
                    return move_flags_tVarArr2[i2];
                }
                i2++;
            } else {
                throw new IllegalArgumentException("No enum " + move_flags_t.class + " with value " + i);
            }
        }
    }

    private move_flags_t(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private move_flags_t(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private move_flags_t(String str, move_flags_t move_flags_tVar) {
        this.swigName = str;
        int i = move_flags_tVar.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
