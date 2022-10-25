package org.mozilla.javascript.tools.shell;

import com.facebook.internal.ServerProtocol;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextAction;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.ImporterTopLevel;
import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Synchronizer;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.Wrapper;
import org.mozilla.javascript.commonjs.module.Require;
import org.mozilla.javascript.commonjs.module.RequireBuilder;
import org.mozilla.javascript.commonjs.module.provider.SoftCachingModuleScriptProvider;
import org.mozilla.javascript.commonjs.module.provider.UrlModuleSourceProvider;
import org.mozilla.javascript.serialize.ScriptableInputStream;
import org.mozilla.javascript.serialize.ScriptableOutputStream;
import org.mozilla.javascript.tools.ToolErrorReporter;

/* loaded from: classes5.dex */
public class Global extends ImporterTopLevel {
    static final long serialVersionUID = 4029130780977538005L;
    boolean attemptedJLineLoad;
    private HashMap<String, String> doctestCanonicalizations;
    private PrintStream errStream;
    NativeArray history;
    private InputStream inStream;
    boolean initialized;
    private PrintStream outStream;
    private QuitAction quitAction;
    private boolean sealedStdLib = false;
    private String[] prompts = {"js> ", "  > "};

    public Global() {
    }

    public Global(Context context) {
        init(context);
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    public void initQuitAction(QuitAction quitAction) {
        if (quitAction == null) {
            throw new IllegalArgumentException("quitAction is null");
        }
        if (this.quitAction != null) {
            throw new IllegalArgumentException("The method is once-call.");
        }
        this.quitAction = quitAction;
    }

    public void init(ContextFactory contextFactory) {
        contextFactory.call(new ContextAction() { // from class: org.mozilla.javascript.tools.shell.Global.1
            @Override // org.mozilla.javascript.ContextAction
            public Object run(Context context) {
                Global.this.init(context);
                return null;
            }
        });
    }

    public void init(Context context) {
        initStandardObjects(context, this.sealedStdLib);
        defineFunctionProperties(new String[]{"defineClass", "deserialize", "doctest", "gc", "help", "load", "loadClass", "print", "quit", "readFile", "readUrl", "runCommand", "seal", "serialize", "spawn", "sync", "toint32", ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION}, Global.class, 2);
        Environment.defineClass(this);
        defineProperty("environment", new Environment(this), 2);
        NativeArray nativeArray = (NativeArray) context.newArray(this, 0);
        this.history = nativeArray;
        defineProperty("history", nativeArray, 2);
        this.initialized = true;
    }

    public Require installRequire(Context context, List<String> list, boolean z) {
        RequireBuilder requireBuilder = new RequireBuilder();
        requireBuilder.setSandboxed(z);
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (String str : list) {
                try {
                    URI uri = new URI(str);
                    if (!uri.isAbsolute()) {
                        uri = new File(str).toURI().resolve("");
                    }
                    if (!uri.toString().endsWith("/")) {
                        uri = new URI(uri + "/");
                    }
                    arrayList.add(uri);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        requireBuilder.setModuleScriptProvider(new SoftCachingModuleScriptProvider(new UrlModuleSourceProvider(arrayList, null)));
        Require createRequire = requireBuilder.createRequire(context, this);
        createRequire.install(this);
        return createRequire;
    }

    public static void help(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        getInstance(function).getOut().println(ToolErrorReporter.getMessage("msg.help"));
    }

    /* renamed from: gc */
    public static void m37gc(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        System.gc();
    }

    public static Object print(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        PrintStream out = getInstance(function).getOut();
        for (int i = 0; i < objArr.length; i++) {
            if (i > 0) {
                out.print(" ");
            }
            out.print(Context.toString(objArr[i]));
        }
        out.println();
        return Context.getUndefinedValue();
    }

    public static void quit(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        Global global = getInstance(function);
        if (global.quitAction != null) {
            global.quitAction.quit(context, objArr.length != 0 ? ScriptRuntime.toInt32(objArr[0]) : 0);
        }
    }

    public static double version(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        double languageVersion = context.getLanguageVersion();
        if (objArr.length > 0) {
            context.setLanguageVersion((int) Context.toNumber(objArr[0]));
        }
        return languageVersion;
    }

    public static void load(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        for (Object obj : objArr) {
            String context2 = Context.toString(obj);
            try {
                Main.processFile(context, scriptable, context2);
            } catch (IOException e) {
                throw Context.reportRuntimeError(ToolErrorReporter.getMessage("msg.couldnt.read.source", context2, e.getMessage()));
            } catch (VirtualMachineError e2) {
                e2.printStackTrace();
                throw Context.reportRuntimeError(ToolErrorReporter.getMessage("msg.uncaughtJSException", e2.toString()));
            }
        }
    }

    public static void defineClass(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> cls = getClass(objArr);
        if (!Scriptable.class.isAssignableFrom(cls)) {
            throw reportRuntimeError("msg.must.implement.Scriptable");
        }
        ScriptableObject.defineClass(scriptable, cls);
    }

    public static void loadClass(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IllegalAccessException, InstantiationException {
        Class<?> cls = getClass(objArr);
        if (!Script.class.isAssignableFrom(cls)) {
            throw reportRuntimeError("msg.must.implement.Script");
        }
        ((Script) cls.newInstance()).exec(context, scriptable);
    }

    private static Class<?> getClass(Object[] objArr) {
        if (objArr.length == 0) {
            throw reportRuntimeError("msg.expected.string.arg");
        }
        Object obj = objArr[0];
        if (obj instanceof Wrapper) {
            Object unwrap = ((Wrapper) obj).unwrap();
            if (unwrap instanceof Class) {
                return (Class) unwrap;
            }
        }
        String context = Context.toString(objArr[0]);
        try {
            return Class.forName(context);
        } catch (ClassNotFoundException unused) {
            throw reportRuntimeError("msg.class.not.found", context);
        }
    }

    public static void serialize(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IOException {
        if (objArr.length < 2) {
            throw Context.reportRuntimeError("Expected an object to serialize and a filename to write the serialization to");
        }
        Object obj = objArr[0];
        ScriptableOutputStream scriptableOutputStream = new ScriptableOutputStream(new FileOutputStream(Context.toString(objArr[1])), ScriptableObject.getTopLevelScope(scriptable));
        scriptableOutputStream.writeObject(obj);
        scriptableOutputStream.close();
    }

    public static Object deserialize(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IOException, ClassNotFoundException {
        if (objArr.length < 1) {
            throw Context.reportRuntimeError("Expected a filename to read the serialization from");
        }
        FileInputStream fileInputStream = new FileInputStream(Context.toString(objArr[0]));
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        ScriptableInputStream scriptableInputStream = new ScriptableInputStream(fileInputStream, topLevelScope);
        Object readObject = scriptableInputStream.readObject();
        scriptableInputStream.close();
        return Context.toObject(readObject, topLevelScope);
    }

    public String[] getPrompts(Context context) {
        if (ScriptableObject.hasProperty(this, "prompts")) {
            Object property = ScriptableObject.getProperty(this, "prompts");
            if (property instanceof Scriptable) {
                Scriptable scriptable = (Scriptable) property;
                if (ScriptableObject.hasProperty(scriptable, 0) && ScriptableObject.hasProperty(scriptable, 1)) {
                    Object property2 = ScriptableObject.getProperty(scriptable, 0);
                    if (property2 instanceof Function) {
                        property2 = ((Function) property2).call(context, this, scriptable, new Object[0]);
                    }
                    this.prompts[0] = Context.toString(property2);
                    Object property3 = ScriptableObject.getProperty(scriptable, 1);
                    if (property3 instanceof Function) {
                        property3 = ((Function) property3).call(context, this, scriptable, new Object[0]);
                    }
                    this.prompts[1] = Context.toString(property3);
                }
            }
        }
        return this.prompts;
    }

    public static Object doctest(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        if (objArr.length == 0) {
            return Boolean.FALSE;
        }
        String context2 = Context.toString(objArr[0]);
        Global global = getInstance(function);
        return new Integer(global.runDoctest(context, global, context2, null, 0));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:40:0x0165
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public int runDoctest(org.mozilla.javascript.Context r26, org.mozilla.javascript.Scriptable r27, java.lang.String r28, java.lang.String r29, int r30) {
        /*
            Method dump skipped, instructions count: 519
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.tools.shell.Global.runDoctest(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, java.lang.String, java.lang.String, int):int");
    }

    private boolean doctestOutputMatches(String str, String str2) {
        String trim = str.trim();
        String replace = str2.trim().replace("\r\n", "\n");
        if (trim.equals(replace)) {
            return true;
        }
        for (Map.Entry<String, String> entry : this.doctestCanonicalizations.entrySet()) {
            trim = trim.replace(entry.getKey(), entry.getValue());
        }
        if (trim.equals(replace)) {
            return true;
        }
        Pattern compile = Pattern.compile("@[0-9a-fA-F]+");
        Matcher matcher = compile.matcher(trim);
        Matcher matcher2 = compile.matcher(replace);
        while (matcher.find() && matcher2.find() && matcher2.start() == matcher.start()) {
            int start = matcher.start();
            if (!trim.substring(0, start).equals(replace.substring(0, start))) {
                return false;
            }
            String group = matcher.group();
            String group2 = matcher2.group();
            String str3 = this.doctestCanonicalizations.get(group);
            if (str3 == null) {
                this.doctestCanonicalizations.put(group, group2);
                trim = trim.replace(group, group2);
            } else if (!group2.equals(str3)) {
                return false;
            }
            if (trim.equals(replace)) {
                return true;
            }
        }
        return false;
    }

    public static Object spawn(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        Runner runner;
        Scriptable parentScope = function.getParentScope();
        if (objArr.length != 0 && (objArr[0] instanceof Function)) {
            Object[] objArr2 = null;
            if (objArr.length > 1 && (objArr[1] instanceof Scriptable)) {
                objArr2 = context.getElements((Scriptable) objArr[1]);
            }
            if (objArr2 == null) {
                objArr2 = ScriptRuntime.emptyArgs;
            }
            runner = new Runner(parentScope, (Function) objArr[0], objArr2);
        } else if (objArr.length != 0 && (objArr[0] instanceof Script)) {
            runner = new Runner(parentScope, (Script) objArr[0]);
        } else {
            throw reportRuntimeError("msg.spawn.args");
        }
        runner.factory = context.getFactory();
        Thread thread = new Thread(runner);
        thread.start();
        return thread;
    }

    public static Object sync(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        if (objArr.length >= 1 && objArr.length <= 2 && (objArr[0] instanceof Function)) {
            Object obj = null;
            if (objArr.length == 2 && objArr[1] != Undefined.instance) {
                obj = objArr[1];
            }
            return new Synchronizer((Function) objArr[0], obj);
        }
        throw reportRuntimeError("msg.sync.args");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d9  */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.io.OutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object runCommand(org.mozilla.javascript.Context r19, org.mozilla.javascript.Scriptable r20, java.lang.Object[] r21, org.mozilla.javascript.Function r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.tools.shell.Global.runCommand(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, java.lang.Object[], org.mozilla.javascript.Function):java.lang.Object");
    }

    public static void seal(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        for (int i = 0; i != objArr.length; i++) {
            Object obj = objArr[i];
            if (!(obj instanceof ScriptableObject) || obj == Undefined.instance) {
                if (!(obj instanceof Scriptable) || obj == Undefined.instance) {
                    throw reportRuntimeError("msg.shell.seal.not.object");
                }
                throw reportRuntimeError("msg.shell.seal.not.scriptable");
            }
        }
        for (int i2 = 0; i2 != objArr.length; i2++) {
            ((ScriptableObject) objArr[i2]).sealObject();
        }
    }

    public static Object readFile(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IOException {
        if (objArr.length == 0) {
            throw reportRuntimeError("msg.shell.readFile.bad.args");
        }
        return readUrl(ScriptRuntime.toString(objArr[0]), objArr.length >= 2 ? ScriptRuntime.toString(objArr[1]) : null, true);
    }

    public static Object readUrl(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IOException {
        if (objArr.length == 0) {
            throw reportRuntimeError("msg.shell.readUrl.bad.args");
        }
        return readUrl(ScriptRuntime.toString(objArr[0]), objArr.length >= 2 ? ScriptRuntime.toString(objArr[1]) : null, false);
    }

    public static Object toint32(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        Object obj = objArr.length != 0 ? objArr[0] : Undefined.instance;
        return obj instanceof Integer ? obj : ScriptRuntime.wrapInt(ScriptRuntime.toInt32(obj));
    }

    public InputStream getIn() {
        if (this.inStream == null && !this.attemptedJLineLoad) {
            InputStream stream = ShellLine.getStream(this);
            if (stream != null) {
                this.inStream = stream;
            }
            this.attemptedJLineLoad = true;
        }
        InputStream inputStream = this.inStream;
        return inputStream == null ? System.in : inputStream;
    }

    public void setIn(InputStream inputStream) {
        this.inStream = inputStream;
    }

    public PrintStream getOut() {
        PrintStream printStream = this.outStream;
        return printStream == null ? System.out : printStream;
    }

    public void setOut(PrintStream printStream) {
        this.outStream = printStream;
    }

    public PrintStream getErr() {
        PrintStream printStream = this.errStream;
        return printStream == null ? System.err : printStream;
    }

    public void setErr(PrintStream printStream) {
        this.errStream = printStream;
    }

    public void setSealedStdLib(boolean z) {
        this.sealedStdLib = z;
    }

    private static Global getInstance(Function function) {
        Scriptable parentScope = function.getParentScope();
        if (!(parentScope instanceof Global)) {
            throw reportRuntimeError("msg.bad.shell.function.scope", String.valueOf(parentScope));
        }
        return (Global) parentScope;
    }

    private static int runProcess(String[] strArr, String[] strArr2, InputStream inputStream, OutputStream outputStream, OutputStream outputStream2) throws IOException {
        Process exec;
        PipeThread pipeThread;
        PipeThread pipeThread2;
        if (strArr2 == null) {
            exec = Runtime.getRuntime().exec(strArr);
        } else {
            exec = Runtime.getRuntime().exec(strArr, strArr2);
        }
        PipeThread pipeThread3 = null;
        try {
            if (inputStream != null) {
                pipeThread = new PipeThread(false, inputStream, exec.getOutputStream());
                pipeThread.start();
            } else {
                exec.getOutputStream().close();
                pipeThread = null;
            }
            if (outputStream != null) {
                pipeThread2 = new PipeThread(true, exec.getInputStream(), outputStream);
                pipeThread2.start();
            } else {
                exec.getInputStream().close();
                pipeThread2 = null;
            }
            if (outputStream2 != null) {
                pipeThread3 = new PipeThread(true, exec.getErrorStream(), outputStream2);
                pipeThread3.start();
            } else {
                exec.getErrorStream().close();
            }
            while (true) {
                try {
                    exec.waitFor();
                    if (pipeThread2 != null) {
                        pipeThread2.join();
                    }
                    if (pipeThread != null) {
                        pipeThread.join();
                    }
                    if (pipeThread3 == null) {
                        break;
                    }
                    pipeThread3.join();
                    break;
                } catch (InterruptedException unused) {
                }
            }
            return exec.exitValue();
        } finally {
            exec.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void pipe(boolean z, InputStream inputStream, OutputStream outputStream) throws IOException {
        int read;
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                if (!z) {
                    read = inputStream.read(bArr, 0, 4096);
                } else {
                    read = inputStream.read(bArr, 0, 4096);
                }
                if (read >= 0) {
                    if (z) {
                        outputStream.write(bArr, 0, read);
                        outputStream.flush();
                    } else {
                        try {
                            outputStream.write(bArr, 0, read);
                            outputStream.flush();
                        } catch (IOException unused) {
                        }
                    }
                }
                try {
                    break;
                } catch (IOException unused2) {
                    return;
                }
            }
        } finally {
            try {
                if (z) {
                    inputStream.close();
                } else {
                    outputStream.close();
                }
            } catch (IOException unused3) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.io.InputStream toInputStream(java.lang.Object r4) throws java.io.IOException {
        /*
            boolean r0 = r4 instanceof org.mozilla.javascript.Wrapper
            r1 = 0
            if (r0 == 0) goto L40
            r0 = r4
            org.mozilla.javascript.Wrapper r0 = (org.mozilla.javascript.Wrapper) r0
            java.lang.Object r0 = r0.unwrap()
            boolean r2 = r0 instanceof java.io.InputStream
            if (r2 == 0) goto L16
            java.io.InputStream r0 = (java.io.InputStream) r0
            r3 = r1
            r1 = r0
            r0 = r3
            goto L41
        L16:
            boolean r2 = r0 instanceof byte[]
            if (r2 == 0) goto L26
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
            byte[] r0 = (byte[]) r0
            byte[] r0 = (byte[]) r0
            r2.<init>(r0)
            r0 = r1
            r1 = r2
            goto L41
        L26:
            boolean r2 = r0 instanceof java.io.Reader
            if (r2 == 0) goto L31
            java.io.Reader r0 = (java.io.Reader) r0
            java.lang.String r0 = readReader(r0)
            goto L41
        L31:
            boolean r2 = r0 instanceof char[]
            if (r2 == 0) goto L40
            java.lang.String r2 = new java.lang.String
            char[] r0 = (char[]) r0
            char[] r0 = (char[]) r0
            r2.<init>(r0)
            r0 = r2
            goto L41
        L40:
            r0 = r1
        L41:
            if (r1 != 0) goto L52
            if (r0 != 0) goto L49
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.toString(r4)
        L49:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            byte[] r4 = r0.getBytes()
            r1.<init>(r4)
        L52:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.tools.shell.Global.toInputStream(java.lang.Object):java.io.InputStream");
    }

    private static OutputStream toOutputStream(Object obj) {
        if (obj instanceof Wrapper) {
            Object unwrap = ((Wrapper) obj).unwrap();
            if (unwrap instanceof OutputStream) {
                return (OutputStream) unwrap;
            }
        }
        return null;
    }

    private static String readUrl(String str, String str2, boolean z) throws IOException {
        int i;
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        String contentType;
        InputStream inputStream2 = null;
        try {
            if (!z) {
                URLConnection openConnection = new URL(str).openConnection();
                inputStream = openConnection.getInputStream();
                i = openConnection.getContentLength();
                if (i <= 0) {
                    i = 1024;
                }
                if (str2 == null && (contentType = openConnection.getContentType()) != null) {
                    str2 = getCharCodingFromType(contentType);
                }
            } else {
                File file = new File(str);
                if (!file.exists()) {
                    throw new FileNotFoundException("File not found: " + str);
                } else if (!file.canRead()) {
                    throw new IOException("Cannot read file: " + str);
                } else {
                    long length = file.length();
                    int i2 = (int) length;
                    if (i2 != length) {
                        throw new IOException("Too big file size: " + length);
                    } else if (i2 == 0) {
                        return "";
                    } else {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        i = i2;
                        inputStream = fileInputStream;
                    }
                }
            }
            if (str2 == null) {
                inputStreamReader = new InputStreamReader(inputStream);
            } else {
                inputStreamReader = new InputStreamReader(inputStream, str2);
            }
            String readReader = readReader(inputStreamReader, i);
            if (inputStream != null) {
                inputStream.close();
            }
            return readReader;
        } catch (Throwable th) {
            if (0 != 0) {
                inputStream2.close();
            }
            throw th;
        }
    }

    private static String getCharCodingFromType(String str) {
        int indexOf = str.indexOf(59);
        if (indexOf >= 0) {
            int length = str.length();
            do {
                indexOf++;
                if (indexOf == length) {
                    break;
                }
            } while (str.charAt(indexOf) <= ' ');
            if ("charset".regionMatches(true, 0, str, indexOf, 7)) {
                int i = indexOf + 7;
                while (i != length && str.charAt(i) <= ' ') {
                    i++;
                }
                if (i == length || str.charAt(i) != '=') {
                    return null;
                }
                do {
                    i++;
                    if (i == length) {
                        break;
                    }
                } while (str.charAt(i) <= ' ');
                if (i != length) {
                    while (str.charAt(length - 1) <= ' ') {
                        length--;
                    }
                    return str.substring(i, length);
                }
                return null;
            }
            return null;
        }
        return null;
    }

    private static String readReader(Reader reader) throws IOException {
        return readReader(reader, 4096);
    }

    private static String readReader(Reader reader, int i) throws IOException {
        char[] cArr = new char[i];
        int i2 = 0;
        while (true) {
            int read = reader.read(cArr, i2, cArr.length - i2);
            if (read >= 0) {
                i2 += read;
                if (i2 == cArr.length) {
                    char[] cArr2 = new char[cArr.length * 2];
                    System.arraycopy(cArr, 0, cArr2, 0, i2);
                    cArr = cArr2;
                }
            } else {
                return new String(cArr, 0, i2);
            }
        }
    }

    static RuntimeException reportRuntimeError(String str) {
        return Context.reportRuntimeError(ToolErrorReporter.getMessage(str));
    }

    static RuntimeException reportRuntimeError(String str, String str2) {
        return Context.reportRuntimeError(ToolErrorReporter.getMessage(str, str2));
    }
}
