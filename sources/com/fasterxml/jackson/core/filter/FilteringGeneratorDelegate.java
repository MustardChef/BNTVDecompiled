package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes2.dex */
public class FilteringGeneratorDelegate extends JsonGeneratorDelegate {
    protected boolean _allowMultipleMatches;
    protected TokenFilterContext _filterContext;
    protected TokenFilter.Inclusion _inclusion;
    protected TokenFilter _itemFilter;
    protected int _matchCount;
    protected TokenFilter rootFilter;

    @Deprecated
    public FilteringGeneratorDelegate(JsonGenerator jsonGenerator, TokenFilter tokenFilter, boolean z, boolean z2) {
        this(jsonGenerator, tokenFilter, z ? TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH : TokenFilter.Inclusion.ONLY_INCLUDE_ALL, z2);
    }

    public FilteringGeneratorDelegate(JsonGenerator jsonGenerator, TokenFilter tokenFilter, TokenFilter.Inclusion inclusion, boolean z) {
        super(jsonGenerator, false);
        this.rootFilter = tokenFilter;
        this._itemFilter = tokenFilter;
        this._filterContext = TokenFilterContext.createRootContext(tokenFilter);
        this._inclusion = inclusion;
        this._allowMultipleMatches = z;
    }

    public TokenFilter getFilter() {
        return this.rootFilter;
    }

    public JsonStreamContext getFilterContext() {
        return this._filterContext;
    }

    public int getMatchCount() {
        return this._matchCount;
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public JsonStreamContext getOutputContext() {
        return this._filterContext;
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeStartArray() throws IOException {
        TokenFilter tokenFilter = this._itemFilter;
        if (tokenFilter == null) {
            this._filterContext = this._filterContext.createChildArrayContext(null, false);
        } else if (tokenFilter == TokenFilter.INCLUDE_ALL) {
            this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, true);
            this.delegate.writeStartArray();
        } else {
            TokenFilter checkValue = this._filterContext.checkValue(this._itemFilter);
            this._itemFilter = checkValue;
            if (checkValue == null) {
                this._filterContext = this._filterContext.createChildArrayContext(null, false);
                return;
            }
            if (checkValue != TokenFilter.INCLUDE_ALL) {
                this._itemFilter = this._itemFilter.filterStartArray();
            }
            if (this._itemFilter == TokenFilter.INCLUDE_ALL) {
                _checkParentPath();
                this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, true);
                this.delegate.writeStartArray();
            } else if (this._itemFilter != null && this._inclusion == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
                _checkParentPath(false);
                this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, true);
                this.delegate.writeStartArray();
            } else {
                this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, false);
            }
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeStartArray(int i) throws IOException {
        TokenFilter tokenFilter = this._itemFilter;
        if (tokenFilter == null) {
            this._filterContext = this._filterContext.createChildArrayContext(null, false);
        } else if (tokenFilter == TokenFilter.INCLUDE_ALL) {
            this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, true);
            this.delegate.writeStartArray(i);
        } else {
            TokenFilter checkValue = this._filterContext.checkValue(this._itemFilter);
            this._itemFilter = checkValue;
            if (checkValue == null) {
                this._filterContext = this._filterContext.createChildArrayContext(null, false);
                return;
            }
            if (checkValue != TokenFilter.INCLUDE_ALL) {
                this._itemFilter = this._itemFilter.filterStartArray();
            }
            if (this._itemFilter == TokenFilter.INCLUDE_ALL) {
                _checkParentPath();
                this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, true);
                this.delegate.writeStartArray(i);
            } else if (this._itemFilter != null && this._inclusion == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
                _checkParentPath(false);
                this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, true);
                this.delegate.writeStartArray(i);
            } else {
                this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, false);
            }
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeStartArray(Object obj) throws IOException {
        TokenFilter tokenFilter = this._itemFilter;
        if (tokenFilter == null) {
            this._filterContext = this._filterContext.createChildArrayContext(null, false);
        } else if (tokenFilter == TokenFilter.INCLUDE_ALL) {
            this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, true);
            this.delegate.writeStartArray(obj);
        } else {
            TokenFilter checkValue = this._filterContext.checkValue(this._itemFilter);
            this._itemFilter = checkValue;
            if (checkValue == null) {
                this._filterContext = this._filterContext.createChildArrayContext(null, false);
                return;
            }
            if (checkValue != TokenFilter.INCLUDE_ALL) {
                this._itemFilter = this._itemFilter.filterStartArray();
            }
            if (this._itemFilter == TokenFilter.INCLUDE_ALL) {
                _checkParentPath();
                this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, true);
                this.delegate.writeStartArray(obj);
                return;
            }
            this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, false);
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeStartArray(Object obj, int i) throws IOException {
        TokenFilter tokenFilter = this._itemFilter;
        if (tokenFilter == null) {
            this._filterContext = this._filterContext.createChildArrayContext(null, false);
        } else if (tokenFilter == TokenFilter.INCLUDE_ALL) {
            this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, true);
            this.delegate.writeStartArray(obj, i);
        } else {
            TokenFilter checkValue = this._filterContext.checkValue(this._itemFilter);
            this._itemFilter = checkValue;
            if (checkValue == null) {
                this._filterContext = this._filterContext.createChildArrayContext(null, false);
                return;
            }
            if (checkValue != TokenFilter.INCLUDE_ALL) {
                this._itemFilter = this._itemFilter.filterStartArray();
            }
            if (this._itemFilter == TokenFilter.INCLUDE_ALL) {
                _checkParentPath();
                this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, true);
                this.delegate.writeStartArray(obj, i);
                return;
            }
            this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, false);
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeEndArray() throws IOException {
        TokenFilterContext closeArray = this._filterContext.closeArray(this.delegate);
        this._filterContext = closeArray;
        if (closeArray != null) {
            this._itemFilter = closeArray.getFilter();
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeStartObject() throws IOException {
        TokenFilter tokenFilter = this._itemFilter;
        if (tokenFilter == null) {
            this._filterContext = this._filterContext.createChildObjectContext(tokenFilter, false);
        } else if (tokenFilter == TokenFilter.INCLUDE_ALL) {
            this._filterContext = this._filterContext.createChildObjectContext(this._itemFilter, true);
            this.delegate.writeStartObject();
        } else {
            TokenFilter checkValue = this._filterContext.checkValue(this._itemFilter);
            if (checkValue == null) {
                return;
            }
            if (checkValue != TokenFilter.INCLUDE_ALL) {
                checkValue = checkValue.filterStartObject();
            }
            if (checkValue == TokenFilter.INCLUDE_ALL) {
                _checkParentPath();
                this._filterContext = this._filterContext.createChildObjectContext(checkValue, true);
                this.delegate.writeStartObject();
            } else if (checkValue != null && this._inclusion == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
                _checkParentPath(false);
                this._filterContext = this._filterContext.createChildObjectContext(checkValue, true);
                this.delegate.writeStartObject();
            } else {
                this._filterContext = this._filterContext.createChildObjectContext(checkValue, false);
            }
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeStartObject(Object obj) throws IOException {
        TokenFilter tokenFilter = this._itemFilter;
        if (tokenFilter == null) {
            this._filterContext = this._filterContext.createChildObjectContext(tokenFilter, false);
        } else if (tokenFilter == TokenFilter.INCLUDE_ALL) {
            this._filterContext = this._filterContext.createChildObjectContext(this._itemFilter, true);
            this.delegate.writeStartObject(obj);
        } else {
            TokenFilter checkValue = this._filterContext.checkValue(this._itemFilter);
            if (checkValue == null) {
                return;
            }
            if (checkValue != TokenFilter.INCLUDE_ALL) {
                checkValue = checkValue.filterStartObject();
            }
            if (checkValue == TokenFilter.INCLUDE_ALL) {
                _checkParentPath();
                this._filterContext = this._filterContext.createChildObjectContext(checkValue, true);
                this.delegate.writeStartObject(obj);
            } else if (checkValue != null && this._inclusion == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
                _checkParentPath(false);
                this._filterContext = this._filterContext.createChildObjectContext(checkValue, true);
                this.delegate.writeStartObject(obj);
            } else {
                this._filterContext = this._filterContext.createChildObjectContext(checkValue, false);
            }
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeStartObject(Object obj, int i) throws IOException {
        TokenFilter tokenFilter = this._itemFilter;
        if (tokenFilter == null) {
            this._filterContext = this._filterContext.createChildObjectContext(tokenFilter, false);
        } else if (tokenFilter == TokenFilter.INCLUDE_ALL) {
            this._filterContext = this._filterContext.createChildObjectContext(this._itemFilter, true);
            this.delegate.writeStartObject(obj, i);
        } else {
            TokenFilter checkValue = this._filterContext.checkValue(this._itemFilter);
            if (checkValue == null) {
                return;
            }
            if (checkValue != TokenFilter.INCLUDE_ALL) {
                checkValue = checkValue.filterStartObject();
            }
            if (checkValue == TokenFilter.INCLUDE_ALL) {
                _checkParentPath();
                this._filterContext = this._filterContext.createChildObjectContext(checkValue, true);
                this.delegate.writeStartObject(obj, i);
                return;
            }
            this._filterContext = this._filterContext.createChildObjectContext(checkValue, false);
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeEndObject() throws IOException {
        TokenFilterContext closeObject = this._filterContext.closeObject(this.delegate);
        this._filterContext = closeObject;
        if (closeObject != null) {
            this._itemFilter = closeObject.getFilter();
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeFieldName(String str) throws IOException {
        TokenFilter fieldName = this._filterContext.setFieldName(str);
        if (fieldName == null) {
            this._itemFilter = null;
        } else if (fieldName == TokenFilter.INCLUDE_ALL) {
            this._itemFilter = fieldName;
            this.delegate.writeFieldName(str);
        } else {
            TokenFilter includeProperty = fieldName.includeProperty(str);
            this._itemFilter = includeProperty;
            if (includeProperty == TokenFilter.INCLUDE_ALL) {
                _checkPropertyParentPath();
            }
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeFieldName(SerializableString serializableString) throws IOException {
        TokenFilter fieldName = this._filterContext.setFieldName(serializableString.getValue());
        if (fieldName == null) {
            this._itemFilter = null;
        } else if (fieldName == TokenFilter.INCLUDE_ALL) {
            this._itemFilter = fieldName;
            this.delegate.writeFieldName(serializableString);
        } else {
            TokenFilter includeProperty = fieldName.includeProperty(serializableString.getValue());
            this._itemFilter = includeProperty;
            if (includeProperty == TokenFilter.INCLUDE_ALL) {
                _checkPropertyParentPath();
            }
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeFieldId(long j) throws IOException {
        writeFieldName(Long.toString(j));
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeString(String str) throws IOException {
        TokenFilter tokenFilter = this._itemFilter;
        if (tokenFilter == null) {
            return;
        }
        if (tokenFilter != TokenFilter.INCLUDE_ALL) {
            TokenFilter checkValue = this._filterContext.checkValue(this._itemFilter);
            if (checkValue == null) {
                return;
            }
            if (checkValue != TokenFilter.INCLUDE_ALL && !checkValue.includeString(str)) {
                return;
            }
            _checkParentPath();
        }
        this.delegate.writeString(str);
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeString(char[] cArr, int i, int i2) throws IOException {
        TokenFilter tokenFilter = this._itemFilter;
        if (tokenFilter == null) {
            return;
        }
        if (tokenFilter != TokenFilter.INCLUDE_ALL) {
            String str = new String(cArr, i, i2);
            TokenFilter checkValue = this._filterContext.checkValue(this._itemFilter);
            if (checkValue == null) {
                return;
            }
            if (checkValue != TokenFilter.INCLUDE_ALL && !checkValue.includeString(str)) {
                return;
            }
            _checkParentPath();
        }
        this.delegate.writeString(cArr, i, i2);
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeString(SerializableString serializableString) throws IOException {
        TokenFilter tokenFilter = this._itemFilter;
        if (tokenFilter == null) {
            return;
        }
        if (tokenFilter != TokenFilter.INCLUDE_ALL) {
            TokenFilter checkValue = this._filterContext.checkValue(this._itemFilter);
            if (checkValue == null) {
                return;
            }
            if (checkValue != TokenFilter.INCLUDE_ALL && !checkValue.includeString(serializableString.getValue())) {
                return;
            }
            _checkParentPath();
        }
        this.delegate.writeString(serializableString);
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeString(Reader reader, int i) throws IOException {
        TokenFilter tokenFilter = this._itemFilter;
        if (tokenFilter == null) {
            return;
        }
        if (tokenFilter != TokenFilter.INCLUDE_ALL) {
            TokenFilter checkValue = this._filterContext.checkValue(this._itemFilter);
            if (checkValue == null) {
                return;
            }
            if (checkValue != TokenFilter.INCLUDE_ALL && !checkValue.includeString(reader, i)) {
                return;
            }
            _checkParentPath();
        }
        this.delegate.writeString(reader, i);
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeRawUTF8String(byte[] bArr, int i, int i2) throws IOException {
        if (_checkRawValueWrite()) {
            this.delegate.writeRawUTF8String(bArr, i, i2);
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeUTF8String(byte[] bArr, int i, int i2) throws IOException {
        if (_checkRawValueWrite()) {
            this.delegate.writeUTF8String(bArr, i, i2);
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str) throws IOException {
        if (_checkRawValueWrite()) {
            this.delegate.writeRaw(str);
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str, int i, int i2) throws IOException {
        if (_checkRawValueWrite()) {
            this.delegate.writeRaw(str, i, i2);
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(SerializableString serializableString) throws IOException {
        if (_checkRawValueWrite()) {
            this.delegate.writeRaw(serializableString);
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char[] cArr, int i, int i2) throws IOException {
        if (_checkRawValueWrite()) {
            this.delegate.writeRaw(cArr, i, i2);
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char c) throws IOException {
        if (_checkRawValueWrite()) {
            this.delegate.writeRaw(c);
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(String str) throws IOException {
        if (_checkRawValueWrite()) {
            this.delegate.writeRawValue(str);
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(String str, int i, int i2) throws IOException {
        if (_checkRawValueWrite()) {
            this.delegate.writeRawValue(str, i, i2);
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(char[] cArr, int i, int i2) throws IOException {
        if (_checkRawValueWrite()) {
            this.delegate.writeRawValue(cArr, i, i2);
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException {
        if (_checkBinaryWrite()) {
            this.delegate.writeBinary(base64Variant, bArr, i, i2);
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public int writeBinary(Base64Variant base64Variant, InputStream inputStream, int i) throws IOException {
        if (_checkBinaryWrite()) {
            return this.delegate.writeBinary(base64Variant, inputStream, i);
        }
        return -1;
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(short s) throws IOException {
        TokenFilter tokenFilter = this._itemFilter;
        if (tokenFilter == null) {
            return;
        }
        if (tokenFilter != TokenFilter.INCLUDE_ALL) {
            TokenFilter checkValue = this._filterContext.checkValue(this._itemFilter);
            if (checkValue == null) {
                return;
            }
            if (checkValue != TokenFilter.INCLUDE_ALL && !checkValue.includeNumber((int) s)) {
                return;
            }
            _checkParentPath();
        }
        this.delegate.writeNumber(s);
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(int i) throws IOException {
        TokenFilter tokenFilter = this._itemFilter;
        if (tokenFilter == null) {
            return;
        }
        if (tokenFilter != TokenFilter.INCLUDE_ALL) {
            TokenFilter checkValue = this._filterContext.checkValue(this._itemFilter);
            if (checkValue == null) {
                return;
            }
            if (checkValue != TokenFilter.INCLUDE_ALL && !checkValue.includeNumber(i)) {
                return;
            }
            _checkParentPath();
        }
        this.delegate.writeNumber(i);
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(long j) throws IOException {
        TokenFilter tokenFilter = this._itemFilter;
        if (tokenFilter == null) {
            return;
        }
        if (tokenFilter != TokenFilter.INCLUDE_ALL) {
            TokenFilter checkValue = this._filterContext.checkValue(this._itemFilter);
            if (checkValue == null) {
                return;
            }
            if (checkValue != TokenFilter.INCLUDE_ALL && !checkValue.includeNumber(j)) {
                return;
            }
            _checkParentPath();
        }
        this.delegate.writeNumber(j);
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigInteger bigInteger) throws IOException {
        TokenFilter tokenFilter = this._itemFilter;
        if (tokenFilter == null) {
            return;
        }
        if (tokenFilter != TokenFilter.INCLUDE_ALL) {
            TokenFilter checkValue = this._filterContext.checkValue(this._itemFilter);
            if (checkValue == null) {
                return;
            }
            if (checkValue != TokenFilter.INCLUDE_ALL && !checkValue.includeNumber(bigInteger)) {
                return;
            }
            _checkParentPath();
        }
        this.delegate.writeNumber(bigInteger);
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(double d) throws IOException {
        TokenFilter tokenFilter = this._itemFilter;
        if (tokenFilter == null) {
            return;
        }
        if (tokenFilter != TokenFilter.INCLUDE_ALL) {
            TokenFilter checkValue = this._filterContext.checkValue(this._itemFilter);
            if (checkValue == null) {
                return;
            }
            if (checkValue != TokenFilter.INCLUDE_ALL && !checkValue.includeNumber(d)) {
                return;
            }
            _checkParentPath();
        }
        this.delegate.writeNumber(d);
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(float f) throws IOException {
        TokenFilter tokenFilter = this._itemFilter;
        if (tokenFilter == null) {
            return;
        }
        if (tokenFilter != TokenFilter.INCLUDE_ALL) {
            TokenFilter checkValue = this._filterContext.checkValue(this._itemFilter);
            if (checkValue == null) {
                return;
            }
            if (checkValue != TokenFilter.INCLUDE_ALL && !checkValue.includeNumber(f)) {
                return;
            }
            _checkParentPath();
        }
        this.delegate.writeNumber(f);
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigDecimal bigDecimal) throws IOException {
        TokenFilter tokenFilter = this._itemFilter;
        if (tokenFilter == null) {
            return;
        }
        if (tokenFilter != TokenFilter.INCLUDE_ALL) {
            TokenFilter checkValue = this._filterContext.checkValue(this._itemFilter);
            if (checkValue == null) {
                return;
            }
            if (checkValue != TokenFilter.INCLUDE_ALL && !checkValue.includeNumber(bigDecimal)) {
                return;
            }
            _checkParentPath();
        }
        this.delegate.writeNumber(bigDecimal);
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(String str) throws IOException, UnsupportedOperationException {
        TokenFilter tokenFilter = this._itemFilter;
        if (tokenFilter == null) {
            return;
        }
        if (tokenFilter != TokenFilter.INCLUDE_ALL) {
            TokenFilter checkValue = this._filterContext.checkValue(this._itemFilter);
            if (checkValue == null) {
                return;
            }
            if (checkValue != TokenFilter.INCLUDE_ALL && !checkValue.includeRawValue()) {
                return;
            }
            _checkParentPath();
        }
        this.delegate.writeNumber(str);
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(char[] cArr, int i, int i2) throws IOException, UnsupportedOperationException {
        TokenFilter tokenFilter = this._itemFilter;
        if (tokenFilter == null) {
            return;
        }
        if (tokenFilter != TokenFilter.INCLUDE_ALL) {
            TokenFilter checkValue = this._filterContext.checkValue(this._itemFilter);
            if (checkValue == null) {
                return;
            }
            if (checkValue != TokenFilter.INCLUDE_ALL && !checkValue.includeRawValue()) {
                return;
            }
            _checkParentPath();
        }
        this.delegate.writeNumber(cArr, i, i2);
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeBoolean(boolean z) throws IOException {
        TokenFilter tokenFilter = this._itemFilter;
        if (tokenFilter == null) {
            return;
        }
        if (tokenFilter != TokenFilter.INCLUDE_ALL) {
            TokenFilter checkValue = this._filterContext.checkValue(this._itemFilter);
            if (checkValue == null) {
                return;
            }
            if (checkValue != TokenFilter.INCLUDE_ALL && !checkValue.includeBoolean(z)) {
                return;
            }
            _checkParentPath();
        }
        this.delegate.writeBoolean(z);
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeNull() throws IOException {
        TokenFilter tokenFilter = this._itemFilter;
        if (tokenFilter == null) {
            return;
        }
        if (tokenFilter != TokenFilter.INCLUDE_ALL) {
            TokenFilter checkValue = this._filterContext.checkValue(this._itemFilter);
            if (checkValue == null) {
                return;
            }
            if (checkValue != TokenFilter.INCLUDE_ALL && !checkValue.includeNull()) {
                return;
            }
            _checkParentPath();
        }
        this.delegate.writeNull();
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeOmittedField(String str) throws IOException {
        if (this._itemFilter != null) {
            this.delegate.writeOmittedField(str);
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeObjectId(Object obj) throws IOException {
        if (this._itemFilter != null) {
            this.delegate.writeObjectId(obj);
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeObjectRef(Object obj) throws IOException {
        if (this._itemFilter != null) {
            this.delegate.writeObjectRef(obj);
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonGeneratorDelegate, com.fasterxml.jackson.core.JsonGenerator
    public void writeTypeId(Object obj) throws IOException {
        if (this._itemFilter != null) {
            this.delegate.writeTypeId(obj);
        }
    }

    protected void _checkParentPath() throws IOException {
        _checkParentPath(true);
    }

    protected void _checkParentPath(boolean z) throws IOException {
        if (z) {
            this._matchCount++;
        }
        if (this._inclusion == TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH) {
            this._filterContext.writePath(this.delegate);
        } else if (this._inclusion == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
            this._filterContext.ensureFieldNameWritten(this.delegate);
        }
        if (!z || this._allowMultipleMatches) {
            return;
        }
        this._filterContext.skipParentChecks();
    }

    protected void _checkPropertyParentPath() throws IOException {
        this._matchCount++;
        if (this._inclusion == TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH) {
            this._filterContext.writePath(this.delegate);
        } else if (this._inclusion == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
            this._filterContext.ensureFieldNameWritten(this.delegate);
        }
        if (this._allowMultipleMatches) {
            return;
        }
        this._filterContext.skipParentChecks();
    }

    protected boolean _checkBinaryWrite() throws IOException {
        TokenFilter tokenFilter = this._itemFilter;
        if (tokenFilter == null) {
            return false;
        }
        if (tokenFilter == TokenFilter.INCLUDE_ALL) {
            return true;
        }
        if (this._itemFilter.includeBinary()) {
            _checkParentPath();
            return true;
        }
        return false;
    }

    protected boolean _checkRawValueWrite() throws IOException {
        TokenFilter tokenFilter = this._itemFilter;
        if (tokenFilter == null) {
            return false;
        }
        if (tokenFilter == TokenFilter.INCLUDE_ALL) {
            return true;
        }
        if (this._itemFilter.includeRawValue()) {
            _checkParentPath();
            return true;
        }
        return false;
    }
}
