package com.anggrayudi.storage.media;

import android.app.RecoverableSecurityException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.format.Formatter;
import androidx.core.content.FileProvider;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.SimpleStorage;
import com.anggrayudi.storage.callback.FileCallback;
import com.anggrayudi.storage.extension.CoroutineExt;
import com.anggrayudi.storage.extension.IOExt;
import com.anggrayudi.storage.extension.PrimitivesExt;
import com.anggrayudi.storage.extension.TextExt;
import com.anggrayudi.storage.extension.UriExt;
import com.anggrayudi.storage.file.CreateMode;
import com.anggrayudi.storage.file.DocumentFileCompat;
import com.anggrayudi.storage.file.DocumentFileExt;
import com.anggrayudi.storage.file.MimeType;
import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.p043io.Closeable;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.AgentOptions;

/* compiled from: MediaFile.kt */
@Metadata(m108d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001qB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ@\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u001a2\u0006\u0010G\u001a\u00020+2\u0006\u0010H\u001a\u00020\u001a2\u0006\u0010I\u001a\u00020JH\u0002J$\u0010K\u001a\u00020?2\u0006\u0010L\u001a\u00020E2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010I\u001a\u00020JH\u0007J3\u0010O\u001a\u00020?2\u0006\u0010D\u001a\u00020E2\u0006\u0010I\u001a\u00020J2\u0018\u0010P\u001a\u0014\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020?0QH\u0082\bJ4\u0010R\u001a\u0004\u0018\u00010E2\u0006\u0010S\u001a\u00020E2\u0006\u0010T\u001a\u00020\u000b2\b\u00102\u001a\u0004\u0018\u00010\u000b2\u0006\u0010U\u001a\u00020V2\u0006\u0010I\u001a\u00020JH\u0002J\u0006\u0010W\u001a\u00020\u001aJ\u0013\u0010X\u001a\u00020\u001a2\b\u0010Y\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0010\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u000bH\u0002J\u0010\u0010]\u001a\u00020+2\u0006\u0010\\\u001a\u00020\u000bH\u0002J\u0012\u0010^\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\\\u001a\u00020\u000bH\u0002J \u0010_\u001a\u00020`2\u0006\u0010L\u001a\u00020E2\u0006\u0010T\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020JH\u0002J\u001c\u0010a\u001a\u00020?2\u0006\u0010b\u001a\u00020c2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010JH\u0002J\b\u0010d\u001a\u00020[H\u0016J$\u0010e\u001a\u00020?2\u0006\u0010L\u001a\u00020E2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010I\u001a\u00020JH\u0007J\u0010\u0010e\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u000bH\u0007J\u0010\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020\u000bH\u0007J\n\u0010i\u001a\u0004\u0018\u00010AH\u0007J\u0014\u0010j\u001a\u0004\u0018\u00010C2\b\b\u0002\u0010k\u001a\u00020\u001aH\u0007J\u000e\u0010l\u001a\u00020\u001a2\u0006\u0010m\u001a\u00020\u000bJ\b\u0010n\u001a\u0004\u0018\u00010EJ\n\u0010o\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010p\u001a\u00020\u000bH\u0016R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0011\u0010\u0016\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0016\u0010\u0002\u001a\n \u0018*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\rR\u0011\u0010\u001f\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b \u0010\rR\u0011\u0010!\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\"\u0010\rR\u0011\u0010#\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b#\u0010\u001cR\u0011\u0010$\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b$\u0010\u001cR$\u0010&\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001a8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b)\u0010\u001cR\u0011\u0010*\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b,\u0010-R$\u0010.\u001a\u00020+2\u0006\u0010%\u001a\u00020+8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b/\u0010-\"\u0004\b0\u00101R\u0013\u00102\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b3\u0010\rR\u0013\u00104\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b5\u0010\rR\u0013\u00106\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b7\u0010\rR\u0011\u00108\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b9\u0010\rR\u0013\u0010:\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b;\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=¨\u0006r"}, m107d2 = {"Lcom/anggrayudi/storage/media/MediaFile;", "", "context", "Landroid/content/Context;", "rawFile", "Ljava/io/File;", "(Landroid/content/Context;Ljava/io/File;)V", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "(Landroid/content/Context;Landroid/net/Uri;)V", "absolutePath", "", "getAbsolutePath", "()Ljava/lang/String;", "accessCallback", "Lcom/anggrayudi/storage/media/MediaFile$AccessCallback;", "getAccessCallback", "()Lcom/anggrayudi/storage/media/MediaFile$AccessCallback;", "setAccessCallback", "(Lcom/anggrayudi/storage/media/MediaFile$AccessCallback;)V", "baseName", "getBaseName", "basePath", "getBasePath", "kotlin.jvm.PlatformType", "exists", "", "getExists", "()Z", ShareConstants.MEDIA_EXTENSION, "getExtension", "formattedSize", "getFormattedSize", "fullName", "getFullName", "isEmpty", "isMine", "value", "isPending", "setPending", "(Z)V", "isRawFile", "lastModified", "", "getLastModified", "()J", SessionDescription.ATTR_LENGTH, "getLength", "setLength", "(J)V", "mimeType", "getMimeType", "name", "getName", "owner", "getOwner", "relativePath", "getRelativePath", "type", "getType", "getUri", "()Landroid/net/Uri;", "copyFileStream", "", "inputStream", "Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "targetFile", "Landroidx/documentfile/provider/DocumentFile;", "watchProgress", "reportInterval", "deleteSourceFileWhenComplete", "callback", "Lcom/anggrayudi/storage/callback/FileCallback;", "copyTo", "targetFolder", "fileDescription", "Lcom/anggrayudi/storage/media/FileDescription;", "createFileStreams", "onStreamsReady", "Lkotlin/Function2;", "createTargetFile", "targetDirectory", "fileName", "mode", "Lcom/anggrayudi/storage/file/CreateMode;", "delete", "equals", "other", "getColumnInfoInt", "", "column", "getColumnInfoLong", "getColumnInfoString", "handleFileConflict", "Lcom/anggrayudi/storage/callback/FileCallback$ConflictResolution;", "handleSecurityException", "e", "Ljava/lang/SecurityException;", "hashCode", "moveTo", "openFileIntent", "Landroid/content/Intent;", "authority", "openInputStream", "openOutputStream", AgentOptions.APPEND, "renameTo", "newName", "toDocumentFile", "toRawFile", "toString", "AccessCallback", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class MediaFile {
    private AccessCallback accessCallback;
    private final Context context;
    private final Uri uri;

    /* compiled from: MediaFile.kt */
    @Metadata(m108d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, m107d2 = {"Lcom/anggrayudi/storage/media/MediaFile$AccessCallback;", "", "onWriteAccessDenied", "", "mediaFile", "Lcom/anggrayudi/storage/media/MediaFile;", "sender", "Landroid/content/IntentSender;", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes.dex */
    public interface AccessCallback {
        void onWriteAccessDenied(MediaFile mediaFile, IntentSender intentSender);
    }

    public final OutputStream openOutputStream() {
        return openOutputStream$default(this, false, 1, null);
    }

    public MediaFile(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
        this.context = context.getApplicationContext();
    }

    public final Uri getUri() {
        return this.uri;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MediaFile(android.content.Context r2, java.io.File r3) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "rawFile"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.net.Uri r3 = android.net.Uri.fromFile(r3)
            java.lang.String r0 = "fromFile(rawFile)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.media.MediaFile.<init>(android.content.Context, java.io.File):void");
    }

    public final AccessCallback getAccessCallback() {
        return this.accessCallback;
    }

    public final void setAccessCallback(AccessCallback accessCallback) {
        this.accessCallback = accessCallback;
    }

    public final String getFullName() {
        if (isRawFile()) {
            File rawFile = toRawFile();
            String name = rawFile == null ? null : rawFile.getName();
            return name != null ? name : "";
        }
        String columnInfoString = getColumnInfoString("mime_type");
        String columnInfoString2 = getColumnInfoString("_display_name");
        return MimeType.getFullFileName(columnInfoString2 != null ? columnInfoString2 : "", columnInfoString);
    }

    public final String getName() {
        File rawFile = toRawFile();
        String name = rawFile == null ? null : rawFile.getName();
        return name == null ? getColumnInfoString("_display_name") : name;
    }

    public final String getBaseName() {
        return StringsKt.substringBeforeLast$default(getFullName(), '.', (String) null, 2, (Object) null);
    }

    public final String getExtension() {
        return StringsKt.substringAfterLast(getFullName(), '.', "");
    }

    public final String getType() {
        String name;
        File rawFile = toRawFile();
        String str = null;
        if (rawFile != null && (name = rawFile.getName()) != null) {
            str = MimeType.getMimeTypeFromExtension(StringsKt.substringAfterLast(name, '.', ""));
        }
        return str == null ? getColumnInfoString("mime_type") : str;
    }

    public final String getMimeType() {
        if (getExists()) {
            String columnInfoString = getColumnInfoString("mime_type");
            return columnInfoString == null ? MimeType.getMimeTypeFromExtension(getExtension()) : columnInfoString;
        }
        return null;
    }

    public final long getLength() {
        File rawFile = toRawFile();
        Long valueOf = rawFile == null ? null : Long.valueOf(rawFile.length());
        return valueOf == null ? getColumnInfoLong("_size") : valueOf.longValue();
    }

    public final void setLength(long j) {
        try {
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("_size", Long.valueOf(j));
            this.context.getContentResolver().update(this.uri, contentValues, null, null);
        } catch (SecurityException e) {
            handleSecurityException$default(this, e, null, 2, null);
        }
    }

    public final String getFormattedSize() {
        String formatFileSize = Formatter.formatFileSize(this.context, getLength());
        Intrinsics.checkNotNullExpressionValue(formatFileSize, "formatFileSize(context, length)");
        return formatFileSize;
    }

    public final boolean getExists() {
        File rawFile = toRawFile();
        Boolean valueOf = rawFile == null ? null : Boolean.valueOf(rawFile.exists());
        if (valueOf != null) {
            return valueOf.booleanValue();
        }
        Uri uri = this.uri;
        Context context = this.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        InputStream openInputStream = UriExt.openInputStream(uri, context);
        if (openInputStream == null) {
            return false;
        }
        InputStream inputStream = openInputStream;
        try {
            InputStream inputStream2 = inputStream;
            Closeable.closeFinally(inputStream, null);
            return true;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                Closeable.closeFinally(inputStream, th);
                throw th2;
            }
        }
    }

    public final boolean isEmpty() {
        Cursor query = this.context.getContentResolver().query(this.uri, null, null, null, null);
        boolean z = false;
        if (query != null) {
            Cursor cursor = query;
            Throwable th = null;
            try {
                if (cursor.getCount() > 0) {
                    if (!getExists()) {
                        z = true;
                    }
                }
                Closeable.closeFinally(cursor, th);
            } finally {
            }
        }
        return z;
    }

    public final boolean isRawFile() {
        return UriExt.isRawFile(this.uri);
    }

    public final long getLastModified() {
        File rawFile = toRawFile();
        Long valueOf = rawFile == null ? null : Long.valueOf(rawFile.lastModified());
        if (valueOf != null) {
            return valueOf.longValue();
        }
        return getColumnInfoLong("date_modified");
    }

    public final String getOwner() {
        if (Build.VERSION.SDK_INT >= 29) {
            return getColumnInfoString("owner_package_name");
        }
        return null;
    }

    public final boolean isMine() {
        return Intrinsics.areEqual(getOwner(), this.context.getPackageName());
    }

    @Deprecated(message = "Accessing files with java.io.File only works on app private directory since Android 10.")
    public final File toRawFile() {
        String path;
        if (!isRawFile() || (path = this.uri.getPath()) == null) {
            return null;
        }
        return new File(path);
    }

    public final DocumentFile toDocumentFile() {
        String absolutePath = getAbsolutePath();
        if (absolutePath.length() == 0) {
            return null;
        }
        Context context = this.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return DocumentFileCompat.fromFullPath$default(context, absolutePath, null, false, false, 28, null);
    }

    public final String getAbsolutePath() {
        String str;
        File rawFile = toRawFile();
        if (rawFile != null) {
            String path = rawFile.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "file.path");
            return path;
        }
        String str2 = null;
        if (Build.VERSION.SDK_INT < 29) {
            try {
                Cursor query = this.context.getContentResolver().query(this.uri, new String[]{"_data"}, null, null, null);
                if (query != null) {
                    Cursor cursor = query;
                    Throwable th = null;
                    Cursor cursor2 = cursor;
                    String string = cursor2.moveToFirst() ? cursor2.getString(cursor2.getColumnIndex("_data")) : "";
                    Closeable.closeFinally(cursor, th);
                    str2 = string;
                }
                if (str2 == null) {
                    return "";
                }
            } catch (Exception unused) {
                return "";
            }
        } else {
            Cursor query2 = this.context.getContentResolver().query(this.uri, new String[]{"relative_path", "_display_name"}, null, null, null);
            if (query2 != null) {
                Cursor cursor3 = query2;
                Throwable th2 = null;
                try {
                    Cursor cursor4 = cursor3;
                    if (cursor4.moveToFirst()) {
                        String string2 = cursor4.getString(cursor4.getColumnIndex("relative_path"));
                        if (string2 == null) {
                            Closeable.closeFinally(cursor3, th2);
                            return "";
                        }
                        String string3 = cursor4.getString(cursor4.getColumnIndex("_display_name"));
                        str = TextExt.replaceCompletely(StringsKt.trimEnd(SimpleStorage.Companion.getExternalStoragePath() + JsonPointer.SEPARATOR + string2 + JsonPointer.SEPARATOR + ((Object) string3), JsonPointer.SEPARATOR), "//", "/");
                    } else {
                        str = "";
                    }
                    Closeable.closeFinally(cursor3, th2);
                    str2 = str;
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        Closeable.closeFinally(cursor3, th3);
                        throw th4;
                    }
                }
            }
            if (str2 == null) {
                return "";
            }
        }
        return str2;
    }

    public final String getBasePath() {
        return TextExt.trimFileSeparator(StringsKt.substringAfter$default(getAbsolutePath(), SimpleStorage.Companion.getExternalStoragePath(), (String) null, 2, (Object) null));
    }

    public final String getRelativePath() {
        File rawFile = toRawFile();
        String str = null;
        if (rawFile != null) {
            String path = rawFile.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "file.path");
            return Intrinsics.stringPlus(TextExt.trimFileSeparator(StringsKt.replaceFirst$default(StringsKt.substringBeforeLast$default(path, (char) JsonPointer.SEPARATOR, (String) null, 2, (Object) null), SimpleStorage.Companion.getExternalStoragePath(), "", false, 4, (Object) null)), "/");
        }
        if (Build.VERSION.SDK_INT < 29) {
            try {
                Cursor query = this.context.getContentResolver().query(this.uri, new String[]{"_data"}, null, null, null);
                if (query != null) {
                    Cursor cursor = query;
                    Throwable th = null;
                    Cursor cursor2 = cursor;
                    if (cursor2.moveToFirst()) {
                        String string = cursor2.getString(cursor2.getColumnIndex("_data"));
                        Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(cursor.getColumnIndex(MediaStore.MediaColumns.DATA))");
                        str = Intrinsics.stringPlus(TextExt.trimFileSeparator(StringsKt.replaceFirst$default(StringsKt.substringBeforeLast$default(string, (char) JsonPointer.SEPARATOR, (String) null, 2, (Object) null), SimpleStorage.Companion.getExternalStoragePath(), "", false, 4, (Object) null)), "/");
                    } else {
                        str = "";
                    }
                    Closeable.closeFinally(cursor, th);
                }
                if (str == null) {
                    return "";
                }
            } catch (Exception unused) {
                return "";
            }
        } else {
            Cursor query2 = this.context.getContentResolver().query(this.uri, new String[]{"relative_path"}, null, null, null);
            if (query2 != null) {
                Cursor cursor3 = query2;
                Throwable th2 = null;
                try {
                    Cursor cursor4 = cursor3;
                    String string2 = cursor4.moveToFirst() ? cursor4.getString(cursor4.getColumnIndex("relative_path")) : "";
                    Closeable.closeFinally(cursor3, th2);
                    str = string2;
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        Closeable.closeFinally(cursor3, th3);
                        throw th4;
                    }
                }
            }
            if (str == null) {
                return "";
            }
        }
        return str;
    }

    public final boolean delete() {
        File rawFile = toRawFile();
        if (rawFile != null) {
            if (rawFile.delete() || !rawFile.exists()) {
                return true;
            }
        } else {
            try {
                if (this.context.getContentResolver().delete(this.uri, null, null) > 0) {
                    return true;
                }
            } catch (SecurityException e) {
                handleSecurityException$default(this, e, null, 2, null);
            }
        }
        return false;
    }

    public final boolean renameTo(String newName) {
        Intrinsics.checkNotNullParameter(newName, "newName");
        File rawFile = toRawFile();
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("_display_name", newName);
        if (rawFile != null) {
            if (rawFile.renameTo(new File(rawFile.getParent(), newName)) && this.context.getContentResolver().update(this.uri, contentValues, null, null) > 0) {
                return true;
            }
        } else {
            try {
                if (this.context.getContentResolver().update(this.uri, contentValues, null, null) > 0) {
                    return true;
                }
            } catch (SecurityException e) {
                handleSecurityException$default(this, e, null, 2, null);
            }
        }
        return false;
    }

    public final boolean isPending() {
        return getColumnInfoInt("is_pending") == 1;
    }

    public final void setPending(boolean z) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("is_pending", Integer.valueOf(PrimitivesExt.toInt(Boolean.valueOf(z))));
        try {
            this.context.getContentResolver().update(this.uri, contentValues, null, null);
        } catch (SecurityException e) {
            handleSecurityException$default(this, e, null, 2, null);
        }
    }

    static /* synthetic */ void handleSecurityException$default(MediaFile mediaFile, SecurityException securityException, FileCallback fileCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            fileCallback = null;
        }
        mediaFile.handleSecurityException(securityException, fileCallback);
    }

    private final void handleSecurityException(SecurityException securityException, FileCallback fileCallback) {
        CoroutineScope uiScope;
        if (Build.VERSION.SDK_INT < 29 || !(securityException instanceof RecoverableSecurityException)) {
            if (fileCallback == null || (uiScope = fileCallback.getUiScope()) == null) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(uiScope, Dispatchers.getMain(), null, new MediaFile$handleSecurityException$$inlined$postToUi$1(null, fileCallback), 2, null);
            return;
        }
        AccessCallback accessCallback = this.accessCallback;
        if (accessCallback == null) {
            return;
        }
        IntentSender intentSender = ((RecoverableSecurityException) securityException).getUserAction().getActionIntent().getIntentSender();
        Intrinsics.checkNotNullExpressionValue(intentSender, "e.userAction.actionIntent.intentSender");
        accessCallback.onWriteAccessDenied(this, intentSender);
    }

    public final Intent openFileIntent(String authority) {
        Uri uri;
        Intrinsics.checkNotNullParameter(authority, "authority");
        Intent intent = new Intent("android.intent.action.VIEW");
        if (isRawFile()) {
            Context context = this.context;
            String path = this.uri.getPath();
            Intrinsics.checkNotNull(path);
            uri = FileProvider.getUriForFile(context, authority, new File(path));
        } else {
            uri = this.uri;
        }
        Intent addFlags = intent.setData(uri).addFlags(1).addFlags(268435456);
        Intrinsics.checkNotNullExpressionValue(addFlags, "Intent(Intent.ACTION_VIEW)\n        .setData(if (isRawFile) FileProvider.getUriForFile(context, authority, File(uri.path!!)) else uri)\n        .addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)\n        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)");
        return addFlags;
    }

    public static /* synthetic */ OutputStream openOutputStream$default(MediaFile mediaFile, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return mediaFile.openOutputStream(z);
    }

    public final OutputStream openOutputStream(boolean z) {
        FileOutputStream openOutputStream;
        try {
            File rawFile = toRawFile();
            if (rawFile != null) {
                openOutputStream = new FileOutputStream(rawFile, z);
            } else {
                openOutputStream = this.context.getContentResolver().openOutputStream(this.uri, z ? "wa" : "w");
            }
            return openOutputStream;
        } catch (IOException unused) {
            return null;
        }
    }

    public final InputStream openInputStream() {
        FileInputStream openInputStream;
        try {
            File rawFile = toRawFile();
            if (rawFile != null) {
                openInputStream = new FileInputStream(rawFile);
            } else {
                openInputStream = this.context.getContentResolver().openInputStream(this.uri);
            }
            return openInputStream;
        } catch (IOException unused) {
            return null;
        }
    }

    public final boolean moveTo(String relativePath) {
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("relative_path", relativePath);
        try {
            return this.context.getContentResolver().update(this.uri, contentValues, null, null) > 0;
        } catch (SecurityException e) {
            handleSecurityException$default(this, e, null, 2, null);
            return false;
        }
    }

    public static /* synthetic */ void moveTo$default(MediaFile mediaFile, DocumentFile documentFile, FileDescription fileDescription, FileCallback fileCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            fileDescription = null;
        }
        mediaFile.moveTo(documentFile, fileDescription, fileCallback);
    }

    public final void moveTo(DocumentFile documentFile, FileDescription fileDescription, FileCallback callback) {
        Object runBlocking$default;
        String mimeType;
        DocumentFile targetFolder = documentFile;
        Intrinsics.checkNotNullParameter(targetFolder, "targetFolder");
        Intrinsics.checkNotNullParameter(callback, "callback");
        DocumentFile documentFile2 = toDocumentFile();
        if (documentFile2 != null) {
            Context context = this.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            DocumentFileExt.moveFileTo(documentFile2, context, targetFolder, fileDescription, callback);
            return;
        }
        try {
            Context context2 = this.context;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            Context context3 = this.context;
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            if (!callback.onCheckFreeSpace(DocumentFileCompat.getFreeSpace(context2, DocumentFileExt.getStorageId(targetFolder, context3)), getLength())) {
                BuildersKt__Builders_commonKt.launch$default(callback.getUiScope(), Dispatchers.getMain(), null, new MediaFile$moveTo$$inlined$postToUi$1(null, callback), 2, null);
                return;
            }
            String subFolder = fileDescription == null ? null : fileDescription.getSubFolder();
            String str = "";
            if (!(subFolder == null || subFolder.length() == 0)) {
                Context context4 = this.context;
                Intrinsics.checkNotNullExpressionValue(context4, "context");
                String subFolder2 = fileDescription == null ? null : fileDescription.getSubFolder();
                if (subFolder2 == null) {
                    subFolder2 = "";
                }
                targetFolder = DocumentFileExt.makeFolder(targetFolder, context4, subFolder2, CreateMode.REUSE);
                if (targetFolder == null) {
                    BuildersKt__Builders_commonKt.launch$default(callback.getUiScope(), Dispatchers.getMain(), null, new MediaFile$moveTo$$inlined$postToUi$3(null, callback), 2, null);
                    return;
                }
            }
            DocumentFileCompat documentFileCompat = DocumentFileCompat.INSTANCE;
            String name = fileDescription == null ? null : fileDescription.getName();
            if (name != null || (name = getName()) != null) {
                str = name;
            }
            String mimeType2 = fileDescription == null ? null : fileDescription.getMimeType();
            if (mimeType2 == null) {
                mimeType2 = getType();
            }
            String trimFileSeparator = TextExt.trimFileSeparator(documentFileCompat.removeForbiddenCharsFromFilename$storage_release(MimeType.getFullFileName(str, mimeType2)));
            FileCallback.ConflictResolution handleFileConflict = handleFileConflict(targetFolder, trimFileSeparator, callback);
            if (handleFileConflict == FileCallback.ConflictResolution.SKIP) {
                return;
            }
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new MediaFile$moveTo$$inlined$awaitUiResult$1(callback.getUiScope(), null, callback, this, Thread.currentThread()), 1, null);
            long longValue = ((Number) runBlocking$default).longValue();
            boolean z = longValue > 0;
            if (fileDescription == null) {
                mimeType = null;
            } else {
                try {
                    mimeType = fileDescription.getMimeType();
                } catch (SecurityException e) {
                    handleSecurityException(e, callback);
                    return;
                } catch (Exception e2) {
                    BuildersKt__Builders_commonKt.launch$default(callback.getUiScope(), Dispatchers.getMain(), null, new MediaFile$moveTo$$inlined$postToUi$4(null, callback, e2), 2, null);
                    return;
                }
            }
            if (mimeType == null) {
                mimeType = getType();
            }
            DocumentFile createTargetFile = createTargetFile(targetFolder, trimFileSeparator, mimeType, handleFileConflict.toCreateMode(), callback);
            if (createTargetFile == null) {
                return;
            }
            Context context5 = this.context;
            Intrinsics.checkNotNullExpressionValue(context5, "context");
            OutputStream openOutputStream$default = DocumentFileExt.openOutputStream$default(createTargetFile, context5, false, 2, null);
            if (openOutputStream$default == null) {
                BuildersKt__Builders_commonKt.launch$default(callback.getUiScope(), Dispatchers.getMain(), null, new MediaFile$createFileStreams$$inlined$postToUi$1(null, callback), 2, null);
                return;
            }
            InputStream openInputStream = openInputStream();
            if (openInputStream == null) {
                BuildersKt__Builders_commonKt.launch$default(callback.getUiScope(), Dispatchers.getMain(), null, new MediaFile$createFileStreams$$inlined$postToUi$2(null, callback), 2, null);
                IOExt.closeStream(openOutputStream$default);
                return;
            }
            copyFileStream(openInputStream, openOutputStream$default, createTargetFile, z, longValue, true, callback);
        } catch (Throwable unused) {
            BuildersKt__Builders_commonKt.launch$default(callback.getUiScope(), Dispatchers.getMain(), null, new MediaFile$moveTo$$inlined$postToUi$2(null, callback), 2, null);
        }
    }

    public static /* synthetic */ void copyTo$default(MediaFile mediaFile, DocumentFile documentFile, FileDescription fileDescription, FileCallback fileCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            fileDescription = null;
        }
        mediaFile.copyTo(documentFile, fileDescription, fileCallback);
    }

    public final void copyTo(DocumentFile documentFile, FileDescription fileDescription, FileCallback callback) {
        Object runBlocking$default;
        String mimeType;
        DocumentFile targetFolder = documentFile;
        Intrinsics.checkNotNullParameter(targetFolder, "targetFolder");
        Intrinsics.checkNotNullParameter(callback, "callback");
        DocumentFile documentFile2 = toDocumentFile();
        if (documentFile2 != null) {
            Context context = this.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            DocumentFileExt.copyFileTo(documentFile2, context, targetFolder, fileDescription, callback);
            return;
        }
        try {
            Context context2 = this.context;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            Context context3 = this.context;
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            if (!callback.onCheckFreeSpace(DocumentFileCompat.getFreeSpace(context2, DocumentFileExt.getStorageId(targetFolder, context3)), getLength())) {
                BuildersKt__Builders_commonKt.launch$default(callback.getUiScope(), Dispatchers.getMain(), null, new MediaFile$copyTo$$inlined$postToUi$1(null, callback), 2, null);
                return;
            }
            String subFolder = fileDescription == null ? null : fileDescription.getSubFolder();
            String str = "";
            if (!(subFolder == null || subFolder.length() == 0)) {
                Context context4 = this.context;
                Intrinsics.checkNotNullExpressionValue(context4, "context");
                String subFolder2 = fileDescription == null ? null : fileDescription.getSubFolder();
                if (subFolder2 == null) {
                    subFolder2 = "";
                }
                targetFolder = DocumentFileExt.makeFolder(targetFolder, context4, subFolder2, CreateMode.REUSE);
                if (targetFolder == null) {
                    BuildersKt__Builders_commonKt.launch$default(callback.getUiScope(), Dispatchers.getMain(), null, new MediaFile$copyTo$$inlined$postToUi$3(null, callback), 2, null);
                    return;
                }
            }
            DocumentFileCompat documentFileCompat = DocumentFileCompat.INSTANCE;
            String name = fileDescription == null ? null : fileDescription.getName();
            if (name != null || (name = getName()) != null) {
                str = name;
            }
            String mimeType2 = fileDescription == null ? null : fileDescription.getMimeType();
            if (mimeType2 == null) {
                mimeType2 = getType();
            }
            String trimFileSeparator = TextExt.trimFileSeparator(documentFileCompat.removeForbiddenCharsFromFilename$storage_release(MimeType.getFullFileName(str, mimeType2)));
            FileCallback.ConflictResolution handleFileConflict = handleFileConflict(targetFolder, trimFileSeparator, callback);
            if (handleFileConflict == FileCallback.ConflictResolution.SKIP) {
                return;
            }
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new MediaFile$copyTo$$inlined$awaitUiResult$1(callback.getUiScope(), null, callback, this, Thread.currentThread()), 1, null);
            long longValue = ((Number) runBlocking$default).longValue();
            boolean z = longValue > 0;
            if (fileDescription == null) {
                mimeType = null;
            } else {
                try {
                    mimeType = fileDescription.getMimeType();
                } catch (SecurityException e) {
                    handleSecurityException(e, callback);
                    return;
                } catch (Exception e2) {
                    BuildersKt__Builders_commonKt.launch$default(callback.getUiScope(), Dispatchers.getMain(), null, new MediaFile$copyTo$$inlined$postToUi$4(null, callback, e2), 2, null);
                    return;
                }
            }
            if (mimeType == null) {
                mimeType = getType();
            }
            DocumentFile createTargetFile = createTargetFile(targetFolder, trimFileSeparator, mimeType, handleFileConflict.toCreateMode(), callback);
            if (createTargetFile == null) {
                return;
            }
            Context context5 = this.context;
            Intrinsics.checkNotNullExpressionValue(context5, "context");
            OutputStream openOutputStream$default = DocumentFileExt.openOutputStream$default(createTargetFile, context5, false, 2, null);
            if (openOutputStream$default == null) {
                BuildersKt__Builders_commonKt.launch$default(callback.getUiScope(), Dispatchers.getMain(), null, new MediaFile$createFileStreams$$inlined$postToUi$1(null, callback), 2, null);
                return;
            }
            InputStream openInputStream = openInputStream();
            if (openInputStream == null) {
                BuildersKt__Builders_commonKt.launch$default(callback.getUiScope(), Dispatchers.getMain(), null, new MediaFile$createFileStreams$$inlined$postToUi$2(null, callback), 2, null);
                IOExt.closeStream(openOutputStream$default);
                return;
            }
            copyFileStream(openInputStream, openOutputStream$default, createTargetFile, z, longValue, false, callback);
        } catch (Throwable unused) {
            BuildersKt__Builders_commonKt.launch$default(callback.getUiScope(), Dispatchers.getMain(), null, new MediaFile$copyTo$$inlined$postToUi$2(null, callback), 2, null);
        }
    }

    private final DocumentFile createTargetFile(DocumentFile documentFile, String str, String str2, CreateMode createMode, FileCallback fileCallback) {
        DocumentFile mkdirs$default;
        try {
            Context context = this.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Context context2 = this.context;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            String storageId = DocumentFileExt.getStorageId(documentFile, context2);
            Context context3 = this.context;
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            String buildAbsolutePath = DocumentFileCompat.buildAbsolutePath(context, storageId, DocumentFileExt.getBasePath(documentFile, context3));
            Context context4 = this.context;
            Intrinsics.checkNotNullExpressionValue(context4, "context");
            mkdirs$default = DocumentFileCompat.mkdirs$default(context4, buildAbsolutePath, false, false, 12, (Object) null);
        } catch (SecurityException e) {
            handleSecurityException(e, fileCallback);
        } catch (Exception e2) {
            BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new MediaFile$createTargetFile$$inlined$postToUi$3(null, fileCallback, e2), 2, null);
        }
        if (mkdirs$default == null) {
            BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new MediaFile$createTargetFile$$inlined$postToUi$1(null, fileCallback), 2, null);
            return null;
        }
        Context context5 = this.context;
        Intrinsics.checkNotNullExpressionValue(context5, "context");
        DocumentFile makeFile = DocumentFileExt.makeFile(mkdirs$default, context5, str, str2, createMode);
        if (makeFile == null) {
            BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new MediaFile$createTargetFile$$inlined$postToUi$2(null, fileCallback), 2, null);
            return null;
        }
        return makeFile;
    }

    private final void createFileStreams(DocumentFile documentFile, FileCallback fileCallback, Function2<? super InputStream, ? super OutputStream, Unit> function2) {
        Context context = this.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        OutputStream openOutputStream$default = DocumentFileExt.openOutputStream$default(documentFile, context, false, 2, null);
        if (openOutputStream$default == null) {
            BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new MediaFile$createFileStreams$$inlined$postToUi$1(null, fileCallback), 2, null);
            return;
        }
        InputStream openInputStream = openInputStream();
        if (openInputStream == null) {
            BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new MediaFile$createFileStreams$$inlined$postToUi$2(null, fileCallback), 2, null);
            IOExt.closeStream(openOutputStream$default);
            return;
        }
        function2.invoke(openInputStream, openOutputStream$default);
    }

    private final void copyFileStream(InputStream inputStream, OutputStream outputStream, DocumentFile documentFile, boolean z, long j, boolean z2, FileCallback fileCallback) {
        Job job;
        try {
            Ref.LongRef longRef = new Ref.LongRef();
            Ref.IntRef intRef = new Ref.IntRef();
            long length = getLength();
            job = (!z || length <= 10485760) ? null : CoroutineExt.startCoroutineTimer$default(0L, j, false, new MediaFile$copyFileStream$1(longRef, length, intRef, fileCallback), 5, null);
            try {
                byte[] bArr = new byte[1024];
                int read = inputStream.read(bArr);
                while (read != -1) {
                    try {
                        outputStream.write(bArr, 0, read);
                        longRef.element += read;
                        intRef.element += read;
                        read = inputStream.read(bArr);
                    } catch (Throwable th) {
                        th = th;
                        if (job != null) {
                            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                        }
                        IOExt.closeStream(inputStream);
                        IOExt.closeStream(outputStream);
                        throw th;
                    }
                }
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                if (z2) {
                    delete();
                }
                BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new MediaFile$copyFileStream$$inlined$postToUi$1(null, fileCallback, documentFile), 2, null);
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                IOExt.closeStream(inputStream);
                IOExt.closeStream(outputStream);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            job = null;
        }
    }

    private final FileCallback.ConflictResolution handleFileConflict(DocumentFile documentFile, String str, FileCallback fileCallback) {
        Object runBlocking$default;
        Context context = this.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        DocumentFile child$default = DocumentFileExt.child$default(documentFile, context, str, false, 4, null);
        if (child$default != null) {
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new C1126xb871910d(fileCallback.getUiScope(), null, fileCallback, child$default), 1, null);
            FileCallback.ConflictResolution conflictResolution = (FileCallback.ConflictResolution) runBlocking$default;
            if (conflictResolution == FileCallback.ConflictResolution.REPLACE) {
                Context context2 = this.context;
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                if (!DocumentFileExt.forceDelete$default(child$default, context2, false, 2, null)) {
                    BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), null, new MediaFile$handleFileConflict$lambda34$$inlined$postToUi$1(null, fileCallback), 2, null);
                    return FileCallback.ConflictResolution.SKIP;
                }
            }
            return conflictResolution;
        }
        return FileCallback.ConflictResolution.CREATE_NEW;
    }

    private final String getColumnInfoString(String str) {
        int columnIndex;
        Cursor query = this.context.getContentResolver().query(this.uri, new String[]{str}, null, null, null);
        if (query != null) {
            Cursor cursor = query;
            Throwable th = null;
            try {
                Cursor cursor2 = cursor;
                if (cursor2.moveToFirst() && (columnIndex = cursor2.getColumnIndex(str)) != -1) {
                    String string = cursor2.getString(columnIndex);
                    Closeable.closeFinally(cursor, th);
                    return string;
                }
                Unit unit = Unit.INSTANCE;
                Closeable.closeFinally(cursor, th);
            } finally {
            }
        }
        return null;
    }

    private final long getColumnInfoLong(String str) {
        int columnIndex;
        Cursor query = this.context.getContentResolver().query(this.uri, new String[]{str}, null, null, null);
        if (query == null) {
            return 0L;
        }
        Cursor cursor = query;
        Throwable th = null;
        try {
            Cursor cursor2 = cursor;
            if (cursor2.moveToFirst() && (columnIndex = cursor2.getColumnIndex(str)) != -1) {
                long j = cursor2.getLong(columnIndex);
                Closeable.closeFinally(cursor, th);
                return j;
            }
            Unit unit = Unit.INSTANCE;
            Closeable.closeFinally(cursor, th);
            return 0L;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                Closeable.closeFinally(cursor, th2);
                throw th3;
            }
        }
    }

    private final int getColumnInfoInt(String str) {
        int columnIndex;
        Cursor query = this.context.getContentResolver().query(this.uri, new String[]{str}, null, null, null);
        if (query != null) {
            Cursor cursor = query;
            Throwable th = null;
            try {
                Cursor cursor2 = cursor;
                if (cursor2.moveToFirst() && (columnIndex = cursor2.getColumnIndex(str)) != -1) {
                    int i = cursor2.getInt(columnIndex);
                    Closeable.closeFinally(cursor, th);
                    return i;
                }
                Unit unit = Unit.INSTANCE;
                Closeable.closeFinally(cursor, th);
            } finally {
            }
        }
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof MediaFile) && Intrinsics.areEqual(((MediaFile) obj).uri, this.uri));
    }

    public int hashCode() {
        return this.uri.hashCode();
    }

    public String toString() {
        String uri = this.uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "uri.toString()");
        return uri;
    }
}
