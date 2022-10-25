package com.google.ads.interactivemedia.p034v3.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aqf */
/* loaded from: classes2.dex */
public abstract class aqf {

    /* renamed from: a */
    private final int f4871a;

    /* renamed from: b */
    private final String f4872b;

    /* renamed from: c */
    private final Object f4873c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aqf(int i, String str, Object obj) {
        this.f4871a = i;
        this.f4872b = str;
        this.f4873c = obj;
        apz.m4779a().m4762b(this);
    }

    /* renamed from: e */
    public static aqf m4771e(int i, String str, Boolean bool) {
        return new aqa(i, str, bool);
    }

    /* renamed from: i */
    public static void m4767i(String str, float f) {
        new aqd(str, Float.valueOf(f));
    }

    /* renamed from: j */
    public static void m4766j(String str, int i) {
        new aqb(str, Integer.valueOf(i));
    }

    /* renamed from: k */
    public static aqf m4765k(String str, long j) {
        return new aqc(str, Long.valueOf(j));
    }

    /* renamed from: l */
    public static aqf m4764l(String str, String str2) {
        return new aqe(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Object mo4775a(JSONObject jSONObject);

    /* renamed from: b */
    public abstract Object mo4774b(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public abstract Object mo4773c(SharedPreferences sharedPreferences);

    /* renamed from: d */
    public final int m4772d() {
        return this.f4871a;
    }

    /* renamed from: f */
    public final Object m4770f() {
        return apz.m4778b().m4760b(this);
    }

    /* renamed from: g */
    public final Object m4769g() {
        return this.f4873c;
    }

    /* renamed from: h */
    public final String m4768h() {
        return this.f4872b;
    }
}
