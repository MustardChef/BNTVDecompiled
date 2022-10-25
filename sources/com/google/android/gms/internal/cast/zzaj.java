package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzaj<R extends Result> extends BasePendingResult<R> {
    private final zzak<R, Status> zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaj(zzak<R, Status> zzakVar) {
        super((GoogleApiClient) null);
        this.zza = zzakVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final R createFailedResult(Status status) {
        int i = CastSession.zza;
        return status;
    }
}
