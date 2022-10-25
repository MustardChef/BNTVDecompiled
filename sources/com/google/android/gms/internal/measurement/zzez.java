package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
final class zzez {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i) {
        return (int) (Integer.rotateLeft((int) (i * (-862048943)), 15) * 461845907);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(@NullableDecl Object obj) {
        return zza(obj == null ? 0 : obj.hashCode());
    }
}
