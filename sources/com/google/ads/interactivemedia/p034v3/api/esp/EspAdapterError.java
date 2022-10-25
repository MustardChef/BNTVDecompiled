package com.google.ads.interactivemedia.p034v3.api.esp;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.api.esp.EspAdapterError */
/* loaded from: classes2.dex */
public class EspAdapterError extends Exception {

    /* renamed from: a */
    private final int f2844a;

    /* compiled from: IMASDK */
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.google.ads.interactivemedia.v3.api.esp.EspAdapterError$ErrorCodes */
    /* loaded from: classes2.dex */
    public @interface ErrorCodes {
        public static final int NOT_ENABLED = 101;
        public static final int UNKNOWN_ERROR = 100;
    }

    public EspAdapterError(int i, String str, Throwable th) {
        super(str, th);
        this.f2844a = i;
    }

    public int getErrorCode() {
        return this.f2844a;
    }
}
