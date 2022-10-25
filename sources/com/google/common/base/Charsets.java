package com.google.common.base;

import com.google.android.exoplayer2.C3282C;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public final class Charsets {
    public static final Charset US_ASCII = Charset.forName(C3282C.ASCII_NAME);
    public static final Charset ISO_8859_1 = Charset.forName(C3282C.ISO88591_NAME);
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final Charset UTF_16BE = Charset.forName("UTF-16BE");
    public static final Charset UTF_16LE = Charset.forName(C3282C.UTF16LE_NAME);
    public static final Charset UTF_16 = Charset.forName(C3282C.UTF16_NAME);

    private Charsets() {
    }
}
