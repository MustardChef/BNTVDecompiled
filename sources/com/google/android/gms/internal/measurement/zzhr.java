package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzht;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzhr<T extends zzht<T>> {
    private static final zzhr zzd = new zzhr(true);
    final zzkc<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zzhr() {
        this.zza = zzkc.zza(16);
    }

    private zzhr(boolean z) {
        this(zzkc.zza(0));
        zzb();
    }

    private zzhr(zzkc<T, Object> zzkcVar) {
        this.zza = zzkcVar;
        zzb();
    }

    public static <T extends zzht<T>> zzhr<T> zza() {
        return zzd;
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        this.zza.zza();
        this.zzb = true;
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzhr) {
            return this.zza.equals(((zzhr) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzc) {
            return new zzip(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> zze() {
        if (this.zzc) {
            return new zzip(this.zza.zze().iterator());
        }
        return this.zza.zze().iterator();
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (obj instanceof zzik) {
            zzik zzikVar = (zzik) obj;
            return zzik.zza();
        }
        return obj;
    }

    private final void zzb(T t, Object obj) {
        if (t.zzd()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(t.zzb(), obj2);
            }
            obj = arrayList;
        } else {
            zza(t.zzb(), obj);
        }
        if (obj instanceof zzik) {
            this.zzc = true;
        }
        this.zza.zza((zzkc<T, Object>) t, (T) obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzid) == false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzik) == false) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zza(com.google.android.gms.internal.measurement.zzlg r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.measurement.zzia.zza(r3)
            int[] r0 = com.google.android.gms.internal.measurement.zzhq.zza
            com.google.android.gms.internal.measurement.zzln r2 = r2.zza()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L31;
                case 7: goto L28;
                case 8: goto L1f;
                case 9: goto L16;
                default: goto L14;
            }
        L14:
            r0 = 0
            goto L42
        L16:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzjj
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzik
            if (r2 == 0) goto L14
            goto L42
        L1f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzid
            if (r2 == 0) goto L14
            goto L42
        L28:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzgp
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L14
            goto L42
        L31:
            boolean r0 = r3 instanceof java.lang.String
            goto L42
        L34:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L42
        L37:
            boolean r0 = r3 instanceof java.lang.Double
            goto L42
        L3a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L42
        L3d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L42
        L40:
            boolean r0 = r3 instanceof java.lang.Integer
        L42:
            if (r0 == 0) goto L45
            return
        L45:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhr.zza(com.google.android.gms.internal.measurement.zzlg, java.lang.Object):void");
    }

    public final boolean zzf() {
        for (int i = 0; i < this.zza.zzc(); i++) {
            if (!zza((Map.Entry) this.zza.zzb(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.zza.zzd()) {
            if (!zza((Map.Entry) entry)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzht<T>> boolean zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() == zzln.MESSAGE) {
            if (key.zzd()) {
                for (zzjj zzjjVar : (List) entry.getValue()) {
                    if (!zzjjVar.zzbn()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzjj) {
                    if (!((zzjj) value).zzbn()) {
                        return false;
                    }
                } else if (value instanceof zzik) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzhr<T> zzhrVar) {
        for (int i = 0; i < zzhrVar.zza.zzc(); i++) {
            zzb(zzhrVar.zza.zzb(i));
        }
        for (Map.Entry<T, Object> entry : zzhrVar.zza.zzd()) {
            zzb(entry);
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzjo) {
            return ((zzjo) obj).zza();
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        return obj;
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        zzjj zzy;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzik) {
            zzik zzikVar = (zzik) value;
            value = zzik.zza();
        }
        if (key.zzd()) {
            Object zza = zza((zzhr<T>) key);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) zza).add(zza(obj));
            }
            this.zza.zza((zzkc<T, Object>) key, (T) zza);
        } else if (key.zzc() == zzln.MESSAGE) {
            Object zza2 = zza((zzhr<T>) key);
            if (zza2 == null) {
                this.zza.zza((zzkc<T, Object>) key, (T) zza(value));
                return;
            }
            if (zza2 instanceof zzjo) {
                zzy = key.zza((zzjo) zza2, (zzjo) value);
            } else {
                zzy = key.zza(((zzjj) zza2).zzbt(), (zzjj) value).zzy();
            }
            this.zza.zza((zzkc<T, Object>) key, (T) zzy);
        } else {
            this.zza.zza((zzkc<T, Object>) key, (T) zza(value));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzhi zzhiVar, zzlg zzlgVar, int i, Object obj) throws IOException {
        if (zzlgVar == zzlg.zzj) {
            zzjj zzjjVar = (zzjj) obj;
            zzia.zza(zzjjVar);
            zzhiVar.zza(i, 3);
            zzjjVar.zza(zzhiVar);
            zzhiVar.zza(i, 4);
            return;
        }
        zzhiVar.zza(i, zzlgVar.zzb());
        switch (zzhq.zzb[zzlgVar.ordinal()]) {
            case 1:
                zzhiVar.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzhiVar.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzhiVar.zza(((Long) obj).longValue());
                return;
            case 4:
                zzhiVar.zza(((Long) obj).longValue());
                return;
            case 5:
                zzhiVar.zza(((Integer) obj).intValue());
                return;
            case 6:
                zzhiVar.zzc(((Long) obj).longValue());
                return;
            case 7:
                zzhiVar.zzd(((Integer) obj).intValue());
                return;
            case 8:
                zzhiVar.zza(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzjj) obj).zza(zzhiVar);
                return;
            case 10:
                zzhiVar.zza((zzjj) obj);
                return;
            case 11:
                if (obj instanceof zzgp) {
                    zzhiVar.zza((zzgp) obj);
                    return;
                } else {
                    zzhiVar.zza((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzgp) {
                    zzhiVar.zza((zzgp) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzhiVar.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzhiVar.zzb(((Integer) obj).intValue());
                return;
            case 14:
                zzhiVar.zzd(((Integer) obj).intValue());
                return;
            case 15:
                zzhiVar.zzc(((Long) obj).longValue());
                return;
            case 16:
                zzhiVar.zzc(((Integer) obj).intValue());
                return;
            case 17:
                zzhiVar.zzb(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzid) {
                    zzhiVar.zza(((zzid) obj).zza());
                    return;
                } else {
                    zzhiVar.zza(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzg() {
        int i = 0;
        for (int i2 = 0; i2 < this.zza.zzc(); i2++) {
            i += zzc(this.zza.zzb(i2));
        }
        for (Map.Entry<T, Object> entry : this.zza.zzd()) {
            i += zzc(entry);
        }
        return i;
    }

    private static int zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() == zzln.MESSAGE && !key.zzd() && !key.zze()) {
            if (value instanceof zzik) {
                return zzhi.zzb(entry.getKey().zza(), (zzik) value);
            }
            return zzhi.zzb(entry.getKey().zza(), (zzjj) value);
        }
        return zza((zzht<?>) key, value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzlg zzlgVar, int i, Object obj) {
        int zze = zzhi.zze(i);
        if (zzlgVar == zzlg.zzj) {
            zzia.zza((zzjj) obj);
            zze <<= 1;
        }
        return zze + zzb(zzlgVar, obj);
    }

    private static int zzb(zzlg zzlgVar, Object obj) {
        switch (zzhq.zzb[zzlgVar.ordinal()]) {
            case 1:
                return zzhi.zzb(((Double) obj).doubleValue());
            case 2:
                return zzhi.zzb(((Float) obj).floatValue());
            case 3:
                return zzhi.zzd(((Long) obj).longValue());
            case 4:
                return zzhi.zze(((Long) obj).longValue());
            case 5:
                return zzhi.zzf(((Integer) obj).intValue());
            case 6:
                return zzhi.zzg(((Long) obj).longValue());
            case 7:
                return zzhi.zzi(((Integer) obj).intValue());
            case 8:
                return zzhi.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzhi.zzc((zzjj) obj);
            case 10:
                if (obj instanceof zzik) {
                    return zzhi.zza((zzik) obj);
                }
                return zzhi.zzb((zzjj) obj);
            case 11:
                if (obj instanceof zzgp) {
                    return zzhi.zzb((zzgp) obj);
                }
                return zzhi.zzb((String) obj);
            case 12:
                if (obj instanceof zzgp) {
                    return zzhi.zzb((zzgp) obj);
                }
                return zzhi.zzb((byte[]) obj);
            case 13:
                return zzhi.zzg(((Integer) obj).intValue());
            case 14:
                return zzhi.zzj(((Integer) obj).intValue());
            case 15:
                return zzhi.zzh(((Long) obj).longValue());
            case 16:
                return zzhi.zzh(((Integer) obj).intValue());
            case 17:
                return zzhi.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzid) {
                    return zzhi.zzk(((zzid) obj).zza());
                }
                return zzhi.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzht<?> zzhtVar, Object obj) {
        zzlg zzb = zzhtVar.zzb();
        int zza = zzhtVar.zza();
        if (zzhtVar.zzd()) {
            int i = 0;
            if (zzhtVar.zze()) {
                for (Object obj2 : (List) obj) {
                    i += zzb(zzb, obj2);
                }
                return zzhi.zze(zza) + i + zzhi.zzl(i);
            }
            for (Object obj3 : (List) obj) {
                i += zza(zzb, zza, obj3);
            }
            return i;
        }
        return zza(zzb, zza, obj);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzhr zzhrVar = new zzhr();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<T, Object> zzb = this.zza.zzb(i);
            zzhrVar.zzb((zzhr) zzb.getKey(), zzb.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zza.zzd()) {
            zzhrVar.zzb((zzhr) entry.getKey(), entry.getValue());
        }
        zzhrVar.zzc = this.zzc;
        return zzhrVar;
    }
}
