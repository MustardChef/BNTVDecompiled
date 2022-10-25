package org.acra.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.config.CoreConfiguration;

/* compiled from: SharedPreferencesFactory.kt */
@Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m107d2 = {"Lorg/acra/prefs/SharedPreferencesFactory;", "", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "(Landroid/content/Context;Lorg/acra/config/CoreConfiguration;)V", "create", "Landroid/content/SharedPreferences;", "Companion", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class SharedPreferencesFactory {
    public static final Companion Companion = new Companion(null);
    private final CoreConfiguration config;
    private final Context context;

    public SharedPreferencesFactory(Context context, CoreConfiguration config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.context = context;
        this.config = config;
    }

    public final SharedPreferences create() {
        if (!Intrinsics.areEqual("", this.config.getSharedPreferencesName())) {
            SharedPreferences sharedPreferences = this.context.getSharedPreferences(this.config.getSharedPreferencesName(), 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "{\n            context.getSharedPreferences(config.sharedPreferencesName, Context.MODE_PRIVATE)\n        }");
            return sharedPreferences;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "{\n            @Suppress(\"DEPRECATION\")\n            PreferenceManager.getDefaultSharedPreferences(context)\n        }");
        return defaultSharedPreferences;
    }

    /* compiled from: SharedPreferencesFactory.kt */
    @Metadata(m108d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m107d2 = {"Lorg/acra/prefs/SharedPreferencesFactory$Companion;", "", "()V", "shouldEnableACRA", "", "prefs", "Landroid/content/SharedPreferences;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean shouldEnableACRA(SharedPreferences prefs) {
            Intrinsics.checkNotNullParameter(prefs, "prefs");
            try {
                return prefs.getBoolean(ACRA.PREF_ENABLE_ACRA, prefs.getBoolean(ACRA.PREF_DISABLE_ACRA, false) ? false : true);
            } catch (Exception unused) {
                return true;
            }
        }
    }
}
