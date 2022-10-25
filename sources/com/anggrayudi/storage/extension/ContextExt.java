package com.anggrayudi.storage.extension;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m108d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u001a\u0014\u0010\t\u001a\u00020\n*\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0002\u001a\u001a\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b\u001a\u0012\u0010\u0013\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000b\u001a\u0014\u0010\u0014\u001a\u00020\u000e*\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¨\u0006\u0017"}, m107d2 = {"fromSingleUri", "Landroidx/documentfile/provider/DocumentFile;", "Landroid/content/Context;", "fileUri", "Landroid/net/Uri;", "fromTreeUri", "getAppDirectory", "", "type", "hasActivityHandler", "", "Landroid/content/Intent;", "context", "startActivityForResultSafely", "", "Landroid/app/Activity;", "requestCode", "", SDKConstants.PARAM_INTENT, "startActivitySafely", "unregisterReceiverSafely", "receiver", "Landroid/content/BroadcastReceiver;", "storage_release"}, m106k = 2, m105mv = {1, 5, 1}, m103xi = 48)
/* renamed from: com.anggrayudi.storage.extension.ContextUtils */
/* loaded from: classes.dex */
public final class ContextExt {
    public static final String getAppDirectory(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return String.valueOf(context.getExternalFilesDir(str));
    }

    public static /* synthetic */ String getAppDirectory$default(Context context, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return getAppDirectory(context, str);
    }

    public static final boolean hasActivityHandler(Intent intent, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (intent == null ? null : intent.resolveActivity(context.getPackageManager())) != null;
    }

    public static final void startActivitySafely(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (hasActivityHandler(intent, context)) {
            context.startActivity(intent);
        }
    }

    public static final void startActivityForResultSafely(Activity activity, int i, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (hasActivityHandler(intent, activity)) {
            activity.startActivityForResult(intent, i);
        }
    }

    public static final void unregisterReceiverSafely(Context context, BroadcastReceiver broadcastReceiver) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (broadcastReceiver == null) {
            return;
        }
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (IllegalArgumentException unused) {
        }
    }

    public static final DocumentFile fromTreeUri(Context context, Uri fileUri) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(fileUri, "fileUri");
        try {
            return DocumentFile.fromTreeUri(context, fileUri);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final DocumentFile fromSingleUri(Context context, Uri fileUri) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(fileUri, "fileUri");
        try {
            return DocumentFile.fromSingleUri(context, fileUri);
        } catch (Exception unused) {
            return null;
        }
    }
}
