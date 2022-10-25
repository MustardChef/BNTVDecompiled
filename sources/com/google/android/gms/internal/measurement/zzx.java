package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzx extends zza implements zzv {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void initialize(IObjectWrapper iObjectWrapper, zzae zzaeVar, long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, iObjectWrapper);
        zzb.zza(m338a_, zzaeVar);
        m338a_.writeLong(j);
        zzb(1, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        m338a_.writeString(str);
        m338a_.writeString(str2);
        zzb.zza(m338a_, bundle);
        zzb.zza(m338a_, z);
        zzb.zza(m338a_, z2);
        m338a_.writeLong(j);
        zzb(2, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void logEventAndBundle(String str, String str2, Bundle bundle, zzw zzwVar, long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        m338a_.writeString(str);
        m338a_.writeString(str2);
        zzb.zza(m338a_, bundle);
        zzb.zza(m338a_, zzwVar);
        m338a_.writeLong(j);
        zzb(3, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        m338a_.writeString(str);
        m338a_.writeString(str2);
        zzb.zza(m338a_, iObjectWrapper);
        zzb.zza(m338a_, z);
        m338a_.writeLong(j);
        zzb(4, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void getUserProperties(String str, String str2, boolean z, zzw zzwVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        m338a_.writeString(str);
        m338a_.writeString(str2);
        zzb.zza(m338a_, z);
        zzb.zza(m338a_, zzwVar);
        zzb(5, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void getMaxUserProperties(String str, zzw zzwVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        m338a_.writeString(str);
        zzb.zza(m338a_, zzwVar);
        zzb(6, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void setUserId(String str, long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        m338a_.writeString(str);
        m338a_.writeLong(j);
        zzb(7, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, bundle);
        m338a_.writeLong(j);
        zzb(8, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel m338a_ = m338a_();
        m338a_.writeString(str);
        m338a_.writeString(str2);
        zzb.zza(m338a_, bundle);
        zzb(9, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void getConditionalUserProperties(String str, String str2, zzw zzwVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        m338a_.writeString(str);
        m338a_.writeString(str2);
        zzb.zza(m338a_, zzwVar);
        zzb(10, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, z);
        m338a_.writeLong(j);
        zzb(11, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void resetAnalyticsData(long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        m338a_.writeLong(j);
        zzb(12, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void setMinimumSessionDuration(long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        m338a_.writeLong(j);
        zzb(13, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void setSessionTimeoutDuration(long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        m338a_.writeLong(j);
        zzb(14, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, iObjectWrapper);
        m338a_.writeString(str);
        m338a_.writeString(str2);
        m338a_.writeLong(j);
        zzb(15, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void getCurrentScreenName(zzw zzwVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, zzwVar);
        zzb(16, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void getCurrentScreenClass(zzw zzwVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, zzwVar);
        zzb(17, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void setInstanceIdProvider(zzac zzacVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, zzacVar);
        zzb(18, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void getCachedAppInstanceId(zzw zzwVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, zzwVar);
        zzb(19, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void getAppInstanceId(zzw zzwVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, zzwVar);
        zzb(20, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void getGmpAppId(zzw zzwVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, zzwVar);
        zzb(21, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void generateEventId(zzw zzwVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, zzwVar);
        zzb(22, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void beginAdUnitExposure(String str, long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        m338a_.writeString(str);
        m338a_.writeLong(j);
        zzb(23, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void endAdUnitExposure(String str, long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        m338a_.writeString(str);
        m338a_.writeLong(j);
        zzb(24, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, iObjectWrapper);
        m338a_.writeLong(j);
        zzb(25, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, iObjectWrapper);
        m338a_.writeLong(j);
        zzb(26, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, iObjectWrapper);
        zzb.zza(m338a_, bundle);
        m338a_.writeLong(j);
        zzb(27, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, iObjectWrapper);
        m338a_.writeLong(j);
        zzb(28, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, iObjectWrapper);
        m338a_.writeLong(j);
        zzb(29, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, iObjectWrapper);
        m338a_.writeLong(j);
        zzb(30, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzw zzwVar, long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, iObjectWrapper);
        zzb.zza(m338a_, zzwVar);
        m338a_.writeLong(j);
        zzb(31, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void performAction(Bundle bundle, zzw zzwVar, long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, bundle);
        zzb.zza(m338a_, zzwVar);
        m338a_.writeLong(j);
        zzb(32, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel m338a_ = m338a_();
        m338a_.writeInt(i);
        m338a_.writeString(str);
        zzb.zza(m338a_, iObjectWrapper);
        zzb.zza(m338a_, iObjectWrapper2);
        zzb.zza(m338a_, iObjectWrapper3);
        zzb(33, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void setEventInterceptor(zzab zzabVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, zzabVar);
        zzb(34, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void registerOnMeasurementEventListener(zzab zzabVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, zzabVar);
        zzb(35, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void unregisterOnMeasurementEventListener(zzab zzabVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, zzabVar);
        zzb(36, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void initForTests(Map map) throws RemoteException {
        Parcel m338a_ = m338a_();
        m338a_.writeMap(map);
        zzb(37, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void getTestFlag(zzw zzwVar, int i) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, zzwVar);
        m338a_.writeInt(i);
        zzb(38, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, z);
        zzb(39, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void isDataCollectionEnabled(zzw zzwVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, zzwVar);
        zzb(40, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void setDefaultEventParameters(Bundle bundle) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, bundle);
        zzb(42, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void clearMeasurementEnabled(long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        m338a_.writeLong(j);
        zzb(43, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void setConsent(Bundle bundle, long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, bundle);
        m338a_.writeLong(j);
        zzb(44, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        zzb.zza(m338a_, bundle);
        m338a_.writeLong(j);
        zzb(45, m338a_);
    }
}
