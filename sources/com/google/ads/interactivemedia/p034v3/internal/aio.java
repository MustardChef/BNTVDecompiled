package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aio */
/* loaded from: classes2.dex */
public abstract class aio {
    public static aio create(int i, String str) {
        return new aix(i, str);
    }

    public abstract int appVersion();

    public abstract String packageName();
}
