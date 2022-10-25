package org.mozilla.universalchardet.prober;

import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes5.dex */
public class HebrewProber extends CharsetProber {
    public static final int FINAL_KAF = 234;
    public static final int FINAL_MEM = 237;
    public static final int FINAL_NUN = 239;
    public static final int FINAL_PE = 243;
    public static final int FINAL_TSADI = 245;
    public static final int MIN_FINAL_CHAR_DISTANCE = 5;
    public static final float MIN_MODEL_DISTANCE = 0.01f;
    public static final int NORMAL_KAF = 235;
    public static final int NORMAL_MEM = 238;
    public static final int NORMAL_NUN = 240;
    public static final int NORMAL_PE = 244;
    public static final int NORMAL_TSADI = 246;
    public static final byte SPACE = 32;
    private byte beforePrev;
    private int finalCharLogicalScore;
    private int finalCharVisualScore;
    private byte prev;
    private CharsetProber logicalProber = null;
    private CharsetProber visualProber = null;

    protected static boolean isFinal(byte b) {
        int i = b & 255;
        return i == 234 || i == 237 || i == 239 || i == 243 || i == 245;
    }

    protected static boolean isNonFinal(byte b) {
        int i = b & 255;
        return i == 235 || i == 238 || i == 240 || i == 244;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float getConfidence() {
        return 0.0f;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void setOption() {
    }

    public HebrewProber() {
        reset();
    }

    public void setModalProbers(CharsetProber charsetProber, CharsetProber charsetProber2) {
        this.logicalProber = charsetProber;
        this.visualProber = charsetProber2;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String getCharSetName() {
        int i = this.finalCharLogicalScore - this.finalCharVisualScore;
        if (i >= 5) {
            return Constants.CHARSET_WINDOWS_1255;
        }
        if (i <= -5) {
            return Constants.CHARSET_ISO_8859_8;
        }
        float confidence = this.logicalProber.getConfidence() - this.visualProber.getConfidence();
        if (confidence > 0.01f) {
            return Constants.CHARSET_WINDOWS_1255;
        }
        if (confidence < -0.01f) {
            return Constants.CHARSET_ISO_8859_8;
        }
        if (i < 0) {
            return Constants.CHARSET_ISO_8859_8;
        }
        return Constants.CHARSET_WINDOWS_1255;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState getState() {
        if (this.logicalProber.getState() == CharsetProber.ProbingState.NOT_ME && this.visualProber.getState() == CharsetProber.ProbingState.NOT_ME) {
            return CharsetProber.ProbingState.NOT_ME;
        }
        return CharsetProber.ProbingState.DETECTING;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState handleData(byte[] bArr, int i, int i2) {
        if (getState() == CharsetProber.ProbingState.NOT_ME) {
            return CharsetProber.ProbingState.NOT_ME;
        }
        int i3 = i2 + i;
        while (i < i3) {
            byte b = bArr[i];
            if (b == 32) {
                if (this.beforePrev != 32) {
                    if (isFinal(this.prev)) {
                        this.finalCharLogicalScore++;
                    } else if (isNonFinal(this.prev)) {
                        this.finalCharVisualScore++;
                    }
                }
            } else if (this.beforePrev == 32 && isFinal(this.prev) && b != 32) {
                this.finalCharVisualScore++;
            }
            this.beforePrev = this.prev;
            this.prev = b;
            i++;
        }
        return CharsetProber.ProbingState.DETECTING;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public final void reset() {
        this.finalCharLogicalScore = 0;
        this.finalCharVisualScore = 0;
        this.prev = (byte) 32;
        this.beforePrev = (byte) 32;
    }
}
