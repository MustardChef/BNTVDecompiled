package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.internal.bla;
import com.google.ads.interactivemedia.p034v3.internal.blb;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.blb */
/* loaded from: classes2.dex */
public abstract class blb<MessageType extends blb<MessageType, BuilderType>, BuilderType extends bla<MessageType, BuilderType>> implements boj {

    /* renamed from: b */
    protected int f5991b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ao */
    public int mo3285ao() {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boj
    /* renamed from: ap */
    public final bls mo3177ap() {
        try {
            int as = mo3175as();
            bls blsVar = bls.f6015b;
            byte[] bArr = new byte[as];
            bma m3426B = bma.m3426B(bArr);
            mo3172bj(bnv.m3210ay(m3426B));
            return bnv.m3211ax(m3426B, bArr);
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + 10);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aq */
    public void mo3284aq(int i) {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boj
    /* renamed from: ar */
    public final byte[] mo3176ar() {
        try {
            byte[] bArr = new byte[mo3175as()];
            bma m3426B = bma.m3426B(bArr);
            mo3172bj(m3426B);
            m3426B.m3425C();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + 10);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }
}
