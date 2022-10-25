package com.applovin.impl.mediation.debugger.p016a.p018b;

import android.content.Context;
import com.applovin.impl.sdk.utils.C1724f;

/* renamed from: com.applovin.impl.mediation.debugger.a.b.d */
/* loaded from: classes.dex */
public class C1411d {

    /* renamed from: a */
    private final String f1072a;

    /* renamed from: b */
    private final String f1073b;

    /* renamed from: c */
    private final boolean f1074c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1411d(String str, String str2, Context context) {
        this.f1072a = str.replace("android.permission.", "");
        this.f1073b = str2;
        this.f1074c = C1724f.m6278a(str, context);
    }

    /* renamed from: a */
    public String m7499a() {
        return this.f1072a;
    }

    /* renamed from: b */
    public String m7498b() {
        return this.f1073b;
    }

    /* renamed from: c */
    public boolean m7497c() {
        return this.f1074c;
    }
}
