package com.lagradost.cloudstream3.p041ui.player;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import at.huber.youtubeExtractor.VideoMeta;
import at.huber.youtubeExtractor.YouTubeExtractor;
import at.huber.youtubeExtractor.YtFile;
import com.anggrayudi.storage.file.MimeType;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.android.exoplayer2.database.StandaloneDatabaseProvider;
import com.google.android.exoplayer2.ext.ima.ImaAdsLoader;
import com.google.android.exoplayer2.ext.okhttp.OkHttpDataSource;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.p036ui.PlayerView;
import com.google.android.exoplayer2.p036ui.SubtitleView;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MergingMediaSource;
import com.google.android.exoplayer2.source.SingleSampleMediaSource;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor;
import com.google.android.exoplayer2.upstream.cache.SimpleCache;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.p041ui.player.CS3IPlayer;
import com.lagradost.cloudstream3.p041ui.subtitles.SaveCaptionStyle;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorUri;
import com.lagradost.cloudstream3.utils.Qualities;
import com.phimhd.AppController;
import com.phimhd.Config;
import com.phimhd.ConfigHomeKt;
import com.phimhd.Key;
import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;

/* compiled from: CS3IPlayer.kt */
@Metadata(m108d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 \u008d\u00012\u00020\u0001:\u0002\u008d\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010I\u001a\u0004\u0018\u00010\u0011H\u0016J\u000f\u0010J\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010KJ\b\u0010L\u001a\u00020!H\u0016J\b\u0010M\u001a\u00020,H\u0016J\u000f\u0010N\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010KJ<\u0010O\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020P0\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001a0\u001f2\b\u0010Q\u001a\u0004\u0018\u00010R2\b\u0010S\u001a\u0004\u0018\u00010R2\u0006\u0010T\u001a\u00020BH\u0002J\b\u0010U\u001a\u00020\u0004H\u0016J\u0010\u0010V\u001a\u00020\u001b2\u0006\u0010W\u001a\u00020XH\u0016J\u008a\u0002\u0010Y\u001a\u00020\u001b2\u0014\u00106\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000107\u0012\u0004\u0012\u00020\u001b0\u00192 \u0010D\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020E0\u001f\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00192\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010.2\u0018\u00102\u001a\u0014\u0012\b\u0012\u000603j\u0002`4\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00192 \u00101\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u001f\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00192\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001a2 \u00105\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001f\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00192\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010.2\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010.2\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010.2\u001a\u0010\u0018\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0019H\u0016J$\u0010Z\u001a\u00020\u001b2\b\u0010[\u001a\u0004\u0018\u00010\\2\b\u0010]\u001a\u0004\u0018\u00010^2\b\u0010_\u001a\u0004\u0018\u00010`J2\u0010a\u001a\u00020\u001b2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020e2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020P0\u001a2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010hH\u0002J\u0018\u0010i\u001a\u00020\u001b2\u0006\u0010b\u001a\u00020c2\u0006\u0010j\u001a\u00020\nH\u0002J\u0018\u0010k\u001a\u00020\u001b2\u0006\u0010b\u001a\u00020c2\u0006\u0010l\u001a\u00020\fH\u0002Jg\u0010m\u001a\u00020\u001b2\u0006\u0010b\u001a\u00020c2\u0006\u0010n\u001a\u00020!2\b\u0010l\u001a\u0004\u0018\u00010\f2\b\u0010j\u001a\u0004\u0018\u00010\n2\b\u0010o\u001a\u0004\u0018\u00010\u00042\f\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00110q2\b\u0010r\u001a\u0004\u0018\u00010\u00112\b\u00108\u001a\u0004\u0018\u0001092\b\u0010s\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0002\u0010tJ\u0016\u0010u\u001a\u00020\u001b2\u0006\u0010b\u001a\u00020c2\u0006\u0010v\u001a\u00020wJ\b\u0010x\u001a\u00020\u001bH\u0016J\u0006\u0010y\u001a\u00020\u001bJ\u0010\u0010z\u001a\u00020\u001b2\u0006\u0010b\u001a\u00020cH\u0016J\b\u0010{\u001a\u00020\u001bH\u0016J\b\u0010|\u001a\u00020\u001bH\u0016J\u0012\u0010}\u001a\u00020\u001b2\b\b\u0002\u0010~\u001a\u00020!H\u0002J\u0010\u0010\u007f\u001a\u00020\u001b2\u0006\u0010b\u001a\u00020cH\u0016J\t\u0010\u0080\u0001\u001a\u00020\u001bH\u0002J\t\u0010\u0081\u0001\u001a\u00020\u001bH\u0002J\u0012\u0010\u0082\u0001\u001a\u00020\u001b2\u0007\u0010\u0083\u0001\u001a\u00020\u0004H\u0016J\u0012\u0010\u0084\u0001\u001a\u00020\u001b2\u0007\u0010\u0083\u0001\u001a\u00020\u0004H\u0016J\u0017\u0010\u0085\u0001\u001a\u00020\u001b2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00110qH\u0016J\u0012\u0010\u0086\u0001\u001a\u00020\u001b2\u0007\u0010\u0087\u0001\u001a\u00020,H\u0016J\u0013\u0010\u0088\u0001\u001a\u00020!2\b\u0010r\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0089\u0001\u001a\u00020\u001b2\u0007\u0010\u008a\u0001\u001a\u00020\u0004H\u0016J\u0011\u0010\u008b\u0001\u001a\u00020\u001b2\u0006\u0010_\u001a\u00020`H\u0016J\u0007\u0010\u008c\u0001\u001a\u00020\u001bJ\u0016\u0010\u0082\u0001\u001a\u00020\u001b*\u00020\u001d2\u0007\u0010\u0083\u0001\u001a\u00020\u0004H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010-\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R(\u00101\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u001f\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R \u00102\u001a\u0014\u0012\b\u0012\u000603j\u0002`4\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R(\u00105\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001f\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00106\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u000107\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010:\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010;\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010>\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0006\"\u0004\b@\u0010\bR\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010C\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010D\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020E0\u001f\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0006\"\u0004\bH\u0010\b¨\u0006\u008e\u0001"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/CS3IPlayer;", "Lcom/lagradost/cloudstream3/ui/player/IPlayer;", "()V", "cacheSize", "", "getCacheSize", "()J", "setCacheSize", "(J)V", "currentDownloadedFile", "Lcom/lagradost/cloudstream3/utils/ExtractorUri;", "currentLink", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "currentSubtitleOffset", "getCurrentSubtitleOffset", "setCurrentSubtitleOffset", "currentSubtitles", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "getCurrentSubtitles", "()Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "setCurrentSubtitles", "(Lcom/lagradost/cloudstream3/ui/player/SubtitleData;)V", "currentWindow", "", "embeddedSubtitlesFetched", "Lkotlin/Function1;", "", "", "exoPlayer", "Lcom/google/android/exoplayer2/ExoPlayer;", "exoPlayerSelectedTracks", "Lkotlin/Pair;", "", "", "hasUsedFirstRender", "ignoreSSL", "imaAdsLoader", "Lcom/google/android/exoplayer2/ext/ima/ImaAdsLoader;", "getImaAdsLoader", "()Lcom/google/android/exoplayer2/ext/ima/ImaAdsLoader;", "setImaAdsLoader", "(Lcom/google/android/exoplayer2/ext/ima/ImaAdsLoader;)V", "isPlaying", "lastMuteVolume", "", "nextEpisode", "Lkotlin/Function0;", "playBackSpeed", "playbackPosition", "playerDimensionsLoaded", "playerError", "Ljava/lang/Exception;", "Lkotlin/Exception;", "playerPositionChanged", "playerUpdated", "", "playerView", "Lcom/google/android/exoplayer2/ui/PlayerView;", "prevEpisode", "requestAutoFocus", "requestedListeningPercentages", "seekActionTime", "simpleCacheSize", "getSimpleCacheSize", "setSimpleCacheSize", "subtitleHelper", "Lcom/lagradost/cloudstream3/ui/player/PlayerSubtitleHelper;", "subtitlesUpdates", "updateIsPlaying", "Lcom/lagradost/cloudstream3/ui/player/CSPlayerLoading;", "videoBufferMs", "getVideoBufferMs", "setVideoBufferMs", "getCurrentPreferredSubtitle", "getDuration", "()Ljava/lang/Long;", "getIsPlaying", "getPlaybackSpeed", "getPosition", "getSubSources", "Lcom/google/android/exoplayer2/source/SingleSampleMediaSource;", "onlineSourceFactory", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "offlineSourceFactory", "subHelper", "getSubtitleOffset", "handleEvent", "event", "Lcom/lagradost/cloudstream3/ui/player/CSPlayerEvent;", "initCallbacks", "initSubtitles", "subView", "Lcom/google/android/exoplayer2/ui/SubtitleView;", "subHolder", "Landroid/widget/FrameLayout;", "style", "Lcom/lagradost/cloudstream3/ui/subtitles/SaveCaptionStyle;", "loadExo", "context", "Landroid/content/Context;", "mediaItem", "Lcom/google/android/exoplayer2/MediaItem;", "subSources", "cacheFactory", "Lcom/google/android/exoplayer2/upstream/cache/CacheDataSource$Factory;", "loadOfflinePlayer", "data", "loadOnlinePlayer", "link", "loadPlayer", "sameEpisode", "startPosition", "subtitles", "", "subtitle", "autoPlay", "(Landroid/content/Context;ZLcom/lagradost/cloudstream3/utils/ExtractorLink;Lcom/lagradost/cloudstream3/utils/ExtractorUri;Ljava/lang/Long;Ljava/util/Set;Lcom/lagradost/cloudstream3/ui/player/SubtitleData;Lcom/google/android/exoplayer2/ui/PlayerView;Ljava/lang/Boolean;)V", "loadYtFile", "yt", "Lat/huber/youtubeExtractor/YtFile;", "onPause", "onRenderFirst", "onResume", "onStop", "release", "releasePlayer", "saveTime", "reloadPlayer", "reloadSubs", "saveData", "seekTime", "time", "seekTo", "setActiveSubtitles", "setPlaybackSpeed", "speed", "setPreferredSubtitles", "setSubtitleOffset", TypedValues.CycleType.S_WAVE_OFFSET, "updateSubtitleStyle", "updatedTime", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.CS3IPlayer */
/* loaded from: classes3.dex */
public final class CS3IPlayer implements IPlayer {
    private static CustomTextRenderer currentTextRenderer;
    private static Functions<Unit> requestSubtitleUpdate;
    private static SimpleCache simpleCache;
    private long cacheSize;
    private ExtractorUri currentDownloadedFile;
    private ExtractorLink currentLink;
    private long currentSubtitleOffset;
    private SubtitleData currentSubtitles;
    private int currentWindow;
    private Function1<? super List<SubtitleData>, Unit> embeddedSubtitlesFetched;
    private ExoPlayer exoPlayer;
    private boolean hasUsedFirstRender;
    private ImaAdsLoader imaAdsLoader;
    private boolean isPlaying;
    private Functions<Unit> nextEpisode;
    private long playbackPosition;
    private Function1<? super Tuples<Integer, Integer>, Unit> playerDimensionsLoaded;
    private Function1<? super Exception, Unit> playerError;
    private Function1<? super Tuples<Long, Long>, Unit> playerPositionChanged;
    private Function1<Object, Unit> playerUpdated;
    private PlayerView playerView;
    private Functions<Unit> prevEpisode;
    private Functions<Unit> requestAutoFocus;
    private List<Integer> requestedListeningPercentages;
    private long simpleCacheSize;
    private Functions<Unit> subtitlesUpdates;
    private Function1<? super Tuples<? extends CSPlayerLoading, ? extends CSPlayerLoading>, Unit> updateIsPlaying;
    private long videoBufferMs;
    public static final Companion Companion = new Companion(null);
    private static Map<String, YtFile> ytVideos = new LinkedHashMap();
    private final long seekActionTime = 30000;
    private boolean ignoreSSL = true;
    private float playBackSpeed = 1.0f;
    private float lastMuteVolume = 1.0f;
    private final PlayerSubtitleHelper subtitleHelper = new PlayerSubtitleHelper();
    private List<Tuples<String, Boolean>> exoPlayerSelectedTracks = CollectionsKt.emptyList();

    /* compiled from: CS3IPlayer.kt */
    @Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.player.CS3IPlayer$WhenMappings */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[SubtitleStatus.values().length];
            iArr[SubtitleStatus.REQUIRES_RELOAD.ordinal()] = 1;
            iArr[SubtitleStatus.IS_ACTIVE.ordinal()] = 2;
            iArr[SubtitleStatus.NOT_FOUND.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CSPlayerEvent.values().length];
            iArr2[CSPlayerEvent.Play.ordinal()] = 1;
            iArr2[CSPlayerEvent.Pause.ordinal()] = 2;
            iArr2[CSPlayerEvent.ToggleMute.ordinal()] = 3;
            iArr2[CSPlayerEvent.PlayPauseToggle.ordinal()] = 4;
            iArr2[CSPlayerEvent.SeekForward.ordinal()] = 5;
            iArr2[CSPlayerEvent.SeekBack.ordinal()] = 6;
            iArr2[CSPlayerEvent.NextEpisode.ordinal()] = 7;
            iArr2[CSPlayerEvent.PrevEpisode.ordinal()] = 8;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[SubtitleOrigin.values().length];
            iArr3[SubtitleOrigin.DOWNLOADED_FILE.ordinal()] = 1;
            iArr3[SubtitleOrigin.URL.ordinal()] = 2;
            iArr3[SubtitleOrigin.EMBEDDED_IN_VIDEO.ordinal()] = 3;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadOnlinePlayer$lambda-16  reason: not valid java name */
    public static final boolean m8663loadOnlinePlayer$lambda16(String str, SSLSession sSLSession) {
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(sSLSession, "<anonymous parameter 1>");
        return true;
    }

    public final long getCacheSize() {
        return this.cacheSize;
    }

    public final void setCacheSize(long j) {
        this.cacheSize = j;
    }

    public final long getSimpleCacheSize() {
        return this.simpleCacheSize;
    }

    public final void setSimpleCacheSize(long j) {
        this.simpleCacheSize = j;
    }

    public final long getVideoBufferMs() {
        return this.videoBufferMs;
    }

    public final void setVideoBufferMs(long j) {
        this.videoBufferMs = j;
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IPlayer
    public Long getDuration() {
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            return Long.valueOf(exoPlayer.getDuration());
        }
        return null;
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IPlayer
    public Long getPosition() {
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            return Long.valueOf(exoPlayer.getCurrentPosition());
        }
        return null;
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IPlayer
    public boolean getIsPlaying() {
        return this.isPlaying;
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IPlayer
    public float getPlaybackSpeed() {
        return this.playBackSpeed;
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IPlayer
    public void initCallbacks(Function1<Object, Unit> playerUpdated, Function1<? super Tuples<? extends CSPlayerLoading, ? extends CSPlayerLoading>, Unit> function1, Functions<Unit> functions, Function1<? super Exception, Unit> function12, Function1<? super Tuples<Integer, Integer>, Unit> function13, List<Integer> list, Function1<? super Tuples<Long, Long>, Unit> function14, Functions<Unit> functions2, Functions<Unit> functions3, Functions<Unit> functions4, Function1<? super List<SubtitleData>, Unit> function15) {
        Intrinsics.checkNotNullParameter(playerUpdated, "playerUpdated");
        this.playerUpdated = playerUpdated;
        this.updateIsPlaying = function1;
        this.requestAutoFocus = functions;
        this.playerError = function12;
        this.playerDimensionsLoaded = function13;
        this.requestedListeningPercentages = list;
        this.playerPositionChanged = function14;
        this.nextEpisode = functions2;
        this.prevEpisode = functions3;
        this.subtitlesUpdates = functions4;
        this.embeddedSubtitlesFetched = function15;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reloadSubs() {
        Looper applicationLooper;
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer == null || (applicationLooper = exoPlayer.getApplicationLooper()) == null) {
            return;
        }
        try {
            Boolean.valueOf(new Handler(applicationLooper).post(new Runnable() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$CS3IPlayer$SUYYF7Jq7e7MKCwC5W4mJgApBFE
                @Override // java.lang.Runnable
                public final void run() {
                    CS3IPlayer.m8665reloadSubs$lambda1$lambda0(CS3IPlayer.this);
                }
            }));
        } catch (Exception e) {
            ArchComponentExt.logError(e);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: reloadSubs$lambda-1$lambda-0  reason: not valid java name */
    public static final void m8665reloadSubs$lambda1$lambda0(CS3IPlayer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.seekTime(1L);
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }

    public final void initSubtitles(SubtitleView subtitleView, FrameLayout frameLayout, SaveCaptionStyle saveCaptionStyle) {
        this.subtitleHelper.initSubtitles(subtitleView, frameLayout, saveCaptionStyle);
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IPlayer
    public void loadPlayer(Context context, boolean z, ExtractorLink extractorLink, ExtractorUri extractorUri, Long l, Set<SubtitleData> subtitles, SubtitleData subtitleData, PlayerView playerView, Boolean bool) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(subtitles, "subtitles");
        Log.i(CS3IPlayerKt.TAG, "loadPlayer");
        this.playerView = playerView;
        if (z) {
            saveData();
        } else {
            this.currentSubtitles = subtitleData;
            this.playbackPosition = 0L;
        }
        if (l != null) {
            this.playbackPosition = l.longValue();
        }
        this.isPlaying = bool != null ? bool.booleanValue() : this.isPlaying;
        releasePlayer$default(this, false, 1, null);
        if (extractorLink != null) {
            loadOnlinePlayer(context, extractorLink);
        } else if (extractorUri != null) {
            loadOfflinePlayer(context, extractorUri);
        }
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IPlayer
    public void setActiveSubtitles(Set<SubtitleData> subtitles) {
        Intrinsics.checkNotNullParameter(subtitles, "subtitles");
        Log.i(CS3IPlayerKt.TAG, "setActiveSubtitles " + subtitles.size());
        this.subtitleHelper.setAllSubtitles(subtitles);
    }

    public final SubtitleData getCurrentSubtitles() {
        return this.currentSubtitles;
    }

    public final void setCurrentSubtitles(SubtitleData subtitleData) {
        this.currentSubtitles = subtitleData;
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IPlayer
    public boolean setPreferredSubtitles(SubtitleData subtitleData) {
        Log.i(CS3IPlayerKt.TAG, "setPreferredSubtitles init " + subtitleData);
        this.currentSubtitles = subtitleData;
        ExoPlayer exoPlayer = this.exoPlayer;
        TrackSelector trackSelector = exoPlayer != null ? exoPlayer.getTrackSelector() : null;
        DefaultTrackSelector defaultTrackSelector = trackSelector instanceof DefaultTrackSelector ? (DefaultTrackSelector) trackSelector : null;
        if (defaultTrackSelector != null) {
            String name = subtitleData != null ? subtitleData.getName() : null;
            String str = name;
            if (str == null || StringsKt.isBlank(str)) {
                defaultTrackSelector.setParameters(defaultTrackSelector.buildUponParameters().setPreferredTextLanguage((String) null));
            } else {
                int i = WhenMappings.$EnumSwitchMapping$0[this.subtitleHelper.subtitleStatus(subtitleData).ordinal()];
                if (i == 1) {
                    Log.i(CS3IPlayerKt.TAG, "setPreferredSubtitles REQUIRES_RELOAD");
                    return true;
                } else if (i == 2) {
                    Log.i(CS3IPlayerKt.TAG, "setPreferredSubtitles IS_ACTIVE");
                    DefaultTrackSelector.ParametersBuilder buildUponParameters = defaultTrackSelector.buildUponParameters();
                    if (subtitleData.getOrigin() == SubtitleOrigin.EMBEDDED_IN_VIDEO) {
                        buildUponParameters.setPreferredTextLanguage(subtitleData.getUrl());
                    } else {
                        buildUponParameters.setPreferredTextLanguage('_' + name);
                    }
                    defaultTrackSelector.setParameters(buildUponParameters);
                } else if (i == 3) {
                    Log.i(CS3IPlayerKt.TAG, "setPreferredSubtitles NOT_FOUND");
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final long getCurrentSubtitleOffset() {
        return this.currentSubtitleOffset;
    }

    public final void setCurrentSubtitleOffset(long j) {
        this.currentSubtitleOffset = j;
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IPlayer
    public void setSubtitleOffset(long j) {
        this.currentSubtitleOffset = j;
        CustomTextRenderer customTextRenderer = currentTextRenderer;
        if (customTextRenderer != null) {
            customTextRenderer.setRenderOffsetMs(j);
        }
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IPlayer
    public long getSubtitleOffset() {
        return this.currentSubtitleOffset;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0084, code lost:
        continue;
     */
    @Override // com.lagradost.cloudstream3.p041ui.player.IPlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.lagradost.cloudstream3.p041ui.player.SubtitleData getCurrentPreferredSubtitle() {
        /*
            r15 = this;
            com.lagradost.cloudstream3.ui.player.PlayerSubtitleHelper r0 = r15.subtitleHelper
            java.util.Set r0 = r0.getAllSubtitles()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        Lc:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L87
            java.lang.Object r1 = r0.next()
            r2 = r1
            com.lagradost.cloudstream3.ui.player.SubtitleData r2 = (com.lagradost.cloudstream3.p041ui.player.SubtitleData) r2
            java.util.List<kotlin.Pair<java.lang.String, java.lang.Boolean>> r3 = r15.exoPlayerSelectedTracks
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            boolean r4 = r3 instanceof java.util.Collection
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L2e
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L2e
        L2c:
            r5 = 0
            goto L84
        L2e:
            java.util.Iterator r3 = r3.iterator()
        L32:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L2c
            java.lang.Object r4 = r3.next()
            kotlin.Pair r4 = (kotlin.Tuples) r4
            com.lagradost.cloudstream3.ui.player.SubtitleOrigin r7 = r2.getOrigin()
            com.lagradost.cloudstream3.ui.player.SubtitleOrigin r8 = com.lagradost.cloudstream3.p041ui.player.SubtitleOrigin.EMBEDDED_IN_VIDEO
            if (r7 != r8) goto L4b
            java.lang.String r7 = r2.getUrl()
            goto L4f
        L4b:
            java.lang.String r7 = r2.getName()
        L4f:
            r8 = r7
            java.lang.Object r7 = r4.getSecond()
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L81
            java.lang.Object r4 = r4.getFirst()
            r9 = r4
            java.lang.String r9 = (java.lang.String) r9
            r12 = 0
            r13 = 4
            r14 = 0
            java.lang.String r10 = "-"
            java.lang.String r11 = ""
            java.lang.String r4 = kotlin.text.StringsKt.replace$default(r9, r10, r11, r12, r13, r14)
            r11 = 0
            r12 = 4
            r13 = 0
            java.lang.String r9 = "-"
            java.lang.String r10 = ""
            java.lang.String r7 = kotlin.text.StringsKt.replace$default(r8, r9, r10, r11, r12, r13)
            boolean r4 = kotlin.text.StringsKt.equals(r4, r7, r5)
            if (r4 == 0) goto L81
            r4 = 1
            goto L82
        L81:
            r4 = 0
        L82:
            if (r4 == 0) goto L32
        L84:
            if (r5 == 0) goto Lc
            goto L88
        L87:
            r1 = 0
        L88:
            com.lagradost.cloudstream3.ui.player.SubtitleData r1 = (com.lagradost.cloudstream3.p041ui.player.SubtitleData) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.player.CS3IPlayer.getCurrentPreferredSubtitle():com.lagradost.cloudstream3.ui.player.SubtitleData");
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IPlayer
    public void updateSubtitleStyle(SaveCaptionStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.subtitleHelper.setSubStyle(style);
    }

    private final void saveData() {
        Log.i(CS3IPlayerKt.TAG, "saveData");
        updatedTime();
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            this.playbackPosition = exoPlayer.getCurrentPosition();
            this.currentWindow = exoPlayer.getCurrentWindowIndex();
            this.isPlaying = exoPlayer.isPlaying();
        }
    }

    static /* synthetic */ void releasePlayer$default(CS3IPlayer cS3IPlayer, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        cS3IPlayer.releasePlayer(z);
    }

    private final void releasePlayer(boolean z) {
        Log.i(CS3IPlayerKt.TAG, "releasePlayer");
        if (z) {
            updatedTime();
        }
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            exoPlayer.release();
        }
        currentTextRenderer = null;
        this.exoPlayer = null;
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IPlayer
    public void onStop() {
        Log.i(CS3IPlayerKt.TAG, "onStop");
        saveData();
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            exoPlayer.pause();
        }
        releasePlayer$default(this, false, 1, null);
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IPlayer
    public void onPause() {
        Log.i(CS3IPlayerKt.TAG, "onPause");
        saveData();
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            exoPlayer.pause();
        }
        releasePlayer$default(this, false, 1, null);
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IPlayer
    public void onResume(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.exoPlayer == null) {
            reloadPlayer(context);
        }
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IPlayer
    public void release() {
        releasePlayer$default(this, false, 1, null);
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IPlayer
    public void setPlaybackSpeed(float f) {
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            exoPlayer.setPlaybackSpeed(f);
        }
        this.playBackSpeed = f;
    }

    /* compiled from: CS3IPlayer.kt */
    @Metadata(m108d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u008e\u0001\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\"2\b\b\u0002\u0010(\u001a\u00020)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u000101H\u0002J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002J\u001a\u00106\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\"H\u0002J\u0018\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u00142\u0006\u00109\u001a\u00020:H\u0002J)\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u00142\n\b\u0002\u0010<\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020?2\u0006\u00108\u001a\u00020\u0014H\u0002J\u0010\u0010@\u001a\u00020-2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\f\u0010A\u001a\u000203*\u00020\u0019H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/CS3IPlayer$Companion;", "", "()V", "currentTextRenderer", "Lcom/lagradost/cloudstream3/ui/player/CustomTextRenderer;", "getCurrentTextRenderer", "()Lcom/lagradost/cloudstream3/ui/player/CustomTextRenderer;", "setCurrentTextRenderer", "(Lcom/lagradost/cloudstream3/ui/player/CustomTextRenderer;)V", "requestSubtitleUpdate", "Lkotlin/Function0;", "", "getRequestSubtitleUpdate", "()Lkotlin/jvm/functions/Function0;", "setRequestSubtitleUpdate", "(Lkotlin/jvm/functions/Function0;)V", "simpleCache", "Lcom/google/android/exoplayer2/upstream/cache/SimpleCache;", "ytVideos", "", "", "Lat/huber/youtubeExtractor/YtFile;", "buildExoPlayer", "Lcom/google/android/exoplayer2/ExoPlayer;", "context", "Landroid/content/Context;", "mediaItem", "Lcom/google/android/exoplayer2/MediaItem;", "subSources", "", "Lcom/google/android/exoplayer2/source/SingleSampleMediaSource;", "currentWindow", "", "playbackPosition", "", "playBackSpeed", "", "subtitleOffset", "cacheSize", "videoBufferMs", "playWhenReady", "", "cacheFactory", "Lcom/google/android/exoplayer2/upstream/cache/CacheDataSource$Factory;", "trackSelector", "Lcom/google/android/exoplayer2/trackselection/TrackSelector;", "playerView", "Lcom/google/android/exoplayer2/ui/PlayerView;", "imaAdsLoader", "Lcom/google/android/exoplayer2/ext/ima/ImaAdsLoader;", "createOnlineSource", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "link", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "getCache", "getMediaItem", "mimeType", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "url", "isLiveStream", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/google/android/exoplayer2/MediaItem;", "getMediaItemBuilder", "Lcom/google/android/exoplayer2/MediaItem$Builder;", "getTrackSelector", "createOfflineSource", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.player.CS3IPlayer$Companion */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Functions<Unit> getRequestSubtitleUpdate() {
            return CS3IPlayer.requestSubtitleUpdate;
        }

        public final void setRequestSubtitleUpdate(Functions<Unit> functions) {
            CS3IPlayer.requestSubtitleUpdate = functions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DataSource.Factory createOnlineSource(ExtractorLink extractorLink) {
            OkHttpDataSource.Factory factory;
            Interceptor videoInterceptor = APIHolder.INSTANCE.getApiFromName(extractorLink.getSource()).getVideoInterceptor(extractorLink);
            if (videoInterceptor == null) {
                DefaultHttpDataSource.Factory allowCrossProtocolRedirects = new DefaultHttpDataSource.Factory().setUserAgent(MainAPIKt.USER_AGENT).setAllowCrossProtocolRedirects(true);
                Intrinsics.checkNotNullExpressionValue(allowCrossProtocolRedirects, "{\n                Defaul…yer-android\n            }");
                factory = allowCrossProtocolRedirects;
            } else {
                OkHttpDataSource.Factory userAgent = new OkHttpDataSource.Factory(MainActivityKt.getApp().getBaseClient().newBuilder().addInterceptor(videoInterceptor).build()).setUserAgent(MainAPIKt.USER_AGENT);
                Intrinsics.checkNotNullExpressionValue(userAgent, "{\n                val cl…USER_AGENT)\n            }");
                factory = userAgent;
            }
            factory.setDefaultRequestProperties(MapsKt.plus(MapsKt.mapOf(TuplesKt.m100to("referer", extractorLink.getReferer()), TuplesKt.m100to("accept", MimeType.UNKNOWN), TuplesKt.m100to("sec-ch-ua", "\"Chromium\";v=\"91\", \" Not;A Brand\";v=\"99\""), TuplesKt.m100to("sec-ch-ua-mobile", "?0"), TuplesKt.m100to("sec-fetch-user", "?1"), TuplesKt.m100to("sec-fetch-mode", "navigate"), TuplesKt.m100to("sec-fetch-dest", "video")), extractorLink.getHeaders()));
            return factory;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DataSource.Factory createOfflineSource(Context context) {
            return new DefaultDataSourceFactory(context, MainAPIKt.USER_AGENT);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final SimpleCache getCache(Context context, long j) {
            try {
                StandaloneDatabaseProvider standaloneDatabaseProvider = new StandaloneDatabaseProvider(context);
                File file = new File(context.getCacheDir(), "exoplayer");
                file.deleteOnExit();
                return new SimpleCache(file, new LeastRecentlyUsedCacheEvictor(j), standaloneDatabaseProvider);
            } catch (Exception e) {
                ArchComponentExt.logError(e);
                return null;
            }
        }

        private final MediaItem.Builder getMediaItemBuilder(String str) {
            MediaItem.Builder mimeType;
            Config config;
            Config config2;
            Config config3;
            AppController companion = AppController.Companion.getInstance();
            String str2 = null;
            if ((companion != null ? companion.getKey() : null) != null) {
                AppController companion2 = AppController.Companion.getInstance();
                Key key = companion2 != null ? companion2.getKey() : null;
                Intrinsics.checkNotNull(key);
                if (!key.isExpired()) {
                    mimeType = new MediaItem.Builder().setMimeType(str);
                    Intrinsics.checkNotNullExpressionValue(mimeType, "if(AppController.instanc…      }\n                }");
                    return mimeType;
                }
            }
            AppController companion3 = AppController.Companion.getInstance();
            boolean z = false;
            if (companion3 != null && !companion3.getVastAdded()) {
                z = true;
            }
            if (z) {
                AppController companion4 = AppController.Companion.getInstance();
                if (((companion4 == null || (config3 = companion4.getConfig()) == null) ? null : config3.getVast()) != null) {
                    AppController companion5 = AppController.Companion.getInstance();
                    if (companion5 != null) {
                        companion5.setVastAdded(true);
                    }
                    MediaItem.Builder mimeType2 = new MediaItem.Builder().setMimeType(str);
                    AppController companion6 = AppController.Companion.getInstance();
                    MediaItem.AdsConfiguration.Builder builder = new MediaItem.AdsConfiguration.Builder(Uri.parse((companion6 == null || (config2 = companion6.getConfig()) == null) ? null : config2.getVast()));
                    AppController companion7 = AppController.Companion.getInstance();
                    if (companion7 != null && (config = companion7.getConfig()) != null) {
                        str2 = config.getVast();
                    }
                    mimeType = mimeType2.setAdsConfiguration(builder.setAdTagUri(Uri.parse(str2)).build());
                    Intrinsics.checkNotNullExpressionValue(mimeType, "if(AppController.instanc…      }\n                }");
                    return mimeType;
                }
            }
            mimeType = new MediaItem.Builder().setMimeType(str);
            Intrinsics.checkNotNullExpressionValue(mimeType, "if(AppController.instanc…      }\n                }");
            return mimeType;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final MediaItem getMediaItem(String str, Uri uri) {
            MediaItem build = getMediaItemBuilder(str).setUri(uri).build();
            Intrinsics.checkNotNullExpressionValue(build, "getMediaItemBuilder(mimeType).setUri(uri).build()");
            return build;
        }

        static /* synthetic */ MediaItem getMediaItem$default(Companion companion, String str, String str2, Boolean bool, int i, Object obj) {
            if ((i & 4) != 0) {
                bool = false;
            }
            return companion.getMediaItem(str, str2, bool);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final MediaItem getMediaItem(String str, String str2, Boolean bool) {
            MediaItem.Builder uri = getMediaItemBuilder(str).setUri(str2);
            Intrinsics.checkNotNullExpressionValue(uri, "getMediaItemBuilder(mimeType).setUri(url)");
            if (Intrinsics.areEqual((Object) bool, (Object) true)) {
                uri.setLiveConfiguration(new MediaItem.LiveConfiguration.Builder().setMaxPlaybackSpeed(1.02f).build());
            }
            MediaItem build = uri.build();
            Intrinsics.checkNotNullExpressionValue(build, "mediaItem.build()");
            return build;
        }

        private final TrackSelector getTrackSelector(Context context) {
            DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(context);
            defaultTrackSelector.setParameters(new DefaultTrackSelector.ParametersBuilder(context).setRendererDisabled(3, true).setDisabledTextTrackSelectionFlags(3).clearSelectionOverrides().build());
            return defaultTrackSelector;
        }

        public final CustomTextRenderer getCurrentTextRenderer() {
            return CS3IPlayer.currentTextRenderer;
        }

        public final void setCurrentTextRenderer(CustomTextRenderer customTextRenderer) {
            CS3IPlayer.currentTextRenderer = customTextRenderer;
        }

        static /* synthetic */ ExoPlayer buildExoPlayer$default(Companion companion, Context context, MediaItem mediaItem, List list, int i, long j, float f, long j2, long j3, long j4, boolean z, CacheDataSource.Factory factory, TrackSelector trackSelector, PlayerView playerView, ImaAdsLoader imaAdsLoader, int i2, Object obj) {
            return companion.buildExoPlayer(context, mediaItem, list, i, j, f, j2, j3, j4, (i2 & 512) != 0 ? true : z, (i2 & 1024) != 0 ? null : factory, (i2 & 2048) != 0 ? null : trackSelector, playerView, (i2 & 8192) != 0 ? null : imaAdsLoader);
        }

        private final ExoPlayer buildExoPlayer(final Context context, MediaItem mediaItem, List<SingleSampleMediaSource> list, int i, long j, float f, final long j2, long j3, long j4, boolean z, CacheDataSource.Factory factory, TrackSelector trackSelector, PlayerView playerView, final ImaAdsLoader imaAdsLoader) {
            DefaultMediaSourceFactory adsLoaderProvider;
            ExoPlayer.Builder loadControl = new ExoPlayer.Builder(context).setRenderersFactory(new RenderersFactory() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$CS3IPlayer$Companion$EnatB5mN82SH8E_V7KMfDTIs5YY
                @Override // com.google.android.exoplayer2.RenderersFactory
                public final Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
                    Renderer[] m8666buildExoPlayer$lambda3;
                    m8666buildExoPlayer$lambda3 = CS3IPlayer.Companion.m8666buildExoPlayer$lambda3(context, j2, handler, videoRendererEventListener, audioRendererEventListener, textOutput, metadataOutput);
                    return m8666buildExoPlayer$lambda3;
                }
            }).setTrackSelector(trackSelector == null ? getTrackSelector(context) : trackSelector).setLoadControl(new DefaultLoadControl.Builder().setTargetBufferBytes(j3 <= 0 ? -1 : j3 > 2147483647L ? Integer.MAX_VALUE : (int) j3).setBufferDurationsMs(50000, j4 <= 0 ? 50000 : (int) j4, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, 5000).build());
            Intrinsics.checkNotNullExpressionValue(loadControl, "Builder(context)\n       …d()\n                    )");
            if (factory == null) {
                adsLoaderProvider = new DefaultMediaSourceFactory(context);
            } else {
                adsLoaderProvider = new DefaultMediaSourceFactory(factory).setAdsLoaderProvider(new DefaultMediaSourceFactory.AdsLoaderProvider() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$CS3IPlayer$Companion$8YC1wfp7PMa-yuZTYbmCAMIUJeE
                    @Override // com.google.android.exoplayer2.source.DefaultMediaSourceFactory.AdsLoaderProvider
                    public final AdsLoader getAdsLoader(MediaItem.AdsConfiguration adsConfiguration) {
                        AdsLoader m8667buildExoPlayer$lambda4;
                        m8667buildExoPlayer$lambda4 = CS3IPlayer.Companion.m8667buildExoPlayer$lambda4(ImaAdsLoader.this, adsConfiguration);
                        return m8667buildExoPlayer$lambda4;
                    }
                });
            }
            MediaSource createMediaSource = adsLoaderProvider.setAdViewProvider(playerView).createMediaSource(mediaItem);
            Intrinsics.checkNotNullExpressionValue(createMediaSource, "if (cacheFactory == null…ateMediaSource(mediaItem)");
            ExoPlayer build = loadControl.build();
            build.setPlayWhenReady(z);
            build.seekTo(i, j);
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.add(createMediaSource);
            Object[] array = list.toArray(new SingleSampleMediaSource[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            spreadBuilder.addSpread(array);
            build.setMediaSource(new MergingMediaSource((MediaSource[]) spreadBuilder.toArray(new MediaSource[spreadBuilder.size()])), j);
            build.setHandleAudioBecomingNoisy(true);
            build.setPlaybackSpeed(f);
            Intrinsics.checkNotNullExpressionValue(build, "exoPlayerBuilder.build()…BackSpeed)\n\n            }");
            return build;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: buildExoPlayer$lambda-3  reason: not valid java name */
        public static final Renderer[] m8666buildExoPlayer$lambda3(Context context, long j, Handler eventHandler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textRendererOutput, MetadataOutput metadataRendererOutput) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
            Intrinsics.checkNotNullParameter(videoRendererEventListener, "videoRendererEventListener");
            Intrinsics.checkNotNullParameter(audioRendererEventListener, "audioRendererEventListener");
            Intrinsics.checkNotNullParameter(textRendererOutput, "textRendererOutput");
            Intrinsics.checkNotNullParameter(metadataRendererOutput, "metadataRendererOutput");
            Renderer[] createRenderers = new DefaultRenderersFactory(context).createRenderers(eventHandler, videoRendererEventListener, audioRendererEventListener, textRendererOutput, metadataRendererOutput);
            Intrinsics.checkNotNullExpressionValue(createRenderers, "DefaultRenderersFactory(…                        )");
            Renderer[] rendererArr = createRenderers;
            ArrayList arrayList = new ArrayList(rendererArr.length);
            for (CustomTextRenderer customTextRenderer : rendererArr) {
                if (customTextRenderer instanceof TextRenderer) {
                    CS3IPlayer.Companion.setCurrentTextRenderer(new CustomTextRenderer(j, textRendererOutput, eventHandler.getLooper(), new CustomSubtitleDecoderFactory()));
                    CustomTextRenderer currentTextRenderer = CS3IPlayer.Companion.getCurrentTextRenderer();
                    Intrinsics.checkNotNull(currentTextRenderer);
                    customTextRenderer = currentTextRenderer;
                }
                arrayList.add(customTextRenderer);
            }
            Object[] array = arrayList.toArray(new Renderer[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return (Renderer[]) array;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: buildExoPlayer$lambda-4  reason: not valid java name */
        public static final AdsLoader m8667buildExoPlayer$lambda4(ImaAdsLoader imaAdsLoader, MediaItem.AdsConfiguration it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return imaAdsLoader;
        }
    }

    public final void updatedTime() {
        Function1<? super Tuples<Long, Long>, Unit> function1;
        ExoPlayer exoPlayer = this.exoPlayer;
        Long valueOf = exoPlayer != null ? Long.valueOf(exoPlayer.getCurrentPosition()) : null;
        ExoPlayer exoPlayer2 = this.exoPlayer;
        Long valueOf2 = exoPlayer2 != null ? Long.valueOf(exoPlayer2.getContentDuration()) : null;
        if (valueOf2 == null || valueOf == null || (function1 = this.playerPositionChanged) == null) {
            return;
        }
        function1.invoke(new Tuples(valueOf, valueOf2));
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IPlayer
    public void seekTime(long j) {
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            seekTime(exoPlayer, j);
        }
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IPlayer
    public void seekTo(long j) {
        updatedTime();
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            exoPlayer.seekTo(j);
        }
    }

    private final void seekTime(ExoPlayer exoPlayer, long j) {
        updatedTime();
        exoPlayer.seekTo(exoPlayer.getCurrentPosition() + j);
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IPlayer
    public void handleEvent(CSPlayerEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Log.i(CS3IPlayerKt.TAG, "handleEvent " + event.name());
        try {
            ExoPlayer exoPlayer = this.exoPlayer;
            if (exoPlayer != null) {
                switch (WhenMappings.$EnumSwitchMapping$1[event.ordinal()]) {
                    case 1:
                        exoPlayer.play();
                        break;
                    case 2:
                        exoPlayer.pause();
                        break;
                    case 3:
                        if (exoPlayer.getVolume() <= 0.0f) {
                            exoPlayer.setVolume(this.lastMuteVolume);
                            break;
                        } else {
                            this.lastMuteVolume = exoPlayer.getVolume();
                            exoPlayer.setVolume(0.0f);
                            break;
                        }
                    case 4:
                        if (exoPlayer.isPlaying()) {
                            exoPlayer.pause();
                            break;
                        } else {
                            exoPlayer.play();
                            break;
                        }
                    case 5:
                        seekTime(exoPlayer, this.seekActionTime);
                        break;
                    case 6:
                        seekTime(exoPlayer, -this.seekActionTime);
                        break;
                    case 7:
                        Functions<Unit> functions = this.nextEpisode;
                        if (functions != null) {
                            functions.invoke();
                            break;
                        }
                        break;
                    case 8:
                        Functions<Unit> functions2 = this.prevEpisode;
                        if (functions2 != null) {
                            functions2.invoke();
                            break;
                        }
                        break;
                }
            }
        } catch (Exception e) {
            Log.e(CS3IPlayerKt.TAG, "handleEvent error", e);
            Function1<? super Exception, Unit> function1 = this.playerError;
            if (function1 != null) {
                function1.invoke(e);
            }
        }
    }

    public final ImaAdsLoader getImaAdsLoader() {
        return this.imaAdsLoader;
    }

    public final void setImaAdsLoader(ImaAdsLoader imaAdsLoader) {
        this.imaAdsLoader = imaAdsLoader;
    }

    static /* synthetic */ void loadExo$default(CS3IPlayer cS3IPlayer, Context context, MediaItem mediaItem, List list, CacheDataSource.Factory factory, int i, Object obj) {
        if ((i & 8) != 0) {
            factory = null;
        }
        cS3IPlayer.loadExo(context, mediaItem, list, factory);
    }

    private final void loadExo(Context context, MediaItem mediaItem, List<SingleSampleMediaSource> list, CacheDataSource.Factory factory) {
        String str;
        Log.i(CS3IPlayerKt.TAG, "loadExo");
        try {
            this.hasUsedFirstRender = false;
            ImaAdsLoader build = new ImaAdsLoader.Builder(context).build();
            this.imaAdsLoader = build;
            Companion companion = Companion;
            int i = this.currentWindow;
            long j = this.playbackPosition;
            float f = this.playBackSpeed;
            long j2 = this.cacheSize;
            long j3 = this.videoBufferMs;
            boolean z = this.isPlaying;
            long j4 = this.currentSubtitleOffset;
            str = CS3IPlayerKt.TAG;
            try {
                ExoPlayer buildExoPlayer$default = Companion.buildExoPlayer$default(companion, context, mediaItem, list, i, j, f, j4, j2, j3, z, factory, null, this.playerView, build, 2048, null);
                this.exoPlayer = buildExoPlayer$default;
                ImaAdsLoader imaAdsLoader = this.imaAdsLoader;
                if (imaAdsLoader != null) {
                    imaAdsLoader.setPlayer(buildExoPlayer$default);
                }
                requestSubtitleUpdate = new CS3IPlayer$loadExo$1(this);
                Function1<Object, Unit> function1 = this.playerUpdated;
                if (function1 != null) {
                    function1.invoke(this.exoPlayer);
                }
                ExoPlayer exoPlayer = this.exoPlayer;
                if (exoPlayer != null) {
                    exoPlayer.prepare();
                }
                ExoPlayer exoPlayer2 = this.exoPlayer;
                if (exoPlayer2 != null) {
                    Function1<? super Tuples<? extends CSPlayerLoading, ? extends CSPlayerLoading>, Unit> function12 = this.updateIsPlaying;
                    if (function12 != null) {
                        function12.invoke(new Tuples(CSPlayerLoading.IsBuffering, CSPlayerLoading.IsBuffering));
                    }
                    this.isPlaying = exoPlayer2.isPlaying();
                }
                ExoPlayer exoPlayer3 = this.exoPlayer;
                if (exoPlayer3 != null) {
                    exoPlayer3.addListener((Player.Listener) new CS3IPlayer$loadExo$3(this));
                }
            } catch (Exception e) {
                e = e;
                Log.e(str, "loadExo error", e);
                Function1<? super Exception, Unit> function13 = this.playerError;
                if (function13 != null) {
                    function13.invoke(e);
                }
            }
        } catch (Exception e2) {
            e = e2;
            str = CS3IPlayerKt.TAG;
        }
    }

    public final void onRenderFirst() {
        List<Integer> list;
        if (this.hasUsedFirstRender) {
            return;
        }
        Log.i(CS3IPlayerKt.TAG, "Rendered first frame");
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null && exoPlayer.getDuration() < SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US) {
            ExtractorUri extractorUri = this.currentDownloadedFile;
        }
        setPreferredSubtitles(this.currentSubtitles);
        this.hasUsedFirstRender = true;
        ExoPlayer exoPlayer2 = this.exoPlayer;
        Format videoFormat = exoPlayer2 != null ? exoPlayer2.getVideoFormat() : null;
        Integer valueOf = videoFormat != null ? Integer.valueOf(videoFormat.width) : null;
        Integer valueOf2 = videoFormat != null ? Integer.valueOf(videoFormat.height) : null;
        if (valueOf2 == null || valueOf == null) {
            return;
        }
        Function1<? super Tuples<Integer, Integer>, Unit> function1 = this.playerDimensionsLoaded;
        if (function1 != null) {
            function1.invoke(new Tuples(valueOf, valueOf2));
        }
        updatedTime();
        ExoPlayer exoPlayer3 = this.exoPlayer;
        if (exoPlayer3 == null || (list = this.requestedListeningPercentages) == null) {
            return;
        }
        for (Number number : list) {
            exoPlayer3.createMessage(new PlayerMessage.Target() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$CS3IPlayer$g6xfHfeN6_1Sxd7ftAVJrpjcLtU
                @Override // com.google.android.exoplayer2.PlayerMessage.Target
                public final void handleMessage(int i, Object obj) {
                    CS3IPlayer.m8664onRenderFirst$lambda13$lambda12$lambda11(CS3IPlayer.this, i, obj);
                }
            }).setLooper(Looper.getMainLooper()).setPosition((exoPlayer3.getContentDuration() * number.intValue()) / 100).setDeleteAfterDelivery(false).send();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onRenderFirst$lambda-13$lambda-12$lambda-11  reason: not valid java name */
    public static final void m8664onRenderFirst$lambda13$lambda12$lambda11(CS3IPlayer this$0, int i, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updatedTime();
    }

    private final void loadOfflinePlayer(Context context, ExtractorUri extractorUri) {
        Log.i(CS3IPlayerKt.TAG, "loadOfflinePlayer");
        try {
            this.currentDownloadedFile = extractorUri;
            Companion companion = Companion;
            MediaItem mediaItem = companion.getMediaItem(MimeTypes.VIDEO_MP4, extractorUri.getUri());
            DataSource.Factory createOfflineSource = companion.createOfflineSource(context);
            Tuples<List<SingleSampleMediaSource>, List<SubtitleData>> subSources = getSubSources(createOfflineSource, createOfflineSource, this.subtitleHelper);
            List<SingleSampleMediaSource> component1 = subSources.component1();
            this.subtitleHelper.setActiveSubtitles(CollectionsKt.toSet(subSources.component2()));
            loadExo$default(this, context, mediaItem, component1, null, 8, null);
        } catch (Exception e) {
            Log.e(CS3IPlayerKt.TAG, "loadOfflinePlayer error", e);
            Function1<? super Exception, Unit> function1 = this.playerError;
            if (function1 != null) {
                function1.invoke(e);
            }
        }
    }

    private final Tuples<List<SingleSampleMediaSource>, List<SubtitleData>> getSubSources(DataSource.Factory factory, DataSource.Factory factory2, PlayerSubtitleHelper playerSubtitleHelper) {
        SingleSampleMediaSource singleSampleMediaSource;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SubtitleData subtitleData : playerSubtitleHelper.getAllSubtitles()) {
            MediaItem.SubtitleConfiguration build = new MediaItem.SubtitleConfiguration.Builder(Uri.parse(subtitleData.getUrl())).setMimeType(subtitleData.getMimeType()).setLanguage('_' + subtitleData.getName()).setSelectionFlags(1).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder(Uri.parse(sub.ur…\n                .build()");
            int i = WhenMappings.$EnumSwitchMapping$2[subtitleData.getOrigin().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (factory2 != null) {
                        arrayList.add(subtitleData);
                        singleSampleMediaSource = new SingleSampleMediaSource.Factory(factory2).createMediaSource(build, C3282C.TIME_UNSET);
                    } else {
                        singleSampleMediaSource = null;
                    }
                } else if (factory != null) {
                    arrayList.add(subtitleData);
                    singleSampleMediaSource = new SingleSampleMediaSource.Factory(factory).createMediaSource(build, C3282C.TIME_UNSET);
                } else {
                    singleSampleMediaSource = null;
                }
            } else if (factory2 != null) {
                arrayList.add(subtitleData);
                singleSampleMediaSource = new SingleSampleMediaSource.Factory(factory2).createMediaSource(build, C3282C.TIME_UNSET);
            } else {
                singleSampleMediaSource = null;
            }
            if (singleSampleMediaSource != null) {
                arrayList2.add(singleSampleMediaSource);
            }
        }
        return new Tuples<>(arrayList2, arrayList);
    }

    public final void loadYtFile(Context context, YtFile yt) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(yt, "yt");
        String url = yt.getUrl();
        Intrinsics.checkNotNullExpressionValue(url, "yt.url");
        at.huber.youtubeExtractor.Format format = yt.getFormat();
        loadOnlinePlayer(context, new ExtractorLink("YouTube", "", url, "", format != null ? format.getHeight() : Qualities.Unknown.getValue(), false, null, null, 224, null));
    }

    private final void loadOnlinePlayer(final Context context, ExtractorLink extractorLink) {
        Log.i(CS3IPlayerKt.TAG, "loadOnlinePlayer " + extractorLink);
        try {
            if (StringsKt.contains$default((CharSequence) extractorLink.getUrl(), (CharSequence) "youtube.com", false, 2, (Object) null)) {
                final String replace$default = StringsKt.replace$default(extractorLink.getUrl(), "/embed/", "/watch?v=", false, 4, (Object) null);
                YtFile ytFile = ytVideos.get(replace$default);
                if (ytFile != null) {
                    loadYtFile(context, ytFile);
                    return;
                }
                YouTubeExtractor youTubeExtractor = new YouTubeExtractor(context, replace$default, this) { // from class: com.lagradost.cloudstream3.ui.player.CS3IPlayer$loadOnlinePlayer$ytExtractor$1
                    final /* synthetic */ Context $context;
                    final /* synthetic */ String $ytLink;
                    final /* synthetic */ CS3IPlayer this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(context);
                        this.$context = context;
                        this.$ytLink = replace$default;
                        this.this$0 = this;
                    }

                    @Override // at.huber.youtubeExtractor.YouTubeExtractor
                    protected void onExtractionComplete(SparseArray<YtFile> sparseArray, VideoMeta videoMeta) {
                        Function1 function1;
                        Map map;
                        at.huber.youtubeExtractor.Format format;
                        YtFile ytFile2 = null;
                        if (sparseArray != null) {
                            int size = sparseArray.size();
                            for (int i = 0; i < size; i++) {
                                sparseArray.keyAt(i);
                                YtFile valueAt = sparseArray.valueAt(i);
                                int height = (ytFile2 == null || (format = ytFile2.getFormat()) == null) ? 0 : format.getHeight();
                                at.huber.youtubeExtractor.Format format2 = valueAt.getFormat();
                                if (height < (format2 != null ? format2.getHeight() : -1)) {
                                    at.huber.youtubeExtractor.Format format3 = valueAt.getFormat();
                                    if ((format3 != null ? format3.getAudioBitrate() : -1) > 0) {
                                        ytFile2 = valueAt;
                                    }
                                }
                            }
                        }
                        if (ytFile2 == null) {
                            function1 = this.this$0.playerError;
                            if (function1 != null) {
                                function1.invoke(new ErrorLoadingException("No Link"));
                                return;
                            }
                            return;
                        }
                        String str = this.$ytLink;
                        CS3IPlayer cS3IPlayer = this.this$0;
                        Context context2 = this.$context;
                        map = CS3IPlayer.ytVideos;
                        map.put(str, ytFile2);
                        cS3IPlayer.loadYtFile(context2, ytFile2);
                    }
                };
                Log.i(CS3IPlayerKt.TAG, "YouTube extraction on " + replace$default);
                youTubeExtractor.extract(replace$default);
                return;
            }
            this.currentLink = extractorLink;
            if (this.ignoreSSL) {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                Intrinsics.checkNotNullExpressionValue(sSLContext, "getInstance(\"TLS\")");
                sSLContext.init(null, new SSLTrustManager[]{new SSLTrustManager()}, new SecureRandom());
                sSLContext.createSSLEngine();
                HttpsURLConnection.setDefaultHostnameVerifier($$Lambda$CS3IPlayer$8b3TnVf7tccFRsf4O3iBf48LIBk.INSTANCE);
                HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
            }
            String str = extractorLink.isM3u8() ? MimeTypes.APPLICATION_M3U8 : MimeTypes.VIDEO_MP4;
            Companion companion = Companion;
            MediaItem mediaItem = companion.getMediaItem(str, extractorLink.getUrl(), Boolean.valueOf(Intrinsics.areEqual(extractorLink.getExtractorData(), ConfigHomeKt.IPTV_API_NAME)));
            DataSource.Factory createOnlineSource = companion.createOnlineSource(extractorLink);
            Tuples<List<SingleSampleMediaSource>, List<SubtitleData>> subSources = getSubSources(createOnlineSource, companion.createOfflineSource(context), this.subtitleHelper);
            List<SingleSampleMediaSource> component1 = subSources.component1();
            this.subtitleHelper.setActiveSubtitles(CollectionsKt.toSet(subSources.component2()));
            if (simpleCache == null) {
                simpleCache = companion.getCache(context, this.simpleCacheSize);
            }
            CacheDataSource.Factory factory = new CacheDataSource.Factory();
            SimpleCache simpleCache2 = simpleCache;
            if (simpleCache2 != null) {
                factory.setCache(simpleCache2);
            }
            factory.setUpstreamDataSourceFactory(createOnlineSource);
            loadExo(context, mediaItem, component1, factory);
        } catch (Exception e) {
            Log.e(CS3IPlayerKt.TAG, "loadOnlinePlayer error", e);
            Function1<? super Exception, Unit> function1 = this.playerError;
            if (function1 != null) {
                function1.invoke(e);
            }
        }
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IPlayer
    public void reloadPlayer(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Log.i(CS3IPlayerKt.TAG, "reloadPlayer");
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            exoPlayer.release();
        }
        ExtractorLink extractorLink = this.currentLink;
        if (extractorLink != null) {
            loadOnlinePlayer(context, extractorLink);
            return;
        }
        ExtractorUri extractorUri = this.currentDownloadedFile;
        if (extractorUri != null) {
            loadOfflinePlayer(context, extractorUri);
        }
    }
}
