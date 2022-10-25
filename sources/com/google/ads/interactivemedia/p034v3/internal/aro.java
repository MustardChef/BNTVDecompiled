package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aro */
/* loaded from: classes2.dex */
public abstract class aro {

    /* renamed from: a */
    private final String f4938a = "com.google.android.gms.ads.adshield.AdShieldCreatorImpl";

    /* renamed from: b */
    private Object f4939b;

    /* renamed from: b */
    protected abstract Object mo4731b(IBinder iBinder);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final Object m4730c(Context context) throws arn {
        if (this.f4939b == null) {
            Preconditions.checkNotNull(context);
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (remoteContext == null) {
                throw new arn();
            }
            try {
                this.f4939b = mo4731b((IBinder) remoteContext.getClassLoader().loadClass(this.f4938a).newInstance());
            } catch (ClassNotFoundException e) {
                throw new arn("Could not load creator class.", e);
            } catch (IllegalAccessException e2) {
                throw new arn("Could not access creator.", e2);
            } catch (InstantiationException e3) {
                throw new arn("Could not instantiate creator.", e3);
            }
        }
        return this.f4939b;
    }
}
