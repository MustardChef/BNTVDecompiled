package com.google.android.mediahome.video;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.google.android.mediahome.video.PreviewChannel;
import com.google.android.mediahome.video.VideoContract;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.mediahome:video@@1.0.0 */
/* loaded from: classes3.dex */
public class PreviewChannelHelper {
    private static final Uri zza = Uri.parse("content://com.google.android.mediahome.video");
    private final Context zzb;

    public PreviewChannelHelper(Context context) {
        this.zzb = context.getApplicationContext();
    }

    public void deleteAllPreviewProgramsByChannelId(long j) {
        this.zzb.getContentResolver().delete(VideoContract.buildPreviewProgramsUriForChannel(j), null, null);
    }

    public void deletePreviewChannel(long j) {
        this.zzb.getContentResolver().delete(VideoContract.buildChannelUri(j), null, null);
    }

    public void deletePreviewProgram(long j) {
        this.zzb.getContentResolver().delete(VideoContract.buildPreviewProgramUri(j), null, null);
    }

    public void deleteWatchNextProgram(long j) {
        this.zzb.getContentResolver().delete(VideoContract.buildWatchNextProgramUri(j), null, null);
    }

    public void deleteWatchNextPrograms() {
        this.zzb.getContentResolver().delete(VideoContract.WatchNextPrograms.CONTENT_URI, null, null);
    }

    public List<PreviewChannel> getAllChannels() {
        Cursor query = this.zzb.getContentResolver().query(VideoContract.PreviewChannels.CONTENT_URI, PreviewChannel.Columns.PROJECTION, null, null, null);
        ArrayList arrayList = new ArrayList();
        if (query != null) {
            if (query.moveToFirst()) {
                do {
                    arrayList.add(PreviewChannel.fromCursor(query));
                } while (query.moveToNext());
                query.close();
            } else {
                query.close();
            }
        }
        return arrayList;
    }

    public PreviewChannel getPreviewChannel(long j) {
        Cursor query = this.zzb.getContentResolver().query(VideoContract.buildChannelUri(j), PreviewChannel.Columns.PROJECTION, null, null, null);
        if (query != null) {
            r8 = query.moveToFirst() ? PreviewChannel.fromCursor(query) : null;
            query.close();
        }
        return r8;
    }

    public PreviewProgram getPreviewProgram(long j) {
        Cursor query = this.zzb.getContentResolver().query(VideoContract.buildPreviewProgramUri(j), null, null, null, null);
        if (query != null) {
            r8 = query.moveToFirst() ? PreviewProgram.fromCursor(query) : null;
            query.close();
        }
        return r8;
    }

    public WatchNextProgram getWatchNextProgram(long j) {
        Cursor query = this.zzb.getContentResolver().query(VideoContract.buildWatchNextProgramUri(j), null, null, null, null);
        if (query != null) {
            r8 = query.moveToFirst() ? WatchNextProgram.fromCursor(query) : null;
            query.close();
        }
        return r8;
    }

    public boolean isAvailable() {
        ContentProviderClient acquireContentProviderClient = this.zzb.getContentResolver().acquireContentProviderClient(zza);
        if (acquireContentProviderClient != null) {
            if (Build.VERSION.SDK_INT <= 23) {
                acquireContentProviderClient.release();
                return true;
            }
            acquireContentProviderClient.close();
            return true;
        }
        return false;
    }

    public long publishChannel(PreviewChannel previewChannel) {
        try {
            Uri insert = this.zzb.getContentResolver().insert(VideoContract.PreviewChannels.CONTENT_URI, previewChannel.toContentValues());
            if (insert == null || insert.equals(Uri.EMPTY)) {
                throw new NullPointerException("Channel insertion failed");
            }
            return ContentUris.parseId(insert);
        } catch (SecurityException e) {
            Log.e("PreviewChannelHelper", "Your app's ability to insert data into the Provider may have been revoked.", e);
            return -1L;
        }
    }

    public long publishPreviewProgram(PreviewProgram previewProgram) {
        try {
            Uri insert = this.zzb.getContentResolver().insert(VideoContract.PreviewPrograms.CONTENT_URI, previewProgram.toContentValues());
            if (insert == null || insert.equals(Uri.EMPTY)) {
                throw new NullPointerException("Program insertion failed");
            }
            return ContentUris.parseId(insert);
        } catch (SecurityException e) {
            Log.e("PreviewChannelHelper", "Your app's ability to insert data into the Provider may have been revoked.", e);
            return -1L;
        }
    }

    public long publishWatchNextProgram(WatchNextProgram watchNextProgram) {
        try {
            Uri insert = this.zzb.getContentResolver().insert(VideoContract.WatchNextPrograms.CONTENT_URI, watchNextProgram.toContentValues());
            if (insert == null || insert.equals(Uri.EMPTY)) {
                throw new NullPointerException("Program insertion failed");
            }
            return ContentUris.parseId(insert);
        } catch (SecurityException e) {
            Log.e("PreviewChannelHelper", "Your app's ability to insert data into the Provider may have been revoked.", e);
            return -1L;
        }
    }

    public void updatePreviewChannel(long j, PreviewChannel previewChannel) {
        PreviewChannel previewChannel2 = getPreviewChannel(j);
        if (previewChannel2 == null || !previewChannel2.hasAnyUpdatedValues(previewChannel)) {
            return;
        }
        this.zzb.getContentResolver().update(VideoContract.buildChannelUri(j), previewChannel.toContentValues(), null, null);
    }

    public void updatePreviewProgram(long j, PreviewProgram previewProgram) {
        PreviewProgram previewProgram2 = getPreviewProgram(j);
        if (previewProgram2 == null || !previewProgram2.hasAnyUpdatedValues(previewProgram)) {
            return;
        }
        this.zzb.getContentResolver().update(VideoContract.buildPreviewProgramUri(j), previewProgram.toContentValues(), null, null);
    }

    public void updateWatchNextProgram(long j, WatchNextProgram watchNextProgram) {
        WatchNextProgram watchNextProgram2 = getWatchNextProgram(j);
        if (watchNextProgram2 == null || !watchNextProgram2.hasAnyUpdatedValues(watchNextProgram)) {
            return;
        }
        this.zzb.getContentResolver().update(VideoContract.buildWatchNextProgramUri(j), watchNextProgram.toContentValues(), null, null);
    }
}
