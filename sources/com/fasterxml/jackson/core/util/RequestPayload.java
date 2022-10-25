package com.fasterxml.jackson.core.util;

import java.io.IOException;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class RequestPayload implements Serializable {
    private static final long serialVersionUID = 1;
    protected String _charset;
    protected byte[] _payloadAsBytes;
    protected CharSequence _payloadAsText;

    public RequestPayload(byte[] bArr, String str) {
        if (bArr == null) {
            throw new IllegalArgumentException();
        }
        this._payloadAsBytes = bArr;
        this._charset = (str == null || str.isEmpty()) ? "UTF-8" : "UTF-8";
    }

    public RequestPayload(CharSequence charSequence) {
        if (charSequence == null) {
            throw new IllegalArgumentException();
        }
        this._payloadAsText = charSequence;
    }

    public Object getRawPayload() {
        byte[] bArr = this._payloadAsBytes;
        return bArr != null ? bArr : this._payloadAsText;
    }

    public String toString() {
        if (this._payloadAsBytes != null) {
            try {
                return new String(this._payloadAsBytes, this._charset);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return this._payloadAsText.toString();
    }
}
