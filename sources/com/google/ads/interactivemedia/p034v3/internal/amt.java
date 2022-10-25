package com.google.ads.interactivemedia.p034v3.internal;

import android.os.ConditionVariable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.amt */
/* loaded from: classes2.dex */
public final class amt implements Runnable {

    /* renamed from: a */
    final /* synthetic */ amu f4656a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public amt(amu amuVar) {
        this.f4656a = amuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConditionVariable conditionVariable;
        boolean z;
        anw anwVar;
        ConditionVariable conditionVariable2;
        if (this.f4656a.f4660b != null) {
            return;
        }
        conditionVariable = amu.f4658c;
        synchronized (conditionVariable) {
            if (this.f4656a.f4660b != null) {
                return;
            }
            boolean z2 = false;
            try {
                z = ((Boolean) aql.f4896i.m4752b()).booleanValue();
            } catch (IllegalStateException unused) {
                z = false;
            }
            if (z) {
                try {
                    anwVar = this.f4656a.f4661e;
                    amu.f4657a = asz.m4635c(anwVar.f4742a, "ADSHIELD");
                } catch (Throwable unused2) {
                }
            }
            z2 = z;
            this.f4656a.f4660b = Boolean.valueOf(z2);
            conditionVariable2 = amu.f4658c;
            conditionVariable2.open();
        }
    }
}
