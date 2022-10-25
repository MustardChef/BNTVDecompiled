package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.concurrent.Executor;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.apq */
/* loaded from: classes2.dex */
public final class apq extends aro {

    /* renamed from: a */
    private static final apq f4861a = new apq();

    private apq() {
    }

    /* renamed from: a */
    public static apt m4804a(Context context, Executor executor, aew aewVar) {
        apt aptVar = null;
        if (aewVar.m5689d() && GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 12800000) == 0) {
            aptVar = f4861a.m4803d(context, executor, aewVar);
        }
        return aptVar == null ? new BinderC2558app(context, executor, aewVar) : aptVar;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, com.google.ads.interactivemedia.v3.internal.apv] */
    /* renamed from: d */
    private final apt m4803d(Context context, Executor executor, aew aewVar) {
        try {
            IBinder mo4783e = m4730c(context).mo4783e(arm.m4733c(context), arm.m4733c(executor), aewVar.mo3176ar());
            if (mo4783e == null) {
                return null;
            }
            IInterface queryLocalInterface = mo4783e.queryLocalInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            return queryLocalInterface instanceof apt ? (apt) queryLocalInterface : new apr(mo4783e);
        } catch (RemoteException | arn | IllegalArgumentException | LinkageError unused) {
            return null;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aro
    /* renamed from: b */
    protected final /* synthetic */ Object mo4731b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.adshield.internal.IAdShieldCreator");
        return queryLocalInterface instanceof apv ? (apv) queryLocalInterface : new apu(iBinder);
    }
}
