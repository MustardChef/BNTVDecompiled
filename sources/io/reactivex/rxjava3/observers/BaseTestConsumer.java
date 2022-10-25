package io.reactivex.rxjava3.observers;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.VolatileSizeArrayList;
import io.reactivex.rxjava3.observers.BaseTestConsumer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> {
    protected boolean checkSubscriptionOnce;
    protected long completions;
    protected Thread lastThread;
    protected CharSequence tag;
    protected boolean timeout;
    protected final List<T> values = new VolatileSizeArrayList();
    protected final List<Throwable> errors = new VolatileSizeArrayList();
    protected final CountDownLatch done = new CountDownLatch(1);

    protected abstract U assertSubscribed();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void dispose();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isDisposed();

    public final List<T> values() {
        return this.values;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AssertionError fail(String message) {
        StringBuilder sb = new StringBuilder(message.length() + 64);
        sb.append(message);
        sb.append(" (");
        sb.append("latch = ");
        sb.append(this.done.getCount());
        sb.append(", ");
        sb.append("values = ");
        sb.append(this.values.size());
        sb.append(", ");
        sb.append("errors = ");
        sb.append(this.errors.size());
        sb.append(", ");
        sb.append("completions = ");
        sb.append(this.completions);
        if (this.timeout) {
            sb.append(", timeout!");
        }
        if (isDisposed()) {
            sb.append(", disposed!");
        }
        CharSequence charSequence = this.tag;
        if (charSequence != null) {
            sb.append(", tag = ");
            sb.append(charSequence);
        }
        sb.append(')');
        AssertionError assertionError = new AssertionError(sb.toString());
        if (!this.errors.isEmpty()) {
            if (this.errors.size() == 1) {
                assertionError.initCause(this.errors.get(0));
            } else {
                assertionError.initCause(new CompositeException(this.errors));
            }
        }
        return assertionError;
    }

    public final U await() throws InterruptedException {
        if (this.done.getCount() == 0) {
            return this;
        }
        this.done.await();
        return this;
    }

    public final boolean await(long time, TimeUnit unit) throws InterruptedException {
        boolean z = this.done.getCount() == 0 || this.done.await(time, unit);
        this.timeout = !z;
        return z;
    }

    public final U assertComplete() {
        long j = this.completions;
        if (j != 0) {
            if (j <= 1) {
                return this;
            }
            throw fail("Multiple completions: " + j);
        }
        throw fail("Not completed");
    }

    public final U assertNotComplete() {
        long j = this.completions;
        int i = (j > 1L ? 1 : (j == 1L ? 0 : -1));
        if (i != 0) {
            if (i <= 0) {
                return this;
            }
            throw fail("Multiple completions: " + j);
        }
        throw fail("Completed!");
    }

    public final U assertNoErrors() {
        if (this.errors.size() == 0) {
            return this;
        }
        throw fail("Error(s) present: " + this.errors);
    }

    public final U assertError(Throwable error) {
        return assertError(Functions.equalsWith(error));
    }

    public final U assertError(Class<? extends Throwable> errorClass) {
        return assertError(Functions.isInstanceOf(errorClass));
    }

    public final U assertError(Predicate<Throwable> errorPredicate) {
        int size = this.errors.size();
        if (size == 0) {
            throw fail("No errors");
        }
        boolean z = false;
        Iterator<Throwable> it = this.errors.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            try {
                if (errorPredicate.test(it.next())) {
                    z = true;
                    break;
                }
            } catch (Throwable th) {
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
        if (z) {
            if (size == 1) {
                return this;
            }
            throw fail("Error present but other errors as well");
        }
        throw fail("Error not present");
    }

    public final U assertValue(T value) {
        if (this.values.size() != 1) {
            throw fail("expected: " + valueAndClass(value) + " but was: " + this.values);
        }
        T t = this.values.get(0);
        if (Objects.equals(value, t)) {
            return this;
        }
        throw fail("expected: " + valueAndClass(value) + " but was: " + valueAndClass(t));
    }

    public final U assertValue(Predicate<T> valuePredicate) {
        assertValueAt(0, (Predicate) valuePredicate);
        if (this.values.size() <= 1) {
            return this;
        }
        throw fail("Value present but other values as well");
    }

    public final U assertValueAt(int index, T value) {
        int size = this.values.size();
        if (size != 0) {
            if (index >= size) {
                throw fail("Invalid index: " + index);
            }
            T t = this.values.get(index);
            if (Objects.equals(value, t)) {
                return this;
            }
            throw fail("expected: " + valueAndClass(value) + " but was: " + valueAndClass(t));
        }
        throw fail("No values");
    }

    public final U assertValueAt(int index, Predicate<T> valuePredicate) {
        if (this.values.size() == 0) {
            throw fail("No values");
        }
        if (index >= this.values.size()) {
            throw fail("Invalid index: " + index);
        }
        try {
            if (valuePredicate.test(this.values.get(index))) {
                return this;
            }
            throw fail("Value not present");
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    public static String valueAndClass(Object o) {
        if (o != null) {
            return o + " (class: " + o.getClass().getSimpleName() + ")";
        }
        return "null";
    }

    public final U assertValueCount(int count) {
        int size = this.values.size();
        if (size == count) {
            return this;
        }
        throw fail("Value counts differ; expected: " + count + " but was: " + size);
    }

    public final U assertNoValues() {
        return assertValueCount(0);
    }

    @SafeVarargs
    public final U assertValues(T... values) {
        int size = this.values.size();
        if (size != values.length) {
            throw fail("Value count differs; expected: " + values.length + " " + Arrays.toString(values) + " but was: " + size + " " + this.values);
        }
        for (int i = 0; i < size; i++) {
            T t = this.values.get(i);
            T t2 = values[i];
            if (!Objects.equals(t2, t)) {
                throw fail("Values at position " + i + " differ; expected: " + valueAndClass(t2) + " but was: " + valueAndClass(t));
            }
        }
        return this;
    }

    @SafeVarargs
    public final U assertValuesOnly(T... values) {
        return (U) assertSubscribed().assertValues(values).assertNoErrors().assertNotComplete();
    }

    public final U assertValueSequence(Iterable<? extends T> sequence) {
        boolean hasNext;
        boolean hasNext2;
        Iterator<T> it = this.values.iterator();
        Iterator<? extends T> it2 = sequence.iterator();
        int i = 0;
        while (true) {
            hasNext = it2.hasNext();
            hasNext2 = it.hasNext();
            if (!hasNext2 || !hasNext) {
                break;
            }
            T next = it2.next();
            T next2 = it.next();
            if (!Objects.equals(next, next2)) {
                throw fail("Values at position " + i + " differ; expected: " + valueAndClass(next) + " but was: " + valueAndClass(next2));
            }
            i++;
        }
        if (hasNext2) {
            throw fail("More values received than expected (" + i + ")");
        } else if (hasNext) {
            throw fail("Fewer values received than expected (" + i + ")");
        } else {
            return this;
        }
    }

    @SafeVarargs
    public final U assertResult(T... values) {
        return (U) assertSubscribed().assertValues(values).assertNoErrors().assertComplete();
    }

    @SafeVarargs
    public final U assertFailure(Class<? extends Throwable> error, T... values) {
        return (U) assertSubscribed().assertValues(values).assertError(error).assertNotComplete();
    }

    public final U awaitDone(long time, TimeUnit unit) {
        try {
            if (!this.done.await(time, unit)) {
                this.timeout = true;
                dispose();
            }
            return this;
        } catch (InterruptedException e) {
            dispose();
            throw ExceptionHelper.wrapOrThrow(e);
        }
    }

    public final U assertEmpty() {
        return (U) assertSubscribed().assertNoValues().assertNoErrors().assertNotComplete();
    }

    public final U withTag(CharSequence tag) {
        this.tag = tag;
        return this;
    }

    public final U awaitCount(int atLeast) {
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            if (System.currentTimeMillis() - currentTimeMillis >= 5000) {
                this.timeout = true;
                break;
            } else if (this.done.getCount() == 0 || this.values.size() >= atLeast) {
                break;
            } else {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return this;
    }
}
