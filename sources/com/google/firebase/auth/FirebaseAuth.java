package com.google.firebase.auth;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p038firebaseauthapi.zzsy;
import com.google.android.gms.internal.p038firebaseauthapi.zzta;
import com.google.android.gms.internal.p038firebaseauthapi.zzte;
import com.google.android.gms.internal.p038firebaseauthapi.zztu;
import com.google.android.gms.internal.p038firebaseauthapi.zztw;
import com.google.android.gms.internal.p038firebaseauthapi.zzud;
import com.google.android.gms.internal.p038firebaseauthapi.zzux;
import com.google.android.gms.internal.p038firebaseauthapi.zzvh;
import com.google.android.gms.internal.p038firebaseauthapi.zzwg;
import com.google.android.gms.internal.p038firebaseauthapi.zzwt;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.auth.internal.zzay;
import com.google.firebase.auth.internal.zzbg;
import com.google.firebase.auth.internal.zzbi;
import com.google.firebase.auth.internal.zzbj;
import com.google.firebase.auth.internal.zzbk;
import com.google.firebase.auth.internal.zzbm;
import com.google.firebase.internal.InternalTokenResult;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public abstract class FirebaseAuth implements InternalAuthProvider {
    private FirebaseApp zza;
    private final List<IdTokenListener> zzb;
    private final List<com.google.firebase.auth.internal.IdTokenListener> zzc;
    private List<AuthStateListener> zzd;
    private zzsy zze;
    private FirebaseUser zzf;
    private com.google.firebase.auth.internal.zzw zzg;
    private final Object zzh;
    private String zzi;
    private final Object zzj;
    private String zzk;
    private final zzbg zzl;
    private final zzbm zzm;
    private final com.google.firebase.auth.internal.zzf zzn;
    private zzbi zzo;
    private zzbj zzp;

    /* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
    /* loaded from: classes3.dex */
    public interface AuthStateListener {
        void onAuthStateChanged(FirebaseAuth firebaseAuth);
    }

    /* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
    /* loaded from: classes3.dex */
    public interface IdTokenListener {
        void onIdTokenChanged(FirebaseAuth firebaseAuth);
    }

    public FirebaseAuth(FirebaseApp firebaseApp) {
        zzwg zzd;
        zzsy zza = zztw.zza(firebaseApp.getApplicationContext(), zztu.zza(Preconditions.checkNotEmpty(firebaseApp.getOptions().getApiKey())));
        zzbg zzbgVar = new zzbg(firebaseApp.getApplicationContext(), firebaseApp.getPersistenceKey());
        zzbm zza2 = zzbm.zza();
        com.google.firebase.auth.internal.zzf zza3 = com.google.firebase.auth.internal.zzf.zza();
        this.zzh = new Object();
        this.zzj = new Object();
        this.zza = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.zze = (zzsy) Preconditions.checkNotNull(zza);
        zzbg zzbgVar2 = (zzbg) Preconditions.checkNotNull(zzbgVar);
        this.zzl = zzbgVar2;
        this.zzg = new com.google.firebase.auth.internal.zzw();
        zzbm zzbmVar = (zzbm) Preconditions.checkNotNull(zza2);
        this.zzm = zzbmVar;
        this.zzn = (com.google.firebase.auth.internal.zzf) Preconditions.checkNotNull(zza3);
        this.zzb = new CopyOnWriteArrayList();
        this.zzc = new CopyOnWriteArrayList();
        this.zzd = new CopyOnWriteArrayList();
        this.zzp = zzbj.zza();
        FirebaseUser zzb = zzbgVar2.zzb();
        this.zzf = zzb;
        if (zzb != null && (zzd = zzbgVar2.zzd(zzb)) != null) {
            zza(this.zzf, zzd, false, false);
        }
        zzbmVar.zzf(this);
    }

    public static FirebaseAuth getInstance() {
        return (FirebaseAuth) FirebaseApp.getInstance().get(FirebaseAuth.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks zzJ(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        return (this.zzg.zzc() && str.equals(this.zzg.zza())) ? new zzq(this, onVerificationStateChangedCallbacks) : onVerificationStateChangedCallbacks;
    }

    private final boolean zzK(String str) {
        ActionCodeUrl parseLink = ActionCodeUrl.parseLink(str);
        return (parseLink == null || TextUtils.equals(this.zzk, parseLink.zza())) ? false : true;
    }

    public void addAuthStateListener(AuthStateListener authStateListener) {
        this.zzd.add(authStateListener);
        this.zzp.execute(new zzk(this, authStateListener));
    }

    public void addIdTokenListener(IdTokenListener idTokenListener) {
        this.zzb.add(idTokenListener);
        this.zzp.execute(new zzj(this, idTokenListener));
    }

    public Task<Void> applyActionCode(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zzE(this.zza, str, this.zzk);
    }

    public Task<ActionCodeResult> checkActionCode(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zzD(this.zza, str, this.zzk);
    }

    public Task<Void> confirmPasswordReset(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zze.zzG(this.zza, str, str2, this.zzk);
    }

    public Task<AuthResult> createUserWithEmailAndPassword(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zze.zzp(this.zza, str, str2, this.zzk, new zzs(this));
    }

    public Task<SignInMethodQueryResult> fetchSignInMethodsForEmail(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zzz(this.zza, str, this.zzk);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider, com.google.firebase.internal.InternalTokenProvider
    public final Task<GetTokenResult> getAccessToken(boolean z) {
        return zzh(this.zzf, z);
    }

    public FirebaseApp getApp() {
        return this.zza;
    }

    public FirebaseUser getCurrentUser() {
        return this.zzf;
    }

    public FirebaseAuthSettings getFirebaseAuthSettings() {
        return this.zzg;
    }

    public String getLanguageCode() {
        String str;
        synchronized (this.zzh) {
            str = this.zzi;
        }
        return str;
    }

    public Task<AuthResult> getPendingAuthResult() {
        return this.zzm.zzd();
    }

    public String getTenantId() {
        String str;
        synchronized (this.zzj) {
            str = this.zzk;
        }
        return str;
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider, com.google.firebase.internal.InternalTokenProvider
    public final String getUid() {
        FirebaseUser firebaseUser = this.zzf;
        if (firebaseUser == null) {
            return null;
        }
        return firebaseUser.getUid();
    }

    public boolean isSignInWithEmailLink(String str) {
        return EmailAuthCredential.zzi(str);
    }

    public void removeAuthStateListener(AuthStateListener authStateListener) {
        this.zzd.remove(authStateListener);
    }

    public void removeIdTokenListener(IdTokenListener idTokenListener) {
        this.zzb.remove(idTokenListener);
    }

    public Task<Void> sendPasswordResetEmail(String str) {
        Preconditions.checkNotEmpty(str);
        return sendPasswordResetEmail(str, null);
    }

    public Task<Void> sendSignInLinkToEmail(String str, ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(actionCodeSettings);
        if (actionCodeSettings.canHandleCodeInApp()) {
            String str2 = this.zzi;
            if (str2 != null) {
                actionCodeSettings.zzc(str2);
            }
            return this.zze.zzB(this.zza, str, actionCodeSettings, this.zzk);
        }
        throw new IllegalArgumentException("You must set canHandleCodeInApp in your ActionCodeSettings to true for Email-Link Sign-in.");
    }

    public Task<Void> setFirebaseUIVersion(String str) {
        return this.zze.zzL(str);
    }

    public void setLanguageCode(String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzh) {
            this.zzi = str;
        }
    }

    public void setTenantId(String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzj) {
            this.zzk = str;
        }
    }

    public Task<AuthResult> signInAnonymously() {
        FirebaseUser firebaseUser = this.zzf;
        if (firebaseUser == null || !firebaseUser.isAnonymous()) {
            return this.zze.zzj(this.zza, new zzs(this), this.zzk);
        }
        com.google.firebase.auth.internal.zzx zzxVar = (com.google.firebase.auth.internal.zzx) this.zzf;
        zzxVar.zzn(false);
        return Tasks.forResult(new com.google.firebase.auth.internal.zzr(zzxVar));
    }

    public Task<AuthResult> signInWithCredential(AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        AuthCredential zza = authCredential.zza();
        if (zza instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza;
            if (!emailAuthCredential.zzh()) {
                return this.zze.zzq(this.zza, emailAuthCredential.zzb(), emailAuthCredential.zzc(), this.zzk, new zzs(this));
            }
            if (zzK(emailAuthCredential.zzd())) {
                return Tasks.forException(zzte.zza(new Status(17072)));
            }
            return this.zze.zzr(this.zza, emailAuthCredential, new zzs(this));
        } else if (zza instanceof PhoneAuthCredential) {
            return this.zze.zzw(this.zza, (PhoneAuthCredential) zza, this.zzk, new zzs(this));
        } else {
            return this.zze.zzg(this.zza, zza, this.zzk, new zzs(this));
        }
    }

    public Task<AuthResult> signInWithCustomToken(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zzf(this.zza, str, this.zzk, new zzs(this));
    }

    public Task<AuthResult> signInWithEmailAndPassword(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zze.zzq(this.zza, str, str2, this.zzk, new zzs(this));
    }

    public Task<AuthResult> signInWithEmailLink(String str, String str2) {
        return signInWithCredential(EmailAuthProvider.getCredentialWithLink(str, str2));
    }

    public void signOut() {
        zzb();
        zzbi zzbiVar = this.zzo;
        if (zzbiVar != null) {
            zzbiVar.zzc();
        }
    }

    public Task<AuthResult> startActivityForSignInWithProvider(Activity activity, FederatedAuthProvider federatedAuthProvider) {
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(activity);
        if (!zzta.zza()) {
            return Tasks.forException(zzte.zza(new Status(17063)));
        }
        TaskCompletionSource<AuthResult> taskCompletionSource = new TaskCompletionSource<>();
        if (!this.zzm.zzi(activity, taskCompletionSource, this)) {
            return Tasks.forException(zzte.zza(new Status(17057)));
        }
        this.zzm.zzb(activity.getApplicationContext(), this);
        federatedAuthProvider.zza(activity);
        return taskCompletionSource.getTask();
    }

    public void useAppLanguage() {
        synchronized (this.zzh) {
            this.zzi = zzud.zza();
        }
    }

    public void useEmulator(String str, int i) {
        Preconditions.checkNotEmpty(str);
        boolean z = false;
        if (i >= 0 && i <= 65535) {
            z = true;
        }
        Preconditions.checkArgument(z, "Port number must be in the range 0-65535");
        zzvh.zza(this.zza, str, i);
    }

    public Task<String> verifyPasswordResetCode(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zzF(this.zza, str, this.zzk);
    }

    public final Task<Void> zzA(FirebaseUser firebaseUser, MultiFactorAssertion multiFactorAssertion, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(multiFactorAssertion);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            return this.zze.zzN(this.zza, (PhoneMultiFactorAssertion) multiFactorAssertion, firebaseUser, str, new zzs(this));
        }
        return Tasks.forException(zzte.zza(new Status(FirebaseError.ERROR_INTERNAL_ERROR)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(FirebaseUser firebaseUser, zzwg zzwgVar, boolean z, boolean z2) {
        boolean z3;
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzwgVar);
        boolean z4 = false;
        boolean z5 = true;
        boolean z6 = this.zzf != null && firebaseUser.getUid().equals(this.zzf.getUid());
        if (z6 || !z2) {
            FirebaseUser firebaseUser2 = this.zzf;
            if (firebaseUser2 == null) {
                z3 = true;
            } else {
                z4 = (!z6 || (firebaseUser2.zze().zze().equals(zzwgVar.zze()) ^ true)) ? true : true;
                z3 = true ^ z6;
                z5 = z4;
            }
            Preconditions.checkNotNull(firebaseUser);
            FirebaseUser firebaseUser3 = this.zzf;
            if (firebaseUser3 == null) {
                this.zzf = firebaseUser;
            } else {
                firebaseUser3.zzb(firebaseUser.getProviderData());
                if (!firebaseUser.isAnonymous()) {
                    this.zzf.zzc();
                }
                this.zzf.zzi(firebaseUser.getMultiFactor().getEnrolledFactors());
            }
            if (z) {
                this.zzl.zza(this.zzf);
            }
            if (z5) {
                FirebaseUser firebaseUser4 = this.zzf;
                if (firebaseUser4 != null) {
                    firebaseUser4.zzf(zzwgVar);
                }
                zzf(this.zzf);
            }
            if (z3) {
                zzg(this.zzf);
            }
            if (z) {
                this.zzl.zzc(firebaseUser, zzwgVar);
            }
            zzd().zzb(this.zzf.zze());
        }
    }

    public final void zzb() {
        FirebaseUser firebaseUser = this.zzf;
        if (firebaseUser != null) {
            zzbg zzbgVar = this.zzl;
            Preconditions.checkNotNull(firebaseUser);
            zzbgVar.zze(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.getUid()));
            this.zzf = null;
        }
        this.zzl.zze("com.google.firebase.auth.FIREBASE_USER");
        zzf(null);
        zzg(null);
    }

    public final synchronized void zzc(zzbi zzbiVar) {
        this.zzo = zzbiVar;
    }

    public final synchronized zzbi zzd() {
        if (this.zzo == null) {
            zzc(new zzbi(this.zza));
        }
        return this.zzo;
    }

    public final FirebaseApp zze() {
        return this.zza;
    }

    public final void zzf(FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            String uid = firebaseUser.getUid();
            StringBuilder sb = new StringBuilder(String.valueOf(uid).length() + 45);
            sb.append("Notifying id token listeners about user ( ");
            sb.append(uid);
            sb.append(" ).");
            Log.d("FirebaseAuth", sb.toString());
        } else {
            Log.d("FirebaseAuth", "Notifying id token listeners about a sign-out event.");
        }
        this.zzp.execute(new zzl(this, new InternalTokenResult(firebaseUser != null ? firebaseUser.zzh() : null)));
    }

    public final void zzg(FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            String uid = firebaseUser.getUid();
            StringBuilder sb = new StringBuilder(String.valueOf(uid).length() + 47);
            sb.append("Notifying auth state listeners about user ( ");
            sb.append(uid);
            sb.append(" ).");
            Log.d("FirebaseAuth", sb.toString());
        } else {
            Log.d("FirebaseAuth", "Notifying auth state listeners about a sign-out event.");
        }
        this.zzp.execute(new zzm(this));
    }

    public final Task<GetTokenResult> zzh(FirebaseUser firebaseUser, boolean z) {
        if (firebaseUser == null) {
            return Tasks.forException(zzte.zza(new Status(FirebaseError.ERROR_NO_SIGNED_IN_USER)));
        }
        zzwg zze = firebaseUser.zze();
        if (!zze.zzb() || z) {
            return this.zze.zze(this.zza, firebaseUser, zze.zzd(), new zzn(this));
        }
        return Tasks.forResult(zzay.zza(zze.zze()));
    }

    public final Task<Void> zzi(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        AuthCredential zza = authCredential.zza();
        if (zza instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza;
            if ("password".equals(emailAuthCredential.getSignInMethod())) {
                return this.zze.zzs(this.zza, firebaseUser, emailAuthCredential.zzb(), emailAuthCredential.zzc(), firebaseUser.getTenantId(), new zzt(this));
            }
            if (zzK(emailAuthCredential.zzd())) {
                return Tasks.forException(zzte.zza(new Status(17072)));
            }
            return this.zze.zzu(this.zza, firebaseUser, emailAuthCredential, new zzt(this));
        } else if (zza instanceof PhoneAuthCredential) {
            return this.zze.zzx(this.zza, firebaseUser, (PhoneAuthCredential) zza, this.zzk, new zzt(this));
        } else {
            return this.zze.zzh(this.zza, firebaseUser, zza, firebaseUser.getTenantId(), new zzt(this));
        }
    }

    public final Task<AuthResult> zzj(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        AuthCredential zza = authCredential.zza();
        if (zza instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza;
            if ("password".equals(emailAuthCredential.getSignInMethod())) {
                return this.zze.zzt(this.zza, firebaseUser, emailAuthCredential.zzb(), emailAuthCredential.zzc(), firebaseUser.getTenantId(), new zzt(this));
            }
            if (zzK(emailAuthCredential.zzd())) {
                return Tasks.forException(zzte.zza(new Status(17072)));
            }
            return this.zze.zzv(this.zza, firebaseUser, emailAuthCredential, new zzt(this));
        } else if (zza instanceof PhoneAuthCredential) {
            return this.zze.zzy(this.zza, firebaseUser, (PhoneAuthCredential) zza, this.zzk, new zzt(this));
        } else {
            return this.zze.zzi(this.zza, firebaseUser, zza, firebaseUser.getTenantId(), new zzt(this));
        }
    }

    public final void zzk(String str, long j, TimeUnit timeUnit, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor, boolean z, String str2, String str3) {
        long convert = TimeUnit.SECONDS.convert(j, timeUnit);
        if (convert < 0 || convert > 120) {
            throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
        }
        this.zze.zzk(this.zza, new zzwt(str, convert, z, this.zzi, this.zzk, str2, zzta.zza(), str3), zzJ(str, onVerificationStateChangedCallbacks), activity, executor);
    }

    public final void zzl(PhoneAuthOptions phoneAuthOptions) {
        String uid;
        if (phoneAuthOptions.zzk()) {
            FirebaseAuth zza = phoneAuthOptions.zza();
            com.google.firebase.auth.internal.zzag zzagVar = (com.google.firebase.auth.internal.zzag) phoneAuthOptions.zzg();
            if (phoneAuthOptions.zzf() != null) {
                if (zzagVar.zze()) {
                    uid = phoneAuthOptions.zzb();
                } else {
                    uid = phoneAuthOptions.zzj().getUid();
                }
                if (zzux.zzb(uid, phoneAuthOptions.zzd(), phoneAuthOptions.zzi(), phoneAuthOptions.zze())) {
                    return;
                }
            }
            zza.zzn.zzb(zza, phoneAuthOptions.zzb(), phoneAuthOptions.zzi(), zzta.zza()).addOnCompleteListener(new zzp(zza, phoneAuthOptions));
            return;
        }
        FirebaseAuth zza2 = phoneAuthOptions.zza();
        String zzb = phoneAuthOptions.zzb();
        long longValue = phoneAuthOptions.zzc().longValue();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zzd = phoneAuthOptions.zzd();
        Activity zzi = phoneAuthOptions.zzi();
        Executor zze = phoneAuthOptions.zze();
        boolean z = phoneAuthOptions.zzf() != null;
        if (z || !zzux.zzb(zzb, zzd, zzi, zze)) {
            zza2.zzn.zzb(zza2, zzb, zzi, zzta.zza()).addOnCompleteListener(new zzo(zza2, zzb, longValue, timeUnit, zzd, zzi, zze, z));
        }
    }

    public final Task<Void> zzm(FirebaseUser firebaseUser, zzbk zzbkVar) {
        Preconditions.checkNotNull(firebaseUser);
        return this.zze.zzJ(this.zza, firebaseUser, zzbkVar);
    }

    public final Task<AuthResult> zzn(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        return this.zze.zzH(this.zza, firebaseUser, authCredential.zza(), new zzt(this));
    }

    public final Task<AuthResult> zzo(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        return this.zze.zzI(this.zza, firebaseUser, str, new zzt(this));
    }

    public final Task<Void> zzp(FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(userProfileChangeRequest);
        return this.zze.zzl(this.zza, firebaseUser, userProfileChangeRequest, new zzt(this));
    }

    public final Task<Void> zzq(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zze.zzm(this.zza, firebaseUser, str, new zzt(this));
    }

    public final Task<Void> zzr(FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(phoneAuthCredential);
        return this.zze.zzo(this.zza, firebaseUser, phoneAuthCredential.clone(), new zzt(this));
    }

    public final Task<Void> zzs(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zze.zzn(this.zza, firebaseUser, str, new zzt(this));
    }

    public final Task<Void> zzt(ActionCodeSettings actionCodeSettings, String str) {
        Preconditions.checkNotEmpty(str);
        if (this.zzi != null) {
            if (actionCodeSettings == null) {
                actionCodeSettings = ActionCodeSettings.zza();
            }
            actionCodeSettings.zzc(this.zzi);
        }
        return this.zze.zzC(this.zza, actionCodeSettings, str);
    }

    public final Task<Void> zzu(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zze.zzQ(this.zza, firebaseUser, str, new zzt(this)).continueWithTask(new zzr(this));
    }

    public final Task<AuthResult> zzv(MultiFactorAssertion multiFactorAssertion, com.google.firebase.auth.internal.zzag zzagVar, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotNull(zzagVar);
        return this.zze.zzP(this.zza, firebaseUser, (PhoneMultiFactorAssertion) multiFactorAssertion, zzagVar.zzd(), new zzs(this));
    }

    public final Task<AuthResult> zzw(Activity activity, FederatedAuthProvider federatedAuthProvider, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(firebaseUser);
        if (!zzta.zza()) {
            return Tasks.forException(zzte.zza(new Status(17063)));
        }
        TaskCompletionSource<AuthResult> taskCompletionSource = new TaskCompletionSource<>();
        if (!this.zzm.zzj(activity, taskCompletionSource, this, firebaseUser)) {
            return Tasks.forException(zzte.zza(new Status(17057)));
        }
        this.zzm.zzc(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zzb(activity);
        return taskCompletionSource.getTask();
    }

    public final Task<AuthResult> zzx(Activity activity, FederatedAuthProvider federatedAuthProvider, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(firebaseUser);
        if (!zzta.zza()) {
            return Tasks.forException(zzte.zza(new Status(17063)));
        }
        TaskCompletionSource<AuthResult> taskCompletionSource = new TaskCompletionSource<>();
        if (!this.zzm.zzj(activity, taskCompletionSource, this, firebaseUser)) {
            return Tasks.forException(zzte.zza(new Status(17057)));
        }
        this.zzm.zzc(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zzc(activity);
        return taskCompletionSource.getTask();
    }

    public final Task<Void> zzy(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        return this.zze.zzK(firebaseUser, new zzi(this, firebaseUser));
    }

    public final Task<Void> zzz(String str, String str2, ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zza();
        }
        String str3 = this.zzi;
        if (str3 != null) {
            actionCodeSettings.zzc(str3);
        }
        return this.zze.zzR(str, str2, actionCodeSettings);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void removeIdTokenListener(com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzc.remove(idTokenListener);
        zzd().zza(this.zzc.size());
    }

    public Task<Void> updateCurrentUser(FirebaseUser firebaseUser) {
        String str;
        if (firebaseUser == null) {
            throw new IllegalArgumentException("Cannot update current user with null user!");
        }
        if ((firebaseUser.getTenantId() == null || firebaseUser.getTenantId().equals(this.zzk)) && ((str = this.zzk) == null || str.equals(firebaseUser.getTenantId()))) {
            String apiKey = firebaseUser.zzd().getOptions().getApiKey();
            String apiKey2 = this.zza.getOptions().getApiKey();
            if (!firebaseUser.zze().zzb() || !apiKey2.equals(apiKey)) {
                return zzm(firebaseUser, new zzu(this));
            }
            zza(com.google.firebase.auth.internal.zzx.zzs(this.zza, firebaseUser), firebaseUser.zze(), true, false);
            return Tasks.forResult(null);
        }
        return Tasks.forException(zzte.zza(new Status(17072)));
    }

    public static FirebaseAuth getInstance(FirebaseApp firebaseApp) {
        return (FirebaseAuth) firebaseApp.get(FirebaseAuth.class);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void addIdTokenListener(com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzc.add(idTokenListener);
        zzd().zza(this.zzc.size());
    }

    public Task<Void> sendPasswordResetEmail(String str, ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zza();
        }
        String str2 = this.zzi;
        if (str2 != null) {
            actionCodeSettings.zzc(str2);
        }
        actionCodeSettings.zze(1);
        return this.zze.zzA(this.zza, str, actionCodeSettings, this.zzk);
    }
}
