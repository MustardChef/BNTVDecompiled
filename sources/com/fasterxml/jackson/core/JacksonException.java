package com.fasterxml.jackson.core;

import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class JacksonException extends IOException {
    private static final long serialVersionUID = 123;

    public abstract JsonLocation getLocation();

    public abstract String getOriginalMessage();

    public abstract Object getProcessor();

    /* JADX INFO: Access modifiers changed from: protected */
    public JacksonException(String str) {
        super(str);
    }

    protected JacksonException(Throwable th) {
        super(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JacksonException(String str, Throwable th) {
        super(str, th);
    }
}
