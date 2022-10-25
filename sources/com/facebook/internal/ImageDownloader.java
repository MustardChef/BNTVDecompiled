package com.facebook.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.WorkQueue;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ImageDownloader {
    private static final int CACHE_READ_QUEUE_MAX_CONCURRENT = 2;
    private static final int DOWNLOAD_QUEUE_MAX_CONCURRENT = 8;
    private static Handler handler;
    private static WorkQueue downloadQueue = new WorkQueue(8);
    private static WorkQueue cacheReadQueue = new WorkQueue(2);
    private static final Map<RequestKey, DownloaderContext> pendingRequests = new HashMap();

    public static void downloadAsync(ImageRequest imageRequest) {
        if (imageRequest == null) {
            return;
        }
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            DownloaderContext downloaderContext = map.get(requestKey);
            if (downloaderContext != null) {
                downloaderContext.request = imageRequest;
                downloaderContext.isCancelled = false;
                downloaderContext.workItem.moveToFront();
            } else {
                enqueueCacheRead(imageRequest, requestKey, imageRequest.isCachedRedirectAllowed());
            }
        }
    }

    public static boolean cancelRequest(ImageRequest imageRequest) {
        boolean z;
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            DownloaderContext downloaderContext = map.get(requestKey);
            z = true;
            if (downloaderContext == null) {
                z = false;
            } else if (downloaderContext.workItem.cancel()) {
                map.remove(requestKey);
            } else {
                downloaderContext.isCancelled = true;
            }
        }
        return z;
    }

    public static void prioritizeRequest(ImageRequest imageRequest) {
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            DownloaderContext downloaderContext = map.get(requestKey);
            if (downloaderContext != null) {
                downloaderContext.workItem.moveToFront();
            }
        }
    }

    public static void clearCache(Context context) {
        ImageResponseCache.clearCache(context);
        UrlRedirectCache.clearCache();
    }

    private static void enqueueCacheRead(ImageRequest imageRequest, RequestKey requestKey, boolean z) {
        enqueueRequest(imageRequest, requestKey, cacheReadQueue, new CacheReadWorkItem(imageRequest.getContext(), requestKey, z));
    }

    private static void enqueueDownload(ImageRequest imageRequest, RequestKey requestKey) {
        enqueueRequest(imageRequest, requestKey, downloadQueue, new DownloadImageWorkItem(imageRequest.getContext(), requestKey));
    }

    private static void enqueueRequest(ImageRequest imageRequest, RequestKey requestKey, WorkQueue workQueue, Runnable runnable) {
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            DownloaderContext downloaderContext = new DownloaderContext();
            downloaderContext.request = imageRequest;
            map.put(requestKey, downloaderContext);
            downloaderContext.workItem = workQueue.addActiveWorkItem(runnable);
        }
    }

    private static void issueResponse(RequestKey requestKey, final Exception exc, final Bitmap bitmap, final boolean z) {
        final ImageRequest imageRequest;
        final ImageRequest.Callback callback;
        DownloaderContext removePendingRequest = removePendingRequest(requestKey);
        if (removePendingRequest == null || removePendingRequest.isCancelled || (callback = (imageRequest = removePendingRequest.request).getCallback()) == null) {
            return;
        }
        getHandler().post(new Runnable() { // from class: com.facebook.internal.ImageDownloader.1
            @Override // java.lang.Runnable
            public void run() {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    callback.onCompleted(new ImageResponse(ImageRequest.this, exc, z, bitmap));
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readFromCache(RequestKey requestKey, Context context, boolean z) {
        InputStream inputStream;
        Uri redirectedUri;
        boolean z2 = false;
        if (!z || (redirectedUri = UrlRedirectCache.getRedirectedUri(requestKey.uri)) == null) {
            inputStream = null;
        } else {
            inputStream = ImageResponseCache.getCachedImageStream(redirectedUri, context);
            if (inputStream != null) {
                z2 = true;
            }
        }
        if (!z2) {
            inputStream = ImageResponseCache.getCachedImageStream(requestKey.uri, context);
        }
        if (inputStream != null) {
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            Utility.closeQuietly(inputStream);
            issueResponse(requestKey, null, decodeStream, z2);
            return;
        }
        DownloaderContext removePendingRequest = removePendingRequest(requestKey);
        if (removePendingRequest == null || removePendingRequest.isCancelled) {
            return;
        }
        enqueueDownload(removePendingRequest.request, requestKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void download(com.facebook.internal.ImageDownloader.RequestKey r9, android.content.Context r10) {
        /*
            r0 = 0
            r1 = 0
            r2 = 1
            java.net.URL r3 = new java.net.URL     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Lb1
            android.net.Uri r4 = r9.uri     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Lb1
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Lb1
            r3.<init>(r4)     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Lb1
            java.net.URLConnection r3 = r3.openConnection()     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Lb1
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Lb1
            r3.setInstanceFollowRedirects(r1)     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La5
            int r4 = r3.getResponseCode()     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La5
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 == r5) goto L8c
            r10 = 301(0x12d, float:4.22E-43)
            if (r4 == r10) goto L59
            r10 = 302(0x12e, float:4.23E-43)
            if (r4 == r10) goto L59
            java.io.InputStream r10 = r3.getErrorStream()     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La5
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e java.io.IOException -> La1
            r4.<init>()     // Catch: java.lang.Throwable -> L9e java.io.IOException -> La1
            if (r10 == 0) goto L49
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L9e java.io.IOException -> La1
            r5.<init>(r10)     // Catch: java.lang.Throwable -> L9e java.io.IOException -> La1
            r6 = 128(0x80, float:1.8E-43)
            char[] r7 = new char[r6]     // Catch: java.lang.Throwable -> L9e java.io.IOException -> La1
        L3b:
            int r8 = r5.read(r7, r1, r6)     // Catch: java.lang.Throwable -> L9e java.io.IOException -> La1
            if (r8 <= 0) goto L45
            r4.append(r7, r1, r8)     // Catch: java.lang.Throwable -> L9e java.io.IOException -> La1
            goto L3b
        L45:
            com.facebook.internal.Utility.closeQuietly(r5)     // Catch: java.lang.Throwable -> L9e java.io.IOException -> La1
            goto L4e
        L49:
            java.lang.String r5 = "Unexpected error while downloading an image."
            r4.append(r5)     // Catch: java.lang.Throwable -> L9e java.io.IOException -> La1
        L4e:
            com.facebook.FacebookException r5 = new com.facebook.FacebookException     // Catch: java.lang.Throwable -> L9e java.io.IOException -> La1
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L9e java.io.IOException -> La1
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L9e java.io.IOException -> La1
            r4 = r0
            goto L95
        L59:
            java.lang.String r10 = "location"
            java.lang.String r10 = r3.getHeaderField(r10)     // Catch: java.io.IOException -> L88 java.lang.Throwable -> La3
            boolean r2 = com.facebook.internal.Utility.isNullOrEmpty(r10)     // Catch: java.io.IOException -> L88 java.lang.Throwable -> La3
            if (r2 != 0) goto L84
            android.net.Uri r10 = android.net.Uri.parse(r10)     // Catch: java.io.IOException -> L88 java.lang.Throwable -> La3
            android.net.Uri r2 = r9.uri     // Catch: java.io.IOException -> L88 java.lang.Throwable -> La3
            com.facebook.internal.UrlRedirectCache.cacheUriRedirect(r2, r10)     // Catch: java.io.IOException -> L88 java.lang.Throwable -> La3
            com.facebook.internal.ImageDownloader$DownloaderContext r2 = removePendingRequest(r9)     // Catch: java.io.IOException -> L88 java.lang.Throwable -> La3
            if (r2 == 0) goto L84
            boolean r4 = r2.isCancelled     // Catch: java.io.IOException -> L88 java.lang.Throwable -> La3
            if (r4 != 0) goto L84
            com.facebook.internal.ImageRequest r2 = r2.request     // Catch: java.io.IOException -> L88 java.lang.Throwable -> La3
            com.facebook.internal.ImageDownloader$RequestKey r4 = new com.facebook.internal.ImageDownloader$RequestKey     // Catch: java.io.IOException -> L88 java.lang.Throwable -> La3
            java.lang.Object r5 = r9.tag     // Catch: java.io.IOException -> L88 java.lang.Throwable -> La3
            r4.<init>(r10, r5)     // Catch: java.io.IOException -> L88 java.lang.Throwable -> La3
            enqueueCacheRead(r2, r4, r1)     // Catch: java.io.IOException -> L88 java.lang.Throwable -> La3
        L84:
            r4 = r0
            r5 = r4
            r2 = 0
            goto L96
        L88:
            r4 = move-exception
            r10 = r0
            r2 = 0
            goto Lb4
        L8c:
            java.io.InputStream r10 = com.facebook.internal.ImageResponseCache.interceptAndCacheImageStream(r10, r3)     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La5
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeStream(r10)     // Catch: java.lang.Throwable -> L9e java.io.IOException -> La1
            r5 = r0
        L95:
            r0 = r10
        L96:
            com.facebook.internal.Utility.closeQuietly(r0)
            com.facebook.internal.Utility.disconnectQuietly(r3)
            r0 = r4
            goto Lbb
        L9e:
            r9 = move-exception
            r0 = r10
            goto Laa
        La1:
            r4 = move-exception
            goto Lb4
        La3:
            r9 = move-exception
            goto Laa
        La5:
            r4 = move-exception
            r10 = r0
            goto Lb4
        La8:
            r9 = move-exception
            r3 = r0
        Laa:
            com.facebook.internal.Utility.closeQuietly(r0)
            com.facebook.internal.Utility.disconnectQuietly(r3)
            throw r9
        Lb1:
            r4 = move-exception
            r10 = r0
            r3 = r10
        Lb4:
            com.facebook.internal.Utility.closeQuietly(r10)
            com.facebook.internal.Utility.disconnectQuietly(r3)
            r5 = r4
        Lbb:
            if (r2 == 0) goto Lc0
            issueResponse(r9, r5, r0, r1)
        Lc0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.ImageDownloader.download(com.facebook.internal.ImageDownloader$RequestKey, android.content.Context):void");
    }

    private static synchronized Handler getHandler() {
        Handler handler2;
        synchronized (ImageDownloader.class) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler2 = handler;
        }
        return handler2;
    }

    private static DownloaderContext removePendingRequest(RequestKey requestKey) {
        DownloaderContext remove;
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            remove = map.remove(requestKey);
        }
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class RequestKey {
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;
        Object tag;
        Uri uri;

        RequestKey(Uri uri, Object obj) {
            this.uri = uri;
            this.tag = obj;
        }

        public int hashCode() {
            return ((1073 + this.uri.hashCode()) * 37) + this.tag.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof RequestKey)) {
                return false;
            }
            RequestKey requestKey = (RequestKey) obj;
            return requestKey.uri == this.uri && requestKey.tag == this.tag;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class DownloaderContext {
        boolean isCancelled;
        ImageRequest request;
        WorkQueue.WorkItem workItem;

        private DownloaderContext() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class CacheReadWorkItem implements Runnable {
        private boolean allowCachedRedirects;
        private Context context;
        private RequestKey key;

        CacheReadWorkItem(Context context, RequestKey requestKey, boolean z) {
            this.context = context;
            this.key = requestKey;
            this.allowCachedRedirects = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                ImageDownloader.readFromCache(this.key, this.context, this.allowCachedRedirects);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class DownloadImageWorkItem implements Runnable {
        private Context context;
        private RequestKey key;

        DownloadImageWorkItem(Context context, RequestKey requestKey) {
            this.context = context;
            this.key = requestKey;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                ImageDownloader.download(this.key, this.context);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
