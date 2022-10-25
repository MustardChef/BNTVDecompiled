package org.mozilla.universalchardet.prober;

import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.statemachine.CodingStateMachine;
import org.mozilla.universalchardet.prober.statemachine.SMModel;
import org.mozilla.universalchardet.prober.statemachine.UTF8SMModel;

/* loaded from: classes5.dex */
public class UTF8Prober extends CharsetProber {
    public static final float ONE_CHAR_PROB = 0.5f;
    private static final SMModel smModel = new UTF8SMModel();
    private CharsetProber.ProbingState state;
    private int numOfMBChar = 0;
    private CodingStateMachine codingSM = new CodingStateMachine(smModel);

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void setOption() {
    }

    public UTF8Prober() {
        reset();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String getCharSetName() {
        return Constants.CHARSET_UTF_8;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState handleData(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        while (true) {
            if (i >= i3) {
                break;
            }
            int nextState = this.codingSM.nextState(bArr[i]);
            if (nextState == 1) {
                this.state = CharsetProber.ProbingState.NOT_ME;
                break;
            } else if (nextState == 2) {
                this.state = CharsetProber.ProbingState.FOUND_IT;
                break;
            } else {
                if (nextState == 0 && this.codingSM.getCurrentCharLen() >= 2) {
                    this.numOfMBChar++;
                }
                i++;
            }
        }
        if (this.state == CharsetProber.ProbingState.DETECTING && getConfidence() > 0.95f) {
            this.state = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.state;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState getState() {
        return this.state;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public final void reset() {
        this.codingSM.reset();
        this.numOfMBChar = 0;
        this.state = CharsetProber.ProbingState.DETECTING;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float getConfidence() {
        float f = 0.99f;
        if (this.numOfMBChar < 6) {
            for (int i = 0; i < this.numOfMBChar; i++) {
                f *= 0.5f;
            }
            return 1.0f - f;
        }
        return 0.99f;
    }
}
