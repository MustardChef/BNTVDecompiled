package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bip */
/* loaded from: classes2.dex */
public final class bip extends bkx {

    /* renamed from: a */
    private static final Writer f5805a = new bio();

    /* renamed from: b */
    private static final bgr f5806b = new bgr("closed");

    /* renamed from: c */
    private final List f5807c;

    /* renamed from: d */
    private String f5808d;

    /* renamed from: e */
    private bgm f5809e;

    public bip() {
        super(f5805a);
        this.f5807c = new ArrayList();
        this.f5809e = bgo.f5697a;
    }

    /* renamed from: s */
    private final bgm m3629s() {
        List list = this.f5807c;
        return (bgm) list.get(list.size() - 1);
    }

    /* renamed from: t */
    private final void m3628t(bgm bgmVar) {
        if (this.f5808d != null) {
            if (!(bgmVar instanceof bgo) || m3549p()) {
                ((bgp) m3629s()).m3710b(this.f5808d, bgmVar);
            }
            this.f5808d = null;
        } else if (this.f5807c.isEmpty()) {
            this.f5809e = bgmVar;
        } else {
            bgm m3629s = m3629s();
            if (m3629s instanceof bgk) {
                ((bgk) m3629s).m3713a(bgmVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    public final bgm m3630a() {
        if (!this.f5807c.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was ".concat(this.f5807c.toString()));
        }
        return this.f5809e;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkx
    /* renamed from: b */
    public final void mo3563b() throws IOException {
        bgk bgkVar = new bgk();
        m3628t(bgkVar);
        this.f5807c.add(bgkVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkx
    /* renamed from: c */
    public final void mo3562c() throws IOException {
        bgp bgpVar = new bgp();
        m3628t(bgpVar);
        this.f5807c.add(bgpVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkx, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (!this.f5807c.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f5807c.add(f5806b);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkx
    /* renamed from: d */
    public final void mo3561d() throws IOException {
        if (this.f5807c.isEmpty() || this.f5808d != null) {
            throw new IllegalStateException();
        }
        if (m3629s() instanceof bgk) {
            List list = this.f5807c;
            list.remove(list.size() - 1);
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkx
    /* renamed from: e */
    public final void mo3560e() throws IOException {
        if (this.f5807c.isEmpty() || this.f5808d != null) {
            throw new IllegalStateException();
        }
        if (m3629s() instanceof bgp) {
            List list = this.f5807c;
            list.remove(list.size() - 1);
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkx
    /* renamed from: f */
    public final void mo3559f(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.f5807c.isEmpty() || this.f5808d != null) {
            throw new IllegalStateException();
        }
        if (m3629s() instanceof bgp) {
            this.f5808d = str;
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkx, java.io.Flushable
    public final void flush() throws IOException {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkx
    /* renamed from: g */
    public final void mo3558g() throws IOException {
        m3628t(bgo.f5697a);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkx
    /* renamed from: h */
    public final void mo3557h(long j) throws IOException {
        m3628t(new bgr(Long.valueOf(j)));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkx
    /* renamed from: i */
    public final void mo3556i(Boolean bool) throws IOException {
        if (bool == null) {
            mo3558g();
        } else {
            m3628t(new bgr(bool));
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkx
    /* renamed from: j */
    public final void mo3555j(Number number) throws IOException {
        if (number == null) {
            mo3558g();
            return;
        }
        if (!m3547r()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: ".concat(number.toString()));
            }
        }
        m3628t(new bgr(number));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkx
    /* renamed from: k */
    public final void mo3554k(String str) throws IOException {
        if (str == null) {
            mo3558g();
        } else {
            m3628t(new bgr(str));
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkx
    /* renamed from: l */
    public final void mo3553l(boolean z) throws IOException {
        m3628t(new bgr(Boolean.valueOf(z)));
    }
}
