package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
final class zzct extends zzdg {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ JSONObject zzc;
    final /* synthetic */ RemoteMediaPlayer zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzct(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i, int i2, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzd = remoteMediaPlayer;
        this.zza = i;
        this.zzb = i2;
        this.zzc = jSONObject;
    }

    @Override // com.google.android.gms.cast.zzdg
    protected final void zza(com.google.android.gms.cast.internal.zzw zzwVar) throws com.google.android.gms.cast.internal.zzal {
        com.google.android.gms.cast.internal.zzan zzanVar;
        int zzg = RemoteMediaPlayer.zzg(this.zzd, this.zza);
        if (zzg == -1) {
            setResult((zzct) new zzdf(this, new Status(0)));
            return;
        }
        int i = this.zzb;
        if (i < 0) {
            setResult((zzct) new zzdf(this, new Status(2001, String.format(Locale.ROOT, "Invalid request: Invalid newIndex %d.", Integer.valueOf(this.zzb)))));
        } else if (zzg == i) {
            setResult((zzct) new zzdf(this, new Status(0)));
        } else {
            MediaStatus mediaStatus = this.zzd.getMediaStatus();
            if (mediaStatus == null) {
                setResult((zzct) new zzdf(this, new Status(2001, String.format(Locale.ROOT, "Invalid request: Invalid MediaStatus", new Object[0]))));
                return;
            }
            int i2 = this.zzb;
            if (i2 > zzg) {
                i2++;
            }
            MediaQueueItem queueItem = mediaStatus.getQueueItem(i2);
            int itemId = queueItem != null ? queueItem.getItemId() : 0;
            zzanVar = this.zzd.zzb;
            zzanVar.zzG(zzb(), new int[]{this.zza}, itemId, this.zzc);
        }
    }
}
