package com.anggrayudi.storage.file;

import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.FileCallback;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DocumentFileExt.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, m107d2 = {"<anonymous>", "", "inputStream", "Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class DocumentFileUtils$copyFileTo$6 extends Lambda implements Function2<InputStream, OutputStream, Unit> {
    final /* synthetic */ FileCallback $callback;
    final /* synthetic */ long $reportInterval;
    final /* synthetic */ DocumentFile $targetFile;
    final /* synthetic */ DocumentFile $this_copyFileTo;
    final /* synthetic */ boolean $watchProgress;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentFileUtils$copyFileTo$6(DocumentFile documentFile, DocumentFile documentFile2, boolean z, long j, FileCallback fileCallback) {
        super(2);
        this.$this_copyFileTo = documentFile;
        this.$targetFile = documentFile2;
        this.$watchProgress = z;
        this.$reportInterval = j;
        this.$callback = fileCallback;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(InputStream inputStream, OutputStream outputStream) {
        invoke2(inputStream, outputStream);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(InputStream inputStream, OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        DocumentFileExt.copyFileStream(this.$this_copyFileTo, inputStream, outputStream, this.$targetFile, this.$watchProgress, this.$reportInterval, false, this.$callback);
    }
}
