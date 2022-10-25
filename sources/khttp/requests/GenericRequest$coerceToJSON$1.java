package khttp.requests;

import android.util.JsonWriter;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GenericRequest.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, m107d2 = {"<anonymous>", "", "jsonWriter", "Landroid/util/JsonWriter;", "<anonymous parameter 1>", "", "invoke"}, m106k = 3, m105mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class GenericRequest$coerceToJSON$1 extends Lambda implements Function2<JsonWriter, Iterable<?>, Unit> {
    final /* synthetic */ Object $any;
    final /* synthetic */ GenericRequest this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericRequest$coerceToJSON$1(GenericRequest genericRequest, Object obj) {
        super(2);
        this.this$0 = genericRequest;
        this.$any = obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(JsonWriter jsonWriter, Iterable<?> iterable) {
        invoke2(jsonWriter, iterable);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(JsonWriter jsonWriter, Iterable<?> iterable) {
        Intrinsics.checkParameterIsNotNull(jsonWriter, "jsonWriter");
        Intrinsics.checkParameterIsNotNull(iterable, "<anonymous parameter 1>");
        jsonWriter.beginArray();
        Iterator it = ((Iterable) this.$any).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (Intrinsics.areEqual(next, Boolean.valueOf(next == null))) {
                jsonWriter.value("null");
            } else if (next instanceof Boolean) {
                jsonWriter.value(((Boolean) next).booleanValue());
            } else if (next instanceof Number) {
                jsonWriter.value((Number) next);
            } else if (next instanceof String) {
                jsonWriter.value((String) next);
            } else {
                GenericRequest genericRequest = this.this$0;
                if (next == null) {
                    Intrinsics.throwNpe();
                }
                genericRequest.coerceToJSON(next);
            }
        }
        jsonWriter.endArray();
    }
}
