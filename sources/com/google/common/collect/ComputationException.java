package com.google.common.collect;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes3.dex */
public class ComputationException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public ComputationException(@NullableDecl Throwable th) {
        super(th);
    }
}
