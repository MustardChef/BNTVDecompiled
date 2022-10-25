package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class AppLovinBroadcastManager {

    /* renamed from: f */
    private static AppLovinBroadcastManager f1428f;

    /* renamed from: g */
    private static final Object f1429g = new Object();

    /* renamed from: a */
    private final Context f1430a;

    /* renamed from: b */
    private final HashMap<Receiver, ArrayList<C1522b>> f1431b = new HashMap<>();

    /* renamed from: c */
    private final HashMap<String, ArrayList<C1522b>> f1432c = new HashMap<>();

    /* renamed from: d */
    private final ArrayList<C1521a> f1433d = new ArrayList<>();

    /* renamed from: e */
    private final Handler f1434e = new Handler(Looper.getMainLooper()) { // from class: com.applovin.impl.sdk.AppLovinBroadcastManager.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                AppLovinBroadcastManager.this.m7260a();
            } else {
                super.handleMessage(message);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface Receiver {
        void onReceive(Context context, Intent intent, Map<String, Object> map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.applovin.impl.sdk.AppLovinBroadcastManager$a */
    /* loaded from: classes.dex */
    public static class C1521a {

        /* renamed from: a */
        final Intent f1436a;

        /* renamed from: b */
        final Map<String, Object> f1437b;

        /* renamed from: c */
        final List<C1522b> f1438c;

        C1521a(Intent intent, Map<String, Object> map, List<C1522b> list) {
            this.f1436a = intent;
            this.f1437b = map;
            this.f1438c = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.applovin.impl.sdk.AppLovinBroadcastManager$b */
    /* loaded from: classes.dex */
    public static class C1522b {

        /* renamed from: a */
        final IntentFilter f1439a;

        /* renamed from: b */
        final Receiver f1440b;

        /* renamed from: c */
        boolean f1441c;

        /* renamed from: d */
        boolean f1442d;

        C1522b(IntentFilter intentFilter, Receiver receiver) {
            this.f1439a = intentFilter;
            this.f1440b = receiver;
        }
    }

    private AppLovinBroadcastManager(Context context) {
        this.f1430a = context;
    }

    /* renamed from: a */
    private List<C1522b> m7259a(Intent intent) {
        synchronized (this.f1431b) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f1430a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            ArrayList<C1522b> arrayList = this.f1432c.get(action);
            if (arrayList == null) {
                return null;
            }
            ArrayList<C1522b> arrayList2 = null;
            for (C1522b c1522b : arrayList) {
                if (!c1522b.f1441c && c1522b.f1439a.match(action, resolveTypeIfNeeded, scheme, data, categories, "AppLovinBroadcastManager") >= 0) {
                    ArrayList arrayList3 = arrayList2 == null ? new ArrayList() : arrayList2;
                    arrayList3.add(c1522b);
                    c1522b.f1441c = true;
                    arrayList2 = arrayList3;
                }
            }
            if (arrayList2 == null) {
                return null;
            }
            for (C1522b c1522b2 : arrayList2) {
                c1522b2.f1441c = false;
            }
            return arrayList2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7260a() {
        int size;
        C1521a[] c1521aArr;
        while (true) {
            synchronized (this.f1431b) {
                size = this.f1433d.size();
                if (size <= 0) {
                    return;
                }
                c1521aArr = new C1521a[size];
                this.f1433d.toArray(c1521aArr);
                this.f1433d.clear();
            }
            for (int i = 0; i < size; i++) {
                C1521a c1521a = c1521aArr[i];
                if (c1521a != null) {
                    for (C1522b c1522b : c1521a.f1438c) {
                        if (c1522b != null && !c1522b.f1442d) {
                            c1522b.f1440b.onReceive(this.f1430a, c1521a.f1436a, c1521a.f1437b);
                        }
                    }
                }
            }
        }
    }

    public static AppLovinBroadcastManager getInstance(Context context) {
        AppLovinBroadcastManager appLovinBroadcastManager;
        synchronized (f1429g) {
            if (f1428f == null) {
                f1428f = new AppLovinBroadcastManager(context.getApplicationContext());
            }
            appLovinBroadcastManager = f1428f;
        }
        return appLovinBroadcastManager;
    }

    public void registerReceiver(Receiver receiver, IntentFilter intentFilter) {
        synchronized (this.f1431b) {
            C1522b c1522b = new C1522b(intentFilter, receiver);
            ArrayList<C1522b> arrayList = this.f1431b.get(receiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f1431b.put(receiver, arrayList);
            }
            arrayList.add(c1522b);
            Iterator<String> actionsIterator = intentFilter.actionsIterator();
            while (actionsIterator.hasNext()) {
                String next = actionsIterator.next();
                ArrayList<C1522b> arrayList2 = this.f1432c.get(next);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f1432c.put(next, arrayList2);
                }
                arrayList2.add(c1522b);
            }
        }
    }

    public boolean sendBroadcast(Intent intent, Map<String, Object> map) {
        synchronized (this.f1431b) {
            List<C1522b> m7259a = m7259a(intent);
            if (m7259a == null) {
                return false;
            }
            this.f1433d.add(new C1521a(intent, map, m7259a));
            if (!this.f1434e.hasMessages(1)) {
                this.f1434e.sendEmptyMessage(1);
            }
            return true;
        }
    }

    public void sendBroadcastSync(Intent intent, Map<String, Object> map) {
        List<C1522b> m7259a = m7259a(intent);
        if (m7259a == null) {
            return;
        }
        for (C1522b c1522b : m7259a) {
            if (!c1522b.f1442d) {
                c1522b.f1440b.onReceive(this.f1430a, intent, map);
            }
        }
    }

    public void sendBroadcastSyncWithPendingBroadcasts(Intent intent, Map<String, Object> map) {
        if (sendBroadcast(intent, map)) {
            m7260a();
        }
    }

    public boolean sendBroadcastWithAdObject(String str, Object obj) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("ad", obj);
        return sendBroadcast(new Intent(str), hashMap);
    }

    public void unregisterReceiver(Receiver receiver) {
        synchronized (this.f1431b) {
            ArrayList<C1522b> remove = this.f1431b.remove(receiver);
            if (remove == null) {
                return;
            }
            for (C1522b c1522b : remove) {
                c1522b.f1442d = true;
                Iterator<String> actionsIterator = c1522b.f1439a.actionsIterator();
                while (actionsIterator.hasNext()) {
                    String next = actionsIterator.next();
                    ArrayList<C1522b> arrayList = this.f1432c.get(next);
                    if (arrayList != null) {
                        Iterator<C1522b> it = arrayList.iterator();
                        while (it.hasNext()) {
                            if (it.next().f1440b == receiver) {
                                c1522b.f1442d = true;
                                it.remove();
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.f1432c.remove(next);
                        }
                    }
                }
            }
        }
    }
}
