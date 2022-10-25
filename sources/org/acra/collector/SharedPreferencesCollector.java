package org.acra.collector;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.acra.prefs.SharedPreferencesFactory;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SharedPreferencesCollector.kt */
@Metadata(m108d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J0\u0010\u0003\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¨\u0006\u0014"}, m107d2 = {"Lorg/acra/collector/SharedPreferencesCollector;", "Lorg/acra/collector/BaseReportFieldCollector;", "()V", "collect", "Lorg/json/JSONObject;", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "", "reportField", "Lorg/acra/ReportField;", "reportBuilder", "Lorg/acra/builder/ReportBuilder;", TypedValues.AttributesType.S_TARGET, "Lorg/acra/data/CrashReportData;", "filteredKey", "", SDKConstants.PARAM_KEY, "", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public class SharedPreferencesCollector extends BaseReportFieldCollector {

    /* compiled from: SharedPreferencesCollector.kt */
    @Metadata(m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReportField.valuesCustom().length];
            iArr[ReportField.USER_EMAIL.ordinal()] = 1;
            iArr[ReportField.SHARED_PREFERENCES.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SharedPreferencesCollector() {
        super(ReportField.USER_EMAIL, ReportField.SHARED_PREFERENCES);
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
            target.put(ReportField.USER_EMAIL, new SharedPreferencesFactory(context, config).create().getString(ACRA.PREF_USER_EMAIL_ADDRESS, null));
        } else if (i == 2) {
            target.put(ReportField.SHARED_PREFERENCES, collect(context, config));
        } else {
            throw new IllegalArgumentException();
        }
    }

    private final JSONObject collect(Context context, CoreConfiguration coreConfiguration) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        TreeMap treeMap = new TreeMap();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(context)");
        treeMap.put(MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY, defaultSharedPreferences);
        String[] additionalSharedPreferences = coreConfiguration.getAdditionalSharedPreferences();
        int length = additionalSharedPreferences.length;
        int i = 0;
        while (i < length) {
            String str = additionalSharedPreferences[i];
            i++;
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPreferences(sharedPrefId, Context.MODE_PRIVATE)");
            treeMap.put(str, sharedPreferences);
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String str2 = (String) entry.getKey();
            Map<String, ?> all = ((SharedPreferences) entry.getValue()).getAll();
            if (all.isEmpty()) {
                jSONObject.put(str2, "empty");
            } else {
                Iterator<String> it = all.keySet().iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                    if (filteredKey(coreConfiguration, next)) {
                        it.remove();
                    }
                }
                jSONObject.put(str2, new JSONObject(all));
            }
        }
        return jSONObject;
    }

    private final boolean filteredKey(CoreConfiguration coreConfiguration, String str) {
        String[] excludeMatchingSharedPreferencesKeys = coreConfiguration.getExcludeMatchingSharedPreferencesKeys();
        int length = excludeMatchingSharedPreferencesKeys.length;
        int i = 0;
        while (i < length) {
            String str2 = excludeMatchingSharedPreferencesKeys[i];
            i++;
            if (new Regex(str2).matches(str)) {
                return true;
            }
        }
        return false;
    }
}
