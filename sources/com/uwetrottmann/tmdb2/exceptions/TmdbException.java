package com.uwetrottmann.tmdb2.exceptions;

import java.io.IOException;

/* loaded from: classes4.dex */
public class TmdbException extends IOException {
    private int code;

    public int getCode() {
        return this.code;
    }

    public TmdbException(String str) {
        super(str);
    }

    public TmdbException(int i, String str) {
        super(str);
        this.code = i;
    }
}
