package com.lagradost.cloudstream3.network;

import com.facebook.share.internal.ShareConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import okhttp3.Interceptor;
import okhttp3.Response;

/* compiled from: DdosGuardKiller.kt */
@Metadata(m108d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R)\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, m107d2 = {"Lcom/lagradost/cloudstream3/network/DdosGuardKiller;", "Lokhttp3/Interceptor;", "alwaysBypass", "", "(Z)V", "ddosBypassPath", "", "savedCookiesMap", "", "", "getSavedCookiesMap", "()Ljava/util/Map;", "bypassDdosGuard", "Lokhttp3/Response;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lokhttp3/Request;", "(Lokhttp3/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class DdosGuardKiller implements Interceptor {
    private final boolean alwaysBypass;
    private String ddosBypassPath;
    private final Map<String, Map<String, String>> savedCookiesMap = new LinkedHashMap();

    public DdosGuardKiller(boolean z) {
        this.alwaysBypass = z;
    }

    public final Map<String, Map<String, String>> getSavedCookiesMap() {
        return this.savedCookiesMap;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Object runBlocking$default;
        Intrinsics.checkNotNullParameter(chain, "chain");
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new DdosGuardKiller$intercept$1(chain, this, null), 1, null);
        return (Response) runBlocking$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01f9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01fa A[PHI: r1 
      PHI: (r1v27 java.lang.Object) = (r1v22 java.lang.Object), (r1v1 java.lang.Object) binds: [B:45:0x01f7, B:13:0x0031] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object bypassDdosGuard(okhttp3.Request r28, kotlin.coroutines.Continuation<? super okhttp3.Response> r29) {
        /*
            Method dump skipped, instructions count: 507
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.network.DdosGuardKiller.bypassDdosGuard(okhttp3.Request, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
