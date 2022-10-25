package com.lagradost.cloudstream3.extractors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Linkbox.kt */
@Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0013\u0014\u0015B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/Linkbox;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "name", "getName", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "url", "referer", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Data", "RList", "Responses", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class Linkbox extends ExtractorApi {
    private final String name = "Linkbox";
    private final String mainUrl = "https://www.linkbox.to";
    private final boolean requiresReferer = true;

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

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(9:5|6|(1:(1:9)(2:30|31))(2:32|(1:34)(1:35))|10|11|12|13|(4:19|(2:22|20)|23|24)|25))|36|6|(0)(0)|10|11|12|13|(6:15|17|19|(1:20)|23|24)|25) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00d7, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00d8, code lost:
        r0.printStackTrace();
        r13 = r23;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0107 A[LOOP:0: B:30:0x0101->B:32:0x0107, LOOP_END] */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.util.List] */
    @Override // com.lagradost.cloudstream3.utils.ExtractorApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getUrl(java.lang.String r28, java.lang.String r29, kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.utils.ExtractorLink>> r30) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.extractors.Linkbox.getUrl(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: Linkbox.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/Linkbox$RList;", "", "url", "", "resolution", "(Ljava/lang/String;Ljava/lang/String;)V", "getResolution", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class RList {
        private final String resolution;
        private final String url;

        public static /* synthetic */ RList copy$default(RList rList, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = rList.url;
            }
            if ((i & 2) != 0) {
                str2 = rList.resolution;
            }
            return rList.copy(str, str2);
        }

        public final String component1() {
            return this.url;
        }

        public final String component2() {
            return this.resolution;
        }

        public final RList copy(@JsonProperty("url") String url, @JsonProperty("resolution") String str) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new RList(url, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RList) {
                RList rList = (RList) obj;
                return Intrinsics.areEqual(this.url, rList.url) && Intrinsics.areEqual(this.resolution, rList.resolution);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.url.hashCode() * 31;
            String str = this.resolution;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "RList(url=" + this.url + ", resolution=" + this.resolution + ')';
        }

        public RList(@JsonProperty("url") String url, @JsonProperty("resolution") String str) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
            this.resolution = str;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getResolution() {
            return this.resolution;
        }
    }

    /* compiled from: Linkbox.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0001\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/Linkbox$Data;", "", "rList", "", "Lcom/lagradost/cloudstream3/extractors/Linkbox$RList;", "(Ljava/util/List;)V", "getRList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Data {
        private final List<RList> rList;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Data copy$default(Data data, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = data.rList;
            }
            return data.copy(list);
        }

        public final List<RList> component1() {
            return this.rList;
        }

        public final Data copy(@JsonProperty("rList") List<RList> list) {
            return new Data(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Data) && Intrinsics.areEqual(this.rList, ((Data) obj).rList);
        }

        public int hashCode() {
            List<RList> list = this.rList;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        public String toString() {
            return "Data(rList=" + this.rList + ')';
        }

        public Data(@JsonProperty("rList") List<RList> list) {
            this.rList = list;
        }

        public final List<RList> getRList() {
            return this.rList;
        }
    }

    /* compiled from: Linkbox.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/Linkbox$Responses;", "", "data", "Lcom/lagradost/cloudstream3/extractors/Linkbox$Data;", "(Lcom/lagradost/cloudstream3/extractors/Linkbox$Data;)V", "getData", "()Lcom/lagradost/cloudstream3/extractors/Linkbox$Data;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Responses {
        private final Data data;

        public static /* synthetic */ Responses copy$default(Responses responses, Data data, int i, Object obj) {
            if ((i & 1) != 0) {
                data = responses.data;
            }
            return responses.copy(data);
        }

        public final Data component1() {
            return this.data;
        }

        public final Responses copy(@JsonProperty("data") Data data) {
            return new Responses(data);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Responses) && Intrinsics.areEqual(this.data, ((Responses) obj).data);
        }

        public int hashCode() {
            Data data = this.data;
            if (data == null) {
                return 0;
            }
            return data.hashCode();
        }

        public String toString() {
            return "Responses(data=" + this.data + ')';
        }

        public Responses(@JsonProperty("data") Data data) {
            this.data = data;
        }

        public final Data getData() {
            return this.data;
        }
    }
}
