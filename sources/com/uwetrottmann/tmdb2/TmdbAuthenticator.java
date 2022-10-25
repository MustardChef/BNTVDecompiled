package com.uwetrottmann.tmdb2;

import com.uwetrottmann.tmdb2.entities.GuestSession;
import com.uwetrottmann.tmdb2.entities.RequestToken;
import com.uwetrottmann.tmdb2.entities.Session;
import com.uwetrottmann.tmdb2.exceptions.TmdbAuthenticationFailedException;
import com.uwetrottmann.tmdb2.services.AuthenticationService;
import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.Authenticator;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/* loaded from: classes4.dex */
public class TmdbAuthenticator implements Authenticator {
    private final Tmdb tmdb;

    public TmdbAuthenticator(Tmdb tmdb) {
        this.tmdb = tmdb;
    }

    @Override // okhttp3.Authenticator
    public Request authenticate(@Nullable Route route, Response response) throws IOException {
        return handleRequest(response, this.tmdb);
    }

    @Nullable
    public static Request handleRequest(Response response, Tmdb tmdb) throws IOException {
        if (response.request().url().pathSegments().get(0).equals(Tmdb.PATH_AUTHENTICATION)) {
            return null;
        }
        if (responseCount(response) >= 2) {
            throw new TmdbAuthenticationFailedException(30, "Authentication failed: You do not have permissions to access the service.");
        }
        HttpUrl.Builder newBuilder = response.request().url().newBuilder();
        if (tmdb.useAccountSession()) {
            if (tmdb.getUsername() == null || tmdb.getPassword() == null) {
                throw new TmdbAuthenticationFailedException(26, "You must provide a username and password.");
            }
            String acquireAccountSession = acquireAccountSession(tmdb);
            if (acquireAccountSession == null) {
                return null;
            }
            newBuilder.setEncodedQueryParameter("session_id", acquireAccountSession);
        } else if (tmdb.useGuestSession()) {
            if (acquireGuestSession(tmdb) == null) {
                return null;
            }
            newBuilder.setEncodedQueryParameter(Tmdb.PARAM_GUEST_SESSION_ID, tmdb.getGuestSessionId());
        } else {
            throw new TmdbAuthenticationFailedException(30, "Authentication failed: You do not have permissions to access the service.");
        }
        return response.request().newBuilder().url(newBuilder.build()).build();
    }

    @Nullable
    public static String acquireAccountSession(Tmdb tmdb) throws IOException {
        RequestToken body;
        Session body2;
        AuthenticationService authenticationService = (AuthenticationService) tmdb.getRetrofit().create(AuthenticationService.class);
        RequestToken body3 = authenticationService.requestToken().execute().body();
        if (body3 == null || (body = authenticationService.validateToken(tmdb.getUsername(), tmdb.getPassword(), body3.request_token).execute().body()) == null || (body2 = authenticationService.createSession(body.request_token).execute().body()) == null) {
            return null;
        }
        tmdb.setSessionId(body2.session_id);
        return body2.session_id;
    }

    @Nullable
    public static String acquireGuestSession(Tmdb tmdb) throws IOException {
        GuestSession body = ((AuthenticationService) tmdb.getRetrofit().create(AuthenticationService.class)).createGuestSession().execute().body();
        if (body == null) {
            return null;
        }
        tmdb.setGuestSessionId(body.guest_session_id);
        return body.guest_session_id;
    }

    private static int responseCount(Response response) {
        int i = 1;
        while (true) {
            response = response.priorResponse();
            if (response == null) {
                return i;
            }
            i++;
        }
    }
}
