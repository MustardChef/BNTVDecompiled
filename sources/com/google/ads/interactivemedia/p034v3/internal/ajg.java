package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2506bx;
import com.google.ads.interactivemedia.p034v3.impl.data.C2476au;
import java.util.SortedSet;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ajg */
/* loaded from: classes2.dex */
final class ajg implements ako {

    /* renamed from: a */
    private final SortedSet f4224a;

    /* renamed from: b */
    private final ajx f4225b;

    /* renamed from: c */
    private final String f4226c;

    /* renamed from: d */
    private long f4227d;

    /* renamed from: e */
    private VideoProgressUpdate f4228e;

    /* renamed from: f */
    private final C2476au f4229f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ajg(ajx ajxVar, SortedSet sortedSet, String str) {
        C2476au c2476au = new C2476au();
        this.f4227d = 0L;
        this.f4228e = new VideoProgressUpdate(0L, 0L);
        this.f4224a = sortedSet;
        this.f4229f = c2476au;
        this.f4225b = ajxVar;
        this.f4226c = str;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ako
    /* renamed from: a */
    public final void mo5077a(VideoProgressUpdate videoProgressUpdate) {
        SortedSet subSet;
        if (videoProgressUpdate == null || videoProgressUpdate.getDuration() < 0.0f || videoProgressUpdate.equals(this.f4228e)) {
            return;
        }
        float currentTime = this.f4228e.getCurrentTime();
        float currentTime2 = videoProgressUpdate.getCurrentTime();
        if (currentTime < currentTime2) {
            subSet = this.f4224a.subSet(Float.valueOf(currentTime), Float.valueOf(currentTime2));
        } else {
            subSet = this.f4224a.subSet(Float.valueOf(currentTime2), Float.valueOf(currentTime));
        }
        if (!subSet.isEmpty() || this.f4224a.contains(Float.valueOf(videoProgressUpdate.getCurrentTime())) || System.currentTimeMillis() - this.f4227d >= 1000) {
            this.f4227d = System.currentTimeMillis();
            this.f4228e = videoProgressUpdate;
            this.f4225b.mo5122o(new ajq(ajo.contentTimeUpdate, ajp.contentTimeUpdate, this.f4226c, AbstractC2506bx.create(videoProgressUpdate)));
        }
    }
}
