package okio;

import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileHandle.kt */
@Metadata(m108d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002()B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u000eH$J\b\u0010\u0016\u001a\u00020\u000eH$J(\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH$J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0011H$J\b\u0010\u001f\u001a\u00020\u0011H$J(\u0010 \u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH$J&\u0010!\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bJ\u001e\u0010!\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u0011J \u0010#\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u0011H\u0002J\u0016\u0010$\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010$\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010%\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\u0011J\u0006\u0010\u001e\u001a\u00020\u0011J\u0010\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u0011J&\u0010&\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bJ\u001e\u0010&\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u0011J \u0010'\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u0011H\u0002R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006*"}, m107d2 = {"Lokio/FileHandle;", "Ljava/io/Closeable;", "Lokio/Closeable;", "readWrite", "", "(Z)V", "closed", "openStreamCount", "", "getReadWrite", "()Z", "appendingSink", "Lokio/Sink;", "close", "", "flush", "position", "", "sink", "source", "Lokio/Source;", "protectedClose", "protectedFlush", "protectedRead", "fileOffset", "array", "", "arrayOffset", "byteCount", "protectedResize", "size", "protectedSize", "protectedWrite", "read", "Lokio/Buffer;", "readNoCloseCheck", "reposition", "resize", "write", "writeNoCloseCheck", "FileHandleSink", "FileHandleSource", "okio"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public abstract class FileHandle implements Closeable {
    private boolean closed;
    private int openStreamCount;
    private final boolean readWrite;

    protected abstract void protectedClose() throws IOException;

    protected abstract void protectedFlush() throws IOException;

    protected abstract int protectedRead(long j, byte[] bArr, int i, int i2) throws IOException;

    protected abstract void protectedResize(long j) throws IOException;

    protected abstract long protectedSize() throws IOException;

    protected abstract void protectedWrite(long j, byte[] bArr, int i, int i2) throws IOException;

    public FileHandle(boolean z) {
        this.readWrite = z;
    }

    public final boolean getReadWrite() {
        return this.readWrite;
    }

    public final void resize(long j) throws IOException {
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        protectedResize(j);
    }

    public final void write(long j, byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        protectedWrite(j, array, i, i2);
    }

    public final void write(long j, Buffer source, long j2) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        writeNoCloseCheck(j, source, j2);
    }

    public final void flush() throws IOException {
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        protectedFlush();
    }

    public static /* synthetic */ Source source$default(FileHandle fileHandle, long j, int i, Object obj) throws IOException {
        if (obj == null) {
            if ((i & 1) != 0) {
                j = 0;
            }
            return fileHandle.source(j);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: source");
    }

    public final long position(Source source) throws IOException {
        long j;
        Intrinsics.checkNotNullParameter(source, "source");
        if (source instanceof RealBufferedSource) {
            RealBufferedSource realBufferedSource = (RealBufferedSource) source;
            j = realBufferedSource.bufferField.size();
            source = realBufferedSource.source;
        } else {
            j = 0;
        }
        if (!((source instanceof FileHandleSource) && ((FileHandleSource) source).getFileHandle() == this)) {
            throw new IllegalArgumentException("source was not created by this FileHandle".toString());
        }
        FileHandleSource fileHandleSource = (FileHandleSource) source;
        if (!(!fileHandleSource.getClosed())) {
            throw new IllegalStateException("closed".toString());
        }
        return fileHandleSource.getPosition() - j;
    }

    public final void reposition(Source source, long j) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        boolean z = false;
        if (source instanceof RealBufferedSource) {
            RealBufferedSource realBufferedSource = (RealBufferedSource) source;
            Source source2 = realBufferedSource.source;
            if (!((source2 instanceof FileHandleSource) && ((FileHandleSource) source2).getFileHandle() == this)) {
                throw new IllegalArgumentException("source was not created by this FileHandle".toString());
            }
            FileHandleSource fileHandleSource = (FileHandleSource) source2;
            if (!(!fileHandleSource.getClosed())) {
                throw new IllegalStateException("closed".toString());
            }
            long size = realBufferedSource.bufferField.size();
            long position = j - (fileHandleSource.getPosition() - size);
            if (0 <= position && position < size) {
                z = true;
            }
            if (z) {
                realBufferedSource.skip(position);
                return;
            }
            realBufferedSource.bufferField.clear();
            fileHandleSource.setPosition(j);
            return;
        }
        if ((source instanceof FileHandleSource) && ((FileHandleSource) source).getFileHandle() == this) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException("source was not created by this FileHandle".toString());
        }
        FileHandleSource fileHandleSource2 = (FileHandleSource) source;
        if (!(!fileHandleSource2.getClosed())) {
            throw new IllegalStateException("closed".toString());
        }
        fileHandleSource2.setPosition(j);
    }

    public static /* synthetic */ Sink sink$default(FileHandle fileHandle, long j, int i, Object obj) throws IOException {
        if (obj == null) {
            if ((i & 1) != 0) {
                j = 0;
            }
            return fileHandle.sink(j);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
    }

    public final Sink sink(long j) throws IOException {
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            this.openStreamCount++;
        }
        return new FileHandleSink(this, j);
    }

    public final Sink appendingSink() throws IOException {
        return sink(size());
    }

    public final long position(Sink sink) throws IOException {
        long j;
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (sink instanceof RealBufferedSink) {
            RealBufferedSink realBufferedSink = (RealBufferedSink) sink;
            j = realBufferedSink.bufferField.size();
            sink = realBufferedSink.sink;
        } else {
            j = 0;
        }
        if (!((sink instanceof FileHandleSink) && ((FileHandleSink) sink).getFileHandle() == this)) {
            throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
        }
        FileHandleSink fileHandleSink = (FileHandleSink) sink;
        if (!(!fileHandleSink.getClosed())) {
            throw new IllegalStateException("closed".toString());
        }
        return fileHandleSink.getPosition() + j;
    }

    public final void reposition(Sink sink, long j) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        boolean z = false;
        if (sink instanceof RealBufferedSink) {
            RealBufferedSink realBufferedSink = (RealBufferedSink) sink;
            Sink sink2 = realBufferedSink.sink;
            if ((sink2 instanceof FileHandleSink) && ((FileHandleSink) sink2).getFileHandle() == this) {
                z = true;
            }
            if (!z) {
                throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
            }
            FileHandleSink fileHandleSink = (FileHandleSink) sink2;
            if (!(!fileHandleSink.getClosed())) {
                throw new IllegalStateException("closed".toString());
            }
            realBufferedSink.emit();
            fileHandleSink.setPosition(j);
            return;
        }
        if ((sink instanceof FileHandleSink) && ((FileHandleSink) sink).getFileHandle() == this) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
        }
        FileHandleSink fileHandleSink2 = (FileHandleSink) sink;
        if (!(!fileHandleSink2.getClosed())) {
            throw new IllegalStateException("closed".toString());
        }
        fileHandleSink2.setPosition(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long readNoCloseCheck(long j, Buffer buffer, long j2) {
        if (j2 >= 0) {
            long j3 = j + j2;
            long j4 = j;
            while (true) {
                if (j4 >= j3) {
                    break;
                }
                Segment writableSegment$okio = buffer.writableSegment$okio(1);
                int protectedRead = protectedRead(j4, writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j3 - j4, 8192 - writableSegment$okio.limit));
                if (protectedRead == -1) {
                    if (writableSegment$okio.pos == writableSegment$okio.limit) {
                        buffer.head = writableSegment$okio.pop();
                        SegmentPool.recycle(writableSegment$okio);
                    }
                    if (j == j4) {
                        return -1L;
                    }
                } else {
                    writableSegment$okio.limit += protectedRead;
                    long j5 = protectedRead;
                    j4 += j5;
                    buffer.setSize$okio(buffer.size() + j5);
                }
            }
            return j4 - j;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(j2)).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeNoCloseCheck(long j, Buffer buffer, long j2) {
        _UtilKt.checkOffsetAndCount(buffer.size(), 0L, j2);
        long j3 = j2 + j;
        while (j < j3) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int min = (int) Math.min(j3 - j, segment.limit - segment.pos);
            protectedWrite(j, segment.data, segment.pos, min);
            segment.pos += min;
            long j4 = min;
            j += j4;
            buffer.setSize$okio(buffer.size() - j4);
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileHandle.kt */
    @Metadata(m108d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, m107d2 = {"Lokio/FileHandle$FileHandleSink;", "Lokio/Sink;", "fileHandle", "Lokio/FileHandle;", "position", "", "(Lokio/FileHandle;J)V", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "getFileHandle", "()Lokio/FileHandle;", "getPosition", "()J", "setPosition", "(J)V", "close", "", "flush", "timeout", "Lokio/Timeout;", "write", "source", "Lokio/Buffer;", "byteCount", "okio"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class FileHandleSink implements Sink {
        private boolean closed;
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSink(FileHandle fileHandle, long j) {
            Intrinsics.checkNotNullParameter(fileHandle, "fileHandle");
            this.fileHandle = fileHandle;
            this.position = j;
        }

        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        public final void setPosition(long j) {
            this.position = j;
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final void setClosed(boolean z) {
            this.closed = z;
        }

        @Override // okio.Sink
        public void write(Buffer source, long j) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (!this.closed) {
                this.fileHandle.writeNoCloseCheck(this.position, source, j);
                this.position += j;
                return;
            }
            throw new IllegalStateException("closed".toString());
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            this.fileHandle.protectedFlush();
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return Timeout.NONE;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            synchronized (this.fileHandle) {
                FileHandle fileHandle = getFileHandle();
                fileHandle.openStreamCount--;
                if (getFileHandle().openStreamCount == 0 && getFileHandle().closed) {
                    Unit unit = Unit.INSTANCE;
                    this.fileHandle.protectedClose();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileHandle.kt */
    @Metadata(m108d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, m107d2 = {"Lokio/FileHandle$FileHandleSource;", "Lokio/Source;", "fileHandle", "Lokio/FileHandle;", "position", "", "(Lokio/FileHandle;J)V", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "getFileHandle", "()Lokio/FileHandle;", "getPosition", "()J", "setPosition", "(J)V", "close", "", "read", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "okio"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class FileHandleSource implements Source {
        private boolean closed;
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSource(FileHandle fileHandle, long j) {
            Intrinsics.checkNotNullParameter(fileHandle, "fileHandle");
            this.fileHandle = fileHandle;
            this.position = j;
        }

        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        public final void setPosition(long j) {
            this.position = j;
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final void setClosed(boolean z) {
            this.closed = z;
        }

        @Override // okio.Source
        public long read(Buffer sink, long j) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (!this.closed) {
                long readNoCloseCheck = this.fileHandle.readNoCloseCheck(this.position, sink, j);
                if (readNoCloseCheck != -1) {
                    this.position += readNoCloseCheck;
                }
                return readNoCloseCheck;
            }
            throw new IllegalStateException("closed".toString());
        }

        @Override // okio.Source
        public Timeout timeout() {
            return Timeout.NONE;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            synchronized (this.fileHandle) {
                FileHandle fileHandle = getFileHandle();
                fileHandle.openStreamCount--;
                if (getFileHandle().openStreamCount == 0 && getFileHandle().closed) {
                    Unit unit = Unit.INSTANCE;
                    this.fileHandle.protectedClose();
                }
            }
        }
    }

    public final int read(long j, byte[] array, int i, int i2) throws IOException {
        Intrinsics.checkNotNullParameter(array, "array");
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        return protectedRead(j, array, i, i2);
    }

    public final long read(long j, Buffer sink, long j2) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        return readNoCloseCheck(j, sink, j2);
    }

    public final long size() throws IOException {
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        return protectedSize();
    }

    public final Source source(long j) throws IOException {
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            this.openStreamCount++;
        }
        return new FileHandleSource(this, j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.openStreamCount != 0) {
                return;
            }
            Unit unit = Unit.INSTANCE;
            protectedClose();
        }
    }
}
