package org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.data;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.internal.data.CRC64 */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/internal/data/CRC64.class */
public final class CRC64 {
    private static final long POLY64REV = -2882303761517117440L;
    private static final long[] LOOKUPTABLE = new long[256];

    static {
        long j;
        for (int i = 0; i < 256; i++) {
            long v = i;
            for (int j2 = 0; j2 < 8; j2++) {
                if ((v & 1) == 1) {
                    j = (v >>> 1) ^ POLY64REV;
                } else {
                    j = v >>> 1;
                }
                v = j;
            }
            LOOKUPTABLE[i] = v;
        }
    }

    public static long checksum(byte[] data) {
        long sum = 0;
        for (byte b : data) {
            int lookupidx = (((int) sum) ^ b) & 255;
            sum = (sum >>> 8) ^ LOOKUPTABLE[lookupidx];
        }
        return sum;
    }

    private CRC64() {
    }
}
