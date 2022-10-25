package khttp.responses;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMarkers;

/* compiled from: GenericResponse.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000!\n\u0000\n\u0002\u0010(\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\f\u001a\u00020\rH\u0096\u0002J\t\u0010\u000e\u001a\u00020\u0002H\u0096\u0002R\u001a\u0010\u0003\u001a\u00020\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, m107d2 = {"khttp/responses/GenericResponse$contentIterator$1", "", "", "readBytes", "getReadBytes", "()[B", "setReadBytes", "([B)V", "stream", "Ljava/io/InputStream;", "getStream", "()Ljava/io/InputStream;", "hasNext", "", "next", "library_release"}, m106k = 1, m105mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class GenericResponse$contentIterator$1 implements Iterator<byte[]>, KMarkers {
    final /* synthetic */ int $chunkSize;
    private byte[] readBytes = new byte[0];
    private final InputStream stream;
    final /* synthetic */ GenericResponse this$0;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GenericResponse$contentIterator$1(GenericResponse genericResponse, int i) {
        this.this$0 = genericResponse;
        this.$chunkSize = i;
        this.stream = genericResponse.getRequest().getStream() ? genericResponse.getRaw() : new ByteArrayInputStream(genericResponse.getContent());
    }

    public final byte[] getReadBytes() {
        return this.readBytes;
    }

    public final void setReadBytes(byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "<set-?>");
        this.readBytes = bArr;
    }

    public final InputStream getStream() {
        return this.stream;
    }

    @Override // java.util.Iterator
    public byte[] next() {
        byte[] bArr = this.readBytes;
        int min = Math.min(this.$chunkSize, bArr.length + this.stream.available());
        if (bArr.length > min) {
            byte[] byteArray = CollectionsKt.toByteArray(ArraysKt.asList(bArr).subList(0, min));
            this.readBytes = CollectionsKt.toByteArray(ArraysKt.asList(bArr).subList(min, bArr.length));
            return byteArray;
        }
        if (!(bArr.length == 0)) {
            min -= bArr.length;
        }
        byte[] bArr2 = new byte[min];
        this.stream.read(bArr2);
        this.readBytes = new byte[0];
        return ArraysKt.plus(bArr, bArr2);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        try {
            boolean markSupported = this.this$0.getRaw().markSupported();
            if (markSupported) {
                this.this$0.getRaw().mark(1);
            }
            int read = this.this$0.getRaw().read();
            if (read == -1) {
                this.stream.close();
                return false;
            }
            if (markSupported) {
                this.this$0.getRaw().reset();
            } else {
                this.readBytes = ArraysKt.plus(this.readBytes, new byte[]{(byte) read});
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
