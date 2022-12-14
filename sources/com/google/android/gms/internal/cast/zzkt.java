package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzkt extends zzos<zzkt, zzks> implements zzpz {
    private static final zzkt zzai;
    private int zzB;
    private int zzC;
    private zzlb zzD;
    private int zzE;
    private zzkr zzF;
    private zzlb zzH;
    private int zzI;
    private int zzJ;
    private int zzK;
    private int zzL;
    private int zzM;
    private int zzN;
    private zznh zzO;
    private zzkl zzP;
    private zzka zzQ;
    private zzlx zzR;
    private zzmv zzS;
    private zzmb zzT;
    private int zzV;
    private zzmj zzW;
    private boolean zzY;
    private boolean zzZ;
    private int zzaa;
    private zzkd zzab;
    private zzmr zzac;
    private zzlr zzad;
    private zzmh zzae;
    private zznb zzaf;
    private zzkv zzag;
    private int zzb;
    private int zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private zzln zzi;
    private zzmp zzj;
    private zzll zzk;
    private zzlh zzl;
    private zzkp zzm;
    private zzmn zzn;
    private zzkh zzo;
    private zznf zzp;
    private zzlf zzr;
    private zzey zzs;
    private zzmf zzu;
    private byte zzah = 2;
    private String zzq = "";
    private String zzt = "";
    private String zzv = "";
    private zzox zzw = zzx();
    private zzpa<zzlp> zzx = zzz();
    private zzpa<zzlt> zzy = zzz();
    private zzpa<zzkx> zzz = zzz();
    private zzpa<zzmx> zzA = zzz();
    private zzpa<zzlb> zzG = zzz();
    private zzpa<zzkj> zzU = zzz();
    private zzpa<zzkn> zzX = zzz();

    static {
        zzkt zzktVar = new zzkt();
        zzai = zzktVar;
        zzos.zzu(zzkt.class, zzktVar);
    }

    private zzkt() {
    }

    public static zzks zzc() {
        return zzai.zzp();
    }

    public static zzks zzd(zzkt zzktVar) {
        zzks zzp = zzai.zzp();
        zzp.zzq(zzktVar);
        return zzp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzf(zzkt zzktVar, long j) {
        zzktVar.zzb |= 2;
        zzktVar.zzg = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzg(zzkt zzktVar, String str) {
        str.getClass();
        zzktVar.zzb |= 16384;
        zzktVar.zzt = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzh(zzkt zzktVar, String str) {
        zzktVar.zzb |= 65536;
        zzktVar.zzv = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zzkt zzktVar, int i) {
        zzktVar.zzb |= 268435456;
        zzktVar.zzN = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzj(zzkt zzktVar, zzkl zzklVar) {
        zzklVar.getClass();
        zzktVar.zzP = zzklVar;
        zzktVar.zzb |= 1073741824;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzk(zzkt zzktVar, zzkj zzkjVar) {
        zzkjVar.getClass();
        zzpa<zzkj> zzpaVar = zzktVar.zzU;
        if (!zzpaVar.zza()) {
            int size = zzpaVar.size();
            zzktVar.zzU = zzpaVar.zzh(size == 0 ? 10 : size + size);
        }
        zzktVar.zzU.add(zzkjVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzl(zzkt zzktVar, zzkd zzkdVar) {
        zzkdVar.getClass();
        zzktVar.zzab = zzkdVar;
        zzktVar.zze |= 256;
    }

    public final zzkl zza() {
        zzkl zzklVar = this.zzP;
        return zzklVar == null ? zzkl.zzd() : zzklVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.cast.zzos
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            this.zzah = obj == null ? (byte) 0 : (byte) 1;
                            return null;
                        }
                        return zzai;
                    }
                    return new zzks(null);
                }
                return new zzkt();
            }
            return zzv(zzai, "\u00016\u0000\u0002\u000166\u0000\b\u0001\u0001???\u0000\u0002???\u0001\u0003???\u0002\u0004???\u0003\u0005???\u0004\u0006???\u0005\u0007???\u0006\b???\u0007\t???\u000e\n???\b\u000b???\t\f???\n\r???\u000b\u000e???\f\u000f???\r\u0010???\u000f\u0011???\u0010\u0012\u0016\u0013\u001b\u0014\u001b\u0015\u001b\u0016\u001b\u0017???\u0011\u0018???\u0015\u0019\u001b\u001a???\u0016\u001b???\u0018\u001c???\u0019\u001d???\u001a\u001e???\u001b\u001f???\u001c ???\u001d!???\u001e\"???\u001f#???\u0012$???\u0013%??? &???!'???\"(\u001b)???#*???$+\u001b,???\u0017-???%.???&/???'0???(1???\u00142???)3???*4???+5???,6???-", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", zzjb.zza(), "zzi", "zzj", "zzk", "zzl", "zzm", "zzt", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzu", "zzv", "zzw", "zzx", zzlp.class, "zzy", zzlt.class, "zzz", zzkx.class, "zzA", zzmx.class, "zzB", zziv.zza(), "zzF", "zzG", zzlb.class, "zzH", "zzJ", zzhd.zza(), "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzC", zzip.zza(), "zzD", "zzR", "zzS", "zzT", "zzU", zzkj.class, "zzV", zzis.zza(), "zzW", "zzX", zzkn.class, "zzI", zzha.zza(), "zzY", "zzZ", "zzaa", zzgu.zza(), "zzab", "zzE", "zzac", "zzad", "zzae", "zzaf", "zzag"});
        }
        return Byte.valueOf(this.zzah);
    }
}
