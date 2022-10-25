package org.acra.data;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.acra.ACRA;
import org.acra.ACRAConstants;
import org.acra.ReportField;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CrashReportData.kt */
@Metadata(m108d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\u0004H\u0086\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\tJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0012J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0013J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0014J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\tJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0012J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0013J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0014J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0006\u0010\u0016\u001a\u00020\u0004J\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m107d2 = {"Lorg/acra/data/CrashReportData;", "", "()V", "json", "", "(Ljava/lang/String;)V", "content", "Lorg/json/JSONObject;", "containsKey", "", SDKConstants.PARAM_KEY, "Lorg/acra/ReportField;", "get", "getString", "put", "", "value", "", "", "", "Lorg/json/JSONArray;", "putNA", "toJSON", "toMap", "", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class CrashReportData {
    private final JSONObject content;

    public CrashReportData() {
        this.content = new JSONObject();
    }

    public CrashReportData(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        this.content = new JSONObject(json);
    }

    public final synchronized void put(String key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            this.content.put(key, z);
        } catch (JSONException unused) {
            ACRA.log.mo61w(ACRA.LOG_TAG, Intrinsics.stringPlus("Failed to put value into CrashReportData: ", Boolean.valueOf(z)));
        }
    }

    public final synchronized void put(String key, double d) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            this.content.put(key, d);
        } catch (JSONException unused) {
            ACRA.log.mo61w(ACRA.LOG_TAG, Intrinsics.stringPlus("Failed to put value into CrashReportData: ", Double.valueOf(d)));
        }
    }

    public final synchronized void put(String key, int i) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            this.content.put(key, i);
        } catch (JSONException unused) {
            ACRA.log.mo61w(ACRA.LOG_TAG, Intrinsics.stringPlus("Failed to put value into CrashReportData: ", Integer.valueOf(i)));
        }
    }

    public final synchronized void put(String key, long j) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            this.content.put(key, j);
        } catch (JSONException unused) {
            ACRA.log.mo61w(ACRA.LOG_TAG, Intrinsics.stringPlus("Failed to put value into CrashReportData: ", Long.valueOf(j)));
        }
    }

    public final synchronized void put(String key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (str == null) {
            putNA(key);
            return;
        }
        try {
            this.content.put(key, str);
        } catch (JSONException unused) {
            ACRA.log.mo61w(ACRA.LOG_TAG, Intrinsics.stringPlus("Failed to put value into CrashReportData: ", str));
        }
    }

    public final synchronized void put(String key, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (jSONObject == null) {
            putNA(key);
            return;
        }
        try {
            this.content.put(key, jSONObject);
        } catch (JSONException unused) {
            ACRA.log.mo61w(ACRA.LOG_TAG, Intrinsics.stringPlus("Failed to put value into CrashReportData: ", jSONObject));
        }
    }

    public final synchronized void put(String key, JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (jSONArray == null) {
            putNA(key);
            return;
        }
        try {
            this.content.put(key, jSONArray);
        } catch (JSONException unused) {
            ACRA.log.mo61w(ACRA.LOG_TAG, Intrinsics.stringPlus("Failed to put value into CrashReportData: ", jSONArray));
        }
    }

    public final synchronized void put(ReportField key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        put(key.toString(), z);
    }

    public final synchronized void put(ReportField key, double d) {
        Intrinsics.checkNotNullParameter(key, "key");
        put(key.toString(), d);
    }

    public final synchronized void put(ReportField key, int i) {
        Intrinsics.checkNotNullParameter(key, "key");
        put(key.toString(), i);
    }

    public final synchronized void put(ReportField key, long j) {
        Intrinsics.checkNotNullParameter(key, "key");
        put(key.toString(), j);
    }

    public final synchronized void put(ReportField key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        put(key.toString(), str);
    }

    public final synchronized void put(ReportField key, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(key, "key");
        put(key.toString(), jSONObject);
    }

    public final synchronized void put(ReportField key, JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(key, "key");
        put(key.toString(), jSONArray);
    }

    private final void putNA(String str) {
        try {
            this.content.put(str, ACRAConstants.NOT_AVAILABLE);
        } catch (JSONException unused) {
        }
    }

    public final String getString(ReportField key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.content.optString(key.toString());
    }

    public final Object get(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.content.opt(key);
    }

    public final boolean containsKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.content.has(key);
    }

    public final boolean containsKey(ReportField key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return containsKey(key.toString());
    }

    public final String toJSON() throws JSONException {
        try {
            return StringFormat.JSON.toFormattedString(this, CollectionsKt.emptyList(), "", "", false);
        } catch (JSONException e) {
            throw e;
        } catch (Exception e2) {
            throw new JSONException(e2.getMessage());
        }
    }

    public final Map<String, Object> toMap() {
        Iterator<String> keys = this.content.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "content.keys()");
        return MapsKt.toMap(SequencesKt.map(SequencesKt.asSequence(keys), new CrashReportData$toMap$1(this)));
    }
}
