package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public final class zal {
    private final SparseIntArray zaa;
    private GoogleApiAvailabilityLight zab;

    public zal() {
        this(GoogleApiAvailability.getInstance());
    }

    public final int zaa(Context context, Api.Client client) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(client);
        int i = 0;
        if (client.requiresGooglePlayServices()) {
            int minApkVersion = client.getMinApkVersion();
            int zab = zab(context, minApkVersion);
            if (zab == -1) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.zaa.size()) {
                        i = -1;
                        break;
                    }
                    int keyAt = this.zaa.keyAt(i2);
                    if (keyAt > minApkVersion && this.zaa.get(keyAt) == 0) {
                        break;
                    }
                    i2++;
                }
                zab = i == -1 ? this.zab.isGooglePlayServicesAvailable(context, minApkVersion) : i;
                this.zaa.put(minApkVersion, zab);
            }
            return zab;
        }
        return 0;
    }

    public final int zab(Context context, int i) {
        return this.zaa.get(i, -1);
    }

    public final void zac() {
        this.zaa.clear();
    }

    public zal(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.zaa = new SparseIntArray();
        Preconditions.checkNotNull(googleApiAvailabilityLight);
        this.zab = googleApiAvailabilityLight;
    }
}
