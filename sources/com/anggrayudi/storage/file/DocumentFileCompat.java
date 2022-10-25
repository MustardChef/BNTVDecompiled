package com.anggrayudi.storage.file;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriPermission;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.StatFs;
import android.system.Os;
import android.system.StructStatVfs;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.SimpleStorage;
import com.anggrayudi.storage.extension.ContextExt;
import com.anggrayudi.storage.extension.TextExt;
import com.anggrayudi.storage.extension.UriExt;
import com.anggrayudi.storage.media.FileDescription;
import com.anggrayudi.storage.media.MediaFile;
import com.anggrayudi.storage.media.MediaStoreCompat;
import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p043io.Closeable;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: DocumentFileCompat.kt */
@Metadata(m108d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0004H\u0007J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u001dH\u0007J8\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\u0017H\u0007J\u001a\u0010\"\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u001dH\u0007J\u0018\u0010#\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0004H\u0007J\u0018\u0010%\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0004H\u0007J:\u0010&\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0017H\u0002J$\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040+2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040+H\u0007J$\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040+2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040/H\u0007J$\u00100\u001a\b\u0012\u0004\u0012\u00020\u00040+2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040/H\u0007J8\u00101\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\u0017H\u0007J8\u00102\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00042\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\u0017H\u0007J8\u00103\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\u0017H\u0007JD\u00107\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\u0017H\u0007J\u001a\u00108\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u00109\u001a\u00020\u001bH\u0007J.\u0010:\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\u0017H\u0007J\u0018\u0010;\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0004H\u0007J\u001b\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00040+2\u0006\u0010=\u001a\u00020\u0004H\u0000¢\u0006\u0002\b>J\u001a\u0010?\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010@\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0004H\u0002J\u0010\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u0004H\u0007J\u0018\u0010C\u001a\u00020D2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0012\u0010E\u001a\u0004\u0018\u00010\u00042\u0006\u0010=\u001a\u00020\u0004H\u0002J.\u0010F\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\u0017H\u0007J$\u0010G\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u0017H\u0007J\u0016\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00040+2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010I\u001a\u00020D2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0018\u0010J\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0004H\u0007J\u0016\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00040+2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010L\u001a\u00020D2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0018\u0010M\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0010\u0010N\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010O\u001a\u00020\u00172\u0006\u00109\u001a\u00020\u001bH\u0007J\"\u0010P\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0004H\u0007J.\u0010Q\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\u0017H\u0007J?\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0R2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040+2\b\b\u0002\u0010)\u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010SJ*\u0010T\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0017H\u0002J8\u0010U\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\u0017H\u0007J\u0011\u0010V\u001a\u00020\u0004*\u00020\u0004H\u0000¢\u0006\u0002\bWR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006X"}, m107d2 = {"Lcom/anggrayudi/storage/file/DocumentFileCompat;", "", "()V", "DOWNLOADS_FOLDER_AUTHORITY", "", "DOWNLOADS_TREE_URI", "EXTERNAL_STORAGE_AUTHORITY", "FILE_NAME_DUPLICATION_REGEX_WITHOUT_EXTENSION", "Lkotlin/text/Regex;", "getFILE_NAME_DUPLICATION_REGEX_WITHOUT_EXTENSION", "()Lkotlin/text/Regex;", "FILE_NAME_DUPLICATION_REGEX_WITH_EXTENSION", "getFILE_NAME_DUPLICATION_REGEX_WITH_EXTENSION", "MEDIA_FOLDER_AUTHORITY", "buildAbsolutePath", "context", "Landroid/content/Context;", "simplePath", "storageId", "basePath", "buildSimplePath", "absolutePath", "create", "", "file", "Ljava/io/File;", "createDocumentUri", "Landroid/net/Uri;", "createDownloadWithMediaStoreFallback", "Lcom/anggrayudi/storage/media/FileDescription;", "createFile", "Landroidx/documentfile/provider/DocumentFile;", "mimeType", "considerRawFile", "createPictureWithMediaStoreFallback", "delete", "fullPath", "doesExist", "exploreFile", "documentType", "Lcom/anggrayudi/storage/file/DocumentFileType;", "requiresWriteAccess", "findInaccessibleStorageLocations", "", "fullPaths", "findUniqueDeepestSubFolders", "folderFullPaths", "", "findUniqueParents", "fromFile", "fromFullPath", "fromPublicFolder", "type", "Lcom/anggrayudi/storage/file/PublicDirectory;", "subFile", "fromSimplePath", "fromUri", ShareConstants.MEDIA_URI, "getAccessibleRootDocumentFile", "getBasePath", "getDirectorySequence", "path", "getDirectorySequence$storage_release", "getDocumentFileForStorageInfo", "getFileNameFromPath", "getFileNameFromUrl", "url", "getFreeSpace", "", "getParentPath", "getRootDocumentFile", "getRootRawFile", "getSdCardIds", "getStorageCapacity", "getStorageId", "getStorageIds", "getUsedSpace", "isAccessGranted", "isDownloadsUriPermissionGranted", "isRootUri", "isStorageUriPermissionGranted", "mkdirs", "", "(Landroid/content/Context;Ljava/util/List;ZZ)[Landroidx/documentfile/provider/DocumentFile;", "mkdirsParentDirectory", "recreate", "removeForbiddenCharsFromFilename", "removeForbiddenCharsFromFilename$storage_release", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class DocumentFileCompat {
    public static final String DOWNLOADS_FOLDER_AUTHORITY = "com.android.providers.downloads.documents";
    public static final String DOWNLOADS_TREE_URI = "content://com.android.providers.downloads.documents/tree/downloads";
    public static final String EXTERNAL_STORAGE_AUTHORITY = "com.android.externalstorage.documents";
    public static final String MEDIA_FOLDER_AUTHORITY = "com.android.providers.media.documents";
    public static final DocumentFileCompat INSTANCE = new DocumentFileCompat();
    private static final Regex FILE_NAME_DUPLICATION_REGEX_WITH_EXTENSION = new Regex("(.*?) \\(\\d+\\)\\.[a-zA-Z0-9]+");
    private static final Regex FILE_NAME_DUPLICATION_REGEX_WITHOUT_EXTENSION = new Regex("(.*?) \\(\\d+\\)");

    @JvmStatic
    public static final Uri createDocumentUri(String storageId) {
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        return createDocumentUri$default(storageId, null, 2, null);
    }

    @JvmStatic
    public static final DocumentFile createFile(Context context, String basePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(basePath, "basePath");
        return createFile$default(context, null, basePath, null, false, 26, null);
    }

    @JvmStatic
    public static final DocumentFile createFile(Context context, String storageId, String basePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        Intrinsics.checkNotNullParameter(basePath, "basePath");
        return createFile$default(context, storageId, basePath, null, false, 24, null);
    }

    @JvmStatic
    public static final DocumentFile createFile(Context context, String storageId, String basePath, String mimeType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        Intrinsics.checkNotNullParameter(basePath, "basePath");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        return createFile$default(context, storageId, basePath, mimeType, false, 16, null);
    }

    @JvmStatic
    public static final DocumentFile fromFile(Context context, File file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        return fromFile$default(context, file, null, false, false, 28, null);
    }

    @JvmStatic
    public static final DocumentFile fromFile(Context context, File file, DocumentFileType documentType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        return fromFile$default(context, file, documentType, false, false, 24, null);
    }

    @JvmStatic
    public static final DocumentFile fromFile(Context context, File file, DocumentFileType documentType, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        return fromFile$default(context, file, documentType, z, false, 16, null);
    }

    @JvmStatic
    public static final DocumentFile fromFullPath(Context context, String fullPath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fullPath, "fullPath");
        return fromFullPath$default(context, fullPath, null, false, false, 28, null);
    }

    @JvmStatic
    public static final DocumentFile fromFullPath(Context context, String fullPath, DocumentFileType documentType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fullPath, "fullPath");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        return fromFullPath$default(context, fullPath, documentType, false, false, 24, null);
    }

    @JvmStatic
    public static final DocumentFile fromFullPath(Context context, String fullPath, DocumentFileType documentType, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fullPath, "fullPath");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        return fromFullPath$default(context, fullPath, documentType, z, false, 16, null);
    }

    @JvmStatic
    public static final DocumentFile fromPublicFolder(Context context, PublicDirectory type) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(type, "type");
        return fromPublicFolder$default(context, type, null, false, false, 28, null);
    }

    @JvmStatic
    public static final DocumentFile fromPublicFolder(Context context, PublicDirectory type, String subFile) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(subFile, "subFile");
        return fromPublicFolder$default(context, type, subFile, false, false, 24, null);
    }

    @JvmStatic
    public static final DocumentFile fromPublicFolder(Context context, PublicDirectory type, String subFile, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(subFile, "subFile");
        return fromPublicFolder$default(context, type, subFile, z, false, 16, null);
    }

    @JvmStatic
    public static final DocumentFile fromSimplePath(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return fromSimplePath$default(context, null, null, null, false, false, 62, null);
    }

    @JvmStatic
    public static final DocumentFile fromSimplePath(Context context, String storageId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        return fromSimplePath$default(context, storageId, null, null, false, false, 60, null);
    }

    @JvmStatic
    public static final DocumentFile fromSimplePath(Context context, String storageId, String basePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        Intrinsics.checkNotNullParameter(basePath, "basePath");
        return fromSimplePath$default(context, storageId, basePath, null, false, false, 56, null);
    }

    @JvmStatic
    public static final DocumentFile fromSimplePath(Context context, String storageId, String basePath, DocumentFileType documentType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        Intrinsics.checkNotNullParameter(basePath, "basePath");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        return fromSimplePath$default(context, storageId, basePath, documentType, false, false, 48, null);
    }

    @JvmStatic
    public static final DocumentFile fromSimplePath(Context context, String storageId, String basePath, DocumentFileType documentType, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        Intrinsics.checkNotNullParameter(basePath, "basePath");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        return fromSimplePath$default(context, storageId, basePath, documentType, z, false, 32, null);
    }

    @JvmStatic
    public static final DocumentFile getAccessibleRootDocumentFile(Context context, String fullPath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fullPath, "fullPath");
        return getAccessibleRootDocumentFile$default(context, fullPath, false, false, 12, null);
    }

    @JvmStatic
    public static final DocumentFile getAccessibleRootDocumentFile(Context context, String fullPath, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fullPath, "fullPath");
        return getAccessibleRootDocumentFile$default(context, fullPath, z, false, 8, null);
    }

    @JvmStatic
    public static final DocumentFile getRootDocumentFile(Context context, String storageId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        return getRootDocumentFile$default(context, storageId, false, false, 12, null);
    }

    @JvmStatic
    public static final DocumentFile getRootDocumentFile(Context context, String storageId, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        return getRootDocumentFile$default(context, storageId, z, false, 8, null);
    }

    @JvmStatic
    public static final File getRootRawFile(Context context, String storageId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        return getRootRawFile$default(context, storageId, false, 4, null);
    }

    @JvmStatic
    public static final boolean isStorageUriPermissionGranted(Context context, String storageId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        return isStorageUriPermissionGranted$default(context, storageId, null, 4, null);
    }

    @JvmStatic
    public static final DocumentFile mkdirs(Context context, String fullPath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fullPath, "fullPath");
        return mkdirs$default(context, fullPath, false, false, 12, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile mkdirs(Context context, String fullPath, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fullPath, "fullPath");
        return mkdirs$default(context, fullPath, z, false, 8, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile[] mkdirs(Context context, List<String> fullPaths) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fullPaths, "fullPaths");
        return mkdirs$default(context, (List) fullPaths, false, false, 12, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile[] mkdirs(Context context, List<String> fullPaths, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fullPaths, "fullPaths");
        return mkdirs$default(context, (List) fullPaths, z, false, 8, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile recreate(Context context, String basePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(basePath, "basePath");
        return recreate$default(context, null, basePath, null, false, 26, null);
    }

    @JvmStatic
    public static final DocumentFile recreate(Context context, String storageId, String basePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        Intrinsics.checkNotNullParameter(basePath, "basePath");
        return recreate$default(context, storageId, basePath, null, false, 24, null);
    }

    @JvmStatic
    public static final DocumentFile recreate(Context context, String storageId, String basePath, String mimeType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        Intrinsics.checkNotNullParameter(basePath, "basePath");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        return recreate$default(context, storageId, basePath, mimeType, false, 16, null);
    }

    private DocumentFileCompat() {
    }

    public final Regex getFILE_NAME_DUPLICATION_REGEX_WITH_EXTENSION() {
        return FILE_NAME_DUPLICATION_REGEX_WITH_EXTENSION;
    }

    public final Regex getFILE_NAME_DUPLICATION_REGEX_WITHOUT_EXTENSION() {
        return FILE_NAME_DUPLICATION_REGEX_WITHOUT_EXTENSION;
    }

    @JvmStatic
    public static final boolean isRootUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String path = uri.getPath();
        return path != null && UriExt.isExternalStorageDocument(uri) && StringsKt.indexOf$default((CharSequence) path, ':', 0, false, 6, (Object) null) == path.length() - 1;
    }

    @JvmStatic
    public static final String getStorageId(Context context, String fullPath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fullPath, "fullPath");
        if (StringsKt.startsWith$default((CharSequence) fullPath, (char) JsonPointer.SEPARATOR, false, 2, (Object) null)) {
            if (StringsKt.startsWith$default(fullPath, SimpleStorage.Companion.getExternalStoragePath(), false, 2, (Object) null)) {
                return StorageId.PRIMARY;
            }
            String path = FileExt.getDataDirectory(context).getPath();
            Intrinsics.checkNotNullExpressionValue(path, "context.dataDirectory.path");
            return StringsKt.startsWith$default(fullPath, path, false, 2, (Object) null) ? "data" : StringsKt.substringBefore$default(StringsKt.substringAfter(fullPath, "/storage/", ""), (char) JsonPointer.SEPARATOR, (String) null, 2, (Object) null);
        }
        return StringsKt.substringAfterLast$default(StringsKt.substringBefore(fullPath, ':', ""), (char) JsonPointer.SEPARATOR, (String) null, 2, (Object) null);
    }

    @JvmStatic
    public static final String getBasePath(Context context, String fullPath) {
        String substringAfter;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fullPath, "fullPath");
        if (StringsKt.startsWith$default((CharSequence) fullPath, (char) JsonPointer.SEPARATOR, false, 2, (Object) null)) {
            String dataDir = FileExt.getDataDirectory(context).getPath();
            String externalStoragePath = SimpleStorage.Companion.getExternalStoragePath();
            if (StringsKt.startsWith$default(fullPath, externalStoragePath, false, 2, (Object) null)) {
                substringAfter = StringsKt.substringAfter$default(fullPath, externalStoragePath, (String) null, 2, (Object) null);
            } else {
                Intrinsics.checkNotNullExpressionValue(dataDir, "dataDir");
                substringAfter = StringsKt.startsWith$default(fullPath, dataDir, false, 2, (Object) null) ? StringsKt.substringAfter$default(fullPath, dataDir, (String) null, 2, (Object) null) : StringsKt.substringAfter(StringsKt.substringAfter(fullPath, "/storage/", ""), (char) JsonPointer.SEPARATOR, "");
            }
        } else {
            substringAfter = StringsKt.substringAfter(fullPath, ':', "");
        }
        return INSTANCE.removeForbiddenCharsFromFilename$storage_release(TextExt.trimFileSeparator(substringAfter));
    }

    @JvmStatic
    public static final DocumentFile fromUri(Context context, Uri uri) {
        DocumentFile writableDownloadsDocumentFile;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (UriExt.isRawFile(uri)) {
            String path = uri.getPath();
            if (path == null) {
                return null;
            }
            File file = new File(path);
            if (!file.canRead()) {
                return null;
            }
            writableDownloadsDocumentFile = DocumentFile.fromFile(file);
        } else if (!UriExt.isTreeDocumentFile(uri)) {
            return ContextExt.fromSingleUri(context, uri);
        } else {
            DocumentFile fromTreeUri = ContextExt.fromTreeUri(context, uri);
            if (fromTreeUri == null) {
                return null;
            }
            if (!DocumentFileExt.isDownloadsDocument(fromTreeUri)) {
                return fromTreeUri;
            }
            writableDownloadsDocumentFile = DocumentFileExt.toWritableDownloadsDocumentFile(fromTreeUri, context);
        }
        return writableDownloadsDocumentFile;
    }

    public static /* synthetic */ DocumentFile fromSimplePath$default(Context context, String str, String str2, DocumentFileType documentFileType, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = StorageId.PRIMARY;
        }
        if ((i & 4) != 0) {
            str2 = "";
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            documentFileType = DocumentFileType.ANY;
        }
        return fromSimplePath(context, str, str3, documentFileType, (i & 16) != 0 ? false : z, (i & 32) != 0 ? true : z2);
    }

    @JvmStatic
    public static final DocumentFile fromSimplePath(Context context, String storageId, String basePath, DocumentFileType documentType, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        Intrinsics.checkNotNullParameter(basePath, "basePath");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        if (Intrinsics.areEqual(storageId, "data")) {
            return DocumentFile.fromFile(FileExt.child(FileExt.getDataDirectory(context), basePath));
        }
        boolean z3 = true;
        if (basePath.length() == 0) {
            return getRootDocumentFile(context, storageId, z, z2);
        }
        DocumentFile exploreFile = INSTANCE.exploreFile(context, storageId, basePath, documentType, z, z2);
        if (exploreFile == null) {
            String DIRECTORY_DOWNLOADS = Environment.DIRECTORY_DOWNLOADS;
            Intrinsics.checkNotNullExpressionValue(DIRECTORY_DOWNLOADS, "DIRECTORY_DOWNLOADS");
            if (StringsKt.startsWith$default(basePath, DIRECTORY_DOWNLOADS, false, 2, (Object) null) && Intrinsics.areEqual(storageId, StorageId.PRIMARY)) {
                Uri parse = Uri.parse(DOWNLOADS_TREE_URI);
                Intrinsics.checkNotNullExpressionValue(parse, "parse(DOWNLOADS_TREE_URI)");
                DocumentFile fromTreeUri = ContextExt.fromTreeUri(context, parse);
                if (fromTreeUri == null || !fromTreeUri.canRead()) {
                    fromTreeUri = null;
                }
                if (fromTreeUri == null || (exploreFile = DocumentFileExt.child$default(fromTreeUri, context, StringsKt.substringAfter(basePath, (char) JsonPointer.SEPARATOR, ""), false, 4, null)) == null) {
                    return null;
                }
                if (documentType != DocumentFileType.ANY && ((documentType != DocumentFileType.FILE || !exploreFile.isFile()) && (documentType != DocumentFileType.FOLDER || !exploreFile.isDirectory()))) {
                    z3 = false;
                }
                if (!z3) {
                    return null;
                }
            }
        }
        return exploreFile;
    }

    public static /* synthetic */ DocumentFile fromFullPath$default(Context context, String str, DocumentFileType documentFileType, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            documentFileType = DocumentFileType.ANY;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        if ((i & 16) != 0) {
            z2 = true;
        }
        return fromFullPath(context, str, documentFileType, z, z2);
    }

    @JvmStatic
    public static final DocumentFile fromFullPath(Context context, String fullPath, DocumentFileType documentType, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fullPath, "fullPath");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        if (StringsKt.startsWith$default((CharSequence) fullPath, (char) JsonPointer.SEPARATOR, false, 2, (Object) null)) {
            return fromFile(context, new File(fullPath), documentType, z, z2);
        }
        return fromSimplePath(context, StringsKt.substringBefore$default(fullPath, ':', (String) null, 2, (Object) null), StringsKt.substringAfter$default(fullPath, ':', (String) null, 2, (Object) null), documentType, z, z2);
    }

    public static /* synthetic */ DocumentFile fromFile$default(Context context, File file, DocumentFileType documentFileType, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            documentFileType = DocumentFileType.ANY;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        if ((i & 16) != 0) {
            z2 = true;
        }
        return fromFile(context, file, documentFileType, z, z2);
    }

    @JvmStatic
    public static final DocumentFile fromFile(Context context, File file, DocumentFileType documentType, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        if (FileExt.checkRequirements(file, context, z, z2)) {
            if ((documentType != DocumentFileType.FILE || file.isFile()) && (documentType != DocumentFileType.FOLDER || file.isDirectory())) {
                return DocumentFile.fromFile(file);
            }
            return null;
        }
        DocumentFileCompat documentFileCompat = INSTANCE;
        String trimFileSeparator = TextExt.trimFileSeparator(documentFileCompat.removeForbiddenCharsFromFilename$storage_release(FileExt.getBasePath(file, context)));
        DocumentFile exploreFile = documentFileCompat.exploreFile(context, FileExt.getStorageId(file, context), trimFileSeparator, documentType, z, z2);
        return exploreFile == null ? fromSimplePath(context, FileExt.getStorageId(file, context), trimFileSeparator, documentType, z, z2) : exploreFile;
    }

    public static /* synthetic */ DocumentFile fromPublicFolder$default(Context context, PublicDirectory publicDirectory, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "";
        }
        if ((i & 8) != 0) {
            z = false;
        }
        if ((i & 16) != 0) {
            z2 = true;
        }
        return fromPublicFolder(context, publicDirectory, str, z, z2);
    }

    @JvmStatic
    public static final DocumentFile fromPublicFolder(Context context, PublicDirectory type, String subFile, boolean z, boolean z2) {
        DocumentFile fromFullPath$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(subFile, "subFile");
        File rawFile = Environment.getExternalStoragePublicDirectory(type.getFolderName());
        boolean z3 = true;
        if (subFile.length() > 0) {
            rawFile = new File(StringsKt.trimEnd(rawFile + JsonPointer.SEPARATOR + subFile, JsonPointer.SEPARATOR));
        }
        Intrinsics.checkNotNullExpressionValue(rawFile, "rawFile");
        if (FileExt.checkRequirements(rawFile, context, z, z2)) {
            return DocumentFile.fromFile(rawFile);
        }
        if (type == PublicDirectory.DOWNLOADS) {
            Uri parse = Uri.parse(DOWNLOADS_TREE_URI);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(DOWNLOADS_TREE_URI)");
            DocumentFile fromTreeUri = ContextExt.fromTreeUri(context, parse);
            if (fromTreeUri != null && fromTreeUri.canRead()) {
                fromFullPath$default = DocumentFileExt.child(fromTreeUri, context, subFile, z);
            } else {
                String absolutePath = rawFile.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "rawFile.absolutePath");
                fromFullPath$default = fromFullPath$default(context, absolutePath, null, false, false, 12, null);
            }
        } else {
            String absolutePath2 = rawFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "rawFile.absolutePath");
            fromFullPath$default = fromFullPath$default(context, absolutePath2, null, false, false, 12, null);
        }
        if (fromFullPath$default != null) {
            if (!fromFullPath$default.canRead() || ((!z || !DocumentFileExt.isWritable(fromFullPath$default, context)) && z)) {
                z3 = false;
            }
            if (z3) {
                return fromFullPath$default;
            }
        }
        return null;
    }

    public static /* synthetic */ DocumentFile getRootDocumentFile$default(Context context, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        return getRootDocumentFile(context, str, z, z2);
    }

    @JvmStatic
    public static final DocumentFile getRootDocumentFile(Context context, String storageId, boolean z, boolean z2) {
        DocumentFile fromTreeUri;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        if (Intrinsics.areEqual(storageId, "data")) {
            return DocumentFile.fromFile(FileExt.getDataDirectory(context));
        }
        if (z2) {
            File rootRawFile = getRootRawFile(context, storageId, z);
            fromTreeUri = rootRawFile == null ? null : DocumentFile.fromFile(rootRawFile);
            if (fromTreeUri == null) {
                fromTreeUri = ContextExt.fromTreeUri(context, createDocumentUri$default(storageId, null, 2, null));
            }
        } else {
            fromTreeUri = ContextExt.fromTreeUri(context, createDocumentUri$default(storageId, null, 2, null));
        }
        if (fromTreeUri == null) {
            return null;
        }
        if (fromTreeUri.canRead() && ((z && DocumentFileExt.isWritable(fromTreeUri, context)) || !z)) {
            return fromTreeUri;
        }
        return null;
    }

    public static /* synthetic */ DocumentFile getAccessibleRootDocumentFile$default(Context context, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        return getAccessibleRootDocumentFile(context, str, z, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x00a9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x007c A[SYNTHETIC] */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.documentfile.provider.DocumentFile getAccessibleRootDocumentFile(android.content.Context r16, java.lang.String r17, boolean r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileCompat.getAccessibleRootDocumentFile(android.content.Context, java.lang.String, boolean, boolean):androidx.documentfile.provider.DocumentFile");
    }

    public static /* synthetic */ File getRootRawFile$default(Context context, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return getRootRawFile(context, str, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0042, code lost:
        if (com.anggrayudi.storage.file.FileExt.isWritable(r3, r2) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0044, code lost:
        if (r4 == false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0046, code lost:
        r2 = true;
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.io.File getRootRawFile(android.content.Context r2, java.lang.String r3, boolean r4) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "storageId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "primary"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r0)
            if (r0 == 0) goto L18
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()
            goto L31
        L18:
            java.lang.String r0 = "data"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r0)
            if (r0 == 0) goto L25
            java.io.File r3 = com.anggrayudi.storage.file.FileExt.getDataDirectory(r2)
            goto L31
        L25:
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "/storage/"
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r3)
            r0.<init>(r3)
            r3 = r0
        L31:
            boolean r0 = r3.canRead()
            if (r0 == 0) goto L48
            if (r4 == 0) goto L44
            java.lang.String r0 = "rootFile"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            boolean r2 = com.anggrayudi.storage.file.FileExt.isWritable(r3, r2)
            if (r2 != 0) goto L46
        L44:
            if (r4 != 0) goto L48
        L46:
            r2 = 1
            goto L49
        L48:
            r2 = 0
        L49:
            if (r2 == 0) goto L4c
            goto L4d
        L4c:
            r3 = 0
        L4d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileCompat.getRootRawFile(android.content.Context, java.lang.String, boolean):java.io.File");
    }

    @JvmStatic
    public static final String buildAbsolutePath(Context context, String storageId, String basePath) {
        String path;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        Intrinsics.checkNotNullParameter(basePath, "basePath");
        String removeForbiddenCharsFromFilename$storage_release = INSTANCE.removeForbiddenCharsFromFilename$storage_release(basePath);
        if (Intrinsics.areEqual(storageId, StorageId.PRIMARY)) {
            path = SimpleStorage.Companion.getExternalStoragePath();
        } else {
            path = Intrinsics.areEqual(storageId, "data") ? FileExt.getDataDirectory(context).getPath() : Intrinsics.stringPlus("/storage/", storageId);
        }
        return StringsKt.trimEnd(((Object) path) + JsonPointer.SEPARATOR + removeForbiddenCharsFromFilename$storage_release, JsonPointer.SEPARATOR);
    }

    @JvmStatic
    public static final String buildAbsolutePath(Context context, String simplePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(simplePath, "simplePath");
        String trimEnd = StringsKt.trimEnd(simplePath, JsonPointer.SEPARATOR);
        if (StringsKt.startsWith$default((CharSequence) trimEnd, (char) JsonPointer.SEPARATOR, false, 2, (Object) null)) {
            return INSTANCE.removeForbiddenCharsFromFilename$storage_release(trimEnd);
        }
        return buildAbsolutePath(context, getStorageId(context, trimEnd), getBasePath(context, trimEnd));
    }

    @JvmStatic
    public static final String buildSimplePath(String storageId, String basePath) {
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        Intrinsics.checkNotNullParameter(basePath, "basePath");
        String trimFileSeparator = TextExt.trimFileSeparator(INSTANCE.removeForbiddenCharsFromFilename$storage_release(basePath));
        return storageId + ':' + trimFileSeparator;
    }

    @JvmStatic
    public static final String buildSimplePath(Context context, String absolutePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(absolutePath, "absolutePath");
        return buildSimplePath(getStorageId(context, absolutePath), getBasePath(context, absolutePath));
    }

    public static /* synthetic */ Uri createDocumentUri$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return createDocumentUri(str, str2);
    }

    @JvmStatic
    public static final Uri createDocumentUri(String storageId, String basePath) {
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        Intrinsics.checkNotNullParameter(basePath, "basePath");
        StringBuilder sb = new StringBuilder();
        sb.append("content://");
        sb.append(EXTERNAL_STORAGE_AUTHORITY);
        sb.append("/tree/");
        sb.append((Object) Uri.encode(storageId + ':' + basePath));
        Uri parse = Uri.parse(sb.toString());
        Intrinsics.checkNotNullExpressionValue(parse, "parse(\"content://$EXTERNAL_STORAGE_AUTHORITY/tree/\" + Uri.encode(\"$storageId:$basePath\"))");
        return parse;
    }

    @JvmStatic
    public static final boolean isAccessGranted(Context context, String storageId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        return Intrinsics.areEqual(storageId, "data") || (Intrinsics.areEqual(storageId, StorageId.PRIMARY) && Build.VERSION.SDK_INT < 29) || getRootDocumentFile$default(context, storageId, true, false, 8, null) != null;
    }

    @JvmStatic
    public static final boolean doesExist(Context context, String fullPath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fullPath, "fullPath");
        DocumentFile fromFullPath$default = fromFullPath$default(context, fullPath, null, false, false, 28, null);
        return fromFullPath$default != null && fromFullPath$default.exists();
    }

    @JvmStatic
    public static final boolean delete(Context context, String fullPath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fullPath, "fullPath");
        DocumentFile fromFullPath$default = fromFullPath$default(context, fullPath, null, false, false, 28, null);
        return fromFullPath$default != null && fromFullPath$default.delete();
    }

    public static /* synthetic */ boolean isStorageUriPermissionGranted$default(Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        return isStorageUriPermissionGranted(context, str, str2);
    }

    @JvmStatic
    public static final boolean isStorageUriPermissionGranted(Context context, String storageId, String basePath) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        Intrinsics.checkNotNullParameter(basePath, "basePath");
        Uri createDocumentUri = createDocumentUri(storageId, basePath);
        List<UriPermission> persistedUriPermissions = context.getContentResolver().getPersistedUriPermissions();
        Intrinsics.checkNotNullExpressionValue(persistedUriPermissions, "context.contentResolver.persistedUriPermissions");
        List<UriPermission> list = persistedUriPermissions;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (UriPermission uriPermission : list) {
                if (uriPermission.isReadPermission() && uriPermission.isWritePermission() && Intrinsics.areEqual(uriPermission.getUri(), createDocumentUri)) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean isDownloadsUriPermissionGranted(Context context) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Uri parse = Uri.parse(DOWNLOADS_TREE_URI);
        List<UriPermission> persistedUriPermissions = context.getContentResolver().getPersistedUriPermissions();
        Intrinsics.checkNotNullExpressionValue(persistedUriPermissions, "context.contentResolver.persistedUriPermissions");
        List<UriPermission> list = persistedUriPermissions;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (UriPermission uriPermission : list) {
                if (uriPermission.isReadPermission() && uriPermission.isWritePermission() && Intrinsics.areEqual(uriPermission.getUri(), parse)) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x00af A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0082 A[SYNTHETIC] */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.util.List<java.lang.String> getStorageIds(android.content.Context r9) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            com.anggrayudi.storage.SimpleStorage$Companion r0 = com.anggrayudi.storage.SimpleStorage.Companion
            java.lang.String r0 = r0.getExternalStoragePath()
            r1 = 0
            java.io.File[] r2 = androidx.core.content.ContextCompat.getExternalFilesDirs(r9, r1)
            java.lang.String r3 = "getExternalFilesDirs(context, null)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            java.util.List r2 = kotlin.collections.ArraysKt.filterNotNull(r2)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r4)
            r3.<init>(r4)
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r2 = r2.iterator()
        L2e:
            boolean r4 = r2.hasNext()
            r5 = 47
            r6 = 0
            r7 = 2
            if (r4 == 0) goto L5e
            java.lang.Object r4 = r2.next()
            java.io.File r4 = (java.io.File) r4
            java.lang.String r4 = r4.getPath()
            java.lang.String r8 = "path"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r8)
            boolean r6 = kotlin.text.StringsKt.startsWith$default(r4, r0, r6, r7, r1)
            if (r6 == 0) goto L50
            java.lang.String r4 = "primary"
            goto L5a
        L50:
            java.lang.String r6 = "/storage/"
            java.lang.String r4 = kotlin.text.StringsKt.substringAfter$default(r4, r6, r1, r7, r1)
            java.lang.String r4 = kotlin.text.StringsKt.substringBefore$default(r4, r5, r1, r7, r1)
        L5a:
            r3.add(r4)
            goto L2e
        L5e:
            java.util.List r3 = (java.util.List) r3
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r0 < r2) goto L68
            goto Lfd
        L68:
            android.content.ContentResolver r9 = r9.getContentResolver()
            java.util.List r9 = r9.getPersistedUriPermissions()
            java.lang.String r0 = "context.contentResolver.persistedUriPermissions"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r9 = r9.iterator()
        L82:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto Lb3
            java.lang.Object r2 = r9.next()
            r4 = r2
            android.content.UriPermission r4 = (android.content.UriPermission) r4
            boolean r8 = r4.isReadPermission()
            if (r8 == 0) goto Lac
            boolean r8 = r4.isWritePermission()
            if (r8 == 0) goto Lac
            android.net.Uri r4 = r4.getUri()
            java.lang.String r8 = "it.uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r8)
            boolean r4 = com.anggrayudi.storage.extension.UriExt.isExternalStorageDocument(r4)
            if (r4 == 0) goto Lac
            r4 = 1
            goto Lad
        Lac:
            r4 = 0
        Lad:
            if (r4 == 0) goto L82
            r0.add(r2)
            goto L82
        Lb3:
            java.util.List r0 = (java.util.List) r0
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.Iterator r0 = r0.iterator()
        Lc2:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto Lea
            java.lang.Object r2 = r0.next()
            android.content.UriPermission r2 = (android.content.UriPermission) r2
            android.net.Uri r2 = r2.getUri()
            java.lang.String r2 = r2.getPath()
            if (r2 != 0) goto Lda
            r2 = r1
            goto Le4
        Lda:
            r4 = 58
            java.lang.String r2 = kotlin.text.StringsKt.substringBefore$default(r2, r4, r1, r7, r1)
            java.lang.String r2 = kotlin.text.StringsKt.substringAfterLast$default(r2, r5, r1, r7, r1)
        Le4:
            if (r2 == 0) goto Lc2
            r9.add(r2)
            goto Lc2
        Lea:
            java.util.List r9 = (java.util.List) r9
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.List r0 = kotlin.collections.CollectionsKt.toMutableList(r3)
            java.util.Collection r9 = (java.util.Collection) r9
            r0.addAll(r9)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.List r3 = kotlin.collections.CollectionsKt.distinct(r0)
        Lfd:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileCompat.getStorageIds(android.content.Context):java.util.List");
    }

    @JvmStatic
    public static final List<String> getSdCardIds(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        for (Object obj : getStorageIds(context)) {
            if (!Intrinsics.areEqual((String) obj, StorageId.PRIMARY)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ DocumentFile mkdirs$default(Context context, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        return mkdirs(context, str, z, z2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0032, code lost:
        if (kotlin.text.StringsKt.startsWith$default(r7, r4, false, 2, (java.lang.Object) null) != false) goto L5;
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.documentfile.provider.DocumentFile mkdirs(android.content.Context r6, java.lang.String r7, boolean r8, boolean r9) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "fullPath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.anggrayudi.storage.file.DocumentFileCompat$mkdirs$tryCreateWithRawFile$1 r0 = new com.anggrayudi.storage.file.DocumentFileCompat$mkdirs$tryCreateWithRawFile$1
            r0.<init>(r7, r8, r6)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Functions) r0
            r1 = 2
            r2 = 0
            r3 = 0
            if (r9 == 0) goto L21
            r4 = r7
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r5 = 47
            boolean r4 = kotlin.text.StringsKt.startsWith$default(r4, r5, r2, r1, r3)
            if (r4 != 0) goto L34
        L21:
            java.io.File r4 = com.anggrayudi.storage.file.FileExt.getDataDirectory(r6)
            java.lang.String r4 = r4.getPath()
            java.lang.String r5 = "context.dataDirectory.path"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            boolean r1 = kotlin.text.StringsKt.startsWith$default(r7, r4, r2, r1, r3)
            if (r1 == 0) goto L3e
        L34:
            java.lang.Object r1 = r0.invoke()
            androidx.documentfile.provider.DocumentFile r1 = (androidx.documentfile.provider.DocumentFile) r1
            if (r1 != 0) goto L3d
            goto L3e
        L3d:
            return r1
        L3e:
            com.anggrayudi.storage.file.DocumentFileCompat r1 = com.anggrayudi.storage.file.DocumentFileCompat.INSTANCE
            androidx.documentfile.provider.DocumentFile r9 = getAccessibleRootDocumentFile(r6, r7, r8, r9)
            if (r9 != 0) goto L47
            return r3
        L47:
            boolean r2 = com.anggrayudi.storage.file.DocumentFileExt.isRawFile(r9)
            if (r2 == 0) goto L54
            java.lang.Object r6 = r0.invoke()
            androidx.documentfile.provider.DocumentFile r6 = (androidx.documentfile.provider.DocumentFile) r6
            return r6
        L54:
            android.content.ContentResolver r0 = r6.getContentResolver()
            java.lang.String r7 = getBasePath(r6, r7)
            java.util.List r7 = r1.getDirectorySequence$storage_release(r7)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L66:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L93
            java.lang.Object r1 = r7.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "resolver"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch: java.lang.Exception -> L92
            androidx.documentfile.provider.DocumentFile r2 = com.anggrayudi.storage.file.DocumentFileExt.quickFindTreeFile(r9, r6, r0, r1)     // Catch: java.lang.Exception -> L92
            if (r2 != 0) goto L84
            androidx.documentfile.provider.DocumentFile r9 = r9.createDirectory(r1)     // Catch: java.lang.Exception -> L92
            if (r9 != 0) goto L66
            return r3
        L84:
            boolean r9 = r2.isDirectory()     // Catch: java.lang.Exception -> L92
            if (r9 == 0) goto L92
            boolean r9 = r2.canRead()     // Catch: java.lang.Exception -> L92
            if (r9 == 0) goto L92
            r9 = r2
            goto L66
        L92:
            return r3
        L93:
            androidx.documentfile.provider.DocumentFile r6 = com.anggrayudi.storage.file.DocumentFileExt.takeIfWritable(r9, r6, r8)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileCompat.mkdirs(android.content.Context, java.lang.String, boolean, boolean):androidx.documentfile.provider.DocumentFile");
    }

    public static /* synthetic */ DocumentFile[] mkdirs$default(Context context, List list, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        return mkdirs(context, list, z, z2);
    }

    @JvmStatic
    public static final DocumentFile[] mkdirs(Context context, List<String> fullPaths, boolean z, boolean z2) {
        DocumentFile quickFindTreeFile;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fullPaths, "fullPaths");
        String dataDir = FileExt.getDataDirectory(context).getPath();
        DocumentFile[] documentFileArr = new DocumentFile[fullPaths.size()];
        List<String> list = fullPaths;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            arrayList.add(buildAbsolutePath(context, str));
        }
        ArrayList arrayList2 = arrayList;
        for (String str2 : findUniqueDeepestSubFolders(context, arrayList2)) {
            File file = new File(str2);
            file.mkdirs();
            int i = 0;
            if (!z2 || !file.isDirectory() || !file.canRead()) {
                Intrinsics.checkNotNullExpressionValue(dataDir, "dataDir");
                if (!StringsKt.startsWith$default(str2, dataDir, false, 2, (Object) null)) {
                    DocumentFileCompat documentFileCompat = INSTANCE;
                    DocumentFile accessibleRootDocumentFile = getAccessibleRootDocumentFile(context, str2, z, z2);
                    if (accessibleRootDocumentFile != null) {
                        boolean isRawFile = DocumentFileExt.isRawFile(accessibleRootDocumentFile);
                        ContentResolver resolver = context.getContentResolver();
                        for (String str3 : documentFileCompat.getDirectorySequence$storage_release(getBasePath(context, str2))) {
                            if (isRawFile) {
                                try {
                                    quickFindTreeFile = DocumentFileExt.quickFindRawFile(accessibleRootDocumentFile, str3);
                                } catch (Throwable unused) {
                                }
                            } else {
                                Intrinsics.checkNotNullExpressionValue(resolver, "resolver");
                                quickFindTreeFile = DocumentFileExt.quickFindTreeFile(accessibleRootDocumentFile, context, resolver, str3);
                            }
                            if (quickFindTreeFile == null) {
                                DocumentFile createDirectory = accessibleRootDocumentFile.createDirectory(str3);
                                if (createDirectory != null) {
                                    try {
                                        String absolutePath = DocumentFileExt.getAbsolutePath(createDirectory, context);
                                        int i2 = 0;
                                        for (Object obj : arrayList2) {
                                            int i3 = i2 + 1;
                                            if (i2 < 0) {
                                                CollectionsKt.throwIndexOverflow();
                                            }
                                            if (Intrinsics.areEqual(absolutePath, (String) obj)) {
                                                documentFileArr[i2] = createDirectory;
                                            }
                                            i2 = i3;
                                        }
                                    } catch (Throwable unused2) {
                                    }
                                    accessibleRootDocumentFile = createDirectory;
                                }
                            } else if (quickFindTreeFile.isDirectory() && quickFindTreeFile.canRead()) {
                                try {
                                    String absolutePath2 = DocumentFileExt.getAbsolutePath(quickFindTreeFile, context);
                                    int i4 = 0;
                                    for (Object obj2 : arrayList2) {
                                        int i5 = i4 + 1;
                                        if (i4 < 0) {
                                            CollectionsKt.throwIndexOverflow();
                                        }
                                        if (Intrinsics.areEqual(absolutePath2, (String) obj2)) {
                                            documentFileArr[i4] = quickFindTreeFile;
                                        }
                                        i4 = i5;
                                    }
                                } catch (Throwable unused3) {
                                }
                                accessibleRootDocumentFile = quickFindTreeFile;
                            }
                        }
                    }
                }
            }
            for (Object obj3 : arrayList2) {
                int i6 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str4 = (String) obj3;
                if (TextExt.hasParent(str2, str4)) {
                    documentFileArr[i] = DocumentFile.fromFile(new File(CollectionsKt.joinToString$default(INSTANCE.getDirectorySequence$storage_release(str4), "/", "/", null, 0, null, null, 60, null)));
                }
                i = i6;
            }
        }
        Iterator<Integer> it = ArraysKt.getIndices(documentFileArr).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            DocumentFile documentFile = documentFileArr[nextInt];
            documentFileArr[nextInt] = documentFile == null ? null : DocumentFileExt.takeIfWritable(documentFile, context, z);
        }
        return documentFileArr;
    }

    @JvmStatic
    public static final Uri createDownloadWithMediaStoreFallback(Context context, FileDescription file) {
        DocumentFile makeFile$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        DocumentFile fromPublicFolder$default = fromPublicFolder$default(context, PublicDirectory.DOWNLOADS, null, true, false, 20, null);
        if (fromPublicFolder$default != null || Build.VERSION.SDK_INT <= 28) {
            if (fromPublicFolder$default == null || (makeFile$default = DocumentFileExt.makeFile$default(fromPublicFolder$default, context, file.getName(), file.getMimeType(), null, 8, null)) == null) {
                return null;
            }
            return makeFile$default.getUri();
        }
        MediaFile createDownload$default = MediaStoreCompat.createDownload$default(context, file, null, 4, null);
        if (createDownload$default == null) {
            return null;
        }
        return createDownload$default.getUri();
    }

    @JvmStatic
    public static final Uri createPictureWithMediaStoreFallback(Context context, FileDescription file) {
        DocumentFile makeFile$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        DocumentFile fromPublicFolder$default = fromPublicFolder$default(context, PublicDirectory.PICTURES, null, true, false, 20, null);
        if (fromPublicFolder$default != null || Build.VERSION.SDK_INT <= 28) {
            if (fromPublicFolder$default == null || (makeFile$default = DocumentFileExt.makeFile$default(fromPublicFolder$default, context, file.getName(), file.getMimeType(), null, 8, null)) == null) {
                return null;
            }
            return makeFile$default.getUri();
        }
        MediaFile createImage$default = MediaStoreCompat.createImage$default(context, file, null, null, 12, null);
        if (createImage$default == null) {
            return null;
        }
        return createImage$default.getUri();
    }

    public static /* synthetic */ DocumentFile createFile$default(Context context, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str = StorageId.PRIMARY;
        }
        if ((i & 8) != 0) {
            str3 = MimeType.UNKNOWN;
        }
        if ((i & 16) != 0) {
            z = true;
        }
        return createFile(context, str, str2, str3, z);
    }

    @JvmStatic
    public static final DocumentFile createFile(Context context, String storageId, String basePath, String mimeType, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        Intrinsics.checkNotNullParameter(basePath, "basePath");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        if (Intrinsics.areEqual(storageId, "data") || (z && Intrinsics.areEqual(storageId, StorageId.PRIMARY) && Build.VERSION.SDK_INT < 29)) {
            DocumentFileCompat documentFileCompat = INSTANCE;
            File file = new File(buildAbsolutePath(context, storageId, basePath));
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            if (documentFileCompat.create(file)) {
                return DocumentFile.fromFile(file);
            }
            return null;
        }
        try {
            DocumentFileCompat documentFileCompat2 = INSTANCE;
            DocumentFile mkdirsParentDirectory = documentFileCompat2.mkdirsParentDirectory(context, storageId, basePath, z);
            String removeForbiddenCharsFromFilename$storage_release = documentFileCompat2.removeForbiddenCharsFromFilename$storage_release(documentFileCompat2.getFileNameFromPath(basePath));
            if (!(removeForbiddenCharsFromFilename$storage_release.length() == 0) && mkdirsParentDirectory != null) {
                return DocumentFileExt.makeFile$default(mkdirsParentDirectory, context, removeForbiddenCharsFromFilename$storage_release, mimeType, null, 8, null);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private final String getParentPath(String str) {
        List<String> directorySequence$storage_release = getDirectorySequence$storage_release(str);
        return (String) CollectionsKt.getOrNull(directorySequence$storage_release, directorySequence$storage_release.size() - 2);
    }

    private final DocumentFile mkdirsParentDirectory(Context context, String str, String str2, boolean z) {
        String parentPath = getParentPath(str2);
        if (parentPath != null) {
            return mkdirs$default(context, buildAbsolutePath(context, str, parentPath), z, false, 8, (Object) null);
        }
        return getRootDocumentFile(context, str, true, z);
    }

    private final String getFileNameFromPath(String str) {
        return StringsKt.substringAfterLast$default(StringsKt.trimEnd(str, JsonPointer.SEPARATOR), (char) JsonPointer.SEPARATOR, (String) null, 2, (Object) null);
    }

    public static /* synthetic */ DocumentFile recreate$default(Context context, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str = StorageId.PRIMARY;
        }
        if ((i & 8) != 0) {
            str3 = MimeType.UNKNOWN;
        }
        if ((i & 16) != 0) {
            z = true;
        }
        return recreate(context, str, str2, str3, z);
    }

    @JvmStatic
    public static final DocumentFile recreate(Context context, String storageId, String basePath, String mimeType, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        Intrinsics.checkNotNullParameter(basePath, "basePath");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        DocumentFileCompat documentFileCompat = INSTANCE;
        File file = new File(buildAbsolutePath(context, storageId, basePath));
        file.delete();
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        if ((z || Intrinsics.areEqual(storageId, "data")) && documentFileCompat.create(file)) {
            return DocumentFile.fromFile(file);
        }
        DocumentFile mkdirsParentDirectory = documentFileCompat.mkdirsParentDirectory(context, storageId, basePath, z);
        String filename = file.getName();
        String str = filename;
        if ((str == null || str.length() == 0) || mkdirsParentDirectory == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(filename, "filename");
        DocumentFile child$default = DocumentFileExt.child$default(mkdirsParentDirectory, context, filename, false, 4, null);
        if (child$default != null) {
            child$default.delete();
        }
        return DocumentFileExt.makeFile$default(mkdirsParentDirectory, context, filename, mimeType, null, 8, null);
    }

    private final boolean create(File file) {
        try {
            if (!file.isFile() || file.length() != 0) {
                if (!file.createNewFile()) {
                    return false;
                }
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public final String removeForbiddenCharsFromFilename$storage_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return TextExt.replaceCompletely(StringsKt.replace$default(str, ":", "_", false, 4, (Object) null), "//", "/");
    }

    private final DocumentFile exploreFile(Context context, String str, String str2, DocumentFileType documentFileType, boolean z, boolean z2) {
        DocumentFile documentFile;
        File file = new File(buildAbsolutePath(context, str, str2));
        if ((z2 || Intrinsics.areEqual(str, "data")) && file.canRead() && FileExt.shouldWritable(file, context, z)) {
            if (documentFileType == DocumentFileType.ANY || ((documentFileType == DocumentFileType.FILE && file.isFile()) || (documentFileType == DocumentFileType.FOLDER && file.isDirectory()))) {
                return DocumentFile.fromFile(file);
            }
            return null;
        }
        boolean z3 = false;
        if (Build.VERSION.SDK_INT < 30) {
            DocumentFile rootDocumentFile = getRootDocumentFile(context, str, z, z2);
            documentFile = rootDocumentFile == null ? null : DocumentFileExt.child$default(rootDocumentFile, context, str2, false, 4, null);
            if (documentFile == null) {
                return null;
            }
        } else {
            List mutableList = CollectionsKt.toMutableList((Collection) getDirectorySequence$storage_release(str2));
            ArrayList arrayList = new ArrayList(mutableList.size());
            DocumentFile documentFile2 = null;
            while (!mutableList.isEmpty()) {
                arrayList.add(CollectionsKt.removeFirst(mutableList));
                try {
                    documentFile2 = ContextExt.fromTreeUri(context, createDocumentUri(str, CollectionsKt.joinToString$default(arrayList, "/", null, null, 0, null, null, 62, null)));
                } catch (SecurityException unused) {
                }
                if (documentFile2 != null && documentFile2.canRead()) {
                    break;
                }
            }
            documentFile = documentFile2;
            if (documentFile != null && !mutableList.isEmpty()) {
                Uri parse = Uri.parse(Intrinsics.stringPlus(documentFile.getUri().toString(), Uri.encode(CollectionsKt.joinToString$default(mutableList, "/", "/", null, 0, null, null, 60, null))));
                Intrinsics.checkNotNullExpressionValue(parse, "parse(grantedFile.uri.toString() + Uri.encode(fileTree))");
                documentFile = ContextExt.fromTreeUri(context, parse);
            }
        }
        if (documentFile == null) {
            return null;
        }
        if (documentFile.canRead() && (documentFileType == DocumentFileType.ANY || ((documentFileType == DocumentFileType.FILE && documentFile.isFile()) || (documentFileType == DocumentFileType.FOLDER && documentFile.isDirectory())))) {
            z3 = true;
        }
        if (z3) {
            return documentFile;
        }
        return null;
    }

    public final List<String> getDirectorySequence$storage_release(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        char[] cArr = {JsonPointer.SEPARATOR};
        ArrayList arrayList = new ArrayList();
        for (Object obj : StringsKt.split$default((CharSequence) path, cArr, false, 0, 6, (Object) null)) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @JvmStatic
    public static final List<String> findUniqueDeepestSubFolders(Context context, Collection<String> folderFullPaths) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(folderFullPaths, "folderFullPaths");
        Collection<String> collection = folderFullPaths;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        for (String str : collection) {
            arrayList.add(buildAbsolutePath(context, str));
        }
        List distinct = CollectionsKt.distinct(arrayList);
        ArrayList arrayList2 = new ArrayList(distinct);
        List<String> list = distinct;
        for (String str2 : list) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                String str3 = (String) obj;
                if (Intrinsics.areEqual(str3, str2) || !TextExt.hasParent(str2, str3)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            String str4 = (String) obj;
            if (str4 != null) {
                arrayList2.remove(str4);
            }
        }
        return arrayList2;
    }

    @JvmStatic
    public static final List<String> findUniqueParents(Context context, Collection<String> folderFullPaths) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(folderFullPaths, "folderFullPaths");
        Collection<String> collection = folderFullPaths;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        for (String str : collection) {
            arrayList.add(buildAbsolutePath(context, str));
        }
        List distinct = CollectionsKt.distinct(arrayList);
        ArrayList arrayList2 = new ArrayList(distinct.size());
        List<String> list = distinct;
        for (String str2 : list) {
            boolean z2 = true;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (String str3 : list) {
                    if (Intrinsics.areEqual(str3, str2) || !TextExt.hasParent(str2, str3)) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
            }
            z2 = false;
            if (!z2) {
                arrayList2.add(str2);
            }
        }
        return arrayList2;
    }

    @JvmStatic
    public static final List<String> findInaccessibleStorageLocations(Context context, List<String> fullPaths) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fullPaths, "fullPaths");
        if (SimpleStorage.Companion.hasStoragePermission(context)) {
            List<String> findUniqueParents = findUniqueParents(context, fullPaths);
            ArrayList arrayList = new ArrayList(findUniqueParents.size());
            DocumentFile[] mkdirs$default = mkdirs$default(context, (List) findUniqueParents, false, false, 12, (Object) null);
            int length = mkdirs$default.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = i2 + 1;
                if (mkdirs$default[i] == null) {
                    arrayList.add(findUniqueParents.get(i2));
                }
                i++;
                i2 = i3;
            }
            return arrayList;
        }
        List<String> list = fullPaths;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            arrayList2.add(buildAbsolutePath(context, str));
        }
        return arrayList2;
    }

    @JvmStatic
    public static final long getFreeSpace(Context context, String storageId) {
        DocumentFile documentFileForStorageInfo;
        ParcelFileDescriptor openFileDescriptor;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        long j = 0;
        try {
            documentFileForStorageInfo = INSTANCE.getDocumentFileForStorageInfo(context, storageId);
        } catch (Throwable unused) {
        }
        if (documentFileForStorageInfo == null) {
            return 0L;
        }
        if (DocumentFileExt.isRawFile(documentFileForStorageInfo)) {
            String path = documentFileForStorageInfo.getUri().getPath();
            Intrinsics.checkNotNull(path);
            j = new StatFs(path).getAvailableBytes();
        } else if (Build.VERSION.SDK_INT >= 21 && (openFileDescriptor = context.getContentResolver().openFileDescriptor(documentFileForStorageInfo.getUri(), "r")) != null) {
            ParcelFileDescriptor parcelFileDescriptor = openFileDescriptor;
            Throwable th = null;
            StructStatVfs fstatvfs = Os.fstatvfs(parcelFileDescriptor.getFileDescriptor());
            long j2 = fstatvfs.f_bavail * fstatvfs.f_frsize;
            Closeable.closeFinally(parcelFileDescriptor, th);
            j = j2;
        }
        return j;
    }

    @JvmStatic
    public static final long getUsedSpace(Context context, String storageId) {
        DocumentFile documentFileForStorageInfo;
        ParcelFileDescriptor openFileDescriptor;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        long j = 0;
        try {
            documentFileForStorageInfo = INSTANCE.getDocumentFileForStorageInfo(context, storageId);
        } catch (Throwable unused) {
        }
        if (documentFileForStorageInfo == null) {
            return 0L;
        }
        if (DocumentFileExt.isRawFile(documentFileForStorageInfo)) {
            String path = documentFileForStorageInfo.getUri().getPath();
            Intrinsics.checkNotNull(path);
            StatFs statFs = new StatFs(path);
            j = statFs.getTotalBytes() - statFs.getAvailableBytes();
        } else if (Build.VERSION.SDK_INT >= 21 && (openFileDescriptor = context.getContentResolver().openFileDescriptor(documentFileForStorageInfo.getUri(), "r")) != null) {
            ParcelFileDescriptor parcelFileDescriptor = openFileDescriptor;
            Throwable th = null;
            StructStatVfs fstatvfs = Os.fstatvfs(parcelFileDescriptor.getFileDescriptor());
            long j2 = fstatvfs.f_blocks * fstatvfs.f_frsize;
            long j3 = fstatvfs.f_bavail;
            long j4 = fstatvfs.f_frsize;
            Long.signum(j3);
            long j5 = j2 - (j3 * j4);
            Closeable.closeFinally(parcelFileDescriptor, th);
            j = j5;
        }
        return j;
    }

    @JvmStatic
    public static final long getStorageCapacity(Context context, String storageId) {
        DocumentFile documentFileForStorageInfo;
        ParcelFileDescriptor openFileDescriptor;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        long j = 0;
        try {
            documentFileForStorageInfo = INSTANCE.getDocumentFileForStorageInfo(context, storageId);
        } catch (Throwable unused) {
        }
        if (documentFileForStorageInfo == null) {
            return 0L;
        }
        if (DocumentFileExt.isRawFile(documentFileForStorageInfo)) {
            String path = documentFileForStorageInfo.getUri().getPath();
            Intrinsics.checkNotNull(path);
            j = new StatFs(path).getTotalBytes();
        } else if (Build.VERSION.SDK_INT >= 21 && (openFileDescriptor = context.getContentResolver().openFileDescriptor(documentFileForStorageInfo.getUri(), "r")) != null) {
            ParcelFileDescriptor parcelFileDescriptor = openFileDescriptor;
            Throwable th = null;
            StructStatVfs fstatvfs = Os.fstatvfs(parcelFileDescriptor.getFileDescriptor());
            long j2 = fstatvfs.f_blocks * fstatvfs.f_frsize;
            Closeable.closeFinally(parcelFileDescriptor, th);
            j = j2;
        }
        return j;
    }

    private final DocumentFile getDocumentFileForStorageInfo(Context context, String str) {
        if (Intrinsics.areEqual(str, StorageId.PRIMARY)) {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                return null;
            }
            return DocumentFile.fromFile(externalFilesDir);
        } else if (Intrinsics.areEqual(str, "data")) {
            return DocumentFile.fromFile(FileExt.getDataDirectory(context));
        } else {
            File file = new File("/storage/" + str + "/Android/data/" + ((Object) context.getPackageName()) + "/files");
            file.mkdirs();
            if (file.canRead()) {
                return DocumentFile.fromFile(file);
            }
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "folder.absolutePath");
            return getAccessibleRootDocumentFile$default(context, absolutePath, false, false, 4, null);
        }
    }

    @JvmStatic
    public static final String getFileNameFromUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            String decode = URLDecoder.decode(url, "UTF-8");
            Intrinsics.checkNotNullExpressionValue(decode, "decode(url, \"UTF-8\")");
            return StringsKt.substringAfterLast$default(decode, (char) JsonPointer.SEPARATOR, (String) null, 2, (Object) null);
        } catch (Exception unused) {
            return url;
        }
    }
}
