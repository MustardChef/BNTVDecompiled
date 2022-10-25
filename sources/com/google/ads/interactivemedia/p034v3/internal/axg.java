package com.google.ads.interactivemedia.p034v3.internal;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.axg */
/* loaded from: classes2.dex */
public final class axg extends axf implements ListIterator {

    /* renamed from: a */
    private final int f5243a;

    /* renamed from: b */
    private int f5244b;

    /* renamed from: c */
    private final avg f5245c;

    protected axg() {
    }

    protected axg(int i, int i2) {
        this();
        atm.m4610l(i2, i);
        this.f5243a = i;
        this.f5244b = i2;
    }

    /* renamed from: a */
    protected final Object m4384a(int i) {
        return this.f5245c.get(i);
    }

    @Override // java.util.ListIterator
    @Deprecated
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f5244b < this.f5243a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f5244b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.f5244b;
        this.f5244b = i + 1;
        return m4384a(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f5244b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.f5244b - 1;
        this.f5244b = i;
        return m4384a(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f5244b - 1;
    }

    @Override // java.util.ListIterator
    @Deprecated
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public axg(avg avgVar, int i) {
        this(avgVar.size(), i);
        this.f5245c = avgVar;
    }
}
