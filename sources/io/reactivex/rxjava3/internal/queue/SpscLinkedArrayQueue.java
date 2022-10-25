package io.reactivex.rxjava3.internal.queue;

import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.util.Pow2;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes4.dex */
public final class SpscLinkedArrayQueue<T> implements SimplePlainQueue<T> {
    AtomicReferenceArray<Object> consumerBuffer;
    final int consumerMask;
    AtomicReferenceArray<Object> producerBuffer;
    long producerLookAhead;
    int producerLookAheadStep;
    final int producerMask;
    static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object HAS_NEXT = new Object();
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    private static int calcDirectOffset(int index) {
        return index;
    }

    public SpscLinkedArrayQueue(final int bufferSize) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(Math.max(8, bufferSize));
        int i = roundToPowerOfTwo - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(roundToPowerOfTwo + 1);
        this.producerBuffer = atomicReferenceArray;
        this.producerMask = i;
        adjustLookAheadStep(roundToPowerOfTwo);
        this.consumerBuffer = atomicReferenceArray;
        this.consumerMask = i;
        this.producerLookAhead = i - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
    public boolean offer(final T e) {
        Objects.requireNonNull(e, "Null is not a valid element");
        AtomicReferenceArray<Object> atomicReferenceArray = this.producerBuffer;
        long lpProducerIndex = lpProducerIndex();
        int i = this.producerMask;
        int calcWrappedOffset = calcWrappedOffset(lpProducerIndex, i);
        if (lpProducerIndex < this.producerLookAhead) {
            return writeToQueue(atomicReferenceArray, e, lpProducerIndex, calcWrappedOffset);
        }
        long j = this.producerLookAheadStep + lpProducerIndex;
        if (lvElement(atomicReferenceArray, calcWrappedOffset(j, i)) == null) {
            this.producerLookAhead = j - 1;
            return writeToQueue(atomicReferenceArray, e, lpProducerIndex, calcWrappedOffset);
        } else if (lvElement(atomicReferenceArray, calcWrappedOffset(1 + lpProducerIndex, i)) == null) {
            return writeToQueue(atomicReferenceArray, e, lpProducerIndex, calcWrappedOffset);
        } else {
            resize(atomicReferenceArray, lpProducerIndex, calcWrappedOffset, e, i);
            return true;
        }
    }

    private boolean writeToQueue(final AtomicReferenceArray<Object> buffer, final T e, final long index, final int offset) {
        soElement(buffer, offset, e);
        soProducerIndex(index + 1);
        return true;
    }

    private void resize(final AtomicReferenceArray<Object> oldBuffer, final long currIndex, final int offset, final T e, final long mask) {
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(oldBuffer.length());
        this.producerBuffer = atomicReferenceArray;
        this.producerLookAhead = (mask + currIndex) - 1;
        soElement(atomicReferenceArray, offset, e);
        soNext(oldBuffer, atomicReferenceArray);
        soElement(oldBuffer, offset, HAS_NEXT);
        soProducerIndex(currIndex + 1);
    }

    private void soNext(AtomicReferenceArray<Object> curr, AtomicReferenceArray<Object> next) {
        soElement(curr, calcDirectOffset(curr.length() - 1), next);
    }

    private AtomicReferenceArray<Object> lvNextBufferAndUnlink(AtomicReferenceArray<Object> curr, int nextIndex) {
        int calcDirectOffset = calcDirectOffset(nextIndex);
        AtomicReferenceArray<Object> atomicReferenceArray = (AtomicReferenceArray) lvElement(curr, calcDirectOffset);
        soElement(curr, calcDirectOffset, null);
        return atomicReferenceArray;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue, io.reactivex.rxjava3.internal.fuseable.SimpleQueue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerBuffer;
        long lpConsumerIndex = lpConsumerIndex();
        int i = this.consumerMask;
        int calcWrappedOffset = calcWrappedOffset(lpConsumerIndex, i);
        T t = (T) lvElement(atomicReferenceArray, calcWrappedOffset);
        boolean z = t == HAS_NEXT;
        if (t == null || z) {
            if (z) {
                return newBufferPoll(lvNextBufferAndUnlink(atomicReferenceArray, i + 1), lpConsumerIndex, i);
            }
            return null;
        }
        soElement(atomicReferenceArray, calcWrappedOffset, null);
        soConsumerIndex(lpConsumerIndex + 1);
        return t;
    }

    private T newBufferPoll(AtomicReferenceArray<Object> nextBuffer, final long index, final int mask) {
        this.consumerBuffer = nextBuffer;
        int calcWrappedOffset = calcWrappedOffset(index, mask);
        T t = (T) lvElement(nextBuffer, calcWrappedOffset);
        if (t != null) {
            soElement(nextBuffer, calcWrappedOffset, null);
            soConsumerIndex(index + 1);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerBuffer;
        long lpConsumerIndex = lpConsumerIndex();
        int i = this.consumerMask;
        T t = (T) lvElement(atomicReferenceArray, calcWrappedOffset(lpConsumerIndex, i));
        return t == HAS_NEXT ? newBufferPeek(lvNextBufferAndUnlink(atomicReferenceArray, i + 1), lpConsumerIndex, i) : t;
    }

    private T newBufferPeek(AtomicReferenceArray<Object> nextBuffer, final long index, final int mask) {
        this.consumerBuffer = nextBuffer;
        return (T) lvElement(nextBuffer, calcWrappedOffset(index, mask));
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public int size() {
        long lvConsumerIndex = lvConsumerIndex();
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long lvConsumerIndex2 = lvConsumerIndex();
            if (lvConsumerIndex == lvConsumerIndex2) {
                return (int) (lvProducerIndex - lvConsumerIndex2);
            }
            lvConsumerIndex = lvConsumerIndex2;
        }
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return lvProducerIndex() == lvConsumerIndex();
    }

    private void adjustLookAheadStep(int capacity) {
        this.producerLookAheadStep = Math.min(capacity / 4, MAX_LOOK_AHEAD_STEP);
    }

    private long lvProducerIndex() {
        return this.producerIndex.get();
    }

    private long lvConsumerIndex() {
        return this.consumerIndex.get();
    }

    private long lpProducerIndex() {
        return this.producerIndex.get();
    }

    private long lpConsumerIndex() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long v) {
        this.producerIndex.lazySet(v);
    }

    private void soConsumerIndex(long v) {
        this.consumerIndex.lazySet(v);
    }

    private static int calcWrappedOffset(long index, int mask) {
        return calcDirectOffset(((int) index) & mask);
    }

    private static void soElement(AtomicReferenceArray<Object> buffer, int offset, Object e) {
        buffer.lazySet(offset, e);
    }

    private static Object lvElement(AtomicReferenceArray<Object> buffer, int offset) {
        return buffer.get(offset);
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
    public boolean offer(T first, T second) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.producerBuffer;
        long lvProducerIndex = lvProducerIndex();
        int i = this.producerMask;
        long j = 2 + lvProducerIndex;
        if (lvElement(atomicReferenceArray, calcWrappedOffset(j, i)) == null) {
            int calcWrappedOffset = calcWrappedOffset(lvProducerIndex, i);
            soElement(atomicReferenceArray, calcWrappedOffset + 1, second);
            soElement(atomicReferenceArray, calcWrappedOffset, first);
            soProducerIndex(j);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.producerBuffer = atomicReferenceArray2;
        int calcWrappedOffset2 = calcWrappedOffset(lvProducerIndex, i);
        soElement(atomicReferenceArray2, calcWrappedOffset2 + 1, second);
        soElement(atomicReferenceArray2, calcWrappedOffset2, first);
        soNext(atomicReferenceArray, atomicReferenceArray2);
        soElement(atomicReferenceArray, calcWrappedOffset2, HAS_NEXT);
        soProducerIndex(j);
        return true;
    }
}
