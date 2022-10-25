package org.mozilla.javascript;

import com.fasterxml.jackson.core.JsonPointer;
import okhttp3.internal.p045ws.WebSocketProtocol;

/* loaded from: classes5.dex */
public class Decompiler {
    public static final int CASE_GAP_PROP = 3;
    private static final int FUNCTION_END = 164;
    public static final int INDENT_GAP_PROP = 2;
    public static final int INITIAL_INDENT_PROP = 1;
    public static final int ONLY_BODY_FLAG = 1;
    public static final int TO_SOURCE_FLAG = 2;
    private static final boolean printSource = false;
    private char[] sourceBuffer = new char[128];
    private int sourceTop;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getEncodedSource() {
        return sourceToString(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentOffset() {
        return this.sourceTop;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int markFunctionStart(int i) {
        int currentOffset = getCurrentOffset();
        addToken(109);
        append((char) i);
        return currentOffset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int markFunctionEnd(int i) {
        int currentOffset = getCurrentOffset();
        append((char) 164);
        return currentOffset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addToken(int i) {
        if (i < 0 || i > 163) {
            throw new IllegalArgumentException();
        }
        append((char) i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addEOL(int i) {
        if (i < 0 || i > 163) {
            throw new IllegalArgumentException();
        }
        append((char) i);
        append((char) 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addName(String str) {
        addToken(39);
        appendString(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addString(String str) {
        addToken(41);
        appendString(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addRegexp(String str, String str2) {
        addToken(48);
        appendString(JsonPointer.SEPARATOR + str + JsonPointer.SEPARATOR + str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addNumber(double d) {
        addToken(40);
        long j = (long) d;
        if (j != d) {
            long doubleToLongBits = Double.doubleToLongBits(d);
            append('D');
            append((char) (doubleToLongBits >> 48));
            append((char) (doubleToLongBits >> 32));
            append((char) (doubleToLongBits >> 16));
            append((char) doubleToLongBits);
            return;
        }
        if (j < 0) {
            Kit.codeBug();
        }
        if (j <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            append('S');
            append((char) j);
            return;
        }
        append('J');
        append((char) (j >> 48));
        append((char) (j >> 32));
        append((char) (j >> 16));
        append((char) j);
    }

    private void appendString(String str) {
        int length = str.length();
        int i = this.sourceTop + (length >= 32768 ? 2 : 1) + length;
        if (i > this.sourceBuffer.length) {
            increaseSourceCapacity(i);
        }
        if (length >= 32768) {
            char[] cArr = this.sourceBuffer;
            int i2 = this.sourceTop;
            cArr[i2] = (char) (32768 | (length >>> 16));
            this.sourceTop = i2 + 1;
        }
        char[] cArr2 = this.sourceBuffer;
        int i3 = this.sourceTop;
        cArr2[i3] = (char) length;
        int i4 = i3 + 1;
        this.sourceTop = i4;
        str.getChars(0, length, cArr2, i4);
        this.sourceTop = i;
    }

    private void append(char c) {
        int i = this.sourceTop;
        if (i == this.sourceBuffer.length) {
            increaseSourceCapacity(i + 1);
        }
        char[] cArr = this.sourceBuffer;
        int i2 = this.sourceTop;
        cArr[i2] = c;
        this.sourceTop = i2 + 1;
    }

    private void increaseSourceCapacity(int i) {
        if (i <= this.sourceBuffer.length) {
            Kit.codeBug();
        }
        char[] cArr = this.sourceBuffer;
        int length = cArr.length * 2;
        if (length >= i) {
            i = length;
        }
        char[] cArr2 = new char[i];
        System.arraycopy(cArr, 0, cArr2, 0, this.sourceTop);
        this.sourceBuffer = cArr2;
    }

    private String sourceToString(int i) {
        if (i < 0 || this.sourceTop < i) {
            Kit.codeBug();
        }
        return new String(this.sourceBuffer, i, this.sourceTop - i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:132:0x0247, code lost:
        if (r4 != 164) goto L119;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String decompile(java.lang.String r17, int r18, org.mozilla.javascript.UintMap r19) {
        /*
            Method dump skipped, instructions count: 1384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Decompiler.decompile(java.lang.String, int, org.mozilla.javascript.UintMap):java.lang.String");
    }

    private static int getNext(String str, int i, int i2) {
        int i3 = i2 + 1;
        if (i3 < i) {
            return str.charAt(i3);
        }
        return 0;
    }

    private static int getSourceStringEnd(String str, int i) {
        return printSourceString(str, i, false, null);
    }

    private static int printSourceString(String str, int i, boolean z, StringBuffer stringBuffer) {
        int charAt = str.charAt(i);
        int i2 = i + 1;
        if ((32768 & charAt) != 0) {
            charAt = ((charAt & 32767) << 16) | str.charAt(i2);
            i2++;
        }
        if (stringBuffer != null) {
            String substring = str.substring(i2, i2 + charAt);
            if (!z) {
                stringBuffer.append(substring);
            } else {
                stringBuffer.append('\"');
                stringBuffer.append(ScriptRuntime.escapeString(substring));
                stringBuffer.append('\"');
            }
        }
        return i2 + charAt;
    }

    private static int printSourceNumber(String str, int i, StringBuffer stringBuffer) {
        int i2;
        char charAt = str.charAt(i);
        int i3 = i + 1;
        if (charAt == 'S') {
            r1 = stringBuffer != null ? str.charAt(i3) : 0.0d;
            i2 = i3 + 1;
        } else if (charAt != 'J' && charAt != 'D') {
            throw new RuntimeException();
        } else {
            if (stringBuffer != null) {
                long charAt2 = (str.charAt(i3) << 48) | (str.charAt(i3 + 1) << 32) | (str.charAt(i3 + 2) << 16) | str.charAt(i3 + 3);
                r1 = charAt == 'J' ? charAt2 : Double.longBitsToDouble(charAt2);
            }
            i2 = i3 + 4;
        }
        if (stringBuffer != null) {
            stringBuffer.append(ScriptRuntime.numberToString(r1, 10));
        }
        return i2;
    }
}
