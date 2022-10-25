package com.google.android.gms.internal.safetynet;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.safetynet.SafetyNet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class zzf<R extends Result> extends BaseImplementation.ApiMethodImpl<R, zzx> {
    public zzf(GoogleApiClient googleApiClient) {
        super(SafetyNet.API, googleApiClient);
    }
}
