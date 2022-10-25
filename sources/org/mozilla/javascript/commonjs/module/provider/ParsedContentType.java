package org.mozilla.javascript.commonjs.module.provider;

import java.io.Serializable;
import java.util.StringTokenizer;

/* loaded from: classes5.dex */
public final class ParsedContentType implements Serializable {
    private static final long serialVersionUID = 1;
    private final String contentType;
    private final String encoding;

    public ParsedContentType(String str) {
        String str2;
        String str3 = null;
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
            if (stringTokenizer.hasMoreTokens()) {
                String trim = stringTokenizer.nextToken().trim();
                while (true) {
                    if (!stringTokenizer.hasMoreTokens()) {
                        break;
                    }
                    String trim2 = stringTokenizer.nextToken().trim();
                    if (trim2.startsWith("charset=")) {
                        str3 = trim2.substring(8).trim();
                        int length = str3.length();
                        if (length > 0) {
                            str3 = str3.charAt(0) == '\"' ? str3.substring(1) : str3;
                            int i = length - 1;
                            if (str3.charAt(i) == '\"') {
                                str3 = str3.substring(0, i);
                            }
                        }
                    }
                }
                String str4 = str3;
                str3 = trim;
                str2 = str4;
                this.contentType = str3;
                this.encoding = str2;
            }
        }
        str2 = null;
        this.contentType = str3;
        this.encoding = str2;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getEncoding() {
        return this.encoding;
    }
}
