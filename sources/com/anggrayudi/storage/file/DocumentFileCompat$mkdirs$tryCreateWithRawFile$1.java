package com.anggrayudi.storage.file;

import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DocumentFileCompat.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, m107d2 = {"<anonymous>", "Landroidx/documentfile/provider/DocumentFile;"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class DocumentFileCompat$mkdirs$tryCreateWithRawFile$1 extends Lambda implements Functions<DocumentFile> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $fullPath;
    final /* synthetic */ boolean $requiresWriteAccess;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentFileCompat$mkdirs$tryCreateWithRawFile$1(String str, boolean z, Context context) {
        super(0);
        this.$fullPath = str;
        this.$requiresWriteAccess = z;
        this.$context = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Functions
    public final DocumentFile invoke() {
        File file = new File(DocumentFileCompat.INSTANCE.removeForbiddenCharsFromFilename$storage_release(this.$fullPath));
        file.mkdirs();
        if (file.isDirectory() && file.canRead() && ((this.$requiresWriteAccess && FileExt.isWritable(file, this.$context)) || !this.$requiresWriteAccess)) {
            return DocumentFile.fromFile(file);
        }
        return null;
    }
}
