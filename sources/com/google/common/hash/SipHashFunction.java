package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable
/* loaded from: classes3.dex */
final class SipHashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;

    /* renamed from: c */
    private final int f9809c;

    /* renamed from: d */
    private final int f9810d;

    /* renamed from: k0 */
    private final long f9811k0;

    /* renamed from: k1 */
    private final long f9812k1;

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SipHashFunction(int i, int i2, long j, long j2) {
        Preconditions.checkArgument(i > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i);
        Preconditions.checkArgument(i2 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i2);
        this.f9809c = i;
        this.f9810d = i2;
        this.f9811k0 = j;
        this.f9812k1 = j2;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new SipHasher(this.f9809c, this.f9810d, this.f9811k0, this.f9812k1);
    }

    public String toString() {
        return "Hashing.sipHash" + this.f9809c + "" + this.f9810d + "(" + this.f9811k0 + ", " + this.f9812k1 + ")";
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof SipHashFunction) {
            SipHashFunction sipHashFunction = (SipHashFunction) obj;
            return this.f9809c == sipHashFunction.f9809c && this.f9810d == sipHashFunction.f9810d && this.f9811k0 == sipHashFunction.f9811k0 && this.f9812k1 == sipHashFunction.f9812k1;
        }
        return false;
    }

    public int hashCode() {
        return (int) ((((getClass().hashCode() ^ this.f9809c) ^ this.f9810d) ^ this.f9811k0) ^ this.f9812k1);
    }

    /* loaded from: classes3.dex */
    private static final class SipHasher extends AbstractStreamingHasher {
        private static final int CHUNK_SIZE = 8;

        /* renamed from: b */
        private long f9813b;

        /* renamed from: c */
        private final int f9814c;

        /* renamed from: d */
        private final int f9815d;
        private long finalM;

        /* renamed from: v0 */
        private long f9816v0;

        /* renamed from: v1 */
        private long f9817v1;

        /* renamed from: v2 */
        private long f9818v2;

        /* renamed from: v3 */
        private long f9819v3;

        SipHasher(int i, int i2, long j, long j2) {
            super(8);
            this.f9816v0 = 8317987319222330741L;
            this.f9817v1 = 7237128888997146477L;
            this.f9818v2 = 7816392313619706465L;
            this.f9819v3 = 8387220255154660723L;
            this.f9813b = 0L;
            this.finalM = 0L;
            this.f9814c = i;
            this.f9815d = i2;
            this.f9816v0 = 8317987319222330741L ^ j;
            this.f9817v1 = 7237128888997146477L ^ j2;
            this.f9818v2 = 7816392313619706465L ^ j;
            this.f9819v3 = 8387220255154660723L ^ j2;
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void process(ByteBuffer byteBuffer) {
            this.f9813b += 8;
            processM(byteBuffer.getLong());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void processRemaining(ByteBuffer byteBuffer) {
            this.f9813b += byteBuffer.remaining();
            int i = 0;
            while (byteBuffer.hasRemaining()) {
                this.finalM ^= (byteBuffer.get() & 255) << i;
                i += 8;
            }
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public HashCode makeHash() {
            long j = this.finalM ^ (this.f9813b << 56);
            this.finalM = j;
            processM(j);
            this.f9818v2 ^= 255;
            sipRound(this.f9815d);
            return HashCode.fromLong(((this.f9816v0 ^ this.f9817v1) ^ this.f9818v2) ^ this.f9819v3);
        }

        private void processM(long j) {
            this.f9819v3 ^= j;
            sipRound(this.f9814c);
            this.f9816v0 = j ^ this.f9816v0;
        }

        private void sipRound(int i) {
            for (int i2 = 0; i2 < i; i2++) {
                long j = this.f9816v0;
                long j2 = this.f9817v1;
                this.f9816v0 = j + j2;
                this.f9818v2 += this.f9819v3;
                this.f9817v1 = Long.rotateLeft(j2, 13);
                long rotateLeft = Long.rotateLeft(this.f9819v3, 16);
                this.f9819v3 = rotateLeft;
                long j3 = this.f9817v1;
                long j4 = this.f9816v0;
                this.f9817v1 = j3 ^ j4;
                this.f9819v3 = rotateLeft ^ this.f9818v2;
                long rotateLeft2 = Long.rotateLeft(j4, 32);
                this.f9816v0 = rotateLeft2;
                long j5 = this.f9818v2;
                long j6 = this.f9817v1;
                this.f9818v2 = j5 + j6;
                this.f9816v0 = rotateLeft2 + this.f9819v3;
                this.f9817v1 = Long.rotateLeft(j6, 17);
                long rotateLeft3 = Long.rotateLeft(this.f9819v3, 21);
                this.f9819v3 = rotateLeft3;
                long j7 = this.f9817v1;
                long j8 = this.f9818v2;
                this.f9817v1 = j7 ^ j8;
                this.f9819v3 = rotateLeft3 ^ this.f9816v0;
                this.f9818v2 = Long.rotateLeft(j8, 32);
            }
        }
    }
}
