package com.google.android.gms.internal.cast;

import com.google.android.gms.internal.cast.zzop;
import com.google.android.gms.internal.cast.zzos;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public abstract class zzos<MessageType extends zzos<MessageType, BuilderType>, BuilderType extends zzop<MessageType, BuilderType>> extends zznm<MessageType, BuilderType> {
    private static final Map<Object, zzos<?, ?>> zzb = new ConcurrentHashMap();
    protected zzqy zzc = zzqy.zza();
    protected int zzd = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzos> T zzt(Class<T> cls) {
        Map<Object, zzos<?, ?>> map = zzb;
        zzos<?, ?> zzosVar = map.get(cls);
        if (zzosVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzosVar = map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzosVar == null) {
            zzosVar = (zzos) ((zzos) zzrh.zzc(cls)).zzb(6, null, null);
            if (zzosVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzosVar);
        }
        return zzosVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzos> void zzu(Class<T> cls, T t) {
        zzb.put(cls, t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zzv(zzpy zzpyVar, String str, Object[] objArr) {
        return new zzqi(zzpyVar, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzw(Method method, Object obj, Object... objArr) {
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
    public static zzox zzx() {
        return zzot.zzd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzoz zzy() {
        return zzpn.zzd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzpa<E> zzz() {
        return zzqh.zzd();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzqg.zza().zzb(getClass()).zza(this, (zzos) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zzb2 = zzqg.zza().zzb(getClass()).zzb(this);
        this.zza = zzb2;
        return zzb2;
    }

    public final String toString() {
        return zzqa.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.cast.zzpy
    public final /* bridge */ /* synthetic */ zzpx zzA() {
        zzop zzopVar = (zzop) zzb(5, null, null);
        zzopVar.zzq(this);
        return zzopVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zzb(int i, Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.cast.zznm
    public final int zzn() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.cast.zznm
    public final void zzo(int i) {
        this.zzd = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends zzos<MessageType, BuilderType>, BuilderType extends zzop<MessageType, BuilderType>> BuilderType zzp() {
        return (BuilderType) zzb(5, null, null);
    }

    @Override // com.google.android.gms.internal.cast.zzpy
    public final void zzq(zzof zzofVar) throws IOException {
        zzqg.zza().zzb(getClass()).zzi(this, zzog.zza(zzofVar));
    }

    @Override // com.google.android.gms.internal.cast.zzpy
    public final int zzr() {
        int i = this.zzd;
        if (i == -1) {
            int zzd = zzqg.zza().zzb(getClass()).zzd(this);
            this.zzd = zzd;
            return zzd;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.cast.zzpz
    public final /* bridge */ /* synthetic */ zzpy zzs() {
        return (zzos) zzb(6, null, null);
    }
}
