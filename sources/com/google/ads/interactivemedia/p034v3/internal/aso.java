package com.google.ads.interactivemedia.p034v3.internal;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.PlaybackException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aso */
/* loaded from: classes2.dex */
public final class aso implements arw {

    /* renamed from: a */
    private final Object f4993a;

    /* renamed from: b */
    private final asp f4994b;

    /* renamed from: c */
    private final asx f4995c;

    /* renamed from: d */
    private final art f4996d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aso(Object obj, asp aspVar, asx asxVar, art artVar) {
        this.f4993a = obj;
        this.f4994b = aspVar;
        this.f4995c = asxVar;
        this.f4996d = artVar;
    }

    /* renamed from: i */
    private static long m4676i(long j) {
        return System.currentTimeMillis() - j;
    }

    /* renamed from: j */
    private static String m4675j(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        aga m5376a = agb.m5376a();
        m5376a.m5400c(afv.f3905e);
        m5376a.m5438a(bls.m3504t(bArr));
        return Base64.encodeToString(((agb) m5376a.mo3179aR()).mo3176ar(), 11);
    }

    /* renamed from: k */
    private final synchronized byte[] m4674k(Map map) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e) {
            this.f4996d.m4727c(2007, m4676i(currentTimeMillis), e);
            return null;
        }
        return (byte[]) this.f4993a.getClass().getDeclaredMethod("xss", Map.class, Map.class).invoke(this.f4993a, null, map);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.arw
    /* renamed from: a */
    public final synchronized String mo4684a(Context context, String str, View view, Activity activity) {
        Map mo4643a;
        mo4643a = this.f4995c.mo4643a();
        mo4643a.put("f", "c");
        mo4643a.put("ctx", context);
        mo4643a.put("cs", str);
        mo4643a.put("aid", null);
        mo4643a.put(ViewHierarchyConstants.VIEW_KEY, view);
        mo4643a.put("act", activity);
        return m4675j(m4674k(mo4643a));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.arw
    /* renamed from: b */
    public final synchronized String mo4683b(Context context, View view, Activity activity) {
        Map mo4641c;
        mo4641c = this.f4995c.mo4641c();
        mo4641c.put("f", "v");
        mo4641c.put("ctx", context);
        mo4641c.put("aid", null);
        mo4641c.put(ViewHierarchyConstants.VIEW_KEY, view);
        mo4641c.put("act", activity);
        return m4675j(m4674k(mo4641c));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.arw
    /* renamed from: c */
    public final synchronized String mo4682c(Context context) {
        Map mo4642b;
        mo4642b = this.f4995c.mo4642b();
        mo4642b.put("f", "q");
        mo4642b.put("ctx", context);
        mo4642b.put("aid", null);
        return m4675j(m4674k(mo4642b));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.arw
    /* renamed from: d */
    public final synchronized void mo4681d(MotionEvent motionEvent) throws asv {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            hashMap.put("t", new Throwable());
            hashMap.put("aid", null);
            hashMap.put("evt", motionEvent);
            this.f4993a.getClass().getDeclaredMethod("he", Map.class).invoke(this.f4993a, hashMap);
            this.f4996d.m4726d(PlaybackException.ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED, m4676i(currentTimeMillis));
        } catch (Exception e) {
            throw new asv(2005, e);
        }
    }

    /* renamed from: e */
    public final synchronized int m4680e() throws asv {
        try {
        } catch (Exception e) {
            throw new asv(2006, e);
        }
        return ((Integer) this.f4993a.getClass().getDeclaredMethod("lcs", new Class[0]).invoke(this.f4993a, new Object[0])).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public final asp m4679f() {
        return this.f4994b;
    }

    /* renamed from: g */
    public final synchronized void m4678g() throws asv {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.f4993a.getClass().getDeclaredMethod("close", new Class[0]).invoke(this.f4993a, new Object[0]);
            this.f4996d.m4726d(PlaybackException.ERROR_CODE_PARSING_CONTAINER_MALFORMED, m4676i(currentTimeMillis));
        } catch (Exception e) {
            throw new asv(2003, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public final synchronized boolean m4677h() throws asv {
        try {
        } catch (Exception e) {
            throw new asv(2001, e);
        }
        return ((Boolean) this.f4993a.getClass().getDeclaredMethod("init", new Class[0]).invoke(this.f4993a, new Object[0])).booleanValue();
    }
}
