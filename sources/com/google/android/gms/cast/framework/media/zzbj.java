package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzbj extends BasePendingResult<RemoteMediaClient.MediaChannelResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbj() {
        super((GoogleApiClient) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ RemoteMediaClient.MediaChannelResult createFailedResult(Status status) {
        return new zzbi(this, status);
    }
}
