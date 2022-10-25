package com.google.ads.interactivemedia.p034v3.internal;

import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bnx */
/* loaded from: classes2.dex */
final class bnx extends bny {
    private bnx() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bnx(byte[] bArr) {
    }

    /* renamed from: a */
    static bnj m3206a(Object obj, long j) {
        return (bnj) bpu.m2896h(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.bny
    /* renamed from: b */
    public final List mo3205b(Object obj, long j) {
        bnj m3206a = m3206a(obj, j);
        if (m3206a.mo3269c()) {
            return m3206a;
        }
        int size = m3206a.size();
        bnj mo3117d = m3206a.mo3117d(size == 0 ? 10 : size + size);
        bpu.m2881w(obj, j, mo3117d);
        return mo3117d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.bny
    /* renamed from: c */
    public final void mo3204c(Object obj, long j) {
        m3206a(obj, j).mo3270b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.bny
    /* renamed from: d */
    public final void mo3203d(Object obj, Object obj2, long j) {
        bnj m3206a = m3206a(obj, j);
        bnj m3206a2 = m3206a(obj2, j);
        int size = m3206a.size();
        int size2 = m3206a2.size();
        if (size > 0 && size2 > 0) {
            if (!m3206a.mo3269c()) {
                m3206a = m3206a.mo3117d(size2 + size);
            }
            m3206a.addAll(m3206a2);
        }
        if (size > 0) {
            m3206a2 = m3206a;
        }
        bpu.m2881w(obj, j, m3206a2);
    }
}
