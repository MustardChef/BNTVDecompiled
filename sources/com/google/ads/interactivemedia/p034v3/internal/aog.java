package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.google.ads.interactivemedia.p034v3.impl.data.C2467al;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aog */
/* loaded from: classes2.dex */
public final class aog extends ape {

    /* renamed from: h */
    private static final apf f4795h = new apf();

    /* renamed from: i */
    private final Context f4796i;

    public aog(anw anwVar, aga agaVar, int i, Context context, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "t7YLiNn9wSLVfNzBPSP796qGY15c9YWt19X86sjfqa1MN8DTMOAxKskDGE2b7plQ", "lEEnhl5euaIfSg9vXz1JH43pBH/xGM9fvSrfPaUZwEI=", agaVar, i, 29, null, null, null);
        this.f4796i = context;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ape
    /* renamed from: a */
    protected final void mo4844a() throws IllegalAccessException, InvocationTargetException {
        this.f4833g.m5445T(ExifInterface.LONGITUDE_EAST);
        AtomicReference m4842a = f4795h.m4842a(this.f4796i.getPackageName());
        if (m4842a.get() == null) {
            synchronized (m4842a) {
                if (m4842a.get() == null) {
                    m4842a.set((String) this.f4830d.invoke(null, this.f4796i));
                }
            }
        }
        String str = (String) m4842a.get();
        synchronized (this.f4833g) {
            this.f4833g.m5445T(C2467al.m6016a(str.getBytes(), true));
        }
    }
}
