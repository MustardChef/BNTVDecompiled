package com.google.ads.interactivemedia.p034v3.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aly */
/* loaded from: classes2.dex */
public final class aly extends alx {

    /* renamed from: a */
    public String f4418a;

    /* renamed from: b */
    public long f4419b;

    /* renamed from: c */
    public String f4420c;

    /* renamed from: d */
    public String f4421d;

    /* renamed from: e */
    public String f4422e;

    public aly() {
        this.f4418a = ExifInterface.LONGITUDE_EAST;
        this.f4419b = -1L;
        this.f4420c = ExifInterface.LONGITUDE_EAST;
        this.f4421d = ExifInterface.LONGITUDE_EAST;
        this.f4422e = ExifInterface.LONGITUDE_EAST;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.alx
    /* renamed from: b */
    protected final HashMap mo4862b() {
        HashMap hashMap = new HashMap();
        hashMap.put(0, this.f4418a);
        hashMap.put(4, this.f4422e);
        hashMap.put(3, this.f4421d);
        hashMap.put(2, this.f4420c);
        hashMap.put(1, Long.valueOf(this.f4419b));
        return hashMap;
    }

    public aly(String str) {
        String str2 = ExifInterface.LONGITUDE_EAST;
        this.f4418a = ExifInterface.LONGITUDE_EAST;
        this.f4419b = -1L;
        this.f4420c = ExifInterface.LONGITUDE_EAST;
        this.f4421d = ExifInterface.LONGITUDE_EAST;
        this.f4422e = ExifInterface.LONGITUDE_EAST;
        HashMap a = m5009a(str);
        if (a != null) {
            this.f4418a = a.get(0) == null ? ExifInterface.LONGITUDE_EAST : (String) a.get(0);
            this.f4419b = a.get(1) != null ? ((Long) a.get(1)).longValue() : -1L;
            this.f4420c = a.get(2) == null ? ExifInterface.LONGITUDE_EAST : (String) a.get(2);
            this.f4421d = a.get(3) == null ? ExifInterface.LONGITUDE_EAST : (String) a.get(3);
            this.f4422e = a.get(4) != null ? (String) a.get(4) : str2;
        }
    }
}
