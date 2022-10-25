package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Log;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.net.HttpHeaders;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ach */
/* loaded from: classes2.dex */
final class ach {

    /* renamed from: a */
    static final String[] f3193a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    /* renamed from: b */
    public static final /* synthetic */ int f3194b = 0;

    /* renamed from: a */
    public static InterfaceC2548aj m5849a(C2621cj c2621cj) {
        String str;
        int m2639c = c2621cj.m2639c() + c2621cj.m2637e();
        int m2637e = c2621cj.m2637e();
        int i = (m2637e >> 24) & 255;
        InterfaceC2548aj interfaceC2548aj = null;
        try {
            if (i == 169 || i == 253) {
                int i2 = 16777215 & m2637e;
                if (i2 == 6516084) {
                    int m2637e2 = c2621cj.m2637e();
                    if (c2621cj.m2637e() == 1684108385) {
                        c2621cj.m2643G(8);
                        String m2622t = c2621cj.m2622t(m2637e2 - 16);
                        interfaceC2548aj = new aak(C3282C.LANGUAGE_UNDETERMINED, m2622t, m2622t);
                    } else {
                        String valueOf = String.valueOf(abt.m5887g(m2637e));
                        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse comment attribute: ".concat(valueOf) : new String("Failed to parse comment attribute: "));
                    }
                    return interfaceC2548aj;
                } else if (i2 == 7233901 || i2 == 7631467) {
                    return m5845e(m2637e, "TIT2", c2621cj);
                } else {
                    if (i2 == 6516589 || i2 == 7828084) {
                        return m5845e(m2637e, "TCOM", c2621cj);
                    }
                    if (i2 == 6578553) {
                        return m5845e(m2637e, "TDRC", c2621cj);
                    }
                    if (i2 == 4280916) {
                        return m5845e(m2637e, "TPE1", c2621cj);
                    }
                    if (i2 == 7630703) {
                        return m5845e(m2637e, "TSSE", c2621cj);
                    }
                    if (i2 == 6384738) {
                        return m5845e(m2637e, "TALB", c2621cj);
                    }
                    if (i2 == 7108978) {
                        return m5845e(m2637e, "USLT", c2621cj);
                    }
                    if (i2 == 6776174) {
                        return m5845e(m2637e, "TCON", c2621cj);
                    }
                    if (i2 == 6779504) {
                        return m5845e(m2637e, "TIT1", c2621cj);
                    }
                }
            } else if (m2637e == 1735291493) {
                int m5848b = m5848b(c2621cj);
                String str2 = (m5848b <= 0 || m5848b > 192) ? null : f3193a[m5848b - 1];
                if (str2 != null) {
                    interfaceC2548aj = new aau("TCON", null, str2);
                } else {
                    Log.w("MetadataUtil", "Failed to parse standard genre code");
                }
                return interfaceC2548aj;
            } else if (m2637e == 1684632427) {
                return m5846d(1684632427, "TPOS", c2621cj);
            } else {
                if (m2637e == 1953655662) {
                    return m5846d(1953655662, "TRCK", c2621cj);
                }
                if (m2637e == 1953329263) {
                    return m5847c(1953329263, "TBPM", c2621cj, true, false);
                }
                if (m2637e == 1668311404) {
                    return m5847c(1668311404, "TCMP", c2621cj, true, true);
                }
                if (m2637e == 1668249202) {
                    int m2637e3 = c2621cj.m2637e();
                    if (c2621cj.m2637e() == 1684108385) {
                        int m5889e = abt.m5889e(c2621cj.m2637e());
                        if (m5889e == 13) {
                            str = MimeTypes.IMAGE_JPEG;
                        } else if (m5889e == 14) {
                            str = "image/png";
                            m5889e = 14;
                        } else {
                            str = null;
                        }
                        if (str == null) {
                            StringBuilder sb = new StringBuilder(41);
                            sb.append("Unrecognized cover art flags: ");
                            sb.append(m5889e);
                            Log.w("MetadataUtil", sb.toString());
                        } else {
                            c2621cj.m2643G(4);
                            int i3 = m2637e3 - 16;
                            byte[] bArr = new byte[i3];
                            c2621cj.m2649A(bArr, 0, i3);
                            interfaceC2548aj = new aaf(str, null, 3, bArr);
                        }
                    } else {
                        Log.w("MetadataUtil", "Failed to parse cover art attribute");
                    }
                    return interfaceC2548aj;
                } else if (m2637e == 1631670868) {
                    return m5845e(1631670868, "TPE2", c2621cj);
                } else {
                    if (m2637e == 1936682605) {
                        return m5845e(1936682605, "TSOT", c2621cj);
                    }
                    if (m2637e == 1936679276) {
                        return m5845e(1936679276, "TSO2", c2621cj);
                    }
                    if (m2637e == 1936679282) {
                        return m5845e(1936679282, "TSOA", c2621cj);
                    }
                    if (m2637e == 1936679265) {
                        return m5845e(1936679265, "TSOP", c2621cj);
                    }
                    if (m2637e == 1936679791) {
                        return m5845e(1936679791, "TSOC", c2621cj);
                    }
                    if (m2637e == 1920233063) {
                        return m5847c(1920233063, "ITUNESADVISORY", c2621cj, false, false);
                    }
                    if (m2637e == 1885823344) {
                        return m5847c(1885823344, "ITUNESGAPLESS", c2621cj, false, true);
                    }
                    if (m2637e == 1936683886) {
                        return m5845e(1936683886, "TVSHOWSORT", c2621cj);
                    }
                    if (m2637e == 1953919848) {
                        return m5845e(1953919848, "TVSHOW", c2621cj);
                    }
                    if (m2637e == 757935405) {
                        String str3 = null;
                        String str4 = null;
                        int i4 = -1;
                        int i5 = -1;
                        while (c2621cj.m2639c() < m2639c) {
                            int m2639c2 = c2621cj.m2639c();
                            int m2637e4 = c2621cj.m2637e();
                            int m2637e5 = c2621cj.m2637e();
                            c2621cj.m2643G(4);
                            if (m2637e5 == 1835360622) {
                                str3 = c2621cj.m2622t(m2637e4 - 12);
                            } else if (m2637e5 == 1851878757) {
                                str4 = c2621cj.m2622t(m2637e4 - 12);
                            } else {
                                if (m2637e5 == 1684108385) {
                                    i5 = m2637e4;
                                }
                                if (m2637e5 == 1684108385) {
                                    i4 = m2639c2;
                                }
                                c2621cj.m2643G(m2637e4 - 12);
                            }
                        }
                        if (str3 != null && str4 != null && i4 != -1) {
                            c2621cj.m2644F(i4);
                            c2621cj.m2643G(16);
                            interfaceC2548aj = new aar(str3, str4, c2621cj.m2622t(i5 - 16));
                        }
                        return interfaceC2548aj;
                    }
                }
            }
            String valueOf2 = String.valueOf(abt.m5887g(m2637e));
            Log.d("MetadataUtil", valueOf2.length() != 0 ? "Skipped unknown metadata entry: ".concat(valueOf2) : new String("Skipped unknown metadata entry: "));
            return null;
        } finally {
            c2621cj.m2644F(m2639c);
        }
    }

    /* renamed from: b */
    private static int m5848b(C2621cj c2621cj) {
        c2621cj.m2643G(4);
        if (c2621cj.m2637e() == 1684108385) {
            c2621cj.m2643G(8);
            return c2621cj.m2633i();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    /* renamed from: c */
    private static aaq m5847c(int i, String str, C2621cj c2621cj, boolean z, boolean z2) {
        int m5848b = m5848b(c2621cj);
        if (z2) {
            m5848b = Math.min(1, m5848b);
        }
        if (m5848b >= 0) {
            if (z) {
                return new aau(str, null, Integer.toString(m5848b));
            }
            return new aak(C3282C.LANGUAGE_UNDETERMINED, str, Integer.toString(m5848b));
        }
        String valueOf = String.valueOf(abt.m5887g(i));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(valueOf) : new String("Failed to parse uint8 attribute: "));
        return null;
    }

    /* renamed from: d */
    private static aau m5846d(int i, String str, C2621cj c2621cj) {
        int m2637e = c2621cj.m2637e();
        if (c2621cj.m2637e() == 1684108385 && m2637e >= 22) {
            c2621cj.m2643G(10);
            int m2629m = c2621cj.m2629m();
            if (m2629m > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(m2629m);
                String sb2 = sb.toString();
                int m2629m2 = c2621cj.m2629m();
                if (m2629m2 > 0) {
                    StringBuilder sb3 = new StringBuilder(sb2.length() + 12);
                    sb3.append(sb2);
                    sb3.append("/");
                    sb3.append(m2629m2);
                    sb2 = sb3.toString();
                }
                return new aau(str, null, sb2);
            }
        }
        String valueOf = String.valueOf(abt.m5887g(i));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse index/count attribute: ".concat(valueOf) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    /* renamed from: e */
    private static aau m5845e(int i, String str, C2621cj c2621cj) {
        int m2637e = c2621cj.m2637e();
        if (c2621cj.m2637e() == 1684108385) {
            c2621cj.m2643G(8);
            return new aau(str, null, c2621cj.m2622t(m2637e - 16));
        }
        String valueOf = String.valueOf(abt.m5887g(i));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse text attribute: ".concat(valueOf) : new String("Failed to parse text attribute: "));
        return null;
    }
}
