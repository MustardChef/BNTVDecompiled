package androidx.core.text;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0086\b¨\u0006\u0002"}, m107d2 = {"htmlEncode", "", "core-ktx_release"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: androidx.core.text.StringKt */
/* loaded from: classes.dex */
public final class String {
    public static final java.lang.String htmlEncode(java.lang.String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        java.lang.String htmlEncode = TextUtils.htmlEncode(str);
        Intrinsics.checkNotNullExpressionValue(htmlEncode, "htmlEncode(this)");
        return htmlEncode;
    }
}
