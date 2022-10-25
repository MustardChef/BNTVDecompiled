package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.parallel.ParallelFailureHandling;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Optional;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class ParallelMapTryOptional<T, R> extends ParallelFlowable<R> {
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
    final Function<? super T, Optional<? extends R>> mapper;
    final ParallelFlowable<T> source;

    public ParallelMapTryOptional(ParallelFlowable<T> source, Function<? super T, Optional<? extends R>> mapper, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler) {
        this.source = source;
        this.mapper = mapper;
        this.errorHandler = errorHandler;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super R>[] subscribers) {
        if (validate(subscribers)) {
            int length = subscribers.length;
            Subscriber<? super T>[] subscriberArr = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                Subscriber<? super R> subscriber = subscribers[i];
                if (subscriber instanceof ConditionalSubscriber) {
                    subscriberArr[i] = new ParallelMapTryConditionalSubscriber((ConditionalSubscriber) subscriber, this.mapper, this.errorHandler);
                } else {
                    subscriberArr[i] = new ParallelMapTrySubscriber(subscriber, this.mapper, this.errorHandler);
                }
            }
            this.source.subscribe(subscriberArr);
        }
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.source.parallelism();
    }

    /* loaded from: classes4.dex */
    static final class ParallelMapTrySubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {
        boolean done;
        final Subscriber<? super R> downstream;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
        final Function<? super T, Optional<? extends R>> mapper;
        Subscription upstream;

        ParallelMapTrySubscriber(Subscriber<? super R> actual, Function<? super T, Optional<? extends R>> mapper, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler) {
            this.downstream = actual;
            this.mapper = mapper;
            this.errorHandler = errorHandler;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            this.upstream.request(n);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (tryOnNext(t) || this.done) {
                return;
            }
            this.upstream.request(1L);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
        @Override // io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean tryOnNext(T r10) {
            /*
                r9 = this;
                boolean r0 = r9.done
                r1 = 0
                if (r0 == 0) goto L6
                return r1
            L6:
                r2 = 0
            L8:
                r0 = 1
                io.reactivex.rxjava3.functions.Function<? super T, java.util.Optional<? extends R>> r4 = r9.mapper     // Catch: java.lang.Throwable -> L27
                java.lang.Object r4 = r4.apply(r10)     // Catch: java.lang.Throwable -> L27
                java.lang.String r5 = "The mapper returned a null Optional"
                java.util.Objects.requireNonNull(r4, r5)     // Catch: java.lang.Throwable -> L27
                java.util.Optional r4 = (java.util.Optional) r4     // Catch: java.lang.Throwable -> L27
                boolean r10 = r4.isPresent()
                if (r10 == 0) goto L26
                org.reactivestreams.Subscriber<? super R> r10 = r9.downstream
                java.lang.Object r1 = r4.get()
                r10.onNext(r1)
                return r0
            L26:
                return r1
            L27:
                r4 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r4)
                r5 = 2
                io.reactivex.rxjava3.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.rxjava3.parallel.ParallelFailureHandling> r6 = r9.errorHandler     // Catch: java.lang.Throwable -> L5d
                r7 = 1
                long r2 = r2 + r7
                java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> L5d
                java.lang.Object r6 = r6.apply(r7, r4)     // Catch: java.lang.Throwable -> L5d
                java.lang.String r7 = "The errorHandler returned a null ParallelFailureHandling"
                java.util.Objects.requireNonNull(r6, r7)     // Catch: java.lang.Throwable -> L5d
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r6 = (io.reactivex.rxjava3.parallel.ParallelFailureHandling) r6     // Catch: java.lang.Throwable -> L5d
                int[] r7 = io.reactivex.rxjava3.internal.jdk8.ParallelMapTryOptional.C50111.$SwitchMap$io$reactivex$rxjava3$parallel$ParallelFailureHandling
                int r6 = r6.ordinal()
                r6 = r7[r6]
                if (r6 == r0) goto L8
                if (r6 == r5) goto L5c
                r10 = 3
                if (r6 == r10) goto L56
                r9.cancel()
                r9.onError(r4)
                return r1
            L56:
                r9.cancel()
                r9.onComplete()
            L5c:
                return r1
            L5d:
                r10 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r10)
                r9.cancel()
                io.reactivex.rxjava3.exceptions.CompositeException r2 = new io.reactivex.rxjava3.exceptions.CompositeException
                java.lang.Throwable[] r3 = new java.lang.Throwable[r5]
                r3[r1] = r4
                r3[r0] = r10
                r2.<init>(r3)
                r9.onError(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.jdk8.ParallelMapTryOptional.ParallelMapTrySubscriber.tryOnNext(java.lang.Object):boolean");
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.done = true;
            this.downstream.onError(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.downstream.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.rxjava3.internal.jdk8.ParallelMapTryOptional$1 */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C50111 {
        static final /* synthetic */ int[] $SwitchMap$io$reactivex$rxjava3$parallel$ParallelFailureHandling;

        static {
            int[] iArr = new int[ParallelFailureHandling.values().length];
            $SwitchMap$io$reactivex$rxjava3$parallel$ParallelFailureHandling = iArr;
            try {
                iArr[ParallelFailureHandling.RETRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$reactivex$rxjava3$parallel$ParallelFailureHandling[ParallelFailureHandling.SKIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$reactivex$rxjava3$parallel$ParallelFailureHandling[ParallelFailureHandling.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes4.dex */
    static final class ParallelMapTryConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {
        boolean done;
        final ConditionalSubscriber<? super R> downstream;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
        final Function<? super T, Optional<? extends R>> mapper;
        Subscription upstream;

        ParallelMapTryConditionalSubscriber(ConditionalSubscriber<? super R> actual, Function<? super T, Optional<? extends R>> mapper, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler) {
            this.downstream = actual;
            this.mapper = mapper;
            this.errorHandler = errorHandler;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            this.upstream.request(n);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (tryOnNext(t) || this.done) {
                return;
            }
            this.upstream.request(1L);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
        @Override // io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean tryOnNext(T r10) {
            /*
                r9 = this;
                boolean r0 = r9.done
                r1 = 0
                if (r0 == 0) goto L6
                return r1
            L6:
                r2 = 0
            L8:
                r0 = 1
                io.reactivex.rxjava3.functions.Function<? super T, java.util.Optional<? extends R>> r4 = r9.mapper     // Catch: java.lang.Throwable -> L2a
                java.lang.Object r4 = r4.apply(r10)     // Catch: java.lang.Throwable -> L2a
                java.lang.String r5 = "The mapper returned a null Optional"
                java.util.Objects.requireNonNull(r4, r5)     // Catch: java.lang.Throwable -> L2a
                java.util.Optional r4 = (java.util.Optional) r4     // Catch: java.lang.Throwable -> L2a
                boolean r10 = r4.isPresent()
                if (r10 == 0) goto L29
                io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber<? super R> r10 = r9.downstream
                java.lang.Object r2 = r4.get()
                boolean r10 = r10.tryOnNext(r2)
                if (r10 == 0) goto L29
                r1 = 1
            L29:
                return r1
            L2a:
                r4 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r4)
                r5 = 2
                io.reactivex.rxjava3.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.rxjava3.parallel.ParallelFailureHandling> r6 = r9.errorHandler     // Catch: java.lang.Throwable -> L60
                r7 = 1
                long r2 = r2 + r7
                java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> L60
                java.lang.Object r6 = r6.apply(r7, r4)     // Catch: java.lang.Throwable -> L60
                java.lang.String r7 = "The errorHandler returned a null ParallelFailureHandling"
                java.util.Objects.requireNonNull(r6, r7)     // Catch: java.lang.Throwable -> L60
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r6 = (io.reactivex.rxjava3.parallel.ParallelFailureHandling) r6     // Catch: java.lang.Throwable -> L60
                int[] r7 = io.reactivex.rxjava3.internal.jdk8.ParallelMapTryOptional.C50111.$SwitchMap$io$reactivex$rxjava3$parallel$ParallelFailureHandling
                int r6 = r6.ordinal()
                r6 = r7[r6]
                if (r6 == r0) goto L8
                if (r6 == r5) goto L5f
                r10 = 3
                if (r6 == r10) goto L59
                r9.cancel()
                r9.onError(r4)
                return r1
            L59:
                r9.cancel()
                r9.onComplete()
            L5f:
                return r1
            L60:
                r10 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r10)
                r9.cancel()
                io.reactivex.rxjava3.exceptions.CompositeException r2 = new io.reactivex.rxjava3.exceptions.CompositeException
                java.lang.Throwable[] r3 = new java.lang.Throwable[r5]
                r3[r1] = r4
                r3[r0] = r10
                r2.<init>(r3)
                r9.onError(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.jdk8.ParallelMapTryOptional.ParallelMapTryConditionalSubscriber.tryOnNext(java.lang.Object):boolean");
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.done = true;
            this.downstream.onError(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.downstream.onComplete();
        }
    }
}
