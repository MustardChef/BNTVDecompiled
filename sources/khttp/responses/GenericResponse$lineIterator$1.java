package khttp.responses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import khttp.extensions.ExtensionsKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMarkers;

/* compiled from: GenericResponse.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u0096\u0002J\t\u0010\u0012\u001a\u00020\u0002H\u0096\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\fj\b\u0012\u0004\u0012\u00020\u0002`\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, m107d2 = {"khttp/responses/GenericResponse$lineIterator$1", "", "", "byteArrays", "getByteArrays", "()Ljava/util/Iterator;", "leftOver", "getLeftOver", "()[B", "setLeftOver", "([B)V", "overflow", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getOverflow", "()Ljava/util/ArrayList;", "hasNext", "", "next", "library_release"}, m106k = 1, m105mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class GenericResponse$lineIterator$1 implements Iterator<byte[]>, KMarkers {
    final /* synthetic */ int $chunkSize;
    final /* synthetic */ byte[] $delimiter;
    private final Iterator<byte[]> byteArrays;
    private byte[] leftOver;
    private final ArrayList<byte[]> overflow = new ArrayList<>();
    final /* synthetic */ GenericResponse this$0;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GenericResponse$lineIterator$1(GenericResponse genericResponse, byte[] bArr, int i) {
        this.this$0 = genericResponse;
        this.$delimiter = bArr;
        this.$chunkSize = i;
        this.byteArrays = genericResponse.contentIterator(i);
    }

    public final Iterator<byte[]> getByteArrays() {
        return this.byteArrays;
    }

    public final byte[] getLeftOver() {
        return this.leftOver;
    }

    public final void setLeftOver(byte[] bArr) {
        this.leftOver = bArr;
    }

    public final ArrayList<byte[]> getOverflow() {
        return this.overflow;
    }

    @Override // java.util.Iterator
    public byte[] next() {
        List<byte[]> splitLines;
        if (!this.overflow.isEmpty()) {
            byte[] remove = this.overflow.remove(0);
            Intrinsics.checkExpressionValueIsNotNull(remove, "overflow.removeAt(0)");
            return remove;
        }
        while (this.byteArrays.hasNext()) {
            do {
                byte[] bArr = this.leftOver;
                byte[] next = this.byteArrays.next();
                if (!(next.length == 0)) {
                    if (bArr != null) {
                        next = ArraysKt.plus(bArr, next);
                    }
                    this.leftOver = next;
                    byte[] bArr2 = this.$delimiter;
                    splitLines = bArr2 == null ? ExtensionsKt.splitLines(next) : ExtensionsKt.split(next, bArr2);
                    if (splitLines.size() >= 2) {
                        this.leftOver = (byte[]) CollectionsKt.last((List<? extends Object>) splitLines);
                        this.overflow.addAll(splitLines.subList(1, splitLines.size() - 1));
                        return splitLines.get(0);
                    }
                }
            } while (splitLines.size() < 2);
        }
        byte[] bArr3 = this.leftOver;
        if (bArr3 == null) {
            Intrinsics.throwNpe();
        }
        return bArr3;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return (this.overflow.isEmpty() ^ true) || this.byteArrays.hasNext();
    }
}
