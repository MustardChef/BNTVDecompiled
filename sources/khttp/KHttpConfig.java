package khttp;

import java.util.ArrayList;
import khttp.responses.Response;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KHttp.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m107d2 = {"Lkhttp/KHttpConfig;", "", "()V", "Companion", "library_release"}, m106k = 1, m105mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class KHttpConfig {
    public static final Companion Companion = new Companion(null);
    private static final ArrayList<Function1<Response, Unit>> interceptors = new ArrayList<>();

    /* compiled from: KHttp.kt */
    @Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005R<\u0010\u0003\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005`\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, m107d2 = {"Lkhttp/KHttpConfig$Companion;", "", "()V", "interceptors", "Ljava/util/ArrayList;", "Lkotlin/Function1;", "Lkhttp/responses/Response;", "", "Lkotlin/collections/ArrayList;", "getInterceptors$library_release", "()Ljava/util/ArrayList;", "attachInterceptor", "interceptor", "library_release"}, m106k = 1, m105mv = {1, 1, 13})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ArrayList<Function1<Response, Unit>> getInterceptors$library_release() {
            return KHttpConfig.interceptors;
        }

        public final void attachInterceptor(Function1<? super Response, Unit> interceptor) {
            Intrinsics.checkParameterIsNotNull(interceptor, "interceptor");
            getInterceptors$library_release().add(interceptor);
        }
    }
}
