package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import java.util.Objects;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.and */
/* loaded from: classes2.dex */
public final class and {

    /* renamed from: a */
    private String f4704a = "googleads.g.doubleclick.net";

    /* renamed from: b */
    private String f4705b = "/pagead/ads";

    /* renamed from: c */
    private final String f4706c = "ad.doubleclick.net";

    /* renamed from: d */
    private String[] f4707d = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};

    /* renamed from: e */
    private final amv f4708e;

    @Deprecated
    public and(amv amvVar) {
        this.f4708e = amvVar;
    }

    /* renamed from: h */
    private final Uri m4922h(Uri uri, String str) throws ane {
        Objects.requireNonNull(uri);
        try {
            try {
                if (uri.getHost().equals(this.f4706c)) {
                    if (!uri.toString().contains("dc_ms=")) {
                        String uri2 = uri.toString();
                        int indexOf = uri2.indexOf(";adurl");
                        if (indexOf != -1) {
                            int i = indexOf + 1;
                            return Uri.parse(uri2.substring(0, i) + "dc_ms=" + str + ";" + uri2.substring(i));
                        }
                        String encodedPath = uri.getEncodedPath();
                        int indexOf2 = uri2.indexOf(encodedPath);
                        return Uri.parse(uri2.substring(0, encodedPath.length() + indexOf2) + ";dc_ms=" + str + ";" + uri2.substring(indexOf2 + encodedPath.length()));
                    }
                    throw new ane("Parameter already exists: dc_ms");
                }
            } catch (NullPointerException unused) {
            }
            if (uri.getQueryParameter("ms") == null) {
                String uri3 = uri.toString();
                int indexOf3 = uri3.indexOf("&adurl");
                if (indexOf3 == -1) {
                    indexOf3 = uri3.indexOf("?adurl");
                }
                if (indexOf3 != -1) {
                    int i2 = indexOf3 + 1;
                    return Uri.parse(uri3.substring(0, i2) + "ms=" + str + "&" + uri3.substring(i2));
                }
                return uri.buildUpon().appendQueryParameter("ms", str).build();
            }
            throw new ane("Query parameter already exists: ms");
        } catch (UnsupportedOperationException unused2) {
            throw new ane("Provided Uri is not in a valid state");
        }
    }

    @Deprecated
    /* renamed from: a */
    public final Uri m4929a(Uri uri, Context context) throws ane {
        return m4922h(uri, this.f4708e.mo4953f(context));
    }

    @Deprecated
    /* renamed from: b */
    public final void m4928b(MotionEvent motionEvent) {
        this.f4708e.mo4948k(motionEvent);
    }

    /* renamed from: c */
    public final void m4927c(String str, String str2) {
        this.f4704a = str;
        this.f4705b = str2;
    }

    /* renamed from: d */
    public final void m4926d(String str) {
        this.f4707d = str.split(",");
    }

    /* renamed from: e */
    public final boolean m4925e(Uri uri) {
        Objects.requireNonNull(uri);
        try {
            String host = uri.getHost();
            for (String str : this.f4707d) {
                if (host.endsWith(str)) {
                    return true;
                }
            }
        } catch (NullPointerException unused) {
        }
        return false;
    }

    /* renamed from: f */
    public final boolean m4924f(Uri uri) {
        Objects.requireNonNull(uri);
        try {
            if (uri.getHost().equals(this.f4704a)) {
                if (uri.getPath().equals(this.f4705b)) {
                    return true;
                }
            }
        } catch (NullPointerException unused) {
        }
        return false;
    }

    @Deprecated
    /* renamed from: g */
    public final Uri m4923g(Uri uri, Context context) throws ane {
        try {
            return m4922h(uri, this.f4708e.mo4954e(context, uri.getQueryParameter("ai"), null, null));
        } catch (UnsupportedOperationException unused) {
            throw new ane("Provided Uri is not in a valid state");
        }
    }
}
