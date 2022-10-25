package com.google.android.gms.cast.internal;

import android.os.SystemClock;
import androidx.mediarouter.media.MediaRouteProviderProtocol;
import com.google.android.gms.cast.AdBreakStatus;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaLiveSeekableRange;
import com.google.android.gms.cast.MediaLoadRequestData;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaSeekOptions;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.cast.internal.media.MediaCommon;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzan extends zzd {
    public static final String zzb = CastUtils.zzd("com.google.cast.media");
    final zzar zzc;
    final zzar zzd;
    final zzar zze;
    final zzar zzf;
    final zzar zzg;
    final zzar zzh;
    final zzar zzi;
    final zzar zzj;
    final zzar zzk;
    final zzar zzl;
    final zzar zzm;
    final zzar zzn;
    final zzar zzo;
    final zzar zzp;
    final zzar zzq;
    final zzar zzr;
    final zzar zzs;
    final zzar zzt;
    final zzar zzu;
    final zzar zzv;
    private long zzw;
    private MediaStatus zzx;
    private Long zzy;
    private zzak zzz;

    public zzan(String str) {
        super(zzb, "MediaControlChannel", null);
        zzar zzarVar = new zzar(86400000L);
        this.zzc = zzarVar;
        zzar zzarVar2 = new zzar(86400000L);
        this.zzd = zzarVar2;
        zzar zzarVar3 = new zzar(86400000L);
        this.zze = zzarVar3;
        zzar zzarVar4 = new zzar(86400000L);
        this.zzf = zzarVar4;
        zzar zzarVar5 = new zzar(10000L);
        this.zzg = zzarVar5;
        zzar zzarVar6 = new zzar(86400000L);
        this.zzh = zzarVar6;
        zzar zzarVar7 = new zzar(86400000L);
        this.zzi = zzarVar7;
        zzar zzarVar8 = new zzar(86400000L);
        this.zzj = zzarVar8;
        zzar zzarVar9 = new zzar(86400000L);
        this.zzk = zzarVar9;
        zzar zzarVar10 = new zzar(86400000L);
        this.zzl = zzarVar10;
        zzar zzarVar11 = new zzar(86400000L);
        this.zzm = zzarVar11;
        zzar zzarVar12 = new zzar(86400000L);
        this.zzn = zzarVar12;
        zzar zzarVar13 = new zzar(86400000L);
        this.zzo = zzarVar13;
        zzar zzarVar14 = new zzar(86400000L);
        this.zzp = zzarVar14;
        zzar zzarVar15 = new zzar(86400000L);
        this.zzq = zzarVar15;
        zzar zzarVar16 = new zzar(86400000L);
        this.zzs = zzarVar16;
        this.zzr = new zzar(86400000L);
        zzar zzarVar17 = new zzar(86400000L);
        this.zzt = zzarVar17;
        zzar zzarVar18 = new zzar(86400000L);
        this.zzu = zzarVar18;
        zzar zzarVar19 = new zzar(86400000L);
        this.zzv = zzarVar19;
        zzc(zzarVar);
        zzc(zzarVar2);
        zzc(zzarVar3);
        zzc(zzarVar4);
        zzc(zzarVar5);
        zzc(zzarVar6);
        zzc(zzarVar7);
        zzc(zzarVar8);
        zzc(zzarVar9);
        zzc(zzarVar10);
        zzc(zzarVar11);
        zzc(zzarVar12);
        zzc(zzarVar13);
        zzc(zzarVar14);
        zzc(zzarVar15);
        zzc(zzarVar16);
        zzc(zzarVar16);
        zzc(zzarVar17);
        zzc(zzarVar18);
        zzc(zzarVar19);
        zzV();
    }

    private final long zzP(double d, long j, long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzw;
        if (elapsedRealtime < 0) {
            elapsedRealtime = 0;
        }
        if (elapsedRealtime == 0) {
            return j;
        }
        long j3 = j + ((long) (elapsedRealtime * d));
        if (j2 <= 0 || j3 <= j2) {
            if (j3 >= 0) {
                return j3;
            }
            return 0L;
        }
        return j2;
    }

    private static int[] zzQ(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        int[] iArr = new int[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            iArr[i] = jSONArray.getInt(i);
        }
        return iArr;
    }

    private final void zzR() {
        zzak zzakVar = this.zzz;
        if (zzakVar != null) {
            zzakVar.zza();
        }
    }

    private final void zzS() {
        zzak zzakVar = this.zzz;
        if (zzakVar != null) {
            zzakVar.zzb();
        }
    }

    private final void zzT() {
        zzak zzakVar = this.zzz;
        if (zzakVar != null) {
            zzakVar.zzc();
        }
    }

    private final void zzU() {
        zzak zzakVar = this.zzz;
        if (zzakVar != null) {
            zzakVar.zzd();
        }
    }

    private final void zzV() {
        this.zzw = 0L;
        this.zzx = null;
        for (zzar zzarVar : zzb()) {
            zzarVar.zze(2002);
        }
    }

    private static zzam zzW(JSONObject jSONObject) {
        MediaError zza = MediaError.zza(jSONObject);
        zzam zzamVar = new zzam();
        zzamVar.zza = CastUtils.zzj(jSONObject, "customData");
        zzamVar.zzb = zza;
        return zzamVar;
    }

    public final MediaStatus zzA() {
        return this.zzx;
    }

    public final MediaInfo zzB() {
        MediaStatus mediaStatus = this.zzx;
        if (mediaStatus == null) {
            return null;
        }
        return mediaStatus.getMediaInfo();
    }

    public final long zzH(zzap zzapVar) throws zzal, IllegalStateException {
        JSONObject jSONObject = new JSONObject();
        long zzg = zzg();
        try {
            jSONObject.put("requestId", zzg);
            jSONObject.put("type", "QUEUE_GET_ITEM_IDS");
            jSONObject.put("mediaSessionId", zzM());
        } catch (JSONException unused) {
        }
        zzf(jSONObject.toString(), zzg, null);
        this.zzq.zza(zzg, zzapVar);
        return zzg;
    }

    public final long zzI(zzap zzapVar, int i, int i2, int i3) throws zzal, IllegalArgumentException {
        if (i2 > 0 && i3 == 0) {
            i3 = 0;
        } else if (i2 != 0 || i3 <= 0) {
            throw new IllegalArgumentException("Exactly one of nextCount and prevCount must be positive and the other must be zero");
        }
        JSONObject jSONObject = new JSONObject();
        long zzg = zzg();
        try {
            jSONObject.put("requestId", zzg);
            jSONObject.put("type", "QUEUE_GET_ITEM_RANGE");
            jSONObject.put("mediaSessionId", zzM());
            jSONObject.put("itemId", i);
            if (i2 > 0) {
                jSONObject.put("nextCount", i2);
            }
            if (i3 > 0) {
                jSONObject.put("prevCount", i3);
            }
        } catch (JSONException unused) {
        }
        zzf(jSONObject.toString(), zzg, null);
        this.zzs.zza(zzg, zzapVar);
        return zzg;
    }

    public final long zzJ(zzap zzapVar, int[] iArr) throws zzal, IllegalArgumentException {
        JSONObject jSONObject = new JSONObject();
        long zzg = zzg();
        try {
            jSONObject.put("requestId", zzg);
            jSONObject.put("type", "QUEUE_GET_ITEMS");
            jSONObject.put("mediaSessionId", zzM());
            JSONArray jSONArray = new JSONArray();
            for (int i : iArr) {
                jSONArray.put(i);
            }
            jSONObject.put("itemIds", jSONArray);
        } catch (JSONException unused) {
        }
        zzf(jSONObject.toString(), zzg, null);
        this.zzr.zza(zzg, zzapVar);
        return zzg;
    }

    public final long zzK(String str, List list) throws IllegalStateException {
        long zzg = zzg();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestId", zzg);
            jSONObject.put("type", "PRECACHE");
            jSONObject.put("precacheData", str);
        } catch (JSONException unused) {
        }
        zzf(jSONObject.toString(), zzg, null);
        return zzg;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0229 A[Catch: JSONException -> 0x02c1, TryCatch #0 {JSONException -> 0x02c1, blocks: (B:3:0x000e, B:41:0x009d, B:43:0x00a3, B:45:0x00ac, B:46:0x00b9, B:48:0x00bf, B:49:0x00d1, B:51:0x00d7, B:53:0x00e0, B:55:0x00f6, B:75:0x012f, B:77:0x0135, B:79:0x013b, B:81:0x0141, B:83:0x0147, B:85:0x0150, B:87:0x015a, B:89:0x0160, B:90:0x0168, B:92:0x016e, B:93:0x017c, B:96:0x0182, B:98:0x018c, B:99:0x019d, B:101:0x01a3, B:102:0x01b1, B:104:0x01bd, B:106:0x01c7, B:107:0x01d8, B:109:0x01de, B:110:0x01ec, B:112:0x01f8, B:114:0x020a, B:125:0x0229, B:128:0x022e, B:130:0x0242, B:132:0x0246, B:133:0x024f, B:135:0x0253, B:136:0x025c, B:138:0x0260, B:139:0x0266, B:141:0x026a, B:142:0x026d, B:144:0x0271, B:145:0x0274, B:147:0x0278, B:148:0x027b, B:150:0x027f, B:152:0x0289, B:153:0x028c, B:155:0x0290, B:157:0x02a8, B:158:0x02b0, B:160:0x02b6, B:129:0x0233, B:118:0x0215, B:120:0x021d, B:156:0x029a), top: B:166:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0246 A[Catch: JSONException -> 0x02c1, TryCatch #0 {JSONException -> 0x02c1, blocks: (B:3:0x000e, B:41:0x009d, B:43:0x00a3, B:45:0x00ac, B:46:0x00b9, B:48:0x00bf, B:49:0x00d1, B:51:0x00d7, B:53:0x00e0, B:55:0x00f6, B:75:0x012f, B:77:0x0135, B:79:0x013b, B:81:0x0141, B:83:0x0147, B:85:0x0150, B:87:0x015a, B:89:0x0160, B:90:0x0168, B:92:0x016e, B:93:0x017c, B:96:0x0182, B:98:0x018c, B:99:0x019d, B:101:0x01a3, B:102:0x01b1, B:104:0x01bd, B:106:0x01c7, B:107:0x01d8, B:109:0x01de, B:110:0x01ec, B:112:0x01f8, B:114:0x020a, B:125:0x0229, B:128:0x022e, B:130:0x0242, B:132:0x0246, B:133:0x024f, B:135:0x0253, B:136:0x025c, B:138:0x0260, B:139:0x0266, B:141:0x026a, B:142:0x026d, B:144:0x0271, B:145:0x0274, B:147:0x0278, B:148:0x027b, B:150:0x027f, B:152:0x0289, B:153:0x028c, B:155:0x0290, B:157:0x02a8, B:158:0x02b0, B:160:0x02b6, B:129:0x0233, B:118:0x0215, B:120:0x021d, B:156:0x029a), top: B:166:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0253 A[Catch: JSONException -> 0x02c1, TryCatch #0 {JSONException -> 0x02c1, blocks: (B:3:0x000e, B:41:0x009d, B:43:0x00a3, B:45:0x00ac, B:46:0x00b9, B:48:0x00bf, B:49:0x00d1, B:51:0x00d7, B:53:0x00e0, B:55:0x00f6, B:75:0x012f, B:77:0x0135, B:79:0x013b, B:81:0x0141, B:83:0x0147, B:85:0x0150, B:87:0x015a, B:89:0x0160, B:90:0x0168, B:92:0x016e, B:93:0x017c, B:96:0x0182, B:98:0x018c, B:99:0x019d, B:101:0x01a3, B:102:0x01b1, B:104:0x01bd, B:106:0x01c7, B:107:0x01d8, B:109:0x01de, B:110:0x01ec, B:112:0x01f8, B:114:0x020a, B:125:0x0229, B:128:0x022e, B:130:0x0242, B:132:0x0246, B:133:0x024f, B:135:0x0253, B:136:0x025c, B:138:0x0260, B:139:0x0266, B:141:0x026a, B:142:0x026d, B:144:0x0271, B:145:0x0274, B:147:0x0278, B:148:0x027b, B:150:0x027f, B:152:0x0289, B:153:0x028c, B:155:0x0290, B:157:0x02a8, B:158:0x02b0, B:160:0x02b6, B:129:0x0233, B:118:0x0215, B:120:0x021d, B:156:0x029a), top: B:166:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0260 A[Catch: JSONException -> 0x02c1, TryCatch #0 {JSONException -> 0x02c1, blocks: (B:3:0x000e, B:41:0x009d, B:43:0x00a3, B:45:0x00ac, B:46:0x00b9, B:48:0x00bf, B:49:0x00d1, B:51:0x00d7, B:53:0x00e0, B:55:0x00f6, B:75:0x012f, B:77:0x0135, B:79:0x013b, B:81:0x0141, B:83:0x0147, B:85:0x0150, B:87:0x015a, B:89:0x0160, B:90:0x0168, B:92:0x016e, B:93:0x017c, B:96:0x0182, B:98:0x018c, B:99:0x019d, B:101:0x01a3, B:102:0x01b1, B:104:0x01bd, B:106:0x01c7, B:107:0x01d8, B:109:0x01de, B:110:0x01ec, B:112:0x01f8, B:114:0x020a, B:125:0x0229, B:128:0x022e, B:130:0x0242, B:132:0x0246, B:133:0x024f, B:135:0x0253, B:136:0x025c, B:138:0x0260, B:139:0x0266, B:141:0x026a, B:142:0x026d, B:144:0x0271, B:145:0x0274, B:147:0x0278, B:148:0x027b, B:150:0x027f, B:152:0x0289, B:153:0x028c, B:155:0x0290, B:157:0x02a8, B:158:0x02b0, B:160:0x02b6, B:129:0x0233, B:118:0x0215, B:120:0x021d, B:156:0x029a), top: B:166:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x026a A[Catch: JSONException -> 0x02c1, TryCatch #0 {JSONException -> 0x02c1, blocks: (B:3:0x000e, B:41:0x009d, B:43:0x00a3, B:45:0x00ac, B:46:0x00b9, B:48:0x00bf, B:49:0x00d1, B:51:0x00d7, B:53:0x00e0, B:55:0x00f6, B:75:0x012f, B:77:0x0135, B:79:0x013b, B:81:0x0141, B:83:0x0147, B:85:0x0150, B:87:0x015a, B:89:0x0160, B:90:0x0168, B:92:0x016e, B:93:0x017c, B:96:0x0182, B:98:0x018c, B:99:0x019d, B:101:0x01a3, B:102:0x01b1, B:104:0x01bd, B:106:0x01c7, B:107:0x01d8, B:109:0x01de, B:110:0x01ec, B:112:0x01f8, B:114:0x020a, B:125:0x0229, B:128:0x022e, B:130:0x0242, B:132:0x0246, B:133:0x024f, B:135:0x0253, B:136:0x025c, B:138:0x0260, B:139:0x0266, B:141:0x026a, B:142:0x026d, B:144:0x0271, B:145:0x0274, B:147:0x0278, B:148:0x027b, B:150:0x027f, B:152:0x0289, B:153:0x028c, B:155:0x0290, B:157:0x02a8, B:158:0x02b0, B:160:0x02b6, B:129:0x0233, B:118:0x0215, B:120:0x021d, B:156:0x029a), top: B:166:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0271 A[Catch: JSONException -> 0x02c1, TryCatch #0 {JSONException -> 0x02c1, blocks: (B:3:0x000e, B:41:0x009d, B:43:0x00a3, B:45:0x00ac, B:46:0x00b9, B:48:0x00bf, B:49:0x00d1, B:51:0x00d7, B:53:0x00e0, B:55:0x00f6, B:75:0x012f, B:77:0x0135, B:79:0x013b, B:81:0x0141, B:83:0x0147, B:85:0x0150, B:87:0x015a, B:89:0x0160, B:90:0x0168, B:92:0x016e, B:93:0x017c, B:96:0x0182, B:98:0x018c, B:99:0x019d, B:101:0x01a3, B:102:0x01b1, B:104:0x01bd, B:106:0x01c7, B:107:0x01d8, B:109:0x01de, B:110:0x01ec, B:112:0x01f8, B:114:0x020a, B:125:0x0229, B:128:0x022e, B:130:0x0242, B:132:0x0246, B:133:0x024f, B:135:0x0253, B:136:0x025c, B:138:0x0260, B:139:0x0266, B:141:0x026a, B:142:0x026d, B:144:0x0271, B:145:0x0274, B:147:0x0278, B:148:0x027b, B:150:0x027f, B:152:0x0289, B:153:0x028c, B:155:0x0290, B:157:0x02a8, B:158:0x02b0, B:160:0x02b6, B:129:0x0233, B:118:0x0215, B:120:0x021d, B:156:0x029a), top: B:166:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0278 A[Catch: JSONException -> 0x02c1, TryCatch #0 {JSONException -> 0x02c1, blocks: (B:3:0x000e, B:41:0x009d, B:43:0x00a3, B:45:0x00ac, B:46:0x00b9, B:48:0x00bf, B:49:0x00d1, B:51:0x00d7, B:53:0x00e0, B:55:0x00f6, B:75:0x012f, B:77:0x0135, B:79:0x013b, B:81:0x0141, B:83:0x0147, B:85:0x0150, B:87:0x015a, B:89:0x0160, B:90:0x0168, B:92:0x016e, B:93:0x017c, B:96:0x0182, B:98:0x018c, B:99:0x019d, B:101:0x01a3, B:102:0x01b1, B:104:0x01bd, B:106:0x01c7, B:107:0x01d8, B:109:0x01de, B:110:0x01ec, B:112:0x01f8, B:114:0x020a, B:125:0x0229, B:128:0x022e, B:130:0x0242, B:132:0x0246, B:133:0x024f, B:135:0x0253, B:136:0x025c, B:138:0x0260, B:139:0x0266, B:141:0x026a, B:142:0x026d, B:144:0x0271, B:145:0x0274, B:147:0x0278, B:148:0x027b, B:150:0x027f, B:152:0x0289, B:153:0x028c, B:155:0x0290, B:157:0x02a8, B:158:0x02b0, B:160:0x02b6, B:129:0x0233, B:118:0x0215, B:120:0x021d, B:156:0x029a), top: B:166:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x027f A[Catch: JSONException -> 0x02c1, TryCatch #0 {JSONException -> 0x02c1, blocks: (B:3:0x000e, B:41:0x009d, B:43:0x00a3, B:45:0x00ac, B:46:0x00b9, B:48:0x00bf, B:49:0x00d1, B:51:0x00d7, B:53:0x00e0, B:55:0x00f6, B:75:0x012f, B:77:0x0135, B:79:0x013b, B:81:0x0141, B:83:0x0147, B:85:0x0150, B:87:0x015a, B:89:0x0160, B:90:0x0168, B:92:0x016e, B:93:0x017c, B:96:0x0182, B:98:0x018c, B:99:0x019d, B:101:0x01a3, B:102:0x01b1, B:104:0x01bd, B:106:0x01c7, B:107:0x01d8, B:109:0x01de, B:110:0x01ec, B:112:0x01f8, B:114:0x020a, B:125:0x0229, B:128:0x022e, B:130:0x0242, B:132:0x0246, B:133:0x024f, B:135:0x0253, B:136:0x025c, B:138:0x0260, B:139:0x0266, B:141:0x026a, B:142:0x026d, B:144:0x0271, B:145:0x0274, B:147:0x0278, B:148:0x027b, B:150:0x027f, B:152:0x0289, B:153:0x028c, B:155:0x0290, B:157:0x02a8, B:158:0x02b0, B:160:0x02b6, B:129:0x0233, B:118:0x0215, B:120:0x021d, B:156:0x029a), top: B:166:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0290 A[Catch: JSONException -> 0x02c1, TryCatch #0 {JSONException -> 0x02c1, blocks: (B:3:0x000e, B:41:0x009d, B:43:0x00a3, B:45:0x00ac, B:46:0x00b9, B:48:0x00bf, B:49:0x00d1, B:51:0x00d7, B:53:0x00e0, B:55:0x00f6, B:75:0x012f, B:77:0x0135, B:79:0x013b, B:81:0x0141, B:83:0x0147, B:85:0x0150, B:87:0x015a, B:89:0x0160, B:90:0x0168, B:92:0x016e, B:93:0x017c, B:96:0x0182, B:98:0x018c, B:99:0x019d, B:101:0x01a3, B:102:0x01b1, B:104:0x01bd, B:106:0x01c7, B:107:0x01d8, B:109:0x01de, B:110:0x01ec, B:112:0x01f8, B:114:0x020a, B:125:0x0229, B:128:0x022e, B:130:0x0242, B:132:0x0246, B:133:0x024f, B:135:0x0253, B:136:0x025c, B:138:0x0260, B:139:0x0266, B:141:0x026a, B:142:0x026d, B:144:0x0271, B:145:0x0274, B:147:0x0278, B:148:0x027b, B:150:0x027f, B:152:0x0289, B:153:0x028c, B:155:0x0290, B:157:0x02a8, B:158:0x02b0, B:160:0x02b6, B:129:0x0233, B:118:0x0215, B:120:0x021d, B:156:0x029a), top: B:166:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzL(java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 808
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.internal.zzan.zzL(java.lang.String):void");
    }

    public final long zzM() throws zzal {
        MediaStatus mediaStatus = this.zzx;
        if (mediaStatus != null) {
            return mediaStatus.zza();
        }
        throw new zzal();
    }

    public final void zzN(long j, int i) {
        for (zzar zzarVar : zzb()) {
            zzarVar.zzd(j, i, null);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzp
    public final void zzh() {
        zza();
        zzV();
    }

    public final void zzi(zzak zzakVar) {
        this.zzz = zzakVar;
    }

    public final long zzj(zzap zzapVar, MediaLoadRequestData mediaLoadRequestData) throws IllegalStateException, IllegalArgumentException {
        if (mediaLoadRequestData.getMediaInfo() != null || mediaLoadRequestData.getQueueData() != null) {
            JSONObject json = mediaLoadRequestData.toJson();
            if (json == null) {
                throw new IllegalArgumentException("Failed to jsonify the load request due to malformed request");
            }
            long zzg = zzg();
            try {
                json.put("requestId", zzg);
                json.put("type", "LOAD");
            } catch (JSONException unused) {
            }
            zzf(json.toString(), zzg, null);
            this.zzc.zza(zzg, zzapVar);
            return zzg;
        }
        throw new IllegalArgumentException("MediaInfo and MediaQueueData should not be both null");
    }

    public final long zzk(zzap zzapVar, JSONObject jSONObject) throws IllegalStateException, zzal {
        JSONObject jSONObject2 = new JSONObject();
        long zzg = zzg();
        try {
            jSONObject2.put("requestId", zzg);
            jSONObject2.put("type", "PAUSE");
            jSONObject2.put("mediaSessionId", zzM());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzf(jSONObject2.toString(), zzg, null);
        this.zzd.zza(zzg, zzapVar);
        return zzg;
    }

    public final long zzl(zzap zzapVar, JSONObject jSONObject) throws IllegalStateException, zzal {
        JSONObject jSONObject2 = new JSONObject();
        long zzg = zzg();
        try {
            jSONObject2.put("requestId", zzg);
            jSONObject2.put("type", "STOP");
            jSONObject2.put("mediaSessionId", zzM());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzf(jSONObject2.toString(), zzg, null);
        this.zzf.zza(zzg, zzapVar);
        return zzg;
    }

    public final long zzm(zzap zzapVar, JSONObject jSONObject) throws IllegalStateException, zzal {
        JSONObject jSONObject2 = new JSONObject();
        long zzg = zzg();
        try {
            jSONObject2.put("requestId", zzg);
            jSONObject2.put("type", "PLAY");
            jSONObject2.put("mediaSessionId", zzM());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzf(jSONObject2.toString(), zzg, null);
        this.zze.zza(zzg, zzapVar);
        return zzg;
    }

    public final long zzn(zzap zzapVar, MediaSeekOptions mediaSeekOptions) throws IllegalStateException, zzal {
        JSONObject jSONObject = new JSONObject();
        long zzg = zzg();
        long position = mediaSeekOptions.isSeekToInfinite() ? 4294967296000L : mediaSeekOptions.getPosition();
        try {
            jSONObject.put("requestId", zzg);
            jSONObject.put("type", "SEEK");
            jSONObject.put("mediaSessionId", zzM());
            jSONObject.put("currentTime", CastUtils.millisecToSec(position));
            if (mediaSeekOptions.getResumeState() == 1) {
                jSONObject.put("resumeState", "PLAYBACK_START");
            } else if (mediaSeekOptions.getResumeState() == 2) {
                jSONObject.put("resumeState", "PLAYBACK_PAUSE");
            }
            if (mediaSeekOptions.getCustomData() != null) {
                jSONObject.put("customData", mediaSeekOptions.getCustomData());
            }
        } catch (JSONException unused) {
        }
        zzf(jSONObject.toString(), zzg, null);
        this.zzy = Long.valueOf(position);
        this.zzg.zza(zzg, new zzaj(this, zzapVar));
        return zzg;
    }

    public final long zzo(zzap zzapVar) throws IllegalStateException, zzal {
        JSONObject jSONObject = new JSONObject();
        long zzg = zzg();
        try {
            jSONObject.put("requestId", zzg);
            jSONObject.put("type", "SKIP_AD");
            jSONObject.put("mediaSessionId", zzM());
        } catch (JSONException e) {
            this.zza.m362w(String.format(Locale.ROOT, "Error creating SkipAd message: %s", e.getMessage()), new Object[0]);
        }
        zzf(jSONObject.toString(), zzg, null);
        this.zzu.zza(zzg, zzapVar);
        return zzg;
    }

    public final long zzp(zzap zzapVar, double d, JSONObject jSONObject) throws IllegalStateException, zzal, IllegalArgumentException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Volume cannot be ");
            sb.append(d);
            throw new IllegalArgumentException(sb.toString());
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzg = zzg();
        try {
            jSONObject2.put("requestId", zzg);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", zzM());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("level", d);
            jSONObject2.put(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzf(jSONObject2.toString(), zzg, null);
        this.zzh.zza(zzg, zzapVar);
        return zzg;
    }

    public final long zzq(zzap zzapVar, boolean z, JSONObject jSONObject) throws IllegalStateException, zzal {
        JSONObject jSONObject2 = new JSONObject();
        long zzg = zzg();
        try {
            jSONObject2.put("requestId", zzg);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", zzM());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("muted", z);
            jSONObject2.put(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzf(jSONObject2.toString(), zzg, null);
        this.zzi.zza(zzg, zzapVar);
        return zzg;
    }

    public final long zzs(zzap zzapVar) throws IllegalStateException {
        JSONObject jSONObject = new JSONObject();
        long zzg = zzg();
        try {
            jSONObject.put("requestId", zzg);
            jSONObject.put("type", "GET_STATUS");
            MediaStatus mediaStatus = this.zzx;
            if (mediaStatus != null) {
                jSONObject.put("mediaSessionId", mediaStatus.zza());
            }
        } catch (JSONException unused) {
        }
        zzf(jSONObject.toString(), zzg, null);
        this.zzj.zza(zzg, zzapVar);
        return zzg;
    }

    public final long zzv() {
        MediaStatus mediaStatus;
        MediaInfo zzB = zzB();
        if (zzB == null || (mediaStatus = this.zzx) == null) {
            return 0L;
        }
        Long l = this.zzy;
        if (l == null) {
            if (this.zzw == 0) {
                return 0L;
            }
            double playbackRate = mediaStatus.getPlaybackRate();
            long streamPosition = this.zzx.getStreamPosition();
            return (playbackRate == 0.0d || this.zzx.getPlayerState() != 2) ? streamPosition : zzP(playbackRate, streamPosition, zzB.getStreamDuration());
        }
        if (l.equals(4294967296000L)) {
            if (this.zzx.getLiveSeekableRange() != null) {
                return Math.min(l.longValue(), zzx());
            }
            if (zzz() >= 0) {
                return Math.min(l.longValue(), zzz());
            }
        }
        return l.longValue();
    }

    public final long zzw() {
        MediaLiveSeekableRange liveSeekableRange;
        MediaStatus mediaStatus = this.zzx;
        if (mediaStatus == null || (liveSeekableRange = mediaStatus.getLiveSeekableRange()) == null) {
            return 0L;
        }
        long startTime = liveSeekableRange.getStartTime();
        if (liveSeekableRange.isMovingWindow()) {
            startTime = zzP(1.0d, startTime, -1L);
        }
        return liveSeekableRange.isLiveDone() ? Math.min(startTime, liveSeekableRange.getEndTime()) : startTime;
    }

    public final long zzx() {
        MediaLiveSeekableRange liveSeekableRange;
        MediaStatus mediaStatus = this.zzx;
        if (mediaStatus == null || (liveSeekableRange = mediaStatus.getLiveSeekableRange()) == null) {
            return 0L;
        }
        long endTime = liveSeekableRange.getEndTime();
        return !liveSeekableRange.isLiveDone() ? zzP(1.0d, endTime, -1L) : endTime;
    }

    public final long zzy() {
        MediaStatus mediaStatus;
        AdBreakStatus adBreakStatus;
        if (this.zzw == 0 || (mediaStatus = this.zzx) == null || (adBreakStatus = mediaStatus.getAdBreakStatus()) == null) {
            return 0L;
        }
        double playbackRate = this.zzx.getPlaybackRate();
        if (playbackRate == 0.0d) {
            playbackRate = 1.0d;
        }
        return zzP(this.zzx.getPlayerState() != 2 ? 0.0d : playbackRate, adBreakStatus.getCurrentBreakClipTimeInMs(), 0L);
    }

    public final long zzz() {
        MediaInfo zzB = zzB();
        if (zzB != null) {
            return zzB.getStreamDuration();
        }
        return 0L;
    }

    public final long zzF(zzap zzapVar, int[] iArr, JSONObject jSONObject) throws IllegalStateException, zzal, IllegalArgumentException {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("itemIdsToRemove must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzg = zzg();
        try {
            jSONObject2.put("requestId", zzg);
            jSONObject2.put("type", "QUEUE_REMOVE");
            jSONObject2.put("mediaSessionId", zzM());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < iArr.length; i++) {
                jSONArray.put(i, iArr[i]);
            }
            jSONObject2.put("itemIds", jSONArray);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzf(jSONObject2.toString(), zzg, null);
        this.zzo.zza(zzg, zzapVar);
        return zzg;
    }

    public final long zzG(zzap zzapVar, int[] iArr, int i, JSONObject jSONObject) throws IllegalStateException, zzal, IllegalArgumentException {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("itemIdsToReorder must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzg = zzg();
        try {
            jSONObject2.put("requestId", zzg);
            jSONObject2.put("type", "QUEUE_REORDER");
            jSONObject2.put("mediaSessionId", zzM());
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < iArr.length; i2++) {
                jSONArray.put(i2, iArr[i2]);
            }
            jSONObject2.put("itemIds", jSONArray);
            if (i != 0) {
                jSONObject2.put("insertBefore", i);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzf(jSONObject2.toString(), zzg, null);
        this.zzp.zza(zzg, zzapVar);
        return zzg;
    }

    public final long zzr(zzap zzapVar, double d, JSONObject jSONObject) throws IllegalStateException, zzal {
        if (this.zzx == null) {
            throw new zzal();
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzg = zzg();
        try {
            jSONObject2.put("requestId", zzg);
            jSONObject2.put("type", "SET_PLAYBACK_RATE");
            jSONObject2.put("playbackRate", d);
            Preconditions.checkNotNull(this.zzx, "mediaStatus should not be null");
            jSONObject2.put("mediaSessionId", this.zzx.zza());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzf(jSONObject2.toString(), zzg, null);
        this.zzt.zza(zzg, zzapVar);
        return zzg;
    }

    public final long zzt(zzap zzapVar, long[] jArr) throws IllegalStateException, zzal {
        if (jArr == null) {
            throw new IllegalArgumentException("trackIds cannot be null");
        }
        JSONObject jSONObject = new JSONObject();
        long zzg = zzg();
        try {
            jSONObject.put("requestId", zzg);
            jSONObject.put("type", "EDIT_TRACKS_INFO");
            jSONObject.put("mediaSessionId", zzM());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < jArr.length; i++) {
                jSONArray.put(i, jArr[i]);
            }
            jSONObject.put("activeTrackIds", jSONArray);
        } catch (JSONException unused) {
        }
        zzf(jSONObject.toString(), zzg, null);
        this.zzk.zza(zzg, zzapVar);
        return zzg;
    }

    public final long zzu(zzap zzapVar, TextTrackStyle textTrackStyle) throws IllegalStateException, zzal {
        if (textTrackStyle == null) {
            throw new IllegalArgumentException("trackStyle cannot be null");
        }
        JSONObject jSONObject = new JSONObject();
        long zzg = zzg();
        try {
            jSONObject.put("requestId", zzg);
            jSONObject.put("type", "EDIT_TRACKS_INFO");
            jSONObject.put("textTrackStyle", textTrackStyle.zza());
            jSONObject.put("mediaSessionId", zzM());
        } catch (JSONException unused) {
        }
        zzf(jSONObject.toString(), zzg, null);
        this.zzl.zza(zzg, zzapVar);
        return zzg;
    }

    public final long zzD(zzap zzapVar, MediaQueueItem[] mediaQueueItemArr, int i, int i2, int i3, long j, JSONObject jSONObject) throws IllegalStateException, zzal, IllegalArgumentException {
        if (mediaQueueItemArr == null || mediaQueueItemArr.length == 0) {
            throw new IllegalArgumentException("itemsToInsert must not be null or empty.");
        }
        int i4 = (j > (-1L) ? 1 : (j == (-1L) ? 0 : -1));
        if (i4 == 0 || j >= 0) {
            JSONObject jSONObject2 = new JSONObject();
            long zzg = zzg();
            try {
                jSONObject2.put("requestId", zzg);
                jSONObject2.put("type", "QUEUE_INSERT");
                jSONObject2.put("mediaSessionId", zzM());
                JSONArray jSONArray = new JSONArray();
                for (int i5 = 0; i5 < mediaQueueItemArr.length; i5++) {
                    jSONArray.put(i5, mediaQueueItemArr[i5].toJson());
                }
                jSONObject2.put(FirebaseAnalytics.Param.ITEMS, jSONArray);
                if (i != 0) {
                    jSONObject2.put("insertBefore", i);
                }
                if (i3 != -1) {
                    jSONObject2.put("currentItemIndex", 0);
                }
                if (i4 != 0) {
                    jSONObject2.put("currentTime", CastUtils.millisecToSec(j));
                }
                if (jSONObject != null) {
                    jSONObject2.put("customData", jSONObject);
                }
            } catch (JSONException unused) {
            }
            zzf(jSONObject2.toString(), zzg, null);
            this.zzm.zza(zzg, zzapVar);
            return zzg;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("playPosition can not be negative: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    public final long zzC(zzap zzapVar, MediaQueueItem[] mediaQueueItemArr, int i, int i2, long j, JSONObject jSONObject) throws IllegalStateException, IllegalArgumentException {
        int length;
        String zza;
        if (mediaQueueItemArr == null || (length = mediaQueueItemArr.length) == 0) {
            throw new IllegalArgumentException("items must not be null or empty.");
        }
        if (i < 0 || i >= length) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Invalid startIndex: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        int i3 = (j > (-1L) ? 1 : (j == (-1L) ? 0 : -1));
        if (i3 == 0 || j >= 0) {
            JSONObject jSONObject2 = new JSONObject();
            long zzg = zzg();
            this.zzc.zza(zzg, zzapVar);
            try {
                jSONObject2.put("requestId", zzg);
                jSONObject2.put("type", "QUEUE_LOAD");
                JSONArray jSONArray = new JSONArray();
                for (int i4 = 0; i4 < mediaQueueItemArr.length; i4++) {
                    jSONArray.put(i4, mediaQueueItemArr[i4].toJson());
                }
                jSONObject2.put(FirebaseAnalytics.Param.ITEMS, jSONArray);
                zza = MediaCommon.zza(Integer.valueOf(i2));
            } catch (JSONException unused) {
            }
            if (zza == null) {
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append("Invalid repeat mode: ");
                sb2.append(i2);
                throw new IllegalArgumentException(sb2.toString());
            }
            jSONObject2.put("repeatMode", zza);
            jSONObject2.put("startIndex", i);
            if (i3 != 0) {
                jSONObject2.put("currentTime", CastUtils.millisecToSec(j));
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
            zzf(jSONObject2.toString(), zzg, null);
            return zzg;
        }
        StringBuilder sb3 = new StringBuilder(54);
        sb3.append("playPosition can not be negative: ");
        sb3.append(j);
        throw new IllegalArgumentException(sb3.toString());
    }

    public final long zzE(zzap zzapVar, int i, long j, MediaQueueItem[] mediaQueueItemArr, int i2, boolean z, Integer num, JSONObject jSONObject) throws IllegalArgumentException, IllegalStateException, zzal {
        int i3 = (j > (-1L) ? 1 : (j == (-1L) ? 0 : -1));
        if (i3 == 0 || j >= 0) {
            JSONObject jSONObject2 = new JSONObject();
            long zzg = zzg();
            try {
                jSONObject2.put("requestId", zzg);
                jSONObject2.put("type", "QUEUE_UPDATE");
                jSONObject2.put("mediaSessionId", zzM());
                if (i != 0) {
                    jSONObject2.put("currentItemId", i);
                }
                if (i2 != 0) {
                    jSONObject2.put("jump", i2);
                }
                if (mediaQueueItemArr != null && mediaQueueItemArr.length > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i4 = 0; i4 < mediaQueueItemArr.length; i4++) {
                        jSONArray.put(i4, mediaQueueItemArr[i4].toJson());
                    }
                    jSONObject2.put(FirebaseAnalytics.Param.ITEMS, jSONArray);
                }
                if (z) {
                    jSONObject2.put("shuffle", true);
                }
                String zza = MediaCommon.zza(num);
                if (zza != null) {
                    jSONObject2.put("repeatMode", zza);
                }
                if (i3 != 0) {
                    jSONObject2.put("currentTime", CastUtils.millisecToSec(j));
                }
                if (jSONObject != null) {
                    jSONObject2.put("customData", jSONObject);
                }
            } catch (JSONException unused) {
            }
            zzf(jSONObject2.toString(), zzg, null);
            this.zzn.zza(zzg, zzapVar);
            return zzg;
        }
        StringBuilder sb = new StringBuilder(53);
        sb.append("playPosition cannot be negative: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }
}
