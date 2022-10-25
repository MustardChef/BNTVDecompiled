package com.uwetrottmann.tmdb2;

import androidx.browser.trusted.sharing.ShareTarget;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.List;
import javax.annotation.Nonnull;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes4.dex */
public class TmdbInterceptor implements Interceptor {
    private final Tmdb tmdb;

    public TmdbInterceptor(Tmdb tmdb) {
        this.tmdb = tmdb;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(@Nonnull Interceptor.Chain chain) throws IOException {
        return handleIntercept(chain, this.tmdb);
    }

    public static Response handleIntercept(Interceptor.Chain chain, Tmdb tmdb) throws IOException {
        String header;
        Request request = chain.request();
        if (!Tmdb.API_HOST.equals(request.url().host())) {
            return chain.proceed(request);
        }
        HttpUrl.Builder newBuilder = request.url().newBuilder();
        newBuilder.setEncodedQueryParameter(Tmdb.PARAM_API_KEY, tmdb.apiKey());
        if (tmdb.isLoggedIn()) {
            List<String> pathSegments = request.url().pathSegments();
            if ((pathSegments.size() >= 2 && pathSegments.get(1).equals("account")) || pathSegments.get(pathSegments.size() - 1).equals("account_states") || pathSegments.get(pathSegments.size() - 1).equals("rating") || !request.method().equals(ShareTarget.METHOD_GET)) {
                addSessionToken(tmdb, newBuilder);
            }
        }
        Request.Builder newBuilder2 = request.newBuilder();
        newBuilder2.url(newBuilder.build());
        Response proceed = chain.proceed(newBuilder2.build());
        if (!proceed.isSuccessful() && (header = proceed.header(HttpHeaders.RETRY_AFTER)) != null) {
            try {
                Thread.sleep((int) ((Integer.parseInt(header) + 0.5d) * 1000.0d));
                if (proceed.body() != null) {
                    proceed.body().close();
                }
                return handleIntercept(chain, tmdb);
            } catch (InterruptedException | NumberFormatException unused) {
            }
        }
        return proceed;
    }

    private static void addSessionToken(Tmdb tmdb, HttpUrl.Builder builder) {
        if (tmdb.getSessionId() != null) {
            builder.addEncodedQueryParameter("session_id", tmdb.getSessionId());
        } else if (tmdb.getGuestSessionId() != null) {
            builder.addEncodedQueryParameter(Tmdb.PARAM_GUEST_SESSION_ID, tmdb.getGuestSessionId());
        }
    }
}
