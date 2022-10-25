package com.google.ads.interactivemedia.p034v3.internal;

import android.content.SharedPreferences;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aqj */
/* loaded from: classes2.dex */
public final class aqj implements aqq {

    /* renamed from: a */
    final /* synthetic */ aqk f4879a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aqj(aqk aqkVar) {
        this.f4879a = aqkVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aqq
    /* renamed from: a */
    public final Boolean mo4751a(String str, boolean z) {
        SharedPreferences sharedPreferences;
        sharedPreferences = this.f4879a.f4884e;
        return Boolean.valueOf(sharedPreferences.getBoolean(str, z));
    }
}
