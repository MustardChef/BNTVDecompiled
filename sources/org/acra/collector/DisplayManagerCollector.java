package org.acra.collector;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.Key;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DisplayManagerCollector.kt */
@Metadata(m108d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J0\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010 \u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010!\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010#\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010$\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010%\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001b\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00170'2\u0006\u0010\r\u001a\u00020\u000eH\u0002¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\bH\u0002¨\u0006+"}, m107d2 = {"Lorg/acra/collector/DisplayManagerCollector;", "Lorg/acra/collector/BaseReportFieldCollector;", "()V", "activeFlags", "", "flagNames", "Landroid/util/SparseArray;", "bitfield", "", "collect", "", "reportField", "Lorg/acra/ReportField;", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "reportBuilder", "Lorg/acra/builder/ReportBuilder;", TypedValues.AttributesType.S_TARGET, "Lorg/acra/data/CrashReportData;", "collectCurrentSizeRange", "display", "Landroid/view/Display;", TtmlNode.RUBY_CONTAINER, "Lorg/json/JSONObject;", "collectDisplayData", "collectFlags", "collectIsValid", "collectMetrics", "metrics", "Landroid/util/DisplayMetrics;", "collectName", "collectRealMetrics", "collectRealSize", "collectRectSize", "collectRotation", "collectSize", "getDisplays", "", "(Landroid/content/Context;)[Landroid/view/Display;", "rotationToString", Key.ROTATION, "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public class DisplayManagerCollector extends BaseReportFieldCollector {
    public DisplayManagerCollector() {
        super(ReportField.DISPLAY);
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    public void collect(ReportField reportField, Context context, CoreConfiguration config, ReportBuilder reportBuilder, CrashReportData target) {
        Intrinsics.checkNotNullParameter(reportField, "reportField");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        Intrinsics.checkNotNullParameter(target, "target");
        JSONObject jSONObject = new JSONObject();
        Display[] displays = getDisplays(context);
        int length = displays.length;
        int i = 0;
        while (i < length) {
            Display display = displays[i];
            i++;
            try {
                jSONObject.put(String.valueOf(display.getDisplayId()), collectDisplayData(display));
            } catch (JSONException e) {
                ACRA.log.mo60w(ACRA.LOG_TAG, Intrinsics.stringPlus("Failed to collect data for display ", Integer.valueOf(display.getDisplayId())), e);
            }
        }
        target.put(ReportField.DISPLAY, jSONObject);
    }

    private final Display[] getDisplays(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            Object systemService = context.getSystemService("display");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
            Display[] displays = ((DisplayManager) systemService).getDisplays();
            Intrinsics.checkNotNullExpressionValue(displays, "{\n            (context.getSystemService(Context.DISPLAY_SERVICE) as DisplayManager).displays\n        }");
            return displays;
        }
        Object systemService2 = context.getSystemService("window");
        Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService2).getDefaultDisplay();
        Intrinsics.checkNotNullExpressionValue(defaultDisplay, "context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay");
        return new Display[]{defaultDisplay};
    }

    private final JSONObject collectDisplayData(Display display) throws JSONException {
        display.getMetrics(new DisplayMetrics());
        JSONObject jSONObject = new JSONObject();
        collectCurrentSizeRange(display, jSONObject);
        collectFlags(display, jSONObject);
        collectMetrics(display, jSONObject);
        collectRealMetrics(display, jSONObject);
        collectName(display, jSONObject);
        collectRealSize(display, jSONObject);
        collectRectSize(display, jSONObject);
        collectSize(display, jSONObject);
        collectRotation(display, jSONObject);
        collectIsValid(display, jSONObject);
        jSONObject.put("orientation", display.getRotation()).put("refreshRate", display.getRefreshRate()).put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, display.getHeight()).put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, display.getWidth()).put("pixelFormat", display.getPixelFormat());
        return jSONObject;
    }

    private final void collectIsValid(Display display, JSONObject jSONObject) throws JSONException {
        if (Build.VERSION.SDK_INT >= 17) {
            jSONObject.put("isValid", display.isValid());
        }
    }

    private final void collectRotation(Display display, JSONObject jSONObject) throws JSONException {
        jSONObject.put(Key.ROTATION, rotationToString(display.getRotation()));
    }

    private final String rotationToString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? String.valueOf(i) : "ROTATION_270" : "ROTATION_180" : "ROTATION_90" : "ROTATION_0";
    }

    private final void collectRectSize(Display display, JSONObject jSONObject) throws JSONException {
        Rect rect = new Rect();
        display.getRectSize(rect);
        jSONObject.put("rectSize", new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(rect.top), Integer.valueOf(rect.left), Integer.valueOf(rect.width()), Integer.valueOf(rect.height())})));
    }

    private final void collectSize(Display display, JSONObject jSONObject) throws JSONException {
        Point point = new Point();
        display.getSize(point);
        jSONObject.put("size", new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(point.x), Integer.valueOf(point.y)})));
    }

    private final void collectRealSize(Display display, JSONObject jSONObject) throws JSONException {
        if (Build.VERSION.SDK_INT >= 17) {
            Point point = new Point();
            display.getRealSize(point);
            jSONObject.put("realSize", new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(point.x), Integer.valueOf(point.y)})));
        }
    }

    private final void collectCurrentSizeRange(Display display, JSONObject jSONObject) throws JSONException {
        if (Build.VERSION.SDK_INT >= 16) {
            Point point = new Point();
            Point point2 = new Point();
            display.getCurrentSizeRange(point, point2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("smallest", new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(point.x), Integer.valueOf(point.y)})));
            jSONObject2.put("largest", new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(point2.x), Integer.valueOf(point2.y)})));
            jSONObject.put("currentSizeRange", jSONObject2);
        }
    }

    private final void collectFlags(Display display, JSONObject jSONObject) throws JSONException {
        if (Build.VERSION.SDK_INT >= 17) {
            SparseArray<String> sparseArray = new SparseArray<>();
            int flags = display.getFlags();
            Field[] fields = display.getClass().getFields();
            Intrinsics.checkNotNullExpressionValue(fields, "display.javaClass.fields");
            int length = fields.length;
            int i = 0;
            while (i < length) {
                Field field = fields[i];
                i++;
                String name = field.getName();
                Intrinsics.checkNotNullExpressionValue(name, "field.name");
                if (StringsKt.startsWith$default(name, "FLAG_", false, 2, (Object) null)) {
                    try {
                        sparseArray.put(field.getInt(null), field.getName());
                    } catch (IllegalAccessException unused) {
                    }
                }
            }
            jSONObject.put("flags", activeFlags(sparseArray, flags));
        }
    }

    private final void collectName(Display display, JSONObject jSONObject) throws JSONException {
        if (Build.VERSION.SDK_INT >= 17) {
            jSONObject.put("name", display.getName());
        }
    }

    private final void collectMetrics(Display display, JSONObject jSONObject) throws JSONException {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        JSONObject jSONObject2 = new JSONObject();
        collectMetrics(displayMetrics, jSONObject2);
        jSONObject.put("metrics", jSONObject2);
    }

    private final void collectRealMetrics(Display display, JSONObject jSONObject) throws JSONException {
        if (Build.VERSION.SDK_INT >= 17) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            display.getRealMetrics(displayMetrics);
            JSONObject jSONObject2 = new JSONObject();
            collectMetrics(displayMetrics, jSONObject2);
            jSONObject.put("realMetrics", jSONObject2);
        }
    }

    private final void collectMetrics(DisplayMetrics displayMetrics, JSONObject jSONObject) throws JSONException {
        jSONObject.put("density", displayMetrics.density).put("densityDpi", displayMetrics.densityDpi).put("scaledDensity", Intrinsics.stringPlus("x", Float.valueOf(displayMetrics.scaledDensity))).put("widthPixels", displayMetrics.widthPixels).put("heightPixels", displayMetrics.heightPixels).put("xdpi", displayMetrics.xdpi).put("ydpi", displayMetrics.ydpi);
    }

    private final String activeFlags(SparseArray<String> sparseArray, int i) {
        StringBuilder sb = new StringBuilder();
        int size = sparseArray.size();
        if (size > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                int keyAt = sparseArray.keyAt(i2) & i;
                if (keyAt > 0) {
                    if (sb.length() > 0) {
                        sb.append('+');
                    }
                    sb.append(sparseArray.get(keyAt));
                }
                if (i3 >= size) {
                    break;
                }
                i2 = i3;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "result.toString()");
        return sb2;
    }
}
