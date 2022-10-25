package com.blankj.utilcode.util;

import android.os.Build;
import android.text.Html;
import android.util.Base64;
import com.fasterxml.jackson.core.base.GeneratorBase;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import kotlin.jvm.internal.CharCompanionObject;

/* loaded from: classes.dex */
public final class EncodeUtils {
    private EncodeUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static byte[] base64Decode(String str) {
        return Base64.decode(str, 2);
    }

    public static byte[] base64Decode(byte[] bArr) {
        return Base64.decode(bArr, 2);
    }

    public static byte[] base64Encode(String str) {
        return base64Encode(str.getBytes());
    }

    public static byte[] base64Encode(byte[] bArr) {
        return Base64.encode(bArr, 2);
    }

    public static String base64Encode2String(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }

    public static byte[] base64UrlSafeEncode(String str) {
        return Base64.encode(str.getBytes(), 8);
    }

    public static CharSequence htmlDecode(String str) {
        return Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(str, 0) : Html.fromHtml(str);
    }

    public static String htmlEncode(CharSequence charSequence) {
        int i;
        char charAt;
        String str;
        if (Build.VERSION.SDK_INT >= 16) {
            return Html.escapeHtml(charSequence);
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        int length = charSequence.length();
        while (i2 < length) {
            char charAt2 = charSequence.charAt(i2);
            if (charAt2 == '<') {
                str = "&lt;";
            } else if (charAt2 == '>') {
                str = "&gt;";
            } else if (charAt2 == '&') {
                str = "&amp;";
            } else {
                if (charAt2 < 55296 || charAt2 > 57343) {
                    if (charAt2 > '~' || charAt2 < ' ') {
                        sb.append("&#");
                        sb.append((int) charAt2);
                        sb.append(";");
                    } else if (charAt2 == ' ') {
                        while (true) {
                            int i3 = i2 + 1;
                            if (i3 >= length || charSequence.charAt(i3) != ' ') {
                                break;
                            }
                            sb.append("&nbsp;");
                            i2 = i3;
                        }
                        sb.append(' ');
                    } else {
                        sb.append(charAt2);
                    }
                } else if (charAt2 < 56320 && (i = i2 + 1) < length && (charAt = charSequence.charAt(i)) >= 56320 && charAt <= 57343) {
                    sb.append("&#");
                    sb.append(65536 | ((charAt2 - GeneratorBase.SURR1_FIRST) << 10) | (charAt - CharCompanionObject.MIN_LOW_SURROGATE));
                    sb.append(";");
                    i2 = i;
                }
                i2++;
            }
            sb.append(str);
            i2++;
        }
        return sb.toString();
    }

    public static String urlDecode(String str) {
        return urlDecode(str, "UTF-8");
    }

    public static String urlDecode(String str, String str2) {
        try {
            return URLDecoder.decode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static String urlEncode(String str) {
        return urlEncode(str, "UTF-8");
    }

    public static String urlEncode(String str, String str2) {
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }
}
