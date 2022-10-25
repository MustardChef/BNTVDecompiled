package com.hippo.unifile;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.anggrayudi.storage.file.MimeType;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class TreeDocumentFile extends UniFile {
    private static final String TAG = "TreeDocumentFile";
    private final Context mContext;
    private String mName;
    private Uri mUri;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TreeDocumentFile(UniFile uniFile, Context context, Uri uri) {
        this(uniFile, context, uri, null);
    }

    TreeDocumentFile(UniFile uniFile, Context context, Uri uri, String str) {
        super(uniFile);
        this.mContext = context.getApplicationContext();
        this.mUri = uri;
        this.mName = str;
    }

    @Override // com.hippo.unifile.UniFile
    public UniFile createFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        UniFile findFile = findFile(str);
        if (findFile != null) {
            if (findFile.isFile()) {
                return findFile;
            }
            String str2 = TAG;
            Log.w(str2, "Try to create file " + str + ", but it is not file");
            return null;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf > 0) {
            String substring = str.substring(0, lastIndexOf);
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(lastIndexOf + 1));
            if (!TextUtils.isEmpty(mimeTypeFromExtension)) {
                Uri createFile = DocumentsContractApi21.createFile(this.mContext, this.mUri, mimeTypeFromExtension, substring);
                if (createFile != null) {
                    return new TreeDocumentFile(this, this.mContext, createFile);
                }
                return null;
            }
        }
        Uri createFile2 = DocumentsContractApi21.createFile(this.mContext, this.mUri, MimeType.BINARY_FILE, str);
        if (createFile2 != null) {
            return new TreeDocumentFile(this, this.mContext, createFile2);
        }
        return null;
    }

    @Override // com.hippo.unifile.UniFile
    public UniFile createDirectory(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        UniFile findFile = findFile(str);
        if (findFile != null) {
            if (findFile.isDirectory()) {
                return findFile;
            }
            return null;
        }
        Uri createDirectory = DocumentsContractApi21.createDirectory(this.mContext, this.mUri, str);
        if (createDirectory != null) {
            return new TreeDocumentFile(this, this.mContext, createDirectory);
        }
        return null;
    }

    @Override // com.hippo.unifile.UniFile
    public Uri getUri() {
        return this.mUri;
    }

    @Override // com.hippo.unifile.UniFile
    public String getName() {
        String str = this.mName;
        return str != null ? str : DocumentsContractApi19.getName(this.mContext, this.mUri);
    }

    @Override // com.hippo.unifile.UniFile
    public String getType() {
        String type = DocumentsContractApi19.getType(this.mContext, this.mUri);
        return !TextUtils.isEmpty(type) ? type : Utils.getTypeForName(getName());
    }

    @Override // com.hippo.unifile.UniFile
    public String getFilePath() {
        return DocumentsContractApi19.getFilePath(this.mContext, this.mUri);
    }

    @Override // com.hippo.unifile.UniFile
    public boolean isDirectory() {
        return DocumentsContractApi19.isDirectory(this.mContext, this.mUri);
    }

    @Override // com.hippo.unifile.UniFile
    public boolean isFile() {
        return DocumentsContractApi19.isFile(this.mContext, this.mUri);
    }

    @Override // com.hippo.unifile.UniFile
    public long lastModified() {
        return DocumentsContractApi19.lastModified(this.mContext, this.mUri);
    }

    @Override // com.hippo.unifile.UniFile
    public long length() {
        if (isDirectory()) {
            return -1L;
        }
        return DocumentsContractApi19.length(this.mContext, this.mUri);
    }

    @Override // com.hippo.unifile.UniFile
    public boolean canRead() {
        return DocumentsContractApi19.canRead(this.mContext, this.mUri);
    }

    @Override // com.hippo.unifile.UniFile
    public boolean canWrite() {
        return DocumentsContractApi19.canWrite(this.mContext, this.mUri);
    }

    @Override // com.hippo.unifile.UniFile
    public boolean delete() {
        invalidateName();
        return DocumentsContractApi19.delete(this.mContext, this.mUri);
    }

    @Override // com.hippo.unifile.UniFile
    public boolean exists() {
        return DocumentsContractApi19.exists(this.mContext, this.mUri);
    }

    @Override // com.hippo.unifile.UniFile
    public UniFile[] listFiles() {
        if (isDirectory()) {
            NamedUri[] listFilesNamed = DocumentsContractApi21.listFilesNamed(this.mContext, this.mUri);
            UniFile[] uniFileArr = new UniFile[listFilesNamed.length];
            int length = listFilesNamed.length;
            for (int i = 0; i < length; i++) {
                NamedUri namedUri = listFilesNamed[i];
                uniFileArr[i] = new TreeDocumentFile(this, this.mContext, namedUri.uri, namedUri.name);
            }
            return uniFileArr;
        }
        return null;
    }

    @Override // com.hippo.unifile.UniFile
    public UniFile[] listFiles(FilenameFilter filenameFilter) {
        if (filenameFilter == null) {
            return listFiles();
        }
        if (isDirectory()) {
            NamedUri[] listFilesNamed = DocumentsContractApi21.listFilesNamed(this.mContext, this.mUri);
            ArrayList arrayList = new ArrayList();
            for (NamedUri namedUri : listFilesNamed) {
                String name = DocumentsContractApi19.getName(this.mContext, namedUri.uri);
                if (name != null && filenameFilter.accept(this, name)) {
                    arrayList.add(new TreeDocumentFile(this, this.mContext, namedUri.uri, namedUri.name));
                }
            }
            return (UniFile[]) arrayList.toArray(new UniFile[arrayList.size()]);
        }
        return null;
    }

    @Override // com.hippo.unifile.UniFile
    public UniFile findFile(String str) {
        return findFile(str, false);
    }

    @Override // com.hippo.unifile.UniFile
    public UniFile findFile(String str, boolean z) {
        NamedUri[] listFilesNamed;
        if (!TextUtils.isEmpty(str) && isDirectory()) {
            for (NamedUri namedUri : DocumentsContractApi21.listFilesNamed(this.mContext, this.mUri)) {
                if (Utils.equals(str, namedUri.name, z)) {
                    return new TreeDocumentFile(this, this.mContext, namedUri.uri, str);
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.hippo.unifile.UniFile
    public boolean renameTo(String str) {
        invalidateName();
        Uri renameTo = DocumentsContractApi21.renameTo(this.mContext, this.mUri, str);
        if (renameTo != null) {
            this.mUri = renameTo;
            return true;
        }
        return false;
    }

    @Override // com.hippo.unifile.UniFile
    public OutputStream openOutputStream() throws IOException {
        if (isDirectory()) {
            throw new IOException("Can't open OutputStream from a directory");
        }
        try {
            OutputStream openOutputStream = this.mContext.getContentResolver().openOutputStream(this.mUri);
            if (openOutputStream != null) {
                return openOutputStream;
            }
            throw new IOException("Can't open OutputStream");
        } catch (Exception unused) {
            throw new IOException("Can't open OutputStream");
        }
    }

    @Override // com.hippo.unifile.UniFile
    public OutputStream openOutputStream(boolean z) throws IOException {
        if (isDirectory()) {
            throw new IOException("Can't open OutputStream from a directory");
        }
        try {
            OutputStream openOutputStream = this.mContext.getContentResolver().openOutputStream(this.mUri, z ? "wa" : "w");
            if (openOutputStream != null) {
                return openOutputStream;
            }
            throw new IOException("Can't open OutputStream");
        } catch (Exception unused) {
            throw new IOException("Can't open OutputStream");
        }
    }

    @Override // com.hippo.unifile.UniFile
    public InputStream openInputStream() throws IOException {
        if (isDirectory()) {
            throw new IOException("Can't open InputStream from a directory");
        }
        try {
            InputStream openInputStream = this.mContext.getContentResolver().openInputStream(this.mUri);
            if (openInputStream != null) {
                return openInputStream;
            }
            throw new IOException("Can't open InputStream");
        } catch (Exception unused) {
            throw new IOException("Can't open InputStream");
        }
    }

    @Override // com.hippo.unifile.UniFile
    public UniRandomAccessFile createRandomAccessFile(String str) throws IOException {
        if (!isFile()) {
            throw new IOException("Can't make sure it is file");
        }
        try {
            ParcelFileDescriptor openFileDescriptor = this.mContext.getContentResolver().openFileDescriptor(this.mUri, str);
            if (openFileDescriptor == null) {
                throw new IOException("Can't open ParcelFileDescriptor");
            }
            return new RawRandomAccessFile(TrickRandomAccessFile.create(openFileDescriptor, str));
        } catch (Exception unused) {
            throw new IOException("Can't open ParcelFileDescriptor");
        }
    }

    private void invalidateName() {
        this.mName = null;
    }
}
