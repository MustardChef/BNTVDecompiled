package khttp;

import androidx.browser.trusted.sharing.ShareTarget;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import khttp.requests.GenericRequest;
import khttp.responses.GenericResponse;
import khttp.responses.Response;
import khttp.structures.authorization.Authorization;
import khttp.structures.files.FileLike;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

/* compiled from: KHttp.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u001a¯\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007¢\u0006\u0002\u0010\u0016\u001a¯\u0001\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007¢\u0006\u0002\u0010\u0016\u001a¯\u0001\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007¢\u0006\u0002\u0010\u0016\u001a¯\u0001\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007¢\u0006\u0002\u0010\u0016\u001a¯\u0001\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007¢\u0006\u0002\u0010\u0016\u001a¯\u0001\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007¢\u0006\u0002\u0010\u0016\u001a¯\u0001\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007¢\u0006\u0002\u0010\u0016\u001a·\u0001\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007¢\u0006\u0002\u0010\u001f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006 "}, m107d2 = {"DEFAULT_TIMEOUT", "", "delete", "Lkhttp/responses/Response;", "url", "", "headers", "", NativeProtocol.WEB_DIALOG_PARAMS, "data", "", "json", "auth", "Lkhttp/structures/authorization/Authorization;", "cookies", "timeout", "allowRedirects", "", "stream", "files", "", "Lkhttp/structures/files/FileLike;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;Lkhttp/structures/authorization/Authorization;Ljava/util/Map;DLjava/lang/Boolean;ZLjava/util/List;)Lkhttp/responses/Response;", "get", TtmlNode.TAG_HEAD, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "patch", "post", "put", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, FirebaseAnalytics.Param.METHOD, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;Lkhttp/structures/authorization/Authorization;Ljava/util/Map;DLjava/lang/Boolean;ZLjava/util/List;)Lkhttp/responses/Response;", "library_release"}, m106k = 2, m105mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class KHttp {
    public static final double DEFAULT_TIMEOUT = 30.0d;

    public static final Response delete(String str) {
        return delete$default(str, null, null, null, null, null, null, 0.0d, null, false, null, 2046, null);
    }

    public static final Response delete(String str, Map<String, String> map) {
        return delete$default(str, map, null, null, null, null, null, 0.0d, null, false, null, 2044, null);
    }

    public static final Response delete(String str, Map<String, String> map, Map<String, String> map2) {
        return delete$default(str, map, map2, null, null, null, null, 0.0d, null, false, null, 2040, null);
    }

    public static final Response delete(String str, Map<String, String> map, Map<String, String> map2, Object obj) {
        return delete$default(str, map, map2, obj, null, null, null, 0.0d, null, false, null, 2032, null);
    }

    public static final Response delete(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2) {
        return delete$default(str, map, map2, obj, obj2, null, null, 0.0d, null, false, null, CastStatusCodes.DEVICE_CONNECTION_SUSPENDED, null);
    }

    public static final Response delete(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization) {
        return delete$default(str, map, map2, obj, obj2, authorization, null, 0.0d, null, false, null, 1984, null);
    }

    public static final Response delete(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3) {
        return delete$default(str, map, map2, obj, obj2, authorization, map3, 0.0d, null, false, null, 1920, null);
    }

    public static final Response delete(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d) {
        return delete$default(str, map, map2, obj, obj2, authorization, map3, d, null, false, null, 1792, null);
    }

    public static final Response delete(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool) {
        return delete$default(str, map, map2, obj, obj2, authorization, map3, d, bool, false, null, 1536, null);
    }

    public static final Response delete(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool, boolean z) {
        return delete$default(str, map, map2, obj, obj2, authorization, map3, d, bool, z, null, 1024, null);
    }

    public static final Response get(String str) {
        return get$default(str, null, null, null, null, null, null, 0.0d, null, false, null, 2046, null);
    }

    public static final Response get(String str, Map<String, String> map) {
        return get$default(str, map, null, null, null, null, null, 0.0d, null, false, null, 2044, null);
    }

    public static final Response get(String str, Map<String, String> map, Map<String, String> map2) {
        return get$default(str, map, map2, null, null, null, null, 0.0d, null, false, null, 2040, null);
    }

    public static final Response get(String str, Map<String, String> map, Map<String, String> map2, Object obj) {
        return get$default(str, map, map2, obj, null, null, null, 0.0d, null, false, null, 2032, null);
    }

    public static final Response get(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2) {
        return get$default(str, map, map2, obj, obj2, null, null, 0.0d, null, false, null, CastStatusCodes.DEVICE_CONNECTION_SUSPENDED, null);
    }

    public static final Response get(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization) {
        return get$default(str, map, map2, obj, obj2, authorization, null, 0.0d, null, false, null, 1984, null);
    }

    public static final Response get(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3) {
        return get$default(str, map, map2, obj, obj2, authorization, map3, 0.0d, null, false, null, 1920, null);
    }

    public static final Response get(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d) {
        return get$default(str, map, map2, obj, obj2, authorization, map3, d, null, false, null, 1792, null);
    }

    public static final Response get(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool) {
        return get$default(str, map, map2, obj, obj2, authorization, map3, d, bool, false, null, 1536, null);
    }

    public static final Response get(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool, boolean z) {
        return get$default(str, map, map2, obj, obj2, authorization, map3, d, bool, z, null, 1024, null);
    }

    public static final Response head(String str) {
        return head$default(str, null, null, null, null, null, null, 0.0d, null, false, null, 2046, null);
    }

    public static final Response head(String str, Map<String, String> map) {
        return head$default(str, map, null, null, null, null, null, 0.0d, null, false, null, 2044, null);
    }

    public static final Response head(String str, Map<String, String> map, Map<String, String> map2) {
        return head$default(str, map, map2, null, null, null, null, 0.0d, null, false, null, 2040, null);
    }

    public static final Response head(String str, Map<String, String> map, Map<String, String> map2, Object obj) {
        return head$default(str, map, map2, obj, null, null, null, 0.0d, null, false, null, 2032, null);
    }

    public static final Response head(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2) {
        return head$default(str, map, map2, obj, obj2, null, null, 0.0d, null, false, null, CastStatusCodes.DEVICE_CONNECTION_SUSPENDED, null);
    }

    public static final Response head(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization) {
        return head$default(str, map, map2, obj, obj2, authorization, null, 0.0d, null, false, null, 1984, null);
    }

    public static final Response head(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3) {
        return head$default(str, map, map2, obj, obj2, authorization, map3, 0.0d, null, false, null, 1920, null);
    }

    public static final Response head(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d) {
        return head$default(str, map, map2, obj, obj2, authorization, map3, d, null, false, null, 1792, null);
    }

    public static final Response head(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool) {
        return head$default(str, map, map2, obj, obj2, authorization, map3, d, bool, false, null, 1536, null);
    }

    public static final Response head(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool, boolean z) {
        return head$default(str, map, map2, obj, obj2, authorization, map3, d, bool, z, null, 1024, null);
    }

    public static final Response options(String str) {
        return options$default(str, null, null, null, null, null, null, 0.0d, null, false, null, 2046, null);
    }

    public static final Response options(String str, Map<String, String> map) {
        return options$default(str, map, null, null, null, null, null, 0.0d, null, false, null, 2044, null);
    }

    public static final Response options(String str, Map<String, String> map, Map<String, String> map2) {
        return options$default(str, map, map2, null, null, null, null, 0.0d, null, false, null, 2040, null);
    }

    public static final Response options(String str, Map<String, String> map, Map<String, String> map2, Object obj) {
        return options$default(str, map, map2, obj, null, null, null, 0.0d, null, false, null, 2032, null);
    }

    public static final Response options(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2) {
        return options$default(str, map, map2, obj, obj2, null, null, 0.0d, null, false, null, CastStatusCodes.DEVICE_CONNECTION_SUSPENDED, null);
    }

    public static final Response options(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization) {
        return options$default(str, map, map2, obj, obj2, authorization, null, 0.0d, null, false, null, 1984, null);
    }

    public static final Response options(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3) {
        return options$default(str, map, map2, obj, obj2, authorization, map3, 0.0d, null, false, null, 1920, null);
    }

    public static final Response options(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d) {
        return options$default(str, map, map2, obj, obj2, authorization, map3, d, null, false, null, 1792, null);
    }

    public static final Response options(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool) {
        return options$default(str, map, map2, obj, obj2, authorization, map3, d, bool, false, null, 1536, null);
    }

    public static final Response options(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool, boolean z) {
        return options$default(str, map, map2, obj, obj2, authorization, map3, d, bool, z, null, 1024, null);
    }

    public static final Response patch(String str) {
        return patch$default(str, null, null, null, null, null, null, 0.0d, null, false, null, 2046, null);
    }

    public static final Response patch(String str, Map<String, String> map) {
        return patch$default(str, map, null, null, null, null, null, 0.0d, null, false, null, 2044, null);
    }

    public static final Response patch(String str, Map<String, String> map, Map<String, String> map2) {
        return patch$default(str, map, map2, null, null, null, null, 0.0d, null, false, null, 2040, null);
    }

    public static final Response patch(String str, Map<String, String> map, Map<String, String> map2, Object obj) {
        return patch$default(str, map, map2, obj, null, null, null, 0.0d, null, false, null, 2032, null);
    }

    public static final Response patch(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2) {
        return patch$default(str, map, map2, obj, obj2, null, null, 0.0d, null, false, null, CastStatusCodes.DEVICE_CONNECTION_SUSPENDED, null);
    }

    public static final Response patch(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization) {
        return patch$default(str, map, map2, obj, obj2, authorization, null, 0.0d, null, false, null, 1984, null);
    }

    public static final Response patch(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3) {
        return patch$default(str, map, map2, obj, obj2, authorization, map3, 0.0d, null, false, null, 1920, null);
    }

    public static final Response patch(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d) {
        return patch$default(str, map, map2, obj, obj2, authorization, map3, d, null, false, null, 1792, null);
    }

    public static final Response patch(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool) {
        return patch$default(str, map, map2, obj, obj2, authorization, map3, d, bool, false, null, 1536, null);
    }

    public static final Response patch(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool, boolean z) {
        return patch$default(str, map, map2, obj, obj2, authorization, map3, d, bool, z, null, 1024, null);
    }

    public static final Response post(String str) {
        return post$default(str, null, null, null, null, null, null, 0.0d, null, false, null, 2046, null);
    }

    public static final Response post(String str, Map<String, String> map) {
        return post$default(str, map, null, null, null, null, null, 0.0d, null, false, null, 2044, null);
    }

    public static final Response post(String str, Map<String, String> map, Map<String, String> map2) {
        return post$default(str, map, map2, null, null, null, null, 0.0d, null, false, null, 2040, null);
    }

    public static final Response post(String str, Map<String, String> map, Map<String, String> map2, Object obj) {
        return post$default(str, map, map2, obj, null, null, null, 0.0d, null, false, null, 2032, null);
    }

    public static final Response post(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2) {
        return post$default(str, map, map2, obj, obj2, null, null, 0.0d, null, false, null, CastStatusCodes.DEVICE_CONNECTION_SUSPENDED, null);
    }

    public static final Response post(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization) {
        return post$default(str, map, map2, obj, obj2, authorization, null, 0.0d, null, false, null, 1984, null);
    }

    public static final Response post(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3) {
        return post$default(str, map, map2, obj, obj2, authorization, map3, 0.0d, null, false, null, 1920, null);
    }

    public static final Response post(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d) {
        return post$default(str, map, map2, obj, obj2, authorization, map3, d, null, false, null, 1792, null);
    }

    public static final Response post(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool) {
        return post$default(str, map, map2, obj, obj2, authorization, map3, d, bool, false, null, 1536, null);
    }

    public static final Response post(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool, boolean z) {
        return post$default(str, map, map2, obj, obj2, authorization, map3, d, bool, z, null, 1024, null);
    }

    public static final Response put(String str) {
        return put$default(str, null, null, null, null, null, null, 0.0d, null, false, null, 2046, null);
    }

    public static final Response put(String str, Map<String, String> map) {
        return put$default(str, map, null, null, null, null, null, 0.0d, null, false, null, 2044, null);
    }

    public static final Response put(String str, Map<String, String> map, Map<String, String> map2) {
        return put$default(str, map, map2, null, null, null, null, 0.0d, null, false, null, 2040, null);
    }

    public static final Response put(String str, Map<String, String> map, Map<String, String> map2, Object obj) {
        return put$default(str, map, map2, obj, null, null, null, 0.0d, null, false, null, 2032, null);
    }

    public static final Response put(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2) {
        return put$default(str, map, map2, obj, obj2, null, null, 0.0d, null, false, null, CastStatusCodes.DEVICE_CONNECTION_SUSPENDED, null);
    }

    public static final Response put(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization) {
        return put$default(str, map, map2, obj, obj2, authorization, null, 0.0d, null, false, null, 1984, null);
    }

    public static final Response put(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3) {
        return put$default(str, map, map2, obj, obj2, authorization, map3, 0.0d, null, false, null, 1920, null);
    }

    public static final Response put(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d) {
        return put$default(str, map, map2, obj, obj2, authorization, map3, d, null, false, null, 1792, null);
    }

    public static final Response put(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool) {
        return put$default(str, map, map2, obj, obj2, authorization, map3, d, bool, false, null, 1536, null);
    }

    public static final Response put(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool, boolean z) {
        return put$default(str, map, map2, obj, obj2, authorization, map3, d, bool, z, null, 1024, null);
    }

    public static final Response request(String str, String str2) {
        return request$default(str, str2, null, null, null, null, null, null, 0.0d, null, false, null, 4092, null);
    }

    public static final Response request(String str, String str2, Map<String, String> map) {
        return request$default(str, str2, map, null, null, null, null, null, 0.0d, null, false, null, 4088, null);
    }

    public static final Response request(String str, String str2, Map<String, String> map, Map<String, String> map2) {
        return request$default(str, str2, map, map2, null, null, null, null, 0.0d, null, false, null, 4080, null);
    }

    public static final Response request(String str, String str2, Map<String, String> map, Map<String, String> map2, Object obj) {
        return request$default(str, str2, map, map2, obj, null, null, null, 0.0d, null, false, null, 4064, null);
    }

    public static final Response request(String str, String str2, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2) {
        return request$default(str, str2, map, map2, obj, obj2, null, null, 0.0d, null, false, null, 4032, null);
    }

    public static final Response request(String str, String str2, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization) {
        return request$default(str, str2, map, map2, obj, obj2, authorization, null, 0.0d, null, false, null, Utf8.MASK_2BYTES, null);
    }

    public static final Response request(String str, String str2, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3) {
        return request$default(str, str2, map, map2, obj, obj2, authorization, map3, 0.0d, null, false, null, 3840, null);
    }

    public static final Response request(String str, String str2, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d) {
        return request$default(str, str2, map, map2, obj, obj2, authorization, map3, d, null, false, null, 3584, null);
    }

    public static final Response request(String str, String str2, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool) {
        return request$default(str, str2, map, map2, obj, obj2, authorization, map3, d, bool, false, null, 3072, null);
    }

    public static final Response request(String str, String str2, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool, boolean z) {
        return request$default(str, str2, map, map2, obj, obj2, authorization, map3, d, bool, z, null, 2048, null);
    }

    public static /* synthetic */ Response delete$default(String str, Map map, Map map2, Object obj, Object obj2, Authorization authorization, Map map3, double d, Boolean bool, boolean z, List list, int i, Object obj3) {
        return delete(str, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? MapsKt.emptyMap() : map2, (i & 8) != 0 ? null : obj, (i & 16) != 0 ? null : obj2, (i & 32) != 0 ? null : authorization, (i & 64) != 0 ? null : map3, (i & 128) != 0 ? 30.0d : d, (i & 256) != 0 ? null : bool, (i & 512) != 0 ? false : z, (i & 1024) != 0 ? CollectionsKt.emptyList() : list);
    }

    public static final Response delete(String url, Map<String, String> headers, Map<String, String> params, Object obj, Object obj2, Authorization authorization, Map<String, String> map, double d, Boolean bool, boolean z, List<FileLike> files) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(headers, "headers");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(files, "files");
        return request("DELETE", url, headers, params, obj, obj2, authorization, map, d, bool, z, files);
    }

    public static /* synthetic */ Response get$default(String str, Map map, Map map2, Object obj, Object obj2, Authorization authorization, Map map3, double d, Boolean bool, boolean z, List list, int i, Object obj3) {
        return get(str, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? MapsKt.emptyMap() : map2, (i & 8) != 0 ? null : obj, (i & 16) != 0 ? null : obj2, (i & 32) != 0 ? null : authorization, (i & 64) != 0 ? null : map3, (i & 128) != 0 ? 30.0d : d, (i & 256) != 0 ? null : bool, (i & 512) != 0 ? false : z, (i & 1024) != 0 ? CollectionsKt.emptyList() : list);
    }

    public static final Response get(String url, Map<String, String> headers, Map<String, String> params, Object obj, Object obj2, Authorization authorization, Map<String, String> map, double d, Boolean bool, boolean z, List<FileLike> files) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(headers, "headers");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(files, "files");
        return request(ShareTarget.METHOD_GET, url, headers, params, obj, obj2, authorization, map, d, bool, z, files);
    }

    public static /* synthetic */ Response head$default(String str, Map map, Map map2, Object obj, Object obj2, Authorization authorization, Map map3, double d, Boolean bool, boolean z, List list, int i, Object obj3) {
        return head(str, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? MapsKt.emptyMap() : map2, (i & 8) != 0 ? null : obj, (i & 16) != 0 ? null : obj2, (i & 32) != 0 ? null : authorization, (i & 64) != 0 ? null : map3, (i & 128) != 0 ? 30.0d : d, (i & 256) != 0 ? null : bool, (i & 512) != 0 ? false : z, (i & 1024) != 0 ? CollectionsKt.emptyList() : list);
    }

    public static final Response head(String url, Map<String, String> headers, Map<String, String> params, Object obj, Object obj2, Authorization authorization, Map<String, String> map, double d, Boolean bool, boolean z, List<FileLike> files) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(headers, "headers");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(files, "files");
        return request("HEAD", url, headers, params, obj, obj2, authorization, map, d, bool, z, files);
    }

    public static /* synthetic */ Response options$default(String str, Map map, Map map2, Object obj, Object obj2, Authorization authorization, Map map3, double d, Boolean bool, boolean z, List list, int i, Object obj3) {
        return options(str, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? MapsKt.emptyMap() : map2, (i & 8) != 0 ? null : obj, (i & 16) != 0 ? null : obj2, (i & 32) != 0 ? null : authorization, (i & 64) != 0 ? null : map3, (i & 128) != 0 ? 30.0d : d, (i & 256) != 0 ? null : bool, (i & 512) != 0 ? false : z, (i & 1024) != 0 ? CollectionsKt.emptyList() : list);
    }

    public static final Response options(String url, Map<String, String> headers, Map<String, String> params, Object obj, Object obj2, Authorization authorization, Map<String, String> map, double d, Boolean bool, boolean z, List<FileLike> files) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(headers, "headers");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(files, "files");
        return request("OPTIONS", url, headers, params, obj, obj2, authorization, map, d, bool, z, files);
    }

    public static /* synthetic */ Response patch$default(String str, Map map, Map map2, Object obj, Object obj2, Authorization authorization, Map map3, double d, Boolean bool, boolean z, List list, int i, Object obj3) {
        return patch(str, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? MapsKt.emptyMap() : map2, (i & 8) != 0 ? null : obj, (i & 16) != 0 ? null : obj2, (i & 32) != 0 ? null : authorization, (i & 64) != 0 ? null : map3, (i & 128) != 0 ? 30.0d : d, (i & 256) != 0 ? null : bool, (i & 512) != 0 ? false : z, (i & 1024) != 0 ? CollectionsKt.emptyList() : list);
    }

    public static final Response patch(String url, Map<String, String> headers, Map<String, String> params, Object obj, Object obj2, Authorization authorization, Map<String, String> map, double d, Boolean bool, boolean z, List<FileLike> files) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(headers, "headers");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(files, "files");
        return request("PATCH", url, headers, params, obj, obj2, authorization, map, d, bool, z, files);
    }

    public static /* synthetic */ Response post$default(String str, Map map, Map map2, Object obj, Object obj2, Authorization authorization, Map map3, double d, Boolean bool, boolean z, List list, int i, Object obj3) {
        return post(str, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? MapsKt.emptyMap() : map2, (i & 8) != 0 ? null : obj, (i & 16) != 0 ? null : obj2, (i & 32) != 0 ? null : authorization, (i & 64) != 0 ? null : map3, (i & 128) != 0 ? 30.0d : d, (i & 256) != 0 ? null : bool, (i & 512) != 0 ? false : z, (i & 1024) != 0 ? CollectionsKt.emptyList() : list);
    }

    public static final Response post(String url, Map<String, String> headers, Map<String, String> params, Object obj, Object obj2, Authorization authorization, Map<String, String> map, double d, Boolean bool, boolean z, List<FileLike> files) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(headers, "headers");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(files, "files");
        return request(ShareTarget.METHOD_POST, url, headers, params, obj, obj2, authorization, map, d, bool, z, files);
    }

    public static /* synthetic */ Response put$default(String str, Map map, Map map2, Object obj, Object obj2, Authorization authorization, Map map3, double d, Boolean bool, boolean z, List list, int i, Object obj3) {
        return put(str, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? MapsKt.emptyMap() : map2, (i & 8) != 0 ? null : obj, (i & 16) != 0 ? null : obj2, (i & 32) != 0 ? null : authorization, (i & 64) != 0 ? null : map3, (i & 128) != 0 ? 30.0d : d, (i & 256) != 0 ? null : bool, (i & 512) != 0 ? false : z, (i & 1024) != 0 ? CollectionsKt.emptyList() : list);
    }

    public static final Response put(String url, Map<String, String> headers, Map<String, String> params, Object obj, Object obj2, Authorization authorization, Map<String, String> map, double d, Boolean bool, boolean z, List<FileLike> files) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(headers, "headers");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(files, "files");
        return request("PUT", url, headers, params, obj, obj2, authorization, map, d, bool, z, files);
    }

    public static /* synthetic */ Response request$default(String str, String str2, Map map, Map map2, Object obj, Object obj2, Authorization authorization, Map map3, double d, Boolean bool, boolean z, List list, int i, Object obj3) {
        return request(str, str2, (i & 4) != 0 ? MapsKt.emptyMap() : map, (i & 8) != 0 ? MapsKt.emptyMap() : map2, (i & 16) != 0 ? null : obj, (i & 32) != 0 ? null : obj2, (i & 64) != 0 ? null : authorization, (i & 128) != 0 ? null : map3, (i & 256) != 0 ? 30.0d : d, (i & 512) != 0 ? null : bool, (i & 1024) != 0 ? false : z, (i & 2048) != 0 ? CollectionsKt.emptyList() : list);
    }

    public static final Response request(String method, String url, Map<String, String> headers, Map<String, String> params, Object obj, Object obj2, Authorization authorization, Map<String, String> map, double d, Boolean bool, boolean z, List<FileLike> files) {
        Intrinsics.checkParameterIsNotNull(method, "method");
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(headers, "headers");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(files, "files");
        GenericResponse genericResponse = new GenericResponse(new GenericRequest(method, url, params, headers, obj, obj2, authorization, map, d, bool, z, files));
        genericResponse.init$library_release();
        Response response = (Response) CollectionsKt.last((List<? extends Object>) genericResponse.get_history$library_release());
        genericResponse.get_history$library_release().remove(response);
        Iterator<T> it = KHttpConfig.Companion.getInterceptors$library_release().iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(response);
        }
        return response;
    }
}
