package com.anggrayudi.storage.file;

import androidx.documentfile.provider.DocumentFile;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: DocumentFileExt.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n"}, m107d2 = {"<anonymous>", "", "it", "Landroidx/documentfile/provider/DocumentFile;", "kotlin.jvm.PlatformType"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
final class DocumentFileUtils$search$3 extends Lambda implements Function1<DocumentFile, Boolean> {
    public static final DocumentFileUtils$search$3 INSTANCE = new DocumentFileUtils$search$3();

    DocumentFileUtils$search$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(DocumentFile documentFile) {
        return Boolean.valueOf(invoke2(documentFile));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(DocumentFile documentFile) {
        return documentFile.isFile();
    }
}
