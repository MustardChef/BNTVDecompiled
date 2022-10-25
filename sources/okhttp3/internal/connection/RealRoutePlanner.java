package okhttp3.internal.connection;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.app.NotificationCompat;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.ConnectionSpec;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.RoutePlanner;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.HttpStatusCodes;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.platform.Platform;

/* compiled from: RealRoutePlanner.kt */
@Metadata(m108d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u0012\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0002J'\u0010 \u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00102\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\"H\u0000¢\u0006\u0002\b#J\n\u0010$\u001a\u0004\u0018\u00010%H\u0002J-\u0010&\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001f2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\"H\u0000¢\u0006\u0002\b(J\u0012\u0010)\u001a\u0004\u0018\u00010\u00102\u0006\u0010*\u001a\u00020\u001aH\u0002J\u0010\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, m107d2 = {"Lokhttp3/internal/connection/RealRoutePlanner;", "Lokhttp3/internal/connection/RoutePlanner;", "client", "Lokhttp3/OkHttpClient;", "address", "Lokhttp3/Address;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/internal/connection/RealCall;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "(Lokhttp3/OkHttpClient;Lokhttp3/Address;Lokhttp3/internal/connection/RealCall;Lokhttp3/internal/http/RealInterceptorChain;)V", "getAddress", "()Lokhttp3/Address;", "doExtensiveHealthChecks", "", "nextRouteToTry", "Lokhttp3/Route;", "routeSelection", "Lokhttp3/internal/connection/RouteSelector$Selection;", "routeSelector", "Lokhttp3/internal/connection/RouteSelector;", "createTunnelRequest", "Lokhttp3/Request;", "route", "hasNext", "failedConnection", "Lokhttp3/internal/connection/RealConnection;", "isCanceled", "plan", "Lokhttp3/internal/connection/RoutePlanner$Plan;", "planConnect", "Lokhttp3/internal/connection/ConnectPlan;", "planConnectToRoute", "routes", "", "planConnectToRoute$okhttp", "planReuseCallConnection", "Lokhttp3/internal/connection/ReusePlan;", "planReusePooledConnection", "planToReplace", "planReusePooledConnection$okhttp", "retryRoute", "connection", "sameHostAndPort", "url", "Lokhttp3/HttpUrl;", "okhttp"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class RealRoutePlanner implements RoutePlanner {
    private final Address address;
    private final RealCall call;
    private final OkHttpClient client;
    private final boolean doExtensiveHealthChecks;
    private Route nextRouteToTry;
    private RouteSelector.Selection routeSelection;
    private RouteSelector routeSelector;

    public RealRoutePlanner(OkHttpClient client, Address address, RealCall call, RealInterceptorChain chain) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(chain, "chain");
        this.client = client;
        this.address = address;
        this.call = call;
        this.doExtensiveHealthChecks = !Intrinsics.areEqual(chain.getRequest$okhttp().method(), ShareTarget.METHOD_GET);
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public Address getAddress() {
        return this.address;
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public boolean isCanceled() {
        return this.call.isCanceled();
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public RoutePlanner.Plan plan() throws IOException {
        ReusePlan planReuseCallConnection = planReuseCallConnection();
        if (planReuseCallConnection != null) {
            return planReuseCallConnection;
        }
        ReusePlan planReusePooledConnection$okhttp$default = planReusePooledConnection$okhttp$default(this, null, null, 3, null);
        if (planReusePooledConnection$okhttp$default != null) {
            return planReusePooledConnection$okhttp$default;
        }
        ConnectPlan planConnect = planConnect();
        ReusePlan planReusePooledConnection$okhttp = planReusePooledConnection$okhttp(planConnect, planConnect.getRoutes$okhttp());
        if (planReusePooledConnection$okhttp != null) {
            return planReusePooledConnection$okhttp;
        }
        return planConnect;
    }

    private final ReusePlan planReuseCallConnection() {
        Socket releaseConnectionNoEvents$okhttp;
        RealConnection connection = this.call.getConnection();
        if (connection == null) {
            return null;
        }
        boolean isHealthy = connection.isHealthy(this.doExtensiveHealthChecks);
        synchronized (connection) {
            if (!isHealthy) {
                connection.setNoNewExchanges(true);
                releaseConnectionNoEvents$okhttp = this.call.releaseConnectionNoEvents$okhttp();
            } else {
                if (!connection.getNoNewExchanges() && sameHostAndPort(connection.route().address().url())) {
                    releaseConnectionNoEvents$okhttp = null;
                }
                releaseConnectionNoEvents$okhttp = this.call.releaseConnectionNoEvents$okhttp();
            }
        }
        if (this.call.getConnection() != null) {
            if (!(releaseConnectionNoEvents$okhttp == null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return new ReusePlan(connection);
        }
        if (releaseConnectionNoEvents$okhttp != null) {
            _UtilJvmKt.closeQuietly(releaseConnectionNoEvents$okhttp);
        }
        this.call.getEventListener$okhttp().connectionReleased(this.call, connection);
        return null;
    }

    private final ConnectPlan planConnect() throws IOException {
        Route route = this.nextRouteToTry;
        if (route != null) {
            this.nextRouteToTry = null;
            return planConnectToRoute$okhttp$default(this, route, null, 2, null);
        }
        RouteSelector.Selection selection = this.routeSelection;
        if (selection != null && selection.hasNext()) {
            return planConnectToRoute$okhttp$default(this, selection.next(), null, 2, null);
        }
        RouteSelector routeSelector = this.routeSelector;
        if (routeSelector == null) {
            routeSelector = new RouteSelector(getAddress(), this.call.getClient().getRouteDatabase$okhttp(), this.call, this.client.fastFallback(), this.call.getEventListener$okhttp());
            this.routeSelector = routeSelector;
        }
        if (!routeSelector.hasNext()) {
            throw new IOException("exhausted all routes");
        }
        RouteSelector.Selection next = routeSelector.next();
        this.routeSelection = next;
        if (this.call.isCanceled()) {
            throw new IOException("Canceled");
        }
        return planConnectToRoute$okhttp(next.next(), next.getRoutes());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReusePlan planReusePooledConnection$okhttp$default(RealRoutePlanner realRoutePlanner, ConnectPlan connectPlan, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            connectPlan = null;
        }
        if ((i & 2) != 0) {
            list = null;
        }
        return realRoutePlanner.planReusePooledConnection$okhttp(connectPlan, list);
    }

    public final ReusePlan planReusePooledConnection$okhttp(ConnectPlan connectPlan, List<Route> list) {
        RealConnection callAcquirePooledConnection = this.client.connectionPool().getDelegate$okhttp().callAcquirePooledConnection(this.doExtensiveHealthChecks, getAddress(), this.call, list, connectPlan != null && connectPlan.isReady());
        if (callAcquirePooledConnection == null) {
            return null;
        }
        if (connectPlan != null) {
            this.nextRouteToTry = connectPlan.getRoute();
            connectPlan.closeQuietly();
        }
        this.call.getEventListener$okhttp().connectionAcquired(this.call, callAcquirePooledConnection);
        return new ReusePlan(callAcquirePooledConnection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConnectPlan planConnectToRoute$okhttp$default(RealRoutePlanner realRoutePlanner, Route route, List list, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            list = null;
        }
        return realRoutePlanner.planConnectToRoute$okhttp(route, list);
    }

    public final ConnectPlan planConnectToRoute$okhttp(Route route, List<Route> list) throws IOException {
        Intrinsics.checkNotNullParameter(route, "route");
        if (route.address().sslSocketFactory() == null) {
            if (!route.address().connectionSpecs().contains(ConnectionSpec.CLEARTEXT)) {
                throw new UnknownServiceException("CLEARTEXT communication not enabled for client");
            }
            String host = route.address().url().host();
            if (!Platform.Companion.get().isCleartextTrafficPermitted(host)) {
                throw new UnknownServiceException("CLEARTEXT communication to " + host + " not permitted by network security policy");
            }
        } else if (route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            throw new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS");
        }
        return new ConnectPlan(this.client, this.call, this, route, list, 0, route.requiresTunnel() ? createTunnelRequest(route) : null, -1, false);
    }

    private final Request createTunnelRequest(Route route) throws IOException {
        Request build = new Request.Builder().url(route.address().url()).method("CONNECT", null).header(HttpHeaders.HOST, _UtilJvmKt.toHostHeader(route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", _UtilCommonKt.userAgent).build();
        Request authenticate = route.address().proxyAuthenticator().authenticate(route, new Response.Builder().request(build).protocol(Protocol.HTTP_1_1).code(HttpStatusCodes.HTTP_PROXY_AUTH).message("Preemptive Authenticate").body(_UtilJvmKt.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(-1L).header("Proxy-Authenticate", "OkHttp-Preemptive").build());
        return authenticate == null ? build : authenticate;
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public boolean hasNext(RealConnection realConnection) {
        RouteSelector routeSelector;
        Route retryRoute;
        if (this.nextRouteToTry != null) {
            return true;
        }
        if (realConnection != null && (retryRoute = retryRoute(realConnection)) != null) {
            this.nextRouteToTry = retryRoute;
            return true;
        }
        RouteSelector.Selection selection = this.routeSelection;
        boolean z = false;
        if (selection != null && selection.hasNext()) {
            z = true;
        }
        if (z || (routeSelector = this.routeSelector) == null) {
            return true;
        }
        return routeSelector.hasNext();
    }

    private final Route retryRoute(RealConnection realConnection) {
        synchronized (realConnection) {
            if (realConnection.getRouteFailureCount$okhttp() != 0) {
                return null;
            }
            if (realConnection.getNoNewExchanges()) {
                if (_UtilJvmKt.canReuseConnectionFor(realConnection.route().address().url(), getAddress().url())) {
                    return realConnection.route();
                }
                return null;
            }
            return null;
        }
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public boolean sameHostAndPort(HttpUrl url) {
        Intrinsics.checkNotNullParameter(url, "url");
        HttpUrl url2 = getAddress().url();
        return url.port() == url2.port() && Intrinsics.areEqual(url.host(), url2.host());
    }
}
