package com.lagradost.cloudstream3.extractors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.firebase.messaging.Constants;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GuardareStream.kt */
@Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/GuardareStream;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "url", "referer", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "GuardareData", "GuardareJsonData", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public class GuardareStream extends ExtractorApi {
    private final boolean requiresReferer;
    private String name = "Guardare";
    private String mainUrl = "https://guardare.stream";

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

    /* compiled from: GuardareStream.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/GuardareStream$GuardareJsonData;", "", "data", "", "Lcom/lagradost/cloudstream3/extractors/GuardareStream$GuardareData;", "(Ljava/util/List;)V", "getData", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class GuardareJsonData {
        private final List<GuardareData> data;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GuardareJsonData copy$default(GuardareJsonData guardareJsonData, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = guardareJsonData.data;
            }
            return guardareJsonData.copy(list);
        }

        public final List<GuardareData> component1() {
            return this.data;
        }

        public final GuardareJsonData copy(@JsonProperty("data") List<GuardareData> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new GuardareJsonData(data);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GuardareJsonData) && Intrinsics.areEqual(this.data, ((GuardareJsonData) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "GuardareJsonData(data=" + this.data + ')';
        }

        public GuardareJsonData(@JsonProperty("data") List<GuardareData> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final List<GuardareData> getData() {
            return this.data;
        }
    }

    /* compiled from: GuardareStream.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/GuardareStream$GuardareData;", "", "file", "", Constants.ScionAnalytics.PARAM_LABEL, "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getLabel", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class GuardareData {
        private final String file;
        private final String label;
        private final String type;

        public static /* synthetic */ GuardareData copy$default(GuardareData guardareData, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = guardareData.file;
            }
            if ((i & 2) != 0) {
                str2 = guardareData.label;
            }
            if ((i & 4) != 0) {
                str3 = guardareData.type;
            }
            return guardareData.copy(str, str2, str3);
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

        public final GuardareData copy(@JsonProperty("file") String file, @JsonProperty("label") String label, @JsonProperty("type") String type) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(type, "type");
            return new GuardareData(file, label, type);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof GuardareData) {
                GuardareData guardareData = (GuardareData) obj;
                return Intrinsics.areEqual(this.file, guardareData.file) && Intrinsics.areEqual(this.label, guardareData.label) && Intrinsics.areEqual(this.type, guardareData.type);
            }
            return false;
        }

        public int hashCode() {
            return (((this.file.hashCode() * 31) + this.label.hashCode()) * 31) + this.type.hashCode();
        }

        public String toString() {
            return "GuardareData(file=" + this.file + ", label=" + this.label + ", type=" + this.type + ')';
        }

        public GuardareData(@JsonProperty("file") String file, @JsonProperty("label") String label, @JsonProperty("type") String type) {
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
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.lagradost.cloudstream3.extractors.GuardareStream r24, java.lang.String r25, java.lang.String r26, kotlin.coroutines.Continuation r27) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.extractors.GuardareStream.getUrl$suspendImpl(com.lagradost.cloudstream3.extractors.GuardareStream, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
