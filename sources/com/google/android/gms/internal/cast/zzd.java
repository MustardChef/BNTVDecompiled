package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transport;
import com.google.android.gms.common.internal.Preconditions;
import java.util.UUID;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzd {
    private final Transport<zzkt> zza;
    private final String zzb;
    private final int zzc;

    private zzd(SharedPreferences sharedPreferences, Transport<zzkt> transport, long j) {
        this.zza = transport;
        String string = sharedPreferences.getString("client_sender_id", null);
        if (string == null) {
            string = UUID.randomUUID().toString();
            sharedPreferences.edit().putString("client_sender_id", string).apply();
        }
        this.zzb = string;
        this.zzc = j == 0 ? 1 : 2;
    }

    public static zzd zza(SharedPreferences sharedPreferences, Transport<zzkt> transport, long j) {
        return new zzd(sharedPreferences, transport, j);
    }

    @Pure
    public final void zzb(zzkt zzktVar, zzhi zzhiVar) {
        Event<zzkt> ofTelemetry;
        zzks zzd = zzkt.zzd(zzktVar);
        zzd.zzb(this.zzb);
        zzkt zzp = zzd.zzp();
        if (this.zzc - 1 != 0) {
            ofTelemetry = Event.ofData(zzhiVar.zza(), zzp);
        } else {
            ofTelemetry = Event.ofTelemetry(zzhiVar.zza(), zzp);
        }
        Preconditions.checkNotNull(ofTelemetry);
        this.zza.send(ofTelemetry);
    }
}
