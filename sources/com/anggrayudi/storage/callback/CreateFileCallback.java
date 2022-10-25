package com.anggrayudi.storage.callback;

import android.content.Intent;
import androidx.documentfile.provider.DocumentFile;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;

/* compiled from: CreateFileCallback.kt */
@Metadata(m108d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, m107d2 = {"Lcom/anggrayudi/storage/callback/CreateFileCallback;", "", "onActivityHandlerNotFound", "", "requestCode", "", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "onCanceledByUser", "onFileCreated", "file", "Landroidx/documentfile/provider/DocumentFile;", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public interface CreateFileCallback {

    /* compiled from: CreateFileCallback.kt */
    /* renamed from: com.anggrayudi.storage.callback.CreateFileCallback$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public final /* synthetic */ class CC {
        public static void $default$onCanceledByUser(CreateFileCallback createFileCallback, int i) {
        }
    }

    void onActivityHandlerNotFound(int i, Intent intent);

    void onCanceledByUser(int i);

    void onFileCreated(int i, DocumentFile documentFile);
}
