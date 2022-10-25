package org.mozilla.javascript.regexp;

/* compiled from: NativeRegExp.java */
/* loaded from: classes5.dex */
class REGlobalData {
    REBackTrackData backTrackStackTop;

    /* renamed from: cp */
    int f10780cp;
    boolean multiline;
    long[] parens;
    RECompiled regexp;
    int skipped;
    REProgState stateStackTop;

    /* JADX INFO: Access modifiers changed from: package-private */
    public int parensIndex(int i) {
        return (int) this.parens[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int parensLength(int i) {
        return (int) (this.parens[i] >>> 32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setParens(int i, int i2, int i3) {
        REBackTrackData rEBackTrackData = this.backTrackStackTop;
        if (rEBackTrackData != null) {
            long[] jArr = rEBackTrackData.parens;
            long[] jArr2 = this.parens;
            if (jArr == jArr2) {
                this.parens = (long[]) jArr2.clone();
            }
        }
        this.parens[i] = (i3 << 32) | (i2 & 4294967295L);
    }
}
