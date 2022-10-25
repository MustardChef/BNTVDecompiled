package androidx.room.util;

/* loaded from: classes.dex */
public class SneakyThrow {
    public static void reThrow(Exception exc) {
        sneakyThrow(exc);
    }

    private static <E extends Throwable> void sneakyThrow(Throwable th) throws Throwable {
        throw th;
    }

    private SneakyThrow() {
    }
}
