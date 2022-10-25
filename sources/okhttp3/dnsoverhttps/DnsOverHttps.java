package okhttp3.dnsoverhttps;

import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p043io.Closeable;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.ByteString;

/* compiled from: DnsOverHttps.kt */
@Metadata(m108d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 +2\u00020\u0001:\u0002*+B7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002JF\u0010\u000f\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00172\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u001cj\u0002`\u001d0\u00172\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J>\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0\u00172\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u001cj\u0002`\u001d0\u0017H\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u0010H\u0002J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J8\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00172\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u001cj\u0002`\u001d0\u0017H\u0002J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\"H\u0002J(\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001f2\u0006\u0010\u0011\u001a\u00020\u00122\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u001cj\u0002`\u001d0\u001fH\u0002R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0013\u0010\b\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\rR\u0013\u0010\t\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\rR\u0013\u0010\n\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\rR\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000e¨\u0006,"}, m107d2 = {"Lokhttp3/dnsoverhttps/DnsOverHttps;", "Lokhttp3/Dns;", "client", "Lokhttp3/OkHttpClient;", "url", "Lokhttp3/HttpUrl;", "includeIPv6", "", "post", "resolvePrivateAddresses", "resolvePublicAddresses", "(Lokhttp3/OkHttpClient;Lokhttp3/HttpUrl;ZZZZ)V", "()Lokhttp3/OkHttpClient;", "()Z", "()Lokhttp3/HttpUrl;", "buildRequest", "Lokhttp3/Request;", "hostname", "", "type", "", "", "networkRequests", "", "Lokhttp3/Call;", "results", "Ljava/net/InetAddress;", "failures", "Ljava/lang/Exception;", "Lkotlin/Exception;", "executeRequests", "", "responses", "getCacheOnlyResponse", "Lokhttp3/Response;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "lookup", "lookupHttps", "processResponse", "response", "readResponse", "throwBestFailure", "Builder", "Companion", "okhttp-dnsoverhttps"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class DnsOverHttps implements Dns {
    public static final Companion Companion = new Companion(null);
    private static final MediaType DNS_MESSAGE = MediaType.Companion.get("application/dns-message");
    public static final int MAX_RESPONSE_SIZE = 65536;
    private final OkHttpClient client;
    private final boolean includeIPv6;
    private final boolean post;
    private final boolean resolvePrivateAddresses;
    private final boolean resolvePublicAddresses;
    private final HttpUrl url;

    public DnsOverHttps(OkHttpClient client, HttpUrl url, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(url, "url");
        this.client = client;
        this.url = url;
        this.includeIPv6 = z;
        this.post = z2;
        this.resolvePrivateAddresses = z3;
        this.resolvePublicAddresses = z4;
    }

    public final OkHttpClient client() {
        return this.client;
    }

    public final HttpUrl url() {
        return this.url;
    }

    public final boolean includeIPv6() {
        return this.includeIPv6;
    }

    public final boolean post() {
        return this.post;
    }

    public final boolean resolvePrivateAddresses() {
        return this.resolvePrivateAddresses;
    }

    public final boolean resolvePublicAddresses() {
        return this.resolvePublicAddresses;
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String hostname) throws UnknownHostException {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        if (!this.resolvePrivateAddresses || !this.resolvePublicAddresses) {
            boolean isPrivateHost$okhttp_dnsoverhttps = Companion.isPrivateHost$okhttp_dnsoverhttps(hostname);
            if (isPrivateHost$okhttp_dnsoverhttps && !this.resolvePrivateAddresses) {
                throw new UnknownHostException("private hosts not resolved");
            }
            if (!isPrivateHost$okhttp_dnsoverhttps && !this.resolvePublicAddresses) {
                throw new UnknownHostException("public hosts not resolved");
            }
        }
        return lookupHttps(hostname);
    }

    private final List<InetAddress> lookupHttps(String str) throws UnknownHostException {
        List<? extends Call> arrayList = new ArrayList<>(2);
        List<Exception> arrayList2 = new ArrayList<>(2);
        List<InetAddress> arrayList3 = new ArrayList<>(5);
        List<? extends Call> list = arrayList;
        List<InetAddress> list2 = arrayList3;
        List<Exception> list3 = arrayList2;
        buildRequest(str, list, list2, list3, 1);
        if (this.includeIPv6) {
            buildRequest(str, list, list2, list3, 28);
        }
        executeRequests(str, list, list2, list3);
        List<InetAddress> list4 = arrayList3;
        if (list4.isEmpty()) {
            list4 = throwBestFailure(str, list3);
        }
        return list4;
    }

    private final void buildRequest(String str, List<Call> list, List<InetAddress> list2, List<Exception> list3, int i) {
        Unit unit;
        Request buildRequest = buildRequest(str, i);
        Response cacheOnlyResponse = getCacheOnlyResponse(buildRequest);
        if (cacheOnlyResponse == null) {
            unit = null;
        } else {
            processResponse(cacheOnlyResponse, str, list2, list3);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            Boolean.valueOf(list.add(this.client.newCall(buildRequest)));
        }
    }

    private final void executeRequests(final String str, List<? extends Call> list, final List<InetAddress> list2, final List<Exception> list3) {
        final CountDownLatch countDownLatch = new CountDownLatch(list.size());
        for (Call call : list) {
            call.enqueue(new Callback() { // from class: okhttp3.dnsoverhttps.DnsOverHttps$executeRequests$1
                @Override // okhttp3.Callback
                public void onFailure(Call call2, IOException e) {
                    Intrinsics.checkNotNullParameter(call2, "call");
                    Intrinsics.checkNotNullParameter(e, "e");
                    List<Exception> list4 = list3;
                    synchronized (list4) {
                        list4.add(e);
                    }
                    countDownLatch.countDown();
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call2, Response response) {
                    Intrinsics.checkNotNullParameter(call2, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    this.processResponse(response, str, list2, list3);
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            list3.add(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processResponse(Response response, String str, List<InetAddress> list, List<Exception> list2) {
        try {
            List<InetAddress> readResponse = readResponse(str, response);
            synchronized (list) {
                list.addAll(readResponse);
            }
        } catch (Exception e) {
            synchronized (list2) {
                list2.add(e);
            }
        }
    }

    private final List<InetAddress> throwBestFailure(String str, List<? extends Exception> list) throws UnknownHostException {
        if (list.isEmpty()) {
            throw new UnknownHostException(str);
        }
        Exception exc = list.get(0);
        if (exc instanceof UnknownHostException) {
            throw exc;
        }
        UnknownHostException unknownHostException = new UnknownHostException(str);
        unknownHostException.initCause(exc);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            ExceptionsKt.addSuppressed(unknownHostException, list.get(i));
        }
        throw unknownHostException;
    }

    private final Response getCacheOnlyResponse(Request request) {
        if (this.post || this.client.cache() == null) {
            return null;
        }
        try {
            Response execute = this.client.newCall(request.newBuilder().cacheControl(new CacheControl.Builder().onlyIfCached().build()).build()).execute();
            if (execute.code() != 504) {
                return execute;
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    private final List<InetAddress> readResponse(String str, Response response) throws Exception {
        if (response.cacheResponse() == null && response.protocol() != Protocol.HTTP_2) {
            Platform.log$default(Platform.Companion.get(), Intrinsics.stringPlus("Incorrect protocol: ", response.protocol()), 5, null, 4, null);
        }
        Response response2 = response;
        try {
            Response response3 = response2;
            if (!response.isSuccessful()) {
                throw new IOException("response: " + response.code() + ' ' + response.message());
            }
            ResponseBody body = response.body();
            Intrinsics.checkNotNull(body);
            if (body.contentLength() > 65536) {
                throw new IOException("response size exceeds limit (65536 bytes): " + body.contentLength() + " bytes");
            }
            List<InetAddress> decodeAnswers = DnsRecordCodec.INSTANCE.decodeAnswers(str, body.source().readByteString());
            Closeable.closeFinally(response2, null);
            return decodeAnswers;
        } finally {
        }
    }

    private final Request buildRequest(String str, int i) {
        Request.Builder builder = new Request.Builder();
        MediaType mediaType = DNS_MESSAGE;
        Request.Builder header = builder.header("Accept", mediaType.toString());
        ByteString encodeQuery = DnsRecordCodec.INSTANCE.encodeQuery(str, i);
        if (post()) {
            header.url(url()).post(RequestBody.Companion.create(encodeQuery, mediaType));
        } else {
            header.url(url().newBuilder().addQueryParameter("dns", StringsKt.replace$default(encodeQuery.base64Url(), "=", "", false, 4, (Object) null)).build());
        }
        return header.build();
    }

    /* compiled from: DnsOverHttps.kt */
    @Metadata(m108d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00002\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050+\"\u00020\u0005¢\u0006\u0002\u0010,J\u0016\u0010\u0003\u001a\u00020\u00002\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u0006\u0010-\u001a\u00020.J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0011J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0011J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0011J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001a\u0010\u001f\u001a\u00020 X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006/"}, m107d2 = {"Lokhttp3/dnsoverhttps/DnsOverHttps$Builder;", "", "()V", "bootstrapDnsHosts", "", "Ljava/net/InetAddress;", "getBootstrapDnsHosts$okhttp_dnsoverhttps", "()Ljava/util/List;", "setBootstrapDnsHosts$okhttp_dnsoverhttps", "(Ljava/util/List;)V", "client", "Lokhttp3/OkHttpClient;", "getClient$okhttp_dnsoverhttps", "()Lokhttp3/OkHttpClient;", "setClient$okhttp_dnsoverhttps", "(Lokhttp3/OkHttpClient;)V", "includeIPv6", "", "getIncludeIPv6$okhttp_dnsoverhttps", "()Z", "setIncludeIPv6$okhttp_dnsoverhttps", "(Z)V", "post", "getPost$okhttp_dnsoverhttps", "setPost$okhttp_dnsoverhttps", "resolvePrivateAddresses", "getResolvePrivateAddresses$okhttp_dnsoverhttps", "setResolvePrivateAddresses$okhttp_dnsoverhttps", "resolvePublicAddresses", "getResolvePublicAddresses$okhttp_dnsoverhttps", "setResolvePublicAddresses$okhttp_dnsoverhttps", "systemDns", "Lokhttp3/Dns;", "getSystemDns$okhttp_dnsoverhttps", "()Lokhttp3/Dns;", "setSystemDns$okhttp_dnsoverhttps", "(Lokhttp3/Dns;)V", "url", "Lokhttp3/HttpUrl;", "getUrl$okhttp_dnsoverhttps", "()Lokhttp3/HttpUrl;", "setUrl$okhttp_dnsoverhttps", "(Lokhttp3/HttpUrl;)V", "", "([Ljava/net/InetAddress;)Lokhttp3/dnsoverhttps/DnsOverHttps$Builder;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lokhttp3/dnsoverhttps/DnsOverHttps;", "okhttp-dnsoverhttps"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Builder {
        private List<? extends InetAddress> bootstrapDnsHosts;
        private OkHttpClient client;
        private boolean post;
        private boolean resolvePrivateAddresses;
        private HttpUrl url;
        private boolean includeIPv6 = true;
        private Dns systemDns = Dns.SYSTEM;
        private boolean resolvePublicAddresses = true;

        public final OkHttpClient getClient$okhttp_dnsoverhttps() {
            return this.client;
        }

        public final void setClient$okhttp_dnsoverhttps(OkHttpClient okHttpClient) {
            this.client = okHttpClient;
        }

        public final HttpUrl getUrl$okhttp_dnsoverhttps() {
            return this.url;
        }

        public final void setUrl$okhttp_dnsoverhttps(HttpUrl httpUrl) {
            this.url = httpUrl;
        }

        public final boolean getIncludeIPv6$okhttp_dnsoverhttps() {
            return this.includeIPv6;
        }

        public final void setIncludeIPv6$okhttp_dnsoverhttps(boolean z) {
            this.includeIPv6 = z;
        }

        public final boolean getPost$okhttp_dnsoverhttps() {
            return this.post;
        }

        public final void setPost$okhttp_dnsoverhttps(boolean z) {
            this.post = z;
        }

        public final Dns getSystemDns$okhttp_dnsoverhttps() {
            return this.systemDns;
        }

        public final void setSystemDns$okhttp_dnsoverhttps(Dns dns) {
            Intrinsics.checkNotNullParameter(dns, "<set-?>");
            this.systemDns = dns;
        }

        public final List<InetAddress> getBootstrapDnsHosts$okhttp_dnsoverhttps() {
            return this.bootstrapDnsHosts;
        }

        public final void setBootstrapDnsHosts$okhttp_dnsoverhttps(List<? extends InetAddress> list) {
            this.bootstrapDnsHosts = list;
        }

        public final boolean getResolvePrivateAddresses$okhttp_dnsoverhttps() {
            return this.resolvePrivateAddresses;
        }

        public final void setResolvePrivateAddresses$okhttp_dnsoverhttps(boolean z) {
            this.resolvePrivateAddresses = z;
        }

        public final boolean getResolvePublicAddresses$okhttp_dnsoverhttps() {
            return this.resolvePublicAddresses;
        }

        public final void setResolvePublicAddresses$okhttp_dnsoverhttps(boolean z) {
            this.resolvePublicAddresses = z;
        }

        public final DnsOverHttps build() {
            OkHttpClient okHttpClient = this.client;
            Objects.requireNonNull(okHttpClient, "client not set");
            OkHttpClient build = okHttpClient.newBuilder().dns(DnsOverHttps.Companion.buildBootstrapClient(this)).build();
            HttpUrl httpUrl = this.url;
            if (httpUrl != null) {
                return new DnsOverHttps(build, httpUrl, this.includeIPv6, this.post, this.resolvePrivateAddresses, this.resolvePublicAddresses);
            }
            throw new IllegalStateException("url not set".toString());
        }

        public final Builder client(OkHttpClient client) {
            Intrinsics.checkNotNullParameter(client, "client");
            Builder builder = this;
            builder.setClient$okhttp_dnsoverhttps(client);
            return builder;
        }

        public final Builder url(HttpUrl url) {
            Intrinsics.checkNotNullParameter(url, "url");
            Builder builder = this;
            builder.setUrl$okhttp_dnsoverhttps(url);
            return builder;
        }

        public final Builder includeIPv6(boolean z) {
            Builder builder = this;
            builder.setIncludeIPv6$okhttp_dnsoverhttps(z);
            return builder;
        }

        public final Builder post(boolean z) {
            Builder builder = this;
            builder.setPost$okhttp_dnsoverhttps(z);
            return builder;
        }

        public final Builder resolvePrivateAddresses(boolean z) {
            Builder builder = this;
            builder.setResolvePrivateAddresses$okhttp_dnsoverhttps(z);
            return builder;
        }

        public final Builder resolvePublicAddresses(boolean z) {
            Builder builder = this;
            builder.setResolvePublicAddresses$okhttp_dnsoverhttps(z);
            return builder;
        }

        public final Builder bootstrapDnsHosts(List<? extends InetAddress> list) {
            Builder builder = this;
            builder.setBootstrapDnsHosts$okhttp_dnsoverhttps(list);
            return builder;
        }

        public final Builder bootstrapDnsHosts(InetAddress... bootstrapDnsHosts) {
            Intrinsics.checkNotNullParameter(bootstrapDnsHosts, "bootstrapDnsHosts");
            return bootstrapDnsHosts(ArraysKt.toList(bootstrapDnsHosts));
        }

        public final Builder systemDns(Dns systemDns) {
            Intrinsics.checkNotNullParameter(systemDns, "systemDns");
            Builder builder = this;
            builder.setSystemDns$okhttp_dnsoverhttps(systemDns);
            return builder;
        }
    }

    /* compiled from: DnsOverHttps.kt */
    @Metadata(m108d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0011R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m107d2 = {"Lokhttp3/dnsoverhttps/DnsOverHttps$Companion;", "", "()V", "DNS_MESSAGE", "Lokhttp3/MediaType;", "getDNS_MESSAGE", "()Lokhttp3/MediaType;", "MAX_RESPONSE_SIZE", "", "buildBootstrapClient", "Lokhttp3/Dns;", "builder", "Lokhttp3/dnsoverhttps/DnsOverHttps$Builder;", "isPrivateHost", "", "host", "", "isPrivateHost$okhttp_dnsoverhttps", "okhttp-dnsoverhttps"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MediaType getDNS_MESSAGE() {
            return DnsOverHttps.DNS_MESSAGE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Dns buildBootstrapClient(Builder builder) {
            List<InetAddress> bootstrapDnsHosts$okhttp_dnsoverhttps = builder.getBootstrapDnsHosts$okhttp_dnsoverhttps();
            if (bootstrapDnsHosts$okhttp_dnsoverhttps != null) {
                HttpUrl url$okhttp_dnsoverhttps = builder.getUrl$okhttp_dnsoverhttps();
                Intrinsics.checkNotNull(url$okhttp_dnsoverhttps);
                return new BootstrapDns(url$okhttp_dnsoverhttps.host(), bootstrapDnsHosts$okhttp_dnsoverhttps);
            }
            return builder.getSystemDns$okhttp_dnsoverhttps();
        }

        public final boolean isPrivateHost$okhttp_dnsoverhttps(String host) {
            Intrinsics.checkNotNullParameter(host, "host");
            return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(host) == null;
        }
    }
}
