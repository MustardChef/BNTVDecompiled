package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.security.Key;
import javax.crypto.Mac;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bfq */
/* loaded from: classes2.dex */
public final class bfq extends ThreadLocal {

    /* renamed from: a */
    final /* synthetic */ bfr f5659a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bfq(bfr bfrVar) {
        this.f5659a = bfrVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    /* renamed from: a */
    public final Mac initialValue() {
        String str;
        Key key;
        try {
            bfj bfjVar = bfj.f5645b;
            str = this.f5659a.f5662c;
            Mac mac = (Mac) bfjVar.m3766a(str);
            key = this.f5659a.f5663d;
            mac.init(key);
            return mac;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
