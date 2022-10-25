package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.source.rtsp.RtspHeaders;
import java.util.Locale;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.mc */
/* loaded from: classes2.dex */
public final class C2884mc {

    /* renamed from: a */
    private final String[] f8086a;

    /* renamed from: b */
    private final int[] f8087b;

    /* renamed from: c */
    private final String[] f8088c;

    /* renamed from: d */
    private final int f8089d;

    private C2884mc(String[] strArr, int[] iArr, String[] strArr2, int i) {
        this.f8086a = strArr;
        this.f8087b = iArr;
        this.f8088c = strArr2;
        this.f8089d = i;
    }

    /* renamed from: a */
    public static C2884mc m1650a(String str) {
        String str2;
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        strArr[0] = "";
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            int indexOf = str.indexOf("$", i);
            char c = 65535;
            if (indexOf == -1) {
                String valueOf = String.valueOf(strArr[i2]);
                String valueOf2 = String.valueOf(str.substring(i));
                strArr[i2] = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                i = str.length();
            } else if (indexOf != i) {
                String valueOf3 = String.valueOf(strArr[i2]);
                String valueOf4 = String.valueOf(str.substring(i, indexOf));
                strArr[i2] = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
                i = indexOf;
            } else if (str.startsWith("$$", i)) {
                strArr[i2] = String.valueOf(strArr[i2]).concat("$");
                i += 2;
            } else {
                int i3 = i + 1;
                int indexOf2 = str.indexOf("$", i3);
                String substring = str.substring(i3, indexOf2);
                if (substring.equals("RepresentationID")) {
                    iArr[i2] = 1;
                } else {
                    int indexOf3 = substring.indexOf("%0");
                    if (indexOf3 != -1) {
                        str2 = substring.substring(indexOf3);
                        if (!str2.endsWith("d") && !str2.endsWith("x")) {
                            str2 = String.valueOf(str2).concat("d");
                        }
                        substring = substring.substring(0, indexOf3);
                    } else {
                        str2 = "%01d";
                    }
                    int hashCode = substring.hashCode();
                    if (hashCode != -1950496919) {
                        if (hashCode != 2606829) {
                            if (hashCode == 38199441 && substring.equals(RtspHeaders.BANDWIDTH)) {
                                c = 1;
                            }
                        } else if (substring.equals("Time")) {
                            c = 2;
                        }
                    } else if (substring.equals("Number")) {
                        c = 0;
                    }
                    if (c == 0) {
                        iArr[i2] = 2;
                    } else if (c == 1) {
                        iArr[i2] = 3;
                    } else if (c != 2) {
                        throw new IllegalArgumentException(str.length() != 0 ? "Invalid template: ".concat(str) : new String("Invalid template: "));
                    } else {
                        iArr[i2] = 4;
                    }
                    strArr2[i2] = str2;
                }
                i2++;
                strArr[i2] = "";
                i = indexOf2 + 1;
            }
        }
        return new C2884mc(strArr, iArr, strArr2, i2);
    }

    /* renamed from: b */
    public final String m1649b(String str, long j, int i, long j2) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            int i3 = this.f8089d;
            if (i2 < i3) {
                sb.append(this.f8086a[i2]);
                int i4 = this.f8087b[i2];
                if (i4 == 1) {
                    sb.append(str);
                } else if (i4 == 2) {
                    sb.append(String.format(Locale.US, this.f8088c[i2], Long.valueOf(j)));
                } else if (i4 == 3) {
                    sb.append(String.format(Locale.US, this.f8088c[i2], Integer.valueOf(i)));
                } else if (i4 == 4) {
                    sb.append(String.format(Locale.US, this.f8088c[i2], Long.valueOf(j2)));
                }
                i2++;
            } else {
                sb.append(this.f8086a[i3]);
                return sb.toString();
            }
        }
    }
}
