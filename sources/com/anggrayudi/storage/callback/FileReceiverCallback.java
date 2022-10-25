package com.anggrayudi.storage.callback;

import android.content.Intent;
import androidx.documentfile.provider.DocumentFile;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.Metadata;

/* compiled from: FileReceiverCallback.kt */
@Metadata(m108d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0016\u0010\n\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, m107d2 = {"Lcom/anggrayudi/storage/callback/FileReceiverCallback;", "", "onFileReceived", "", "files", "", "Landroidx/documentfile/provider/DocumentFile;", "onNonFileReceived", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "onStoragePermissionDenied", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public interface FileReceiverCallback {
    void onFileReceived(List<? extends DocumentFile> list);

    void onNonFileReceived(Intent intent);

    void onStoragePermissionDenied(List<? extends DocumentFile> list);
}
