package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.avz */
/* loaded from: classes2.dex */
final class avz implements Iterator {

    /* renamed from: a */
    public static final avz f5199a;

    /* renamed from: b */
    private static final /* synthetic */ avz[] f5200b;

    static {
        avz avzVar = new avz();
        f5199a = avzVar;
        f5200b = new avz[]{avzVar};
    }

    private avz() {
    }

    public static avz[] values() {
        return (avz[]) f5200b.clone();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        axd.m4414H(false);
    }
}
