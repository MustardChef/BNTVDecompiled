package com.facebook.internal.instrument;

import android.os.Build;
import com.facebook.internal.Utility;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class InstrumentData {
    private static final String PARAM_APP_VERSION = "app_version";
    private static final String PARAM_CALLSTACK = "callstack";
    private static final String PARAM_DEVICE_MODEL = "device_model";
    private static final String PARAM_DEVICE_OS = "device_os_version";
    private static final String PARAM_FEATURE_NAMES = "feature_names";
    private static final String PARAM_REASON = "reason";
    private static final String PARAM_TIMESTAMP = "timestamp";
    private static final String PARAM_TYPE = "type";
    private static final String UNKNOWN = "Unknown";
    private String appVersion;
    private String cause;
    private JSONArray featureNames;
    private String filename;
    private String stackTrace;
    private Long timestamp;
    private Type type;

    /* synthetic */ InstrumentData(File file, C20961 c20961) {
        this(file);
    }

    /* synthetic */ InstrumentData(Throwable th, Type type, C20961 c20961) {
        this(th, type);
    }

    /* synthetic */ InstrumentData(JSONArray jSONArray, C20961 c20961) {
        this(jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.facebook.internal.instrument.InstrumentData$1 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C20961 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$internal$instrument$InstrumentData$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$com$facebook$internal$instrument$InstrumentData$Type = iArr;
            try {
                iArr[Type.Analysis.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$internal$instrument$InstrumentData$Type[Type.CrashReport.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$internal$instrument$InstrumentData$Type[Type.CrashShield.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$internal$instrument$InstrumentData$Type[Type.ThreadCheck.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum Type {
        Unknown,
        Analysis,
        CrashReport,
        CrashShield,
        ThreadCheck;

        @Override // java.lang.Enum
        public String toString() {
            int i = C20961.$SwitchMap$com$facebook$internal$instrument$InstrumentData$Type[ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "Unknown" : "ThreadCheck" : "CrashShield" : "CrashReport" : "Analysis";
        }

        public String getLogPrefix() {
            int i = C20961.$SwitchMap$com$facebook$internal$instrument$InstrumentData$Type[ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "Unknown" : InstrumentUtility.THREAD_CHECK_PREFIX : InstrumentUtility.CRASH_SHIELD_PREFIX : InstrumentUtility.CRASH_REPORT_PREFIX : InstrumentUtility.ANALYSIS_REPORT_PREFIX;
        }
    }

    private InstrumentData(JSONArray jSONArray) {
        this.type = Type.Analysis;
        this.timestamp = Long.valueOf(System.currentTimeMillis() / 1000);
        this.featureNames = jSONArray;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(InstrumentUtility.ANALYSIS_REPORT_PREFIX);
        stringBuffer.append(this.timestamp.toString());
        stringBuffer.append(".json");
        this.filename = stringBuffer.toString();
    }

    private InstrumentData(Throwable th, Type type) {
        this.type = type;
        this.appVersion = Utility.getAppVersion();
        this.cause = InstrumentUtility.getCause(th);
        this.stackTrace = InstrumentUtility.getStackTrace(th);
        this.timestamp = Long.valueOf(System.currentTimeMillis() / 1000);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(type.getLogPrefix());
        stringBuffer.append(this.timestamp.toString());
        stringBuffer.append(".json");
        this.filename = stringBuffer.toString();
    }

    private InstrumentData(File file) {
        String name = file.getName();
        this.filename = name;
        this.type = getType(name);
        JSONObject readFile = InstrumentUtility.readFile(this.filename, true);
        if (readFile != null) {
            this.timestamp = Long.valueOf(readFile.optLong(PARAM_TIMESTAMP, 0L));
            this.appVersion = readFile.optString(PARAM_APP_VERSION, null);
            this.cause = readFile.optString(PARAM_REASON, null);
            this.stackTrace = readFile.optString(PARAM_CALLSTACK, null);
            this.featureNames = readFile.optJSONArray(PARAM_FEATURE_NAMES);
        }
    }

    private static Type getType(String str) {
        if (str.startsWith(InstrumentUtility.CRASH_REPORT_PREFIX)) {
            return Type.CrashReport;
        }
        if (str.startsWith(InstrumentUtility.CRASH_SHIELD_PREFIX)) {
            return Type.CrashShield;
        }
        if (str.startsWith(InstrumentUtility.THREAD_CHECK_PREFIX)) {
            return Type.ThreadCheck;
        }
        if (str.startsWith(InstrumentUtility.ANALYSIS_REPORT_PREFIX)) {
            return Type.Analysis;
        }
        return Type.Unknown;
    }

    public int compareTo(InstrumentData instrumentData) {
        Long l = this.timestamp;
        if (l == null) {
            return -1;
        }
        Long l2 = instrumentData.timestamp;
        if (l2 == null) {
            return 1;
        }
        return l2.compareTo(l);
    }

    public boolean isValid() {
        int i = C20961.$SwitchMap$com$facebook$internal$instrument$InstrumentData$Type[this.type.ordinal()];
        return i != 1 ? ((i != 2 && i != 3 && i != 4) || this.stackTrace == null || this.timestamp == null) ? false : true : (this.featureNames == null || this.timestamp == null) ? false : true;
    }

    public void save() {
        if (isValid()) {
            InstrumentUtility.writeFile(this.filename, toString());
        }
    }

    public void clear() {
        InstrumentUtility.deleteFile(this.filename);
    }

    public String toString() {
        JSONObject parameters = getParameters();
        if (parameters == null) {
            return null;
        }
        return parameters.toString();
    }

    private JSONObject getParameters() {
        int i = C20961.$SwitchMap$com$facebook$internal$instrument$InstrumentData$Type[this.type.ordinal()];
        if (i != 1) {
            if (i == 2 || i == 3 || i == 4) {
                return getExceptionReportParameters();
            }
            return null;
        }
        return getAnalysisReportParameters();
    }

    private JSONObject getAnalysisReportParameters() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = this.featureNames;
            if (jSONArray != null) {
                jSONObject.put(PARAM_FEATURE_NAMES, jSONArray);
            }
            Long l = this.timestamp;
            if (l != null) {
                jSONObject.put(PARAM_TIMESTAMP, l);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private JSONObject getExceptionReportParameters() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_os_version", Build.VERSION.RELEASE);
            jSONObject.put("device_model", Build.MODEL);
            String str = this.appVersion;
            if (str != null) {
                jSONObject.put(PARAM_APP_VERSION, str);
            }
            Long l = this.timestamp;
            if (l != null) {
                jSONObject.put(PARAM_TIMESTAMP, l);
            }
            String str2 = this.cause;
            if (str2 != null) {
                jSONObject.put(PARAM_REASON, str2);
            }
            String str3 = this.stackTrace;
            if (str3 != null) {
                jSONObject.put(PARAM_CALLSTACK, str3);
            }
            Type type = this.type;
            if (type != null) {
                jSONObject.put("type", type);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class Builder {
        public static InstrumentData load(File file) {
            return new InstrumentData(file, (C20961) null);
        }

        public static InstrumentData build(Throwable th, Type type) {
            return new InstrumentData(th, type, null);
        }

        public static InstrumentData build(JSONArray jSONArray) {
            return new InstrumentData(jSONArray, (C20961) null);
        }
    }
}
