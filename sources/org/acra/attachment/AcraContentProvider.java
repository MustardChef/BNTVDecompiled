package org.acra.attachment;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.acra.ACRA;
import org.acra.file.Directory;
import org.acra.log.ACRALog;

/* compiled from: AcraContentProvider.kt */
@Metadata(m108d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J/\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004H\u0016JK\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\u001cJ9\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u001eR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, m107d2 = {"Lorg/acra/attachment/AcraContentProvider;", "Landroid/content/ContentProvider;", "()V", "authority", "", "delete", "", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getFileForUri", "Ljava/io/File;", "getType", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "", "openFile", "Landroid/os/ParcelFileDescriptor;", "mode", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class AcraContentProvider extends ContentProvider {
    private static final String MIME_TYPE_OCTET_STREAM = "application/octet-stream";
    private String authority;
    public static final Companion Companion = new Companion(null);
    private static final String[] COLUMNS = {"_display_name", "_size"};

    @JvmStatic
    public static final Uri getUriForFile(Context context, File file) {
        return Companion.getUriForFile(context, file);
    }

    @JvmStatic
    public static final Uri getUriForFile(Context context, Directory directory, String str) {
        return Companion.getUriForFile(context, directory, str);
    }

    @JvmStatic
    public static final String guessMimeType(Uri uri) {
        return Companion.guessMimeType(uri);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Companion companion = Companion;
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        this.authority = companion.getAuthority(context);
        if (ACRA.DEV_LOGGING) {
            ACRA.log.mo69d(ACRA.LOG_TAG, Intrinsics.stringPlus("Registered content provider for authority ", this.authority));
            return true;
        }
        return true;
    }

    private final File getFileForUri(Uri uri) {
        if (Intrinsics.areEqual("content", uri.getScheme()) && Intrinsics.areEqual(this.authority, uri.getAuthority())) {
            List<String> pathSegments = uri.getPathSegments();
            Intrinsics.checkNotNullExpressionValue(pathSegments, "uri.pathSegments");
            List mutableList = CollectionsKt.toMutableList((Collection) pathSegments);
            if (mutableList.size() < 2) {
                return null;
            }
            Object remove = mutableList.remove(0);
            Intrinsics.checkNotNullExpressionValue(remove, "segments.removeAt(0)");
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String upperCase = ((String) remove).toUpperCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            try {
                Directory valueOf = Directory.valueOf(upperCase);
                Context context = getContext();
                Intrinsics.checkNotNull(context);
                String join = TextUtils.join(File.separator, mutableList);
                Intrinsics.checkNotNullExpressionValue(join, "join(File.separator, segments)");
                return valueOf.getFile(context, join);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return Companion.guessMimeType(uri);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        throw new UnsupportedOperationException("No insert supported");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        throw new UnsupportedOperationException("No delete supported");
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        throw new UnsupportedOperationException("No update supported");
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
        String stringPlus;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(mode, "mode");
        File fileForUri = getFileForUri(uri);
        if (fileForUri == null || !fileForUri.exists()) {
            fileForUri = null;
        }
        if (fileForUri == null) {
            throw new FileNotFoundException("File represented by uri " + uri + " could not be found");
        }
        if (ACRA.DEV_LOGGING) {
            ACRALog aCRALog = ACRA.log;
            String str = ACRA.LOG_TAG;
            if (Build.VERSION.SDK_INT >= 19) {
                stringPlus = ((Object) getCallingPackage()) + " opened " + ((Object) fileForUri.getPath());
            } else {
                stringPlus = Intrinsics.stringPlus(fileForUri.getPath(), " was opened by an application");
            }
            aCRALog.mo69d(str, stringPlus);
        }
        ParcelFileDescriptor open = ParcelFileDescriptor.open(fileForUri, 268435456);
        Intrinsics.checkNotNullExpressionValue(open, "open(file, ParcelFileDescriptor.MODE_READ_ONLY)");
        return open;
    }

    /* compiled from: AcraContentProvider.kt */
    @Metadata(m108d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007J \u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0007J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\fH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m107d2 = {"Lorg/acra/attachment/AcraContentProvider$Companion;", "", "()V", "COLUMNS", "", "", "[Ljava/lang/String;", "MIME_TYPE_OCTET_STREAM", "getAuthority", "context", "Landroid/content/Context;", "getUriForFile", "Landroid/net/Uri;", "file", "Ljava/io/File;", "directory", "Lorg/acra/file/Directory;", "relativePath", "guessMimeType", ShareConstants.MEDIA_URI, "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getAuthority(Context context) {
            return Intrinsics.stringPlus(context.getPackageName(), ".acra");
        }

        @JvmStatic
        public final Uri getUriForFile(Context context, File file) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(file, "file");
            Directory directory = Directory.ROOT;
            String path = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "file.path");
            return getUriForFile(context, directory, path);
        }

        @JvmStatic
        public final Uri getUriForFile(Context context, Directory directory, String relativePath) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(directory, "directory");
            Intrinsics.checkNotNullParameter(relativePath, "relativePath");
            Uri.Builder authority = new Uri.Builder().scheme("content").authority(getAuthority(context));
            String name = directory.name();
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = name.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            Uri.Builder appendPath = authority.appendPath(lowerCase);
            String str = relativePath;
            String quote = Pattern.quote(File.separator);
            Intrinsics.checkNotNullExpressionValue(quote, "quote(File.separator)");
            Object[] array = StringsKt.split$default((CharSequence) str, new String[]{quote}, false, 0, 6, (Object) null).toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            String[] strArr = (String[]) array;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str2 = strArr[i];
                i++;
                if (str2.length() > 0) {
                    appendPath.appendPath(str2);
                }
            }
            Uri build = appendPath.build();
            Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
            return build;
        }

        @JvmStatic
        public final String guessMimeType(Uri uri) {
            String str;
            Intrinsics.checkNotNullParameter(uri, "uri");
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(uri.toString());
            if (fileExtensionFromUrl != null) {
                MimeTypeMap singleton = MimeTypeMap.getSingleton();
                Locale ROOT = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                String lowerCase = fileExtensionFromUrl.toLowerCase(ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                str = singleton.getMimeTypeFromExtension(lowerCase);
                if (str == null && Intrinsics.areEqual("json", fileExtensionFromUrl)) {
                    str = AbstractSpiCall.ACCEPT_JSON_VALUE;
                }
            } else {
                str = null;
            }
            return str == null ? "application/octet-stream" : str;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (ACRA.DEV_LOGGING) {
            ACRA.log.mo69d(ACRA.LOG_TAG, Intrinsics.stringPlus("Query: ", uri));
        }
        File fileForUri = getFileForUri(uri);
        if (fileForUri == null) {
            return null;
        }
        if (strArr == null) {
            strArr = COLUMNS;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = ArrayIteratorKt.iterator(strArr);
        while (it.hasNext()) {
            String str3 = (String) it.next();
            if (Intrinsics.areEqual(str3, "_display_name")) {
                linkedHashMap.put("_display_name", fileForUri.getName());
            } else if (Intrinsics.areEqual(str3, "_size")) {
                linkedHashMap.put("_size", Long.valueOf(fileForUri.length()));
            }
        }
        Object[] array = linkedHashMap.keySet().toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        MatrixCursor matrixCursor = new MatrixCursor((String[]) array, 1);
        matrixCursor.addRow(linkedHashMap.values());
        return matrixCursor;
    }
}
