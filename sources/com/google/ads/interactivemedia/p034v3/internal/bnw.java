package com.google.ads.interactivemedia.p034v3.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bnw */
/* loaded from: classes2.dex */
final class bnw extends bny {

    /* renamed from: a */
    private static final Class f6296a = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private bnw() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bnw(byte[] bArr) {
    }

    /* renamed from: a */
    static List m3208a(Object obj, long j) {
        return (List) bpu.m2896h(obj, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: g */
    private static List m3207g(Object obj, long j, int i) {
        bnt bntVar;
        List arrayList;
        List m3208a = m3208a(obj, j);
        if (m3208a.isEmpty()) {
            if (m3208a instanceof bnu) {
                arrayList = new bnt(i);
            } else if (!(m3208a instanceof bop) || !(m3208a instanceof bnj)) {
                arrayList = new ArrayList(i);
            } else {
                arrayList = ((bnj) m3208a).mo3117d(i);
            }
            bpu.m2881w(obj, j, arrayList);
            return arrayList;
        }
        if (f6296a.isAssignableFrom(m3208a.getClass())) {
            ArrayList arrayList2 = new ArrayList(m3208a.size() + i);
            arrayList2.addAll(m3208a);
            bpu.m2881w(obj, j, arrayList2);
            bntVar = arrayList2;
        } else if (m3208a instanceof bpp) {
            bnt bntVar2 = new bnt(m3208a.size() + i);
            bntVar2.addAll((bpp) m3208a);
            bpu.m2881w(obj, j, bntVar2);
            bntVar = bntVar2;
        } else if ((m3208a instanceof bop) && (m3208a instanceof bnj)) {
            bnj bnjVar = (bnj) m3208a;
            if (bnjVar.mo3269c()) {
                return m3208a;
            }
            bnj mo3117d = bnjVar.mo3117d(m3208a.size() + i);
            bpu.m2881w(obj, j, mo3117d);
            return mo3117d;
        } else {
            return m3208a;
        }
        return bntVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.bny
    /* renamed from: b */
    public final List mo3205b(Object obj, long j) {
        return m3207g(obj, j, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.bny
    /* renamed from: c */
    public final void mo3204c(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) bpu.m2896h(obj, j);
        if (list instanceof bnu) {
            unmodifiableList = ((bnu) list).mo2939e();
        } else if (f6296a.isAssignableFrom(list.getClass())) {
            return;
        } else {
            if (!(list instanceof bop) || !(list instanceof bnj)) {
                unmodifiableList = Collections.unmodifiableList(list);
            } else {
                bnj bnjVar = (bnj) list;
                if (bnjVar.mo3269c()) {
                    bnjVar.mo3270b();
                    return;
                }
                return;
            }
        }
        bpu.m2881w(obj, j, unmodifiableList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.bny
    /* renamed from: d */
    public final void mo3203d(Object obj, Object obj2, long j) {
        List m3208a = m3208a(obj2, j);
        List m3207g = m3207g(obj, j, m3208a.size());
        int size = m3207g.size();
        int size2 = m3208a.size();
        if (size > 0 && size2 > 0) {
            m3207g.addAll(m3208a);
        }
        if (size > 0) {
            m3208a = m3207g;
        }
        bpu.m2881w(obj, j, m3208a);
    }
}
