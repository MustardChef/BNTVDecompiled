package com.applovin.communicator;

import android.content.Context;
import com.applovin.impl.communicator.C1324a;
import com.applovin.impl.communicator.MessagingServiceImpl;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class AppLovinCommunicator {

    /* renamed from: a */
    private static AppLovinCommunicator f173a;

    /* renamed from: b */
    private static final Object f174b = new Object();

    /* renamed from: c */
    private C1662k f175c;

    /* renamed from: d */
    private C1710r f176d;

    /* renamed from: e */
    private final C1324a f177e;

    /* renamed from: f */
    private final MessagingServiceImpl f178f;

    private AppLovinCommunicator(Context context) {
        this.f177e = new C1324a(context);
        this.f178f = new MessagingServiceImpl(context);
    }

    /* renamed from: a */
    private void m8432a(String str) {
        C1710r c1710r = this.f176d;
        if (c1710r != null) {
            c1710r.m6319b("AppLovinCommunicator", str);
        }
    }

    public static AppLovinCommunicator getInstance(Context context) {
        synchronized (f174b) {
            if (f173a == null) {
                f173a = new AppLovinCommunicator(context.getApplicationContext());
            }
        }
        return f173a;
    }

    /* renamed from: a */
    public void m8433a(C1662k c1662k) {
        this.f175c = c1662k;
        this.f176d = c1662k.m6588z();
        m8432a("Attached SDK instance: " + c1662k + "...");
    }

    public AppLovinCommunicatorMessagingService getMessagingService() {
        return this.f178f;
    }

    public void subscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        subscribe(appLovinCommunicatorSubscriber, Collections.singletonList(str));
    }

    public void subscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, List<String> list) {
        for (String str : list) {
            if (this.f177e.m7854a(appLovinCommunicatorSubscriber, str)) {
                this.f178f.maybeFlushStickyMessages(str);
            } else {
                m8432a("Unable to subscribe " + appLovinCommunicatorSubscriber + " to topic: " + str);
            }
        }
    }

    public String toString() {
        return "AppLovinCommunicator{sdk=" + this.f175c + '}';
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        unsubscribe(appLovinCommunicatorSubscriber, Collections.singletonList(str));
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, List<String> list) {
        for (String str : list) {
            m8432a("Unsubscribing " + appLovinCommunicatorSubscriber + " from topic: " + str);
            this.f177e.m7852b(appLovinCommunicatorSubscriber, str);
        }
    }
}
