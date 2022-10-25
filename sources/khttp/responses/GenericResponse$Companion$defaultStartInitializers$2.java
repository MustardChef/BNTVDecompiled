package khttp.responses;

import java.net.HttpURLConnection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: GenericResponse.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, m107d2 = {"<anonymous>", "", "response", "Lkhttp/responses/GenericResponse;", "connection", "Ljava/net/HttpURLConnection;", "invoke"}, m106k = 3, m105mv = {1, 1, 13})
/* loaded from: classes4.dex */
final class GenericResponse$Companion$defaultStartInitializers$2 extends Lambda implements Function2<GenericResponse, HttpURLConnection, Unit> {
    public static final GenericResponse$Companion$defaultStartInitializers$2 INSTANCE = new GenericResponse$Companion$defaultStartInitializers$2();

    GenericResponse$Companion$defaultStartInitializers$2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(GenericResponse genericResponse, HttpURLConnection httpURLConnection) {
        invoke2(genericResponse, httpURLConnection);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(GenericResponse response, HttpURLConnection connection) {
        Intrinsics.checkParameterIsNotNull(response, "response");
        Intrinsics.checkParameterIsNotNull(connection, "connection");
        for (Map.Entry<String, String> entry : response.getRequest().getHeaders().entrySet()) {
            connection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }
}
