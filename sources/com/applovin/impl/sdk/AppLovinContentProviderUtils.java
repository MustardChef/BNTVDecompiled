package com.applovin.impl.sdk;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* loaded from: classes.dex */
public class AppLovinContentProviderUtils {

    /* renamed from: a */
    private static final String[] f1443a = {"_display_name", "_size"};

    /* renamed from: a */
    private static Uri m7256a(String str) {
        return Uri.parse("content://" + (C1662k.m6676K().getPackageName() + ".applovincontentprovider/" + str));
    }

    /* renamed from: a */
    private static File m7257a(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return null;
        }
        return m7255b(lastPathSegment);
    }

    /* renamed from: b */
    private static File m7255b(String str) {
        File file = new File(C1662k.m6676K().getCacheDir() + File.separator + "ALContentProviderCache");
        if (!file.exists()) {
            try {
                if (!file.mkdir()) {
                    return null;
                }
            } catch (Throwable unused) {
            }
        }
        return new File(file, str);
    }

    public static Uri cacheJPEGImageWithFileName(Bitmap bitmap, String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(m7255b(str));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return m7256a(str);
        } catch (Throwable th) {
            C1710r.m6310i("AppLovinContentProvider", "Failed to create jpeg file '" + str + "' for content provider with exception: " + th);
            return null;
        }
    }

    public static Uri cacheTextWithFileName(String str, String str2) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(m7255b(str2));
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
            return m7256a(str2);
        } catch (Throwable th) {
            C1710r.m6310i("AppLovinContentProvider", "Failed to create text file '" + str2 + "' for content provider with exception: " + th);
            return null;
        }
    }

    public static String getType(Uri uri) {
        File m7257a = m7257a(uri);
        try {
            String substring = m7257a.getName().substring(m7257a.getName().indexOf(46) + 1);
            if (MimeTypeMap.getSingleton().hasExtension(substring)) {
                return MimeTypeMap.getSingleton().getMimeTypeFromExtension(substring);
            }
            return null;
        } catch (Throwable th) {
            C1710r.m6316c("AppLovinContentProvider", "Failed to get file type for '" + uri.toString() + "'", th);
            return null;
        }
    }

    public static ParcelFileDescriptor openFile(Uri uri) {
        try {
            return ParcelFileDescriptor.open(m7257a(uri), 268435456);
        } catch (FileNotFoundException e) {
            C1710r.m6316c("AppLovinContentProvider", "Failed to open file '" + uri.toString() + "'", e);
            return null;
        }
    }

    public static Cursor query(Uri uri) {
        File m7257a = m7257a(uri);
        try {
            MatrixCursor matrixCursor = new MatrixCursor(f1443a, 1);
            matrixCursor.addRow(new Object[]{m7257a.getName(), Long.valueOf(m7257a.length())});
            return matrixCursor;
        } catch (Throwable th) {
            C1710r.m6316c("AppLovinContentProvider", "Failed to query file '" + uri.toString() + "'", th);
            return null;
        }
    }
}
