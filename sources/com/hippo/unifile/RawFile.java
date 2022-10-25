package com.hippo.unifile;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class RawFile extends UniFile {
    private static final String TAG = "RawFile";
    private File mFile;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RawFile(UniFile uniFile, File file) {
        super(uniFile);
        this.mFile = file;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    @Override // com.hippo.unifile.UniFile
    public UniFile createFile(String str) {
        FileOutputStream fileOutputStream;
        Closeable closeable = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(this.mFile, str);
        ?? exists = file.exists();
        try {
            if (exists != 0) {
                if (file.isFile()) {
                    return new RawFile(this, file);
                }
                return null;
            }
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException e) {
                e = e;
                fileOutputStream = null;
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly(closeable);
                throw th;
            }
            try {
                RawFile rawFile = new RawFile(this, file);
                IOUtils.closeQuietly(fileOutputStream);
                return rawFile;
            } catch (IOException e2) {
                e = e2;
                Log.w(TAG, "Failed to createFile " + str + ": " + e);
                IOUtils.closeQuietly(fileOutputStream);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable = exists;
        }
    }

    @Override // com.hippo.unifile.UniFile
    public UniFile createDirectory(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(this.mFile, str);
        if (file.isDirectory() || file.mkdirs()) {
            return new RawFile(this, file);
        }
        return null;
    }

    @Override // com.hippo.unifile.UniFile
    public Uri getUri() {
        return Uri.fromFile(this.mFile);
    }

    @Override // com.hippo.unifile.UniFile
    public String getName() {
        return this.mFile.getName();
    }

    @Override // com.hippo.unifile.UniFile
    public String getType() {
        if (this.mFile.isDirectory()) {
            return null;
        }
        return Utils.getTypeForName(this.mFile.getName());
    }

    @Override // com.hippo.unifile.UniFile
    public String getFilePath() {
        return this.mFile.getPath();
    }

    @Override // com.hippo.unifile.UniFile
    public boolean isDirectory() {
        return this.mFile.isDirectory();
    }

    @Override // com.hippo.unifile.UniFile
    public boolean isFile() {
        return this.mFile.isFile();
    }

    @Override // com.hippo.unifile.UniFile
    public long lastModified() {
        return this.mFile.lastModified();
    }

    @Override // com.hippo.unifile.UniFile
    public long length() {
        return this.mFile.length();
    }

    @Override // com.hippo.unifile.UniFile
    public boolean canRead() {
        return this.mFile.canRead();
    }

    @Override // com.hippo.unifile.UniFile
    public boolean canWrite() {
        return this.mFile.canWrite();
    }

    @Override // com.hippo.unifile.UniFile
    public boolean delete() {
        deleteContents(this.mFile);
        return this.mFile.delete();
    }

    @Override // com.hippo.unifile.UniFile
    public boolean exists() {
        return this.mFile.exists();
    }

    @Override // com.hippo.unifile.UniFile
    public UniFile[] listFiles() {
        File[] listFiles = this.mFile.listFiles();
        if (listFiles == null) {
            return null;
        }
        int length = listFiles.length;
        UniFile[] uniFileArr = new UniFile[length];
        for (int i = 0; i < length; i++) {
            uniFileArr[i] = new RawFile(this, listFiles[i]);
        }
        return uniFileArr;
    }

    @Override // com.hippo.unifile.UniFile
    public UniFile[] listFiles(FilenameFilter filenameFilter) {
        if (filenameFilter == null) {
            return listFiles();
        }
        File[] listFiles = this.mFile.listFiles();
        if (listFiles == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : listFiles) {
            if (filenameFilter.accept(this, file.getName())) {
                arrayList.add(new RawFile(this, file));
            }
        }
        return (UniFile[]) arrayList.toArray(new UniFile[arrayList.size()]);
    }

    @Override // com.hippo.unifile.UniFile
    public UniFile findFile(String str) {
        return findFile(str, false);
    }

    @Override // com.hippo.unifile.UniFile
    public UniFile findFile(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(this.mFile, str);
        if (file.exists()) {
            return new RawFile(this, file);
        }
        return null;
    }

    @Override // com.hippo.unifile.UniFile
    public boolean renameTo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(this.mFile.getParentFile(), str);
        if (this.mFile.renameTo(file)) {
            this.mFile = file;
            return true;
        }
        return false;
    }

    @Override // com.hippo.unifile.UniFile
    public OutputStream openOutputStream() throws IOException {
        return new FileOutputStream(this.mFile);
    }

    @Override // com.hippo.unifile.UniFile
    public OutputStream openOutputStream(boolean z) throws IOException {
        return new FileOutputStream(this.mFile, z);
    }

    @Override // com.hippo.unifile.UniFile
    public InputStream openInputStream() throws IOException {
        return new FileInputStream(this.mFile);
    }

    @Override // com.hippo.unifile.UniFile
    public UniRandomAccessFile createRandomAccessFile(String str) throws FileNotFoundException {
        return new RawRandomAccessFile(new RandomAccessFile(this.mFile, str));
    }

    private static boolean deleteContents(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    z &= deleteContents(file2);
                }
                if (!file2.delete()) {
                    Log.w(TAG, "Failed to delete " + file2);
                    z = false;
                }
            }
        }
        return z;
    }
}
