package io.reactivex.rxjava3.internal.functions;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;
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
import io.reactivex.rxjava3.functions.LongConsumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class Functions {
    static final Function<Object, Object> IDENTITY = new Identity();
    public static final Runnable EMPTY_RUNNABLE = new EmptyRunnable();
    public static final Action EMPTY_ACTION = new EmptyAction();
    static final Consumer<Object> EMPTY_CONSUMER = new EmptyConsumer();
    public static final Consumer<Throwable> ERROR_CONSUMER = new ErrorConsumer();
    public static final Consumer<Throwable> ON_ERROR_MISSING = new OnErrorMissingConsumer();
    public static final LongConsumer EMPTY_LONG_CONSUMER = new EmptyLongConsumer();
    static final Predicate<Object> ALWAYS_TRUE = new TruePredicate();
    static final Predicate<Object> ALWAYS_FALSE = new FalsePredicate();
    static final Supplier<Object> NULL_SUPPLIER = new NullProvider();
    public static final Consumer<Subscription> REQUEST_MAX = new MaxRequestSubscription();

    private Functions() {
        throw new IllegalStateException("No instances!");
    }

    public static <T1, T2, R> Function<Object[], R> toFunction(BiFunction<? super T1, ? super T2, ? extends R> f) {
        return new Array2Func(f);
    }

    public static <T1, T2, T3, R> Function<Object[], R> toFunction(Function3<T1, T2, T3, R> f) {
        return new Array3Func(f);
    }

    public static <T1, T2, T3, T4, R> Function<Object[], R> toFunction(Function4<T1, T2, T3, T4, R> f) {
        return new Array4Func(f);
    }

    public static <T1, T2, T3, T4, T5, R> Function<Object[], R> toFunction(Function5<T1, T2, T3, T4, T5, R> f) {
        return new Array5Func(f);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Function<Object[], R> toFunction(Function6<T1, T2, T3, T4, T5, T6, R> f) {
        return new Array6Func(f);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Function<Object[], R> toFunction(Function7<T1, T2, T3, T4, T5, T6, T7, R> f) {
        return new Array7Func(f);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Function<Object[], R> toFunction(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> f) {
        return new Array8Func(f);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Function<Object[], R> toFunction(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f) {
        return new Array9Func(f);
    }

    public static <T> Function<T, T> identity() {
        return (Function<T, T>) IDENTITY;
    }

    public static <T> Consumer<T> emptyConsumer() {
        return (Consumer<T>) EMPTY_CONSUMER;
    }

    public static <T> Predicate<T> alwaysTrue() {
        return (Predicate<T>) ALWAYS_TRUE;
    }

    public static <T> Predicate<T> alwaysFalse() {
        return (Predicate<T>) ALWAYS_FALSE;
    }

    public static <T> Supplier<T> nullSupplier() {
        return (Supplier<T>) NULL_SUPPLIER;
    }

    /* loaded from: classes4.dex */
    static final class FutureAction implements Action {
        final Future<?> future;

        FutureAction(Future<?> future) {
            this.future = future;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public void run() throws Exception {
            this.future.get();
        }
    }

    public static Action futureAction(Future<?> future) {
        return new FutureAction(future);
    }

    /* loaded from: classes4.dex */
    static final class JustValue<T, U> implements Callable<U>, Supplier<U>, Function<T, U> {
        final U value;

        JustValue(U value) {
            this.value = value;
        }

        @Override // java.util.concurrent.Callable
        public U call() {
            return this.value;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public U apply(T t) {
            return this.value;
        }

        @Override // io.reactivex.rxjava3.functions.Supplier
        public U get() {
            return this.value;
        }
    }

    public static <T> Callable<T> justCallable(T value) {
        return new JustValue(value);
    }

    public static <T> Supplier<T> justSupplier(T value) {
        return new JustValue(value);
    }

    public static <T, U> Function<T, U> justFunction(U value) {
        return new JustValue(value);
    }

    /* loaded from: classes4.dex */
    static final class CastToClass<T, U> implements Function<T, U> {
        final Class<U> clazz;

        CastToClass(Class<U> clazz) {
            this.clazz = clazz;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public U apply(T t) {
            return this.clazz.cast(t);
        }
    }

    public static <T, U> Function<T, U> castFunction(Class<U> target) {
        return new CastToClass(target);
    }

    /* loaded from: classes4.dex */
    static final class ArrayListCapacityCallable<T> implements Supplier<List<T>> {
        final int capacity;

        ArrayListCapacityCallable(int capacity) {
            this.capacity = capacity;
        }

        @Override // io.reactivex.rxjava3.functions.Supplier
        public List<T> get() {
            return new ArrayList(this.capacity);
        }
    }

    public static <T> Supplier<List<T>> createArrayList(int capacity) {
        return new ArrayListCapacityCallable(capacity);
    }

    /* loaded from: classes4.dex */
    static final class EqualsPredicate<T> implements Predicate<T> {
        final T value;

        EqualsPredicate(T value) {
            this.value = value;
        }

        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(T t) {
            return Objects.equals(t, this.value);
        }
    }

    public static <T> Predicate<T> equalsWith(T value) {
        return new EqualsPredicate(value);
    }

    /* loaded from: classes4.dex */
    enum HashSetSupplier implements Supplier<Set<Object>> {
        INSTANCE;

        @Override // io.reactivex.rxjava3.functions.Supplier
        public Set<Object> get() {
            return new HashSet();
        }
    }

    public static <T> Supplier<Set<T>> createHashSet() {
        return HashSetSupplier.INSTANCE;
    }

    /* loaded from: classes4.dex */
    static final class NotificationOnNext<T> implements Consumer<T> {
        final Consumer<? super Notification<T>> onNotification;

        NotificationOnNext(Consumer<? super Notification<T>> onNotification) {
            this.onNotification = onNotification;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(T v) throws Throwable {
            this.onNotification.accept(Notification.createOnNext(v));
        }
    }

    /* loaded from: classes4.dex */
    static final class NotificationOnError<T> implements Consumer<Throwable> {
        final Consumer<? super Notification<T>> onNotification;

        NotificationOnError(Consumer<? super Notification<T>> onNotification) {
            this.onNotification = onNotification;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable v) throws Throwable {
            this.onNotification.accept(Notification.createOnError(v));
        }
    }

    /* loaded from: classes4.dex */
    static final class NotificationOnComplete<T> implements Action {
        final Consumer<? super Notification<T>> onNotification;

        NotificationOnComplete(Consumer<? super Notification<T>> onNotification) {
            this.onNotification = onNotification;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public void run() throws Throwable {
            this.onNotification.accept(Notification.createOnComplete());
        }
    }

    public static <T> Consumer<T> notificationOnNext(Consumer<? super Notification<T>> onNotification) {
        return new NotificationOnNext(onNotification);
    }

    public static <T> Consumer<Throwable> notificationOnError(Consumer<? super Notification<T>> onNotification) {
        return new NotificationOnError(onNotification);
    }

    public static <T> Action notificationOnComplete(Consumer<? super Notification<T>> onNotification) {
        return new NotificationOnComplete(onNotification);
    }

    /* loaded from: classes4.dex */
    static final class ActionConsumer<T> implements Consumer<T> {
        final Action action;

        ActionConsumer(Action action) {
            this.action = action;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(T t) throws Throwable {
            this.action.run();
        }
    }

    public static <T> Consumer<T> actionConsumer(Action action) {
        return new ActionConsumer(action);
    }

    /* loaded from: classes4.dex */
    static final class ClassFilter<T, U> implements Predicate<T> {
        final Class<U> clazz;

        ClassFilter(Class<U> clazz) {
            this.clazz = clazz;
        }

        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(T t) {
            return this.clazz.isInstance(t);
        }
    }

    public static <T, U> Predicate<T> isInstanceOf(Class<U> clazz) {
        return new ClassFilter(clazz);
    }

    /* loaded from: classes4.dex */
    static final class BooleanSupplierPredicateReverse<T> implements Predicate<T> {
        final BooleanSupplier supplier;

        BooleanSupplierPredicateReverse(BooleanSupplier supplier) {
            this.supplier = supplier;
        }

        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(T t) throws Throwable {
            return !this.supplier.getAsBoolean();
        }
    }

    public static <T> Predicate<T> predicateReverseFor(BooleanSupplier supplier) {
        return new BooleanSupplierPredicateReverse(supplier);
    }

    /* loaded from: classes4.dex */
    static final class TimestampFunction<T> implements Function<T, Timed<T>> {
        final Scheduler scheduler;
        final TimeUnit unit;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object t) throws Throwable {
            return apply((TimestampFunction<T>) t);
        }

        TimestampFunction(TimeUnit unit, Scheduler scheduler) {
            this.unit = unit;
            this.scheduler = scheduler;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public Timed<T> apply(T t) {
            return new Timed<>(t, this.scheduler.now(this.unit), this.unit);
        }
    }

    public static <T> Function<T, Timed<T>> timestampWith(TimeUnit unit, Scheduler scheduler) {
        return new TimestampFunction(unit, scheduler);
    }

    /* loaded from: classes4.dex */
    static final class ToMapKeySelector<K, T> implements BiConsumer<Map<K, T>, T> {
        private final Function<? super T, ? extends K> keySelector;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.BiConsumer
        public /* bridge */ /* synthetic */ void accept(Object m, Object t) throws Throwable {
            accept((Map<K, Map<K, T>>) m, (Map<K, T>) t);
        }

        ToMapKeySelector(Function<? super T, ? extends K> keySelector) {
            this.keySelector = keySelector;
        }

        public void accept(Map<K, T> m, T t) throws Throwable {
            m.put(this.keySelector.apply(t), t);
        }
    }

    public static <T, K> BiConsumer<Map<K, T>, T> toMapKeySelector(final Function<? super T, ? extends K> keySelector) {
        return new ToMapKeySelector(keySelector);
    }

    /* loaded from: classes4.dex */
    static final class ToMapKeyValueSelector<K, V, T> implements BiConsumer<Map<K, V>, T> {
        private final Function<? super T, ? extends K> keySelector;
        private final Function<? super T, ? extends V> valueSelector;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.BiConsumer
        public /* bridge */ /* synthetic */ void accept(Object m, Object t) throws Throwable {
            accept((Map) ((Map) m), (Map<K, V>) t);
        }

        ToMapKeyValueSelector(Function<? super T, ? extends V> valueSelector, Function<? super T, ? extends K> keySelector) {
            this.valueSelector = valueSelector;
            this.keySelector = keySelector;
        }

        public void accept(Map<K, V> m, T t) throws Throwable {
            m.put(this.keySelector.apply(t), this.valueSelector.apply(t));
        }
    }

    public static <T, K, V> BiConsumer<Map<K, V>, T> toMapKeyValueSelector(final Function<? super T, ? extends K> keySelector, final Function<? super T, ? extends V> valueSelector) {
        return new ToMapKeyValueSelector(valueSelector, keySelector);
    }

    /* loaded from: classes4.dex */
    static final class ToMultimapKeyValueSelector<K, V, T> implements BiConsumer<Map<K, Collection<V>>, T> {
        private final Function<? super K, ? extends Collection<? super V>> collectionFactory;
        private final Function<? super T, ? extends K> keySelector;
        private final Function<? super T, ? extends V> valueSelector;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.BiConsumer
        public /* bridge */ /* synthetic */ void accept(Object m, Object t) throws Throwable {
            accept((Map) ((Map) m), (Map<K, Collection<V>>) t);
        }

        ToMultimapKeyValueSelector(Function<? super K, ? extends Collection<? super V>> collectionFactory, Function<? super T, ? extends V> valueSelector, Function<? super T, ? extends K> keySelector) {
            this.collectionFactory = collectionFactory;
            this.valueSelector = valueSelector;
            this.keySelector = keySelector;
        }

        public void accept(Map<K, Collection<V>> m, T t) throws Throwable {
            K apply = this.keySelector.apply(t);
            Collection<? super V> collection = m.get(apply);
            if (collection == null) {
                collection = this.collectionFactory.apply(apply);
                m.put(apply, collection);
            }
            collection.add(this.valueSelector.apply(t));
        }
    }

    public static <T, K, V> BiConsumer<Map<K, Collection<V>>, T> toMultimapKeyValueSelector(final Function<? super T, ? extends K> keySelector, final Function<? super T, ? extends V> valueSelector, final Function<? super K, ? extends Collection<? super V>> collectionFactory) {
        return new ToMultimapKeyValueSelector(collectionFactory, valueSelector, keySelector);
    }

    /* loaded from: classes4.dex */
    enum NaturalComparator implements Comparator<Object> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object o1, Object o2) {
            return ((Comparable) o1).compareTo(o2);
        }
    }

    public static <T> Comparator<T> naturalComparator() {
        return NaturalComparator.INSTANCE;
    }

    /* loaded from: classes4.dex */
    static final class ListSorter<T> implements Function<List<T>, List<T>> {
        final Comparator<? super T> comparator;

        @Override // io.reactivex.rxjava3.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object v) throws Throwable {
            return apply((List) ((List) v));
        }

        ListSorter(Comparator<? super T> comparator) {
            this.comparator = comparator;
        }

        public List<T> apply(List<T> v) {
            Collections.sort(v, this.comparator);
            return v;
        }
    }

    public static <T> Function<List<T>, List<T>> listSorter(final Comparator<? super T> comparator) {
        return new ListSorter(comparator);
    }

    /* loaded from: classes4.dex */
    static final class Array2Func<T1, T2, R> implements Function<Object[], R> {

        /* renamed from: f */
        final BiFunction<? super T1, ? super T2, ? extends R> f10503f;

        Array2Func(BiFunction<? super T1, ? super T2, ? extends R> f) {
            this.f10503f = f;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public R apply(Object[] a) throws Throwable {
            if (a.length != 2) {
                throw new IllegalArgumentException("Array of size 2 expected but got " + a.length);
            }
            return this.f10503f.apply(a[0], a[1]);
        }
    }

    /* loaded from: classes4.dex */
    static final class Array3Func<T1, T2, T3, R> implements Function<Object[], R> {

        /* renamed from: f */
        final Function3<T1, T2, T3, R> f10504f;

        Array3Func(Function3<T1, T2, T3, R> f) {
            this.f10504f = f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Function
        public R apply(Object[] a) throws Throwable {
            if (a.length != 3) {
                throw new IllegalArgumentException("Array of size 3 expected but got " + a.length);
            }
            return (R) this.f10504f.apply(a[0], a[1], a[2]);
        }
    }

    /* loaded from: classes4.dex */
    static final class Array4Func<T1, T2, T3, T4, R> implements Function<Object[], R> {

        /* renamed from: f */
        final Function4<T1, T2, T3, T4, R> f10505f;

        Array4Func(Function4<T1, T2, T3, T4, R> f) {
            this.f10505f = f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Function
        public R apply(Object[] a) throws Throwable {
            if (a.length != 4) {
                throw new IllegalArgumentException("Array of size 4 expected but got " + a.length);
            }
            return (R) this.f10505f.apply(a[0], a[1], a[2], a[3]);
        }
    }

    /* loaded from: classes4.dex */
    static final class Array5Func<T1, T2, T3, T4, T5, R> implements Function<Object[], R> {

        /* renamed from: f */
        private final Function5<T1, T2, T3, T4, T5, R> f10506f;

        Array5Func(Function5<T1, T2, T3, T4, T5, R> f) {
            this.f10506f = f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Function
        public R apply(Object[] a) throws Throwable {
            if (a.length != 5) {
                throw new IllegalArgumentException("Array of size 5 expected but got " + a.length);
            }
            return (R) this.f10506f.apply(a[0], a[1], a[2], a[3], a[4]);
        }
    }

    /* loaded from: classes4.dex */
    static final class Array6Func<T1, T2, T3, T4, T5, T6, R> implements Function<Object[], R> {

        /* renamed from: f */
        final Function6<T1, T2, T3, T4, T5, T6, R> f10507f;

        Array6Func(Function6<T1, T2, T3, T4, T5, T6, R> f) {
            this.f10507f = f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Function
        public R apply(Object[] a) throws Throwable {
            if (a.length != 6) {
                throw new IllegalArgumentException("Array of size 6 expected but got " + a.length);
            }
            return (R) this.f10507f.apply(a[0], a[1], a[2], a[3], a[4], a[5]);
        }
    }

    /* loaded from: classes4.dex */
    static final class Array7Func<T1, T2, T3, T4, T5, T6, T7, R> implements Function<Object[], R> {

        /* renamed from: f */
        final Function7<T1, T2, T3, T4, T5, T6, T7, R> f10508f;

        Array7Func(Function7<T1, T2, T3, T4, T5, T6, T7, R> f) {
            this.f10508f = f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Function
        public R apply(Object[] a) throws Throwable {
            if (a.length != 7) {
                throw new IllegalArgumentException("Array of size 7 expected but got " + a.length);
            }
            return (R) this.f10508f.apply(a[0], a[1], a[2], a[3], a[4], a[5], a[6]);
        }
    }

    /* loaded from: classes4.dex */
    static final class Array8Func<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Function<Object[], R> {

        /* renamed from: f */
        final Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> f10509f;

        Array8Func(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> f) {
            this.f10509f = f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Function
        public R apply(Object[] a) throws Throwable {
            if (a.length != 8) {
                throw new IllegalArgumentException("Array of size 8 expected but got " + a.length);
            }
            return (R) this.f10509f.apply(a[0], a[1], a[2], a[3], a[4], a[5], a[6], a[7]);
        }
    }

    /* loaded from: classes4.dex */
    static final class Array9Func<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Function<Object[], R> {

        /* renamed from: f */
        final Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f10510f;

        Array9Func(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f) {
            this.f10510f = f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Function
        public R apply(Object[] a) throws Throwable {
            if (a.length != 9) {
                throw new IllegalArgumentException("Array of size 9 expected but got " + a.length);
            }
            return (R) this.f10510f.apply(a[0], a[1], a[2], a[3], a[4], a[5], a[6], a[7], a[8]);
        }
    }

    /* loaded from: classes4.dex */
    static final class Identity implements Function<Object, Object> {
        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object v) {
            return v;
        }

        public String toString() {
            return "IdentityFunction";
        }

        Identity() {
        }
    }

    /* loaded from: classes4.dex */
    static final class EmptyRunnable implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }

        EmptyRunnable() {
        }
    }

    /* loaded from: classes4.dex */
    static final class EmptyAction implements Action {
        @Override // io.reactivex.rxjava3.functions.Action
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }

        EmptyAction() {
        }
    }

    /* loaded from: classes4.dex */
    static final class EmptyConsumer implements Consumer<Object> {
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Object v) {
        }

        public String toString() {
            return "EmptyConsumer";
        }

        EmptyConsumer() {
        }
    }

    /* loaded from: classes4.dex */
    static final class ErrorConsumer implements Consumer<Throwable> {
        ErrorConsumer() {
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable error) {
            RxJavaPlugins.onError(error);
        }
    }

    /* loaded from: classes4.dex */
    static final class OnErrorMissingConsumer implements Consumer<Throwable> {
        OnErrorMissingConsumer() {
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable error) {
            RxJavaPlugins.onError(new OnErrorNotImplementedException(error));
        }
    }

    /* loaded from: classes4.dex */
    static final class EmptyLongConsumer implements LongConsumer {
        @Override // io.reactivex.rxjava3.functions.LongConsumer
        public void accept(long v) {
        }

        EmptyLongConsumer() {
        }
    }

    /* loaded from: classes4.dex */
    static final class TruePredicate implements Predicate<Object> {
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(Object o) {
            return true;
        }

        TruePredicate() {
        }
    }

    /* loaded from: classes4.dex */
    static final class FalsePredicate implements Predicate<Object> {
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(Object o) {
            return false;
        }

        FalsePredicate() {
        }
    }

    /* loaded from: classes4.dex */
    static final class NullProvider implements Supplier<Object> {
        @Override // io.reactivex.rxjava3.functions.Supplier
        public Object get() {
            return null;
        }

        NullProvider() {
        }
    }

    /* loaded from: classes4.dex */
    static final class MaxRequestSubscription implements Consumer<Subscription> {
        MaxRequestSubscription() {
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Subscription t) {
            t.request(Long.MAX_VALUE);
        }
    }

    public static <T> Consumer<T> boundedConsumer(int bufferSize) {
        return new BoundedConsumer(bufferSize);
    }

    /* loaded from: classes4.dex */
    public static class BoundedConsumer implements Consumer<Subscription> {
        final int bufferSize;

        BoundedConsumer(int bufferSize) {
            this.bufferSize = bufferSize;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Subscription s) {
            s.request(this.bufferSize);
        }
    }
}
