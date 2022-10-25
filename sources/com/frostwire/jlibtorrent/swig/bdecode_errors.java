package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public final class bdecode_errors {
    public static final bdecode_errors bdecode_no_error;
    public static final bdecode_errors depth_exceeded;
    public static final bdecode_errors error_code_max;
    public static final bdecode_errors expected_colon;
    public static final bdecode_errors expected_digit;
    public static final bdecode_errors expected_value;
    public static final bdecode_errors limit_exceeded;
    public static final bdecode_errors overflow;
    private static int swigNext;
    private static bdecode_errors[] swigValues;
    public static final bdecode_errors unexpected_eof;
    private final String swigName;
    private final int swigValue;

    static {
        bdecode_errors bdecode_errorsVar = new bdecode_errors("bdecode_no_error", libtorrent_jni.bdecode_no_error_get());
        bdecode_no_error = bdecode_errorsVar;
        bdecode_errors bdecode_errorsVar2 = new bdecode_errors("expected_digit");
        expected_digit = bdecode_errorsVar2;
        bdecode_errors bdecode_errorsVar3 = new bdecode_errors("expected_colon");
        expected_colon = bdecode_errorsVar3;
        bdecode_errors bdecode_errorsVar4 = new bdecode_errors("unexpected_eof");
        unexpected_eof = bdecode_errorsVar4;
        bdecode_errors bdecode_errorsVar5 = new bdecode_errors("expected_value");
        expected_value = bdecode_errorsVar5;
        bdecode_errors bdecode_errorsVar6 = new bdecode_errors("depth_exceeded");
        depth_exceeded = bdecode_errorsVar6;
        bdecode_errors bdecode_errorsVar7 = new bdecode_errors("limit_exceeded");
        limit_exceeded = bdecode_errorsVar7;
        bdecode_errors bdecode_errorsVar8 = new bdecode_errors("overflow");
        overflow = bdecode_errorsVar8;
        bdecode_errors bdecode_errorsVar9 = new bdecode_errors("error_code_max");
        error_code_max = bdecode_errorsVar9;
        swigValues = new bdecode_errors[]{bdecode_errorsVar, bdecode_errorsVar2, bdecode_errorsVar3, bdecode_errorsVar4, bdecode_errorsVar5, bdecode_errorsVar6, bdecode_errorsVar7, bdecode_errorsVar8, bdecode_errorsVar9};
        swigNext = 0;
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static bdecode_errors swigToEnum(int i) {
        bdecode_errors[] bdecode_errorsVarArr = swigValues;
        if (i < bdecode_errorsVarArr.length && i >= 0 && bdecode_errorsVarArr[i].swigValue == i) {
            return bdecode_errorsVarArr[i];
        }
        int i2 = 0;
        while (true) {
            bdecode_errors[] bdecode_errorsVarArr2 = swigValues;
            if (i2 < bdecode_errorsVarArr2.length) {
                if (bdecode_errorsVarArr2[i2].swigValue == i) {
                    return bdecode_errorsVarArr2[i2];
                }
                i2++;
            } else {
                throw new IllegalArgumentException("No enum " + bdecode_errors.class + " with value " + i);
            }
        }
    }

    private bdecode_errors(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private bdecode_errors(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private bdecode_errors(String str, bdecode_errors bdecode_errorsVar) {
        this.swigName = str;
        int i = bdecode_errorsVar.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
