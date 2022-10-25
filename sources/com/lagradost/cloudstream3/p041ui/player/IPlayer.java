package com.lagradost.cloudstream3.p041ui.player;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.p036ui.PlayerView;
import com.lagradost.cloudstream3.p041ui.subtitles.SaveCaptionStyle;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorUri;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Functions;

/* compiled from: IPlayer.kt */
@Metadata(m108d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u009e\u0002\u0010\u0011\u001a\u00020\u000e2\u0014\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u000e0\u00132\"\b\u0002\u0010\u0014\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00132\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00182\u001a\b\u0002\u0010\u0019\u001a\u0014\u0012\b\u0012\u00060\u001aj\u0002`\u001b\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00132\"\b\u0002\u0010\u001c\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u0015\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00132\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001f2\"\b\u0002\u0010 \u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0015\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00132\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00182\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00182\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00182\u001c\b\u0002\u0010$\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0013H&Jq\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00052\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030/2\b\u00100\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u00104J\b\u00105\u001a\u00020\u000eH&J\u0010\u00106\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'H&J\b\u00107\u001a\u00020\u000eH&J\b\u00108\u001a\u00020\u000eH&J\u0010\u00109\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'H&J\u0010\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u0005H&J\u0010\u0010<\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u0005H&J\u0016\u0010=\u001a\u00020\u000e2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030/H&J\u0010\u0010>\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\nH&J\u0012\u0010@\u001a\u00020\b2\b\u00100\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u0005H&J\u0010\u0010C\u001a\u00020\u000e2\u0006\u0010D\u001a\u00020EH&¨\u0006F"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/IPlayer;", "", "getCurrentPreferredSubtitle", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "getDuration", "", "()Ljava/lang/Long;", "getIsPlaying", "", "getPlaybackSpeed", "", "getPosition", "getSubtitleOffset", "handleEvent", "", "event", "Lcom/lagradost/cloudstream3/ui/player/CSPlayerEvent;", "initCallbacks", "playerUpdated", "Lkotlin/Function1;", "updateIsPlaying", "Lkotlin/Pair;", "Lcom/lagradost/cloudstream3/ui/player/CSPlayerLoading;", "requestAutoFocus", "Lkotlin/Function0;", "playerError", "Ljava/lang/Exception;", "Lkotlin/Exception;", "playerDimensionsLoaded", "", "requestedListeningPercentages", "", "playerPositionChanged", "nextEpisode", "prevEpisode", "subtitlesUpdates", "embeddedSubtitlesFetched", "loadPlayer", "context", "Landroid/content/Context;", "sameEpisode", "link", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "data", "Lcom/lagradost/cloudstream3/utils/ExtractorUri;", "startPosition", "subtitles", "", "subtitle", "playerView", "Lcom/google/android/exoplayer2/ui/PlayerView;", "autoPlay", "(Landroid/content/Context;ZLcom/lagradost/cloudstream3/utils/ExtractorLink;Lcom/lagradost/cloudstream3/utils/ExtractorUri;Ljava/lang/Long;Ljava/util/Set;Lcom/lagradost/cloudstream3/ui/player/SubtitleData;Lcom/google/android/exoplayer2/ui/PlayerView;Ljava/lang/Boolean;)V", "onPause", "onResume", "onStop", "release", "reloadPlayer", "seekTime", "time", "seekTo", "setActiveSubtitles", "setPlaybackSpeed", "speed", "setPreferredSubtitles", "setSubtitleOffset", TypedValues.CycleType.S_WAVE_OFFSET, "updateSubtitleStyle", "style", "Lcom/lagradost/cloudstream3/ui/subtitles/SaveCaptionStyle;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.IPlayer */
/* loaded from: classes3.dex */
public interface IPlayer {
    SubtitleData getCurrentPreferredSubtitle();

    Long getDuration();

    boolean getIsPlaying();

    float getPlaybackSpeed();

    Long getPosition();

    long getSubtitleOffset();

    void handleEvent(CSPlayerEvent cSPlayerEvent);

    void initCallbacks(Function1<Object, Unit> function1, Function1<? super Tuples<? extends CSPlayerLoading, ? extends CSPlayerLoading>, Unit> function12, Functions<Unit> functions, Function1<? super Exception, Unit> function13, Function1<? super Tuples<Integer, Integer>, Unit> function14, List<Integer> list, Function1<? super Tuples<Long, Long>, Unit> function15, Functions<Unit> functions2, Functions<Unit> functions3, Functions<Unit> functions4, Function1<? super List<SubtitleData>, Unit> function16);

    void loadPlayer(Context context, boolean z, ExtractorLink extractorLink, ExtractorUri extractorUri, Long l, Set<SubtitleData> set, SubtitleData subtitleData, PlayerView playerView, Boolean bool);

    void onPause();

    void onResume(Context context);

    void onStop();

    void release();

    void reloadPlayer(Context context);

    void seekTime(long j);

    void seekTo(long j);

    void setActiveSubtitles(Set<SubtitleData> set);

    void setPlaybackSpeed(float f);

    boolean setPreferredSubtitles(SubtitleData subtitleData);

    void setSubtitleOffset(long j);

    void updateSubtitleStyle(SaveCaptionStyle saveCaptionStyle);

    /* compiled from: IPlayer.kt */
    @Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.player.IPlayer$DefaultImpls */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void initCallbacks$default(IPlayer iPlayer, Function1 function1, Function1 function12, Functions functions, Function1 function13, Function1 function14, List list, Function1 function15, Functions functions2, Functions functions3, Functions functions4, Function1 function16, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initCallbacks");
            }
            iPlayer.initCallbacks(function1, (i & 2) != 0 ? null : function12, (i & 4) != 0 ? null : functions, (i & 8) != 0 ? null : function13, (i & 16) != 0 ? null : function14, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : function15, (i & 128) != 0 ? null : functions2, (i & 256) != 0 ? null : functions3, (i & 512) != 0 ? null : functions4, (i & 1024) == 0 ? function16 : null);
        }

        public static /* synthetic */ void loadPlayer$default(IPlayer iPlayer, Context context, boolean z, ExtractorLink extractorLink, ExtractorUri extractorUri, Long l, Set set, SubtitleData subtitleData, PlayerView playerView, Boolean bool, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadPlayer");
            }
            iPlayer.loadPlayer(context, z, (i & 4) != 0 ? null : extractorLink, (i & 8) != 0 ? null : extractorUri, (i & 16) != 0 ? null : l, set, subtitleData, (i & 128) != 0 ? null : playerView, (i & 256) != 0 ? true : bool);
        }
    }
}
