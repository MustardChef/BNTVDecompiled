package okio.internal;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import okio.BufferedSource;

/* compiled from: zip.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, m107d2 = {"<anonymous>", "", "headerId", "", "dataSize", ""}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
final class ZipKt$readOrSkipLocalHeader$1 extends Lambda implements Function2<Integer, Long, Unit> {
    final /* synthetic */ Ref.ObjectRef<Long> $createdAtMillis;
    final /* synthetic */ Ref.ObjectRef<Long> $lastAccessedAtMillis;
    final /* synthetic */ Ref.ObjectRef<Long> $lastModifiedAtMillis;
    final /* synthetic */ BufferedSource $this_readOrSkipLocalHeader;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZipKt$readOrSkipLocalHeader$1(BufferedSource bufferedSource, Ref.ObjectRef<Long> objectRef, Ref.ObjectRef<Long> objectRef2, Ref.ObjectRef<Long> objectRef3) {
        super(2);
        this.$this_readOrSkipLocalHeader = bufferedSource;
        this.$lastModifiedAtMillis = objectRef;
        this.$lastAccessedAtMillis = objectRef2;
        this.$createdAtMillis = objectRef3;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Long l) {
        invoke(num.intValue(), l.longValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [T, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r0v17, types: [T, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r10v3, types: [T, java.lang.Long] */
    public final void invoke(int i, long j) {
        if (i == 21589) {
            if (j < 1) {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            int readByte = this.$this_readOrSkipLocalHeader.readByte() & 255;
            boolean z = (readByte & 1) == 1;
            boolean z2 = (readByte & 2) == 2;
            boolean z3 = (readByte & 4) == 4;
            BufferedSource bufferedSource = this.$this_readOrSkipLocalHeader;
            long j2 = z ? 5L : 1L;
            if (z2) {
                j2 += 4;
            }
            if (z3) {
                j2 += 4;
            }
            if (j < j2) {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            if (z) {
                this.$lastModifiedAtMillis.element = Long.valueOf(bufferedSource.readIntLe() * 1000);
            }
            if (z2) {
                this.$lastAccessedAtMillis.element = Long.valueOf(this.$this_readOrSkipLocalHeader.readIntLe() * 1000);
            }
            if (z3) {
                this.$createdAtMillis.element = Long.valueOf(this.$this_readOrSkipLocalHeader.readIntLe() * 1000);
            }
        }
    }
}
