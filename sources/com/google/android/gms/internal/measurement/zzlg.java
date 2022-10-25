package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum zzi uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
public class zzlg {
    public static final zzlg zza;
    public static final zzlg zzb;
    public static final zzlg zzc;
    public static final zzlg zzd;
    public static final zzlg zze;
    public static final zzlg zzf;
    public static final zzlg zzg;
    public static final zzlg zzh;
    public static final zzlg zzi;
    public static final zzlg zzj;
    public static final zzlg zzk;
    public static final zzlg zzl;
    public static final zzlg zzm;
    public static final zzlg zzn;
    public static final zzlg zzo;
    public static final zzlg zzp;
    public static final zzlg zzq;
    public static final zzlg zzr;
    private static final /* synthetic */ zzlg[] zzu;
    private final zzln zzs;
    private final int zzt;

    public static zzlg[] values() {
        return (zzlg[]) zzu.clone();
    }

    private zzlg(String str, int i, zzln zzlnVar, int i2) {
        this.zzs = zzlnVar;
        this.zzt = i2;
    }

    public final zzln zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzlg(String str, int i, zzln zzlnVar, int i2, zzlh zzlhVar) {
        this(str, i, zzlnVar, i2);
    }

    static {
        zzlg zzlgVar = new zzlg("DOUBLE", 0, zzln.DOUBLE, 1);
        zza = zzlgVar;
        zzlg zzlgVar2 = new zzlg("FLOAT", 1, zzln.FLOAT, 5);
        zzb = zzlgVar2;
        zzlg zzlgVar3 = new zzlg("INT64", 2, zzln.LONG, 0);
        zzc = zzlgVar3;
        zzlg zzlgVar4 = new zzlg("UINT64", 3, zzln.LONG, 0);
        zzd = zzlgVar4;
        zzlg zzlgVar5 = new zzlg("INT32", 4, zzln.INT, 0);
        zze = zzlgVar5;
        zzlg zzlgVar6 = new zzlg("FIXED64", 5, zzln.LONG, 1);
        zzf = zzlgVar6;
        zzlg zzlgVar7 = new zzlg("FIXED32", 6, zzln.INT, 5);
        zzg = zzlgVar7;
        zzlg zzlgVar8 = new zzlg("BOOL", 7, zzln.BOOLEAN, 0);
        zzh = zzlgVar8;
        final zzln zzlnVar = zzln.STRING;
        zzlg zzlgVar9 = new zzlg("STRING", 8, zzlnVar, 2) { // from class: com.google.android.gms.internal.measurement.zzlj
        };
        zzi = zzlgVar9;
        final zzln zzlnVar2 = zzln.MESSAGE;
        zzlg zzlgVar10 = new zzlg("GROUP", 9, zzlnVar2, 3) { // from class: com.google.android.gms.internal.measurement.zzli
        };
        zzj = zzlgVar10;
        final zzln zzlnVar3 = zzln.MESSAGE;
        zzlg zzlgVar11 = new zzlg("MESSAGE", 10, zzlnVar3, 2) { // from class: com.google.android.gms.internal.measurement.zzll
        };
        zzk = zzlgVar11;
        final zzln zzlnVar4 = zzln.BYTE_STRING;
        zzlg zzlgVar12 = new zzlg("BYTES", 11, zzlnVar4, 2) { // from class: com.google.android.gms.internal.measurement.zzlk
        };
        zzl = zzlgVar12;
        zzlg zzlgVar13 = new zzlg("UINT32", 12, zzln.INT, 0);
        zzm = zzlgVar13;
        zzlg zzlgVar14 = new zzlg("ENUM", 13, zzln.ENUM, 0);
        zzn = zzlgVar14;
        zzlg zzlgVar15 = new zzlg("SFIXED32", 14, zzln.INT, 5);
        zzo = zzlgVar15;
        zzlg zzlgVar16 = new zzlg("SFIXED64", 15, zzln.LONG, 1);
        zzp = zzlgVar16;
        zzlg zzlgVar17 = new zzlg("SINT32", 16, zzln.INT, 0);
        zzq = zzlgVar17;
        zzlg zzlgVar18 = new zzlg("SINT64", 17, zzln.LONG, 0);
        zzr = zzlgVar18;
        zzu = new zzlg[]{zzlgVar, zzlgVar2, zzlgVar3, zzlgVar4, zzlgVar5, zzlgVar6, zzlgVar7, zzlgVar8, zzlgVar9, zzlgVar10, zzlgVar11, zzlgVar12, zzlgVar13, zzlgVar14, zzlgVar15, zzlgVar16, zzlgVar17, zzlgVar18};
    }
}
