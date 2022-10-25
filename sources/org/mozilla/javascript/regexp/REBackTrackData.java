package org.mozilla.javascript.regexp;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NativeRegExp.java */
/* loaded from: classes5.dex */
public class REBackTrackData {
    final int continuationOp;
    final int continuationPc;

    /* renamed from: cp */
    final int f10777cp;

    /* renamed from: op */
    final int f10778op;
    final long[] parens;

    /* renamed from: pc */
    final int f10779pc;
    final REBackTrackData previous;
    final REProgState stateStackTop;

    /* JADX INFO: Access modifiers changed from: package-private */
    public REBackTrackData(REGlobalData rEGlobalData, int i, int i2, int i3, int i4, int i5) {
        this.previous = rEGlobalData.backTrackStackTop;
        this.f10778op = i;
        this.f10779pc = i2;
        this.f10777cp = i3;
        this.continuationOp = i4;
        this.continuationPc = i5;
        this.parens = rEGlobalData.parens;
        this.stateStackTop = rEGlobalData.stateStackTop;
    }
}
