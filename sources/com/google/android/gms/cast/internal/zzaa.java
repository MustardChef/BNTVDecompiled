package com.google.android.gms.cast.internal;

import android.content.Context;
import com.google.android.gms.flags.Flag;
import com.google.android.gms.flags.FlagRegistry;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzaa {
    public static final Flag<Boolean> zza = Flag.define(0, "gms:cast:remote_display_enabled", (Boolean) false);

    public static final void zza(Context context) {
        FlagRegistry.initialize(context);
    }
}
