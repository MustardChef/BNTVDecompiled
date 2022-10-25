package org.mozilla.javascript.ast;

import org.mozilla.javascript.ErrorReporter;

/* loaded from: classes5.dex */
public interface IdeErrorReporter extends ErrorReporter {
    void error(String str, String str2, int i, int i2);

    void warning(String str, String str2, int i, int i2);
}
