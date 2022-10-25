package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.atj */
/* loaded from: classes2.dex */
public final class atj {

    /* renamed from: a */
    private final String f5042a;

    /* renamed from: b */
    private final ati f5043b;

    /* renamed from: c */
    private ati f5044c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ atj(String str) {
        ati atiVar = new ati(null);
        this.f5043b = atiVar;
        this.f5044c = atiVar;
        atm.m4612j(str);
        this.f5042a = str;
    }

    /* renamed from: a */
    public final atj m4624a(Object obj) {
        ati atiVar = new ati(null);
        this.f5044c.f5041b = atiVar;
        this.f5044c = atiVar;
        atiVar.f5040a = obj;
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f5042a);
        sb.append('{');
        ati atiVar = this.f5043b.f5041b;
        String str = "";
        while (atiVar != null) {
            Object obj = atiVar.f5040a;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
            }
            atiVar = atiVar.f5041b;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
