package androidx.tvprovider.media.p009tv;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import androidx.tvprovider.media.p009tv.PreviewChannel;
import androidx.tvprovider.media.p009tv.TvContractCompat;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.tvprovider.media.tv.PreviewChannelHelper */
/* loaded from: classes.dex */
public class PreviewChannelHelper {
    private static final int DEFAULT_READ_TIMEOUT_MILLIS = 10000;
    private static final int DEFAULT_URL_CONNNECTION_TIMEOUT_MILLIS = 3000;
    private static final int INVALID_CONTENT_ID = -1;
    private static final String TAG = "PreviewChannelHelper";
    private final Context mContext;
    private final int mUrlConnectionTimeoutMillis;
    private final int mUrlReadTimeoutMillis;

    public PreviewChannelHelper(Context context) {
        this(context, 3000, 10000);
    }

    public PreviewChannelHelper(Context context, int i, int i2) {
        this.mContext = context;
        this.mUrlConnectionTimeoutMillis = i;
        this.mUrlReadTimeoutMillis = i2;
    }

    public long publishChannel(PreviewChannel previewChannel) throws IOException {
        try {
            Uri insert = this.mContext.getContentResolver().insert(TvContractCompat.Channels.CONTENT_URI, previewChannel.toContentValues());
            if (insert == null || insert.equals(Uri.EMPTY)) {
                throw new NullPointerException("Channel insertion failed");
            }
            long parseId = ContentUris.parseId(insert);
            if (addChannelLogo(parseId, previewChannel)) {
                return parseId;
            }
            deletePreviewChannel(parseId);
            throw new IOException("Failed to add logo, so channel (ID=" + parseId + ") was not created");
        } catch (SecurityException e) {
            Log.e(TAG, "Your app's ability to insert data into the TvProvider may have been revoked.", e);
            return -1L;
        }
    }

    public long publishDefaultChannel(PreviewChannel previewChannel) throws IOException {
        long publishChannel = publishChannel(previewChannel);
        TvContractCompat.requestChannelBrowsable(this.mContext, publishChannel);
        return publishChannel;
    }

    public List<PreviewChannel> getAllChannels() {
        Cursor query = this.mContext.getContentResolver().query(TvContractCompat.Channels.CONTENT_URI, PreviewChannel.Columns.PROJECTION, null, null, null);
        ArrayList arrayList = new ArrayList();
        if (query == null || !query.moveToFirst()) {
            return arrayList;
        }
        do {
            arrayList.add(PreviewChannel.fromCursor(query));
        } while (query.moveToNext());
        return arrayList;
    }

    public PreviewChannel getPreviewChannel(long j) {
        Cursor query = this.mContext.getContentResolver().query(TvContractCompat.buildChannelUri(j), PreviewChannel.Columns.PROJECTION, null, null, null);
        if (query == null || !query.moveToFirst()) {
            return null;
        }
        return PreviewChannel.fromCursor(query);
    }

    public void updatePreviewChannel(long j, PreviewChannel previewChannel) throws IOException {
        PreviewChannel previewChannel2 = getPreviewChannel(j);
        if (previewChannel2 != null && previewChannel2.hasAnyUpdatedValues(previewChannel)) {
            updatePreviewChannelInternal(j, previewChannel);
        }
        if (!previewChannel.isLogoChanged() || addChannelLogo(j, previewChannel)) {
            return;
        }
        throw new IOException("Fail to update channel (ID=" + j + ") logo.");
    }

    protected void updatePreviewChannelInternal(long j, PreviewChannel previewChannel) {
        this.mContext.getContentResolver().update(TvContractCompat.buildChannelUri(j), previewChannel.toContentValues(), null, null);
    }

    private boolean addChannelLogo(long j, PreviewChannel previewChannel) {
        boolean z = false;
        if (previewChannel.isLogoChanged()) {
            Bitmap logo = previewChannel.getLogo(this.mContext);
            if (logo == null) {
                logo = getLogoFromUri(previewChannel.getLogoUri());
            }
            try {
                OutputStream openOutputStream = this.mContext.getContentResolver().openOutputStream(TvContractCompat.buildChannelLogoUri(j));
                z = logo.compress(Bitmap.CompressFormat.PNG, 100, openOutputStream);
                openOutputStream.flush();
                if (openOutputStream != null) {
                    openOutputStream.close();
                }
            } catch (SQLiteException | IOException | NullPointerException e) {
                Log.i(TAG, "Failed to add logo to the published channel (ID= " + j + ")", e);
            }
            return z;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Bitmap getLogoFromUri(android.net.Uri r8) {
        /*
            r7 = this;
            android.net.Uri r0 = r8.normalizeScheme()
            java.lang.String r0 = r0.getScheme()
            r1 = 0
            java.lang.String r2 = "android.resource"
            boolean r2 = r2.equals(r0)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L47
            if (r2 != 0) goto L27
            java.lang.String r2 = "file"
            boolean r2 = r2.equals(r0)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L47
            if (r2 != 0) goto L27
            java.lang.String r2 = "content"
            boolean r0 = r2.equals(r0)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L47
            if (r0 == 0) goto L22
            goto L27
        L22:
            android.graphics.Bitmap r8 = r7.downloadBitmap(r8)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L47
            goto L36
        L27:
            android.content.Context r0 = r7.mContext     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L47
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L47
            java.io.InputStream r0 = r0.openInputStream(r8)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L47
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeStream(r0)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L40
            r1 = r0
        L36:
            if (r1 == 0) goto L3b
            r1.close()     // Catch: java.io.IOException -> L3b
        L3b:
            r1 = r8
            goto L64
        L3d:
            r8 = move-exception
            r1 = r0
            goto L67
        L40:
            r2 = move-exception
            r6 = r2
            r2 = r0
            r0 = r6
            goto L49
        L45:
            r8 = move-exception
            goto L67
        L47:
            r0 = move-exception
            r2 = r1
        L49:
            java.lang.String r3 = "PreviewChannelHelper"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L65
            r4.<init>()     // Catch: java.lang.Throwable -> L65
            java.lang.String r5 = "Failed to get logo from the URI: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L65
            r4.append(r8)     // Catch: java.lang.Throwable -> L65
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Throwable -> L65
            android.util.Log.e(r3, r8, r0)     // Catch: java.lang.Throwable -> L65
            if (r2 == 0) goto L64
            r2.close()     // Catch: java.io.IOException -> L64
        L64:
            return r1
        L65:
            r8 = move-exception
            r1 = r2
        L67:
            if (r1 == 0) goto L6c
            r1.close()     // Catch: java.io.IOException -> L6c
        L6c:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.tvprovider.media.p009tv.PreviewChannelHelper.getLogoFromUri(android.net.Uri):android.graphics.Bitmap");
    }

    protected Bitmap downloadBitmap(Uri uri) throws IOException {
        URLConnection uRLConnection;
        InputStream inputStream = null;
        try {
            uRLConnection = new URL(uri.toString()).openConnection();
        } catch (Throwable th) {
            th = th;
            uRLConnection = null;
        }
        try {
            uRLConnection.setConnectTimeout(this.mUrlConnectionTimeoutMillis);
            uRLConnection.setReadTimeout(this.mUrlReadTimeoutMillis);
            inputStream = uRLConnection.getInputStream();
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            if (uRLConnection instanceof HttpURLConnection) {
                ((HttpURLConnection) uRLConnection).disconnect();
            }
            return decodeStream;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            if (uRLConnection instanceof HttpURLConnection) {
                ((HttpURLConnection) uRLConnection).disconnect();
            }
            throw th;
        }
    }

    public void deletePreviewChannel(long j) {
        this.mContext.getContentResolver().delete(TvContractCompat.buildChannelUri(j), null, null);
    }

    public long publishPreviewProgram(PreviewProgram previewProgram) {
        try {
            return ContentUris.parseId(this.mContext.getContentResolver().insert(TvContractCompat.PreviewPrograms.CONTENT_URI, previewProgram.toContentValues()));
        } catch (SecurityException e) {
            Log.e(TAG, "Your app's ability to insert data into the TvProvider may have been revoked.", e);
            return -1L;
        }
    }

    public PreviewProgram getPreviewProgram(long j) {
        Cursor query = this.mContext.getContentResolver().query(TvContractCompat.buildPreviewProgramUri(j), null, null, null, null);
        if (query == null || !query.moveToFirst()) {
            return null;
        }
        return PreviewProgram.fromCursor(query);
    }

    public void updatePreviewProgram(long j, PreviewProgram previewProgram) {
        PreviewProgram previewProgram2 = getPreviewProgram(j);
        if (previewProgram2 == null || !previewProgram2.hasAnyUpdatedValues(previewProgram)) {
            return;
        }
        updatePreviewProgramInternal(j, previewProgram);
    }

    void updatePreviewProgramInternal(long j, PreviewProgram previewProgram) {
        this.mContext.getContentResolver().update(TvContractCompat.buildPreviewProgramUri(j), previewProgram.toContentValues(), null, null);
    }

    public void deletePreviewProgram(long j) {
        this.mContext.getContentResolver().delete(TvContractCompat.buildPreviewProgramUri(j), null, null);
    }

    public long publishWatchNextProgram(WatchNextProgram watchNextProgram) {
        try {
            return ContentUris.parseId(this.mContext.getContentResolver().insert(TvContractCompat.WatchNextPrograms.CONTENT_URI, watchNextProgram.toContentValues()));
        } catch (SecurityException e) {
            Log.e(TAG, "Your app's ability to insert data into the TvProvider may have been revoked.", e);
            return -1L;
        }
    }

    public WatchNextProgram getWatchNextProgram(long j) {
        Cursor query = this.mContext.getContentResolver().query(TvContractCompat.buildWatchNextProgramUri(j), null, null, null, null);
        if (query == null || !query.moveToFirst()) {
            return null;
        }
        return WatchNextProgram.fromCursor(query);
    }

    public void updateWatchNextProgram(WatchNextProgram watchNextProgram, long j) {
        WatchNextProgram watchNextProgram2 = getWatchNextProgram(j);
        if (watchNextProgram2 == null || !watchNextProgram2.hasAnyUpdatedValues(watchNextProgram)) {
            return;
        }
        updateWatchNextProgram(j, watchNextProgram);
    }

    void updateWatchNextProgram(long j, WatchNextProgram watchNextProgram) {
        this.mContext.getContentResolver().update(TvContractCompat.buildWatchNextProgramUri(j), watchNextProgram.toContentValues(), null, null);
    }
}
