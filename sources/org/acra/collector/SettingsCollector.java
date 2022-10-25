package org.acra.collector;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.cast.MediaError;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.json.JSONObject;

/* compiled from: SettingsCollector.kt */
@Metadata(m108d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0002J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002¨\u0006\u0018"}, m107d2 = {"Lorg/acra/collector/SettingsCollector;", "Lorg/acra/collector/BaseReportFieldCollector;", "()V", "collect", "", "reportField", "Lorg/acra/ReportField;", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "reportBuilder", "Lorg/acra/builder/ReportBuilder;", TypedValues.AttributesType.S_TARGET, "Lorg/acra/data/CrashReportData;", "collectSettings", "Lorg/json/JSONObject;", "settings", "Ljava/lang/Class;", "isAuthorized", "", SDKConstants.PARAM_KEY, "Ljava/lang/reflect/Field;", "Companion", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public class SettingsCollector extends BaseReportFieldCollector {
    public static final Companion Companion = new Companion(null);
    private static final String ERROR = "Error: ";

    /* compiled from: SettingsCollector.kt */
    @Metadata(m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReportField.valuesCustom().length];
            iArr[ReportField.SETTINGS_SYSTEM.ordinal()] = 1;
            iArr[ReportField.SETTINGS_SECURE.ordinal()] = 2;
            iArr[ReportField.SETTINGS_GLOBAL.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SettingsCollector() {
        super(ReportField.SETTINGS_SYSTEM, ReportField.SETTINGS_SECURE, ReportField.SETTINGS_GLOBAL);
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    public void collect(ReportField reportField, Context context, CoreConfiguration config, ReportBuilder reportBuilder, CrashReportData target) throws Exception {
        Intrinsics.checkNotNullParameter(reportField, "reportField");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        Intrinsics.checkNotNullParameter(target, "target");
        int i = WhenMappings.$EnumSwitchMapping$0[reportField.ordinal()];
        if (i == 1) {
            target.put(ReportField.SETTINGS_SYSTEM, collectSettings(context, config, Settings.System.class));
        } else if (i == 2) {
            target.put(ReportField.SETTINGS_SECURE, collectSettings(context, config, Settings.Secure.class));
        } else if (i == 3) {
            target.put(ReportField.SETTINGS_GLOBAL, Build.VERSION.SDK_INT >= 17 ? collectSettings(context, config, Settings.Global.class) : null);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private final JSONObject collectSettings(Context context, CoreConfiguration coreConfiguration, Class<?> cls) throws NoSuchMethodException {
        JSONObject jSONObject = new JSONObject();
        Field[] keys = cls.getFields();
        Method method = cls.getMethod("getString", ContentResolver.class, String.class);
        Intrinsics.checkNotNullExpressionValue(keys, "keys");
        int length = keys.length;
        int i = 0;
        while (i < length) {
            Field field = keys[i];
            i++;
            if (!field.isAnnotationPresent(Deprecated.class) && Intrinsics.areEqual(field.getType(), String.class) && isAuthorized(coreConfiguration, field)) {
                try {
                    Object invoke = method.invoke(null, context.getContentResolver(), field.get(null));
                    if (invoke != null) {
                        jSONObject.put(field.getName(), invoke);
                    }
                } catch (Exception e) {
                    ACRA.log.mo60w(ACRA.LOG_TAG, ERROR, e);
                }
            }
        }
        return jSONObject;
    }

    private final boolean isAuthorized(CoreConfiguration coreConfiguration, Field field) {
        if (field != null) {
            String name = field.getName();
            Intrinsics.checkNotNullExpressionValue(name, "key.name");
            if (!StringsKt.startsWith$default(name, "WIFI_AP", false, 2, (Object) null)) {
                String[] excludeMatchingSettingsKeys = coreConfiguration.getExcludeMatchingSettingsKeys();
                int length = excludeMatchingSettingsKeys.length;
                int i = 0;
                while (i < length) {
                    String str = excludeMatchingSettingsKeys[i];
                    i++;
                    String name2 = field.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "key.name");
                    if (new Regex(str).matches(name2)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* compiled from: SettingsCollector.kt */
    @Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m107d2 = {"Lorg/acra/collector/SettingsCollector$Companion;", "", "()V", MediaError.ERROR_TYPE_ERROR, "", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
