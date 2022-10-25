package com.hippo.unifile;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.anggrayudi.storage.file.StorageId;
import java.io.File;
import java.util.List;

/* loaded from: classes3.dex */
final class DocumentsContractApi19 {
    private static final String AUTHORITY_DOCUMENT_DOWNLOAD = "com.android.providers.downloads.documents";
    private static final String AUTHORITY_DOCUMENT_EXTERNAL_STORAGE = "com.android.externalstorage.documents";
    private static final String AUTHORITY_DOCUMENT_MEDIA = "com.android.providers.media.documents";
    private static final String PATH_DOCUMENT = "document";
    private static final String PATH_TREE = "tree";
    private static final String PROVIDER_INTERFACE = "android.content.action.DOCUMENTS_PROVIDER";
    private static final String TAG = "DocumentsContractApi19";

    private DocumentsContractApi19() {
    }

    public static boolean isContentUri(Uri uri) {
        return uri != null && "content".equals(uri.getScheme());
    }

    public static boolean isDocumentsProvider(Context context, String str) {
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentContentProviders(new Intent(PROVIDER_INTERFACE), 0)) {
            if (str.equals(resolveInfo.providerInfo.authority)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDocumentUri(Context context, Uri uri) {
        if (isContentUri(uri) && isDocumentsProvider(context, uri.getAuthority())) {
            List<String> pathSegments = uri.getPathSegments();
            return pathSegments.size() == 2 ? PATH_DOCUMENT.equals(pathSegments.get(0)) || PATH_TREE.equals(pathSegments.get(0)) : pathSegments.size() == 4 && PATH_TREE.equals(pathSegments.get(0)) && PATH_DOCUMENT.equals(pathSegments.get(2));
        }
        return false;
    }

    public static String getName(Context context, Uri uri) {
        return Contracts.queryForString(context, uri, "_display_name", null);
    }

    private static String getRawType(Context context, Uri uri) {
        return Contracts.queryForString(context, uri, "mime_type", null);
    }

    public static String getType(Context context, Uri uri) {
        String rawType = getRawType(context, uri);
        if ("vnd.android.document/directory".equals(rawType)) {
            return null;
        }
        return rawType;
    }

    public static String getFilePath(Context context, Uri uri) {
        String authority;
        Uri uri2;
        if (uri == null) {
            return null;
        }
        try {
            authority = uri.getAuthority();
        } catch (Exception unused) {
        }
        if ("com.android.externalstorage.documents".equals(authority)) {
            String[] split = DocumentsContract.getDocumentId(uri).split(":");
            String str = split[0];
            String str2 = split[1];
            if (StorageId.PRIMARY.equalsIgnoreCase(str)) {
                return Environment.getExternalStorageDirectory() + "/" + str2;
            }
            String str3 = null;
            for (File file : context.getExternalCacheDirs()) {
                String path = file.getPath();
                int indexOf = path.indexOf(str);
                if (indexOf >= 0) {
                    str3 = path.substring(0, indexOf + str.length());
                }
            }
            if (str3 != null) {
                return str3 + "/" + str2;
            }
            return null;
        } else if ("com.android.providers.downloads.documents".equals(authority)) {
            return Contracts.queryForString(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), "_data", null);
        } else {
            if ("com.android.providers.media.documents".equals(authority)) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                String str4 = split2[0];
                String str5 = split2[1];
                if ("image".equals(str4)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str4)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(str4)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                } else {
                    Log.d(TAG, "Unknown type in com.android.providers.media.documents: " + str4);
                }
                return Contracts.queryForString(context, ContentUris.withAppendedId(uri2, Long.valueOf(str5).longValue()), "_data", null);
            }
            return null;
        }
    }

    public static boolean isDirectory(Context context, Uri uri) {
        return "vnd.android.document/directory".equals(getRawType(context, uri));
    }

    public static boolean isFile(Context context, Uri uri) {
        String rawType = getRawType(context, uri);
        return ("vnd.android.document/directory".equals(rawType) || TextUtils.isEmpty(rawType)) ? false : true;
    }

    public static long lastModified(Context context, Uri uri) {
        return Contracts.queryForLong(context, uri, "last_modified", -1L);
    }

    public static long length(Context context, Uri uri) {
        return Contracts.queryForLong(context, uri, "_size", -1L);
    }

    public static boolean canRead(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 1) != 0) {
            return false;
        }
        return !TextUtils.isEmpty(getRawType(context, uri));
    }

    public static boolean canWrite(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        String rawType = getRawType(context, uri);
        int queryForInt = Contracts.queryForInt(context, uri, "flags", 0);
        if (TextUtils.isEmpty(rawType)) {
            return false;
        }
        if ((queryForInt & 4) != 0) {
            return true;
        }
        if (!"vnd.android.document/directory".equals(rawType) || (queryForInt & 8) == 0) {
            return (TextUtils.isEmpty(rawType) || (queryForInt & 2) == 0) ? false : true;
        }
        return true;
    }

    public static boolean delete(Context context, Uri uri) {
        try {
            return DocumentsContract.deleteDocument(context.getContentResolver(), uri);
        } catch (Exception e) {
            Log.e(TAG, "Failed to renameTo", e);
            return false;
        }
    }

    public static boolean exists(Context context, Uri uri) {
        ContentResolver contentResolver = context.getContentResolver();
        boolean z = false;
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(uri, new String[]{"document_id"}, null, null, null);
            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    z = true;
                }
            }
            return z;
        } catch (Exception unused) {
            return false;
        } finally {
            Contracts.closeQuietly(cursor);
        }
    }
}
