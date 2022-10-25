package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.pu */
/* loaded from: classes2.dex */
public final class C2983pu extends AbstractC2991qb {

    /* renamed from: a */
    public static final C2983pu f8508a = new C2983pu("", Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, Collections.emptyList(), false, Collections.emptyMap(), Collections.emptyList());

    /* renamed from: b */
    public final List f8509b;

    /* renamed from: c */
    public final List f8510c;

    /* renamed from: d */
    public final List f8511d;

    /* renamed from: e */
    public final List f8512e;

    /* renamed from: f */
    public final C2962p f8513f;

    /* renamed from: g */
    public final List f8514g;

    /* renamed from: h */
    public final Map f8515h;

    /* renamed from: i */
    public final List f8516i;

    public C2983pu(String str, List list, List list2, List list3, List list4, List list5, List list6, C2962p c2962p, List list7, boolean z, Map map, List list8) {
        super(str, list, z);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list2.size(); i++) {
            Uri uri = ((C2982pt) list2.get(i)).f8502a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        m1347c(list3, arrayList);
        m1347c(list4, arrayList);
        m1347c(list5, arrayList);
        m1347c(list6, arrayList);
        this.f8509b = Collections.unmodifiableList(arrayList);
        this.f8510c = Collections.unmodifiableList(list2);
        Collections.unmodifiableList(list3);
        this.f8511d = Collections.unmodifiableList(list4);
        this.f8512e = Collections.unmodifiableList(list5);
        Collections.unmodifiableList(list6);
        this.f8513f = c2962p;
        this.f8514g = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.f8515h = Collections.unmodifiableMap(map);
        this.f8516i = Collections.unmodifiableList(list8);
    }

    /* renamed from: a */
    public static C2983pu m1349a(String str) {
        Uri parse = Uri.parse(str);
        C2935o c2935o = new C2935o();
        c2935o.m1545S("0");
        c2935o.m1553K(MimeTypes.APPLICATION_M3U8);
        return new C2983pu("", Collections.emptyList(), Collections.singletonList(new C2982pt(parse, c2935o.m1506v(), null, null, null, null)), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, false, Collections.emptyMap(), Collections.emptyList());
    }

    /* renamed from: b */
    private static List m1348b(List list, int i, List list2) {
        ArrayList arrayList = new ArrayList(list2.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            Object obj = list.get(i2);
            int i3 = 0;
            while (true) {
                if (i3 < list2.size()) {
                    C2568ax c2568ax = (C2568ax) list2.get(i3);
                    if (c2568ax.f5239b == i && c2568ax.f5240c == i2) {
                        arrayList.add(obj);
                        break;
                    }
                    i3++;
                }
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    private static void m1347c(List list, List list2) {
        for (int i = 0; i < list.size(); i++) {
            Uri uri = ((C2981ps) list.get(i)).f8499a;
            if (!list2.contains(uri)) {
                list2.add(uri);
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3035rs
    /* renamed from: e */
    public final /* bridge */ /* synthetic */ Object mo1188e(List list) {
        return new C2983pu(this.f8559t, this.f8560u, m1348b(this.f8510c, 0, list), Collections.emptyList(), m1348b(this.f8511d, 1, list), m1348b(this.f8512e, 2, list), Collections.emptyList(), this.f8513f, this.f8514g, this.f8561v, this.f8515h, this.f8516i);
    }
}
