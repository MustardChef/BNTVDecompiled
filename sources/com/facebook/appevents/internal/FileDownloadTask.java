package com.facebook.appevents.internal;

import android.os.AsyncTask;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

/* loaded from: classes.dex */
public class FileDownloadTask extends AsyncTask<String, Void, Boolean> {
    private File destFile;
    private Callback onSuccess;
    private String uriStr;

    /* loaded from: classes.dex */
    public interface Callback {
        void onComplete(File file);
    }

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ Boolean doInBackground(String[] strArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return doInBackground2(strArr);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ void onPostExecute(Boolean bool) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            onPostExecute2(bool);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public FileDownloadTask(String str, File file, Callback callback) {
        this.uriStr = str;
        this.destFile = file;
        this.onSuccess = callback;
    }

    /* renamed from: doInBackground  reason: avoid collision after fix types in other method */
    protected Boolean doInBackground2(String... strArr) {
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                URL url = new URL(this.uriStr);
                int contentLength = url.openConnection().getContentLength();
                DataInputStream dataInputStream = new DataInputStream(url.openStream());
                byte[] bArr = new byte[contentLength];
                dataInputStream.readFully(bArr);
                dataInputStream.close();
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.destFile));
                dataOutputStream.write(bArr);
                dataOutputStream.flush();
                dataOutputStream.close();
                return true;
            } catch (Exception unused) {
                return false;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* renamed from: onPostExecute  reason: avoid collision after fix types in other method */
    protected void onPostExecute2(Boolean bool) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (bool.booleanValue()) {
                this.onSuccess.onComplete(this.destFile);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
