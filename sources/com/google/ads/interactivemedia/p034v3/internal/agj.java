package com.google.ads.interactivemedia.p034v3.internal;

import android.view.View;
import com.google.ads.interactivemedia.p034v3.impl.data.C2518i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.agj */
/* loaded from: classes2.dex */
public final class agj extends agf {

    /* renamed from: a */
    private static final Pattern f3969a = Pattern.compile("^[a-zA-Z0-9 ]+$");

    /* renamed from: b */
    private final agh f3970b;

    /* renamed from: d */
    private ahd f3972d;

    /* renamed from: h */
    private ahx f3976h;

    /* renamed from: c */
    private final List f3971c = new ArrayList();

    /* renamed from: e */
    private boolean f3973e = false;

    /* renamed from: f */
    private boolean f3974f = false;

    /* renamed from: g */
    private final String f3975g = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: package-private */
    public agj(agg aggVar, agh aghVar) {
        this.f3970b = aghVar;
        m5339l(null);
        if (aghVar.m5355c() == agi.HTML || aghVar.m5355c() == agi.JAVASCRIPT) {
            this.f3972d = new ahe(aghVar.m5357a());
        } else {
            this.f3972d = new ahg(aghVar.m5350h());
        }
        this.f3972d.mo5280j();
        agq.m5331a().m5328d(this);
        agw.m5309a().m5306d(this.f3972d.m5290a(), aggVar.m5359a());
    }

    /* renamed from: l */
    private final void m5339l(View view) {
        this.f3976h = new ahx(view);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.agf
    /* renamed from: b */
    public final void mo5349b(View view, agl aglVar, String str) {
        agt agtVar;
        if (this.f3974f) {
            return;
        }
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
        if (str == null || (str.length() <= 50 && f3969a.matcher(str).matches())) {
            Iterator it = this.f3971c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    agtVar = null;
                    break;
                }
                agtVar = (agt) it.next();
                if (agtVar.m5313d().get() == view) {
                    break;
                }
            }
            if (agtVar == null) {
                this.f3971c.add(new agt(view, aglVar, str));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("FriendlyObstruction has improperly formatted detailed reason");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.agf
    /* renamed from: c */
    public final void mo5348c() {
        if (this.f3974f) {
            return;
        }
        this.f3976h.clear();
        mo5346e();
        this.f3974f = true;
        agw.m5309a().m5307c(this.f3972d.m5290a());
        agq.m5331a().m5327e(this);
        this.f3972d.mo5282c();
        this.f3972d = null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.agf
    /* renamed from: d */
    public final void mo5347d(View view) {
        if (this.f3974f) {
            return;
        }
        C2518i.m5997d(view, "AdView is null");
        if (m5344g() == view) {
            return;
        }
        m5339l(view);
        this.f3972d.m5289b();
        Collection<agj> m5329c = agq.m5331a().m5329c();
        if (m5329c == null || m5329c.size() <= 0) {
            return;
        }
        for (agj agjVar : m5329c) {
            if (agjVar != this && agjVar.m5344g() == view) {
                agjVar.f3976h.clear();
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.agf
    /* renamed from: e */
    public final void mo5346e() {
        if (this.f3974f) {
            return;
        }
        this.f3971c.clear();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.agf
    /* renamed from: f */
    public final void mo5345f() {
        if (this.f3973e) {
            return;
        }
        this.f3973e = true;
        agq.m5331a().m5326f(this);
        this.f3972d.m5285h(agx.m5300b().m5301a());
        this.f3972d.mo5281f(this, this.f3970b);
    }

    /* renamed from: g */
    public final View m5344g() {
        return (View) this.f3976h.get();
    }

    /* renamed from: h */
    public final ahd m5343h() {
        return this.f3972d;
    }

    /* renamed from: i */
    public final String m5342i() {
        return this.f3975g;
    }

    /* renamed from: j */
    public final List m5341j() {
        return this.f3971c;
    }

    /* renamed from: k */
    public final boolean m5340k() {
        return this.f3973e && !this.f3974f;
    }
}
