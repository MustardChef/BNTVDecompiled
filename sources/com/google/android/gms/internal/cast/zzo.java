package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionProvider;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzo extends SessionProvider {
    private final CastOptions zza;
    private final zzag zzb;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzo(android.content.Context r3, com.google.android.gms.cast.framework.CastOptions r4, com.google.android.gms.internal.cast.zzag r5) {
        /*
            r2 = this;
            java.util.List r0 = r4.getSupportedNamespaces()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L13
            java.lang.String r0 = r4.getReceiverApplicationId()
            java.lang.String r0 = com.google.android.gms.cast.CastMediaControlIntent.categoryForCast(r0)
            goto L1f
        L13:
            java.lang.String r0 = r4.getReceiverApplicationId()
            java.util.List r1 = r4.getSupportedNamespaces()
            java.lang.String r0 = com.google.android.gms.cast.CastMediaControlIntent.categoryForCast(r0, r1)
        L1f:
            r2.<init>(r3, r0)
            r2.zza = r4
            r2.zzb = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzo.<init>(android.content.Context, com.google.android.gms.cast.framework.CastOptions, com.google.android.gms.internal.cast.zzag):void");
    }

    @Override // com.google.android.gms.cast.framework.SessionProvider
    public final Session createSession(String str) {
        return new CastSession(getContext(), getCategory(), str, this.zza, new com.google.android.gms.cast.framework.media.internal.zzp(getContext(), this.zza, this.zzb));
    }

    @Override // com.google.android.gms.cast.framework.SessionProvider
    public final boolean isSessionRecoverable() {
        return this.zza.getResumeSavedSession();
    }
}
