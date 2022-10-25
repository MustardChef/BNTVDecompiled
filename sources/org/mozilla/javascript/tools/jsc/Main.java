package org.mozilla.javascript.tools.jsc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.optimizer.ClassCompiler;
import org.mozilla.javascript.tools.SourceReader;
import org.mozilla.javascript.tools.ToolErrorReporter;

/* loaded from: classes5.dex */
public class Main {
    private String characterEncoding;
    private ClassCompiler compiler;
    private CompilerEnvirons compilerEnv;
    private String destinationDir;
    private boolean printHelp;
    private ToolErrorReporter reporter = new ToolErrorReporter(true);
    private String targetName;
    private String targetPackage;

    public static void main(String[] strArr) {
        Main main = new Main();
        String[] processOptions = main.processOptions(strArr);
        if (processOptions == null) {
            if (main.printHelp) {
                System.out.println(ToolErrorReporter.getMessage("msg.jsc.usage", Main.class.getName()));
                System.exit(0);
            }
            System.exit(1);
        }
        if (main.reporter.hasReportedError()) {
            return;
        }
        main.processSource(processOptions);
    }

    public Main() {
        CompilerEnvirons compilerEnvirons = new CompilerEnvirons();
        this.compilerEnv = compilerEnvirons;
        compilerEnvirons.setErrorReporter(this.reporter);
        this.compiler = new ClassCompiler(this.compilerEnv);
    }

    public String[] processOptions(String[] strArr) {
        int i;
        this.targetPackage = "";
        this.compilerEnv.setGenerateDebugInfo(false);
        int i2 = 0;
        while (i2 < strArr.length) {
            String str = strArr[i2];
            if (!str.startsWith("-")) {
                int length = strArr.length - i2;
                String str2 = this.targetName;
                if (str2 != null && length > 1) {
                    addError("msg.multiple.js.to.file", str2);
                    return null;
                }
                String[] strArr2 = new String[length];
                for (int i3 = 0; i3 != length; i3++) {
                    strArr2[i3] = strArr[i2 + i3];
                }
                return strArr2;
            } else if (str.equals("-help") || str.equals("-h") || str.equals("--help")) {
                this.printHelp = true;
                return null;
            } else {
                try {
                    if (str.equals("-version") && (i2 = i2 + 1) < strArr.length) {
                        this.compilerEnv.setLanguageVersion(Integer.parseInt(strArr[i2]));
                    } else if ((str.equals("-opt") || str.equals("-O")) && (i2 = i2 + 1) < strArr.length) {
                        this.compilerEnv.setOptimizationLevel(Integer.parseInt(strArr[i2]));
                    } else if (str.equals("-nosource")) {
                        this.compilerEnv.setGeneratingSource(false);
                    } else if (str.equals("-debug") || str.equals("-g")) {
                        this.compilerEnv.setGenerateDebugInfo(true);
                    } else if (str.equals("-main-method-class") && (i2 = i2 + 1) < strArr.length) {
                        this.compiler.setMainMethodClass(strArr[i2]);
                    } else if (str.equals("-encoding") && (i2 = i2 + 1) < strArr.length) {
                        this.characterEncoding = strArr[i2];
                    } else if (str.equals("-o") && (i2 = i2 + 1) < strArr.length) {
                        String str3 = strArr[i2];
                        int length2 = str3.length();
                        if (length2 == 0 || !Character.isJavaIdentifierStart(str3.charAt(0))) {
                            addError("msg.invalid.classfile.name", str3);
                        } else {
                            int i4 = 1;
                            while (true) {
                                if (i4 >= length2) {
                                    break;
                                }
                                char charAt = str3.charAt(i4);
                                if (Character.isJavaIdentifierPart(charAt)) {
                                    i4++;
                                } else if (charAt == '.' && i4 == length2 - 6 && str3.endsWith(".class")) {
                                    str3 = str3.substring(0, i4);
                                } else {
                                    addError("msg.invalid.classfile.name", str3);
                                }
                            }
                            this.targetName = str3;
                        }
                    } else {
                        if (str.equals("-observe-instruction-count")) {
                            this.compilerEnv.setGenerateObserverCount(true);
                        }
                        if (str.equals("-package") && (i2 = i2 + 1) < strArr.length) {
                            String str4 = strArr[i2];
                            int length3 = str4.length();
                            while (i != length3) {
                                char charAt2 = str4.charAt(i);
                                if (Character.isJavaIdentifierStart(charAt2)) {
                                    do {
                                        i++;
                                        if (i == length3) {
                                            break;
                                        }
                                        charAt2 = str4.charAt(i);
                                    } while (Character.isJavaIdentifierPart(charAt2));
                                    if (i == length3) {
                                        break;
                                    }
                                    i = (charAt2 == '.' && i != length3 + (-1)) ? i + 1 : 0;
                                }
                                addError("msg.package.name", this.targetPackage);
                                return null;
                            }
                            this.targetPackage = str4;
                        } else if (str.equals("-extends") && (i2 = i2 + 1) < strArr.length) {
                            try {
                                this.compiler.setTargetExtends(Class.forName(strArr[i2]));
                            } catch (ClassNotFoundException e) {
                                throw new Error(e.toString());
                            }
                        } else if (str.equals("-implements") && (i2 = i2 + 1) < strArr.length) {
                            StringTokenizer stringTokenizer = new StringTokenizer(strArr[i2], ",");
                            ArrayList arrayList = new ArrayList();
                            while (stringTokenizer.hasMoreTokens()) {
                                try {
                                    arrayList.add(Class.forName(stringTokenizer.nextToken()));
                                } catch (ClassNotFoundException e2) {
                                    throw new Error(e2.toString());
                                }
                            }
                            this.compiler.setTargetImplements((Class[]) arrayList.toArray(new Class[arrayList.size()]));
                        } else if (str.equals("-d") && (i2 = i2 + 1) < strArr.length) {
                            this.destinationDir = strArr[i2];
                        } else {
                            badUsage(str);
                            return null;
                        }
                    }
                    i2++;
                } catch (NumberFormatException unused) {
                    badUsage(strArr[i2]);
                    return null;
                }
            }
        }
        m38p(ToolErrorReporter.getMessage("msg.no.file"));
        return null;
    }

    private static void badUsage(String str) {
        System.err.println(ToolErrorReporter.getMessage("msg.jsc.bad.usage", Main.class.getName(), str));
    }

    public void processSource(String[] strArr) {
        String name;
        for (int i = 0; i != strArr.length; i++) {
            String str = strArr[i];
            if (!str.endsWith(".js")) {
                addError("msg.extension.not.js", str);
                return;
            }
            File file = new File(str);
            String readSource = readSource(file);
            if (readSource == null) {
                return;
            }
            String str2 = this.targetName;
            if (str2 == null) {
                str2 = getClassName(file.getName().substring(0, name.length() - 3));
            }
            if (this.targetPackage.length() != 0) {
                str2 = this.targetPackage + "." + str2;
            }
            Object[] compileToClassFiles = this.compiler.compileToClassFiles(readSource, str, 1, str2);
            if (compileToClassFiles == null || compileToClassFiles.length == 0) {
                return;
            }
            File file2 = null;
            if (this.destinationDir != null) {
                file2 = new File(this.destinationDir);
            } else {
                String parent = file.getParent();
                if (parent != null) {
                    file2 = new File(parent);
                }
            }
            for (int i2 = 0; i2 != compileToClassFiles.length; i2 += 2) {
                byte[] bArr = (byte[]) compileToClassFiles[i2 + 1];
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(getOutputFile(file2, (String) compileToClassFiles[i2]));
                    fileOutputStream.write(bArr);
                    fileOutputStream.close();
                } catch (IOException e) {
                    addFormatedError(e.toString());
                }
            }
        }
    }

    private String readSource(File file) {
        String absolutePath = file.getAbsolutePath();
        if (!file.isFile()) {
            addError("msg.jsfile.not.found", absolutePath);
            return null;
        }
        try {
            return (String) SourceReader.readFileOrUrl(absolutePath, true, this.characterEncoding);
        } catch (FileNotFoundException unused) {
            addError("msg.couldnt.open", absolutePath);
            return null;
        } catch (IOException e) {
            addFormatedError(e.toString());
            return null;
        }
    }

    private File getOutputFile(File file, String str) {
        File file2 = new File(file, str.replace('.', File.separatorChar).concat(".class"));
        String parent = file2.getParent();
        if (parent != null) {
            File file3 = new File(parent);
            if (!file3.exists()) {
                file3.mkdirs();
            }
        }
        return file2;
    }

    String getClassName(String str) {
        int i = 1;
        char[] cArr = new char[str.length() + 1];
        int i2 = 0;
        if (Character.isJavaIdentifierStart(str.charAt(0))) {
            i = 0;
        } else {
            cArr[0] = '_';
        }
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (Character.isJavaIdentifierPart(charAt)) {
                cArr[i] = charAt;
            } else {
                cArr[i] = '_';
            }
            i2++;
            i++;
        }
        return new String(cArr).trim();
    }

    /* renamed from: p */
    private static void m38p(String str) {
        System.out.println(str);
    }

    private void addError(String str, String str2) {
        String message;
        if (str2 == null) {
            message = ToolErrorReporter.getMessage(str);
        } else {
            message = ToolErrorReporter.getMessage(str, str2);
        }
        addFormatedError(message);
    }

    private void addFormatedError(String str) {
        this.reporter.error(str, null, -1, null, -1);
    }
}
