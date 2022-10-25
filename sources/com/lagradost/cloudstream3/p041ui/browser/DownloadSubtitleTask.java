package com.lagradost.cloudstream3.p041ui.browser;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import java.lang.ref.WeakReference;
import okhttp3.ResponseBody;

/* renamed from: com.lagradost.cloudstream3.ui.browser.DownloadSubtitleTask */
/* loaded from: classes.dex */
public class DownloadSubtitleTask extends AsyncTask<ResponseBody, Void, String> {
    WeakReference<Context> contextWeakReference;
    WeakReference<String> fileNameWeakReference;
    ICallback<String> iCallback;

    public DownloadSubtitleTask(Context context, String str, ICallback<String> iCallback) {
        this.contextWeakReference = new WeakReference<>(context);
        this.fileNameWeakReference = new WeakReference<>(str);
        this.iCallback = iCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public String doInBackground(ResponseBody... responseBodyArr) {
        String str;
        if (this.contextWeakReference.get() != null) {
            Context context = this.contextWeakReference.get();
            if (this.fileNameWeakReference.get() != null) {
                str = this.fileNameWeakReference.get();
            } else {
                str = "file" + System.currentTimeMillis() + ".srt";
            }
            String writeResponseBodyToDisk = writeResponseBodyToDisk(context, responseBodyArr[0], str);
            StringBuilder sb = new StringBuilder();
            sb.append("file download was a success? ");
            sb.append(writeResponseBodyToDisk);
            Log.d("DuongKK", sb.toString() != null ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
            return writeResponseBodyToDisk;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((DownloadSubtitleTask) str);
        ICallback<String> iCallback = this.iCallback;
        if (iCallback != null) {
            iCallback.onCallback(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e2 A[Catch: IOException -> 0x00eb, TryCatch #5 {IOException -> 0x00eb, blocks: (B:3:0x0001, B:14:0x008f, B:15:0x0092, B:18:0x0098, B:19:0x009b, B:36:0x00d6, B:38:0x00db, B:42:0x00e2, B:44:0x00e7, B:45:0x00ea), top: B:51:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e7 A[Catch: IOException -> 0x00eb, TryCatch #5 {IOException -> 0x00eb, blocks: (B:3:0x0001, B:14:0x008f, B:15:0x0092, B:18:0x0098, B:19:0x009b, B:36:0x00d6, B:38:0x00db, B:42:0x00e2, B:44:0x00e7, B:45:0x00ea), top: B:51:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String writeResponseBodyToDisk(android.content.Context r12, okhttp3.ResponseBody r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.browser.DownloadSubtitleTask.writeResponseBodyToDisk(android.content.Context, okhttp3.ResponseBody, java.lang.String):java.lang.String");
    }
}
