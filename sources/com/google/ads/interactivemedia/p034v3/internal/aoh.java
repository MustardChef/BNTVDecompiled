package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import org.acra.ACRAConstants;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aoh */
/* loaded from: classes2.dex */
public final class aoh extends ape {

    /* renamed from: h */
    private static final apf f4797h = new apf();

    /* renamed from: i */
    private final Context f4798i;

    /* renamed from: j */
    private final afd f4799j;

    public aoh(anw anwVar, aga agaVar, int i, Context context, afd afdVar, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "iH08ecr5p8p5eQT3/BFJ6jAaJm3eLNoIe2oA7hLZl5P0jAtinrUdPK16lrJGpxBz", "Gvy6wet11FtrNaAWhnvYSI1hOQnkPBTAgqoI9PXuwaM=", agaVar, i, 27, null, null, null);
        this.f4798i = context;
        this.f4799j = afdVar;
    }

    /* renamed from: c */
    public static String m4851c(afd afdVar) {
        if (afdVar == null || !afdVar.m5647f() || anz.m4869g(afdVar.m5649d().m5639c())) {
            return null;
        }
        return afdVar.m5649d().m5639c();
    }

    /* renamed from: d */
    private final String m4850d() {
        try {
            if (this.f4827a.m4899k() != null) {
                this.f4827a.m4899k().get();
            }
            afr m4907c = this.f4827a.m4907c();
            if (m4907c == null || !m4907c.m5566ae()) {
                return null;
            }
            return m4907c.m5552f();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    /* renamed from: e */
    private final boolean m4849e() {
        return this.f4827a.m4896n();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ape
    /* renamed from: a */
    protected final void mo4844a() throws IllegalAccessException, InvocationTargetException {
        Boolean valueOf;
        int i;
        aly alyVar;
        AtomicReference m4842a = f4797h.m4842a(this.f4798i.getPackageName());
        synchronized (m4842a) {
            aly alyVar2 = (aly) m4842a.get();
            if (alyVar2 == null || anz.m4869g(alyVar2.f4418a) || alyVar2.f4418a.equals(ExifInterface.LONGITUDE_EAST) || alyVar2.f4418a.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                if (!anz.m4869g(m4851c(this.f4799j))) {
                    i = aff.f3685e;
                } else {
                    afd afdVar = this.f4799j;
                    if (!anz.m4869g(m4851c(afdVar))) {
                        valueOf = false;
                    } else {
                        valueOf = Boolean.valueOf(afdVar != null && afdVar.m5648e() && afdVar.m5650c().m5644c() == aff.f3684d);
                    }
                    if (!valueOf.booleanValue() || !m4849e()) {
                        i = aff.f3683c;
                    } else {
                        i = aff.f3684d;
                    }
                }
                Boolean valueOf2 = Boolean.valueOf(i == aff.f3683c);
                Boolean bool = (Boolean) aql.f4892e.m4770f();
                String m4852b = ((Boolean) aql.f4891d.m4770f()).booleanValue() ? m4852b() : null;
                if (bool.booleanValue() && m4849e() && anz.m4869g(m4852b)) {
                    m4852b = m4850d();
                }
                aly alyVar3 = new aly((String) this.f4830d.invoke(null, this.f4798i, valueOf2, m4852b));
                if (anz.m4869g(alyVar3.f4418a) || alyVar3.f4418a.equals(ExifInterface.LONGITUDE_EAST)) {
                    int i2 = i - 1;
                    if (i == 0) {
                        throw null;
                    }
                    if (i2 == 3) {
                        String m4850d = m4850d();
                        if (!anz.m4869g(m4850d)) {
                            alyVar3.f4418a = m4850d;
                        }
                    } else if (i2 == 4) {
                        alyVar3.f4418a = this.f4799j.m5649d().m5639c();
                    }
                }
                m4842a.set(alyVar3);
            }
            alyVar = (aly) m4842a.get();
        }
        synchronized (this.f4833g) {
            if (alyVar != null) {
                this.f4833g.m5426ab(alyVar.f4418a);
                this.f4833g.m5436aB(alyVar.f4419b);
                this.f4833g.m5434aD(alyVar.f4420c);
                this.f4833g.m5450O(alyVar.f4421d);
                this.f4833g.m5427aa(alyVar.f4422e);
            }
        }
    }

    /* renamed from: b */
    protected final String m4852b() {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance(ACRAConstants.DEFAULT_CERTIFICATE_TYPE);
            byte[] m4867i = anz.m4867i((String) aql.f4893f.m4770f());
            ArrayList arrayList = new ArrayList();
            arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(m4867i)));
            if (!Build.TYPE.equals("user")) {
                arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(anz.m4867i((String) aql.f4894g.m4770f()))));
            }
            Context context = this.f4798i;
            String packageName = context.getPackageName();
            this.f4827a.m4900j();
            if (Build.VERSION.SDK_INT > 30 || Build.VERSION.CODENAME.equals(ExifInterface.LATITUDE_SOUTH)) {
                final ayv m4312q = ayv.m4312q();
                context.getPackageManager().requestChecksums(packageName, false, 8, arrayList, new PackageManager.OnChecksumsReadyListener() { // from class: com.google.ads.interactivemedia.v3.internal.apg
                    @Override // android.content.pm.PackageManager.OnChecksumsReadyListener
                    public final void onChecksumsReady(List list) {
                        ayv ayvVar = ayv.this;
                        if (list == null) {
                            ayvVar.mo4313k(null);
                            return;
                        }
                        try {
                            int size = list.size();
                            for (int i = 0; i < size; i++) {
                                ApkChecksum apkChecksum = (ApkChecksum) list.get(i);
                                if (apkChecksum.getType() == 8) {
                                    ayvVar.mo4313k(anz.m4873c(apkChecksum.getValue()));
                                    return;
                                }
                            }
                            ayvVar.mo4313k(null);
                        } catch (Throwable unused) {
                            ayvVar.mo4313k(null);
                        }
                    }
                });
                return (String) m4312q.get();
            }
            return null;
        } catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException unused) {
            return null;
        }
    }
}
