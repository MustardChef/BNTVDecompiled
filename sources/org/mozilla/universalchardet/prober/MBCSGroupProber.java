package org.mozilla.universalchardet.prober;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes5.dex */
public class MBCSGroupProber extends CharsetProber {
    private int activeNum;
    private CharsetProber bestGuess;
    private List<CharsetProber> probers;
    private CharsetProber.ProbingState state;

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void setOption() {
    }

    public MBCSGroupProber() {
        ArrayList arrayList = new ArrayList();
        this.probers = arrayList;
        arrayList.add(new UTF8Prober());
        this.probers.add(new SJISProber());
        this.probers.add(new EUCJPProber());
        this.probers.add(new GB18030Prober());
        this.probers.add(new EUCKRProber());
        this.probers.add(new Big5Prober());
        this.probers.add(new EUCTWProber());
        reset();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String getCharSetName() {
        if (this.bestGuess == null) {
            getConfidence();
            if (this.bestGuess == null) {
                this.bestGuess = this.probers.get(0);
            }
        }
        return this.bestGuess.getCharSetName();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float getConfidence() {
        if (this.state == CharsetProber.ProbingState.FOUND_IT) {
            return 0.99f;
        }
        if (this.state == CharsetProber.ProbingState.NOT_ME) {
            return 0.01f;
        }
        float f = 0.0f;
        for (CharsetProber charsetProber : this.probers) {
            if (charsetProber.isActive()) {
                float confidence = charsetProber.getConfidence();
                if (f < confidence) {
                    this.bestGuess = charsetProber;
                    f = confidence;
                }
            }
        }
        return f;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState getState() {
        return this.state;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState handleData(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        int i3 = i2 + i;
        boolean z = true;
        int i4 = 0;
        while (i < i3) {
            if ((bArr[i] & 128) != 0) {
                bArr2[i4] = bArr[i];
                i4++;
                z = true;
            } else if (z) {
                bArr2[i4] = bArr[i];
                i4++;
                z = false;
            }
            i++;
        }
        Iterator<CharsetProber> it = this.probers.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            CharsetProber next = it.next();
            if (next.isActive()) {
                CharsetProber.ProbingState handleData = next.handleData(bArr2, 0, i4);
                if (handleData == CharsetProber.ProbingState.FOUND_IT) {
                    this.bestGuess = next;
                    this.state = CharsetProber.ProbingState.FOUND_IT;
                    break;
                } else if (handleData == CharsetProber.ProbingState.NOT_ME) {
                    next.setActive(false);
                    int i5 = this.activeNum - 1;
                    this.activeNum = i5;
                    if (i5 <= 0) {
                        this.state = CharsetProber.ProbingState.NOT_ME;
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        return this.state;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public final void reset() {
        this.activeNum = 0;
        for (CharsetProber charsetProber : this.probers) {
            charsetProber.reset();
            charsetProber.setActive(true);
            this.activeNum++;
        }
        this.bestGuess = null;
        this.state = CharsetProber.ProbingState.DETECTING;
    }
}
