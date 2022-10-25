package com.applovin.impl.p010a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.utils.C1766p;
import com.applovin.impl.sdk.utils.StringUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Locale;

/* renamed from: com.applovin.impl.a.k */
/* loaded from: classes.dex */
public class C1146k {

    /* renamed from: a */
    private Uri f268a;

    /* renamed from: b */
    private Uri f269b;

    /* renamed from: c */
    private EnumC1147a f270c;

    /* renamed from: d */
    private String f271d;

    /* renamed from: e */
    private int f272e;

    /* renamed from: f */
    private int f273f;

    /* renamed from: g */
    private int f274g;

    /* renamed from: com.applovin.impl.a.k$a */
    /* loaded from: classes.dex */
    public enum EnumC1147a {
        Progressive,
        Streaming
    }

    private C1146k() {
    }

    /* renamed from: a */
    private static EnumC1147a m8325a(String str) {
        if (StringUtils.isValidString(str)) {
            if ("progressive".equalsIgnoreCase(str)) {
                return EnumC1147a.Progressive;
            }
            if ("streaming".equalsIgnoreCase(str)) {
                return EnumC1147a.Streaming;
            }
        }
        return EnumC1147a.Progressive;
    }

    /* renamed from: a */
    public static C1146k m8326a(C1766p c1766p, C1662k c1662k) {
        if (c1766p != null) {
            if (c1662k != null) {
                try {
                    String m6150c = c1766p.m6150c();
                    if (!URLUtil.isValidUrl(m6150c)) {
                        c1662k.m6588z().m6314e("VastVideoFile", "Unable to create video file. Could not find URL.");
                        return null;
                    }
                    Uri parse = Uri.parse(m6150c);
                    C1146k c1146k = new C1146k();
                    c1146k.f268a = parse;
                    c1146k.f269b = parse;
                    c1146k.f274g = StringUtils.parseInt(c1766p.m6152b().get("bitrate"));
                    c1146k.f270c = m8325a(c1766p.m6152b().get("delivery"));
                    c1146k.f273f = StringUtils.parseInt(c1766p.m6152b().get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
                    c1146k.f272e = StringUtils.parseInt(c1766p.m6152b().get(ViewHierarchyConstants.DIMENSION_WIDTH_KEY));
                    c1146k.f271d = c1766p.m6152b().get("type").toLowerCase(Locale.ENGLISH);
                    return c1146k;
                } catch (Throwable th) {
                    c1662k.m6588z().m6318b("VastVideoFile", "Error occurred while initializing", th);
                    return null;
                }
            }
            throw new IllegalArgumentException("No sdk specified.");
        }
        throw new IllegalArgumentException("No node specified.");
    }

    /* renamed from: a */
    public Uri m8328a() {
        return this.f268a;
    }

    /* renamed from: a */
    public void m8327a(Uri uri) {
        this.f269b = uri;
    }

    /* renamed from: b */
    public Uri m8324b() {
        return this.f269b;
    }

    /* renamed from: c */
    public String m8323c() {
        return this.f271d;
    }

    /* renamed from: d */
    public int m8322d() {
        return this.f274g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1146k) {
            C1146k c1146k = (C1146k) obj;
            if (this.f272e == c1146k.f272e && this.f273f == c1146k.f273f && this.f274g == c1146k.f274g) {
                Uri uri = this.f268a;
                if (uri == null ? c1146k.f268a == null : uri.equals(c1146k.f268a)) {
                    Uri uri2 = this.f269b;
                    if (uri2 == null ? c1146k.f269b == null : uri2.equals(c1146k.f269b)) {
                        if (this.f270c != c1146k.f270c) {
                            return false;
                        }
                        String str = this.f271d;
                        String str2 = c1146k.f271d;
                        return str != null ? str.equals(str2) : str2 == null;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        Uri uri = this.f268a;
        int hashCode = (uri != null ? uri.hashCode() : 0) * 31;
        Uri uri2 = this.f269b;
        int hashCode2 = (hashCode + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        EnumC1147a enumC1147a = this.f270c;
        int hashCode3 = (hashCode2 + (enumC1147a != null ? enumC1147a.hashCode() : 0)) * 31;
        String str = this.f271d;
        return ((((((hashCode3 + (str != null ? str.hashCode() : 0)) * 31) + this.f272e) * 31) + this.f273f) * 31) + this.f274g;
    }

    public String toString() {
        return "VastVideoFile{sourceVideoUri=" + this.f268a + ", videoUri=" + this.f269b + ", deliveryType=" + this.f270c + ", fileType='" + this.f271d + "', width=" + this.f272e + ", height=" + this.f273f + ", bitrate=" + this.f274g + '}';
    }
}
