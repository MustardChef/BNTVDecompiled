package org.mozilla.javascript;

import java.io.CharArrayWriter;
import java.io.FilenameFilter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public abstract class RhinoException extends RuntimeException {
    static final long serialVersionUID = 1883500631321581169L;
    private static boolean useMozillaStackStyle = false;
    private int columnNumber;
    int[] interpreterLineData;
    Object interpreterStackInfo;
    private int lineNumber;
    private String lineSource;
    private String sourceName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RhinoException() {
        Evaluator createInterpreter = Context.createInterpreter();
        if (createInterpreter != null) {
            createInterpreter.captureStackInfo(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RhinoException(String str) {
        super(str);
        Evaluator createInterpreter = Context.createInterpreter();
        if (createInterpreter != null) {
            createInterpreter.captureStackInfo(this);
        }
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String details = details();
        if (this.sourceName == null || this.lineNumber <= 0) {
            return details;
        }
        StringBuffer stringBuffer = new StringBuffer(details);
        stringBuffer.append(" (");
        String str = this.sourceName;
        if (str != null) {
            stringBuffer.append(str);
        }
        if (this.lineNumber > 0) {
            stringBuffer.append('#');
            stringBuffer.append(this.lineNumber);
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public String details() {
        return super.getMessage();
    }

    public final String sourceName() {
        return this.sourceName;
    }

    public final void initSourceName(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (this.sourceName != null) {
            throw new IllegalStateException();
        }
        this.sourceName = str;
    }

    public final int lineNumber() {
        return this.lineNumber;
    }

    public final void initLineNumber(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        if (this.lineNumber > 0) {
            throw new IllegalStateException();
        }
        this.lineNumber = i;
    }

    public final int columnNumber() {
        return this.columnNumber;
    }

    public final void initColumnNumber(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        if (this.columnNumber > 0) {
            throw new IllegalStateException();
        }
        this.columnNumber = i;
    }

    public final String lineSource() {
        return this.lineSource;
    }

    public final void initLineSource(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (this.lineSource != null) {
            throw new IllegalStateException();
        }
        this.lineSource = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void recordErrorOrigin(String str, int i, String str2, int i2) {
        if (i == -1) {
            i = 0;
        }
        if (str != null) {
            initSourceName(str);
        }
        if (i != 0) {
            initLineNumber(i);
        }
        if (str2 != null) {
            initLineSource(str2);
        }
        if (i2 != 0) {
            initColumnNumber(i2);
        }
    }

    private String generateStackTrace() {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        super.printStackTrace(new PrintWriter(charArrayWriter));
        String charArrayWriter2 = charArrayWriter.toString();
        Evaluator createInterpreter = Context.createInterpreter();
        if (createInterpreter != null) {
            return createInterpreter.getPatchedStack(this, charArrayWriter2);
        }
        return null;
    }

    public String getScriptStackTrace() {
        ScriptStackElement[] scriptStack;
        StringBuilder sb = new StringBuilder();
        String systemProperty = SecurityUtilities.getSystemProperty("line.separator");
        for (ScriptStackElement scriptStackElement : getScriptStack()) {
            if (useMozillaStackStyle) {
                scriptStackElement.renderMozillaStyle(sb);
            } else {
                scriptStackElement.renderJavaStyle(sb);
            }
            sb.append(systemProperty);
        }
        return sb.toString();
    }

    public String getScriptStackTrace(FilenameFilter filenameFilter) {
        return getScriptStackTrace();
    }

    public ScriptStackElement[] getScriptStack() {
        ArrayList arrayList = new ArrayList();
        ScriptStackElement[][] scriptStackElementArr = null;
        if (this.interpreterStackInfo != null) {
            Evaluator createInterpreter = Context.createInterpreter();
            if (createInterpreter instanceof Interpreter) {
                scriptStackElementArr = ((Interpreter) createInterpreter).getScriptStackElements(this);
            }
        }
        StackTraceElement[] stackTrace = getStackTrace();
        Pattern compile = Pattern.compile("_c_(.*)_\\d+");
        int i = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            String fileName = stackTraceElement.getFileName();
            if (stackTraceElement.getMethodName().startsWith("_c_") && stackTraceElement.getLineNumber() > -1 && fileName != null && !fileName.endsWith(".java")) {
                String methodName = stackTraceElement.getMethodName();
                Matcher matcher = compile.matcher(methodName);
                arrayList.add(new ScriptStackElement(fileName, ("_c_script_0".equals(methodName) || !matcher.find()) ? null : matcher.group(1), stackTraceElement.getLineNumber()));
            } else if ("org.mozilla.javascript.Interpreter".equals(stackTraceElement.getClassName()) && "interpretLoop".equals(stackTraceElement.getMethodName()) && scriptStackElementArr != null && scriptStackElementArr.length > i) {
                int i2 = i + 1;
                for (ScriptStackElement scriptStackElement : scriptStackElementArr[i]) {
                    arrayList.add(scriptStackElement);
                }
                i = i2;
            }
        }
        return (ScriptStackElement[]) arrayList.toArray(new ScriptStackElement[arrayList.size()]);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        if (this.interpreterStackInfo == null) {
            super.printStackTrace(printWriter);
        } else {
            printWriter.print(generateStackTrace());
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        if (this.interpreterStackInfo == null) {
            super.printStackTrace(printStream);
        } else {
            printStream.print(generateStackTrace());
        }
    }

    public static boolean usesMozillaStackStyle() {
        return useMozillaStackStyle;
    }

    public static void useMozillaStackStyle(boolean z) {
        useMozillaStackStyle = z;
    }
}
