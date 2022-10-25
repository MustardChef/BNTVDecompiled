package org.mozilla.javascript.regexp;

import org.mozilla.javascript.Context;

/* compiled from: NativeRegExp.java */
/* loaded from: classes5.dex */
class CompilerState {
    char[] cpbegin;
    int cpend;

    /* renamed from: cx */
    Context f10775cx;
    int flags;
    int parenNesting;
    RENode result;

    /* renamed from: cp */
    int f10774cp = 0;
    int parenCount = 0;
    int classCount = 0;
    int progLength = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompilerState(Context context, char[] cArr, int i, int i2) {
        this.f10775cx = context;
        this.cpbegin = cArr;
        this.cpend = i;
        this.flags = i2;
    }
}
