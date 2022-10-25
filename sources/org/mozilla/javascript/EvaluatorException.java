package org.mozilla.javascript;

/* loaded from: classes5.dex */
public class EvaluatorException extends RhinoException {
    static final long serialVersionUID = -8743165779676009808L;

    public EvaluatorException(String str) {
        super(str);
    }

    public EvaluatorException(String str, String str2, int i) {
        this(str, str2, i, null, 0);
    }

    public EvaluatorException(String str, String str2, int i, String str3, int i2) {
        super(str);
        recordErrorOrigin(str2, i, str3, i2);
    }

    public String getSourceName() {
        return sourceName();
    }

    public int getLineNumber() {
        return lineNumber();
    }

    public int getColumnNumber() {
        return columnNumber();
    }

    public String getLineSource() {
        return lineSource();
    }
}
