package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

/* loaded from: classes3.dex */
public class OptionalProvider<T> implements Provider<T>, Deferred<T> {
    private static final Provider<Object> EMPTY_PROVIDER;
    private static final Deferred.DeferredHandler<Object> NOOP_HANDLER = OptionalProvider$$Lambda$4.lambdaFactory$();
    private volatile Provider<T> delegate;
    private Deferred.DeferredHandler<T> handler;

    public static /* synthetic */ void lambda$static$0(Provider provider) {
    }

    public static /* synthetic */ Object lambda$static$1() {
        return null;
    }

    static {
        Deferred.DeferredHandler<Object> deferredHandler;
        Provider<Object> provider;
        deferredHandler = OptionalProvider$$Lambda$4.instance;
        NOOP_HANDLER = deferredHandler;
        provider = OptionalProvider$$Lambda$5.instance;
        EMPTY_PROVIDER = provider;
    }

    private OptionalProvider(Deferred.DeferredHandler<T> deferredHandler, Provider<T> provider) {
        this.handler = deferredHandler;
        this.delegate = provider;
    }

    public static <T> OptionalProvider<T> empty() {
        return new OptionalProvider<>(NOOP_HANDLER, EMPTY_PROVIDER);
    }

    /* renamed from: of */
    public static <T> OptionalProvider<T> m152of(Provider<T> provider) {
        return new OptionalProvider<>(null, provider);
    }

    @Override // com.google.firebase.inject.Provider
    public T get() {
        return this.delegate.get();
    }

    public void set(Provider<T> provider) {
        Deferred.DeferredHandler<T> deferredHandler;
        if (this.delegate != EMPTY_PROVIDER) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (this) {
            deferredHandler = this.handler;
            this.handler = null;
            this.delegate = provider;
        }
        deferredHandler.handle(provider);
    }

    @Override // com.google.firebase.inject.Deferred
    public void whenAvailable(Deferred.DeferredHandler<T> deferredHandler) {
        Provider<T> provider;
        Provider<T> provider2 = this.delegate;
        Provider<Object> provider3 = EMPTY_PROVIDER;
        if (provider2 != provider3) {
            deferredHandler.handle(provider2);
            return;
        }
        Provider<T> provider4 = null;
        synchronized (this) {
            provider = this.delegate;
            if (provider != provider3) {
                provider4 = provider;
            } else {
                this.handler = OptionalProvider$$Lambda$1.lambdaFactory$(this.handler, deferredHandler);
            }
        }
        if (provider4 != null) {
            deferredHandler.handle(provider);
        }
    }

    public static /* synthetic */ void lambda$whenAvailable$2(Deferred.DeferredHandler deferredHandler, Deferred.DeferredHandler deferredHandler2, Provider provider) {
        deferredHandler.handle(provider);
        deferredHandler2.handle(provider);
    }
}
