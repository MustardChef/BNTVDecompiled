package org.mozilla.universalchardet.prober.contextanalysis;

import org.mozilla.universalchardet.prober.contextanalysis.JapaneseContextAnalysis;

/* loaded from: classes5.dex */
public class SJISContextAnalysis extends JapaneseContextAnalysis {
    public static final int HIGHBYTE_BEGIN_1 = 129;
    public static final int HIGHBYTE_BEGIN_2 = 224;
    public static final int HIGHBYTE_END_1 = 159;
    public static final int HIGHBYTE_END_2 = 239;
    public static final int HIRAGANA_HIGHBYTE = 130;
    public static final int HIRAGANA_LOWBYTE_BEGIN = 159;
    public static final int HIRAGANA_LOWBYTE_END = 241;

    @Override // org.mozilla.universalchardet.prober.contextanalysis.JapaneseContextAnalysis
    protected void getOrder(JapaneseContextAnalysis.Order order, byte[] bArr, int i) {
        int i2;
        order.order = -1;
        order.charLength = 1;
        int i3 = bArr[i] & 255;
        if ((i3 >= 129 && i3 <= 159) || (i3 >= 224 && i3 <= 239)) {
            order.charLength = 2;
        }
        if (i3 != 130 || (i2 = bArr[i + 1] & 255) < 159 || i2 > 241) {
            return;
        }
        order.order = i2 - 159;
    }

    @Override // org.mozilla.universalchardet.prober.contextanalysis.JapaneseContextAnalysis
    protected int getOrder(byte[] bArr, int i) {
        int i2;
        if ((bArr[i] & 255) != 130 || (i2 = bArr[i + 1] & 255) < 159 || i2 > 241) {
            return -1;
        }
        return i2 - 159;
    }
}
