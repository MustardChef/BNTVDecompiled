package com.lagradost.cloudstream3.extractors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.firebase.messaging.Constants;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: Streamlare.kt */
@Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/Slmaxed;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "()V", "embedRegex", "Lkotlin/text/Regex;", "getEmbedRegex", "()Lkotlin/text/Regex;", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "name", "getName", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "url", "referer", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "JsonResponse", "Result", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public class Slmaxed extends ExtractorApi {
    private final String name = "Streamlare";
    private final String mainUrl = "https://slmaxed.com/";
    private final boolean requiresReferer = true;
    private final Regex embedRegex = new Regex("/e/([^/]*)");

    @Override // com.lagradost.cloudstream3.utils.ExtractorApi
    public Object getUrl(String str, String str2, Continuation<? super List<? extends ExtractorLink>> continuation) {
        return getUrl$suspendImpl(this, str, str2, (Continuation) continuation);
    }

    @Override // com.lagradost.cloudstream3.utils.ExtractorApi
    public String getName() {
        return this.name;
    }

    @Override // com.lagradost.cloudstream3.utils.ExtractorApi
    public String getMainUrl() {
        return this.mainUrl;
    }

    @Override // com.lagradost.cloudstream3.utils.ExtractorApi
    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    public final Regex getEmbedRegex() {
        return this.embedRegex;
    }

    /* compiled from: Streamlare.kt */
    @Metadata(m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0003\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JQ\u0010\u0017\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0016\b\u0003\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/Slmaxed$JsonResponse;", "", "status", "", "message", "type", "token", "result", "", "Lcom/lagradost/cloudstream3/extractors/Slmaxed$Result;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getMessage", "()Ljava/lang/String;", "getResult", "()Ljava/util/Map;", "getStatus", "getToken", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class JsonResponse {
        private final String message;
        private final Map<String, Result> result;
        private final String status;
        private final String token;
        private final String type;

        public JsonResponse() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ JsonResponse copy$default(JsonResponse jsonResponse, String str, String str2, String str3, String str4, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = jsonResponse.status;
            }
            if ((i & 2) != 0) {
                str2 = jsonResponse.message;
            }
            String str5 = str2;
            if ((i & 4) != 0) {
                str3 = jsonResponse.type;
            }
            String str6 = str3;
            if ((i & 8) != 0) {
                str4 = jsonResponse.token;
            }
            String str7 = str4;
            Map<String, Result> map2 = map;
            if ((i & 16) != 0) {
                map2 = jsonResponse.result;
            }
            return jsonResponse.copy(str, str5, str6, str7, map2);
        }

        public final String component1() {
            return this.status;
        }

        public final String component2() {
            return this.message;
        }

        public final String component3() {
            return this.type;
        }

        public final String component4() {
            return this.token;
        }

        public final Map<String, Result> component5() {
            return this.result;
        }

        public final JsonResponse copy(@JsonProperty String str, @JsonProperty String str2, @JsonProperty String str3, @JsonProperty String str4, @JsonProperty Map<String, Result> map) {
            return new JsonResponse(str, str2, str3, str4, map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof JsonResponse) {
                JsonResponse jsonResponse = (JsonResponse) obj;
                return Intrinsics.areEqual(this.status, jsonResponse.status) && Intrinsics.areEqual(this.message, jsonResponse.message) && Intrinsics.areEqual(this.type, jsonResponse.type) && Intrinsics.areEqual(this.token, jsonResponse.token) && Intrinsics.areEqual(this.result, jsonResponse.result);
            }
            return false;
        }

        public int hashCode() {
            String str = this.status;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.message;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.type;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.token;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Map<String, Result> map = this.result;
            return hashCode4 + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            return "JsonResponse(status=" + this.status + ", message=" + this.message + ", type=" + this.type + ", token=" + this.token + ", result=" + this.result + ')';
        }

        public JsonResponse(@JsonProperty String str, @JsonProperty String str2, @JsonProperty String str3, @JsonProperty String str4, @JsonProperty Map<String, Result> map) {
            this.status = str;
            this.message = str2;
            this.type = str3;
            this.token = str4;
            this.result = map;
        }

        public /* synthetic */ JsonResponse(String str, String str2, String str3, String str4, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : map);
        }

        public final String getStatus() {
            return this.status;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getType() {
            return this.type;
        }

        public final String getToken() {
            return this.token;
        }

        public final Map<String, Result> getResult() {
            return this.result;
        }
    }

    /* compiled from: Streamlare.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/Slmaxed$Result;", "", Constants.ScionAnalytics.PARAM_LABEL, "", "file", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getLabel", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Result {
        private final String file;
        private final String label;
        private final String type;

        public Result() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ Result copy$default(Result result, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = result.label;
            }
            if ((i & 2) != 0) {
                str2 = result.file;
            }
            if ((i & 4) != 0) {
                str3 = result.type;
            }
            return result.copy(str, str2, str3);
        }

        public final String component1() {
            return this.label;
        }

        public final String component2() {
            return this.file;
        }

        public final String component3() {
            return this.type;
        }

        public final Result copy(@JsonProperty String str, @JsonProperty String str2, @JsonProperty String str3) {
            return new Result(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Result) {
                Result result = (Result) obj;
                return Intrinsics.areEqual(this.label, result.label) && Intrinsics.areEqual(this.file, result.file) && Intrinsics.areEqual(this.type, result.type);
            }
            return false;
        }

        public int hashCode() {
            String str = this.label;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.file;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.type;
            return hashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "Result(label=" + this.label + ", file=" + this.file + ", type=" + this.type + ')';
        }

        public Result(@JsonProperty String str, @JsonProperty String str2, @JsonProperty String str3) {
            this.label = str;
            this.file = str2;
            this.type = str3;
        }

        public /* synthetic */ Result(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        public final String getLabel() {
            return this.label;
        }

        public final String getFile() {
            return this.file;
        }

        public final String getType() {
            return this.type;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0181  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.lagradost.cloudstream3.extractors.Slmaxed r26, java.lang.String r27, java.lang.String r28, kotlin.coroutines.Continuation r29) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.extractors.Slmaxed.getUrl$suspendImpl(com.lagradost.cloudstream3.extractors.Slmaxed, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
