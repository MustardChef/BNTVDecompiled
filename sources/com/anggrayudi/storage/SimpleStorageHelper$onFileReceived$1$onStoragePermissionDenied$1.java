package com.anggrayudi.storage;

import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.SimpleStorageHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: SimpleStorageHelper.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m107d2 = {"<anonymous>", "", "it", ""}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
final class SimpleStorageHelper$onFileReceived$1$onStoragePermissionDenied$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ SimpleStorageHelper.OnFileReceived $callback;
    final /* synthetic */ List<DocumentFile> $files;
    final /* synthetic */ SimpleStorageHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SimpleStorageHelper$onFileReceived$1$onStoragePermissionDenied$1(SimpleStorageHelper.OnFileReceived onFileReceived, List<? extends DocumentFile> list, SimpleStorageHelper simpleStorageHelper) {
        super(1);
        this.$callback = onFileReceived;
        this.$files = list;
        this.this$0 = simpleStorageHelper;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (!z) {
            this.this$0.reset();
            return;
        }
        SimpleStorageHelper.OnFileReceived onFileReceived = this.$callback;
        if (onFileReceived == null) {
            return;
        }
        onFileReceived.onFileReceived(this.$files);
    }
}
