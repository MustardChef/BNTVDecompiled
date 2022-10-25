package com.google.ads.interactivemedia.p034v3.internal;

import android.app.Activity;
import android.content.Context;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.anb */
/* loaded from: classes2.dex */
public class anb extends amw {

    /* renamed from: r */
    protected static final Object f4696r = new Object();

    /* renamed from: s */
    static boolean f4697s = false;

    /* renamed from: w */
    private static final String f4698w = "anb";

    /* renamed from: x */
    private static long f4699x;

    /* renamed from: y */
    private static ang f4700y;

    /* renamed from: t */
    protected final boolean f4701t;

    /* renamed from: u */
    protected final String f4702u;

    /* renamed from: v */
    aod f4703v;

    /* JADX INFO: Access modifiers changed from: protected */
    public anb(Context context) {
        super(context);
        this.f4701t = false;
        this.f4702u = "";
    }

    /* renamed from: j */
    private final synchronized void m4939j(anw anwVar, aga agaVar) {
        MotionEvent motionEvent;
        try {
            any m4935u = m4935u(anwVar, this.f4663b, this.f4678q);
            Long l = m4935u.f4760a;
            if (l != null) {
                agaVar.m5409as(l.longValue());
            }
            Long l2 = m4935u.f4761b;
            if (l2 != null) {
                agaVar.m5408at(l2.longValue());
            }
            Long l3 = m4935u.f4762c;
            if (l3 != null) {
                agaVar.m5411aq(l3.longValue());
            }
            if (this.f4677p) {
                Long l4 = m4935u.f4763d;
                if (l4 != null) {
                    agaVar.m5412ap(l4.longValue());
                }
                Long l5 = m4935u.f4764e;
                if (l5 != null) {
                    agaVar.m5415am(l5.longValue());
                }
            }
        } catch (ano unused) {
        }
        aga m5605w = afp.m5605w();
        if (this.f4665d > 0 && anz.m4868h(this.f4678q)) {
            m5605w.m5385r(anz.m4875a(this.f4672k, this.f4678q));
            m5605w.m5460E(anz.m4875a(this.f4675n - this.f4673l, this.f4678q));
            m5605w.m5459F(anz.m4875a(this.f4676o - this.f4674m, this.f4678q));
            m5605w.m5379x(anz.m4875a(this.f4673l, this.f4678q));
            m5605w.m5377z(anz.m4875a(this.f4674m, this.f4678q));
            if (this.f4677p && (motionEvent = this.f4663b) != null) {
                long m4875a = anz.m4875a(((this.f4673l - this.f4675n) + motionEvent.getRawX()) - this.f4663b.getX(), this.f4678q);
                if (m4875a != 0) {
                    m5605w.m5462C(m4875a);
                }
                long m4875a2 = anz.m4875a(((this.f4674m - this.f4676o) + this.f4663b.getRawY()) - this.f4663b.getY(), this.f4678q);
                if (m4875a2 != 0) {
                    m5605w.m5461D(m4875a2);
                }
            }
        }
        try {
            any mo4943b = mo4943b(this.f4663b);
            Long l6 = mo4943b.f4760a;
            if (l6 != null) {
                m5605w.m5378y(l6.longValue());
            }
            Long l7 = mo4943b.f4761b;
            if (l7 != null) {
                m5605w.m5464A(l7.longValue());
            }
            m5605w.m5380w(mo4943b.f4762c.longValue());
            if (this.f4677p) {
                Long l8 = mo4943b.f4764e;
                if (l8 != null) {
                    m5605w.m5382u(l8.longValue());
                }
                Long l9 = mo4943b.f4763d;
                if (l9 != null) {
                    m5605w.m5381v(l9.longValue());
                }
                Long l10 = mo4943b.f4765f;
                if (l10 != null) {
                    m5605w.m5457H(l10.longValue() != 0 ? afw.f3909b : afw.f3908a);
                }
                if (this.f4666e > 0) {
                    Long valueOf = anz.m4868h(this.f4678q) ? Long.valueOf(Math.round(this.f4671j / this.f4666e)) : null;
                    if (valueOf != null) {
                        m5605w.m5387p(valueOf.longValue());
                    } else {
                        m5605w.m5388o();
                    }
                    m5605w.m5386q(Math.round(this.f4670i / this.f4666e));
                }
                Long l11 = mo4943b.f4768i;
                if (l11 != null) {
                    m5605w.m5384s(l11.longValue());
                }
                Long l12 = mo4943b.f4769j;
                if (l12 != null) {
                    m5605w.m5463B(l12.longValue());
                }
                Long l13 = mo4943b.f4770k;
                if (l13 != null) {
                    m5605w.m5458G(l13.longValue() != 0 ? afw.f3909b : afw.f3908a);
                }
            }
        } catch (ano unused2) {
        }
        long j = this.f4669h;
        if (j > 0) {
            m5605w.m5383t(j);
        }
        agaVar.m5406av((afp) m5605w.mo3179aR());
        long j2 = this.f4665d;
        if (j2 > 0) {
            agaVar.m5414an(j2);
        }
        long j3 = this.f4666e;
        if (j3 > 0) {
            agaVar.m5413ao(j3);
        }
        long j4 = this.f4667f;
        if (j4 > 0) {
            agaVar.m5410ar(j4);
        }
        long j5 = this.f4668g;
        if (j5 > 0) {
            agaVar.m5416al(j5);
        }
        try {
            int size = this.f4664c.size() - 1;
            if (size > 0) {
                agaVar.m5455J();
                for (int i = 0; i < size; i++) {
                    any m4935u2 = m4935u(f4662a, (MotionEvent) this.f4664c.get(i), this.f4678q);
                    aga m5605w2 = afp.m5605w();
                    m5605w2.m5378y(m4935u2.f4760a.longValue());
                    m5605w2.m5464A(m4935u2.f4761b.longValue());
                    agaVar.m5456I((afp) m5605w2.mo3179aR());
                }
            }
        } catch (ano unused3) {
            agaVar.m5455J();
        }
    }

    /* renamed from: t */
    protected static anw m4936t(Context context, boolean z) {
        if (f4662a == null) {
            synchronized (f4696r) {
                if (f4662a == null) {
                    anw m4890t = anw.m4890t(context, z);
                    if (m4890t.m4894p()) {
                        try {
                            if (((Boolean) aql.f4904q.m4770f()).booleanValue()) {
                                m4890t.m4889u("PDJGtr7hH5z8kziZtOwKBHfUklGaxsnuMOcaf4/XJNQXH5uqgOnO+ZxxlrN1G5R2", "8jFByxLLStK1ZA6Q/SQPKITUmXlRJfaQf0bJ+6rt27M=", new Class[0]);
                            }
                        } catch (IllegalStateException unused) {
                        }
                        m4890t.m4889u("pzhIFr8jSwvyB8FXK2qfBOfw0jXHNl6+dmbReaTm1jquB51r9sbZLlTA4zaBxZEm", "RbRyr5uGUYOSrOuNnmzV0kl42YeLvs7OFWbwh2MFm18=", Context.class);
                        m4890t.m4889u("t7YLiNn9wSLVfNzBPSP796qGY15c9YWt19X86sjfqa1MN8DTMOAxKskDGE2b7plQ", "lEEnhl5euaIfSg9vXz1JH43pBH/xGM9fvSrfPaUZwEI=", Context.class);
                        m4890t.m4889u("Zsy6wzxKzkvuI5Zg91hlK7lftgUdlMXbkLzI72tnQVNXNUFbyYhuDjwGRJi5QzOf", "/h10yfi8gz82TQ6rp82eUm/z42AeNO79/O3Nlfr8yws=", Context.class);
                        m4890t.m4889u("glZYRiAaVgXhfq7gmv5KdTlxK1u1W7CDU+wEOCdR48SsabliUSLxOyNuMGeUOQq8", "BXtZidg/K24z5N/YUAEC4oPRR4OaYUycAQjBgFG9Ir4=", Context.class);
                        m4890t.m4889u("/739lR4kemkoeiIxGTB69dfyotmKoGTnr6wtM0ugYOMXQexqwGvsBs8l5HrCnFT4", "LBvMjmMBC2btK8Ghl34ZYYMmZM0GDlWreJMsAap/ceE=", Context.class);
                        m4890t.m4889u("xNZCZdqL8o1jZKUOIQXHHGKMYJmFGBT5z1mMXWF7VHR3erPGPRFl7DocpCFVg9bF", "1GRZIGWaJCWi5hYVyOzM0ARje4NaXoHaW7HEe5QbRxs=", Context.class, Boolean.TYPE);
                        m4890t.m4889u("uUtXgghNropSfe2KUSoP0Efn1EgB4X6maOF+tPLLzG1rSS0RqDSE3s9EWbbdwRaZ", "iu0TCa9uEtKUas610luihENZAQIiF7MRaL5XfmToU24=", Context.class);
                        m4890t.m4889u("SnrtMYC9+qStj9ZoSAj1DR6mGb7YlLFiZbsMn2F8wpevpQUtlzrwws7lBSZ1KQhS", "3Z4807bJ0KoyYYoQ9dcfmEBolGH5CdxZiQurF1neOqs=", Context.class);
                        m4890t.m4889u("8ik9NLkf2/tOyUWOONqxKfb9fxC2GinfkSDGvq3LdfAIyGrwvLIO/sr/FhjBRdwL", "E5fWzXFb8RAG+0QVT91wIl5kQfApis+Ago2PTXmCPgE=", MotionEvent.class, DisplayMetrics.class);
                        m4890t.m4889u("fI0N3kbZw/umjLZrsorw2Wh0+0tg4xypZfrKau+VpPGw8hjO0IIZVyJi5hB0Wcbt", "YnDH+tthutt98if0TMBwjusoYiZkXUV9qrwRfqxnS3g=", MotionEvent.class, DisplayMetrics.class);
                        m4890t.m4889u("llxemQySqp4ImE2+K1SCPJZsWjXNCqydynC9yBT/03FiPJ85o8JSvF0iMBwiw5vV", "Do3k5DuMuAsRGeDxKZVVE8+FSftLk9ZlBUPdFxDzrUE=", new Class[0]);
                        m4890t.m4889u("M8X9pjLXmkUmNpxAUiXCS0VzRrfgsx47JCdWPtF77o1zbxjaTxGH9o3y3XsfapA3", "IGAB4+J/PDJStxsBeRODYeAaV8Ap48L0bK2MK3UJNBs=", new Class[0]);
                        m4890t.m4889u("uVfRV2qL6y+/frn7UQ8HZUcJpLFj+yNt3k4Ns9czyDlwcIbIheGCFGCtGsGaaHh4", "RmtCo/dRwPWzjhuo/V+opsA0IDlV0P6pRfQFRNu3WDY=", new Class[0]);
                        m4890t.m4889u("9GRJeHWq4dh2BvJK4ycB7gT7rSPz0ZkF1/0dgXOpChUtvNoPNNrpav7wZxlsKwP4", "wAGvvwsR6C1vDVsIyeUg+KWcunmHMDzvTAjP5mYaviw=", new Class[0]);
                        m4890t.m4889u("hUIXYyX7voAFfmX9K6Tyj7UNRMoApsO3NHhichzgf1HY6Km4YpCnpT8GA4sfwulx", "RhEw32BK9OU3wzUC3Jj98VTZvnt6yWz3Jzx/x8tD2qo=", new Class[0]);
                        m4890t.m4889u("n2Au6L29UBBc2fEdbhtyAmTKpQRV7jQpdKVw+7Bcq8RzfUQmGwjEOtWTLTfPZXlx", "dCN8M8R2yrrpg52x17w1rrrZtT0eIXPeEX6Ibp28VuQ=", new Class[0]);
                        m4890t.m4889u("iH08ecr5p8p5eQT3/BFJ6jAaJm3eLNoIe2oA7hLZl5P0jAtinrUdPK16lrJGpxBz", "Gvy6wet11FtrNaAWhnvYSI1hOQnkPBTAgqoI9PXuwaM=", Context.class, Boolean.TYPE, String.class);
                        m4890t.m4889u("xd283h5qAcacM5zVZnbCaCYEYmyBvCzSWmcoDFc838gJ/DBCdoedE0EgOC5ZJs5s", "KFN28huBDzw/UNPPRO5YgG4GEIzzfegN1j75wmksmGk=", StackTraceElement[].class);
                        m4890t.m4889u("hQ5xuCRMiz6eJqaT4+9Wf/Kj854Yma0NmQLTM8SLOoEkyUHQjbgUSxF3PTxTz3Bq", "CIY4BMAyy7Fe28Pq7/h8od2SEEojcWEgmd3J7ORxssU=", View.class, DisplayMetrics.class, Boolean.TYPE);
                        m4890t.m4889u("yRC8yDQzUDrmroLbdHZh1cdlZfd8ub/FsIslAHpddfKGkTWa/jUYdNJ0tT+5diCM", "HM4qeDzacgZSWStWAwQJTi2Amm6uvEB2WlZumyUY0B8=", Context.class, Boolean.TYPE);
                        m4890t.m4889u("VJibBREzYucPjNukhWG65jB60OIZQrcDVR3W2JV3G5ynshQ4Nd74pHrZYUgRiYK0", "TiANcug5zndviERrHpzUihvZthrd+vHCK5ngnbrocVE=", View.class, Activity.class, Boolean.TYPE);
                        m4890t.m4889u("e3op4R4hYomHt8fD4e46pNuu/60OumzY4fWht1zvNw/PVRGde3uP5Y0px+X+3p+E", "jLlOehpoNgAQzvuHrTyBcudcfwOhFguv/E47mcpJrto=", Long.TYPE);
                        try {
                            if (((Boolean) aql.f4908u.m4770f()).booleanValue()) {
                                m4890t.m4889u("nKg4HNqb3w+l+hWBt0181NzZuRHIlhptjDdMcQ5dE3JWGvySjoPYfybKeplgFTfD", "XexrqxQZ83Dsows1I9oUUMC34QJd/x5AyWUFr5Va7Yc=", Context.class);
                            }
                        } catch (IllegalStateException unused2) {
                        }
                        m4890t.m4889u("CaNDUMCWCaGbEGmM1Yj39BxpZ8FPbNtvFQfeZOrEB+NgN6NGnTaiZA/U29rLN/tj", "INyd2w/uRsAGkjbqPl7ialNH5emmi1OBLIEI6gUyIzM=", Context.class);
                        try {
                            if (Build.VERSION.SDK_INT >= 26) {
                                if (((Boolean) aql.f4909v.m4770f()).booleanValue()) {
                                    m4890t.m4889u("pJoEelkZiKPOxk90a9HaLYHjU9iyGURNQtyjZ4Eem1yb/gFTG2yLqZLPefEosnhY", "oU8dxPYnryKlPd91mK89Z7Qor1PaeT+LMYSHnhThZ+4=", NetworkCapabilities.class);
                                }
                            }
                        } catch (IllegalStateException unused3) {
                        }
                    }
                    f4662a = m4890t;
                }
            }
        }
        return f4662a;
    }

    /* renamed from: u */
    static any m4935u(anw anwVar, MotionEvent motionEvent, DisplayMetrics displayMetrics) throws ano {
        Method m4901i = anwVar.m4901i("8ik9NLkf2/tOyUWOONqxKfb9fxC2GinfkSDGvq3LdfAIyGrwvLIO/sr/FhjBRdwL", "E5fWzXFb8RAG+0QVT91wIl5kQfApis+Ago2PTXmCPgE=");
        if (m4901i == null || motionEvent == null) {
            throw new ano();
        }
        try {
            return new any((String) m4901i.invoke(null, motionEvent, displayMetrics));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ano(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: v */
    public static synchronized void m4934v(Context context, boolean z) {
        synchronized (anb.class) {
            if (f4697s) {
                return;
            }
            f4699x = System.currentTimeMillis() / 1000;
            f4662a = m4936t(context, z);
            if (((Boolean) aql.f4909v.m4770f()).booleanValue()) {
                f4700y = ang.m4919c(context);
            }
            f4697s = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: w */
    public static final void m4933w(List list) {
        ExecutorService m4900j;
        if (f4662a == null || (m4900j = f4662a.m4900j()) == null || list.isEmpty()) {
            return;
        }
        try {
            m4900j.invokeAll(list, ((Long) aql.f4898k.m4770f()).longValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Log.d(f4698w, String.format("class methods got exception: %s", anz.m4871e(e)));
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amw
    /* renamed from: a */
    protected final long mo4944a(StackTraceElement[] stackTraceElementArr) throws ano {
        Method m4901i = f4662a.m4901i("xd283h5qAcacM5zVZnbCaCYEYmyBvCzSWmcoDFc838gJ/DBCdoedE0EgOC5ZJs5s", "KFN28huBDzw/UNPPRO5YgG4GEIzzfegN1j75wmksmGk=");
        if (m4901i == null || stackTraceElementArr == null) {
            throw new ano();
        }
        try {
            return new anp((String) m4901i.invoke(null, stackTraceElementArr)).f4724a.longValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ano(e);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amw
    /* renamed from: b */
    protected final any mo4943b(MotionEvent motionEvent) throws ano {
        Method m4901i = f4662a.m4901i("fI0N3kbZw/umjLZrsorw2Wh0+0tg4xypZfrKau+VpPGw8hjO0IIZVyJi5hB0Wcbt", "YnDH+tthutt98if0TMBwjusoYiZkXUV9qrwRfqxnS3g=");
        if (m4901i == null || motionEvent == null) {
            throw new ano();
        }
        try {
            return new any((String) m4901i.invoke(null, motionEvent, this.f4678q));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ano(e);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amw
    /* renamed from: c */
    protected aga mo4942c(Context context, View view, Activity activity) {
        aga m5557an = afr.m5557an();
        if (!TextUtils.isEmpty(this.f4702u)) {
            m5557an.m5451N(this.f4702u);
        }
        m4932x(m4936t(context, this.f4701t), m5557an, view, activity, true);
        return m5557an;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amw
    /* renamed from: d */
    protected final aga mo4941d(Context context, afd afdVar) {
        aga m5557an = afr.m5557an();
        if (!TextUtils.isEmpty(this.f4702u)) {
            m5557an.m5451N(this.f4702u);
        }
        mo4937r(m4936t(context, this.f4701t), context, m5557an, afdVar);
        if (afdVar != null && afdVar.m5647f() && ((Boolean) aql.f4902o.m4770f()).booleanValue() && !anz.m4869g(afdVar.m5649d().m5638d())) {
            aga m5502c = afz.m5502c();
            m5502c.m5399d(afdVar.m5649d().m5638d());
            m5557an.m5419ai((afz) m5502c.mo3179aR());
        }
        return m5557an;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amw
    /* renamed from: i */
    protected aga mo4940i(Context context, View view, Activity activity) {
        aga m5557an = afr.m5557an();
        m5557an.m5451N(this.f4702u);
        m4932x(m4936t(context, this.f4701t), m5557an, view, activity, false);
        return m5557an;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amw, com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: n */
    public final void mo4938n(View view) {
        if (((Boolean) aql.f4901n.m4770f()).booleanValue()) {
            if (this.f4703v == null) {
                anw anwVar = f4662a;
                this.f4703v = new aod(anwVar.f4742a, anwVar.m4904f());
            }
            this.f4703v.m4858d(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: p */
    public List mo4930p(anw anwVar, Context context, aga agaVar, afd afdVar) {
        int m4909a = anwVar.m4909a();
        ArrayList arrayList = new ArrayList();
        if (!anwVar.m4894p()) {
            agaVar.m5420ah(afm.m5629a(afm.f3750v));
            return arrayList;
        }
        arrayList.add(new aoh(anwVar, agaVar, m4909a, context, afdVar, null, null, null));
        arrayList.add(new aok(anwVar, agaVar, f4699x, m4909a, null, null, null));
        arrayList.add(new aor(anwVar, agaVar, m4909a, null, null, null));
        arrayList.add(new aou(anwVar, agaVar, m4909a, null, null, null));
        arrayList.add(new aoz(anwVar, agaVar, m4909a, null, null, null));
        arrayList.add(new aog(anwVar, agaVar, m4909a, context, null, null, null));
        arrayList.add(new aoi(anwVar, agaVar, m4909a, null, null, null));
        arrayList.add(new aoq(anwVar, agaVar, m4909a, null, null, null));
        arrayList.add(new aos(anwVar, agaVar, m4909a, null, null, null));
        arrayList.add(new aoj(anwVar, agaVar, m4909a, null, null, null));
        arrayList.add(new aon(anwVar, agaVar, m4909a, null, null, null));
        arrayList.add(new apa(anwVar, agaVar, m4909a, null, null, null));
        arrayList.add(new aof(anwVar, agaVar, m4909a, null, null, null));
        arrayList.add(new aox(anwVar, agaVar, m4909a, null, null, null));
        arrayList.add(new aov(anwVar, agaVar, m4909a, null, null, null));
        if (Build.VERSION.SDK_INT >= 24 && ((Boolean) aql.f4909v.m4770f()).booleanValue()) {
            arrayList.add(new aop(anwVar, agaVar, m4909a, f4700y, null, null, null));
        }
        if (((Boolean) aql.f4908u.m4770f()).booleanValue()) {
            arrayList.add(new aot(anwVar, agaVar, m4909a, null, null, null));
        }
        arrayList.add(new aoo(anwVar, agaVar, m4909a, null, null, null));
        return arrayList;
    }

    /* renamed from: r */
    protected void mo4937r(anw anwVar, Context context, aga agaVar, afd afdVar) {
        if (anwVar.m4900j() == null) {
            return;
        }
        m4933w(mo4930p(anwVar, context, agaVar, afdVar));
    }

    /* renamed from: x */
    protected final void m4932x(anw anwVar, aga agaVar, View view, Activity activity, boolean z) {
        List arrayList;
        if (!anwVar.m4894p()) {
            agaVar.m5420ah(afm.m5629a(afm.f3750v));
            arrayList = Arrays.asList(new aom(anwVar, agaVar, null, null, null));
        } else {
            m4939j(anwVar, agaVar);
            arrayList = new ArrayList();
            if (anwVar.m4900j() != null) {
                int m4909a = anwVar.m4909a();
                arrayList.add(new aom(anwVar, agaVar, null, null, null));
                arrayList.add(new aor(anwVar, agaVar, m4909a, null, null, null));
                arrayList.add(new aok(anwVar, agaVar, f4699x, m4909a, null, null, null));
                arrayList.add(new aoj(anwVar, agaVar, m4909a, null, null, null));
                arrayList.add(new aoq(anwVar, agaVar, m4909a, null, null, null));
                arrayList.add(new aos(anwVar, agaVar, m4909a, null, null, null));
                arrayList.add(new aon(anwVar, agaVar, m4909a, null, null, null));
                arrayList.add(new aoi(anwVar, agaVar, m4909a, null, null, null));
                arrayList.add(new apa(anwVar, agaVar, m4909a, null, null, null));
                arrayList.add(new aof(anwVar, agaVar, m4909a, null, null, null));
                arrayList.add(new aox(anwVar, agaVar, m4909a, null, null, null));
                arrayList.add(new aow(anwVar, agaVar, m4909a, new Throwable().getStackTrace(), null, null, null));
                arrayList.add(new apb(anwVar, agaVar, m4909a, view, null, null, null));
                arrayList.add(new aov(anwVar, agaVar, m4909a, null, null, null));
                if (((Boolean) aql.f4899l.m4770f()).booleanValue()) {
                    arrayList.add(new aoe(anwVar, agaVar, m4909a, view, activity, null, null, null));
                }
                if (z && ((Boolean) aql.f4901n.m4770f()).booleanValue()) {
                    arrayList.add(new aoy(anwVar, agaVar, m4909a, this.f4703v, null, null, null));
                    m4933w(arrayList);
                }
            }
        }
        m4933w(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public anb(Context context, String str, boolean z) {
        super(context);
        this.f4702u = str;
        this.f4701t = z;
    }
}
