package com.hippo.unifile;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
final class DocumentsContractApi21 {
    private static final String PATH_DOCUMENT = "document";
    private static final String PATH_TREE = "tree";
    private static final String TAG = "DocumentsContractApi21";

    private DocumentsContractApi21() {
    }

    public static boolean isTreeDocumentUri(Context context, Uri uri) {
        if (DocumentsContractApi19.isContentUri(uri) && DocumentsContractApi19.isDocumentsProvider(context, uri.getAuthority())) {
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() == 2) {
                return PATH_TREE.equals(pathSegments.get(0));
            }
            return pathSegments.size() == 4 && PATH_TREE.equals(pathSegments.get(0)) && PATH_DOCUMENT.equals(pathSegments.get(2));
        }
        return false;
    }

    public static Uri createFile(Context context, Uri uri, String str, String str2) {
        try {
            return DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
        } catch (Exception e) {
            Log.e(TAG, "Failed to createFile", e);
            return null;
        }
    }

    public static Uri createDirectory(Context context, Uri uri, String str) {
        return createFile(context, uri, "vnd.android.document/directory", str);
    }

    public static Uri prepareTreeUri(Uri uri) {
        String treeDocumentId;
        try {
            treeDocumentId = DocumentsContract.getDocumentId(uri);
        } catch (Exception unused) {
            treeDocumentId = DocumentsContract.getTreeDocumentId(uri);
        }
        if (treeDocumentId == null) {
            throw new IllegalArgumentException();
        }
        return DocumentsContract.buildDocumentUriUsingTree(uri, treeDocumentId);
    }

    public static Uri[] listFiles(Context context, Uri uri) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri buildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri));
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(buildChildDocumentsUriUsingTree, new String[]{"document_id"}, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    arrayList.add(DocumentsContract.buildDocumentUriUsingTree(uri, cursor.getString(0)));
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            closeQuietly(cursor);
            throw th;
        }
        closeQuietly(cursor);
        return (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
    }

    public static NamedUri[] listFilesNamed(Context context, Uri uri) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri buildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri));
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(buildChildDocumentsUriUsingTree, new String[]{"document_id", "_display_name"}, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    String string = cursor.getString(0);
                    arrayList.add(new NamedUri(DocumentsContract.buildDocumentUriUsingTree(uri, string), cursor.getString(1)));
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            closeQuietly(cursor);
            throw th;
        }
        closeQuietly(cursor);
        return (NamedUri[]) arrayList.toArray(new NamedUri[arrayList.size()]);
    }

    public static Uri renameTo(Context context, Uri uri, String str) {
        try {
            return DocumentsContract.renameDocument(context.getContentResolver(), uri, str);
        } catch (Exception e) {
            Log.e(TAG, "Failed to renameTo", e);
            return null;
        }
    }

    private static void closeQuietly(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }
}
