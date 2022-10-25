package org.mozilla.universalchardet.prober.distributionanalysis;

/* loaded from: classes5.dex */
public abstract class CharDistributionAnalysis {
    public static final int ENOUGH_DATA_THRESHOLD = 1024;
    public static final int MINIMUM_DATA_THRESHOLD = 4;
    public static final float SURE_NO = 0.01f;
    public static final float SURE_YES = 0.99f;
    protected int[] charToFreqOrder;
    private int freqChars;
    private int totalChars;
    protected float typicalDistributionRatio;

    protected abstract int getOrder(byte[] bArr, int i);

    public void handleData(byte[] bArr, int i, int i2) {
    }

    public void setOption() {
    }

    public CharDistributionAnalysis() {
        reset();
    }

    public void handleOneChar(byte[] bArr, int i, int i2) {
        int order = i2 == 2 ? getOrder(bArr, i) : -1;
        if (order >= 0) {
            this.totalChars++;
            int[] iArr = this.charToFreqOrder;
            if (order >= iArr.length || 512 <= iArr[order]) {
                return;
            }
            this.freqChars++;
        }
    }

    public float getConfidence() {
        int i;
        int i2 = this.totalChars;
        if (i2 <= 0 || (i = this.freqChars) <= 4) {
            return 0.01f;
        }
        if (i2 != i) {
            float f = i / ((i2 - i) * this.typicalDistributionRatio);
            if (f < 0.99f) {
                return f;
            }
        }
        return 0.99f;
    }

    public final void reset() {
        this.totalChars = 0;
        this.freqChars = 0;
    }

    public boolean gotEnoughData() {
        return this.totalChars > 1024;
    }
}
