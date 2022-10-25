package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aa */
/* loaded from: classes2.dex */
public class C2537aa {

    /* renamed from: a */
    public final Uri f2863a;

    /* renamed from: b */
    public final String f2864b;

    /* renamed from: c */
    public final C3178x f2865c;

    /* renamed from: e */
    public final List f2867e;

    /* renamed from: g */
    public final avg f2869g;

    /* renamed from: h */
    public final Object f2870h;

    /* renamed from: d */
    public final C3016r f2866d = null;

    /* renamed from: f */
    public final String f2868f = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2537aa(Uri uri, String str, C3178x c3178x, List list, avg avgVar) {
        this.f2863a = uri;
        this.f2864b = str;
        this.f2865c = c3178x;
        this.f2867e = list;
        this.f2869g = avgVar;
        avm m4509t = avg.m4509t();
        if (avgVar.size() > 0) {
            C2541ad c2541ad = (C2541ad) avgVar.get(0);
            throw null;
        }
        m4509t.m4499e();
        this.f2870h = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2537aa) {
            C2537aa c2537aa = (C2537aa) obj;
            if (this.f2863a.equals(c2537aa.f2863a) && C2628cq.m2563T(this.f2864b, c2537aa.f2864b) && C2628cq.m2563T(this.f2865c, c2537aa.f2865c)) {
                C3016r c3016r = c2537aa.f2866d;
                if (C2628cq.m2563T(null, null) && this.f2867e.equals(c2537aa.f2867e)) {
                    String str = c2537aa.f2868f;
                    if (C2628cq.m2563T(null, null) && this.f2869g.equals(c2537aa.f2869g)) {
                        Object obj2 = c2537aa.f2870h;
                        if (C2628cq.m2563T(null, null)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.f2863a.hashCode() * 31;
        String str = this.f2864b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        C3178x c3178x = this.f2865c;
        return (((((hashCode2 + (c3178x != null ? c3178x.hashCode() : 0)) * 961) + this.f2867e.hashCode()) * 961) + this.f2869g.hashCode()) * 31;
    }
}
