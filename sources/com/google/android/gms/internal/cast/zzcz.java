package com.google.android.gms.internal.cast;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public abstract class zzcz<T> implements Serializable {
    public static <T> zzcz<T> zzb(@NullableDecl T t) {
        return t == null ? zzcw.zza : new zzdb(t);
    }

    @NullableDecl
    public abstract T zza();
}
