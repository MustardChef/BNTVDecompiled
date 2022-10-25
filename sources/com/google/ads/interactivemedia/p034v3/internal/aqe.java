package com.google.ads.interactivemedia.p034v3.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aqe */
/* loaded from: classes2.dex */
public final class aqe extends aqf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public aqe(String str, String str2) {
        super(1, str, str2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aqf
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo4775a(JSONObject jSONObject) {
        return jSONObject.optString(m4768h(), (String) m4769g());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aqf
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ Object mo4774b(Bundle bundle) {
        String m4768h = m4768h();
        if (bundle.containsKey(m4768h.length() != 0 ? "com.google.android.gms.ads.flag.".concat(m4768h) : new String("com.google.android.gms.ads.flag."))) {
            String m4768h2 = m4768h();
            return bundle.getString(m4768h2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(m4768h2) : new String("com.google.android.gms.ads.flag."));
        }
        return (String) m4769g();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aqf
    /* renamed from: c */
    public final /* bridge */ /* synthetic */ Object mo4773c(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(m4768h(), (String) m4769g());
    }
}
