package com.applovin.impl.communicator;

import android.content.Context;
import android.content.IntentFilter;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.applovin.impl.communicator.a */
/* loaded from: classes.dex */
public class C1324a {

    /* renamed from: a */
    private final Context f779a;

    /* renamed from: b */
    private final Set<C1325b> f780b = new HashSet(32);

    /* renamed from: c */
    private final Object f781c = new Object();

    public C1324a(Context context) {
        this.f779a = context;
    }

    /* renamed from: a */
    private C1325b m7853a(String str, AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
        for (C1325b c1325b : this.f780b) {
            if (str.equals(c1325b.m7851a()) && appLovinCommunicatorSubscriber.equals(c1325b.m7849b())) {
                return c1325b;
            }
        }
        return null;
    }

    /* renamed from: a */
    public boolean m7854a(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        if (appLovinCommunicatorSubscriber == null || !StringUtils.isValidString(str)) {
            C1710r.m6310i("AppLovinCommunicator", "Unable to subscribe - invalid subscriber (" + appLovinCommunicatorSubscriber + ") or topic (" + str + ")");
            return false;
        }
        synchronized (this.f781c) {
            C1325b m7853a = m7853a(str, appLovinCommunicatorSubscriber);
            if (m7853a == null) {
                C1325b c1325b = new C1325b(str, appLovinCommunicatorSubscriber);
                this.f780b.add(c1325b);
                AppLovinBroadcastManager.getInstance(this.f779a).registerReceiver(c1325b, new IntentFilter(str));
                return true;
            }
            C1710r.m6310i("AppLovinCommunicator", "Attempting to re-subscribe subscriber (" + appLovinCommunicatorSubscriber + ") to topic (" + str + ")");
            if (!m7853a.m7848c()) {
                m7853a.m7850a(true);
                AppLovinBroadcastManager.getInstance(this.f779a).registerReceiver(m7853a, new IntentFilter(str));
            }
            return true;
        }
    }

    /* renamed from: b */
    public void m7852b(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        C1325b m7853a;
        if (StringUtils.isValidString(str)) {
            synchronized (this.f781c) {
                m7853a = m7853a(str, appLovinCommunicatorSubscriber);
            }
            if (m7853a != null) {
                m7853a.m7850a(false);
                AppLovinBroadcastManager.getInstance(this.f779a).unregisterReceiver(m7853a);
            }
        }
    }
}
