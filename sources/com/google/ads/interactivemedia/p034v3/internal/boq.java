package com.google.ads.interactivemedia.p034v3.internal;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.boq */
/* loaded from: classes2.dex */
public final class boq {

    /* renamed from: a */
    private static final boq f6343a = new boq();

    /* renamed from: c */
    private final ConcurrentMap f6345c = new ConcurrentHashMap();

    /* renamed from: b */
    private final boz f6344b = new boc();

    private boq() {
    }

    /* renamed from: a */
    public static boq m3120a() {
        return f6343a;
    }

    /* renamed from: b */
    public final boy m3119b(Class cls) {
        bnk.m3259j(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        boy boyVar = (boy) this.f6345c.get(cls);
        if (boyVar == null) {
            boyVar = this.f6344b.mo3030a(cls);
            bnk.m3259j(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
            bnk.m3259j(boyVar, "schema");
            boy boyVar2 = (boy) this.f6345c.putIfAbsent(cls, boyVar);
            if (boyVar2 != null) {
                return boyVar2;
            }
        }
        return boyVar;
    }

    /* renamed from: c */
    public final boy m3118c(Object obj) {
        return m3119b(obj.getClass());
    }
}
