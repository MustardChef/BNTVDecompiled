package com.google.android.gms.cast.framework;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public abstract class SessionProvider {
    private final Context zza;
    private final String zzb;
    private final zzaw zzc = new zzaw(this, null);

    /* JADX INFO: Access modifiers changed from: protected */
    public SessionProvider(Context context, String str) {
        this.zza = ((Context) Preconditions.checkNotNull(context)).getApplicationContext();
        this.zzb = Preconditions.checkNotEmpty(str);
    }

    public abstract Session createSession(String str);

    public final String getCategory() {
        return this.zzb;
    }

    public final Context getContext() {
        return this.zza;
    }

    public abstract boolean isSessionRecoverable();

    public final IBinder zza() {
        return this.zzc;
    }
}
