package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.p002v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.ExoPlayer;
import com.phimhd.Constants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.we */
/* loaded from: classes2.dex */
public final class C3156we implements InterfaceC3153wb, InterfaceC2659du {

    /* renamed from: a */
    public static final avg f9270a = avg.m4512q(5400000L, 3300000L, 2000000L, 1300000L, 760000L);

    /* renamed from: b */
    public static final avg f9271b = avg.m4512q(1700000L, 820000L, 450000L, 180000L, 130000L);

    /* renamed from: c */
    public static final avg f9272c = avg.m4512q(2300000L, 1300000L, 1000000L, 820000L, 570000L);

    /* renamed from: d */
    public static final avg f9273d = avg.m4512q(3400000L, 2000000L, 1400000L, 1000000L, 620000L);

    /* renamed from: e */
    public static final avg f9274e = avg.m4512q(7500000L, 5200000L, 3700000L, Long.valueOf((long) Constants.TIME_30MIN_TO_SHOW_ADS), 1100000L);

    /* renamed from: f */
    public static final avg f9275f = avg.m4512q(3300000L, 1900000L, 1700000L, 1500000L, 1200000L);

    /* renamed from: g */
    private static C3156we f9276g;

    /* renamed from: h */
    private final avj f9277h;

    /* renamed from: i */
    private final C3150vz f9278i;

    /* renamed from: j */
    private final C3173wv f9279j;

    /* renamed from: k */
    private final InterfaceC2598bn f9280k;

    /* renamed from: l */
    private final boolean f9281l;

    /* renamed from: m */
    private int f9282m;

    /* renamed from: n */
    private long f9283n;

    /* renamed from: o */
    private long f9284o;

    /* renamed from: p */
    private int f9285p;

    /* renamed from: q */
    private long f9286q;

    /* renamed from: r */
    private long f9287r;

    /* renamed from: s */
    private long f9288s;

    /* renamed from: t */
    private long f9289t;

    @Deprecated
    public C3156we() {
        avj.m4504d();
        InterfaceC2598bn interfaceC2598bn = InterfaceC2598bn.f6252a;
        throw null;
    }

    /* renamed from: l */
    private final long m749l(int i) {
        Long l = (Long) this.f9277h.get(Integer.valueOf(i));
        if (l == null) {
            l = (Long) this.f9277h.get(0);
        }
        if (l == null) {
            l = 1000000L;
        }
        return l.longValue();
    }

    /* renamed from: m */
    private final void m748m(int i, long j, long j2) {
        int i2;
        long j3;
        if (i == 0) {
            if (j != 0) {
                j3 = j;
            } else if (j2 == this.f9289t) {
                return;
            } else {
                j3 = 0;
            }
            i2 = 0;
        } else {
            i2 = i;
            j3 = j;
        }
        this.f9289t = j2;
        this.f9278i.m776b(i2, j3, j2);
    }

    /* renamed from: n */
    public final synchronized void m747n(int i) {
        int i2 = this.f9285p;
        if (i2 == 0 || this.f9281l) {
            if (i2 == i) {
                return;
            }
            this.f9285p = i;
            if (i != 1 && i != 0 && i != 8) {
                this.f9288s = m749l(i);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                m748m(this.f9282m > 0 ? (int) (elapsedRealtime - this.f9283n) : 0, this.f9284o, this.f9288s);
                this.f9283n = elapsedRealtime;
                this.f9284o = 0L;
                this.f9287r = 0L;
                this.f9286q = 0L;
                this.f9279j.m708b();
            }
        }
    }

    /* renamed from: o */
    private static boolean m746o(C2642dd c2642dd, boolean z) {
        return z && !c2642dd.m2487d(8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:1003:0x0149, code lost:
        if (r3.equals("YE") != false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1014:0x016f, code lost:
        if (r3.equals("WF") != false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1029:0x01a3, code lost:
        if (r3.equals("VG") != false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1032:0x01ad, code lost:
        if (r3.equals("VE") != false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1035:0x01b7, code lost:
        if (r3.equals("VC") != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1042:0x01cf, code lost:
        if (r3.equals("UY") != false) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1045:0x01d9, code lost:
        if (r3.equals("US") != false) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1048:0x01e3, code lost:
        if (r3.equals("UG") != false) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1055:0x01fb, code lost:
        if (r3.equals("TZ") != false) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1062:0x0213, code lost:
        if (r3.equals("TV") != false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1077:0x0247, code lost:
        if (r3.equals("TN") != false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1084:0x025f, code lost:
        if (r3.equals("TL") != false) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1099:0x0293, code lost:
        if (r3.equals("TD") != false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1102:0x029d, code lost:
        if (r3.equals("TC") != false) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1109:0x02b4, code lost:
        if (r3.equals("SY") != false) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1112:0x02be, code lost:
        if (r3.equals("SX") != false) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1114:0x02c5, code lost:
        return new int[]{2, 2, 1, 0, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1120:0x02da, code lost:
        if (r3.equals("ST") != false) goto L228;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1123:0x02e4, code lost:
        if (r3.equals("SS") != false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1126:0x02ee, code lost:
        if (r3.equals("SR") != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1128:0x02f5, code lost:
        return new int[]{2, 3, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1130:0x02fc, code lost:
        if (r3.equals("SO") != false) goto L236;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1133:0x0306, code lost:
        if (r3.equals("SN") != false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1136:0x0310, code lost:
        if (r3.equals("SM") != false) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1143:0x0328, code lost:
        if (r3.equals("SK") != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1146:0x0332, code lost:
        if (r3.equals("SJ") != false) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1149:0x033c, code lost:
        if (r3.equals("SI") != false) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1152:0x0346, code lost:
        if (r3.equals("SH") != false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1159:0x035e, code lost:
        if (r3.equals("SE") != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1162:0x0368, code lost:
        if (r3.equals("SD") != false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1169:0x0380, code lost:
        if (r3.equals("SB") != false) goto L272;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1172:0x038a, code lost:
        if (r3.equals("SA") != false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1174:0x0391, code lost:
        return new int[]{2, 2, 1, 1, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1184:0x03b4, code lost:
        if (r3.equals("RS") != false) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1219:0x042e, code lost:
        if (r3.equals("PM") != false) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1222:0x0438, code lost:
        if (r3.equals("PL") != false) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1225:0x0442, code lost:
        if (r3.equals("PK") != false) goto L236;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1232:0x045a, code lost:
        if (r3.equals("PG") != false) goto L332;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1255:0x04aa, code lost:
        if (r3.equals("NU") != false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1282:0x0508, code lost:
        if (r3.equals("NE") != false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1285:0x0512, code lost:
        if (r3.equals("NC") != false) goto L384;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1292:0x052a, code lost:
        if (r3.equals("MZ") != false) goto L228;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1295:0x0534, code lost:
        if (r3.equals("MY") != false) goto L394;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1298:0x053e, code lost:
        if (r3.equals("MX") != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1300:0x0545, code lost:
        return new int[]{2, 4, 3, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1314:0x0576, code lost:
        if (r3.equals("MT") != false) goto L412;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1317:0x0580, code lost:
        if (r3.equals("MS") != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1324:0x0598, code lost:
        if (r3.equals("MQ") != false) goto L422;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1327:0x05a2, code lost:
        if (r3.equals("MP") != false) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1346:0x05e4, code lost:
        if (r3.equals("MK") != false) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1361:0x0618, code lost:
        if (r3.equals("ME") != false) goto L458;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1364:0x0622, code lost:
        if (r3.equals("MD") != false) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1371:0x063a, code lost:
        if (r3.equals("MA") != false) goto L228;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1374:0x0644, code lost:
        if (r3.equals("LY") != false) goto L272;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1377:0x064e, code lost:
        if (r3.equals("LV") != false) goto L412;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1384:0x0666, code lost:
        if (r3.equals("LT") != false) goto L412;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1399:0x069a, code lost:
        if (r3.equals("LI") != false) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1402:0x06a4, code lost:
        if (r3.equals("LC") != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1409:0x06bc, code lost:
        if (r3.equals("LA") != false) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1411:0x06c3, code lost:
        return new int[]{2, 2, 1, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1417:0x06d8, code lost:
        if (r3.equals("KY") != false) goto L506;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1428:0x06fe, code lost:
        if (r3.equals("KP") != false) goto L228;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1431:0x0708, code lost:
        if (r3.equals("KM") != false) goto L272;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1434:0x0711, code lost:
        if (r3.equals("KI") != false) goto L272;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1436:0x0718, code lost:
        return new int[]{4, 2, 4, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1454:0x0757, code lost:
        if (r3.equals("JO") != false) goto L458;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1456:0x075e, code lost:
        return new int[]{1, 0, 0, 1, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1458:0x0765, code lost:
        if (r3.equals("JM") != false) goto L542;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1469:0x078b, code lost:
        if (r3.equals("IS") != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1471:0x0792, code lost:
        return new int[]{0, 0, 0, 0, 0, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1477:0x07a7, code lost:
        if (r3.equals("IQ") != false) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1479:0x07ae, code lost:
        return new int[]{3, 3, 3, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1481:0x07b5, code lost:
        if (r3.equals("IO") != false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1496:0x07e9, code lost:
        if (r3.equals("IE") != false) goto L576;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1507:0x080f, code lost:
        if (r3.equals("HT") != false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1510:0x0819, code lost:
        if (r3.equals("HR") != false) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1513:0x0822, code lost:
        if (r3.equals("HN") != false) goto L236;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1515:0x0829, code lost:
        return new int[]{3, 2, 3, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1521:0x083e, code lost:
        if (r3.equals("GY") != false) goto L598;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1524:0x0848, code lost:
        if (r3.equals("GW") != false) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1526:0x084f, code lost:
        return new int[]{3, 4, 3, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1528:0x0856, code lost:
        if (r3.equals("GU") != false) goto L604;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1535:0x086e, code lost:
        if (r3.equals("GR") != false) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1537:0x0875, code lost:
        return new int[]{1, 0, 0, 0, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1543:0x088a, code lost:
        if (r3.equals("GP") != false) goto L422;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1550:0x08a1, code lost:
        if (r3.equals("GM") != false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1552:0x08a8, code lost:
        return new int[]{4, 2, 2, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1554:0x08af, code lost:
        if (r3.equals("GL") != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1557:0x08b9, code lost:
        if (r3.equals("GI") != false) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1564:0x08d1, code lost:
        if (r3.equals("GG") != false) goto L634;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1567:0x08db, code lost:
        if (r3.equals("GF") != false) goto L422;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1569:0x08e2, code lost:
        return new int[]{2, 1, 2, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1575:0x08f7, code lost:
        if (r3.equals("GD") != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1590:0x092b, code lost:
        if (r3.equals("FO") != false) goto L634;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1597:0x0943, code lost:
        if (r3.equals("FK") != false) goto L228;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1599:0x094a, code lost:
        return new int[]{3, 2, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1613:0x097b, code lost:
        if (r3.equals("ES") != false) goto L576;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1615:0x0982, code lost:
        return new int[]{0, 1, 1, 1, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1617:0x0989, code lost:
        if (r3.equals("ER") != false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1619:0x0990, code lost:
        return new int[]{4, 2, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1625:0x09a5, code lost:
        if (r3.equals("EE") != false) goto L412;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1627:0x09ac, code lost:
        return new int[]{0, 0, 0, 0, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1633:0x09c1, code lost:
        if (r3.equals("DZ") != false) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1636:0x09cb, code lost:
        if (r3.equals("DO") != false) goto L542;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1638:0x09d2, code lost:
        return new int[]{3, 4, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1640:0x09d9, code lost:
        if (r3.equals("DM") != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1655:0x0a0d, code lost:
        if (r3.equals("CZ") != false) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1662:0x0a25, code lost:
        if (r3.equals("CX") != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1673:0x0a4b, code lost:
        if (r3.equals("CU") != false) goto L332;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1675:0x0a52, code lost:
        return new int[]{4, 4, 3, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1689:0x0a83, code lost:
        if (r3.equals("CM") != false) goto L740;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1692:0x0a8d, code lost:
        if (r3.equals("CL") != false) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1694:0x0a94, code lost:
        return new int[]{1, 1, 2, 2, 3, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1708:0x0ac5, code lost:
        if (r3.equals("BW") != false) goto L598;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1710:0x0acc, code lost:
        return new int[]{3, 4, 1, 0, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1716:0x0ae1, code lost:
        if (r3.equals("BI") != false) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1718:0x0ae8, code lost:
        return new int[]{4, 3, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1724:0x0afd, code lost:
        if (r3.equals("BG") != false) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1726:0x0b04, code lost:
        return new int[]{0, 0, 0, 0, 1, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1736:0x0b27, code lost:
        if (r3.equals("BD") != false) goto L394;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1738:0x0b2e, code lost:
        return new int[]{2, 1, 3, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1740:0x0b35, code lost:
        if (r3.equals("AZ") != false) goto L384;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1742:0x0b3c, code lost:
        return new int[]{3, 2, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1744:0x0b43, code lost:
        if (r3.equals("AO") != false) goto L740;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1746:0x0b4a, code lost:
        return new int[]{3, 4, 3, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1748:0x0b51, code lost:
        if (r3.equals("AI") != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1750:0x0b58, code lost:
        return new int[]{1, 2, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1756:0x0b6d, code lost:
        if (r3.equals("AF") != false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1758:0x0b74, code lost:
        return new int[]{4, 4, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1764:0x0b89, code lost:
        if (r3.equals("AD") != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1766:0x0b90, code lost:
        return new int[]{1, 2, 0, 0, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1776:0x0bb3, code lost:
        if (r3.equals("BB") != false) goto L634;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1778:0x0bba, code lost:
        return new int[]{0, 2, 0, 0, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1780:0x0bc1, code lost:
        if (r3.equals("BA") != false) goto L506;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1783:0x0bca, code lost:
        if (r3.equals("AX") != false) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1785:0x0bd1, code lost:
        return new int[]{0, 2, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1787:0x0bd8, code lost:
        if (r3.equals("AW") != false) goto L604;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1789:0x0bdf, code lost:
        return new int[]{1, 2, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:1795:0x0bf4, code lost:
        if (r3.equals("AL") != false) goto L506;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1797:0x0bfb, code lost:
        return new int[]{1, 2, 0, 1, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:930:0x004d, code lost:
        if (r3.equals("CH") != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:933:0x0057, code lost:
        if (r3.equals("CG") != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:948:0x008b, code lost:
        if (r3.equals("BR") != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:963:0x00bf, code lost:
        if (r3.equals("BM") != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:966:0x00c9, code lost:
        if (r3.equals("BL") != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:973:0x00e1, code lost:
        if (r3.equals("AT") != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:984:0x0107, code lost:
        if (r3.equals("AQ") != false) goto L90;
     */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] m745p(java.lang.String r3) {
        /*
            Method dump skipped, instructions count: 6534
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3156we.m745p(java.lang.String):int[]");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2659du
    /* renamed from: a */
    public final synchronized void mo760a(C2642dd c2642dd, boolean z, int i) {
        if (m746o(c2642dd, z)) {
            this.f9284o += i;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2659du
    /* renamed from: b */
    public final synchronized void mo759b(C2642dd c2642dd, boolean z) {
        if (m746o(c2642dd, z)) {
            C2616ce.m2685h(this.f9282m > 0);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i = (int) (elapsedRealtime - this.f9283n);
            this.f9286q += i;
            long j = this.f9287r;
            long j2 = this.f9284o;
            this.f9287r = j + j2;
            if (i > 0) {
                this.f9279j.m709a((int) Math.sqrt(j2), (((float) j2) * 8000.0f) / i);
                if (this.f9286q >= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS || this.f9287r >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                    this.f9288s = this.f9279j.m707c();
                }
                m748m(i, this.f9284o, this.f9288s);
                this.f9283n = elapsedRealtime;
                this.f9284o = 0L;
            }
            this.f9282m--;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2659du
    /* renamed from: c */
    public final void mo758c() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2659du
    /* renamed from: d */
    public final synchronized void mo757d(C2642dd c2642dd, boolean z) {
        if (m746o(c2642dd, z)) {
            if (this.f9282m == 0) {
                this.f9283n = SystemClock.elapsedRealtime();
            }
            this.f9282m++;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3153wb
    /* renamed from: e */
    public final synchronized long mo756e() {
        return this.f9288s;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3153wb
    /* renamed from: f */
    public final InterfaceC2659du mo755f() {
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3153wb
    /* renamed from: g */
    public final void mo754g(Handler handler, InterfaceC3152wa interfaceC3152wa) {
        this.f9278i.m777a(handler, interfaceC3152wa);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3153wb
    /* renamed from: h */
    public final void mo753h(InterfaceC3152wa interfaceC3152wa) {
        this.f9278i.m775c(interfaceC3152wa);
    }

    /* renamed from: i */
    public static synchronized C3156we m752i(Context context) {
        C3156we c3156we;
        synchronized (C3156we.class) {
            if (f9276g == null) {
                Context applicationContext = context == null ? null : context.getApplicationContext();
                int[] m745p = m745p(C2628cq.m2572K(context));
                HashMap hashMap = new HashMap(8);
                hashMap.put(0, 1000000L);
                avg avgVar = f9270a;
                hashMap.put(2, (Long) avgVar.get(m745p[0]));
                hashMap.put(3, (Long) f9271b.get(m745p[1]));
                hashMap.put(4, (Long) f9272c.get(m745p[2]));
                hashMap.put(5, (Long) f9273d.get(m745p[3]));
                hashMap.put(10, (Long) f9274e.get(m745p[4]));
                hashMap.put(9, (Long) f9275f.get(m745p[5]));
                hashMap.put(7, (Long) avgVar.get(m745p[0]));
                f9276g = C3161wj.m737d(applicationContext, hashMap, 2000, InterfaceC2598bn.f6252a, true);
            }
            c3156we = f9276g;
        }
        return c3156we;
    }

    public /* synthetic */ C3156we(Context context, Map map, int i, InterfaceC2598bn interfaceC2598bn, boolean z) {
        this.f9277h = avj.m4505c(map);
        this.f9278i = new C3150vz();
        this.f9279j = new C3173wv(2000);
        this.f9280k = interfaceC2598bn;
        this.f9281l = true;
        if (context != null) {
            C2619ch m2666b = C2619ch.m2666b(context);
            int m2667a = m2666b.m2667a();
            this.f9285p = m2667a;
            this.f9288s = m749l(m2667a);
            m2666b.m2664d(new C3155wd(this));
            return;
        }
        this.f9285p = 0;
        this.f9288s = m749l(0);
    }
}
