package org.mozilla.universalchardet.prober.statemachine;

/* loaded from: classes5.dex */
public class CodingStateMachine {
    protected int currentBytePos;
    protected int currentCharLen;
    protected int currentState = 0;
    protected SMModel model;

    public CodingStateMachine(SMModel sMModel) {
        this.model = sMModel;
    }

    public int nextState(byte b) {
        int i = this.model.getClass(b);
        if (this.currentState == 0) {
            this.currentBytePos = 0;
            this.currentCharLen = this.model.getCharLen(i);
        }
        int nextState = this.model.getNextState(i, this.currentState);
        this.currentState = nextState;
        this.currentBytePos++;
        return nextState;
    }

    public int getCurrentCharLen() {
        return this.currentCharLen;
    }

    public void reset() {
        this.currentState = 0;
    }

    public String getCodingStateMachine() {
        return this.model.getName();
    }
}
