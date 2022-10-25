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
final class ZipKt$readEntry$1 extends Lambda implements Function2<Integer, Long, Unit> {
    final /* synthetic */ Ref.LongRef $compressedSize;
    final /* synthetic */ Ref.BooleanRef $hasZip64Extra;
    final /* synthetic */ Ref.LongRef $offset;
    final /* synthetic */ long $requiredZip64ExtraSize;
    final /* synthetic */ Ref.LongRef $size;
    final /* synthetic */ BufferedSource $this_readEntry;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZipKt$readEntry$1(Ref.BooleanRef booleanRef, long j, Ref.LongRef longRef, BufferedSource bufferedSource, Ref.LongRef longRef2, Ref.LongRef longRef3) {
        super(2);
        this.$hasZip64Extra = booleanRef;
        this.$requiredZip64ExtraSize = j;
        this.$size = longRef;
        this.$this_readEntry = bufferedSource;
        this.$compressedSize = longRef2;
        this.$offset = longRef3;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Long l) {
        invoke(num.intValue(), l.longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, long j) {
        if (i == 1) {
            if (this.$hasZip64Extra.element) {
                throw new IOException("bad zip: zip64 extra repeated");
            }
            this.$hasZip64Extra.element = true;
            if (j < this.$requiredZip64ExtraSize) {
                throw new IOException("bad zip: zip64 extra too short");
            }
            Ref.LongRef longRef = this.$size;
            longRef.element = longRef.element == 4294967295L ? this.$this_readEntry.readLongLe() : this.$size.element;
            Ref.LongRef longRef2 = this.$compressedSize;
            longRef2.element = longRef2.element == 4294967295L ? this.$this_readEntry.readLongLe() : 0L;
            Ref.LongRef longRef3 = this.$offset;
            longRef3.element = longRef3.element == 4294967295L ? this.$this_readEntry.readLongLe() : 0L;
        }
    }
}
