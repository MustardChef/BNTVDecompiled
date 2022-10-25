package com.blankj.utilcode.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;

/* loaded from: classes.dex */
public final class ClipboardUtils {
    private ClipboardUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void copyIntent(Intent intent) {
        ((ClipboardManager) Utils.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newIntent(SDKConstants.PARAM_INTENT, intent));
    }

    public static void copyText(CharSequence charSequence) {
        ((ClipboardManager) Utils.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", charSequence));
    }

    public static void copyUri(Uri uri) {
        ((ClipboardManager) Utils.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newUri(Utils.getContext().getContentResolver(), ShareConstants.MEDIA_URI, uri));
    }

    public static Intent getIntent() {
        ClipData primaryClip = ((ClipboardManager) Utils.getContext().getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip == null || primaryClip.getItemCount() <= 0) {
            return null;
        }
        return primaryClip.getItemAt(0).getIntent();
    }

    public static CharSequence getText() {
        ClipData primaryClip = ((ClipboardManager) Utils.getContext().getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip == null || primaryClip.getItemCount() <= 0) {
            return null;
        }
        return primaryClip.getItemAt(0).coerceToText(Utils.getContext());
    }

    public static Uri getUri() {
        ClipData primaryClip = ((ClipboardManager) Utils.getContext().getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip == null || primaryClip.getItemCount() <= 0) {
            return null;
        }
        return primaryClip.getItemAt(0).getUri();
    }
}
