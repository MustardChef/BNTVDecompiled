package com.google.android.gms.cast.framework.media;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.cast.AdBreakInfo;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaLoadOptions;
import com.google.android.gms.cast.MediaLoadRequestData;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaSeekOptions;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzci;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public class RemoteMediaClient implements Cast.MessageReceivedCallback {
    public static final String NAMESPACE = com.google.android.gms.cast.internal.zzan.zzb;
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    private final com.google.android.gms.cast.internal.zzan zzd;
    private final zzbh zze;
    @NotOnlyInitialized
    private final MediaQueue zzf;
    private com.google.android.gms.cast.zzq zzg;
    private ParseAdsInfoCallback zzk;
    private final List<Listener> zzh = new CopyOnWriteArrayList();
    final List<Callback> zza = new CopyOnWriteArrayList();
    private final Map<ProgressListener, zzbq> zzi = new ConcurrentHashMap();
    private final Map<Long, zzbq> zzj = new ConcurrentHashMap();
    private final Object zzb = new Object();
    private final Handler zzc = new zzci(Looper.getMainLooper());

    /* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
    /* loaded from: classes2.dex */
    public static abstract class Callback {
        public void onAdBreakStatusUpdated() {
        }

        public void onMediaError(MediaError mediaError) {
        }

        public void onMetadataUpdated() {
        }

        public void onPreloadStatusUpdated() {
        }

        public void onQueueStatusUpdated() {
        }

        public void onSendingRemoteMediaRequest() {
        }

        public void onStatusUpdated() {
        }

        public void zza(int[] iArr) {
        }

        public void zzb(int[] iArr, int i) {
        }

        public void zzc(int[] iArr) {
        }

        public void zzd(int[] iArr) {
        }

        public void zze(MediaQueueItem[] mediaQueueItemArr) {
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
    @Deprecated
    /* loaded from: classes2.dex */
    public interface Listener {
        void onAdBreakStatusUpdated();

        void onMetadataUpdated();

        void onPreloadStatusUpdated();

        void onQueueStatusUpdated();

        void onSendingRemoteMediaRequest();

        void onStatusUpdated();
    }

    /* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
    /* loaded from: classes2.dex */
    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();

        MediaError getMediaError();
    }

    /* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
    /* loaded from: classes2.dex */
    public interface ParseAdsInfoCallback {
        List<AdBreakInfo> parseAdBreaksFromMediaStatus(MediaStatus mediaStatus);

        boolean parseIsPlayingAdFromMediaStatus(MediaStatus mediaStatus);
    }

    /* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
    /* loaded from: classes2.dex */
    public interface ProgressListener {
        void onProgressUpdated(long j, long j2);
    }

    public RemoteMediaClient(com.google.android.gms.cast.internal.zzan zzanVar) {
        zzbh zzbhVar = new zzbh(this);
        this.zze = zzbhVar;
        com.google.android.gms.cast.internal.zzan zzanVar2 = (com.google.android.gms.cast.internal.zzan) Preconditions.checkNotNull(zzanVar);
        this.zzd = zzanVar2;
        zzanVar2.zzi(new zzbo(this, null));
        zzanVar2.zze(zzbhVar);
        this.zzf = new MediaQueue(this, 20, 20);
    }

    public static PendingResult<MediaChannelResult> zzi(int i, String str) {
        zzbj zzbjVar = new zzbj();
        zzbjVar.setResult(new zzbi(zzbjVar, new Status(i, str)));
        return zzbjVar;
    }

    public static /* synthetic */ void zzj(RemoteMediaClient remoteMediaClient) {
        Set<ProgressListener> set;
        for (zzbq zzbqVar : remoteMediaClient.zzj.values()) {
            if (!remoteMediaClient.hasMediaSession() || zzbqVar.zzg()) {
                if (!remoteMediaClient.hasMediaSession() && zzbqVar.zzg()) {
                    zzbqVar.zzf();
                }
            } else {
                zzbqVar.zze();
            }
            if (zzbqVar.zzg() && (remoteMediaClient.isBuffering() || remoteMediaClient.zzg() || remoteMediaClient.isPaused() || remoteMediaClient.isLoadingNextItem())) {
                set = zzbqVar.zzb;
                remoteMediaClient.zzr(set);
            }
        }
    }

    private final boolean zzq() {
        return this.zzg != null;
    }

    public final void zzr(Set<ProgressListener> set) {
        MediaInfo media;
        HashSet<ProgressListener> hashSet = new HashSet(set);
        if (isPlaying() || isPaused() || isBuffering() || zzg()) {
            for (ProgressListener progressListener : hashSet) {
                progressListener.onProgressUpdated(getApproximateStreamPosition(), getStreamDuration());
            }
        } else if (isLoadingNextItem()) {
            MediaQueueItem loadingItem = getLoadingItem();
            if (loadingItem == null || (media = loadingItem.getMedia()) == null) {
                return;
            }
            for (ProgressListener progressListener2 : hashSet) {
                progressListener2.onProgressUpdated(0L, media.getStreamDuration());
            }
        } else {
            for (ProgressListener progressListener3 : hashSet) {
                progressListener3.onProgressUpdated(0L, 0L);
            }
        }
    }

    private static final zzbm zzs(zzbm zzbmVar) {
        try {
            zzbmVar.zzc();
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Throwable unused) {
            zzbmVar.setResult(new zzbl(zzbmVar, new Status(2100)));
        }
        return zzbmVar;
    }

    @Deprecated
    public void addListener(Listener listener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (listener != null) {
            this.zzh.add(listener);
        }
    }

    public boolean addProgressListener(ProgressListener progressListener, long j) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (progressListener == null || this.zzi.containsKey(progressListener)) {
            return false;
        }
        Map<Long, zzbq> map = this.zzj;
        Long valueOf = Long.valueOf(j);
        zzbq zzbqVar = map.get(valueOf);
        if (zzbqVar == null) {
            zzbqVar = new zzbq(this, j);
            this.zzj.put(valueOf, zzbqVar);
        }
        zzbqVar.zzb(progressListener);
        this.zzi.put(progressListener, zzbqVar);
        if (hasMediaSession()) {
            zzbqVar.zze();
            return true;
        }
        return true;
    }

    public long getApproximateAdBreakClipPositionMs() {
        long zzy;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzy = this.zzd.zzy();
        }
        return zzy;
    }

    public long getApproximateLiveSeekableRangeEnd() {
        long zzx;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzx = this.zzd.zzx();
        }
        return zzx;
    }

    public long getApproximateLiveSeekableRangeStart() {
        long zzw;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzw = this.zzd.zzw();
        }
        return zzw;
    }

    public long getApproximateStreamPosition() {
        long zzv;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzv = this.zzd.zzv();
        }
        return zzv;
    }

    public MediaQueueItem getCurrentItem() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null) {
            return null;
        }
        return mediaStatus.getQueueItemById(mediaStatus.getCurrentItemId());
    }

    public int getIdleReason() {
        int idleReason;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            MediaStatus mediaStatus = getMediaStatus();
            idleReason = mediaStatus != null ? mediaStatus.getIdleReason() : 0;
        }
        return idleReason;
    }

    public MediaQueueItem getLoadingItem() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null) {
            return null;
        }
        return mediaStatus.getQueueItemById(mediaStatus.getLoadingItemId());
    }

    public MediaInfo getMediaInfo() {
        MediaInfo zzB;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzB = this.zzd.zzB();
        }
        return zzB;
    }

    public MediaQueue getMediaQueue() {
        MediaQueue mediaQueue;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            mediaQueue = this.zzf;
        }
        return mediaQueue;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus zzA;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzA = this.zzd.zzA();
        }
        return zzA;
    }

    public String getNamespace() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzd.zzd();
    }

    public int getPlayerState() {
        int playerState;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            MediaStatus mediaStatus = getMediaStatus();
            playerState = mediaStatus != null ? mediaStatus.getPlayerState() : 1;
        }
        return playerState;
    }

    public MediaQueueItem getPreloadedItem() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null) {
            return null;
        }
        return mediaStatus.getQueueItemById(mediaStatus.getPreloadedItemId());
    }

    public long getStreamDuration() {
        long zzz;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzz = this.zzd.zzz();
        }
        return zzz;
    }

    public boolean hasMediaSession() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return isBuffering() || zzg() || isPlaying() || isPaused() || isLoadingNextItem();
    }

    public boolean isBuffering() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return mediaStatus != null && mediaStatus.getPlayerState() == 4;
    }

    public boolean isLiveStream() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaInfo mediaInfo = getMediaInfo();
        return mediaInfo != null && mediaInfo.getStreamType() == 2;
    }

    public boolean isLoadingNextItem() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return (mediaStatus == null || mediaStatus.getLoadingItemId() == 0) ? false : true;
    }

    public boolean isPaused() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus != null) {
            if (mediaStatus.getPlayerState() == 3) {
                return true;
            }
            if (isLiveStream() && getIdleReason() == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean isPlaying() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return mediaStatus != null && mediaStatus.getPlayerState() == 2;
    }

    public boolean isPlayingAd() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return mediaStatus != null && mediaStatus.isPlayingAd();
    }

    @Deprecated
    public PendingResult<MediaChannelResult> load(MediaInfo mediaInfo) {
        return load(mediaInfo, new MediaLoadOptions.Builder().build());
    }

    @Override // com.google.android.gms.cast.Cast.MessageReceivedCallback
    public void onMessageReceived(CastDevice castDevice, String str, String str2) {
        this.zzd.zzL(str2);
    }

    public PendingResult<MediaChannelResult> pause() {
        return pause(null);
    }

    public PendingResult<MediaChannelResult> play() {
        return play(null);
    }

    public PendingResult<MediaChannelResult> queueAppendItem(MediaQueueItem mediaQueueItem, JSONObject jSONObject) throws IllegalArgumentException {
        return queueInsertItems(new MediaQueueItem[]{mediaQueueItem}, 0, jSONObject);
    }

    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(MediaQueueItem mediaQueueItem, int i, long j, JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzai zzaiVar = new zzai(this, mediaQueueItem, i, j, jSONObject);
        zzs(zzaiVar);
        return zzaiVar;
    }

    public PendingResult<MediaChannelResult> queueInsertItems(MediaQueueItem[] mediaQueueItemArr, int i, JSONObject jSONObject) throws IllegalArgumentException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzah zzahVar = new zzah(this, mediaQueueItemArr, i, jSONObject);
        zzs(zzahVar);
        return zzahVar;
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(int i, long j, JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzas zzasVar = new zzas(this, i, j, jSONObject);
        zzs(zzasVar);
        return zzasVar;
    }

    public PendingResult<MediaChannelResult> queueLoad(MediaQueueItem[] mediaQueueItemArr, int i, int i2, long j, JSONObject jSONObject) throws IllegalArgumentException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzag zzagVar = new zzag(this, mediaQueueItemArr, i, i2, j, jSONObject);
        zzs(zzagVar);
        return zzagVar;
    }

    public PendingResult<MediaChannelResult> queueMoveItemToNewIndex(int i, int i2, JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzat zzatVar = new zzat(this, i, i2, jSONObject);
        zzs(zzatVar);
        return zzatVar;
    }

    public PendingResult<MediaChannelResult> queueNext(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzap zzapVar = new zzap(this, jSONObject);
        zzs(zzapVar);
        return zzapVar;
    }

    public PendingResult<MediaChannelResult> queuePrev(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzao zzaoVar = new zzao(this, jSONObject);
        zzs(zzaoVar);
        return zzaoVar;
    }

    public PendingResult<MediaChannelResult> queueRemoveItem(int i, JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzar zzarVar = new zzar(this, i, jSONObject);
        zzs(zzarVar);
        return zzarVar;
    }

    public PendingResult<MediaChannelResult> queueRemoveItems(int[] iArr, JSONObject jSONObject) throws IllegalArgumentException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzak zzakVar = new zzak(this, iArr, jSONObject);
        zzs(zzakVar);
        return zzakVar;
    }

    public PendingResult<MediaChannelResult> queueReorderItems(int[] iArr, int i, JSONObject jSONObject) throws IllegalArgumentException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzal zzalVar = new zzal(this, iArr, i, jSONObject);
        zzs(zzalVar);
        return zzalVar;
    }

    public PendingResult<MediaChannelResult> queueSetRepeatMode(int i, JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzaq zzaqVar = new zzaq(this, i, jSONObject);
        zzs(zzaqVar);
        return zzaqVar;
    }

    public PendingResult<MediaChannelResult> queueShuffle(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzan zzanVar = new zzan(this, jSONObject);
        zzs(zzanVar);
        return zzanVar;
    }

    public PendingResult<MediaChannelResult> queueUpdateItems(MediaQueueItem[] mediaQueueItemArr, JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzaj zzajVar = new zzaj(this, mediaQueueItemArr, jSONObject);
        zzs(zzajVar);
        return zzajVar;
    }

    public void registerCallback(Callback callback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (callback != null) {
            this.zza.add(callback);
        }
    }

    @Deprecated
    public void removeListener(Listener listener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (listener != null) {
            this.zzh.remove(listener);
        }
    }

    public void removeProgressListener(ProgressListener progressListener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzbq remove = this.zzi.remove(progressListener);
        if (remove != null) {
            remove.zzc(progressListener);
            if (remove.zzd()) {
                return;
            }
            this.zzj.remove(Long.valueOf(remove.zza()));
            remove.zzf();
        }
    }

    public PendingResult<MediaChannelResult> requestStatus() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzad zzadVar = new zzad(this);
        zzs(zzadVar);
        return zzadVar;
    }

    @Deprecated
    public PendingResult<MediaChannelResult> seek(long j) {
        return seek(j, 0, null);
    }

    public PendingResult<MediaChannelResult> setActiveMediaTracks(long[] jArr) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzae zzaeVar = new zzae(this, jArr);
        zzs(zzaeVar);
        return zzaeVar;
    }

    public void setParseAdsInfoCallback(ParseAdsInfoCallback parseAdsInfoCallback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzk = parseAdsInfoCallback;
    }

    public PendingResult<MediaChannelResult> setPlaybackRate(double d) {
        return setPlaybackRate(d, null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(boolean z) {
        return setStreamMute(z, null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(double d) throws IllegalArgumentException {
        return setStreamVolume(d, null);
    }

    public PendingResult<MediaChannelResult> setTextTrackStyle(TextTrackStyle textTrackStyle) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzaf zzafVar = new zzaf(this, textTrackStyle);
        zzs(zzafVar);
        return zzafVar;
    }

    public PendingResult<MediaChannelResult> skipAd() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzac zzacVar = new zzac(this);
        zzs(zzacVar);
        return zzacVar;
    }

    public PendingResult<MediaChannelResult> stop() {
        return stop(null);
    }

    public void togglePlayback() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        int playerState = getPlayerState();
        if (playerState == 4 || playerState == 2) {
            pause();
        } else {
            play();
        }
    }

    public void unregisterCallback(Callback callback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (callback != null) {
            this.zza.remove(callback);
        }
    }

    public final void zza(com.google.android.gms.cast.zzq zzqVar) {
        com.google.android.gms.cast.zzq zzqVar2 = this.zzg;
        if (zzqVar2 == zzqVar) {
            return;
        }
        if (zzqVar2 != null) {
            this.zzd.zzh();
            this.zzf.zza();
            zzqVar2.zzq(getNamespace());
            this.zze.zza(null);
            this.zzc.removeCallbacksAndMessages(null);
        }
        this.zzg = zzqVar;
        if (zzqVar != null) {
            this.zze.zza(zzqVar);
        }
    }

    public final void zzb() {
        com.google.android.gms.cast.zzq zzqVar = this.zzg;
        if (zzqVar == null) {
            return;
        }
        zzqVar.zzp(getNamespace(), this);
        requestStatus();
    }

    public final PendingResult<MediaChannelResult> zzc() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzau zzauVar = new zzau(this, true);
        zzs(zzauVar);
        return zzauVar;
    }

    public final PendingResult<MediaChannelResult> zzd(int[] iArr) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzav zzavVar = new zzav(this, true, iArr);
        zzs(zzavVar);
        return zzavVar;
    }

    public final PendingResult<MediaChannelResult> zze(int i, int i2, int i3) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzaw zzawVar = new zzaw(this, true, i, i2, i3);
        zzs(zzawVar);
        return zzawVar;
    }

    public final PendingResult<MediaChannelResult> zzf(String str, List list) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzay zzayVar = new zzay(this, true, str, null);
        zzs(zzayVar);
        return zzayVar;
    }

    final boolean zzg() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return mediaStatus != null && mediaStatus.getPlayerState() == 5;
    }

    public final boolean zzh() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (isLiveStream()) {
            MediaStatus mediaStatus = getMediaStatus();
            return (mediaStatus == null || !mediaStatus.isMediaCommandSupported(2L) || mediaStatus.getLiveSeekableRange() == null) ? false : true;
        }
        return true;
    }

    public PendingResult<MediaChannelResult> load(MediaInfo mediaInfo, MediaLoadOptions mediaLoadOptions) {
        MediaLoadRequestData.Builder builder = new MediaLoadRequestData.Builder();
        builder.setMediaInfo(mediaInfo);
        builder.setAutoplay(Boolean.valueOf(mediaLoadOptions.getAutoplay()));
        builder.setCurrentTime(mediaLoadOptions.getPlayPosition());
        builder.setPlaybackRate(mediaLoadOptions.getPlaybackRate());
        builder.setActiveTrackIds(mediaLoadOptions.getActiveTrackIds());
        builder.setCustomData(mediaLoadOptions.getCustomData());
        builder.setCredentials(mediaLoadOptions.getCredentials());
        builder.setCredentialsType(mediaLoadOptions.getCredentialsType());
        return load(builder.build());
    }

    public PendingResult<MediaChannelResult> pause(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzaz zzazVar = new zzaz(this, jSONObject);
        zzs(zzazVar);
        return zzazVar;
    }

    public PendingResult<MediaChannelResult> play(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzbb zzbbVar = new zzbb(this, jSONObject);
        zzs(zzbbVar);
        return zzbbVar;
    }

    @Deprecated
    public PendingResult<MediaChannelResult> seek(long j, int i) {
        return seek(j, i, null);
    }

    public PendingResult<MediaChannelResult> setPlaybackRate(double d, JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzbf zzbfVar = new zzbf(this, d, jSONObject);
        zzs(zzbfVar);
        return zzbfVar;
    }

    public PendingResult<MediaChannelResult> setStreamMute(boolean z, JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzbe zzbeVar = new zzbe(this, z, jSONObject);
        zzs(zzbeVar);
        return zzbeVar;
    }

    public PendingResult<MediaChannelResult> setStreamVolume(double d, JSONObject jSONObject) throws IllegalArgumentException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzbd zzbdVar = new zzbd(this, d, jSONObject);
        zzs(zzbdVar);
        return zzbdVar;
    }

    public PendingResult<MediaChannelResult> stop(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzba zzbaVar = new zzba(this, jSONObject);
        zzs(zzbaVar);
        return zzbaVar;
    }

    @Deprecated
    public PendingResult<MediaChannelResult> seek(long j, int i, JSONObject jSONObject) {
        MediaSeekOptions.Builder builder = new MediaSeekOptions.Builder();
        builder.setPosition(j);
        builder.setResumeState(i);
        builder.setCustomData(jSONObject);
        return seek(builder.build());
    }

    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(MediaQueueItem mediaQueueItem, int i, JSONObject jSONObject) {
        return queueInsertAndPlayItem(mediaQueueItem, i, -1L, jSONObject);
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(int i, JSONObject jSONObject) {
        return queueJumpToItem(i, -1L, jSONObject);
    }

    public PendingResult<MediaChannelResult> queueLoad(MediaQueueItem[] mediaQueueItemArr, int i, int i2, JSONObject jSONObject) throws IllegalArgumentException {
        return queueLoad(mediaQueueItemArr, i, i2, -1L, jSONObject);
    }

    public PendingResult<MediaChannelResult> seek(MediaSeekOptions mediaSeekOptions) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzbc zzbcVar = new zzbc(this, mediaSeekOptions);
        zzs(zzbcVar);
        return zzbcVar;
    }

    @Deprecated
    public PendingResult<MediaChannelResult> load(MediaInfo mediaInfo, boolean z) {
        MediaLoadOptions.Builder builder = new MediaLoadOptions.Builder();
        builder.setAutoplay(z);
        return load(mediaInfo, builder.build());
    }

    @Deprecated
    public PendingResult<MediaChannelResult> load(MediaInfo mediaInfo, boolean z, long j) {
        MediaLoadOptions.Builder builder = new MediaLoadOptions.Builder();
        builder.setAutoplay(z);
        builder.setPlayPosition(j);
        return load(mediaInfo, builder.build());
    }

    @Deprecated
    public PendingResult<MediaChannelResult> load(MediaInfo mediaInfo, boolean z, long j, JSONObject jSONObject) {
        MediaLoadOptions.Builder builder = new MediaLoadOptions.Builder();
        builder.setAutoplay(z);
        builder.setPlayPosition(j);
        builder.setCustomData(jSONObject);
        return load(mediaInfo, builder.build());
    }

    @Deprecated
    public PendingResult<MediaChannelResult> load(MediaInfo mediaInfo, boolean z, long j, long[] jArr, JSONObject jSONObject) {
        MediaLoadOptions.Builder builder = new MediaLoadOptions.Builder();
        builder.setAutoplay(z);
        builder.setPlayPosition(j);
        builder.setActiveTrackIds(jArr);
        builder.setCustomData(jSONObject);
        return load(mediaInfo, builder.build());
    }

    public PendingResult<MediaChannelResult> load(MediaLoadRequestData mediaLoadRequestData) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzq()) {
            return zzi(17, null);
        }
        zzax zzaxVar = new zzax(this, mediaLoadRequestData);
        zzs(zzaxVar);
        return zzaxVar;
    }
}
