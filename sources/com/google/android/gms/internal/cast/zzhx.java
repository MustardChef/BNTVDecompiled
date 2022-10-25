package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzhx implements zzou {
    MDNS_RESPONSE_ERROR_UNKNOWN(0),
    ERROR_NOT_RESPONSE_MESSAGE(1),
    ERROR_NO_ANSWERS(2),
    ERROR_READING_RESPONSE_LABELS(3),
    ERROR_READING_IP4_ADDRESS(4),
    ERROR_READING_IP6_ADDRESS(5),
    ERROR_READING_POINTER_RECORD(6),
    ERROR_SKIPPING_POINTER_RECORD(7),
    ERROR_READING_SERVICE_RECORD(8),
    ERROR_SKIPPING_SERVICE_RECORD(9),
    ERROR_READING_TEXT_RECORD(10),
    ERROR_SKIPPING_UNKNOWN_RECORD(11),
    ERROR_END_OF_FILE(12);
    
    private static final zzov<zzhx> zzn = new zzov<zzhx>() { // from class: com.google.android.gms.internal.cast.zzhv
    };
    private final int zzo;

    zzhx(int i) {
        this.zzo = i;
    }

    public static zzow zza() {
        return zzhw.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzo + " name=" + name() + Typography.greater;
    }
}
