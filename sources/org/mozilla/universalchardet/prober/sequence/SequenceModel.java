package org.mozilla.universalchardet.prober.sequence;

/* loaded from: classes5.dex */
public abstract class SequenceModel {
    protected short[] charToOrderMap;
    protected String charsetName;
    protected boolean keepEnglishLetter;
    protected byte[] precedenceMatrix;
    protected float typicalPositiveRatio;

    public SequenceModel(short[] sArr, byte[] bArr, float f, boolean z, String str) {
        this.charToOrderMap = (short[]) sArr.clone();
        this.precedenceMatrix = (byte[]) bArr.clone();
        this.typicalPositiveRatio = f;
        this.keepEnglishLetter = z;
        this.charsetName = str;
    }

    public short getOrder(byte b) {
        return this.charToOrderMap[b & 255];
    }

    public byte getPrecedence(int i) {
        return this.precedenceMatrix[i];
    }

    public float getTypicalPositiveRatio() {
        return this.typicalPositiveRatio;
    }

    public boolean getKeepEnglishLetter() {
        return this.keepEnglishLetter;
    }

    public String getCharsetName() {
        return this.charsetName;
    }
}
