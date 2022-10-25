package com.hippo.unifile;

import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes3.dex */
class RawRandomAccessFile implements UniRandomAccessFile {
    private RandomAccessFile mFile;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RawRandomAccessFile(RandomAccessFile randomAccessFile) {
        this.mFile = randomAccessFile;
    }

    @Override // com.hippo.unifile.UniRandomAccessFile
    public void close() throws IOException {
        this.mFile.close();
    }

    @Override // com.hippo.unifile.UniRandomAccessFile
    public long getFilePointer() throws IOException {
        return this.mFile.getFilePointer();
    }

    @Override // com.hippo.unifile.UniRandomAccessFile
    public void seek(long j) throws IOException {
        this.mFile.seek(j);
    }

    @Override // com.hippo.unifile.UniRandomAccessFile
    public int skipBytes(int i) throws IOException {
        return this.mFile.skipBytes(i);
    }

    @Override // com.hippo.unifile.UniRandomAccessFile
    public long length() throws IOException {
        return this.mFile.length();
    }

    @Override // com.hippo.unifile.UniRandomAccessFile
    public void setLength(long j) throws IOException {
        this.mFile.setLength(j);
    }

    @Override // com.hippo.unifile.UniRandomAccessFile
    public void read(byte[] bArr) throws IOException {
        this.mFile.read(bArr);
    }

    @Override // com.hippo.unifile.UniRandomAccessFile
    public void read(byte[] bArr, int i, int i2) throws IOException {
        this.mFile.read(bArr, i, i2);
    }

    @Override // com.hippo.unifile.UniRandomAccessFile
    public void write(byte[] bArr) throws IOException {
        this.mFile.write(bArr);
    }

    @Override // com.hippo.unifile.UniRandomAccessFile
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.mFile.write(bArr, i, i2);
    }
}
