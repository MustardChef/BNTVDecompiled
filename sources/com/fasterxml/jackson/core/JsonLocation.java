package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.p033io.ContentReference;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class JsonLocation implements Serializable {
    @Deprecated
    public static final int MAX_CONTENT_SNIPPET = 500;

    /* renamed from: NA */
    public static final JsonLocation f2776NA = new JsonLocation(ContentReference.unknown(), -1L, -1L, -1, -1);
    private static final long serialVersionUID = 2;
    protected final int _columnNr;
    protected final ContentReference _contentReference;
    protected final int _lineNr;
    protected transient String _sourceDescription;
    protected final long _totalBytes;
    protected final long _totalChars;

    public JsonLocation(ContentReference contentReference, long j, int i, int i2) {
        this(contentReference, -1L, j, i, i2);
    }

    public JsonLocation(ContentReference contentReference, long j, long j2, int i, int i2) {
        this._contentReference = contentReference == null ? ContentReference.unknown() : contentReference;
        this._totalBytes = j;
        this._totalChars = j2;
        this._lineNr = i;
        this._columnNr = i2;
    }

    @Deprecated
    public JsonLocation(Object obj, long j, int i, int i2) {
        this(_wrap(obj), j, i, i2);
    }

    @Deprecated
    public JsonLocation(Object obj, long j, long j2, int i, int i2) {
        this(_wrap(obj), j, j2, i, i2);
    }

    protected static ContentReference _wrap(Object obj) {
        if (obj instanceof ContentReference) {
            return (ContentReference) obj;
        }
        return ContentReference.construct(false, obj);
    }

    public ContentReference contentReference() {
        return this._contentReference;
    }

    @Deprecated
    public Object getSourceRef() {
        return this._contentReference.getRawContent();
    }

    public int getLineNr() {
        return this._lineNr;
    }

    public int getColumnNr() {
        return this._columnNr;
    }

    public long getCharOffset() {
        return this._totalChars;
    }

    public long getByteOffset() {
        return this._totalBytes;
    }

    public String sourceDescription() {
        if (this._sourceDescription == null) {
            this._sourceDescription = this._contentReference.buildSourceDescription();
        }
        return this._sourceDescription;
    }

    public String offsetDescription() {
        return appendOffsetDescription(new StringBuilder(40)).toString();
    }

    public StringBuilder appendOffsetDescription(StringBuilder sb) {
        if (this._contentReference.hasTextualContent()) {
            sb.append("line: ");
            int i = this._lineNr;
            if (i >= 0) {
                sb.append(i);
            } else {
                sb.append("UNKNOWN");
            }
            sb.append(", column: ");
            int i2 = this._columnNr;
            if (i2 >= 0) {
                sb.append(i2);
            } else {
                sb.append("UNKNOWN");
            }
        } else if (this._lineNr > 0) {
            sb.append("line: ");
            sb.append(this._lineNr);
            if (this._columnNr > 0) {
                sb.append(", column: ");
                sb.append(this._columnNr);
            }
        } else {
            sb.append("byte offset: #");
            long j = this._totalBytes;
            if (j >= 0) {
                sb.append(j);
            } else {
                sb.append("UNKNOWN");
            }
        }
        return sb;
    }

    public int hashCode() {
        return ((((this._contentReference == null ? 1 : 2) ^ this._lineNr) + this._columnNr) ^ ((int) this._totalChars)) + ((int) this._totalBytes);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof JsonLocation)) {
            JsonLocation jsonLocation = (JsonLocation) obj;
            ContentReference contentReference = this._contentReference;
            if (contentReference == null) {
                if (jsonLocation._contentReference != null) {
                    return false;
                }
            } else if (!contentReference.equals(jsonLocation._contentReference)) {
                return false;
            }
            return this._lineNr == jsonLocation._lineNr && this._columnNr == jsonLocation._columnNr && this._totalChars == jsonLocation._totalChars && this._totalBytes == jsonLocation._totalBytes;
        }
        return false;
    }

    public String toString() {
        String sourceDescription = sourceDescription();
        StringBuilder sb = new StringBuilder(sourceDescription.length() + 40);
        sb.append("[Source: ");
        sb.append(sourceDescription);
        sb.append("; ");
        StringBuilder appendOffsetDescription = appendOffsetDescription(sb);
        appendOffsetDescription.append(']');
        return appendOffsetDescription.toString();
    }
}
