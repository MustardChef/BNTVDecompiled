package com.anggrayudi.storage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import androidx.activity.ComponentActivity;
import androidx.core.content.ContextCompat;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.Fragment;
import com.anggrayudi.storage.callback.CreateFileCallback;
import com.anggrayudi.storage.callback.FilePickerCallback;
import com.anggrayudi.storage.callback.FileReceiverCallback;
import com.anggrayudi.storage.callback.FolderPickerCallback;
import com.anggrayudi.storage.callback.StorageAccessCallback;
import com.anggrayudi.storage.extension.ContextExt;
import com.anggrayudi.storage.extension.UriExt;
import com.anggrayudi.storage.file.DocumentFileCompat;
import com.anggrayudi.storage.file.DocumentFileExt;
import com.anggrayudi.storage.file.MimeType;
import com.anggrayudi.storage.file.StorageId;
import com.anggrayudi.storage.file.StorageType;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.core.JsonPointer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.concurrent.Thread;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleStorage.kt */
@Metadata(m108d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\n\u0018\u0000 q2\u00020\u0001:\u0001qB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bB\u001b\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bB\u000f\b\u0002\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\u001cJ\b\u0010L\u001a\u00020JH\u0002J&\u0010M\u001a\u00020J2\u0006\u0010N\u001a\u00020O2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010O2\b\b\u0002\u0010Q\u001a\u000202H\u0007J\u0018\u0010R\u001a\u00020J2\u0006\u0010Q\u001a\u0002022\u0006\u0010S\u001a\u00020TH\u0002J\u0018\u0010U\u001a\u00020J2\u0006\u0010Q\u001a\u0002022\u0006\u0010V\u001a\u00020\u001cH\u0002J\u0018\u0010W\u001a\u00020J2\u0006\u0010Q\u001a\u0002022\u0006\u0010S\u001a\u00020TH\u0002J\u0018\u0010X\u001a\u00020J2\u0006\u0010Q\u001a\u0002022\u0006\u0010S\u001a\u00020TH\u0002J\u0018\u0010Y\u001a\b\u0012\u0004\u0012\u00020[0Z2\b\u0010K\u001a\u0004\u0018\u00010\u001cH\u0002J\u000e\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020OJ \u0010_\u001a\u00020J2\u0006\u0010Q\u001a\u0002022\u0006\u0010`\u001a\u0002022\b\u0010V\u001a\u0004\u0018\u00010\u001cJ\u000e\u0010a\u001a\u00020J2\u0006\u0010b\u001a\u00020\u0005J\u000e\u0010c\u001a\u00020J2\u0006\u0010d\u001a\u00020\u0005J5\u0010e\u001a\u00020J2\b\b\u0002\u0010Q\u001a\u0002022\b\b\u0002\u0010f\u001a\u00020]2\u0012\u0010g\u001a\n\u0012\u0006\b\u0001\u0012\u00020O0h\"\u00020OH\u0007¢\u0006\u0002\u0010iJ\u0012\u0010j\u001a\u00020J2\b\b\u0002\u0010Q\u001a\u000202H\u0007J\b\u0010k\u001a\u00020JH\u0007J&\u0010l\u001a\u00020J2\b\b\u0002\u0010Q\u001a\u0002022\b\b\u0002\u0010m\u001a\u00020\u001a2\b\b\u0002\u0010n\u001a\u00020\u001aH\u0007J\u0010\u0010o\u001a\u00020]2\u0006\u0010p\u001a\u00020TH\u0002R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00103\u001a\u0002022\u0006\u00101\u001a\u000202@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u00108\u001a\u0002022\u0006\u00101\u001a\u000202@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00105\"\u0004\b:\u00107R$\u0010;\u001a\u0002022\u0006\u00101\u001a\u000202@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00105\"\u0004\b=\u00107R$\u0010>\u001a\u0002022\u0006\u00101\u001a\u000202@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00105\"\u0004\b@\u00107R\u0014\u0010A\u001a\u00020\u001c8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u001eR\u001c\u0010C\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006r"}, m107d2 = {"Lcom/anggrayudi/storage/SimpleStorage;", "", "activity", "Landroid/app/Activity;", "savedState", "Landroid/os/Bundle;", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "Landroidx/activity/ComponentActivity;", "(Landroidx/activity/ComponentActivity;Landroid/os/Bundle;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Landroid/os/Bundle;)V", "wrapper", "Lcom/anggrayudi/storage/ComponentWrapper;", "(Lcom/anggrayudi/storage/ComponentWrapper;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "createFileCallback", "Lcom/anggrayudi/storage/callback/CreateFileCallback;", "getCreateFileCallback", "()Lcom/anggrayudi/storage/callback/CreateFileCallback;", "setCreateFileCallback", "(Lcom/anggrayudi/storage/callback/CreateFileCallback;)V", "expectedStorageTypeForAccessRequest", "Lcom/anggrayudi/storage/file/StorageType;", "externalStorageRootAccessIntent", "Landroid/content/Intent;", "getExternalStorageRootAccessIntent", "()Landroid/content/Intent;", "filePickerCallback", "Lcom/anggrayudi/storage/callback/FilePickerCallback;", "getFilePickerCallback", "()Lcom/anggrayudi/storage/callback/FilePickerCallback;", "setFilePickerCallback", "(Lcom/anggrayudi/storage/callback/FilePickerCallback;)V", "fileReceiverCallback", "Lcom/anggrayudi/storage/callback/FileReceiverCallback;", "getFileReceiverCallback", "()Lcom/anggrayudi/storage/callback/FileReceiverCallback;", "setFileReceiverCallback", "(Lcom/anggrayudi/storage/callback/FileReceiverCallback;)V", "folderPickerCallback", "Lcom/anggrayudi/storage/callback/FolderPickerCallback;", "getFolderPickerCallback", "()Lcom/anggrayudi/storage/callback/FolderPickerCallback;", "setFolderPickerCallback", "(Lcom/anggrayudi/storage/callback/FolderPickerCallback;)V", "value", "", "requestCodeCreateFile", "getRequestCodeCreateFile", "()I", "setRequestCodeCreateFile", "(I)V", "requestCodeFilePicker", "getRequestCodeFilePicker", "setRequestCodeFilePicker", "requestCodeFolderPicker", "getRequestCodeFolderPicker", "setRequestCodeFolderPicker", "requestCodeStorageAccess", "getRequestCodeStorageAccess", "setRequestCodeStorageAccess", "sdCardRootAccessIntent", "getSdCardRootAccessIntent", "storageAccessCallback", "Lcom/anggrayudi/storage/callback/StorageAccessCallback;", "getStorageAccessCallback", "()Lcom/anggrayudi/storage/callback/StorageAccessCallback;", "setStorageAccessCallback", "(Lcom/anggrayudi/storage/callback/StorageAccessCallback;)V", "checkIfFileReceived", "", SDKConstants.PARAM_INTENT, "checkRequestCode", "createFile", "mimeType", "", "fileName", "requestCode", "handleActivityResultForCreateFile", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "handleActivityResultForFilePicker", "data", "handleActivityResultForFolderPicker", "handleActivityResultForStorageAccess", "intentToDocumentFiles", "", "Landroidx/documentfile/provider/DocumentFile;", "isStorageAccessGranted", "", "storageId", "onActivityResult", "resultCode", "onRestoreInstanceState", "savedInstanceState", "onSaveInstanceState", "outState", "openFilePicker", "allowMultiple", "filterMimeTypes", "", "(IZ[Ljava/lang/String;)V", "openFolderPicker", "requestFullStorageAccess", "requestStorageAccess", "initialRootPath", "expectedStorageType", "saveUriPermission", "root", "Companion", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class SimpleStorage {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_EXPECTED_STORAGE_TYPE_FOR_ACCESS_REQUEST = "com.anggrayudi.storage.expectedStorageTypeForAccessRequest";
    private static final String KEY_REQUEST_CODE_CREATE_FILE = "com.anggrayudi.storage.requestCodeCreateFile";
    private static final String KEY_REQUEST_CODE_FILE_PICKER = "com.anggrayudi.storage.requestCodeFilePicker";
    private static final String KEY_REQUEST_CODE_FOLDER_PICKER = "com.anggrayudi.storage.requestCodeFolderPicker";
    private static final String KEY_REQUEST_CODE_FRAGMENT_PICKER = "com.anggrayudi.storage.requestCodeFragmentPicker";
    private static final String KEY_REQUEST_CODE_STORAGE_ACCESS = "com.anggrayudi.storage.requestCodeStorageAccess";
    private CreateFileCallback createFileCallback;
    private StorageType expectedStorageTypeForAccessRequest;
    private FilePickerCallback filePickerCallback;
    private FileReceiverCallback fileReceiverCallback;
    private FolderPickerCallback folderPickerCallback;
    private int requestCodeCreateFile;
    private int requestCodeFilePicker;
    private int requestCodeFolderPicker;
    private int requestCodeStorageAccess;
    private StorageAccessCallback storageAccessCallback;
    private final ComponentWrapper wrapper;

    @JvmStatic
    public static final void cleanupRedundantUriPermissions(Context context) {
        Companion.cleanupRedundantUriPermissions(context);
    }

    public static final Intent getDefaultExternalStorageIntent() {
        return Companion.getDefaultExternalStorageIntent();
    }

    public static final String getExternalStoragePath() {
        return Companion.getExternalStoragePath();
    }

    @JvmStatic
    public static final boolean hasFullDiskAccess(Context context, String str) {
        return Companion.hasFullDiskAccess(context, str);
    }

    @JvmStatic
    public static final boolean hasStorageAccess(Context context, String str) {
        return Companion.hasStorageAccess(context, str);
    }

    @JvmStatic
    public static final boolean hasStorageAccess(Context context, String str, boolean z) {
        return Companion.hasStorageAccess(context, str, z);
    }

    @JvmStatic
    public static final boolean hasStoragePermission(Context context) {
        return Companion.hasStoragePermission(context);
    }

    @JvmStatic
    public static final boolean hasStorageReadPermission(Context context) {
        return Companion.hasStorageReadPermission(context);
    }

    public static final boolean isSdCardPresent() {
        return Companion.isSdCardPresent();
    }

    public final void createFile(String mimeType) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        createFile$default(this, mimeType, null, 0, 6, null);
    }

    public final void createFile(String mimeType, String str) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        createFile$default(this, mimeType, str, 0, 4, null);
    }

    public final void openFilePicker(int i, String... filterMimeTypes) {
        Intrinsics.checkNotNullParameter(filterMimeTypes, "filterMimeTypes");
        openFilePicker$default(this, i, false, filterMimeTypes, 2, null);
    }

    public final void openFilePicker(String... filterMimeTypes) {
        Intrinsics.checkNotNullParameter(filterMimeTypes, "filterMimeTypes");
        openFilePicker$default(this, 0, false, filterMimeTypes, 3, null);
    }

    public final void openFolderPicker() {
        openFolderPicker$default(this, 0, 1, null);
    }

    public final void requestStorageAccess() {
        requestStorageAccess$default(this, 0, null, null, 7, null);
    }

    public final void requestStorageAccess(int i) {
        requestStorageAccess$default(this, i, null, null, 6, null);
    }

    public final void requestStorageAccess(int i, StorageType initialRootPath) {
        Intrinsics.checkNotNullParameter(initialRootPath, "initialRootPath");
        requestStorageAccess$default(this, i, initialRootPath, null, 4, null);
    }

    private SimpleStorage(ComponentWrapper componentWrapper) {
        this.wrapper = componentWrapper;
        this.requestCodeStorageAccess = 1;
        this.requestCodeFolderPicker = 2;
        this.requestCodeFilePicker = 3;
        this.requestCodeCreateFile = 4;
        this.expectedStorageTypeForAccessRequest = StorageType.UNKNOWN;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleStorage(Activity activity, Bundle bundle) {
        this(new ActivityWrapper(activity));
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (bundle == null) {
            return;
        }
        onRestoreInstanceState(bundle);
    }

    public /* synthetic */ SimpleStorage(Activity activity, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, (i & 2) != 0 ? null : bundle);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleStorage(ComponentActivity activity, Bundle bundle) {
        this(new ComponentActivityWrapper(activity));
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (bundle != null) {
            onRestoreInstanceState(bundle);
        }
        ((ComponentActivityWrapper) this.wrapper).setStorage(this);
    }

    public /* synthetic */ SimpleStorage(ComponentActivity componentActivity, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(componentActivity, (i & 2) != 0 ? null : bundle);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleStorage(Fragment fragment, Bundle bundle) {
        this(new FragmentWrapper(fragment));
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (bundle != null) {
            onRestoreInstanceState(bundle);
        }
        ((FragmentWrapper) this.wrapper).setStorage(this);
    }

    public /* synthetic */ SimpleStorage(Fragment fragment, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment, (i & 2) != 0 ? null : bundle);
    }

    public final StorageAccessCallback getStorageAccessCallback() {
        return this.storageAccessCallback;
    }

    public final void setStorageAccessCallback(StorageAccessCallback storageAccessCallback) {
        this.storageAccessCallback = storageAccessCallback;
    }

    public final FolderPickerCallback getFolderPickerCallback() {
        return this.folderPickerCallback;
    }

    public final void setFolderPickerCallback(FolderPickerCallback folderPickerCallback) {
        this.folderPickerCallback = folderPickerCallback;
    }

    public final FilePickerCallback getFilePickerCallback() {
        return this.filePickerCallback;
    }

    public final void setFilePickerCallback(FilePickerCallback filePickerCallback) {
        this.filePickerCallback = filePickerCallback;
    }

    public final CreateFileCallback getCreateFileCallback() {
        return this.createFileCallback;
    }

    public final void setCreateFileCallback(CreateFileCallback createFileCallback) {
        this.createFileCallback = createFileCallback;
    }

    public final FileReceiverCallback getFileReceiverCallback() {
        return this.fileReceiverCallback;
    }

    public final void setFileReceiverCallback(FileReceiverCallback fileReceiverCallback) {
        this.fileReceiverCallback = fileReceiverCallback;
    }

    public final int getRequestCodeStorageAccess() {
        return this.requestCodeStorageAccess;
    }

    public final void setRequestCodeStorageAccess(int i) {
        this.requestCodeStorageAccess = i;
        checkRequestCode();
    }

    public final int getRequestCodeFolderPicker() {
        return this.requestCodeFolderPicker;
    }

    public final void setRequestCodeFolderPicker(int i) {
        this.requestCodeFolderPicker = i;
        checkRequestCode();
    }

    public final int getRequestCodeFilePicker() {
        return this.requestCodeFilePicker;
    }

    public final void setRequestCodeFilePicker(int i) {
        this.requestCodeFilePicker = i;
        checkRequestCode();
    }

    public final int getRequestCodeCreateFile() {
        return this.requestCodeCreateFile;
    }

    public final void setRequestCodeCreateFile(int i) {
        this.requestCodeCreateFile = i;
        checkRequestCode();
    }

    public final Context getContext() {
        return this.wrapper.getContext();
    }

    private final Intent getExternalStorageRootAccessIntent() {
        if (Build.VERSION.SDK_INT >= 29) {
            Object systemService = getContext().getSystemService("storage");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.storage.StorageManager");
            Intent createOpenDocumentTreeIntent = ((StorageManager) systemService).getPrimaryStorageVolume().createOpenDocumentTreeIntent();
            Intrinsics.checkNotNullExpressionValue(createOpenDocumentTreeIntent, "{\n            val sm = context.getSystemService(Context.STORAGE_SERVICE) as StorageManager\n            sm.primaryStorageVolume.createOpenDocumentTreeIntent()\n        }");
            return createOpenDocumentTreeIntent;
        }
        return Companion.getDefaultExternalStorageIntent();
    }

    private final Intent getSdCardRootAccessIntent() {
        Intent intent;
        Object obj;
        Intent createAccessIntent;
        Object systemService = getContext().getSystemService("storage");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.storage.StorageManager");
        List<StorageVolume> storageVolumes = ((StorageManager) systemService).getStorageVolumes();
        Intrinsics.checkNotNullExpressionValue(storageVolumes, "sm.storageVolumes");
        Iterator<T> it = storageVolumes.iterator();
        while (true) {
            intent = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((StorageVolume) obj).isRemovable()) {
                break;
            }
        }
        StorageVolume storageVolume = (StorageVolume) obj;
        if (storageVolume != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                createAccessIntent = storageVolume.createOpenDocumentTreeIntent();
            } else if (storageVolume.isPrimary()) {
                createAccessIntent = Companion.getDefaultExternalStorageIntent();
            } else {
                createAccessIntent = storageVolume.createAccessIntent(null);
            }
            intent = createAccessIntent;
        }
        return intent == null ? Companion.getDefaultExternalStorageIntent() : intent;
    }

    public final boolean isStorageAccessGranted(String storageId) {
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        return DocumentFileCompat.isAccessGranted(getContext(), storageId);
    }

    public static /* synthetic */ void requestStorageAccess$default(SimpleStorage simpleStorage, int i, StorageType storageType, StorageType storageType2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = simpleStorage.requestCodeStorageAccess;
        }
        if ((i2 & 2) != 0) {
            storageType = StorageType.EXTERNAL;
        }
        if ((i2 & 4) != 0) {
            storageType2 = StorageType.UNKNOWN;
        }
        simpleStorage.requestStorageAccess(i, storageType, storageType2);
    }

    public final void requestStorageAccess(int i, StorageType initialRootPath, StorageType expectedStorageType) {
        Intent externalStorageRootAccessIntent;
        Intrinsics.checkNotNullParameter(initialRootPath, "initialRootPath");
        Intrinsics.checkNotNullParameter(expectedStorageType, "expectedStorageType");
        Companion companion = Companion;
        if (!companion.hasStoragePermission(getContext())) {
            StorageAccessCallback storageAccessCallback = this.storageAccessCallback;
            if (storageAccessCallback == null) {
                return;
            }
            storageAccessCallback.onStoragePermissionDenied(i);
        } else if (initialRootPath == StorageType.DATA || expectedStorageType == StorageType.DATA) {
            throw new IllegalArgumentException("Cannot use StorageType.DATA because it is never available in Storage Access Framework's folder selector.");
        } else {
            if (initialRootPath == StorageType.EXTERNAL && expectedStorageType.isExpected(initialRootPath) && Build.VERSION.SDK_INT < 29 && !companion.isSdCardPresent()) {
                DocumentFile rootDocumentFile$default = DocumentFileCompat.getRootDocumentFile$default(getContext(), StorageId.PRIMARY, true, false, 8, null);
                if (rootDocumentFile$default == null) {
                    return;
                }
                Uri uri = rootDocumentFile$default.getUri();
                Intrinsics.checkNotNullExpressionValue(uri, "root.uri");
                saveUriPermission(uri);
                StorageAccessCallback storageAccessCallback2 = this.storageAccessCallback;
                if (storageAccessCallback2 == null) {
                    return;
                }
                storageAccessCallback2.onRootPathPermissionGranted(i, rootDocumentFile$default);
                return;
            }
            if (initialRootPath == StorageType.SD_CARD && Build.VERSION.SDK_INT >= 24) {
                externalStorageRootAccessIntent = getSdCardRootAccessIntent();
            } else {
                externalStorageRootAccessIntent = getExternalStorageRootAccessIntent();
            }
            if (this.wrapper.startActivityForResult(externalStorageRootAccessIntent, i)) {
                setRequestCodeStorageAccess(i);
                this.expectedStorageTypeForAccessRequest = expectedStorageType;
                return;
            }
            StorageAccessCallback storageAccessCallback3 = this.storageAccessCallback;
            if (storageAccessCallback3 == null) {
                return;
            }
            storageAccessCallback3.onActivityHandlerNotFound(i, externalStorageRootAccessIntent);
        }
    }

    public final void requestFullStorageAccess() {
        getContext().startActivity(new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION"));
    }

    public static /* synthetic */ void createFile$default(SimpleStorage simpleStorage, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            i = simpleStorage.requestCodeCreateFile;
        }
        simpleStorage.createFile(str, str2, i);
    }

    public final void createFile(String mimeType, String str, int i) {
        CreateFileCallback createFileCallback;
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        setRequestCodeCreateFile(i);
        Intent type = new Intent("android.intent.action.CREATE_DOCUMENT").setType(mimeType);
        Intrinsics.checkNotNullExpressionValue(type, "Intent(Intent.ACTION_CREATE_DOCUMENT).setType(mimeType)");
        if (str != null) {
            type.putExtra("android.intent.extra.TITLE", str);
        }
        if (this.wrapper.startActivityForResult(type, i) || (createFileCallback = this.createFileCallback) == null) {
            return;
        }
        createFileCallback.onActivityHandlerNotFound(i, type);
    }

    public static /* synthetic */ void openFolderPicker$default(SimpleStorage simpleStorage, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = simpleStorage.requestCodeFolderPicker;
        }
        simpleStorage.openFolderPicker(i);
    }

    public final void openFolderPicker(int i) {
        Intent externalStorageRootAccessIntent;
        FolderPickerCallback folderPickerCallback;
        setRequestCodeFolderPicker(i);
        if (Companion.hasStoragePermission(getContext())) {
            if (Build.VERSION.SDK_INT < 30) {
                externalStorageRootAccessIntent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            } else {
                externalStorageRootAccessIntent = getExternalStorageRootAccessIntent();
            }
            if (this.wrapper.startActivityForResult(externalStorageRootAccessIntent, i) || (folderPickerCallback = this.folderPickerCallback) == null) {
                return;
            }
            folderPickerCallback.onActivityHandlerNotFound(i, externalStorageRootAccessIntent);
            return;
        }
        FolderPickerCallback folderPickerCallback2 = this.folderPickerCallback;
        if (folderPickerCallback2 == null) {
            return;
        }
        folderPickerCallback2.onStoragePermissionDenied(i);
    }

    public static /* synthetic */ void openFilePicker$default(SimpleStorage simpleStorage, int i, boolean z, String[] strArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = simpleStorage.requestCodeFilePicker;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        simpleStorage.openFilePicker(i, z, strArr);
    }

    public final void openFilePicker(int i, boolean z, String... filterMimeTypes) {
        FilePickerCallback filePickerCallback;
        Intrinsics.checkNotNullParameter(filterMimeTypes, "filterMimeTypes");
        setRequestCodeFilePicker(i);
        if (Companion.hasStorageReadPermission(getContext())) {
            Intent putExtra = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.ALLOW_MULTIPLE", z);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(Intent.ACTION_OPEN_DOCUMENT)\n                .putExtra(Intent.EXTRA_ALLOW_MULTIPLE, allowMultiple)");
            int length = filterMimeTypes.length;
            String str = MimeType.UNKNOWN;
            if (length > 1) {
                putExtra.setType(MimeType.UNKNOWN).putExtra("android.intent.extra.MIME_TYPES", filterMimeTypes);
            } else {
                String str2 = (String) ArraysKt.firstOrNull(filterMimeTypes);
                if (str2 != null) {
                    str = str2;
                }
                putExtra.setType(str);
            }
            if (this.wrapper.startActivityForResult(putExtra, i) || (filePickerCallback = this.filePickerCallback) == null) {
                return;
            }
            filePickerCallback.onActivityHandlerNotFound(i, putExtra);
            return;
        }
        FilePickerCallback filePickerCallback2 = this.filePickerCallback;
        if (filePickerCallback2 == null) {
            return;
        }
        filePickerCallback2.onStoragePermissionDenied(i, null);
    }

    private final void handleActivityResultForStorageAccess(int i, Uri uri) {
        DocumentFile fromTreeUri;
        Object obj;
        Intent createAccessIntent;
        StorageAccessCallback storageAccessCallback;
        DocumentFile fromTreeUri2;
        DocumentFile fromTreeUri3;
        String storageId = UriExt.getStorageId(uri, getContext());
        StorageType fromStorageId = StorageType.Companion.fromStorageId(storageId);
        if (!this.expectedStorageTypeForAccessRequest.isExpected(fromStorageId)) {
            DocumentFile fromTreeUri4 = ContextExt.fromTreeUri(getContext(), uri);
            String absolutePath = fromTreeUri4 != null ? DocumentFileExt.getAbsolutePath(fromTreeUri4, getContext()) : null;
            String str = absolutePath != null ? absolutePath : "";
            StorageAccessCallback storageAccessCallback2 = this.storageAccessCallback;
            if (storageAccessCallback2 == null) {
                return;
            }
            storageAccessCallback2.onRootPathNotSelected(i, str, uri, fromStorageId, this.expectedStorageTypeForAccessRequest);
        } else if (UriExt.isDownloadsDocument(uri)) {
            if (Intrinsics.areEqual(uri.toString(), DocumentFileCompat.DOWNLOADS_TREE_URI)) {
                saveUriPermission(uri);
                StorageAccessCallback storageAccessCallback3 = this.storageAccessCallback;
                if (storageAccessCallback3 == null || (fromTreeUri3 = ContextExt.fromTreeUri(getContext(), uri)) == null) {
                    return;
                }
                storageAccessCallback3.onRootPathPermissionGranted(i, fromTreeUri3);
                return;
            }
            StorageAccessCallback storageAccessCallback4 = this.storageAccessCallback;
            if (storageAccessCallback4 == null) {
                return;
            }
            storageAccessCallback4.onRootPathNotSelected(i, Companion.getExternalStoragePath() + JsonPointer.SEPARATOR + ((Object) Environment.DIRECTORY_DOWNLOADS), uri, StorageType.EXTERNAL, this.expectedStorageTypeForAccessRequest);
        } else if (Build.VERSION.SDK_INT < 30 && !UriExt.isExternalStorageDocument(uri)) {
            StorageAccessCallback storageAccessCallback5 = this.storageAccessCallback;
            if (storageAccessCallback5 == null) {
                return;
            }
            storageAccessCallback5.onRootPathNotSelected(i, Companion.getExternalStoragePath(), uri, StorageType.EXTERNAL, this.expectedStorageTypeForAccessRequest);
        } else if (Build.VERSION.SDK_INT < 29 && Intrinsics.areEqual(storageId, StorageId.PRIMARY)) {
            saveUriPermission(uri);
            StorageAccessCallback storageAccessCallback6 = this.storageAccessCallback;
            if (storageAccessCallback6 == null || (fromTreeUri2 = ContextExt.fromTreeUri(getContext(), uri)) == null) {
                return;
            }
            storageAccessCallback6.onRootPathPermissionGranted(i, fromTreeUri2);
        } else if (Build.VERSION.SDK_INT >= 30 || DocumentFileCompat.isRootUri(uri)) {
            if (saveUriPermission(uri)) {
                StorageAccessCallback storageAccessCallback7 = this.storageAccessCallback;
                if (storageAccessCallback7 == null || (fromTreeUri = ContextExt.fromTreeUri(getContext(), uri)) == null) {
                    return;
                }
                storageAccessCallback7.onRootPathPermissionGranted(i, fromTreeUri);
                return;
            }
            StorageAccessCallback storageAccessCallback8 = this.storageAccessCallback;
            if (storageAccessCallback8 == null) {
                return;
            }
            storageAccessCallback8.onStoragePermissionDenied(i);
        } else if (Intrinsics.areEqual(storageId, StorageId.PRIMARY)) {
            StorageAccessCallback storageAccessCallback9 = this.storageAccessCallback;
            if (storageAccessCallback9 == null) {
                return;
            }
            storageAccessCallback9.onRootPathNotSelected(i, Companion.getExternalStoragePath(), uri, StorageType.EXTERNAL, this.expectedStorageTypeForAccessRequest);
        } else {
            if (Build.VERSION.SDK_INT >= 24 && Build.VERSION.SDK_INT < 29) {
                Object systemService = getContext().getSystemService("storage");
                Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.storage.StorageManager");
                List<StorageVolume> storageVolumes = ((StorageManager) systemService).getStorageVolumes();
                Intrinsics.checkNotNullExpressionValue(storageVolumes, "sm.storageVolumes");
                Iterator<T> it = storageVolumes.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((StorageVolume) obj).isRemovable()) {
                        break;
                    }
                }
                StorageVolume storageVolume = (StorageVolume) obj;
                if (storageVolume != null && (createAccessIntent = storageVolume.createAccessIntent(null)) != null) {
                    if (this.wrapper.startActivityForResult(createAccessIntent, i) || (storageAccessCallback = getStorageAccessCallback()) == null) {
                        return;
                    }
                    storageAccessCallback.onActivityHandlerNotFound(i, createAccessIntent);
                    return;
                }
            }
            StorageAccessCallback storageAccessCallback10 = this.storageAccessCallback;
            if (storageAccessCallback10 == null) {
                return;
            }
            storageAccessCallback10.onRootPathNotSelected(i, Intrinsics.stringPlus("/storage/", storageId), uri, StorageType.SD_CARD, this.expectedStorageTypeForAccessRequest);
        }
    }

    private final void handleActivityResultForFolderPicker(int i, Uri uri) {
        DocumentFile fromTreeUri = ContextExt.fromTreeUri(getContext(), uri);
        String storageId = UriExt.getStorageId(uri, getContext());
        StorageType fromStorageId = StorageType.Companion.fromStorageId(storageId);
        if (fromTreeUri == null || !DocumentFileExt.canModify(fromTreeUri, getContext())) {
            FolderPickerCallback folderPickerCallback = this.folderPickerCallback;
            if (folderPickerCallback == null) {
                return;
            }
            folderPickerCallback.onStorageAccessDenied(i, fromTreeUri, fromStorageId);
            return;
        }
        if (Intrinsics.areEqual(uri.toString(), DocumentFileCompat.DOWNLOADS_TREE_URI) || (DocumentFileCompat.isRootUri(uri) && (((Build.VERSION.SDK_INT < 24 && fromStorageId == StorageType.SD_CARD) || Build.VERSION.SDK_INT == 29) && !DocumentFileCompat.isStorageUriPermissionGranted$default(getContext(), storageId, null, 4, null)))) {
            saveUriPermission(uri);
        }
        if ((Build.VERSION.SDK_INT < 29 && fromStorageId == StorageType.EXTERNAL) || ((Build.VERSION.SDK_INT >= 30 && saveUriPermission(uri)) || ((!UriExt.isExternalStorageDocument(uri) && DocumentFileExt.canModify(fromTreeUri, getContext())) || DocumentFileCompat.isStorageUriPermissionGranted$default(getContext(), storageId, null, 4, null)))) {
            FolderPickerCallback folderPickerCallback2 = this.folderPickerCallback;
            if (folderPickerCallback2 == null) {
                return;
            }
            folderPickerCallback2.onFolderSelected(i, fromTreeUri);
            return;
        }
        FolderPickerCallback folderPickerCallback3 = this.folderPickerCallback;
        if (folderPickerCallback3 == null) {
            return;
        }
        folderPickerCallback3.onStorageAccessDenied(i, fromTreeUri, fromStorageId);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
        if ((!r4.isEmpty()) != false) goto L4;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x005f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<androidx.documentfile.provider.DocumentFile> intentToDocumentFiles(android.content.Intent r10) {
        /*
            r9 = this;
            r0 = 1
            r1 = 0
            r2 = 0
            if (r10 != 0) goto L7
        L5:
            r4 = r2
            goto L3d
        L7:
            android.content.ClipData r3 = r10.getClipData()
            if (r3 != 0) goto Le
            goto L5
        Le:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List r4 = (java.util.List) r4
            int r5 = r3.getItemCount()
            if (r5 <= 0) goto L33
            r6 = 0
        L1c:
            int r7 = r6 + 1
            android.content.ClipData$Item r6 = r3.getItemAt(r6)
            android.net.Uri r6 = r6.getUri()
            java.lang.String r8 = "getItemAt(i).uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r8)
            r4.add(r6)
            if (r7 < r5) goto L31
            goto L33
        L31:
            r6 = r7
            goto L1c
        L33:
            r3 = r4
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r0
            if (r3 == 0) goto L5
        L3d:
            if (r4 != 0) goto L52
            if (r10 != 0) goto L43
            r10 = r2
            goto L47
        L43:
            android.net.Uri r10 = r10.getData()
        L47:
            if (r10 != 0) goto L4e
            java.util.List r10 = kotlin.collections.CollectionsKt.emptyList()
            return r10
        L4e:
            java.util.List r4 = kotlin.collections.CollectionsKt.listOf(r10)
        L52:
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Collection r10 = (java.util.Collection) r10
            java.util.Iterator r3 = r4.iterator()
        L5f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto Lb6
            java.lang.Object r4 = r3.next()
            android.net.Uri r4 = (android.net.Uri) r4
            java.lang.String r5 = "uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            boolean r5 = com.anggrayudi.storage.extension.UriExt.isDownloadsDocument(r4)
            if (r5 == 0) goto La8
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 28
            if (r5 >= r6) goto La8
            java.lang.String r5 = r4.getPath()
            r6 = 2
            java.lang.String r7 = "/document/raw:"
            if (r5 != 0) goto L88
        L86:
            r5 = 0
            goto L8f
        L88:
            boolean r5 = kotlin.text.StringsKt.startsWith$default(r5, r7, r1, r6, r2)
            if (r5 != r0) goto L86
            r5 = 1
        L8f:
            if (r5 == 0) goto La8
            java.lang.String r4 = r4.getPath()
            if (r4 == 0) goto L98
            goto L9a
        L98:
            java.lang.String r4 = ""
        L9a:
            java.lang.String r4 = kotlin.text.StringsKt.substringAfterLast$default(r4, r7, r2, r6, r2)
            java.io.File r5 = new java.io.File
            r5.<init>(r4)
            androidx.documentfile.provider.DocumentFile r4 = androidx.documentfile.provider.DocumentFile.fromFile(r5)
            goto Lb0
        La8:
            android.content.Context r5 = r9.getContext()
            androidx.documentfile.provider.DocumentFile r4 = com.anggrayudi.storage.extension.ContextExt.fromSingleUri(r5, r4)
        Lb0:
            if (r4 == 0) goto L5f
            r10.add(r4)
            goto L5f
        Lb6:
            java.util.List r10 = (java.util.List) r10
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r10 = r10.iterator()
        Lc5:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto Ldc
            java.lang.Object r1 = r10.next()
            r2 = r1
            androidx.documentfile.provider.DocumentFile r2 = (androidx.documentfile.provider.DocumentFile) r2
            boolean r2 = r2.isFile()
            if (r2 == 0) goto Lc5
            r0.add(r1)
            goto Lc5
        Ldc:
            java.util.List r0 = (java.util.List) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.SimpleStorage.intentToDocumentFiles(android.content.Intent):java.util.List");
    }

    public final void checkIfFileReceived(Intent intent) {
        String action = intent == null ? null : intent.getAction();
        boolean z = true;
        if (Intrinsics.areEqual(action, "android.intent.action.SEND") ? true : Intrinsics.areEqual(action, "android.intent.action.SEND_MULTIPLE")) {
            List<DocumentFile> intentToDocumentFiles = intentToDocumentFiles(intent);
            if (intentToDocumentFiles.isEmpty()) {
                FileReceiverCallback fileReceiverCallback = this.fileReceiverCallback;
                if (fileReceiverCallback == null) {
                    return;
                }
                fileReceiverCallback.onNonFileReceived(intent);
                return;
            }
            List<DocumentFile> list = intentToDocumentFiles;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (!((DocumentFile) it.next()).canRead()) {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                FileReceiverCallback fileReceiverCallback2 = this.fileReceiverCallback;
                if (fileReceiverCallback2 == null) {
                    return;
                }
                fileReceiverCallback2.onFileReceived(intentToDocumentFiles);
                return;
            }
            FileReceiverCallback fileReceiverCallback3 = this.fileReceiverCallback;
            if (fileReceiverCallback3 == null) {
                return;
            }
            fileReceiverCallback3.onStoragePermissionDenied(intentToDocumentFiles);
        }
    }

    private final void handleActivityResultForFilePicker(int i, Intent intent) {
        List<DocumentFile> intentToDocumentFiles = intentToDocumentFiles(intent);
        boolean z = true;
        if (!intentToDocumentFiles.isEmpty()) {
            List<DocumentFile> list = intentToDocumentFiles;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (!((DocumentFile) it.next()).canRead()) {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                FilePickerCallback filePickerCallback = this.filePickerCallback;
                if (filePickerCallback == null) {
                    return;
                }
                filePickerCallback.onFileSelected(i, intentToDocumentFiles);
                return;
            }
        }
        FilePickerCallback filePickerCallback2 = this.filePickerCallback;
        if (filePickerCallback2 == null) {
            return;
        }
        filePickerCallback2.onStoragePermissionDenied(i, intentToDocumentFiles);
    }

    private final void handleActivityResultForCreateFile(int i, Uri uri) {
        CreateFileCallback createFileCallback;
        DocumentFile fromUri = DocumentFileCompat.fromUri(getContext(), uri);
        if (fromUri == null || (createFileCallback = getCreateFileCallback()) == null) {
            return;
        }
        createFileCallback.onFileCreated(i, fromUri);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        Uri data;
        checkRequestCode();
        if (i == this.requestCodeStorageAccess) {
            if (i2 == -1) {
                data = intent != null ? intent.getData() : null;
                if (data == null) {
                    return;
                }
                handleActivityResultForStorageAccess(i, data);
                return;
            }
            StorageAccessCallback storageAccessCallback = this.storageAccessCallback;
            if (storageAccessCallback == null) {
                return;
            }
            storageAccessCallback.onCanceledByUser(i);
        } else if (i == this.requestCodeFolderPicker) {
            if (i2 == -1) {
                data = intent != null ? intent.getData() : null;
                if (data == null) {
                    return;
                }
                handleActivityResultForFolderPicker(i, data);
                return;
            }
            FolderPickerCallback folderPickerCallback = this.folderPickerCallback;
            if (folderPickerCallback == null) {
                return;
            }
            folderPickerCallback.onCanceledByUser(i);
        } else if (i == this.requestCodeFilePicker) {
            if (i2 == -1) {
                if (intent == null) {
                    return;
                }
                handleActivityResultForFilePicker(i, intent);
                return;
            }
            FilePickerCallback filePickerCallback = this.filePickerCallback;
            if (filePickerCallback == null) {
                return;
            }
            filePickerCallback.onCanceledByUser(i);
        } else if (i == this.requestCodeCreateFile) {
            data = intent != null ? intent.getData() : null;
            if (data != null) {
                handleActivityResultForCreateFile(i, data);
                return;
            }
            CreateFileCallback createFileCallback = this.createFileCallback;
            if (createFileCallback == null) {
                return;
            }
            createFileCallback.onCanceledByUser(i);
        }
    }

    public final void onSaveInstanceState(Bundle outState) {
        Integer requestCode;
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putInt(KEY_REQUEST_CODE_STORAGE_ACCESS, this.expectedStorageTypeForAccessRequest.ordinal());
        outState.putInt(KEY_REQUEST_CODE_STORAGE_ACCESS, this.requestCodeStorageAccess);
        outState.putInt(KEY_REQUEST_CODE_FOLDER_PICKER, this.requestCodeFolderPicker);
        outState.putInt(KEY_REQUEST_CODE_FILE_PICKER, this.requestCodeFilePicker);
        outState.putInt(KEY_REQUEST_CODE_CREATE_FILE, this.requestCodeCreateFile);
        ComponentWrapper componentWrapper = this.wrapper;
        if (!(componentWrapper instanceof FragmentWrapper) || (requestCode = ((FragmentWrapper) componentWrapper).getRequestCode()) == null) {
            return;
        }
        outState.putInt(KEY_REQUEST_CODE_FRAGMENT_PICKER, requestCode.intValue());
    }

    public final void onRestoreInstanceState(Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        this.expectedStorageTypeForAccessRequest = StorageType.values()[savedInstanceState.getInt(KEY_EXPECTED_STORAGE_TYPE_FOR_ACCESS_REQUEST)];
        setRequestCodeStorageAccess(savedInstanceState.getInt(KEY_REQUEST_CODE_STORAGE_ACCESS));
        setRequestCodeFolderPicker(savedInstanceState.getInt(KEY_REQUEST_CODE_FOLDER_PICKER));
        setRequestCodeFilePicker(savedInstanceState.getInt(KEY_REQUEST_CODE_FILE_PICKER));
        setRequestCodeCreateFile(savedInstanceState.getInt(KEY_REQUEST_CODE_CREATE_FILE));
        if ((this.wrapper instanceof FragmentWrapper) && savedInstanceState.containsKey(KEY_REQUEST_CODE_FRAGMENT_PICKER)) {
            ((FragmentWrapper) this.wrapper).setRequestCode(Integer.valueOf(savedInstanceState.getInt(KEY_REQUEST_CODE_FRAGMENT_PICKER)));
        }
    }

    private final void checkRequestCode() {
        if (SetsKt.mutableSetOf(Integer.valueOf(this.requestCodeFilePicker), Integer.valueOf(this.requestCodeFolderPicker), Integer.valueOf(this.requestCodeStorageAccess), Integer.valueOf(this.requestCodeCreateFile)).size() >= 4) {
            return;
        }
        throw new IllegalArgumentException("Request codes must be unique. File picker=" + this.requestCodeFilePicker + ", Folder picker=" + this.requestCodeFolderPicker + ", Storage access=" + this.requestCodeStorageAccess + ", Create file=" + this.requestCodeCreateFile);
    }

    private final boolean saveUriPermission(Uri uri) {
        try {
            getContext().getContentResolver().takePersistableUriPermission(uri, 3);
            Companion companion = Companion;
            Context applicationContext = getContext().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            companion.cleanupRedundantUriPermissions(applicationContext);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }

    /* compiled from: SimpleStorage.kt */
    @Metadata(m108d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0004H\u0007J\"\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u0014H\u0007J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0013\u0010\u0016¨\u0006\""}, m107d2 = {"Lcom/anggrayudi/storage/SimpleStorage$Companion;", "", "()V", "KEY_EXPECTED_STORAGE_TYPE_FOR_ACCESS_REQUEST", "", "KEY_REQUEST_CODE_CREATE_FILE", "KEY_REQUEST_CODE_FILE_PICKER", "KEY_REQUEST_CODE_FOLDER_PICKER", "KEY_REQUEST_CODE_FRAGMENT_PICKER", "KEY_REQUEST_CODE_STORAGE_ACCESS", "defaultExternalStorageIntent", "Landroid/content/Intent;", "getDefaultExternalStorageIntent$annotations", "getDefaultExternalStorageIntent", "()Landroid/content/Intent;", "externalStoragePath", "getExternalStoragePath$annotations", "getExternalStoragePath", "()Ljava/lang/String;", "isSdCardPresent", "", "isSdCardPresent$annotations", "()Z", "cleanupRedundantUriPermissions", "", "context", "Landroid/content/Context;", "hasFullDiskAccess", "storageId", "hasStorageAccess", "fullPath", "requiresWriteAccess", "hasStoragePermission", "hasStorageReadPermission", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getDefaultExternalStorageIntent$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getExternalStoragePath$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void isSdCardPresent$annotations() {
        }

        @JvmStatic
        public final boolean hasStorageAccess(Context context, String fullPath) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fullPath, "fullPath");
            return hasStorageAccess$default(this, context, fullPath, false, 4, null);
        }

        private Companion() {
        }

        public final String getExternalStoragePath() {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getExternalStorageDirectory().absolutePath");
            return absolutePath;
        }

        public final boolean isSdCardPresent() {
            return Intrinsics.areEqual(Environment.getExternalStorageState(), "mounted");
        }

        public final Intent getDefaultExternalStorageIntent() {
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (Build.VERSION.SDK_INT >= 26) {
                intent.putExtra("android.provider.extra.INITIAL_URI", DocumentFileCompat.createDocumentUri$default(StorageId.PRIMARY, null, 2, null));
            }
            return intent;
        }

        @JvmStatic
        public final boolean hasStoragePermission(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return ContextCompat.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && hasStorageReadPermission(context);
        }

        @JvmStatic
        public final boolean hasStorageReadPermission(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return ContextCompat.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE") == 0;
        }

        @JvmStatic
        public final boolean hasFullDiskAccess(Context context, String storageId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(storageId, "storageId");
            return hasStorageAccess$default(this, context, DocumentFileCompat.buildAbsolutePath(context, storageId, ""), false, 4, null);
        }

        public static /* synthetic */ boolean hasStorageAccess$default(Companion companion, Context context, String str, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = true;
            }
            return companion.hasStorageAccess(context, str, z);
        }

        @JvmStatic
        public final boolean hasStorageAccess(Context context, String fullPath, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fullPath, "fullPath");
            return ((z && hasStoragePermission(context)) || (!z && hasStorageReadPermission(context))) && DocumentFileCompat.getAccessibleRootDocumentFile$default(context, fullPath, z, false, 8, null) != null;
        }

        @JvmStatic
        public final void cleanupRedundantUriPermissions(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Thread.thread((r12 & 1) != 0, (r12 & 2) != 0 ? false : false, (r12 & 4) != 0 ? null : null, (r12 & 8) != 0 ? null : null, (r12 & 16) != 0 ? -1 : 0, new SimpleStorage$Companion$cleanupRedundantUriPermissions$1(context));
        }
    }
}
