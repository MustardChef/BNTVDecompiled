package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.BackpressureKind;
import io.reactivex.rxjava3.annotations.BackpressureSupport;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Function3;
import io.reactivex.rxjava3.functions.Function4;
import io.reactivex.rxjava3.functions.Function5;
import io.reactivex.rxjava3.functions.Function6;
import io.reactivex.rxjava3.functions.Function7;
import io.reactivex.rxjava3.functions.Function8;
import io.reactivex.rxjava3.functions.Function9;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.internal.jdk8.CompletionStageConsumer;
import io.reactivex.rxjava3.internal.jdk8.MaybeFlattenStreamAsFlowable;
import io.reactivex.rxjava3.internal.jdk8.MaybeFlattenStreamAsObservable;
import io.reactivex.rxjava3.internal.jdk8.MaybeFromCompletionStage;
import io.reactivex.rxjava3.internal.jdk8.MaybeMapOptional;
import io.reactivex.rxjava3.internal.observers.BlockingDisposableMultiObserver;
import io.reactivex.rxjava3.internal.observers.BlockingMultiObserver;
import io.reactivex.rxjava3.internal.observers.FutureMultiObserver;
import io.reactivex.rxjava3.internal.observers.SafeMaybeObserver;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableElementAtMaybePublisher;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlatMapMaybePublisher;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeAmb;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeCache;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeCallbackObserver;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeConcatArray;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeConcatArrayDelayError;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeConcatIterable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeContains;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeCount;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeCreate;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDefer;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDelay;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDelayOtherPublisher;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDelaySubscriptionOtherPublisher;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDematerialize;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDetach;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDoAfterSuccess;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDoFinally;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDoOnEvent;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDoOnLifecycle;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDoOnTerminate;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeEmpty;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeEqualSingle;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeError;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeErrorCallable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFilter;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFlatMapBiSelector;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFlatMapCompletable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFlatMapIterableFlowable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFlatMapIterableObservable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFlatMapNotification;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFlatMapSingle;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFlatten;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFromAction;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFromCallable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFromCompletable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFromFuture;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFromRunnable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFromSingle;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFromSupplier;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeHide;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeIgnoreElementCompletable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeIsEmptySingle;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeJust;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeLift;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeMap;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeMaterialize;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeNever;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeObserveOn;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeOnErrorComplete;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeOnErrorNext;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeOnErrorReturn;
import io.reactivex.rxjava3.internal.operators.maybe.MaybePeek;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeSubscribeOn;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeSwitchIfEmpty;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeSwitchIfEmptySingle;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeTakeUntilMaybe;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeTakeUntilPublisher;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeTimeInterval;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeTimeoutMaybe;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeTimeoutPublisher;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeTimer;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeToFlowable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeToObservable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeToPublisher;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeToSingle;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeUnsafeCreate;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeUnsubscribeOn;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeUsing;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeZipArray;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeZipIterable;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableConcatMapMaybePublisher;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapMaybePublisher;
import io.reactivex.rxjava3.internal.operators.mixed.MaybeFlatMapObservable;
import io.reactivex.rxjava3.internal.operators.mixed.MaybeFlatMapPublisher;
import io.reactivex.rxjava3.internal.operators.observable.ObservableElementAtMaybe;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.observers.TestObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import org.reactivestreams.Publisher;

/* loaded from: classes4.dex */
public abstract class Maybe<T> implements MaybeSource<T> {
    protected abstract void subscribeActual(MaybeObserver<? super T> observer);

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Maybe<T> amb(Iterable<? extends MaybeSource<? extends T>> sources) {
        Objects.requireNonNull(sources, "sources is null");
        return RxJavaPlugins.onAssembly(new MaybeAmb(null, sources));
    }

    @CheckReturnValue
    @SafeVarargs
    @SchedulerSupport("none")
    public static <T> Maybe<T> ambArray(MaybeSource<? extends T>... sources) {
        Objects.requireNonNull(sources, "sources is null");
        if (sources.length == 0) {
            return empty();
        }
        if (sources.length == 1) {
            return wrap(sources[0]);
        }
        return RxJavaPlugins.onAssembly(new MaybeAmb(sources, null));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concat(Iterable<? extends MaybeSource<? extends T>> sources) {
        Objects.requireNonNull(sources, "sources is null");
        return RxJavaPlugins.onAssembly(new MaybeConcatIterable(sources));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concat(MaybeSource<? extends T> source1, MaybeSource<? extends T> source2) {
        Objects.requireNonNull(source1, "source1 is null");
        Objects.requireNonNull(source2, "source2 is null");
        return concatArray(source1, source2);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concat(MaybeSource<? extends T> source1, MaybeSource<? extends T> source2, MaybeSource<? extends T> source3) {
        Objects.requireNonNull(source1, "source1 is null");
        Objects.requireNonNull(source2, "source2 is null");
        Objects.requireNonNull(source3, "source3 is null");
        return concatArray(source1, source2, source3);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concat(MaybeSource<? extends T> source1, MaybeSource<? extends T> source2, MaybeSource<? extends T> source3, MaybeSource<? extends T> source4) {
        Objects.requireNonNull(source1, "source1 is null");
        Objects.requireNonNull(source2, "source2 is null");
        Objects.requireNonNull(source3, "source3 is null");
        Objects.requireNonNull(source4, "source4 is null");
        return concatArray(source1, source2, source3, source4);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concat(Publisher<? extends MaybeSource<? extends T>> sources) {
        return concat(sources, 2);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concat(Publisher<? extends MaybeSource<? extends T>> sources, int prefetch) {
        Objects.requireNonNull(sources, "sources is null");
        ObjectHelper.verifyPositive(prefetch, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapMaybePublisher(sources, Functions.identity(), ErrorMode.IMMEDIATE, prefetch));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SafeVarargs
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatArray(MaybeSource<? extends T>... sources) {
        Objects.requireNonNull(sources, "sources is null");
        if (sources.length == 0) {
            return Flowable.empty();
        }
        if (sources.length == 1) {
            return RxJavaPlugins.onAssembly(new MaybeToFlowable(sources[0]));
        }
        return RxJavaPlugins.onAssembly(new MaybeConcatArray(sources));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SafeVarargs
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatArrayDelayError(MaybeSource<? extends T>... sources) {
        Objects.requireNonNull(sources, "sources is null");
        if (sources.length == 0) {
            return Flowable.empty();
        }
        if (sources.length == 1) {
            return RxJavaPlugins.onAssembly(new MaybeToFlowable(sources[0]));
        }
        return RxJavaPlugins.onAssembly(new MaybeConcatArrayDelayError(sources));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SafeVarargs
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatArrayEager(MaybeSource<? extends T>... sources) {
        return Flowable.fromArray(sources).concatMapEager(MaybeToPublisher.instance());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SafeVarargs
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatArrayEagerDelayError(MaybeSource<? extends T>... sources) {
        return Flowable.fromArray(sources).concatMapEagerDelayError(MaybeToPublisher.instance(), true);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatDelayError(Iterable<? extends MaybeSource<? extends T>> sources) {
        return Flowable.fromIterable(sources).concatMapMaybeDelayError(Functions.identity());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatDelayError(Publisher<? extends MaybeSource<? extends T>> sources) {
        return Flowable.fromPublisher(sources).concatMapMaybeDelayError(Functions.identity());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatDelayError(Publisher<? extends MaybeSource<? extends T>> sources, int prefetch) {
        return Flowable.fromPublisher(sources).concatMapMaybeDelayError(Functions.identity(), true, prefetch);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatEager(Iterable<? extends MaybeSource<? extends T>> sources) {
        return Flowable.fromIterable(sources).concatMapEagerDelayError(MaybeToPublisher.instance(), false);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatEager(Iterable<? extends MaybeSource<? extends T>> sources, int maxConcurrency) {
        return Flowable.fromIterable(sources).concatMapEagerDelayError(MaybeToPublisher.instance(), false, maxConcurrency, 1);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatEager(Publisher<? extends MaybeSource<? extends T>> sources) {
        return Flowable.fromPublisher(sources).concatMapEager(MaybeToPublisher.instance());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatEager(Publisher<? extends MaybeSource<? extends T>> sources, int maxConcurrency) {
        return Flowable.fromPublisher(sources).concatMapEager(MaybeToPublisher.instance(), maxConcurrency, 1);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatEagerDelayError(Iterable<? extends MaybeSource<? extends T>> sources) {
        return Flowable.fromIterable(sources).concatMapEagerDelayError(MaybeToPublisher.instance(), true);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatEagerDelayError(Iterable<? extends MaybeSource<? extends T>> sources, int maxConcurrency) {
        return Flowable.fromIterable(sources).concatMapEagerDelayError(MaybeToPublisher.instance(), true, maxConcurrency, 1);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatEagerDelayError(Publisher<? extends MaybeSource<? extends T>> sources) {
        return Flowable.fromPublisher(sources).concatMapEagerDelayError(MaybeToPublisher.instance(), true);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatEagerDelayError(Publisher<? extends MaybeSource<? extends T>> sources, int maxConcurrency) {
        return Flowable.fromPublisher(sources).concatMapEagerDelayError(MaybeToPublisher.instance(), true, maxConcurrency, 1);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Maybe<T> create(MaybeOnSubscribe<T> onSubscribe) {
        Objects.requireNonNull(onSubscribe, "onSubscribe is null");
        return RxJavaPlugins.onAssembly(new MaybeCreate(onSubscribe));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Maybe<T> defer(Supplier<? extends MaybeSource<? extends T>> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.onAssembly(new MaybeDefer(supplier));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Maybe<T> empty() {
        return RxJavaPlugins.onAssembly(MaybeEmpty.INSTANCE);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Maybe<T> error(Throwable throwable) {
        Objects.requireNonNull(throwable, "throwable is null");
        return RxJavaPlugins.onAssembly(new MaybeError(throwable));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Maybe<T> error(Supplier<? extends Throwable> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.onAssembly(new MaybeErrorCallable(supplier));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Maybe<T> fromAction(Action action) {
        Objects.requireNonNull(action, "action is null");
        return RxJavaPlugins.onAssembly(new MaybeFromAction(action));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Maybe<T> fromCompletable(CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "completableSource is null");
        return RxJavaPlugins.onAssembly(new MaybeFromCompletable(completableSource));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Maybe<T> fromSingle(SingleSource<T> single) {
        Objects.requireNonNull(single, "single is null");
        return RxJavaPlugins.onAssembly(new MaybeFromSingle(single));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Maybe<T> fromCallable(Callable<? extends T> callable) {
        Objects.requireNonNull(callable, "callable is null");
        return RxJavaPlugins.onAssembly(new MaybeFromCallable(callable));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Maybe<T> fromFuture(Future<? extends T> future) {
        Objects.requireNonNull(future, "future is null");
        return RxJavaPlugins.onAssembly(new MaybeFromFuture(future, 0L, null));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Maybe<T> fromFuture(Future<? extends T> future, long timeout, TimeUnit unit) {
        Objects.requireNonNull(future, "future is null");
        Objects.requireNonNull(unit, "unit is null");
        return RxJavaPlugins.onAssembly(new MaybeFromFuture(future, timeout, unit));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Maybe<T> fromObservable(ObservableSource<T> source) {
        Objects.requireNonNull(source, "source is null");
        return RxJavaPlugins.onAssembly(new ObservableElementAtMaybe(source, 0L));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public static <T> Maybe<T> fromPublisher(Publisher<T> source) {
        Objects.requireNonNull(source, "source is null");
        return RxJavaPlugins.onAssembly(new FlowableElementAtMaybePublisher(source, 0L));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Maybe<T> fromRunnable(Runnable run) {
        Objects.requireNonNull(run, "run is null");
        return RxJavaPlugins.onAssembly(new MaybeFromRunnable(run));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Maybe<T> fromSupplier(Supplier<? extends T> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.onAssembly(new MaybeFromSupplier(supplier));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Maybe<T> just(T item) {
        Objects.requireNonNull(item, "item is null");
        return RxJavaPlugins.onAssembly(new MaybeJust(item));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> merge(Iterable<? extends MaybeSource<? extends T>> sources) {
        return Flowable.fromIterable(sources).flatMapMaybe(Functions.identity(), false, Integer.MAX_VALUE);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> merge(Publisher<? extends MaybeSource<? extends T>> sources) {
        return merge(sources, Integer.MAX_VALUE);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> merge(Publisher<? extends MaybeSource<? extends T>> sources, int maxConcurrency) {
        Objects.requireNonNull(sources, "sources is null");
        ObjectHelper.verifyPositive(maxConcurrency, "maxConcurrency");
        return RxJavaPlugins.onAssembly(new FlowableFlatMapMaybePublisher(sources, Functions.identity(), false, maxConcurrency));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Maybe<T> merge(MaybeSource<? extends MaybeSource<? extends T>> source) {
        Objects.requireNonNull(source, "source is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatten(source, Functions.identity()));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> merge(MaybeSource<? extends T> source1, MaybeSource<? extends T> source2) {
        Objects.requireNonNull(source1, "source1 is null");
        Objects.requireNonNull(source2, "source2 is null");
        return mergeArray(source1, source2);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> merge(MaybeSource<? extends T> source1, MaybeSource<? extends T> source2, MaybeSource<? extends T> source3) {
        Objects.requireNonNull(source1, "source1 is null");
        Objects.requireNonNull(source2, "source2 is null");
        Objects.requireNonNull(source3, "source3 is null");
        return mergeArray(source1, source2, source3);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> merge(MaybeSource<? extends T> source1, MaybeSource<? extends T> source2, MaybeSource<? extends T> source3, MaybeSource<? extends T> source4) {
        Objects.requireNonNull(source1, "source1 is null");
        Objects.requireNonNull(source2, "source2 is null");
        Objects.requireNonNull(source3, "source3 is null");
        Objects.requireNonNull(source4, "source4 is null");
        return mergeArray(source1, source2, source3, source4);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SafeVarargs
    @SchedulerSupport("none")
    public static <T> Flowable<T> mergeArray(MaybeSource<? extends T>... sources) {
        Objects.requireNonNull(sources, "sources is null");
        if (sources.length == 0) {
            return Flowable.empty();
        }
        if (sources.length == 1) {
            return RxJavaPlugins.onAssembly(new MaybeToFlowable(sources[0]));
        }
        return RxJavaPlugins.onAssembly(new MaybeMergeArray(sources));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SafeVarargs
    @SchedulerSupport("none")
    public static <T> Flowable<T> mergeArrayDelayError(MaybeSource<? extends T>... sources) {
        Objects.requireNonNull(sources, "sources is null");
        return Flowable.fromArray(sources).flatMapMaybe(Functions.identity(), true, Math.max(1, sources.length));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> mergeDelayError(Iterable<? extends MaybeSource<? extends T>> sources) {
        return Flowable.fromIterable(sources).flatMapMaybe(Functions.identity(), true, Integer.MAX_VALUE);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends MaybeSource<? extends T>> sources) {
        return mergeDelayError(sources, Integer.MAX_VALUE);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends MaybeSource<? extends T>> sources, int maxConcurrency) {
        Objects.requireNonNull(sources, "sources is null");
        ObjectHelper.verifyPositive(maxConcurrency, "maxConcurrency");
        return RxJavaPlugins.onAssembly(new FlowableFlatMapMaybePublisher(sources, Functions.identity(), true, maxConcurrency));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> mergeDelayError(MaybeSource<? extends T> source1, MaybeSource<? extends T> source2) {
        Objects.requireNonNull(source1, "source1 is null");
        Objects.requireNonNull(source2, "source2 is null");
        return mergeArrayDelayError(source1, source2);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> mergeDelayError(MaybeSource<? extends T> source1, MaybeSource<? extends T> source2, MaybeSource<? extends T> source3) {
        Objects.requireNonNull(source1, "source1 is null");
        Objects.requireNonNull(source2, "source2 is null");
        Objects.requireNonNull(source3, "source3 is null");
        return mergeArrayDelayError(source1, source2, source3);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> mergeDelayError(MaybeSource<? extends T> source1, MaybeSource<? extends T> source2, MaybeSource<? extends T> source3, MaybeSource<? extends T> source4) {
        Objects.requireNonNull(source1, "source1 is null");
        Objects.requireNonNull(source2, "source2 is null");
        Objects.requireNonNull(source3, "source3 is null");
        Objects.requireNonNull(source4, "source4 is null");
        return mergeArrayDelayError(source1, source2, source3, source4);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Maybe<T> never() {
        return RxJavaPlugins.onAssembly(MaybeNever.INSTANCE);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Single<Boolean> sequenceEqual(MaybeSource<? extends T> source1, MaybeSource<? extends T> source2) {
        return sequenceEqual(source1, source2, ObjectHelper.equalsPredicate());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Single<Boolean> sequenceEqual(MaybeSource<? extends T> source1, MaybeSource<? extends T> source2, BiPredicate<? super T, ? super T> isEqual) {
        Objects.requireNonNull(source1, "source1 is null");
        Objects.requireNonNull(source2, "source2 is null");
        Objects.requireNonNull(isEqual, "isEqual is null");
        return RxJavaPlugins.onAssembly(new MaybeEqualSingle(source1, source2, isEqual));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public static <T> Flowable<T> switchOnNext(Publisher<? extends MaybeSource<? extends T>> sources) {
        Objects.requireNonNull(sources, "sources is null");
        return RxJavaPlugins.onAssembly(new FlowableSwitchMapMaybePublisher(sources, Functions.identity(), false));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> switchOnNextDelayError(Publisher<? extends MaybeSource<? extends T>> sources) {
        Objects.requireNonNull(sources, "sources is null");
        return RxJavaPlugins.onAssembly(new FlowableSwitchMapMaybePublisher(sources, Functions.identity(), true));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public static Maybe<Long> timer(long delay, TimeUnit unit) {
        return timer(delay, unit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public static Maybe<Long> timer(long delay, TimeUnit unit, Scheduler scheduler) {
        Objects.requireNonNull(unit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new MaybeTimer(Math.max(0L, delay), unit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Maybe<T> unsafeCreate(MaybeSource<T> onSubscribe) {
        if (onSubscribe instanceof Maybe) {
            throw new IllegalArgumentException("unsafeCreate(Maybe) should be upgraded");
        }
        Objects.requireNonNull(onSubscribe, "onSubscribe is null");
        return RxJavaPlugins.onAssembly(new MaybeUnsafeCreate(onSubscribe));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, D> Maybe<T> using(Supplier<? extends D> resourceSupplier, Function<? super D, ? extends MaybeSource<? extends T>> sourceSupplier, Consumer<? super D> resourceCleanup) {
        return using(resourceSupplier, sourceSupplier, resourceCleanup, true);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, D> Maybe<T> using(Supplier<? extends D> resourceSupplier, Function<? super D, ? extends MaybeSource<? extends T>> sourceSupplier, Consumer<? super D> resourceCleanup, boolean eager) {
        Objects.requireNonNull(resourceSupplier, "resourceSupplier is null");
        Objects.requireNonNull(sourceSupplier, "sourceSupplier is null");
        Objects.requireNonNull(resourceCleanup, "resourceCleanup is null");
        return RxJavaPlugins.onAssembly(new MaybeUsing(resourceSupplier, sourceSupplier, resourceCleanup, eager));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Maybe<T> wrap(MaybeSource<T> source) {
        if (source instanceof Maybe) {
            return RxJavaPlugins.onAssembly((Maybe) source);
        }
        Objects.requireNonNull(source, "source is null");
        return RxJavaPlugins.onAssembly(new MaybeUnsafeCreate(source));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Maybe<R> zip(Iterable<? extends MaybeSource<? extends T>> sources, Function<? super Object[], ? extends R> zipper) {
        Objects.requireNonNull(zipper, "zipper is null");
        Objects.requireNonNull(sources, "sources is null");
        return RxJavaPlugins.onAssembly(new MaybeZipIterable(sources, zipper));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, R> Maybe<R> zip(MaybeSource<? extends T1> source1, MaybeSource<? extends T2> source2, BiFunction<? super T1, ? super T2, ? extends R> zipper) {
        Objects.requireNonNull(source1, "source1 is null");
        Objects.requireNonNull(source2, "source2 is null");
        Objects.requireNonNull(zipper, "zipper is null");
        return zipArray(Functions.toFunction(zipper), source1, source2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, R> Maybe<R> zip(MaybeSource<? extends T1> source1, MaybeSource<? extends T2> source2, MaybeSource<? extends T3> source3, Function3<? super T1, ? super T2, ? super T3, ? extends R> zipper) {
        Objects.requireNonNull(source1, "source1 is null");
        Objects.requireNonNull(source2, "source2 is null");
        Objects.requireNonNull(source3, "source3 is null");
        Objects.requireNonNull(zipper, "zipper is null");
        return zipArray(Functions.toFunction(zipper), source1, source2, source3);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, R> Maybe<R> zip(MaybeSource<? extends T1> source1, MaybeSource<? extends T2> source2, MaybeSource<? extends T3> source3, MaybeSource<? extends T4> source4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> zipper) {
        Objects.requireNonNull(source1, "source1 is null");
        Objects.requireNonNull(source2, "source2 is null");
        Objects.requireNonNull(source3, "source3 is null");
        Objects.requireNonNull(source4, "source4 is null");
        Objects.requireNonNull(zipper, "zipper is null");
        return zipArray(Functions.toFunction(zipper), source1, source2, source3, source4);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, R> Maybe<R> zip(MaybeSource<? extends T1> source1, MaybeSource<? extends T2> source2, MaybeSource<? extends T3> source3, MaybeSource<? extends T4> source4, MaybeSource<? extends T5> source5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> zipper) {
        Objects.requireNonNull(source1, "source1 is null");
        Objects.requireNonNull(source2, "source2 is null");
        Objects.requireNonNull(source3, "source3 is null");
        Objects.requireNonNull(source4, "source4 is null");
        Objects.requireNonNull(source5, "source5 is null");
        Objects.requireNonNull(zipper, "zipper is null");
        return zipArray(Functions.toFunction(zipper), source1, source2, source3, source4, source5);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, R> Maybe<R> zip(MaybeSource<? extends T1> source1, MaybeSource<? extends T2> source2, MaybeSource<? extends T3> source3, MaybeSource<? extends T4> source4, MaybeSource<? extends T5> source5, MaybeSource<? extends T6> source6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> zipper) {
        Objects.requireNonNull(source1, "source1 is null");
        Objects.requireNonNull(source2, "source2 is null");
        Objects.requireNonNull(source3, "source3 is null");
        Objects.requireNonNull(source4, "source4 is null");
        Objects.requireNonNull(source5, "source5 is null");
        Objects.requireNonNull(source6, "source6 is null");
        Objects.requireNonNull(zipper, "zipper is null");
        return zipArray(Functions.toFunction(zipper), source1, source2, source3, source4, source5, source6);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> Maybe<R> zip(MaybeSource<? extends T1> source1, MaybeSource<? extends T2> source2, MaybeSource<? extends T3> source3, MaybeSource<? extends T4> source4, MaybeSource<? extends T5> source5, MaybeSource<? extends T6> source6, MaybeSource<? extends T7> source7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> zipper) {
        Objects.requireNonNull(source1, "source1 is null");
        Objects.requireNonNull(source2, "source2 is null");
        Objects.requireNonNull(source3, "source3 is null");
        Objects.requireNonNull(source4, "source4 is null");
        Objects.requireNonNull(source5, "source5 is null");
        Objects.requireNonNull(source6, "source6 is null");
        Objects.requireNonNull(source7, "source7 is null");
        Objects.requireNonNull(zipper, "zipper is null");
        return zipArray(Functions.toFunction(zipper), source1, source2, source3, source4, source5, source6, source7);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Maybe<R> zip(MaybeSource<? extends T1> source1, MaybeSource<? extends T2> source2, MaybeSource<? extends T3> source3, MaybeSource<? extends T4> source4, MaybeSource<? extends T5> source5, MaybeSource<? extends T6> source6, MaybeSource<? extends T7> source7, MaybeSource<? extends T8> source8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> zipper) {
        Objects.requireNonNull(source1, "source1 is null");
        Objects.requireNonNull(source2, "source2 is null");
        Objects.requireNonNull(source3, "source3 is null");
        Objects.requireNonNull(source4, "source4 is null");
        Objects.requireNonNull(source5, "source5 is null");
        Objects.requireNonNull(source6, "source6 is null");
        Objects.requireNonNull(source7, "source7 is null");
        Objects.requireNonNull(source8, "source8 is null");
        Objects.requireNonNull(zipper, "zipper is null");
        return zipArray(Functions.toFunction(zipper), source1, source2, source3, source4, source5, source6, source7, source8);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Maybe<R> zip(MaybeSource<? extends T1> source1, MaybeSource<? extends T2> source2, MaybeSource<? extends T3> source3, MaybeSource<? extends T4> source4, MaybeSource<? extends T5> source5, MaybeSource<? extends T6> source6, MaybeSource<? extends T7> source7, MaybeSource<? extends T8> source8, MaybeSource<? extends T9> source9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> zipper) {
        Objects.requireNonNull(source1, "source1 is null");
        Objects.requireNonNull(source2, "source2 is null");
        Objects.requireNonNull(source3, "source3 is null");
        Objects.requireNonNull(source4, "source4 is null");
        Objects.requireNonNull(source5, "source5 is null");
        Objects.requireNonNull(source6, "source6 is null");
        Objects.requireNonNull(source7, "source7 is null");
        Objects.requireNonNull(source8, "source8 is null");
        Objects.requireNonNull(source9, "source9 is null");
        Objects.requireNonNull(zipper, "zipper is null");
        return zipArray(Functions.toFunction(zipper), source1, source2, source3, source4, source5, source6, source7, source8, source9);
    }

    @CheckReturnValue
    @SafeVarargs
    @SchedulerSupport("none")
    public static <T, R> Maybe<R> zipArray(Function<? super Object[], ? extends R> zipper, MaybeSource<? extends T>... sources) {
        Objects.requireNonNull(sources, "sources is null");
        if (sources.length == 0) {
            return empty();
        }
        Objects.requireNonNull(zipper, "zipper is null");
        return RxJavaPlugins.onAssembly(new MaybeZipArray(sources, zipper));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> ambWith(MaybeSource<? extends T> other) {
        Objects.requireNonNull(other, "other is null");
        return ambArray(this, other);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final T blockingGet() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        return (T) blockingMultiObserver.blockingGet();
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final T blockingGet(T defaultValue) {
        Objects.requireNonNull(defaultValue, "defaultValue is null");
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        return (T) blockingMultiObserver.blockingGet(defaultValue);
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe() {
        blockingSubscribe(Functions.emptyConsumer(), Functions.ERROR_CONSUMER, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> onSuccess) {
        blockingSubscribe(onSuccess, Functions.ERROR_CONSUMER, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> onSuccess, Consumer<? super Throwable> onError) {
        blockingSubscribe(onSuccess, onError, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> onSuccess, Consumer<? super Throwable> onError, Action onComplete) {
        Objects.requireNonNull(onSuccess, "onSuccess is null");
        Objects.requireNonNull(onError, "onError is null");
        Objects.requireNonNull(onComplete, "onComplete is null");
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        blockingMultiObserver.blockingConsume(onSuccess, onError, onComplete);
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(MaybeObserver<? super T> observer) {
        Objects.requireNonNull(observer, "observer is null");
        BlockingDisposableMultiObserver blockingDisposableMultiObserver = new BlockingDisposableMultiObserver();
        observer.onSubscribe(blockingDisposableMultiObserver);
        subscribe(blockingDisposableMultiObserver);
        blockingDisposableMultiObserver.blockingConsume(observer);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> cache() {
        return RxJavaPlugins.onAssembly(new MaybeCache(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Maybe<U> cast(Class<? extends U> clazz) {
        Objects.requireNonNull(clazz, "clazz is null");
        return (Maybe<U>) map(Functions.castFunction(clazz));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Maybe<R> compose(MaybeTransformer<? super T, ? extends R> transformer) {
        Objects.requireNonNull(transformer, "transformer is null");
        return wrap(transformer.apply(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Maybe<R> concatMap(Function<? super T, ? extends MaybeSource<? extends R>> mapper) {
        return flatMap(mapper);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> mapper) {
        return flatMapCompletable(mapper);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Maybe<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> mapper) {
        return flatMapSingle(mapper);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> concatWith(MaybeSource<? extends T> other) {
        Objects.requireNonNull(other, "other is null");
        return concat(this, other);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<Boolean> contains(Object item) {
        Objects.requireNonNull(item, "item is null");
        return RxJavaPlugins.onAssembly(new MaybeContains(this, item));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<Long> count() {
        return RxJavaPlugins.onAssembly(new MaybeCount(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<T> defaultIfEmpty(T defaultItem) {
        Objects.requireNonNull(defaultItem, "defaultItem is null");
        return RxJavaPlugins.onAssembly(new MaybeToSingle(this, defaultItem));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Maybe<R> dematerialize(Function<? super T, Notification<R>> selector) {
        Objects.requireNonNull(selector, "selector is null");
        return RxJavaPlugins.onAssembly(new MaybeDematerialize(this, selector));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Maybe<T> delay(long time, TimeUnit unit) {
        return delay(time, unit, Schedulers.computation(), false);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Maybe<T> delay(long time, TimeUnit unit, boolean delayError) {
        return delay(time, unit, Schedulers.computation(), delayError);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Maybe<T> delay(long time, TimeUnit unit, Scheduler scheduler) {
        return delay(time, unit, scheduler, false);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Maybe<T> delay(long time, TimeUnit unit, Scheduler scheduler, boolean delayError) {
        Objects.requireNonNull(unit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new MaybeDelay(this, Math.max(0L, time), unit, scheduler, delayError));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final <U> Maybe<T> delay(Publisher<U> delayIndicator) {
        Objects.requireNonNull(delayIndicator, "delayIndicator is null");
        return RxJavaPlugins.onAssembly(new MaybeDelayOtherPublisher(this, delayIndicator));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final <U> Maybe<T> delaySubscription(Publisher<U> subscriptionIndicator) {
        Objects.requireNonNull(subscriptionIndicator, "subscriptionIndicator is null");
        return RxJavaPlugins.onAssembly(new MaybeDelaySubscriptionOtherPublisher(this, subscriptionIndicator));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Maybe<T> delaySubscription(long time, TimeUnit unit) {
        return delaySubscription(time, unit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Maybe<T> delaySubscription(long time, TimeUnit unit, Scheduler scheduler) {
        return delaySubscription(Flowable.timer(time, unit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> doAfterSuccess(Consumer<? super T> onAfterSuccess) {
        Objects.requireNonNull(onAfterSuccess, "onAfterSuccess is null");
        return RxJavaPlugins.onAssembly(new MaybeDoAfterSuccess(this, onAfterSuccess));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> doAfterTerminate(Action onAfterTerminate) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        Objects.requireNonNull(onAfterTerminate, "onAfterTerminate is null");
        return RxJavaPlugins.onAssembly(new MaybePeek(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action, onAfterTerminate, Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> doFinally(Action onFinally) {
        Objects.requireNonNull(onFinally, "onFinally is null");
        return RxJavaPlugins.onAssembly(new MaybeDoFinally(this, onFinally));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> doOnDispose(Action onDispose) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        Action action2 = Functions.EMPTY_ACTION;
        Objects.requireNonNull(onDispose, "onDispose is null");
        return RxJavaPlugins.onAssembly(new MaybePeek(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action, action2, onDispose));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> doOnComplete(Action onComplete) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Objects.requireNonNull(onComplete, "onComplete is null");
        return RxJavaPlugins.onAssembly(new MaybePeek(this, emptyConsumer, emptyConsumer2, emptyConsumer3, onComplete, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> doOnError(Consumer<? super Throwable> onError) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Objects.requireNonNull(onError, "onError is null");
        return RxJavaPlugins.onAssembly(new MaybePeek(this, emptyConsumer, emptyConsumer2, onError, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> doOnEvent(BiConsumer<? super T, ? super Throwable> onEvent) {
        Objects.requireNonNull(onEvent, "onEvent is null");
        return RxJavaPlugins.onAssembly(new MaybeDoOnEvent(this, onEvent));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> doOnLifecycle(Consumer<? super Disposable> onSubscribe, Action onDispose) {
        Objects.requireNonNull(onSubscribe, "onSubscribe is null");
        Objects.requireNonNull(onDispose, "onDispose is null");
        return RxJavaPlugins.onAssembly(new MaybeDoOnLifecycle(this, onSubscribe, onDispose));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> doOnSubscribe(Consumer<? super Disposable> onSubscribe) {
        Objects.requireNonNull(onSubscribe, "onSubscribe is null");
        return RxJavaPlugins.onAssembly(new MaybePeek(this, onSubscribe, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> doOnTerminate(Action onTerminate) {
        Objects.requireNonNull(onTerminate, "onTerminate is null");
        return RxJavaPlugins.onAssembly(new MaybeDoOnTerminate(this, onTerminate));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> doOnSuccess(Consumer<? super T> onSuccess) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Objects.requireNonNull(onSuccess, "onSuccess is null");
        return RxJavaPlugins.onAssembly(new MaybePeek(this, emptyConsumer, onSuccess, Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> filter(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new MaybeFilter(this, predicate));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Maybe<R> flatMap(Function<? super T, ? extends MaybeSource<? extends R>> mapper) {
        Objects.requireNonNull(mapper, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatten(this, mapper));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Maybe<R> flatMap(Function<? super T, ? extends MaybeSource<? extends R>> onSuccessMapper, Function<? super Throwable, ? extends MaybeSource<? extends R>> onErrorMapper, Supplier<? extends MaybeSource<? extends R>> onCompleteSupplier) {
        Objects.requireNonNull(onSuccessMapper, "onSuccessMapper is null");
        Objects.requireNonNull(onErrorMapper, "onErrorMapper is null");
        Objects.requireNonNull(onCompleteSupplier, "onCompleteSupplier is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatMapNotification(this, onSuccessMapper, onErrorMapper, onCompleteSupplier));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, R> Maybe<R> flatMap(Function<? super T, ? extends MaybeSource<? extends U>> mapper, BiFunction<? super T, ? super U, ? extends R> combiner) {
        Objects.requireNonNull(mapper, "mapper is null");
        Objects.requireNonNull(combiner, "combiner is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatMapBiSelector(this, mapper, combiner));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <U> Flowable<U> flattenAsFlowable(Function<? super T, ? extends Iterable<? extends U>> mapper) {
        Objects.requireNonNull(mapper, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatMapIterableFlowable(this, mapper));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<U> flattenAsObservable(Function<? super T, ? extends Iterable<? extends U>> mapper) {
        Objects.requireNonNull(mapper, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatMapIterableObservable(this, mapper));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> flatMapObservable(Function<? super T, ? extends ObservableSource<? extends R>> mapper) {
        Objects.requireNonNull(mapper, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatMapObservable(this, mapper));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <R> Flowable<R> flatMapPublisher(Function<? super T, ? extends Publisher<? extends R>> mapper) {
        Objects.requireNonNull(mapper, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatMapPublisher(this, mapper));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Maybe<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> mapper) {
        Objects.requireNonNull(mapper, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatMapSingle(this, mapper));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> mapper) {
        Objects.requireNonNull(mapper, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatMapCompletable(this, mapper));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> hide() {
        return RxJavaPlugins.onAssembly(new MaybeHide(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable ignoreElement() {
        return RxJavaPlugins.onAssembly(new MaybeIgnoreElementCompletable(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<Boolean> isEmpty() {
        return RxJavaPlugins.onAssembly(new MaybeIsEmptySingle(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Maybe<R> lift(MaybeOperator<? extends R, ? super T> lift) {
        Objects.requireNonNull(lift, "lift is null");
        return RxJavaPlugins.onAssembly(new MaybeLift(this, lift));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Maybe<R> map(Function<? super T, ? extends R> mapper) {
        Objects.requireNonNull(mapper, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeMap(this, mapper));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<Notification<T>> materialize() {
        return RxJavaPlugins.onAssembly(new MaybeMaterialize(this));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> mergeWith(MaybeSource<? extends T> other) {
        Objects.requireNonNull(other, "other is null");
        return merge(this, other);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Maybe<T> observeOn(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new MaybeObserveOn(this, scheduler));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Maybe<U> ofType(Class<U> clazz) {
        Objects.requireNonNull(clazz, "clazz is null");
        return filter(Functions.isInstanceOf(clazz)).cast(clazz);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: to */
    public final <R> R m115to(MaybeConverter<T, ? extends R> converter) {
        Objects.requireNonNull(converter, "converter is null");
        return converter.apply(this);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Flowable<T> toFlowable() {
        if (this instanceof FuseToFlowable) {
            return ((FuseToFlowable) this).fuseToFlowable();
        }
        return RxJavaPlugins.onAssembly(new MaybeToFlowable(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Future<T> toFuture() {
        return (Future) subscribeWith(new FutureMultiObserver());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> toObservable() {
        if (this instanceof FuseToObservable) {
            return ((FuseToObservable) this).fuseToObservable();
        }
        return RxJavaPlugins.onAssembly(new MaybeToObservable(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<T> toSingle() {
        return RxJavaPlugins.onAssembly(new MaybeToSingle(this, null));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> onErrorComplete() {
        return onErrorComplete(Functions.alwaysTrue());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> onErrorComplete(Predicate<? super Throwable> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new MaybeOnErrorComplete(this, predicate));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> onErrorResumeWith(MaybeSource<? extends T> fallback) {
        Objects.requireNonNull(fallback, "fallback is null");
        return onErrorResumeNext(Functions.justFunction(fallback));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> onErrorResumeNext(Function<? super Throwable, ? extends MaybeSource<? extends T>> fallbackSupplier) {
        Objects.requireNonNull(fallbackSupplier, "fallbackSupplier is null");
        return RxJavaPlugins.onAssembly(new MaybeOnErrorNext(this, fallbackSupplier));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> onErrorReturn(Function<? super Throwable, ? extends T> itemSupplier) {
        Objects.requireNonNull(itemSupplier, "itemSupplier is null");
        return RxJavaPlugins.onAssembly(new MaybeOnErrorReturn(this, itemSupplier));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> onErrorReturnItem(T item) {
        Objects.requireNonNull(item, "item is null");
        return onErrorReturn(Functions.justFunction(item));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> onTerminateDetach() {
        return RxJavaPlugins.onAssembly(new MaybeDetach(this));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Flowable<T> repeat() {
        return repeat(Long.MAX_VALUE);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> repeat(long times) {
        return toFlowable().repeat(times);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> repeatUntil(BooleanSupplier stop) {
        return toFlowable().repeatUntil(stop);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> handler) {
        return toFlowable().repeatWhen(handler);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> retry() {
        return retry(Long.MAX_VALUE, Functions.alwaysTrue());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> retry(BiPredicate<? super Integer, ? super Throwable> predicate) {
        return toFlowable().retry(predicate).singleElement();
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> retry(long times) {
        return retry(times, Functions.alwaysTrue());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> retry(long times, Predicate<? super Throwable> predicate) {
        return toFlowable().retry(times, predicate).singleElement();
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> retry(Predicate<? super Throwable> predicate) {
        return retry(Long.MAX_VALUE, predicate);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> retryUntil(BooleanSupplier stop) {
        Objects.requireNonNull(stop, "stop is null");
        return retry(Long.MAX_VALUE, Functions.predicateReverseFor(stop));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> handler) {
        return toFlowable().retryWhen(handler).singleElement();
    }

    @SchedulerSupport("none")
    public final void safeSubscribe(MaybeObserver<? super T> observer) {
        Objects.requireNonNull(observer, "observer is null");
        subscribe(new SafeMaybeObserver(observer));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> startWith(CompletableSource other) {
        Objects.requireNonNull(other, "other is null");
        return Flowable.concat(Completable.wrap(other).toFlowable(), toFlowable());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> startWith(SingleSource<T> other) {
        Objects.requireNonNull(other, "other is null");
        return Flowable.concat(Single.wrap(other).toFlowable(), toFlowable());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> startWith(MaybeSource<T> other) {
        Objects.requireNonNull(other, "other is null");
        return Flowable.concat(wrap(other).toFlowable(), toFlowable());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> startWith(ObservableSource<T> other) {
        Objects.requireNonNull(other, "other is null");
        return Observable.wrap(other).concatWith(toObservable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> startWith(Publisher<T> other) {
        Objects.requireNonNull(other, "other is null");
        return toFlowable().startWith(other);
    }

    @SchedulerSupport("none")
    public final Disposable subscribe() {
        return subscribe(Functions.emptyConsumer(), Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Disposable subscribe(Consumer<? super T> onSuccess) {
        return subscribe(onSuccess, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Disposable subscribe(Consumer<? super T> onSuccess, Consumer<? super Throwable> onError) {
        return subscribe(onSuccess, onError, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Disposable subscribe(Consumer<? super T> onSuccess, Consumer<? super Throwable> onError, Action onComplete) {
        Objects.requireNonNull(onSuccess, "onSuccess is null");
        Objects.requireNonNull(onError, "onError is null");
        Objects.requireNonNull(onComplete, "onComplete is null");
        return (Disposable) subscribeWith(new MaybeCallbackObserver(onSuccess, onError, onComplete));
    }

    @Override // io.reactivex.rxjava3.core.MaybeSource
    @SchedulerSupport("none")
    public final void subscribe(MaybeObserver<? super T> observer) {
        Objects.requireNonNull(observer, "observer is null");
        MaybeObserver<? super T> onSubscribe = RxJavaPlugins.onSubscribe(this, observer);
        Objects.requireNonNull(onSubscribe, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            subscribeActual(onSubscribe);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Maybe<T> subscribeOn(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new MaybeSubscribeOn(this, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <E extends MaybeObserver<? super T>> E subscribeWith(E observer) {
        subscribe(observer);
        return observer;
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> switchIfEmpty(MaybeSource<? extends T> other) {
        Objects.requireNonNull(other, "other is null");
        return RxJavaPlugins.onAssembly(new MaybeSwitchIfEmpty(this, other));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<T> switchIfEmpty(SingleSource<? extends T> other) {
        Objects.requireNonNull(other, "other is null");
        return RxJavaPlugins.onAssembly(new MaybeSwitchIfEmptySingle(this, other));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Maybe<T> takeUntil(MaybeSource<U> other) {
        Objects.requireNonNull(other, "other is null");
        return RxJavaPlugins.onAssembly(new MaybeTakeUntilMaybe(this, other));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final <U> Maybe<T> takeUntil(Publisher<U> other) {
        Objects.requireNonNull(other, "other is null");
        return RxJavaPlugins.onAssembly(new MaybeTakeUntilPublisher(this, other));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Maybe<Timed<T>> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Maybe<Timed<T>> timeInterval(Scheduler scheduler) {
        return timeInterval(TimeUnit.MILLISECONDS, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Maybe<Timed<T>> timeInterval(TimeUnit unit) {
        return timeInterval(unit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Maybe<Timed<T>> timeInterval(TimeUnit unit, Scheduler scheduler) {
        Objects.requireNonNull(unit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new MaybeTimeInterval(this, unit, scheduler, true));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Maybe<Timed<T>> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Maybe<Timed<T>> timestamp(Scheduler scheduler) {
        return timestamp(TimeUnit.MILLISECONDS, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Maybe<Timed<T>> timestamp(TimeUnit unit) {
        return timestamp(unit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Maybe<Timed<T>> timestamp(TimeUnit unit, Scheduler scheduler) {
        Objects.requireNonNull(unit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new MaybeTimeInterval(this, unit, scheduler, false));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Maybe<T> timeout(long timeout, TimeUnit unit) {
        return timeout(timeout, unit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Maybe<T> timeout(long timeout, TimeUnit unit, MaybeSource<? extends T> fallback) {
        Objects.requireNonNull(fallback, "fallback is null");
        return timeout(timeout, unit, Schedulers.computation(), fallback);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Maybe<T> timeout(long timeout, TimeUnit unit, Scheduler scheduler, MaybeSource<? extends T> fallback) {
        Objects.requireNonNull(fallback, "fallback is null");
        return timeout(timer(timeout, unit, scheduler), fallback);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Maybe<T> timeout(long timeout, TimeUnit unit, Scheduler scheduler) {
        return timeout(timer(timeout, unit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Maybe<T> timeout(MaybeSource<U> timeoutIndicator) {
        Objects.requireNonNull(timeoutIndicator, "timeoutIndicator is null");
        return RxJavaPlugins.onAssembly(new MaybeTimeoutMaybe(this, timeoutIndicator, null));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Maybe<T> timeout(MaybeSource<U> timeoutIndicator, MaybeSource<? extends T> fallback) {
        Objects.requireNonNull(timeoutIndicator, "timeoutIndicator is null");
        Objects.requireNonNull(fallback, "fallback is null");
        return RxJavaPlugins.onAssembly(new MaybeTimeoutMaybe(this, timeoutIndicator, fallback));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final <U> Maybe<T> timeout(Publisher<U> timeoutIndicator) {
        Objects.requireNonNull(timeoutIndicator, "timeoutIndicator is null");
        return RxJavaPlugins.onAssembly(new MaybeTimeoutPublisher(this, timeoutIndicator, null));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final <U> Maybe<T> timeout(Publisher<U> timeoutIndicator, MaybeSource<? extends T> fallback) {
        Objects.requireNonNull(timeoutIndicator, "timeoutIndicator is null");
        Objects.requireNonNull(fallback, "fallback is null");
        return RxJavaPlugins.onAssembly(new MaybeTimeoutPublisher(this, timeoutIndicator, fallback));
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Maybe<T> unsubscribeOn(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new MaybeUnsubscribeOn(this, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, R> Maybe<R> zipWith(MaybeSource<? extends U> other, BiFunction<? super T, ? super U, ? extends R> zipper) {
        Objects.requireNonNull(other, "other is null");
        return zip(this, other, zipper);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final TestObserver<T> test() {
        TestObserver<T> testObserver = new TestObserver<>();
        subscribe(testObserver);
        return testObserver;
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final TestObserver<T> test(boolean dispose) {
        TestObserver<T> testObserver = new TestObserver<>();
        if (dispose) {
            testObserver.dispose();
        }
        subscribe(testObserver);
        return testObserver;
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Maybe<T> fromOptional(Optional<T> optional) {
        Objects.requireNonNull(optional, "optional is null");
        return (Maybe) optional.map($$Lambda$x9C_3FtG8jwsPfMw7SxZKNbSE0.INSTANCE).orElseGet($$Lambda$3ZDUt9BH1D18za8YKJpE0B3yoSI.INSTANCE);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Maybe<T> fromCompletionStage(CompletionStage<T> stage) {
        Objects.requireNonNull(stage, "stage is null");
        return RxJavaPlugins.onAssembly(new MaybeFromCompletionStage(stage));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Maybe<R> mapOptional(Function<? super T, Optional<? extends R>> mapper) {
        Objects.requireNonNull(mapper, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeMapOptional(this, mapper));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final CompletionStage<T> toCompletionStage() {
        return (CompletionStage) subscribeWith(new CompletionStageConsumer(false, null));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final CompletionStage<T> toCompletionStage(T defaultItem) {
        return (CompletionStage) subscribeWith(new CompletionStageConsumer(true, defaultItem));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <R> Flowable<R> flattenStreamAsFlowable(Function<? super T, ? extends Stream<? extends R>> mapper) {
        Objects.requireNonNull(mapper, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeFlattenStreamAsFlowable(this, mapper));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> flattenStreamAsObservable(Function<? super T, ? extends Stream<? extends R>> mapper) {
        Objects.requireNonNull(mapper, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeFlattenStreamAsObservable(this, mapper));
    }
}
