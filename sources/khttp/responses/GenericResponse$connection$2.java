package khttp.responses;

import java.net.HttpURLConnection;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GenericResponse.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Ljava/net/HttpURLConnection;", "invoke"}, m106k = 3, m105mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class GenericResponse$connection$2 extends Lambda implements Function1<HttpURLConnection, Unit> {
    final /* synthetic */ GenericResponse this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericResponse$connection$2(GenericResponse genericResponse) {
        super(1);
        this.this$0 = genericResponse;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HttpURLConnection httpURLConnection) {
        invoke2(httpURLConnection);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(HttpURLConnection receiver$0) {
        List list;
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        list = this.this$0.initializers;
        for (Function2 function2 : CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) GenericResponse.Companion.getDefaultStartInitializers$library_release(), (Iterable) list), (Iterable) GenericResponse.Companion.getDefaultEndInitializers$library_release())) {
            function2.invoke(this.this$0, receiver$0);
        }
    }
}
