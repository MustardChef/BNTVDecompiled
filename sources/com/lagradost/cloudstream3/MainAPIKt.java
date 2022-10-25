package com.lagradost.cloudstream3;

import android.util.Base64;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.tvprovider.media.p009tv.TvContractCompat;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.module.kotlin.KotlinModule;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.cast.HlsSegmentFormat;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.p041ui.player.SubtitleData;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.uwetrottmann.tmdb2.TmdbHelper;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: MainAPI.kt */
@Metadata(m108d1 = {"\u0000À\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0007\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0004H\u0007\u001a\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0010H\u0007\u001a\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004\u001a\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u001a\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u001a\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004\u001a\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u001c\u001a\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u001a\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\u0004\u001a\u0012\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0004\u001a\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00172\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0%\u001a\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00172\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0%\u001a\u0014\u0010)\u001a\u00020**\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-\u001a\u001e\u0010)\u001a\u00020**\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010.\u001a\u00020\u0004\u001a\u0019\u0010/\u001a\u00020**\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u00102\u001a#\u00103\u001a\u00020**\u0002002\u0006\u00104\u001a\u0002052\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u00106\u001a7\u00103\u001a\u00020**\u0002002\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u0002082\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010<\u001a#\u00103\u001a\u00020**\u0002002\u0006\u0010=\u001a\u0002082\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010>\u001a#\u00103\u001a\u00020**\u0002002\u0006\u00104\u001a\u00020\u00042\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010?\u001a\"\u0010@\u001a\u00020**\u00020A2\u0006\u00104\u001a\u0002052\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u0017\u001a,\u0010B\u001a\u00020**\u00020C2\b\u0010 \u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010E\u001a,\u0010B\u001a\u00020**\u00020F2\b\u0010 \u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010E\u001a\u0012\u0010G\u001a\u00020**\u00020F2\u0006\u0010H\u001a\u00020\u0004\u001a\u0019\u0010I\u001a\u00020**\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u00102\u001a\u0012\u0010J\u001a\u00020\u0004*\u00020K2\u0006\u0010 \u001a\u00020\u0004\u001a\u0016\u0010L\u001a\u0004\u0018\u00010\u0004*\u00020K2\b\u0010 \u001a\u0004\u0018\u00010\u0004\u001a\f\u0010M\u001a\u000208*\u0004\u0018\u00010C\u001a\n\u0010N\u001a\u000208*\u00020O\u001a\f\u0010P\u001a\u000208*\u0004\u0018\u00010C\u001a\f\u0010P\u001a\u000208*\u0004\u0018\u00010O\u001a\n\u0010Q\u001a\u000208*\u00020O\u001aG\u0010R\u001a\u00020A*\u00020K2\u0006\u0010S\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010T\u001a\u00020O2\b\b\u0002\u0010U\u001a\u0002082\u0019\b\u0002\u0010V\u001a\u0013\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020*0W¢\u0006\u0002\bX\u001aI\u0010Y\u001a\u000200*\u00020K2\u0006\u0010S\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\b\b\u0002\u0010T\u001a\u00020O2\b\b\u0002\u0010Z\u001a\u0002082\u0019\b\u0002\u0010V\u001a\u0013\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020*0W¢\u0006\u0002\bX\u001a8\u0010[\u001a\u00020+\"\u0004\b\u0000\u0010\\*\u00020K2\u0006\u0010]\u001a\u0002H\\2\u0019\b\u0002\u0010V\u001a\u0013\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020*0W¢\u0006\u0002\bX¢\u0006\u0002\u0010^\u001a7\u0010[\u001a\u00020+*\u00020K2\u0006\u0010 \u001a\u00020\u00042\u0019\b\u0002\u0010V\u001a\u0013\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020*0W¢\u0006\u0002\bX2\b\b\u0002\u0010Z\u001a\u000208\u001aR\u0010_\u001a\u00020`\"\u0004\b\u0000\u0010\\*\u00020K2\u0006\u0010S\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010T\u001a\u00020O2\b\u0010]\u001a\u0004\u0018\u0001H\\2\u0019\b\u0002\u0010V\u001a\u0013\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020*0W¢\u0006\u0002\bX¢\u0006\u0002\u0010a\u001aE\u0010_\u001a\u00020`*\u00020K2\u0006\u0010S\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010T\u001a\u00020O2\u0006\u0010b\u001a\u00020\u00042\u0019\b\u0002\u0010V\u001a\u0013\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020*0W¢\u0006\u0002\bX\u001aI\u0010c\u001a\u00020d*\u00020K2\u0006\u0010S\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\b\b\u0002\u0010T\u001a\u00020O2\b\b\u0002\u0010Z\u001a\u0002082\u0019\b\u0002\u0010V\u001a\u0013\u0012\u0004\u0012\u00020d\u0012\u0004\u0012\u00020*0W¢\u0006\u0002\bX\u001aK\u0010e\u001a\u00020f*\u00020K2\u0006\u0010S\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010T\u001a\u00020O2\f\u00101\u001a\b\u0012\u0004\u0012\u00020+0\u00172\u0019\b\u0002\u0010V\u001a\u0013\u0012\u0004\u0012\u00020f\u0012\u0004\u0012\u00020*0W¢\u0006\u0002\bX\u001aI\u0010g\u001a\u00020h*\u00020K2\u0006\u0010S\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\b\b\u0002\u0010T\u001a\u00020O2\b\b\u0002\u0010Z\u001a\u0002082\u0019\b\u0002\u0010V\u001a\u0013\u0012\u0004\u0012\u00020h\u0012\u0004\u0012\u00020*0W¢\u0006\u0002\bX\u001a\u0013\u0010i\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u001c\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\"\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006j"}, m107d2 = {"PROVIDER_STATUS_BETA_ONLY", "", "PROVIDER_STATUS_DOWN", MainAPIKt.PROVIDER_STATUS_KEY, "", "PROVIDER_STATUS_OK", "PROVIDER_STATUS_SLOW", "PROVIDER_STATUS_URL", "USER_AGENT", "mapper", "Lcom/fasterxml/jackson/databind/json/JsonMapper;", "getMapper", "()Lcom/fasterxml/jackson/databind/json/JsonMapper;", "base64Decode", TypedValues.Custom.S_STRING, "base64DecodeArray", "", "base64Encode", "array", "capitalizeString", "str", "capitalizeStringNullable", "fetchUrls", "", "text", "fixTitle", "getDurationFromString", TvContractCompat.PARAM_INPUT, "(Ljava/lang/String;)Ljava/lang/Integer;", "getQualityFromString", "Lcom/lagradost/cloudstream3/SearchQuality;", "imdbUrlToId", "url", "imdbUrlToIdNullable", "sortSubs", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "subs", "", "sortUrls", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "urls", "addDate", "", "Lcom/lagradost/cloudstream3/Episode;", "date", "Ljava/util/Date;", "format", "addDub", "Lcom/lagradost/cloudstream3/AnimeSearchResponse;", "episodes", "(Lcom/lagradost/cloudstream3/AnimeSearchResponse;Ljava/lang/Integer;)V", "addDubStatus", "status", "Lcom/lagradost/cloudstream3/DubStatus;", "(Lcom/lagradost/cloudstream3/AnimeSearchResponse;Lcom/lagradost/cloudstream3/DubStatus;Ljava/lang/Integer;)V", "dubExist", "", "subExist", "dubEpisodes", "subEpisodes", "(Lcom/lagradost/cloudstream3/AnimeSearchResponse;ZZLjava/lang/Integer;Ljava/lang/Integer;)V", "isDub", "(Lcom/lagradost/cloudstream3/AnimeSearchResponse;ZLjava/lang/Integer;)V", "(Lcom/lagradost/cloudstream3/AnimeSearchResponse;Ljava/lang/String;Ljava/lang/Integer;)V", "addEpisodes", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;", "addPoster", "Lcom/lagradost/cloudstream3/LoadResponse;", "headers", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "addQuality", "quality", "addSub", "fixUrl", "Lcom/lagradost/cloudstream3/MainAPI;", "fixUrlNull", "isAnimeBased", "isAnimeOp", "Lcom/lagradost/cloudstream3/TvType;", "isEpisodeBased", "isMovieType", "newAnimeLoadResponse", "name", "type", "comingSoonIfNone", "initializer", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "newAnimeSearchResponse", "fix", "newEpisode", ExifInterface.GPS_DIRECTION_TRUE, "data", "(Lcom/lagradost/cloudstream3/MainAPI;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lcom/lagradost/cloudstream3/Episode;", "newMovieLoadResponse", "Lcom/lagradost/cloudstream3/MovieLoadResponse;", "(Lcom/lagradost/cloudstream3/MainAPI;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lcom/lagradost/cloudstream3/MovieLoadResponse;", "dataUrl", "newMovieSearchResponse", "Lcom/lagradost/cloudstream3/MovieSearchResponse;", "newTvSeriesLoadResponse", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;", "newTvSeriesSearchResponse", "Lcom/lagradost/cloudstream3/TvSeriesSearchResponse;", "toRatingInt", "app_release"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class MainAPIKt {
    public static final int PROVIDER_STATUS_BETA_ONLY = 3;
    public static final int PROVIDER_STATUS_DOWN = 0;
    public static final String PROVIDER_STATUS_KEY = "PROVIDER_STATUS_KEY";
    public static final int PROVIDER_STATUS_OK = 1;
    public static final int PROVIDER_STATUS_SLOW = 2;
    public static final String PROVIDER_STATUS_URL = "https://raw.githubusercontent.com/cinehubwork/abc/master/providers.json";
    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36";
    private static final JsonMapper mapper;

    static {
        JsonMapper build = JsonMapper.builder().addModule(new KotlinModule(0, false, false, false, null, false, 63, null)).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();
        Intrinsics.checkNotNull(build);
        mapper = build;
    }

    public static final JsonMapper getMapper() {
        return mapper;
    }

    public static final String base64Decode(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return new String(base64DecodeArray(string), Charsets.ISO_8859_1);
    }

    public static final byte[] base64DecodeArray(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        try {
            byte[] decode = Base64.decode(string, 0);
            Intrinsics.checkNotNullExpressionValue(decode, "{\n        android.util.B…til.Base64.DEFAULT)\n    }");
            return decode;
        } catch (Exception unused) {
            byte[] decode2 = java.util.Base64.getDecoder().decode(string);
            Intrinsics.checkNotNullExpressionValue(decode2, "{\n        Base64.getDecoder().decode(string)\n    }");
            return decode2;
        }
    }

    public static final String base64Encode(byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        try {
            byte[] encode = Base64.encode(array, 2);
            Intrinsics.checkNotNullExpressionValue(encode, "encode(array, android.util.Base64.NO_WRAP)");
            return new String(encode, Charsets.ISO_8859_1);
        } catch (Exception unused) {
            byte[] encode2 = java.util.Base64.getEncoder().encode(array);
            Intrinsics.checkNotNullExpressionValue(encode2, "getEncoder().encode(array)");
            return new String(encode2, Charsets.UTF_8);
        }
    }

    public static final String fixUrlNull(MainAPI mainAPI, String str) {
        Intrinsics.checkNotNullParameter(mainAPI, "<this>");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        return fixUrl(mainAPI, str);
    }

    public static final String fixUrl(MainAPI mainAPI, String url) {
        Intrinsics.checkNotNullParameter(mainAPI, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null) || StringsKt.startsWith$default(url, "{\"", false, 2, (Object) null)) {
            return url;
        }
        String str = url;
        if (str.length() == 0) {
            return "";
        }
        if (StringsKt.startsWith$default(url, "//", false, 2, (Object) null)) {
            return "https:" + url;
        } else if (StringsKt.startsWith$default((CharSequence) str, (char) JsonPointer.SEPARATOR, false, 2, (Object) null)) {
            return mainAPI.getMainUrl() + url;
        } else {
            return mainAPI.getMainUrl() + JsonPointer.SEPARATOR + url;
        }
    }

    public static final List<ExtractorLink> sortUrls(Set<? extends ExtractorLink> urls) {
        Intrinsics.checkNotNullParameter(urls, "urls");
        return CollectionsKt.sortedWith(urls, new Comparator() { // from class: com.lagradost.cloudstream3.MainAPIKt$sortUrls$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(-((ExtractorLink) t).getQuality()), Integer.valueOf(-((ExtractorLink) t2).getQuality()));
            }
        });
    }

    public static final List<SubtitleData> sortSubs(Set<SubtitleData> subs) {
        Intrinsics.checkNotNullParameter(subs, "subs");
        return CollectionsKt.sortedWith(subs, new Comparator() { // from class: com.lagradost.cloudstream3.MainAPIKt$sortSubs$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((SubtitleData) t).getName(), ((SubtitleData) t2).getName());
            }
        });
    }

    public static final String capitalizeString(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        String capitalizeStringNullable = capitalizeStringNullable(str);
        return capitalizeStringNullable == null ? str : capitalizeStringNullable;
    }

    public static final String capitalizeStringNullable(String str) {
        String valueOf;
        if (str == null) {
            return null;
        }
        try {
            if (str.length() > 0) {
                StringBuilder sb = new StringBuilder();
                char charAt = str.charAt(0);
                if (Character.isLowerCase(charAt)) {
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                    valueOf = CharsKt.titlecase(charAt, locale);
                } else {
                    valueOf = String.valueOf(charAt);
                }
                sb.append((Object) valueOf);
                String substring = str.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                sb.append(substring);
                return sb.toString();
            }
            return str;
        } catch (Exception unused) {
            return str;
        }
    }

    public static final String fixTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        return CollectionsKt.joinToString$default(StringsKt.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null), " ", null, null, 0, null, MainAPIKt$fixTitle$1.INSTANCE, 30, null);
    }

    public static final String imdbUrlToId(String url) {
        List<String> groupValues;
        List<String> groupValues2;
        String str;
        Intrinsics.checkNotNullParameter(url, "url");
        String str2 = url;
        MatchResult find$default = Regex.find$default(new Regex("/title/(tt[0-9]*)"), str2, 0, 2, null);
        if (find$default == null || (groupValues2 = find$default.getGroupValues()) == null || (str = groupValues2.get(1)) == null) {
            MatchResult find$default2 = Regex.find$default(new Regex("tt[0-9]{5,}"), str2, 0, 2, null);
            if (find$default2 == null || (groupValues = find$default2.getGroupValues()) == null) {
                return null;
            }
            return groupValues.get(0);
        }
        return str;
    }

    public static final String imdbUrlToIdNullable(String str) {
        if (str == null) {
            return null;
        }
        return imdbUrlToId(str);
    }

    public static final boolean isMovieType(TvType tvType) {
        Intrinsics.checkNotNullParameter(tvType, "<this>");
        return tvType == TvType.Movie || tvType == TvType.AnimeMovie || tvType == TvType.Torrent;
    }

    public static final boolean isAnimeOp(TvType tvType) {
        Intrinsics.checkNotNullParameter(tvType, "<this>");
        return tvType == TvType.Anime || tvType == TvType.OVA;
    }

    public static final SearchQuality getQualityFromString(String str) {
        if (str == null) {
            return null;
        }
        String lowerCase = StringsKt.trim((CharSequence) str).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        String replace$default = StringsKt.replace$default(lowerCase, " ", "", false, 4, (Object) null);
        switch (replace$default.hashCode()) {
            case -1385972001:
                if (replace$default.equals("bluray")) {
                    return SearchQuality.BlueRay;
                }
                return null;
            case -1367739670:
                if (replace$default.equals("camrip")) {
                    return SearchQuality.CamRip;
                }
                return null;
            case -1360595129:
                if (replace$default.equals("telecine")) {
                    return SearchQuality.Telecine;
                }
                return null;
            case -1360103099:
                if (replace$default.equals("telesync")) {
                    return SearchQuality.Telesync;
                }
                return null;
            case -1327781603:
                if (replace$default.equals("highquality")) {
                    return SearchQuality.HQ;
                }
                return null;
            case -1319984697:
                if (replace$default.equals("dvdrip")) {
                    return SearchQuality.DVD;
                }
                return null;
            case -1319983920:
                if (replace$default.equals("dvdscr")) {
                    return SearchQuality.DVD;
                }
                return null;
            case -791790267:
                if (replace$default.equals("webrip")) {
                    return SearchQuality.WebRip;
                }
                return null;
            case -289214347:
                if (replace$default.equals("highdefinition")) {
                    return SearchQuality.HD;
                }
                return null;
            case -15830640:
                if (replace$default.equals("blueray")) {
                    return SearchQuality.BlueRay;
                }
                return null;
            case 1719:
                if (replace$default.equals("4k")) {
                    return SearchQuality.FourK;
                }
                return null;
            case 3152:
                if (replace$default.equals(TtmlNode.TAG_BR)) {
                    return SearchQuality.BlueRay;
                }
                return null;
            case 3324:
                if (replace$default.equals("hd")) {
                    return SearchQuality.HD;
                }
                return null;
            case 3337:
                if (replace$default.equals("hq")) {
                    return SearchQuality.HQ;
                }
                return null;
            case 3665:
                if (replace$default.equals("sd")) {
                    return SearchQuality.SD;
                }
                return null;
            case 3695:
                if (replace$default.equals("tc")) {
                    return SearchQuality.Telecine;
                }
                return null;
            case 3711:
                if (replace$default.equals(HlsSegmentFormat.f9702TS)) {
                    return SearchQuality.Telesync;
                }
                return null;
            case 3801:
                if (replace$default.equals("wp")) {
                    return SearchQuality.WorkPrint;
                }
                return null;
            case 97643:
                if (replace$default.equals("blu")) {
                    return SearchQuality.BlueRay;
                }
                return null;
            case 98255:
                if (replace$default.equals("cam")) {
                    return SearchQuality.Cam;
                }
                return null;
            case 99858:
                if (replace$default.equals("dvd")) {
                    return SearchQuality.DVD;
                }
                return null;
            case 101346:
                if (replace$default.equals("fhd")) {
                    return SearchQuality.HD;
                }
                return null;
            case 103158:
                if (replace$default.equals("hdr")) {
                    return SearchQuality.HDR;
                }
                return null;
            case 112921:
                if (replace$default.equals("rip")) {
                    return SearchQuality.CamRip;
                }
                return null;
            case 113729:
                if (replace$default.equals("sdr")) {
                    return SearchQuality.SDR;
                }
                return null;
            case 115761:
                if (replace$default.equals("uhd")) {
                    return SearchQuality.UHD;
                }
                return null;
            case 117588:
                if (replace$default.equals("web")) {
                    return SearchQuality.WebRip;
                }
                return null;
            case 3027034:
                if (replace$default.equals("blue")) {
                    return SearchQuality.BlueRay;
                }
                return null;
            case 3198059:
                if (replace$default.equals("hdtc")) {
                    return SearchQuality.HdCam;
                }
                return null;
            case 3198075:
                if (replace$default.equals("hdts")) {
                    return SearchQuality.HdCam;
                }
                return null;
            case 3198078:
                if (replace$default.equals("hdtv")) {
                    return SearchQuality.HD;
                }
                return null;
            case 99123539:
                if (replace$default.equals("hdcam")) {
                    return SearchQuality.HdCam;
                }
                return null;
            case 99138205:
                if (replace$default.equals("hdrip")) {
                    return SearchQuality.HD;
                }
                return null;
            case 113005276:
                if (replace$default.equals("webdl")) {
                    return SearchQuality.WebRip;
                }
                return null;
            case 1106161212:
                if (replace$default.equals("workprint")) {
                    return SearchQuality.WorkPrint;
                }
                return null;
            case 1312628413:
                if (replace$default.equals("standard")) {
                    return SearchQuality.SD;
                }
                return null;
            default:
                return null;
        }
    }

    public static /* synthetic */ MovieSearchResponse newMovieSearchResponse$default(MainAPI mainAPI, String str, String str2, TvType tvType, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            tvType = TvType.Movie;
        }
        TvType tvType2 = tvType;
        boolean z2 = (i & 8) != 0 ? true : z;
        if ((i & 16) != 0) {
            function1 = MainAPIKt$newMovieSearchResponse$1.INSTANCE;
        }
        return newMovieSearchResponse(mainAPI, str, str2, tvType2, z2, function1);
    }

    public static final MovieSearchResponse newMovieSearchResponse(MainAPI mainAPI, String name, String str, TvType type, boolean z, Function1<? super MovieSearchResponse, Unit> initializer) {
        String url = str;
        Intrinsics.checkNotNullParameter(mainAPI, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        if (z) {
            url = fixUrl(mainAPI, url);
        }
        MovieSearchResponse movieSearchResponse = new MovieSearchResponse(name, url, mainAPI.getName(), type, null, null, null, null, null, 496, null);
        initializer.invoke(movieSearchResponse);
        return movieSearchResponse;
    }

    public static /* synthetic */ TvSeriesSearchResponse newTvSeriesSearchResponse$default(MainAPI mainAPI, String str, String str2, TvType tvType, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            tvType = TvType.TvSeries;
        }
        TvType tvType2 = tvType;
        boolean z2 = (i & 8) != 0 ? true : z;
        if ((i & 16) != 0) {
            function1 = MainAPIKt$newTvSeriesSearchResponse$1.INSTANCE;
        }
        return newTvSeriesSearchResponse(mainAPI, str, str2, tvType2, z2, function1);
    }

    public static final TvSeriesSearchResponse newTvSeriesSearchResponse(MainAPI mainAPI, String name, String str, TvType type, boolean z, Function1<? super TvSeriesSearchResponse, Unit> initializer) {
        String url = str;
        Intrinsics.checkNotNullParameter(mainAPI, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        if (z) {
            url = fixUrl(mainAPI, url);
        }
        TvSeriesSearchResponse tvSeriesSearchResponse = new TvSeriesSearchResponse(name, url, mainAPI.getName(), type, null, null, null, null, null, null, 1008, null);
        initializer.invoke(tvSeriesSearchResponse);
        return tvSeriesSearchResponse;
    }

    public static /* synthetic */ AnimeSearchResponse newAnimeSearchResponse$default(MainAPI mainAPI, String str, String str2, TvType tvType, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            tvType = TvType.Anime;
        }
        TvType tvType2 = tvType;
        boolean z2 = (i & 8) != 0 ? true : z;
        if ((i & 16) != 0) {
            function1 = MainAPIKt$newAnimeSearchResponse$1.INSTANCE;
        }
        return newAnimeSearchResponse(mainAPI, str, str2, tvType2, z2, function1);
    }

    public static final AnimeSearchResponse newAnimeSearchResponse(MainAPI mainAPI, String name, String str, TvType type, boolean z, Function1<? super AnimeSearchResponse, Unit> initializer) {
        String url = str;
        Intrinsics.checkNotNullParameter(mainAPI, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        if (z) {
            url = fixUrl(mainAPI, url);
        }
        AnimeSearchResponse animeSearchResponse = new AnimeSearchResponse(name, url, mainAPI.getName(), type, null, null, null, null, null, null, null, null, 4080, null);
        initializer.invoke(animeSearchResponse);
        return animeSearchResponse;
    }

    public static final void addQuality(SearchResponse searchResponse, String quality) {
        Intrinsics.checkNotNullParameter(searchResponse, "<this>");
        Intrinsics.checkNotNullParameter(quality, "quality");
        searchResponse.setQuality(getQualityFromString(quality));
    }

    public static /* synthetic */ void addPoster$default(SearchResponse searchResponse, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        addPoster(searchResponse, str, map);
    }

    public static final void addPoster(SearchResponse searchResponse, String str, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(searchResponse, "<this>");
        searchResponse.setPosterUrl(str);
        searchResponse.setPosterHeaders(map);
    }

    public static /* synthetic */ void addPoster$default(LoadResponse loadResponse, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        addPoster(loadResponse, str, map);
    }

    public static final void addPoster(LoadResponse loadResponse, String str, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(loadResponse, "<this>");
        loadResponse.setPosterUrl(str);
        loadResponse.setPosterHeaders(map);
    }

    public static /* synthetic */ void addDubStatus$default(AnimeSearchResponse animeSearchResponse, DubStatus dubStatus, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        addDubStatus(animeSearchResponse, dubStatus, num);
    }

    public static final void addDubStatus(AnimeSearchResponse animeSearchResponse, DubStatus status, Integer num) {
        Intrinsics.checkNotNullParameter(animeSearchResponse, "<this>");
        Intrinsics.checkNotNullParameter(status, "status");
        EnumSet<DubStatus> dubStatus = animeSearchResponse.getDubStatus();
        if (dubStatus != null) {
            dubStatus.add(status);
        } else {
            dubStatus = EnumSet.of(status);
        }
        animeSearchResponse.setDubStatus(dubStatus);
        TvType type = animeSearchResponse.getType();
        boolean z = true;
        if (((type == null || !isMovieType(type)) ? false : false) || num == null || num.intValue() <= 0) {
            return;
        }
        animeSearchResponse.getEpisodes().put(status, num);
    }

    public static /* synthetic */ void addDubStatus$default(AnimeSearchResponse animeSearchResponse, boolean z, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        addDubStatus(animeSearchResponse, z, num);
    }

    public static final void addDubStatus(AnimeSearchResponse animeSearchResponse, boolean z, Integer num) {
        Intrinsics.checkNotNullParameter(animeSearchResponse, "<this>");
        addDubStatus(animeSearchResponse, z ? DubStatus.Dubbed : DubStatus.Subbed, num);
    }

    public static final void addDub(AnimeSearchResponse animeSearchResponse, Integer num) {
        Intrinsics.checkNotNullParameter(animeSearchResponse, "<this>");
        if (num == null || num.intValue() <= 0) {
            return;
        }
        addDubStatus(animeSearchResponse, DubStatus.Dubbed, num);
    }

    public static final void addSub(AnimeSearchResponse animeSearchResponse, Integer num) {
        Intrinsics.checkNotNullParameter(animeSearchResponse, "<this>");
        if (num == null || num.intValue() <= 0) {
            return;
        }
        addDubStatus(animeSearchResponse, DubStatus.Subbed, num);
    }

    public static /* synthetic */ void addDubStatus$default(AnimeSearchResponse animeSearchResponse, boolean z, boolean z2, Integer num, Integer num2, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            num2 = null;
        }
        addDubStatus(animeSearchResponse, z, z2, num, num2);
    }

    public static final void addDubStatus(AnimeSearchResponse animeSearchResponse, boolean z, boolean z2, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(animeSearchResponse, "<this>");
        if (z) {
            addDubStatus(animeSearchResponse, DubStatus.Dubbed, num);
        }
        if (z2) {
            addDubStatus(animeSearchResponse, DubStatus.Subbed, num2);
        }
    }

    public static /* synthetic */ void addDubStatus$default(AnimeSearchResponse animeSearchResponse, String str, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        addDubStatus(animeSearchResponse, str, num);
    }

    public static final void addDubStatus(AnimeSearchResponse animeSearchResponse, String status, Integer num) {
        Intrinsics.checkNotNullParameter(animeSearchResponse, "<this>");
        Intrinsics.checkNotNullParameter(status, "status");
        String str = status;
        if (StringsKt.contains((CharSequence) str, (CharSequence) "(dub)", true)) {
            addDubStatus$default(animeSearchResponse, DubStatus.Dubbed, (Integer) null, 2, (Object) null);
        } else if (StringsKt.contains((CharSequence) str, (CharSequence) "(sub)", true)) {
            addDubStatus$default(animeSearchResponse, DubStatus.Subbed, (Integer) null, 2, (Object) null);
        }
    }

    public static final Integer getDurationFromString(String str) {
        String obj;
        String replace$default;
        List<String> groupValues;
        List<String> groupValues2;
        if (str != null && (obj = StringsKt.trim((CharSequence) str).toString()) != null && (replace$default = StringsKt.replace$default(obj, " ", "", false, 4, (Object) null)) != null) {
            String str2 = replace$default;
            MatchResult find$default = Regex.find$default(new Regex("([0-9]*)h.*?([0-9]*)m"), str2, 0, 2, null);
            if (find$default != null && (groupValues2 = find$default.getGroupValues()) != null && groupValues2.size() == 3) {
                Integer intOrNull = StringsKt.toIntOrNull(groupValues2.get(1));
                Integer intOrNull2 = StringsKt.toIntOrNull(groupValues2.get(2));
                if (intOrNull2 == null || intOrNull == null) {
                    return null;
                }
                return Integer.valueOf((intOrNull.intValue() * 60) + intOrNull2.intValue());
            }
            MatchResult find$default2 = Regex.find$default(new Regex("([0-9]*)m"), str2, 0, 2, null);
            if (find$default2 != null && (groupValues = find$default2.getGroupValues()) != null && groupValues.size() == 2) {
                return StringsKt.toIntOrNull(groupValues.get(1));
            }
        }
        return null;
    }

    public static final boolean isEpisodeBased(LoadResponse loadResponse) {
        if (loadResponse == null) {
            return false;
        }
        return ((loadResponse instanceof AnimeLoadResponse) || (loadResponse instanceof TvSeriesLoadResponse)) && isEpisodeBased(loadResponse.getType());
    }

    public static final boolean isAnimeBased(LoadResponse loadResponse) {
        if (loadResponse == null) {
            return false;
        }
        return loadResponse.getType() == TvType.Anime || loadResponse.getType() == TvType.OVA;
    }

    public static final boolean isEpisodeBased(TvType tvType) {
        if (tvType == null) {
            return false;
        }
        return tvType == TvType.TvSeries || tvType == TvType.Anime;
    }

    public static final void addEpisodes(AnimeLoadResponse animeLoadResponse, DubStatus status, List<Episode> list) {
        Intrinsics.checkNotNullParameter(animeLoadResponse, "<this>");
        Intrinsics.checkNotNullParameter(status, "status");
        if (list == null) {
            return;
        }
        animeLoadResponse.getEpisodes().put(status, list);
    }

    public static /* synthetic */ AnimeLoadResponse newAnimeLoadResponse$default(MainAPI mainAPI, String str, String str2, TvType tvType, boolean z, Function1 function1, int i, Object obj) {
        boolean z2 = (i & 8) != 0 ? true : z;
        if ((i & 16) != 0) {
            function1 = MainAPIKt$newAnimeLoadResponse$1.INSTANCE;
        }
        return newAnimeLoadResponse(mainAPI, str, str2, tvType, z2, function1);
    }

    public static final AnimeLoadResponse newAnimeLoadResponse(MainAPI mainAPI, String name, String url, TvType type, boolean z, Function1<? super AnimeLoadResponse, Unit> initializer) {
        boolean z2;
        Intrinsics.checkNotNullParameter(mainAPI, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        AnimeLoadResponse animeLoadResponse = new AnimeLoadResponse(null, null, name, url, mainAPI.getName(), type, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, 4194243, null);
        initializer.invoke(animeLoadResponse);
        if (z) {
            animeLoadResponse.setComingSoon(true);
            Iterator<DubStatus> it = animeLoadResponse.getEpisodes().keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                List<Episode> list = animeLoadResponse.getEpisodes().get(it.next());
                if (list == null || list.isEmpty()) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (!z2) {
                    animeLoadResponse.setComingSoon(false);
                    break;
                }
            }
        }
        return animeLoadResponse;
    }

    public static /* synthetic */ MovieLoadResponse newMovieLoadResponse$default(MainAPI mainAPI, String str, String str2, TvType tvType, Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 16) != 0) {
            function1 = MainAPIKt$newMovieLoadResponse$1.INSTANCE;
        }
        return newMovieLoadResponse(mainAPI, str, str2, tvType, obj, function1);
    }

    public static final <T> MovieLoadResponse newMovieLoadResponse(MainAPI mainAPI, String name, String url, TvType type, T t, Function1<? super MovieLoadResponse, Unit> initializer) {
        Intrinsics.checkNotNullParameter(mainAPI, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        if (t instanceof String) {
            return newMovieLoadResponse(mainAPI, name, url, type, (String) t, initializer);
        }
        String str = (t == null || (r0 = AppUtils.INSTANCE.toJson(t)) == null) ? "" : "";
        MovieLoadResponse movieLoadResponse = new MovieLoadResponse(name, url, mainAPI.getName(), type, str, null, null, null, null, null, null, null, null, null, StringsKt.isBlank(str), null, null, null, 245728, null);
        initializer.invoke(movieLoadResponse);
        return movieLoadResponse;
    }

    public static /* synthetic */ MovieLoadResponse newMovieLoadResponse$default(MainAPI mainAPI, String str, String str2, TvType tvType, String str3, Function1 function1, int i, Object obj) {
        if ((i & 16) != 0) {
            function1 = MainAPIKt$newMovieLoadResponse$2.INSTANCE;
        }
        return newMovieLoadResponse(mainAPI, str, str2, tvType, str3, (Function1<? super MovieLoadResponse, Unit>) function1);
    }

    public static final MovieLoadResponse newMovieLoadResponse(MainAPI mainAPI, String name, String url, TvType type, String dataUrl, Function1<? super MovieLoadResponse, Unit> initializer) {
        Intrinsics.checkNotNullParameter(mainAPI, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(dataUrl, "dataUrl");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        MovieLoadResponse movieLoadResponse = new MovieLoadResponse(name, url, mainAPI.getName(), type, dataUrl, null, null, null, null, null, null, null, null, null, StringsKt.isBlank(dataUrl), null, null, null, 245728, null);
        initializer.invoke(movieLoadResponse);
        return movieLoadResponse;
    }

    public static /* synthetic */ void addDate$default(Episode episode, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = TmdbHelper.TMDB_DATE_PATTERN;
        }
        addDate(episode, str, str2);
    }

    public static final void addDate(Episode episode, String str, String format) {
        Intrinsics.checkNotNullParameter(episode, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            if (str == null) {
                return;
            }
            Date parse = simpleDateFormat.parse(str);
            episode.setDate(parse != null ? Long.valueOf(parse.getTime()) : null);
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }

    public static final void addDate(Episode episode, Date date) {
        Intrinsics.checkNotNullParameter(episode, "<this>");
        episode.setDate(date != null ? Long.valueOf(date.getTime()) : null);
    }

    public static /* synthetic */ Episode newEpisode$default(MainAPI mainAPI, String str, Function1 function1, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = MainAPIKt$newEpisode$1.INSTANCE;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        return newEpisode(mainAPI, str, function1, z);
    }

    public static final Episode newEpisode(MainAPI mainAPI, String url, Function1<? super Episode, Unit> initializer, boolean z) {
        Intrinsics.checkNotNullParameter(mainAPI, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        if (z) {
            url = fixUrl(mainAPI, url);
        }
        Episode episode = new Episode(url, null, null, null, null, null, null, null, 254, null);
        initializer.invoke(episode);
        return episode;
    }

    public static /* synthetic */ Episode newEpisode$default(MainAPI mainAPI, Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 2) != 0) {
            function1 = MainAPIKt$newEpisode$2.INSTANCE;
        }
        return newEpisode(mainAPI, obj, function1);
    }

    public static final <T> Episode newEpisode(MainAPI mainAPI, T t, Function1<? super Episode, Unit> initializer) {
        String json;
        Intrinsics.checkNotNullParameter(mainAPI, "<this>");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        if (t instanceof String) {
            return newEpisode$default(mainAPI, (String) t, initializer, false, 4, null);
        }
        if (t != null && (json = AppUtils.INSTANCE.toJson(t)) != null) {
            Episode episode = new Episode(json, null, null, null, null, null, null, null, 254, null);
            initializer.invoke(episode);
            return episode;
        }
        throw new ErrorLoadingException("invalid newEpisode");
    }

    public static /* synthetic */ TvSeriesLoadResponse newTvSeriesLoadResponse$default(MainAPI mainAPI, String str, String str2, TvType tvType, List list, Function1 function1, int i, Object obj) {
        if ((i & 16) != 0) {
            function1 = MainAPIKt$newTvSeriesLoadResponse$1.INSTANCE;
        }
        return newTvSeriesLoadResponse(mainAPI, str, str2, tvType, list, function1);
    }

    public static final TvSeriesLoadResponse newTvSeriesLoadResponse(MainAPI mainAPI, String name, String url, TvType type, List<Episode> episodes, Function1<? super TvSeriesLoadResponse, Unit> initializer) {
        Intrinsics.checkNotNullParameter(mainAPI, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(episodes, "episodes");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        TvSeriesLoadResponse tvSeriesLoadResponse = new TvSeriesLoadResponse(name, url, mainAPI.getName(), type, episodes, null, null, null, null, null, null, null, null, null, null, episodes.isEmpty(), null, null, null, 491488, null);
        initializer.invoke(tvSeriesLoadResponse);
        return tvSeriesLoadResponse;
    }

    public static final List<String> fetchUrls(String str) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return CollectionsKt.emptyList();
        }
        return SequencesKt.toList(SequencesKt.map(Regex.findAll$default(new Regex("(https?://(www\\.)?[-a-zA-Z0-9@:%._+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_+.~#?&/=]*))"), str2, 0, 2, null), MainAPIKt$fetchUrls$1.INSTANCE));
    }

    public static final Integer toRatingInt(String str) {
        String replace$default;
        String obj;
        Double doubleOrNull;
        if (str == null || (replace$default = StringsKt.replace$default(str, " ", "", false, 4, (Object) null)) == null || (obj = StringsKt.trim((CharSequence) replace$default).toString()) == null || (doubleOrNull = StringsKt.toDoubleOrNull(obj)) == null) {
            return null;
        }
        return Integer.valueOf((int) (Math.abs(doubleOrNull.doubleValue()) * 1000.0f));
    }
}
