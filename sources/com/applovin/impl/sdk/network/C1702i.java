package com.applovin.impl.sdk.network;

import android.os.Bundle;

/* renamed from: com.applovin.impl.sdk.network.i */
/* loaded from: classes.dex */
public class C1702i {

    /* renamed from: a */
    private final Bundle f2436a;

    /* renamed from: com.applovin.impl.sdk.network.i$a */
    /* loaded from: classes.dex */
    public static class C1704a {

        /* renamed from: a */
        private final Bundle f2437a;

        public C1704a() {
            this(null);
        }

        public C1704a(C1702i c1702i) {
            this.f2437a = new Bundle();
            if (c1702i != null) {
                for (String str : c1702i.m6365a().keySet()) {
                    m6361a(str, c1702i.m6365a().getString(str));
                }
            }
        }

        /* renamed from: a */
        public C1704a m6362a(String str) {
            if (str != null) {
                this.f2437a.remove(str);
                return this;
            }
            throw new IllegalArgumentException("No key specified.");
        }

        /* renamed from: a */
        public C1704a m6361a(String str, String str2) {
            if (str != null) {
                this.f2437a.putString(str, str2);
                return this;
            }
            throw new IllegalArgumentException("No key specified");
        }

        /* renamed from: a */
        public C1702i m6364a() {
            return new C1702i(this);
        }
    }

    private C1702i(C1704a c1704a) {
        this.f2436a = new Bundle(c1704a.f2437a);
    }

    /* renamed from: a */
    public Bundle m6365a() {
        return this.f2436a;
    }

    public String toString() {
        return "RequestParameters{extraParameters=" + this.f2436a + '}';
    }
}
