package io.reactivex.rxjava3.plugins;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import io.reactivex.rxjava3.exceptions.UndeliverableException;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.schedulers.ComputationScheduler;
import io.reactivex.rxjava3.internal.schedulers.IoScheduler;
import io.reactivex.rxjava3.internal.schedulers.NewThreadScheduler;
import io.reactivex.rxjava3.internal.schedulers.SingleScheduler;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import org.reactivestreams.Subscriber;

/* loaded from: classes4.dex */
public final class RxJavaPlugins {
    static volatile Consumer<? super Throwable> errorHandler;
    static volatile boolean failNonBlockingScheduler;
    static volatile boolean lockdown;
    static volatile BooleanSupplier onBeforeBlocking;
    static volatile Function<? super Completable, ? extends Completable> onCompletableAssembly;
    static volatile BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> onCompletableSubscribe;
    static volatile Function<? super Scheduler, ? extends Scheduler> onComputationHandler;
    static volatile Function<? super ConnectableFlowable, ? extends ConnectableFlowable> onConnectableFlowableAssembly;
    static volatile Function<? super ConnectableObservable, ? extends ConnectableObservable> onConnectableObservableAssembly;
    static volatile Function<? super Flowable, ? extends Flowable> onFlowableAssembly;
    static volatile BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> onFlowableSubscribe;
    static volatile Function<? super Supplier<Scheduler>, ? extends Scheduler> onInitComputationHandler;
    static volatile Function<? super Supplier<Scheduler>, ? extends Scheduler> onInitIoHandler;
    static volatile Function<? super Supplier<Scheduler>, ? extends Scheduler> onInitNewThreadHandler;
    static volatile Function<? super Supplier<Scheduler>, ? extends Scheduler> onInitSingleHandler;
    static volatile Function<? super Scheduler, ? extends Scheduler> onIoHandler;
    static volatile Function<? super Maybe, ? extends Maybe> onMaybeAssembly;
    static volatile BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> onMaybeSubscribe;
    static volatile Function<? super Scheduler, ? extends Scheduler> onNewThreadHandler;
    static volatile Function<? super Observable, ? extends Observable> onObservableAssembly;
    static volatile BiFunction<? super Observable, ? super Observer, ? extends Observer> onObservableSubscribe;
    static volatile Function<? super ParallelFlowable, ? extends ParallelFlowable> onParallelAssembly;
    static volatile Function<? super Runnable, ? extends Runnable> onScheduleHandler;
    static volatile Function<? super Single, ? extends Single> onSingleAssembly;
    static volatile Function<? super Scheduler, ? extends Scheduler> onSingleHandler;
    static volatile BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> onSingleSubscribe;

    public static void lockdown() {
        lockdown = true;
    }

    public static boolean isLockdown() {
        return lockdown;
    }

    public static void setFailOnNonBlockingScheduler(boolean enable) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        failNonBlockingScheduler = enable;
    }

    public static boolean isFailOnNonBlockingScheduler() {
        return failNonBlockingScheduler;
    }

    public static Function<? super Scheduler, ? extends Scheduler> getComputationSchedulerHandler() {
        return onComputationHandler;
    }

    public static Consumer<? super Throwable> getErrorHandler() {
        return errorHandler;
    }

    public static Function<? super Supplier<Scheduler>, ? extends Scheduler> getInitComputationSchedulerHandler() {
        return onInitComputationHandler;
    }

    public static Function<? super Supplier<Scheduler>, ? extends Scheduler> getInitIoSchedulerHandler() {
        return onInitIoHandler;
    }

    public static Function<? super Supplier<Scheduler>, ? extends Scheduler> getInitNewThreadSchedulerHandler() {
        return onInitNewThreadHandler;
    }

    public static Function<? super Supplier<Scheduler>, ? extends Scheduler> getInitSingleSchedulerHandler() {
        return onInitSingleHandler;
    }

    public static Function<? super Scheduler, ? extends Scheduler> getIoSchedulerHandler() {
        return onIoHandler;
    }

    public static Function<? super Scheduler, ? extends Scheduler> getNewThreadSchedulerHandler() {
        return onNewThreadHandler;
    }

    public static Function<? super Runnable, ? extends Runnable> getScheduleHandler() {
        return onScheduleHandler;
    }

    public static Function<? super Scheduler, ? extends Scheduler> getSingleSchedulerHandler() {
        return onSingleHandler;
    }

    public static Scheduler initComputationScheduler(Supplier<Scheduler> defaultScheduler) {
        Objects.requireNonNull(defaultScheduler, "Scheduler Supplier can't be null");
        Function<? super Supplier<Scheduler>, ? extends Scheduler> function = onInitComputationHandler;
        if (function == null) {
            return callRequireNonNull(defaultScheduler);
        }
        return applyRequireNonNull(function, defaultScheduler);
    }

    public static Scheduler initIoScheduler(Supplier<Scheduler> defaultScheduler) {
        Objects.requireNonNull(defaultScheduler, "Scheduler Supplier can't be null");
        Function<? super Supplier<Scheduler>, ? extends Scheduler> function = onInitIoHandler;
        if (function == null) {
            return callRequireNonNull(defaultScheduler);
        }
        return applyRequireNonNull(function, defaultScheduler);
    }

    public static Scheduler initNewThreadScheduler(Supplier<Scheduler> defaultScheduler) {
        Objects.requireNonNull(defaultScheduler, "Scheduler Supplier can't be null");
        Function<? super Supplier<Scheduler>, ? extends Scheduler> function = onInitNewThreadHandler;
        if (function == null) {
            return callRequireNonNull(defaultScheduler);
        }
        return applyRequireNonNull(function, defaultScheduler);
    }

    public static Scheduler initSingleScheduler(Supplier<Scheduler> defaultScheduler) {
        Objects.requireNonNull(defaultScheduler, "Scheduler Supplier can't be null");
        Function<? super Supplier<Scheduler>, ? extends Scheduler> function = onInitSingleHandler;
        if (function == null) {
            return callRequireNonNull(defaultScheduler);
        }
        return applyRequireNonNull(function, defaultScheduler);
    }

    public static Scheduler onComputationScheduler(Scheduler defaultScheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = onComputationHandler;
        return function == null ? defaultScheduler : (Scheduler) apply(function, defaultScheduler);
    }

    public static void onError(Throwable error) {
        Consumer<? super Throwable> consumer = errorHandler;
        if (error == null) {
            error = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
        } else if (!isBug(error)) {
            error = new UndeliverableException(error);
        }
        if (consumer != null) {
            try {
                consumer.accept(error);
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                uncaught(th);
            }
        }
        error.printStackTrace();
        uncaught(error);
    }

    static boolean isBug(Throwable error) {
        return (error instanceof OnErrorNotImplementedException) || (error instanceof MissingBackpressureException) || (error instanceof IllegalStateException) || (error instanceof NullPointerException) || (error instanceof IllegalArgumentException) || (error instanceof CompositeException);
    }

    static void uncaught(Throwable error) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, error);
    }

    public static Scheduler onIoScheduler(Scheduler defaultScheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = onIoHandler;
        return function == null ? defaultScheduler : (Scheduler) apply(function, defaultScheduler);
    }

    public static Scheduler onNewThreadScheduler(Scheduler defaultScheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = onNewThreadHandler;
        return function == null ? defaultScheduler : (Scheduler) apply(function, defaultScheduler);
    }

    public static Runnable onSchedule(Runnable run) {
        Objects.requireNonNull(run, "run is null");
        Function<? super Runnable, ? extends Runnable> function = onScheduleHandler;
        return function == null ? run : (Runnable) apply(function, run);
    }

    public static Scheduler onSingleScheduler(Scheduler defaultScheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = onSingleHandler;
        return function == null ? defaultScheduler : (Scheduler) apply(function, defaultScheduler);
    }

    public static void reset() {
        setErrorHandler(null);
        setScheduleHandler(null);
        setComputationSchedulerHandler(null);
        setInitComputationSchedulerHandler(null);
        setIoSchedulerHandler(null);
        setInitIoSchedulerHandler(null);
        setSingleSchedulerHandler(null);
        setInitSingleSchedulerHandler(null);
        setNewThreadSchedulerHandler(null);
        setInitNewThreadSchedulerHandler(null);
        setOnFlowableAssembly(null);
        setOnFlowableSubscribe(null);
        setOnObservableAssembly(null);
        setOnObservableSubscribe(null);
        setOnSingleAssembly(null);
        setOnSingleSubscribe(null);
        setOnCompletableAssembly(null);
        setOnCompletableSubscribe(null);
        setOnConnectableFlowableAssembly(null);
        setOnConnectableObservableAssembly(null);
        setOnMaybeAssembly(null);
        setOnMaybeSubscribe(null);
        setOnParallelAssembly(null);
        setFailOnNonBlockingScheduler(false);
        setOnBeforeBlocking(null);
    }

    public static void setComputationSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> handler) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        onComputationHandler = handler;
    }

    public static void setErrorHandler(Consumer<? super Throwable> handler) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        errorHandler = handler;
    }

    public static void setInitComputationSchedulerHandler(Function<? super Supplier<Scheduler>, ? extends Scheduler> handler) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        onInitComputationHandler = handler;
    }

    public static void setInitIoSchedulerHandler(Function<? super Supplier<Scheduler>, ? extends Scheduler> handler) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        onInitIoHandler = handler;
    }

    public static void setInitNewThreadSchedulerHandler(Function<? super Supplier<Scheduler>, ? extends Scheduler> handler) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        onInitNewThreadHandler = handler;
    }

    public static void setInitSingleSchedulerHandler(Function<? super Supplier<Scheduler>, ? extends Scheduler> handler) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        onInitSingleHandler = handler;
    }

    public static void setIoSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> handler) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        onIoHandler = handler;
    }

    public static void setNewThreadSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> handler) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        onNewThreadHandler = handler;
    }

    public static void setScheduleHandler(Function<? super Runnable, ? extends Runnable> handler) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        onScheduleHandler = handler;
    }

    public static void setSingleSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> handler) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        onSingleHandler = handler;
    }

    static void unlock() {
        lockdown = false;
    }

    public static Function<? super Completable, ? extends Completable> getOnCompletableAssembly() {
        return onCompletableAssembly;
    }

    public static BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> getOnCompletableSubscribe() {
        return onCompletableSubscribe;
    }

    public static Function<? super Flowable, ? extends Flowable> getOnFlowableAssembly() {
        return onFlowableAssembly;
    }

    public static Function<? super ConnectableFlowable, ? extends ConnectableFlowable> getOnConnectableFlowableAssembly() {
        return onConnectableFlowableAssembly;
    }

    public static BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> getOnFlowableSubscribe() {
        return onFlowableSubscribe;
    }

    public static BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> getOnMaybeSubscribe() {
        return onMaybeSubscribe;
    }

    public static Function<? super Maybe, ? extends Maybe> getOnMaybeAssembly() {
        return onMaybeAssembly;
    }

    public static Function<? super Single, ? extends Single> getOnSingleAssembly() {
        return onSingleAssembly;
    }

    public static BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> getOnSingleSubscribe() {
        return onSingleSubscribe;
    }

    public static Function<? super Observable, ? extends Observable> getOnObservableAssembly() {
        return onObservableAssembly;
    }

    public static Function<? super ConnectableObservable, ? extends ConnectableObservable> getOnConnectableObservableAssembly() {
        return onConnectableObservableAssembly;
    }

    public static BiFunction<? super Observable, ? super Observer, ? extends Observer> getOnObservableSubscribe() {
        return onObservableSubscribe;
    }

    public static void setOnCompletableAssembly(Function<? super Completable, ? extends Completable> onCompletableAssembly2) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        onCompletableAssembly = onCompletableAssembly2;
    }

    public static void setOnCompletableSubscribe(BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> onCompletableSubscribe2) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        onCompletableSubscribe = onCompletableSubscribe2;
    }

    public static void setOnFlowableAssembly(Function<? super Flowable, ? extends Flowable> onFlowableAssembly2) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        onFlowableAssembly = onFlowableAssembly2;
    }

    public static void setOnMaybeAssembly(Function<? super Maybe, ? extends Maybe> onMaybeAssembly2) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        onMaybeAssembly = onMaybeAssembly2;
    }

    public static void setOnConnectableFlowableAssembly(Function<? super ConnectableFlowable, ? extends ConnectableFlowable> onConnectableFlowableAssembly2) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        onConnectableFlowableAssembly = onConnectableFlowableAssembly2;
    }

    public static void setOnFlowableSubscribe(BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> onFlowableSubscribe2) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        onFlowableSubscribe = onFlowableSubscribe2;
    }

    public static void setOnMaybeSubscribe(BiFunction<? super Maybe, MaybeObserver, ? extends MaybeObserver> onMaybeSubscribe2) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        onMaybeSubscribe = onMaybeSubscribe2;
    }

    public static void setOnObservableAssembly(Function<? super Observable, ? extends Observable> onObservableAssembly2) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        onObservableAssembly = onObservableAssembly2;
    }

    public static void setOnConnectableObservableAssembly(Function<? super ConnectableObservable, ? extends ConnectableObservable> onConnectableObservableAssembly2) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        onConnectableObservableAssembly = onConnectableObservableAssembly2;
    }

    public static void setOnObservableSubscribe(BiFunction<? super Observable, ? super Observer, ? extends Observer> onObservableSubscribe2) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        onObservableSubscribe = onObservableSubscribe2;
    }

    public static void setOnSingleAssembly(Function<? super Single, ? extends Single> onSingleAssembly2) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        onSingleAssembly = onSingleAssembly2;
    }

    public static void setOnSingleSubscribe(BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> onSingleSubscribe2) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        onSingleSubscribe = onSingleSubscribe2;
    }

    public static <T> Subscriber<? super T> onSubscribe(Flowable<T> source, Subscriber<? super T> subscriber) {
        BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> biFunction = onFlowableSubscribe;
        return biFunction != null ? (Subscriber) apply(biFunction, source, subscriber) : subscriber;
    }

    public static <T> Observer<? super T> onSubscribe(Observable<T> source, Observer<? super T> observer) {
        BiFunction<? super Observable, ? super Observer, ? extends Observer> biFunction = onObservableSubscribe;
        return biFunction != null ? (Observer) apply(biFunction, source, observer) : observer;
    }

    public static <T> SingleObserver<? super T> onSubscribe(Single<T> source, SingleObserver<? super T> observer) {
        BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> biFunction = onSingleSubscribe;
        return biFunction != null ? (SingleObserver) apply(biFunction, source, observer) : observer;
    }

    public static CompletableObserver onSubscribe(Completable source, CompletableObserver observer) {
        BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> biFunction = onCompletableSubscribe;
        return biFunction != null ? (CompletableObserver) apply(biFunction, source, observer) : observer;
    }

    public static <T> MaybeObserver<? super T> onSubscribe(Maybe<T> source, MaybeObserver<? super T> observer) {
        BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> biFunction = onMaybeSubscribe;
        return biFunction != null ? (MaybeObserver) apply(biFunction, source, observer) : observer;
    }

    public static <T> Maybe<T> onAssembly(Maybe<T> source) {
        Function<? super Maybe, ? extends Maybe> function = onMaybeAssembly;
        return function != null ? (Maybe) apply(function, source) : source;
    }

    public static <T> Flowable<T> onAssembly(Flowable<T> source) {
        Function<? super Flowable, ? extends Flowable> function = onFlowableAssembly;
        return function != null ? (Flowable) apply(function, source) : source;
    }

    public static <T> ConnectableFlowable<T> onAssembly(ConnectableFlowable<T> source) {
        Function<? super ConnectableFlowable, ? extends ConnectableFlowable> function = onConnectableFlowableAssembly;
        return function != null ? (ConnectableFlowable) apply(function, source) : source;
    }

    public static <T> Observable<T> onAssembly(Observable<T> source) {
        Function<? super Observable, ? extends Observable> function = onObservableAssembly;
        return function != null ? (Observable) apply(function, source) : source;
    }

    public static <T> ConnectableObservable<T> onAssembly(ConnectableObservable<T> source) {
        Function<? super ConnectableObservable, ? extends ConnectableObservable> function = onConnectableObservableAssembly;
        return function != null ? (ConnectableObservable) apply(function, source) : source;
    }

    public static <T> Single<T> onAssembly(Single<T> source) {
        Function<? super Single, ? extends Single> function = onSingleAssembly;
        return function != null ? (Single) apply(function, source) : source;
    }

    public static Completable onAssembly(Completable source) {
        Function<? super Completable, ? extends Completable> function = onCompletableAssembly;
        return function != null ? (Completable) apply(function, source) : source;
    }

    public static void setOnParallelAssembly(Function<? super ParallelFlowable, ? extends ParallelFlowable> handler) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        onParallelAssembly = handler;
    }

    public static Function<? super ParallelFlowable, ? extends ParallelFlowable> getOnParallelAssembly() {
        return onParallelAssembly;
    }

    public static <T> ParallelFlowable<T> onAssembly(ParallelFlowable<T> source) {
        Function<? super ParallelFlowable, ? extends ParallelFlowable> function = onParallelAssembly;
        return function != null ? (ParallelFlowable) apply(function, source) : source;
    }

    public static boolean onBeforeBlocking() {
        BooleanSupplier booleanSupplier = onBeforeBlocking;
        if (booleanSupplier != null) {
            try {
                return booleanSupplier.getAsBoolean();
            } catch (Throwable th) {
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
        return false;
    }

    public static void setOnBeforeBlocking(BooleanSupplier handler) {
        if (lockdown) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        onBeforeBlocking = handler;
    }

    public static BooleanSupplier getOnBeforeBlocking() {
        return onBeforeBlocking;
    }

    public static Scheduler createComputationScheduler(ThreadFactory threadFactory) {
        Objects.requireNonNull(threadFactory, "threadFactory is null");
        return new ComputationScheduler(threadFactory);
    }

    public static Scheduler createIoScheduler(ThreadFactory threadFactory) {
        Objects.requireNonNull(threadFactory, "threadFactory is null");
        return new IoScheduler(threadFactory);
    }

    public static Scheduler createNewThreadScheduler(ThreadFactory threadFactory) {
        Objects.requireNonNull(threadFactory, "threadFactory is null");
        return new NewThreadScheduler(threadFactory);
    }

    public static Scheduler createSingleScheduler(ThreadFactory threadFactory) {
        Objects.requireNonNull(threadFactory, "threadFactory is null");
        return new SingleScheduler(threadFactory);
    }

    static <T, R> R apply(Function<T, R> f, T t) {
        try {
            return f.apply(t);
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    static <T, U, R> R apply(BiFunction<T, U, R> f, T t, U u) {
        try {
            return f.apply(t, u);
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    static Scheduler callRequireNonNull(Supplier<Scheduler> s) {
        try {
            Scheduler scheduler = s.get();
            Objects.requireNonNull(scheduler, "Scheduler Supplier result can't be null");
            return scheduler;
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    static Scheduler applyRequireNonNull(Function<? super Supplier<Scheduler>, ? extends Scheduler> f, Supplier<Scheduler> s) {
        Object apply = apply(f, s);
        Objects.requireNonNull(apply, "Scheduler Supplier result can't be null");
        return (Scheduler) apply;
    }

    private RxJavaPlugins() {
        throw new IllegalStateException("No instances!");
    }
}
