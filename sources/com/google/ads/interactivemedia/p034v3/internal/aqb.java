package com.google.ads.interactivemedia.p034v3.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aqb */
/* loaded from: classes2.dex */
public final class aqb extends aqf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public aqb(String str, Integer num) {
        super(1, str, num);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aqf
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo4775a(JSONObject jSONObject) {
        return Integer.valueOf(jSONObject.optInt(m4768h(), ((Integer) m4769g()).intValue()));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aqf
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ Object mo4774b(Bundle bundle) {
        String m4768h = m4768h();
        if (bundle.containsKey(m4768h.length() != 0 ? "com.google.android.gms.ads.flag.".concat(m4768h) : new String("com.google.android.gms.ads.flag."))) {
            String m4768h2 = m4768h();
            return Integer.valueOf(bundle.getInt(m4768h2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(m4768h2) : new String("com.google.android.gms.ads.flag.")));
        }
        return (Integer) m4769g();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aqf
    /* renamed from: c */
    public final /* bridge */ /* synthetic */ Object mo4773c(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(m4768h(), ((Integer) m4769g()).intValue()));
    }
}
