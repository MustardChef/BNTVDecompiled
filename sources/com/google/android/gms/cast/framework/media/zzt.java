package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.CastUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzt extends RemoteMediaClient.Callback {
    final /* synthetic */ MediaQueue zza;

    public zzt(MediaQueue mediaQueue) {
        this.zza = mediaQueue;
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
    public final void onStatusUpdated() {
        long zzs;
        zzs = this.zza.zzs();
        MediaQueue mediaQueue = this.zza;
        if (zzs != mediaQueue.zza) {
            mediaQueue.zza = zzs;
            mediaQueue.zza();
            MediaQueue mediaQueue2 = this.zza;
            if (mediaQueue2.zza != 0) {
                mediaQueue2.zzb();
            }
        }
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
    public final void zza(int[] iArr) {
        List<Integer> zzh = CastUtils.zzh(iArr);
        if (this.zza.zzb.equals(zzh)) {
            return;
        }
        this.zza.zzt();
        this.zza.zzd.evictAll();
        this.zza.zze.clear();
        MediaQueue mediaQueue = this.zza;
        mediaQueue.zzb = zzh;
        MediaQueue.zzg(mediaQueue);
        this.zza.zzv();
        this.zza.zzu();
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
    public final void zzb(int[] iArr, int i) {
        int i2;
        int length = iArr.length;
        if (i == 0) {
            i2 = this.zza.zzb.size();
        } else {
            i2 = this.zza.zzc.get(i, -1);
            if (i2 == -1) {
                this.zza.zzb();
                return;
            }
        }
        this.zza.zzt();
        this.zza.zzb.addAll(i2, CastUtils.zzh(iArr));
        MediaQueue.zzg(this.zza);
        MediaQueue.zzj(this.zza, i2, length);
        this.zza.zzu();
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
    public final void zzc(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            this.zza.zzd.remove(Integer.valueOf(i));
            int i2 = this.zza.zzc.get(i, -1);
            if (i2 != -1) {
                arrayList.add(Integer.valueOf(i2));
            } else {
                this.zza.zzb();
                return;
            }
        }
        Collections.sort(arrayList);
        this.zza.zzt();
        this.zza.zzw(CastUtils.zzg(arrayList));
        this.zza.zzu();
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
    public final void zzd(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            this.zza.zzd.remove(Integer.valueOf(i));
            int i2 = this.zza.zzc.get(i, -1);
            if (i2 != -1) {
                this.zza.zzc.delete(i);
                arrayList.add(Integer.valueOf(i2));
            } else {
                this.zza.zzb();
                return;
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Collections.sort(arrayList);
        this.zza.zzt();
        this.zza.zzb.removeAll(CastUtils.zzh(iArr));
        MediaQueue.zzg(this.zza);
        MediaQueue.zzl(this.zza, CastUtils.zzg(arrayList));
        this.zza.zzu();
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
    public final void zze(MediaQueueItem[] mediaQueueItemArr) {
        HashSet hashSet = new HashSet();
        this.zza.zze.clear();
        for (MediaQueueItem mediaQueueItem : mediaQueueItemArr) {
            int itemId = mediaQueueItem.getItemId();
            this.zza.zzd.put(Integer.valueOf(itemId), mediaQueueItem);
            int i = this.zza.zzc.get(itemId, -1);
            if (i != -1) {
                hashSet.add(Integer.valueOf(i));
            } else {
                this.zza.zzb();
                return;
            }
        }
        for (Integer num : this.zza.zze) {
            int i2 = this.zza.zzc.get(num.intValue(), -1);
            if (i2 != -1) {
                hashSet.add(Integer.valueOf(i2));
            }
        }
        this.zza.zze.clear();
        ArrayList arrayList = new ArrayList(hashSet);
        Collections.sort(arrayList);
        this.zza.zzt();
        this.zza.zzw(CastUtils.zzg(arrayList));
        this.zza.zzu();
    }
}
