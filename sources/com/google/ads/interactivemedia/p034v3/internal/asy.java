package com.google.ads.interactivemedia.p034v3.internal;

import android.os.RemoteException;
import android.util.Log;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.asy */
/* loaded from: classes2.dex */
public final class asy {

    /* renamed from: a */
    final /* synthetic */ asz f5028a;

    /* renamed from: b */
    private final byte[] f5029b;

    /* renamed from: c */
    private int f5030c;

    /* renamed from: d */
    private int f5031d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ asy(asz aszVar, byte[] bArr) {
        this.f5028a = aszVar;
        this.f5029b = bArr;
    }

    /* renamed from: a */
    public final synchronized void m4640a() {
        try {
            asz aszVar = this.f5028a;
            if (aszVar.f5033b) {
                aszVar.f5032a.mo4629h(this.f5029b);
                this.f5028a.f5032a.mo4630g(this.f5030c);
                this.f5028a.f5032a.mo4631f(this.f5031d);
                this.f5028a.f5032a.mo4627j();
                this.f5028a.f5032a.mo4632e();
            }
        } catch (RemoteException e) {
            Log.d("GASS", "Clearcut log failed", e);
        }
    }

    /* renamed from: b */
    public final void m4639b(int i) {
        this.f5031d = i;
    }

    /* renamed from: c */
    public final void m4638c(int i) {
        this.f5030c = i;
    }
}
