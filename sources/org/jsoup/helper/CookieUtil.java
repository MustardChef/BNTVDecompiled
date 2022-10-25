package org.jsoup.helper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import org.jsoup.Connection;
import org.jsoup.helper.HttpConnection;
import org.jsoup.internal.StringUtil;

/* loaded from: classes.dex */
class CookieUtil {
    private static final String Cookie2Name = "Cookie2";
    private static final String CookieName = "Cookie";
    private static final Map<String, List<String>> EmptyRequestHeaders = Collections.unmodifiableMap(new HashMap());
    private static final String Sep = "; ";

    CookieUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void applyCookiesToRequest(HttpConnection.Request request, HttpURLConnection httpURLConnection) throws IOException {
        HashSet hashSet;
        HashSet hashSet2;
        LinkedHashSet<String> requestCookieSet = requestCookieSet(request);
        HashSet hashSet3 = null;
        for (Map.Entry<String, List<String>> entry : request.cookieManager().get(asUri(request.url), EmptyRequestHeaders).entrySet()) {
            List<String> value = entry.getValue();
            if (value != null && value.size() != 0) {
                String key = entry.getKey();
                if ("Cookie".equals(key)) {
                    hashSet = hashSet3;
                    hashSet2 = requestCookieSet;
                } else if (Cookie2Name.equals(key)) {
                    hashSet2 = new HashSet();
                    hashSet = hashSet2;
                }
                hashSet2.addAll(value);
                hashSet3 = hashSet;
            }
        }
        if (requestCookieSet.size() > 0) {
            httpURLConnection.addRequestProperty("Cookie", StringUtil.join(requestCookieSet, Sep));
        }
        if (hashSet3 == null || hashSet3.size() <= 0) {
            return;
        }
        httpURLConnection.addRequestProperty(Cookie2Name, StringUtil.join(hashSet3, Sep));
    }

    private static LinkedHashSet<String> requestCookieSet(Connection.Request request) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        for (Map.Entry<String, String> entry : request.cookies().entrySet()) {
            linkedHashSet.add(entry.getKey() + "=" + entry.getValue());
        }
        return linkedHashSet;
    }

    static URI asUri(URL url) throws IOException {
        try {
            return url.toURI();
        } catch (URISyntaxException e) {
            MalformedURLException malformedURLException = new MalformedURLException(e.getMessage());
            malformedURLException.initCause(e);
            throw malformedURLException;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void storeCookies(HttpConnection.Request request, URL url, Map<String, List<String>> map) throws IOException {
        request.cookieManager().put(asUri(url), map);
    }
}
