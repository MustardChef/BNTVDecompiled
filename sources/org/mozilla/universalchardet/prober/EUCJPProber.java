package org.mozilla.universalchardet.prober;

import java.util.Arrays;
import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.contextanalysis.EUCJPContextAnalysis;
import org.mozilla.universalchardet.prober.distributionanalysis.EUCJPDistributionAnalysis;
import org.mozilla.universalchardet.prober.statemachine.CodingStateMachine;
import org.mozilla.universalchardet.prober.statemachine.EUCJPSMModel;
import org.mozilla.universalchardet.prober.statemachine.SMModel;

/* loaded from: classes5.dex */
public class EUCJPProber extends CharsetProber {
    private static final SMModel smModel = new EUCJPSMModel();
    private CodingStateMachine codingSM = new CodingStateMachine(smModel);
    private EUCJPContextAnalysis contextAnalyzer = new EUCJPContextAnalysis();
    private EUCJPDistributionAnalysis distributionAnalyzer = new EUCJPDistributionAnalysis();
    private byte[] lastChar = new byte[2];
    private CharsetProber.ProbingState state;

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void setOption() {
    }

    public EUCJPProber() {
        reset();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String getCharSetName() {
        return Constants.CHARSET_EUC_JP;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float getConfidence() {
        return Math.max(this.contextAnalyzer.getConfidence(), this.distributionAnalyzer.getConfidence());
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState getState() {
        return this.state;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState handleData(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        int i4 = i;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            int nextState = this.codingSM.nextState(bArr[i4]);
            if (nextState == 1) {
                this.state = CharsetProber.ProbingState.NOT_ME;
                break;
            } else if (nextState == 2) {
                this.state = CharsetProber.ProbingState.FOUND_IT;
                break;
            } else {
                if (nextState == 0) {
                    int currentCharLen = this.codingSM.getCurrentCharLen();
                    if (i4 == i) {
                        byte[] bArr2 = this.lastChar;
                        bArr2[1] = bArr[i];
                        this.contextAnalyzer.handleOneChar(bArr2, 0, currentCharLen);
                        this.distributionAnalyzer.handleOneChar(this.lastChar, 0, currentCharLen);
                    } else {
                        int i5 = i4 - 1;
                        this.contextAnalyzer.handleOneChar(bArr, i5, currentCharLen);
                        this.distributionAnalyzer.handleOneChar(bArr, i5, currentCharLen);
                    }
                }
                i4++;
            }
        }
        this.lastChar[0] = bArr[i3 - 1];
        if (this.state == CharsetProber.ProbingState.DETECTING && this.contextAnalyzer.gotEnoughData() && getConfidence() > 0.95f) {
            this.state = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.state;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public final void reset() {
        this.codingSM.reset();
        this.state = CharsetProber.ProbingState.DETECTING;
        this.contextAnalyzer.reset();
        this.distributionAnalyzer.reset();
        Arrays.fill(this.lastChar, (byte) 0);
    }
}
