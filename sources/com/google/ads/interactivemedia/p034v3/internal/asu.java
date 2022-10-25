package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.ads.interactivemedia.p034v3.impl.data.C2472aq;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.asu */
/* loaded from: classes2.dex */
public final class asu {

    /* renamed from: a */
    private static final Object f5014a = new Object();

    /* renamed from: b */
    private final Context f5015b;

    /* renamed from: c */
    private final SharedPreferences f5016c;

    /* renamed from: d */
    private final String f5017d;

    /* renamed from: e */
    private final asg f5018e;

    /* renamed from: f */
    private boolean f5019f;

    public asu(Context context, int i, asg asgVar, boolean z) {
        this.f5019f = false;
        this.f5015b = context;
        this.f5017d = Integer.toString(aph.m4840b(i));
        this.f5016c = context.getSharedPreferences("pcvmspf", 0);
        this.f5018e = asgVar;
        this.f5019f = z;
    }

    /* renamed from: e */
    private final File m4656e(String str) {
        return new File(new File(this.f5015b.getDir("pccache", 0), this.f5017d), str);
    }

    /* renamed from: f */
    private static String m4655f(C2557api c2557api) {
        apj m4826d = apk.m4826d();
        m4826d.m4830e(c2557api.m4837c().m4820k());
        m4826d.m4834a(c2557api.m4837c().m4821j());
        m4826d.m4833b(c2557api.m4837c().m4829a());
        m4826d.m4831d(c2557api.m4837c().m4827c());
        m4826d.m4832c(c2557api.m4837c().m4828b());
        return Hex.bytesToStringLowercase(((apk) m4826d.mo3179aR()).mo3177ap().m3509C());
    }

    /* renamed from: g */
    private final String m4654g() {
        String valueOf = String.valueOf(this.f5017d);
        return valueOf.length() != 0 ? "FBAMTD".concat(valueOf) : new String("FBAMTD");
    }

    /* renamed from: h */
    private final String m4653h() {
        String valueOf = String.valueOf(this.f5017d);
        return valueOf.length() != 0 ? "LATMTD".concat(valueOf) : new String("LATMTD");
    }

    /* renamed from: i */
    private final void m4652i(int i, long j) {
        asg asgVar = this.f5018e;
        if (asgVar != null) {
            asgVar.mo4691a(i, j);
        }
    }

    /* renamed from: j */
    private final void m4651j(int i, long j, String str) {
        asg asgVar = this.f5018e;
        if (asgVar != null) {
            asgVar.mo4690b(i, j, str);
        }
    }

    /* renamed from: k */
    private final apk m4650k(int i) {
        String string;
        bmr m3340b;
        if (i == 1) {
            string = this.f5016c.getString(m4653h(), null);
        } else {
            string = this.f5016c.getString(m4654g(), null);
        }
        if (string == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            bls m3504t = bls.m3504t(Hex.stringToBytes(string));
            if (this.f5019f) {
                m3340b = bmr.m3341a();
            } else {
                m3340b = bmr.m3340b();
            }
            return apk.m4822h(m3504t, m3340b);
        } catch (bnm unused) {
            return null;
        } catch (NullPointerException unused2) {
            m4652i(2029, currentTimeMillis);
            return null;
        } catch (RuntimeException unused3) {
            m4652i(2032, currentTimeMillis);
            return null;
        }
    }

    /* renamed from: a */
    public final boolean m4660a(C2557api c2557api) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (f5014a) {
            if (!C2472aq.m6005d(new File(m4656e(c2557api.m4837c().m4820k()), "pcbc"), c2557api.m4836d().m3509C())) {
                m4652i(4020, currentTimeMillis);
                return false;
            }
            String m4655f = m4655f(c2557api);
            SharedPreferences.Editor edit = this.f5016c.edit();
            edit.putString(m4653h(), m4655f);
            boolean commit = edit.commit();
            if (commit) {
                m4652i(5015, currentTimeMillis);
            } else {
                m4652i(4021, currentTimeMillis);
            }
            return commit;
        }
    }

    /* renamed from: b */
    public final boolean m4659b(C2557api c2557api, InterfaceC2563ast interfaceC2563ast) {
        File[] listFiles;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (f5014a) {
            apk m4650k = m4650k(1);
            String m4820k = c2557api.m4837c().m4820k();
            if (m4650k == null || !m4650k.m4820k().equals(m4820k)) {
                long currentTimeMillis2 = System.currentTimeMillis();
                File m4656e = m4656e(m4820k);
                if (m4656e.exists()) {
                    String str = true != m4656e.isDirectory() ? "0" : "1";
                    String str2 = true != m4656e.isFile() ? "0" : "1";
                    StringBuilder sb = new StringBuilder(str.length() + 5 + str2.length());
                    sb.append("d:");
                    sb.append(str);
                    sb.append(",f:");
                    sb.append(str2);
                    m4651j(4023, currentTimeMillis2, sb.toString());
                    m4652i(4015, currentTimeMillis2);
                } else if (!m4656e.mkdirs()) {
                    String str3 = true != m4656e.canWrite() ? "0" : "1";
                    m4651j(4024, currentTimeMillis2, str3.length() != 0 ? "cw:".concat(str3) : new String("cw:"));
                    m4652i(4015, currentTimeMillis2);
                    return false;
                }
                File m4656e2 = m4656e(m4820k);
                File file = new File(m4656e2, "pcam.jar");
                File file2 = new File(m4656e2, "pcbc");
                if (!C2472aq.m6005d(file, c2557api.m4835e().m3509C())) {
                    m4652i(4016, currentTimeMillis);
                    return false;
                } else if (C2472aq.m6005d(file2, c2557api.m4836d().m3509C())) {
                    if (interfaceC2563ast.mo4661a(file)) {
                        String m4655f = m4655f(c2557api);
                        long currentTimeMillis3 = System.currentTimeMillis();
                        String string = this.f5016c.getString(m4653h(), null);
                        SharedPreferences.Editor edit = this.f5016c.edit();
                        edit.putString(m4653h(), m4655f);
                        if (string != null) {
                            edit.putString(m4654g(), string);
                        }
                        if (edit.commit()) {
                            HashSet hashSet = new HashSet();
                            apk m4650k2 = m4650k(1);
                            if (m4650k2 != null) {
                                hashSet.add(m4650k2.m4820k());
                            }
                            apk m4650k3 = m4650k(2);
                            if (m4650k3 != null) {
                                hashSet.add(m4650k3.m4820k());
                            }
                            for (File file3 : new File(this.f5015b.getDir("pccache", 0), this.f5017d).listFiles()) {
                                if (!hashSet.contains(file3.getName())) {
                                    C2472aq.m6006c(file3);
                                }
                            }
                            m4652i(5014, currentTimeMillis);
                            return true;
                        }
                        m4652i(4019, currentTimeMillis3);
                        return false;
                    }
                    m4652i(4018, currentTimeMillis);
                    C2472aq.m6006c(m4656e2);
                    return false;
                } else {
                    m4652i(4017, currentTimeMillis);
                    return false;
                }
            }
            m4652i(4014, currentTimeMillis);
            return false;
        }
    }

    /* renamed from: c */
    public final asp m4658c(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (f5014a) {
            apk m4650k = m4650k(1);
            if (m4650k == null) {
                m4652i(4022, currentTimeMillis);
                return null;
            }
            File m4656e = m4656e(m4650k.m4820k());
            File file = new File(m4656e, "pcam.jar");
            if (!file.exists()) {
                file = new File(m4656e, "pcam");
            }
            File file2 = new File(m4656e, "pcbc");
            File file3 = new File(m4656e, "pcopt");
            m4652i(5016, currentTimeMillis);
            return new asp(m4650k, file, file2, file3);
        }
    }

    /* renamed from: d */
    public final boolean m4657d(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (f5014a) {
            apk m4650k = m4650k(1);
            if (m4650k == null) {
                m4652i(4025, currentTimeMillis);
                return false;
            }
            File m4656e = m4656e(m4650k.m4820k());
            if (!new File(m4656e, "pcam.jar").exists()) {
                m4652i(4026, currentTimeMillis);
                return false;
            } else if (!new File(m4656e, "pcbc").exists()) {
                m4652i(4027, currentTimeMillis);
                return false;
            } else {
                m4652i(5019, currentTimeMillis);
                return true;
            }
        }
    }
}
