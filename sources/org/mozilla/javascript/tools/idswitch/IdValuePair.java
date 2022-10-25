package org.mozilla.javascript.tools.idswitch;

/* loaded from: classes5.dex */
public class IdValuePair {

    /* renamed from: id */
    public final String f10789id;
    public final int idLength;
    private int lineNumber;
    public final String value;

    public IdValuePair(String str, String str2) {
        this.idLength = str.length();
        this.f10789id = str;
        this.value = str2;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public void setLineNumber(int i) {
        this.lineNumber = i;
    }
}
