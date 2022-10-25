package com.google.android.gms.cast.framework.media;

import android.os.Handler;
import android.os.Looper;
import android.util.LruCache;
import android.util.SparseIntArray;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzci;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimerTask;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public class MediaQueue {
    long zza;
    LruCache<Integer, MediaQueueItem> zzd;
    private final RemoteMediaClient zzh;
    private PendingResult<RemoteMediaClient.MediaChannelResult> zzl;
    private PendingResult<RemoteMediaClient.MediaChannelResult> zzm;
    private Set<Callback> zzn = new HashSet();
    private final Logger zzg = new Logger("MediaQueue");
    private final int zzi = Math.max(20, 1);
    List<Integer> zzb = new ArrayList();
    final SparseIntArray zzc = new SparseIntArray();
    final List<Integer> zze = new ArrayList();
    final Deque<Integer> zzf = new ArrayDeque(20);
    private final Handler zzj = new zzci(Looper.getMainLooper());
    private TimerTask zzk = new zzr(this);

    /* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
    /* loaded from: classes2.dex */
    public static abstract class Callback {
        public void itemsInsertedInRange(int i, int i2) {
        }

        public void itemsReloaded() {
        }

        public void itemsRemovedAtIndexes(int[] iArr) {
        }

        public void itemsUpdatedAtIndexes(int[] iArr) {
        }

        public void mediaQueueChanged() {
        }

        public void mediaQueueWillChange() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaQueue(RemoteMediaClient remoteMediaClient, int i, int i2) {
        this.zzh = remoteMediaClient;
        remoteMediaClient.registerCallback(new zzt(this));
        zzn(20);
        this.zza = zzs();
        zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zze(final MediaQueue mediaQueue) {
        if (mediaQueue.zzf.isEmpty() || mediaQueue.zzl != null || mediaQueue.zza == 0) {
            return;
        }
        PendingResult<RemoteMediaClient.MediaChannelResult> zzd = mediaQueue.zzh.zzd(CastUtils.zzg(mediaQueue.zzf));
        mediaQueue.zzl = zzd;
        zzd.setResultCallback(new ResultCallback(mediaQueue) { // from class: com.google.android.gms.cast.framework.media.zzq
            private final MediaQueue zza;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = mediaQueue;
            }

            @Override // com.google.android.gms.common.api.ResultCallback
            public final void onResult(Result result) {
                this.zza.zzc((RemoteMediaClient.MediaChannelResult) result);
            }
        });
        mediaQueue.zzf.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzg(MediaQueue mediaQueue) {
        mediaQueue.zzc.clear();
        for (int i = 0; i < mediaQueue.zzb.size(); i++) {
            mediaQueue.zzc.put(mediaQueue.zzb.get(i).intValue(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzj(MediaQueue mediaQueue, int i, int i2) {
        for (Callback callback : mediaQueue.zzn) {
            callback.itemsInsertedInRange(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzl(MediaQueue mediaQueue, int[] iArr) {
        for (Callback callback : mediaQueue.zzn) {
            callback.itemsRemovedAtIndexes(iArr);
        }
    }

    private final void zzn(int i) {
        this.zzd = new zzs(this, i);
    }

    private final void zzo() {
        zzp();
        this.zzj.postDelayed(this.zzk, 500L);
    }

    private final void zzp() {
        this.zzj.removeCallbacks(this.zzk);
    }

    private final void zzq() {
        PendingResult<RemoteMediaClient.MediaChannelResult> pendingResult = this.zzm;
        if (pendingResult != null) {
            pendingResult.cancel();
            this.zzm = null;
        }
    }

    private final void zzr() {
        PendingResult<RemoteMediaClient.MediaChannelResult> pendingResult = this.zzl;
        if (pendingResult != null) {
            pendingResult.cancel();
            this.zzl = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzs() {
        MediaStatus mediaStatus = this.zzh.getMediaStatus();
        if (mediaStatus == null || mediaStatus.zzc()) {
            return 0L;
        }
        return mediaStatus.zza();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzt() {
        for (Callback callback : this.zzn) {
            callback.mediaQueueWillChange();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzu() {
        for (Callback callback : this.zzn) {
            callback.mediaQueueChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzv() {
        for (Callback callback : this.zzn) {
            callback.itemsReloaded();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzw(int[] iArr) {
        for (Callback callback : this.zzn) {
            callback.itemsUpdatedAtIndexes(iArr);
        }
    }

    public PendingResult<RemoteMediaClient.MediaChannelResult> fetchMoreItemsRelativeToIndex(int i, int i2, int i3) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (this.zza == 0) {
            return RemoteMediaClient.zzi(2100, "No active media session");
        }
        int itemIdAtIndex = itemIdAtIndex(i);
        if (itemIdAtIndex == 0) {
            return RemoteMediaClient.zzi(2001, "index out of bound");
        }
        return this.zzh.zze(itemIdAtIndex, i2, i3);
    }

    public MediaQueueItem getItemAtIndex(int i) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return getItemAtIndex(i, true);
    }

    public int getItemCount() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzb.size();
    }

    public int[] getItemIds() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return CastUtils.zzg(this.zzb);
    }

    public int indexOfItemWithId(int i) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzc.get(i, -1);
    }

    public int itemIdAtIndex(int i) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (i < 0 || i >= this.zzb.size()) {
            return 0;
        }
        return this.zzb.get(i).intValue();
    }

    public void registerCallback(Callback callback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzn.add(callback);
    }

    public void setCacheCapacity(int i) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        LruCache<Integer, MediaQueueItem> lruCache = this.zzd;
        ArrayList arrayList = new ArrayList();
        zzn(i);
        int size = lruCache.size();
        for (Map.Entry<Integer, MediaQueueItem> entry : lruCache.snapshot().entrySet()) {
            if (size > i) {
                int i2 = this.zzc.get(entry.getKey().intValue(), -1);
                if (i2 != -1) {
                    arrayList.add(Integer.valueOf(i2));
                }
            } else {
                this.zzd.put(entry.getKey(), entry.getValue());
            }
            size--;
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Collections.sort(arrayList);
        zzt();
        zzw(CastUtils.zzg(arrayList));
        zzu();
    }

    public void unregisterCallback(Callback callback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzn.remove(callback);
    }

    public final void zza() {
        zzt();
        this.zzb.clear();
        this.zzc.clear();
        this.zzd.evictAll();
        this.zze.clear();
        zzp();
        this.zzf.clear();
        zzq();
        zzr();
        zzv();
        zzu();
    }

    public final void zzb() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (this.zza != 0 && this.zzm == null) {
            zzq();
            zzr();
            PendingResult<RemoteMediaClient.MediaChannelResult> zzc = this.zzh.zzc();
            this.zzm = zzc;
            zzc.setResultCallback(new ResultCallback(this) { // from class: com.google.android.gms.cast.framework.media.zzp
                private final MediaQueue zza;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zza = this;
                }

                @Override // com.google.android.gms.common.api.ResultCallback
                public final void onResult(Result result) {
                    this.zza.zzd((RemoteMediaClient.MediaChannelResult) result);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(RemoteMediaClient.MediaChannelResult mediaChannelResult) {
        Status status = mediaChannelResult.getStatus();
        int statusCode = status.getStatusCode();
        if (statusCode != 0) {
            this.zzg.m362w(String.format("Error fetching queue items, statusCode=%s, statusMessage=%s", Integer.valueOf(statusCode), status.getStatusMessage()), new Object[0]);
        }
        this.zzl = null;
        if (this.zzf.isEmpty()) {
            return;
        }
        zzo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd(RemoteMediaClient.MediaChannelResult mediaChannelResult) {
        Status status = mediaChannelResult.getStatus();
        int statusCode = status.getStatusCode();
        if (statusCode != 0) {
            this.zzg.m362w(String.format("Error fetching queue item ids, statusCode=%s, statusMessage=%s", Integer.valueOf(statusCode), status.getStatusMessage()), new Object[0]);
        }
        this.zzm = null;
        if (this.zzf.isEmpty()) {
            return;
        }
        zzo();
    }

    public MediaQueueItem getItemAtIndex(int i, boolean z) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (i < 0 || i >= this.zzb.size()) {
            return null;
        }
        int intValue = this.zzb.get(i).intValue();
        LruCache<Integer, MediaQueueItem> lruCache = this.zzd;
        Integer valueOf = Integer.valueOf(intValue);
        MediaQueueItem mediaQueueItem = lruCache.get(valueOf);
        if (mediaQueueItem == null && z && !this.zzf.contains(valueOf)) {
            while (this.zzf.size() >= this.zzi) {
                this.zzf.removeFirst();
            }
            this.zzf.add(Integer.valueOf(intValue));
            zzo();
        }
        return mediaQueueItem;
    }
}
