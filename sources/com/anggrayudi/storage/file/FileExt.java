package com.anggrayudi.storage.file;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.core.content.ContextCompat;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.SimpleStorage;
import com.anggrayudi.storage.callback.FileCallback;
import com.anggrayudi.storage.extension.TextExt;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p043io.FilesKt;
import kotlin.text.StringsKt;

@Metadata(m108d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0012\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000b\u001a\u0012\u0010\u0014\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a$\u0010\u0016\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0007\u001a\u0012\u0010\u0019\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u000b\u001a\n\u0010\u001b\u001a\u00020\u0006*\u00020\u0001\u001a\u0012\u0010\u001c\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0016\u0010\u001d\u001a\u00020\u0006*\u00020\u00012\b\b\u0002\u0010\u001e\u001a\u00020\u0006H\u0007\u001a\u0012\u0010\u001f\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010 \u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a \u0010!\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0012\u0010\"\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010#\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020%*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010&\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u001a\u0010'\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0001\u001a\u0012\u0010)\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010*\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010+\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010,\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a4\u0010-\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u000b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010/\u001a\u000200H\u0007\u001a(\u00101\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u000200H\u0007\u001a4\u00102\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u00012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u00105\u001a\u000206H\u0007\u001a4\u00102\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u000b2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u00105\u001a\u000206H\u0007\u001a\n\u00107\u001a\u00020\u0006*\u00020\u0001\u001a\u001c\u00108\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u001e\u00109\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0014\u0010:\u001a\u0004\u0018\u00010;*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\n\u0010<\u001a\u00020\u0006*\u00020\u0001\u001a\u0012\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00010>*\u00020\u0001H\u0002\u001a\u001c\u0010?\u001a\u00020@*\u00020\u00012\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000bH\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\t\u0010\b\"\u0017\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006C"}, m107d2 = {"dataDirectory", "Ljava/io/File;", "Landroid/content/Context;", "getDataDirectory", "(Landroid/content/Context;)Ljava/io/File;", "inPrimaryStorage", "", "getInPrimaryStorage", "(Ljava/io/File;)Z", "isEmpty", "mimeType", "", "getMimeType", "(Ljava/io/File;)Ljava/lang/String;", "writableDirs", "", "getWritableDirs", "(Landroid/content/Context;)Ljava/util/Set;", "autoIncrementFileName", "filename", "canModify", "context", "checkRequirements", "requiresWriteAccess", "considerRawFile", "child", "path", "createNewFileIfPossible", "deleteEmptyFolders", "forceDelete", "childrenOnly", "getBasePath", "getRootPath", "getRootRawFile", "getSimplePath", "getStorageId", "getStorageType", "Lcom/anggrayudi/storage/file/StorageType;", "inDataStorage", "inSameMountPointWith", "file", "inSdCardStorage", "isExternalStorageManager", "isReadOnly", "isWritable", "makeFile", "name", "mode", "Lcom/anggrayudi/storage/file/CreateMode;", "makeFolder", "moveTo", "targetFolder", "newFileNameInTarget", "conflictResolution", "Lcom/anggrayudi/storage/callback/FileCallback$ConflictResolution;", "recreateFile", "shouldWritable", "takeIfWritable", "toDocumentFile", "Landroidx/documentfile/provider/DocumentFile;", "tryCreateNewFile", "walkFileTreeAndDeleteEmptyFolders", "", "walkFileTreeForMove", "", "srcPath", "destFolderPath", "storage_release"}, m106k = 2, m105mv = {1, 5, 1}, m103xi = 48)
/* renamed from: com.anggrayudi.storage.file.FileUtils */
/* loaded from: classes.dex */
public final class FileExt {

    /* compiled from: FileExt.kt */
    @Metadata(m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
    /* renamed from: com.anggrayudi.storage.file.FileUtils$WhenMappings */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FileCallback.ConflictResolution.values().length];
            iArr[FileCallback.ConflictResolution.SKIP.ordinal()] = 1;
            iArr[FileCallback.ConflictResolution.REPLACE.ordinal()] = 2;
            iArr[FileCallback.ConflictResolution.CREATE_NEW.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean forceDelete(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return forceDelete$default(file, false, 1, null);
    }

    public static final File getRootRawFile(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return getRootRawFile$default(file, context, false, 2, null);
    }

    public static final File makeFile(File file, Context context, String name) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        return makeFile$default(file, context, name, null, null, 12, null);
    }

    public static final File makeFile(File file, Context context, String name, String str) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        return makeFile$default(file, context, name, str, null, 8, null);
    }

    public static final File makeFolder(File file, Context context, String name) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        return makeFolder$default(file, context, name, null, 4, null);
    }

    public static final File moveTo(File file, Context context, File targetFolder) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(targetFolder, "targetFolder");
        return moveTo$default(file, context, targetFolder, (String) null, (FileCallback.ConflictResolution) null, 12, (Object) null);
    }

    public static final File moveTo(File file, Context context, File targetFolder, String str) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(targetFolder, "targetFolder");
        return moveTo$default(file, context, targetFolder, str, (FileCallback.ConflictResolution) null, 8, (Object) null);
    }

    public static final File moveTo(File file, Context context, String targetFolder) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(targetFolder, "targetFolder");
        return moveTo$default(file, context, targetFolder, (String) null, (FileCallback.ConflictResolution) null, 12, (Object) null);
    }

    public static final File moveTo(File file, Context context, String targetFolder, String str) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(targetFolder, "targetFolder");
        return moveTo$default(file, context, targetFolder, str, (FileCallback.ConflictResolution) null, 8, (Object) null);
    }

    public static final String getStorageId(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "path");
        if (StringsKt.startsWith$default(path, SimpleStorage.Companion.getExternalStoragePath(), false, 2, (Object) null)) {
            return StorageId.PRIMARY;
        }
        String path2 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "path");
        String path3 = getDataDirectory(context).getPath();
        Intrinsics.checkNotNullExpressionValue(path3, "context.dataDirectory.path");
        if (StringsKt.startsWith$default(path2, path3, false, 2, (Object) null)) {
            return "data";
        }
        String path4 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path4, "path");
        return StringsKt.substringBefore$default(StringsKt.substringAfter(path4, "/storage/", ""), (char) JsonPointer.SEPARATOR, (String) null, 2, (Object) null);
    }

    public static final boolean getInPrimaryStorage(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "path");
        return StringsKt.startsWith$default(path, SimpleStorage.Companion.getExternalStoragePath(), false, 2, (Object) null);
    }

    public static final boolean inDataStorage(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "path");
        String path2 = getDataDirectory(context).getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "context.dataDirectory.path");
        return StringsKt.startsWith$default(path, path2, false, 2, (Object) null);
    }

    public static final boolean inSdCardStorage(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String storageId = getStorageId(file, context);
        if (Intrinsics.areEqual(storageId, StorageId.PRIMARY) || Intrinsics.areEqual(storageId, "data")) {
            return false;
        }
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "path");
        return StringsKt.startsWith$default(path, Intrinsics.stringPlus("/storage/", storageId), false, 2, (Object) null);
    }

    public static final boolean inSameMountPointWith(File file, Context context, File file2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file2, "file");
        String storageId = getStorageId(file, context);
        String storageId2 = getStorageId(file2, context);
        return Intrinsics.areEqual(storageId, storageId2) || ((Intrinsics.areEqual(storageId, StorageId.PRIMARY) || Intrinsics.areEqual(storageId, "data")) && (Intrinsics.areEqual(storageId2, StorageId.PRIMARY) || Intrinsics.areEqual(storageId2, "data")));
    }

    public static final StorageType getStorageType(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return getInPrimaryStorage(file) ? StorageType.EXTERNAL : inDataStorage(file, context) ? StorageType.DATA : inSdCardStorage(file, context) ? StorageType.SD_CARD : StorageType.UNKNOWN;
    }

    public static final File child(File file, String path) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        return new File(file, path);
    }

    public static final File getDataDirectory(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (Build.VERSION.SDK_INT > 23) {
            File dataDir = context.getDataDir();
            Intrinsics.checkNotNullExpressionValue(dataDir, "dataDir");
            return dataDir;
        }
        File parentFile = context.getFilesDir().getParentFile();
        Intrinsics.checkNotNull(parentFile);
        return parentFile;
    }

    public static final String getBasePath(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String externalStoragePath = SimpleStorage.Companion.getExternalStoragePath();
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "path");
        if (StringsKt.startsWith$default(path, externalStoragePath, false, 2, (Object) null)) {
            String path2 = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path2, "path");
            return TextExt.trimFileSeparator(StringsKt.substringAfter(path2, externalStoragePath, ""));
        }
        String dataDir = getDataDirectory(context).getPath();
        String path3 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path3, "path");
        Intrinsics.checkNotNullExpressionValue(dataDir, "dataDir");
        if (StringsKt.startsWith$default(path3, dataDir, false, 2, (Object) null)) {
            String path4 = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path4, "path");
            return TextExt.trimFileSeparator(StringsKt.substringAfter(path4, dataDir, ""));
        }
        String storageId = getStorageId(file, context);
        String path5 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path5, "path");
        return TextExt.trimFileSeparator(StringsKt.substringAfter(path5, Intrinsics.stringPlus("/storage/", storageId), ""));
    }

    public static final String getRootPath(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String storageId = getStorageId(file, context);
        if (Intrinsics.areEqual(storageId, StorageId.PRIMARY)) {
            return SimpleStorage.Companion.getExternalStoragePath();
        }
        if (!Intrinsics.areEqual(storageId, "data")) {
            return storageId.length() > 0 ? Intrinsics.stringPlus("/storage/", storageId) : "";
        }
        String path = getDataDirectory(context).getPath();
        Intrinsics.checkNotNullExpressionValue(path, "context.dataDirectory.path");
        return path;
    }

    public static final String getSimplePath(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return StringsKt.removePrefix(getStorageId(file, context) + ':' + getBasePath(file, context), (CharSequence) ":");
    }

    public static final String getMimeType(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        if (file.isFile()) {
            return MimeType.getMimeTypeFromExtension(FilesKt.getExtension(file));
        }
        return null;
    }

    public static final File getRootRawFile(File file, Context context, boolean z) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String rootPath = getRootPath(file, context);
        if (rootPath.length() == 0) {
            return null;
        }
        File file2 = new File(rootPath);
        if (file2.canRead()) {
            return takeIfWritable(file2, context, z);
        }
        return null;
    }

    public static /* synthetic */ File getRootRawFile$default(File file, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return getRootRawFile(file, context, z);
    }

    public static final boolean isReadOnly(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return file.canRead() && !isWritable(file, context);
    }

    public static final boolean canModify(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return file.canRead() && isWritable(file, context);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean isEmpty(java.io.File r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            boolean r0 = r7.isFile()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L17
            long r3 = r7.length()
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L33
        L17:
            boolean r0 = r7.isDirectory()
            if (r0 == 0) goto L32
            java.lang.String[] r7 = r7.list()
            if (r7 == 0) goto L2e
            int r7 = r7.length
            if (r7 != 0) goto L28
            r7 = 1
            goto L29
        L28:
            r7 = 0
        L29:
            if (r7 == 0) goto L2c
            goto L2e
        L2c:
            r7 = 0
            goto L2f
        L2e:
            r7 = 1
        L2f:
            if (r7 == 0) goto L32
            goto L33
        L32:
            r1 = 0
        L33:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.FileExt.isEmpty(java.io.File):boolean");
    }

    public static final boolean shouldWritable(File file, Context context, boolean z) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return (z && isWritable(file, context)) || !z;
    }

    public static final File takeIfWritable(File file, Context context, boolean z) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (shouldWritable(file, context, z)) {
            return file;
        }
        return null;
    }

    public static final boolean checkRequirements(File file, Context context, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return file.canRead() && (z2 || isExternalStorageManager(file, context)) && shouldWritable(file, context, z);
    }

    public static final boolean createNewFileIfPossible(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        try {
            if (!file.isFile()) {
                if (!file.createNewFile()) {
                    return false;
                }
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static final boolean isWritable(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return file.canWrite() && (file.isFile() || isExternalStorageManager(file, context));
    }

    public static final boolean isExternalStorageManager(File file, Context context) {
        boolean z;
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT <= 29 || !Environment.isExternalStorageManager(file)) {
            if (Build.VERSION.SDK_INT < 29) {
                String path = file.getPath();
                Intrinsics.checkNotNullExpressionValue(path, "path");
                if (StringsKt.startsWith$default(path, SimpleStorage.Companion.getExternalStoragePath(), false, 2, (Object) null) && SimpleStorage.Companion.hasStoragePermission(context)) {
                    return true;
                }
            }
            Set<File> writableDirs = getWritableDirs(context);
            if (!(writableDirs instanceof Collection) || !writableDirs.isEmpty()) {
                for (File file2 : writableDirs) {
                    String path2 = file.getPath();
                    Intrinsics.checkNotNullExpressionValue(path2, "path");
                    String path3 = file2.getPath();
                    Intrinsics.checkNotNullExpressionValue(path3, "it.path");
                    if (StringsKt.startsWith$default(path2, path3, false, 2, (Object) null)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            return z;
        }
        return true;
    }

    public static final Set<File> getWritableDirs(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Set<File> mutableSetOf = SetsKt.mutableSetOf(getDataDirectory(context));
        File[] obbDirs = ContextCompat.getObbDirs(context);
        Intrinsics.checkNotNullExpressionValue(obbDirs, "getObbDirs(this)");
        mutableSetOf.addAll(ArraysKt.filterNotNull(obbDirs));
        File[] externalFilesDirs = ContextCompat.getExternalFilesDirs(context, null);
        Intrinsics.checkNotNullExpressionValue(externalFilesDirs, "getExternalFilesDirs(this, null)");
        File[] fileArr = externalFilesDirs;
        ArrayList arrayList = new ArrayList();
        int length = fileArr.length;
        for (int i = 0; i < length; i++) {
            File file = fileArr[i];
            File parentFile = file == null ? null : file.getParentFile();
            if (parentFile != null) {
                arrayList.add(parentFile);
            }
        }
        mutableSetOf.addAll(arrayList);
        return mutableSetOf;
    }

    public static /* synthetic */ File makeFile$default(File file, Context context, String str, String str2, CreateMode createMode, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = MimeType.UNKNOWN;
        }
        if ((i & 8) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        return makeFile(file, context, str, str2, createMode);
    }

    public static final File makeFile(File file, Context context, String name, String str, CreateMode mode) {
        File file2;
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (file.isDirectory() && isWritable(file, context)) {
            String trimFileSeparator = TextExt.trimFileSeparator(DocumentFileCompat.INSTANCE.removeForbiddenCharsFromFilename$storage_release(name));
            String substringBeforeLast = StringsKt.substringBeforeLast(trimFileSeparator, (char) JsonPointer.SEPARATOR, "");
            if (substringBeforeLast.length() == 0) {
                file2 = file;
            } else {
                file2 = new File(file, substringBeforeLast);
                file2.mkdirs();
            }
            String substringAfterLast$default = StringsKt.substringAfterLast$default(trimFileSeparator, (char) JsonPointer.SEPARATOR, (String) null, 2, (Object) null);
            String substringAfterLast = StringsKt.substringAfterLast(trimFileSeparator, '.', "");
            if (!(substringAfterLast.length() > 0) || (str != null && !Intrinsics.areEqual(str, MimeType.UNKNOWN) && !Intrinsics.areEqual(str, MimeType.BINARY_FILE))) {
                substringAfterLast = MimeType.getExtensionFromMimeTypeOrFileName(str, trimFileSeparator);
            }
            String removeSuffix = StringsKt.removeSuffix(substringAfterLast$default, (CharSequence) Intrinsics.stringPlus(".", substringAfterLast));
            String trimEnd = StringsKt.trimEnd(removeSuffix + '.' + substringAfterLast, '.');
            if (mode != CreateMode.CREATE_NEW) {
                File file3 = new File(file2, trimEnd);
                if (file3.exists()) {
                    if (mode == CreateMode.REPLACE) {
                        if (!recreateFile(file3)) {
                            return null;
                        }
                    } else if (!file3.isFile()) {
                        return null;
                    }
                    return file3;
                }
            }
            try {
                File file4 = new File(file2, autoIncrementFileName(file, trimEnd));
                if (file4.createNewFile()) {
                    return file4;
                }
                return null;
            } catch (IOException unused) {
                return null;
            }
        }
        return null;
    }

    public static /* synthetic */ File makeFolder$default(File file, Context context, String str, CreateMode createMode, int i, Object obj) {
        if ((i & 4) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        return makeFolder(file, context, str, createMode);
    }

    public static final File makeFolder(File file, Context context, String name, CreateMode mode) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (file.isDirectory() && isWritable(file, context)) {
            List mutableList = CollectionsKt.toMutableList((Collection) DocumentFileCompat.INSTANCE.getDirectorySequence$storage_release(DocumentFileCompat.INSTANCE.removeForbiddenCharsFromFilename$storage_release(name)));
            String str = (String) CollectionsKt.removeFirstOrNull(mutableList);
            if (str == null) {
                return null;
            }
            if (mode == CreateMode.CREATE_NEW) {
                str = autoIncrementFileName(file, str);
            }
            File child = child(file, str);
            if (mode == CreateMode.REPLACE) {
                forceDelete(child, true);
            }
            child.mkdir();
            if (!mutableList.isEmpty()) {
                child = child(child, CollectionsKt.joinToString$default(mutableList, "/", null, null, 0, null, null, 62, null));
                child.mkdirs();
            }
            if (child.isDirectory()) {
                return child;
            }
            return null;
        }
        return null;
    }

    public static final DocumentFile toDocumentFile(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (file.canRead()) {
            return DocumentFileCompat.fromFile$default(context, file, null, false, false, 28, null);
        }
        return null;
    }

    public static final boolean deleteEmptyFolders(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (file.isDirectory() && isWritable(file, context)) {
            for (File file2 : CollectionsKt.reversed(walkFileTreeAndDeleteEmptyFolders(file))) {
                file2.delete();
            }
            return true;
        }
        return false;
    }

    private static final List<File> walkFileTreeAndDeleteEmptyFolders(File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File it : listFiles) {
                if (it.isDirectory() && !it.delete()) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    arrayList.add(it);
                    arrayList.addAll(walkFileTreeAndDeleteEmptyFolders(it));
                }
            }
        }
        return arrayList;
    }

    public static /* synthetic */ boolean forceDelete$default(File file, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return forceDelete(file, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean forceDelete(java.io.File r3, boolean r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            boolean r0 = r3.isDirectory()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L33
            boolean r0 = kotlin.p043io.FilesKt.deleteRecursively(r3)
            if (r4 == 0) goto L31
            r3.mkdir()
            boolean r4 = r3.isDirectory()
            if (r4 == 0) goto L40
            java.lang.String[] r3 = r3.list()
            if (r3 == 0) goto L2d
            int r3 = r3.length
            if (r3 != 0) goto L27
            r3 = 1
            goto L28
        L27:
            r3 = 0
        L28:
            if (r3 == 0) goto L2b
            goto L2d
        L2b:
            r3 = 0
            goto L2e
        L2d:
            r3 = 1
        L2e:
            if (r3 == 0) goto L40
            goto L3f
        L31:
            r1 = r0
            goto L40
        L33:
            boolean r4 = r3.delete()
            if (r4 != 0) goto L3f
            boolean r3 = r3.exists()
            if (r3 != 0) goto L40
        L3f:
            r1 = 1
        L40:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.FileExt.forceDelete(java.io.File, boolean):boolean");
    }

    public static final boolean recreateFile(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        forceDelete$default(file, false, 1, null);
        return tryCreateNewFile(file);
    }

    public static final boolean tryCreateNewFile(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0068, code lost:
        if (com.anggrayudi.storage.file.DocumentFileCompat.INSTANCE.getFILE_NAME_DUPLICATION_REGEX_WITHOUT_EXTENSION().matches(r3) == false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0071 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String autoIncrementFileName(java.io.File r16, java.lang.String r17) {
        /*
            r0 = r17
            java.lang.String r1 = "<this>"
            r2 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            java.lang.String r1 = "filename"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.io.File r1 = child(r16, r17)
            boolean r1 = r1.exists()
            if (r1 == 0) goto Le4
            r1 = 46
            r3 = 0
            r4 = 2
            java.lang.String r5 = kotlin.text.StringsKt.substringBeforeLast$default(r0, r1, r3, r4, r3)
            java.lang.String r6 = ""
            java.lang.String r0 = kotlin.text.StringsKt.substringAfterLast(r0, r1, r6)
            java.lang.String r7 = " ("
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r7)
            java.lang.String[] r2 = r16.list()
            r9 = 0
            if (r2 == 0) goto L34
            goto L36
        L34:
            java.lang.String[] r2 = new java.lang.String[r9]
        L36:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Collection r10 = (java.util.Collection) r10
            int r11 = r2.length
            r12 = 0
        L3f:
            r13 = 1
            if (r12 >= r11) goto L75
            r14 = r2[r12]
            java.lang.String r15 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r15)
            boolean r15 = kotlin.text.StringsKt.startsWith$default(r14, r8, r9, r4, r3)
            if (r15 == 0) goto L6b
            com.anggrayudi.storage.file.DocumentFileCompat r15 = com.anggrayudi.storage.file.DocumentFileCompat.INSTANCE
            kotlin.text.Regex r15 = r15.getFILE_NAME_DUPLICATION_REGEX_WITH_EXTENSION()
            r3 = r14
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r15 = r15.matches(r3)
            if (r15 != 0) goto L6c
            com.anggrayudi.storage.file.DocumentFileCompat r15 = com.anggrayudi.storage.file.DocumentFileCompat.INSTANCE
            kotlin.text.Regex r15 = r15.getFILE_NAME_DUPLICATION_REGEX_WITHOUT_EXTENSION()
            boolean r3 = r15.matches(r3)
            if (r3 == 0) goto L6b
            goto L6c
        L6b:
            r13 = 0
        L6c:
            if (r13 == 0) goto L71
            r10.add(r14)
        L71:
            int r12 = r12 + 1
            r3 = 0
            goto L3f
        L75:
            java.util.List r10 = (java.util.List) r10
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r2 = r10.iterator()
            boolean r3 = r2.hasNext()
            if (r3 != 0) goto L85
            r3 = 0
            goto La3
        L85:
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Comparable r3 = (java.lang.Comparable) r3
        L8d:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto La3
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Comparable r4 = (java.lang.Comparable) r4
            int r8 = r3.compareTo(r4)
            if (r8 >= 0) goto L8d
            r3 = r4
            goto L8d
        La3:
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto La8
            goto La9
        La8:
            r3 = r6
        La9:
            r2 = 40
            java.lang.String r2 = kotlin.text.StringsKt.substringAfterLast(r3, r2, r6)
            r3 = 41
            java.lang.String r2 = kotlin.text.StringsKt.substringBefore(r2, r3, r6)
            java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r2)
            if (r2 != 0) goto Lbd
            r2 = 0
            goto Lc1
        Lbd:
            int r2 = r2.intValue()
        Lc1:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            r3.append(r7)
            int r2 = r2 + r13
            r3.append(r2)
            java.lang.String r2 = ")."
            r3.append(r2)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            char[] r2 = new char[r13]
            r2[r9] = r1
            java.lang.String r0 = kotlin.text.StringsKt.trimEnd(r0, r2)
        Le4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.FileExt.autoIncrementFileName(java.io.File, java.lang.String):java.lang.String");
    }

    public static /* synthetic */ File moveTo$default(File file, Context context, String str, String str2, FileCallback.ConflictResolution conflictResolution, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            conflictResolution = FileCallback.ConflictResolution.CREATE_NEW;
        }
        return moveTo(file, context, str, str2, conflictResolution);
    }

    public static final File moveTo(File file, Context context, String targetFolder, String str, FileCallback.ConflictResolution conflictResolution) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(targetFolder, "targetFolder");
        Intrinsics.checkNotNullParameter(conflictResolution, "conflictResolution");
        return moveTo(file, context, new File(targetFolder), str, conflictResolution);
    }

    public static /* synthetic */ File moveTo$default(File file, Context context, File file2, String str, FileCallback.ConflictResolution conflictResolution, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            conflictResolution = FileCallback.ConflictResolution.CREATE_NEW;
        }
        return moveTo(file, context, file2, str, conflictResolution);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0087, code lost:
        if (forceDelete$default(r0, false, 1, null) == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.io.File moveTo(java.io.File r4, android.content.Context r5, java.io.File r6, java.lang.String r7, com.anggrayudi.storage.callback.FileCallback.ConflictResolution r8) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "targetFolder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "conflictResolution"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            boolean r0 = r4.exists()
            r1 = 0
            if (r0 == 0) goto Lba
            boolean r0 = isWritable(r4, r5)
            if (r0 != 0) goto L24
            goto Lba
        L24:
            r6.mkdirs()
            boolean r0 = r6.isDirectory()
            if (r0 == 0) goto Lba
            boolean r0 = isWritable(r6, r5)
            if (r0 != 0) goto L35
            goto Lba
        L35:
            if (r7 != 0) goto L3b
            java.lang.String r7 = r4.getName()
        L3b:
            java.lang.String r0 = "filename"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            java.io.File r0 = child(r6, r7)
            java.lang.String r2 = r4.getParent()
            java.lang.String r3 = r6.getPath()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 == 0) goto L5a
            boolean r4 = r4.renameTo(r0)
            if (r4 == 0) goto L59
            r1 = r0
        L59:
            return r1
        L5a:
            boolean r5 = inSameMountPointWith(r4, r5, r6)
            if (r5 != 0) goto L61
            return r1
        L61:
            boolean r5 = r0.exists()
            r2 = 1
            if (r5 == 0) goto L8a
            int[] r5 = com.anggrayudi.storage.file.FileExt.WhenMappings.$EnumSwitchMapping$0
            int r8 = r8.ordinal()
            r5 = r5[r8]
            if (r5 == r2) goto L89
            r8 = 2
            if (r5 == r8) goto L82
            r8 = 3
            if (r5 == r8) goto L79
            goto L8a
        L79:
            java.lang.String r5 = autoIncrementFileName(r6, r7)
            java.io.File r0 = child(r6, r5)
            goto L8a
        L82:
            r5 = 0
            boolean r5 = forceDelete$default(r0, r5, r2, r1)
            if (r5 != 0) goto L8a
        L89:
            return r1
        L8a:
            boolean r5 = r4.renameTo(r0)
            if (r5 == 0) goto L91
            return r0
        L91:
            boolean r5 = r4.isDirectory()
            if (r5 == 0) goto Lba
            r0.mkdirs()
            java.lang.String r5 = r4.getPath()
            java.lang.String r6 = "path"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.String r6 = r0.getPath()
            java.lang.String r7 = "dest.path"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            walkFileTreeForMove(r4, r5, r6)
            kotlin.p043io.FilesKt.deleteRecursively(r4)
            boolean r4 = isEmpty(r0)
            r4 = r4 ^ r2
            if (r4 == 0) goto Lba
            r1 = r0
        Lba:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.FileExt.moveTo(java.io.File, android.content.Context, java.io.File, java.lang.String, com.anggrayudi.storage.callback.FileCallback$ConflictResolution):java.io.File");
    }

    private static final void walkFileTreeForMove(File file, String str, String str2) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File it : listFiles) {
            String path = it.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "it.path");
            File file2 = new File(str2, StringsKt.trim(StringsKt.substringAfter$default(path, str, (String) null, 2, (Object) null), JsonPointer.SEPARATOR));
            if (it.isFile()) {
                it.renameTo(file2);
            } else {
                file2.mkdirs();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                walkFileTreeForMove(it, str, str2);
            }
        }
    }
}
