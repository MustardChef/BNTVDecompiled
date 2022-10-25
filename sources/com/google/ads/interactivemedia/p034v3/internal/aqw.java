package com.google.ads.interactivemedia.p034v3.internal;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aqw */
/* loaded from: classes2.dex */
public abstract class aqw extends apm implements aqx {
    /* renamed from: b */
    public static aqx m4746b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.signalsdk.ISignalSdkService");
        return queryLocalInterface instanceof aqx ? (aqx) queryLocalInterface : new aqv(iBinder);
    }
}
