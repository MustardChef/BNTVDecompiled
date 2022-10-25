package com.anggrayudi.storage.media;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.extension.TextExt;
import com.anggrayudi.storage.file.CreateMode;
import com.anggrayudi.storage.file.DocumentFileCompat;
import com.anggrayudi.storage.file.DocumentFileExt;
import com.anggrayudi.storage.file.DocumentFileType;
import com.anggrayudi.storage.file.PublicDirectory;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p043io.Closeable;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: MediaStoreCompat.kt */
@Metadata(m108d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007J$\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007J.\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00142\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007J2\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J.\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u001a2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007J\"\u0010\u001b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0004H\u0007J\"\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J&\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0!2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\"\u0010\"\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004H\u0007J&\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0!2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u0004H\u0007J\"\u0010&\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010'\u001a\u00020(H\u0007J\"\u0010&\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0004H\u0007J\u001e\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0!2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J&\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0!2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u0004H\u0007J\u001e\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0!2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020.H\u0007J\u001e\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0!2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u0004H\u0007J\"\u0010,\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004H\u0007J\u0012\u00100\u001a\u0004\u0018\u00010\u00172\u0006\u00101\u001a\u00020\u0004H\u0003R\u001a\u0010\u0003\u001a\u00020\u00048GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u00062"}, m107d2 = {"Lcom/anggrayudi/storage/media/MediaStoreCompat;", "", "()V", "volumeName", "", "getVolumeName$annotations", "getVolumeName", "()Ljava/lang/String;", "createAudio", "Lcom/anggrayudi/storage/media/MediaFile;", "context", "Landroid/content/Context;", "file", "Lcom/anggrayudi/storage/media/FileDescription;", "relativeParentDirectory", "Lcom/anggrayudi/storage/media/AudioMediaDirectory;", "mode", "Lcom/anggrayudi/storage/file/CreateMode;", "createDownload", "createImage", "Lcom/anggrayudi/storage/media/ImageMediaDirectory;", "createMedia", "mediaType", "Lcom/anggrayudi/storage/media/MediaType;", "folderName", "createVideo", "Lcom/anggrayudi/storage/media/VideoMediaDirectory;", "fromBasePath", "basePath", "fromCursorToMediaFile", "cursor", "Landroid/database/Cursor;", "fromCursorToMediaFiles", "", "fromFileName", "name", "fromFileNameContains", "containsName", "fromMediaId", "id", "", "fromMediaType", "fromMimeType", "mimeType", "fromRelativePath", "publicDirectory", "Lcom/anggrayudi/storage/file/PublicDirectory;", "relativePath", "mediaTypeFromRelativePath", "cleanRelativePath", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class MediaStoreCompat {
    public static final MediaStoreCompat INSTANCE = new MediaStoreCompat();

    @JvmStatic
    public static final MediaFile createAudio(Context context, FileDescription file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        return createAudio$default(context, file, null, null, 12, null);
    }

    @JvmStatic
    public static final MediaFile createAudio(Context context, FileDescription file, AudioMediaDirectory relativeParentDirectory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(relativeParentDirectory, "relativeParentDirectory");
        return createAudio$default(context, file, relativeParentDirectory, null, 8, null);
    }

    @JvmStatic
    public static final MediaFile createDownload(Context context, FileDescription file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        return createDownload$default(context, file, null, 4, null);
    }

    @JvmStatic
    public static final MediaFile createImage(Context context, FileDescription file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        return createImage$default(context, file, null, null, 12, null);
    }

    @JvmStatic
    public static final MediaFile createImage(Context context, FileDescription file, ImageMediaDirectory relativeParentDirectory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(relativeParentDirectory, "relativeParentDirectory");
        return createImage$default(context, file, relativeParentDirectory, null, 8, null);
    }

    @JvmStatic
    public static final MediaFile createVideo(Context context, FileDescription file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        return createVideo$default(context, file, null, null, 12, null);
    }

    @JvmStatic
    public static final MediaFile createVideo(Context context, FileDescription file, VideoMediaDirectory relativeParentDirectory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(relativeParentDirectory, "relativeParentDirectory");
        return createVideo$default(context, file, relativeParentDirectory, null, 8, null);
    }

    @JvmStatic
    public static /* synthetic */ void getVolumeName$annotations() {
    }

    private MediaStoreCompat() {
    }

    public static final String getVolumeName() {
        return Build.VERSION.SDK_INT < 29 ? "external" : "external_primary";
    }

    public static /* synthetic */ MediaFile createDownload$default(Context context, FileDescription fileDescription, CreateMode createMode, int i, Object obj) {
        if ((i & 4) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        return createDownload(context, fileDescription, createMode);
    }

    @JvmStatic
    public static final MediaFile createDownload(Context context, FileDescription file, CreateMode mode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(mode, "mode");
        MediaStoreCompat mediaStoreCompat = INSTANCE;
        MediaType mediaType = MediaType.DOWNLOADS;
        String DIRECTORY_DOWNLOADS = Environment.DIRECTORY_DOWNLOADS;
        Intrinsics.checkNotNullExpressionValue(DIRECTORY_DOWNLOADS, "DIRECTORY_DOWNLOADS");
        return mediaStoreCompat.createMedia(context, mediaType, DIRECTORY_DOWNLOADS, file, mode);
    }

    public static /* synthetic */ MediaFile createImage$default(Context context, FileDescription fileDescription, ImageMediaDirectory imageMediaDirectory, CreateMode createMode, int i, Object obj) {
        if ((i & 4) != 0) {
            imageMediaDirectory = ImageMediaDirectory.PICTURES;
        }
        if ((i & 8) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        return createImage(context, fileDescription, imageMediaDirectory, createMode);
    }

    @JvmStatic
    public static final MediaFile createImage(Context context, FileDescription file, ImageMediaDirectory relativeParentDirectory, CreateMode mode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(relativeParentDirectory, "relativeParentDirectory");
        Intrinsics.checkNotNullParameter(mode, "mode");
        return INSTANCE.createMedia(context, MediaType.IMAGE, relativeParentDirectory.getFolderName(), file, mode);
    }

    public static /* synthetic */ MediaFile createAudio$default(Context context, FileDescription fileDescription, AudioMediaDirectory audioMediaDirectory, CreateMode createMode, int i, Object obj) {
        if ((i & 4) != 0) {
            audioMediaDirectory = AudioMediaDirectory.MUSIC;
        }
        if ((i & 8) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        return createAudio(context, fileDescription, audioMediaDirectory, createMode);
    }

    @JvmStatic
    public static final MediaFile createAudio(Context context, FileDescription file, AudioMediaDirectory relativeParentDirectory, CreateMode mode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(relativeParentDirectory, "relativeParentDirectory");
        Intrinsics.checkNotNullParameter(mode, "mode");
        return INSTANCE.createMedia(context, MediaType.AUDIO, relativeParentDirectory.getFolderName(), file, mode);
    }

    public static /* synthetic */ MediaFile createVideo$default(Context context, FileDescription fileDescription, VideoMediaDirectory videoMediaDirectory, CreateMode createMode, int i, Object obj) {
        if ((i & 4) != 0) {
            videoMediaDirectory = VideoMediaDirectory.MOVIES;
        }
        if ((i & 8) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        return createVideo(context, fileDescription, videoMediaDirectory, createMode);
    }

    @JvmStatic
    public static final MediaFile createVideo(Context context, FileDescription file, VideoMediaDirectory relativeParentDirectory, CreateMode mode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(relativeParentDirectory, "relativeParentDirectory");
        Intrinsics.checkNotNullParameter(mode, "mode");
        return INSTANCE.createMedia(context, MediaType.VIDEO, relativeParentDirectory.getFolderName(), file, mode);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01a9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0175 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.anggrayudi.storage.media.MediaFile createMedia(android.content.Context r21, com.anggrayudi.storage.media.MediaType r22, java.lang.String r23, com.anggrayudi.storage.media.FileDescription r24, com.anggrayudi.storage.file.CreateMode r25) {
        /*
            Method dump skipped, instructions count: 804
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.media.MediaStoreCompat.createMedia(android.content.Context, com.anggrayudi.storage.media.MediaType, java.lang.String, com.anggrayudi.storage.media.FileDescription, com.anggrayudi.storage.file.CreateMode):com.anggrayudi.storage.media.MediaFile");
    }

    @JvmStatic
    public static final MediaFile fromMediaId(Context context, MediaType mediaType, String id) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(id, "id");
        Uri writeUri = mediaType.getWriteUri();
        if (writeUri == null) {
            return null;
        }
        Uri build = writeUri.buildUpon().appendPath(id).build();
        Intrinsics.checkNotNullExpressionValue(build, "it.buildUpon().appendPath(id).build()");
        return new MediaFile(context, build);
    }

    @JvmStatic
    public static final MediaFile fromMediaId(Context context, MediaType mediaType, long j) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        return fromMediaId(context, mediaType, String.valueOf(j));
    }

    @JvmStatic
    public static final MediaFile fromFileName(Context context, MediaType mediaType, String name) {
        Cursor query;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(name, "name");
        if (Build.VERSION.SDK_INT < 29) {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), name);
            if (file.isFile() && file.canRead()) {
                return new MediaFile(context, file);
            }
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Uri readUri = mediaType.getReadUri();
        if (readUri == null || (query = contentResolver.query(readUri, new String[]{"_id"}, "_display_name = ?", new String[]{name}, null)) == null) {
            return null;
        }
        Cursor cursor = query;
        Throwable th = null;
        try {
            MediaFile fromCursorToMediaFile = INSTANCE.fromCursorToMediaFile(context, mediaType, cursor);
            Closeable.closeFinally(cursor, th);
            return fromCursorToMediaFile;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                Closeable.closeFinally(cursor, th2);
                throw th3;
            }
        }
    }

    @JvmStatic
    public static final MediaFile fromBasePath(Context context, MediaType mediaType, String basePath) {
        Cursor query;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(basePath, "basePath");
        String trimFileSeparator = TextExt.trimFileSeparator(DocumentFileCompat.INSTANCE.removeForbiddenCharsFromFilename$storage_release(basePath));
        if (Build.VERSION.SDK_INT < 29) {
            File file = new File(Environment.getExternalStorageDirectory(), trimFileSeparator);
            if (file.isFile() && file.canRead()) {
                return new MediaFile(context, file);
            }
            return null;
        }
        String substringBeforeLast = StringsKt.substringBeforeLast(trimFileSeparator, (char) JsonPointer.SEPARATOR, "");
        if (substringBeforeLast.length() == 0) {
            return null;
        }
        String substringAfterLast$default = StringsKt.substringAfterLast$default(trimFileSeparator, (char) JsonPointer.SEPARATOR, (String) null, 2, (Object) null);
        ContentResolver contentResolver = context.getContentResolver();
        Uri readUri = mediaType.getReadUri();
        if (readUri == null || (query = contentResolver.query(readUri, new String[]{"_id"}, "_display_name = ? AND relative_path = ?", new String[]{substringAfterLast$default, Intrinsics.stringPlus(substringBeforeLast, "/")}, null)) == null) {
            return null;
        }
        Cursor cursor = query;
        Throwable th = null;
        try {
            MediaFile fromCursorToMediaFile = INSTANCE.fromCursorToMediaFile(context, mediaType, cursor);
            Closeable.closeFinally(cursor, th);
            return fromCursorToMediaFile;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                Closeable.closeFinally(cursor, th2);
                throw th3;
            }
        }
    }

    private final MediaType mediaTypeFromRelativePath(String str) {
        if (Intrinsics.areEqual(str, Environment.DIRECTORY_DCIM) ? true : Intrinsics.areEqual(str, Environment.DIRECTORY_PICTURES)) {
            return MediaType.IMAGE;
        }
        if (Intrinsics.areEqual(str, Environment.DIRECTORY_MOVIES) ? true : Intrinsics.areEqual(str, Environment.DIRECTORY_DCIM)) {
            return MediaType.VIDEO;
        }
        if (Intrinsics.areEqual(str, Environment.DIRECTORY_MUSIC) ? true : Intrinsics.areEqual(str, Environment.DIRECTORY_PODCASTS) ? true : Intrinsics.areEqual(str, Environment.DIRECTORY_RINGTONES) ? true : Intrinsics.areEqual(str, Environment.DIRECTORY_ALARMS) ? true : Intrinsics.areEqual(str, Environment.DIRECTORY_NOTIFICATIONS)) {
            return MediaType.AUDIO;
        }
        if (Intrinsics.areEqual(str, Environment.DIRECTORY_DOWNLOADS)) {
            return MediaType.DOWNLOADS;
        }
        return null;
    }

    @JvmStatic
    public static final List<MediaFile> fromRelativePath(Context context, PublicDirectory publicDirectory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(publicDirectory, "publicDirectory");
        return fromRelativePath(context, publicDirectory.getFolderName());
    }

    @JvmStatic
    public static final List<MediaFile> fromRelativePath(Context context, String relativePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        String trimFileSeparator = TextExt.trimFileSeparator(relativePath);
        if (Build.VERSION.SDK_INT < 29) {
            DocumentFile fromFile = DocumentFile.fromFile(new File(Environment.getExternalStorageDirectory(), trimFileSeparator));
            Intrinsics.checkNotNullExpressionValue(fromFile, "fromFile(File(Environment.getExternalStorageDirectory(), cleanRelativePath))");
            List<DocumentFile> search$default = DocumentFileExt.search$default(fromFile, true, DocumentFileType.FILE, null, null, null, 28, null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(search$default, 10));
            for (DocumentFile documentFile : search$default) {
                String path = documentFile.getUri().getPath();
                Intrinsics.checkNotNull(path);
                arrayList.add(new MediaFile(context, new File(path)));
            }
            return arrayList;
        }
        MediaStoreCompat mediaStoreCompat = INSTANCE;
        MediaType mediaTypeFromRelativePath = mediaStoreCompat.mediaTypeFromRelativePath(trimFileSeparator);
        if (mediaTypeFromRelativePath == null) {
            return CollectionsKt.emptyList();
        }
        String[] strArr = {Intrinsics.stringPlus(StringsKt.trimEnd(relativePath, JsonPointer.SEPARATOR), "/"), trimFileSeparator};
        ContentResolver contentResolver = context.getContentResolver();
        Uri readUri = mediaTypeFromRelativePath.getReadUri();
        if (readUri == null) {
            return CollectionsKt.emptyList();
        }
        Cursor query = contentResolver.query(readUri, new String[]{"_id"}, "relative_path IN(?, ?)", strArr, null);
        List<MediaFile> list = null;
        if (query != null) {
            Cursor cursor = query;
            Throwable th = null;
            try {
                List<MediaFile> fromCursorToMediaFiles = mediaStoreCompat.fromCursorToMediaFiles(context, mediaTypeFromRelativePath, cursor);
                Closeable.closeFinally(cursor, th);
                list = fromCursorToMediaFiles;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    Closeable.closeFinally(cursor, th2);
                    throw th3;
                }
            }
        }
        return list != null ? list : CollectionsKt.emptyList();
    }

    @JvmStatic
    public static final MediaFile fromRelativePath(Context context, String relativePath, String name) {
        Cursor query;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        Intrinsics.checkNotNullParameter(name, "name");
        String trimFileSeparator = TextExt.trimFileSeparator(relativePath);
        if (Build.VERSION.SDK_INT < 29) {
            DocumentFile fromFile = DocumentFile.fromFile(new File(Environment.getExternalStorageDirectory(), trimFileSeparator));
            Intrinsics.checkNotNullExpressionValue(fromFile, "fromFile(File(Environment.getExternalStorageDirectory(), cleanRelativePath))");
            List<DocumentFile> search$default = DocumentFileExt.search$default(fromFile, true, DocumentFileType.FILE, null, name, null, 20, null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(search$default, 10));
            for (DocumentFile documentFile : search$default) {
                String path = documentFile.getUri().getPath();
                Intrinsics.checkNotNull(path);
                arrayList.add(new MediaFile(context, new File(path)));
            }
            return (MediaFile) CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        }
        MediaStoreCompat mediaStoreCompat = INSTANCE;
        MediaType mediaTypeFromRelativePath = mediaStoreCompat.mediaTypeFromRelativePath(trimFileSeparator);
        if (mediaTypeFromRelativePath == null) {
            return null;
        }
        String[] strArr = {name, Intrinsics.stringPlus(StringsKt.trimEnd(relativePath, JsonPointer.SEPARATOR), "/"), trimFileSeparator};
        ContentResolver contentResolver = context.getContentResolver();
        Uri readUri = mediaTypeFromRelativePath.getReadUri();
        if (readUri == null || (query = contentResolver.query(readUri, new String[]{"_id"}, "_display_name = ? AND relative_path IN(?, ?)", strArr, null)) == null) {
            return null;
        }
        Cursor cursor = query;
        Throwable th = null;
        try {
            MediaFile fromCursorToMediaFile = mediaStoreCompat.fromCursorToMediaFile(context, mediaTypeFromRelativePath, cursor);
            Closeable.closeFinally(cursor, th);
            return fromCursorToMediaFile;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                Closeable.closeFinally(cursor, th2);
                throw th3;
            }
        }
    }

    @JvmStatic
    public static final List<MediaFile> fromFileNameContains(Context context, MediaType mediaType, String containsName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(containsName, "containsName");
        if (Build.VERSION.SDK_INT < 29) {
            List<File> directories = mediaType.getDirectories();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(directories, 10));
            for (File file : directories) {
                Regex regex = new Regex("^.*" + containsName + ".*$");
                String[] strArr = {mediaType.getMimeType()};
                DocumentFile fromFile = DocumentFile.fromFile(file);
                Intrinsics.checkNotNullExpressionValue(fromFile, "fromFile(directory)");
                List<DocumentFile> search$default = DocumentFileExt.search$default(fromFile, true, null, strArr, null, regex, 10, null);
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(search$default, 10));
                for (DocumentFile documentFile : search$default) {
                    String path = documentFile.getUri().getPath();
                    Intrinsics.checkNotNull(path);
                    arrayList2.add(new MediaFile(context, new File(path)));
                }
                arrayList.add(arrayList2);
            }
            return CollectionsKt.flatten(arrayList);
        }
        String str = "_display_name LIKE '%" + containsName + "%'";
        ContentResolver contentResolver = context.getContentResolver();
        Uri readUri = mediaType.getReadUri();
        if (readUri == null) {
            return CollectionsKt.emptyList();
        }
        Cursor query = contentResolver.query(readUri, new String[]{"_id"}, str, null, null);
        List<MediaFile> list = null;
        if (query != null) {
            Cursor cursor = query;
            Throwable th = null;
            try {
                List<MediaFile> fromCursorToMediaFiles = INSTANCE.fromCursorToMediaFiles(context, mediaType, cursor);
                Closeable.closeFinally(cursor, th);
                list = fromCursorToMediaFiles;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    Closeable.closeFinally(cursor, th2);
                    throw th3;
                }
            }
        }
        return list != null ? list : CollectionsKt.emptyList();
    }

    @JvmStatic
    public static final List<MediaFile> fromMimeType(Context context, MediaType mediaType, String mimeType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        if (Build.VERSION.SDK_INT < 29) {
            List<File> directories = mediaType.getDirectories();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(directories, 10));
            for (File file : directories) {
                DocumentFile fromFile = DocumentFile.fromFile(file);
                Intrinsics.checkNotNullExpressionValue(fromFile, "fromFile(directory)");
                List<DocumentFile> search$default = DocumentFileExt.search$default(fromFile, true, DocumentFileType.FILE, new String[]{mimeType}, null, null, 24, null);
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(search$default, 10));
                for (DocumentFile documentFile : search$default) {
                    String path = documentFile.getUri().getPath();
                    Intrinsics.checkNotNull(path);
                    arrayList2.add(new MediaFile(context, new File(path)));
                }
                arrayList.add(arrayList2);
            }
            return CollectionsKt.flatten(arrayList);
        }
        ContentResolver contentResolver = context.getContentResolver();
        Uri readUri = mediaType.getReadUri();
        if (readUri == null) {
            return CollectionsKt.emptyList();
        }
        Cursor query = contentResolver.query(readUri, new String[]{"_id"}, "mime_type = ?", new String[]{mimeType}, null);
        List<MediaFile> list = null;
        if (query != null) {
            Cursor cursor = query;
            Throwable th = null;
            try {
                List<MediaFile> fromCursorToMediaFiles = INSTANCE.fromCursorToMediaFiles(context, mediaType, cursor);
                Closeable.closeFinally(cursor, th);
                list = fromCursorToMediaFiles;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    Closeable.closeFinally(cursor, th2);
                    throw th3;
                }
            }
        }
        return list != null ? list : CollectionsKt.emptyList();
    }

    @JvmStatic
    public static final List<MediaFile> fromMediaType(Context context, MediaType mediaType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        if (Build.VERSION.SDK_INT < 29) {
            List<File> directories = mediaType.getDirectories();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(directories, 10));
            for (File file : directories) {
                DocumentFile fromFile = DocumentFile.fromFile(file);
                Intrinsics.checkNotNullExpressionValue(fromFile, "fromFile(directory)");
                List<DocumentFile> search$default = DocumentFileExt.search$default(fromFile, true, null, new String[]{mediaType.getMimeType()}, null, null, 26, null);
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(search$default, 10));
                for (DocumentFile documentFile : search$default) {
                    String path = documentFile.getUri().getPath();
                    Intrinsics.checkNotNull(path);
                    arrayList2.add(new MediaFile(context, new File(path)));
                }
                arrayList.add(arrayList2);
            }
            return CollectionsKt.flatten(arrayList);
        }
        ContentResolver contentResolver = context.getContentResolver();
        Uri readUri = mediaType.getReadUri();
        if (readUri == null) {
            return CollectionsKt.emptyList();
        }
        Cursor query = contentResolver.query(readUri, new String[]{"_id"}, null, null, null);
        List<MediaFile> list = null;
        if (query != null) {
            Cursor cursor = query;
            Throwable th = null;
            try {
                List<MediaFile> fromCursorToMediaFiles = INSTANCE.fromCursorToMediaFiles(context, mediaType, cursor);
                Closeable.closeFinally(cursor, th);
                list = fromCursorToMediaFiles;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    Closeable.closeFinally(cursor, th2);
                    throw th3;
                }
            }
        }
        return list != null ? list : CollectionsKt.emptyList();
    }

    private final List<MediaFile> fromCursorToMediaFiles(Context context, MediaType mediaType, Cursor cursor) {
        if (cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex("_id");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            do {
                String mediaId = cursor.getString(columnIndex);
                Intrinsics.checkNotNullExpressionValue(mediaId, "mediaId");
                MediaFile fromMediaId = fromMediaId(context, mediaType, mediaId);
                if (fromMediaId != null) {
                    arrayList.add(fromMediaId);
                }
            } while (cursor.moveToNext());
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    private final MediaFile fromCursorToMediaFile(Context context, MediaType mediaType, Cursor cursor) {
        if (cursor.moveToFirst()) {
            String mediaId = cursor.getString(cursor.getColumnIndex("_id"));
            Intrinsics.checkNotNullExpressionValue(mediaId, "mediaId");
            return fromMediaId(context, mediaType, mediaId);
        }
        return null;
    }
}
