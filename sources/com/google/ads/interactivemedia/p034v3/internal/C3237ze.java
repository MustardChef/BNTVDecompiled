package com.google.ads.interactivemedia.p034v3.internal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ze */
/* loaded from: classes2.dex */
public final class C3237ze {

    /* renamed from: c */
    private static final Pattern f9555c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: a */
    public int f9556a = -1;

    /* renamed from: b */
    public int f9557b = -1;

    /* renamed from: c */
    private final boolean m483c(String str) {
        Matcher matcher = f9555c.matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group(1);
                int i = C2628cq.f6961a;
                int parseInt = Integer.parseInt(group, 16);
                int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                if (parseInt > 0 || parseInt2 > 0) {
                    this.f9556a = parseInt;
                    this.f9557b = parseInt2;
                    return true;
                }
                return false;
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final boolean m485a() {
        return (this.f9556a == -1 || this.f9557b == -1) ? false : true;
    }

    /* renamed from: b */
    public final void m484b(C2549ak c2549ak) {
        for (int i = 0; i < c2549ak.m5127a(); i++) {
            InterfaceC2548aj m5126b = c2549ak.m5126b(i);
            if (m5126b instanceof aak) {
                aak aakVar = (aak) m5126b;
                if ("iTunSMPB".equals(aakVar.f2905b) && m483c(aakVar.f2906c)) {
                    return;
                }
            } else if (m5126b instanceof aar) {
                aar aarVar = (aar) m5126b;
                if ("com.apple.iTunes".equals(aarVar.f2918a) && "iTunSMPB".equals(aarVar.f2919b) && m483c(aarVar.f2920c)) {
                    return;
                }
            } else {
                continue;
            }
        }
    }
}
