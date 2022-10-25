package com.fasterxml.jackson.core.json.async;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.json.JsonReadContext;
import com.fasterxml.jackson.core.p033io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* loaded from: classes2.dex */
public abstract class NonBlockingJsonParserBase extends ParserBase {
    protected static final int MAJOR_ARRAY_ELEMENT_FIRST = 5;
    protected static final int MAJOR_ARRAY_ELEMENT_NEXT = 6;
    protected static final int MAJOR_CLOSED = 7;
    protected static final int MAJOR_INITIAL = 0;
    protected static final int MAJOR_OBJECT_FIELD_FIRST = 2;
    protected static final int MAJOR_OBJECT_FIELD_NEXT = 3;
    protected static final int MAJOR_OBJECT_VALUE = 4;
    protected static final int MAJOR_ROOT = 1;
    protected static final int MINOR_COMMENT_C = 53;
    protected static final int MINOR_COMMENT_CLOSING_ASTERISK = 52;
    protected static final int MINOR_COMMENT_CPP = 54;
    protected static final int MINOR_COMMENT_LEADING_SLASH = 51;
    protected static final int MINOR_COMMENT_YAML = 55;
    protected static final int MINOR_FIELD_APOS_NAME = 9;
    protected static final int MINOR_FIELD_LEADING_COMMA = 5;
    protected static final int MINOR_FIELD_LEADING_WS = 4;
    protected static final int MINOR_FIELD_NAME = 7;
    protected static final int MINOR_FIELD_NAME_ESCAPE = 8;
    protected static final int MINOR_FIELD_UNQUOTED_NAME = 10;
    protected static final int MINOR_NUMBER_EXPONENT_DIGITS = 32;
    protected static final int MINOR_NUMBER_EXPONENT_MARKER = 31;
    protected static final int MINOR_NUMBER_FRACTION_DIGITS = 30;
    protected static final int MINOR_NUMBER_INTEGER_DIGITS = 26;
    protected static final int MINOR_NUMBER_MINUS = 23;
    protected static final int MINOR_NUMBER_MINUSZERO = 25;
    protected static final int MINOR_NUMBER_ZERO = 24;
    protected static final int MINOR_ROOT_BOM = 1;
    protected static final int MINOR_ROOT_GOT_SEPARATOR = 3;
    protected static final int MINOR_ROOT_NEED_SEPARATOR = 2;
    protected static final int MINOR_VALUE_APOS_STRING = 45;
    protected static final int MINOR_VALUE_EXPECTING_COLON = 14;
    protected static final int MINOR_VALUE_EXPECTING_COMMA = 13;
    protected static final int MINOR_VALUE_LEADING_WS = 12;
    protected static final int MINOR_VALUE_STRING = 40;
    protected static final int MINOR_VALUE_STRING_ESCAPE = 41;
    protected static final int MINOR_VALUE_STRING_UTF8_2 = 42;
    protected static final int MINOR_VALUE_STRING_UTF8_3 = 43;
    protected static final int MINOR_VALUE_STRING_UTF8_4 = 44;
    protected static final int MINOR_VALUE_TOKEN_ERROR = 50;
    protected static final int MINOR_VALUE_TOKEN_FALSE = 18;
    protected static final int MINOR_VALUE_TOKEN_NON_STD = 19;
    protected static final int MINOR_VALUE_TOKEN_NULL = 16;
    protected static final int MINOR_VALUE_TOKEN_TRUE = 17;
    protected static final int MINOR_VALUE_WS_AFTER_COMMA = 15;
    protected static final int NON_STD_TOKEN_INFINITY = 1;
    protected static final int NON_STD_TOKEN_MINUS_INFINITY = 3;
    protected static final int NON_STD_TOKEN_NAN = 0;
    protected static final int NON_STD_TOKEN_PLUS_INFINITY = 2;
    protected int _currBufferStart;
    protected int _currInputRowAlt;
    protected boolean _endOfInput;
    protected int _majorState;
    protected int _majorStateAfterValue;
    protected int _minorState;
    protected int _minorStateAfterSplit;
    protected int _nonStdTokenType;
    protected int _pending32;
    protected int _pendingBytes;
    protected int _quad1;
    protected int[] _quadBuffer;
    protected int _quadLength;
    protected int _quoted32;
    protected int _quotedDigits;
    protected final ByteQuadsCanonicalizer _symbols;
    protected static final String[] NON_STD_TOKENS = {"NaN", "Infinity", "+Infinity", "-Infinity"};
    protected static final double[] NON_STD_TOKEN_VALUES = {Double.NaN, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};

    /* JADX INFO: Access modifiers changed from: protected */
    public static final int _padLastQuad(int i, int i2) {
        return i2 == 4 ? i : i | ((-1) << (i2 << 3));
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean canParseAsync() {
        return true;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public ObjectCodec getCodec() {
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object getInputSource() {
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract int releaseBuffered(OutputStream outputStream) throws IOException;

    public NonBlockingJsonParserBase(IOContext iOContext, int i, ByteQuadsCanonicalizer byteQuadsCanonicalizer) {
        super(iOContext, i);
        this._quadBuffer = new int[8];
        this._endOfInput = false;
        this._currBufferStart = 0;
        this._currInputRowAlt = 1;
        this._symbols = byteQuadsCanonicalizer;
        this._currToken = null;
        this._majorState = 0;
        this._majorStateAfterValue = 1;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void setCodec(ObjectCodec objectCodec) {
        throw new UnsupportedOperationException("Can not use ObjectMapper with non-blocking parser");
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JacksonFeatureSet<StreamReadCapability> getReadCapabilities() {
        return JSON_READ_CAPABILITIES;
    }

    protected ByteQuadsCanonicalizer symbolTableForTests() {
        return this._symbols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.core.base.ParserBase
    public void _releaseBuffers() throws IOException {
        super._releaseBuffers();
        this._symbols.release();
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    protected void _closeInput() throws IOException {
        this._currBufferStart = 0;
        this._inputEnd = 0;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public boolean hasTextCharacters() {
        if (this._currToken == JsonToken.VALUE_STRING) {
            return this._textBuffer.hasTextAsCharacters();
        }
        if (this._currToken == JsonToken.FIELD_NAME) {
            return this._nameCopied;
        }
        return false;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.JsonParser
    public JsonLocation getCurrentLocation() {
        int i = (this._inputPtr - this._currInputRowStart) + 1;
        return new JsonLocation(_contentReference(), this._currInputProcessed + (this._inputPtr - this._currBufferStart), -1L, Math.max(this._currInputRow, this._currInputRowAlt), i);
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.JsonParser
    public JsonLocation getTokenLocation() {
        return new JsonLocation(_contentReference(), this._tokenInputTotal, -1L, this._tokenInputRow, this._tokenInputCol);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getText() throws IOException {
        if (this._currToken == JsonToken.VALUE_STRING) {
            return this._textBuffer.contentsAsString();
        }
        return _getText2(this._currToken);
    }

    protected final String _getText2(JsonToken jsonToken) {
        int m6071id;
        if (jsonToken == null || (m6071id = jsonToken.m6071id()) == -1) {
            return null;
        }
        if (m6071id != 5) {
            if (m6071id == 6 || m6071id == 7 || m6071id == 8) {
                return this._textBuffer.contentsAsString();
            }
            return jsonToken.asString();
        }
        return this._parsingContext.getCurrentName();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getText(Writer writer) throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            return this._textBuffer.contentsToWriter(writer);
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            String currentName = this._parsingContext.getCurrentName();
            writer.write(currentName);
            return currentName.length();
        } else if (jsonToken != null) {
            if (jsonToken.isNumeric()) {
                return this._textBuffer.contentsToWriter(writer);
            }
            if (jsonToken == JsonToken.NOT_AVAILABLE) {
                _reportError("Current token not available: can not call this method");
            }
            char[] asCharArray = jsonToken.asCharArray();
            writer.write(asCharArray);
            return asCharArray.length;
        } else {
            return 0;
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getValueAsString() throws IOException {
        if (this._currToken == JsonToken.VALUE_STRING) {
            return this._textBuffer.contentsAsString();
        }
        if (this._currToken == JsonToken.FIELD_NAME) {
            return getCurrentName();
        }
        return super.getValueAsString(null);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getValueAsString(String str) throws IOException {
        if (this._currToken == JsonToken.VALUE_STRING) {
            return this._textBuffer.contentsAsString();
        }
        if (this._currToken == JsonToken.FIELD_NAME) {
            return getCurrentName();
        }
        return super.getValueAsString(str);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public char[] getTextCharacters() throws IOException {
        if (this._currToken != null) {
            int m6071id = this._currToken.m6071id();
            if (m6071id != 5) {
                if (m6071id == 6 || m6071id == 7 || m6071id == 8) {
                    return this._textBuffer.getTextBuffer();
                }
                return this._currToken.asCharArray();
            }
            if (!this._nameCopied) {
                String currentName = this._parsingContext.getCurrentName();
                int length = currentName.length();
                if (this._nameCopyBuffer == null) {
                    this._nameCopyBuffer = this._ioContext.allocNameCopyBuffer(length);
                } else if (this._nameCopyBuffer.length < length) {
                    this._nameCopyBuffer = new char[length];
                }
                currentName.getChars(0, length, this._nameCopyBuffer, 0);
                this._nameCopied = true;
            }
            return this._nameCopyBuffer;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public int getTextLength() throws IOException {
        if (this._currToken != null) {
            int m6071id = this._currToken.m6071id();
            if (m6071id != 5) {
                if (m6071id == 6 || m6071id == 7 || m6071id == 8) {
                    return this._textBuffer.size();
                }
                return this._currToken.asCharArray().length;
            }
            return this._parsingContext.getCurrentName().length();
        }
        return 0;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public int getTextOffset() throws IOException {
        if (this._currToken != null) {
            int m6071id = this._currToken.m6071id();
            if (m6071id == 6 || m6071id == 7 || m6071id == 8) {
                return this._textBuffer.getTextOffset();
            }
            return 0;
        }
        return 0;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public byte[] getBinaryValue(Base64Variant base64Variant) throws IOException {
        if (this._currToken != JsonToken.VALUE_STRING) {
            _reportError("Current token (%s) not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary", this._currToken);
        }
        if (this._binaryValue == null) {
            ByteArrayBuilder _getByteArrayBuilder = _getByteArrayBuilder();
            _decodeBase64(getText(), _getByteArrayBuilder, base64Variant);
            this._binaryValue = _getByteArrayBuilder.toByteArray();
        }
        return this._binaryValue;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int readBinaryValue(Base64Variant base64Variant, OutputStream outputStream) throws IOException {
        byte[] binaryValue = getBinaryValue(base64Variant);
        outputStream.write(binaryValue);
        return binaryValue.length;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object getEmbeddedObject() throws IOException {
        if (this._currToken == JsonToken.VALUE_EMBEDDED_OBJECT) {
            return this._binaryValue;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken _startArrayScope() throws IOException {
        this._parsingContext = this._parsingContext.createChildArrayContext(-1, -1);
        this._majorState = 5;
        this._majorStateAfterValue = 6;
        JsonToken jsonToken = JsonToken.START_ARRAY;
        this._currToken = jsonToken;
        return jsonToken;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken _startObjectScope() throws IOException {
        this._parsingContext = this._parsingContext.createChildObjectContext(-1, -1);
        this._majorState = 2;
        this._majorStateAfterValue = 3;
        JsonToken jsonToken = JsonToken.START_OBJECT;
        this._currToken = jsonToken;
        return jsonToken;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken _closeArrayScope() throws IOException {
        int i;
        if (!this._parsingContext.inArray()) {
            _reportMismatchedEndMarker(93, '}');
        }
        JsonReadContext parent = this._parsingContext.getParent();
        this._parsingContext = parent;
        if (parent.inObject()) {
            i = 3;
        } else {
            i = parent.inArray() ? 6 : 1;
        }
        this._majorState = i;
        this._majorStateAfterValue = i;
        JsonToken jsonToken = JsonToken.END_ARRAY;
        this._currToken = jsonToken;
        return jsonToken;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken _closeObjectScope() throws IOException {
        int i;
        if (!this._parsingContext.inObject()) {
            _reportMismatchedEndMarker(125, ']');
        }
        JsonReadContext parent = this._parsingContext.getParent();
        this._parsingContext = parent;
        if (parent.inObject()) {
            i = 3;
        } else {
            i = parent.inArray() ? 6 : 1;
        }
        this._majorState = i;
        this._majorStateAfterValue = i;
        JsonToken jsonToken = JsonToken.END_OBJECT;
        this._currToken = jsonToken;
        return jsonToken;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String _findName(int i, int i2) throws JsonParseException {
        int _padLastQuad = _padLastQuad(i, i2);
        String findName = this._symbols.findName(_padLastQuad);
        if (findName != null) {
            return findName;
        }
        int[] iArr = this._quadBuffer;
        iArr[0] = _padLastQuad;
        return _addName(iArr, 1, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String _findName(int i, int i2, int i3) throws JsonParseException {
        int _padLastQuad = _padLastQuad(i2, i3);
        String findName = this._symbols.findName(i, _padLastQuad);
        if (findName != null) {
            return findName;
        }
        int[] iArr = this._quadBuffer;
        iArr[0] = i;
        iArr[1] = _padLastQuad;
        return _addName(iArr, 2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String _findName(int i, int i2, int i3, int i4) throws JsonParseException {
        int _padLastQuad = _padLastQuad(i3, i4);
        String findName = this._symbols.findName(i, i2, _padLastQuad);
        if (findName != null) {
            return findName;
        }
        int[] iArr = this._quadBuffer;
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = _padLastQuad(_padLastQuad, i4);
        return _addName(iArr, 3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String _addName(int[] r17, int r18, int r19) throws com.fasterxml.jackson.core.JsonParseException {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.async.NonBlockingJsonParserBase._addName(int[], int, int):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken _eofAsNextToken() throws IOException {
        this._majorState = 7;
        if (!this._parsingContext.inRoot()) {
            _handleEOF();
        }
        close();
        this._currToken = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken _fieldComplete(String str) throws IOException {
        this._majorState = 4;
        this._parsingContext.setCurrentName(str);
        JsonToken jsonToken = JsonToken.FIELD_NAME;
        this._currToken = jsonToken;
        return jsonToken;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken _valueComplete(JsonToken jsonToken) throws IOException {
        this._majorState = this._majorStateAfterValue;
        this._currToken = jsonToken;
        return jsonToken;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken _valueCompleteInt(int i, String str) throws IOException {
        this._textBuffer.resetWithString(str);
        this._intLength = str.length();
        this._numTypesValid = 1;
        this._numberInt = i;
        this._majorState = this._majorStateAfterValue;
        JsonToken jsonToken = JsonToken.VALUE_NUMBER_INT;
        this._currToken = jsonToken;
        return jsonToken;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken _valueNonStdNumberComplete(int i) throws IOException {
        String str = NON_STD_TOKENS[i];
        this._textBuffer.resetWithString(str);
        if (!isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
            _reportError("Non-standard token '%s': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow", str);
        }
        this._intLength = 0;
        this._numTypesValid = 8;
        this._numberDouble = NON_STD_TOKEN_VALUES[i];
        this._majorState = this._majorStateAfterValue;
        JsonToken jsonToken = JsonToken.VALUE_NUMBER_FLOAT;
        this._currToken = jsonToken;
        return jsonToken;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String _nonStdToken(int i) {
        return NON_STD_TOKENS[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void _updateTokenLocation() {
        this._tokenInputRow = Math.max(this._currInputRow, this._currInputRowAlt);
        int i = this._inputPtr;
        this._tokenInputCol = i - this._currInputRowStart;
        this._tokenInputTotal = this._currInputProcessed + (i - this._currBufferStart);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void _reportInvalidChar(int i) throws JsonParseException {
        if (i < 32) {
            _throwInvalidSpace(i);
        }
        _reportInvalidInitial(i);
    }

    protected void _reportInvalidInitial(int i) throws JsonParseException {
        _reportError("Invalid UTF-8 start byte 0x" + Integer.toHexString(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void _reportInvalidOther(int i, int i2) throws JsonParseException {
        this._inputPtr = i2;
        _reportInvalidOther(i);
    }

    protected void _reportInvalidOther(int i) throws JsonParseException {
        _reportError("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i));
    }
}
