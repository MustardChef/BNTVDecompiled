package org.mozilla.universalchardet;

import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* loaded from: classes5.dex */
public class UnicodeBOMInputStream extends InputStream {
    private final BOM bom;

    /* renamed from: in */
    private final PushbackInputStream f10803in;
    private boolean skipped;

    /* loaded from: classes5.dex */
    public static final class BOM {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final byte[] bytes;
        private final String description;
        public static final BOM NONE = new BOM(new byte[0], "NONE");
        public static final BOM UTF_8 = new BOM(new byte[]{ByteSourceJsonBootstrapper.UTF8_BOM_1, ByteSourceJsonBootstrapper.UTF8_BOM_2, ByteSourceJsonBootstrapper.UTF8_BOM_3}, "UTF-8");
        public static final BOM UTF_16_LE = new BOM(new byte[]{-1, -2}, "UTF-16 little-endian");
        public static final BOM UTF_16_BE = new BOM(new byte[]{-2, -1}, "UTF-16 big-endian");
        public static final BOM UTF_32_LE = new BOM(new byte[]{-1, -2, 0, 0}, "UTF-32 little-endian");
        public static final BOM UTF_32_BE = new BOM(new byte[]{0, 0, -2, -1}, "UTF-32 big-endian");

        public final String toString() {
            return this.description;
        }

        public final byte[] getBytes() {
            byte[] bArr = this.bytes;
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            return bArr2;
        }

        private BOM(byte[] bArr, String str) {
            this.bytes = bArr;
            this.description = str;
        }
    }

    public UnicodeBOMInputStream(InputStream inputStream) throws IOException {
        this(inputStream, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public UnicodeBOMInputStream(java.io.InputStream r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            r9.<init>()
            r0 = 0
            r9.skipped = r0
            java.lang.String r1 = "invalid input stream: null is not allowed"
            java.util.Objects.requireNonNull(r10, r1)
            java.io.PushbackInputStream r1 = new java.io.PushbackInputStream
            r2 = 4
            r1.<init>(r10, r2)
            r9.f10803in = r1
            byte[] r10 = new byte[r2]
            int r3 = r1.read(r10)
            r4 = -2
            r5 = -1
            r6 = 2
            r7 = 1
            if (r3 == r6) goto L66
            r8 = 3
            if (r3 == r8) goto L4f
            if (r3 == r2) goto L25
            goto L80
        L25:
            r2 = r10[r0]
            if (r2 != r5) goto L3a
            r2 = r10[r7]
            if (r2 != r4) goto L3a
            r2 = r10[r6]
            if (r2 != 0) goto L3a
            r2 = r10[r8]
            if (r2 != 0) goto L3a
            org.mozilla.universalchardet.UnicodeBOMInputStream$BOM r2 = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.UTF_32_LE
            r9.bom = r2
            goto L84
        L3a:
            r2 = r10[r0]
            if (r2 != 0) goto L4f
            r2 = r10[r7]
            if (r2 != 0) goto L4f
            r2 = r10[r6]
            if (r2 != r4) goto L4f
            r2 = r10[r8]
            if (r2 != r5) goto L4f
            org.mozilla.universalchardet.UnicodeBOMInputStream$BOM r2 = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.UTF_32_BE
            r9.bom = r2
            goto L84
        L4f:
            r2 = r10[r0]
            r8 = -17
            if (r2 != r8) goto L66
            r2 = r10[r7]
            r8 = -69
            if (r2 != r8) goto L66
            r2 = r10[r6]
            r6 = -65
            if (r2 != r6) goto L66
            org.mozilla.universalchardet.UnicodeBOMInputStream$BOM r2 = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.UTF_8
            r9.bom = r2
            goto L84
        L66:
            r2 = r10[r0]
            if (r2 != r5) goto L73
            r2 = r10[r7]
            if (r2 != r4) goto L73
            org.mozilla.universalchardet.UnicodeBOMInputStream$BOM r2 = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.UTF_16_LE
            r9.bom = r2
            goto L84
        L73:
            r2 = r10[r0]
            if (r2 != r4) goto L80
            r2 = r10[r7]
            if (r2 != r5) goto L80
            org.mozilla.universalchardet.UnicodeBOMInputStream$BOM r2 = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.UTF_16_BE
            r9.bom = r2
            goto L84
        L80:
            org.mozilla.universalchardet.UnicodeBOMInputStream$BOM r2 = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.NONE
            r9.bom = r2
        L84:
            if (r3 <= 0) goto L89
            r1.unread(r10, r0, r3)
        L89:
            if (r11 == 0) goto L8e
            r9.skipBOM()
        L8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.universalchardet.UnicodeBOMInputStream.<init>(java.io.InputStream, boolean):void");
    }

    public final BOM getBOM() {
        return this.bom;
    }

    public final synchronized UnicodeBOMInputStream skipBOM() throws IOException {
        if (!this.skipped) {
            long length = this.bom.bytes.length;
            for (long skip = this.f10803in.skip(length); skip < length; skip++) {
                this.f10803in.read();
            }
            this.skipped = true;
        }
        return this;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        this.skipped = true;
        return this.f10803in.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        this.skipped = true;
        return this.f10803in.read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        this.skipped = true;
        return this.f10803in.read(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        this.skipped = true;
        return this.f10803in.skip(j);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f10803in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f10803in.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.f10803in.mark(i);
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f10803in.reset();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f10803in.markSupported();
    }
}
