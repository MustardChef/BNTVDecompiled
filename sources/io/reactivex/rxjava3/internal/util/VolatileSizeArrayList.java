package io.reactivex.rxjava3.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class VolatileSizeArrayList<T> extends AtomicInteger implements List<T>, RandomAccess {
    private static final long serialVersionUID = 3972397474470203923L;
    final ArrayList<T> list;

    public VolatileSizeArrayList() {
        this.list = new ArrayList<>();
    }

    public VolatileSizeArrayList(int initialCapacity) {
        this.list = new ArrayList<>(initialCapacity);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return get();
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return get() == 0;
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object o) {
        return this.list.contains(o);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return this.list.iterator();
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.list.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public <E> E[] toArray(E[] a) {
        return (E[]) this.list.toArray(a);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T e) {
        boolean add = this.list.add(e);
        lazySet(this.list.size());
        return add;
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object o) {
        boolean remove = this.list.remove(o);
        lazySet(this.list.size());
        return remove;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> c) {
        return this.list.containsAll(c);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> c) {
        boolean addAll = this.list.addAll(c);
        lazySet(this.list.size());
        return addAll;
    }

    @Override // java.util.List
    public boolean addAll(int index, Collection<? extends T> c) {
        boolean addAll = this.list.addAll(index, c);
        lazySet(this.list.size());
        return addAll;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> c) {
        boolean removeAll = this.list.removeAll(c);
        lazySet(this.list.size());
        return removeAll;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> c) {
        boolean retainAll = this.list.retainAll(c);
        lazySet(this.list.size());
        return retainAll;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.list.clear();
        lazySet(0);
    }

    @Override // java.util.List
    public T get(int index) {
        return this.list.get(index);
    }

    @Override // java.util.List
    public T set(int index, T element) {
        return this.list.set(index, element);
    }

    @Override // java.util.List
    public void add(int index, T element) {
        this.list.add(index, element);
        lazySet(this.list.size());
    }

    @Override // java.util.List
    public T remove(int index) {
        T remove = this.list.remove(index);
        lazySet(this.list.size());
        return remove;
    }

    @Override // java.util.List
    public int indexOf(Object o) {
        return this.list.indexOf(o);
    }

    @Override // java.util.List
    public int lastIndexOf(Object o) {
        return this.list.lastIndexOf(o);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return this.list.listIterator();
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int index) {
        return this.list.listIterator(index);
    }

    @Override // java.util.List
    public List<T> subList(int fromIndex, int toIndex) {
        return this.list.subList(fromIndex, toIndex);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        if (obj instanceof VolatileSizeArrayList) {
            return this.list.equals(((VolatileSizeArrayList) obj).list);
        }
        return this.list.equals(obj);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public String toString() {
        return this.list.toString();
    }
}
