package com.lagradost.cloudstream3.utils;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.extractors.Acefile;
import com.lagradost.cloudstream3.extractors.Aico;
import com.lagradost.cloudstream3.extractors.AsianLoad;
import com.lagradost.cloudstream3.extractors.Blogger;
import com.lagradost.cloudstream3.extractors.BullStream;
import com.lagradost.cloudstream3.extractors.Cinestart;
import com.lagradost.cloudstream3.extractors.DBfilm;
import com.lagradost.cloudstream3.extractors.DesuArcg;
import com.lagradost.cloudstream3.extractors.DesuDrive;
import com.lagradost.cloudstream3.extractors.DesuOdchan;
import com.lagradost.cloudstream3.extractors.DesuOdvip;
import com.lagradost.cloudstream3.extractors.DoodExtractor;
import com.lagradost.cloudstream3.extractors.DoodLaExtractor;
import com.lagradost.cloudstream3.extractors.DoodPmExtractor;
import com.lagradost.cloudstream3.extractors.DoodShExtractor;
import com.lagradost.cloudstream3.extractors.DoodSoExtractor;
import com.lagradost.cloudstream3.extractors.DoodToExtractor;
import com.lagradost.cloudstream3.extractors.DoodWatchExtractor;
import com.lagradost.cloudstream3.extractors.DoodWsExtractor;
import com.lagradost.cloudstream3.extractors.Evolaod;
import com.lagradost.cloudstream3.extractors.Evoload1;
import com.lagradost.cloudstream3.extractors.FEmbed;
import com.lagradost.cloudstream3.extractors.FeHD;
import com.lagradost.cloudstream3.extractors.Filesim;
import com.lagradost.cloudstream3.extractors.Fplayer;
import com.lagradost.cloudstream3.extractors.GMPlayer;
import com.lagradost.cloudstream3.extractors.GuardareStream;
import com.lagradost.cloudstream3.extractors.Hxfile;
import com.lagradost.cloudstream3.extractors.JWPlayer;
import com.lagradost.cloudstream3.extractors.Jawcloud;
import com.lagradost.cloudstream3.extractors.KotakAnimeid;
import com.lagradost.cloudstream3.extractors.LayarKaca;
import com.lagradost.cloudstream3.extractors.Linkbox;
import com.lagradost.cloudstream3.extractors.Luxubu;
import com.lagradost.cloudstream3.extractors.Maxstream;
import com.lagradost.cloudstream3.extractors.Mcloud;
import com.lagradost.cloudstream3.extractors.Meownime;
import com.lagradost.cloudstream3.extractors.MixDrop;
import com.lagradost.cloudstream3.extractors.MixDropBz;
import com.lagradost.cloudstream3.extractors.MixDropCh;
import com.lagradost.cloudstream3.extractors.MixDropTo;
import com.lagradost.cloudstream3.extractors.Mp4Upload;
import com.lagradost.cloudstream3.extractors.MwvnVizcloudInfo;
import com.lagradost.cloudstream3.extractors.Neonime7n;
import com.lagradost.cloudstream3.extractors.Neonime8n;
import com.lagradost.cloudstream3.extractors.OkRu;
import com.lagradost.cloudstream3.extractors.OkRuHttps;
import com.lagradost.cloudstream3.extractors.PlayerVoxzer;
import com.lagradost.cloudstream3.extractors.SBfull;
import com.lagradost.cloudstream3.extractors.Solidfiles;
import com.lagradost.cloudstream3.extractors.SpeedoStream;
import com.lagradost.cloudstream3.extractors.StreamSB;
import com.lagradost.cloudstream3.extractors.StreamSB1;
import com.lagradost.cloudstream3.extractors.StreamSB10;
import com.lagradost.cloudstream3.extractors.StreamSB2;
import com.lagradost.cloudstream3.extractors.StreamSB3;
import com.lagradost.cloudstream3.extractors.StreamSB4;
import com.lagradost.cloudstream3.extractors.StreamSB5;
import com.lagradost.cloudstream3.extractors.StreamSB6;
import com.lagradost.cloudstream3.extractors.StreamSB7;
import com.lagradost.cloudstream3.extractors.StreamSB8;
import com.lagradost.cloudstream3.extractors.StreamSB9;
import com.lagradost.cloudstream3.extractors.StreamTape;
import com.lagradost.cloudstream3.extractors.Streamhub2;
import com.lagradost.cloudstream3.extractors.Streamlare;
import com.lagradost.cloudstream3.extractors.Supervideo;
import com.lagradost.cloudstream3.extractors.Tantifilm;
import com.lagradost.cloudstream3.extractors.Tomatomatela;
import com.lagradost.cloudstream3.extractors.Upstream;
import com.lagradost.cloudstream3.extractors.Uqload;
import com.lagradost.cloudstream3.extractors.Uqload1;
import com.lagradost.cloudstream3.extractors.Userload;
import com.lagradost.cloudstream3.extractors.VidSrcExtractor;
import com.lagradost.cloudstream3.extractors.VidSrcExtractor2;
import com.lagradost.cloudstream3.extractors.VideoVard;
import com.lagradost.cloudstream3.extractors.VideovardSX;
import com.lagradost.cloudstream3.extractors.Vidstreamz;
import com.lagradost.cloudstream3.extractors.Vizcloud;
import com.lagradost.cloudstream3.extractors.Vizcloud2;
import com.lagradost.cloudstream3.extractors.VizcloudCloud;
import com.lagradost.cloudstream3.extractors.VizcloudDigital;
import com.lagradost.cloudstream3.extractors.VizcloudInfo;
import com.lagradost.cloudstream3.extractors.VizcloudLive;
import com.lagradost.cloudstream3.extractors.VizcloudOnline;
import com.lagradost.cloudstream3.extractors.VizcloudXyz;
import com.lagradost.cloudstream3.extractors.VoeExtractor;
import com.lagradost.cloudstream3.extractors.WcoStream;
import com.lagradost.cloudstream3.extractors.XStreamCdn;
import com.lagradost.cloudstream3.extractors.YourUpload;
import com.lagradost.cloudstream3.extractors.Yufiles;
import com.lagradost.cloudstream3.extractors.Zplayer;
import com.lagradost.cloudstream3.extractors.ZplayerV2;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: ExtractorApi.kt */
@Metadata(m108d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\u001a\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f\u001a\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f\u001a\u0010\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\f\u001a#\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\f\u001a\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f\u001aA\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\f2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001f0\u001dH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\"\u001aM\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\f2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001f0\u001dH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010$\u001a\u000e\u0010%\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\f\u001a\u0019\u0010&\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010'\u001a\n\u0010(\u001a\u00020)*\u00020)\"\u0019\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, m107d2 = {"extractorApis", "", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "getExtractorApis", "()[Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "[Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "packedRegex", "Lkotlin/text/Regex;", "schemaStripRegex", "getSchemaStripRegex", "()Lkotlin/text/Regex;", "getAndUnpack", "", TypedValues.Custom.S_STRING, "getExtractorApiFromName", "name", "getPacked", "getPostForm", "requestUrl", "html", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQualityFromName", "", "qualityName", "httpsify", "url", "loadExtractor", "", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "referer", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireReferer", "unshortenLinkSafe", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toUs", "", "app_release"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ExtractorApiKt {
    private static final Regex schemaStripRegex = new Regex("^(https:|)//(www\\.|)");
    private static final Regex packedRegex = new Regex("eval\\(function\\(p,a,c,k,e,.*\\)\\)");
    private static final ExtractorApi[] extractorApis = {new WcoStream(), new Vidstreamz(), new Vizcloud(), new Vizcloud2(), new VizcloudOnline(), new VizcloudXyz(), new VizcloudLive(), new VizcloudInfo(), new MwvnVizcloudInfo(), new VizcloudDigital(), new VizcloudCloud(), new VideoVard(), new VideovardSX(), new Mp4Upload(), new StreamTape(), new MixDropBz(), new MixDropCh(), new MixDropTo(), new MixDrop(), new Mcloud(), new XStreamCdn(), new StreamSB(), new StreamSB1(), new StreamSB2(), new StreamSB3(), new StreamSB4(), new StreamSB5(), new StreamSB6(), new StreamSB7(), new StreamSB8(), new StreamSB9(), new StreamSB10(), new SBfull(), new Streamhub2(), new FEmbed(), new FeHD(), new Fplayer(), new DBfilm(), new Luxubu(), new LayarKaca(), new Uqload(), new Uqload1(), new Evolaod(), new Evoload1(), new VoeExtractor(), new Tomatomatela(), new Cinestart(), new OkRu(), new OkRuHttps(), new DoodExtractor(), new DoodPmExtractor(), new DoodToExtractor(), new DoodSoExtractor(), new DoodLaExtractor(), new DoodWsExtractor(), new DoodShExtractor(), new DoodWatchExtractor(), new AsianLoad(), new Jawcloud(), new Zplayer(), new ZplayerV2(), new Upstream(), new Maxstream(), new Tantifilm(), new Userload(), new Supervideo(), new GuardareStream(), new PlayerVoxzer(), new BullStream(), new GMPlayer(), new Blogger(), new Solidfiles(), new YourUpload(), new Hxfile(), new KotakAnimeid(), new Neonime8n(), new Neonime7n(), new Yufiles(), new Aico(), new JWPlayer(), new Meownime(), new DesuArcg(), new DesuOdchan(), new DesuOdvip(), new DesuDrive(), new Filesim(), new Linkbox(), new Acefile(), new SpeedoStream(), new Streamlare(), new VidSrcExtractor(), new VidSrcExtractor2()};

    public static final long toUs(long j) {
        return j * 1000000;
    }

    public static final Regex getSchemaStripRegex() {
        return schemaStripRegex;
    }

    public static final int getQualityFromName(String str) {
        if (str == null) {
            return Qualities.Unknown.getValue();
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        String obj = StringsKt.trim((CharSequence) StringsKt.replace$default(lowerCase, TtmlNode.TAG_P, "", false, 4, (Object) null)).toString();
        Qualities qualities = Intrinsics.areEqual(obj, "4k") ? Qualities.P2160 : null;
        if (qualities != null) {
            return qualities.getValue();
        }
        Integer intOrNull = StringsKt.toIntOrNull(obj);
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        return Qualities.Unknown.getValue();
    }

    public static final String getPacked(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        MatchResult find$default = Regex.find$default(packedRegex, string, 0, 2, null);
        if (find$default != null) {
            return find$default.getValue();
        }
        return null;
    }

    public static final String getAndUnpack(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        String unpack = new JsUnpacker(getPacked(string)).unpack();
        return unpack == null ? string : unpack;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object unshortenLinkSafe(java.lang.String r7, kotlin.coroutines.Continuation<? super java.lang.String> r8) {
        /*
            boolean r0 = r8 instanceof com.lagradost.cloudstream3.utils.ExtractorApiKt$unshortenLinkSafe$1
            if (r0 == 0) goto L14
            r0 = r8
            com.lagradost.cloudstream3.utils.ExtractorApiKt$unshortenLinkSafe$1 r0 = (com.lagradost.cloudstream3.utils.ExtractorApiKt$unshortenLinkSafe$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.lagradost.cloudstream3.utils.ExtractorApiKt$unshortenLinkSafe$1 r0 = new com.lagradost.cloudstream3.utils.ExtractorApiKt$unshortenLinkSafe$1
            r0.<init>(r8)
        L19:
            r4 = r0
            java.lang.Object r8 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r7 = r4.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L57
            goto L53
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            kotlin.ResultKt.throwOnFailure(r8)
            com.lagradost.cloudstream3.utils.ShortLink r8 = com.lagradost.cloudstream3.utils.UnshortenUrl.INSTANCE     // Catch: java.lang.Exception -> L57
            boolean r8 = r8.isShortLink(r7)     // Catch: java.lang.Exception -> L57
            if (r8 == 0) goto L5d
            com.lagradost.cloudstream3.utils.ShortLink r1 = com.lagradost.cloudstream3.utils.UnshortenUrl.INSTANCE     // Catch: java.lang.Exception -> L57
            r3 = 0
            r5 = 2
            r6 = 0
            r4.L$0 = r7     // Catch: java.lang.Exception -> L57
            r4.label = r2     // Catch: java.lang.Exception -> L57
            r2 = r7
            java.lang.Object r8 = com.lagradost.cloudstream3.utils.UnshortenUrl.unshorten$default(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L57
            if (r8 != r0) goto L53
            return r0
        L53:
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Exception -> L57
            r7 = r8
            goto L5d
        L57:
            r8 = move-exception
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            com.lagradost.cloudstream3.mvvm.ArchComponentExt.logError(r8)
        L5d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.ExtractorApiKt.unshortenLinkSafe(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object loadExtractor(String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super Boolean> continuation) {
        return loadExtractor(str, null, function1, function12, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object loadExtractor(java.lang.String r17, java.lang.String r18, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r19, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r20, kotlin.coroutines.Continuation<? super java.lang.Boolean> r21) {
        /*
            r0 = r21
            boolean r1 = r0 instanceof com.lagradost.cloudstream3.utils.ExtractorApiKt$loadExtractor$2
            if (r1 == 0) goto L16
            r1 = r0
            com.lagradost.cloudstream3.utils.ExtractorApiKt$loadExtractor$2 r1 = (com.lagradost.cloudstream3.utils.ExtractorApiKt$loadExtractor$2) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L16
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L1b
        L16:
            com.lagradost.cloudstream3.utils.ExtractorApiKt$loadExtractor$2 r1 = new com.lagradost.cloudstream3.utils.ExtractorApiKt$loadExtractor$2
            r1.<init>(r0)
        L1b:
            r7 = r1
            java.lang.Object r0 = r7.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            r3 = 2
            r8 = 1
            if (r2 == 0) goto L4f
            if (r2 == r8) goto L39
            if (r2 != r3) goto L31
            kotlin.ResultKt.throwOnFailure(r0)
            goto Lb2
        L31:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L39:
            java.lang.Object r2 = r7.L$2
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.Object r4 = r7.L$1
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r5 = r7.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r0)
            r6 = r2
            r16 = r5
            r5 = r4
            r4 = r16
            goto L6d
        L4f:
            kotlin.ResultKt.throwOnFailure(r0)
            r0 = r18
            r7.L$0 = r0
            r2 = r19
            r7.L$1 = r2
            r4 = r20
            r7.L$2 = r4
            r7.label = r8
            r5 = r17
            java.lang.Object r5 = unshortenLinkSafe(r5, r7)
            if (r5 != r1) goto L69
            return r1
        L69:
            r6 = r4
            r4 = r0
            r0 = r5
            r5 = r2
        L6d:
            java.lang.String r0 = (java.lang.String) r0
            java.util.Locale r2 = java.util.Locale.ROOT
            java.lang.String r2 = r0.toLowerCase(r2)
            java.lang.String r9 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r9)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            kotlin.text.Regex r9 = com.lagradost.cloudstream3.utils.ExtractorApiKt.schemaStripRegex
            java.lang.String r10 = ""
            java.lang.String r2 = r9.replace(r2, r10)
            com.lagradost.cloudstream3.utils.ExtractorApi[] r9 = com.lagradost.cloudstream3.utils.ExtractorApiKt.extractorApis
            int r11 = r9.length
            r12 = 0
            r13 = 0
        L89:
            if (r13 >= r11) goto Lbb
            r14 = r9[r13]
            java.lang.String r15 = r14.getMainUrl()
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            kotlin.text.Regex r8 = com.lagradost.cloudstream3.utils.ExtractorApiKt.schemaStripRegex
            java.lang.String r8 = r8.replace(r15, r10)
            r15 = 0
            boolean r8 = kotlin.text.StringsKt.startsWith$default(r2, r8, r12, r3, r15)
            if (r8 == 0) goto Lb7
            r7.L$0 = r15
            r7.L$1 = r15
            r7.L$2 = r15
            r7.label = r3
            r2 = r14
            r3 = r0
            java.lang.Object r0 = r2.getSafeUrl(r3, r4, r5, r6, r7)
            if (r0 != r1) goto Lb1
            return r1
        Lb1:
            r8 = 1
        Lb2:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r8)
            return r0
        Lb7:
            r8 = 1
            int r13 = r13 + 1
            goto L89
        Lbb:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.ExtractorApiKt.loadExtractor(java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object loadExtractor$default(String str, String str2, Function1 function1, Function1 function12, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return loadExtractor(str, str2, function1, function12, continuation);
    }

    public static final ExtractorApi[] getExtractorApis() {
        return extractorApis;
    }

    public static final ExtractorApi getExtractorApiFromName(String name) {
        ExtractorApi[] extractorApiArr;
        Intrinsics.checkNotNullParameter(name, "name");
        for (ExtractorApi extractorApi : extractorApis) {
            if (Intrinsics.areEqual(extractorApi.getName(), name)) {
                return extractorApi;
            }
        }
        return extractorApis[0];
    }

    public static final boolean requireReferer(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getExtractorApiFromName(name).getRequiresReferer();
    }

    public static final String httpsify(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (StringsKt.startsWith$default(url, "//", false, 2, (Object) null)) {
            return "https:" + url;
        }
        return url;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x018b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x018c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object getPostForm(java.lang.String r22, java.lang.String r23, kotlin.coroutines.Continuation<? super java.lang.String> r24) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.ExtractorApiKt.getPostForm(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
