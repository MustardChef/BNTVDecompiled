package com.hippo.unifile;

import android.content.Context;
import android.net.Uri;

/* loaded from: classes3.dex */
final class MediaContract {
    private MediaContract() {
    }

    public static String getName(Context context, Uri uri) {
        return Contracts.queryForString(context, uri, "_display_name", null);
    }

    public static String getType(Context context, Uri uri) {
        return Contracts.queryForString(context, uri, "mime_type", null);
    }

    public static String getFilePath(Context context, Uri uri) {
        return Contracts.queryForString(context, uri, "_data", null);
    }

    public static long lastModified(Context context, Uri uri) {
        return Contracts.queryForLong(context, uri, "date_modified", -1L);
    }

    public static long length(Context context, Uri uri) {
        return Contracts.queryForLong(context, uri, "_size", -1L);
    }
}
