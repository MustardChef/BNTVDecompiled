package com.lagradost.cloudstream3.p041ui.browser;

import android.util.Log;
import com.blankj.utilcode.util.ZipUtils;
import com.facebook.internal.ServerProtocol;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.services.ApiService;
import com.lagradost.cloudstream3.services.ApiUtils;
import com.lagradost.cloudstream3.services.ResponseSubtitle;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* compiled from: SubtitleBrowserRepository.kt */
@Metadata(m108d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n\u0012\u0004\u0012\u00020\u00040\tJ\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006J$\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00040\tJ(\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/browser/SubtitleBrowserRepository;", "", "()V", "downloadSubtitle", "", "url", "", "fileDir", "callback", "Lkotlin/Function1;", "", "extractZipSubtitle", "responseBody", "Lokhttp3/ResponseBody;", "uploadFile", "file", "Ljava/io/File;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "writeResponseBodyToDisk", "body", "filename", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.browser.SubtitleBrowserRepository */
/* loaded from: classes.dex */
public final class SubtitleBrowserRepository {
    public final void downloadSubtitle(String url, final String fileDir, final Function1<? super List<String>, Unit> callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(fileDir, "fileDir");
        Intrinsics.checkNotNullParameter(callback, "callback");
        new ApiUtils().createApi().downloadZipSubtitleFile(url).enqueue(new Callback<ResponseBody>() { // from class: com.lagradost.cloudstream3.ui.browser.SubtitleBrowserRepository$downloadSubtitle$1
            @Override // retrofit2.Callback
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                ResponseBody body = response.body();
                if (body != null) {
                    SubtitleBrowserRepository subtitleBrowserRepository = SubtitleBrowserRepository.this;
                    String str = fileDir;
                    Function1<List<String>, Unit> function1 = callback;
                    List<String> extractZipSubtitle = subtitleBrowserRepository.extractZipSubtitle(body, str);
                    Log.d("DuongKK", "File " + extractZipSubtitle);
                    if (extractZipSubtitle != null) {
                        function1.invoke(extractZipSubtitle);
                    }
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                Log.e("DuongKK", "onFailure " + t.getMessage());
            }
        });
    }

    public final List<String> extractZipSubtitle(ResponseBody responseBody, String fileDir) {
        Intrinsics.checkNotNullParameter(responseBody, "responseBody");
        Intrinsics.checkNotNullParameter(fileDir, "fileDir");
        List<String> writeResponseBodyToDisk = writeResponseBodyToDisk(fileDir, responseBody, "file" + System.currentTimeMillis() + ".srt");
        StringBuilder sb = new StringBuilder();
        sb.append("file download was a success? ");
        sb.append(writeResponseBodyToDisk);
        Log.d("DuongKK", sb.toString() != null ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return writeResponseBodyToDisk;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [okhttp3.ResponseBody] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r13v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v7 */
    private final List<String> writeResponseBodyToDisk(String str, ResponseBody responseBody, String str2) {
        FileOutputStream fileOutputStream;
        ArrayList arrayList;
        try {
            String substring = str2.substring(StringsKt.lastIndexOf$default((CharSequence) str2, ".", 0, false, 6, (Object) null));
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            ?? r6 = 4;
            File file = new File(str + File.separator + StringsKt.replace$default(str2, substring, ".zip", false, 4, (Object) null));
            try {
                try {
                    byte[] bArr = new byte[4096];
                    long contentLength = responseBody.contentLength();
                    long j = 0;
                    responseBody = responseBody.byteStream();
                    try {
                        fileOutputStream = new FileOutputStream(file);
                        while (true) {
                            try {
                                int read = responseBody.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                                j += read;
                                Log.d("DuongKK", "file download: " + j + " of " + contentLength);
                            } catch (IOException e) {
                                e = e;
                                e.printStackTrace();
                                arrayList = null;
                                if (responseBody != 0) {
                                    responseBody.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                return arrayList;
                            }
                        }
                        fileOutputStream.flush();
                        boolean unzipFile = ZipUtils.unzipFile(file, file.getParentFile());
                        Log.d("DuongKK", "unzipSuccess: " + unzipFile);
                        if (unzipFile) {
                            List<String> filesPath = ZipUtils.getFilesPath(file);
                            arrayList = new ArrayList();
                            Iterator<String> it = filesPath.iterator();
                            while (it.hasNext()) {
                                arrayList.add(new File(str + File.separator + it.next()).getAbsolutePath());
                            }
                        } else {
                            arrayList = null;
                        }
                        if (responseBody != 0) {
                            responseBody.close();
                        }
                    } catch (IOException e2) {
                        e = e2;
                        fileOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        r6 = 0;
                        if (responseBody != 0) {
                            responseBody.close();
                        }
                        if (r6 != 0) {
                            r6.close();
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    responseBody = 0;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    responseBody = 0;
                    r6 = 0;
                }
                fileOutputStream.close();
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public final void uploadFile(File file, Function1<? super SubtitleFile, Unit> callback) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Log.d("Du", "File: " + file.getAbsolutePath());
        ApiService createApi = new ApiUtils().createApi();
        MultipartBody.Part createFormData = MultipartBody.Part.Companion.createFormData("myFile", file.getName(), RequestBody.Companion.create(MediaType.Companion.parse("multipart/form-data"), file));
        RequestBody.Companion.create(MultipartBody.FORM, "hello, this is description speaking");
        Response<ResponseSubtitle> execute = createApi.upload(createFormData).execute();
        if (execute.isSuccessful() && execute.body() != null) {
            ResponseSubtitle body = execute.body();
            StringBuilder sb = new StringBuilder();
            sb.append("Data sub ");
            sb.append(body != null ? body.getFullPath() : null);
            Log.d("Du", sb.toString());
            if (body != null) {
                callback.invoke(new SubtitleFile(String.valueOf(file.getName()), body.getFullPath(), null, 4, null));
                return;
            }
            return;
        }
        Log.e("Du", "Data sub error");
        callback.invoke(null);
    }
}
