package com.fasterxml.jackson.core.p033io;

import com.fasterxml.jackson.core.base.GeneratorBase;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* renamed from: com.fasterxml.jackson.core.io.UTF32Reader */
/* loaded from: classes2.dex */
public class UTF32Reader extends Reader {
    protected static final int LAST_VALID_UNICODE_CHAR = 1114111;

    /* renamed from: NC */
    protected static final char f2782NC = 0;
    protected final boolean _bigEndian;
    protected byte[] _buffer;
    protected int _byteCount;
    protected int _charCount;
    protected final IOContext _context;
    protected InputStream _in;
    protected int _length;
    protected final boolean _managedBuffers;
    protected int _ptr;
    protected char _surrogate = 0;
    protected char[] _tmpBuf;

    public UTF32Reader(IOContext iOContext, InputStream inputStream, byte[] bArr, int i, int i2, boolean z) {
        this._context = iOContext;
        this._in = inputStream;
        this._buffer = bArr;
        this._ptr = i;
        this._length = i2;
        this._bigEndian = z;
        this._managedBuffers = inputStream != null;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this._in;
        if (inputStream != null) {
            this._in = null;
            freeBuffers();
            inputStream.close();
        }
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        if (this._tmpBuf == null) {
            this._tmpBuf = new char[1];
        }
        if (read(this._tmpBuf, 0, 1) < 1) {
            return -1;
        }
        return this._tmpBuf[0];
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        int i5;
        if (this._buffer == null) {
            return -1;
        }
        if (i2 < 1) {
            return i2;
        }
        if (i < 0 || i + i2 > cArr.length) {
            reportBounds(cArr, i, i2);
        }
        int i6 = i2 + i;
        char c = this._surrogate;
        if (c != 0) {
            i3 = i + 1;
            cArr[i] = c;
            this._surrogate = (char) 0;
        } else {
            int i7 = this._length - this._ptr;
            if (i7 < 4 && !loadMore(i7)) {
                if (i7 == 0) {
                    return -1;
                }
                reportUnexpectedEOF(this._length - this._ptr, 4);
            }
            i3 = i;
        }
        int i8 = this._length - 4;
        while (true) {
            if (i3 >= i6) {
                break;
            }
            int i9 = this._ptr;
            if (i9 > i8) {
                break;
            }
            if (this._bigEndian) {
                byte[] bArr = this._buffer;
                i4 = (bArr[i9] << 8) | (bArr[i9 + 1] & 255);
                i5 = (bArr[i9 + 3] & 255) | ((bArr[i9 + 2] & 255) << 8);
            } else {
                byte[] bArr2 = this._buffer;
                int i10 = (bArr2[i9] & 255) | ((bArr2[i9 + 1] & 255) << 8);
                i4 = (bArr2[i9 + 3] << 8) | (bArr2[i9 + 2] & 255);
                i5 = i10;
            }
            this._ptr = i9 + 4;
            if (i4 != 0) {
                int i11 = 65535 & i4;
                int i12 = i5 | ((i11 - 1) << 16);
                if (i11 > 16) {
                    reportInvalid(i12, i3 - i, String.format(" (above 0x%08x)", Integer.valueOf((int) LAST_VALID_UNICODE_CHAR)));
                }
                int i13 = i3 + 1;
                cArr[i3] = (char) ((i12 >> 10) + GeneratorBase.SURR1_FIRST);
                int i14 = 56320 | (i12 & AnalyticsListener.EVENT_DROPPED_VIDEO_FRAMES);
                if (i13 >= i6) {
                    this._surrogate = (char) i12;
                    i3 = i13;
                    break;
                }
                i5 = i14;
                i3 = i13;
            }
            cArr[i3] = (char) i5;
            i3++;
        }
        int i15 = i3 - i;
        this._charCount += i15;
        return i15;
    }

    private void reportUnexpectedEOF(int i, int i2) throws IOException {
        int i3 = this._charCount;
        throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + i + ", needed " + i2 + ", at char #" + i3 + ", byte #" + (this._byteCount + i) + ")");
    }

    private void reportInvalid(int i, int i2, String str) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid UTF-32 character 0x");
        sb.append(Integer.toHexString(i));
        sb.append(str);
        sb.append(" at char #");
        sb.append(this._charCount + i2);
        sb.append(", byte #");
        sb.append((this._byteCount + this._ptr) - 1);
        sb.append(")");
        throw new CharConversionException(sb.toString());
    }

    private boolean loadMore(int i) throws IOException {
        byte[] bArr;
        InputStream inputStream = this._in;
        if (inputStream == null || (bArr = this._buffer) == null) {
            return false;
        }
        this._byteCount += this._length - i;
        if (i > 0) {
            int i2 = this._ptr;
            if (i2 > 0) {
                System.arraycopy(bArr, i2, bArr, 0, i);
                this._ptr = 0;
            }
            this._length = i;
        } else {
            this._ptr = 0;
            int read = inputStream.read(bArr);
            if (read < 1) {
                this._length = 0;
                if (read < 0) {
                    if (this._managedBuffers) {
                        freeBuffers();
                    }
                    return false;
                }
                reportStrangeStream();
            }
            this._length = read;
        }
        while (true) {
            int i3 = this._length;
            if (i3 >= 4) {
                return true;
            }
            InputStream inputStream2 = this._in;
            byte[] bArr2 = this._buffer;
            int read2 = inputStream2.read(bArr2, i3, bArr2.length - i3);
            if (read2 < 1) {
                if (read2 < 0) {
                    if (this._managedBuffers) {
                        freeBuffers();
                    }
                    reportUnexpectedEOF(this._length, 4);
                }
                reportStrangeStream();
            }
            this._length += read2;
        }
    }

    private void freeBuffers() {
        byte[] bArr = this._buffer;
        if (bArr != null) {
            this._buffer = null;
            IOContext iOContext = this._context;
            if (iOContext != null) {
                iOContext.releaseReadIOBuffer(bArr);
            }
        }
    }

    private void reportBounds(char[] cArr, int i, int i2) throws IOException {
        throw new ArrayIndexOutOfBoundsException(String.format("read(buf,%d,%d), cbuf[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(cArr.length)));
    }

    private void reportStrangeStream() throws IOException {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }
}
