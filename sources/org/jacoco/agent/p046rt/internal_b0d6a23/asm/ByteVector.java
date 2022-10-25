package org.jacoco.agent.p046rt.internal_b0d6a23.asm;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.ByteVector */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/ByteVector.class */
public class ByteVector {
    byte[] data;
    int length;

    public ByteVector() {
        this.data = new byte[64];
    }

    public ByteVector(int initialSize) {
        this.data = new byte[initialSize];
    }

    public ByteVector putByte(int b) {
        int length = this.length;
        if (length + 1 > this.data.length) {
            enlarge(1);
        }
        this.data[length] = (byte) b;
        this.length = length + 1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteVector put11(int b1, int b2) {
        int length = this.length;
        if (length + 2 > this.data.length) {
            enlarge(2);
        }
        byte[] data = this.data;
        int length2 = length + 1;
        data[length] = (byte) b1;
        data[length2] = (byte) b2;
        this.length = length2 + 1;
        return this;
    }

    public ByteVector putShort(int s) {
        int length = this.length;
        if (length + 2 > this.data.length) {
            enlarge(2);
        }
        byte[] data = this.data;
        int length2 = length + 1;
        data[length] = (byte) (s >>> 8);
        data[length2] = (byte) s;
        this.length = length2 + 1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteVector put12(int b, int s) {
        int length = this.length;
        if (length + 3 > this.data.length) {
            enlarge(3);
        }
        byte[] data = this.data;
        int length2 = length + 1;
        data[length] = (byte) b;
        int length3 = length2 + 1;
        data[length2] = (byte) (s >>> 8);
        data[length3] = (byte) s;
        this.length = length3 + 1;
        return this;
    }

    public ByteVector putInt(int i) {
        int length = this.length;
        if (length + 4 > this.data.length) {
            enlarge(4);
        }
        byte[] data = this.data;
        int length2 = length + 1;
        data[length] = (byte) (i >>> 24);
        int length3 = length2 + 1;
        data[length2] = (byte) (i >>> 16);
        int length4 = length3 + 1;
        data[length3] = (byte) (i >>> 8);
        data[length4] = (byte) i;
        this.length = length4 + 1;
        return this;
    }

    public ByteVector putLong(long l) {
        int length = this.length;
        if (length + 8 > this.data.length) {
            enlarge(8);
        }
        byte[] data = this.data;
        int i = (int) (l >>> 32);
        int length2 = length + 1;
        data[length] = (byte) (i >>> 24);
        int length3 = length2 + 1;
        data[length2] = (byte) (i >>> 16);
        int length4 = length3 + 1;
        data[length3] = (byte) (i >>> 8);
        int length5 = length4 + 1;
        data[length4] = (byte) i;
        int i2 = (int) l;
        int length6 = length5 + 1;
        data[length5] = (byte) (i2 >>> 24);
        int length7 = length6 + 1;
        data[length6] = (byte) (i2 >>> 16);
        int length8 = length7 + 1;
        data[length7] = (byte) (i2 >>> 8);
        data[length8] = (byte) i2;
        this.length = length8 + 1;
        return this;
    }

    public ByteVector putUTF8(String s) {
        int charLength = s.length();
        if (charLength > 65535) {
            throw new IllegalArgumentException();
        }
        int len = this.length;
        if (len + 2 + charLength > this.data.length) {
            enlarge(2 + charLength);
        }
        byte[] data = this.data;
        int len2 = len + 1;
        data[len] = (byte) (charLength >>> 8);
        int len3 = len2 + 1;
        data[len2] = (byte) charLength;
        for (int i = 0; i < charLength; i++) {
            char c = s.charAt(i);
            if (c >= 1 && c <= 127) {
                int i2 = len3;
                len3++;
                data[i2] = (byte) c;
            } else {
                this.length = len3;
                return encodeUTF8(s, i, 65535);
            }
        }
        this.length = len3;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteVector encodeUTF8(String s, int i, int maxByteLength) {
        int charLength = s.length();
        int byteLength = i;
        for (int j = i; j < charLength; j++) {
            char c = s.charAt(j);
            if (c >= 1 && c <= 127) {
                byteLength++;
            } else if (c > 2047) {
                byteLength += 3;
            } else {
                byteLength += 2;
            }
        }
        if (byteLength > maxByteLength) {
            throw new IllegalArgumentException();
        }
        int start = (this.length - i) - 2;
        if (start >= 0) {
            this.data[start] = (byte) (byteLength >>> 8);
            this.data[start + 1] = (byte) byteLength;
        }
        if ((this.length + byteLength) - i > this.data.length) {
            enlarge(byteLength - i);
        }
        int len = this.length;
        for (int j2 = i; j2 < charLength; j2++) {
            char c2 = s.charAt(j2);
            if (c2 >= 1 && c2 <= 127) {
                int i2 = len;
                len++;
                this.data[i2] = (byte) c2;
            } else if (c2 > 2047) {
                int i3 = len;
                int len2 = len + 1;
                this.data[i3] = (byte) (224 | ((c2 >> '\f') & 15));
                int len3 = len2 + 1;
                this.data[len2] = (byte) (128 | ((c2 >> 6) & 63));
                len = len3 + 1;
                this.data[len3] = (byte) (128 | (c2 & '?'));
            } else {
                int i4 = len;
                int len4 = len + 1;
                this.data[i4] = (byte) (192 | ((c2 >> 6) & 31));
                len = len4 + 1;
                this.data[len4] = (byte) (128 | (c2 & '?'));
            }
        }
        this.length = len;
        return this;
    }

    public ByteVector putByteArray(byte[] b, int off, int len) {
        if (this.length + len > this.data.length) {
            enlarge(len);
        }
        if (b != null) {
            System.arraycopy(b, off, this.data, this.length, len);
        }
        this.length += len;
        return this;
    }

    private void enlarge(int size) {
        int length1 = 2 * this.data.length;
        int length2 = this.length + size;
        byte[] newData = new byte[length1 > length2 ? length1 : length2];
        System.arraycopy(this.data, 0, newData, 0, this.length);
        this.data = newData;
    }
}
