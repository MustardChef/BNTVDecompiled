package khttp.requests;

import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import khttp.structures.authorization.Authorization;
import khttp.structures.files.FileLike;
import kotlin.Metadata;

/* compiled from: Request.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0006\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR \u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0012R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0015R\u0012\u0010\u001f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u001e\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0012R\u0012\u0010$\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0005R\u0012\u0010&\u001a\u00020'X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0012\u0010*\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010!¨\u0006,"}, m107d2 = {"Lkhttp/requests/Request;", "", "allowRedirects", "", "getAllowRedirects", "()Z", "auth", "Lkhttp/structures/authorization/Authorization;", "getAuth", "()Lkhttp/structures/authorization/Authorization;", "body", "", "getBody", "()[B", "cookies", "", "", "getCookies", "()Ljava/util/Map;", "data", "getData", "()Ljava/lang/Object;", "files", "", "Lkhttp/structures/files/FileLike;", "getFiles", "()Ljava/util/List;", "headers", "getHeaders", "json", "getJson", FirebaseAnalytics.Param.METHOD, "getMethod", "()Ljava/lang/String;", NativeProtocol.WEB_DIALOG_PARAMS, "getParams", "stream", "getStream", "timeout", "", "getTimeout", "()D", "url", "getUrl", "library_release"}, m106k = 1, m105mv = {1, 1, 13})
/* loaded from: classes4.dex */
public interface Request {
    boolean getAllowRedirects();

    Authorization getAuth();

    byte[] getBody();

    Map<String, String> getCookies();

    Object getData();

    List<FileLike> getFiles();

    Map<String, String> getHeaders();

    Object getJson();

    String getMethod();

    Map<String, String> getParams();

    boolean getStream();

    double getTimeout();

    String getUrl();
}
