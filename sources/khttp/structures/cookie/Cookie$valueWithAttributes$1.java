package khttp.structures.cookie;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Cookie.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, m107d2 = {"<anonymous>", "", "it", "", "", "", "invoke"}, m106k = 3, m105mv = {1, 1, 13})
/* loaded from: classes4.dex */
final class Cookie$valueWithAttributes$1 extends Lambda implements Function1<Map.Entry<? extends String, ? extends Object>, CharSequence> {
    public static final Cookie$valueWithAttributes$1 INSTANCE = new Cookie$valueWithAttributes$1();

    Cookie$valueWithAttributes$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends Object> entry) {
        return invoke2((Map.Entry<String, ? extends Object>) entry);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(Map.Entry<String, ? extends Object> it) {
        String valueOf;
        Intrinsics.checkParameterIsNotNull(it, "it");
        if (it.getValue() != null) {
            valueOf = it.getKey() + '=' + it.getValue();
        } else {
            valueOf = String.valueOf(it.getKey());
        }
        return valueOf;
    }
}
