package com.google.ads.interactivemedia.p034v3.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aqc */
/* loaded from: classes2.dex */
public final class aqc extends aqf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public aqc(String str, Long l) {
        super(1, str, l);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aqf
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo4775a(JSONObject jSONObject) {
        return Long.valueOf(jSONObject.optLong(m4768h(), ((Long) m4769g()).longValue()));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aqf
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ Object mo4774b(Bundle bundle) {
        String m4768h = m4768h();
        if (bundle.containsKey(m4768h.length() != 0 ? "com.google.android.gms.ads.flag.".concat(m4768h) : new String("com.google.android.gms.ads.flag."))) {
            String m4768h2 = m4768h();
            return Long.valueOf(bundle.getLong(m4768h2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(m4768h2) : new String("com.google.android.gms.ads.flag.")));
        }
        return (Long) m4769g();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aqf
    /* renamed from: c */
    public final /* bridge */ /* synthetic */ Object mo4773c(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(m4768h(), ((Long) m4769g()).longValue()));
    }
}
