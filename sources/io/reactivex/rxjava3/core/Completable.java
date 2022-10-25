package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.BackpressureKind;
import io.reactivex.rxjava3.annotations.BackpressureSupport;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.fuseable.FuseToMaybe;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.internal.jdk8.CompletableFromCompletionStage;
import io.reactivex.rxjava3.internal.jdk8.CompletionStageConsumer;
import io.reactivex.rxjava3.internal.observers.BlockingDisposableMultiObserver;
import io.reactivex.rxjava3.internal.observers.BlockingMultiObserver;
import io.reactivex.rxjava3.internal.observers.CallbackCompletableObserver;
import io.reactivex.rxjava3.internal.observers.EmptyCompletableObserver;
import io.reactivex.rxjava3.internal.observers.FutureMultiObserver;
import io.reactivex.rxjava3.internal.observers.SafeCompletableObserver;
import io.reactivex.rxjava3.internal.operators.completable.CompletableAmb;
import io.reactivex.rxjava3.internal.operators.completable.CompletableAndThenCompletable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableCache;
import io.reactivex.rxjava3.internal.operators.completable.CompletableConcat;
import io.reactivex.rxjava3.internal.operators.completable.CompletableConcatArray;
import io.reactivex.rxjava3.internal.operators.completable.CompletableConcatIterable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableCreate;
import io.reactivex.rxjava3.internal.operators.completable.CompletableDefer;
import io.reactivex.rxjava3.internal.operators.completable.CompletableDelay;
import io.reactivex.rxjava3.internal.operators.completable.CompletableDetach;
import io.reactivex.rxjava3.internal.operators.completable.CompletableDisposeOn;
import io.reactivex.rxjava3.internal.operators.completable.CompletableDoFinally;
import io.reactivex.rxjava3.internal.operators.completable.CompletableDoOnEvent;
import io.reactivex.rxjava3.internal.operators.completable.CompletableEmpty;
import io.reactivex.rxjava3.internal.operators.completable.CompletableError;
import io.reactivex.rxjava3.internal.operators.completable.CompletableErrorSupplier;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromAction;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromCallable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromObservable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromPublisher;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromRunnable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromSingle;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromSupplier;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromUnsafeSource;
import io.reactivex.rxjava3.internal.operators.completable.CompletableHide;
import io.reactivex.rxjava3.internal.operators.completable.CompletableLift;
import io.reactivex.rxjava3.internal.operators.completable.CompletableMaterialize;
import io.reactivex.rxjava3.internal.operators.completable.CompletableMerge;
import io.reactivex.rxjava3.internal.operators.completable.CompletableMergeArray;
import io.reactivex.rxjava3.internal.operators.completable.CompletableMergeArrayDelayError;
import io.reactivex.rxjava3.internal.operators.completable.CompletableMergeDelayErrorIterable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableMergeIterable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableNever;
import io.reactivex.rxjava3.internal.operators.completable.CompletableObserveOn;
import io.reactivex.rxjava3.internal.operators.completable.CompletableOnErrorComplete;
import io.reactivex.rxjava3.internal.operators.completable.CompletableOnErrorReturn;
import io.reactivex.rxjava3.internal.operators.completable.CompletablePeek;
import io.reactivex.rxjava3.internal.operators.completable.CompletableResumeNext;
import io.reactivex.rxjava3.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.rxjava3.internal.operators.completable.CompletableTakeUntilCompletable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableTimeout;
import io.reactivex.rxjava3.internal.operators.completable.CompletableTimer;
import io.reactivex.rxjava3.internal.operators.completable.CompletableToFlowable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableToObservable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableToSingle;
import io.reactivex.rxjava3.internal.operators.completable.CompletableUsing;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDelayWithCompletable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFromCompletable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeIgnoreElementCompletable;
import io.reactivex.rxjava3.internal.operators.mixed.CompletableAndThenObservable;
import io.reactivex.rxjava3.internal.operators.mixed.CompletableAndThenPublisher;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapCompletablePublisher;
import io.reactivex.rxjava3.internal.operators.single.SingleDelayWithCompletable;
import io.reactivex.rxjava3.observers.TestObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

/* loaded from: classes4.dex */
public abstract class Completable implements CompletableSource {
    protected abstract void subscribeActual(CompletableObserver observer);

    @CheckReturnValue
    @SafeVarargs
    @SchedulerSupport("none")
    public static Completable ambArray(CompletableSource... sources) {
        Objects.requireNonNull(sources, "sources is null");
        if (sources.length == 0) {
            return complete();
        }
        if (sources.length == 1) {
            return wrap(sources[0]);
        }
        return RxJavaPlugins.onAssembly(new CompletableAmb(sources, null));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable amb(Iterable<? extends CompletableSource> sources) {
        Objects.requireNonNull(sources, "sources is null");
        return RxJavaPlugins.onAssembly(new CompletableAmb(null, sources));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable complete() {
        return RxJavaPlugins.onAssembly(CompletableEmpty.INSTANCE);
    }

    @CheckReturnValue
    @SafeVarargs
    @SchedulerSupport("none")
    public static Completable concatArray(CompletableSource... sources) {
        Objects.requireNonNull(sources, "sources is null");
        if (sources.length == 0) {
            return complete();
        }
        if (sources.length == 1) {
            return wrap(sources[0]);
        }
        return RxJavaPlugins.onAssembly(new CompletableConcatArray(sources));
    }

    @CheckReturnValue
    @SafeVarargs
    @SchedulerSupport("none")
    public static Completable concatArrayDelayError(CompletableSource... sources) {
        return Flowable.fromArray(sources).concatMapCompletableDelayError(Functions.identity(), true, 2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable concat(Iterable<? extends CompletableSource> sources) {
        Objects.requireNonNull(sources, "sources is null");
        return RxJavaPlugins.onAssembly(new CompletableConcatIterable(sources));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static Completable concat(Publisher<? extends CompletableSource> sources) {
        return concat(sources, 2);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static Completable concat(Publisher<? extends CompletableSource> sources, int prefetch) {
        Objects.requireNonNull(sources, "sources is null");
        ObjectHelper.verifyPositive(prefetch, "prefetch");
        return RxJavaPlugins.onAssembly(new CompletableConcat(sources, prefetch));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable concatDelayError(Iterable<? extends CompletableSource> sources) {
        return Flowable.fromIterable(sources).concatMapCompletableDelayError(Functions.identity());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static Completable concatDelayError(Publisher<? extends CompletableSource> sources) {
        return concatDelayError(sources, 2);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static Completable concatDelayError(Publisher<? extends CompletableSource> sources, int prefetch) {
        return Flowable.fromPublisher(sources).concatMapCompletableDelayError(Functions.identity(), true, prefetch);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable create(CompletableOnSubscribe source) {
        Objects.requireNonNull(source, "source is null");
        return RxJavaPlugins.onAssembly(new CompletableCreate(source));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static Single<Boolean> sequenceEqual(CompletableSource source1, CompletableSource source2) {
        Objects.requireNonNull(source1, "source1 is null");
        Objects.requireNonNull(source2, "source2 is null");
        return mergeArrayDelayError(source1, source2).andThen(Single.just(true));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable unsafeCreate(CompletableSource onSubscribe) {
        Objects.requireNonNull(onSubscribe, "onSubscribe is null");
        if (onSubscribe instanceof Completable) {
            throw new IllegalArgumentException("Use of unsafeCreate(Completable)!");
        }
        return RxJavaPlugins.onAssembly(new CompletableFromUnsafeSource(onSubscribe));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable defer(Supplier<? extends CompletableSource> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.onAssembly(new CompletableDefer(supplier));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable error(Supplier<? extends Throwable> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.onAssembly(new CompletableErrorSupplier(supplier));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable error(Throwable throwable) {
        Objects.requireNonNull(throwable, "throwable is null");
        return RxJavaPlugins.onAssembly(new CompletableError(throwable));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable fromAction(Action action) {
        Objects.requireNonNull(action, "action is null");
        return RxJavaPlugins.onAssembly(new CompletableFromAction(action));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable fromCallable(Callable<?> callable) {
        Objects.requireNonNull(callable, "callable is null");
        return RxJavaPlugins.onAssembly(new CompletableFromCallable(callable));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable fromFuture(Future<?> future) {
        Objects.requireNonNull(future, "future is null");
        return fromAction(Functions.futureAction(future));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Completable fromMaybe(MaybeSource<T> maybe) {
        Objects.requireNonNull(maybe, "maybe is null");
        return RxJavaPlugins.onAssembly(new MaybeIgnoreElementCompletable(maybe));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable fromRunnable(Runnable run) {
        Objects.requireNonNull(run, "run is null");
        return RxJavaPlugins.onAssembly(new CompletableFromRunnable(run));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Completable fromObservable(ObservableSource<T> observable) {
        Objects.requireNonNull(observable, "observable is null");
        return RxJavaPlugins.onAssembly(new CompletableFromObservable(observable));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public static <T> Completable fromPublisher(Publisher<T> publisher) {
        Objects.requireNonNull(publisher, "publisher is null");
        return RxJavaPlugins.onAssembly(new CompletableFromPublisher(publisher));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Completable fromSingle(SingleSource<T> single) {
        Objects.requireNonNull(single, "single is null");
        return RxJavaPlugins.onAssembly(new CompletableFromSingle(single));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable fromSupplier(Supplier<?> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.onAssembly(new CompletableFromSupplier(supplier));
    }

    @CheckReturnValue
    @SafeVarargs
    @SchedulerSupport("none")
    public static Completable mergeArray(CompletableSource... sources) {
        Objects.requireNonNull(sources, "sources is null");
        if (sources.length == 0) {
            return complete();
        }
        if (sources.length == 1) {
            return wrap(sources[0]);
        }
        return RxJavaPlugins.onAssembly(new CompletableMergeArray(sources));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable merge(Iterable<? extends CompletableSource> sources) {
        Objects.requireNonNull(sources, "sources is null");
        return RxJavaPlugins.onAssembly(new CompletableMergeIterable(sources));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public static Completable merge(Publisher<? extends CompletableSource> sources) {
        return merge0(sources, Integer.MAX_VALUE, false);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static Completable merge(Publisher<? extends CompletableSource> sources, int maxConcurrency) {
        return merge0(sources, maxConcurrency, false);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    private static Completable merge0(Publisher<? extends CompletableSource> sources, int maxConcurrency, boolean delayErrors) {
        Objects.requireNonNull(sources, "sources is null");
        ObjectHelper.verifyPositive(maxConcurrency, "maxConcurrency");
        return RxJavaPlugins.onAssembly(new CompletableMerge(sources, maxConcurrency, delayErrors));
    }

    @CheckReturnValue
    @SafeVarargs
    @SchedulerSupport("none")
    public static Completable mergeArrayDelayError(CompletableSource... sources) {
        Objects.requireNonNull(sources, "sources is null");
        return RxJavaPlugins.onAssembly(new CompletableMergeArrayDelayError(sources));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable mergeDelayError(Iterable<? extends CompletableSource> sources) {
        Objects.requireNonNull(sources, "sources is null");
        return RxJavaPlugins.onAssembly(new CompletableMergeDelayErrorIterable(sources));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public static Completable mergeDelayError(Publisher<? extends CompletableSource> sources) {
        return merge0(sources, Integer.MAX_VALUE, true);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static Completable mergeDelayError(Publisher<? extends CompletableSource> sources, int maxConcurrency) {
        return merge0(sources, maxConcurrency, true);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable never() {
        return RxJavaPlugins.onAssembly(CompletableNever.INSTANCE);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public static Completable timer(long delay, TimeUnit unit) {
        return timer(delay, unit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public static Completable timer(long delay, TimeUnit unit, Scheduler scheduler) {
        Objects.requireNonNull(unit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new CompletableTimer(delay, unit, scheduler));
    }

    private static NullPointerException toNpe(Throwable ex) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(ex);
        return nullPointerException;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public static Completable switchOnNext(Publisher<? extends CompletableSource> sources) {
        Objects.requireNonNull(sources, "sources is null");
        return RxJavaPlugins.onAssembly(new FlowableSwitchMapCompletablePublisher(sources, Functions.identity(), false));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public static Completable switchOnNextDelayError(Publisher<? extends CompletableSource> sources) {
        Objects.requireNonNull(sources, "sources is null");
        return RxJavaPlugins.onAssembly(new FlowableSwitchMapCompletablePublisher(sources, Functions.identity(), true));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <R> Completable using(Supplier<R> resourceSupplier, Function<? super R, ? extends CompletableSource> sourceSupplier, Consumer<? super R> resourceCleanup) {
        return using(resourceSupplier, sourceSupplier, resourceCleanup, true);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <R> Completable using(Supplier<R> resourceSupplier, Function<? super R, ? extends CompletableSource> sourceSupplier, Consumer<? super R> resourceCleanup, boolean eager) {
        Objects.requireNonNull(resourceSupplier, "resourceSupplier is null");
        Objects.requireNonNull(sourceSupplier, "sourceSupplier is null");
        Objects.requireNonNull(resourceCleanup, "resourceCleanup is null");
        return RxJavaPlugins.onAssembly(new CompletableUsing(resourceSupplier, sourceSupplier, resourceCleanup, eager));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable wrap(CompletableSource source) {
        Objects.requireNonNull(source, "source is null");
        if (source instanceof Completable) {
            return RxJavaPlugins.onAssembly((Completable) source);
        }
        return RxJavaPlugins.onAssembly(new CompletableFromUnsafeSource(source));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable ambWith(CompletableSource other) {
        Objects.requireNonNull(other, "other is null");
        return ambArray(this, other);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <T> Observable<T> andThen(ObservableSource<T> next) {
        Objects.requireNonNull(next, "next is null");
        return RxJavaPlugins.onAssembly(new CompletableAndThenObservable(this, next));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <T> Flowable<T> andThen(Publisher<T> next) {
        Objects.requireNonNull(next, "next is null");
        return RxJavaPlugins.onAssembly(new CompletableAndThenPublisher(this, next));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <T> Single<T> andThen(SingleSource<T> next) {
        Objects.requireNonNull(next, "next is null");
        return RxJavaPlugins.onAssembly(new SingleDelayWithCompletable(next, this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <T> Maybe<T> andThen(MaybeSource<T> next) {
        Objects.requireNonNull(next, "next is null");
        return RxJavaPlugins.onAssembly(new MaybeDelayWithCompletable(next, this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable andThen(CompletableSource next) {
        Objects.requireNonNull(next, "next is null");
        return RxJavaPlugins.onAssembly(new CompletableAndThenCompletable(this, next));
    }

    @SchedulerSupport("none")
    public final void blockingAwait() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        blockingMultiObserver.blockingGet();
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final boolean blockingAwait(long timeout, TimeUnit unit) {
        Objects.requireNonNull(unit, "unit is null");
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        return blockingMultiObserver.blockingAwait(timeout, unit);
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe() {
        blockingSubscribe(Functions.EMPTY_ACTION, Functions.ERROR_CONSUMER);
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Action onComplete) {
        blockingSubscribe(onComplete, Functions.ERROR_CONSUMER);
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Action onComplete, Consumer<? super Throwable> onError) {
        Objects.requireNonNull(onComplete, "onComplete is null");
        Objects.requireNonNull(onError, "onError is null");
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        blockingMultiObserver.blockingConsume(Functions.emptyConsumer(), onError, onComplete);
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(CompletableObserver observer) {
        Objects.requireNonNull(observer, "observer is null");
        BlockingDisposableMultiObserver blockingDisposableMultiObserver = new BlockingDisposableMultiObserver();
        observer.onSubscribe(blockingDisposableMultiObserver);
        subscribe(blockingDisposableMultiObserver);
        blockingDisposableMultiObserver.blockingConsume(observer);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable cache() {
        return RxJavaPlugins.onAssembly(new CompletableCache(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable compose(CompletableTransformer transformer) {
        Objects.requireNonNull(transformer, "transformer is null");
        return wrap(transformer.apply(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable concatWith(CompletableSource other) {
        Objects.requireNonNull(other, "other is null");
        return RxJavaPlugins.onAssembly(new CompletableAndThenCompletable(this, other));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Completable delay(long time, TimeUnit unit) {
        return delay(time, unit, Schedulers.computation(), false);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Completable delay(long time, TimeUnit unit, Scheduler scheduler) {
        return delay(time, unit, scheduler, false);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Completable delay(long time, TimeUnit unit, Scheduler scheduler, boolean delayError) {
        Objects.requireNonNull(unit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new CompletableDelay(this, time, unit, scheduler, delayError));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Completable delaySubscription(long time, TimeUnit unit) {
        return delaySubscription(time, unit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Completable delaySubscription(long time, TimeUnit unit, Scheduler scheduler) {
        return timer(time, unit, scheduler).andThen(this);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable doOnComplete(Action onComplete) {
        return doOnLifecycle(Functions.emptyConsumer(), Functions.emptyConsumer(), onComplete, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable doOnDispose(Action onDispose) {
        return doOnLifecycle(Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, onDispose);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable doOnError(Consumer<? super Throwable> onError) {
        return doOnLifecycle(Functions.emptyConsumer(), onError, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable doOnEvent(Consumer<? super Throwable> onEvent) {
        Objects.requireNonNull(onEvent, "onEvent is null");
        return RxJavaPlugins.onAssembly(new CompletableDoOnEvent(this, onEvent));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable doOnLifecycle(Consumer<? super Disposable> onSubscribe, Action onDispose) {
        return doOnLifecycle(onSubscribe, Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, onDispose);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    private Completable doOnLifecycle(final Consumer<? super Disposable> onSubscribe, final Consumer<? super Throwable> onError, final Action onComplete, final Action onTerminate, final Action onAfterTerminate, final Action onDispose) {
        Objects.requireNonNull(onSubscribe, "onSubscribe is null");
        Objects.requireNonNull(onError, "onError is null");
        Objects.requireNonNull(onComplete, "onComplete is null");
        Objects.requireNonNull(onTerminate, "onTerminate is null");
        Objects.requireNonNull(onAfterTerminate, "onAfterTerminate is null");
        Objects.requireNonNull(onDispose, "onDispose is null");
        return RxJavaPlugins.onAssembly(new CompletablePeek(this, onSubscribe, onError, onComplete, onTerminate, onAfterTerminate, onDispose));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable doOnSubscribe(Consumer<? super Disposable> onSubscribe) {
        return doOnLifecycle(onSubscribe, Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable doOnTerminate(Action onTerminate) {
        return doOnLifecycle(Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, onTerminate, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable doAfterTerminate(Action onAfterTerminate) {
        return doOnLifecycle(Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, onAfterTerminate, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable doFinally(Action onFinally) {
        Objects.requireNonNull(onFinally, "onFinally is null");
        return RxJavaPlugins.onAssembly(new CompletableDoFinally(this, onFinally));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable lift(CompletableOperator onLift) {
        Objects.requireNonNull(onLift, "onLift is null");
        return RxJavaPlugins.onAssembly(new CompletableLift(this, onLift));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <T> Single<Notification<T>> materialize() {
        return RxJavaPlugins.onAssembly(new CompletableMaterialize(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable mergeWith(CompletableSource other) {
        Objects.requireNonNull(other, "other is null");
        return mergeArray(this, other);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Completable observeOn(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new CompletableObserveOn(this, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable onErrorComplete() {
        return onErrorComplete(Functions.alwaysTrue());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable onErrorComplete(Predicate<? super Throwable> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new CompletableOnErrorComplete(this, predicate));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable onErrorResumeNext(Function<? super Throwable, ? extends CompletableSource> fallbackSupplier) {
        Objects.requireNonNull(fallbackSupplier, "fallbackSupplier is null");
        return RxJavaPlugins.onAssembly(new CompletableResumeNext(this, fallbackSupplier));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable onErrorResumeWith(CompletableSource fallback) {
        Objects.requireNonNull(fallback, "fallback is null");
        return onErrorResumeNext(Functions.justFunction(fallback));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <T> Maybe<T> onErrorReturn(Function<? super Throwable, ? extends T> itemSupplier) {
        Objects.requireNonNull(itemSupplier, "itemSupplier is null");
        return RxJavaPlugins.onAssembly(new CompletableOnErrorReturn(this, itemSupplier));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <T> Maybe<T> onErrorReturnItem(T item) {
        Objects.requireNonNull(item, "item is null");
        return onErrorReturn(Functions.justFunction(item));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable onTerminateDetach() {
        return RxJavaPlugins.onAssembly(new CompletableDetach(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable repeat() {
        return fromPublisher(toFlowable().repeat());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable repeat(long times) {
        return fromPublisher(toFlowable().repeat(times));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable repeatUntil(BooleanSupplier stop) {
        return fromPublisher(toFlowable().repeatUntil(stop));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> handler) {
        return fromPublisher(toFlowable().repeatWhen(handler));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable retry() {
        return fromPublisher(toFlowable().retry());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable retry(BiPredicate<? super Integer, ? super Throwable> predicate) {
        return fromPublisher(toFlowable().retry(predicate));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable retry(long times) {
        return fromPublisher(toFlowable().retry(times));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable retry(long times, Predicate<? super Throwable> predicate) {
        return fromPublisher(toFlowable().retry(times, predicate));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable retry(Predicate<? super Throwable> predicate) {
        return fromPublisher(toFlowable().retry(predicate));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable retryUntil(BooleanSupplier stop) {
        Objects.requireNonNull(stop, "stop is null");
        return retry(Long.MAX_VALUE, Functions.predicateReverseFor(stop));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> handler) {
        return fromPublisher(toFlowable().retryWhen(handler));
    }

    @SchedulerSupport("none")
    public final void safeSubscribe(CompletableObserver observer) {
        Objects.requireNonNull(observer, "observer is null");
        subscribe(new SafeCompletableObserver(observer));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable startWith(CompletableSource other) {
        Objects.requireNonNull(other, "other is null");
        return concatArray(other, this);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <T> Flowable<T> startWith(SingleSource<T> other) {
        Objects.requireNonNull(other, "other is null");
        return Flowable.concat(Single.wrap(other).toFlowable(), toFlowable());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <T> Flowable<T> startWith(MaybeSource<T> other) {
        Objects.requireNonNull(other, "other is null");
        return Flowable.concat(Maybe.wrap(other).toFlowable(), toFlowable());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <T> Observable<T> startWith(ObservableSource<T> other) {
        Objects.requireNonNull(other, "other is null");
        return Observable.wrap(other).concatWith(toObservable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <T> Flowable<T> startWith(Publisher<T> other) {
        Objects.requireNonNull(other, "other is null");
        return toFlowable().startWith(other);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable hide() {
        return RxJavaPlugins.onAssembly(new CompletableHide(this));
    }

    @SchedulerSupport("none")
    public final Disposable subscribe() {
        EmptyCompletableObserver emptyCompletableObserver = new EmptyCompletableObserver();
        subscribe(emptyCompletableObserver);
        return emptyCompletableObserver;
    }

    @Override // io.reactivex.rxjava3.core.CompletableSource
    @SchedulerSupport("none")
    public final void subscribe(CompletableObserver observer) {
        Objects.requireNonNull(observer, "observer is null");
        try {
            CompletableObserver onSubscribe = RxJavaPlugins.onSubscribe(this, observer);
            Objects.requireNonNull(onSubscribe, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            subscribeActual(onSubscribe);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            throw toNpe(th);
        }
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <E extends CompletableObserver> E subscribeWith(E observer) {
        subscribe(observer);
        return observer;
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Disposable subscribe(Action onComplete, Consumer<? super Throwable> onError) {
        Objects.requireNonNull(onError, "onError is null");
        Objects.requireNonNull(onComplete, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(onError, onComplete);
        subscribe(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Disposable subscribe(Action onComplete) {
        Objects.requireNonNull(onComplete, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(onComplete);
        subscribe(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Completable subscribeOn(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new CompletableSubscribeOn(this, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable takeUntil(CompletableSource other) {
        Objects.requireNonNull(other, "other is null");
        return RxJavaPlugins.onAssembly(new CompletableTakeUntilCompletable(this, other));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Completable timeout(long timeout, TimeUnit unit) {
        return timeout0(timeout, unit, Schedulers.computation(), null);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Completable timeout(long timeout, TimeUnit unit, CompletableSource fallback) {
        Objects.requireNonNull(fallback, "fallback is null");
        return timeout0(timeout, unit, Schedulers.computation(), fallback);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Completable timeout(long timeout, TimeUnit unit, Scheduler scheduler) {
        return timeout0(timeout, unit, scheduler, null);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Completable timeout(long timeout, TimeUnit unit, Scheduler scheduler, CompletableSource fallback) {
        Objects.requireNonNull(fallback, "fallback is null");
        return timeout0(timeout, unit, scheduler, fallback);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    private Completable timeout0(long timeout, TimeUnit unit, Scheduler scheduler, CompletableSource fallback) {
        Objects.requireNonNull(unit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new CompletableTimeout(this, timeout, unit, scheduler, fallback));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: to */
    public final <R> R m117to(CompletableConverter<? extends R> converter) {
        Objects.requireNonNull(converter, "converter is null");
        return converter.apply(this);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport("none")
    public final <T> Flowable<T> toFlowable() {
        if (this instanceof FuseToFlowable) {
            return ((FuseToFlowable) this).fuseToFlowable();
        }
        return RxJavaPlugins.onAssembly(new CompletableToFlowable(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Future<Void> toFuture() {
        return (Future) subscribeWith(new FutureMultiObserver());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <T> Maybe<T> toMaybe() {
        if (this instanceof FuseToMaybe) {
            return ((FuseToMaybe) this).fuseToMaybe();
        }
        return RxJavaPlugins.onAssembly(new MaybeFromCompletable(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <T> Observable<T> toObservable() {
        if (this instanceof FuseToObservable) {
            return ((FuseToObservable) this).fuseToObservable();
        }
        return RxJavaPlugins.onAssembly(new CompletableToObservable(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <T> Single<T> toSingle(Supplier<? extends T> completionValueSupplier) {
        Objects.requireNonNull(completionValueSupplier, "completionValueSupplier is null");
        return RxJavaPlugins.onAssembly(new CompletableToSingle(this, completionValueSupplier, null));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <T> Single<T> toSingleDefault(T completionValue) {
        Objects.requireNonNull(completionValue, "completionValue is null");
        return RxJavaPlugins.onAssembly(new CompletableToSingle(this, null, completionValue));
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Completable unsubscribeOn(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new CompletableDisposeOn(this, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final TestObserver<Void> test() {
        TestObserver<Void> testObserver = new TestObserver<>();
        subscribe(testObserver);
        return testObserver;
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final TestObserver<Void> test(boolean dispose) {
        TestObserver<Void> testObserver = new TestObserver<>();
        if (dispose) {
            testObserver.dispose();
        }
        subscribe(testObserver);
        return testObserver;
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable fromCompletionStage(CompletionStage<?> stage) {
        Objects.requireNonNull(stage, "stage is null");
        return RxJavaPlugins.onAssembly(new CompletableFromCompletionStage(stage));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <T> CompletionStage<T> toCompletionStage(T defaultItem) {
        return (CompletionStage) subscribeWith(new CompletionStageConsumer(true, defaultItem));
    }
}
