package org.mozilla.javascript.tools;

import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.EcmaError;
import org.mozilla.javascript.ErrorReporter;
import org.mozilla.javascript.EvaluatorException;
import org.mozilla.javascript.JavaScriptException;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.SecurityUtilities;
import org.mozilla.javascript.WrappedException;

/* loaded from: classes5.dex */
public class ToolErrorReporter implements ErrorReporter {
    private static final String messagePrefix = "js: ";
    private PrintStream err;
    private boolean hasReportedErrorFlag;
    private boolean reportWarnings;

    public ToolErrorReporter(boolean z) {
        this(z, System.err);
    }

    public ToolErrorReporter(boolean z, PrintStream printStream) {
        this.reportWarnings = z;
        this.err = printStream;
    }

    public static String getMessage(String str) {
        return getMessage(str, (Object[]) null);
    }

    public static String getMessage(String str, String str2) {
        return getMessage(str, new Object[]{str2});
    }

    public static String getMessage(String str, Object obj, Object obj2) {
        return getMessage(str, new Object[]{obj, obj2});
    }

    public static String getMessage(String str, Object[] objArr) {
        Context currentContext = Context.getCurrentContext();
        try {
            String string = ResourceBundle.getBundle("org.mozilla.javascript.tools.resources.Messages", currentContext == null ? Locale.getDefault() : currentContext.getLocale()).getString(str);
            return objArr == null ? string : new MessageFormat(string).format(objArr);
        } catch (MissingResourceException unused) {
            throw new RuntimeException("no message resource found for message property " + str);
        }
    }

    private static String getExceptionMessage(RhinoException rhinoException) {
        if (rhinoException instanceof JavaScriptException) {
            return getMessage("msg.uncaughtJSException", rhinoException.details());
        }
        if (rhinoException instanceof EcmaError) {
            return getMessage("msg.uncaughtEcmaError", rhinoException.details());
        }
        if (rhinoException instanceof EvaluatorException) {
            return rhinoException.details();
        }
        return rhinoException.toString();
    }

    @Override // org.mozilla.javascript.ErrorReporter
    public void warning(String str, String str2, int i, String str3, int i2) {
        if (this.reportWarnings) {
            reportErrorMessage(str, str2, i, str3, i2, true);
        }
    }

    @Override // org.mozilla.javascript.ErrorReporter
    public void error(String str, String str2, int i, String str3, int i2) {
        this.hasReportedErrorFlag = true;
        reportErrorMessage(str, str2, i, str3, i2, false);
    }

    @Override // org.mozilla.javascript.ErrorReporter
    public EvaluatorException runtimeError(String str, String str2, int i, String str3, int i2) {
        return new EvaluatorException(str, str2, i, str3, i2);
    }

    public boolean hasReportedError() {
        return this.hasReportedErrorFlag;
    }

    public boolean isReportingWarnings() {
        return this.reportWarnings;
    }

    public void setIsReportingWarnings(boolean z) {
        this.reportWarnings = z;
    }

    public static void reportException(ErrorReporter errorReporter, RhinoException rhinoException) {
        if (errorReporter instanceof ToolErrorReporter) {
            ((ToolErrorReporter) errorReporter).reportException(rhinoException);
        } else {
            errorReporter.error(getExceptionMessage(rhinoException), rhinoException.sourceName(), rhinoException.lineNumber(), rhinoException.lineSource(), rhinoException.columnNumber());
        }
    }

    public void reportException(RhinoException rhinoException) {
        if (rhinoException instanceof WrappedException) {
            ((WrappedException) rhinoException).printStackTrace(this.err);
            return;
        }
        String systemProperty = SecurityUtilities.getSystemProperty("line.separator");
        reportErrorMessage(getExceptionMessage(rhinoException) + systemProperty + rhinoException.getScriptStackTrace(), rhinoException.sourceName(), rhinoException.lineNumber(), rhinoException.lineSource(), rhinoException.columnNumber(), false);
    }

    private void reportErrorMessage(String str, String str2, int i, String str3, int i2, boolean z) {
        String message;
        if (i > 0) {
            String valueOf = String.valueOf(i);
            if (str2 != null) {
                message = getMessage("msg.format3", new Object[]{str2, valueOf, str});
            } else {
                message = getMessage("msg.format2", new Object[]{valueOf, str});
            }
        } else {
            message = getMessage("msg.format1", new Object[]{str});
        }
        if (z) {
            message = getMessage("msg.warning", message);
        }
        PrintStream printStream = this.err;
        printStream.println(messagePrefix + message);
        if (str3 != null) {
            PrintStream printStream2 = this.err;
            printStream2.println(messagePrefix + str3);
            PrintStream printStream3 = this.err;
            printStream3.println(messagePrefix + buildIndicator(i2));
        }
    }

    private String buildIndicator(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i - 1; i2++) {
            stringBuffer.append(".");
        }
        stringBuffer.append("^");
        return stringBuffer.toString();
    }
}
