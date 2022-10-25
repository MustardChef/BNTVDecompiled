package org.jsoup.nodes;

import com.google.android.exoplayer2.C3282C;
import java.io.IOException;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.text.Typography;
import org.jsoup.SerializationException;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.parser.CharacterReader;
import org.jsoup.parser.Parser;

/* loaded from: classes5.dex */
public class Entities {
    static final int codepointRadix = 36;
    private static final int empty = -1;
    private static final String emptyName = "";
    private static final char[] codeDelims = {',', ';'};
    private static final HashMap<String, String> multipoints = new HashMap<>();
    private static final Document.OutputSettings DefaultOutput = new Document.OutputSettings();

    /* loaded from: classes5.dex */
    public enum EscapeMode {
        xhtml(EntitiesData.xmlPoints, 4),
        base(EntitiesData.basePoints, 106),
        extended(EntitiesData.fullPoints, 2125);
        
        private int[] codeKeys;
        private int[] codeVals;
        private String[] nameKeys;
        private String[] nameVals;

        EscapeMode(String str, int i) {
            Entities.load(this, str, i);
        }

        int codepointForName(String str) {
            int binarySearch = Arrays.binarySearch(this.nameKeys, str);
            if (binarySearch >= 0) {
                return this.codeVals[binarySearch];
            }
            return -1;
        }

        String nameForCodepoint(int i) {
            int binarySearch = Arrays.binarySearch(this.codeKeys, i);
            if (binarySearch >= 0) {
                String[] strArr = this.nameVals;
                if (binarySearch < strArr.length - 1) {
                    int i2 = binarySearch + 1;
                    if (this.codeKeys[i2] == i) {
                        return strArr[i2];
                    }
                }
                return strArr[binarySearch];
            }
            return "";
        }

        private int size() {
            return this.nameKeys.length;
        }
    }

    private Entities() {
    }

    public static boolean isNamedEntity(String str) {
        return EscapeMode.extended.codepointForName(str) != -1;
    }

    public static boolean isBaseNamedEntity(String str) {
        return EscapeMode.base.codepointForName(str) != -1;
    }

    public static String getByName(String str) {
        String str2 = multipoints.get(str);
        if (str2 != null) {
            return str2;
        }
        int codepointForName = EscapeMode.extended.codepointForName(str);
        return codepointForName != -1 ? new String(new int[]{codepointForName}, 0, 1) : "";
    }

    public static int codepointsForName(String str, int[] iArr) {
        String str2 = multipoints.get(str);
        if (str2 != null) {
            iArr[0] = str2.codePointAt(0);
            iArr[1] = str2.codePointAt(1);
            return 2;
        }
        int codepointForName = EscapeMode.extended.codepointForName(str);
        if (codepointForName != -1) {
            iArr[0] = codepointForName;
            return 1;
        }
        return 0;
    }

    public static String escape(String str, Document.OutputSettings outputSettings) {
        if (str == null) {
            return "";
        }
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        try {
            escape(borrowBuilder, str, outputSettings, false, false, false);
            return StringUtil.releaseBuilder(borrowBuilder);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    public static String escape(String str) {
        return escape(str, DefaultOutput);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void escape(Appendable appendable, String str, Document.OutputSettings outputSettings, boolean z, boolean z2, boolean z3) throws IOException {
        EscapeMode escapeMode = outputSettings.escapeMode();
        CharsetEncoder encoder = outputSettings.encoder();
        CoreCharset coreCharset = outputSettings.coreCharset;
        int length = str.length();
        int i = 0;
        boolean z4 = false;
        boolean z5 = false;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (z2) {
                if (StringUtil.isWhitespace(codePointAt)) {
                    if ((!z3 || z4) && !z5) {
                        appendable.append(' ');
                        z5 = true;
                    }
                    i += Character.charCount(codePointAt);
                } else {
                    z4 = true;
                    z5 = false;
                }
            }
            if (codePointAt < 65536) {
                char c = (char) codePointAt;
                if (c == '\t' || c == '\n' || c == '\r') {
                    appendable.append(c);
                } else if (c != '\"') {
                    if (c == '&') {
                        appendable.append("&amp;");
                    } else if (c != '<') {
                        if (c != '>') {
                            if (c == 160) {
                                if (escapeMode != EscapeMode.xhtml) {
                                    appendable.append("&nbsp;");
                                } else {
                                    appendable.append("&#xa0;");
                                }
                            } else if (c < ' ' || !canEncode(coreCharset, c, encoder)) {
                                appendEncoded(appendable, escapeMode, codePointAt);
                            } else {
                                appendable.append(c);
                            }
                        } else if (!z) {
                            appendable.append("&gt;");
                        } else {
                            appendable.append(c);
                        }
                    } else if (!z || escapeMode == EscapeMode.xhtml || outputSettings.syntax() == Document.OutputSettings.Syntax.xml) {
                        appendable.append("&lt;");
                    } else {
                        appendable.append(c);
                    }
                } else if (z) {
                    appendable.append("&quot;");
                } else {
                    appendable.append(c);
                }
            } else {
                String str2 = new String(Character.toChars(codePointAt));
                if (encoder.canEncode(str2)) {
                    appendable.append(str2);
                } else {
                    appendEncoded(appendable, escapeMode, codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    private static void appendEncoded(Appendable appendable, EscapeMode escapeMode, int i) throws IOException {
        String nameForCodepoint = escapeMode.nameForCodepoint(i);
        if (!"".equals(nameForCodepoint)) {
            appendable.append(Typography.amp).append(nameForCodepoint).append(';');
        } else {
            appendable.append("&#x").append(Integer.toHexString(i)).append(';');
        }
    }

    public static String unescape(String str) {
        return unescape(str, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String unescape(String str, boolean z) {
        return Parser.unescapeEntities(str, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.jsoup.nodes.Entities$1 */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C53961 {
        static final /* synthetic */ int[] $SwitchMap$org$jsoup$nodes$Entities$CoreCharset;

        static {
            int[] iArr = new int[CoreCharset.values().length];
            $SwitchMap$org$jsoup$nodes$Entities$CoreCharset = iArr;
            try {
                iArr[CoreCharset.ascii.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jsoup$nodes$Entities$CoreCharset[CoreCharset.utf.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static boolean canEncode(CoreCharset coreCharset, char c, CharsetEncoder charsetEncoder) {
        int i = C53961.$SwitchMap$org$jsoup$nodes$Entities$CoreCharset[coreCharset.ordinal()];
        if (i == 1) {
            return c < 128;
        } else if (i != 2) {
            return charsetEncoder.canEncode(c);
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public enum CoreCharset {
        ascii,
        utf,
        fallback;

        /* JADX INFO: Access modifiers changed from: package-private */
        public static CoreCharset byName(String str) {
            if (str.equals(C3282C.ASCII_NAME)) {
                return ascii;
            }
            if (str.startsWith("UTF-")) {
                return utf;
            }
            return fallback;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void load(EscapeMode escapeMode, String str, int i) {
        int i2;
        escapeMode.nameKeys = new String[i];
        escapeMode.codeVals = new int[i];
        escapeMode.codeKeys = new int[i];
        escapeMode.nameVals = new String[i];
        CharacterReader characterReader = new CharacterReader(str);
        int i3 = 0;
        while (!characterReader.isEmpty()) {
            try {
                String consumeTo = characterReader.consumeTo('=');
                characterReader.advance();
                int parseInt = Integer.parseInt(characterReader.consumeToAny(codeDelims), 36);
                char current = characterReader.current();
                characterReader.advance();
                if (current == ',') {
                    i2 = Integer.parseInt(characterReader.consumeTo(';'), 36);
                    characterReader.advance();
                } else {
                    i2 = -1;
                }
                int parseInt2 = Integer.parseInt(characterReader.consumeTo(Typography.amp), 36);
                characterReader.advance();
                escapeMode.nameKeys[i3] = consumeTo;
                escapeMode.codeVals[i3] = parseInt;
                escapeMode.codeKeys[parseInt2] = parseInt;
                escapeMode.nameVals[parseInt2] = consumeTo;
                if (i2 != -1) {
                    multipoints.put(consumeTo, new String(new int[]{parseInt, i2}, 0, 2));
                }
                i3++;
            } finally {
                characterReader.close();
            }
        }
        Validate.isTrue(i3 == i, "Unexpected count of entities loaded");
    }
}
