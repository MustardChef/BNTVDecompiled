package com.google.android.gms.internal.p038firebaseauthapi;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzw */
/* loaded from: classes3.dex */
public class zzzw extends IOException {
    private zzaar zza;

    public zzzw(String str) {
        super(str);
        this.zza = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzzw zzb() {
        return new zzzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzzw zzc() {
        return new zzzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzzw zzd() {
        return new zzzw("CodedInputStream encountered a malformed varint.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzzw zze() {
        return new zzzw("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzzw zzf() {
        return new zzzw("Protocol message end-group tag did not match expected tag.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzzv zzg() {
        return new zzzv("Protocol message tag had invalid wire type.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzzw zzh() {
        return new zzzw("Failed to parse the message.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzzw zzi() {
        return new zzzw("Protocol message had invalid UTF-8.");
    }

    public final zzzw zza(zzaar zzaarVar) {
        this.zza = zzaarVar;
        return this;
    }
}
