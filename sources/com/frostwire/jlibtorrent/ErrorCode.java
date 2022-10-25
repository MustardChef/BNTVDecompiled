package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.error_code;

/* loaded from: classes2.dex */
public final class ErrorCode {
    private boolean isError;
    private String message;
    private int value;

    public ErrorCode(error_code error_codeVar) {
        assign(error_codeVar);
    }

    public int value() {
        return this.value;
    }

    public String message() {
        return this.message;
    }

    public boolean isError() {
        return this.isError;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void assign(error_code error_codeVar) {
        this.value = error_codeVar.value();
        this.message = error_codeVar.message();
        this.isError = error_codeVar.op_bool();
    }
}
