package okio.internal;

import kotlin.Metadata;

@Metadata(m108d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, m107d2 = {"Lokio/internal/EocdRecord;", "", "entryCount", "", "centralDirectoryOffset", "commentByteCount", "", "(JJI)V", "getCentralDirectoryOffset", "()J", "getCommentByteCount", "()I", "getEntryCount", "okio"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* renamed from: okio.internal.EocdRecord */
/* loaded from: classes4.dex */
final class zip {
    private final long centralDirectoryOffset;
    private final int commentByteCount;
    private final long entryCount;

    public zip(long j, long j2, int i) {
        this.entryCount = j;
        this.centralDirectoryOffset = j2;
        this.commentByteCount = i;
    }

    public final long getEntryCount() {
        return this.entryCount;
    }

    public final long getCentralDirectoryOffset() {
        return this.centralDirectoryOffset;
    }

    public final int getCommentByteCount() {
        return this.commentByteCount;
    }
}
