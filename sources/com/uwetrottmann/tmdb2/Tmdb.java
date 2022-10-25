package com.uwetrottmann.tmdb2;

import com.uwetrottmann.tmdb2.entities.Status;
import com.uwetrottmann.tmdb2.exceptions.TmdbAuthenticationFailedException;
import com.uwetrottmann.tmdb2.exceptions.TmdbDuplicateEntryException;
import com.uwetrottmann.tmdb2.exceptions.TmdbInvalidParametersException;
import com.uwetrottmann.tmdb2.exceptions.TmdbNotFoundException;
import com.uwetrottmann.tmdb2.exceptions.TmdbServiceErrorException;
import com.uwetrottmann.tmdb2.services.AccountService;
import com.uwetrottmann.tmdb2.services.AuthenticationService;
import com.uwetrottmann.tmdb2.services.CertificationsService;
import com.uwetrottmann.tmdb2.services.ChangesService;
import com.uwetrottmann.tmdb2.services.CollectionsService;
import com.uwetrottmann.tmdb2.services.CompaniesService;
import com.uwetrottmann.tmdb2.services.ConfigurationService;
import com.uwetrottmann.tmdb2.services.CreditsService;
import com.uwetrottmann.tmdb2.services.DiscoverService;
import com.uwetrottmann.tmdb2.services.FindService;
import com.uwetrottmann.tmdb2.services.GenresService;
import com.uwetrottmann.tmdb2.services.GuestSessionService;
import com.uwetrottmann.tmdb2.services.KeywordsService;
import com.uwetrottmann.tmdb2.services.ListsService;
import com.uwetrottmann.tmdb2.services.MoviesService;
import com.uwetrottmann.tmdb2.services.NetworksService;
import com.uwetrottmann.tmdb2.services.PeopleService;
import com.uwetrottmann.tmdb2.services.ReviewsService;
import com.uwetrottmann.tmdb2.services.SearchService;
import com.uwetrottmann.tmdb2.services.TimezonesService;
import com.uwetrottmann.tmdb2.services.TvEpisodesService;
import com.uwetrottmann.tmdb2.services.TvSeasonsService;
import com.uwetrottmann.tmdb2.services.TvService;
import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* loaded from: classes4.dex */
public class Tmdb {
    public static final String API_HOST = "api.themoviedb.org";
    public static final String API_URL = "https://api.themoviedb.org/3/";
    public static final String API_VERSION = "3";
    public static final String PARAM_API_KEY = "api_key";
    public static final String PARAM_GUEST_SESSION_ID = "guest_session_id";
    public static final String PARAM_SESSION_ID = "session_id";
    public static final String PATH_AUTHENTICATION = "authentication";
    private String apiKey;
    @Nullable
    private String guestSessionId;
    @Nullable
    private OkHttpClient okHttpClient;
    @Nullable
    private String password;
    @Nullable
    private Retrofit retrofit;
    @Nullable
    private String sessionId;
    @Nullable
    private String username;
    private boolean useGuestSession = false;
    private boolean useAccountSession = false;

    public Tmdb(String str) {
        this.apiKey = str;
    }

    public void accountSession(String str, String str2) {
        this.username = str;
        this.password = str2;
        this.useAccountSession = true;
    }

    public void guestSession() {
        this.useGuestSession = true;
    }

    public void clearSessions() {
        this.username = null;
        this.password = null;
        this.useAccountSession = false;
        this.useGuestSession = false;
        setSessionId(null);
        setGuestSessionId(null);
    }

    public boolean useAccountSession() {
        return this.useAccountSession;
    }

    public boolean useGuestSession() {
        return this.useGuestSession;
    }

    @Nullable
    public String getUsername() {
        return this.username;
    }

    @Nullable
    public String getPassword() {
        return this.password;
    }

    @Nullable
    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(@Nullable String str) {
        this.sessionId = str;
    }

    @Nullable
    public String getGuestSessionId() {
        return this.guestSessionId;
    }

    public void setGuestSessionId(@Nullable String str) {
        this.guestSessionId = str;
    }

    public boolean isLoggedIn() {
        return (getSessionId() == null && getGuestSessionId() == null) ? false : true;
    }

    public void apiKey(String str) {
        this.apiKey = str;
    }

    public String apiKey() {
        return this.apiKey;
    }

    protected Retrofit.Builder retrofitBuilder() {
        return new Retrofit.Builder().baseUrl(API_URL).addConverterFactory(GsonConverterFactory.create(TmdbHelper.getGsonBuilder().create())).client(okHttpClient());
    }

    protected synchronized OkHttpClient okHttpClient() {
        if (this.okHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            setOkHttpClientDefaults(builder);
            this.okHttpClient = builder.build();
        }
        return this.okHttpClient;
    }

    protected void setOkHttpClientDefaults(OkHttpClient.Builder builder) {
        builder.addInterceptor(new TmdbInterceptor(this)).authenticator(new TmdbAuthenticator(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Retrofit getRetrofit() {
        if (this.retrofit == null) {
            this.retrofit = retrofitBuilder().build();
        }
        return this.retrofit;
    }

    public void throwOnKnownError(Response response) throws IOException {
        ResponseBody errorBody;
        Status status;
        if (response.isSuccessful() || (errorBody = response.errorBody()) == null || (status = (Status) getRetrofit().responseBodyConverter(Status.class, Status.class.getAnnotations()).convert(errorBody)) == null) {
            return;
        }
        Integer num = status.status_code;
        String str = status.status_message;
        switch (num.intValue()) {
            case 2:
            case 4:
            case 9:
            case 11:
            case 15:
            case 16:
            case 19:
            case 24:
                throw new TmdbServiceErrorException(num.intValue(), str);
            case 3:
            case 7:
            case 10:
            case 14:
            case 17:
            case 18:
            case 26:
            case 30:
            case 31:
            case 32:
            case 33:
                throw new TmdbAuthenticationFailedException(num.intValue(), str);
            case 5:
            case 20:
            case 22:
            case 23:
            case 27:
            case 28:
                throw new TmdbInvalidParametersException(num.intValue(), str);
            case 6:
            case 34:
                throw new TmdbNotFoundException(num.intValue(), str);
            case 8:
                throw new TmdbDuplicateEntryException(num.intValue(), str);
            case 12:
            case 13:
            case 21:
            case 25:
            case 29:
            default:
                return;
        }
    }

    public AccountService accountService() {
        return (AccountService) getRetrofit().create(AccountService.class);
    }

    public AuthenticationService authenticationService() {
        return (AuthenticationService) getRetrofit().create(AuthenticationService.class);
    }

    public CertificationsService certificationsService() {
        return (CertificationsService) getRetrofit().create(CertificationsService.class);
    }

    public ChangesService changesService() {
        return (ChangesService) getRetrofit().create(ChangesService.class);
    }

    public CollectionsService collectionService() {
        return (CollectionsService) getRetrofit().create(CollectionsService.class);
    }

    public CompaniesService companiesService() {
        return (CompaniesService) getRetrofit().create(CompaniesService.class);
    }

    public ConfigurationService configurationService() {
        return (ConfigurationService) getRetrofit().create(ConfigurationService.class);
    }

    public CreditsService creditsService() {
        return (CreditsService) getRetrofit().create(CreditsService.class);
    }

    public DiscoverService discoverService() {
        return (DiscoverService) getRetrofit().create(DiscoverService.class);
    }

    public FindService findService() {
        return (FindService) getRetrofit().create(FindService.class);
    }

    public GenresService genreService() {
        return (GenresService) getRetrofit().create(GenresService.class);
    }

    public GuestSessionService guestSessionService() {
        return (GuestSessionService) getRetrofit().create(GuestSessionService.class);
    }

    public KeywordsService keywordsService() {
        return (KeywordsService) getRetrofit().create(KeywordsService.class);
    }

    public ListsService listsService() {
        return (ListsService) getRetrofit().create(ListsService.class);
    }

    public MoviesService moviesService() {
        return (MoviesService) getRetrofit().create(MoviesService.class);
    }

    public NetworksService networksService() {
        return (NetworksService) getRetrofit().create(NetworksService.class);
    }

    public PeopleService personService() {
        return (PeopleService) getRetrofit().create(PeopleService.class);
    }

    public ReviewsService reviewsService() {
        return (ReviewsService) getRetrofit().create(ReviewsService.class);
    }

    public SearchService searchService() {
        return (SearchService) getRetrofit().create(SearchService.class);
    }

    public TimezonesService timezonesService() {
        return (TimezonesService) getRetrofit().create(TimezonesService.class);
    }

    public TvService tvService() {
        return (TvService) getRetrofit().create(TvService.class);
    }

    public TvSeasonsService tvSeasonsService() {
        return (TvSeasonsService) getRetrofit().create(TvSeasonsService.class);
    }

    public TvEpisodesService tvEpisodesService() {
        return (TvEpisodesService) getRetrofit().create(TvEpisodesService.class);
    }

    public DiscoverMovieBuilder discoverMovie() {
        return new DiscoverMovieBuilder(discoverService());
    }

    public DiscoverTvBuilder discoverTv() {
        return new DiscoverTvBuilder(discoverService());
    }
}
