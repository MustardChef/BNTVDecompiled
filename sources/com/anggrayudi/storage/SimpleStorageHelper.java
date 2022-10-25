package com.anggrayudi.storage;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AlertDialog;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.Fragment;
import com.anggrayudi.storage.SimpleStorageHelper;
import com.anggrayudi.storage.callback.CreateFileCallback;
import com.anggrayudi.storage.callback.FilePickerCallback;
import com.anggrayudi.storage.callback.FileReceiverCallback;
import com.anggrayudi.storage.file.StorageType;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleStorageHelper.kt */
@Metadata(m108d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ]2\u00020\u0001:\u0002]^B#\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u001b\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\nB\u001b\b\u0017\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\rJ&\u0010D\u001a\u00020\u00182\u0006\u0010E\u001a\u00020\u00102\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u0005H\u0007J\b\u0010G\u001a\u00020\u0018H\u0002J\u0012\u0010H\u001a\u00020\u00182\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J)\u0010I\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00052\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00100=2\u0006\u0010K\u001a\u00020L¢\u0006\u0002\u0010MJ\u000e\u0010N\u001a\u00020\u00182\u0006\u0010O\u001a\u00020\u0007J\u000e\u0010P\u001a\u00020\u00182\u0006\u0010Q\u001a\u00020\u0007J5\u0010R\u001a\u00020\u00182\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010S\u001a\u00020/2\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100=\"\u00020\u0010H\u0007¢\u0006\u0002\u0010TJ\u0012\u0010U\u001a\u00020\u00182\b\b\u0002\u0010\u0015\u001a\u00020\u0005H\u0007J&\u0010V\u001a\u00020\u00182\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010W\u001a\u00020X2\b\b\u0002\u0010Y\u001a\u00020XH\u0007J\u001c\u0010Z\u001a\u00020\u00182\u0012\u0010[\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00180.H\u0002J\b\u0010\\\u001a\u00020\u0018H\u0002R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0088\u0001\u0010\u0019\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001228\u0010\u0011\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0012@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u001e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0094\u0001\u0010&\u001a:\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00160$¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00122>\u0010\u0011\u001a:\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00160$¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0012@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001b\"\u0004\b(\u0010\u001dR\u0088\u0001\u0010*\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001228\u0010\u0011\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0012@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001dR\u001c\u0010-\u001a\u0010\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u0018\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000RL\u00100\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001b\"\u0004\b3\u0010\u001dR\u000e\u00104\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u0002068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00100=8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0011\u0010@\u001a\u00020A¢\u0006\b\n\u0000\u001a\u0004\bB\u0010C¨\u0006_"}, m107d2 = {"Lcom/anggrayudi/storage/SimpleStorageHelper;", "", "activity", "Landroid/app/Activity;", "requestCodeForPermissionDialog", "", "savedState", "Landroid/os/Bundle;", "(Landroid/app/Activity;ILandroid/os/Bundle;)V", "Landroidx/activity/ComponentActivity;", "(Landroidx/activity/ComponentActivity;Landroid/os/Bundle;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Landroid/os/Bundle;)V", "filterMimeTypes", "", "", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "requestCode", "Landroidx/documentfile/provider/DocumentFile;", "file", "", "onFileCreated", "getOnFileCreated", "()Lkotlin/jvm/functions/Function2;", "setOnFileCreated", "(Lkotlin/jvm/functions/Function2;)V", "Lcom/anggrayudi/storage/SimpleStorageHelper$OnFileReceived;", "onFileReceived", "getOnFileReceived", "()Lcom/anggrayudi/storage/SimpleStorageHelper$OnFileReceived;", "setOnFileReceived", "(Lcom/anggrayudi/storage/SimpleStorageHelper$OnFileReceived;)V", "", "files", "onFileSelected", "getOnFileSelected", "setOnFileSelected", "folder", "onFolderSelected", "getOnFolderSelected", "setOnFolderSelected", "onPermissionsResult", "Lkotlin/Function1;", "", "onStorageAccessGranted", "root", "getOnStorageAccessGranted", "setOnStorageAccessGranted", "originalRequestCode", "permissionCallback", "Lcom/anggrayudi/storage/permission/PermissionCallback;", "getPermissionCallback", "()Lcom/anggrayudi/storage/permission/PermissionCallback;", "permissionRequest", "Lcom/anggrayudi/storage/permission/PermissionRequest;", "pickerToOpenOnceGranted", "rwPermission", "", "getRwPermission", "()[Ljava/lang/String;", "storage", "Lcom/anggrayudi/storage/SimpleStorage;", "getStorage", "()Lcom/anggrayudi/storage/SimpleStorage;", "createFile", "mimeType", "fileName", "handleMissingActivityHandler", "init", "onRequestPermissionsResult", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "savedInstanceState", "onSaveInstanceState", "outState", "openFilePicker", "allowMultiple", "(IZ[Ljava/lang/String;)V", "openFolderPicker", "requestStorageAccess", "initialRootPath", "Lcom/anggrayudi/storage/file/StorageType;", "expectedStorageType", "requestStoragePermission", "onResult", "reset", "Companion", "OnFileReceived", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class SimpleStorageHelper {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_FILTER_MIME_TYPES = "com.anggrayudi.storage.filterMimeTypes";
    private static final String KEY_OPEN_FOLDER_PICKER_ONCE_GRANTED = "com.anggrayudi.storage.pickerToOpenOnceGranted";
    private static final String KEY_ORIGINAL_REQUEST_CODE = "com.anggrayudi.storage.originalRequestCode";
    public static final int TYPE_FILE_PICKER = 1;
    public static final int TYPE_FOLDER_PICKER = 2;
    private Set<String> filterMimeTypes;
    private Function2<? super Integer, ? super DocumentFile, Unit> onFileCreated;
    private OnFileReceived onFileReceived;
    private Function2<? super Integer, ? super List<? extends DocumentFile>, Unit> onFileSelected;
    private Function2<? super Integer, ? super DocumentFile, Unit> onFolderSelected;
    private Function1<? super Boolean, Unit> onPermissionsResult;
    private Function2<? super Integer, ? super DocumentFile, Unit> onStorageAccessGranted;
    private int originalRequestCode;
    private final PermissionRequest permissionRequest;
    private int pickerToOpenOnceGranted;
    private final SimpleStorage storage;

    /* compiled from: SimpleStorageHelper.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, m107d2 = {"Lcom/anggrayudi/storage/SimpleStorageHelper$OnFileReceived;", "", "onFileReceived", "", "files", "", "Landroidx/documentfile/provider/DocumentFile;", "onNonFileReceived", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes.dex */
    public interface OnFileReceived {

        /* compiled from: SimpleStorageHelper.kt */
        /* renamed from: com.anggrayudi.storage.SimpleStorageHelper$OnFileReceived$-CC  reason: invalid class name */
        /* loaded from: classes.dex */
        public final /* synthetic */ class CC {
        }

        void onFileReceived(List<? extends DocumentFile> list);

        void onNonFileReceived(Intent intent);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleStorageHelper(Activity activity, int i) {
        this(activity, i, null, 4, null);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleStorageHelper(ComponentActivity activity) {
        this(activity, (Bundle) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleStorageHelper(Fragment fragment) {
        this(fragment, (Bundle) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    @JvmStatic
    public static final void redirectToSystemSettings(Context context) {
        Companion.redirectToSystemSettings(context);
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

    public final SimpleStorage getStorage() {
        return this.storage;
    }

    public SimpleStorageHelper(Activity activity, int i, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.storage = new SimpleStorage(activity, (Bundle) null, 2, (DefaultConstructorMarker) null);
        init(bundle);
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder(activity, i);
        String[] rwPermission = getRwPermission();
        this.permissionRequest = builder.withPermissions((String[]) Arrays.copyOf(rwPermission, rwPermission.length)).withCallback(getPermissionCallback()).build();
    }

    public /* synthetic */ SimpleStorageHelper(Activity activity, int i, Bundle bundle, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, i, (i2 & 4) != 0 ? null : bundle);
    }

    public SimpleStorageHelper(ComponentActivity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.storage = new SimpleStorage(activity, (Bundle) null, 2, (DefaultConstructorMarker) null);
        init(bundle);
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder(activity);
        String[] rwPermission = getRwPermission();
        this.permissionRequest = builder.withPermissions((String[]) Arrays.copyOf(rwPermission, rwPermission.length)).withCallback(getPermissionCallback()).build();
    }

    public /* synthetic */ SimpleStorageHelper(ComponentActivity componentActivity, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(componentActivity, (i & 2) != 0 ? null : bundle);
    }

    public SimpleStorageHelper(Fragment fragment, Bundle bundle) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.storage = new SimpleStorage(fragment, (Bundle) null, 2, (DefaultConstructorMarker) null);
        init(bundle);
        FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(fragment);
        String[] rwPermission = getRwPermission();
        this.permissionRequest = builder.withPermissions((String[]) Arrays.copyOf(rwPermission, rwPermission.length)).withCallback(getPermissionCallback()).build();
    }

    public /* synthetic */ SimpleStorageHelper(Fragment fragment, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment, (i & 2) != 0 ? null : bundle);
    }

    public final Function2<Integer, DocumentFile, Unit> getOnStorageAccessGranted() {
        return this.onStorageAccessGranted;
    }

    public final void setOnStorageAccessGranted(Function2<? super Integer, ? super DocumentFile, Unit> function2) {
        this.onStorageAccessGranted = function2;
    }

    public final Function2<Integer, DocumentFile, Unit> getOnFolderSelected() {
        return this.onFolderSelected;
    }

    public final void setOnFolderSelected(Function2<? super Integer, ? super DocumentFile, Unit> function2) {
        this.onFolderSelected = function2;
        this.storage.setFolderPickerCallback(new SimpleStorageHelper$onFolderSelected$1(this, function2));
    }

    public final Function2<Integer, List<? extends DocumentFile>, Unit> getOnFileSelected() {
        return this.onFileSelected;
    }

    public final void setOnFileSelected(final Function2<? super Integer, ? super List<? extends DocumentFile>, Unit> function2) {
        this.onFileSelected = function2;
        this.storage.setFilePickerCallback(new FilePickerCallback() { // from class: com.anggrayudi.storage.SimpleStorageHelper$onFileSelected$1
            @Override // com.anggrayudi.storage.callback.FilePickerCallback
            public void onStoragePermissionDenied(int i, List<? extends DocumentFile> list) {
                SimpleStorageHelper simpleStorageHelper = SimpleStorageHelper.this;
                simpleStorageHelper.requestStoragePermission(new SimpleStorageHelper$onFileSelected$1$onStoragePermissionDenied$1(simpleStorageHelper));
            }

            @Override // com.anggrayudi.storage.callback.FilePickerCallback
            public void onFileSelected(int i, List<? extends DocumentFile> files) {
                Intrinsics.checkNotNullParameter(files, "files");
                SimpleStorageHelper.this.reset();
                Function2<Integer, List<? extends DocumentFile>, Unit> function22 = function2;
                if (function22 == null) {
                    return;
                }
                function22.invoke(Integer.valueOf(i), files);
            }

            @Override // com.anggrayudi.storage.callback.FilePickerCallback
            public void onCanceledByUser(int i) {
                SimpleStorageHelper.this.reset();
            }

            @Override // com.anggrayudi.storage.callback.FilePickerCallback
            public void onActivityHandlerNotFound(int i, Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                SimpleStorageHelper.this.handleMissingActivityHandler();
            }
        });
    }

    public final Function2<Integer, DocumentFile, Unit> getOnFileCreated() {
        return this.onFileCreated;
    }

    public final void setOnFileCreated(final Function2<? super Integer, ? super DocumentFile, Unit> function2) {
        this.onFileCreated = function2;
        this.storage.setCreateFileCallback(new CreateFileCallback() { // from class: com.anggrayudi.storage.SimpleStorageHelper$onFileCreated$1
            @Override // com.anggrayudi.storage.callback.CreateFileCallback
            public void onCanceledByUser(int i) {
                SimpleStorageHelper.this.reset();
            }

            @Override // com.anggrayudi.storage.callback.CreateFileCallback
            public void onActivityHandlerNotFound(int i, Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                SimpleStorageHelper.this.handleMissingActivityHandler();
            }

            @Override // com.anggrayudi.storage.callback.CreateFileCallback
            public void onFileCreated(int i, DocumentFile file) {
                Intrinsics.checkNotNullParameter(file, "file");
                SimpleStorageHelper.this.reset();
                Function2<Integer, DocumentFile, Unit> function22 = function2;
                if (function22 == null) {
                    return;
                }
                function22.invoke(Integer.valueOf(i), file);
            }
        });
    }

    public final OnFileReceived getOnFileReceived() {
        return this.onFileReceived;
    }

    public final void setOnFileReceived(final OnFileReceived onFileReceived) {
        this.onFileReceived = onFileReceived;
        this.storage.setFileReceiverCallback(new FileReceiverCallback() { // from class: com.anggrayudi.storage.SimpleStorageHelper$onFileReceived$1
            @Override // com.anggrayudi.storage.callback.FileReceiverCallback
            public void onFileReceived(List<? extends DocumentFile> files) {
                Intrinsics.checkNotNullParameter(files, "files");
                SimpleStorageHelper.OnFileReceived onFileReceived2 = SimpleStorageHelper.OnFileReceived.this;
                if (onFileReceived2 == null) {
                    return;
                }
                onFileReceived2.onFileReceived(files);
            }

            @Override // com.anggrayudi.storage.callback.FileReceiverCallback
            public void onNonFileReceived(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                SimpleStorageHelper.OnFileReceived onFileReceived2 = SimpleStorageHelper.OnFileReceived.this;
                if (onFileReceived2 == null) {
                    return;
                }
                onFileReceived2.onNonFileReceived(intent);
            }

            @Override // com.anggrayudi.storage.callback.FileReceiverCallback
            public void onStoragePermissionDenied(List<? extends DocumentFile> files) {
                Intrinsics.checkNotNullParameter(files, "files");
                SimpleStorageHelper simpleStorageHelper = this;
                simpleStorageHelper.requestStoragePermission(new SimpleStorageHelper$onFileReceived$1$onStoragePermissionDenied$1(SimpleStorageHelper.OnFileReceived.this, files, simpleStorageHelper));
            }
        });
    }

    private final void init(Bundle bundle) {
        if (bundle != null) {
            onRestoreInstanceState(bundle);
        }
        this.storage.setStorageAccessCallback(new SimpleStorageHelper$init$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestStoragePermission(Function1<? super Boolean, Unit> function1) {
        this.onPermissionsResult = function1;
        this.permissionRequest.check();
    }

    public final void onRequestPermissionsResult(int i, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        PermissionRequest permissionRequest = this.permissionRequest;
        if (permissionRequest instanceof ActivityPermissionRequest) {
            ((ActivityPermissionRequest) permissionRequest).onRequestPermissionsResult(i, permissions, grantResults);
        }
    }

    private final PermissionCallback getPermissionCallback() {
        return new PermissionCallback() { // from class: com.anggrayudi.storage.SimpleStorageHelper$permissionCallback$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.$default$onDisplayConsentDialog(this, permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public void onPermissionsChecked(PermissionResult result, boolean z) {
                Function1 function1;
                Intrinsics.checkNotNullParameter(result, "result");
                boolean areAllPermissionsGranted = result.getAreAllPermissionsGranted();
                if (!areAllPermissionsGranted) {
                    Toast.makeText(SimpleStorageHelper.this.getStorage().getContext(), C1077R.string.ss_please_grant_storage_permission, 0).show();
                }
                function1 = SimpleStorageHelper.this.onPermissionsResult;
                if (function1 != null) {
                    function1.invoke(Boolean.valueOf(areAllPermissionsGranted));
                }
                SimpleStorageHelper.this.onPermissionsResult = null;
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public void onShouldRedirectToSystemSettings(List<PermissionReport> blockedPermissions) {
                Function1 function1;
                Intrinsics.checkNotNullParameter(blockedPermissions, "blockedPermissions");
                SimpleStorageHelper.Companion.redirectToSystemSettings(SimpleStorageHelper.this.getStorage().getContext());
                function1 = SimpleStorageHelper.this.onPermissionsResult;
                if (function1 != null) {
                    function1.invoke(false);
                }
                SimpleStorageHelper.this.onPermissionsResult = null;
            }
        };
    }

    private final String[] getRwPermission() {
        return new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reset() {
        this.pickerToOpenOnceGranted = 0;
        this.originalRequestCode = 0;
        this.filterMimeTypes = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleMissingActivityHandler() {
        reset();
        Toast.makeText(this.storage.getContext(), C1077R.string.ss_missing_saf_activity_handler, 0).show();
    }

    public static /* synthetic */ void openFolderPicker$default(SimpleStorageHelper simpleStorageHelper, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = simpleStorageHelper.storage.getRequestCodeFolderPicker();
        }
        simpleStorageHelper.openFolderPicker(i);
    }

    public final void openFolderPicker(int i) {
        this.pickerToOpenOnceGranted = 2;
        this.originalRequestCode = i;
        this.storage.openFolderPicker(i);
    }

    public static /* synthetic */ void openFilePicker$default(SimpleStorageHelper simpleStorageHelper, int i, boolean z, String[] strArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = simpleStorageHelper.storage.getRequestCodeFilePicker();
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        simpleStorageHelper.openFilePicker(i, z, strArr);
    }

    public final void openFilePicker(int i, boolean z, String... filterMimeTypes) {
        Intrinsics.checkNotNullParameter(filterMimeTypes, "filterMimeTypes");
        this.pickerToOpenOnceGranted = 1;
        this.originalRequestCode = i;
        Set<String> set = ArraysKt.toSet(filterMimeTypes);
        this.filterMimeTypes = set;
        SimpleStorage storage = getStorage();
        Object[] array = set.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        String[] strArr = (String[]) array;
        storage.openFilePicker(i, z, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static /* synthetic */ void requestStorageAccess$default(SimpleStorageHelper simpleStorageHelper, int i, StorageType storageType, StorageType storageType2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = simpleStorageHelper.storage.getRequestCodeStorageAccess();
        }
        if ((i2 & 2) != 0) {
            storageType = StorageType.EXTERNAL;
        }
        if ((i2 & 4) != 0) {
            storageType2 = StorageType.UNKNOWN;
        }
        simpleStorageHelper.requestStorageAccess(i, storageType, storageType2);
    }

    public final void requestStorageAccess(int i, StorageType initialRootPath, StorageType expectedStorageType) {
        Intrinsics.checkNotNullParameter(initialRootPath, "initialRootPath");
        Intrinsics.checkNotNullParameter(expectedStorageType, "expectedStorageType");
        this.pickerToOpenOnceGranted = 0;
        this.originalRequestCode = i;
        this.storage.requestStorageAccess(i, initialRootPath, expectedStorageType);
    }

    public static /* synthetic */ void createFile$default(SimpleStorageHelper simpleStorageHelper, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            i = simpleStorageHelper.storage.getRequestCodeCreateFile();
        }
        simpleStorageHelper.createFile(str, str2, i);
    }

    public final void createFile(String mimeType, String str, int i) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        this.pickerToOpenOnceGranted = 0;
        this.originalRequestCode = i;
        this.storage.createFile(mimeType, str, i);
    }

    public final void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        this.storage.onSaveInstanceState(outState);
        outState.putInt(KEY_ORIGINAL_REQUEST_CODE, this.originalRequestCode);
        outState.putInt(KEY_OPEN_FOLDER_PICKER_ONCE_GRANTED, this.pickerToOpenOnceGranted);
        Set<String> set = this.filterMimeTypes;
        if (set == null) {
            return;
        }
        Object[] array = set.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        outState.putStringArray(KEY_FILTER_MIME_TYPES, (String[]) array);
    }

    public final void onRestoreInstanceState(Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        this.storage.onRestoreInstanceState(savedInstanceState);
        this.originalRequestCode = savedInstanceState.getInt(KEY_ORIGINAL_REQUEST_CODE);
        this.pickerToOpenOnceGranted = savedInstanceState.getInt(KEY_OPEN_FOLDER_PICKER_ONCE_GRANTED);
        String[] stringArray = savedInstanceState.getStringArray(KEY_FILTER_MIME_TYPES);
        this.filterMimeTypes = stringArray == null ? null : ArraysKt.toSet(stringArray);
    }

    /* compiled from: SimpleStorageHelper.kt */
    @Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m107d2 = {"Lcom/anggrayudi/storage/SimpleStorageHelper$Companion;", "", "()V", "KEY_FILTER_MIME_TYPES", "", "KEY_OPEN_FOLDER_PICKER_ONCE_GRANTED", "KEY_ORIGINAL_REQUEST_CODE", "TYPE_FILE_PICKER", "", "TYPE_FOLDER_PICKER", "redirectToSystemSettings", "", "context", "Landroid/content/Context;", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: redirectToSystemSettings$lambda-0  reason: not valid java name */
        public static final void m8546redirectToSystemSettings$lambda0(DialogInterface dialogInterface, int i) {
        }

        private Companion() {
        }

        @JvmStatic
        public final void redirectToSystemSettings(final Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            new AlertDialog.Builder(context).setMessage(C1077R.string.ss_storage_permission_permanently_disabled).setNegativeButton(17039360, DialogInterface$OnClickListenerC1074x7817720b.INSTANCE).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.anggrayudi.storage.-$$Lambda$SimpleStorageHelper$Companion$A0_4NGa39nsHCK5B6OqRrEY94rI
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SimpleStorageHelper.Companion.m8547redirectToSystemSettings$lambda1(context, dialogInterface, i);
                }
            }).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: redirectToSystemSettings$lambda-1  reason: not valid java name */
        public static final void m8547redirectToSystemSettings$lambda1(Context context, DialogInterface dialogInterface, int i) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intent flags = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(Intrinsics.stringPlus("package:", context.getPackageName()))).addCategory("android.intent.category.DEFAULT").setFlags(268435456);
            Intrinsics.checkNotNullExpressionValue(flags, "Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse(\"package:${context.packageName}\"))\n                        .addCategory(Intent.CATEGORY_DEFAULT)\n                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)");
            context.startActivity(flags);
        }
    }
}
