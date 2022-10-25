package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: locks.kt */
/* loaded from: classes4.dex */
public interface SimpleLock {
    public static final Companion Companion = Companion.$$INSTANCE;

    void lock();

    void unlock();

    /* compiled from: locks.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final DefaultSimpleLock simpleLock(Runnable runnable, Function1<? super InterruptedException, Unit> function1) {
            if (runnable != null && function1 != null) {
                return new locks(runnable, function1);
            }
            return new DefaultSimpleLock(null, 1, null);
        }
    }
}
