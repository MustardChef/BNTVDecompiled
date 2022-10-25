package com.google.android.gms.common.server.response;

import android.util.Log;
import com.google.android.exoplayer2.C3282C;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.Base64Utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import okio.internal._BufferKt;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public class FastParser<T extends FastJsonResponse> {
    private static final char[] zaf = {'u', 'l', 'l'};
    private static final char[] zag = {'r', 'u', 'e'};
    private static final char[] zah = {'r', 'u', 'e', '\"'};
    private static final char[] zai = {'a', 'l', 's', 'e'};
    private static final char[] zaj = {'a', 'l', 's', 'e', '\"'};
    private static final char[] zak = {'\n'};
    private static final zai<Integer> zam = new zaa();
    private static final zai<Long> zan = new zab();
    private static final zai<Float> zao = new zac();
    private static final zai<Double> zap = new zad();
    private static final zai<Boolean> zaq = new zae();
    private static final zai<String> zar = new zaf();
    private static final zai<BigInteger> zas = new zag();
    private static final zai<BigDecimal> zat = new zah();
    private final char[] zaa = new char[1];
    private final char[] zab = new char[32];
    private final char[] zac = new char[1024];
    private final StringBuilder zad = new StringBuilder(32);
    private final StringBuilder zae = new StringBuilder(1024);
    private final Stack<Integer> zal = new Stack<>();

    /* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
    /* loaded from: classes2.dex */
    public static class ParseException extends Exception {
        public ParseException(String str) {
            super(str);
        }

        public ParseException(String str, Throwable th) {
            super("Error instantiating inner object", th);
        }

        public ParseException(Throwable th) {
            super(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
        throw new com.google.android.gms.common.server.response.FastParser.ParseException("Unexpected control character while reading string");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.lang.String zaA(java.io.BufferedReader r8, char[] r9, java.lang.StringBuilder r10, char[] r11) throws com.google.android.gms.common.server.response.FastParser.ParseException, java.io.IOException {
        /*
            r0 = 0
            r10.setLength(r0)
            int r1 = r9.length
            r8.mark(r1)
            r1 = 0
            r2 = 0
        La:
            int r3 = r8.read(r9)
            r4 = -1
            if (r3 == r4) goto L69
            r4 = 0
        L12:
            if (r4 >= r3) goto L61
            char r5 = r9[r4]
            boolean r6 = java.lang.Character.isISOControl(r5)
            if (r6 == 0) goto L32
            if (r11 == 0) goto L2a
            r6 = 0
        L1f:
            int r7 = r11.length
            if (r6 >= r7) goto L2a
            char r7 = r11[r6]
            if (r7 != r5) goto L27
            goto L32
        L27:
            int r6 = r6 + 1
            goto L1f
        L2a:
            com.google.android.gms.common.server.response.FastParser$ParseException r8 = new com.google.android.gms.common.server.response.FastParser$ParseException
            java.lang.String r9 = "Unexpected control character while reading string"
            r8.<init>(r9)
            throw r8
        L32:
            r6 = 34
            r7 = 1
            if (r5 != r6) goto L54
            if (r2 != 0) goto L5d
            r10.append(r9, r0, r4)
            r8.reset()
            int r4 = r4 + r7
            long r2 = (long) r4
            r8.skip(r2)
            if (r1 == 0) goto L4f
            java.lang.String r8 = r10.toString()
            java.lang.String r8 = com.google.android.gms.common.util.JsonUtils.unescapeString(r8)
            return r8
        L4f:
            java.lang.String r8 = r10.toString()
            return r8
        L54:
            r6 = 92
            if (r5 != r6) goto L5d
            r1 = r2 ^ 1
            r2 = r1
            r1 = 1
            goto L5e
        L5d:
            r2 = 0
        L5e:
            int r4 = r4 + 1
            goto L12
        L61:
            r10.append(r9, r0, r3)
            int r3 = r9.length
            r8.mark(r3)
            goto La
        L69:
            com.google.android.gms.common.server.response.FastParser$ParseException r8 = new com.google.android.gms.common.server.response.FastParser$ParseException
            java.lang.String r9 = "Unexpected EOF while parsing string"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.FastParser.zaA(java.io.BufferedReader, char[], java.lang.StringBuilder, char[]):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean zai(BufferedReader bufferedReader, FastJsonResponse fastJsonResponse) throws ParseException, IOException {
        HashMap hashMap;
        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
        String zaj2 = zaj(bufferedReader);
        if (zaj2 != null) {
            while (zaj2 != null) {
                FastJsonResponse.Field<?, ?> field = fieldMappings.get(zaj2);
                if (field == null) {
                    zaj2 = zak(bufferedReader);
                } else {
                    this.zal.push(4);
                    int i = field.zaa;
                    switch (i) {
                        case 0:
                            if (field.zab) {
                                fastJsonResponse.zab(field, zam(bufferedReader, zam));
                                break;
                            } else {
                                fastJsonResponse.zaa(field, zao(bufferedReader));
                                break;
                            }
                        case 1:
                            if (field.zab) {
                                fastJsonResponse.zad(field, zam(bufferedReader, zas));
                                break;
                            } else {
                                fastJsonResponse.zac(field, zaq(bufferedReader));
                                break;
                            }
                        case 2:
                            if (field.zab) {
                                fastJsonResponse.zaf(field, zam(bufferedReader, zan));
                                break;
                            } else {
                                fastJsonResponse.zae(field, zap(bufferedReader));
                                break;
                            }
                        case 3:
                            if (field.zab) {
                                fastJsonResponse.zah(field, zam(bufferedReader, zao));
                                break;
                            } else {
                                fastJsonResponse.zag(field, zas(bufferedReader));
                                break;
                            }
                        case 4:
                            if (field.zab) {
                                fastJsonResponse.zaj(field, zam(bufferedReader, zap));
                                break;
                            } else {
                                fastJsonResponse.zai(field, zat(bufferedReader));
                                break;
                            }
                        case 5:
                            if (field.zab) {
                                fastJsonResponse.zal(field, zam(bufferedReader, zat));
                                break;
                            } else {
                                fastJsonResponse.zak(field, zau(bufferedReader));
                                break;
                            }
                        case 6:
                            if (field.zab) {
                                fastJsonResponse.zan(field, zam(bufferedReader, zaq));
                                break;
                            } else {
                                fastJsonResponse.zam(field, zar(bufferedReader, false));
                                break;
                            }
                        case 7:
                            if (field.zab) {
                                fastJsonResponse.zap(field, zam(bufferedReader, zar));
                                break;
                            } else {
                                fastJsonResponse.zao(field, zal(bufferedReader));
                                break;
                            }
                        case 8:
                            fastJsonResponse.zaq(field, Base64Utils.decode(zan(bufferedReader, this.zac, this.zae, zak)));
                            break;
                        case 9:
                            fastJsonResponse.zaq(field, Base64Utils.decodeUrlSafe(zan(bufferedReader, this.zac, this.zae, zak)));
                            break;
                        case 10:
                            char zaw = zaw(bufferedReader);
                            if (zaw == 'n') {
                                zay(bufferedReader, zaf);
                                hashMap = null;
                            } else if (zaw == '{') {
                                this.zal.push(1);
                                hashMap = new HashMap();
                                while (true) {
                                    char zaw2 = zaw(bufferedReader);
                                    if (zaw2 == 0) {
                                        throw new ParseException("Unexpected EOF");
                                    }
                                    if (zaw2 == '\"') {
                                        String zaA = zaA(bufferedReader, this.zab, this.zad, null);
                                        if (zaw(bufferedReader) == ':') {
                                            if (zaw(bufferedReader) == '\"') {
                                                hashMap.put(zaA, zaA(bufferedReader, this.zab, this.zad, null));
                                                char zaw3 = zaw(bufferedReader);
                                                if (zaw3 != ',') {
                                                    if (zaw3 == '}') {
                                                        zaz(1);
                                                    } else {
                                                        StringBuilder sb = new StringBuilder(48);
                                                        sb.append("Unexpected character while parsing string map: ");
                                                        sb.append(zaw3);
                                                        throw new ParseException(sb.toString());
                                                    }
                                                }
                                            } else {
                                                String valueOf = String.valueOf(zaA);
                                                throw new ParseException(valueOf.length() != 0 ? "Expected String value for key ".concat(valueOf) : new String("Expected String value for key "));
                                            }
                                        } else {
                                            String valueOf2 = String.valueOf(zaA);
                                            throw new ParseException(valueOf2.length() != 0 ? "No map value found for key ".concat(valueOf2) : new String("No map value found for key "));
                                        }
                                    } else if (zaw2 == '}') {
                                        zaz(1);
                                    }
                                }
                            } else {
                                throw new ParseException("Expected start of a map object");
                            }
                            fastJsonResponse.zar(field, hashMap);
                            break;
                        case 11:
                            if (field.zab) {
                                char zaw4 = zaw(bufferedReader);
                                if (zaw4 == 'n') {
                                    zay(bufferedReader, zaf);
                                    fastJsonResponse.addConcreteTypeArrayInternal(field, field.zae, null);
                                    break;
                                } else {
                                    this.zal.push(5);
                                    if (zaw4 == '[') {
                                        fastJsonResponse.addConcreteTypeArrayInternal(field, field.zae, zav(bufferedReader, field));
                                        break;
                                    } else {
                                        throw new ParseException("Expected array start");
                                    }
                                }
                            } else {
                                char zaw5 = zaw(bufferedReader);
                                if (zaw5 == 'n') {
                                    zay(bufferedReader, zaf);
                                    fastJsonResponse.addConcreteTypeInternal(field, field.zae, null);
                                    break;
                                } else {
                                    this.zal.push(1);
                                    if (zaw5 == '{') {
                                        try {
                                            FastJsonResponse zaf2 = field.zaf();
                                            zai(bufferedReader, zaf2);
                                            fastJsonResponse.addConcreteTypeInternal(field, field.zae, zaf2);
                                            break;
                                        } catch (IllegalAccessException e) {
                                            throw new ParseException("Error instantiating inner object", e);
                                        } catch (InstantiationException e2) {
                                            throw new ParseException("Error instantiating inner object", e2);
                                        }
                                    } else {
                                        throw new ParseException("Expected start of object");
                                    }
                                }
                            }
                        default:
                            StringBuilder sb2 = new StringBuilder(30);
                            sb2.append("Invalid field type ");
                            sb2.append(i);
                            throw new ParseException(sb2.toString());
                    }
                    zaz(4);
                    zaz(2);
                    char zaw6 = zaw(bufferedReader);
                    if (zaw6 == ',') {
                        zaj2 = zaj(bufferedReader);
                    } else if (zaw6 != '}') {
                        StringBuilder sb3 = new StringBuilder(55);
                        sb3.append("Expected end of object or field separator, but found: ");
                        sb3.append(zaw6);
                        throw new ParseException(sb3.toString());
                    } else {
                        zaj2 = null;
                    }
                }
            }
            zaz(1);
            return true;
        }
        zaz(1);
        return false;
    }

    private final String zaj(BufferedReader bufferedReader) throws ParseException, IOException {
        this.zal.push(2);
        char zaw = zaw(bufferedReader);
        if (zaw == '\"') {
            this.zal.push(3);
            String zaA = zaA(bufferedReader, this.zab, this.zad, null);
            zaz(3);
            if (zaw(bufferedReader) == ':') {
                return zaA;
            }
            throw new ParseException("Expected key/value separator");
        } else if (zaw == ']') {
            zaz(2);
            zaz(1);
            zaz(5);
            return null;
        } else if (zaw == '}') {
            zaz(2);
            return null;
        } else {
            StringBuilder sb = new StringBuilder(19);
            sb.append("Unexpected token: ");
            sb.append(zaw);
            throw new ParseException(sb.toString());
        }
    }

    private final String zak(BufferedReader bufferedReader) throws ParseException, IOException {
        bufferedReader.mark(1024);
        char zaw = zaw(bufferedReader);
        int i = 1;
        if (zaw == '\"') {
            if (bufferedReader.read(this.zaa) != -1) {
                char c = this.zaa[0];
                boolean z = false;
                do {
                    if (c == '\"') {
                        if (z) {
                            c = '\"';
                            z = true;
                        }
                    }
                    z = c == '\\' ? !z : false;
                    if (bufferedReader.read(this.zaa) != -1) {
                        c = this.zaa[0];
                    } else {
                        throw new ParseException("Unexpected EOF while parsing string");
                    }
                } while (!Character.isISOControl(c));
                throw new ParseException("Unexpected control character while reading string");
            }
            throw new ParseException("Unexpected EOF while parsing string");
        } else if (zaw == ',') {
            throw new ParseException("Missing value");
        } else {
            if (zaw == '[') {
                this.zal.push(5);
                bufferedReader.mark(32);
                if (zaw(bufferedReader) == ']') {
                    zaz(5);
                } else {
                    bufferedReader.reset();
                    boolean z2 = false;
                    loop1: while (true) {
                        boolean z3 = false;
                        while (i > 0) {
                            char zaw2 = zaw(bufferedReader);
                            if (zaw2 != 0) {
                                if (Character.isISOControl(zaw2)) {
                                    throw new ParseException("Unexpected control character while reading array");
                                }
                                if (zaw2 == '\"') {
                                    if (!z3) {
                                        z2 = !z2;
                                    }
                                    zaw2 = '\"';
                                }
                                if (zaw2 == '[') {
                                    if (!z2) {
                                        i++;
                                    }
                                    zaw2 = '[';
                                }
                                if (zaw2 == ']' && !z2) {
                                    i--;
                                }
                                if (zaw2 == '\\' && z2) {
                                    z3 = !z3;
                                }
                            } else {
                                throw new ParseException("Unexpected EOF while parsing array");
                            }
                        }
                        zaz(5);
                        break loop1;
                    }
                }
            } else if (zaw == '{') {
                this.zal.push(1);
                bufferedReader.mark(32);
                char zaw3 = zaw(bufferedReader);
                if (zaw3 == '}') {
                    zaz(1);
                } else if (zaw3 == '\"') {
                    bufferedReader.reset();
                    zaj(bufferedReader);
                    do {
                    } while (zak(bufferedReader) != null);
                    zaz(1);
                } else {
                    StringBuilder sb = new StringBuilder(18);
                    sb.append("Unexpected token ");
                    sb.append(zaw3);
                    throw new ParseException(sb.toString());
                }
            } else {
                bufferedReader.reset();
                zax(bufferedReader, this.zac);
            }
        }
        char zaw4 = zaw(bufferedReader);
        if (zaw4 == ',') {
            zaz(2);
            return zaj(bufferedReader);
        } else if (zaw4 == '}') {
            zaz(2);
            return null;
        } else {
            StringBuilder sb2 = new StringBuilder(18);
            sb2.append("Unexpected token ");
            sb2.append(zaw4);
            throw new ParseException(sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String zal(BufferedReader bufferedReader) throws ParseException, IOException {
        return zan(bufferedReader, this.zab, this.zad, null);
    }

    private final <O> ArrayList<O> zam(BufferedReader bufferedReader, zai<O> zaiVar) throws ParseException, IOException {
        char zaw = zaw(bufferedReader);
        if (zaw == 'n') {
            zay(bufferedReader, zaf);
            return null;
        } else if (zaw != '[') {
            throw new ParseException("Expected start of array");
        } else {
            this.zal.push(5);
            ArrayList<O> arrayList = new ArrayList<>();
            while (true) {
                bufferedReader.mark(1024);
                char zaw2 = zaw(bufferedReader);
                if (zaw2 == 0) {
                    throw new ParseException("Unexpected EOF");
                }
                if (zaw2 != ',') {
                    if (zaw2 != ']') {
                        bufferedReader.reset();
                        arrayList.add(zaiVar.zaa(this, bufferedReader));
                    } else {
                        zaz(5);
                        return arrayList;
                    }
                }
            }
        }
    }

    private final String zan(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) throws ParseException, IOException {
        char zaw = zaw(bufferedReader);
        if (zaw != '\"') {
            if (zaw == 'n') {
                zay(bufferedReader, zaf);
                return null;
            }
            throw new ParseException("Expected string");
        }
        return zaA(bufferedReader, cArr, sb, cArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zao(BufferedReader bufferedReader) throws ParseException, IOException {
        int i;
        int i2;
        int zax = zax(bufferedReader, this.zac);
        if (zax == 0) {
            return 0;
        }
        char[] cArr = this.zac;
        if (zax > 0) {
            char c = cArr[0];
            int i3 = c == '-' ? Integer.MIN_VALUE : -2147483647;
            int i4 = c == '-' ? 1 : 0;
            if (i4 < zax) {
                i = i4 + 1;
                int digit = Character.digit(cArr[i4], 10);
                if (digit < 0) {
                    throw new ParseException("Unexpected non-digit character");
                }
                i2 = -digit;
            } else {
                i = i4;
                i2 = 0;
            }
            while (i < zax) {
                int i5 = i + 1;
                int digit2 = Character.digit(cArr[i], 10);
                if (digit2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                }
                if (i2 < -214748364) {
                    throw new ParseException("Number too large");
                }
                int i6 = i2 * 10;
                if (i6 < i3 + digit2) {
                    throw new ParseException("Number too large");
                }
                i2 = i6 - digit2;
                i = i5;
            }
            if (i4 != 0) {
                if (i > 1) {
                    return i2;
                }
                throw new ParseException("No digits to parse");
            }
            return -i2;
        }
        throw new ParseException("No number to parse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zap(BufferedReader bufferedReader) throws ParseException, IOException {
        long j;
        int i;
        int zax = zax(bufferedReader, this.zac);
        if (zax == 0) {
            return 0L;
        }
        char[] cArr = this.zac;
        if (zax > 0) {
            char c = cArr[0];
            long j2 = c == '-' ? Long.MIN_VALUE : C3282C.TIME_UNSET;
            int i2 = c == '-' ? 1 : 0;
            if (i2 < zax) {
                i = i2 + 1;
                int digit = Character.digit(cArr[i2], 10);
                if (digit < 0) {
                    throw new ParseException("Unexpected non-digit character");
                }
                j = -digit;
            } else {
                j = 0;
                i = i2;
            }
            while (i < zax) {
                int i3 = i + 1;
                int digit2 = Character.digit(cArr[i], 10);
                if (digit2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                }
                if (j < _BufferKt.OVERFLOW_ZONE) {
                    throw new ParseException("Number too large");
                }
                long j3 = j * 10;
                long j4 = digit2;
                if (j3 < j2 + j4) {
                    throw new ParseException("Number too large");
                }
                j = j3 - j4;
                i = i3;
            }
            if (i2 != 0) {
                if (i > 1) {
                    return j;
                }
                throw new ParseException("No digits to parse");
            }
            return -j;
        }
        throw new ParseException("No number to parse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BigInteger zaq(BufferedReader bufferedReader) throws ParseException, IOException {
        int zax = zax(bufferedReader, this.zac);
        if (zax == 0) {
            return null;
        }
        return new BigInteger(new String(this.zac, 0, zax));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zar(BufferedReader bufferedReader, boolean z) throws ParseException, IOException {
        char[] cArr;
        char zaw = zaw(bufferedReader);
        if (zaw == '\"') {
            if (z) {
                throw new ParseException("No boolean value found in string");
            }
            return zar(bufferedReader, true);
        } else if (zaw == 'f') {
            if (z) {
                cArr = zaj;
            } else {
                cArr = zai;
            }
            zay(bufferedReader, cArr);
            return false;
        } else if (zaw == 'n') {
            zay(bufferedReader, zaf);
            return false;
        } else if (zaw == 't') {
            zay(bufferedReader, z ? zah : zag);
            return true;
        } else {
            StringBuilder sb = new StringBuilder(19);
            sb.append("Unexpected token: ");
            sb.append(zaw);
            throw new ParseException(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float zas(BufferedReader bufferedReader) throws ParseException, IOException {
        int zax = zax(bufferedReader, this.zac);
        if (zax == 0) {
            return 0.0f;
        }
        return Float.parseFloat(new String(this.zac, 0, zax));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double zat(BufferedReader bufferedReader) throws ParseException, IOException {
        int zax = zax(bufferedReader, this.zac);
        if (zax == 0) {
            return 0.0d;
        }
        return Double.parseDouble(new String(this.zac, 0, zax));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BigDecimal zau(BufferedReader bufferedReader) throws ParseException, IOException {
        int zax = zax(bufferedReader, this.zac);
        if (zax == 0) {
            return null;
        }
        return new BigDecimal(new String(this.zac, 0, zax));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T extends FastJsonResponse> ArrayList<T> zav(BufferedReader bufferedReader, FastJsonResponse.Field<?, ?> field) throws ParseException, IOException {
        ArrayList<T> arrayList = (ArrayList<T>) new ArrayList();
        char zaw = zaw(bufferedReader);
        if (zaw == ']') {
            zaz(5);
            return arrayList;
        } else if (zaw == 'n') {
            zay(bufferedReader, zaf);
            zaz(5);
            return null;
        } else if (zaw == '{') {
            this.zal.push(1);
            while (true) {
                try {
                    FastJsonResponse zaf2 = field.zaf();
                    if (!zai(bufferedReader, zaf2)) {
                        return arrayList;
                    }
                    arrayList.add(zaf2);
                    char zaw2 = zaw(bufferedReader);
                    if (zaw2 != ',') {
                        if (zaw2 == ']') {
                            zaz(5);
                            return arrayList;
                        }
                        StringBuilder sb = new StringBuilder(19);
                        sb.append("Unexpected token: ");
                        sb.append(zaw2);
                        throw new ParseException(sb.toString());
                    } else if (zaw(bufferedReader) == '{') {
                        this.zal.push(1);
                    } else {
                        throw new ParseException("Expected start of next object in array");
                    }
                } catch (IllegalAccessException e) {
                    throw new ParseException("Error instantiating inner object", e);
                } catch (InstantiationException e2) {
                    throw new ParseException("Error instantiating inner object", e2);
                }
            }
        } else {
            StringBuilder sb2 = new StringBuilder(19);
            sb2.append("Unexpected token: ");
            sb2.append(zaw);
            throw new ParseException(sb2.toString());
        }
    }

    private final char zaw(BufferedReader bufferedReader) throws ParseException, IOException {
        if (bufferedReader.read(this.zaa) != -1) {
            while (Character.isWhitespace(this.zaa[0])) {
                if (bufferedReader.read(this.zaa) == -1) {
                    return (char) 0;
                }
            }
            return this.zaa[0];
        }
        return (char) 0;
    }

    private final int zax(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i;
        char zaw = zaw(bufferedReader);
        if (zaw != 0) {
            if (zaw != ',') {
                if (zaw == 'n') {
                    zay(bufferedReader, zaf);
                    return 0;
                }
                bufferedReader.mark(1024);
                if (zaw == '\"') {
                    i = 0;
                    boolean z = false;
                    while (i < cArr.length && bufferedReader.read(cArr, i, 1) != -1) {
                        char c = cArr[i];
                        if (Character.isISOControl(c)) {
                            throw new ParseException("Unexpected control character while reading string");
                        }
                        if (c == '\"') {
                            if (!z) {
                                bufferedReader.reset();
                                bufferedReader.skip(i + 1);
                                return i;
                            }
                        } else if (c == '\\') {
                            z = !z;
                            i++;
                        }
                        z = false;
                        i++;
                    }
                } else {
                    cArr[0] = zaw;
                    i = 1;
                    while (i < cArr.length && bufferedReader.read(cArr, i, 1) != -1) {
                        char c2 = cArr[i];
                        if (c2 == '}' || c2 == ',' || Character.isWhitespace(c2) || cArr[i] == ']') {
                            bufferedReader.reset();
                            bufferedReader.skip(i - 1);
                            cArr[i] = 0;
                            return i;
                        }
                        i++;
                    }
                }
                if (i == cArr.length) {
                    throw new ParseException("Absurdly long value");
                }
                throw new ParseException("Unexpected EOF");
            }
            throw new ParseException("Missing value");
        }
        throw new ParseException("Unexpected EOF");
    }

    private final void zay(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i = 0;
        while (true) {
            int length = cArr.length;
            if (i >= length) {
                return;
            }
            int read = bufferedReader.read(this.zab, 0, length - i);
            if (read == -1) {
                throw new ParseException("Unexpected EOF");
            }
            for (int i2 = 0; i2 < read; i2++) {
                if (cArr[i2 + i] != this.zab[i2]) {
                    throw new ParseException("Unexpected character");
                }
            }
            i += read;
        }
    }

    private final void zaz(int i) throws ParseException {
        if (this.zal.isEmpty()) {
            StringBuilder sb = new StringBuilder(46);
            sb.append("Expected state ");
            sb.append(i);
            sb.append(" but had empty stack");
            throw new ParseException(sb.toString());
        }
        int intValue = this.zal.pop().intValue();
        if (intValue == i) {
            return;
        }
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("Expected state ");
        sb2.append(i);
        sb2.append(" but had ");
        sb2.append(intValue);
        throw new ParseException(sb2.toString());
    }

    public void parse(InputStream inputStream, T t) throws ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        try {
            try {
                this.zal.push(0);
                char zaw = zaw(bufferedReader);
                if (zaw != 0) {
                    if (zaw == '[') {
                        this.zal.push(5);
                        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = t.getFieldMappings();
                        if (fieldMappings.size() != 1) {
                            throw new ParseException("Object array response class must have a single Field");
                        }
                        FastJsonResponse.Field<?, ?> value = fieldMappings.entrySet().iterator().next().getValue();
                        t.addConcreteTypeArrayInternal(value, value.zae, zav(bufferedReader, value));
                    } else if (zaw == '{') {
                        this.zal.push(1);
                        zai(bufferedReader, t);
                    } else {
                        StringBuilder sb = new StringBuilder(19);
                        sb.append("Unexpected token: ");
                        sb.append(zaw);
                        throw new ParseException(sb.toString());
                    }
                    zaz(0);
                    try {
                        bufferedReader.close();
                        return;
                    } catch (IOException unused) {
                        Log.w("FastParser", "Failed to close reader while parsing.");
                        return;
                    }
                }
                throw new ParseException("No data to parse");
            } catch (IOException e) {
                throw new ParseException(e);
            }
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
                Log.w("FastParser", "Failed to close reader while parsing.");
            }
            throw th;
        }
    }
}
