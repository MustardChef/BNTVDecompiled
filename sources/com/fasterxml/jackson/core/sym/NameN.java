package com.fasterxml.jackson.core.sym;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class NameN extends Name {

    /* renamed from: q */
    private final int[] f2789q;

    /* renamed from: q1 */
    private final int f2790q1;

    /* renamed from: q2 */
    private final int f2791q2;

    /* renamed from: q3 */
    private final int f2792q3;

    /* renamed from: q4 */
    private final int f2793q4;
    private final int qlen;

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i2) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i2, int i3) {
        return false;
    }

    NameN(String str, int i, int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        super(str, i);
        this.f2790q1 = i2;
        this.f2791q2 = i3;
        this.f2792q3 = i4;
        this.f2793q4 = i5;
        this.f2789q = iArr;
        this.qlen = i6;
    }

    public static NameN construct(String str, int i, int[] iArr, int i2) {
        if (i2 < 4) {
            throw new IllegalArgumentException();
        }
        return new NameN(str, i, iArr[0], iArr[1], iArr[2], iArr[3], i2 + (-4) > 0 ? Arrays.copyOfRange(iArr, 4, i2) : null, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0040 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0054 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0055 A[RETURN] */
    @Override // com.fasterxml.jackson.core.sym.Name
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(int[] r7, int r8) {
        /*
            r6 = this;
            int r0 = r6.qlen
            r1 = 0
            if (r8 == r0) goto L6
            return r1
        L6:
            r0 = r7[r1]
            int r2 = r6.f2790q1
            if (r0 == r2) goto Ld
            return r1
        Ld:
            r0 = 1
            r2 = r7[r0]
            int r3 = r6.f2791q2
            if (r2 == r3) goto L15
            return r1
        L15:
            r2 = 2
            r3 = r7[r2]
            int r4 = r6.f2792q3
            if (r3 == r4) goto L1d
            return r1
        L1d:
            r3 = 3
            r4 = r7[r3]
            int r5 = r6.f2793q4
            if (r4 == r5) goto L25
            return r1
        L25:
            switch(r8) {
                case 4: goto L55;
                case 5: goto L4b;
                case 6: goto L41;
                case 7: goto L37;
                case 8: goto L2d;
                default: goto L28;
            }
        L28:
            boolean r7 = r6._equals2(r7)
            return r7
        L2d:
            r8 = 7
            r8 = r7[r8]
            int[] r4 = r6.f2789q
            r3 = r4[r3]
            if (r8 == r3) goto L37
            return r1
        L37:
            r8 = 6
            r8 = r7[r8]
            int[] r3 = r6.f2789q
            r2 = r3[r2]
            if (r8 == r2) goto L41
            return r1
        L41:
            r8 = 5
            r8 = r7[r8]
            int[] r2 = r6.f2789q
            r2 = r2[r0]
            if (r8 == r2) goto L4b
            return r1
        L4b:
            r8 = 4
            r7 = r7[r8]
            int[] r8 = r6.f2789q
            r8 = r8[r1]
            if (r7 == r8) goto L55
            return r1
        L55:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.sym.NameN.equals(int[], int):boolean");
    }

    private final boolean _equals2(int[] iArr) {
        int i = this.qlen - 4;
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2 + 4] != this.f2789q[i2]) {
                return false;
            }
        }
        return true;
    }
}
