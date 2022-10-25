package org.mozilla.javascript.tools;

import com.google.android.exoplayer2.C3282C;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.commonjs.module.provider.ParsedContentType;

/* loaded from: classes5.dex */
public class SourceReader {
    public static URL toUrl(String str) {
        if (str.indexOf(58) >= 2) {
            try {
                return new URL(str);
            } catch (MalformedURLException unused) {
                return null;
            }
        }
        return null;
    }

    public static Object readFileOrUrl(String str, boolean z, String str2) throws IOException {
        String contentType;
        int contentLength;
        String str3;
        URL url = toUrl(str);
        FileInputStream fileInputStream = null;
        String encoding = null;
        try {
            if (url == null) {
                File file = new File(str);
                contentLength = (int) file.length();
                FileInputStream fileInputStream2 = new FileInputStream(file);
                str3 = null;
                fileInputStream = fileInputStream2;
                contentType = null;
            } else {
                URLConnection openConnection = url.openConnection();
                InputStream inputStream = openConnection.getInputStream();
                if (z) {
                    try {
                        ParsedContentType parsedContentType = new ParsedContentType(openConnection.getContentType());
                        contentType = parsedContentType.getContentType();
                        encoding = parsedContentType.getEncoding();
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = inputStream;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                } else {
                    contentType = null;
                }
                contentLength = openConnection.getContentLength();
                if (contentLength > 1048576) {
                    contentLength = -1;
                }
                str3 = encoding;
                fileInputStream = inputStream;
            }
            if (contentLength <= 0) {
                contentLength = 4096;
            }
            byte[] readStream = Kit.readStream(fileInputStream, contentLength);
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (z) {
                if (str3 != null) {
                    str2 = str3;
                } else if (readStream.length > 3 && readStream[0] == -1 && readStream[1] == -2 && readStream[2] == 0 && readStream[3] == 0) {
                    str2 = "UTF-32LE";
                } else if (readStream.length > 3 && readStream[0] == 0 && readStream[1] == 0 && readStream[2] == -2 && readStream[3] == -1) {
                    str2 = "UTF-32BE";
                } else {
                    if (readStream.length <= 2 || readStream[0] != -17 || readStream[1] != -69 || readStream[2] != -65) {
                        if (readStream.length > 1 && readStream[0] == -1 && readStream[1] == -2) {
                            str2 = C3282C.UTF16LE_NAME;
                        } else if (readStream.length > 1 && readStream[0] == -2 && readStream[1] == -1) {
                            str2 = "UTF-16BE";
                        } else if (str2 == null) {
                            if (url == null) {
                                str2 = System.getProperty("file.encoding");
                            } else if (contentType == null || !contentType.startsWith("application/")) {
                                str2 = C3282C.ASCII_NAME;
                            }
                        }
                    }
                    str2 = "UTF-8";
                }
                String str4 = new String(readStream, str2);
                return (str4.length() <= 0 || str4.charAt(0) != 65279) ? str4 : str4.substring(1);
            }
            return readStream;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
