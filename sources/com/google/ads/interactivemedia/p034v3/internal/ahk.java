package com.google.ads.interactivemedia.p034v3.internal;

import android.view.View;
import android.view.ViewParent;
import com.google.ads.interactivemedia.p034v3.impl.data.C2518i;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ahk */
/* loaded from: classes2.dex */
public final class ahk {

    /* renamed from: a */
    private final HashMap f4075a = new HashMap();

    /* renamed from: b */
    private final HashMap f4076b = new HashMap();

    /* renamed from: c */
    private final HashMap f4077c = new HashMap();

    /* renamed from: d */
    private final HashSet f4078d = new HashSet();

    /* renamed from: e */
    private final HashSet f4079e = new HashSet();

    /* renamed from: f */
    private final HashSet f4080f = new HashSet();

    /* renamed from: g */
    private final HashMap f4081g = new HashMap();

    /* renamed from: h */
    private boolean f4082h;

    /* renamed from: a */
    public final View m5264a(String str) {
        return (View) this.f4077c.get(str);
    }

    /* renamed from: b */
    public final ahj m5263b(View view) {
        ahj ahjVar = (ahj) this.f4076b.get(view);
        if (ahjVar != null) {
            this.f4076b.remove(view);
        }
        return ahjVar;
    }

    /* renamed from: c */
    public final String m5262c(String str) {
        return (String) this.f4081g.get(str);
    }

    /* renamed from: d */
    public final String m5261d(View view) {
        if (this.f4075a.size() == 0) {
            return null;
        }
        String str = (String) this.f4075a.get(view);
        if (str != null) {
            this.f4075a.remove(view);
        }
        return str;
    }

    /* renamed from: e */
    public final HashSet m5260e() {
        return this.f4080f;
    }

    /* renamed from: f */
    public final HashSet m5259f() {
        return this.f4079e;
    }

    /* renamed from: g */
    public final void m5258g() {
        this.f4075a.clear();
        this.f4076b.clear();
        this.f4077c.clear();
        this.f4078d.clear();
        this.f4079e.clear();
        this.f4080f.clear();
        this.f4081g.clear();
        this.f4082h = false;
    }

    /* renamed from: h */
    public final void m5257h() {
        this.f4082h = true;
    }

    /* renamed from: i */
    public final void m5256i() {
        agq m5331a = agq.m5331a();
        if (m5331a != null) {
            for (agj agjVar : m5331a.m5330b()) {
                View m5344g = agjVar.m5344g();
                if (agjVar.m5340k()) {
                    String m5342i = agjVar.m5342i();
                    if (m5344g != null) {
                        String str = null;
                        if (m5344g.hasWindowFocus()) {
                            HashSet hashSet = new HashSet();
                            View view = m5344g;
                            while (true) {
                                if (view != null) {
                                    String m5999b = C2518i.m5999b(view);
                                    if (m5999b != null) {
                                        str = m5999b;
                                        break;
                                    }
                                    hashSet.add(view);
                                    ViewParent parent = view.getParent();
                                    view = parent instanceof View ? (View) parent : null;
                                } else {
                                    this.f4078d.addAll(hashSet);
                                    break;
                                }
                            }
                        } else {
                            str = "noWindowFocus";
                        }
                        if (str == null) {
                            this.f4079e.add(m5342i);
                            this.f4075a.put(m5344g, m5342i);
                            for (agt agtVar : agjVar.m5341j()) {
                                View view2 = (View) agtVar.m5313d().get();
                                if (view2 != null) {
                                    ahj ahjVar = (ahj) this.f4076b.get(view2);
                                    if (ahjVar != null) {
                                        ahjVar.m5265c(agjVar.m5342i());
                                    } else {
                                        this.f4076b.put(view2, new ahj(agtVar, agjVar.m5342i()));
                                    }
                                }
                            }
                        } else {
                            this.f4080f.add(m5342i);
                            this.f4077c.put(m5342i, m5344g);
                            this.f4081g.put(m5342i, str);
                        }
                    } else {
                        this.f4080f.add(m5342i);
                        this.f4081g.put(m5342i, "noAdView");
                    }
                }
            }
        }
    }

    /* renamed from: j */
    public final int m5255j(View view) {
        if (this.f4078d.contains(view)) {
            return 1;
        }
        return this.f4082h ? 2 : 3;
    }
}
