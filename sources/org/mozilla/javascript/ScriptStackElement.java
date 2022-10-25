package org.mozilla.javascript;

import java.io.Serializable;

/* loaded from: classes5.dex */
public final class ScriptStackElement implements Serializable {
    static final long serialVersionUID = -6416688260860477449L;
    public final String fileName;
    public final String functionName;
    public final int lineNumber;

    public ScriptStackElement(String str, String str2, int i) {
        this.fileName = str;
        this.functionName = str2;
        this.lineNumber = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        renderMozillaStyle(sb);
        return sb.toString();
    }

    public void renderJavaStyle(StringBuilder sb) {
        sb.append("\tat ");
        sb.append(this.fileName);
        if (this.lineNumber > -1) {
            sb.append(':');
            sb.append(this.lineNumber);
        }
        if (this.functionName != null) {
            sb.append(" (");
            sb.append(this.functionName);
            sb.append(')');
        }
    }

    public void renderMozillaStyle(StringBuilder sb) {
        String str = this.functionName;
        if (str != null) {
            sb.append(str);
            sb.append("()");
        }
        sb.append('@');
        sb.append(this.fileName);
        if (this.lineNumber > -1) {
            sb.append(':');
            sb.append(this.lineNumber);
        }
    }
}
