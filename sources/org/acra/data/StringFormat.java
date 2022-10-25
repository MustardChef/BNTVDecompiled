package org.acra.data;

import com.fasterxml.jackson.core.JsonFactory;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.acra.ReportField;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* compiled from: StringFormat.kt */
@Metadata(m108d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J6\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, m107d2 = {"Lorg/acra/data/StringFormat;", "", "matchingHttpContentType", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getMatchingHttpContentType", "()Ljava/lang/String;", "toFormattedString", "data", "Lorg/acra/data/CrashReportData;", "order", "", "Lorg/acra/ReportField;", "mainJoiner", "subJoiner", "urlEncode", "", JsonFactory.FORMAT_NAME_JSON, "KEY_VALUE_LIST", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public enum StringFormat {
    JSON { // from class: org.acra.data.StringFormat.JSON
        @Override // org.acra.data.StringFormat
        public String toFormattedString(CrashReportData data, List<? extends ReportField> order, String mainJoiner, String subJoiner, boolean z) throws JSONException {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(order, "order");
            Intrinsics.checkNotNullParameter(mainJoiner, "mainJoiner");
            Intrinsics.checkNotNullParameter(subJoiner, "subJoiner");
            Map mutableMap = MapsKt.toMutableMap(data.toMap());
            JSONStringer object = new JSONStringer().object();
            for (ReportField reportField : order) {
                object.key(reportField.toString()).value(mutableMap.remove(reportField.toString()));
            }
            for (Map.Entry entry : mutableMap.entrySet()) {
                object.key((String) entry.getKey()).value(entry.getValue());
            }
            String jSONStringer = object.endObject().toString();
            Intrinsics.checkNotNullExpressionValue(jSONStringer, "stringer.endObject().toString()");
            return jSONStringer;
        }
    },
    KEY_VALUE_LIST { // from class: org.acra.data.StringFormat.KEY_VALUE_LIST
        @Override // org.acra.data.StringFormat
        public String toFormattedString(CrashReportData data, List<? extends ReportField> order, String mainJoiner, String subJoiner, boolean z) throws UnsupportedEncodingException {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(order, "order");
            Intrinsics.checkNotNullParameter(mainJoiner, "mainJoiner");
            Intrinsics.checkNotNullParameter(subJoiner, "subJoiner");
            Map mutableMap = MapsKt.toMutableMap(toStringMap(data.toMap(), subJoiner));
            StringBuilder sb = new StringBuilder();
            for (ReportField reportField : order) {
                append(sb, reportField.toString(), (String) mutableMap.remove(reportField.toString()), mainJoiner, z);
            }
            for (Map.Entry entry : mutableMap.entrySet()) {
                append(sb, (String) entry.getKey(), (String) entry.getValue(), mainJoiner, z);
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
            return sb2;
        }

        private final void append(StringBuilder sb, String str, String str2, String str3, boolean z) throws UnsupportedEncodingException {
            if (sb.length() > 0) {
                sb.append(str3);
            }
            if (z) {
                str = str == null ? null : URLEncoder.encode(str, "UTF-8");
                str2 = str2 == null ? null : URLEncoder.encode(str2, "UTF-8");
            }
            sb.append(str);
            sb.append('=');
            sb.append(str2);
        }

        private final String valueToString(String str, Object obj) {
            if (obj instanceof JSONObject) {
                return CollectionsKt.joinToString$default(flatten((JSONObject) obj), str, null, null, 0, null, null, 62, null);
            }
            return String.valueOf(obj);
        }

        private final List<String> flatten(JSONObject jSONObject) {
            Object obj;
            ArrayList listOf;
            Iterator<String> keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "json.keys()");
            ArrayList arrayList = new ArrayList();
            for (String str : SequencesKt.toList(SequencesKt.asSequence(keys))) {
                try {
                    obj = jSONObject.get(str);
                } catch (JSONException unused) {
                    obj = null;
                }
                if (obj instanceof JSONObject) {
                    List<String> flatten = flatten((JSONObject) obj);
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(flatten, 10));
                    Iterator<T> it = flatten.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(((Object) str) + '.' + ((String) it.next()));
                    }
                    listOf = arrayList2;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append((Object) str);
                    sb.append('=');
                    sb.append(obj);
                    listOf = CollectionsKt.listOf(sb.toString());
                }
                CollectionsKt.addAll(arrayList, listOf);
            }
            return arrayList;
        }

        private final Map<String, String> toStringMap(Map<String, ? extends Object> map, String str) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), valueToString(str, entry.getValue()));
            }
            return MapsKt.toMap(linkedHashMap);
        }
    };
    
    private final String matchingHttpContentType;

    /* synthetic */ StringFormat(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public abstract String toFormattedString(CrashReportData crashReportData, List<? extends ReportField> list, String str, String str2, boolean z) throws Exception;

    StringFormat(String str) {
        this.matchingHttpContentType = str;
    }

    public final String getMatchingHttpContentType() {
        return this.matchingHttpContentType;
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static StringFormat[] valuesCustom() {
        StringFormat[] valuesCustom = values();
        return (StringFormat[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }
}
