package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ayj */
/* loaded from: classes2.dex */
final class ayj implements ayi {

    /* renamed from: a */
    public static final ayj f5298a;

    /* renamed from: b */
    private static final Set f5299b;

    /* renamed from: c */
    private static final /* synthetic */ ayj[] f5300c;

    static {
        ayj ayjVar = new ayj();
        f5298a = ayjVar;
        f5300c = new ayj[]{ayjVar};
        f5299b = new CopyOnWriteArraySet();
    }

    private ayj() {
    }

    public static ayj[] values() {
        return (ayj[]) f5300c.clone();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ayi
    /* renamed from: a */
    public final void mo4330a(Class cls) {
        for (WeakReference weakReference : f5299b) {
            if (cls.equals(weakReference.get())) {
                return;
            }
        }
        ayl.m4327c(cls);
        Set set = f5299b;
        if (set.size() > 1000) {
            set.clear();
        }
        set.add(new WeakReference(cls));
    }
}
