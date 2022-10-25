package com.lagradost.cloudstream3.extractors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.firebase.messaging.Constants;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoeExtractor.kt */
@Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/VoeExtractor;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "name", "getName", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "url", "referer", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ResponseLinks", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public class VoeExtractor extends ExtractorApi {
    private final boolean requiresReferer;
    private final String name = "Voe";
    private final String mainUrl = "https://voe.sx";

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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VoeExtractor.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/VoeExtractor$ResponseLinks;", "", "url", "", Constants.ScionAnalytics.PARAM_LABEL, "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getLabel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/extractors/VoeExtractor$ResponseLinks;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class ResponseLinks {
        private final Integer label;
        private final String url;

        public static /* synthetic */ ResponseLinks copy$default(ResponseLinks responseLinks, String str, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = responseLinks.url;
            }
            if ((i & 2) != 0) {
                num = responseLinks.label;
            }
            return responseLinks.copy(str, num);
        }

        public final String component1() {
            return this.url;
        }

        public final Integer component2() {
            return this.label;
        }

        public final ResponseLinks copy(@JsonProperty("hls") String str, @JsonProperty("video_height") Integer num) {
            return new ResponseLinks(str, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ResponseLinks) {
                ResponseLinks responseLinks = (ResponseLinks) obj;
                return Intrinsics.areEqual(this.url, responseLinks.url) && Intrinsics.areEqual(this.label, responseLinks.label);
            }
            return false;
        }

        public int hashCode() {
            String str = this.url;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.label;
            return hashCode + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            return "ResponseLinks(url=" + this.url + ", label=" + this.label + ')';
        }

        public ResponseLinks(@JsonProperty("hls") String str, @JsonProperty("video_height") Integer num) {
            this.url = str;
            this.label = num;
        }

        public final String getUrl() {
            return this.url;
        }

        public final Integer getLabel() {
            return this.label;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009e  */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.lagradost.cloudstream3.extractors.VoeExtractor r22, java.lang.String r23, java.lang.String r24, kotlin.coroutines.Continuation r25) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.extractors.VoeExtractor.getUrl$suspendImpl(com.lagradost.cloudstream3.extractors.VoeExtractor, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
