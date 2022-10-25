package com.google.ads.interactivemedia.p034v3.internal;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ark */
/* loaded from: classes2.dex */
public class ark extends apm implements arl {
    public ark() {
        super("com.google.android.gms.dynamic.IObjectWrapper");
    }

    /* renamed from: b */
    public static arl m4734b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
        return queryLocalInterface instanceof arl ? (arl) queryLocalInterface : new arj(iBinder);
    }
}
