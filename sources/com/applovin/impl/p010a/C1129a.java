package com.applovin.impl.p010a;

import android.net.Uri;
import com.applovin.impl.p010a.C1143j;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p027a.EnumC1528b;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p030d.C1576a;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.a.a */
/* loaded from: classes.dex */
public class C1129a extends AbstractC1537g {

    /* renamed from: a */
    private final String f179a;

    /* renamed from: b */
    private final String f180b;

    /* renamed from: c */
    private final C1139f f181c;

    /* renamed from: d */
    private final long f182d;

    /* renamed from: e */
    private final C1143j f183e;

    /* renamed from: f */
    private final C1134b f184f;

    /* renamed from: g */
    private final String f185g;

    /* renamed from: h */
    private final Set<C1140g> f186h;

    /* renamed from: i */
    private final Set<C1140g> f187i;

    /* renamed from: com.applovin.impl.a.a$a */
    /* loaded from: classes.dex */
    public static class C1131a {

        /* renamed from: a */
        private JSONObject f188a;

        /* renamed from: b */
        private JSONObject f189b;

        /* renamed from: c */
        private EnumC1528b f190c;

        /* renamed from: d */
        private C1662k f191d;

        /* renamed from: e */
        private long f192e;

        /* renamed from: f */
        private String f193f;

        /* renamed from: g */
        private String f194g;

        /* renamed from: h */
        private C1139f f195h;

        /* renamed from: i */
        private C1143j f196i;

        /* renamed from: j */
        private C1134b f197j;

        /* renamed from: k */
        private Set<C1140g> f198k;

        /* renamed from: l */
        private Set<C1140g> f199l;

        private C1131a() {
        }

        /* renamed from: a */
        public C1131a m8409a(long j) {
            this.f192e = j;
            return this;
        }

        /* renamed from: a */
        public C1131a m8407a(C1134b c1134b) {
            this.f197j = c1134b;
            return this;
        }

        /* renamed from: a */
        public C1131a m8406a(C1139f c1139f) {
            this.f195h = c1139f;
            return this;
        }

        /* renamed from: a */
        public C1131a m8405a(C1143j c1143j) {
            this.f196i = c1143j;
            return this;
        }

        /* renamed from: a */
        public C1131a m8404a(EnumC1528b enumC1528b) {
            this.f190c = enumC1528b;
            return this;
        }

        /* renamed from: a */
        public C1131a m8403a(C1662k c1662k) {
            if (c1662k != null) {
                this.f191d = c1662k;
                return this;
            }
            throw new IllegalArgumentException("No sdk specified.");
        }

        /* renamed from: a */
        public C1131a m8402a(String str) {
            this.f193f = str;
            return this;
        }

        /* renamed from: a */
        public C1131a m8401a(Set<C1140g> set) {
            this.f198k = set;
            return this;
        }

        /* renamed from: a */
        public C1131a m8400a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f188a = jSONObject;
                return this;
            }
            throw new IllegalArgumentException("No ad object specified.");
        }

        /* renamed from: a */
        public C1129a m8410a() {
            return new C1129a(this);
        }

        /* renamed from: b */
        public C1131a m8398b(String str) {
            this.f194g = str;
            return this;
        }

        /* renamed from: b */
        public C1131a m8397b(Set<C1140g> set) {
            this.f199l = set;
            return this;
        }

        /* renamed from: b */
        public C1131a m8396b(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f189b = jSONObject;
                return this;
            }
            throw new IllegalArgumentException("No full ad response specified.");
        }
    }

    /* renamed from: com.applovin.impl.a.a$b */
    /* loaded from: classes.dex */
    public enum EnumC1132b {
        COMPANION_AD,
        VIDEO
    }

    /* renamed from: com.applovin.impl.a.a$c */
    /* loaded from: classes.dex */
    public enum EnumC1133c {
        IMPRESSION,
        VIDEO_CLICK,
        COMPANION_CLICK,
        VIDEO,
        COMPANION,
        ERROR
    }

    private C1129a(C1131a c1131a) {
        super(c1131a.f188a, c1131a.f189b, c1131a.f190c, c1131a.f191d);
        this.f179a = c1131a.f193f;
        this.f181c = c1131a.f195h;
        this.f180b = c1131a.f194g;
        this.f183e = c1131a.f196i;
        this.f184f = c1131a.f197j;
        this.f186h = c1131a.f198k;
        this.f187i = c1131a.f199l;
        Uri mo7082h = mo7082h();
        this.f185g = mo7082h != null ? mo7082h.toString() : "";
        this.f182d = c1131a.f192e;
    }

    /* renamed from: a */
    private Set<C1140g> m8431a(EnumC1132b enumC1132b, String[] strArr) {
        C1134b c1134b;
        C1143j c1143j;
        if (strArr == null || strArr.length <= 0) {
            return Collections.emptySet();
        }
        Map<String, Set<C1140g>> map = null;
        if (enumC1132b == EnumC1132b.VIDEO && (c1143j = this.f183e) != null) {
            map = c1143j.m8330e();
        } else if (enumC1132b == EnumC1132b.COMPANION_AD && (c1134b = this.f184f) != null) {
            map = c1134b.m8381d();
        }
        HashSet hashSet = new HashSet();
        if (map != null && !map.isEmpty()) {
            for (String str : strArr) {
                if (map.containsKey(str)) {
                    hashSet.addAll(map.get(str));
                }
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* renamed from: aS */
    public static C1131a m8423aS() {
        return new C1131a();
    }

    /* renamed from: aT */
    private String m8422aT() {
        String stringFromAdObject = getStringFromAdObject("vimp_url", null);
        if (stringFromAdObject != null) {
            return stringFromAdObject.replace(Utils.MACRO_CLCODE, getClCode());
        }
        return null;
    }

    /* renamed from: aU */
    private C1143j.EnumC1145a m8421aU() {
        C1143j.EnumC1145a[] values = C1143j.EnumC1145a.values();
        int intValue = ((Integer) this.sdk.m6656a(C1568b.f1900ek)).intValue();
        return (intValue < 0 || intValue >= values.length) ? C1143j.EnumC1145a.UNSPECIFIED : values[intValue];
    }

    /* renamed from: aV */
    private Set<C1140g> m8420aV() {
        C1143j c1143j = this.f183e;
        return c1143j != null ? c1143j.m8331d() : Collections.emptySet();
    }

    /* renamed from: aW */
    private Set<C1140g> m8419aW() {
        C1134b c1134b = this.f184f;
        return c1134b != null ? c1134b.m8382c() : Collections.emptySet();
    }

    @Override // com.applovin.impl.sdk.p027a.AbstractC1537g
    /* renamed from: D */
    public boolean mo7169D() {
        return getBooleanFromAdObject("video_clickable", false) && mo7081j() != null;
    }

    /* renamed from: a */
    public Set<C1140g> m8430a(EnumC1133c enumC1133c, String str) {
        return m8429a(enumC1133c, new String[]{str});
    }

    /* renamed from: a */
    public Set<C1140g> m8429a(EnumC1133c enumC1133c, String[] strArr) {
        C1710r m6588z = this.sdk.m6588z();
        m6588z.m6319b("VastAd", "Retrieving trackers of type '" + enumC1133c + "' and events '" + strArr + "'...");
        if (enumC1133c == EnumC1133c.IMPRESSION) {
            return this.f186h;
        }
        if (enumC1133c == EnumC1133c.VIDEO_CLICK) {
            return m8420aV();
        }
        if (enumC1133c == EnumC1133c.COMPANION_CLICK) {
            return m8419aW();
        }
        if (enumC1133c == EnumC1133c.VIDEO) {
            return m8431a(EnumC1132b.VIDEO, strArr);
        }
        if (enumC1133c == EnumC1133c.COMPANION) {
            return m8431a(EnumC1132b.COMPANION_AD, strArr);
        }
        if (enumC1133c == EnumC1133c.ERROR) {
            return this.f187i;
        }
        C1710r m6588z2 = this.sdk.m6588z();
        m6588z2.m6314e("VastAd", "Failed to retrieve trackers of invalid type '" + enumC1133c + "' and events '" + strArr + "'");
        return Collections.emptySet();
    }

    @Override // com.applovin.impl.sdk.p027a.AbstractC1537g
    /* renamed from: a */
    public void mo7146a() {
    }

    /* renamed from: a */
    public void m8428a(String str) {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html_template", str);
        }
    }

    /* renamed from: aO */
    public String m8427aO() {
        return getStringFromAdObject("html_template", "");
    }

    /* renamed from: aP */
    public Uri m8426aP() {
        String stringFromAdObject = getStringFromAdObject("html_template_url", null);
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    /* renamed from: aQ */
    public boolean m8425aQ() {
        return getBooleanFromAdObject("cache_companion_ad", true);
    }

    /* renamed from: aR */
    public boolean m8424aR() {
        return getBooleanFromAdObject("cache_video", true);
    }

    @Override // com.applovin.impl.sdk.p027a.AbstractC1537g
    /* renamed from: at */
    public List<C1576a> mo7106at() {
        List<C1576a> postbacks;
        synchronized (this.adObjectLock) {
            postbacks = Utils.getPostbacks("vimp_urls", this.adObject, getClCode(), CollectionUtils.map(Utils.SHOWN_OUT_OF_CONTEXT_MACRO, String.valueOf(m7114al())), m8422aT(), m7105au(), m7070y(), this.sdk);
        }
        return postbacks;
    }

    @Override // com.applovin.impl.sdk.p027a.AbstractC1537g
    /* renamed from: b */
    public JSONObject mo7099b() {
        return this.fullResponse;
    }

    /* renamed from: c */
    public void m8418c() {
        synchronized (this.adObjectLock) {
            this.adObject.remove("vast_is_streaming");
        }
    }

    @Override // com.applovin.impl.sdk.p027a.AbstractC1537g
    /* renamed from: d */
    public String mo7089d() {
        return this.f185g;
    }

    /* renamed from: e */
    public EnumC1132b m8417e() {
        return "companion_ad".equalsIgnoreCase(getStringFromAdObject("vast_first_caching_operation", "companion_ad")) ? EnumC1132b.COMPANION_AD : EnumC1132b.VIDEO;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof C1129a) && super.equals(obj)) {
            C1129a c1129a = (C1129a) obj;
            String str = this.f179a;
            if (str == null ? c1129a.f179a == null : str.equals(c1129a.f179a)) {
                String str2 = this.f180b;
                if (str2 == null ? c1129a.f180b == null : str2.equals(c1129a.f180b)) {
                    C1139f c1139f = this.f181c;
                    if (c1139f == null ? c1129a.f181c == null : c1139f.equals(c1129a.f181c)) {
                        C1143j c1143j = this.f183e;
                        if (c1143j == null ? c1129a.f183e == null : c1143j.equals(c1129a.f183e)) {
                            C1134b c1134b = this.f184f;
                            if (c1134b == null ? c1129a.f184f == null : c1134b.equals(c1129a.f184f)) {
                                Set<C1140g> set = this.f186h;
                                if (set == null ? c1129a.f186h == null : set.equals(c1129a.f186h)) {
                                    Set<C1140g> set2 = this.f187i;
                                    Set<C1140g> set3 = c1129a.f187i;
                                    return set2 != null ? set2.equals(set3) : set3 == null;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.applovin.impl.sdk.p027a.AbstractC1537g
    /* renamed from: f */
    public boolean mo7085f() {
        return getBooleanFromAdObject("vast_is_streaming", false);
    }

    /* renamed from: g */
    public boolean m8416g() {
        return getBooleanFromAdObject("vast_immediate_ad_load", true);
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public long getCreatedAtMillis() {
        return this.f182d;
    }

    @Override // com.applovin.impl.sdk.p027a.AbstractC1537g
    /* renamed from: h */
    public Uri mo7082h() {
        C1146k m8413m = m8413m();
        if (m8413m != null) {
            return m8413m.m8324b();
        }
        return null;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public boolean hasVideoUrl() {
        List<C1146k> m8338a;
        C1143j c1143j = this.f183e;
        return (c1143j == null || (m8338a = c1143j.m8338a()) == null || m8338a.size() <= 0) ? false : true;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f179a;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f180b;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        C1139f c1139f = this.f181c;
        int hashCode4 = (hashCode3 + (c1139f != null ? c1139f.hashCode() : 0)) * 31;
        C1143j c1143j = this.f183e;
        int hashCode5 = (hashCode4 + (c1143j != null ? c1143j.hashCode() : 0)) * 31;
        C1134b c1134b = this.f184f;
        int hashCode6 = (hashCode5 + (c1134b != null ? c1134b.hashCode() : 0)) * 31;
        Set<C1140g> set = this.f186h;
        int hashCode7 = (hashCode6 + (set != null ? set.hashCode() : 0)) * 31;
        Set<C1140g> set2 = this.f187i;
        return hashCode7 + (set2 != null ? set2.hashCode() : 0);
    }

    /* renamed from: i */
    public C1139f m8415i() {
        return this.f181c;
    }

    @Override // com.applovin.impl.sdk.p027a.AbstractC1537g
    /* renamed from: j */
    public Uri mo7081j() {
        C1143j c1143j = this.f183e;
        if (c1143j != null) {
            return c1143j.m8332c();
        }
        return null;
    }

    @Override // com.applovin.impl.sdk.p027a.AbstractC1537g
    /* renamed from: k */
    public Uri mo7080k() {
        return mo7081j();
    }

    /* renamed from: l */
    public C1143j m8414l() {
        return this.f183e;
    }

    /* renamed from: m */
    public C1146k m8413m() {
        C1143j c1143j = this.f183e;
        if (c1143j != null) {
            return c1143j.m8337a(m8421aU());
        }
        return null;
    }

    /* renamed from: n */
    public C1134b m8412n() {
        return this.f184f;
    }

    /* renamed from: o */
    public boolean m8411o() {
        return getBooleanFromAdObject("vast_fire_click_trackers_on_html_clicks", false);
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public String toString() {
        return "VastAd{title='" + this.f179a + "', adDescription='" + this.f180b + "', systemInfo=" + this.f181c + ", videoCreative=" + this.f183e + ", companionAd=" + this.f184f + ", impressionTrackers=" + this.f186h + ", errorTrackers=" + this.f187i + '}';
    }
}
