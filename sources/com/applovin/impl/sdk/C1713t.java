package com.applovin.impl.sdk;

import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.applovin.impl.sdk.t */
/* loaded from: classes.dex */
public class C1713t {

    /* renamed from: a */
    private final Queue<AppLovinAdBase> f2465a = new LinkedList();

    /* renamed from: b */
    private final Object f2466b = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m6305a() {
        int size;
        synchronized (this.f2466b) {
            size = this.f2465a.size();
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m6304a(AppLovinAdBase appLovinAdBase) {
        synchronized (this.f2466b) {
            if (m6305a() <= 25) {
                this.f2465a.offer(appLovinAdBase);
            } else {
                C1710r.m6310i("AppLovinSdk", "Maximum queue capacity reached - discarding ad...");
            }
        }
    }

    /* renamed from: b */
    boolean m6303b() {
        boolean z;
        synchronized (this.f2466b) {
            z = m6305a() == 0;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public AppLovinAdBase m6302c() {
        AppLovinAdBase poll;
        synchronized (this.f2466b) {
            poll = !m6303b() ? this.f2465a.poll() : null;
        }
        return poll;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public AppLovinAdBase m6301d() {
        AppLovinAdBase peek;
        synchronized (this.f2466b) {
            peek = this.f2465a.peek();
        }
        return peek;
    }
}
