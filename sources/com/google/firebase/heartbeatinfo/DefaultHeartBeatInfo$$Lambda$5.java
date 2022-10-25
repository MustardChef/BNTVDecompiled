package com.google.firebase.heartbeatinfo;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes3.dex */
final /* synthetic */ class DefaultHeartBeatInfo$$Lambda$5 implements ThreadFactory {
    private static final DefaultHeartBeatInfo$$Lambda$5 instance = new DefaultHeartBeatInfo$$Lambda$5();

    private DefaultHeartBeatInfo$$Lambda$5() {
    }

    public static ThreadFactory lambdaFactory$() {
        return instance;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return DefaultHeartBeatInfo.lambda$static$0(runnable);
    }
}
