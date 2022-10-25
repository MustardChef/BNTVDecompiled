package io.reactivex.rxjava3.exceptions;

import io.reactivex.rxjava3.internal.util.ExceptionHelper;

/* loaded from: classes4.dex */
public final class Exceptions {
    private Exceptions() {
        throw new IllegalStateException("No instances!");
    }

    public static RuntimeException propagate(Throwable t) {
        throw ExceptionHelper.wrapOrThrow(t);
    }

    public static void throwIfFatal(Throwable t) {
        if (t instanceof VirtualMachineError) {
            throw ((VirtualMachineError) t);
        }
        if (t instanceof ThreadDeath) {
            throw ((ThreadDeath) t);
        }
        if (t instanceof LinkageError) {
            throw ((LinkageError) t);
        }
    }
}
