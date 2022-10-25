package com.google.android.gms.internal.p038firebaseauthapi;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzue */
/* loaded from: classes3.dex */
final class zzue extends LifecycleCallback {
    private final List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> zza;

    private zzue(LifecycleFragment lifecycleFragment, List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> list) {
        super(lifecycleFragment);
        this.mLifecycleFragment.addCallback("PhoneAuthActivityStopCallback", this);
        this.zza = list;
    }

    public static void zza(Activity activity, List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> list) {
        LifecycleFragment fragment = getFragment(activity);
        if (((zzue) fragment.getCallbackOrNull("PhoneAuthActivityStopCallback", zzue.class)) == null) {
            new zzue(fragment, list);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        synchronized (this.zza) {
            this.zza.clear();
        }
    }
}
