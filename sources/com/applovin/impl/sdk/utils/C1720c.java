package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import com.applovin.impl.sdk.C1710r;
import com.google.android.exoplayer2.util.MimeTypes;

/* renamed from: com.applovin.impl.sdk.utils.c */
/* loaded from: classes.dex */
public class C1720c {

    /* renamed from: a */
    private static C1720c f2473a;

    /* renamed from: b */
    private static final Object f2474b = new Object();

    /* renamed from: c */
    private final Bundle f2475c;

    /* renamed from: d */
    private final int f2476d;

    private C1720c(Context context) {
        Bundle bundle = null;
        try {
            try {
                bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e) {
                C1710r.m6316c("AndroidManifest", "Failed to get meta data.", e);
            }
            int i = 0;
            try {
                XmlResourceParser openXmlResourceParser = context.getAssets().openXmlResourceParser("AndroidManifest.xml");
                int eventType = openXmlResourceParser.getEventType();
                int i2 = 0;
                do {
                    if (2 == eventType) {
                        try {
                            if (openXmlResourceParser.getName().equals(MimeTypes.BASE_TYPE_APPLICATION)) {
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= openXmlResourceParser.getAttributeCount()) {
                                        break;
                                    }
                                    String attributeName = openXmlResourceParser.getAttributeName(i3);
                                    String attributeValue = openXmlResourceParser.getAttributeValue(i3);
                                    if (attributeName.equals("networkSecurityConfig")) {
                                        i2 = Integer.valueOf(attributeValue.substring(1)).intValue();
                                        break;
                                    }
                                    i3++;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            i = i2;
                            try {
                                C1710r.m6316c("AndroidManifest", "Failed to parse AndroidManifest.xml.", th);
                                return;
                            } finally {
                                this.f2476d = i;
                            }
                        }
                    }
                    eventType = openXmlResourceParser.next();
                } while (eventType != 1);
                this.f2476d = i2;
            } catch (Throwable th2) {
                th = th2;
            }
        } finally {
            this.f2475c = bundle;
        }
    }

    /* renamed from: a */
    public static C1720c m6288a(Context context) {
        C1720c c1720c;
        synchronized (f2474b) {
            if (f2473a == null) {
                f2473a = new C1720c(context);
            }
            c1720c = f2473a;
        }
        return c1720c;
    }

    /* renamed from: a */
    public String m6286a(String str, String str2) {
        Bundle bundle = this.f2475c;
        return bundle != null ? bundle.getString(str, str2) : str2;
    }

    /* renamed from: a */
    public boolean m6289a() {
        return this.f2476d != 0;
    }

    /* renamed from: a */
    public boolean m6287a(String str) {
        Bundle bundle = this.f2475c;
        if (bundle != null) {
            return bundle.containsKey(str);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m6285a(String str, boolean z) {
        Bundle bundle = this.f2475c;
        return bundle != null ? bundle.getBoolean(str, z) : z;
    }
}
