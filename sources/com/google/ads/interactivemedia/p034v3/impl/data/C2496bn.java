package com.google.ads.interactivemedia.p034v3.impl.data;

import android.util.Log;
import com.google.ads.interactivemedia.p034v3.internal.brf;
import com.google.ads.interactivemedia.p034v3.internal.brh;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.bn */
/* loaded from: classes2.dex */
public final class C2496bn {
    public double adBreakDuration;
    public String adBreakTime;
    public List<Float> adCuePoints;
    public C2509c adData;
    public double adPeriodDuration;
    public C2513d adPodInfo;
    public int adPosition;
    public long adTimeUpdateMs;
    public double bufferedTime;
    public Map<String, CompanionData> companions;
    public List<AbstractC2483ba> cuepoints;
    public double currentTime;
    public boolean disableAppSetId;
    public double duration;
    public boolean enableGks;
    public boolean enableInstrumentation;
    public int errorCode;
    public String errorMessage;
    public Integer espAdapterTimeoutMs;
    public List<String> espAdapters;
    public String eventId;
    public String innerError;
    public SortedSet<Float> internalCuePoints;

    /* renamed from: ln */
    public String f2853ln;
    public C2495bm logData;

    /* renamed from: m */
    public String f2854m;
    public boolean monitorAppLifecycle;

    /* renamed from: n */
    public String f2855n;
    public AbstractC2499bq networkRequest;
    public String queryId;
    public ResizeAndPositionVideoMsgData resizeAndPositionVideo;
    public double seekTime;
    public String streamId;
    public String streamUrl;
    public List<HashMap<String, String>> subtitles;
    public int totalAds;
    public String url;
    public String vastEvent;
    public String videoUrl;

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return brf.m2729c(this, obj, new String[0]);
    }

    public int hashCode() {
        return brh.m2722a(this, new String[0]);
    }

    public String toString() {
        Field[] fields;
        StringBuilder sb = new StringBuilder();
        sb.append("JavaScriptMsgData[");
        for (Field field : C2496bn.class.getFields()) {
            try {
                Object obj = field.get(this);
                sb.append(field.getName());
                sb.append(":");
                sb.append(obj);
                sb.append(",");
            } catch (IllegalAccessException e) {
                Log.e("IMASDK", "IllegalAccessException occurred", e);
            } catch (IllegalArgumentException e2) {
                Log.e("IMASDK", "IllegalArgumentException occurred", e2);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
