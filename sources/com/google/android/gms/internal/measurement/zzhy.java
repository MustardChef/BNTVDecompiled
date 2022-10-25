package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzhy.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
public abstract class zzhy<MessageType extends zzhy<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzgg<MessageType, BuilderType> {
    private static Map<Object, zzhy<?, ?>> zzd = new ConcurrentHashMap();
    protected zzks zzb = zzks.zza();
    private int zzc = -1;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    /* loaded from: classes3.dex */
    protected static class zza<T extends zzhy<T, ?>> extends zzgk<T> {
        private final T zza;

        public zza(T t) {
            this.zza = t;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    /* loaded from: classes3.dex */
    static final class zzc implements zzht<zzc> {
        @Override // com.google.android.gms.internal.measurement.zzht
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final zzlg zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final zzln zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final zzji zza(zzji zzjiVar, zzjj zzjjVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final zzjo zza(zzjo zzjoVar, zzjo zzjoVar2) {
            throw new NoSuchMethodError();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    /* loaded from: classes3.dex */
    public enum zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzh = {1, 2, 3, 4, 5, 6, 7};

        public static int[] zza() {
            return (int[]) zzh.clone();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    /* loaded from: classes3.dex */
    public static class zzf<ContainingType extends zzjj, Type> extends zzhm<ContainingType, Type> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    /* loaded from: classes3.dex */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzhy<MessageType, BuilderType> implements zzjl {
        protected zzhr<zzc> zzc = zzhr.zza();

        /* JADX INFO: Access modifiers changed from: package-private */
        public final zzhr<zzc> zza() {
            if (this.zzc.zzc()) {
                this.zzc = (zzhr) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    public String toString() {
        return zzjk.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zza != 0) {
            return this.zza;
        }
        this.zza = zzjx.zza().zza((zzjx) this).zza(this);
        return this.zza;
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    /* loaded from: classes3.dex */
    public static abstract class zzb<MessageType extends zzhy<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzgi<MessageType, BuilderType> {
        protected MessageType zza;
        protected boolean zzb = false;
        private final MessageType zzc;

        /* JADX INFO: Access modifiers changed from: protected */
        public zzb(MessageType messagetype) {
            this.zzc = messagetype;
            this.zza = (MessageType) messagetype.zza(zze.zzd, null, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void zzu() {
            MessageType messagetype = (MessageType) this.zza.zza(zze.zzd, null, null);
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        @Override // com.google.android.gms.internal.measurement.zzjl
        public final boolean zzbn() {
            return zzhy.zza(this.zza, false);
        }

        @Override // com.google.android.gms.internal.measurement.zzji
        /* renamed from: zzv */
        public MessageType zzx() {
            if (this.zzb) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzjx.zza().zza((zzjx) messagetype).zzc(messagetype);
            this.zzb = true;
            return this.zza;
        }

        @Override // com.google.android.gms.internal.measurement.zzji
        /* renamed from: zzw */
        public final MessageType zzy() {
            MessageType messagetype = (MessageType) zzx();
            if (messagetype.zzbn()) {
                return messagetype;
            }
            throw new zzkq(messagetype);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb) {
                zzu();
                this.zzb = false;
            }
            zza(this.zza, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzjx.zza().zza((zzjx) messagetype).zzb(messagetype, messagetype2);
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzhl zzhlVar) throws zzij {
            if (this.zzb) {
                zzu();
                this.zzb = false;
            }
            try {
                zzjx.zza().zza((zzjx) this.zza).zza(this.zza, bArr, 0, i2, new zzgo(zzhlVar));
                return this;
            } catch (zzij e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            } catch (IndexOutOfBoundsException unused) {
                throw zzij.zza();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.google.android.gms.internal.measurement.zzgi
        /* renamed from: zzb */
        public final BuilderType zza(zzhb zzhbVar, zzhl zzhlVar) throws IOException {
            if (this.zzb) {
                zzu();
                this.zzb = false;
            }
            try {
                zzjx.zza().zza((zzjx) this.zza).zza(this.zza, zzhg.zza(zzhbVar), zzhlVar);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.measurement.zzgi
        protected final /* synthetic */ zzgi zza(zzgg zzggVar) {
            return zza((zzb<MessageType, BuilderType>) ((zzhy) zzggVar));
        }

        @Override // com.google.android.gms.internal.measurement.zzgi
        public final /* synthetic */ zzgi zza(byte[] bArr, int i, int i2, zzhl zzhlVar) throws zzij {
            return zzb(bArr, 0, i2, zzhlVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzgi
        public final /* synthetic */ zzgi zza(byte[] bArr, int i, int i2) throws zzij {
            return zzb(bArr, 0, i2, zzhl.zza());
        }

        @Override // com.google.android.gms.internal.measurement.zzgi
        public final /* synthetic */ zzgi zzt() {
            return (zzb) clone();
        }

        @Override // com.google.android.gms.internal.measurement.zzjl
        public final /* synthetic */ zzjj zzbv() {
            return this.zzc;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.measurement.zzgi
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzbVar = (zzb) this.zzc.zza(zze.zze, null, null);
            zzbVar.zza((zzb) ((zzhy) zzx()));
            return zzbVar;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzjx.zza().zza((zzjx) this).zza(this, (zzhy) obj);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends zzhy<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzbm() {
        return (BuilderType) zza(zze.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final boolean zzbn() {
        Boolean bool = Boolean.TRUE;
        return zza(this, true);
    }

    public final BuilderType zzbo() {
        BuilderType buildertype = (BuilderType) zza(zze.zze, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.measurement.zzgg
    final int zzbl() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzgg
    final void zzc(int i) {
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzjj
    public final void zza(zzhi zzhiVar) throws IOException {
        zzjx.zza().zza((zzjx) this).zza((zzkb) this, (zzlm) zzhk.zza(zzhiVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzjj
    public final int zzbp() {
        if (this.zzc == -1) {
            this.zzc = zzjx.zza().zza((zzjx) this).zzb(this);
        }
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzhy<?, ?>> T zza(Class<T> cls) {
        zzhy<?, ?> zzhyVar = zzd.get(cls);
        if (zzhyVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzhyVar = zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzhyVar == null) {
            zzhyVar = (T) ((zzhy) zzkz.zza(cls)).zza(zze.zzf, (Object) null, (Object) null);
            if (zzhyVar == null) {
                throw new IllegalStateException();
            }
            zzd.put(cls, zzhyVar);
        }
        return (T) zzhyVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzhy<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zza(zzjj zzjjVar, String str, Object[] objArr) {
        return new zzjz(zzjjVar, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zza(Method method, Object obj, Object... objArr) {
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

    protected static final <T extends zzhy<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zza, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzd2 = zzjx.zza().zza((zzjx) t).zzd(t);
        if (z) {
            t.zza(zze.zzb, zzd2 ? t : null, null);
        }
        return zzd2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzie zzbq() {
        return zzib.zzd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzih zzbr() {
        return zzix.zzd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzih zza(zzih zzihVar) {
        int size = zzihVar.size();
        return zzihVar.zzc(size == 0 ? 10 : size << 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzig<E> zzbs() {
        return zzjw.zzd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzig<E> zza(zzig<E> zzigVar) {
        int size = zzigVar.size();
        return zzigVar.zza(size == 0 ? 10 : size << 1);
    }

    @Override // com.google.android.gms.internal.measurement.zzjj
    public final /* synthetic */ zzji zzbt() {
        zzb zzbVar = (zzb) zza(zze.zze, (Object) null, (Object) null);
        zzbVar.zza((zzb) this);
        return zzbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzjj
    public final /* synthetic */ zzji zzbu() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final /* synthetic */ zzjj zzbv() {
        return (zzhy) zza(zze.zzf, (Object) null, (Object) null);
    }
}
