package com.google.firebase.auth;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class PhoneAuthOptions {
    private final FirebaseAuth zza;
    private Long zzb;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks zzc;
    private Executor zzd;
    private String zze;
    private Activity zzf;
    private PhoneAuthProvider.ForceResendingToken zzg;
    private MultiFactorSession zzh;
    private PhoneMultiFactorInfo zzi;
    private boolean zzj;

    /* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
    /* loaded from: classes3.dex */
    public static final class Builder {
        private final FirebaseAuth zza;
        private String zzb;
        private Long zzc;
        private PhoneAuthProvider.OnVerificationStateChangedCallbacks zzd;
        private Executor zze;
        private Activity zzf;
        private PhoneAuthProvider.ForceResendingToken zzg;
        private MultiFactorSession zzh;
        private PhoneMultiFactorInfo zzi;
        private boolean zzj;

        public Builder(FirebaseAuth firebaseAuth) {
            this.zza = (FirebaseAuth) Preconditions.checkNotNull(firebaseAuth);
        }

        public PhoneAuthOptions build() {
            Preconditions.checkNotNull(this.zza, "FirebaseAuth instance cannot be null");
            Preconditions.checkNotNull(this.zzc, "You must specify an auto-retrieval timeout; please call #setTimeout()");
            Preconditions.checkNotNull(this.zzd, "You must specify callbacks on your PhoneAuthOptions. Please call #setCallbacks()");
            Preconditions.checkNotNull(this.zzf, "You must specify an Activity on your PhoneAuthOptions. Please call #setActivity()");
            this.zze = TaskExecutors.MAIN_THREAD;
            if (this.zzc.longValue() < 0 || this.zzc.longValue() > 120) {
                throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
            }
            MultiFactorSession multiFactorSession = this.zzh;
            if (multiFactorSession != null) {
                if (!((com.google.firebase.auth.internal.zzag) multiFactorSession).zze()) {
                    Preconditions.checkArgument(this.zzi != null, "A phoneMultiFactorInfo must be set for second factor sign-in.");
                    Preconditions.checkArgument(this.zzb == null, "A phone number must not be set for MFA sign-in. A PhoneMultiFactorInfo should be set instead.");
                } else {
                    Preconditions.checkNotEmpty(this.zzb);
                    Preconditions.checkArgument(this.zzi == null, "Invalid MultiFactorSession - use the getSession method in MultiFactorResolver to get a valid sign-in session.");
                }
            } else {
                Preconditions.checkNotEmpty(this.zzb, "The given phoneNumber is empty. Please set a non-empty phone number with #setPhoneNumber()");
                Preconditions.checkArgument(!this.zzj, "You cannot require sms validation without setting a multi-factor session.");
                Preconditions.checkArgument(this.zzi == null, "A phoneMultiFactorInfo must be set for second factor sign-in.");
            }
            return new PhoneAuthOptions(this.zza, this.zzc, this.zzd, this.zze, this.zzb, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, null);
        }

        public Builder requireSmsValidation(boolean z) {
            this.zzj = z;
            return this;
        }

        public Builder setActivity(Activity activity) {
            this.zzf = activity;
            return this;
        }

        public Builder setCallbacks(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
            this.zzd = onVerificationStateChangedCallbacks;
            return this;
        }

        public Builder setForceResendingToken(PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            this.zzg = forceResendingToken;
            return this;
        }

        public Builder setMultiFactorHint(PhoneMultiFactorInfo phoneMultiFactorInfo) {
            this.zzi = phoneMultiFactorInfo;
            return this;
        }

        public Builder setMultiFactorSession(MultiFactorSession multiFactorSession) {
            this.zzh = multiFactorSession;
            return this;
        }

        public Builder setPhoneNumber(String str) {
            this.zzb = str;
            return this;
        }

        public Builder setTimeout(Long l, TimeUnit timeUnit) {
            this.zzc = Long.valueOf(TimeUnit.SECONDS.convert(l.longValue(), timeUnit));
            return this;
        }
    }

    /* synthetic */ PhoneAuthOptions(FirebaseAuth firebaseAuth, Long l, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, String str, Activity activity, PhoneAuthProvider.ForceResendingToken forceResendingToken, MultiFactorSession multiFactorSession, PhoneMultiFactorInfo phoneMultiFactorInfo, boolean z, zzad zzadVar) {
        this.zza = firebaseAuth;
        this.zze = str;
        this.zzb = l;
        this.zzc = onVerificationStateChangedCallbacks;
        this.zzf = activity;
        this.zzd = executor;
        this.zzg = forceResendingToken;
        this.zzh = multiFactorSession;
        this.zzi = phoneMultiFactorInfo;
        this.zzj = z;
    }

    public static Builder newBuilder() {
        return new Builder(FirebaseAuth.getInstance());
    }

    public final FirebaseAuth zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zze;
    }

    public final Long zzc() {
        return this.zzb;
    }

    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks zzd() {
        return this.zzc;
    }

    public final Executor zze() {
        return this.zzd;
    }

    public final PhoneAuthProvider.ForceResendingToken zzf() {
        return this.zzg;
    }

    public final MultiFactorSession zzg() {
        return this.zzh;
    }

    public final boolean zzh() {
        return this.zzj;
    }

    public final Activity zzi() {
        return this.zzf;
    }

    public final PhoneMultiFactorInfo zzj() {
        return this.zzi;
    }

    public final boolean zzk() {
        return this.zzh != null;
    }

    public static Builder newBuilder(FirebaseAuth firebaseAuth) {
        return new Builder(firebaseAuth);
    }
}
