package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.wrappers.Wrappers;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aqk */
/* loaded from: classes2.dex */
public final class aqk implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: g */
    private Context f4886g;

    /* renamed from: b */
    private final Object f4881b = new Object();

    /* renamed from: c */
    private final ConditionVariable f4882c = new ConditionVariable();

    /* renamed from: d */
    private volatile boolean f4883d = false;

    /* renamed from: a */
    volatile boolean f4880a = false;

    /* renamed from: e */
    private SharedPreferences f4884e = null;

    /* renamed from: f */
    private Bundle f4885f = new Bundle();

    /* renamed from: h */
    private JSONObject f4887h = new JSONObject();

    /* renamed from: f */
    private final void m4756f() {
        if (this.f4884e == null) {
            return;
        }
        try {
            this.f4887h = new JSONObject((String) aqm.m4754a(new atn() { // from class: com.google.ads.interactivemedia.v3.internal.aqh
                @Override // com.google.ads.interactivemedia.p034v3.internal.atn
                /* renamed from: a */
                public final Object mo1308a() {
                    return aqk.this.m4758d();
                }
            }));
        } catch (JSONException unused) {
        }
    }

    /* renamed from: b */
    public final Object m4760b(final aqf aqfVar) {
        if (!this.f4882c.block(5000L)) {
            synchronized (this.f4881b) {
                if (!this.f4880a) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.f4883d || this.f4884e == null) {
            synchronized (this.f4881b) {
                if (this.f4883d && this.f4884e != null) {
                }
                return aqfVar.m4769g();
            }
        }
        if (aqfVar.m4772d() == 2) {
            Bundle bundle = this.f4885f;
            return bundle == null ? aqfVar.m4769g() : aqfVar.mo4774b(bundle);
        } else if (aqfVar.m4772d() != 1 || !this.f4887h.has(aqfVar.m4768h())) {
            return aqm.m4754a(new atn() { // from class: com.google.ads.interactivemedia.v3.internal.aqi
                @Override // com.google.ads.interactivemedia.p034v3.internal.atn
                /* renamed from: a */
                public final Object mo1308a() {
                    return aqk.this.m4759c(aqfVar);
                }
            });
        } else {
            return aqfVar.mo4775a(this.f4887h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ Object m4759c(aqf aqfVar) {
        return aqfVar.mo4773c(this.f4884e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ String m4758d() {
        return this.f4884e.getString("flag_configuration", JsonUtils.EMPTY_JSON);
    }

    /* renamed from: e */
    public final void m4757e(Context context) {
        if (this.f4883d) {
            return;
        }
        synchronized (this.f4881b) {
            if (this.f4883d) {
                return;
            }
            if (!this.f4880a) {
                this.f4880a = true;
            }
            Context applicationContext = context.getApplicationContext() == null ? context : context.getApplicationContext();
            this.f4886g = applicationContext;
            try {
                this.f4885f = Wrappers.packageManager(applicationContext).getApplicationInfo(this.f4886g.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            }
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (remoteContext != null || context == null || (remoteContext = context.getApplicationContext()) != null) {
                context = remoteContext;
            }
            if (context == null) {
                this.f4880a = false;
                this.f4882c.open();
                return;
            }
            apz.m4777c();
            SharedPreferences sharedPreferences = context.getSharedPreferences("google_ads_flags", 0);
            this.f4884e = sharedPreferences;
            if (sharedPreferences != null) {
                sharedPreferences.registerOnSharedPreferenceChangeListener(this);
            }
            aqs.m4747c(new aqj(this));
            m4756f();
            this.f4883d = true;
            this.f4880a = false;
            this.f4882c.open();
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            m4756f();
        }
    }
}
