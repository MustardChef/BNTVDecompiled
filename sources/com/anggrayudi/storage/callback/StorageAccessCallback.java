package com.anggrayudi.storage.callback;

import android.content.Intent;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.file.StorageType;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;

/* compiled from: StorageAccessCallback.kt */
@Metadata(m108d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J0\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, m107d2 = {"Lcom/anggrayudi/storage/callback/StorageAccessCallback;", "", "onActivityHandlerNotFound", "", "requestCode", "", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "onCanceledByUser", "onRootPathNotSelected", "rootPath", "", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "selectedStorageType", "Lcom/anggrayudi/storage/file/StorageType;", "expectedStorageType", "onRootPathPermissionGranted", "root", "Landroidx/documentfile/provider/DocumentFile;", "onStoragePermissionDenied", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public interface StorageAccessCallback {

    /* compiled from: StorageAccessCallback.kt */
    /* renamed from: com.anggrayudi.storage.callback.StorageAccessCallback$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public final /* synthetic */ class CC {
        public static void $default$onCanceledByUser(StorageAccessCallback storageAccessCallback, int i) {
        }
    }

    void onActivityHandlerNotFound(int i, Intent intent);

    void onCanceledByUser(int i);

    void onRootPathNotSelected(int i, String str, Uri uri, StorageType storageType, StorageType storageType2);

    void onRootPathPermissionGranted(int i, DocumentFile documentFile);

    void onStoragePermissionDenied(int i);
}
