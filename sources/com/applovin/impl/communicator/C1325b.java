package com.applovin.impl.communicator;

import android.content.Context;
import android.content.Intent;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1710r;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.applovin.impl.communicator.b */
/* loaded from: classes.dex */
public class C1325b implements AppLovinBroadcastManager.Receiver {

    /* renamed from: b */
    private final String f783b;

    /* renamed from: c */
    private final WeakReference<AppLovinCommunicatorSubscriber> f784c;

    /* renamed from: a */
    private boolean f782a = true;

    /* renamed from: d */
    private final Set<CommunicatorMessageImpl> f785d = new LinkedHashSet();

    /* renamed from: e */
    private final Object f786e = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1325b(String str, AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
        this.f783b = str;
        this.f784c = new WeakReference<>(appLovinCommunicatorSubscriber);
    }

    /* renamed from: a */
    public String m7851a() {
        return this.f783b;
    }

    /* renamed from: a */
    public void m7850a(boolean z) {
        this.f782a = z;
    }

    /* renamed from: b */
    public AppLovinCommunicatorSubscriber m7849b() {
        return this.f784c.get();
    }

    /* renamed from: c */
    public boolean m7848c() {
        return this.f782a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1325b) {
            C1325b c1325b = (C1325b) obj;
            if (m7851a().equals(c1325b.m7851a())) {
                if (this.f784c.get() != null) {
                    if (this.f784c.get().equals(c1325b.f784c.get())) {
                        return true;
                    }
                } else if (this.f784c.get() == c1325b.f784c.get()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (this.f783b.hashCode() * 31) + (this.f784c.get() != null ? this.f784c.get().hashCode() : 0);
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        if (m7849b() == null) {
            C1710r.m6310i("AppLovinCommunicator", "Message received for GC'd subscriber");
            return;
        }
        CommunicatorMessageImpl communicatorMessageImpl = (CommunicatorMessageImpl) intent;
        boolean z = false;
        synchronized (this.f786e) {
            if (!this.f785d.contains(communicatorMessageImpl)) {
                this.f785d.add(communicatorMessageImpl);
                z = true;
            }
        }
        if (z) {
            m7849b().onMessageReceived((AppLovinCommunicatorMessage) communicatorMessageImpl);
        }
    }
}
