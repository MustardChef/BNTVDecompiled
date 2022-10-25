package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.backend.cct.BuildConfig;
import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.LogEvent;
import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.android.datatransport.cct.internal.LogResponse;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.retries.Function;
import com.google.android.datatransport.runtime.retries.Retries;
import com.google.android.datatransport.runtime.retries.RetryStrategy;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
public final class CctTransportBackend implements TransportBackend {
    private static final String ACCEPT_ENCODING_HEADER_KEY = "Accept-Encoding";
    static final String API_KEY_HEADER_KEY = "X-Goog-Api-Key";
    private static final int CONNECTION_TIME_OUT = 30000;
    private static final String CONTENT_ENCODING_HEADER_KEY = "Content-Encoding";
    private static final String CONTENT_TYPE_HEADER_KEY = "Content-Type";
    private static final String GZIP_CONTENT_ENCODING = "gzip";
    private static final int INVALID_VERSION_CODE = -1;
    private static final String JSON_CONTENT_TYPE = "application/json";
    private static final String KEY_APPLICATION_BUILD = "application_build";
    private static final String KEY_COUNTRY = "country";
    private static final String KEY_DEVICE = "device";
    private static final String KEY_FINGERPRINT = "fingerprint";
    private static final String KEY_HARDWARE = "hardware";
    private static final String KEY_LOCALE = "locale";
    private static final String KEY_MANUFACTURER = "manufacturer";
    private static final String KEY_MCC_MNC = "mcc_mnc";
    static final String KEY_MOBILE_SUBTYPE = "mobile-subtype";
    private static final String KEY_MODEL = "model";
    static final String KEY_NETWORK_TYPE = "net-type";
    private static final String KEY_OS_BUILD = "os-uild";
    private static final String KEY_PRODUCT = "product";
    private static final String KEY_SDK_VERSION = "sdk-version";
    private static final String KEY_TIMEZONE_OFFSET = "tz-offset";
    private static final String LOG_TAG = "CctTransportBackend";
    private static final int READ_TIME_OUT = 40000;
    private final Context applicationContext;
    private final ConnectivityManager connectivityManager;
    private final DataEncoder dataEncoder;
    final URL endPoint;
    private final int readTimeout;
    private final Clock uptimeClock;
    private final Clock wallTimeClock;

    private static URL parseUrlOrThrow(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid url: " + str, e);
        }
    }

    CctTransportBackend(Context context, Clock clock, Clock clock2, int i) {
        this.dataEncoder = BatchedLogRequest.createDataEncoder();
        this.applicationContext = context;
        this.connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.endPoint = parseUrlOrThrow(CCTDestination.DEFAULT_END_POINT);
        this.uptimeClock = clock2;
        this.wallTimeClock = clock;
        this.readTimeout = i;
    }

    public CctTransportBackend(Context context, Clock clock, Clock clock2) {
        this(context, clock, clock2, 40000);
    }

    private static TelephonyManager getTelephonyManager(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    private static int getPackageVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Logging.m417e(LOG_TAG, "Unable to find version code for package", e);
            return -1;
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.TransportBackend
    public EventInternal decorate(EventInternal eventInternal) {
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        return eventInternal.toBuilder().addMetadata(KEY_SDK_VERSION, Build.VERSION.SDK_INT).addMetadata(KEY_MODEL, Build.MODEL).addMetadata(KEY_HARDWARE, Build.HARDWARE).addMetadata(KEY_DEVICE, Build.DEVICE).addMetadata("product", Build.PRODUCT).addMetadata(KEY_OS_BUILD, Build.ID).addMetadata(KEY_MANUFACTURER, Build.MANUFACTURER).addMetadata(KEY_FINGERPRINT, Build.FINGERPRINT).addMetadata(KEY_TIMEZONE_OFFSET, getTzOffset()).addMetadata(KEY_NETWORK_TYPE, getNetTypeValue(activeNetworkInfo)).addMetadata(KEY_MOBILE_SUBTYPE, getNetSubtypeValue(activeNetworkInfo)).addMetadata("country", Locale.getDefault().getCountry()).addMetadata(KEY_LOCALE, Locale.getDefault().getLanguage()).addMetadata(KEY_MCC_MNC, getTelephonyManager(this.applicationContext).getSimOperator()).addMetadata(KEY_APPLICATION_BUILD, Integer.toString(getPackageVersionCode(this.applicationContext))).build();
    }

    private static int getNetTypeValue(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.NetworkType.NONE.getValue();
        }
        return networkInfo.getType();
    }

    private static int getNetSubtypeValue(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.getValue();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return NetworkConnectionInfo.MobileSubtype.COMBINED.getValue();
        }
        if (NetworkConnectionInfo.MobileSubtype.forNumber(subtype) != null) {
            return subtype;
        }
        return 0;
    }

    private BatchedLogRequest getRequestBody(BackendRequest backendRequest) {
        LogEvent.Builder protoBuilder;
        HashMap hashMap = new HashMap();
        for (EventInternal eventInternal : backendRequest.getEvents()) {
            String transportName = eventInternal.getTransportName();
            if (!hashMap.containsKey(transportName)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(eventInternal);
                hashMap.put(transportName, arrayList);
            } else {
                ((List) hashMap.get(transportName)).add(eventInternal);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            EventInternal eventInternal2 = (EventInternal) ((List) entry.getValue()).get(0);
            LogRequest.Builder clientInfo = LogRequest.builder().setQosTier(QosTier.DEFAULT).setRequestTimeMs(this.wallTimeClock.getTime()).setRequestUptimeMs(this.uptimeClock.getTime()).setClientInfo(ClientInfo.builder().setClientType(ClientInfo.ClientType.ANDROID_FIREBASE).setAndroidClientInfo(AndroidClientInfo.builder().setSdkVersion(Integer.valueOf(eventInternal2.getInteger(KEY_SDK_VERSION))).setModel(eventInternal2.get(KEY_MODEL)).setHardware(eventInternal2.get(KEY_HARDWARE)).setDevice(eventInternal2.get(KEY_DEVICE)).setProduct(eventInternal2.get("product")).setOsBuild(eventInternal2.get(KEY_OS_BUILD)).setManufacturer(eventInternal2.get(KEY_MANUFACTURER)).setFingerprint(eventInternal2.get(KEY_FINGERPRINT)).setCountry(eventInternal2.get("country")).setLocale(eventInternal2.get(KEY_LOCALE)).setMccMnc(eventInternal2.get(KEY_MCC_MNC)).setApplicationBuild(eventInternal2.get(KEY_APPLICATION_BUILD)).build()).build());
            try {
                clientInfo.setSource(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                clientInfo.setSource((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (EventInternal eventInternal3 : (List) entry.getValue()) {
                EncodedPayload encodedPayload = eventInternal3.getEncodedPayload();
                Encoding encoding = encodedPayload.getEncoding();
                if (encoding.equals(Encoding.m423of("proto"))) {
                    protoBuilder = LogEvent.protoBuilder(encodedPayload.getBytes());
                } else if (encoding.equals(Encoding.m423of("json"))) {
                    protoBuilder = LogEvent.jsonBuilder(new String(encodedPayload.getBytes(), Charset.forName("UTF-8")));
                } else {
                    Logging.m415w(LOG_TAG, "Received event of unsupported encoding %s. Skipping...", encoding);
                }
                protoBuilder.setEventTimeMs(eventInternal3.getEventMillis()).setEventUptimeMs(eventInternal3.getUptimeMillis()).setTimezoneOffsetSeconds(eventInternal3.getLong(KEY_TIMEZONE_OFFSET)).setNetworkConnectionInfo(NetworkConnectionInfo.builder().setNetworkType(NetworkConnectionInfo.NetworkType.forNumber(eventInternal3.getInteger(KEY_NETWORK_TYPE))).setMobileSubtype(NetworkConnectionInfo.MobileSubtype.forNumber(eventInternal3.getInteger(KEY_MOBILE_SUBTYPE))).build());
                if (eventInternal3.getCode() != null) {
                    protoBuilder.setEventCode(eventInternal3.getCode());
                }
                arrayList3.add(protoBuilder.build());
            }
            clientInfo.setLogEvents(arrayList3);
            arrayList2.add(clientInfo.build());
        }
        return BatchedLogRequest.create(arrayList2);
    }

    public HttpResponse doSend(HttpRequest httpRequest) throws IOException {
        Logging.m420d(LOG_TAG, "Making request to: %s", httpRequest.url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpRequest.url.openConnection();
        httpURLConnection.setConnectTimeout(CONNECTION_TIME_OUT);
        httpURLConnection.setReadTimeout(this.readTimeout);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", BuildConfig.VERSION_NAME));
        httpURLConnection.setRequestProperty("Content-Encoding", GZIP_CONTENT_ENCODING);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", GZIP_CONTENT_ENCODING);
        if (httpRequest.apiKey != null) {
            httpURLConnection.setRequestProperty(API_KEY_HEADER_KEY, httpRequest.apiKey);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                this.dataEncoder.encode(httpRequest.requestBody, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                gZIPOutputStream.close();
                if (outputStream != null) {
                    outputStream.close();
                }
                int responseCode = httpURLConnection.getResponseCode();
                Logging.m416i(LOG_TAG, "Status Code: " + responseCode);
                Logging.m416i(LOG_TAG, "Content-Type: " + httpURLConnection.getHeaderField("Content-Type"));
                Logging.m416i(LOG_TAG, "Content-Encoding: " + httpURLConnection.getHeaderField("Content-Encoding"));
                if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                    return new HttpResponse(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                }
                if (responseCode != 200) {
                    return new HttpResponse(responseCode, null, 0L);
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    InputStream maybeUnGzip = maybeUnGzip(inputStream, httpURLConnection.getHeaderField("Content-Encoding"));
                    HttpResponse httpResponse = new HttpResponse(responseCode, null, LogResponse.fromJson(new BufferedReader(new InputStreamReader(maybeUnGzip))).getNextRequestWaitMillis());
                    if (maybeUnGzip != null) {
                        maybeUnGzip.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return httpResponse;
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th2;
            }
        } catch (EncodingException e) {
            e = e;
            Logging.m417e(LOG_TAG, "Couldn't encode request, returning with 400", e);
            return new HttpResponse(400, null, 0L);
        } catch (ConnectException e2) {
            e = e2;
            Logging.m417e(LOG_TAG, "Couldn't open connection, returning with 500", e);
            return new HttpResponse(500, null, 0L);
        } catch (UnknownHostException e3) {
            e = e3;
            Logging.m417e(LOG_TAG, "Couldn't open connection, returning with 500", e);
            return new HttpResponse(500, null, 0L);
        } catch (IOException e4) {
            e = e4;
            Logging.m417e(LOG_TAG, "Couldn't encode request, returning with 400", e);
            return new HttpResponse(400, null, 0L);
        }
    }

    private static InputStream maybeUnGzip(InputStream inputStream, String str) throws IOException {
        return GZIP_CONTENT_ENCODING.equals(str) ? new GZIPInputStream(inputStream) : inputStream;
    }

    @Override // com.google.android.datatransport.runtime.backends.TransportBackend
    public BackendResponse send(BackendRequest backendRequest) {
        RetryStrategy retryStrategy;
        BatchedLogRequest requestBody = getRequestBody(backendRequest);
        URL url = this.endPoint;
        if (backendRequest.getExtras() != null) {
            try {
                CCTDestination fromByteArray = CCTDestination.fromByteArray(backendRequest.getExtras());
                r3 = fromByteArray.getAPIKey() != null ? fromByteArray.getAPIKey() : null;
                if (fromByteArray.getEndPoint() != null) {
                    url = parseUrlOrThrow(fromByteArray.getEndPoint());
                }
            } catch (IllegalArgumentException unused) {
                return BackendResponse.fatalError();
            }
        }
        try {
            HttpRequest httpRequest = new HttpRequest(url, requestBody, r3);
            Function lambdaFactory$ = CctTransportBackend$$Lambda$1.lambdaFactory$(this);
            retryStrategy = CctTransportBackend$$Lambda$4.instance;
            HttpResponse httpResponse = (HttpResponse) Retries.retry(5, httpRequest, lambdaFactory$, retryStrategy);
            if (httpResponse.code == 200) {
                return BackendResponse.m422ok(httpResponse.nextRequestMillis);
            }
            if (httpResponse.code < 500 && httpResponse.code != 404) {
                return BackendResponse.fatalError();
            }
            return BackendResponse.transientError();
        } catch (IOException e) {
            Logging.m417e(LOG_TAG, "Could not make request to the backend", e);
            return BackendResponse.transientError();
        }
    }

    public static /* synthetic */ HttpRequest lambda$send$0(HttpRequest httpRequest, HttpResponse httpResponse) {
        if (httpResponse.redirectUrl != null) {
            Logging.m420d(LOG_TAG, "Following redirect to: %s", httpResponse.redirectUrl);
            return httpRequest.withUrl(httpResponse.redirectUrl);
        }
        return null;
    }

    static long getTzOffset() {
        Calendar.getInstance();
        return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
    }

    /* loaded from: classes2.dex */
    public static final class HttpResponse {
        final int code;
        final long nextRequestMillis;
        final URL redirectUrl;

        HttpResponse(int i, URL url, long j) {
            this.code = i;
            this.redirectUrl = url;
            this.nextRequestMillis = j;
        }
    }

    /* loaded from: classes2.dex */
    public static final class HttpRequest {
        final String apiKey;
        final BatchedLogRequest requestBody;
        final URL url;

        HttpRequest(URL url, BatchedLogRequest batchedLogRequest, String str) {
            this.url = url;
            this.requestBody = batchedLogRequest;
            this.apiKey = str;
        }

        HttpRequest withUrl(URL url) {
            return new HttpRequest(url, this.requestBody, this.apiKey);
        }
    }
}
