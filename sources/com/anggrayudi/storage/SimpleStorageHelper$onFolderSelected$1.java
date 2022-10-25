package com.anggrayudi.storage;

import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.FolderPickerCallback;
import com.anggrayudi.storage.file.StorageType;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleStorageHelper.kt */
@Metadata(m108d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0010"}, m107d2 = {"com/anggrayudi/storage/SimpleStorageHelper$onFolderSelected$1", "Lcom/anggrayudi/storage/callback/FolderPickerCallback;", "onActivityHandlerNotFound", "", "requestCode", "", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "onCanceledByUser", "onFolderSelected", "folder", "Landroidx/documentfile/provider/DocumentFile;", "onStorageAccessDenied", "storageType", "Lcom/anggrayudi/storage/file/StorageType;", "onStoragePermissionDenied", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class SimpleStorageHelper$onFolderSelected$1 implements FolderPickerCallback {
    final /* synthetic */ Function2<Integer, DocumentFile, Unit> $callback;
    final /* synthetic */ SimpleStorageHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public SimpleStorageHelper$onFolderSelected$1(SimpleStorageHelper simpleStorageHelper, Function2<? super Integer, ? super DocumentFile, Unit> function2) {
        this.this$0 = simpleStorageHelper;
        this.$callback = function2;
    }

    @Override // com.anggrayudi.storage.callback.FolderPickerCallback
    public void onFolderSelected(int i, DocumentFile folder) {
        Intrinsics.checkNotNullParameter(folder, "folder");
        this.this$0.reset();
        Function2<Integer, DocumentFile, Unit> function2 = this.$callback;
        if (function2 == null) {
            return;
        }
        function2.invoke(Integer.valueOf(i), folder);
    }

    @Override // com.anggrayudi.storage.callback.FolderPickerCallback
    public void onStorageAccessDenied(int i, DocumentFile documentFile, final StorageType storageType) {
        Intrinsics.checkNotNullParameter(storageType, "storageType");
        if (storageType == StorageType.UNKNOWN) {
            onStoragePermissionDenied(i);
            return;
        }
        AlertDialog.Builder message = new AlertDialog.Builder(this.this$0.getStorage().getContext()).setCancelable(false).setMessage(C1077R.string.ss_storage_access_denied_confirm);
        final SimpleStorageHelper simpleStorageHelper = this.this$0;
        AlertDialog.Builder negativeButton = message.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.anggrayudi.storage.-$$Lambda$SimpleStorageHelper$onFolderSelected$1$7yMBgydmoHisbPLsvHMie_KiRBI
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                SimpleStorageHelper$onFolderSelected$1.m8551onStorageAccessDenied$lambda0(SimpleStorageHelper.this, dialogInterface, i2);
            }
        });
        final SimpleStorageHelper simpleStorageHelper2 = this.this$0;
        negativeButton.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.anggrayudi.storage.-$$Lambda$SimpleStorageHelper$onFolderSelected$1$6r8zLAeWiYSzT5pdZFYBSXa8CKs
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                SimpleStorageHelper$onFolderSelected$1.m8552onStorageAccessDenied$lambda1(SimpleStorageHelper.this, storageType, dialogInterface, i2);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onStorageAccessDenied$lambda-0  reason: not valid java name */
    public static final void m8551onStorageAccessDenied$lambda0(SimpleStorageHelper this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onStorageAccessDenied$lambda-1  reason: not valid java name */
    public static final void m8552onStorageAccessDenied$lambda1(SimpleStorageHelper this$0, StorageType storageType, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(storageType, "$storageType");
        SimpleStorage.requestStorageAccess$default(this$0.getStorage(), 0, storageType, null, 5, null);
    }

    @Override // com.anggrayudi.storage.callback.FolderPickerCallback
    public void onStoragePermissionDenied(int i) {
        SimpleStorageHelper simpleStorageHelper = this.this$0;
        simpleStorageHelper.requestStoragePermission(new C1084x7cdfe751(simpleStorageHelper));
    }

    @Override // com.anggrayudi.storage.callback.FolderPickerCallback
    public void onCanceledByUser(int i) {
        this.this$0.reset();
    }

    @Override // com.anggrayudi.storage.callback.FolderPickerCallback
    public void onActivityHandlerNotFound(int i, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.this$0.handleMissingActivityHandler();
    }
}
