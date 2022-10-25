package org.mozilla.universalchardet.prober.distributionanalysis;

/* loaded from: classes5.dex */
public class SJISDistributionAnalysis extends JISDistributionAnalysis {
    public static final int HIGHBYTE_BEGIN_1 = 129;
    public static final int HIGHBYTE_BEGIN_2 = 224;
    public static final int HIGHBYTE_END_1 = 159;
    public static final int HIGHBYTE_END_2 = 239;
    public static final int LOWBYTE_BEGIN_1 = 64;
    public static final int LOWBYTE_BEGIN_2 = 128;

    @Override // org.mozilla.universalchardet.prober.distributionanalysis.CharDistributionAnalysis
    protected int getOrder(byte[] bArr, int i) {
        int i2;
        int i3 = bArr[i] & 255;
        if (i3 >= 129 && i3 <= 159) {
            i2 = i3 - 129;
        } else if (i3 < 224 || i3 > 239) {
            return -1;
        } else {
            i2 = (i3 - 224) + 31;
        }
        int i4 = i2 * 188;
        int i5 = bArr[i + 1] & 255;
        int i6 = i4 + (i5 - 64);
        return i5 >= 128 ? i6 - 1 : i6;
    }
}
