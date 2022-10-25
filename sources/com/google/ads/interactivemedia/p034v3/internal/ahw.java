package com.google.ads.interactivemedia.p034v3.internal;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ahw */
/* loaded from: classes2.dex */
public final class ahw extends ahr {
    public ahw(ahl ahlVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(ahlVar, hashSet, jSONObject, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.ahs
    /* renamed from: a */
    public final void mo5231a(String str) {
        agq m5331a;
        if (!TextUtils.isEmpty(str) && (m5331a = agq.m5331a()) != null) {
            for (agj agjVar : m5331a.m5329c()) {
                if (this.f4098a.contains(agjVar.m5342i())) {
                    agjVar.m5343h().m5287e(str, this.f4100c);
                }
            }
        }
        super.onPostExecute(str);
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        if (ahi.m5269j(this.f4099b, this.f4102d.m5254a())) {
            return null;
        }
        this.f4102d.m5250e(this.f4099b);
        return this.f4099b.toString();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ahs, android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        onPostExecute((String) obj);
    }
}
