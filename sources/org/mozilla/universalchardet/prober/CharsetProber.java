package org.mozilla.universalchardet.prober;

import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public abstract class CharsetProber {
    public static final int ASCII_A = 97;
    public static final int ASCII_A_CAPITAL = 65;
    public static final int ASCII_GT = 62;
    public static final int ASCII_LT = 60;
    public static final int ASCII_SP = 32;
    public static final int ASCII_Z = 122;
    public static final int ASCII_Z_CAPITAL = 90;
    public static final float SHORTCUT_THRESHOLD = 0.95f;
    private boolean active = true;

    /* loaded from: classes5.dex */
    public enum ProbingState {
        DETECTING,
        FOUND_IT,
        NOT_ME
    }

    private boolean isAscii(byte b) {
        return (b & 128) == 0;
    }

    private boolean isAsciiSymbol(byte b) {
        int i = b & 255;
        return i < 65 || (i > 90 && i < 97) || i > 122;
    }

    public abstract String getCharSetName();

    public abstract float getConfidence();

    public abstract ProbingState getState();

    public abstract ProbingState handleData(byte[] bArr, int i, int i2);

    public abstract void reset();

    public abstract void setOption();

    public ByteBuffer filterWithoutEnglishLetters(byte[] bArr, int i, int i2) {
        ByteBuffer allocate = ByteBuffer.allocate(i2);
        int i3 = i2 + i;
        int i4 = i;
        boolean z = false;
        while (i < i3) {
            byte b = bArr[i];
            if (!isAscii(b)) {
                z = true;
            } else if (isAsciiSymbol(b)) {
                if (!z || i <= i4) {
                    i4 = i + 1;
                } else {
                    allocate.put(bArr, i4, i - i4);
                    allocate.put((byte) 32);
                    i4 = i + 1;
                    z = false;
                }
            }
            i++;
        }
        if (z && i > i4) {
            allocate.put(bArr, i4, i - i4);
        }
        return allocate;
    }

    public ByteBuffer filterWithEnglishLetters(byte[] bArr, int i, int i2) {
        ByteBuffer allocate = ByteBuffer.allocate(i2);
        int i3 = i2 + i;
        int i4 = i;
        boolean z = false;
        while (i < i3) {
            byte b = bArr[i];
            if (b == 62) {
                z = false;
            } else if (b == 60) {
                z = true;
            }
            if (isAscii(b) && isAsciiSymbol(b)) {
                if (i > i4 && !z) {
                    allocate.put(bArr, i4, i - i4);
                    allocate.put((byte) 32);
                }
                i4 = i + 1;
            }
            i++;
        }
        if (!z && i > i4) {
            allocate.put(bArr, i4, i - i4);
        }
        return allocate;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean z) {
        this.active = z;
    }
}
