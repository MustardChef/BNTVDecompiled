package com.applovin.impl.adview;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.adview.u */
/* loaded from: classes.dex */
public class C1316u {

    /* renamed from: a */
    private final int f755a;

    /* renamed from: b */
    private final int f756b;

    /* renamed from: c */
    private final int f757c;

    /* renamed from: d */
    private final int f758d;

    /* renamed from: e */
    private final boolean f759e;

    /* renamed from: f */
    private final int f760f;

    /* renamed from: g */
    private final int f761g;

    /* renamed from: h */
    private final int f762h;

    /* renamed from: i */
    private final float f763i;

    /* renamed from: j */
    private final float f764j;

    public C1316u(JSONObject jSONObject, C1662k c1662k) {
        C1710r m6588z = c1662k.m6588z();
        m6588z.m6317c("VideoButtonProperties", "Updating video button properties with JSON = " + JsonUtils.maybeConvertToIndentedString(jSONObject));
        this.f755a = JsonUtils.getInt(jSONObject, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 64);
        this.f756b = JsonUtils.getInt(jSONObject, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 7);
        this.f757c = JsonUtils.getInt(jSONObject, "margin", 20);
        this.f758d = JsonUtils.getInt(jSONObject, "gravity", 85);
        this.f759e = JsonUtils.getBoolean(jSONObject, "tap_to_fade", false).booleanValue();
        this.f760f = JsonUtils.getInt(jSONObject, "tap_to_fade_duration_milliseconds", 500);
        this.f761g = JsonUtils.getInt(jSONObject, "fade_in_duration_milliseconds", 500);
        this.f762h = JsonUtils.getInt(jSONObject, "fade_out_duration_milliseconds", 500);
        this.f763i = JsonUtils.getFloat(jSONObject, "fade_in_delay_seconds", 1.0f);
        this.f764j = JsonUtils.getFloat(jSONObject, "fade_out_delay_seconds", 6.0f);
    }

    /* renamed from: a */
    public int m7889a() {
        return this.f755a;
    }

    /* renamed from: b */
    public int m7888b() {
        return this.f756b;
    }

    /* renamed from: c */
    public int m7887c() {
        return this.f757c;
    }

    /* renamed from: d */
    public int m7886d() {
        return this.f758d;
    }

    /* renamed from: e */
    public boolean m7885e() {
        return this.f759e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1316u c1316u = (C1316u) obj;
        return this.f755a == c1316u.f755a && this.f756b == c1316u.f756b && this.f757c == c1316u.f757c && this.f758d == c1316u.f758d && this.f759e == c1316u.f759e && this.f760f == c1316u.f760f && this.f761g == c1316u.f761g && this.f762h == c1316u.f762h && Float.compare(c1316u.f763i, this.f763i) == 0 && Float.compare(c1316u.f764j, this.f764j) == 0;
    }

    /* renamed from: f */
    public long m7884f() {
        return this.f760f;
    }

    /* renamed from: g */
    public long m7883g() {
        return this.f761g;
    }

    /* renamed from: h */
    public long m7882h() {
        return this.f762h;
    }

    public int hashCode() {
        int i = ((((((((((((((this.f755a * 31) + this.f756b) * 31) + this.f757c) * 31) + this.f758d) * 31) + (this.f759e ? 1 : 0)) * 31) + this.f760f) * 31) + this.f761g) * 31) + this.f762h) * 31;
        float f = this.f763i;
        int floatToIntBits = (i + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
        float f2 = this.f764j;
        return floatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0);
    }

    /* renamed from: i */
    public float m7881i() {
        return this.f763i;
    }

    /* renamed from: j */
    public float m7880j() {
        return this.f764j;
    }

    public String toString() {
        return "VideoButtonProperties{widthPercentOfScreen=" + this.f755a + ", heightPercentOfScreen=" + this.f756b + ", margin=" + this.f757c + ", gravity=" + this.f758d + ", tapToFade=" + this.f759e + ", tapToFadeDurationMillis=" + this.f760f + ", fadeInDurationMillis=" + this.f761g + ", fadeOutDurationMillis=" + this.f762h + ", fadeInDelay=" + this.f763i + ", fadeOutDelay=" + this.f764j + '}';
    }
}
