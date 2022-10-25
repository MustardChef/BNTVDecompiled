package com.lagradost.cloudstream3.services;

import okhttp3.Interceptor;
import okhttp3.Response;

/* compiled from: lambda */
/* renamed from: com.lagradost.cloudstream3.services.-$$Lambda$ApiUtils$bDXlutHUzLCg3HelnBfEzhZ7gME  reason: invalid class name */
/* loaded from: classes3.dex */
public final /* synthetic */ class $$Lambda$ApiUtils$bDXlutHUzLCg3HelnBfEzhZ7gME implements Interceptor {
    public static final /* synthetic */ $$Lambda$ApiUtils$bDXlutHUzLCg3HelnBfEzhZ7gME INSTANCE = new $$Lambda$ApiUtils$bDXlutHUzLCg3HelnBfEzhZ7gME();

    private /* synthetic */ $$Lambda$ApiUtils$bDXlutHUzLCg3HelnBfEzhZ7gME() {
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        Response m8604createService$lambda0;
        m8604createService$lambda0 = ApiUtils.m8604createService$lambda0(chain);
        return m8604createService$lambda0;
    }
}
