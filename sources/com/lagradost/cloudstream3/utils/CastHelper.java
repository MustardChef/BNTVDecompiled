package com.lagradost.cloudstream3.utils;

import android.net.Uri;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.images.WebImage;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.p041ui.MetadataHolder;
import com.lagradost.cloudstream3.p041ui.player.SubtitleData;
import com.lagradost.cloudstream3.p041ui.result.ResultEpisode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: CastHelper.kt */
@Metadata(m108d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tJ6\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u007f\u0010\u0018\u001a\u00020\n*\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001f\u001a\u00020\u00122\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u00162\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%¢\u0006\u0002\u0010&¨\u0006'"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/CastHelper;", "", "()V", "awaitLinks", "", "pending", "Lcom/google/android/gms/common/api/PendingResult;", "Lcom/google/android/gms/cast/framework/media/RemoteMediaClient$MediaChannelResult;", "callback", "Lkotlin/Function1;", "", "getMediaInfo", "Lcom/google/android/gms/cast/MediaInfo;", "epData", "Lcom/lagradost/cloudstream3/ui/result/ResultEpisode;", "holder", "Lcom/lagradost/cloudstream3/ui/MetadataHolder;", FirebaseAnalytics.Param.INDEX, "", "data", "Lorg/json/JSONObject;", "subtitles", "", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "startCast", "Lcom/google/android/gms/cast/framework/CastSession;", "apiName", "", "isMovie", "title", "poster", "currentEpisodeIndex", "episodes", "currentLinks", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "startIndex", "startTime", "", "(Lcom/google/android/gms/cast/framework/CastSession;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Long;)Z", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class CastHelper {
    public static final CastHelper INSTANCE = new CastHelper();

    private CastHelper() {
    }

    public final MediaInfo getMediaInfo(ResultEpisode epData, MetadataHolder holder, int i, JSONObject jSONObject, List<SubtitleData> subtitles) {
        String sb;
        Intrinsics.checkNotNullParameter(epData, "epData");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(subtitles, "subtitles");
        ExtractorLink extractorLink = holder.getCurrentLinks().get(i);
        MediaMetadata mediaMetadata = new MediaMetadata(1);
        if (holder.isMovie()) {
            sb = extractorLink.getName() + ' ' + Qualities.Companion.getStringByInt(Integer.valueOf(extractorLink.getQuality()));
        } else {
            StringBuilder sb2 = new StringBuilder();
            String name = epData.getName();
            if (name == null) {
                name = "Episode " + epData.getEpisode();
            }
            sb2.append(name);
            sb2.append(" - ");
            sb2.append(extractorLink.getName());
            sb2.append(' ');
            sb2.append(Qualities.Companion.getStringByInt(Integer.valueOf(extractorLink.getQuality())));
            sb = sb2.toString();
        }
        mediaMetadata.putString(MediaMetadata.KEY_SUBTITLE, sb);
        String title = holder.getTitle();
        if (title != null) {
            mediaMetadata.putString(MediaMetadata.KEY_TITLE, title);
        }
        String poster = epData.getPoster();
        if (poster == null) {
            poster = holder.getPoster();
        }
        if (poster != null) {
            mediaMetadata.addImage(new WebImage(Uri.parse(poster)));
        }
        int i2 = 0;
        List<SubtitleData> list = subtitles;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (SubtitleData subtitleData : list) {
            arrayList.add(new MediaTrack.Builder(i2, 1).setName(subtitleData.getName()).setSubtype(1).setContentId(subtitleData.getUrl()).build());
            i2++;
        }
        MediaInfo.Builder mediaTracks = new MediaInfo.Builder(extractorLink.getUrl()).setStreamType(1).setContentType(extractorLink.isM3u8() ? MimeTypes.APPLICATION_M3U8 : MimeTypes.VIDEO_MP4).setMetadata(mediaMetadata).setMediaTracks(arrayList);
        if (jSONObject != null) {
            mediaTracks.setCustomData(jSONObject);
        }
        MediaInfo build = mediaTracks.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public final void awaitLinks(PendingResult<RemoteMediaClient.MediaChannelResult> pendingResult, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (pendingResult == null) {
            return;
        }
        Coroutines.INSTANCE.main(new CastHelper$awaitLinks$1(callback, pendingResult, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007a A[Catch: Exception -> 0x00c1, TryCatch #1 {Exception -> 0x00c1, blocks: (B:5:0x0022, B:8:0x0029, B:11:0x0030, B:13:0x0050, B:16:0x0057, B:18:0x005e, B:20:0x007a, B:22:0x0085, B:24:0x008c, B:26:0x009a), top: B:39:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean startCast(com.google.android.gms.cast.framework.CastSession r17, java.lang.String r18, boolean r19, java.lang.String r20, java.lang.String r21, int r22, java.util.List<com.lagradost.cloudstream3.p041ui.result.ResultEpisode> r23, java.util.List<? extends com.lagradost.cloudstream3.utils.ExtractorLink> r24, java.util.List<com.lagradost.cloudstream3.p041ui.player.SubtitleData> r25, java.lang.Integer r26, java.lang.Long r27) {
        /*
            r16 = this;
            r0 = r22
            r10 = r23
            java.lang.String r1 = "apiName"
            r11 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r1)
            java.lang.String r1 = "episodes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            java.lang.String r1 = "currentLinks"
            r12 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            java.lang.String r1 = "subtitles"
            r13 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r1)
            r14 = 0
            if (r17 != 0) goto L22
            return r14
        L22:
            boolean r1 = r23.isEmpty()     // Catch: java.lang.Exception -> Lc1
            if (r1 == 0) goto L29
            return r14
        L29:
            int r1 = r23.size()     // Catch: java.lang.Exception -> Lc1
            if (r0 < r1) goto L30
            return r14
        L30:
            java.lang.Object r1 = r10.get(r0)     // Catch: java.lang.Exception -> Lc1
            r15 = r1
            com.lagradost.cloudstream3.ui.result.ResultEpisode r15 = (com.lagradost.cloudstream3.p041ui.result.ResultEpisode) r15     // Catch: java.lang.Exception -> Lc1
            com.lagradost.cloudstream3.ui.MetadataHolder r9 = new com.lagradost.cloudstream3.ui.MetadataHolder     // Catch: java.lang.Exception -> Lc1
            r1 = r9
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r21
            r6 = r22
            r7 = r23
            r8 = r24
            r14 = r9
            r9 = r25
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> Lc1
            if (r26 == 0) goto L5d
            int r1 = r26.intValue()     // Catch: java.lang.Exception -> Lc1
            if (r1 >= 0) goto L57
            goto L5d
        L57:
            int r1 = r26.intValue()     // Catch: java.lang.Exception -> Lc1
            r8 = r1
            goto L5e
        L5d:
            r8 = 0
        L5e:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: java.lang.Exception -> Lc1
            com.lagradost.cloudstream3.utils.AppUtils r1 = com.lagradost.cloudstream3.utils.AppUtils.INSTANCE     // Catch: java.lang.Exception -> Lc1
            java.lang.String r1 = r1.toJson(r14)     // Catch: java.lang.Exception -> Lc1
            r6.<init>(r1)     // Catch: java.lang.Exception -> Lc1
            r2 = r16
            r3 = r15
            r4 = r14
            r5 = r8
            r7 = r25
            com.google.android.gms.cast.MediaInfo r1 = r2.getMediaInfo(r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> Lc1
            com.google.android.gms.cast.framework.media.RemoteMediaClient r2 = r17.getRemoteMediaClient()     // Catch: java.lang.Exception -> Lc1
            if (r2 == 0) goto L99
            com.google.android.gms.cast.MediaLoadRequestData$Builder r3 = new com.google.android.gms.cast.MediaLoadRequestData$Builder     // Catch: java.lang.Exception -> Lc1
            r3.<init>()     // Catch: java.lang.Exception -> Lc1
            com.google.android.gms.cast.MediaLoadRequestData$Builder r1 = r3.setMediaInfo(r1)     // Catch: java.lang.Exception -> Lc1
            if (r27 == 0) goto L8a
            long r3 = r27.longValue()     // Catch: java.lang.Exception -> Lc1
            goto L8c
        L8a:
            r3 = 0
        L8c:
            com.google.android.gms.cast.MediaLoadRequestData$Builder r1 = r1.setCurrentTime(r3)     // Catch: java.lang.Exception -> Lc1
            com.google.android.gms.cast.MediaLoadRequestData r1 = r1.build()     // Catch: java.lang.Exception -> Lc1
            com.google.android.gms.common.api.PendingResult r1 = r2.load(r1)     // Catch: java.lang.Exception -> Lc1
            goto L9a
        L99:
            r1 = 0
        L9a:
            r14 = r1
            com.lagradost.cloudstream3.utils.CastHelper$startCast$1 r15 = new com.lagradost.cloudstream3.utils.CastHelper$startCast$1     // Catch: java.lang.Exception -> Lc1
            r1 = r15
            r2 = r24
            r3 = r8
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r11 = r25
            r12 = r27
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Exception -> Lc1
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15     // Catch: java.lang.Exception -> Lc1
            r1 = r16
            r1.awaitLinks(r14, r15)     // Catch: java.lang.Exception -> Lbf
            r0 = 1
            return r0
        Lbf:
            r0 = move-exception
            goto Lc4
        Lc1:
            r0 = move-exception
            r1 = r16
        Lc4:
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            com.lagradost.cloudstream3.mvvm.ArchComponentExt.logError(r0)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.CastHelper.startCast(com.google.android.gms.cast.framework.CastSession, java.lang.String, boolean, java.lang.String, java.lang.String, int, java.util.List, java.util.List, java.util.List, java.lang.Integer, java.lang.Long):boolean");
    }
}
