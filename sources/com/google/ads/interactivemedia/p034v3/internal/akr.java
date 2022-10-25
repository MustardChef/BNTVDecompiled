package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.util.Log;
import com.google.ads.interactivemedia.p034v3.api.AdEvent;
import com.google.ads.interactivemedia.p034v3.api.CuePoint;
import com.google.ads.interactivemedia.p034v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.p034v3.api.StreamManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.akr */
/* loaded from: classes2.dex */
public final class akr extends ajb implements StreamManager {

    /* renamed from: a */
    private final String f4315a;

    /* renamed from: b */
    private List f4316b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public akr(String str, ajx ajxVar, StreamDisplayContainer streamDisplayContainer, aku akuVar, ahz ahzVar, akm akmVar, aji ajiVar, Context context, String str2, boolean z) {
        super(str, ajxVar, akuVar, streamDisplayContainer, ahzVar, akmVar, ajiVar, context, z);
        this.f4316b = new ArrayList();
        this.f4315a = str2;
        akuVar.m5072k();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ajb, com.google.ads.interactivemedia.p034v3.internal.ajv
    /* renamed from: b */
    public final void mo5088b(aju ajuVar) {
        aku akuVar = (aku) m5176c();
        AdEvent.AdEventType adEventType = AdEvent.AdEventType.ALL_ADS_COMPLETED;
        int ordinal = ajuVar.f4250a.ordinal();
        if (ordinal == 3) {
            akuVar.m5069n();
        } else if (ordinal == 4) {
            this.f4316b = ajuVar.f4253d;
        } else if (ordinal == 14) {
            double d = ajuVar.f4255f;
            StringBuilder sb = new StringBuilder(54);
            sb.append("Seek time when ad is skipped: ");
            sb.append(d);
            Log.i("IMASDK", sb.toString());
            akuVar.m5071l(Math.round(ajuVar.f4255f * 1000.0d));
        } else if (ordinal == 15) {
            akuVar.m5070m(ajuVar.f4251b);
        } else {
            switch (ordinal) {
                case 23:
                    akuVar.m5075e();
                    break;
                case 24:
                    akuVar.m5076b();
                    break;
                case 25:
                    akuVar.m5073j();
                    break;
                case 26:
                    akuVar.m5074i();
                    break;
            }
        }
        super.mo5088b(ajuVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ajb, com.google.ads.interactivemedia.p034v3.api.BaseManager
    public final void destroy() {
        super.destroy();
        m5173n(ajp.contentComplete);
        m5175l();
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamManager
    public final double getContentTimeForStreamTime(double d) {
        double d2 = d;
        for (CuePoint cuePoint : this.f4316b) {
            if (cuePoint.getStartTime() > cuePoint.getEndTime()) {
                return 0.0d;
            }
            if (d >= cuePoint.getEndTime()) {
                d2 -= cuePoint.getEndTime() - cuePoint.getStartTime();
            } else if (d < cuePoint.getEndTime() && d > cuePoint.getStartTime()) {
                d2 -= d - cuePoint.getStartTime();
            }
        }
        return d2;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamManager
    public final long getContentTimeMsForStreamTimeMs(long j) {
        long j2 = j;
        for (CuePoint cuePoint : this.f4316b) {
            if (cuePoint.getStartTimeMs() > cuePoint.getEndTimeMs()) {
                return 0L;
            }
            if (j >= cuePoint.getEndTimeMs()) {
                j2 -= cuePoint.getEndTimeMs() - cuePoint.getStartTimeMs();
            } else if (j < cuePoint.getEndTimeMs() && j > cuePoint.getStartTimeMs()) {
                j2 -= j - cuePoint.getStartTimeMs();
            }
        }
        return j2;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamManager
    public final List<CuePoint> getCuePoints() {
        return Collections.unmodifiableList(this.f4316b);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamManager
    public final CuePoint getPreviousCuePointForStreamTime(double d) {
        CuePoint cuePoint = null;
        for (CuePoint cuePoint2 : this.f4316b) {
            if (cuePoint2.getStartTime() < d) {
                cuePoint = cuePoint2;
            }
        }
        return cuePoint;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamManager
    public final CuePoint getPreviousCuePointForStreamTimeMs(long j) {
        CuePoint cuePoint = null;
        for (CuePoint cuePoint2 : this.f4316b) {
            if (cuePoint2.getStartTimeMs() < j) {
                cuePoint = cuePoint2;
            }
        }
        return cuePoint;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamManager
    public final String getStreamId() {
        return this.f4315a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamManager
    public final double getStreamTimeForContentTime(double d) {
        double d2 = d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        for (CuePoint cuePoint : this.f4316b) {
            if (cuePoint.getStartTime() > cuePoint.getEndTime()) {
                return 0.0d;
            }
            d3 += cuePoint.getStartTime() - d4;
            if (d3 > d) {
                return d2;
            }
            d2 += cuePoint.getEndTime() - cuePoint.getStartTime();
            d4 = cuePoint.getEndTime();
        }
        return d2;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamManager
    public final long getStreamTimeMsForContentTimeMs(long j) {
        long j2 = j;
        long j3 = 0;
        long j4 = 0;
        for (CuePoint cuePoint : this.f4316b) {
            if (cuePoint.getStartTimeMs() > cuePoint.getEndTimeMs()) {
                return 0L;
            }
            j3 += cuePoint.getStartTimeMs() - j4;
            if (j3 > j) {
                return j2;
            }
            j2 += cuePoint.getEndTimeMs() - cuePoint.getStartTimeMs();
            j4 = cuePoint.getEndTimeMs();
        }
        return j2;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.BaseManager
    public final boolean isCustomPlaybackUsed() {
        return true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamManager
    public final void replaceAdTagParameters(Map<String, String> map) {
        if (map == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("adTagParameters", map);
        m5174m(ajo.adsManager, ajp.replaceAdTagParameters, hashMap);
    }
}
