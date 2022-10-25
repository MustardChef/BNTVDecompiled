package org.mozilla.universalchardet.prober.distributionanalysis;

/* loaded from: classes5.dex */
public class EUCJPDistributionAnalysis extends JISDistributionAnalysis {
    public static final int HIGHBYTE_BEGIN = 161;
    public static final int HIGHBYTE_END = 254;
    public static final int LOWBYTE_BEGIN = 161;
    public static final int LOWBYTE_END = 254;

    @Override // org.mozilla.universalchardet.prober.distributionanalysis.CharDistributionAnalysis
    protected int getOrder(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        if (i2 >= 161) {
            return (((i2 - 161) * 94) + (bArr[i + 1] & 255)) - 161;
        }
        return -1;
    }
}
