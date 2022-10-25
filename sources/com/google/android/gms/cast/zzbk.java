package com.google.android.gms.cast;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzbk extends GoogleApi<Cast.CastOptions> implements zzq {
    public static final /* synthetic */ int zzf = 0;
    private static final Logger zzg = new Logger("CastClient");
    private static final Api.AbstractClientBuilder<com.google.android.gms.cast.internal.zzx, Cast.CastOptions> zzh;
    private static final Api<Cast.CastOptions> zzi;
    final zzbj zza;
    TaskCompletionSource<Cast.ApplicationConnectionResult> zzb;
    TaskCompletionSource<Status> zzc;
    final Map<Long, TaskCompletionSource<Void>> zzd;
    final Map<String, Cast.MessageReceivedCallback> zze;
    private Handler zzj;
    private boolean zzk;
    private boolean zzl;
    private final AtomicLong zzm;
    private final Object zzn;
    private final Object zzo;
    private ApplicationMetadata zzp;
    private String zzq;
    private double zzr;
    private boolean zzs;
    private int zzt;
    private int zzu;
    private zzam zzv;
    private final CastDevice zzw;
    private final Cast.Listener zzx;
    private final List<zzp> zzy;
    private int zzz;

    static {
        zzbb zzbbVar = new zzbb();
        zzh = zzbbVar;
        zzi = new Api<>("Cast.API_CXLESS", zzbbVar, com.google.android.gms.cast.internal.zzai.zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbk(Context context, Cast.CastOptions castOptions) {
        super(context, zzi, castOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zza = new zzbj(this);
        this.zzn = new Object();
        this.zzo = new Object();
        this.zzy = Collections.synchronizedList(new ArrayList());
        Preconditions.checkNotNull(context, "context cannot be null");
        Preconditions.checkNotNull(castOptions, "CastOptions cannot be null");
        this.zzx = castOptions.zzb;
        this.zzw = castOptions.zza;
        this.zzd = new HashMap();
        this.zze = new HashMap();
        this.zzm = new AtomicLong(0L);
        this.zzz = 1;
        zzs();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Handler zzB(zzbk zzbkVar) {
        if (zzbkVar.zzj == null) {
            zzbkVar.zzj = new com.google.android.gms.internal.cast.zzci(zzbkVar.getLooper());
        }
        return zzbkVar.zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzE(zzbk zzbkVar, Cast.ApplicationConnectionResult applicationConnectionResult) {
        synchronized (zzbkVar.zzn) {
            TaskCompletionSource<Cast.ApplicationConnectionResult> taskCompletionSource = zzbkVar.zzb;
            if (taskCompletionSource != null) {
                taskCompletionSource.setResult(applicationConnectionResult);
            }
            zzbkVar.zzb = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzG(zzbk zzbkVar, int i) {
        synchronized (zzbkVar.zzo) {
            TaskCompletionSource<Status> taskCompletionSource = zzbkVar.zzc;
            if (taskCompletionSource == null) {
                return;
            }
            if (i == 0) {
                taskCompletionSource.setResult(new Status(0));
            } else {
                taskCompletionSource.setException(zzaa(i));
            }
            zzbkVar.zzc = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzJ(zzbk zzbkVar, long j, int i) {
        TaskCompletionSource<Void> taskCompletionSource;
        synchronized (zzbkVar.zzd) {
            Map<Long, TaskCompletionSource<Void>> map = zzbkVar.zzd;
            Long valueOf = Long.valueOf(j);
            taskCompletionSource = map.get(valueOf);
            zzbkVar.zzd.remove(valueOf);
        }
        if (taskCompletionSource != null) {
            if (i == 0) {
                taskCompletionSource.setResult(null);
            } else {
                taskCompletionSource.setException(zzaa(i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzL(zzbk zzbkVar, com.google.android.gms.cast.internal.zza zzaVar) {
        boolean z;
        String zza = zzaVar.zza();
        if (CastUtils.zza(zza, zzbkVar.zzq)) {
            z = false;
        } else {
            zzbkVar.zzq = zza;
            z = true;
        }
        zzg.m369d("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(zzbkVar.zzl));
        Cast.Listener listener = zzbkVar.zzx;
        if (listener != null && (z || zzbkVar.zzl)) {
            listener.onApplicationStatusChanged();
        }
        zzbkVar.zzl = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzM(zzbk zzbkVar, com.google.android.gms.cast.internal.zzy zzyVar) {
        boolean z;
        boolean z2;
        boolean z3;
        ApplicationMetadata zze = zzyVar.zze();
        if (!CastUtils.zza(zze, zzbkVar.zzp)) {
            zzbkVar.zzp = zze;
            zzbkVar.zzx.onApplicationMetadataChanged(zze);
        }
        double zza = zzyVar.zza();
        if (Double.isNaN(zza) || Math.abs(zza - zzbkVar.zzr) <= 1.0E-7d) {
            z = false;
        } else {
            zzbkVar.zzr = zza;
            z = true;
        }
        boolean zzb = zzyVar.zzb();
        if (zzb != zzbkVar.zzs) {
            zzbkVar.zzs = zzb;
            z = true;
        }
        Logger logger = zzg;
        logger.m369d("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(zzbkVar.zzk));
        Cast.Listener listener = zzbkVar.zzx;
        if (listener != null && (z || zzbkVar.zzk)) {
            listener.onVolumeChanged();
        }
        Double.isNaN(zzyVar.zzg());
        int zzc = zzyVar.zzc();
        if (zzc != zzbkVar.zzt) {
            zzbkVar.zzt = zzc;
            z2 = true;
        } else {
            z2 = false;
        }
        logger.m369d("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z2), Boolean.valueOf(zzbkVar.zzk));
        Cast.Listener listener2 = zzbkVar.zzx;
        if (listener2 != null && (z2 || zzbkVar.zzk)) {
            listener2.onActiveInputStateChanged(zzbkVar.zzt);
        }
        int zzd = zzyVar.zzd();
        if (zzd != zzbkVar.zzu) {
            zzbkVar.zzu = zzd;
            z3 = true;
        } else {
            z3 = false;
        }
        logger.m369d("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z3), Boolean.valueOf(zzbkVar.zzk));
        Cast.Listener listener3 = zzbkVar.zzx;
        if (listener3 != null && (z3 || zzbkVar.zzk)) {
            listener3.onStandbyStateChanged(zzbkVar.zzu);
        }
        if (!CastUtils.zza(zzbkVar.zzv, zzyVar.zzf())) {
            zzbkVar.zzv = zzyVar.zzf();
        }
        zzbkVar.zzk = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzR(zzbk zzbkVar) {
        zzbkVar.zzt = -1;
        zzbkVar.zzu = -1;
        zzbkVar.zzp = null;
        zzbkVar.zzq = null;
        zzbkVar.zzr = 0.0d;
        zzbkVar.zzs();
        zzbkVar.zzs = false;
        zzbkVar.zzv = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Task<Boolean> zzU(com.google.android.gms.cast.internal.zzag zzagVar) {
        return doUnregisterEventListener((ListenerHolder.ListenerKey) Preconditions.checkNotNull(registerListener(zzagVar, "castDeviceControllerListenerKey").getListenerKey(), "Key must not be null"), 8415);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzV() {
        zzg.m369d("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.zze) {
            this.zze.clear();
        }
    }

    private final void zzW() {
        Preconditions.checkState(this.zzz != 1, "Not active connection");
    }

    private final void zzX() {
        Preconditions.checkState(this.zzz == 2, "Not connected to device");
    }

    private final void zzY(TaskCompletionSource<Cast.ApplicationConnectionResult> taskCompletionSource) {
        synchronized (this.zzn) {
            if (this.zzb != null) {
                zzZ(2477);
            }
            this.zzb = taskCompletionSource;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzZ(int i) {
        synchronized (this.zzn) {
            TaskCompletionSource<Cast.ApplicationConnectionResult> taskCompletionSource = this.zzb;
            if (taskCompletionSource != null) {
                taskCompletionSource.setException(zzaa(i));
            }
            this.zzb = null;
        }
    }

    private static ApiException zzaa(int i) {
        return ApiExceptionUtil.fromStatus(new Status(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzA(String str, String str2, String str3, com.google.android.gms.cast.internal.zzx zzxVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        long incrementAndGet = this.zzm.incrementAndGet();
        zzX();
        try {
            this.zzd.put(Long.valueOf(incrementAndGet), taskCompletionSource);
            ((com.google.android.gms.cast.internal.zzae) zzxVar.getService()).zzk(str2, str3, incrementAndGet);
        } catch (RemoteException e) {
            this.zzd.remove(Long.valueOf(incrementAndGet));
            taskCompletionSource.setException(e);
        }
    }

    @Override // com.google.android.gms.cast.zzq
    public final void zza(zzp zzpVar) {
        Preconditions.checkNotNull(zzpVar);
        this.zzy.add(zzpVar);
    }

    @Override // com.google.android.gms.cast.zzq
    public final Task<Void> zzb() {
        Object registerListener = registerListener(this.zza, "castDeviceControllerListenerKey");
        RegistrationMethods.Builder builder = RegistrationMethods.builder();
        return doRegisterEventListener(builder.withHolder(registerListener).register(new RemoteCall(this) { // from class: com.google.android.gms.cast.zzap
            private final zzbk zza;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                com.google.android.gms.cast.internal.zzx zzxVar = (com.google.android.gms.cast.internal.zzx) obj;
                ((com.google.android.gms.cast.internal.zzae) zzxVar.getService()).zzq(this.zza.zza);
                ((com.google.android.gms.cast.internal.zzae) zzxVar.getService()).zzp();
                ((TaskCompletionSource) obj2).setResult(null);
            }
        }).unregister(zzau.zza).setFeatures(zzao.zzb).setMethodKey(8428).build());
    }

    @Override // com.google.android.gms.cast.zzq
    public final Task<Void> zzc() {
        Task doWrite = doWrite(TaskApiCall.builder().run(zzav.zza).setMethodKey(8403).build());
        zzV();
        zzU(this.zza);
        return doWrite;
    }

    @Override // com.google.android.gms.cast.zzq
    public final Task<Void> zzd() {
        return doWrite(TaskApiCall.builder().run(zzaw.zza).setMethodKey(8404).build());
    }

    @Override // com.google.android.gms.cast.zzq
    public final Task<Void> zze(final String str, final String str2) {
        CastUtils.throwIfInvalidNamespace(str);
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        }
        if (str2.length() > 524288) {
            zzg.m362w("Message send failed. Message exceeds maximum size", new Object[0]);
            throw new IllegalArgumentException("Message exceeds maximum size524288");
        }
        return doWrite(TaskApiCall.builder().run(new RemoteCall(this, null, str, str2) { // from class: com.google.android.gms.cast.zzax
            private final zzbk zza;
            private final String zzb;
            private final String zzc;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = str;
                this.zzc = str2;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                this.zza.zzA(null, this.zzb, this.zzc, (com.google.android.gms.cast.internal.zzx) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(8405).build());
    }

    @Override // com.google.android.gms.cast.zzq
    public final Task<Cast.ApplicationConnectionResult> zzf(final String str, final LaunchOptions launchOptions) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall(this, str, launchOptions) { // from class: com.google.android.gms.cast.zzay
            private final zzbk zza;
            private final String zzb;
            private final LaunchOptions zzc;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = str;
                this.zzc = launchOptions;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                this.zza.zzz(this.zzb, this.zzc, (com.google.android.gms.cast.internal.zzx) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(8406).build());
    }

    @Override // com.google.android.gms.cast.zzq
    public final Task<Status> zzg(final String str) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall(this, str) { // from class: com.google.android.gms.cast.zzba
            private final zzbk zza;
            private final String zzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = str;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                this.zza.zzx(this.zzb, (com.google.android.gms.cast.internal.zzx) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(8409).build());
    }

    @Override // com.google.android.gms.cast.zzq
    public final Task<Void> zzh(final double d) {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Volume cannot be ");
            sb.append(d);
            throw new IllegalArgumentException(sb.toString());
        }
        return doWrite(TaskApiCall.builder().run(new RemoteCall(this, d) { // from class: com.google.android.gms.cast.zzaq
            private final zzbk zza;
            private final double zzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = d;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                this.zza.zzw(this.zzb, (com.google.android.gms.cast.internal.zzx) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(8411).build());
    }

    @Override // com.google.android.gms.cast.zzq
    public final double zzi() {
        zzX();
        return this.zzr;
    }

    @Override // com.google.android.gms.cast.zzq
    public final Task<Void> zzj(final boolean z) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall(this, z) { // from class: com.google.android.gms.cast.zzar
            private final zzbk zza;
            private final boolean zzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = z;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                this.zza.zzv(this.zzb, (com.google.android.gms.cast.internal.zzx) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(8412).build());
    }

    @Override // com.google.android.gms.cast.zzq
    public final boolean zzk() {
        zzX();
        return this.zzs;
    }

    @Override // com.google.android.gms.cast.zzq
    public final int zzl() {
        zzX();
        return this.zzt;
    }

    @Override // com.google.android.gms.cast.zzq
    public final int zzm() {
        zzX();
        return this.zzu;
    }

    @Override // com.google.android.gms.cast.zzq
    public final ApplicationMetadata zzn() {
        zzX();
        return this.zzp;
    }

    @Override // com.google.android.gms.cast.zzq
    public final String zzo() {
        zzX();
        return this.zzq;
    }

    @Override // com.google.android.gms.cast.zzq
    public final Task<Void> zzp(final String str, final Cast.MessageReceivedCallback messageReceivedCallback) {
        CastUtils.throwIfInvalidNamespace(str);
        if (messageReceivedCallback != null) {
            synchronized (this.zze) {
                this.zze.put(str, messageReceivedCallback);
            }
        }
        return doWrite(TaskApiCall.builder().run(new RemoteCall(this, str, messageReceivedCallback) { // from class: com.google.android.gms.cast.zzas
            private final zzbk zza;
            private final String zzb;
            private final Cast.MessageReceivedCallback zzc;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = str;
                this.zzc = messageReceivedCallback;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                this.zza.zzu(this.zzb, this.zzc, (com.google.android.gms.cast.internal.zzx) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(8413).build());
    }

    @Override // com.google.android.gms.cast.zzq
    public final Task<Void> zzq(final String str) {
        final Cast.MessageReceivedCallback remove;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.zze) {
                remove = this.zze.remove(str);
            }
            return doWrite(TaskApiCall.builder().run(new RemoteCall(this, remove, str) { // from class: com.google.android.gms.cast.zzat
                private final zzbk zza;
                private final Cast.MessageReceivedCallback zzb;
                private final String zzc;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zza = this;
                    this.zzb = remove;
                    this.zzc = str;
                }

                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) {
                    this.zza.zzt(this.zzb, this.zzc, (com.google.android.gms.cast.internal.zzx) obj, (TaskCompletionSource) obj2);
                }
            }).setMethodKey(8414).build());
        }
        throw new IllegalArgumentException("Channel namespace cannot be null or empty");
    }

    public final Task<Cast.ApplicationConnectionResult> zzr(final String str, final String str2, zzbl zzblVar) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall(this, str, str2, null) { // from class: com.google.android.gms.cast.zzaz
            private final zzbk zza;
            private final String zzb;
            private final String zzc;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = str;
                this.zzc = str2;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                this.zza.zzy(this.zzb, this.zzc, null, (com.google.android.gms.cast.internal.zzx) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(8407).build());
    }

    @RequiresNonNull({"device"})
    final double zzs() {
        if (this.zzw.hasCapability(2048)) {
            return 0.02d;
        }
        return (!this.zzw.hasCapability(4) || this.zzw.hasCapability(1) || "Chromecast Audio".equals(this.zzw.getModelName())) ? 0.05d : 0.02d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzt(Cast.MessageReceivedCallback messageReceivedCallback, String str, com.google.android.gms.cast.internal.zzx zzxVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzW();
        if (messageReceivedCallback != null) {
            ((com.google.android.gms.cast.internal.zzae) zzxVar.getService()).zzm(str);
        }
        taskCompletionSource.setResult(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzu(String str, Cast.MessageReceivedCallback messageReceivedCallback, com.google.android.gms.cast.internal.zzx zzxVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzW();
        ((com.google.android.gms.cast.internal.zzae) zzxVar.getService()).zzm(str);
        if (messageReceivedCallback != null) {
            ((com.google.android.gms.cast.internal.zzae) zzxVar.getService()).zzl(str);
        }
        taskCompletionSource.setResult(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzv(boolean z, com.google.android.gms.cast.internal.zzx zzxVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((com.google.android.gms.cast.internal.zzae) zzxVar.getService()).zzj(z, this.zzr, this.zzs);
        taskCompletionSource.setResult(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzw(double d, com.google.android.gms.cast.internal.zzx zzxVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((com.google.android.gms.cast.internal.zzae) zzxVar.getService()).zzi(d, this.zzr, this.zzs);
        taskCompletionSource.setResult(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzx(String str, com.google.android.gms.cast.internal.zzx zzxVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzX();
        ((com.google.android.gms.cast.internal.zzae) zzxVar.getService()).zzg(str);
        synchronized (this.zzo) {
            if (this.zzc != null) {
                taskCompletionSource.setException(zzaa(2001));
            } else {
                this.zzc = taskCompletionSource;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzy(String str, String str2, zzbl zzblVar, com.google.android.gms.cast.internal.zzx zzxVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzX();
        ((com.google.android.gms.cast.internal.zzae) zzxVar.getService()).zzo(str, str2, null);
        zzY(taskCompletionSource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzz(String str, LaunchOptions launchOptions, com.google.android.gms.cast.internal.zzx zzxVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzX();
        ((com.google.android.gms.cast.internal.zzae) zzxVar.getService()).zzn(str, launchOptions);
        zzY(taskCompletionSource);
    }
}
