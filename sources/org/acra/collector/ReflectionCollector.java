package org.acra.collector;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ReflectionCollector.kt */
@Metadata(m108d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001c\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u0016"}, m107d2 = {"Lorg/acra/collector/ReflectionCollector;", "Lorg/acra/collector/BaseReportFieldCollector;", "()V", "collect", "", "reportField", "Lorg/acra/ReportField;", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "reportBuilder", "Lorg/acra/builder/ReportBuilder;", TypedValues.AttributesType.S_TARGET, "Lorg/acra/data/CrashReportData;", "collectStaticGettersResults", "someClass", "Ljava/lang/Class;", TtmlNode.RUBY_CONTAINER, "Lorg/json/JSONObject;", "getBuildConfigClass", "Companion", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public class ReflectionCollector extends BaseReportFieldCollector {
    public static final Companion Companion = new Companion(null);

    /* compiled from: ReflectionCollector.kt */
    @Metadata(m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReportField.valuesCustom().length];
            iArr[ReportField.BUILD.ordinal()] = 1;
            iArr[ReportField.BUILD_CONFIG.ordinal()] = 2;
            iArr[ReportField.ENVIRONMENT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ReflectionCollector() {
        super(ReportField.BUILD, ReportField.BUILD_CONFIG, ReportField.ENVIRONMENT);
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    public void collect(ReportField reportField, Context context, CoreConfiguration config, ReportBuilder reportBuilder, CrashReportData target) throws JSONException, ClassNotFoundException {
        Intrinsics.checkNotNullParameter(reportField, "reportField");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        Intrinsics.checkNotNullParameter(target, "target");
        JSONObject jSONObject = new JSONObject();
        int i = WhenMappings.$EnumSwitchMapping$0[reportField.ordinal()];
        if (i == 1) {
            Companion companion = Companion;
            companion.collectConstants(Build.class, jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            companion.collectConstants(Build.VERSION.class, jSONObject2);
            jSONObject.put("VERSION", jSONObject2);
        } else if (i == 2) {
            Companion.collectConstants(getBuildConfigClass(context, config), jSONObject);
        } else if (i == 3) {
            collectStaticGettersResults(Environment.class, jSONObject);
        } else {
            throw new IllegalArgumentException();
        }
        target.put(reportField, jSONObject);
    }

    private final void collectStaticGettersResults(Class<?> cls, JSONObject jSONObject) throws JSONException {
        Method[] methods = cls.getMethods();
        Intrinsics.checkNotNullExpressionValue(methods, "methods");
        int length = methods.length;
        int i = 0;
        while (i < length) {
            Method method = methods[i];
            i++;
            Class<?>[] parameterTypes = method.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(parameterTypes, "method.parameterTypes");
            if (parameterTypes.length == 0) {
                String name = method.getName();
                Intrinsics.checkNotNullExpressionValue(name, "method.name");
                if (!StringsKt.startsWith$default(name, "get", false, 2, (Object) null)) {
                    String name2 = method.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "method.name");
                    if (StringsKt.startsWith$default(name2, "is", false, 2, (Object) null)) {
                    }
                }
                if (!Intrinsics.areEqual("getClass", method.getName())) {
                    try {
                        jSONObject.put(method.getName(), method.invoke(null, new Object[0]));
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                    }
                }
            }
        }
    }

    private final Class<?> getBuildConfigClass(Context context, CoreConfiguration coreConfiguration) throws ClassNotFoundException {
        Class<?> buildConfigClass = coreConfiguration.getBuildConfigClass();
        if (Intrinsics.areEqual(buildConfigClass, Object.class)) {
            Class<?> cls = Class.forName(Intrinsics.stringPlus(context.getPackageName(), ".BuildConfig"));
            Intrinsics.checkNotNullExpressionValue(cls, "forName(className)");
            return cls;
        }
        return buildConfigClass;
    }

    /* compiled from: ReflectionCollector.kt */
    @Metadata(m108d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\t"}, m107d2 = {"Lorg/acra/collector/ReflectionCollector$Companion;", "", "()V", "collectConstants", "", "someClass", "Ljava/lang/Class;", TtmlNode.RUBY_CONTAINER, "Lorg/json/JSONObject;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void collectConstants(Class<?> cls, JSONObject jSONObject) throws JSONException {
            Field[] fields = cls.getFields();
            Intrinsics.checkNotNullExpressionValue(fields, "fields");
            int length = fields.length;
            int i = 0;
            while (i < length) {
                Field field = fields[i];
                i++;
                try {
                    Object obj = field.get(null);
                    if (obj != null) {
                        if (field.getType().isArray()) {
                            Object[] objArr = (Object[]) obj;
                            jSONObject.put(field.getName(), new JSONArray((Collection) CollectionsKt.listOf(Arrays.copyOf(objArr, objArr.length))));
                        } else {
                            jSONObject.put(field.getName(), obj);
                        }
                    }
                } catch (IllegalAccessException | IllegalArgumentException unused) {
                }
            }
        }
    }
}
