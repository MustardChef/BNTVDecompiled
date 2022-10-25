package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.android.gms.internal.p038firebaseauthapi.zzzk;
import com.google.android.gms.internal.p038firebaseauthapi.zzzo;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzo */
/* loaded from: classes3.dex */
public abstract class zzzo<MessageType extends zzzo<MessageType, BuilderType>, BuilderType extends zzzk<MessageType, BuilderType>> extends zzxu<MessageType, BuilderType> {
    private static final Map<Object, zzzo<?, ?>> zzb = new ConcurrentHashMap();
    protected zzabs zzc = zzabs.zza();
    protected int zzd = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzA(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzzt<E> zzB() {
        return zzaba.zzd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzzt<E> zzC(zzzt<E> zzztVar) {
        int size = zzztVar.size();
        return zzztVar.zze(size == 0 ? 10 : size + size);
    }

    static <T extends zzzo<T, ?>> T zzD(T t, byte[] bArr, int i, int i2, zzzb zzzbVar) throws zzzw {
        T t2 = (T) t.zzj(4, null, null);
        try {
            zzabd zzb2 = zzaaz.zza().zzb(t2.getClass());
            zzb2.zzi(t2, bArr, 0, i2, new zzxx(zzzbVar));
            zzb2.zzj(t2);
            if (t2.zza == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (!(e.getCause() instanceof zzzw)) {
                zzzw zzzwVar = new zzzw(e.getMessage());
                zzzwVar.zza(t2);
                throw zzzwVar;
            }
            throw ((zzzw) e.getCause());
        } catch (IndexOutOfBoundsException unused) {
            zzzw zzb3 = zzzw.zzb();
            zzb3.zza(t2);
            throw zzb3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzzo<T, ?>> T zzE(T t, zzym zzymVar, zzzb zzzbVar) throws zzzw {
        try {
            zzyp zzk = zzymVar.zzk();
            T t2 = (T) t.zzj(4, null, null);
            try {
                zzabd zzb2 = zzaaz.zza().zzb(t2.getClass());
                zzb2.zzf(t2, zzyq.zza(zzk), zzzbVar);
                zzb2.zzj(t2);
                try {
                    zzk.zzb(0);
                    zza(t2);
                    return t2;
                } catch (zzzw e) {
                    e.zza(t2);
                    throw e;
                }
            } catch (IOException e2) {
                if (e2.getCause() instanceof zzzw) {
                    throw ((zzzw) e2.getCause());
                }
                zzzw zzzwVar = new zzzw(e2.getMessage());
                zzzwVar.zza(t2);
                throw zzzwVar;
            } catch (RuntimeException e3) {
                if (e3.getCause() instanceof zzzw) {
                    throw ((zzzw) e3.getCause());
                }
                throw e3;
            }
        } catch (zzzw e4) {
            throw e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzzo<T, ?>> T zzF(T t, byte[] bArr, zzzb zzzbVar) throws zzzw {
        T t2 = (T) zzD(t, bArr, 0, bArr.length, zzzbVar);
        zza(t2);
        return t2;
    }

    private static <T extends zzzo<T, ?>> T zza(T t) throws zzzw {
        if (t == null || t.zzt()) {
            return t;
        }
        zzzw zzzwVar = new zzzw(new zzabq(t).getMessage());
        zzzwVar.zza(t);
        throw zzzwVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzzo> T zzx(Class<T> cls) {
        Map<Object, zzzo<?, ?>> map = zzb;
        zzzo<?, ?> zzzoVar = map.get(cls);
        if (zzzoVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzzoVar = map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzzoVar == null) {
            zzzoVar = (zzzo) ((zzzo) zzacc.zzc(cls)).zzj(6, null, null);
            if (zzzoVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzzoVar);
        }
        return zzzoVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzzo> void zzy(Class<T> cls, T t) {
        zzb.put(cls, t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zzz(zzaar zzaarVar, String str, Object[] objArr) {
        return new zzabb(zzaarVar, str, objArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzaaz.zza().zzb(getClass()).zzb(this, (zzzo) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zzc = zzaaz.zza().zzb(getClass()).zzc(this);
        this.zza = zzc;
        return zzc;
    }

    public final String toString() {
        return zzaat.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaar
    public final /* bridge */ /* synthetic */ zzaaq zzG() {
        zzzk zzzkVar = (zzzk) zzj(5, null, null);
        zzzkVar.zzm(this);
        return zzzkVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaar
    public final /* bridge */ /* synthetic */ zzaaq zzH() {
        return (zzzk) zzj(5, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zzj(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaas
    public final /* bridge */ /* synthetic */ zzaar zzo() {
        return (zzzo) zzj(6, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzxu
    public final int zzq() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzxu
    public final void zzr(int i) {
        this.zzd = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends zzzo<MessageType, BuilderType>, BuilderType extends zzzk<MessageType, BuilderType>> BuilderType zzs() {
        return (BuilderType) zzj(5, null, null);
    }

    public final BuilderType zzu() {
        BuilderType buildertype = (BuilderType) zzj(5, null, null);
        buildertype.zzm(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaar
    public final void zzv(zzyw zzywVar) throws IOException {
        zzaaz.zza().zzb(getClass()).zzn(this, zzyx.zza(zzywVar));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaar
    public final int zzw() {
        int i = this.zzd;
        if (i == -1) {
            int zze = zzaaz.zza().zzb(getClass()).zze(this);
            this.zzd = zze;
            return zze;
        }
        return i;
    }

    public final boolean zzt() {
        Boolean bool = Boolean.TRUE;
        byte byteValue = ((Byte) zzj(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzaaz.zza().zzb(getClass()).zzk(this);
        zzj(2, true != zzk ? null : this, null);
        return zzk;
    }
}
