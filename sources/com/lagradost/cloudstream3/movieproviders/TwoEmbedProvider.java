package com.lagradost.cloudstream3.movieproviders;

import android.util.Log;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.metaproviders.TmdbProvider;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TwoEmbedProvider.kt */
@Metadata(m108d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJI\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\b2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001a0!2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u001a0!H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010%R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TwoEmbedProvider;", "Lcom/lagradost/cloudstream3/metaproviders/TmdbProvider;", "()V", "apiName", "", "getApiName", "()Ljava/lang/String;", "instantLinkLoading", "", "getInstantLinkLoading", "()Z", "mainUrl", "getMainUrl", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "useMetaLoadResponse", "getUseMetaLoadResponse", "extractorVerifierJob", "", "extractorData", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "EmbedJson", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class TwoEmbedProvider extends TmdbProvider {
    private final boolean instantLinkLoading;
    private final String apiName = "2Embed";
    private String name = "2Embed";
    private String mainUrl = "https://www.2embed.to";
    private final boolean useMetaLoadResponse = true;
    private final Set<TvType> supportedTypes = SetsKt.setOf((Object[]) new TvType[]{TvType.Movie, TvType.TvSeries});

    @Override // com.lagradost.cloudstream3.metaproviders.TmdbProvider
    public String getApiName() {
        return this.apiName;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public String getName() {
        return this.name;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public String getMainUrl() {
        return this.mainUrl;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public void setMainUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mainUrl = str;
    }

    @Override // com.lagradost.cloudstream3.metaproviders.TmdbProvider
    public boolean getUseMetaLoadResponse() {
        return this.useMetaLoadResponse;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getInstantLinkLoading() {
        return this.instantLinkLoading;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* compiled from: TwoEmbedProvider.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0001\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006\u0012\u0010\b\u0001\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003JC\u0010\u0013\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00062\u0010\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TwoEmbedProvider$EmbedJson;", "", "type", "", "link", "sources", "", "tracks", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getLink", "()Ljava/lang/String;", "getSources", "()Ljava/util/List;", "getTracks", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class EmbedJson {
        private final String link;
        private final List<String> sources;
        private final List<String> tracks;
        private final String type;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ EmbedJson copy$default(EmbedJson embedJson, String str, String str2, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = embedJson.type;
            }
            if ((i & 2) != 0) {
                str2 = embedJson.link;
            }
            if ((i & 4) != 0) {
                list = embedJson.sources;
            }
            if ((i & 8) != 0) {
                list2 = embedJson.tracks;
            }
            return embedJson.copy(str, str2, list, list2);
        }

        public final String component1() {
            return this.type;
        }

        public final String component2() {
            return this.link;
        }

        public final List<String> component3() {
            return this.sources;
        }

        public final List<String> component4() {
            return this.tracks;
        }

        public final EmbedJson copy(@JsonProperty("type") String str, @JsonProperty("link") String link, @JsonProperty("sources") List<String> sources, @JsonProperty("tracks") List<String> list) {
            Intrinsics.checkNotNullParameter(link, "link");
            Intrinsics.checkNotNullParameter(sources, "sources");
            return new EmbedJson(str, link, sources, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EmbedJson) {
                EmbedJson embedJson = (EmbedJson) obj;
                return Intrinsics.areEqual(this.type, embedJson.type) && Intrinsics.areEqual(this.link, embedJson.link) && Intrinsics.areEqual(this.sources, embedJson.sources) && Intrinsics.areEqual(this.tracks, embedJson.tracks);
            }
            return false;
        }

        public int hashCode() {
            String str = this.type;
            int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.link.hashCode()) * 31) + this.sources.hashCode()) * 31;
            List<String> list = this.tracks;
            return hashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "EmbedJson(type=" + this.type + ", link=" + this.link + ", sources=" + this.sources + ", tracks=" + this.tracks + ')';
        }

        public EmbedJson(@JsonProperty("type") String str, @JsonProperty("link") String link, @JsonProperty("sources") List<String> sources, @JsonProperty("tracks") List<String> list) {
            Intrinsics.checkNotNullParameter(link, "link");
            Intrinsics.checkNotNullParameter(sources, "sources");
            this.type = str;
            this.link = link;
            this.sources = sources;
            this.tracks = list;
        }

        public final String getType() {
            return this.type;
        }

        public final String getLink() {
            return this.link;
        }

        public final List<String> getSources() {
            return this.sources;
        }

        public final List<String> getTracks() {
            return this.tracks;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01ab A[LOOP:0: B:40:0x01a5->B:42:0x01ab, LOOP_END] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadLinks(java.lang.String r25, boolean r26, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r27, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r28, kotlin.coroutines.Continuation<? super java.lang.Boolean> r29) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.TwoEmbedProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Object extractorVerifierJob(String str, Continuation<? super Unit> continuation) {
        String name = getName();
        Log.d(name, "Starting " + getName() + " job!");
        Object runSflixExtractorVerifierJob = SflixProvider.Companion.runSflixExtractorVerifierJob(this, str, "https://rabbitstream.net/", continuation);
        return runSflixExtractorVerifierJob == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? runSflixExtractorVerifierJob : Unit.INSTANCE;
    }
}
