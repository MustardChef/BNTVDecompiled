package com.anggrayudi.storage.file;

import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.FolderCallback;
import com.anggrayudi.storage.extension.IOExt;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DocumentFileExt.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, m107d2 = {"<anonymous>", "", "sourceFile", "Landroidx/documentfile/provider/DocumentFile;", "destFile"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class DocumentFileUtils$copyFolderTo$copy$1 extends Lambda implements Function2<DocumentFile, DocumentFile, Unit> {
    final /* synthetic */ byte[] $buffer;
    final /* synthetic */ Ref.LongRef $bytesMoved;
    final /* synthetic */ FolderCallback $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $deleteSourceWhenComplete;
    final /* synthetic */ Ref.IntRef $totalCopiedFiles;
    final /* synthetic */ Ref.IntRef $writeSpeed;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentFileUtils$copyFolderTo$copy$1(Context context, FolderCallback folderCallback, Ref.IntRef intRef, boolean z, byte[] bArr, Ref.LongRef longRef, Ref.IntRef intRef2) {
        super(2);
        this.$context = context;
        this.$callback = folderCallback;
        this.$totalCopiedFiles = intRef;
        this.$deleteSourceWhenComplete = z;
        this.$buffer = bArr;
        this.$bytesMoved = longRef;
        this.$writeSpeed = intRef2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DocumentFileExt.kt */
    @Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, m107d2 = {"<anonymous>", "", "inputStream", "Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
    /* renamed from: com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$copy$1$1 */
    /* loaded from: classes.dex */
    public static final class C11211 extends Lambda implements Function2<InputStream, OutputStream, Unit> {
        final /* synthetic */ byte[] $buffer;
        final /* synthetic */ Ref.LongRef $bytesMoved;
        final /* synthetic */ Ref.IntRef $writeSpeed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11211(byte[] bArr, Ref.LongRef longRef, Ref.IntRef intRef) {
            super(2);
            this.$buffer = bArr;
            this.$bytesMoved = longRef;
            this.$writeSpeed = intRef;
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
            try {
                int read = inputStream.read(this.$buffer);
                while (read != -1) {
                    outputStream.write(this.$buffer, 0, read);
                    this.$bytesMoved.element += read;
                    this.$writeSpeed.element += read;
                    read = inputStream.read(this.$buffer);
                }
            } finally {
                IOExt.closeStream(inputStream);
                IOExt.closeStream(outputStream);
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(DocumentFile documentFile, DocumentFile documentFile2) {
        invoke2(documentFile, documentFile2);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(DocumentFile sourceFile, DocumentFile destFile) {
        Intrinsics.checkNotNullParameter(sourceFile, "sourceFile");
        Intrinsics.checkNotNullParameter(destFile, "destFile");
        DocumentFileExt.createFileStreams(this.$context, sourceFile, destFile, this.$callback, new C11211(this.$buffer, this.$bytesMoved, this.$writeSpeed));
        this.$totalCopiedFiles.element++;
        if (this.$deleteSourceWhenComplete) {
            sourceFile.delete();
        }
    }
}
