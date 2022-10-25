package androidx.browser.trusted;

import java.util.Comparator;

/* compiled from: lambda */
/* renamed from: androidx.browser.trusted.-$$Lambda$TokenContents$Q7kOl2yBde7CmQs5Ktpiz56Nr70  reason: invalid class name */
/* loaded from: classes.dex */
public final /* synthetic */ class $$Lambda$TokenContents$Q7kOl2yBde7CmQs5Ktpiz56Nr70 implements Comparator {
    public static final /* synthetic */ $$Lambda$TokenContents$Q7kOl2yBde7CmQs5Ktpiz56Nr70 INSTANCE = new $$Lambda$TokenContents$Q7kOl2yBde7CmQs5Ktpiz56Nr70();

    private /* synthetic */ $$Lambda$TokenContents$Q7kOl2yBde7CmQs5Ktpiz56Nr70() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int compareByteArrays;
        compareByteArrays = TokenContents.compareByteArrays((byte[]) obj, (byte[]) obj2);
        return compareByteArrays;
    }
}
