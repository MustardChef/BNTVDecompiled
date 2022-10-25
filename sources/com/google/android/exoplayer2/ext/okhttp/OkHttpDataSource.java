package com.google.android.exoplayer2.ext.okhttp;

import android.net.Uri;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.upstream.BaseDataSource;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.HttpUtil;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Predicate;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes2.dex */
public class OkHttpDataSource extends BaseDataSource implements HttpDataSource {
    private long bytesRead;
    private long bytesToRead;
    private final CacheControl cacheControl;
    private final Call.Factory callFactory;
    private Predicate<String> contentTypePredicate;
    private DataSpec dataSpec;
    private final HttpDataSource.RequestProperties defaultRequestProperties;
    private boolean opened;
    private final HttpDataSource.RequestProperties requestProperties;
    private Response response;
    private InputStream responseByteStream;
    private final String userAgent;

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.okhttp");
    }

    /* loaded from: classes2.dex */
    public static final class Factory implements HttpDataSource.Factory {
        private CacheControl cacheControl;
        private final Call.Factory callFactory;
        private Predicate<String> contentTypePredicate;
        private final HttpDataSource.RequestProperties defaultRequestProperties = new HttpDataSource.RequestProperties();
        private TransferListener transferListener;
        private String userAgent;

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.Factory
        public /* bridge */ /* synthetic */ HttpDataSource.Factory setDefaultRequestProperties(Map map) {
            return setDefaultRequestProperties((Map<String, String>) map);
        }

        public Factory(Call.Factory factory) {
            this.callFactory = factory;
        }

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.Factory
        public final Factory setDefaultRequestProperties(Map<String, String> map) {
            this.defaultRequestProperties.clearAndSet(map);
            return this;
        }

        public Factory setUserAgent(String str) {
            this.userAgent = str;
            return this;
        }

        public Factory setCacheControl(CacheControl cacheControl) {
            this.cacheControl = cacheControl;
            return this;
        }

        public Factory setContentTypePredicate(Predicate<String> predicate) {
            this.contentTypePredicate = predicate;
            return this;
        }

        public Factory setTransferListener(TransferListener transferListener) {
            this.transferListener = transferListener;
            return this;
        }

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.Factory, com.google.android.exoplayer2.upstream.DataSource.Factory
        public OkHttpDataSource createDataSource() {
            OkHttpDataSource okHttpDataSource = new OkHttpDataSource(this.callFactory, this.userAgent, this.cacheControl, this.defaultRequestProperties, this.contentTypePredicate);
            TransferListener transferListener = this.transferListener;
            if (transferListener != null) {
                okHttpDataSource.addTransferListener(transferListener);
            }
            return okHttpDataSource;
        }
    }

    @Deprecated
    public OkHttpDataSource(Call.Factory factory) {
        this(factory, null);
    }

    @Deprecated
    public OkHttpDataSource(Call.Factory factory, String str) {
        this(factory, str, null, null);
    }

    @Deprecated
    public OkHttpDataSource(Call.Factory factory, String str, CacheControl cacheControl, HttpDataSource.RequestProperties requestProperties) {
        this(factory, str, cacheControl, requestProperties, null);
    }

    private OkHttpDataSource(Call.Factory factory, String str, CacheControl cacheControl, HttpDataSource.RequestProperties requestProperties, Predicate<String> predicate) {
        super(true);
        this.callFactory = (Call.Factory) Assertions.checkNotNull(factory);
        this.userAgent = str;
        this.cacheControl = cacheControl;
        this.defaultRequestProperties = requestProperties;
        this.contentTypePredicate = predicate;
        this.requestProperties = new HttpDataSource.RequestProperties();
    }

    @Deprecated
    public void setContentTypePredicate(Predicate<String> predicate) {
        this.contentTypePredicate = predicate;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        Response response = this.response;
        if (response == null) {
            return null;
        }
        return Uri.parse(response.request().url().toString());
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public int getResponseCode() {
        Response response = this.response;
        if (response == null) {
            return -1;
        }
        return response.code();
    }

    @Override // com.google.android.exoplayer2.upstream.BaseDataSource, com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public Map<String, List<String>> getResponseHeaders() {
        Response response = this.response;
        return response == null ? Collections.emptyMap() : response.headers().toMultimap();
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void setRequestProperty(String str, String str2) {
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(str2);
        this.requestProperties.set(str, str2);
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void clearRequestProperty(String str) {
        Assertions.checkNotNull(str);
        this.requestProperties.remove(str);
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void clearAllRequestProperties() {
        this.requestProperties.clear();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public long open(DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        byte[] bArr;
        this.dataSpec = dataSpec;
        long j = 0;
        this.bytesRead = 0L;
        this.bytesToRead = 0L;
        transferInitializing(dataSpec);
        try {
            Response execute = this.callFactory.newCall(makeRequest(dataSpec)).execute();
            this.response = execute;
            ResponseBody responseBody = (ResponseBody) Assertions.checkNotNull(execute.body());
            this.responseByteStream = responseBody.byteStream();
            int code = execute.code();
            if (!execute.isSuccessful()) {
                if (code == 416) {
                    if (dataSpec.position == HttpUtil.getDocumentSize(execute.headers().get(HttpHeaders.CONTENT_RANGE))) {
                        this.opened = true;
                        transferStarted(dataSpec);
                        if (dataSpec.length != -1) {
                            return dataSpec.length;
                        }
                        return 0L;
                    }
                }
                try {
                    bArr = Util.toByteArray((InputStream) Assertions.checkNotNull(this.responseByteStream));
                } catch (IOException unused) {
                    bArr = Util.EMPTY_BYTE_ARRAY;
                }
                byte[] bArr2 = bArr;
                Map<String, List<String>> multimap = execute.headers().toMultimap();
                closeConnectionQuietly();
                throw new HttpDataSource.InvalidResponseCodeException(code, execute.message(), code == 416 ? new DataSourceException(2008) : null, multimap, dataSpec, bArr2);
            }
            MediaType contentType = responseBody.contentType();
            String mediaType = contentType != null ? contentType.toString() : "";
            Predicate<String> predicate = this.contentTypePredicate;
            if (predicate != null && !predicate.apply(mediaType)) {
                closeConnectionQuietly();
                throw new HttpDataSource.InvalidContentTypeException(mediaType, dataSpec);
            }
            if (code == 200 && dataSpec.position != 0) {
                j = dataSpec.position;
            }
            if (dataSpec.length != -1) {
                this.bytesToRead = dataSpec.length;
            } else {
                long contentLength = responseBody.contentLength();
                this.bytesToRead = contentLength != -1 ? contentLength - j : -1L;
            }
            this.opened = true;
            transferStarted(dataSpec);
            try {
                skipFully(j, dataSpec);
                return this.bytesToRead;
            } catch (HttpDataSource.HttpDataSourceException e) {
                closeConnectionQuietly();
                throw e;
            }
        } catch (IOException e2) {
            throw HttpDataSource.HttpDataSourceException.createForIOException(e2, dataSpec, 1);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader, com.google.android.exoplayer2.upstream.HttpDataSource
    public int read(byte[] bArr, int i, int i2) throws HttpDataSource.HttpDataSourceException {
        try {
            return readInternal(bArr, i, i2);
        } catch (IOException e) {
            throw HttpDataSource.HttpDataSourceException.createForIOException(e, (DataSpec) Util.castNonNull(this.dataSpec), 2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public void close() {
        if (this.opened) {
            this.opened = false;
            transferEnded();
            closeConnectionQuietly();
        }
    }

    private Request makeRequest(DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        long j = dataSpec.position;
        long j2 = dataSpec.length;
        HttpUrl parse = HttpUrl.parse(dataSpec.uri.toString());
        if (parse == null) {
            throw new HttpDataSource.HttpDataSourceException("Malformed URL", dataSpec, 1004, 1);
        }
        Request.Builder url = new Request.Builder().url(parse);
        CacheControl cacheControl = this.cacheControl;
        if (cacheControl != null) {
            url.cacheControl(cacheControl);
        }
        HashMap hashMap = new HashMap();
        HttpDataSource.RequestProperties requestProperties = this.defaultRequestProperties;
        if (requestProperties != null) {
            hashMap.putAll(requestProperties.getSnapshot());
        }
        hashMap.putAll(this.requestProperties.getSnapshot());
        hashMap.putAll(dataSpec.httpRequestHeaders);
        for (Map.Entry entry : hashMap.entrySet()) {
            url.header((String) entry.getKey(), (String) entry.getValue());
        }
        String buildRangeRequestHeader = HttpUtil.buildRangeRequestHeader(j, j2);
        if (buildRangeRequestHeader != null) {
            url.addHeader("Range", buildRangeRequestHeader);
        }
        String str = this.userAgent;
        if (str != null) {
            url.addHeader("User-Agent", str);
        }
        if (!dataSpec.isFlagSet(1)) {
            url.addHeader(HttpHeaders.ACCEPT_ENCODING, "identity");
        }
        RequestBody requestBody = null;
        if (dataSpec.httpBody != null) {
            requestBody = RequestBody.create((MediaType) null, dataSpec.httpBody);
        } else if (dataSpec.httpMethod == 2) {
            requestBody = RequestBody.create((MediaType) null, Util.EMPTY_BYTE_ARRAY);
        }
        url.method(dataSpec.getHttpMethodString(), requestBody);
        return url.build();
    }

    private void skipFully(long j, DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        if (j == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j > 0) {
            try {
                int read = ((InputStream) Util.castNonNull(this.responseByteStream)).read(bArr, 0, (int) Math.min(j, 4096));
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedIOException();
                }
                if (read == -1) {
                    throw new HttpDataSource.HttpDataSourceException(dataSpec, 2008, 1);
                }
                j -= read;
                bytesTransferred(read);
            } catch (IOException e) {
                if (e instanceof HttpDataSource.HttpDataSourceException) {
                    throw ((HttpDataSource.HttpDataSourceException) e);
                }
                throw new HttpDataSource.HttpDataSourceException(dataSpec, 2000, 1);
            }
        }
    }

    private int readInternal(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.bytesToRead;
        if (j != -1) {
            long j2 = j - this.bytesRead;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) Math.min(i2, j2);
        }
        int read = ((InputStream) Util.castNonNull(this.responseByteStream)).read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        this.bytesRead += read;
        bytesTransferred(read);
        return read;
    }

    private void closeConnectionQuietly() {
        Response response = this.response;
        if (response != null) {
            ((ResponseBody) Assertions.checkNotNull(response.body())).close();
            this.response = null;
        }
        this.responseByteStream = null;
    }
}
