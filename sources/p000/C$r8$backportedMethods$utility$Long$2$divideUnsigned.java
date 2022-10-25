package p000;

/* renamed from: $r8$backportedMethods$utility$Long$2$divideUnsigned  reason: invalid class name */
/* loaded from: classes.dex */
public /* synthetic */ class C$r8$backportedMethods$utility$Long$2$divideUnsigned {
    public static /* synthetic */ long divideUnsigned(long j, long j2) {
        if (j2 < 0) {
            return (j ^ Long.MIN_VALUE) < (j2 ^ Long.MIN_VALUE) ? 0L : 1L;
        } else if (j >= 0) {
            return j / j2;
        } else {
            long j3 = ((j >>> 1) / j2) << 1;
            return j3 + (((j - (j3 * j2)) ^ Long.MIN_VALUE) < (j2 ^ Long.MIN_VALUE) ? 0 : 1);
        }
    }
}
