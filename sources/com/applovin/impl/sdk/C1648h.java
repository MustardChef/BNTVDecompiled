package com.applovin.impl.sdk;

import android.content.Context;
import com.applovin.impl.sdk.p029c.C1570d;
import com.applovin.impl.sdk.p029c.C1571e;

/* renamed from: com.applovin.impl.sdk.h */
/* loaded from: classes.dex */
public class C1648h {

    /* renamed from: a */
    private static final C1649a f2208a = new C1649a("Age Restricted User", C1570d.f1940l);

    /* renamed from: b */
    private static final C1649a f2209b = new C1649a("Has User Consent", C1570d.f1939k);

    /* renamed from: c */
    private static final C1649a f2210c = new C1649a("\"Do Not Sell\"", C1570d.f1941m);

    /* renamed from: com.applovin.impl.sdk.h$a */
    /* loaded from: classes.dex */
    public static class C1649a {

        /* renamed from: a */
        private final String f2211a;

        /* renamed from: b */
        private final C1570d<Boolean> f2212b;

        C1649a(String str, C1570d<Boolean> c1570d) {
            this.f2211a = str;
            this.f2212b = c1570d;
        }

        /* renamed from: a */
        public Boolean m6713a(Context context) {
            return (Boolean) C1571e.m6977b(this.f2212b, (Object) null, context);
        }

        /* renamed from: a */
        public String m6714a() {
            return this.f2211a;
        }

        /* renamed from: b */
        public String m6711b(Context context) {
            Boolean m6713a = m6713a(context);
            return m6713a != null ? m6713a.toString() : "No value set";
        }
    }

    /* renamed from: a */
    public static C1649a m6723a() {
        return f2208a;
    }

    /* renamed from: a */
    public static String m6722a(Context context) {
        return m6720a(f2208a, context) + m6720a(f2209b, context) + m6720a(f2210c, context);
    }

    /* renamed from: a */
    private static String m6720a(C1649a c1649a, Context context) {
        return "\n" + c1649a.f2211a + " - " + c1649a.m6711b(context);
    }

    /* renamed from: a */
    private static boolean m6721a(C1570d<Boolean> c1570d, Boolean bool, Context context) {
        if (context != null) {
            Boolean bool2 = (Boolean) C1571e.m6977b(c1570d, (Object) null, context);
            C1571e.m6984a(c1570d, bool, context);
            return bool2 == null || bool2 != bool;
        }
        C1710r.m6310i("AppLovinSdk", "Failed to update compliance value for key: " + c1570d);
        return false;
    }

    /* renamed from: a */
    public static boolean m6719a(boolean z, Context context) {
        return m6721a(C1570d.f1940l, Boolean.valueOf(z), context);
    }

    /* renamed from: b */
    public static C1649a m6718b() {
        return f2209b;
    }

    /* renamed from: b */
    public static boolean m6717b(boolean z, Context context) {
        return m6721a(C1570d.f1939k, Boolean.valueOf(z), context);
    }

    /* renamed from: c */
    public static C1649a m6716c() {
        return f2210c;
    }

    /* renamed from: c */
    public static boolean m6715c(boolean z, Context context) {
        return m6721a(C1570d.f1941m, Boolean.valueOf(z), context);
    }
}
