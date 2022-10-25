package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;

/* loaded from: classes2.dex */
public abstract class DatabindException extends JsonProcessingException {
    private static final long serialVersionUID = 3;

    public abstract void prependPath(Object obj, int i);

    public abstract void prependPath(Object obj, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public DatabindException(String str, JsonLocation jsonLocation, Throwable th) {
        super(str, jsonLocation, th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DatabindException(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DatabindException(String str, JsonLocation jsonLocation) {
        this(str, jsonLocation, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DatabindException(String str, Throwable th) {
        this(str, null, th);
    }
}
