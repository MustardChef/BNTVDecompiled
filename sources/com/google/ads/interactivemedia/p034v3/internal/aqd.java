package com.google.ads.interactivemedia.p034v3.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aqd */
/* loaded from: classes2.dex */
public final class aqd extends aqf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public aqd(String str, Float f) {
        super(1, str, f);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aqf
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo4775a(JSONObject jSONObject) {
        return Float.valueOf((float) jSONObject.optDouble(m4768h(), ((Float) m4769g()).floatValue()));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aqf
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ Object mo4774b(Bundle bundle) {
        String m4768h = m4768h();
        if (bundle.containsKey(m4768h.length() != 0 ? "com.google.android.gms.ads.flag.".concat(m4768h) : new String("com.google.android.gms.ads.flag."))) {
            String m4768h2 = m4768h();
            return Float.valueOf(bundle.getFloat(m4768h2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(m4768h2) : new String("com.google.android.gms.ads.flag.")));
        }
        return (Float) m4769g();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aqf
    /* renamed from: c */
    public final /* bridge */ /* synthetic */ Object mo4773c(SharedPreferences sharedPreferences) {
        return Float.valueOf(sharedPreferences.getFloat(m4768h(), ((Float) m4769g()).floatValue()));
    }
}
