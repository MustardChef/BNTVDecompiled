package com.google.firebase.heartbeatinfo;

import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
final /* synthetic */ class DefaultHeartBeatInfo$$Lambda$3 implements Callable {
    private final DefaultHeartBeatInfo arg$1;
    private final String arg$2;

    private DefaultHeartBeatInfo$$Lambda$3(DefaultHeartBeatInfo defaultHeartBeatInfo, String str) {
        this.arg$1 = defaultHeartBeatInfo;
        this.arg$2 = str;
    }

    public static Callable lambdaFactory$(DefaultHeartBeatInfo defaultHeartBeatInfo, String str) {
        return new DefaultHeartBeatInfo$$Lambda$3(defaultHeartBeatInfo, str);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return DefaultHeartBeatInfo.lambda$storeHeartBeatInfo$3(this.arg$1, this.arg$2);
    }
}
