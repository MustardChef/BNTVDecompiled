package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.google.ads.interactivemedia.p034v3.impl.data.C2518i;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.agp */
/* loaded from: classes2.dex */
public final class agp extends ContentObserver {

    /* renamed from: a */
    private final Context f4006a;

    /* renamed from: b */
    private final AudioManager f4007b;

    /* renamed from: c */
    private float f4008c;

    /* renamed from: d */
    private final agx f4009d;

    /* renamed from: e */
    private final C2518i f4010e;

    public agp(Handler handler, Context context, C2518i c2518i, agx agxVar, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(handler);
        this.f4006a = context;
        this.f4007b = (AudioManager) context.getSystemService("audio");
        this.f4010e = c2518i;
        this.f4009d = agxVar;
    }

    /* renamed from: c */
    private final float m5333c() {
        int streamVolume = this.f4007b.getStreamVolume(3);
        int streamMaxVolume = this.f4007b.getStreamMaxVolume(3);
        if (streamMaxVolume <= 0 || streamVolume <= 0) {
            return 0.0f;
        }
        float f = streamVolume / streamMaxVolume;
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    /* renamed from: d */
    private final void m5332d() {
        this.f4009d.m5298d(this.f4008c);
    }

    /* renamed from: a */
    public final void m5335a() {
        this.f4008c = m5333c();
        m5332d();
        this.f4006a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    /* renamed from: b */
    public final void m5334b() {
        this.f4006a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        super.onChange(z);
        float m5333c = m5333c();
        if (m5333c != this.f4008c) {
            this.f4008c = m5333c;
            m5332d();
        }
    }
}
