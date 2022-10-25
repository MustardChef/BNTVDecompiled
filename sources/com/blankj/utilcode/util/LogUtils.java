package com.blankj.utilcode.util;

import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class LogUtils {

    /* renamed from: A */
    public static final int f2717A = 32;
    private static final String ARGS = "args";
    private static final String BOTTOM_BORDER = "╚═══════════════════════════════════════════════════════════════════════════════════════════════════";

    /* renamed from: D */
    public static final int f2718D = 2;

    /* renamed from: E */
    public static final int f2719E = 16;
    private static final int FILE = 241;

    /* renamed from: I */
    public static final int f2720I = 4;
    private static final int JSON = 242;
    private static final String LEFT_BORDER = "║ ";
    private static final int MAX_LEN = 4000;
    private static final String NULL = "null";
    private static final String NULL_TIPS = "Log with null object.";
    private static final String TOP_BORDER = "╔═══════════════════════════════════════════════════════════════════════════════════════════════════";

    /* renamed from: V */
    public static final int f2721V = 1;

    /* renamed from: W */
    public static final int f2722W = 8;
    private static final int XML = 244;
    private static String defaultDir = null;
    private static String dir = null;
    private static ExecutorService executor = null;
    private static String sGlobalTag = null;
    private static boolean sLog2FileSwitch = false;
    private static boolean sLogBorderSwitch = true;
    private static int sLogFilter = 1;
    private static boolean sLogHeadSwitch = true;
    private static boolean sLogSwitch = true;
    private static boolean sTagIsSpace = true;
    private static final String FILE_SEP = System.getProperty("file.separator");
    private static final String LINE_SEP = System.getProperty("line.separator");
    private static final Format FORMAT = new SimpleDateFormat("MM-dd HH:mm:ss.SSS ", Locale.getDefault());

    /* loaded from: classes.dex */
    public static class Builder {
        public Builder() {
            StringBuilder sb;
            File cacheDir;
            if (LogUtils.defaultDir != null) {
                return;
            }
            if (!"mounted".equals(Environment.getExternalStorageState()) || Utils.getContext().getExternalCacheDir() == null) {
                sb = new StringBuilder();
                cacheDir = Utils.getContext().getCacheDir();
            } else {
                sb = new StringBuilder();
                cacheDir = Utils.getContext().getExternalCacheDir();
            }
            sb.append(cacheDir);
            sb.append(LogUtils.FILE_SEP);
            sb.append("log");
            sb.append(LogUtils.FILE_SEP);
            String unused = LogUtils.defaultDir = sb.toString();
        }

        public Builder setBorderSwitch(boolean z) {
            boolean unused = LogUtils.sLogBorderSwitch = z;
            return this;
        }

        public Builder setDir(File file) {
            String str;
            if (file == null) {
                str = null;
            } else {
                str = file.getAbsolutePath() + LogUtils.FILE_SEP;
            }
            String unused = LogUtils.dir = str;
            return this;
        }

        public Builder setDir(String str) {
            if (LogUtils.isSpace(str)) {
                str = null;
            } else if (!str.endsWith(LogUtils.FILE_SEP)) {
                str = str + LogUtils.FILE_SEP;
            }
            String unused = LogUtils.dir = str;
            return this;
        }

        public Builder setGlobalTag(String str) {
            boolean z;
            if (LogUtils.isSpace(str)) {
                String unused = LogUtils.sGlobalTag = "";
                z = true;
            } else {
                String unused2 = LogUtils.sGlobalTag = str;
                z = false;
            }
            boolean unused3 = LogUtils.sTagIsSpace = z;
            return this;
        }

        public Builder setLog2FileSwitch(boolean z) {
            boolean unused = LogUtils.sLog2FileSwitch = z;
            return this;
        }

        public Builder setLogFilter(int i) {
            int unused = LogUtils.sLogFilter = i;
            return this;
        }

        public Builder setLogHeadSwitch(boolean z) {
            boolean unused = LogUtils.sLogHeadSwitch = z;
            return this;
        }

        public Builder setLogSwitch(boolean z) {
            boolean unused = LogUtils.sLogSwitch = z;
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("switch: ");
            sb.append(LogUtils.sLogSwitch);
            sb.append(LogUtils.LINE_SEP);
            sb.append("tag: ");
            sb.append(LogUtils.sGlobalTag.equals("") ? LogUtils.NULL : LogUtils.sGlobalTag);
            sb.append(LogUtils.LINE_SEP);
            sb.append("head: ");
            sb.append(LogUtils.sLogHeadSwitch);
            sb.append(LogUtils.LINE_SEP);
            sb.append("file: ");
            sb.append(LogUtils.sLog2FileSwitch);
            sb.append(LogUtils.LINE_SEP);
            sb.append("dir: ");
            sb.append(LogUtils.dir == null ? LogUtils.defaultDir : LogUtils.dir);
            sb.append(LogUtils.LINE_SEP);
            sb.append("border: ");
            sb.append(LogUtils.sLogBorderSwitch);
            sb.append(LogUtils.LINE_SEP);
            sb.append("filter: ");
            sb.append(LogUtils.sLogFilter == 1 ? "verbose" : "not verbose");
            return sb.toString();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    private @interface TYPE {
    }

    private LogUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /* renamed from: a */
    public static void m6083a(Object obj) {
        log(32, sGlobalTag, obj);
    }

    /* renamed from: a */
    public static void m6082a(String str, Object... objArr) {
        log(32, str, objArr);
    }

    private static boolean createOrExistsDir(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    private static boolean createOrExistsFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile();
        }
        if (createOrExistsDir(file.getParentFile())) {
            try {
                return file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    /* renamed from: d */
    public static void m6081d(Object obj) {
        log(2, sGlobalTag, obj);
    }

    /* renamed from: d */
    public static void m6080d(String str, Object... objArr) {
        log(2, str, objArr);
    }

    /* renamed from: e */
    public static void m6079e(Object obj) {
        log(16, sGlobalTag, obj);
    }

    /* renamed from: e */
    public static void m6078e(String str, Object... objArr) {
        log(16, str, objArr);
    }

    public static void file(Object obj) {
        log(241, sGlobalTag, obj);
    }

    public static void file(String str, Object obj) {
        log(241, str, obj);
    }

    private static String formatJson(String str) {
        try {
            if (str.startsWith("{")) {
                str = new JSONObject(str).toString(4);
            } else if (str.startsWith("[")) {
                str = new JSONArray(str).toString(4);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return str;
    }

    private static String formatXml(String str) {
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            newTransformer.transform(streamSource, streamResult);
            String obj = streamResult.getWriter().toString();
            return obj.replaceFirst(">", ">" + LINE_SEP);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    /* renamed from: i */
    public static void m6077i(Object obj) {
        log(4, sGlobalTag, obj);
    }

    /* renamed from: i */
    public static void m6076i(String str, Object... objArr) {
        log(4, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void json(String str) {
        log(242, sGlobalTag, str);
    }

    public static void json(String str, String str2) {
        log(242, str, str2);
    }

    private static void log(int i, String str, Object... objArr) {
        if (sLogSwitch) {
            String[] processContents = processContents(i, str, objArr);
            String str2 = processContents[0];
            String str3 = processContents[1];
            if (i != 1 && i != 2 && i != 4 && i != 8 && i != 16 && i != 32) {
                if (i != 244) {
                    if (i != 241) {
                        if (i != 242) {
                            return;
                        }
                    }
                }
                printLog(2, str2, str3);
                return;
            } else if (i < sLogFilter) {
                return;
            } else {
                printLog(i, str2, str3);
                if (!sLog2FileSwitch) {
                    return;
                }
            }
            print2File(str2, str3);
        }
    }

    private static void print(int i, String str, String str2) {
        if (i == 1) {
            Log.v(str, str2);
        } else if (i == 2) {
            Log.d(str, str2);
        } else if (i == 4) {
            Log.i(str, str2);
        } else if (i == 8) {
            Log.w(str, str2);
        } else if (i == 16) {
            Log.e(str, str2);
        } else if (i != 32) {
        } else {
            Log.wtf(str, str2);
        }
    }

    private static void print2File(final String str, String str2) {
        String format = FORMAT.format(new Date(System.currentTimeMillis()));
        String substring = format.substring(0, 5);
        String substring2 = format.substring(6);
        StringBuilder sb = new StringBuilder();
        String str3 = dir;
        if (str3 == null) {
            str3 = defaultDir;
        }
        sb.append(str3);
        sb.append(substring);
        sb.append(".txt");
        final String sb2 = sb.toString();
        if (!createOrExistsFile(sb2)) {
            Log.e(str, "log to " + sb2 + " failed!");
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        if (sLogBorderSwitch) {
            sb3.append(TOP_BORDER);
            String str4 = LINE_SEP;
            sb3.append(str4);
            sb3.append(LEFT_BORDER);
            sb3.append(substring2);
            sb3.append(str);
            sb3.append(str4);
            sb3.append(str2);
            sb3.append(BOTTOM_BORDER);
            sb3.append(str4);
        } else {
            sb3.append(substring2);
            sb3.append(str);
            String str5 = LINE_SEP;
            sb3.append(str5);
            sb3.append(str2);
            sb3.append(str5);
        }
        sb3.append(LINE_SEP);
        final String sb4 = sb3.toString();
        if (executor == null) {
            executor = Executors.newSingleThreadExecutor();
        }
        executor.execute(new Runnable() { // from class: com.blankj.utilcode.util.LogUtils.1
            /* JADX WARN: Removed duplicated region for block: B:35:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r7 = this;
                    java.lang.String r0 = "log to "
                    r1 = 0
                    java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
                    java.io.FileWriter r3 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
                    java.lang.String r4 = r1     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
                    r5 = 1
                    r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
                    r2.<init>(r3)     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
                    java.lang.String r1 = r2     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L65
                    r2.write(r1)     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L65
                    java.lang.String r1 = r3     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L65
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L65
                    r3.<init>()     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L65
                    r3.append(r0)     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L65
                    java.lang.String r4 = r1     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L65
                    r3.append(r4)     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L65
                    java.lang.String r4 = " success!"
                    r3.append(r4)     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L65
                    java.lang.String r3 = r3.toString()     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L65
                    android.util.Log.d(r1, r3)     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L65
                    r2.close()     // Catch: java.io.IOException -> L60
                    goto L64
                L34:
                    r1 = move-exception
                    goto L3c
                L36:
                    r0 = move-exception
                    goto L67
                L38:
                    r2 = move-exception
                    r6 = r2
                    r2 = r1
                    r1 = r6
                L3c:
                    r1.printStackTrace()     // Catch: java.lang.Throwable -> L65
                    java.lang.String r1 = r3     // Catch: java.lang.Throwable -> L65
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L65
                    r3.<init>()     // Catch: java.lang.Throwable -> L65
                    r3.append(r0)     // Catch: java.lang.Throwable -> L65
                    java.lang.String r0 = r1     // Catch: java.lang.Throwable -> L65
                    r3.append(r0)     // Catch: java.lang.Throwable -> L65
                    java.lang.String r0 = " failed!"
                    r3.append(r0)     // Catch: java.lang.Throwable -> L65
                    java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L65
                    android.util.Log.e(r1, r0)     // Catch: java.lang.Throwable -> L65
                    if (r2 == 0) goto L64
                    r2.close()     // Catch: java.io.IOException -> L60
                    goto L64
                L60:
                    r0 = move-exception
                    r0.printStackTrace()
                L64:
                    return
                L65:
                    r0 = move-exception
                    r1 = r2
                L67:
                    if (r1 == 0) goto L71
                    r1.close()     // Catch: java.io.IOException -> L6d
                    goto L71
                L6d:
                    r1 = move-exception
                    r1.printStackTrace()
                L71:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.LogUtils.RunnableC18111.run():void");
            }
        });
    }

    private static void printLog(int i, String str, String str2) {
        if (sLogBorderSwitch) {
            print(i, str, TOP_BORDER);
        }
        int length = str2.length();
        int i2 = length / MAX_LEN;
        if (i2 > 0) {
            int i3 = MAX_LEN;
            print(i, str, str2.substring(0, MAX_LEN));
            int i4 = 1;
            while (i4 < i2) {
                int i5 = i3 + MAX_LEN;
                String substring = str2.substring(i3, i5);
                if (sLogBorderSwitch) {
                    substring = LEFT_BORDER + substring;
                }
                print(i, str, substring);
                i4++;
                i3 = i5;
            }
            str2 = str2.substring(i3, length);
            if (sLogBorderSwitch) {
                str2 = LEFT_BORDER + str2;
            }
        }
        print(i, str, str2);
        if (sLogBorderSwitch) {
            print(i, str, BOTTOM_BORDER);
        }
    }

    private static String[] processContents(int i, String str, Object... objArr) {
        String str2;
        String[] split;
        String str3 = "";
        if (sTagIsSpace || sLogHeadSwitch) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[5];
            String className = stackTraceElement.getClassName();
            String[] split2 = className.split("\\.");
            if (split2.length > 0) {
                className = split2[split2.length - 1];
            }
            if (className.contains("$")) {
                className = className.split("\\$")[0];
            }
            if (sTagIsSpace && isSpace(str)) {
                str = className;
            }
            if (sLogHeadSwitch) {
                str3 = new Formatter().format("Thread: %s, %s(%s.java:%d)" + LINE_SEP, Thread.currentThread().getName(), stackTraceElement.getMethodName(), className, Integer.valueOf(stackTraceElement.getLineNumber())).toString();
            }
        } else {
            str = sGlobalTag;
        }
        if (objArr != null) {
            int length = objArr.length;
            str2 = NULL;
            if (length == 1) {
                Object obj = objArr[0];
                if (obj != null) {
                    str2 = obj.toString();
                }
                if (i == 242) {
                    str2 = formatJson(str2);
                } else if (i == 244) {
                    str2 = formatXml(str2);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                int length2 = objArr.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    Object obj2 = objArr[i2];
                    sb.append(ARGS);
                    sb.append("[");
                    sb.append(i2);
                    sb.append("]");
                    sb.append(" = ");
                    sb.append(obj2 == null ? NULL : obj2.toString());
                    sb.append(LINE_SEP);
                }
                str2 = sb.toString();
            }
        } else {
            str2 = NULL_TIPS;
        }
        String str4 = str3 + str2;
        if (sLogBorderSwitch) {
            StringBuilder sb2 = new StringBuilder();
            for (String str5 : str4.split(LINE_SEP)) {
                sb2.append(LEFT_BORDER);
                sb2.append(str5);
                sb2.append(LINE_SEP);
            }
            str4 = sb2.toString();
        }
        return new String[]{str, str4};
    }

    /* renamed from: v */
    public static void m6075v(Object obj) {
        log(1, sGlobalTag, obj);
    }

    /* renamed from: v */
    public static void m6074v(String str, Object... objArr) {
        log(1, str, objArr);
    }

    /* renamed from: w */
    public static void m6073w(Object obj) {
        log(8, sGlobalTag, obj);
    }

    /* renamed from: w */
    public static void m6072w(String str, Object... objArr) {
        log(8, str, objArr);
    }

    public static void xml(String str) {
        log(244, sGlobalTag, str);
    }

    public static void xml(String str, String str2) {
        log(244, str, str2);
    }
}
