package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.utils.AppKilledService;
import com.applovin.impl.sdk.utils.C1757j;
import com.applovin.impl.sdk.utils.StringUtils;
import com.google.android.gms.cast.MediaError;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.r */
/* loaded from: classes.dex */
public class C1710r {

    /* renamed from: a */
    private final C1662k f2458a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1710r(final C1662k c1662k) {
        this.f2458a = c1662k;
        if (c1662k.m6611e()) {
            return;
        }
        m6323a("SDK Session Begin");
        c1662k.m6631ai().registerReceiver(new AppLovinBroadcastManager.Receiver() { // from class: com.applovin.impl.sdk.r.1
            @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
            public void onReceive(Context context, Intent intent, Map<String, Object> map) {
                C1710r.this.m6323a("SDK Session End");
                c1662k.m6631ai().unregisterReceiver(this);
            }
        }, new IntentFilter(AppKilledService.ACTION_APP_KILLED));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6323a(String str) {
        C1757j c1757j = new C1757j();
        c1757j.m6200a().m6195a(str).m6200a();
        m6313f("AppLovinSdk", c1757j.toString());
    }

    /* renamed from: a */
    private void m6320a(String str, String str2, boolean z) {
        int intValue;
        if (StringUtils.isValidString(str2) && (intValue = ((Integer) this.f2458a.m6656a(C1568b.f1691ak)).intValue()) > 0) {
            int length = str2.length();
            int i = ((length + intValue) - 1) / intValue;
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = i2 * intValue;
                String substring = str2.substring(i3, Math.min(length, i3 + intValue));
                if (z) {
                    Log.d(str, substring);
                } else {
                    m6319b(str, substring);
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m6325a() {
        return this.f2458a.m6678I().m6994d();
    }

    /* renamed from: c */
    public static void m6316c(String str, String str2, Throwable th) {
        Log.e("AppLovinSdk", "[" + str + "] " + str2, th);
    }

    /* renamed from: f */
    public static void m6313f(String str, String str2) {
        Log.d("AppLovinSdk", "[" + str + "] " + str2);
    }

    /* renamed from: g */
    public static void m6312g(String str, String str2) {
        Log.i("AppLovinSdk", "[" + str + "] " + str2);
    }

    /* renamed from: h */
    public static void m6311h(String str, String str2) {
        Log.w("AppLovinSdk", "[" + str + "] " + str2);
    }

    /* renamed from: i */
    public static void m6310i(String str, String str2) {
        m6316c(str, str2, null);
    }

    /* renamed from: j */
    private void m6309j(String str, String str2) {
    }

    /* renamed from: a */
    public void m6322a(String str, String str2) {
        if (m6325a()) {
            m6320a(str, str2, false);
        }
    }

    /* renamed from: a */
    public void m6321a(String str, String str2, Throwable th) {
        if (m6325a()) {
            String str3 = "[" + str + "] " + str2;
            Log.w("AppLovinSdk", str3, th);
            m6309j("WARN", str3);
        }
    }

    /* renamed from: b */
    public void m6319b(String str, String str2) {
        if (m6325a()) {
            String str3 = "[" + str + "] " + str2;
            Log.d("AppLovinSdk", str3);
            m6309j("DEBUG", str3);
        }
    }

    /* renamed from: b */
    public void m6318b(String str, String str2, Throwable th) {
        if (m6325a()) {
            String str3 = "[" + str + "] " + str2;
            Log.e("AppLovinSdk", str3, th);
            m6309j(MediaError.ERROR_TYPE_ERROR, str3 + " : " + th);
        }
    }

    /* renamed from: c */
    public void m6317c(String str, String str2) {
        if (m6325a()) {
            String str3 = "[" + str + "] " + str2;
            Log.i("AppLovinSdk", str3);
            m6309j("INFO", str3);
        }
    }

    /* renamed from: d */
    public void m6315d(String str, String str2) {
        m6321a(str, str2, (Throwable) null);
    }

    /* renamed from: e */
    public void m6314e(String str, String str2) {
        m6318b(str, str2, null);
    }
}
