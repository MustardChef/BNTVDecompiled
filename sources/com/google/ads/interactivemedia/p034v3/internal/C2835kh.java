package com.google.ads.interactivemedia.p034v3.internal;

import android.os.SystemClock;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.kh */
/* loaded from: classes2.dex */
public final class C2835kh {

    /* renamed from: a */
    private final Map f7850a;

    /* renamed from: b */
    private final Map f7851b;

    /* renamed from: c */
    private final Map f7852c;

    /* renamed from: d */
    private final Random f7853d;

    public C2835kh() {
        Random random = new Random();
        this.f7852c = new HashMap();
        this.f7853d = random;
        this.f7850a = new HashMap();
        this.f7851b = new HashMap();
    }

    /* renamed from: e */
    private final List m1788e(List list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        m1786g(elapsedRealtime, this.f7850a);
        m1786g(elapsedRealtime, this.f7851b);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            C2863li c2863li = (C2863li) list.get(i);
            if (!this.f7850a.containsKey(c2863li.f8005b) && !this.f7851b.containsKey(Integer.valueOf(c2863li.f8006c))) {
                arrayList.add(c2863li);
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    private static void m1787f(Object obj, long j, Map map) {
        if (map.containsKey(obj)) {
            int i = C2628cq.f6961a;
            j = Math.max(j, ((Long) map.get(obj)).longValue());
        }
        map.put(obj, Long.valueOf(j));
    }

    /* renamed from: g */
    private static void m1786g(long j, Map map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            if (((Long) entry.getValue()).longValue() <= j) {
                arrayList.add(entry.getKey());
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            map.remove(arrayList.get(i));
        }
    }

    /* renamed from: a */
    public final int m1792a(List list) {
        HashSet hashSet = new HashSet();
        List m1788e = m1788e(list);
        for (int i = 0; i < m1788e.size(); i++) {
            hashSet.add(Integer.valueOf(((C2863li) m1788e.get(i)).f8006c));
        }
        return hashSet.size();
    }

    /* renamed from: b */
    public final C2863li m1791b(List list) {
        C2863li c2863li;
        List m1788e = m1788e(list);
        if (m1788e.size() < 2) {
            return (C2863li) axd.m4420B(m1788e);
        }
        Collections.sort(m1788e, C2834kg.f7849a);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = ((C2863li) m1788e.get(0)).f8006c;
        int i3 = 0;
        while (true) {
            if (i3 >= m1788e.size()) {
                break;
            }
            C2863li c2863li2 = (C2863li) m1788e.get(i3);
            if (i2 == c2863li2.f8006c) {
                arrayList.add(new Pair(c2863li2.f8005b, Integer.valueOf(c2863li2.f8007d)));
                i3++;
            } else if (arrayList.size() == 1) {
                return (C2863li) m1788e.get(0);
            }
        }
        C2863li c2863li3 = (C2863li) this.f7852c.get(arrayList);
        if (c2863li3 == null) {
            List subList = m1788e.subList(0, arrayList.size());
            int i4 = 0;
            for (int i5 = 0; i5 < subList.size(); i5++) {
                i4 += ((C2863li) subList.get(i5)).f8007d;
            }
            int nextInt = this.f7853d.nextInt(i4);
            int i6 = 0;
            while (true) {
                if (i < subList.size()) {
                    c2863li = (C2863li) subList.get(i);
                    i6 += c2863li.f8007d;
                    if (nextInt < i6) {
                        break;
                    }
                    i++;
                } else {
                    c2863li = (C2863li) axd.m4386z(subList);
                    break;
                }
            }
            this.f7852c.put(arrayList, c2863li);
            return c2863li;
        }
        return c2863li3;
    }

    /* renamed from: c */
    public final void m1790c(C2863li c2863li, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime() + j;
        m1787f(c2863li.f8005b, elapsedRealtime, this.f7850a);
        m1787f(Integer.valueOf(c2863li.f8006c), elapsedRealtime, this.f7851b);
    }

    /* renamed from: d */
    public final void m1789d() {
        this.f7850a.clear();
        this.f7851b.clear();
        this.f7852c.clear();
    }
}
