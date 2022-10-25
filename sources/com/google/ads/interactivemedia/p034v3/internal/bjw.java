package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bjw */
/* loaded from: classes2.dex */
final class bjw extends bgy {

    /* renamed from: a */
    final /* synthetic */ Class f5881a;

    /* renamed from: b */
    final /* synthetic */ bjx f5882b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bjw(bjx bjxVar, Class cls) {
        this.f5882b = bjxVar;
        this.f5881a = cls;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final Object read(bkv bkvVar) throws IOException {
        Object read = this.f5882b.f5884b.read(bkvVar);
        if (read == null || this.f5881a.isInstance(read)) {
            return read;
        }
        String name = this.f5881a.getName();
        String name2 = read.getClass().getName();
        String mo3586f = bkvVar.mo3586f();
        int length = String.valueOf(name).length();
        StringBuilder sb = new StringBuilder(length + 30 + String.valueOf(name2).length() + String.valueOf(mo3586f).length());
        sb.append("Expected a ");
        sb.append(name);
        sb.append(" but was ");
        sb.append(name2);
        sb.append("; at path ");
        sb.append(mo3586f);
        throw new bgt(sb.toString());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final void write(bkx bkxVar, Object obj) throws IOException {
        this.f5882b.f5884b.write(bkxVar, obj);
    }
}
