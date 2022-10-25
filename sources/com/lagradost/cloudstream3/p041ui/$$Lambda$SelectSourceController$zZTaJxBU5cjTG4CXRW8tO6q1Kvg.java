package com.lagradost.cloudstream3.p041ui;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;

/* compiled from: lambda */
/* renamed from: com.lagradost.cloudstream3.ui.-$$Lambda$SelectSourceController$zZTaJxBU5cjTG4CXRW8tO6q1Kvg  reason: invalid class name */
/* loaded from: classes.dex */
public final /* synthetic */ class $$Lambda$SelectSourceController$zZTaJxBU5cjTG4CXRW8tO6q1Kvg implements ResultCallback {
    public static final /* synthetic */ $$Lambda$SelectSourceController$zZTaJxBU5cjTG4CXRW8tO6q1Kvg INSTANCE = new $$Lambda$SelectSourceController$zZTaJxBU5cjTG4CXRW8tO6q1Kvg();

    private /* synthetic */ $$Lambda$SelectSourceController$zZTaJxBU5cjTG4CXRW8tO6q1Kvg() {
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void onResult(Result result) {
        SelectSourceController.m8610lambda11$lambda7$lambda6((RemoteMediaClient.MediaChannelResult) result);
    }
}
