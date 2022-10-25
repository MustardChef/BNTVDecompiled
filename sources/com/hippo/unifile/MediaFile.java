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
public class MediaFile extends UniFile {
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
    public boolean delete() {
        return false;
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
    public boolean isDirectory() {
        return false;
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
    public MediaFile(Context context, Uri uri) {
        super(null);
        this.mContext = context.getApplicationContext();
        this.mUri = uri;
    }

    @Override // com.hippo.unifile.UniFile
    public Uri getUri() {
        return this.mUri;
    }

    @Override // com.hippo.unifile.UniFile
    public String getName() {
        return MediaContract.getName(this.mContext, this.mUri);
    }

    @Override // com.hippo.unifile.UniFile
    public String getType() {
        String type = MediaContract.getType(this.mContext, this.mUri);
        return !TextUtils.isEmpty(type) ? type : Utils.getTypeForName(getName());
    }

    @Override // com.hippo.unifile.UniFile
    public String getFilePath() {
        return MediaContract.getFilePath(this.mContext, this.mUri);
    }

    @Override // com.hippo.unifile.UniFile
    public boolean isFile() {
        try {
            IOUtils.closeQuietly(openInputStream());
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.hippo.unifile.UniFile
    public long lastModified() {
        return MediaContract.lastModified(this.mContext, this.mUri);
    }

    @Override // com.hippo.unifile.UniFile
    public long length() {
        return MediaContract.length(this.mContext, this.mUri);
    }

    @Override // com.hippo.unifile.UniFile
    public boolean canRead() {
        return isFile();
    }

    @Override // com.hippo.unifile.UniFile
    public boolean canWrite() {
        try {
            IOUtils.closeQuietly(openOutputStream(true));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.hippo.unifile.UniFile
    public boolean exists() {
        return isFile();
    }

    @Override // com.hippo.unifile.UniFile
    public OutputStream openOutputStream() throws IOException {
        return TrickOutputStream.create(this.mContext, this.mUri, "w");
    }

    @Override // com.hippo.unifile.UniFile
    public OutputStream openOutputStream(boolean z) throws IOException {
        return TrickOutputStream.create(this.mContext, this.mUri, z ? "wa" : "w");
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
