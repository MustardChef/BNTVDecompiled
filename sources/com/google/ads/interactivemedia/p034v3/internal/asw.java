package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.google.android.exoplayer2.PlaybackException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.asw */
/* loaded from: classes2.dex */
public final class asw {

    /* renamed from: a */
    private static final HashMap f5021a = new HashMap();

    /* renamed from: b */
    private final Context f5022b;

    /* renamed from: c */
    private final asx f5023c;

    /* renamed from: d */
    private final art f5024d;

    /* renamed from: e */
    private final ari f5025e;

    /* renamed from: f */
    private aso f5026f;

    /* renamed from: g */
    private final Object f5027g = new Object();

    public asw(Context context, asx asxVar, art artVar, ari ariVar) {
        this.f5022b = context;
        this.f5023c = asxVar;
        this.f5024d = artVar;
        this.f5025e = ariVar;
    }

    /* renamed from: d */
    private static long m4645d(long j) {
        return System.currentTimeMillis() - j;
    }

    /* renamed from: e */
    private final synchronized Class m4644e(asp aspVar) throws asv {
        String m4820k = aspVar.m4673a().m4820k();
        HashMap hashMap = f5021a;
        Class cls = (Class) hashMap.get(m4820k);
        if (cls != null) {
            return cls;
        }
        try {
            if (this.f5025e.m4735a(aspVar.m4671c())) {
                try {
                    File m4672b = aspVar.m4672b();
                    if (!m4672b.exists()) {
                        m4672b.mkdirs();
                    }
                    Class loadClass = new DexClassLoader(aspVar.m4671c().getAbsolutePath(), m4672b.getAbsolutePath(), null, this.f5022b.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                    hashMap.put(m4820k, loadClass);
                    return loadClass;
                } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e) {
                    throw new asv(2008, e);
                }
            }
            throw new asv(2026, "VM did not pass signature verification");
        } catch (GeneralSecurityException e2) {
            throw new asv(2026, e2);
        }
    }

    /* renamed from: a */
    public final arw m4648a() {
        aso asoVar;
        synchronized (this.f5027g) {
            asoVar = this.f5026f;
        }
        return asoVar;
    }

    /* renamed from: b */
    public final asp m4647b() {
        synchronized (this.f5027g) {
            aso asoVar = this.f5026f;
            if (asoVar != null) {
                return asoVar.m4679f();
            }
            return null;
        }
    }

    /* renamed from: c */
    public final boolean m4646c(asp aspVar) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                aso asoVar = new aso(m4644e(aspVar).getDeclaredConstructor(Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE).newInstance(this.f5022b, "msa-r", aspVar.m4669e(), null, new Bundle(), 2), aspVar, this.f5023c, this.f5024d);
                if (!asoVar.m4677h()) {
                    throw new asv(4000, "init failed");
                }
                int m4680e = asoVar.m4680e();
                if (m4680e == 0) {
                    synchronized (this.f5027g) {
                        aso asoVar2 = this.f5026f;
                        if (asoVar2 != null) {
                            try {
                                asoVar2.m4678g();
                            } catch (asv e) {
                                this.f5024d.m4727c(e.m4649a(), -1L, e);
                            }
                        }
                        this.f5026f = asoVar;
                    }
                    this.f5024d.m4726d(PathInterpolatorCompat.MAX_NUM_POINTS, m4645d(currentTimeMillis));
                    return true;
                }
                StringBuilder sb = new StringBuilder(15);
                sb.append("ci: ");
                sb.append(m4680e);
                throw new asv((int) PlaybackException.ERROR_CODE_DECODER_INIT_FAILED, sb.toString());
            } catch (Exception e2) {
                throw new asv(2004, e2);
            }
        } catch (asv e3) {
            this.f5024d.m4727c(e3.m4649a(), m4645d(currentTimeMillis), e3);
            return false;
        } catch (Exception e4) {
            this.f5024d.m4727c(4010, m4645d(currentTimeMillis), e4);
            return false;
        }
    }
}
