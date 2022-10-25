package org.mozilla.javascript.v8dtoa;

/* loaded from: classes5.dex */
class DiyFp {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int kSignificandSize = 64;
    static final long kUint64MSB = Long.MIN_VALUE;

    /* renamed from: e */
    private int f10798e;

    /* renamed from: f */
    private long f10799f;

    private static boolean uint64_gte(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i != 0) {
            if (!(((j < 0) ^ (i > 0)) ^ (j2 < 0))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DiyFp() {
        this.f10799f = 0L;
        this.f10798e = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DiyFp(long j, int i) {
        this.f10799f = j;
        this.f10798e = i;
    }

    void subtract(DiyFp diyFp) {
        this.f10799f -= diyFp.f10799f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DiyFp minus(DiyFp diyFp, DiyFp diyFp2) {
        DiyFp diyFp3 = new DiyFp(diyFp.f10799f, diyFp.f10798e);
        diyFp3.subtract(diyFp2);
        return diyFp3;
    }

    void multiply(DiyFp diyFp) {
        long j = this.f10799f;
        long j2 = j >>> 32;
        long j3 = j & 4294967295L;
        long j4 = diyFp.f10799f;
        long j5 = j4 >>> 32;
        long j6 = j4 & 4294967295L;
        long j7 = j2 * j5;
        long j8 = j5 * j3;
        long j9 = j2 * j6;
        this.f10798e += diyFp.f10798e + 64;
        this.f10799f = j7 + (j9 >>> 32) + (j8 >>> 32) + ((((((j3 * j6) >>> 32) + (j9 & 4294967295L)) + (4294967295L & j8)) + 2147483648L) >>> 32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DiyFp times(DiyFp diyFp, DiyFp diyFp2) {
        DiyFp diyFp3 = new DiyFp(diyFp.f10799f, diyFp.f10798e);
        diyFp3.multiply(diyFp2);
        return diyFp3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void normalize() {
        long j = this.f10799f;
        int i = this.f10798e;
        while (((-18014398509481984L) & j) == 0) {
            j <<= 10;
            i -= 10;
        }
        while ((Long.MIN_VALUE & j) == 0) {
            j <<= 1;
            i--;
        }
        this.f10799f = j;
        this.f10798e = i;
    }

    static DiyFp normalize(DiyFp diyFp) {
        DiyFp diyFp2 = new DiyFp(diyFp.f10799f, diyFp.f10798e);
        diyFp2.normalize();
        return diyFp2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public long m35f() {
        return this.f10799f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public int m36e() {
        return this.f10798e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setF(long j) {
        this.f10799f = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setE(int i) {
        this.f10798e = i;
    }

    public String toString() {
        return "[DiyFp f:" + this.f10799f + ", e:" + this.f10798e + "]";
    }
}
