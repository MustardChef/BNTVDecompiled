package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.internal.bmz;
import com.google.ads.interactivemedia.p034v3.internal.bnd;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bnd */
/* loaded from: classes2.dex */
public abstract class bnd<MessageType extends bnd<MessageType, BuilderType>, BuilderType extends bmz<MessageType, BuilderType>> extends blb<MessageType, BuilderType> {

    /* renamed from: a */
    private static final Map f6258a = new ConcurrentHashMap();

    /* renamed from: c */
    protected bpm f6259c = bpm.m2949c();

    /* renamed from: d */
    protected int f6260d = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: aA */
    public static bnj m3293aA(bnj bnjVar) {
        int size = bnjVar.size();
        return bnjVar.mo3117d(size == 0 ? 10 : size + size);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aB */
    public static Object m3292aB(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: aC */
    public static Object m3291aC(boj bojVar, String str, Object[] objArr) {
        return new bos(bojVar, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: aD */
    public static void m3290aD(Class cls, bnd bndVar) {
        f6258a.put(cls, bndVar);
    }

    /* renamed from: aF */
    public static bmp m3288aF(boj bojVar, Object obj, boj bojVar2, bng bngVar, int i, bpz bpzVar, Class cls) {
        return new bmp(bojVar, bojVar2, new bnc(bngVar, i, bpzVar, false));
    }

    /* renamed from: aG */
    public static bmp m3287aG(boj bojVar, boj bojVar2, int i, bpz bpzVar, Class cls) {
        Collections.emptyList();
        return new bmp(bojVar, bojVar2, new bnc(null, i, bpzVar, true));
    }

    /* renamed from: aH */
    static bnd m3286aH(bnd bndVar, byte[] bArr, int i, bmr bmrVar) throws bnm {
        bnd bndVar2 = (bnd) bndVar.m3289aE(4);
        try {
            boy m3118c = boq.m3120a().m3118c(bndVar2);
            m3118c.mo3034i(bndVar2, bArr, 0, i, new blf(bmrVar));
            m3118c.mo3037f(bndVar2);
            if (bndVar2.f5991b == 0) {
                return bndVar2;
            }
            throw new RuntimeException();
        } catch (bnm e) {
            if (e.m3248k()) {
                throw new bnm(e);
            }
            throw e;
        } catch (IOException e2) {
            if (e2.getCause() instanceof bnm) {
                throw ((bnm) e2.getCause());
            }
            throw new bnm(e2);
        } catch (IndexOutOfBoundsException unused) {
            throw bnm.m3250i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: au */
    public static bnd m3282au(Class cls) {
        Map map = f6258a;
        bnd bndVar = (bnd) map.get(cls);
        if (bndVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                bndVar = (bnd) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (bndVar == null) {
            bndVar = (bnd) ((bnd) bpu.m2897g(cls)).m3289aE(6);
            if (bndVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, bndVar);
        }
        return bndVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: av */
    public static bnd m3281av(bnd bndVar, bls blsVar) throws bnm {
        bmr m3341a = bmr.m3341a();
        try {
            blw mo3046l = blsVar.mo3046l();
            bnd bndVar2 = (bnd) bndVar.m3289aE(4);
            try {
                try {
                    boy m3118c = boq.m3120a().m3118c(bndVar2);
                    m3118c.mo3035h(bndVar2, bly.m3429p(mo3046l), m3341a);
                    m3118c.mo3037f(bndVar2);
                    try {
                        mo3046l.mo3436z(0);
                        m3276c(bndVar2);
                        m3276c(bndVar2);
                        return bndVar2;
                    } catch (bnm e) {
                        throw e;
                    }
                } catch (bnm e2) {
                    if (e2.m3248k()) {
                        throw new bnm(e2);
                    }
                    throw e2;
                } catch (RuntimeException e3) {
                    if (e3.getCause() instanceof bnm) {
                        throw ((bnm) e3.getCause());
                    }
                    throw e3;
                }
            } catch (IOException e4) {
                if (e4.getCause() instanceof bnm) {
                    throw ((bnm) e4.getCause());
                }
                throw new bnm(e4);
            }
        } catch (bnm e5) {
            throw e5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: aw */
    public static bnd m3280aw(bnd bndVar, bls blsVar, bmr bmrVar) throws bnm {
        try {
            blw mo3046l = blsVar.mo3046l();
            bnd bndVar2 = (bnd) bndVar.m3289aE(4);
            try {
                boy m3118c = boq.m3120a().m3118c(bndVar2);
                m3118c.mo3035h(bndVar2, bly.m3429p(mo3046l), bmrVar);
                m3118c.mo3037f(bndVar2);
                try {
                    mo3046l.mo3436z(0);
                    m3276c(bndVar2);
                    return bndVar2;
                } catch (bnm e) {
                    throw e;
                }
            } catch (bnm e2) {
                if (e2.m3248k()) {
                    throw new bnm(e2);
                }
                throw e2;
            } catch (IOException e3) {
                if (e3.getCause() instanceof bnm) {
                    throw ((bnm) e3.getCause());
                }
                throw new bnm(e3);
            } catch (RuntimeException e4) {
                if (e4.getCause() instanceof bnm) {
                    throw ((bnm) e4.getCause());
                }
                throw e4;
            }
        } catch (bnm e5) {
            throw e5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ax */
    public static bnd m3279ax(bnd bndVar, byte[] bArr, bmr bmrVar) throws bnm {
        bnd m3286aH = m3286aH(bndVar, bArr, bArr.length, bmrVar);
        m3276c(m3286aH);
        return m3286aH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ay */
    public static bni m3278ay() {
        return bne.m3274f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: az */
    public static bnj m3277az() {
        return bor.m3116e();
    }

    /* renamed from: c */
    private static void m3276c(bnd bndVar) throws bnm {
        if (bndVar != null && !bndVar.mo3170aV()) {
            throw new bnm(new bpl().getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: aE */
    public final Object m3289aE(int i) {
        return mo2732i(i, null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bok
    /* renamed from: aT */
    public final /* synthetic */ boj mo3171aT() {
        return (bnd) m3289aE(6);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bok
    /* renamed from: aV */
    public final boolean mo3170aV() {
        Boolean bool = Boolean.TRUE;
        byte byteValue = ((Byte) m3289aE(1)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean mo3031l = boq.m3120a().m3118c(this).mo3031l(this);
        mo2732i(2, true != mo3031l ? null : this);
        return mo3031l;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blb
    /* renamed from: ao */
    final int mo3285ao() {
        return this.f6260d;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blb
    /* renamed from: aq */
    final void mo3284aq(int i) {
        this.f6260d = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boj
    /* renamed from: as */
    public final int mo3175as() {
        int i = this.f6260d;
        if (i == -1) {
            int mo3040a = boq.m3120a().m3118c(this).mo3040a(this);
            this.f6260d = mo3040a;
            return mo3040a;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: at */
    public final bmz m3283at() {
        return (bmz) m3289aE(5);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boj
    /* renamed from: bh */
    public final /* synthetic */ boi mo3174bh() {
        return (bmz) m3289aE(5);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boj
    /* renamed from: bi */
    public final /* synthetic */ boi mo3173bi() {
        bmz bmzVar = (bmz) m3289aE(5);
        bmzVar.m3306aW(this);
        return bmzVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boj
    /* renamed from: bj */
    public final void mo3172bj(bma bmaVar) throws IOException {
        boq.m3120a().m3118c(this).mo3033j(this, bmb.m3362a(bmaVar));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return boq.m3120a().m3118c(this).mo3032k(this, (bnd) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f5991b;
        if (i != 0) {
            return i;
        }
        int mo3039b = boq.m3120a().m3118c(this).mo3039b(this);
        this.f5991b = mo3039b;
        return mo3039b;
    }

    /* renamed from: i */
    protected abstract Object mo2732i(int i, Object obj);

    public final String toString() {
        return bqd.m2809D(this, super.toString());
    }
}
