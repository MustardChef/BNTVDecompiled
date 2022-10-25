package org.acra.collections;

import androidx.exifinterface.media.ExifInterface;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

/* compiled from: WeakStack.kt */
@Metadata(m108d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010)\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J\u0017\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0015H\u0096\u0002J\u000b\u0010\u0016\u001a\u00028\u0000¢\u0006\u0002\u0010\u0017J\u000b\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eR\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, m107d2 = {"Lorg/acra/collections/WeakStack;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/AbstractCollection;", "()V", "contents", "", "Ljava/lang/ref/WeakReference;", "size", "", "getSize", "()I", "add", "", "t", "(Ljava/lang/Object;)Z", "cleanup", "", "clear", "contains", "element", "iterator", "", "peek", "()Ljava/lang/Object;", "pop", "remove", "WeakIterator", "acra-javacore"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class WeakStack<T> extends AbstractCollection<T> {
    private final List<WeakReference<T>> contents = new ArrayList();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    private final void cleanup() {
        for (WeakReference<T> weakReference : this.contents) {
            if (weakReference.get() == null) {
                this.contents.remove(weakReference);
            }
        }
    }

    public int getSize() {
        cleanup();
        return this.contents.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        for (WeakReference<T> weakReference : this.contents) {
            if (Intrinsics.areEqual(obj, weakReference.get())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new WeakIterator(this.contents.iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(T t) {
        return this.contents.add(new WeakReference<>(t));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        int size;
        if (obj != null && this.contents.size() - 1 >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (Intrinsics.areEqual(obj, this.contents.get(i).get())) {
                    this.contents.remove(i);
                    return true;
                } else if (i2 > size) {
                    break;
                } else {
                    i = i2;
                }
            }
        }
        return false;
    }

    public final T peek() {
        int size = this.contents.size() - 1;
        if (size >= 0) {
            while (true) {
                int i = size - 1;
                T t = this.contents.get(size).get();
                if (t == null) {
                    if (i < 0) {
                        break;
                    }
                    size = i;
                } else {
                    return t;
                }
            }
        }
        throw new EmptyStackException();
    }

    public final T pop() {
        T peek = peek();
        remove(peek);
        return peek;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.contents.clear();
    }

    /* compiled from: WeakStack.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0002¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\u000e\u0010\u0006\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00018\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\r"}, m107d2 = {"Lorg/acra/collections/WeakStack$WeakIterator;", ExifInterface.GPS_DIRECTION_TRUE, "", "iterator", "Ljava/lang/ref/WeakReference;", "(Ljava/util/Iterator;)V", "next", "Ljava/lang/Object;", "hasNext", "", "()Ljava/lang/Object;", "remove", "", "acra-javacore"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    private static final class WeakIterator<T> implements Iterator<T>, KMutableIterator {
        private final Iterator<WeakReference<T>> iterator;
        private T next;

        /* JADX WARN: Multi-variable type inference failed */
        public WeakIterator(Iterator<? extends WeakReference<T>> iterator) {
            Intrinsics.checkNotNullParameter(iterator, "iterator");
            this.iterator = iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.next != null) {
                return true;
            }
            while (this.iterator.hasNext()) {
                T t = this.iterator.next().get();
                if (t != null) {
                    this.next = t;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            T t = this.next;
            this.next = null;
            while (t == null) {
                t = this.iterator.next().get();
            }
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
        }
    }
}
