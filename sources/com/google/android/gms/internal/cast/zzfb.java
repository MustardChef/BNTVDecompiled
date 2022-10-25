package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzfb implements zzou {
    TRIGGER_REASON_NONE(0),
    NO_MDNS_RESPONSE(1),
    NO_MDNS_SUBTYPE_RESPONSE(2),
    SOME_MDNS_SUBTYPE_RESPONSES_RECEIVED(3);
    
    private static final zzov<zzfb> zze = new zzov<zzfb>() { // from class: com.google.android.gms.internal.cast.zzez
    };
    private final int zzf;

    zzfb(int i) {
        this.zzf = i;
    }

    public static zzow zza() {
        return zzfa.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
    }
}
