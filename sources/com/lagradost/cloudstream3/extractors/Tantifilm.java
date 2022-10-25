package com.lagradost.cloudstream3.extractors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.firebase.messaging.Constants;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tantifilm.kt */
@Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/Tantifilm;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "url", "referer", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "TantifilmData", "TantifilmJsonData", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public class Tantifilm extends ExtractorApi {
    private final boolean requiresReferer;
    private String name = "Tantifilm";
    private String mainUrl = "https://cercafilm.net";

    @Override // com.lagradost.cloudstream3.utils.ExtractorApi
    public Object getUrl(String str, String str2, Continuation<? super List<? extends ExtractorLink>> continuation) {
        return getUrl$suspendImpl(this, str, str2, (Continuation) continuation);
    }

    @Override // com.lagradost.cloudstream3.utils.ExtractorApi
    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    @Override // com.lagradost.cloudstream3.utils.ExtractorApi
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mainUrl = str;
    }

    @Override // com.lagradost.cloudstream3.utils.ExtractorApi
    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* compiled from: Tantifilm.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J=\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0003\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\b\b\u0003\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\bHÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/Tantifilm$TantifilmJsonData;", "", "success", "", "data", "", "Lcom/lagradost/cloudstream3/extractors/Tantifilm$TantifilmData;", "captions", "", "is_vr", "(ZLjava/util/List;Ljava/util/List;Z)V", "getCaptions", "()Ljava/util/List;", "getData", "()Z", "getSuccess", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class TantifilmJsonData {
        private final List<String> captions;
        private final List<TantifilmData> data;
        private final boolean is_vr;
        private final boolean success;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TantifilmJsonData copy$default(TantifilmJsonData tantifilmJsonData, boolean z, List list, List list2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = tantifilmJsonData.success;
            }
            if ((i & 2) != 0) {
                list = tantifilmJsonData.data;
            }
            if ((i & 4) != 0) {
                list2 = tantifilmJsonData.captions;
            }
            if ((i & 8) != 0) {
                z2 = tantifilmJsonData.is_vr;
            }
            return tantifilmJsonData.copy(z, list, list2, z2);
        }

        public final boolean component1() {
            return this.success;
        }

        public final List<TantifilmData> component2() {
            return this.data;
        }

        public final List<String> component3() {
            return this.captions;
        }

        public final boolean component4() {
            return this.is_vr;
        }

        public final TantifilmJsonData copy(@JsonProperty("success") boolean z, @JsonProperty("data") List<TantifilmData> data, @JsonProperty("captions") List<String> captions, @JsonProperty("is_vr") boolean z2) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(captions, "captions");
            return new TantifilmJsonData(z, data, captions, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TantifilmJsonData) {
                TantifilmJsonData tantifilmJsonData = (TantifilmJsonData) obj;
                return this.success == tantifilmJsonData.success && Intrinsics.areEqual(this.data, tantifilmJsonData.data) && Intrinsics.areEqual(this.captions, tantifilmJsonData.captions) && this.is_vr == tantifilmJsonData.is_vr;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public int hashCode() {
            boolean z = this.success;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int hashCode = ((((r0 * 31) + this.data.hashCode()) * 31) + this.captions.hashCode()) * 31;
            boolean z2 = this.is_vr;
            return hashCode + (z2 ? 1 : z2 ? 1 : 0);
        }

        public String toString() {
            return "TantifilmJsonData(success=" + this.success + ", data=" + this.data + ", captions=" + this.captions + ", is_vr=" + this.is_vr + ')';
        }

        public TantifilmJsonData(@JsonProperty("success") boolean z, @JsonProperty("data") List<TantifilmData> data, @JsonProperty("captions") List<String> captions, @JsonProperty("is_vr") boolean z2) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(captions, "captions");
            this.success = z;
            this.data = data;
            this.captions = captions;
            this.is_vr = z2;
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final List<TantifilmData> getData() {
            return this.data;
        }

        public final List<String> getCaptions() {
            return this.captions;
        }

        public final boolean is_vr() {
            return this.is_vr;
        }
    }

    /* compiled from: Tantifilm.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/Tantifilm$TantifilmData;", "", "file", "", Constants.ScionAnalytics.PARAM_LABEL, "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getLabel", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class TantifilmData {
        private final String file;
        private final String label;
        private final String type;

        public static /* synthetic */ TantifilmData copy$default(TantifilmData tantifilmData, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tantifilmData.file;
            }
            if ((i & 2) != 0) {
                str2 = tantifilmData.label;
            }
            if ((i & 4) != 0) {
                str3 = tantifilmData.type;
            }
            return tantifilmData.copy(str, str2, str3);
        }

        public final String component1() {
            return this.file;
        }

        public final String component2() {
            return this.label;
        }

        public final String component3() {
            return this.type;
        }

        public final TantifilmData copy(@JsonProperty("file") String file, @JsonProperty("label") String label, @JsonProperty("type") String type) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(type, "type");
            return new TantifilmData(file, label, type);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TantifilmData) {
                TantifilmData tantifilmData = (TantifilmData) obj;
                return Intrinsics.areEqual(this.file, tantifilmData.file) && Intrinsics.areEqual(this.label, tantifilmData.label) && Intrinsics.areEqual(this.type, tantifilmData.type);
            }
            return false;
        }

        public int hashCode() {
            return (((this.file.hashCode() * 31) + this.label.hashCode()) * 31) + this.type.hashCode();
        }

        public String toString() {
            return "TantifilmData(file=" + this.file + ", label=" + this.label + ", type=" + this.type + ')';
        }

        public TantifilmData(@JsonProperty("file") String file, @JsonProperty("label") String label, @JsonProperty("type") String type) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(type, "type");
            this.file = file;
            this.label = label;
            this.type = type;
        }

        public final String getFile() {
            return this.file;
        }

        public final String getLabel() {
            return this.label;
        }

        public final String getType() {
            return this.type;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.lagradost.cloudstream3.extractors.Tantifilm r24, java.lang.String r25, java.lang.String r26, kotlin.coroutines.Continuation r27) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.extractors.Tantifilm.getUrl$suspendImpl(com.lagradost.cloudstream3.extractors.Tantifilm, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
