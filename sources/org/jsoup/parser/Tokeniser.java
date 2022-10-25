package org.jsoup.parser;

import java.util.Arrays;
import javax.annotation.Nullable;
import kotlin.text.Typography;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.Token;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class Tokeniser {
    private static final char[] notCharRefCharsSorted;
    static final char replacementChar = 65533;
    static final int[] win1252Extensions;
    static final int win1252ExtensionsStart = 128;
    private Token emitPending;
    private final ParseErrorList errors;
    @Nullable
    private String lastStartCloseSeq;
    private String lastStartTag;
    private final CharacterReader reader;
    Token.Tag tagPending;
    private TokeniserState state = TokeniserState.Data;
    private boolean isEmitPending = false;
    private String charsString = null;
    private StringBuilder charsBuilder = new StringBuilder(1024);
    StringBuilder dataBuffer = new StringBuilder(1024);
    Token.StartTag startPending = new Token.StartTag();
    Token.EndTag endPending = new Token.EndTag();
    Token.Character charPending = new Token.Character();
    Token.Doctype doctypePending = new Token.Doctype();
    Token.Comment commentPending = new Token.Comment();
    private final int[] codepointHolder = new int[1];
    private final int[] multipointHolder = new int[2];

    boolean currentNodeInHtmlNS() {
        return true;
    }

    static {
        char[] cArr = {'\t', '\n', '\r', '\f', ' ', Typography.less, Typography.amp};
        notCharRefCharsSorted = cArr;
        win1252Extensions = new int[]{8364, 129, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 381, 143, 144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 157, 382, 376};
        Arrays.sort(cArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tokeniser(CharacterReader characterReader, ParseErrorList parseErrorList) {
        this.reader = characterReader;
        this.errors = parseErrorList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Token read() {
        while (!this.isEmitPending) {
            this.state.read(this, this.reader);
        }
        StringBuilder sb = this.charsBuilder;
        if (sb.length() != 0) {
            String sb2 = sb.toString();
            sb.delete(0, sb.length());
            this.charsString = null;
            return this.charPending.data(sb2);
        }
        String str = this.charsString;
        if (str != null) {
            Token.Character data = this.charPending.data(str);
            this.charsString = null;
            return data;
        }
        this.isEmitPending = false;
        return this.emitPending;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void emit(Token token) {
        Validate.isFalse(this.isEmitPending);
        this.emitPending = token;
        this.isEmitPending = true;
        if (token.type == Token.TokenType.StartTag) {
            this.lastStartTag = ((Token.StartTag) token).tagName;
            this.lastStartCloseSeq = null;
        } else if (token.type == Token.TokenType.EndTag) {
            Token.EndTag endTag = (Token.EndTag) token;
            if (endTag.hasAttributes()) {
                error("Attributes incorrectly present on end tag [/%s]", endTag.normalName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void emit(String str) {
        if (this.charsString == null) {
            this.charsString = str;
            return;
        }
        if (this.charsBuilder.length() == 0) {
            this.charsBuilder.append(this.charsString);
        }
        this.charsBuilder.append(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void emit(StringBuilder sb) {
        if (this.charsString == null) {
            this.charsString = sb.toString();
            return;
        }
        if (this.charsBuilder.length() == 0) {
            this.charsBuilder.append(this.charsString);
        }
        this.charsBuilder.append((CharSequence) sb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void emit(char c) {
        if (this.charsString == null) {
            this.charsString = String.valueOf(c);
            return;
        }
        if (this.charsBuilder.length() == 0) {
            this.charsBuilder.append(this.charsString);
        }
        this.charsBuilder.append(c);
    }

    void emit(char[] cArr) {
        emit(String.valueOf(cArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void emit(int[] iArr) {
        emit(new String(iArr, 0, iArr.length));
    }

    TokeniserState getState() {
        return this.state;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void transition(TokeniserState tokeniserState) {
        this.state = tokeniserState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void advanceTransition(TokeniserState tokeniserState) {
        this.reader.advance();
        this.state = tokeniserState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public int[] consumeCharacterReference(Character ch, boolean z) {
        int i;
        if (this.reader.isEmpty()) {
            return null;
        }
        if ((ch == null || ch.charValue() != this.reader.current()) && !this.reader.matchesAnySorted(notCharRefCharsSorted)) {
            int[] iArr = this.codepointHolder;
            this.reader.mark();
            if (this.reader.matchConsume("#")) {
                boolean matchConsumeIgnoreCase = this.reader.matchConsumeIgnoreCase("X");
                CharacterReader characterReader = this.reader;
                String consumeHexSequence = matchConsumeIgnoreCase ? characterReader.consumeHexSequence() : characterReader.consumeDigitSequence();
                if (consumeHexSequence.length() == 0) {
                    characterReferenceError("numeric reference with no numerals", new Object[0]);
                    this.reader.rewindToMark();
                    return null;
                }
                this.reader.unmark();
                if (!this.reader.matchConsume(";")) {
                    characterReferenceError("missing semicolon on [&#%s]", consumeHexSequence);
                }
                try {
                    i = Integer.valueOf(consumeHexSequence, matchConsumeIgnoreCase ? 16 : 10).intValue();
                } catch (NumberFormatException unused) {
                    i = -1;
                }
                if (i == -1 || ((i >= 55296 && i <= 57343) || i > 1114111)) {
                    characterReferenceError("character [%s] outside of valid range", Integer.valueOf(i));
                    iArr[0] = 65533;
                } else {
                    if (i >= 128) {
                        int[] iArr2 = win1252Extensions;
                        if (i < iArr2.length + 128) {
                            characterReferenceError("character [%s] is not a valid unicode code point", Integer.valueOf(i));
                            i = iArr2[i - 128];
                        }
                    }
                    iArr[0] = i;
                }
                return iArr;
            }
            String consumeLetterThenDigitSequence = this.reader.consumeLetterThenDigitSequence();
            boolean matches = this.reader.matches(';');
            if (!(Entities.isBaseNamedEntity(consumeLetterThenDigitSequence) || (Entities.isNamedEntity(consumeLetterThenDigitSequence) && matches))) {
                this.reader.rewindToMark();
                if (matches) {
                    characterReferenceError("invalid named reference [%s]", consumeLetterThenDigitSequence);
                }
                return null;
            } else if (z && (this.reader.matchesLetter() || this.reader.matchesDigit() || this.reader.matchesAny('=', '-', '_'))) {
                this.reader.rewindToMark();
                return null;
            } else {
                this.reader.unmark();
                if (!this.reader.matchConsume(";")) {
                    characterReferenceError("missing semicolon on [&%s]", consumeLetterThenDigitSequence);
                }
                int codepointsForName = Entities.codepointsForName(consumeLetterThenDigitSequence, this.multipointHolder);
                if (codepointsForName == 1) {
                    iArr[0] = this.multipointHolder[0];
                    return iArr;
                } else if (codepointsForName == 2) {
                    return this.multipointHolder;
                } else {
                    Validate.fail("Unexpected characters returned for " + consumeLetterThenDigitSequence);
                    return this.multipointHolder;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Token.Tag createTagPending(boolean z) {
        Token.Tag reset = z ? this.startPending.reset() : this.endPending.reset();
        this.tagPending = reset;
        return reset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void emitTagPending() {
        this.tagPending.finaliseTag();
        emit(this.tagPending);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void createCommentPending() {
        this.commentPending.reset();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void emitCommentPending() {
        emit(this.commentPending);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void createBogusCommentPending() {
        this.commentPending.reset();
        this.commentPending.bogus = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void createDoctypePending() {
        this.doctypePending.reset();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void emitDoctypePending() {
        emit(this.doctypePending);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void createTempBuffer() {
        Token.reset(this.dataBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAppropriateEndTagToken() {
        return this.lastStartTag != null && this.tagPending.name().equalsIgnoreCase(this.lastStartTag);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String appropriateEndTagName() {
        return this.lastStartTag;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String appropriateEndTagSeq() {
        if (this.lastStartCloseSeq == null) {
            this.lastStartCloseSeq = "</" + this.lastStartTag;
        }
        return this.lastStartCloseSeq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void error(TokeniserState tokeniserState) {
        if (this.errors.canAddError()) {
            ParseErrorList parseErrorList = this.errors;
            CharacterReader characterReader = this.reader;
            parseErrorList.add(new ParseError(characterReader, "Unexpected character '%s' in input state [%s]", Character.valueOf(characterReader.current()), tokeniserState));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eofError(TokeniserState tokeniserState) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader, "Unexpectedly reached end of file (EOF) in input state [%s]", tokeniserState));
        }
    }

    private void characterReferenceError(String str, Object... objArr) {
        if (this.errors.canAddError()) {
            ParseErrorList parseErrorList = this.errors;
            CharacterReader characterReader = this.reader;
            parseErrorList.add(new ParseError(characterReader, String.format("Invalid character reference: " + str, objArr)));
        }
    }

    void error(String str) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void error(String str, Object... objArr) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader, str, objArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String unescapeEntities(boolean z) {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        while (!this.reader.isEmpty()) {
            borrowBuilder.append(this.reader.consumeTo(Typography.amp));
            if (this.reader.matches(Typography.amp)) {
                this.reader.consume();
                int[] consumeCharacterReference = consumeCharacterReference(null, z);
                if (consumeCharacterReference == null || consumeCharacterReference.length == 0) {
                    borrowBuilder.append(Typography.amp);
                } else {
                    borrowBuilder.appendCodePoint(consumeCharacterReference[0]);
                    if (consumeCharacterReference.length == 2) {
                        borrowBuilder.appendCodePoint(consumeCharacterReference[1]);
                    }
                }
            }
        }
        return StringUtil.releaseBuilder(borrowBuilder);
    }
}
