package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.messaging.Constants;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzo {
    private final zzfu zza;

    public zzo(zzfu zzfuVar) {
        this.zza = zzfuVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        this.zza.zzp().zzc();
        if (zzd()) {
            if (zzc()) {
                this.zza.zzb().zzv.zza(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", SDKConstants.PARAM_INTENT);
                bundle.putLong("_cc", 1L);
                this.zza.zzg().zza("auto", "_cmpx", bundle);
            } else {
                String zza = this.zza.zzb().zzv.zza();
                if (TextUtils.isEmpty(zza)) {
                    this.zza.zzq().zzf().zza("Cache still valid but referrer not found");
                } else {
                    long zza2 = ((this.zza.zzb().zzw.zza() / 3600000) - 1) * 3600000;
                    Uri parse = Uri.parse(zza);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(parse.getPath(), bundle2);
                    for (String str : parse.getQueryParameterNames()) {
                        bundle2.putString(str, parse.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", zza2);
                    this.zza.zzg().zza((String) pair.first, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, (Bundle) pair.second);
                }
                this.zza.zzb().zzv.zza(null);
            }
            this.zza.zzb().zzw.zza(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(String str, Bundle bundle) {
        String str2;
        this.zza.zzp().zzc();
        if (this.zza.zzaa()) {
            return;
        }
        if (bundle == null || bundle.isEmpty()) {
            str2 = null;
        } else {
            str = (str == null || str.isEmpty()) ? "auto" : "auto";
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str3 : bundle.keySet()) {
                builder.appendQueryParameter(str3, bundle.getString(str3));
            }
            str2 = builder.build().toString();
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.zza.zzb().zzv.zza(str2);
        this.zza.zzb().zzw.zza(this.zza.zzl().currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb() {
        if (zzd() && zzc()) {
            this.zza.zzb().zzv.zza(null);
        }
    }

    private final boolean zzc() {
        return zzd() && this.zza.zzl().currentTimeMillis() - this.zza.zzb().zzw.zza() > this.zza.zza().zza((String) null, zzas.zzcd);
    }

    private final boolean zzd() {
        return this.zza.zzb().zzw.zza() > 0;
    }
}
