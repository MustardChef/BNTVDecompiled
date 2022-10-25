package org.mozilla.javascript;

import java.io.IOException;
import java.io.Reader;
import org.mozilla.javascript.Token;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class TokenStream {
    private static final char BYTE_ORDER_MARK = 65279;
    private static final int EOF_CHAR = -1;
    Token.CommentType commentType;
    int cursor;
    private boolean dirtyLine;
    private boolean isOctal;
    int lineno;
    private double number;
    private Parser parser;
    private int quoteChar;
    String regExpFlags;
    private char[] sourceBuffer;
    int sourceCursor;
    private int sourceEnd;
    private Reader sourceReader;
    private String sourceString;
    private int stringBufferTop;
    int tokenBeg;
    int tokenEnd;
    private int ungetCursor;
    private boolean xmlIsAttribute;
    private boolean xmlIsTagContent;
    private int xmlOpenTagsCount;
    private String string = "";
    private char[] stringBuffer = new char[128];
    private ObjToIntMap allStrings = new ObjToIntMap(50);
    private final int[] ungetBuffer = new int[3];
    private boolean hitEOF = false;
    private int lineStart = 0;
    private int lineEndChar = -1;
    private String commentPrefix = "";
    private int commentCursor = -1;

    private static boolean isAlpha(int i) {
        return i <= 90 ? 65 <= i : 97 <= i && i <= 122;
    }

    static boolean isDigit(int i) {
        return 48 <= i && i <= 57;
    }

    String tokenToString(int i) {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TokenStream(Parser parser, Reader reader, String str, int i) {
        this.parser = parser;
        this.lineno = i;
        if (reader != null) {
            if (str != null) {
                Kit.codeBug();
            }
            this.sourceReader = reader;
            this.sourceBuffer = new char[512];
            this.sourceEnd = 0;
        } else {
            if (str == null) {
                Kit.codeBug();
            }
            this.sourceString = str;
            this.sourceEnd = str.length();
        }
        this.cursor = 0;
        this.sourceCursor = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isKeyword(String str) {
        return stringToKeyword(str) != 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0205, code lost:
        if (r17.charAt(1) == 'n') goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0231, code lost:
        if (r17.charAt(1) == 'h') goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x029f, code lost:
        if (r17.charAt(1) == 'n') goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x02a1, code lost:
        r5 = 127;
     */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02df A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int stringToKeyword(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 798
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.TokenStream.stringToKeyword(java.lang.String):int");
    }

    final String getSourceString() {
        return this.sourceString;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getLineno() {
        return this.lineno;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String getString() {
        return this.string;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final char getQuoteChar() {
        return (char) this.quoteChar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final double getNumber() {
        return this.number;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isNumberOctal() {
        return this.isOctal;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean eof() {
        return this.hitEOF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00bd, code lost:
        if (r1 != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00bf, code lost:
        r1 = stringToKeyword(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00c3, code lost:
        if (r1 == 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c7, code lost:
        if (r1 == 153) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00cb, code lost:
        if (r1 != 72) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d7, code lost:
        if (r16.parser.compilerEnv.getLanguageVersion() >= 170) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00db, code lost:
        if (r1 != 153) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00dd, code lost:
        r1 = "let";
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00e0, code lost:
        r1 = "yield";
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00e2, code lost:
        r16.string = r1;
        r1 = 39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00e6, code lost:
        r16.string = (java.lang.String) r16.allStrings.intern(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f2, code lost:
        if (r1 == 127) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00f4, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00fd, code lost:
        if (r16.parser.compilerEnv.isReservedKeywordAsIdentifier() != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00ff, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0104, code lost:
        if (isKeyword(r2) == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0106, code lost:
        r2 = convertLastCharToHex(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x010a, code lost:
        r16.string = (java.lang.String) r16.allStrings.intern(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0114, code lost:
        return 39;
     */
    /* JADX WARN: Removed duplicated region for block: B:208:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x045b A[LOOP:6: B:373:0x045b->B:375:0x0461, LOOP_START, PHI: r1 
      PHI: (r1v27 int) = (r1v6 int), (r1v28 int) binds: [B:372:0x0459, B:375:0x0461] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0469 A[LOOP:9: B:376:0x0469->B:387:0x0487, LOOP_START, PHI: r1 r8 
      PHI: (r1v7 int) = (r1v6 int), (r1v8 int) binds: [B:372:0x0459, B:387:0x0487] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r8v4 int) = (r8v3 int), (r8v5 int) binds: [B:372:0x0459, B:387:0x0487] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:394:0x049b A[LOOP:7: B:394:0x049b->B:395:0x04a6, LOOP_START, PHI: r1 
      PHI: (r1v25 int) = (r1v9 int), (r1v26 int) binds: [B:393:0x0499, B:395:0x04a6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:396:0x04a8 A[PHI: r1 
      PHI: (r1v17 int) = (r1v9 int), (r1v26 int) binds: [B:393:0x0499, B:475:0x04a8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:407:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x04d3 A[LOOP:8: B:409:0x04d3->B:410:0x04de, LOOP_START, PHI: r1 
      PHI: (r1v21 int) = (r1v20 int), (r1v22 int) binds: [B:406:0x04c9, B:410:0x04de] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:442:0x0262 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0115  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:203:0x025b -> B:204:0x025c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:208:0x026f -> B:201:0x0255). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int getToken() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.TokenStream.getToken():int");
    }

    static boolean isJSSpace(int i) {
        return i <= 127 ? i == 32 || i == 9 || i == 12 || i == 11 : i == 160 || i == 65279 || Character.getType((char) i) == 12;
    }

    private static boolean isJSFormatChar(int i) {
        return i > 127 && Character.getType((char) i) == 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a7, code lost:
        ungetChar(r2);
        r5.tokenEnd = r5.cursor - 1;
        r5.string = new java.lang.String(r5.stringBuffer, 0, r5.stringBufferTop);
        r5.parser.reportError("msg.unterminated.re.lit");
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c1, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void readRegExp(int r6) throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.tokenBeg
            r1 = 0
            r5.stringBufferTop = r1
            r2 = 100
            if (r6 != r2) goto Lf
            r6 = 61
            r5.addToString(r6)
            goto L16
        Lf:
            r2 = 24
            if (r6 == r2) goto L16
            org.mozilla.javascript.Kit.codeBug()
        L16:
            r6 = 0
        L17:
            int r2 = r5.getChar()
            r3 = 47
            if (r2 != r3) goto L82
            if (r6 == 0) goto L22
            goto L82
        L22:
            int r6 = r5.stringBufferTop
        L24:
            r2 = 103(0x67, float:1.44E-43)
            boolean r3 = r5.matchChar(r2)
            if (r3 == 0) goto L30
            r5.addToString(r2)
            goto L24
        L30:
            r2 = 105(0x69, float:1.47E-43)
            boolean r3 = r5.matchChar(r2)
            if (r3 == 0) goto L3c
            r5.addToString(r2)
            goto L24
        L3c:
            r2 = 109(0x6d, float:1.53E-43)
            boolean r3 = r5.matchChar(r2)
            if (r3 == 0) goto L48
            r5.addToString(r2)
            goto L24
        L48:
            r2 = 121(0x79, float:1.7E-43)
            boolean r3 = r5.matchChar(r2)
            if (r3 == 0) goto L54
            r5.addToString(r2)
            goto L24
        L54:
            int r2 = r5.stringBufferTop
            int r0 = r0 + r2
            int r0 = r0 + 2
            r5.tokenEnd = r0
            int r0 = r5.peekChar()
            boolean r0 = isAlpha(r0)
            if (r0 == 0) goto L6c
            org.mozilla.javascript.Parser r0 = r5.parser
            java.lang.String r2 = "msg.invalid.re.flag"
            r0.reportError(r2)
        L6c:
            java.lang.String r0 = new java.lang.String
            char[] r2 = r5.stringBuffer
            r0.<init>(r2, r1, r6)
            r5.string = r0
            java.lang.String r0 = new java.lang.String
            char[] r1 = r5.stringBuffer
            int r2 = r5.stringBufferTop
            int r2 = r2 - r6
            r0.<init>(r1, r6, r2)
            r5.regExpFlags = r0
            return
        L82:
            r3 = 10
            r4 = 1
            if (r2 == r3) goto La7
            r3 = -1
            if (r2 != r3) goto L8b
            goto La7
        L8b:
            r3 = 92
            if (r2 != r3) goto L97
            r5.addToString(r2)
            int r2 = r5.getChar()
            goto La2
        L97:
            r3 = 91
            if (r2 != r3) goto L9d
            r6 = 1
            goto La2
        L9d:
            r3 = 93
            if (r2 != r3) goto La2
            r6 = 0
        La2:
            r5.addToString(r2)
            goto L17
        La7:
            r5.ungetChar(r2)
            int r6 = r5.cursor
            int r6 = r6 - r4
            r5.tokenEnd = r6
            java.lang.String r6 = new java.lang.String
            char[] r0 = r5.stringBuffer
            int r2 = r5.stringBufferTop
            r6.<init>(r0, r1, r2)
            r5.string = r6
            org.mozilla.javascript.Parser r6 = r5.parser
            java.lang.String r0 = "msg.unterminated.re.lit"
            r6.reportError(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.TokenStream.readRegExp(int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String readAndClearRegExpFlags() {
        String str = this.regExpFlags;
        this.regExpFlags = null;
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isXMLAttribute() {
        return this.xmlIsAttribute;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getFirstXMLToken() throws IOException {
        this.xmlOpenTagsCount = 0;
        this.xmlIsAttribute = false;
        this.xmlIsTagContent = false;
        if (canUngetChar()) {
            ungetChar(60);
            return getNextXMLToken();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x015d, code lost:
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getNextXMLToken() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.TokenStream.getNextXMLToken():int");
    }

    private boolean readQuotedString(int i) throws IOException {
        int i2;
        do {
            i2 = getChar();
            if (i2 != -1) {
                addToString(i2);
            } else {
                this.stringBufferTop = 0;
                this.string = null;
                this.parser.addError("msg.XML.bad.form");
                return false;
            }
        } while (i2 != i);
        return true;
    }

    private boolean readXmlComment() throws IOException {
        int i = getChar();
        while (i != -1) {
            addToString(i);
            if (i == 45 && peekChar() == 45) {
                i = getChar();
                addToString(i);
                if (peekChar() == 62) {
                    addToString(getChar());
                    return true;
                }
            } else {
                i = getChar();
            }
        }
        this.stringBufferTop = 0;
        this.string = null;
        this.parser.addError("msg.XML.bad.form");
        return false;
    }

    private boolean readCDATA() throws IOException {
        int i = getChar();
        while (i != -1) {
            addToString(i);
            if (i == 93 && peekChar() == 93) {
                i = getChar();
                addToString(i);
                if (peekChar() == 62) {
                    addToString(getChar());
                    return true;
                }
            } else {
                i = getChar();
            }
        }
        this.stringBufferTop = 0;
        this.string = null;
        this.parser.addError("msg.XML.bad.form");
        return false;
    }

    private boolean readEntity() throws IOException {
        int i = getChar();
        int i2 = 1;
        while (i != -1) {
            addToString(i);
            if (i == 60) {
                i2++;
            } else if (i == 62 && i2 - 1 == 0) {
                return true;
            }
            i = getChar();
        }
        this.stringBufferTop = 0;
        this.string = null;
        this.parser.addError("msg.XML.bad.form");
        return false;
    }

    private boolean readPI() throws IOException {
        while (true) {
            int i = getChar();
            if (i != -1) {
                addToString(i);
                if (i == 63 && peekChar() == 62) {
                    addToString(getChar());
                    return true;
                }
            } else {
                this.stringBufferTop = 0;
                this.string = null;
                this.parser.addError("msg.XML.bad.form");
                return false;
            }
        }
    }

    private String getStringFromBuffer() {
        this.tokenEnd = this.cursor;
        return new String(this.stringBuffer, 0, this.stringBufferTop);
    }

    private void addToString(int i) {
        int i2 = this.stringBufferTop;
        char[] cArr = this.stringBuffer;
        if (i2 == cArr.length) {
            char[] cArr2 = new char[cArr.length * 2];
            System.arraycopy(cArr, 0, cArr2, 0, i2);
            this.stringBuffer = cArr2;
        }
        this.stringBuffer[i2] = (char) i;
        this.stringBufferTop = i2 + 1;
    }

    private boolean canUngetChar() {
        int i = this.ungetCursor;
        return i == 0 || this.ungetBuffer[i - 1] != 10;
    }

    private void ungetChar(int i) {
        int i2 = this.ungetCursor;
        if (i2 != 0 && this.ungetBuffer[i2 - 1] == 10) {
            Kit.codeBug();
        }
        int[] iArr = this.ungetBuffer;
        int i3 = this.ungetCursor;
        this.ungetCursor = i3 + 1;
        iArr[i3] = i;
        this.cursor--;
    }

    private boolean matchChar(int i) throws IOException {
        int charIgnoreLineEnd = getCharIgnoreLineEnd();
        if (charIgnoreLineEnd == i) {
            this.tokenEnd = this.cursor;
            return true;
        }
        ungetCharIgnoreLineEnd(charIgnoreLineEnd);
        return false;
    }

    private int peekChar() throws IOException {
        int i = getChar();
        ungetChar(i);
        return i;
    }

    private int getChar() throws IOException {
        return getChar(true);
    }

    private int getChar(boolean z) throws IOException {
        char c;
        int i = this.ungetCursor;
        if (i != 0) {
            this.cursor++;
            int[] iArr = this.ungetBuffer;
            int i2 = i - 1;
            this.ungetCursor = i2;
            return iArr[i2];
        }
        while (true) {
            String str = this.sourceString;
            if (str != null) {
                int i3 = this.sourceCursor;
                if (i3 == this.sourceEnd) {
                    this.hitEOF = true;
                    return -1;
                }
                this.cursor++;
                this.sourceCursor = i3 + 1;
                c = str.charAt(i3);
            } else if (this.sourceCursor == this.sourceEnd && !fillSourceBuffer()) {
                this.hitEOF = true;
                return -1;
            } else {
                this.cursor++;
                char[] cArr = this.sourceBuffer;
                int i4 = this.sourceCursor;
                this.sourceCursor = i4 + 1;
                c = cArr[i4];
            }
            int i5 = this.lineEndChar;
            if (i5 >= 0) {
                if (i5 == 13 && c == '\n') {
                    this.lineEndChar = 10;
                } else {
                    this.lineEndChar = -1;
                    this.lineStart = this.sourceCursor - 1;
                    this.lineno++;
                }
            }
            if (c <= 127) {
                if (c != '\n' && c != '\r') {
                    return c;
                }
                this.lineEndChar = c;
            } else if (c == 65279) {
                return c;
            } else {
                if (!z || !isJSFormatChar(c)) {
                    break;
                }
            }
        }
        if (ScriptRuntime.isJSLineTerminator(c)) {
            this.lineEndChar = c;
            return 10;
        }
        return c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005a, code lost:
        return 10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int getCharIgnoreLineEnd() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.ungetCursor
            r1 = 1
            if (r0 == 0) goto L12
            int r2 = r5.cursor
            int r2 = r2 + r1
            r5.cursor = r2
            int[] r2 = r5.ungetBuffer
            int r0 = r0 - r1
            r5.ungetCursor = r0
            r0 = r2[r0]
            return r0
        L12:
            java.lang.String r0 = r5.sourceString
            r2 = -1
            if (r0 == 0) goto L2e
            int r3 = r5.sourceCursor
            int r4 = r5.sourceEnd
            if (r3 != r4) goto L20
            r5.hitEOF = r1
            return r2
        L20:
            int r2 = r5.cursor
            int r2 = r2 + r1
            r5.cursor = r2
            int r2 = r3 + 1
            r5.sourceCursor = r2
            char r0 = r0.charAt(r3)
            goto L4c
        L2e:
            int r0 = r5.sourceCursor
            int r3 = r5.sourceEnd
            if (r0 != r3) goto L3d
            boolean r0 = r5.fillSourceBuffer()
            if (r0 != 0) goto L3d
            r5.hitEOF = r1
            return r2
        L3d:
            int r0 = r5.cursor
            int r0 = r0 + r1
            r5.cursor = r0
            char[] r0 = r5.sourceBuffer
            int r2 = r5.sourceCursor
            int r3 = r2 + 1
            r5.sourceCursor = r3
            char r0 = r0[r2]
        L4c:
            r2 = 127(0x7f, float:1.78E-43)
            r3 = 10
            if (r0 > r2) goto L5d
            if (r0 == r3) goto L58
            r1 = 13
            if (r0 != r1) goto L73
        L58:
            r5.lineEndChar = r0
        L5a:
            r0 = 10
            goto L73
        L5d:
            r2 = 65279(0xfeff, float:9.1475E-41)
            if (r0 != r2) goto L63
            return r0
        L63:
            boolean r2 = isJSFormatChar(r0)
            if (r2 == 0) goto L6a
            goto L12
        L6a:
            boolean r1 = org.mozilla.javascript.ScriptRuntime.isJSLineTerminator(r0)
            if (r1 == 0) goto L73
            r5.lineEndChar = r0
            goto L5a
        L73:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.TokenStream.getCharIgnoreLineEnd():int");
    }

    private void ungetCharIgnoreLineEnd(int i) {
        int[] iArr = this.ungetBuffer;
        int i2 = this.ungetCursor;
        this.ungetCursor = i2 + 1;
        iArr[i2] = i;
        this.cursor--;
    }

    private void skipLine() throws IOException {
        int i;
        do {
            i = getChar();
            if (i == -1) {
                break;
            }
        } while (i != 10);
        ungetChar(i);
        this.tokenEnd = this.cursor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getOffset() {
        int i = this.sourceCursor - this.lineStart;
        return this.lineEndChar >= 0 ? i - 1 : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String getLine() {
        if (this.sourceString != null) {
            int i = this.sourceCursor;
            if (this.lineEndChar >= 0) {
                i--;
            } else {
                while (i != this.sourceEnd && !ScriptRuntime.isJSLineTerminator(this.sourceString.charAt(i))) {
                    i++;
                }
            }
            return this.sourceString.substring(this.lineStart, i);
        }
        int i2 = this.sourceCursor - this.lineStart;
        if (this.lineEndChar >= 0) {
            i2--;
        } else {
            while (true) {
                int i3 = this.lineStart + i2;
                if (i3 == this.sourceEnd) {
                    try {
                        if (!fillSourceBuffer()) {
                            break;
                        }
                        i3 = this.lineStart + i2;
                    } catch (IOException unused) {
                    }
                }
                if (ScriptRuntime.isJSLineTerminator(this.sourceBuffer[i3])) {
                    break;
                }
                i2++;
            }
        }
        return new String(this.sourceBuffer, this.lineStart, i2);
    }

    private boolean fillSourceBuffer() throws IOException {
        if (this.sourceString != null) {
            Kit.codeBug();
        }
        if (this.sourceEnd == this.sourceBuffer.length) {
            if (this.lineStart != 0 && !isMarkingComment()) {
                char[] cArr = this.sourceBuffer;
                int i = this.lineStart;
                System.arraycopy(cArr, i, cArr, 0, this.sourceEnd - i);
                int i2 = this.sourceEnd;
                int i3 = this.lineStart;
                this.sourceEnd = i2 - i3;
                this.sourceCursor -= i3;
                this.lineStart = 0;
            } else {
                char[] cArr2 = this.sourceBuffer;
                char[] cArr3 = new char[cArr2.length * 2];
                System.arraycopy(cArr2, 0, cArr3, 0, this.sourceEnd);
                this.sourceBuffer = cArr3;
            }
        }
        Reader reader = this.sourceReader;
        char[] cArr4 = this.sourceBuffer;
        int i4 = this.sourceEnd;
        int read = reader.read(cArr4, i4, cArr4.length - i4);
        if (read < 0) {
            return false;
        }
        this.sourceEnd += read;
        return true;
    }

    public int getCursor() {
        return this.cursor;
    }

    public int getTokenBeg() {
        return this.tokenBeg;
    }

    public int getTokenEnd() {
        return this.tokenEnd;
    }

    public int getTokenLength() {
        return this.tokenEnd - this.tokenBeg;
    }

    public Token.CommentType getCommentType() {
        return this.commentType;
    }

    private void markCommentStart() {
        markCommentStart("");
    }

    private void markCommentStart(String str) {
        if (!this.parser.compilerEnv.isRecordingComments() || this.sourceReader == null) {
            return;
        }
        this.commentPrefix = str;
        this.commentCursor = this.sourceCursor - 1;
    }

    private boolean isMarkingComment() {
        return this.commentCursor != -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String getAndResetCurrentComment() {
        if (this.sourceString != null) {
            if (isMarkingComment()) {
                Kit.codeBug();
            }
            return this.sourceString.substring(this.tokenBeg, this.tokenEnd);
        }
        if (!isMarkingComment()) {
            Kit.codeBug();
        }
        StringBuilder sb = new StringBuilder(this.commentPrefix);
        sb.append(this.sourceBuffer, this.commentCursor, getTokenLength() - this.commentPrefix.length());
        this.commentCursor = -1;
        return sb.toString();
    }

    private String convertLastCharToHex(String str) {
        int length = str.length() - 1;
        StringBuffer stringBuffer = new StringBuffer(str.substring(0, length));
        stringBuffer.append("\\u");
        String hexString = Integer.toHexString(str.charAt(length));
        for (int i = 0; i < 4 - hexString.length(); i++) {
            stringBuffer.append('0');
        }
        stringBuffer.append(hexString);
        return stringBuffer.toString();
    }
}
