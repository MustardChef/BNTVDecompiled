package com.google.ads.interactivemedia.p034v3.internal;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.agh */
/* loaded from: classes2.dex */
public final class agh {

    /* renamed from: a */
    private final ago f3957a;

    /* renamed from: b */
    private final WebView f3958b;

    /* renamed from: c */
    private final List f3959c = new ArrayList();

    /* renamed from: d */
    private final Map f3960d = new HashMap();

    /* renamed from: e */
    private final String f3961e;

    /* renamed from: f */
    private final String f3962f;

    /* renamed from: g */
    private final agi f3963g;

    private agh(ago agoVar, WebView webView, String str, String str2, agi agiVar) {
        this.f3957a = agoVar;
        this.f3958b = webView;
        this.f3963g = agiVar;
        this.f3962f = str;
        this.f3961e = str2;
    }

    /* renamed from: a */
    public final WebView m5357a() {
        return this.f3958b;
    }

    /* renamed from: c */
    public final agi m5355c() {
        return this.f3963g;
    }

    /* renamed from: d */
    public final ago m5354d() {
        return this.f3957a;
    }

    /* renamed from: e */
    public final String m5353e() {
        return this.f3962f;
    }

    /* renamed from: f */
    public final String m5352f() {
        return this.f3961e;
    }

    /* renamed from: g */
    public final List m5351g() {
        return Collections.unmodifiableList(this.f3959c);
    }

    /* renamed from: h */
    public final Map m5350h() {
        return Collections.unmodifiableMap(this.f3960d);
    }

    /* renamed from: b */
    public static agh m5356b(ago agoVar, WebView webView, String str, String str2) {
        if (str2.length() <= 256) {
            return new agh(agoVar, webView, str, str2, agi.JAVASCRIPT);
        }
        throw new IllegalArgumentException("CustomReferenceData is greater than 256 characters");
    }
}
