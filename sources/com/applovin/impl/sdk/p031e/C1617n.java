package com.applovin.impl.sdk.p031e;

import android.app.Activity;
import androidx.exifinterface.media.ExifInterface;
import com.applovin.impl.sdk.C1648h;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.utils.C1757j;
import com.applovin.impl.sdk.utils.C1762n;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinSdk;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.e.n */
/* loaded from: classes.dex */
public class C1617n extends AbstractRunnableC1589a {

    /* renamed from: a */
    private final C1662k f2104a;

    public C1617n(C1662k c1662k) {
        super("TaskInitializeSdk", c1662k);
        this.f2104a = c1662k;
    }

    /* renamed from: a */
    private void m6798a() {
        if (this.f2104a.m6685B().m7343a()) {
            return;
        }
        Activity m6628al = this.f2104a.m6628al();
        if (m6628al != null) {
            this.f2104a.m6685B().m7342a(m6628al);
        } else {
            this.f2104a.m6670Q().m6792a(new C1642y(this.f2104a, true, new Runnable() { // from class: com.applovin.impl.sdk.e.n.2
                @Override // java.lang.Runnable
                public void run() {
                    C1617n.this.f2104a.m6685B().m7342a(C1617n.this.f2104a.m6636ad().m7240a());
                }
            }), C1620o.EnumC1622a.MAIN, TimeUnit.SECONDS.toMillis(1L));
        }
    }

    /* renamed from: b */
    private void m6796b() {
        String str;
        if (this.f2104a.m6611e()) {
            return;
        }
        boolean m6994d = this.f2104a.m6678I().m6994d();
        if (m6994d) {
            str = this.f2104a.m6667T().m6543j().f2334b + " (use this for test devices)";
        } else {
            str = "<Enable verbose logging to see the GAID to use for test devices - https://monetization-support.applovin.com/hc/en-us/articles/236114328-How-can-I-expose-verbose-logging-for-the-SDK>";
        }
        Map<String, Object> m6549d = this.f2104a.m6667T().m6549d();
        Map<String, Object> m6551c = this.f2104a.m6667T().m6551c();
        C1757j c1757j = new C1757j();
        c1757j.m6200a().m6195a("=====AppLovin SDK=====");
        c1757j.m6195a("===SDK Versions===").m6194a("Version", AppLovinSdk.VERSION).m6194a("Plugin Version", this.f2104a.m6656a(C1568b.f1863dz)).m6194a("Ad Review Version", Utils.getSafedkVersion());
        c1757j.m6195a("===Device Info===").m6194a("OS", Utils.getAndroidOSInfo()).m6194a("GAID", str).m6194a(ExifInterface.TAG_MODEL, m6549d.get("model")).m6194a("Locale", m6549d.get("locale")).m6194a("Emulator", m6549d.get("sim")).m6194a("WVVC", m6549d.get("wvvc"));
        c1757j.m6195a("===App Info===").m6194a("Application ID", m6551c.get("package_name")).m6194a("Target SDK", m6551c.get("target_sdk")).m6194a("ExoPlayer Version", Integer.valueOf(Utils.tryToGetExoPlayerVersionCode()));
        c1757j.m6195a("===SDK Settings===").m6194a("SDK Key", this.f2104a.m6590x()).m6194a("Mediation Provider", this.f2104a.m6595s()).m6194a("TG", C1762n.m6165a(this.f2104a)).m6194a("Test Mode On", Boolean.valueOf(this.f2104a.m6679H().m7351a())).m6194a("Verbose Logging On", Boolean.valueOf(m6994d));
        c1757j.m6195a("===Privacy States===\nPlease review AppLovin MAX documentation to be compliant with regional privacy policies.").m6195a(C1648h.m6722a(m6877f()));
        c1757j.m6200a();
        C1710r.m6313f("AppLovinSdk", c1757j.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0147, code lost:
        if (r12.f2104a.m6613d() != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0191, code lost:
        if (r12.f2104a.m6613d() == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0194, code lost:
        r2 = "failed";
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0195, code lost:
        r8.append(r2);
        r8.append(" in ");
        r8.append(java.lang.System.currentTimeMillis() - r6);
        r8.append("ms");
        m6884a(r8.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x01ad, code lost:
        return;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 517
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p031e.C1617n.run():void");
    }
}
