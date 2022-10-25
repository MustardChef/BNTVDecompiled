package com.hippo.unifile;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class AssetFile extends UniFile {
    private final AssetManager mAssetManager;
    private final String mPath;

    @Override // com.hippo.unifile.UniFile
    public boolean canWrite() {
        return false;
    }

    @Override // com.hippo.unifile.UniFile
    public boolean delete() {
        return false;
    }

    @Override // com.hippo.unifile.UniFile
    public String getFilePath() {
        return null;
    }

    @Override // com.hippo.unifile.UniFile
    public long lastModified() {
        return -1L;
    }

    @Override // com.hippo.unifile.UniFile
    public long length() {
        return -1L;
    }

    @Override // com.hippo.unifile.UniFile
    public boolean renameTo(String str) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AssetFile(UniFile uniFile, AssetManager assetManager, String str) {
        super(uniFile);
        this.mAssetManager = assetManager;
        this.mPath = str;
    }

    @Override // com.hippo.unifile.UniFile
    public UniFile createFile(String str) {
        UniFile findFile = findFile(str);
        if (findFile == null || !findFile.isFile()) {
            return null;
        }
        return findFile;
    }

    @Override // com.hippo.unifile.UniFile
    public UniFile createDirectory(String str) {
        UniFile findFile = findFile(str);
        if (findFile == null || !findFile.isDirectory()) {
            return null;
        }
        return findFile;
    }

    @Override // com.hippo.unifile.UniFile
    public Uri getUri() {
        Uri.Builder authority = new Uri.Builder().scheme("file").authority("");
        return authority.path("android_asset/" + this.mPath).build();
    }

    @Override // com.hippo.unifile.UniFile
    public String getName() {
        int lastIndexOf = this.mPath.lastIndexOf(47);
        if (lastIndexOf >= 0 && lastIndexOf < this.mPath.length() - 1) {
            return this.mPath.substring(lastIndexOf + 1);
        }
        return this.mPath;
    }

    @Override // com.hippo.unifile.UniFile
    public String getType() {
        if (isDirectory()) {
            return null;
        }
        return Utils.getTypeForName(getName());
    }

    @Override // com.hippo.unifile.UniFile
    public boolean isDirectory() {
        try {
            String[] list = this.mAssetManager.list(this.mPath);
            if (list != null) {
                return list.length > 0;
            }
            return false;
        } catch (IOException unused) {
            return false;
        }
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
    public boolean canRead() {
        return isFile();
    }

    @Override // com.hippo.unifile.UniFile
    public boolean exists() {
        return isDirectory() || isFile();
    }

    @Override // com.hippo.unifile.UniFile
    public UniFile[] listFiles() {
        try {
            String[] list = this.mAssetManager.list(this.mPath);
            if (list != null && list.length != 0) {
                int length = list.length;
                UniFile[] uniFileArr = new UniFile[length];
                for (int i = 0; i < length; i++) {
                    uniFileArr[i] = new AssetFile(this, this.mAssetManager, Utils.resolve(this.mPath, list[i]));
                }
                return uniFileArr;
            }
        } catch (IOException unused) {
        }
        return null;
    }

    @Override // com.hippo.unifile.UniFile
    public UniFile[] listFiles(FilenameFilter filenameFilter) {
        if (filenameFilter == null) {
            return listFiles();
        }
        try {
            String[] list = this.mAssetManager.list(this.mPath);
            if (list != null && list.length != 0) {
                int length = list.length;
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    if (filenameFilter.accept(this, list[i])) {
                        arrayList.add(new AssetFile(this, this.mAssetManager, Utils.resolve(this.mPath, list[i])));
                    }
                }
                return (UniFile[]) arrayList.toArray(new UniFile[arrayList.size()]);
            }
        } catch (IOException unused) {
        }
        return null;
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
        try {
            String[] list = this.mAssetManager.list(this.mPath);
            if (list != null && list.length != 0) {
                for (String str2 : list) {
                    if (Utils.equals(str, str2, z)) {
                        return new AssetFile(this, this.mAssetManager, Utils.resolve(this.mPath, str));
                    }
                }
            }
        } catch (IOException unused) {
        }
        return null;
    }

    @Override // com.hippo.unifile.UniFile
    public OutputStream openOutputStream() throws IOException {
        throw new IOException("Not support OutputStream for asset file.");
    }

    @Override // com.hippo.unifile.UniFile
    public OutputStream openOutputStream(boolean z) throws IOException {
        throw new IOException("Not support OutputStream for asset file.");
    }

    @Override // com.hippo.unifile.UniFile
    public InputStream openInputStream() throws IOException {
        return this.mAssetManager.open(this.mPath);
    }

    @Override // com.hippo.unifile.UniFile
    public UniRandomAccessFile createRandomAccessFile(String str) throws IOException {
        if (!"r".equals(str)) {
            throw new IOException("Unsupported mode: " + str);
        }
        AssetFileDescriptor openFd = this.mAssetManager.openFd(this.mPath);
        if (openFd == null) {
            throw new IOException("Can't open AssetFileDescriptor");
        }
        return new RawRandomAccessFile(TrickRandomAccessFile.create(openFd, str));
    }
}
