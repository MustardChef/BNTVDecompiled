package com.google.android.gms.safetynet;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.safetynet.zzx;
import com.google.android.gms.internal.safetynet.zzy;

/* loaded from: classes3.dex */
public final class SafetyNet {
    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> API;
    private static final Api.AbstractClientBuilder<zzx, Api.ApiOptions.NoOptions> CLIENT_BUILDER;
    private static final Api.ClientKey<zzx> CLIENT_KEY;
    @Deprecated
    public static final SafetyNetApi SafetyNetApi;
    private static final zzo zzu;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.safetynet.zzy, com.google.android.gms.safetynet.zzo] */
    static {
        Api.ClientKey<zzx> clientKey = new Api.ClientKey<>();
        CLIENT_KEY = clientKey;
        zzk zzkVar = new zzk();
        CLIENT_BUILDER = zzkVar;
        API = new Api<>("SafetyNet.API", zzkVar, clientKey);
        SafetyNetApi = new com.google.android.gms.internal.safetynet.zzk();
        zzu = new zzy();
    }

    private SafetyNet() {
    }

    public static SafetyNetClient getClient(Activity activity) {
        return new SafetyNetClient(activity);
    }

    public static SafetyNetClient getClient(Context context) {
        return new SafetyNetClient(context);
    }
}
