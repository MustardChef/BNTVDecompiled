package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aau */
/* loaded from: classes2.dex */
public final class aau extends aaq {
    public static final Parcelable.Creator<aau> CREATOR = new aag(9);

    /* renamed from: a */
    public final String f2928a;

    /* renamed from: b */
    public final String f2929b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public aau(android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = r3.readString()
            int r1 = com.google.ads.interactivemedia.p034v3.internal.C2628cq.f6961a
            r2.<init>(r0)
            java.lang.String r0 = r3.readString()
            r2.f2928a = r0
            java.lang.String r3 = r3.readString()
            r2.f2929b = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.aau.<init>(android.os.Parcel):void");
    }

    /* renamed from: b */
    private static List m5964b(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
            } else if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.ads.interactivemedia.p034v3.internal.aaq, com.google.ads.interactivemedia.p034v3.internal.InterfaceC2548aj
    /* renamed from: a */
    public final void mo1383a(C2545ag c2545ag) {
        char c;
        String str = this.f2917f;
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 82878:
                if (str.equals("TCM")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 82897:
                if (str.equals("TDA")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 83253:
                if (str.equals("TP1")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 83254:
                if (str.equals("TP2")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 83255:
                if (str.equals("TP3")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 83341:
                if (str.equals("TRK")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 83378:
                if (str.equals("TT2")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 83536:
                if (str.equals("TXT")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 83552:
                if (str.equals("TYE")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 2569357:
                if (str.equals("TCOM")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 2569891:
                if (str.equals("TDAT")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 2570401:
                if (str.equals("TDRC")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 2570410:
                if (str.equals("TDRL")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 2571565:
                if (str.equals("TEXT")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 2581514:
                if (str.equals("TPE3")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
                c2545ag.m5494H(this.f2929b);
                return;
            case 2:
            case 3:
                c2545ag.m5467x(this.f2929b);
                return;
            case 4:
            case 5:
                c2545ag.m5469v(this.f2929b);
                return;
            case 6:
            case 7:
                c2545ag.m5468w(this.f2929b);
                return;
            case '\b':
            case '\t':
                String[] m2547ai = C2628cq.m2547ai(this.f2929b, "/");
                try {
                    int parseInt = Integer.parseInt(m2547ai[0]);
                    Integer valueOf = m2547ai.length > 1 ? Integer.valueOf(Integer.parseInt(m2547ai[1])) : null;
                    c2545ag.m5492J(Integer.valueOf(parseInt));
                    c2545ag.m5493I(valueOf);
                    return;
                } catch (NumberFormatException unused) {
                    return;
                }
            case '\n':
            case 11:
                try {
                    c2545ag.m5498D(Integer.valueOf(Integer.parseInt(this.f2929b)));
                    return;
                } catch (NumberFormatException unused2) {
                    return;
                }
            case '\f':
            case '\r':
                try {
                    int parseInt2 = Integer.parseInt(this.f2929b.substring(2, 4));
                    int parseInt3 = Integer.parseInt(this.f2929b.substring(0, 2));
                    c2545ag.m5499C(Integer.valueOf(parseInt2));
                    c2545ag.m5500B(Integer.valueOf(parseInt3));
                    return;
                } catch (NumberFormatException | StringIndexOutOfBoundsException unused3) {
                    return;
                }
            case 14:
                List m5964b = m5964b(this.f2929b);
                int size = m5964b.size();
                if (size != 1) {
                    if (size != 2) {
                        if (size != 3) {
                            return;
                        }
                        c2545ag.m5500B((Integer) m5964b.get(2));
                    }
                    c2545ag.m5499C((Integer) m5964b.get(1));
                }
                c2545ag.m5498D((Integer) m5964b.get(0));
                return;
            case 15:
                List m5964b2 = m5964b(this.f2929b);
                int size2 = m5964b2.size();
                if (size2 != 1) {
                    if (size2 != 2) {
                        if (size2 != 3) {
                            return;
                        }
                        c2545ag.m5497E((Integer) m5964b2.get(2));
                    }
                    c2545ag.m5496F((Integer) m5964b2.get(1));
                }
                c2545ag.m5495G((Integer) m5964b2.get(0));
                return;
            case 16:
            case 17:
                c2545ag.m5465z(this.f2929b);
                return;
            case 18:
            case 19:
                c2545ag.m5501A(this.f2929b);
                return;
            case 20:
            case 21:
                c2545ag.m5491K(this.f2929b);
                return;
            default:
                return;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            aau aauVar = (aau) obj;
            if (C2628cq.m2563T(this.f2917f, aauVar.f2917f) && C2628cq.m2563T(this.f2928a, aauVar.f2928a) && C2628cq.m2563T(this.f2929b, aauVar.f2929b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.f2917f.hashCode() + 527) * 31;
        String str = this.f2928a;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f2929b;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aaq
    public final String toString() {
        String str = this.f2917f;
        String str2 = this.f2928a;
        String str3 = this.f2929b;
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 22 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append(": description=");
        sb.append(str2);
        sb.append(": value=");
        sb.append(str3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2917f);
        parcel.writeString(this.f2928a);
        parcel.writeString(this.f2929b);
    }

    public aau(String str, String str2, String str3) {
        super(str);
        this.f2928a = str2;
        this.f2929b = str3;
    }
}
