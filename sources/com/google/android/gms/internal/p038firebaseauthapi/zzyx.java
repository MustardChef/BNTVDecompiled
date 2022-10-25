package com.google.android.gms.internal.p038firebaseauthapi;

import java.io.IOException;
import java.util.List;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.AgentOptions;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyx */
/* loaded from: classes3.dex */
final class zzyx {
    private final zzyw zza;

    private zzyx(zzyw zzywVar) {
        zzzu.zzb(zzywVar, AgentOptions.OUTPUT);
        this.zza = zzywVar;
        zzywVar.zze = this;
    }

    public static zzyx zza(zzyw zzywVar) {
        zzyx zzyxVar = zzywVar.zze;
        return zzyxVar != null ? zzyxVar : new zzyx(zzywVar);
    }

    public final void zzE(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzaab)) {
            while (i2 < list.size()) {
                this.zza.zzj(i, list.get(i2));
                i2++;
            }
            return;
        }
        zzaab zzaabVar = (zzaab) list;
        while (i2 < list.size()) {
            Object zzg = zzaabVar.zzg(i2);
            if (zzg instanceof String) {
                this.zza.zzj(i, (String) zzg);
            } else {
                this.zza.zzk(i, (zzym) zzg);
            }
            i2++;
        }
    }

    public final void zzF(int i, List<zzym> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzk(i, list.get(i2));
        }
    }

    public final void zzb(int i, int i2) throws IOException {
        this.zza.zzR(i, i2);
    }

    public final void zzc(int i, long j) throws IOException {
        this.zza.zzS(i, j);
    }

    public final void zzd(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    public final void zze(int i, float f) throws IOException {
        this.zza.zzR(i, Float.floatToRawIntBits(f));
    }

    public final void zzf(int i, double d) throws IOException {
        this.zza.zzh(i, Double.doubleToRawLongBits(d));
    }

    public final void zzg(int i, int i2) throws IOException {
        this.zza.zzP(i, i2);
    }

    public final void zzh(int i, long j) throws IOException {
        this.zza.zzS(i, j);
    }

    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzP(i, i2);
    }

    public final void zzj(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzR(i, i2);
    }

    public final void zzl(int i, boolean z) throws IOException {
        this.zza.zzi(i, z);
    }

    public final void zzm(int i, String str) throws IOException {
        this.zza.zzj(i, str);
    }

    public final void zzn(int i, zzym zzymVar) throws IOException {
        this.zza.zzk(i, zzymVar);
    }

    public final void zzo(int i, int i2) throws IOException {
        this.zza.zzQ(i, i2);
    }

    public final void zzp(int i, int i2) throws IOException {
        this.zza.zzQ(i, zzyw.zzG(i2));
    }

    public final void zzq(int i, long j) throws IOException {
        this.zza.zzS(i, zzyw.zzH(j));
    }

    public final void zzr(int i, Object obj, zzabd zzabdVar) throws IOException {
        this.zza.zzl(i, (zzaar) obj, zzabdVar);
    }

    public final void zzs(int i, Object obj, zzabd zzabdVar) throws IOException {
        zzyw zzywVar = this.zza;
        zzywVar.zzO(i, 3);
        zzabdVar.zzn((zzaar) obj, zzywVar.zze);
        zzywVar.zzO(i, 4);
    }

    public final void zzt(int i) throws IOException {
        this.zza.zzO(i, 3);
    }

    public final void zzu(int i) throws IOException {
        this.zza.zzO(i, 4);
    }

    public final void zzC(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzP(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzyw.zzz(list.get(i4).intValue());
        }
        this.zza.zzo(i3);
        while (i2 < list.size()) {
            this.zza.zzn(list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzD(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzi(i, list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).booleanValue();
            i3++;
        }
        this.zza.zzo(i3);
        while (i2 < list.size()) {
            this.zza.zzm(list.get(i2).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    public final void zzG(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzQ(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzyw.zzA(list.get(i4).intValue());
        }
        this.zza.zzo(i3);
        while (i2 < list.size()) {
            this.zza.zzo(list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzH(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzR(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).intValue();
            i3 += 4;
        }
        this.zza.zzo(i3);
        while (i2 < list.size()) {
            this.zza.zzp(list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzI(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).longValue();
            i3 += 8;
        }
        this.zza.zzo(i3);
        while (i2 < list.size()) {
            this.zza.zzr(list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzJ(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzQ(i, zzyw.zzG(list.get(i2).intValue()));
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzyw.zzA(zzyw.zzG(list.get(i4).intValue()));
        }
        this.zza.zzo(i3);
        while (i2 < list.size()) {
            this.zza.zzo(zzyw.zzG(list.get(i2).intValue()));
            i2++;
        }
    }

    public final void zzK(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzS(i, zzyw.zzH(list.get(i2).longValue()));
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzyw.zzB(zzyw.zzH(list.get(i4).longValue()));
        }
        this.zza.zzo(i3);
        while (i2 < list.size()) {
            this.zza.zzq(zzyw.zzH(list.get(i2).longValue()));
            i2++;
        }
    }

    public final void zzv(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzP(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzyw.zzz(list.get(i4).intValue());
        }
        this.zza.zzo(i3);
        while (i2 < list.size()) {
            this.zza.zzn(list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzw(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzR(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).intValue();
            i3 += 4;
        }
        this.zza.zzo(i3);
        while (i2 < list.size()) {
            this.zza.zzp(list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzx(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzS(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzyw.zzB(list.get(i4).longValue());
        }
        this.zza.zzo(i3);
        while (i2 < list.size()) {
            this.zza.zzq(list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzy(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzS(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzyw.zzB(list.get(i4).longValue());
        }
        this.zza.zzo(i3);
        while (i2 < list.size()) {
            this.zza.zzq(list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzz(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).longValue();
            i3 += 8;
        }
        this.zza.zzo(i3);
        while (i2 < list.size()) {
            this.zza.zzr(list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzA(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzR(i, Float.floatToRawIntBits(list.get(i2).floatValue()));
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).floatValue();
            i3 += 4;
        }
        this.zza.zzo(i3);
        while (i2 < list.size()) {
            this.zza.zzp(Float.floatToRawIntBits(list.get(i2).floatValue()));
            i2++;
        }
    }

    public final void zzB(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, Double.doubleToRawLongBits(list.get(i2).doubleValue()));
                i2++;
            }
            return;
        }
        this.zza.zzO(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).doubleValue();
            i3 += 8;
        }
        this.zza.zzo(i3);
        while (i2 < list.size()) {
            this.zza.zzr(Double.doubleToRawLongBits(list.get(i2).doubleValue()));
            i2++;
        }
    }
}
