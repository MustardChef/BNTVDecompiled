package com.lagradost.cloudstream3.utils;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import androidx.loader.content.CursorLoader;
import com.anggrayudi.storage.file.DocumentFileCompat;
import com.anggrayudi.storage.file.StorageId;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class RealPathUtil {
    public static String getRealPath(Context context, Uri uri, String str) {
        if (Build.VERSION.SDK_INT < 11) {
            return getRealPathFromURI_BelowAPI11(context, uri, str);
        }
        if (Build.VERSION.SDK_INT < 19) {
            return getRealPathFromURI_API11to18(context, uri, str);
        }
        return getRealPathFromURI_API19(context, uri, str);
    }

    public static String getRealPathFromURI_API11to18(Context context, Uri uri, String str) {
        Cursor loadInBackground = new CursorLoader(context, uri, new String[]{"_data"}, null, null, null).loadInBackground();
        if (loadInBackground != null) {
            int columnIndexOrThrow = loadInBackground.getColumnIndexOrThrow("_data");
            loadInBackground.moveToFirst();
            String string = loadInBackground.getString(columnIndexOrThrow);
            loadInBackground.close();
            return string;
        }
        return null;
    }

    public static String getRealPathFromURI_BelowAPI11(Context context, Uri uri, String str) {
        Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        if (query != null) {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
            query.moveToFirst();
            String string = query.getString(columnIndexOrThrow);
            query.close();
            return string;
        }
        return "";
    }

    public static String getRealPathFromURI_API19(Context context, Uri uri, String str) {
        Uri uri2 = null;
        if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (documentId != null && documentId.startsWith("msf:")) {
                    File file = new File(context.getCacheDir(), str);
                    try {
                        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = openInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileOutputStream.flush();
                            String absolutePath = file.getAbsolutePath();
                            fileOutputStream.close();
                            if (openInputStream != null) {
                                openInputStream.close();
                            }
                            return absolutePath;
                        } catch (Throwable th) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                String[] split = documentId.split(":");
                if (StorageId.PRIMARY.equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else if (isDownloadsDocument(uri)) {
                String documentId2 = DocumentsContract.getDocumentId(uri);
                if (documentId2 != null && documentId2.startsWith("msf:")) {
                    File file2 = new File(context.getCacheDir(), str);
                    try {
                        InputStream openInputStream2 = context.getContentResolver().openInputStream(uri);
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                        byte[] bArr2 = new byte[4096];
                        while (true) {
                            int read2 = openInputStream2.read(bArr2);
                            if (read2 == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr2, 0, read2);
                        }
                        fileOutputStream2.flush();
                        String absolutePath2 = file2.getAbsolutePath();
                        fileOutputStream2.close();
                        if (openInputStream2 != null) {
                            openInputStream2.close();
                        }
                        return absolutePath2;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return null;
                    }
                }
                return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId2).longValue()), null, null);
            } else if (isMediaDocument(uri)) {
                String documentId3 = DocumentsContract.getDocumentId(uri);
                if (documentId3 != null && documentId3.startsWith("msf:")) {
                    File file3 = new File(context.getCacheDir(), str);
                    try {
                        InputStream openInputStream3 = context.getContentResolver().openInputStream(uri);
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file3);
                        try {
                            byte[] bArr3 = new byte[4096];
                            while (true) {
                                int read3 = openInputStream3.read(bArr3);
                                if (read3 == -1) {
                                    break;
                                }
                                fileOutputStream3.write(bArr3, 0, read3);
                            }
                            fileOutputStream3.flush();
                            String absolutePath3 = file3.getAbsolutePath();
                            fileOutputStream3.close();
                            if (openInputStream3 != null) {
                                openInputStream3.close();
                            }
                            return absolutePath3;
                        } catch (Throwable th3) {
                            try {
                                fileOutputStream3.close();
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                            }
                            throw th3;
                        }
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return null;
                    }
                }
                String[] split2 = documentId3.split(":");
                String str2 = split2[0];
                if ("image".equals(str2)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str2)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(str2)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return getDataColumn(context, uri2, "_id=?", new String[]{split2[1]});
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            if (isGooglePhotosUri(uri)) {
                return uri.getLastPathSegment();
            }
            return getDataColumn(context, uri, null, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndexOrThrow("_data"));
                        if (query != null) {
                            query.close();
                        }
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return DocumentFileCompat.EXTERNAL_STORAGE_AUTHORITY.equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return DocumentFileCompat.DOWNLOADS_FOLDER_AUTHORITY.equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return DocumentFileCompat.MEDIA_FOLDER_AUTHORITY.equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }
}
