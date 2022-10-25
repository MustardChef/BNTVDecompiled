package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
abstract class zabb {
    private final zaba zaa;

    /* JADX INFO: Access modifiers changed from: protected */
    public zabb(zaba zabaVar) {
        this.zaa = zabaVar;
    }

    protected abstract void zaa();

    public final void zab(zabd zabdVar) {
        Lock lock;
        Lock lock2;
        zaba zabaVar;
        Lock lock3;
        lock = zabdVar.zai;
        lock.lock();
        try {
            zabaVar = zabdVar.zan;
            if (zabaVar != this.zaa) {
                lock3 = zabdVar.zai;
            } else {
                zaa();
                lock3 = zabdVar.zai;
            }
            lock3.unlock();
        } catch (Throwable th) {
            lock2 = zabdVar.zai;
            lock2.unlock();
            throw th;
        }
    }
}
