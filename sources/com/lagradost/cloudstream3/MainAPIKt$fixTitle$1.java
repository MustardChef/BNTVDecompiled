package com.lagradost.cloudstream3;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.CharsKt;

/* compiled from: MainAPI.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
final class MainAPIKt$fixTitle$1 extends Lambda implements Function1<String, CharSequence> {
    public static final MainAPIKt$fixTitle$1 INSTANCE = new MainAPIKt$fixTitle$1();

    MainAPIKt$fixTitle$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String lowerCase = it.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (lowerCase.length() > 0) {
            StringBuilder sb = new StringBuilder();
            char charAt = lowerCase.charAt(0);
            if (Character.isLowerCase(charAt)) {
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                it = CharsKt.titlecase(charAt, locale);
            }
            sb.append((Object) it);
            String substring = lowerCase.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            sb.append(substring);
            lowerCase = sb.toString();
        }
        return lowerCase;
    }
}
