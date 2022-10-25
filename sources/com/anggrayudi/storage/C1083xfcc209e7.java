package com.anggrayudi.storage;

import android.content.Context;
import android.widget.Toast;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.file.DocumentFileExt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;

/* compiled from: SimpleStorageHelper.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* renamed from: com.anggrayudi.storage.SimpleStorageHelper$init$2$onRootPathPermissionGranted$toastFilePicker$1 */
/* loaded from: classes.dex */
final class C1083xfcc209e7 extends Lambda implements Functions<Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ DocumentFile $root;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1083xfcc209e7(Context context, DocumentFile documentFile) {
        super(0);
        this.$context = context;
        this.$root = documentFile;
    }

    @Override // kotlin.jvm.functions.Functions
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Functions
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Context context = this.$context;
        Toast.makeText(context, context.getString(C1077R.string.ss_selecting_root_path_success_with_open_folder_picker, DocumentFileExt.getAbsolutePath(this.$root, this.$context)), 1).show();
    }
}
