package com.google.android.gms.internal.p038firebaseauthapi;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApi;
import com.google.firebase.FirebaseExceptionMapper;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsz */
/* loaded from: classes3.dex */
public final class zzsz implements Callable<zzpk<zztv>> {
    private final zztv zza;
    private final Context zzb;

    public zzsz(zztv zztvVar, Context context) {
        this.zza = zztvVar;
        this.zzb = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ zzpk<zztv> call() throws Exception {
        int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.zzb, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        boolean unused = zzta.zza = isGooglePlayServicesAvailable == 0 || isGooglePlayServicesAvailable == 2;
        Context context = this.zzb;
        zztv zza = this.zza.zza();
        zza.zza = true;
        return new zzpk<>(new zzpm(context, zztw.zzb, zza, new GoogleApi.Settings.Builder().setMapper(new FirebaseExceptionMapper()).build()));
    }
}
