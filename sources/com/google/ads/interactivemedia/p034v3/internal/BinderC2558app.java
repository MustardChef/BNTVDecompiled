package com.google.ads.interactivemedia.p034v3.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.Executor;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.app */
/* loaded from: classes2.dex */
public final class BinderC2558app extends aps {

    /* renamed from: a */
    private final amv f4857a;

    /* renamed from: b */
    private final amx f4858b;

    /* renamed from: c */
    private final and f4859c;

    /* renamed from: d */
    private boolean f4860d = false;

    public BinderC2558app(Context context, Executor executor, aew aewVar) {
        ana anaVar = new ana(context, executor, aewVar);
        this.f4857a = anaVar;
        this.f4859c = new and(anaVar);
        this.f4858b = aewVar.m5690c() ? null : amx.m4979j(context);
    }

    @Deprecated
    /* renamed from: u */
    private final arl m4805u(arl arlVar, arl arlVar2, boolean z) {
        Uri m4923g;
        try {
            Uri uri = (Uri) arm.m4732d(arlVar);
            Context context = (Context) arm.m4732d(arlVar2);
            if (z) {
                m4923g = this.f4859c.m4929a(uri, context);
            } else {
                m4923g = this.f4859c.m4923g(uri, context);
            }
            return arm.m4733c(m4923g);
        } catch (ane unused) {
            return null;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: b */
    public final int mo4802b() {
        amv amvVar = this.f4857a;
        if (amvVar instanceof ana) {
            amv m4958a = ((ana) amvVar).m4958a();
            if (m4958a instanceof ana) {
                return 1;
            }
            return m4958a instanceof ams ? 2 : -1;
        }
        return -1;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    @Deprecated
    /* renamed from: c */
    public final arl mo4801c(arl arlVar, arl arlVar2) {
        return m4805u(arlVar, arlVar2, false);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    @Deprecated
    /* renamed from: d */
    public final arl mo4800d(arl arlVar, arl arlVar2) {
        return m4805u(arlVar, arlVar2, true);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    @Deprecated
    /* renamed from: e */
    public final String mo4799e(arl arlVar, String str) {
        return ((ana) this.f4857a).mo4954e((Context) arm.m4732d(arlVar), str, null, null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    @Deprecated
    /* renamed from: f */
    public final String mo4798f(arl arlVar) {
        return mo4797g(arlVar, null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    @Deprecated
    /* renamed from: g */
    public final String mo4797g(arl arlVar, byte[] bArr) {
        Context context = (Context) arm.m4732d(arlVar);
        String mo4952g = this.f4857a.mo4952g(context, bArr);
        amx amxVar = this.f4858b;
        if (amxVar == null || !this.f4860d) {
            return mo4952g;
        }
        String m4978m = this.f4858b.m4978m(mo4952g, amxVar.mo4952g(context, bArr));
        this.f4860d = false;
        return m4978m;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: h */
    public final String mo4796h(arl arlVar, arl arlVar2, arl arlVar3, arl arlVar4) {
        return this.f4857a.mo4954e((Context) arm.m4732d(arlVar), (String) arm.m4732d(arlVar2), (View) arm.m4732d(arlVar3), (Activity) arm.m4732d(arlVar4));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: i */
    public final String mo4795i(arl arlVar) {
        return this.f4857a.mo4953f((Context) arm.m4732d(arlVar));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: j */
    public final String mo4794j() {
        return "ms";
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: k */
    public final String mo4793k(arl arlVar, arl arlVar2, arl arlVar3) {
        return this.f4857a.mo4951h((Context) arm.m4732d(arlVar), (View) arm.m4732d(arlVar2), (Activity) arm.m4732d(arlVar3));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: l */
    public final void mo4792l(arl arlVar) {
        this.f4859c.m4928b((MotionEvent) arm.m4732d(arlVar));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: m */
    public final void mo4791m(arl arlVar) {
        this.f4857a.mo4938n((View) arm.m4732d(arlVar));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    @Deprecated
    /* renamed from: n */
    public final void mo4790n(String str, String str2) {
        this.f4859c.m4927c(str, str2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    @Deprecated
    /* renamed from: o */
    public final void mo4789o(String str) {
        this.f4859c.m4926d(str);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    @Deprecated
    /* renamed from: p */
    public final boolean mo4788p(arl arlVar) {
        return this.f4859c.m4924f((Uri) arm.m4732d(arlVar));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    @Deprecated
    /* renamed from: q */
    public final boolean mo4787q(arl arlVar) {
        return this.f4859c.m4925e((Uri) arm.m4732d(arlVar));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: r */
    public final boolean mo4786r() {
        return this.f4857a.mo4946q();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    @Deprecated
    /* renamed from: s */
    public final boolean mo4785s(String str, boolean z) {
        if (this.f4858b == null) {
            return false;
        }
        this.f4858b.m4977o(new AdvertisingIdClient.Info(str, z));
        this.f4860d = true;
        return true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: t */
    public final boolean mo4784t() {
        return this.f4857a.mo4945s();
    }
}
