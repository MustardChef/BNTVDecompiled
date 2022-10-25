package com.google.ads.interactivemedia.p034v3.internal;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aac */
/* loaded from: classes2.dex */
public final class aac {

    /* renamed from: a */
    private final ByteArrayOutputStream f2879a;

    /* renamed from: b */
    private final DataOutputStream f2880b;

    public aac() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f2879a = byteArrayOutputStream;
        this.f2880b = new DataOutputStream(byteArrayOutputStream);
    }

    /* renamed from: b */
    private static void m5979b(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    /* renamed from: a */
    public final byte[] m5980a(aaa aaaVar) {
        this.f2879a.reset();
        try {
            m5979b(this.f2880b, aaaVar.f2873a);
            String str = aaaVar.f2874b;
            if (str == null) {
                str = "";
            }
            m5979b(this.f2880b, str);
            this.f2880b.writeLong(aaaVar.f2875c);
            this.f2880b.writeLong(aaaVar.f2876d);
            this.f2880b.write(aaaVar.f2877e);
            this.f2880b.flush();
            return this.f2879a.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
