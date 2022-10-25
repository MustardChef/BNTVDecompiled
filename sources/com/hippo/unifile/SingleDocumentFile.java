package com.hippo.unifile;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class SingleDocumentFile extends UniFile {
    private final Context mContext;
    private final Uri mUri;

    @Override // com.hippo.unifile.UniFile
    public UniFile createDirectory(String str) {
        return null;
    }

    @Override // com.hippo.unifile.UniFile
    public UniFile createFile(String str) {
        return null;
    }

    @Override // com.hippo.unifile.UniFile
    public UniFile findFile(String str) {
        return null;
    }

    @Override // com.hippo.unifile.UniFile
    public UniFile findFile(String str, boolean z) {
        return null;
    }

    @Override // com.hippo.unifile.UniFile
    public UniFile[] listFiles() {
        return null;
    }

    @Override // com.hippo.unifile.UniFile
    public UniFile[] listFiles(FilenameFilter filenameFilter) {
        return null;
    }

    @Override // com.hippo.unifile.UniFile
    public boolean renameTo(String str) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingleDocumentFile(UniFile uniFile, Context context, Uri uri) {
        super(uniFile);
        this.mContext = context.getApplicationContext();
        this.mUri = uri;
    }

    @Override // com.hippo.unifile.UniFile
    public Uri getUri() {
        return this.mUri;
    }

    @Override // com.hippo.unifile.UniFile
    public String getName() {
        return DocumentsContractApi19.getName(this.mContext, this.mUri);
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
        return DocumentsContractApi19.delete(this.mContext, this.mUri);
    }

    @Override // com.hippo.unifile.UniFile
    public boolean exists() {
        return DocumentsContractApi19.exists(this.mContext, this.mUri);
    }

    @Override // com.hippo.unifile.UniFile
    public OutputStream openOutputStream() throws IOException {
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
}
