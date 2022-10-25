package com.applovin.impl.sdk.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.network.d */
/* loaded from: classes.dex */
public class C1690d extends BroadcastReceiver {

    /* renamed from: a */
    private final List<InterfaceC1691a> f2394a = Collections.synchronizedList(new ArrayList());

    /* renamed from: com.applovin.impl.sdk.network.d$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1691a {
        /* renamed from: a */
        void mo6463a();

        /* renamed from: b */
        void mo6462b();
    }

    public C1690d(Context context) {
        context.getApplicationContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    /* renamed from: a */
    private static boolean m6466a(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            Object obj = extras.get("networkInfo");
            if (obj instanceof NetworkInfo) {
                return ((NetworkInfo) obj).isConnected();
            }
            return false;
        }
        return false;
    }

    /* renamed from: a */
    public void m6465a(InterfaceC1691a interfaceC1691a) {
        this.f2394a.add(interfaceC1691a);
    }

    /* renamed from: b */
    public void m6464b(InterfaceC1691a interfaceC1691a) {
        this.f2394a.remove(interfaceC1691a);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() == null || !intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") || isInitialStickyBroadcast()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f2394a);
        boolean m6466a = m6466a(intent);
        Iterator it = arrayList.iterator();
        if (m6466a) {
            while (it.hasNext()) {
                ((InterfaceC1691a) it.next()).mo6463a();
            }
            return;
        }
        while (it.hasNext()) {
            ((InterfaceC1691a) it.next()).mo6462b();
        }
    }
}
