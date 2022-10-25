package org.mozilla.javascript.tools.idswitch;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.mozilla.javascript.EvaluatorException;
import org.mozilla.javascript.tools.ToolErrorReporter;

/* loaded from: classes5.dex */
public class Main {
    private static final int GENERATED_TAG = 2;
    private static final String GENERATED_TAG_STR = "generated";
    private static final int NORMAL_LINE = 0;
    private static final int STRING_TAG = 3;
    private static final String STRING_TAG_STR = "string";
    private static final int SWITCH_TAG = 1;
    private static final String SWITCH_TAG_STR = "string_id_map";

    /* renamed from: P */
    private CodePrinter f10790P;

    /* renamed from: R */
    private ToolErrorReporter f10791R;
    private final List<IdValuePair> all_pairs = new ArrayList();
    private FileBody body;
    private String source_file;
    private int tag_definition_end;
    private int tag_value_end;
    private int tag_value_start;

    private static boolean is_value_type(int i) {
        return i == 3;
    }

    private static boolean is_white_space(int i) {
        return i == 32 || i == 9;
    }

    private static String tag_name(int i) {
        return i != -2 ? i != -1 ? i != 1 ? i != 2 ? "" : GENERATED_TAG_STR : SWITCH_TAG_STR : "/string_id_map" : "/generated";
    }

    void process_file(String str) throws IOException {
        InputStream fileInputStream;
        OutputStream fileOutputStream;
        this.source_file = str;
        this.body = new FileBody();
        if (str.equals("-")) {
            fileInputStream = System.in;
        } else {
            fileInputStream = new FileInputStream(str);
        }
        try {
            this.body.readData(new InputStreamReader(fileInputStream, "ASCII"));
            fileInputStream.close();
            process_file();
            if (this.body.wasModified()) {
                if (str.equals("-")) {
                    fileOutputStream = System.out;
                } else {
                    fileOutputStream = new FileOutputStream(str);
                }
                try {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                    this.body.writeData(outputStreamWriter);
                    outputStreamWriter.flush();
                } finally {
                    fileOutputStream.close();
                }
            }
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }

    private void process_file() {
        char[] buffer = this.body.getBuffer();
        this.body.startLineLoop();
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        while (this.body.nextLine()) {
            int lineBegin = this.body.getLineBegin();
            int lineEnd = this.body.getLineEnd();
            int extract_line_tag_id = extract_line_tag_id(buffer, lineBegin, lineEnd);
            boolean z = true;
            if (i == 0) {
                if (extract_line_tag_id == 1) {
                    this.all_pairs.clear();
                    i = 1;
                    i2 = -1;
                } else if (extract_line_tag_id == -1) {
                    continue;
                }
                z = false;
                continue;
            } else if (i != 1) {
                if (i == 2) {
                    if (extract_line_tag_id == 0) {
                        if (i2 < 0) {
                            i2 = lineBegin;
                        }
                    } else if (extract_line_tag_id != -2) {
                        continue;
                    } else {
                        if (i2 < 0) {
                            i2 = lineBegin;
                        }
                        i3 = lineBegin;
                        i = 1;
                    }
                }
                z = false;
                continue;
            } else {
                if (extract_line_tag_id == 0) {
                    look_for_id_definitions(buffer, lineBegin, lineEnd, false);
                } else if (extract_line_tag_id == 3) {
                    look_for_id_definitions(buffer, lineBegin, lineEnd, true);
                } else if (extract_line_tag_id == 2) {
                    if (i2 >= 0) {
                        continue;
                    } else {
                        i4 = this.tag_definition_end;
                        i5 = lineEnd;
                        i = 2;
                    }
                } else if (extract_line_tag_id != -1) {
                    continue;
                } else {
                    if (i2 >= 0 && !this.all_pairs.isEmpty()) {
                        generate_java_code();
                        if (this.body.setReplacement(i2, i3, this.f10790P.toString())) {
                            this.body.setReplacement(i4, i5, get_time_stamp());
                        }
                    }
                    i = 0;
                }
                z = false;
                continue;
            }
            if (z) {
                throw this.f10791R.runtimeError(ToolErrorReporter.getMessage("msg.idswitch.bad_tag_order", tag_name(extract_line_tag_id)), this.source_file, this.body.getLineNumber(), null, 0);
            }
        }
        if (i == 0) {
            return;
        }
        throw this.f10791R.runtimeError(ToolErrorReporter.getMessage("msg.idswitch.file_end_in_switch", tag_name(i)), this.source_file, this.body.getLineNumber(), null, 0);
    }

    private String get_time_stamp() {
        return new SimpleDateFormat(" 'Last update:' yyyy-MM-dd HH:mm:ss z").format(new Date());
    }

    private void generate_java_code() {
        this.f10790P.clear();
        IdValuePair[] idValuePairArr = new IdValuePair[this.all_pairs.size()];
        this.all_pairs.toArray(idValuePairArr);
        SwitchGenerator switchGenerator = new SwitchGenerator();
        switchGenerator.char_tail_test_threshold = 2;
        switchGenerator.setReporter(this.f10791R);
        switchGenerator.setCodePrinter(this.f10790P);
        switchGenerator.generateSwitch(idValuePairArr, "0");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0044, code lost:
        r7 = skip_white_space(r10, r5, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0048, code lost:
        if (r7 == r12) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004a, code lost:
        r8 = r10[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004c, code lost:
        if (r8 == '=') goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004e, code lost:
        if (r8 != '#') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0050, code lost:
        r1 = get_tag_id(r10, r0, r5, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0054, code lost:
        if (r1 == 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0056, code lost:
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0057, code lost:
        if (r8 != '#') goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0059, code lost:
        if (r3 == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005b, code lost:
        r1 = -r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0060, code lost:
        if (is_value_type(r1) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0062, code lost:
        r11 = "msg.idswitch.no_end_usage";
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0064, code lost:
        r9.tag_definition_end = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0068, code lost:
        if (r3 == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x006a, code lost:
        r11 = "msg.idswitch.no_end_with_value";
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0071, code lost:
        if (is_value_type(r1) != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0073, code lost:
        r11 = "msg.idswitch.no_value_allowed";
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0075, code lost:
        r1 = extract_tag_value(r10, r7 + 1, r12, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x007b, code lost:
        if (r11 != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0096, code lost:
        throw r9.f10791R.runtimeError(org.mozilla.javascript.tools.ToolErrorReporter.getMessage(r11, tag_name(r1)), r9.source_file, r9.body.getLineNumber(), null, 0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int extract_line_tag_id(char[] r10, int r11, int r12) {
        /*
            r9 = this;
            int r11 = skip_white_space(r10, r11, r12)
            int r0 = r9.look_for_slash_slash(r10, r11, r12)
            r1 = 0
            if (r0 == r12) goto L97
            int r11 = r11 + 2
            r2 = 1
            if (r11 != r0) goto L12
            r11 = 1
            goto L13
        L12:
            r11 = 0
        L13:
            int r0 = skip_white_space(r10, r0, r12)
            if (r0 == r12) goto L97
            char r3 = r10[r0]
            r4 = 35
            if (r3 != r4) goto L97
            int r0 = r0 + r2
            if (r0 == r12) goto L2c
            char r3 = r10[r0]
            r5 = 47
            if (r3 != r5) goto L2c
            int r0 = r0 + 1
            r3 = 1
            goto L2d
        L2c:
            r3 = 0
        L2d:
            r5 = r0
        L2e:
            r6 = 61
            if (r5 == r12) goto L42
            char r7 = r10[r5]
            if (r7 == r4) goto L42
            if (r7 == r6) goto L42
            boolean r7 = is_white_space(r7)
            if (r7 == 0) goto L3f
            goto L42
        L3f:
            int r5 = r5 + 1
            goto L2e
        L42:
            if (r5 == r12) goto L97
            int r7 = skip_white_space(r10, r5, r12)
            if (r7 == r12) goto L97
            char r8 = r10[r7]
            if (r8 == r6) goto L50
            if (r8 != r4) goto L97
        L50:
            int r1 = r9.get_tag_id(r10, r0, r5, r11)
            if (r1 == 0) goto L97
            r11 = 0
            if (r8 != r4) goto L68
            if (r3 == 0) goto L64
            int r1 = -r1
            boolean r10 = is_value_type(r1)
            if (r10 == 0) goto L64
            java.lang.String r11 = "msg.idswitch.no_end_usage"
        L64:
            int r7 = r7 + r2
            r9.tag_definition_end = r7
            goto L7b
        L68:
            if (r3 == 0) goto L6d
            java.lang.String r11 = "msg.idswitch.no_end_with_value"
            goto L75
        L6d:
            boolean r0 = is_value_type(r1)
            if (r0 != 0) goto L75
            java.lang.String r11 = "msg.idswitch.no_value_allowed"
        L75:
            int r7 = r7 + r2
            int r10 = r9.extract_tag_value(r10, r7, r12, r1)
            r1 = r10
        L7b:
            if (r11 != 0) goto L7e
            goto L97
        L7e:
            java.lang.String r10 = tag_name(r1)
            java.lang.String r1 = org.mozilla.javascript.tools.ToolErrorReporter.getMessage(r11, r10)
            org.mozilla.javascript.tools.ToolErrorReporter r0 = r9.f10791R
            java.lang.String r2 = r9.source_file
            org.mozilla.javascript.tools.idswitch.FileBody r10 = r9.body
            int r3 = r10.getLineNumber()
            r4 = 0
            r5 = 0
            org.mozilla.javascript.EvaluatorException r10 = r0.runtimeError(r1, r2, r3, r4, r5)
            throw r10
        L97:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.tools.idswitch.Main.extract_line_tag_id(char[], int, int):int");
    }

    private int look_for_slash_slash(char[] cArr, int i, int i2) {
        while (i + 2 <= i2) {
            int i3 = i + 1;
            if (cArr[i] == '/') {
                i = i3 + 1;
                if (cArr[i3] == '/') {
                    return i;
                }
            } else {
                i = i3;
            }
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int extract_tag_value(char[] r7, int r8, int r9, int r10) {
        /*
            r6 = this;
            int r8 = skip_white_space(r7, r8, r9)
            r0 = 0
            r1 = 1
            if (r8 == r9) goto L3a
            r2 = r8
        L9:
            if (r2 == r9) goto L2f
            char r3 = r7[r2]
            boolean r4 = is_white_space(r3)
            r5 = 35
            if (r4 == 0) goto L28
            int r3 = r2 + 1
            int r3 = skip_white_space(r7, r3, r9)
            if (r3 == r9) goto L24
            char r4 = r7[r3]
            if (r4 != r5) goto L24
            r7 = r2
            r2 = r3
            goto L30
        L24:
            int r3 = r3 + 1
            r2 = r3
            goto L9
        L28:
            if (r3 != r5) goto L2c
            r7 = r2
            goto L30
        L2c:
            int r2 = r2 + 1
            goto L9
        L2f:
            r7 = r8
        L30:
            if (r2 == r9) goto L3a
            r6.tag_value_start = r8
            r6.tag_value_end = r7
            int r2 = r2 + r1
            r6.tag_definition_end = r2
            goto L3b
        L3a:
            r1 = 0
        L3b:
            if (r1 == 0) goto L3e
            goto L3f
        L3e:
            r10 = 0
        L3f:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.tools.idswitch.Main.extract_tag_value(char[], int, int, int):int");
    }

    private int get_tag_id(char[] cArr, int i, int i2, boolean z) {
        if (z) {
            if (equals(SWITCH_TAG_STR, cArr, i, i2)) {
                return 1;
            }
            if (equals(GENERATED_TAG_STR, cArr, i, i2)) {
                return 2;
            }
        }
        return equals("string", cArr, i, i2) ? 3 : 0;
    }

    private void look_for_id_definitions(char[] cArr, int i, int i2, boolean z) {
        int skip_name_char;
        int skip_white_space;
        int i3;
        int i4;
        int skip_white_space2 = skip_white_space(cArr, i, i2);
        int skip_matched_prefix = skip_matched_prefix("Id_", cArr, skip_white_space2, i2);
        if (skip_matched_prefix < 0 || skip_matched_prefix == (skip_name_char = skip_name_char(cArr, skip_matched_prefix, i2)) || (skip_white_space = skip_white_space(cArr, skip_name_char, i2)) == i2 || cArr[skip_white_space] != '=') {
            return;
        }
        if (z) {
            i3 = this.tag_value_start;
            i4 = this.tag_value_end;
        } else {
            i3 = skip_matched_prefix;
            i4 = skip_name_char;
        }
        add_id(cArr, skip_white_space2, skip_name_char, i3, i4);
    }

    private void add_id(char[] cArr, int i, int i2, int i3, int i4) {
        IdValuePair idValuePair = new IdValuePair(new String(cArr, i3, i4 - i3), new String(cArr, i, i2 - i));
        idValuePair.setLineNumber(this.body.getLineNumber());
        this.all_pairs.add(idValuePair);
    }

    private static int skip_white_space(char[] cArr, int i, int i2) {
        while (i != i2 && is_white_space(cArr[i])) {
            i++;
        }
        return i;
    }

    private static int skip_matched_prefix(String str, char[] cArr, int i, int i2) {
        int length = str.length();
        if (length <= i2 - i) {
            int i3 = 0;
            while (i3 != length) {
                if (str.charAt(i3) != cArr[i]) {
                    return -1;
                }
                i3++;
                i++;
            }
            return i;
        }
        return -1;
    }

    private static boolean equals(String str, char[] cArr, int i, int i2) {
        if (str.length() == i2 - i) {
            int i3 = 0;
            while (i != i2) {
                if (cArr[i] != str.charAt(i3)) {
                    return false;
                }
                i++;
                i3++;
            }
            return true;
        }
        return false;
    }

    private static int skip_name_char(char[] cArr, int i, int i2) {
        while (i != i2) {
            char c = cArr[i];
            if (('a' > c || c > 'z') && (('A' > c || c > 'Z') && (('0' > c || c > '9') && c != '_'))) {
                break;
            }
            i++;
        }
        return i;
    }

    public static void main(String[] strArr) {
        System.exit(new Main().exec(strArr));
    }

    private int exec(String[] strArr) {
        this.f10791R = new ToolErrorReporter(true, System.err);
        int process_options = process_options(strArr);
        if (process_options == 0) {
            option_error(ToolErrorReporter.getMessage("msg.idswitch.no_file_argument"));
            return -1;
        } else if (process_options > 1) {
            option_error(ToolErrorReporter.getMessage("msg.idswitch.too_many_arguments"));
            return -1;
        } else {
            CodePrinter codePrinter = new CodePrinter();
            this.f10790P = codePrinter;
            codePrinter.setIndentStep(4);
            this.f10790P.setIndentTabSize(0);
            try {
                process_file(strArr[0]);
                return 0;
            } catch (IOException e) {
                print_error(ToolErrorReporter.getMessage("msg.idswitch.io_error", e.toString()));
                return -1;
            } catch (EvaluatorException unused) {
                return -1;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
        r5 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int process_options(java.lang.String[] r14) {
        /*
            r13 = this;
            int r0 = r14.length
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
        L5:
            r5 = -1
            r6 = 1
            if (r2 == r0) goto L66
            r7 = r14[r2]
            int r8 = r7.length()
            r9 = 2
            if (r8 < r9) goto L63
            char r10 = r7.charAt(r1)
            r11 = 45
            if (r10 != r11) goto L63
            char r10 = r7.charAt(r6)
            r12 = 0
            if (r10 != r11) goto L44
            if (r8 != r9) goto L26
            r14[r2] = r12
            goto L66
        L26:
            java.lang.String r8 = "--help"
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L30
            r3 = 1
            goto L61
        L30:
            java.lang.String r8 = "--version"
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L3a
            r4 = 1
            goto L61
        L3a:
            java.lang.String r0 = "msg.idswitch.bad_option"
            java.lang.String r0 = org.mozilla.javascript.tools.ToolErrorReporter.getMessage(r0, r7)
            r13.option_error(r0)
            goto L67
        L44:
            r9 = 1
        L45:
            if (r9 == r8) goto L61
            char r10 = r7.charAt(r9)
            r11 = 104(0x68, float:1.46E-43)
            if (r10 == r11) goto L5d
            java.lang.String r0 = java.lang.String.valueOf(r10)
            java.lang.String r2 = "msg.idswitch.bad_option_char"
            java.lang.String r0 = org.mozilla.javascript.tools.ToolErrorReporter.getMessage(r2, r0)
            r13.option_error(r0)
            goto L67
        L5d:
            int r9 = r9 + 1
            r3 = 1
            goto L45
        L61:
            r14[r2] = r12
        L63:
            int r2 = r2 + 1
            goto L5
        L66:
            r5 = 1
        L67:
            if (r5 != r6) goto L75
            if (r3 == 0) goto L6f
            r13.show_usage()
            r5 = 0
        L6f:
            if (r4 == 0) goto L75
            r13.show_version()
            goto L76
        L75:
            r1 = r5
        L76:
            if (r1 == r6) goto L7b
            java.lang.System.exit(r1)
        L7b:
            int r14 = r13.remove_nulls(r14)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.tools.idswitch.Main.process_options(java.lang.String[]):int");
    }

    private void show_usage() {
        System.out.println(ToolErrorReporter.getMessage("msg.idswitch.usage"));
        System.out.println();
    }

    private void show_version() {
        System.out.println(ToolErrorReporter.getMessage("msg.idswitch.version"));
    }

    private void option_error(String str) {
        print_error(ToolErrorReporter.getMessage("msg.idswitch.bad_invocation", str));
    }

    private void print_error(String str) {
        System.err.println(str);
    }

    private int remove_nulls(String[] strArr) {
        int length = strArr.length;
        int i = 0;
        while (i != length && strArr[i] != null) {
            i++;
        }
        if (i != length) {
            for (int i2 = i + 1; i2 != length; i2++) {
                String str = strArr[i2];
                if (str != null) {
                    strArr[i] = str;
                    i++;
                }
            }
        }
        return i;
    }
}
