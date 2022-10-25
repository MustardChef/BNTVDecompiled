package com.google.android.mediahome.video;

import java.util.Arrays;

/* compiled from: com.google.android.mediahome:video@@1.0.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class WatchNextProgram$$ExternalSyntheticBackport0 {
    /* renamed from: m */
    public static /* synthetic */ boolean m326m(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return obj instanceof boolean[] ? (obj2 instanceof boolean[]) && Arrays.equals((boolean[]) obj, (boolean[]) obj2) : obj instanceof byte[] ? (obj2 instanceof byte[]) && Arrays.equals((byte[]) obj, (byte[]) obj2) : obj instanceof char[] ? (obj2 instanceof char[]) && Arrays.equals((char[]) obj, (char[]) obj2) : obj instanceof double[] ? (obj2 instanceof double[]) && Arrays.equals((double[]) obj, (double[]) obj2) : obj instanceof float[] ? (obj2 instanceof float[]) && Arrays.equals((float[]) obj, (float[]) obj2) : obj instanceof int[] ? (obj2 instanceof int[]) && Arrays.equals((int[]) obj, (int[]) obj2) : obj instanceof long[] ? (obj2 instanceof long[]) && Arrays.equals((long[]) obj, (long[]) obj2) : obj instanceof short[] ? (obj2 instanceof short[]) && Arrays.equals((short[]) obj, (short[]) obj2) : obj instanceof Object[] ? (obj2 instanceof Object[]) && Arrays.deepEquals((Object[]) obj, (Object[]) obj2) : obj.equals(obj2);
    }
}
