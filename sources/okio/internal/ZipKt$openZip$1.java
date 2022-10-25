package okio.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: zip.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m107d2 = {"<anonymous>", "", "it", "Lokio/internal/ZipEntry;"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ZipKt$openZip$1 extends Lambda implements Function1<ZipEntry, Boolean> {
    public static final ZipKt$openZip$1 INSTANCE = new ZipKt$openZip$1();

    ZipKt$openZip$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(ZipEntry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }
}
