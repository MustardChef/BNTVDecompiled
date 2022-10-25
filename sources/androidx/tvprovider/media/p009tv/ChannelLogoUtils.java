package androidx.tvprovider.media.p009tv;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.tv.TvContract;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/* renamed from: androidx.tvprovider.media.tv.ChannelLogoUtils */
/* loaded from: classes.dex */
public class ChannelLogoUtils {
    private static final int CONNECTION_TIMEOUT_MS_FOR_URLCONNECTION = 3000;
    private static final int READ_TIMEOUT_MS_FOR_URLCONNECTION = 10000;
    private static final String TAG = "ChannelLogoUtils";

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004b, code lost:
        if ((r0 instanceof java.net.HttpURLConnection) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004d, code lost:
        ((java.net.HttpURLConnection) r0).disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0085, code lost:
        if ((r0 instanceof java.net.HttpURLConnection) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0088, code lost:
        if (r1 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008e, code lost:
        if (storeChannelLogo(r8, r9, r1) == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0090, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0092, code lost:
        return false;
     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean storeChannelLogo(android.content.Context r8, long r9, android.net.Uri r11) {
        /*
            android.net.Uri r0 = r11.normalizeScheme()
            java.lang.String r0 = r0.getScheme()
            r1 = 0
            java.lang.String r2 = "android.resource"
            boolean r2 = r2.equals(r0)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e
            if (r2 != 0) goto L35
            java.lang.String r2 = "file"
            boolean r2 = r2.equals(r0)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e
            if (r2 != 0) goto L35
            java.lang.String r2 = "content"
            boolean r0 = r2.equals(r0)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e
            if (r0 == 0) goto L22
            goto L35
        L22:
            java.lang.String r0 = r11.toString()     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e
            java.net.URLConnection r0 = getUrlConnection(r0)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e
            java.io.InputStream r2 = r0.getInputStream()     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32
            goto L3e
        L2f:
            r8 = move-exception
            goto L96
        L32:
            r2 = move-exception
            r3 = r1
            goto L61
        L35:
            android.content.ContentResolver r0 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e
            java.io.InputStream r2 = r0.openInputStream(r11)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e
            r0 = r1
        L3e:
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L56
            if (r2 == 0) goto L49
            r2.close()     // Catch: java.io.IOException -> L48
            goto L49
        L48:
        L49:
            boolean r11 = r0 instanceof java.net.HttpURLConnection
            if (r11 == 0) goto L88
        L4d:
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
            r0.disconnect()
            goto L88
        L53:
            r8 = move-exception
            r1 = r2
            goto L96
        L56:
            r3 = move-exception
            r7 = r3
            r3 = r2
            r2 = r7
            goto L61
        L5b:
            r8 = move-exception
            r0 = r1
            goto L96
        L5e:
            r2 = move-exception
            r0 = r1
            r3 = r0
        L61:
            java.lang.String r4 = "ChannelLogoUtils"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L94
            r5.<init>()     // Catch: java.lang.Throwable -> L94
            java.lang.String r6 = "Failed to get logo from the URI: "
            r5.append(r6)     // Catch: java.lang.Throwable -> L94
            r5.append(r11)     // Catch: java.lang.Throwable -> L94
            java.lang.String r11 = "\n"
            r5.append(r11)     // Catch: java.lang.Throwable -> L94
            java.lang.String r11 = r5.toString()     // Catch: java.lang.Throwable -> L94
            android.util.Log.i(r4, r11, r2)     // Catch: java.lang.Throwable -> L94
            if (r3 == 0) goto L83
            r3.close()     // Catch: java.io.IOException -> L82
            goto L83
        L82:
        L83:
            boolean r11 = r0 instanceof java.net.HttpURLConnection
            if (r11 == 0) goto L88
            goto L4d
        L88:
            if (r1 == 0) goto L92
            boolean r8 = storeChannelLogo(r8, r9, r1)
            if (r8 == 0) goto L92
            r8 = 1
            goto L93
        L92:
            r8 = 0
        L93:
            return r8
        L94:
            r8 = move-exception
            r1 = r3
        L96:
            if (r1 == 0) goto L9d
            r1.close()     // Catch: java.io.IOException -> L9c
            goto L9d
        L9c:
        L9d:
            boolean r9 = r0 instanceof java.net.HttpURLConnection
            if (r9 == 0) goto La6
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
            r0.disconnect()
        La6:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.tvprovider.media.p009tv.ChannelLogoUtils.storeChannelLogo(android.content.Context, long, android.net.Uri):boolean");
    }

    public static boolean storeChannelLogo(Context context, long j, Bitmap bitmap) {
        OutputStream openOutputStream;
        boolean z = false;
        try {
            openOutputStream = context.getContentResolver().openOutputStream(TvContract.buildChannelLogoUri(j));
        } catch (SQLiteException | IOException e) {
            Log.i(TAG, "Failed to store the logo to the system content provider.\n", e);
        }
        try {
            z = bitmap.compress(Bitmap.CompressFormat.PNG, 100, openOutputStream);
            openOutputStream.flush();
            if (openOutputStream != null) {
                openOutputStream.close();
            }
            return z;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (openOutputStream != null) {
                    try {
                        openOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static Bitmap loadChannelLogo(Context context, long j) {
        try {
            return BitmapFactory.decodeStream(context.getContentResolver().openInputStream(TvContract.buildChannelLogoUri(j)));
        } catch (FileNotFoundException e) {
            Log.i(TAG, "Channel logo for channel (ID:" + j + ") not found.", e);
            return null;
        }
    }

    private static URLConnection getUrlConnection(String str) throws IOException {
        URLConnection openConnection = new URL(str).openConnection();
        openConnection.setConnectTimeout(3000);
        openConnection.setReadTimeout(10000);
        return openConnection;
    }
}
