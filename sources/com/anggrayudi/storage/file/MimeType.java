package com.anggrayudi.storage.file;

import android.webkit.MimeTypeMap;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: MimeType.kt */
@Metadata(m108d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m107d2 = {"Lcom/anggrayudi/storage/file/MimeType;", "", "()V", "APPLICATION", "", "AUDIO", "BINARY_FILE", "CHEMICAL", "FONT", ShareConstants.IMAGE_URL, "MODEL", "TEXT", "UNKNOWN", ShareConstants.VIDEO_URL, "getExtensionFromMimeType", "mimeType", "getExtensionFromMimeTypeOrFileName", "filename", "getFullFileName", "name", "getMimeTypeFromExtension", "fileExtension", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class MimeType {
    public static final String APPLICATION = "application/*";
    public static final String AUDIO = "audio/*";
    public static final String BINARY_FILE = "application/octet-stream";
    public static final String CHEMICAL = "chemical/*";
    public static final String FONT = "font/*";
    public static final String IMAGE = "image/*";
    public static final MimeType INSTANCE = new MimeType();
    public static final String MODEL = "model/*";
    public static final String TEXT = "text/*";
    public static final String UNKNOWN = "*/*";
    public static final String VIDEO = "video/*";

    private MimeType() {
    }

    @JvmStatic
    public static final String getFullFileName(String name, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        String extensionFromMimeType = getExtensionFromMimeType(str);
        if ((extensionFromMimeType.length() == 0) || StringsKt.endsWith$default(name, Intrinsics.stringPlus(".", extensionFromMimeType), false, 2, (Object) null)) {
            return name;
        }
        return StringsKt.trimEnd(name + '.' + extensionFromMimeType, '.');
    }

    @JvmStatic
    public static final String getExtensionFromMimeType(String str) {
        String extensionFromMimeType;
        if (str == null) {
            extensionFromMimeType = null;
        } else {
            extensionFromMimeType = Intrinsics.areEqual(str, BINARY_FILE) ? "bin" : MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        }
        return extensionFromMimeType != null ? extensionFromMimeType : "";
    }

    @JvmStatic
    public static final String getExtensionFromMimeTypeOrFileName(String str, String filename) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        return (str == null || Intrinsics.areEqual(str, UNKNOWN)) ? StringsKt.substringAfterLast(filename, '.', "") : getExtensionFromMimeType(str);
    }

    @JvmStatic
    public static final String getMimeTypeFromExtension(String fileExtension) {
        Intrinsics.checkNotNullParameter(fileExtension, "fileExtension");
        if (Intrinsics.areEqual(fileExtension, "bin")) {
            return BINARY_FILE;
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtension);
        return mimeTypeFromExtension == null ? UNKNOWN : mimeTypeFromExtension;
    }
}
