package org.acra.collector;

import android.content.Context;
import android.content.res.Configuration;
import android.util.SparseArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ConfigurationCollector.kt */
@Metadata(m108d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0002%&B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J0\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J2\u0010\u001d\u001a\u00020\u001e2\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\t0 2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0002J\u001a\u0010$\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\t0 H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, m107d2 = {"Lorg/acra/collector/ConfigurationCollector;", "Lorg/acra/collector/BaseReportFieldCollector;", "Lorg/acra/collector/ApplicationStartupCollector;", "()V", "initialConfiguration", "Lorg/json/JSONObject;", "activeFlags", "", "valueNames", "Landroid/util/SparseArray;", "bitfield", "", "collect", "", "reportField", "Lorg/acra/ReportField;", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "reportBuilder", "Lorg/acra/builder/ReportBuilder;", TypedValues.AttributesType.S_TARGET, "Lorg/acra/data/CrashReportData;", "collectApplicationStartUp", "collectConfiguration", "configToJson", "conf", "Landroid/content/res/Configuration;", "getFieldValueName", "", "valueArrays", "", "Lorg/acra/collector/ConfigurationCollector$Prefix;", "f", "Ljava/lang/reflect/Field;", "getValueArrays", "Companion", "Prefix", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public class ConfigurationCollector extends BaseReportFieldCollector implements ApplicationStartupCollector {
    public static final Companion Companion = new Companion(null);
    private static final String FIELD_MCC = "mcc";
    private static final String FIELD_MNC = "mnc";
    private static final String FIELD_SCREENLAYOUT = "screenLayout";
    private static final String FIELD_UIMODE = "uiMode";
    private static final String SUFFIX_MASK = "_MASK";
    private JSONObject initialConfiguration;

    /* compiled from: ConfigurationCollector.kt */
    @Metadata(m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReportField.valuesCustom().length];
            iArr[ReportField.INITIAL_CONFIGURATION.ordinal()] = 1;
            iArr[ReportField.CRASH_CONFIGURATION.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ConfigurationCollector() {
        super(ReportField.INITIAL_CONFIGURATION, ReportField.CRASH_CONFIGURATION);
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    public void collect(ReportField reportField, Context context, CoreConfiguration config, ReportBuilder reportBuilder, CrashReportData target) {
        Intrinsics.checkNotNullParameter(reportField, "reportField");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        Intrinsics.checkNotNullParameter(target, "target");
        int i = WhenMappings.$EnumSwitchMapping$0[reportField.ordinal()];
        if (i == 1) {
            target.put(ReportField.INITIAL_CONFIGURATION, this.initialConfiguration);
        } else if (i == 2) {
            target.put(ReportField.CRASH_CONFIGURATION, collectConfiguration(context));
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override // org.acra.collector.ApplicationStartupCollector
    public void collectApplicationStartUp(Context context, CoreConfiguration config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        if (config.getReportContent().contains(ReportField.INITIAL_CONFIGURATION)) {
            this.initialConfiguration = collectConfiguration(context);
        }
    }

    private final JSONObject configToJson(Configuration configuration) {
        JSONObject jSONObject = new JSONObject();
        Map<Prefix, SparseArray<String>> valueArrays = getValueArrays();
        Field[] fields = configuration.getClass().getFields();
        Intrinsics.checkNotNullExpressionValue(fields, "conf.javaClass.fields");
        int length = fields.length;
        int i = 0;
        while (i < length) {
            Field f = fields[i];
            i++;
            try {
                if (!Modifier.isStatic(f.getModifiers())) {
                    String name = f.getName();
                    try {
                        if (Intrinsics.areEqual(f.getType(), Integer.TYPE)) {
                            Intrinsics.checkNotNullExpressionValue(f, "f");
                            jSONObject.put(name, getFieldValueName(valueArrays, configuration, f));
                        } else if (f.get(configuration) != null) {
                            jSONObject.put(name, f.get(configuration));
                        }
                    } catch (JSONException e) {
                        ACRA.log.mo60w(ACRA.LOG_TAG, Intrinsics.stringPlus("Could not collect configuration field ", name), e);
                    }
                }
            } catch (IllegalAccessException e2) {
                ACRA.log.mo66e(ACRA.LOG_TAG, "Error while inspecting device configuration: ", e2);
            } catch (IllegalArgumentException e3) {
                ACRA.log.mo66e(ACRA.LOG_TAG, "Error while inspecting device configuration: ", e3);
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0138 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0102 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.Map<org.acra.collector.ConfigurationCollector.Prefix, android.util.SparseArray<java.lang.String>> getValueArrays() {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.acra.collector.ConfigurationCollector.getValueArrays():java.util.Map");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r0.equals(org.acra.collector.ConfigurationCollector.FIELD_MCC) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:
        return java.lang.Integer.valueOf(r12.getInt(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
        if (r0.equals(org.acra.collector.ConfigurationCollector.FIELD_MNC) == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Object getFieldValueName(java.util.Map<org.acra.collector.ConfigurationCollector.Prefix, ? extends android.util.SparseArray<java.lang.String>> r10, android.content.res.Configuration r11, java.lang.reflect.Field r12) throws java.lang.IllegalAccessException {
        /*
            r9 = this;
            java.lang.String r0 = r12.getName()
            if (r0 == 0) goto L5f
            int r1 = r0.hashCode()
            switch(r1) {
                case -1896438090: goto L45;
                case -845983145: goto L2a;
                case 107917: goto L17;
                case 108258: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L5f
        Le:
            java.lang.String r1 = "mnc"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L20
            goto L5f
        L17:
            java.lang.String r1 = "mcc"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L20
            goto L5f
        L20:
            int r10 = r12.getInt(r11)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            goto Lbd
        L2a:
            java.lang.String r1 = "uiMode"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L33
            goto L5f
        L33:
            org.acra.collector.ConfigurationCollector$Prefix r0 = org.acra.collector.ConfigurationCollector.Prefix.UI_MODE
            java.lang.Object r10 = kotlin.collections.MapsKt.getValue(r10, r0)
            android.util.SparseArray r10 = (android.util.SparseArray) r10
            int r11 = r12.getInt(r11)
            java.lang.String r10 = r9.activeFlags(r10, r11)
            goto Lbd
        L45:
            java.lang.String r1 = "screenLayout"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L4e
            goto L5f
        L4e:
            org.acra.collector.ConfigurationCollector$Prefix r0 = org.acra.collector.ConfigurationCollector.Prefix.SCREENLAYOUT
            java.lang.Object r10 = kotlin.collections.MapsKt.getValue(r10, r0)
            android.util.SparseArray r10 = (android.util.SparseArray) r10
            int r11 = r12.getInt(r11)
            java.lang.String r10 = r9.activeFlags(r10, r11)
            goto Lbd
        L5f:
            org.acra.collector.ConfigurationCollector$Prefix[] r1 = org.acra.collector.ConfigurationCollector.Prefix.valuesCustom()
            int r2 = r1.length
            r3 = 0
        L65:
            r4 = 0
            if (r3 >= r2) goto L93
            r5 = r1[r3]
            java.lang.String r6 = r5.getText()
            java.lang.String r7 = "fieldName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r7)
            java.util.Locale r7 = java.util.Locale.ROOT
            java.lang.String r8 = "ROOT"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            java.lang.String r7 = r0.toUpperCase(r7)
            java.lang.String r8 = "(this as java.lang.String).toUpperCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            java.lang.String r8 = "_"
            java.lang.String r7 = kotlin.jvm.internal.Intrinsics.stringPlus(r7, r8)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
            if (r6 == 0) goto L90
            goto L94
        L90:
            int r3 = r3 + 1
            goto L65
        L93:
            r5 = r4
        L94:
            if (r5 != 0) goto L97
            goto L9e
        L97:
            java.lang.Object r10 = kotlin.collections.MapsKt.getValue(r10, r5)
            r4 = r10
            android.util.SparseArray r4 = (android.util.SparseArray) r4
        L9e:
            if (r4 != 0) goto La9
            int r10 = r12.getInt(r11)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            return r10
        La9:
            int r10 = r12.getInt(r11)
            java.lang.Object r10 = r4.get(r10)
            java.lang.String r10 = (java.lang.String) r10
            if (r10 != 0) goto Lbd
            int r10 = r12.getInt(r11)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
        Lbd:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.acra.collector.ConfigurationCollector.getFieldValueName(java.util.Map, android.content.res.Configuration, java.lang.reflect.Field):java.lang.Object");
    }

    private final String activeFlags(SparseArray<String> sparseArray, int i) {
        int i2;
        StringBuilder sb = new StringBuilder();
        int size = sparseArray.size();
        if (size > 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                int keyAt = sparseArray.keyAt(i3);
                String str = sparseArray.get(keyAt);
                Intrinsics.checkNotNullExpressionValue(str, "valueNames[maskValue]");
                if (StringsKt.endsWith$default(str, SUFFIX_MASK, false, 2, (Object) null) && (i2 = keyAt & i) > 0) {
                    if (sb.length() > 0) {
                        sb.append('+');
                    }
                    sb.append(sparseArray.get(i2));
                }
                if (i4 >= size) {
                    break;
                }
                i3 = i4;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "result.toString()");
        return sb2;
    }

    private final JSONObject collectConfiguration(Context context) {
        try {
            Configuration configuration = context.getResources().getConfiguration();
            Intrinsics.checkNotNullExpressionValue(configuration, "context.resources.configuration");
            return configToJson(configuration);
        } catch (RuntimeException e) {
            ACRA.log.mo60w(ACRA.LOG_TAG, Intrinsics.stringPlus("Couldn't retrieve CrashConfiguration for : ", context.getPackageName()), e);
            return null;
        }
    }

    /* compiled from: ConfigurationCollector.kt */
    @Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, m107d2 = {"Lorg/acra/collector/ConfigurationCollector$Prefix;", "", "text", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getText", "()Ljava/lang/String;", "UI_MODE", "TOUCHSCREEN", "SCREENLAYOUT", "ORIENTATION", "NAVIGATIONHIDDEN", "NAVIGATION", "KEYBOARDHIDDEN", "KEYBOARD", "HARDKEYBOARDHIDDEN", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public enum Prefix {
        UI_MODE("UI_MODE_"),
        TOUCHSCREEN("TOUCHSCREEN_"),
        SCREENLAYOUT("SCREENLAYOUT_"),
        ORIENTATION("ORIENTATION_"),
        NAVIGATIONHIDDEN("NAVIGATIONHIDDEN_"),
        NAVIGATION("NAVIGATION_"),
        KEYBOARDHIDDEN("KEYBOARDHIDDEN_"),
        KEYBOARD("KEYBOARD_"),
        HARDKEYBOARDHIDDEN("HARDKEYBOARDHIDDEN_");
        
        private final String text;

        Prefix(String str) {
            this.text = str;
        }

        public final String getText() {
            return this.text;
        }

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Prefix[] valuesCustom() {
            Prefix[] valuesCustom = values();
            return (Prefix[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    /* compiled from: ConfigurationCollector.kt */
    @Metadata(m108d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, m107d2 = {"Lorg/acra/collector/ConfigurationCollector$Companion;", "", "()V", "FIELD_MCC", "", "FIELD_MNC", "FIELD_SCREENLAYOUT", "FIELD_UIMODE", "SUFFIX_MASK", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
