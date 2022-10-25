package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.ads.interactivemedia.p034v3.api.player.ContentProgressProvider;
import com.google.ads.interactivemedia.p034v3.api.player.VideoProgressUpdate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.akp */
/* loaded from: classes2.dex */
public final class akp {

    /* renamed from: a */
    protected final ContentProgressProvider f4311a;

    /* renamed from: b */
    private final Handler f4312b;

    /* renamed from: c */
    private final List f4313c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public akp(ContentProgressProvider contentProgressProvider) {
        this();
        this.f4311a = contentProgressProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public final void m5089g() {
        VideoProgressUpdate m5090f = m5090f();
        for (ako akoVar : this.f4313c) {
            akoVar.mo5077a(m5090f);
        }
        this.f4312b.postDelayed(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.akn
            @Override // java.lang.Runnable
            public final void run() {
                akp.this.m5089g();
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final void m5094b(ako akoVar) {
        this.f4313c.add(akoVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final void m5093c(ako akoVar) {
        this.f4313c.remove(akoVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final void m5092d() {
        m5091e();
        m5089g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public final void m5091e() {
        this.f4312b.removeCallbacksAndMessages(null);
    }

    /* renamed from: f */
    public final VideoProgressUpdate m5090f() {
        VideoProgressUpdate contentProgress = this.f4311a.getContentProgress();
        if (contentProgress == null) {
            Log.w("IMASDK", "ContentProgressProvider.getContentProgress() is null. Use VideoProgressUpdate.VIDEO_TIME_NOT_READY instead.");
            return VideoProgressUpdate.VIDEO_TIME_NOT_READY;
        }
        return contentProgress;
    }

    akp() {
        this.f4313c = new ArrayList(1);
        this.f4312b = new Handler(Looper.getMainLooper());
    }
}
