package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
final class zzat extends zzbm {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ JSONObject zzc;
    final /* synthetic */ RemoteMediaClient zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzat(RemoteMediaClient remoteMediaClient, int i, int i2, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzd = remoteMediaClient;
        this.zza = i;
        this.zzb = i2;
        this.zzc = jSONObject;
    }

    @Override // com.google.android.gms.cast.framework.media.zzbm
    protected final void zza() throws com.google.android.gms.cast.internal.zzal {
        com.google.android.gms.cast.internal.zzan zzanVar;
        MediaQueueItem queueItem;
        RemoteMediaClient remoteMediaClient = this.zzd;
        int i = this.zza;
        Preconditions.checkMainThread("Must be called from the main thread.");
        int indexOfItemWithId = remoteMediaClient.getMediaQueue().indexOfItemWithId(i);
        if (indexOfItemWithId == -1) {
            MediaStatus mediaStatus = (MediaStatus) Preconditions.checkNotNull(remoteMediaClient.getMediaStatus());
            indexOfItemWithId = 0;
            while (true) {
                if (indexOfItemWithId >= mediaStatus.getQueueItemCount()) {
                    indexOfItemWithId = -1;
                    break;
                } else if (((MediaQueueItem) Preconditions.checkNotNull(mediaStatus.getQueueItem(indexOfItemWithId))).getItemId() == i) {
                    break;
                } else {
                    indexOfItemWithId++;
                }
            }
        }
        int i2 = this.zzb;
        if (i2 < 0) {
            setResult(new zzbl(this, new Status(2001, String.format(Locale.ROOT, "Invalid request: Invalid newIndex %d.", Integer.valueOf(this.zzb)))));
        } else if (indexOfItemWithId == i2) {
            setResult(new zzbl(this, new Status(0)));
        } else {
            if (i2 > indexOfItemWithId) {
                i2++;
            }
            RemoteMediaClient remoteMediaClient2 = this.zzd;
            Preconditions.checkMainThread("Must be called from the main thread.");
            int itemIdAtIndex = remoteMediaClient2.getMediaQueue().itemIdAtIndex(i2);
            if (itemIdAtIndex == 0) {
                MediaStatus mediaStatus2 = remoteMediaClient2.getMediaStatus();
                itemIdAtIndex = (mediaStatus2 == null || (queueItem = mediaStatus2.getQueueItem(i2)) == null) ? 0 : queueItem.getItemId();
            }
            zzanVar = this.zzd.zzd;
            zzanVar.zzG(zzb(), new int[]{this.zza}, itemIdAtIndex, this.zzc);
        }
    }
}
