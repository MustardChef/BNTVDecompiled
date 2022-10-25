package com.google.ads.interactivemedia.p034v3.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.boc */
/* loaded from: classes2.dex */
public final class boc implements boz {

    /* renamed from: a */
    private static final boh f6308a = new boa(0);

    /* renamed from: b */
    private final boh f6309b;

    public boc() {
        boh bohVar;
        boh[] bohVarArr = new boh[2];
        bohVarArr[0] = boa.m3193c();
        try {
            bohVar = (boh) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            bohVar = f6308a;
        }
        bohVarArr[1] = bohVar;
        bob bobVar = new bob(bohVarArr);
        bnk.m3259j(bobVar, "messageInfoFactory");
        this.f6309b = bobVar;
    }

    /* renamed from: b */
    private static boolean m3192b(bog bogVar) {
        return bogVar.mo2953c() == 1;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boz
    /* renamed from: a */
    public final boy mo3030a(Class cls) {
        bpa.m2986p(cls);
        bog mo3182a = this.f6309b.mo3182a(cls);
        if (!mo3182a.mo2954b()) {
            if (bnd.class.isAssignableFrom(cls)) {
                if (m3192b(mo3182a)) {
                    return bol.m3137n(mo3182a, boo.m3121b(), bny.m3201f(), bpa.m3008V(), bms.m3338b(), bof.m3183b());
                }
                return bol.m3137n(mo3182a, boo.m3121b(), bny.m3201f(), bpa.m3008V(), null, bof.m3183b());
            } else if (m3192b(mo3182a)) {
                return bol.m3137n(mo3182a, boo.m3122a(), bny.m3202e(), bpa.m3010T(), bms.m3339a(), bof.m3184a());
            } else {
                return bol.m3137n(mo3182a, boo.m3122a(), bny.m3202e(), bpa.m3009U(), null, bof.m3184a());
            }
        } else if (bnd.class.isAssignableFrom(cls)) {
            return bom.m3124c(bpa.m3008V(), bms.m3338b(), mo3182a.mo2955a());
        } else {
            return bom.m3124c(bpa.m3010T(), bms.m3339a(), mo3182a.mo2955a());
        }
    }
}
