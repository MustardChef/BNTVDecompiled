package com.anggrayudi.storage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.StorageAccessCallback;
import com.anggrayudi.storage.file.DocumentFileExt;
import com.anggrayudi.storage.file.StorageType;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleStorageHelper.kt */
@Metadata(m108d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J0\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0015"}, m107d2 = {"com/anggrayudi/storage/SimpleStorageHelper$init$2", "Lcom/anggrayudi/storage/callback/StorageAccessCallback;", "onActivityHandlerNotFound", "", "requestCode", "", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "onCanceledByUser", "onRootPathNotSelected", "rootPath", "", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "selectedStorageType", "Lcom/anggrayudi/storage/file/StorageType;", "expectedStorageType", "onRootPathPermissionGranted", "root", "Landroidx/documentfile/provider/DocumentFile;", "onStoragePermissionDenied", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class SimpleStorageHelper$init$2 implements StorageAccessCallback {
    final /* synthetic */ SimpleStorageHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleStorageHelper$init$2(SimpleStorageHelper simpleStorageHelper) {
        this.this$0 = simpleStorageHelper;
    }

    @Override // com.anggrayudi.storage.callback.StorageAccessCallback
    public void onRootPathNotSelected(int i, String rootPath, Uri uri, final StorageType selectedStorageType, final StorageType expectedStorageType) {
        Intrinsics.checkNotNullParameter(rootPath, "rootPath");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(selectedStorageType, "selectedStorageType");
        Intrinsics.checkNotNullParameter(expectedStorageType, "expectedStorageType");
        if (!expectedStorageType.isExpected(selectedStorageType)) {
            selectedStorageType = expectedStorageType;
        }
        AlertDialog.Builder message = new AlertDialog.Builder(this.this$0.getStorage().getContext()).setCancelable(false).setMessage(selectedStorageType == StorageType.SD_CARD ? C1077R.string.ss_please_select_root_storage_sdcard : C1077R.string.ss_please_select_root_storage_primary);
        final SimpleStorageHelper simpleStorageHelper = this.this$0;
        AlertDialog.Builder negativeButton = message.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.anggrayudi.storage.-$$Lambda$SimpleStorageHelper$init$2$m4IJB8Tg8IWweYKmPR64IcoVce8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                SimpleStorageHelper$init$2.m8549onRootPathNotSelected$lambda0(SimpleStorageHelper.this, dialogInterface, i2);
            }
        });
        final SimpleStorageHelper simpleStorageHelper2 = this.this$0;
        negativeButton.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.anggrayudi.storage.-$$Lambda$SimpleStorageHelper$init$2$dQS0jbFOIpGFBx-erJwiIELpNTM
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                SimpleStorageHelper$init$2.m8550onRootPathNotSelected$lambda1(SimpleStorageHelper.this, selectedStorageType, expectedStorageType, dialogInterface, i2);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onRootPathNotSelected$lambda-0  reason: not valid java name */
    public static final void m8549onRootPathNotSelected$lambda0(SimpleStorageHelper this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onRootPathNotSelected$lambda-1  reason: not valid java name */
    public static final void m8550onRootPathNotSelected$lambda1(SimpleStorageHelper this$0, StorageType storageType, StorageType expectedStorageType, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(storageType, "$storageType");
        Intrinsics.checkNotNullParameter(expectedStorageType, "$expectedStorageType");
        SimpleStorage.requestStorageAccess$default(this$0.getStorage(), 0, storageType, expectedStorageType, 1, null);
    }

    @Override // com.anggrayudi.storage.callback.StorageAccessCallback
    public void onRootPathPermissionGranted(int i, DocumentFile root) {
        int i2;
        int i3;
        Set set;
        Intrinsics.checkNotNullParameter(root, "root");
        i2 = this.this$0.originalRequestCode;
        if (i == i2) {
            this.this$0.reset();
            Function2<Integer, DocumentFile, Unit> onStorageAccessGranted = this.this$0.getOnStorageAccessGranted();
            if (onStorageAccessGranted == null) {
                return;
            }
            onStorageAccessGranted.invoke(Integer.valueOf(i), root);
            return;
        }
        Context context = this.this$0.getStorage().getContext();
        C1083xfcc209e7 c1083xfcc209e7 = new C1083xfcc209e7(context, root);
        i3 = this.this$0.pickerToOpenOnceGranted;
        if (i3 == 1) {
            SimpleStorage storage = this.this$0.getStorage();
            set = this.this$0.filterMimeTypes;
            if (set == null) {
                set = SetsKt.emptySet();
            }
            Object[] array = set.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            String[] strArr = (String[]) array;
            SimpleStorage.openFilePicker$default(storage, 0, false, (String[]) Arrays.copyOf(strArr, strArr.length), 3, null);
            c1083xfcc209e7.invoke();
        } else if (i3 == 2) {
            SimpleStorage.openFolderPicker$default(this.this$0.getStorage(), 0, 1, null);
            c1083xfcc209e7.invoke();
        } else {
            Toast.makeText(context, context.getString(C1077R.string.ss_selecting_root_path_success_without_open_folder_picker, DocumentFileExt.getAbsolutePath(root, context)), 0).show();
        }
        this.this$0.reset();
    }

    @Override // com.anggrayudi.storage.callback.StorageAccessCallback
    public void onStoragePermissionDenied(int i) {
        SimpleStorageHelper simpleStorageHelper = this.this$0;
        simpleStorageHelper.requestStoragePermission(new SimpleStorageHelper$init$2$onStoragePermissionDenied$1(simpleStorageHelper));
    }

    @Override // com.anggrayudi.storage.callback.StorageAccessCallback
    public void onCanceledByUser(int i) {
        this.this$0.reset();
    }

    @Override // com.anggrayudi.storage.callback.StorageAccessCallback
    public void onActivityHandlerNotFound(int i, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.this$0.handleMissingActivityHandler();
    }
}
