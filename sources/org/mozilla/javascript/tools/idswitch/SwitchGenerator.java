package org.mozilla.javascript.tools.idswitch;

import org.mozilla.javascript.EvaluatorException;
import org.mozilla.javascript.tools.ToolErrorReporter;

/* loaded from: classes5.dex */
public class SwitchGenerator {

    /* renamed from: P */
    private CodePrinter f10792P;

    /* renamed from: R */
    private ToolErrorReporter f10793R;
    private boolean c_was_defined;
    private int[] columns;
    private String default_value;
    private IdValuePair[] pairs;
    private String source_file;
    String v_switch_label = "L0";
    String v_label = "L";
    String v_s = "s";
    String v_c = "c";
    String v_guess = "X";
    String v_id = "id";
    String v_length_suffix = "_length";
    int use_if_threshold = 3;
    int char_tail_test_threshold = 2;

    public CodePrinter getCodePrinter() {
        return this.f10792P;
    }

    public void setCodePrinter(CodePrinter codePrinter) {
        this.f10792P = codePrinter;
    }

    public ToolErrorReporter getReporter() {
        return this.f10793R;
    }

    public void setReporter(ToolErrorReporter toolErrorReporter) {
        this.f10793R = toolErrorReporter;
    }

    public String getSourceFileName() {
        return this.source_file;
    }

    public void setSourceFileName(String str) {
        this.source_file = str;
    }

    public void generateSwitch(String[] strArr, String str) {
        int length = strArr.length / 2;
        IdValuePair[] idValuePairArr = new IdValuePair[length];
        for (int i = 0; i != length; i++) {
            int i2 = i * 2;
            idValuePairArr[i] = new IdValuePair(strArr[i2], strArr[i2 + 1]);
        }
        generateSwitch(idValuePairArr, str);
    }

    public void generateSwitch(IdValuePair[] idValuePairArr, String str) {
        int length = idValuePairArr.length;
        if (length == 0) {
            return;
        }
        this.pairs = idValuePairArr;
        this.default_value = str;
        generate_body(0, length, 2);
    }

    private void generate_body(int i, int i2, int i3) {
        this.f10792P.indent(i3);
        this.f10792P.m41p(this.v_switch_label);
        this.f10792P.m41p(": { ");
        this.f10792P.m41p(this.v_id);
        this.f10792P.m41p(" = ");
        this.f10792P.m41p(this.default_value);
        this.f10792P.m41p("; String ");
        this.f10792P.m41p(this.v_guess);
        this.f10792P.m41p(" = null;");
        this.c_was_defined = false;
        int offset = this.f10792P.getOffset();
        this.f10792P.m41p(" int ");
        this.f10792P.m41p(this.v_c);
        this.f10792P.m43p(';');
        int offset2 = this.f10792P.getOffset();
        this.f10792P.m44nl();
        int i4 = i3 + 1;
        generate_length_switch(i, i2, i4);
        if (!this.c_was_defined) {
            this.f10792P.erase(offset, offset2);
        }
        this.f10792P.indent(i4);
        this.f10792P.m41p("if (");
        this.f10792P.m41p(this.v_guess);
        this.f10792P.m41p("!=null && ");
        this.f10792P.m41p(this.v_guess);
        this.f10792P.m41p("!=");
        this.f10792P.m41p(this.v_s);
        this.f10792P.m41p(" && !");
        this.f10792P.m41p(this.v_guess);
        this.f10792P.m41p(".equals(");
        this.f10792P.m41p(this.v_s);
        this.f10792P.m41p(")) ");
        this.f10792P.m41p(this.v_id);
        this.f10792P.m41p(" = ");
        this.f10792P.m41p(this.default_value);
        this.f10792P.m41p(";");
        this.f10792P.m44nl();
        this.f10792P.indent(i4);
        this.f10792P.m41p("break ");
        this.f10792P.m41p(this.v_switch_label);
        this.f10792P.m41p(";");
        this.f10792P.m44nl();
        this.f10792P.line(i3, "}");
    }

    private void generate_length_switch(int i, int i2, int i3) {
        boolean z;
        int i4;
        sort_pairs(i, i2, -1);
        check_all_is_different(i, i2);
        int count_different_lengths = count_different_lengths(i, i2);
        this.columns = new int[this.pairs[i2 - 1].idLength];
        int i5 = 0;
        if (count_different_lengths <= this.use_if_threshold) {
            if (count_different_lengths != 1) {
                this.f10792P.indent(i3);
                this.f10792P.m41p("int ");
                this.f10792P.m41p(this.v_s);
                this.f10792P.m41p(this.v_length_suffix);
                this.f10792P.m41p(" = ");
                this.f10792P.m41p(this.v_s);
                this.f10792P.m41p(".length();");
                this.f10792P.m44nl();
            }
            z = true;
        } else {
            this.f10792P.indent(i3);
            this.f10792P.m41p(this.v_label);
            this.f10792P.m41p(": switch (");
            this.f10792P.m41p(this.v_s);
            this.f10792P.m41p(".length()) {");
            this.f10792P.m44nl();
            z = false;
        }
        int i6 = this.pairs[i].idLength;
        int i7 = i;
        while (true) {
            int i8 = i7;
            while (true) {
                i4 = i8 + 1;
                if (i4 == i2 || (i5 = this.pairs[i4].idLength) != i6) {
                    break;
                }
                i8 = i4;
            }
            if (z) {
                this.f10792P.indent(i3);
                if (i7 != i) {
                    this.f10792P.m41p("else ");
                }
                this.f10792P.m41p("if (");
                if (count_different_lengths == 1) {
                    this.f10792P.m41p(this.v_s);
                    this.f10792P.m41p(".length()==");
                } else {
                    this.f10792P.m41p(this.v_s);
                    this.f10792P.m41p(this.v_length_suffix);
                    this.f10792P.m41p("==");
                }
                this.f10792P.m42p(i6);
                this.f10792P.m41p(") {");
            } else {
                this.f10792P.indent(i3);
                this.f10792P.m41p("case ");
                this.f10792P.m42p(i6);
                this.f10792P.m41p(":");
            }
            generate_letter_switch(i7, i4, i3 + 1, !z, z);
            if (z) {
                this.f10792P.m41p("}");
                this.f10792P.m44nl();
            } else {
                this.f10792P.m41p("break ");
                this.f10792P.m41p(this.v_label);
                this.f10792P.m41p(";");
                this.f10792P.m44nl();
            }
            if (i4 == i2) {
                break;
            }
            i6 = i5;
            i7 = i4;
        }
        if (z) {
            return;
        }
        this.f10792P.indent(i3);
        this.f10792P.m41p("}");
        this.f10792P.m44nl();
    }

    private void generate_letter_switch(int i, int i2, int i3, boolean z, boolean z2) {
        int i4 = this.pairs[i].idLength;
        for (int i5 = 0; i5 != i4; i5++) {
            this.columns[i5] = i5;
        }
        generate_letter_switch_r(i, i2, i4, i3, z, z2);
    }

    private boolean generate_letter_switch_r(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        int i5;
        boolean z6 = false;
        if (i + 1 == i2) {
            this.f10792P.m43p(' ');
            IdValuePair idValuePair = this.pairs[i];
            if (i3 > this.char_tail_test_threshold) {
                this.f10792P.m41p(this.v_guess);
                this.f10792P.m41p("=");
                this.f10792P.qstring(idValuePair.f10789id);
                this.f10792P.m41p(";");
                this.f10792P.m41p(this.v_id);
                this.f10792P.m41p("=");
                this.f10792P.m41p(idValuePair.value);
                this.f10792P.m41p(";");
            } else if (i3 == 0) {
                this.f10792P.m41p(this.v_id);
                this.f10792P.m41p("=");
                this.f10792P.m41p(idValuePair.value);
                this.f10792P.m41p("; break ");
                this.f10792P.m41p(this.v_switch_label);
                this.f10792P.m41p(";");
                z6 = true;
            } else {
                this.f10792P.m41p("if (");
                int i6 = this.columns[0];
                this.f10792P.m41p(this.v_s);
                this.f10792P.m41p(".charAt(");
                this.f10792P.m42p(i6);
                this.f10792P.m41p(")==");
                this.f10792P.qchar(idValuePair.f10789id.charAt(i6));
                for (int i7 = 1; i7 != i3; i7++) {
                    this.f10792P.m41p(" && ");
                    int i8 = this.columns[i7];
                    this.f10792P.m41p(this.v_s);
                    this.f10792P.m41p(".charAt(");
                    this.f10792P.m42p(i8);
                    this.f10792P.m41p(")==");
                    this.f10792P.qchar(idValuePair.f10789id.charAt(i8));
                }
                this.f10792P.m41p(") {");
                this.f10792P.m41p(this.v_id);
                this.f10792P.m41p("=");
                this.f10792P.m41p(idValuePair.value);
                this.f10792P.m41p("; break ");
                this.f10792P.m41p(this.v_switch_label);
                this.f10792P.m41p(";}");
            }
            this.f10792P.m43p(' ');
            return z6;
        }
        int find_max_different_column = find_max_different_column(i, i2, i3);
        int i9 = this.columns[find_max_different_column];
        int count_different_chars = count_different_chars(i, i2, i9);
        int[] iArr = this.columns;
        int i10 = i3 - 1;
        iArr[find_max_different_column] = iArr[i10];
        if (z2) {
            this.f10792P.m44nl();
            this.f10792P.indent(i4);
        } else {
            this.f10792P.m43p(' ');
        }
        if (count_different_chars <= this.use_if_threshold) {
            this.c_was_defined = true;
            this.f10792P.m41p(this.v_c);
            this.f10792P.m41p("=");
            this.f10792P.m41p(this.v_s);
            this.f10792P.m41p(".charAt(");
            this.f10792P.m42p(i9);
            this.f10792P.m41p(");");
            z4 = z;
            z5 = true;
        } else {
            if (z) {
                z3 = z;
            } else {
                this.f10792P.m41p(this.v_label);
                this.f10792P.m41p(": ");
                z3 = true;
            }
            this.f10792P.m41p("switch (");
            this.f10792P.m41p(this.v_s);
            this.f10792P.m41p(".charAt(");
            this.f10792P.m42p(i9);
            this.f10792P.m41p(")) {");
            z4 = z3;
            z5 = false;
        }
        char charAt = this.pairs[i].f10789id.charAt(i9);
        int i11 = i;
        int i12 = i11;
        char c = 0;
        while (true) {
            int i13 = i12 + 1;
            if (i13 == i2 || (c = this.pairs[i13].f10789id.charAt(i9)) != charAt) {
                char c2 = c;
                if (z5) {
                    this.f10792P.m44nl();
                    this.f10792P.indent(i4);
                    if (i11 != i) {
                        this.f10792P.m41p("else ");
                    }
                    this.f10792P.m41p("if (");
                    this.f10792P.m41p(this.v_c);
                    this.f10792P.m41p("==");
                    this.f10792P.qchar(charAt);
                    this.f10792P.m41p(") {");
                } else {
                    this.f10792P.m44nl();
                    this.f10792P.indent(i4);
                    this.f10792P.m41p("case ");
                    this.f10792P.qchar(charAt);
                    this.f10792P.m41p(":");
                }
                i5 = i9;
                boolean generate_letter_switch_r = generate_letter_switch_r(i11, i13, i10, i4 + 1, z4, z5);
                if (z5) {
                    this.f10792P.m41p("}");
                } else if (!generate_letter_switch_r) {
                    this.f10792P.m41p("break ");
                    this.f10792P.m41p(this.v_label);
                    this.f10792P.m41p(";");
                }
                if (i13 == i2) {
                    break;
                }
                i11 = i13;
                i12 = i11;
                charAt = c2;
                c = charAt;
                i9 = i5;
            } else {
                i12 = i13;
            }
        }
        if (z5) {
            this.f10792P.m44nl();
            if (z2) {
                this.f10792P.indent(i4 - 1);
            } else {
                this.f10792P.indent(i4);
            }
        } else {
            this.f10792P.m44nl();
            this.f10792P.indent(i4);
            this.f10792P.m41p("}");
            if (z2) {
                this.f10792P.m44nl();
                this.f10792P.indent(i4 - 1);
            } else {
                this.f10792P.m43p(' ');
            }
        }
        this.columns[find_max_different_column] = i5;
        return false;
    }

    private int count_different_lengths(int i, int i2) {
        int i3 = 0;
        int i4 = -1;
        while (i != i2) {
            int i5 = this.pairs[i].idLength;
            if (i4 != i5) {
                i3++;
                i4 = i5;
            }
            i++;
        }
        return i3;
    }

    private int find_max_different_column(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 != i3; i6++) {
            int i7 = this.columns[i6];
            sort_pairs(i, i2, i7);
            int count_different_chars = count_different_chars(i, i2, i7);
            if (count_different_chars == i2 - i) {
                return i6;
            }
            if (i5 < count_different_chars) {
                i4 = i6;
                i5 = count_different_chars;
            }
        }
        if (i4 != i3 - 1) {
            sort_pairs(i, i2, this.columns[i4]);
        }
        return i4;
    }

    private int count_different_chars(int i, int i2, int i3) {
        int i4 = 0;
        char c = 65535;
        while (i != i2) {
            char charAt = this.pairs[i].f10789id.charAt(i3);
            if (charAt != c) {
                i4++;
                c = charAt;
            }
            i++;
        }
        return i4;
    }

    private void check_all_is_different(int i, int i2) {
        if (i == i2) {
            return;
        }
        IdValuePair idValuePair = this.pairs[i];
        while (true) {
            i++;
            if (i == i2) {
                return;
            }
            IdValuePair idValuePair2 = this.pairs[i];
            if (idValuePair.f10789id.equals(idValuePair2.f10789id)) {
                throw on_same_pair_fail(idValuePair, idValuePair2);
            }
            idValuePair = idValuePair2;
        }
    }

    private EvaluatorException on_same_pair_fail(IdValuePair idValuePair, IdValuePair idValuePair2) {
        int i;
        int lineNumber = idValuePair.getLineNumber();
        int lineNumber2 = idValuePair2.getLineNumber();
        if (lineNumber2 > lineNumber) {
            i = lineNumber2;
        } else {
            i = lineNumber;
            lineNumber = lineNumber2;
        }
        return this.f10793R.runtimeError(ToolErrorReporter.getMessage("msg.idswitch.same_string", idValuePair.f10789id, new Integer(lineNumber)), this.source_file, i, null, 0);
    }

    private void sort_pairs(int i, int i2, int i3) {
        heap4Sort(this.pairs, i, i2 - i, i3);
    }

    private static boolean bigger(IdValuePair idValuePair, IdValuePair idValuePair2, int i) {
        if (i >= 0) {
            return idValuePair.f10789id.charAt(i) > idValuePair2.f10789id.charAt(i);
        }
        int i2 = idValuePair.idLength - idValuePair2.idLength;
        return i2 != 0 ? i2 > 0 : idValuePair.f10789id.compareTo(idValuePair2.f10789id) > 0;
    }

    private static void heap4Sort(IdValuePair[] idValuePairArr, int i, int i2, int i3) {
        if (i2 <= 1) {
            return;
        }
        makeHeap4(idValuePairArr, i, i2, i3);
        while (i2 > 1) {
            i2--;
            int i4 = i + i2;
            IdValuePair idValuePair = idValuePairArr[i4];
            int i5 = i + 0;
            idValuePairArr[i4] = idValuePairArr[i5];
            idValuePairArr[i5] = idValuePair;
            heapify4(idValuePairArr, i, i2, 0, i3);
        }
    }

    private static void makeHeap4(IdValuePair[] idValuePairArr, int i, int i2, int i3) {
        int i4 = (i2 + 2) >> 2;
        while (i4 != 0) {
            i4--;
            heapify4(idValuePairArr, i, i2, i4, i3);
        }
    }

    private static void heapify4(IdValuePair[] idValuePairArr, int i, int i2, int i3, int i4) {
        IdValuePair idValuePair = idValuePairArr[i + i3];
        while (true) {
            int i5 = i3 << 2;
            int i6 = i5 | 1;
            int i7 = i5 | 2;
            int i8 = i5 | 3;
            int i9 = i5 + 4;
            if (i9 >= i2) {
                if (i6 < i2) {
                    IdValuePair idValuePair2 = idValuePairArr[i + i6];
                    if (i7 != i2) {
                        IdValuePair idValuePair3 = idValuePairArr[i + i7];
                        if (bigger(idValuePair3, idValuePair2, i4)) {
                            i6 = i7;
                            idValuePair2 = idValuePair3;
                        }
                        if (i8 != i2) {
                            IdValuePair idValuePair4 = idValuePairArr[i + i8];
                            if (bigger(idValuePair4, idValuePair2, i4)) {
                                idValuePair2 = idValuePair4;
                                i6 = i8;
                            }
                        }
                    }
                    if (bigger(idValuePair2, idValuePair, i4)) {
                        idValuePairArr[i3 + i] = idValuePair2;
                        idValuePairArr[i + i6] = idValuePair;
                        return;
                    }
                    return;
                }
                return;
            }
            IdValuePair idValuePair5 = idValuePairArr[i + i6];
            IdValuePair idValuePair6 = idValuePairArr[i + i7];
            IdValuePair idValuePair7 = idValuePairArr[i + i8];
            IdValuePair idValuePair8 = idValuePairArr[i + i9];
            if (bigger(idValuePair6, idValuePair5, i4)) {
                i6 = i7;
                idValuePair5 = idValuePair6;
            }
            if (bigger(idValuePair8, idValuePair7, i4)) {
                i8 = i9;
                idValuePair7 = idValuePair8;
            }
            if (bigger(idValuePair7, idValuePair5, i4)) {
                i6 = i8;
                idValuePair5 = idValuePair7;
            }
            if (bigger(idValuePair, idValuePair5, i4)) {
                return;
            }
            idValuePairArr[i3 + i] = idValuePair5;
            idValuePairArr[i + i6] = idValuePair;
            i3 = i6;
        }
    }
}
