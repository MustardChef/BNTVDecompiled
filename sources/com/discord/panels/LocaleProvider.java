package com.discord.panels;

import android.content.Context;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocaleProvider.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0005J\u001a\u0010\t\u001a\u00020\n2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m107d2 = {"Lcom/discord/panels/LocaleProvider;", "", "()V", "provider", "Lkotlin/Function1;", "Landroid/content/Context;", "Ljava/util/Locale;", "getPrimaryLocale", "context", "setProvider", "", "overlapping_panels_release"}, m106k = 1, m105mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class LocaleProvider {
    public static final LocaleProvider INSTANCE = new LocaleProvider();
    private static Function1<? super Context, Locale> provider = LocaleProvider$provider$1.INSTANCE;

    private LocaleProvider() {
    }

    public final Locale getPrimaryLocale(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return provider.invoke(context);
    }

    public final void setProvider(Function1<? super Context, Locale> provider2) {
        Intrinsics.checkParameterIsNotNull(provider2, "provider");
        provider = provider2;
    }
}
