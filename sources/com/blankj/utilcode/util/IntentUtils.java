package com.blankj.utilcode.util;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.FileProvider;
import com.anggrayudi.storage.file.MimeType;
import java.io.File;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.AgentOptions;

/* loaded from: classes.dex */
public final class IntentUtils {
    private IntentUtils() {
        throw new UnsupportedOperationException("u can't fuck me...");
    }

    public static Intent getAppDetailsSettingsIntent(String str) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + str));
        return intent.addFlags(268435456);
    }

    public static Intent getCallIntent(String str) {
        return new Intent("android.intent.action.CALL", Uri.parse("tel:" + str)).addFlags(268435456);
    }

    public static Intent getCaptureIntent(Uri uri) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(AgentOptions.OUTPUT, uri);
        return intent.addFlags(268435457);
    }

    public static Intent getComponentIntent(String str, String str2) {
        return getComponentIntent(str, str2, null);
    }

    public static Intent getComponentIntent(String str, String str2, Bundle bundle) {
        Intent intent = new Intent("android.intent.action.VIEW");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setComponent(new ComponentName(str, str2));
        return intent.addFlags(268435456);
    }

    public static Intent getDialIntent(String str) {
        return new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)).addFlags(268435456);
    }

    public static Intent getInstallAppIntent(File file, String str) {
        Uri uriForFile;
        if (file == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT < 24) {
            uriForFile = Uri.fromFile(file);
        } else {
            intent.setFlags(1);
            uriForFile = FileProvider.getUriForFile(Utils.getContext(), str, file);
        }
        intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
        return intent.addFlags(268435456);
    }

    public static Intent getInstallAppIntent(String str, String str2) {
        return getInstallAppIntent(FileUtils.getFileByPath(str), str2);
    }

    public static Intent getLaunchAppIntent(String str) {
        return Utils.getContext().getPackageManager().getLaunchIntentForPackage(str);
    }

    public static Intent getSendSmsIntent(String str, String str2) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
        intent.putExtra("sms_body", str2);
        return intent.addFlags(268435456);
    }

    public static Intent getShareImageIntent(String str, Uri uri) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setType(MimeType.IMAGE);
        return intent.setFlags(268435456);
    }

    public static Intent getShareImageIntent(String str, File file) {
        if (FileUtils.isFileExists(file)) {
            return getShareImageIntent(str, Uri.fromFile(file));
        }
        return null;
    }

    public static Intent getShareImageIntent(String str, String str2) {
        return getShareImageIntent(str, FileUtils.getFileByPath(str2));
    }

    public static Intent getShareTextIntent(String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        return intent.setFlags(268435456);
    }

    public static Intent getShutdownIntent() {
        return new Intent("android.intent.action.ACTION_SHUTDOWN").addFlags(268435456);
    }

    public static Intent getUninstallAppIntent(String str) {
        Intent intent = new Intent("android.intent.action.DELETE");
        intent.setData(Uri.parse("package:" + str));
        return intent.addFlags(268435456);
    }
}
