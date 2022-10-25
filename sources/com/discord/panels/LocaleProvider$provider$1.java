package com.discord.panels;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.p005os.ConfigurationCompat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: LocaleProvider.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "Ljava/util/Locale;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "invoke"}, m106k = 3, m105mv = {1, 1, 16})
/* loaded from: classes.dex */
final class LocaleProvider$provider$1 extends Lambda implements Function1<Context, Locale> {
    public static final LocaleProvider$provider$1 INSTANCE = new LocaleProvider$provider$1();

    LocaleProvider$provider$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Locale invoke(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
        Locale locale = ConfigurationCompat.getLocales(resources.getConfiguration()).get(0);
        Intrinsics.checkExpressionValueIsNotNull(locale, "ConfigurationCompat.getL…sources.configuration)[0]");
        return locale;
    }
}
