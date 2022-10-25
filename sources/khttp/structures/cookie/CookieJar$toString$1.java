package khttp.structures.cookie;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CookieJar.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "Lkhttp/structures/cookie/Cookie;", "invoke"}, m106k = 3, m105mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class CookieJar$toString$1 extends Lambda implements Function1<Cookie, String> {
    public static final CookieJar$toString$1 INSTANCE = new CookieJar$toString$1();

    CookieJar$toString$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(Cookie it) {
        Intrinsics.checkParameterIsNotNull(it, "it");
        return it.getKey() + '=' + it.getValue();
    }
}
