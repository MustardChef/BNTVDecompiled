package com.google.common.hash;

import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
@Immutable
/* loaded from: classes3.dex */
public final class Murmur3_128HashFunction extends AbstractHashFunction implements Serializable {
    private static final long serialVersionUID = 0;
    private final int seed;
    static final HashFunction MURMUR3_128 = new Murmur3_128HashFunction(0);
    static final HashFunction GOOD_FAST_HASH_128 = new Murmur3_128HashFunction(Hashing.GOOD_FAST_HASH_SEED);

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 128;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Murmur3_128HashFunction(int i) {
        this.seed = i;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new Murmur3_128Hasher(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_128(" + this.seed + ")";
    }

    public boolean equals(@NullableDecl Object obj) {
        return (obj instanceof Murmur3_128HashFunction) && this.seed == ((Murmur3_128HashFunction) obj).seed;
    }

    public int hashCode() {
        return getClass().hashCode() ^ this.seed;
    }

    /* loaded from: classes3.dex */
    private static final class Murmur3_128Hasher extends AbstractStreamingHasher {

        /* renamed from: C1 */
        private static final long f9802C1 = -8663945395140668459L;

        /* renamed from: C2 */
        private static final long f9803C2 = 5545529020109919103L;
        private static final int CHUNK_SIZE = 16;

        /* renamed from: h1 */
        private long f9804h1;

        /* renamed from: h2 */
        private long f9805h2;
        private int length;

        private static long fmix64(long j) {
            long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
            long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
            return j3 ^ (j3 >>> 33);
        }

        Murmur3_128Hasher(int i) {
            super(16);
            long j = i;
            this.f9804h1 = j;
            this.f9805h2 = j;
            this.length = 0;
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void process(ByteBuffer byteBuffer) {
            bmix64(byteBuffer.getLong(), byteBuffer.getLong());
            this.length += 16;
        }

        private void bmix64(long j, long j2) {
            long mixK1 = mixK1(j) ^ this.f9804h1;
            this.f9804h1 = mixK1;
            long rotateLeft = Long.rotateLeft(mixK1, 27);
            this.f9804h1 = rotateLeft;
            long j3 = this.f9805h2;
            long j4 = rotateLeft + j3;
            this.f9804h1 = j4;
            this.f9804h1 = (j4 * 5) + 1390208809;
            long mixK2 = mixK2(j2) ^ j3;
            this.f9805h2 = mixK2;
            long rotateLeft2 = Long.rotateLeft(mixK2, 31);
            this.f9805h2 = rotateLeft2;
            long j5 = rotateLeft2 + this.f9804h1;
            this.f9805h2 = j5;
            this.f9805h2 = (j5 * 5) + 944331445;
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void processRemaining(ByteBuffer byteBuffer) {
            long j;
            long j2;
            long j3;
            long j4;
            long j5;
            long j6;
            long j7;
            long j8;
            long j9;
            long j10;
            long j11;
            long j12;
            long j13;
            long j14;
            this.length += byteBuffer.remaining();
            long j15 = 0;
            switch (byteBuffer.remaining()) {
                case 1:
                    j = 0;
                    j7 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j;
                    this.f9804h1 ^= mixK1(j7);
                    this.f9805h2 ^= mixK2(j15);
                    return;
                case 2:
                    j2 = 0;
                    j = j2 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j7 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j;
                    this.f9804h1 ^= mixK1(j7);
                    this.f9805h2 ^= mixK2(j15);
                    return;
                case 3:
                    j3 = 0;
                    j2 = j3 ^ (UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j = j2 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j7 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j;
                    this.f9804h1 ^= mixK1(j7);
                    this.f9805h2 ^= mixK2(j15);
                    return;
                case 4:
                    j4 = 0;
                    j3 = j4 ^ (UnsignedBytes.toInt(byteBuffer.get(3)) << 24);
                    j2 = j3 ^ (UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j = j2 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j7 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j;
                    this.f9804h1 ^= mixK1(j7);
                    this.f9805h2 ^= mixK2(j15);
                    return;
                case 5:
                    j5 = 0;
                    j4 = j5 ^ (UnsignedBytes.toInt(byteBuffer.get(4)) << 32);
                    j3 = j4 ^ (UnsignedBytes.toInt(byteBuffer.get(3)) << 24);
                    j2 = j3 ^ (UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j = j2 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j7 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j;
                    this.f9804h1 ^= mixK1(j7);
                    this.f9805h2 ^= mixK2(j15);
                    return;
                case 6:
                    j6 = 0;
                    j5 = j6 ^ (UnsignedBytes.toInt(byteBuffer.get(5)) << 40);
                    j4 = j5 ^ (UnsignedBytes.toInt(byteBuffer.get(4)) << 32);
                    j3 = j4 ^ (UnsignedBytes.toInt(byteBuffer.get(3)) << 24);
                    j2 = j3 ^ (UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j = j2 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j7 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j;
                    this.f9804h1 ^= mixK1(j7);
                    this.f9805h2 ^= mixK2(j15);
                    return;
                case 7:
                    j6 = (UnsignedBytes.toInt(byteBuffer.get(6)) << 48) ^ 0;
                    j5 = j6 ^ (UnsignedBytes.toInt(byteBuffer.get(5)) << 40);
                    j4 = j5 ^ (UnsignedBytes.toInt(byteBuffer.get(4)) << 32);
                    j3 = j4 ^ (UnsignedBytes.toInt(byteBuffer.get(3)) << 24);
                    j2 = j3 ^ (UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j = j2 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j7 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j;
                    this.f9804h1 ^= mixK1(j7);
                    this.f9805h2 ^= mixK2(j15);
                    return;
                case 8:
                    j8 = 0;
                    j7 = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.f9804h1 ^= mixK1(j7);
                    this.f9805h2 ^= mixK2(j15);
                    return;
                case 9:
                    j9 = 0;
                    j8 = j9 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.f9804h1 ^= mixK1(j7);
                    this.f9805h2 ^= mixK2(j15);
                    return;
                case 10:
                    j10 = 0;
                    j9 = j10 ^ (UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j8 = j9 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.f9804h1 ^= mixK1(j7);
                    this.f9805h2 ^= mixK2(j15);
                    return;
                case 11:
                    j11 = 0;
                    j10 = j11 ^ (UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j9 = j10 ^ (UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j8 = j9 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.f9804h1 ^= mixK1(j7);
                    this.f9805h2 ^= mixK2(j15);
                    return;
                case 12:
                    j12 = 0;
                    j11 = j12 ^ (UnsignedBytes.toInt(byteBuffer.get(11)) << 24);
                    j10 = j11 ^ (UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j9 = j10 ^ (UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j8 = j9 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.f9804h1 ^= mixK1(j7);
                    this.f9805h2 ^= mixK2(j15);
                    return;
                case 13:
                    j13 = 0;
                    j12 = j13 ^ (UnsignedBytes.toInt(byteBuffer.get(12)) << 32);
                    j11 = j12 ^ (UnsignedBytes.toInt(byteBuffer.get(11)) << 24);
                    j10 = j11 ^ (UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j9 = j10 ^ (UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j8 = j9 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.f9804h1 ^= mixK1(j7);
                    this.f9805h2 ^= mixK2(j15);
                    return;
                case 14:
                    j14 = 0;
                    j13 = j14 ^ (UnsignedBytes.toInt(byteBuffer.get(13)) << 40);
                    j12 = j13 ^ (UnsignedBytes.toInt(byteBuffer.get(12)) << 32);
                    j11 = j12 ^ (UnsignedBytes.toInt(byteBuffer.get(11)) << 24);
                    j10 = j11 ^ (UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j9 = j10 ^ (UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j8 = j9 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.f9804h1 ^= mixK1(j7);
                    this.f9805h2 ^= mixK2(j15);
                    return;
                case 15:
                    j14 = (UnsignedBytes.toInt(byteBuffer.get(14)) << 48) ^ 0;
                    j13 = j14 ^ (UnsignedBytes.toInt(byteBuffer.get(13)) << 40);
                    j12 = j13 ^ (UnsignedBytes.toInt(byteBuffer.get(12)) << 32);
                    j11 = j12 ^ (UnsignedBytes.toInt(byteBuffer.get(11)) << 24);
                    j10 = j11 ^ (UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j9 = j10 ^ (UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j8 = j9 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j7 = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.f9804h1 ^= mixK1(j7);
                    this.f9805h2 ^= mixK2(j15);
                    return;
                default:
                    throw new AssertionError("Should never get here.");
            }
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public HashCode makeHash() {
            long j = this.f9804h1;
            int i = this.length;
            long j2 = j ^ i;
            this.f9804h1 = j2;
            long j3 = this.f9805h2 ^ i;
            this.f9805h2 = j3;
            long j4 = j2 + j3;
            this.f9804h1 = j4;
            this.f9805h2 = j3 + j4;
            this.f9804h1 = fmix64(j4);
            long fmix64 = fmix64(this.f9805h2);
            this.f9805h2 = fmix64;
            long j5 = this.f9804h1 + fmix64;
            this.f9804h1 = j5;
            this.f9805h2 = fmix64 + j5;
            return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f9804h1).putLong(this.f9805h2).array());
        }

        private static long mixK1(long j) {
            return Long.rotateLeft(j * f9802C1, 31) * f9803C2;
        }

        private static long mixK2(long j) {
            return Long.rotateLeft(j * f9803C2, 33) * f9802C1;
        }
    }
}
