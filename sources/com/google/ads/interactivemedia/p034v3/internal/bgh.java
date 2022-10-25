package com.google.ads.interactivemedia.p034v3.internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bgh */
/* loaded from: classes2.dex */
public final class bgh {

    /* renamed from: a */
    final List f5679a;

    /* renamed from: b */
    final boolean f5680b;

    /* renamed from: c */
    private final ThreadLocal f5681c;

    /* renamed from: d */
    private final Map f5682d;

    /* renamed from: e */
    private final bhl f5683e;

    /* renamed from: f */
    private final bil f5684f;

    static {
        bkt.m3602a(Object.class);
    }

    public bgh() {
        bhn bhnVar = bhn.f5735a;
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public static void m3721h(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            StringBuilder sb = new StringBuilder(168);
            sb.append(d);
            sb.append(" is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    public final bgy m3728a(bkt bktVar) {
        boolean z;
        bgy bgyVar = (bgy) this.f5682d.get(bktVar);
        if (bgyVar != null) {
            return bgyVar;
        }
        Map map = (Map) this.f5681c.get();
        if (map == null) {
            map = new HashMap();
            this.f5681c.set(map);
            z = true;
        } else {
            z = false;
        }
        bgg bggVar = (bgg) map.get(bktVar);
        if (bggVar != null) {
            return bggVar;
        }
        try {
            bgg bggVar2 = new bgg();
            map.put(bktVar, bggVar2);
            for (bgz bgzVar : this.f5679a) {
                bgy mo3604a = bgzVar.mo3604a(this, bktVar);
                if (mo3604a != null) {
                    bggVar2.m3729a(mo3604a);
                    this.f5682d.put(bktVar, mo3604a);
                    return mo3604a;
                }
            }
            String obj = bktVar.toString();
            StringBuilder sb = new StringBuilder(obj.length() + 40);
            sb.append("GSON (${project.version}) cannot handle ");
            sb.append(obj);
            throw new IllegalArgumentException(sb.toString());
        } finally {
            map.remove(bktVar);
            if (z) {
                this.f5681c.remove();
            }
        }
    }

    /* renamed from: b */
    public final bgy m3727b(Class cls) {
        return m3728a(bkt.m3602a(cls));
    }

    /* renamed from: c */
    public final bgy m3726c(bgz bgzVar, bkt bktVar) {
        if (!this.f5679a.contains(bgzVar)) {
            bgzVar = this.f5684f;
        }
        boolean z = false;
        for (bgz bgzVar2 : this.f5679a) {
            if (z) {
                bgy mo3604a = bgzVar2.mo3604a(this, bktVar);
                if (mo3604a != null) {
                    return mo3604a;
                }
            } else if (bgzVar2 == bgzVar) {
                z = true;
            }
        }
        String valueOf = String.valueOf(bktVar);
        String.valueOf(valueOf).length();
        throw new IllegalArgumentException("GSON cannot serialize ".concat(String.valueOf(valueOf)));
    }

    /* renamed from: d */
    public final bkx m3725d(Writer writer) throws IOException {
        bkx bkxVar = new bkx(writer);
        bkxVar.m3552m(this.f5680b);
        bkxVar.m3551n(false);
        bkxVar.m3550o(false);
        return bkxVar;
    }

    /* renamed from: e */
    public final Object m3724e(bkv bkvVar, Type type) throws bgn, bgt {
        boolean m3570v = bkvVar.m3570v();
        boolean z = true;
        bkvVar.m3571u(true);
        try {
            try {
                try {
                    bkvVar.mo3574r();
                    try {
                        return m3728a(bkt.m3601b(type)).read(bkvVar);
                    } catch (EOFException e) {
                        e = e;
                        z = false;
                        if (z) {
                            bkvVar.m3571u(m3570v);
                            return null;
                        }
                        throw new bgt(e);
                    }
                } catch (IOException e2) {
                    throw new bgt(e2);
                } catch (AssertionError e3) {
                    String valueOf = String.valueOf(e3.getMessage());
                    AssertionError assertionError = new AssertionError(valueOf.length() != 0 ? "AssertionError (GSON ${project.version}): ".concat(valueOf) : new String("AssertionError (GSON ${project.version}): "));
                    assertionError.initCause(e3);
                    throw assertionError;
                } catch (IllegalStateException e4) {
                    throw new bgt(e4);
                }
            } catch (EOFException e5) {
                e = e5;
            }
        } finally {
            bkvVar.m3571u(m3570v);
        }
    }

    /* renamed from: f */
    public final Object m3723f(Reader reader, Type type) throws bgn, bgt {
        bkv bkvVar = new bkv(reader);
        bkvVar.m3571u(false);
        Object m3724e = m3724e(bkvVar, type);
        if (m3724e != null) {
            try {
                if (bkvVar.mo3574r() != 10) {
                    throw new bgn("JSON document was not fully consumed.");
                }
            } catch (bky e) {
                throw new bgt(e);
            } catch (IOException e2) {
                throw new bgn(e2);
            }
        }
        return m3724e;
    }

    /* renamed from: g */
    public final String m3722g(Object obj) {
        if (obj == null) {
            bgm bgmVar = bgo.f5697a;
            StringWriter stringWriter = new StringWriter();
            try {
                m3720i(bgmVar, m3725d(stringWriter));
                return stringWriter.toString();
            } catch (IOException e) {
                throw new bgn(e);
            }
        }
        Type type = obj.getClass();
        StringWriter stringWriter2 = new StringWriter();
        try {
            m3719j(obj, type, m3725d(stringWriter2));
            return stringWriter2.toString();
        } catch (IOException e2) {
            throw new bgn(e2);
        }
    }

    /* renamed from: i */
    public final void m3720i(bgm bgmVar, bkx bkxVar) throws bgn {
        boolean m3547r = bkxVar.m3547r();
        bkxVar.m3551n(true);
        boolean m3548q = bkxVar.m3548q();
        bkxVar.m3552m(this.f5680b);
        boolean m3549p = bkxVar.m3549p();
        bkxVar.m3550o(false);
        try {
            try {
                axn.m4377d(bgmVar, bkxVar);
            } catch (IOException e) {
                throw new bgn(e);
            } catch (AssertionError e2) {
                String valueOf = String.valueOf(e2.getMessage());
                AssertionError assertionError = new AssertionError(valueOf.length() != 0 ? "AssertionError (GSON ${project.version}): ".concat(valueOf) : new String("AssertionError (GSON ${project.version}): "));
                assertionError.initCause(e2);
                throw assertionError;
            }
        } finally {
            bkxVar.m3551n(m3547r);
            bkxVar.m3552m(m3548q);
            bkxVar.m3550o(m3549p);
        }
    }

    /* renamed from: j */
    public final void m3719j(Object obj, Type type, bkx bkxVar) throws bgn {
        bgy m3728a = m3728a(bkt.m3601b(type));
        boolean m3547r = bkxVar.m3547r();
        bkxVar.m3551n(true);
        boolean m3548q = bkxVar.m3548q();
        bkxVar.m3552m(this.f5680b);
        boolean m3549p = bkxVar.m3549p();
        bkxVar.m3550o(false);
        try {
            try {
                m3728a.write(bkxVar, obj);
            } catch (IOException e) {
                throw new bgn(e);
            } catch (AssertionError e2) {
                String valueOf = String.valueOf(e2.getMessage());
                AssertionError assertionError = new AssertionError(valueOf.length() != 0 ? "AssertionError (GSON ${project.version}): ".concat(valueOf) : new String("AssertionError (GSON ${project.version}): "));
                assertionError.initCause(e2);
                throw assertionError;
            }
        } finally {
            bkxVar.m3551n(m3547r);
            bkxVar.m3552m(m3548q);
            bkxVar.m3550o(m3549p);
        }
    }

    public final String toString() {
        return "{serializeNulls:false,factories:" + this.f5679a + ",instanceCreators:" + this.f5683e + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bgh(bhn bhnVar, bga bgaVar, Map map, boolean z, int i, List list, bgw bgwVar, bgw bgwVar2) {
        this.f5681c = new ThreadLocal();
        this.f5682d = new ConcurrentHashMap();
        bhl bhlVar = new bhl(map);
        this.f5683e = bhlVar;
        this.f5680b = true;
        ArrayList arrayList = new ArrayList();
        arrayList.add(bkh.f5912T);
        arrayList.add(biu.m3625a(bgwVar));
        arrayList.add(bhnVar);
        arrayList.addAll(list);
        arrayList.add(bkh.f5939z);
        arrayList.add(bkh.f5926m);
        arrayList.add(bkh.f5920g);
        arrayList.add(bkh.f5922i);
        arrayList.add(bkh.f5924k);
        bgy bgdVar = i == bgu.f5700a ? bkh.f5933t : new bgd();
        arrayList.add(bkh.m3612c(Long.TYPE, Long.class, bgdVar));
        arrayList.add(bkh.m3612c(Double.TYPE, Double.class, new bgb()));
        arrayList.add(bkh.m3612c(Float.TYPE, Float.class, new bgc()));
        arrayList.add(bis.m3627a(bgwVar2));
        arrayList.add(bkh.f5928o);
        arrayList.add(bkh.f5930q);
        arrayList.add(bkh.m3613b(AtomicLong.class, new bge(bgdVar).nullSafe()));
        arrayList.add(bkh.m3613b(AtomicLongArray.class, new bgf(bgdVar).nullSafe()));
        arrayList.add(bkh.f5932s);
        arrayList.add(bkh.f5935v);
        arrayList.add(bkh.f5894B);
        arrayList.add(bkh.f5896D);
        arrayList.add(bkh.m3613b(BigDecimal.class, bkh.f5937x));
        arrayList.add(bkh.m3613b(BigInteger.class, bkh.f5938y));
        arrayList.add(bkh.f5898F);
        arrayList.add(bkh.f5900H);
        arrayList.add(bkh.f5904L);
        arrayList.add(bkh.f5906N);
        arrayList.add(bkh.f5910R);
        arrayList.add(bkh.f5902J);
        arrayList.add(bkh.f5917d);
        arrayList.add(bii.f5793a);
        arrayList.add(bkh.f5908P);
        if (bks.f5952a) {
            arrayList.add(bks.f5956e);
            arrayList.add(bks.f5955d);
            arrayList.add(bks.f5957f);
        }
        arrayList.add(bif.f5787a);
        arrayList.add(bkh.f5915b);
        arrayList.add(new bil(bhlVar, 1));
        arrayList.add(new bil(bhlVar, 2));
        bil bilVar = new bil(bhlVar, 0);
        this.f5684f = bilVar;
        arrayList.add(bilVar);
        arrayList.add(bkh.f5913U);
        arrayList.add(new bix(bhlVar, bgaVar, bhnVar, bilVar));
        this.f5679a = Collections.unmodifiableList(arrayList);
    }
}
