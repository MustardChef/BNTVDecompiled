package com.google.ads.interactivemedia.p034v3.internal;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.axh */
/* loaded from: classes2.dex */
public final class axh implements FilenameFilter {

    /* renamed from: a */
    private final Pattern f5246a;

    public axh(Pattern pattern) {
        atm.m4612j(pattern);
        this.f5246a = pattern;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return this.f5246a.matcher(str).matches();
    }
}
