package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.asz */
/* loaded from: classes2.dex */
public final class asz {

    /* renamed from: a */
    final atc f5032a;

    /* renamed from: b */
    final boolean f5033b;

    private asz(atc atcVar) {
        this.f5032a = atcVar;
        this.f5033b = atcVar != null;
    }

    /* renamed from: b */
    public static asz m4636b() {
        atb atbVar = new atb(null);
        Log.d("GASS", "Clearcut logging disabled");
        return new asz(atbVar);
    }

    /* renamed from: c */
    public static asz m4635c(Context context, String str) {
        try {
            try {
                try {
                    atc m4633b = atb.m4633b(DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, "com.google.android.gms.ads.dynamite").instantiate("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger"));
                    m4633b.mo4628i(arm.m4733c(context), str);
                    Log.i("GASS", "GassClearcutLogger Initialized.");
                    return new asz(m4633b);
                } catch (Exception e) {
                    throw new ash(e);
                }
            } catch (Exception e2) {
                throw new ash(e2);
            }
        } catch (RemoteException | ash | NullPointerException | SecurityException unused) {
            Log.d("GASS", "Cannot dynamite load clearcut");
            return new asz(new atb(null));
        }
    }

    /* renamed from: a */
    public final asy m4637a(byte[] bArr) {
        return new asy(this, bArr);
    }
}
