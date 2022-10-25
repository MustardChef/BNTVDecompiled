package khttp.extensions;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.cast.CastStatusCodes;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.List;
import java.util.Map;
import khttp.KHttp;
import khttp.responses.Response;
import khttp.structures.authorization.Authorization;
import khttp.structures.files.FileLike;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u001aµ\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007¢\u0006\u0002\u0010\u0016\u001aµ\u0001\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007¢\u0006\u0002\u0010\u0016\u001aµ\u0001\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007¢\u0006\u0002\u0010\u0016\u001aµ\u0001\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007¢\u0006\u0002\u0010\u0016\u001aµ\u0001\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007¢\u0006\u0002\u0010\u0016\u001aµ\u0001\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007¢\u0006\u0002\u0010\u0016\u001aµ\u0001\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007¢\u0006\u0002\u0010\u0016¨\u0006\u001d"}, m107d2 = {"delete", "Lio/reactivex/Single;", "Lkhttp/responses/Response;", "url", "", "headers", "", NativeProtocol.WEB_DIALOG_PARAMS, "data", "", "json", "auth", "Lkhttp/structures/authorization/Authorization;", "cookies", "timeout", "", "allowRedirects", "", "stream", "files", "", "Lkhttp/structures/files/FileLike;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;Lkhttp/structures/authorization/Authorization;Ljava/util/Map;DLjava/lang/Boolean;ZLjava/util/List;)Lio/reactivex/Single;", "get", TtmlNode.TAG_HEAD, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "patch", "post", "put", "library_release"}, m106k = 2, m105mv = {1, 1, 13})
/* renamed from: khttp.extensions.RxKHttpKt */
/* loaded from: classes4.dex */
public final class RxKHttp {
    public static final Single<Response> delete(String str) {
        return delete$default(str, null, null, null, null, null, null, 0.0d, null, false, null, 2046, null);
    }

    public static final Single<Response> delete(String str, Map<String, String> map) {
        return delete$default(str, map, null, null, null, null, null, 0.0d, null, false, null, 2044, null);
    }

    public static final Single<Response> delete(String str, Map<String, String> map, Map<String, String> map2) {
        return delete$default(str, map, map2, null, null, null, null, 0.0d, null, false, null, 2040, null);
    }

    public static final Single<Response> delete(String str, Map<String, String> map, Map<String, String> map2, Object obj) {
        return delete$default(str, map, map2, obj, null, null, null, 0.0d, null, false, null, 2032, null);
    }

    public static final Single<Response> delete(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2) {
        return delete$default(str, map, map2, obj, obj2, null, null, 0.0d, null, false, null, CastStatusCodes.DEVICE_CONNECTION_SUSPENDED, null);
    }

    public static final Single<Response> delete(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization) {
        return delete$default(str, map, map2, obj, obj2, authorization, null, 0.0d, null, false, null, 1984, null);
    }

    public static final Single<Response> delete(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3) {
        return delete$default(str, map, map2, obj, obj2, authorization, map3, 0.0d, null, false, null, 1920, null);
    }

    public static final Single<Response> delete(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d) {
        return delete$default(str, map, map2, obj, obj2, authorization, map3, d, null, false, null, 1792, null);
    }

    public static final Single<Response> delete(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool) {
        return delete$default(str, map, map2, obj, obj2, authorization, map3, d, bool, false, null, 1536, null);
    }

    public static final Single<Response> delete(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool, boolean z) {
        return delete$default(str, map, map2, obj, obj2, authorization, map3, d, bool, z, null, 1024, null);
    }

    public static final Single<Response> get(String str) {
        return get$default(str, null, null, null, null, null, null, 0.0d, null, false, null, 2046, null);
    }

    public static final Single<Response> get(String str, Map<String, String> map) {
        return get$default(str, map, null, null, null, null, null, 0.0d, null, false, null, 2044, null);
    }

    public static final Single<Response> get(String str, Map<String, String> map, Map<String, String> map2) {
        return get$default(str, map, map2, null, null, null, null, 0.0d, null, false, null, 2040, null);
    }

    public static final Single<Response> get(String str, Map<String, String> map, Map<String, String> map2, Object obj) {
        return get$default(str, map, map2, obj, null, null, null, 0.0d, null, false, null, 2032, null);
    }

    public static final Single<Response> get(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2) {
        return get$default(str, map, map2, obj, obj2, null, null, 0.0d, null, false, null, CastStatusCodes.DEVICE_CONNECTION_SUSPENDED, null);
    }

    public static final Single<Response> get(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization) {
        return get$default(str, map, map2, obj, obj2, authorization, null, 0.0d, null, false, null, 1984, null);
    }

    public static final Single<Response> get(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3) {
        return get$default(str, map, map2, obj, obj2, authorization, map3, 0.0d, null, false, null, 1920, null);
    }

    public static final Single<Response> get(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d) {
        return get$default(str, map, map2, obj, obj2, authorization, map3, d, null, false, null, 1792, null);
    }

    public static final Single<Response> get(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool) {
        return get$default(str, map, map2, obj, obj2, authorization, map3, d, bool, false, null, 1536, null);
    }

    public static final Single<Response> get(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool, boolean z) {
        return get$default(str, map, map2, obj, obj2, authorization, map3, d, bool, z, null, 1024, null);
    }

    public static final Single<Response> head(String str) {
        return head$default(str, null, null, null, null, null, null, 0.0d, null, false, null, 2046, null);
    }

    public static final Single<Response> head(String str, Map<String, String> map) {
        return head$default(str, map, null, null, null, null, null, 0.0d, null, false, null, 2044, null);
    }

    public static final Single<Response> head(String str, Map<String, String> map, Map<String, String> map2) {
        return head$default(str, map, map2, null, null, null, null, 0.0d, null, false, null, 2040, null);
    }

    public static final Single<Response> head(String str, Map<String, String> map, Map<String, String> map2, Object obj) {
        return head$default(str, map, map2, obj, null, null, null, 0.0d, null, false, null, 2032, null);
    }

    public static final Single<Response> head(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2) {
        return head$default(str, map, map2, obj, obj2, null, null, 0.0d, null, false, null, CastStatusCodes.DEVICE_CONNECTION_SUSPENDED, null);
    }

    public static final Single<Response> head(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization) {
        return head$default(str, map, map2, obj, obj2, authorization, null, 0.0d, null, false, null, 1984, null);
    }

    public static final Single<Response> head(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3) {
        return head$default(str, map, map2, obj, obj2, authorization, map3, 0.0d, null, false, null, 1920, null);
    }

    public static final Single<Response> head(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d) {
        return head$default(str, map, map2, obj, obj2, authorization, map3, d, null, false, null, 1792, null);
    }

    public static final Single<Response> head(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool) {
        return head$default(str, map, map2, obj, obj2, authorization, map3, d, bool, false, null, 1536, null);
    }

    public static final Single<Response> head(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool, boolean z) {
        return head$default(str, map, map2, obj, obj2, authorization, map3, d, bool, z, null, 1024, null);
    }

    public static final Single<Response> options(String str) {
        return options$default(str, null, null, null, null, null, null, 0.0d, null, false, null, 2046, null);
    }

    public static final Single<Response> options(String str, Map<String, String> map) {
        return options$default(str, map, null, null, null, null, null, 0.0d, null, false, null, 2044, null);
    }

    public static final Single<Response> options(String str, Map<String, String> map, Map<String, String> map2) {
        return options$default(str, map, map2, null, null, null, null, 0.0d, null, false, null, 2040, null);
    }

    public static final Single<Response> options(String str, Map<String, String> map, Map<String, String> map2, Object obj) {
        return options$default(str, map, map2, obj, null, null, null, 0.0d, null, false, null, 2032, null);
    }

    public static final Single<Response> options(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2) {
        return options$default(str, map, map2, obj, obj2, null, null, 0.0d, null, false, null, CastStatusCodes.DEVICE_CONNECTION_SUSPENDED, null);
    }

    public static final Single<Response> options(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization) {
        return options$default(str, map, map2, obj, obj2, authorization, null, 0.0d, null, false, null, 1984, null);
    }

    public static final Single<Response> options(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3) {
        return options$default(str, map, map2, obj, obj2, authorization, map3, 0.0d, null, false, null, 1920, null);
    }

    public static final Single<Response> options(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d) {
        return options$default(str, map, map2, obj, obj2, authorization, map3, d, null, false, null, 1792, null);
    }

    public static final Single<Response> options(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool) {
        return options$default(str, map, map2, obj, obj2, authorization, map3, d, bool, false, null, 1536, null);
    }

    public static final Single<Response> options(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool, boolean z) {
        return options$default(str, map, map2, obj, obj2, authorization, map3, d, bool, z, null, 1024, null);
    }

    public static final Single<Response> patch(String str) {
        return patch$default(str, null, null, null, null, null, null, 0.0d, null, false, null, 2046, null);
    }

    public static final Single<Response> patch(String str, Map<String, String> map) {
        return patch$default(str, map, null, null, null, null, null, 0.0d, null, false, null, 2044, null);
    }

    public static final Single<Response> patch(String str, Map<String, String> map, Map<String, String> map2) {
        return patch$default(str, map, map2, null, null, null, null, 0.0d, null, false, null, 2040, null);
    }

    public static final Single<Response> patch(String str, Map<String, String> map, Map<String, String> map2, Object obj) {
        return patch$default(str, map, map2, obj, null, null, null, 0.0d, null, false, null, 2032, null);
    }

    public static final Single<Response> patch(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2) {
        return patch$default(str, map, map2, obj, obj2, null, null, 0.0d, null, false, null, CastStatusCodes.DEVICE_CONNECTION_SUSPENDED, null);
    }

    public static final Single<Response> patch(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization) {
        return patch$default(str, map, map2, obj, obj2, authorization, null, 0.0d, null, false, null, 1984, null);
    }

    public static final Single<Response> patch(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3) {
        return patch$default(str, map, map2, obj, obj2, authorization, map3, 0.0d, null, false, null, 1920, null);
    }

    public static final Single<Response> patch(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d) {
        return patch$default(str, map, map2, obj, obj2, authorization, map3, d, null, false, null, 1792, null);
    }

    public static final Single<Response> patch(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool) {
        return patch$default(str, map, map2, obj, obj2, authorization, map3, d, bool, false, null, 1536, null);
    }

    public static final Single<Response> patch(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool, boolean z) {
        return patch$default(str, map, map2, obj, obj2, authorization, map3, d, bool, z, null, 1024, null);
    }

    public static final Single<Response> post(String str) {
        return post$default(str, null, null, null, null, null, null, 0.0d, null, false, null, 2046, null);
    }

    public static final Single<Response> post(String str, Map<String, String> map) {
        return post$default(str, map, null, null, null, null, null, 0.0d, null, false, null, 2044, null);
    }

    public static final Single<Response> post(String str, Map<String, String> map, Map<String, String> map2) {
        return post$default(str, map, map2, null, null, null, null, 0.0d, null, false, null, 2040, null);
    }

    public static final Single<Response> post(String str, Map<String, String> map, Map<String, String> map2, Object obj) {
        return post$default(str, map, map2, obj, null, null, null, 0.0d, null, false, null, 2032, null);
    }

    public static final Single<Response> post(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2) {
        return post$default(str, map, map2, obj, obj2, null, null, 0.0d, null, false, null, CastStatusCodes.DEVICE_CONNECTION_SUSPENDED, null);
    }

    public static final Single<Response> post(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization) {
        return post$default(str, map, map2, obj, obj2, authorization, null, 0.0d, null, false, null, 1984, null);
    }

    public static final Single<Response> post(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3) {
        return post$default(str, map, map2, obj, obj2, authorization, map3, 0.0d, null, false, null, 1920, null);
    }

    public static final Single<Response> post(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d) {
        return post$default(str, map, map2, obj, obj2, authorization, map3, d, null, false, null, 1792, null);
    }

    public static final Single<Response> post(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool) {
        return post$default(str, map, map2, obj, obj2, authorization, map3, d, bool, false, null, 1536, null);
    }

    public static final Single<Response> post(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool, boolean z) {
        return post$default(str, map, map2, obj, obj2, authorization, map3, d, bool, z, null, 1024, null);
    }

    public static final Single<Response> put(String str) {
        return put$default(str, null, null, null, null, null, null, 0.0d, null, false, null, 2046, null);
    }

    public static final Single<Response> put(String str, Map<String, String> map) {
        return put$default(str, map, null, null, null, null, null, 0.0d, null, false, null, 2044, null);
    }

    public static final Single<Response> put(String str, Map<String, String> map, Map<String, String> map2) {
        return put$default(str, map, map2, null, null, null, null, 0.0d, null, false, null, 2040, null);
    }

    public static final Single<Response> put(String str, Map<String, String> map, Map<String, String> map2, Object obj) {
        return put$default(str, map, map2, obj, null, null, null, 0.0d, null, false, null, 2032, null);
    }

    public static final Single<Response> put(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2) {
        return put$default(str, map, map2, obj, obj2, null, null, 0.0d, null, false, null, CastStatusCodes.DEVICE_CONNECTION_SUSPENDED, null);
    }

    public static final Single<Response> put(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization) {
        return put$default(str, map, map2, obj, obj2, authorization, null, 0.0d, null, false, null, 1984, null);
    }

    public static final Single<Response> put(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3) {
        return put$default(str, map, map2, obj, obj2, authorization, map3, 0.0d, null, false, null, 1920, null);
    }

    public static final Single<Response> put(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d) {
        return put$default(str, map, map2, obj, obj2, authorization, map3, d, null, false, null, 1792, null);
    }

    public static final Single<Response> put(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool) {
        return put$default(str, map, map2, obj, obj2, authorization, map3, d, bool, false, null, 1536, null);
    }

    public static final Single<Response> put(String str, Map<String, String> map, Map<String, String> map2, Object obj, Object obj2, Authorization authorization, Map<String, String> map3, double d, Boolean bool, boolean z) {
        return put$default(str, map, map2, obj, obj2, authorization, map3, d, bool, z, null, 1024, null);
    }

    public static /* synthetic */ Single delete$default(String str, Map map, Map map2, Object obj, Object obj2, Authorization authorization, Map map3, double d, Boolean bool, boolean z, List list, int i, Object obj3) {
        return delete(str, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? MapsKt.emptyMap() : map2, (i & 8) != 0 ? null : obj, (i & 16) != 0 ? null : obj2, (i & 32) != 0 ? null : authorization, (i & 64) != 0 ? null : map3, (i & 128) != 0 ? 30.0d : d, (i & 256) != 0 ? null : bool, (i & 512) != 0 ? false : z, (i & 1024) != 0 ? CollectionsKt.emptyList() : list);
    }

    public static final Single<Response> delete(final String url, final Map<String, String> headers, final Map<String, String> params, final Object obj, final Object obj2, final Authorization authorization, final Map<String, String> map, final double d, final Boolean bool, final boolean z, final List<FileLike> files) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(headers, "headers");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(files, "files");
        Single<Response> create = Single.create(new SingleOnSubscribe<T>() { // from class: khttp.extensions.RxKHttpKt$delete$1
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(SingleEmitter<Response> emitter) {
                Intrinsics.checkParameterIsNotNull(emitter, "emitter");
                emitter.onSuccess(KHttp.delete(url, headers, params, obj, obj2, authorization, map, d, bool, z, files));
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(create, "Single.create<Response> …onSuccess(response)\n    }");
        return create;
    }

    public static /* synthetic */ Single get$default(String str, Map map, Map map2, Object obj, Object obj2, Authorization authorization, Map map3, double d, Boolean bool, boolean z, List list, int i, Object obj3) {
        return get(str, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? MapsKt.emptyMap() : map2, (i & 8) != 0 ? null : obj, (i & 16) != 0 ? null : obj2, (i & 32) != 0 ? null : authorization, (i & 64) != 0 ? null : map3, (i & 128) != 0 ? 30.0d : d, (i & 256) != 0 ? null : bool, (i & 512) != 0 ? false : z, (i & 1024) != 0 ? CollectionsKt.emptyList() : list);
    }

    public static final Single<Response> get(final String url, final Map<String, String> headers, final Map<String, String> params, final Object obj, final Object obj2, final Authorization authorization, final Map<String, String> map, final double d, final Boolean bool, final boolean z, final List<FileLike> files) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(headers, "headers");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(files, "files");
        Single<Response> create = Single.create(new SingleOnSubscribe<T>() { // from class: khttp.extensions.RxKHttpKt$get$1
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(SingleEmitter<Response> emitter) {
                Intrinsics.checkParameterIsNotNull(emitter, "emitter");
                emitter.onSuccess(KHttp.get(url, headers, params, obj, obj2, authorization, map, d, bool, z, files));
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(create, "Single.create<Response> …onSuccess(response)\n    }");
        return create;
    }

    public static /* synthetic */ Single head$default(String str, Map map, Map map2, Object obj, Object obj2, Authorization authorization, Map map3, double d, Boolean bool, boolean z, List list, int i, Object obj3) {
        return head(str, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? MapsKt.emptyMap() : map2, (i & 8) != 0 ? null : obj, (i & 16) != 0 ? null : obj2, (i & 32) != 0 ? null : authorization, (i & 64) != 0 ? null : map3, (i & 128) != 0 ? 30.0d : d, (i & 256) != 0 ? null : bool, (i & 512) != 0 ? false : z, (i & 1024) != 0 ? CollectionsKt.emptyList() : list);
    }

    public static final Single<Response> head(final String url, final Map<String, String> headers, final Map<String, String> params, final Object obj, final Object obj2, final Authorization authorization, final Map<String, String> map, final double d, final Boolean bool, final boolean z, final List<FileLike> files) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(headers, "headers");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(files, "files");
        Single<Response> create = Single.create(new SingleOnSubscribe<T>() { // from class: khttp.extensions.RxKHttpKt$head$1
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(SingleEmitter<Response> emitter) {
                Intrinsics.checkParameterIsNotNull(emitter, "emitter");
                emitter.onSuccess(KHttp.head(url, headers, params, obj, obj2, authorization, map, d, bool, z, files));
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(create, "Single.create<Response> …onSuccess(response)\n    }");
        return create;
    }

    public static /* synthetic */ Single options$default(String str, Map map, Map map2, Object obj, Object obj2, Authorization authorization, Map map3, double d, Boolean bool, boolean z, List list, int i, Object obj3) {
        return options(str, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? MapsKt.emptyMap() : map2, (i & 8) != 0 ? null : obj, (i & 16) != 0 ? null : obj2, (i & 32) != 0 ? null : authorization, (i & 64) != 0 ? null : map3, (i & 128) != 0 ? 30.0d : d, (i & 256) != 0 ? null : bool, (i & 512) != 0 ? false : z, (i & 1024) != 0 ? CollectionsKt.emptyList() : list);
    }

    public static final Single<Response> options(final String url, final Map<String, String> headers, final Map<String, String> params, final Object obj, final Object obj2, final Authorization authorization, final Map<String, String> map, final double d, final Boolean bool, final boolean z, final List<FileLike> files) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(headers, "headers");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(files, "files");
        Single<Response> create = Single.create(new SingleOnSubscribe<T>() { // from class: khttp.extensions.RxKHttpKt$options$1
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(SingleEmitter<Response> emitter) {
                Intrinsics.checkParameterIsNotNull(emitter, "emitter");
                emitter.onSuccess(KHttp.options(url, headers, params, obj, obj2, authorization, map, d, bool, z, files));
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(create, "Single.create<Response> …onSuccess(response)\n    }");
        return create;
    }

    public static /* synthetic */ Single patch$default(String str, Map map, Map map2, Object obj, Object obj2, Authorization authorization, Map map3, double d, Boolean bool, boolean z, List list, int i, Object obj3) {
        return patch(str, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? MapsKt.emptyMap() : map2, (i & 8) != 0 ? null : obj, (i & 16) != 0 ? null : obj2, (i & 32) != 0 ? null : authorization, (i & 64) != 0 ? null : map3, (i & 128) != 0 ? 30.0d : d, (i & 256) != 0 ? null : bool, (i & 512) != 0 ? false : z, (i & 1024) != 0 ? CollectionsKt.emptyList() : list);
    }

    public static final Single<Response> patch(final String url, final Map<String, String> headers, final Map<String, String> params, final Object obj, final Object obj2, final Authorization authorization, final Map<String, String> map, final double d, final Boolean bool, final boolean z, final List<FileLike> files) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(headers, "headers");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(files, "files");
        Single<Response> create = Single.create(new SingleOnSubscribe<T>() { // from class: khttp.extensions.RxKHttpKt$patch$1
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(SingleEmitter<Response> emitter) {
                Intrinsics.checkParameterIsNotNull(emitter, "emitter");
                emitter.onSuccess(KHttp.patch(url, headers, params, obj, obj2, authorization, map, d, bool, z, files));
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(create, "Single.create<Response> …onSuccess(response)\n    }");
        return create;
    }

    public static /* synthetic */ Single post$default(String str, Map map, Map map2, Object obj, Object obj2, Authorization authorization, Map map3, double d, Boolean bool, boolean z, List list, int i, Object obj3) {
        return post(str, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? MapsKt.emptyMap() : map2, (i & 8) != 0 ? null : obj, (i & 16) != 0 ? null : obj2, (i & 32) != 0 ? null : authorization, (i & 64) != 0 ? null : map3, (i & 128) != 0 ? 30.0d : d, (i & 256) != 0 ? null : bool, (i & 512) != 0 ? false : z, (i & 1024) != 0 ? CollectionsKt.emptyList() : list);
    }

    public static final Single<Response> post(final String url, final Map<String, String> headers, final Map<String, String> params, final Object obj, final Object obj2, final Authorization authorization, final Map<String, String> map, final double d, final Boolean bool, final boolean z, final List<FileLike> files) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(headers, "headers");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(files, "files");
        Single<Response> create = Single.create(new SingleOnSubscribe<T>() { // from class: khttp.extensions.RxKHttpKt$post$1
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(SingleEmitter<Response> emitter) {
                Intrinsics.checkParameterIsNotNull(emitter, "emitter");
                emitter.onSuccess(KHttp.post(url, headers, params, obj, obj2, authorization, map, d, bool, z, files));
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(create, "Single.create<Response> …onSuccess(response)\n    }");
        return create;
    }

    public static /* synthetic */ Single put$default(String str, Map map, Map map2, Object obj, Object obj2, Authorization authorization, Map map3, double d, Boolean bool, boolean z, List list, int i, Object obj3) {
        return put(str, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? MapsKt.emptyMap() : map2, (i & 8) != 0 ? null : obj, (i & 16) != 0 ? null : obj2, (i & 32) != 0 ? null : authorization, (i & 64) != 0 ? null : map3, (i & 128) != 0 ? 30.0d : d, (i & 256) != 0 ? null : bool, (i & 512) != 0 ? false : z, (i & 1024) != 0 ? CollectionsKt.emptyList() : list);
    }

    public static final Single<Response> put(final String url, final Map<String, String> headers, final Map<String, String> params, final Object obj, final Object obj2, final Authorization authorization, final Map<String, String> map, final double d, final Boolean bool, final boolean z, final List<FileLike> files) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(headers, "headers");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(files, "files");
        Single<Response> create = Single.create(new SingleOnSubscribe<T>() { // from class: khttp.extensions.RxKHttpKt$put$1
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(SingleEmitter<Response> emitter) {
                Intrinsics.checkParameterIsNotNull(emitter, "emitter");
                emitter.onSuccess(KHttp.put(url, headers, params, obj, obj2, authorization, map, d, bool, z, files));
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(create, "Single.create<Response> …onSuccess(response)\n    }");
        return create;
    }
}
