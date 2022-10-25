package com.applovin.impl.sdk.p031e;

import android.net.Uri;
import android.os.Bundle;
import androidx.browser.trusted.sharing.ShareTarget;
import com.applovin.impl.mediation.C1514h;
import com.applovin.impl.mediation.p013a.AbstractC1334a;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1706p;
import com.applovin.impl.sdk.network.C1684b;
import com.applovin.impl.sdk.network.C1688c;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p030d.C1584d;
import com.applovin.impl.sdk.p030d.C1585e;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.applovin.impl.sdk.e.c */
/* loaded from: classes.dex */
public abstract class AbstractC1594c extends AbstractRunnableC1589a implements C1514h.InterfaceC1515a {

    /* renamed from: a */
    protected final AbstractC1537g f2064a;

    /* renamed from: c */
    private AppLovinAdLoadListener f2065c;

    /* renamed from: d */
    private final C1706p f2066d;

    /* renamed from: e */
    private final Collection<Character> f2067e;

    /* renamed from: f */
    private final C1585e f2068f;

    /* renamed from: g */
    private boolean f2069g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC1594c(String str, AbstractC1537g abstractC1537g, C1662k c1662k, AppLovinAdLoadListener appLovinAdLoadListener) {
        super(str, c1662k);
        if (abstractC1537g == null) {
            throw new IllegalArgumentException("No ad specified.");
        }
        this.f2064a = abstractC1537g;
        this.f2065c = appLovinAdLoadListener;
        this.f2066d = c1662k.m6662Y();
        this.f2067e = m6846j();
        this.f2068f = new C1585e();
    }

    /* renamed from: a */
    private Uri m6862a(Uri uri, String str) {
        StringBuilder sb;
        String str2;
        if (uri != null) {
            String uri2 = uri.toString();
            if (StringUtils.isValidString(uri2)) {
                m6884a("Caching " + str + " image...");
                return m6849g(uri2);
            }
            sb = new StringBuilder();
            sb.append("Failed to cache ");
            sb.append(str);
            str2 = " image";
        } else {
            sb = new StringBuilder();
            sb.append("No ");
            sb.append(str);
            str2 = " image to cache";
        }
        sb.append(str2);
        m6884a(sb.toString());
        return null;
    }

    /* renamed from: a */
    private Uri m6858a(String str, String str2) {
        StringBuilder sb;
        String replace = str2.replace("/", "_");
        String m7162K = this.f2064a.m7162K();
        if (StringUtils.isValidString(m7162K)) {
            replace = m7162K + replace;
        }
        File m6346a = this.f2066d.m6346a(replace, this.f2058b.m6677J());
        if (m6346a == null) {
            return null;
        }
        if (m6346a.exists()) {
            this.f2068f.m6907b(m6346a.length());
            sb = new StringBuilder();
        } else {
            if (!this.f2066d.m6348a(m6346a, str + str2, Arrays.asList(str), this.f2068f)) {
                return null;
            }
            sb = new StringBuilder();
        }
        sb.append("file://");
        sb.append(m6346a.getAbsolutePath());
        return Uri.parse(sb.toString());
    }

    /* renamed from: g */
    private Uri m6849g(String str) {
        return m6853b(str, this.f2064a.m7163J(), true);
    }

    /* renamed from: j */
    private Collection<Character> m6846j() {
        HashSet hashSet = new HashSet();
        for (char c : ((String) this.f2058b.m6656a(C1568b.f1742bi)).toCharArray()) {
            hashSet.add(Character.valueOf(c));
        }
        hashSet.add('\"');
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Uri m6855a(String str, List<String> list, boolean z) {
        String str2;
        if (StringUtils.isValidString(str)) {
            m6884a("Caching video " + str + "...");
            String m6352a = this.f2066d.m6352a(m6877f(), str, this.f2064a.m7162K(), list, z, this.f2068f);
            if (!StringUtils.isValidString(m6352a)) {
                m6879d("Failed to cache video");
                m6848h();
                Bundle bundle = new Bundle();
                bundle.putLong("ad_id", this.f2064a.getAdIdNumber());
                bundle.putInt("load_response_code", this.f2068f.m6899j());
                Exception m6900i = this.f2068f.m6900i();
                if (m6900i != null) {
                    bundle.putString("load_exception_message", m6900i.getMessage());
                }
                this.f2058b.m6634af().m6731a(bundle, "video_caching_failed");
                return null;
            }
            File m6346a = this.f2066d.m6346a(m6352a, m6877f());
            if (m6346a != null) {
                Uri fromFile = Uri.fromFile(m6346a);
                if (fromFile != null) {
                    m6884a("Finish caching video for ad #" + this.f2064a.getAdIdNumber() + ". Updating ad with cachedVideoFilename = " + m6352a);
                    return fromFile;
                }
                str2 = "Unable to create URI from cached video file = " + m6346a;
            } else {
                str2 = "Unable to cache video = " + str + "Video file was missing or null";
            }
            m6879d(str2);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public String m6857a(String str, List<String> list) {
        if (StringUtils.isValidString(str)) {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                m6884a("Nothing to cache, skipping...");
                return null;
            }
            String lastPathSegment = parse.getLastPathSegment();
            if (StringUtils.isValidString(this.f2064a.m7162K())) {
                lastPathSegment = this.f2064a.m7162K() + lastPathSegment;
            }
            File m6346a = this.f2066d.m6346a(lastPathSegment, m6877f());
            ByteArrayOutputStream m6349a = (m6346a == null || !m6346a.exists()) ? null : this.f2066d.m6349a(m6346a);
            if (m6349a == null) {
                m6349a = this.f2066d.m6345a(str, list, true, this.f2068f);
                if (m6349a != null) {
                    this.f2066d.m6350a(m6349a, m6346a);
                    this.f2068f.m6910a(m6349a.size());
                }
            } else {
                this.f2068f.m6907b(m6349a.size());
            }
            try {
                return m6349a.toString("UTF-8");
            } catch (UnsupportedEncodingException e) {
                m6883a("UTF-8 encoding not supported.", e);
            } catch (Throwable th) {
                m6883a("String resource at " + str + " failed to load.", th);
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x002e, code lost:
        continue;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m6856a(java.lang.String r10, java.util.List<java.lang.String> r11, com.applovin.impl.sdk.p027a.AbstractC1537g r12) {
        /*
            r9 = this;
            boolean r0 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r10)
            if (r0 != 0) goto L7
            return r10
        L7:
            com.applovin.impl.sdk.k r0 = r9.f2058b
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r1 = com.applovin.impl.sdk.p029c.C1568b.f1743bj
            java.lang.Object r0 = r0.m6656a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L1d
            java.lang.String r11 = "Resource caching is disabled, skipping cache..."
            r9.m6884a(r11)
            return r10
        L1d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r10)
            boolean r1 = r12.shouldCancelHtmlCachingIfShown()
            boolean r2 = r12.m7126aN()
            java.util.Iterator r11 = r11.iterator()
        L2e:
            boolean r3 = r11.hasNext()
            if (r3 == 0) goto Lf6
            java.lang.Object r3 = r11.next()
            java.lang.String r3 = (java.lang.String) r3
            r4 = 0
            r5 = 0
        L3c:
            int r6 = r0.length()
            if (r4 >= r6) goto L2e
            boolean r4 = r9.m6854b()
            if (r4 == 0) goto L49
            return r10
        L49:
            int r4 = r0.indexOf(r3, r5)
            r5 = -1
            if (r4 != r5) goto L51
            goto L2e
        L51:
            int r5 = r0.length()
            r6 = r4
        L56:
            java.util.Collection<java.lang.Character> r7 = r9.f2067e
            char r8 = r0.charAt(r6)
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            boolean r7 = r7.contains(r8)
            if (r7 != 0) goto L6b
            if (r6 >= r5) goto L6b
            int r6 = r6 + 1
            goto L56
        L6b:
            if (r6 <= r4) goto Lf0
            if (r6 == r5) goto Lf0
            int r5 = r3.length()
            int r5 = r5 + r4
            java.lang.String r5 = r0.substring(r5, r6)
            boolean r7 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r5)
            if (r7 == 0) goto Le2
            if (r1 == 0) goto L91
            boolean r7 = r12.hasShown()
            if (r7 == 0) goto L91
            java.lang.String r11 = "Cancelling HTML caching due to ad being shown already"
            r9.m6884a(r11)
            com.applovin.impl.sdk.d.e r11 = r9.f2068f
            r11.m6912a()
            return r10
        L91:
            if (r2 == 0) goto Lc6
            java.lang.String r7 = r12.mo7089d()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r3)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto Lc6
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Postponing caching for \""
            r7.append(r8)
            r7.append(r5)
            java.lang.String r5 = "\" video resource"
        Lbb:
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r9.m6884a(r5)
            goto Led
        Lc6:
            android.net.Uri r5 = r9.m6858a(r3, r5)
            if (r5 == 0) goto Ldc
            java.lang.String r7 = r5.toString()
            r0.replace(r4, r6, r7)
            r12.m7097b(r5)
            com.applovin.impl.sdk.d.e r5 = r9.f2068f
            r5.m6904e()
            goto Led
        Ldc:
            com.applovin.impl.sdk.d.e r5 = r9.f2068f
            r5.m6903f()
            goto Led
        Le2:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Skip caching of non-resource "
            r7.append(r8)
            goto Lbb
        Led:
            r5 = r6
            goto L3c
        Lf0:
            java.lang.String r11 = "Unable to cache resource; ad HTML is invalid."
            r9.m6879d(r11)
            return r10
        Lf6:
            java.lang.String r10 = r0.toString()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p031e.AbstractC1594c.m6856a(java.lang.String, java.util.List, com.applovin.impl.sdk.a.g):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m6863a() {
        this.f2058b.m6681F().m7275b(this);
    }

    @Override // com.applovin.impl.mediation.C1514h.InterfaceC1515a
    /* renamed from: a */
    public void mo6843a(AbstractC1334a abstractC1334a) {
        if (abstractC1334a.m7813e().equalsIgnoreCase(this.f2064a.m7160M())) {
            m6879d("Updating flag for timeout...");
            this.f2069g = true;
        }
        this.f2058b.m6681F().m7275b(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m6861a(AppLovinAdBase appLovinAdBase) {
        C1584d.m6922a(this.f2068f, appLovinAdBase, this.f2058b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public Uri m6853b(String str, List<String> list, boolean z) {
        String str2;
        try {
            String m6352a = this.f2066d.m6352a(m6877f(), str, this.f2064a.m7162K(), list, z, this.f2068f);
            if (StringUtils.isValidString(m6352a)) {
                File m6346a = this.f2066d.m6346a(m6352a, m6877f());
                if (m6346a != null) {
                    Uri fromFile = Uri.fromFile(m6346a);
                    if (fromFile != null) {
                        return fromFile;
                    }
                    str2 = "Unable to extract Uri from image file";
                } else {
                    str2 = "Unable to retrieve File from cached image filename = " + m6352a;
                }
                m6879d(str2);
                return null;
            }
            return null;
        } catch (Throwable th) {
            m6883a("Failed to cache image at url = " + str, th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public boolean m6854b() {
        return this.f2069g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m6852c() {
        m6884a("Caching mute images...");
        Uri m6862a = m6862a(this.f2064a.m7135aE(), "mute");
        if (m6862a != null) {
            this.f2064a.m7092c(m6862a);
        }
        Uri m6862a2 = m6862a(this.f2064a.m7134aF(), "unmute");
        if (m6862a2 != null) {
            this.f2064a.m7088d(m6862a2);
        }
        m6884a("Ad updated with muteImageFilename = " + this.f2064a.m7135aE() + ", unmuteImageFilename = " + this.f2064a.m7134aF());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public Uri m6851e(String str) {
        return m6855a(str, this.f2064a.m7163J(), true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public String m6850f(final String str) {
        if (StringUtils.isValidString(str)) {
            C1688c mo6395a = C1688c.m6487a(this.f2058b).mo6391a(str).mo6384b(ShareTarget.METHOD_GET).mo6392a((C1688c.C1689a) "").mo6394a(0).mo6395a();
            final AtomicReference atomicReference = new AtomicReference(null);
            this.f2058b.m6671P().m6508a(mo6395a, new C1684b.C1685a(), new C1684b.InterfaceC1687c<String>() { // from class: com.applovin.impl.sdk.e.c.1
                @Override // com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
                /* renamed from: a */
                public void mo6491a(int i, String str2, String str3) {
                    AbstractC1594c abstractC1594c = AbstractC1594c.this;
                    abstractC1594c.m6879d("Failed to load resource from '" + str + "'");
                }

                @Override // com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
                /* renamed from: a */
                public void mo6490a(String str2, int i) {
                    atomicReference.set(str2);
                }
            });
            String str2 = (String) atomicReference.get();
            if (str2 != null) {
                this.f2068f.m6910a(str2.length());
            }
            return str2;
        }
        return null;
    }

    /* renamed from: h */
    void m6848h() {
        AppLovinAdLoadListener appLovinAdLoadListener = this.f2065c;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES);
            this.f2065c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public void m6847i() {
        m6884a("Rendered new ad:" + this.f2064a);
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.e.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (AbstractC1594c.this.f2065c != null) {
                    AbstractC1594c.this.f2065c.adReceived(AbstractC1594c.this.f2064a);
                    AbstractC1594c.this.f2065c = null;
                }
            }
        });
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f2064a.m7161L()) {
            m6884a("Subscribing to timeout events...");
            this.f2058b.m6681F().m7276a(this);
        }
    }
}
