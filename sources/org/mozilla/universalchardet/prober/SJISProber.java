package org.mozilla.universalchardet.prober;

import java.util.Arrays;
import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.contextanalysis.SJISContextAnalysis;
import org.mozilla.universalchardet.prober.distributionanalysis.SJISDistributionAnalysis;
import org.mozilla.universalchardet.prober.statemachine.CodingStateMachine;
import org.mozilla.universalchardet.prober.statemachine.SJISSMModel;
import org.mozilla.universalchardet.prober.statemachine.SMModel;

/* loaded from: classes5.dex */
public class SJISProber extends CharsetProber {
    private static final SMModel smModel = new SJISSMModel();
    private CodingStateMachine codingSM = new CodingStateMachine(smModel);
    private SJISContextAnalysis contextAnalyzer = new SJISContextAnalysis();
    private SJISDistributionAnalysis distributionAnalyzer = new SJISDistributionAnalysis();
    private byte[] lastChar = new byte[2];
    private CharsetProber.ProbingState state;

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void setOption() {
    }

    public SJISProber() {
        reset();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String getCharSetName() {
        return Constants.CHARSET_SHIFT_JIS;
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
                        this.contextAnalyzer.handleOneChar(bArr2, 2 - currentCharLen, currentCharLen);
                        this.distributionAnalyzer.handleOneChar(this.lastChar, 0, currentCharLen);
                    } else {
                        this.contextAnalyzer.handleOneChar(bArr, (i4 + 1) - currentCharLen, currentCharLen);
                        this.distributionAnalyzer.handleOneChar(bArr, i4 - 1, currentCharLen);
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
