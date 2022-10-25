package org.mozilla.universalchardet.prober.contextanalysis;

import org.mozilla.universalchardet.prober.contextanalysis.JapaneseContextAnalysis;

/* loaded from: classes5.dex */
public class EUCJPContextAnalysis extends JapaneseContextAnalysis {
    public static final int FIRSTPLANE_HIGHBYTE_BEGIN = 161;
    public static final int FIRSTPLANE_HIGHBYTE_END = 254;
    public static final int HIRAGANA_HIGHBYTE = 164;
    public static final int HIRAGANA_LOWBYTE_BEGIN = 161;
    public static final int HIRAGANA_LOWBYTE_END = 243;
    public static final int SINGLE_SHIFT_2 = 142;
    public static final int SINGLE_SHIFT_3 = 143;

    @Override // org.mozilla.universalchardet.prober.contextanalysis.JapaneseContextAnalysis
    protected void getOrder(JapaneseContextAnalysis.Order order, byte[] bArr, int i) {
        int i2;
        order.order = -1;
        order.charLength = 1;
        int i3 = bArr[i] & 255;
        if (i3 == 142 || (i3 >= 161 && i3 <= 254)) {
            order.charLength = 2;
        } else if (i3 == 143) {
            order.charLength = 3;
        }
        if (i3 != 164 || (i2 = bArr[i + 1] & 255) < 161 || i2 > 243) {
            return;
        }
        order.order = i2 - 161;
    }

    @Override // org.mozilla.universalchardet.prober.contextanalysis.JapaneseContextAnalysis
    protected int getOrder(byte[] bArr, int i) {
        int i2;
        if ((bArr[i] & 255) != 164 || (i2 = bArr[i + 1] & 255) < 161 || i2 > 243) {
            return -1;
        }
        return i2 - 161;
    }
}
