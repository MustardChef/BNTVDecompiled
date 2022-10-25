package com.fasterxml.jackson.core.async;

/* loaded from: classes2.dex */
public interface NonBlockingInputFeeder {
    void endOfInput();

    boolean needMoreInput();
}
