package com.google.common.base;

import com.google.common.base.CharMatcher;
import java.util.BitSet;

/* loaded from: classes3.dex */
final class SmallCharMatcher extends CharMatcher.NamedFastMatcher {

    /* renamed from: C1 */
    private static final int f9775C1 = -862048943;

    /* renamed from: C2 */
    private static final int f9776C2 = 461845907;
    private static final double DESIRED_LOAD_FACTOR = 0.5d;
    static final int MAX_SIZE = 1023;
    private final boolean containsZero;
    private final long filter;
    private final char[] table;

    private SmallCharMatcher(char[] cArr, long j, boolean z, String str) {
        super(str);
        this.table = cArr;
        this.filter = j;
        this.containsZero = z;
    }

    static int smear(int i) {
        return Integer.rotateLeft(i * f9775C1, 15) * f9776C2;
    }

    private boolean checkFilter(int i) {
        return 1 == ((this.filter >> i) & 1);
    }

    static int chooseTableSize(int i) {
        if (i == 1) {
            return 2;
        }
        int highestOneBit = Integer.highestOneBit(i - 1) << 1;
        while (highestOneBit * 0.5d < i) {
            highestOneBit <<= 1;
        }
        return highestOneBit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CharMatcher from(BitSet bitSet, String str) {
        int i;
        int cardinality = bitSet.cardinality();
        boolean z = bitSet.get(0);
        int chooseTableSize = chooseTableSize(cardinality);
        char[] cArr = new char[chooseTableSize];
        int i2 = chooseTableSize - 1;
        int nextSetBit = bitSet.nextSetBit(0);
        long j = 0;
        while (nextSetBit != -1) {
            long j2 = (1 << nextSetBit) | j;
            int smear = smear(nextSetBit);
            while (true) {
                i = smear & i2;
                if (cArr[i] == 0) {
                    break;
                }
                smear = i + 1;
            }
            cArr[i] = (char) nextSetBit;
            nextSetBit = bitSet.nextSetBit(nextSetBit + 1);
            j = j2;
        }
        return new SmallCharMatcher(cArr, j, z, str);
    }

    @Override // com.google.common.base.CharMatcher
    public boolean matches(char c) {
        if (c == 0) {
            return this.containsZero;
        }
        if (checkFilter(c)) {
            int length = this.table.length - 1;
            int smear = smear(c) & length;
            int i = smear;
            do {
                char[] cArr = this.table;
                if (cArr[i] == 0) {
                    return false;
                }
                if (cArr[i] == c) {
                    return true;
                }
                i = (i + 1) & length;
            } while (i != smear);
            return false;
        }
        return false;
    }

    @Override // com.google.common.base.CharMatcher
    void setBits(BitSet bitSet) {
        char[] cArr;
        if (this.containsZero) {
            bitSet.set(0);
        }
        for (char c : this.table) {
            if (c != 0) {
                bitSet.set(c);
            }
        }
    }
}
