package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.arg */
/* loaded from: classes2.dex */
public final class arg extends GoogleApi implements arb {

    /* renamed from: a */
    private static final Api.ClientKey f4930a;

    /* renamed from: b */
    private static final Api.AbstractClientBuilder f4931b;

    /* renamed from: c */
    private static final Api f4932c;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        f4930a = clientKey;
        are areVar = new are();
        f4931b = areVar;
        f4932c = new Api("SignalSdk.API", areVar, clientKey);
    }

    public arg(Context context) {
        super(context, f4932c, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
