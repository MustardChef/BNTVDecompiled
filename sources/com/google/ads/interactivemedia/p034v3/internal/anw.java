package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import com.google.ads.interactivemedia.p034v3.impl.data.C2467al;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.anw */
/* loaded from: classes2.dex */
public final class anw {

    /* renamed from: d */
    private static final String f4741d = "anw";

    /* renamed from: a */
    protected final Context f4742a;

    /* renamed from: e */
    private ExecutorService f4745e;

    /* renamed from: f */
    private DexClassLoader f4746f;

    /* renamed from: g */
    private ani f4747g;

    /* renamed from: h */
    private byte[] f4748h;

    /* renamed from: l */
    private final boolean f4752l;

    /* renamed from: o */
    private amu f4755o;

    /* renamed from: p */
    private final Map f4756p;

    /* renamed from: r */
    private anq f4758r;

    /* renamed from: i */
    private volatile AdvertisingIdClient f4749i = null;

    /* renamed from: j */
    private volatile boolean f4750j = false;

    /* renamed from: k */
    private Future f4751k = null;

    /* renamed from: m */
    private volatile afr f4753m = null;

    /* renamed from: n */
    private Future f4754n = null;

    /* renamed from: b */
    protected boolean f4743b = false;

    /* renamed from: c */
    protected boolean f4744c = false;

    /* renamed from: q */
    private boolean f4757q = false;

    private anw(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f4752l = applicationContext != null;
        context = applicationContext != null ? applicationContext : context;
        this.f4742a = context;
        this.f4756p = new HashMap();
        if (this.f4758r != null) {
            return;
        }
        this.f4758r = new anq(context);
    }

    /* renamed from: t */
    public static anw m4890t(Context context, boolean z) {
        anw anwVar = new anw(context);
        try {
            anwVar.f4745e = Executors.newCachedThreadPool(new ant());
            anwVar.f4750j = z;
            if (z) {
                anwVar.f4751k = anwVar.f4745e.submit(new anv(anwVar, 1));
            }
            anwVar.f4745e.execute(new anv(anwVar, 0));
            try {
                GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.getInstance();
                anwVar.f4743b = googleApiAvailabilityLight.getApkVersion(anwVar.f4742a) > 0;
                anwVar.f4744c = googleApiAvailabilityLight.isGooglePlayServicesAvailable(anwVar.f4742a) == 0;
            } catch (Throwable unused) {
            }
            anwVar.m4891s(0);
            if (anz.m4870f() && ((Boolean) aql.f4907t.m4770f()).booleanValue()) {
                throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
            }
            anwVar.f4747g = new ani();
            try {
            } catch (anh e) {
                throw new ano(e);
            }
        } catch (ano unused2) {
        }
        try {
            byte[] m6015b = C2467al.m6015b("BcJJ7m9GnDZ5QH3kvN4kRXKQduFKSe4hbLIA7qGtn8k=", false);
            if (m6015b.length != 32) {
                throw new anh();
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(m6015b, 4, 16).get(bArr);
            for (int i = 0; i < 16; i++) {
                bArr[i] = (byte) (bArr[i] ^ 68);
            }
            anwVar.f4748h = bArr;
            try {
                try {
                    File cacheDir = anwVar.f4742a.getCacheDir();
                    if (cacheDir == null && (cacheDir = anwVar.f4742a.getDir("dex", 0)) == null) {
                        throw new ano();
                    }
                    File file = new File(String.format("%s/%s.jar", cacheDir, "1633031840514"));
                    if (!file.exists()) {
                        byte[] m4916b = anwVar.f4747g.m4916b(anwVar.f4748h, "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");
                        file.createNewFile();
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(m4916b, 0, m4916b.length);
                        fileOutputStream.close();
                    }
                    anwVar.m4885y(cacheDir);
                    try {
                        anwVar.f4746f = new DexClassLoader(file.getAbsolutePath(), cacheDir.getAbsolutePath(), null, anwVar.f4742a.getClassLoader());
                        m4886x(file);
                        anwVar.m4884z(cacheDir);
                        anwVar.m4888v(String.format("%s/%s.dex", cacheDir, "1633031840514"));
                        anwVar.f4755o = new amu(anwVar);
                        anwVar.f4757q = true;
                        return anwVar;
                    } catch (Throwable th) {
                        m4886x(file);
                        anwVar.m4884z(cacheDir);
                        anwVar.m4888v(String.format("%s/%s.dex", cacheDir, "1633031840514"));
                        throw th;
                    }
                } catch (FileNotFoundException e2) {
                    throw new ano(e2);
                } catch (IOException e3) {
                    throw new ano(e3);
                }
            } catch (anh e4) {
                throw new ano(e4);
            } catch (NullPointerException e5) {
                throw new ano(e5);
            }
        } catch (IllegalArgumentException e6) {
            throw new anh(e6);
        }
    }

    /* renamed from: v */
    private final void m4888v(String str) {
        m4886x(new File(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public final void m4887w() {
        try {
            if (this.f4749i == null && this.f4752l) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.f4742a);
                advertisingIdClient.start();
                this.f4749i = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.f4749i = null;
        }
    }

    /* renamed from: x */
    private static final void m4886x(File file) {
        if (file.exists()) {
            file.delete();
        } else {
            Log.d(f4741d, String.format("File %s not found. No need for deletion", file.getAbsolutePath()));
        }
    }

    /* renamed from: y */
    private final void m4885y(File file) {
        FileOutputStream fileOutputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, "1633031840514"));
        if (!file2.exists()) {
            return;
        }
        File file3 = new File(String.format("%s/%s.dex", file, "1633031840514"));
        if (file3.exists()) {
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            long length = file2.length();
            if (length <= 0) {
                m4886x(file2);
                return;
            }
            byte[] bArr = new byte[(int) length];
            FileInputStream fileInputStream2 = new FileInputStream(file2);
            try {
                try {
                    if (fileInputStream2.read(bArr) <= 0) {
                        Log.d(f4741d, "Cannot read the cache data.");
                        m4886x(file2);
                        try {
                            fileInputStream2.close();
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    try {
                        try {
                            afu m5526b = afu.m5526b(bArr, bmr.m3341a());
                            if ("1633031840514".equals(new String(m5526b.m5522f().m3509C())) && Arrays.equals(m5526b.m5524d().m3509C(), ama.m5004d(m5526b.m5525c().m3509C())) && Arrays.equals(m5526b.m5523e().m3509C(), Build.VERSION.SDK.getBytes())) {
                                byte[] m4916b = this.f4747g.m4916b(this.f4748h, new String(m5526b.m5525c().m3509C()));
                                file3.createNewFile();
                                fileOutputStream = new FileOutputStream(file3);
                                try {
                                    fileOutputStream.write(m4916b, 0, m4916b.length);
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException unused2) {
                                    }
                                    try {
                                        fileOutputStream.close();
                                        return;
                                    } catch (IOException unused3) {
                                        return;
                                    }
                                } catch (anh | IOException | NoSuchAlgorithmException unused4) {
                                    fileInputStream = fileInputStream2;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException unused5) {
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                            return;
                                        } catch (IOException unused6) {
                                            return;
                                        }
                                    }
                                    return;
                                } catch (Throwable th) {
                                    th = th;
                                    fileInputStream = fileInputStream2;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException unused7) {
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException unused8) {
                                        }
                                    }
                                    throw th;
                                }
                            }
                            m4886x(file2);
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused9) {
                            }
                        } catch (IOException unused10) {
                        }
                    } catch (NullPointerException unused11) {
                        fileInputStream2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (anh | IOException | NoSuchAlgorithmException unused12) {
                fileOutputStream = null;
            }
        } catch (anh | IOException | NoSuchAlgorithmException unused13) {
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    /* renamed from: z */
    private final void m4884z(File file) {
        Throwable th;
        FileOutputStream fileOutputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, "1633031840514"));
        if (file2.exists()) {
            return;
        }
        File file3 = new File(String.format("%s/%s.dex", file, "1633031840514"));
        if (!file3.exists()) {
            return;
        }
        long length = file3.length();
        if (length <= 0) {
            return;
        }
        byte[] bArr = new byte[(int) length];
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file3);
            try {
                if (fileInputStream2.read(bArr) <= 0) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused) {
                    }
                    m4886x(file3);
                    return;
                }
                System.out.print("test");
                System.out.print("test");
                System.out.print("test");
                aga m5517l = afu.m5517l();
                m5517l.m5396g(bls.m3504t(Build.VERSION.SDK.getBytes()));
                m5517l.m5395h(bls.m3504t("1633031840514".getBytes()));
                byte[] bytes = this.f4747g.m4917a(this.f4748h, bArr).getBytes();
                m5517l.m5398e(bls.m3504t(bytes));
                m5517l.m5397f(bls.m3504t(ama.m5004d(bytes)));
                file2.createNewFile();
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] mo3176ar = ((afu) m5517l.mo3179aR()).mo3176ar();
                    fileOutputStream.write(mo3176ar, 0, mo3176ar.length);
                    fileOutputStream.close();
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused2) {
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                    }
                    m4886x(file3);
                } catch (anh | IOException | NoSuchAlgorithmException unused4) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused6) {
                        }
                    }
                    m4886x(file3);
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused7) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused8) {
                        }
                    }
                    m4886x(file3);
                    throw th;
                }
            } catch (anh | IOException | NoSuchAlgorithmException unused9) {
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (anh | IOException | NoSuchAlgorithmException unused10) {
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    /* renamed from: a */
    public final int m4909a() {
        if (this.f4755o != null) {
            return amu.m4984d();
        }
        return Integer.MIN_VALUE;
    }

    /* renamed from: b */
    public final Context m4908b() {
        return this.f4742a;
    }

    /* renamed from: c */
    public final afr m4907c() {
        return this.f4753m;
    }

    /* renamed from: d */
    public final amu m4906d() {
        return this.f4755o;
    }

    /* renamed from: e */
    public final ani m4905e() {
        return this.f4747g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public final anq m4904f() {
        return this.f4758r;
    }

    /* renamed from: g */
    public final AdvertisingIdClient m4903g() {
        if (this.f4750j) {
            if (this.f4749i != null) {
                return this.f4749i;
            }
            Future future = this.f4751k;
            if (future != null) {
                try {
                    future.get(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
                    this.f4751k = null;
                } catch (InterruptedException | ExecutionException unused) {
                } catch (TimeoutException unused2) {
                    this.f4751k.cancel(true);
                }
            }
            return this.f4749i;
        }
        return null;
    }

    /* renamed from: h */
    public final DexClassLoader m4902h() {
        return this.f4746f;
    }

    /* renamed from: i */
    public final Method m4901i(String str, String str2) {
        apd apdVar = (apd) this.f4756p.get(new Pair(str, str2));
        if (apdVar == null) {
            return null;
        }
        return apdVar.m4847a();
    }

    /* renamed from: j */
    public final ExecutorService m4900j() {
        return this.f4745e;
    }

    /* renamed from: k */
    public final Future m4899k() {
        return this.f4754n;
    }

    /* renamed from: n */
    public final boolean m4896n() {
        return this.f4744c;
    }

    /* renamed from: o */
    public final boolean m4895o() {
        return this.f4743b;
    }

    /* renamed from: p */
    public final boolean m4894p() {
        return this.f4757q;
    }

    /* renamed from: q */
    public final boolean m4893q() {
        return this.f4758r.m4912a();
    }

    /* renamed from: r */
    public final byte[] m4892r() {
        return this.f4748h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public final void m4891s(int i) {
        if (this.f4744c) {
            Future<?> submit = this.f4745e.submit(new anu(this, i));
            if (i == 0) {
                this.f4754n = submit;
            }
        }
    }

    /* renamed from: u */
    public final void m4889u(String str, String str2, Class... clsArr) {
        if (this.f4756p.containsKey(new Pair(str, str2))) {
            return;
        }
        this.f4756p.put(new Pair(str, str2), new apd(this, str, str2, clsArr));
    }
}
