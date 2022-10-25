package org.mozilla.universalchardet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.EscCharsetProber;
import org.mozilla.universalchardet.prober.Latin1Prober;
import org.mozilla.universalchardet.prober.MBCSGroupProber;
import org.mozilla.universalchardet.prober.SBCSGroupProber;

/* loaded from: classes5.dex */
public class UniversalDetector {
    public static final float MINIMUM_THRESHOLD = 0.2f;
    public static final float SHORTCUT_THRESHOLD = 0.95f;
    private String detectedCharset;
    private boolean done;
    private CharsetProber escCharsetProber;
    private boolean gotData;
    private InputState inputState;
    private byte lastChar;
    private CharsetListener listener;
    private boolean onlyPrintableASCII;
    private CharsetProber[] probers;
    private boolean start;

    /* loaded from: classes5.dex */
    public enum InputState {
        PURE_ASCII,
        ESC_ASCII,
        HIGHBYTE
    }

    public UniversalDetector() {
        this(null);
    }

    public UniversalDetector(CharsetListener charsetListener) {
        this.onlyPrintableASCII = true;
        this.listener = charsetListener;
        this.escCharsetProber = null;
        this.probers = new CharsetProber[3];
        reset();
    }

    public boolean isDone() {
        return this.done;
    }

    public String getDetectedCharset() {
        return this.detectedCharset;
    }

    public void setListener(CharsetListener charsetListener) {
        this.listener = charsetListener;
    }

    public CharsetListener getListener() {
        return this.listener;
    }

    public void handleData(byte[] bArr) {
        handleData(bArr, 0, bArr.length);
    }

    public void handleData(byte[] bArr, int i, int i2) {
        String detectCharsetFromBOM;
        if (this.done) {
            return;
        }
        if (i2 > 0) {
            this.gotData = true;
        }
        int i3 = 0;
        if (this.start) {
            this.start = false;
            if (i2 > 3 && (detectCharsetFromBOM = detectCharsetFromBOM(bArr, i)) != null) {
                this.detectedCharset = detectCharsetFromBOM;
                this.done = true;
                return;
            }
        }
        int i4 = i + i2;
        for (int i5 = i; i5 < i4; i5++) {
            int i6 = bArr[i5] & 255;
            if ((i6 & 128) != 0 && i6 != 160) {
                if (this.inputState != InputState.HIGHBYTE) {
                    this.inputState = InputState.HIGHBYTE;
                    if (this.escCharsetProber != null) {
                        this.escCharsetProber = null;
                    }
                    CharsetProber[] charsetProberArr = this.probers;
                    if (charsetProberArr[0] == null) {
                        charsetProberArr[0] = new MBCSGroupProber();
                    }
                    CharsetProber[] charsetProberArr2 = this.probers;
                    if (charsetProberArr2[1] == null) {
                        charsetProberArr2[1] = new SBCSGroupProber();
                    }
                    CharsetProber[] charsetProberArr3 = this.probers;
                    if (charsetProberArr3[2] == null) {
                        charsetProberArr3[2] = new Latin1Prober();
                    }
                }
            } else {
                if (this.inputState == InputState.PURE_ASCII && (i6 == 27 || (i6 == 123 && this.lastChar == 126))) {
                    this.inputState = InputState.ESC_ASCII;
                }
                if (this.inputState == InputState.PURE_ASCII && this.onlyPrintableASCII) {
                    this.onlyPrintableASCII = (i6 >= 32 && i6 <= 126) || i6 == 10 || i6 == 13 || i6 == 9;
                }
                this.lastChar = bArr[i5];
            }
        }
        if (this.inputState == InputState.ESC_ASCII) {
            if (this.escCharsetProber == null) {
                this.escCharsetProber = new EscCharsetProber();
            }
            if (this.escCharsetProber.handleData(bArr, i, i2) == CharsetProber.ProbingState.FOUND_IT) {
                this.done = true;
                this.detectedCharset = this.escCharsetProber.getCharSetName();
            }
        } else if (this.inputState == InputState.HIGHBYTE) {
            while (true) {
                CharsetProber[] charsetProberArr4 = this.probers;
                if (i3 >= charsetProberArr4.length) {
                    return;
                }
                if (charsetProberArr4[i3].handleData(bArr, i, i2) == CharsetProber.ProbingState.FOUND_IT) {
                    this.done = true;
                    this.detectedCharset = this.probers[i3].getCharSetName();
                    return;
                }
                i3++;
            }
        }
    }

    public static String detectCharsetFromBOM(byte[] bArr) {
        return detectCharsetFromBOM(bArr, 0);
    }

    private static String detectCharsetFromBOM(byte[] bArr, int i) {
        int i2 = i + 3;
        if (bArr.length > i2) {
            int i3 = bArr[i] & 255;
            int i4 = bArr[i + 1] & 255;
            int i5 = bArr[i + 2] & 255;
            int i6 = bArr[i2] & 255;
            if (i3 == 0) {
                if (i4 == 0 && i5 == 254 && i6 == 255) {
                    return Constants.CHARSET_UTF_32BE;
                }
                if (i4 == 0 && i5 == 255 && i6 == 254) {
                    return Constants.CHARSET_X_ISO_10646_UCS_4_2143;
                }
                return null;
            } else if (i3 == 239) {
                if (i4 == 187 && i5 == 191) {
                    return Constants.CHARSET_UTF_8;
                }
                return null;
            } else if (i3 == 254) {
                if (i4 == 255 && i5 == 0 && i6 == 0) {
                    return Constants.CHARSET_X_ISO_10646_UCS_4_3412;
                }
                if (i4 == 255) {
                    return Constants.CHARSET_UTF_16BE;
                }
                return null;
            } else if (i3 != 255) {
                return null;
            } else {
                if (i4 == 254 && i5 == 0 && i6 == 0) {
                    return Constants.CHARSET_UTF_32LE;
                }
                if (i4 == 254) {
                    return Constants.CHARSET_UTF_16LE;
                }
                return null;
            }
        }
        return null;
    }

    public void dataEnd() {
        CharsetProber[] charsetProberArr;
        if (this.gotData) {
            String str = this.detectedCharset;
            if (str != null) {
                this.done = true;
                CharsetListener charsetListener = this.listener;
                if (charsetListener != null) {
                    charsetListener.report(str);
                }
            } else if (this.inputState != InputState.HIGHBYTE) {
                if (this.inputState != InputState.ESC_ASCII && this.inputState == InputState.PURE_ASCII && this.onlyPrintableASCII) {
                    this.detectedCharset = Constants.CHARSET_US_ASCCI;
                }
            } else {
                float f = 0.0f;
                int i = 0;
                int i2 = 0;
                while (true) {
                    charsetProberArr = this.probers;
                    if (i >= charsetProberArr.length) {
                        break;
                    }
                    float confidence = charsetProberArr[i].getConfidence();
                    if (confidence > f) {
                        i2 = i;
                        f = confidence;
                    }
                    i++;
                }
                if (f > 0.2f) {
                    String charSetName = charsetProberArr[i2].getCharSetName();
                    this.detectedCharset = charSetName;
                    CharsetListener charsetListener2 = this.listener;
                    if (charsetListener2 != null) {
                        charsetListener2.report(charSetName);
                    }
                }
            }
        }
    }

    public final void reset() {
        int i = 0;
        this.done = false;
        this.start = true;
        this.detectedCharset = null;
        this.gotData = false;
        this.inputState = InputState.PURE_ASCII;
        this.lastChar = (byte) 0;
        CharsetProber charsetProber = this.escCharsetProber;
        if (charsetProber != null) {
            charsetProber.reset();
        }
        while (true) {
            CharsetProber[] charsetProberArr = this.probers;
            if (i >= charsetProberArr.length) {
                return;
            }
            if (charsetProberArr[i] != null) {
                charsetProberArr[i].reset();
            }
            i++;
        }
    }

    public static String detectCharset(File file) throws IOException {
        return detectCharset(file.toPath());
    }

    public static String detectCharset(Path path) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(path, new OpenOption[0]));
        try {
            String detectCharset = detectCharset(bufferedInputStream);
            bufferedInputStream.close();
            return detectCharset;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static String detectCharset(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        UniversalDetector universalDetector = new UniversalDetector(null);
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0 || universalDetector.isDone()) {
                break;
            }
            universalDetector.handleData(bArr, 0, read);
        }
        universalDetector.dataEnd();
        String detectedCharset = universalDetector.getDetectedCharset();
        universalDetector.reset();
        return detectedCharset;
    }
}
