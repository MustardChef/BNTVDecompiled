package com.google.firebase.auth;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthOptions;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public class PhoneAuthProvider {
    public static final String PHONE_SIGN_IN_METHOD = "phone";
    public static final String PROVIDER_ID = "phone";
    private FirebaseAuth zza;

    /* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
    /* loaded from: classes3.dex */
    public static class ForceResendingToken extends AbstractSafeParcelable {
        public static final Parcelable.Creator<ForceResendingToken> CREATOR = new zzd();

        public static ForceResendingToken zza() {
            return new ForceResendingToken();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            SafeParcelWriter.finishObjectHeader(parcel, SafeParcelWriter.beginObjectHeader(parcel));
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
    /* loaded from: classes3.dex */
    public static abstract class OnVerificationStateChangedCallbacks {
        private static final Logger zza = new Logger("PhoneAuthProvider", new String[0]);

        public void onCodeAutoRetrievalTimeOut(String str) {
            zza.m342i("Sms auto retrieval timed-out.", new Object[0]);
        }

        public void onCodeSent(String str, ForceResendingToken forceResendingToken) {
        }

        public abstract void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential);

        public abstract void onVerificationFailed(FirebaseException firebaseException);
    }

    private PhoneAuthProvider(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public static PhoneAuthCredential getCredential(String str, String str2) {
        return PhoneAuthCredential.zzb(str, str2);
    }

    @Deprecated
    public static PhoneAuthProvider getInstance() {
        return new PhoneAuthProvider(FirebaseAuth.getInstance(FirebaseApp.getInstance()));
    }

    public static void verifyPhoneNumber(PhoneAuthOptions phoneAuthOptions) {
        Preconditions.checkNotNull(phoneAuthOptions);
        phoneAuthOptions.zza().zzl(phoneAuthOptions);
    }

    @Deprecated
    public static PhoneAuthProvider getInstance(FirebaseAuth firebaseAuth) {
        return new PhoneAuthProvider(firebaseAuth);
    }

    @Deprecated
    public void verifyPhoneNumber(String str, long j, TimeUnit timeUnit, Activity activity, OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        PhoneAuthOptions.Builder newBuilder = PhoneAuthOptions.newBuilder(this.zza);
        newBuilder.setPhoneNumber(str);
        newBuilder.setTimeout(Long.valueOf(j), timeUnit);
        newBuilder.setActivity(activity);
        newBuilder.setCallbacks(onVerificationStateChangedCallbacks);
        verifyPhoneNumber(newBuilder.build());
    }

    @Deprecated
    public void verifyPhoneNumber(String str, long j, TimeUnit timeUnit, Activity activity, OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, ForceResendingToken forceResendingToken) {
        PhoneAuthOptions.Builder newBuilder = PhoneAuthOptions.newBuilder(this.zza);
        newBuilder.setPhoneNumber(str);
        newBuilder.setTimeout(Long.valueOf(j), timeUnit);
        newBuilder.setActivity(activity);
        newBuilder.setCallbacks(onVerificationStateChangedCallbacks);
        newBuilder.setForceResendingToken(forceResendingToken);
        verifyPhoneNumber(newBuilder.build());
    }
}
