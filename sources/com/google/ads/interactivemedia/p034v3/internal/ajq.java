package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import com.google.ads.interactivemedia.p034v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.p034v3.api.UiElement;
import com.google.ads.interactivemedia.p034v3.impl.data.C2496bn;
import com.google.ads.interactivemedia.p034v3.impl.data.C2508bz;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ajq */
/* loaded from: classes2.dex */
public final class ajq {

    /* renamed from: a */
    private static final bgh f4244a;

    /* renamed from: b */
    private final ajo f4245b;

    /* renamed from: c */
    private final Object f4246c;

    /* renamed from: d */
    private final String f4247d;

    /* renamed from: e */
    private final ajp f4248e;

    static {
        bgi bgiVar = new bgi();
        bgiVar.m3717b(UiElement.class, C2508bz.GSON_TYPE_ADAPTER);
        bgiVar.m3717b(CompanionAdSlot.class, new ajn());
        bgiVar.m3716c(new atf());
        f4244a = bgiVar.m3718a();
    }

    public ajq(ajo ajoVar, ajp ajpVar, String str) {
        this(ajoVar, ajpVar, str, null);
    }

    public ajq(ajo ajoVar, ajp ajpVar, String str, Object obj) {
        this.f4245b = ajoVar;
        this.f4248e = ajpVar;
        this.f4247d = str;
        this.f4246c = obj;
    }

    /* renamed from: c */
    public static ajq m5159c(String str) throws MalformedURLException, bgt {
        Uri parse = Uri.parse(str);
        String path = parse.getPath();
        if (path == null) {
            throw new MalformedURLException("URL must have message.");
        }
        String substring = path.substring(1);
        if (parse.getQueryParameter("sid") == null) {
            throw new MalformedURLException("Session id must be provided in message.");
        }
        ajo m5163a = ajo.m5163a(substring);
        ajp m5162a = ajp.m5162a(parse.getQueryParameter("type"));
        String queryParameter = parse.getQueryParameter("sid");
        bgh bghVar = f4244a;
        String queryParameter2 = parse.getQueryParameter("data");
        Class cls = C2496bn.class;
        Object m3723f = queryParameter2 == null ? null : bghVar.m3723f(new StringReader(queryParameter2), cls);
        if (Integer.TYPE == cls) {
            cls = Integer.class;
        } else if (Float.TYPE == cls) {
            cls = Float.class;
        } else if (Byte.TYPE == cls) {
            cls = Byte.class;
        } else if (Double.TYPE == cls) {
            cls = Double.class;
        } else if (Long.TYPE == cls) {
            cls = Long.class;
        } else if (Character.TYPE == cls) {
            cls = Character.class;
        } else if (Boolean.TYPE == cls) {
            cls = Boolean.class;
        } else if (Short.TYPE == cls) {
            cls = Short.class;
        } else if (Void.TYPE == cls) {
            cls = Void.class;
        }
        return new ajq(m5163a, m5162a, queryParameter, cls.cast(m3723f));
    }

    /* renamed from: a */
    public final ajo m5161a() {
        return this.f4245b;
    }

    /* renamed from: b */
    public final ajp m5160b() {
        return this.f4248e;
    }

    /* renamed from: d */
    public final Object m5158d() {
        return this.f4246c;
    }

    /* renamed from: e */
    public final String m5157e() {
        return this.f4247d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof ajq)) {
            ajq ajqVar = (ajq) obj;
            return this.f4245b == ajqVar.f4245b && anx.m4882b(this.f4246c, ajqVar.f4246c) && anx.m4882b(this.f4247d, ajqVar.f4247d) && this.f4248e == ajqVar.f4248e;
        }
        return false;
    }

    /* renamed from: f */
    public final String m5156f() {
        avh avhVar = new avh();
        avhVar.mo4491a("type", this.f4248e);
        avh mo4491a = avhVar.mo4491a("sid", this.f4247d);
        Object obj = this.f4246c;
        if (obj != null) {
            mo4491a.mo4491a("data", obj);
        }
        return String.format("%s('%s', %s);", "javascript:adsense.mobileads.afmanotify.receiveMessage", this.f4245b, f4244a.m3722g(mo4491a.mo4489c()));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4245b, this.f4246c, this.f4247d, this.f4248e});
    }

    public final String toString() {
        return String.format("JavaScriptMessage [command=%s, type=%s, sid=%s, data=%s]", this.f4245b, this.f4248e, this.f4247d, this.f4246c);
    }
}
