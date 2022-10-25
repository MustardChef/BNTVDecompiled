package com.applovin.impl.sdk.p027a;

import android.text.TextUtils;
import android.util.Base64;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.utils.StringUtils;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.a.c */
/* loaded from: classes.dex */
public class C1529c {

    /* renamed from: a */
    private final C1662k f1479a;

    /* renamed from: b */
    private final String f1480b;

    /* renamed from: com.applovin.impl.sdk.a.c$a */
    /* loaded from: classes.dex */
    public enum EnumC1530a {
        UNSPECIFIED("UNSPECIFIED"),
        REGULAR("REGULAR"),
        AD_RESPONSE_JSON("AD_RESPONSE_JSON");
        

        /* renamed from: d */
        private final String f1485d;

        EnumC1530a(String str) {
            this.f1485d = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f1485d;
        }
    }

    public C1529c(String str, C1662k c1662k) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Identifier is empty");
        }
        if (c1662k == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f1480b = str;
        this.f1479a = c1662k;
    }

    /* renamed from: a */
    private String m7222a(C1568b<String> c1568b) {
        for (String str : this.f1479a.m6625b(c1568b)) {
            if (this.f1480b.startsWith(str)) {
                return str;
            }
        }
        return null;
    }

    /* renamed from: a */
    public String m7223a() {
        return this.f1480b;
    }

    /* renamed from: b */
    public EnumC1530a m7221b() {
        return m7222a(C1568b.f1677aW) != null ? EnumC1530a.REGULAR : m7222a(C1568b.f1678aX) != null ? EnumC1530a.AD_RESPONSE_JSON : EnumC1530a.UNSPECIFIED;
    }

    /* renamed from: c */
    public String m7220c() {
        String m7222a = m7222a(C1568b.f1677aW);
        if (TextUtils.isEmpty(m7222a)) {
            String m7222a2 = m7222a(C1568b.f1678aX);
            if (TextUtils.isEmpty(m7222a2)) {
                return null;
            }
            return m7222a2;
        }
        return m7222a;
    }

    /* renamed from: d */
    public JSONObject m7219d() {
        if (m7221b() == EnumC1530a.AD_RESPONSE_JSON) {
            try {
                try {
                    JSONObject jSONObject = new JSONObject(new String(Base64.decode(this.f1480b.substring(m7220c().length()), 0), "UTF-8"));
                    C1710r m6588z = this.f1479a.m6588z();
                    m6588z.m6319b("AdToken", "Decoded token into ad response: " + jSONObject);
                    return jSONObject;
                } catch (JSONException e) {
                    C1710r m6588z2 = this.f1479a.m6588z();
                    m6588z2.m6318b("AdToken", "Unable to decode token '" + this.f1480b + "' into JSON", e);
                    return null;
                }
            } catch (UnsupportedEncodingException e2) {
                C1710r m6588z3 = this.f1479a.m6588z();
                m6588z3.m6318b("AdToken", "Unable to process ad response from token '" + this.f1480b + "'", e2);
                return null;
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1529c) {
            String str = this.f1480b;
            String str2 = ((C1529c) obj).f1480b;
            return str != null ? str.equals(str2) : str2 == null;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f1480b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        String prefixToIndex = StringUtils.prefixToIndex(32, this.f1480b);
        return "AdToken{id=" + prefixToIndex + ", type=" + m7221b() + '}';
    }
}
