package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.apw */
/* loaded from: classes2.dex */
public class apw {

    /* renamed from: a */
    protected apt f4862a;

    @Deprecated
    /* renamed from: a */
    public final Uri m4782a(Uri uri, Context context) throws apx, RemoteException {
        arl mo4800d = this.f4862a.mo4800d(arm.m4733c(uri), arm.m4733c(context));
        if (mo4800d == null) {
            throw new apx();
        }
        return (Uri) arm.m4732d(mo4800d);
    }

    @Deprecated
    /* renamed from: b */
    public final String m4781b(Context context) throws RemoteException {
        return this.f4862a.mo4797g(arm.m4733c(context), null);
    }

    @Deprecated
    /* renamed from: c */
    public final boolean m4780c(Uri uri) throws RemoteException {
        return this.f4862a.mo4787q(arm.m4733c(uri));
    }
}
