package com.facebook.core.internal.logging.dumpsys;

import android.content.res.Resources;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.core.internal.logging.dumpsys.AndroidRootResolver;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class EndToEndDumpsysHelper {
    private static final String ALL_ROOTS_ARGUMENT = "all-roots";
    private static final String E2E_ARGUMENT = "e2e";
    private static final String LITHO_VIEW_CLASS = "com.facebook.litho.LithoView";
    private static final String LITHO_VIEW_TEST_HELPER_CLASS = "com.facebook.litho.LithoViewTestHelper";
    private static final String LITHO_VIEW_TO_STRING_METHOD = "viewToStringForE2E";
    private static final String RC_TEXT_VIEW_SIMPLE_CLASS_NAME = "RCTextView";
    private static final String TOP_ROOT_ARGUMENT = "top-root";
    private static final String WITH_PROPS_ARGUMENT = "props";
    private static final String WITH_WEBVIEW_ARGUMENT = "webview";
    private static EndToEndDumpsysHelper mInstance;
    private static Method sRcTextViewGetTextMethod;
    private Method mLithoViewToStringMethod;
    private final AndroidRootResolver mRootResolver = new AndroidRootResolver();
    private final WebViewDumpHelper mWebViewDumpHelper = new WebViewDumpHelper();

    public static boolean maybeDump(String str, PrintWriter printWriter, String[] strArr) {
        if (strArr == null || strArr.length <= 0 || !"e2e".equals(strArr[0])) {
            return false;
        }
        if (mInstance == null) {
            mInstance = new EndToEndDumpsysHelper();
        }
        mInstance.dumpViewHierarchy(str, printWriter, strArr);
        return true;
    }

    private void dumpViewHierarchy(String str, PrintWriter printWriter, String[] strArr) {
        String str2 = str;
        printWriter.print(str2);
        printWriter.println("Top Level Window View Hierarchy:");
        boolean hasArgument = hasArgument(strArr, ALL_ROOTS_ARGUMENT);
        boolean hasArgument2 = hasArgument(strArr, TOP_ROOT_ARGUMENT);
        boolean hasArgument3 = hasArgument(strArr, WITH_WEBVIEW_ARGUMENT);
        boolean hasArgument4 = hasArgument(strArr, WITH_PROPS_ARGUMENT);
        try {
            List<AndroidRootResolver.Root> listActiveRoots = this.mRootResolver.listActiveRoots();
            if (listActiveRoots != null && !listActiveRoots.isEmpty()) {
                Collections.reverse(listActiveRoots);
                WindowManager.LayoutParams layoutParams = null;
                for (AndroidRootResolver.Root root : listActiveRoots) {
                    if (root.view.getVisibility() == 0) {
                        if (!hasArgument && layoutParams != null && Math.abs(root.param.type - layoutParams.type) != 1) {
                            break;
                        }
                        dumpViewHierarchy(str2 + "  ", printWriter, root.view, 0, 0, hasArgument3, hasArgument4);
                        layoutParams = root.param;
                        if (hasArgument2) {
                            break;
                        }
                        str2 = str;
                    }
                }
                this.mWebViewDumpHelper.dump(printWriter);
            }
        } catch (Exception e) {
            printWriter.println("Failure in view hierarchy dump: " + e.getMessage());
        }
    }

    private void dumpViewHierarchy(String str, PrintWriter printWriter, View view, int i, int i2, boolean z, boolean z2) {
        ViewGroup viewGroup;
        int childCount;
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.print(view.getClass().getName());
        printWriter.print("{");
        printWriter.print(Integer.toHexString(view.hashCode()));
        writeViewFlags(printWriter, view);
        writeViewBounds(printWriter, view, i, i2);
        writeViewTestId(printWriter, view);
        writeViewText(printWriter, view);
        if (z2 && Build.VERSION.SDK_INT >= 21) {
            Api21Utils.writeExtraProps(printWriter, view);
        }
        printWriter.println("}");
        if (isExtendsLithoView(view)) {
            writeLithoViewSubHierarchy(printWriter, view, str, z2);
        }
        if (z && (view instanceof WebView)) {
            this.mWebViewDumpHelper.handle((WebView) view);
        }
        if ((view instanceof ViewGroup) && (childCount = (viewGroup = (ViewGroup) view).getChildCount()) > 0) {
            String str2 = str + "  ";
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            for (int i3 = 0; i3 < childCount; i3++) {
                dumpViewHierarchy(str2, printWriter, viewGroup.getChildAt(i3), iArr[0], iArr[1], z, z2);
            }
        }
    }

    private static boolean isExtendsLithoView(View view) {
        for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
            if (cls.getName().equals(LITHO_VIEW_CLASS)) {
                return true;
            }
        }
        return false;
    }

    private void writeLithoViewSubHierarchy(PrintWriter printWriter, View view, String str, boolean z) {
        try {
            if (this.mLithoViewToStringMethod == null) {
                this.mLithoViewToStringMethod = Class.forName(LITHO_VIEW_TEST_HELPER_CLASS).getDeclaredMethod(LITHO_VIEW_TO_STRING_METHOD, View.class, Integer.TYPE, Boolean.TYPE);
            }
            printWriter.append((CharSequence) ((String) this.mLithoViewToStringMethod.invoke(null, view, Integer.valueOf((str.length() / 2) + 1), Boolean.valueOf(z))));
        } catch (Exception e) {
            printWriter.append((CharSequence) str).append("Failed litho view sub hierarch dump: ").append((CharSequence) fixString(e.getMessage(), 100)).println();
        }
    }

    private static void writeViewFlags(PrintWriter printWriter, View view) {
        printWriter.print(" ");
        int visibility = view.getVisibility();
        String str = ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        if (visibility == 0) {
            printWriter.print(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        } else if (visibility == 4) {
            printWriter.print("I");
        } else if (visibility == 8) {
            printWriter.print("G");
        } else {
            printWriter.print(".");
        }
        printWriter.print(view.isFocusable() ? "F" : ".");
        printWriter.print(view.isEnabled() ? ExifInterface.LONGITUDE_EAST : ".");
        printWriter.print(".");
        printWriter.print(view.isHorizontalScrollBarEnabled() ? "H" : ".");
        if (!view.isVerticalScrollBarEnabled()) {
            str = ".";
        }
        printWriter.print(str);
        printWriter.print(view.isClickable() ? "C" : ".");
        printWriter.print(view.isLongClickable() ? "L" : ".");
        printWriter.print(" ");
        printWriter.print(view.isFocused() ? "F" : ".");
        printWriter.print(view.isSelected() ? ExifInterface.LATITUDE_SOUTH : ".");
        printWriter.print(view.isHovered() ? "H" : ".");
        printWriter.print(view.isActivated() ? ExifInterface.GPS_MEASUREMENT_IN_PROGRESS : ".");
        printWriter.print(view.isDirty() ? "D" : ".");
    }

    private static void writeViewBounds(PrintWriter printWriter, View view, int i, int i2) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        printWriter.print(" ");
        printWriter.print(iArr[0] - i);
        printWriter.print(",");
        printWriter.print(iArr[1] - i2);
        printWriter.print("-");
        printWriter.print((iArr[0] + view.getWidth()) - i);
        printWriter.print(",");
        printWriter.print((iArr[1] + view.getHeight()) - i2);
    }

    private static void writeViewTestId(PrintWriter printWriter, View view) {
        String str;
        try {
            int id = view.getId();
            if (id == -1) {
                maybeWriteViewTestIdFromTag(printWriter, view);
                return;
            }
            printWriter.append(" #");
            printWriter.append((CharSequence) Integer.toHexString(id));
            Resources resources = view.getResources();
            if (id > 0 && resources != null) {
                int i = (-16777216) & id;
                if (i != 16777216) {
                    str = i != 2130706432 ? resources.getResourcePackageName(id) : "app";
                } else {
                    str = "android";
                }
                printWriter.print(" ");
                printWriter.print(str);
                printWriter.print(":");
                printWriter.print(resources.getResourceTypeName(id));
                printWriter.print("/");
                printWriter.print(resources.getResourceEntryName(id));
                return;
            }
            maybeWriteViewTestIdFromTag(printWriter, view);
        } catch (Exception unused) {
            maybeWriteViewTestIdFromTag(printWriter, view);
        }
    }

    private static void maybeWriteViewTestIdFromTag(PrintWriter printWriter, View view) {
        Object tag = view.getTag();
        if (tag instanceof String) {
            String str = (String) tag;
            if (str.length() <= 0) {
                return;
            }
            printWriter.print(" app:tag/");
            printWriter.print(fixString(str, 60));
        }
    }

    private static void writeViewText(PrintWriter printWriter, View view) {
        Object tag;
        String trim;
        try {
            if (view instanceof TextView) {
                trim = ((TextView) view).getText().toString();
            } else if (view.getClass().getSimpleName().equals(RC_TEXT_VIEW_SIMPLE_CLASS_NAME)) {
                trim = getTextFromRcTextView(view);
            } else {
                CharSequence contentDescription = view.getContentDescription();
                String charSequence = contentDescription != null ? contentDescription.toString() : null;
                trim = ((charSequence == null || charSequence.isEmpty()) && (tag = view.getTag()) != null) ? tag.toString().trim() : charSequence;
            }
            if (trim != null && !trim.isEmpty()) {
                printWriter.print(" text=\"");
                printWriter.print(fixString(trim, 600));
                printWriter.print("\"");
            }
        } catch (Exception unused) {
        }
    }

    private static String getTextFromRcTextView(View view) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (sRcTextViewGetTextMethod == null) {
            sRcTextViewGetTextMethod = view.getClass().getDeclaredMethod("getText", new Class[0]);
        }
        Object invoke = sRcTextViewGetTextMethod.invoke(view, new Object[0]);
        if (invoke != null) {
            return invoke.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String fixString(CharSequence charSequence, int i) {
        if (charSequence == null || charSequence.length() < 1) {
            return "";
        }
        String replace = charSequence.toString().replace(" \n", " ").replace("\n", " ").replace("\"", "");
        if (charSequence.length() > i) {
            return replace.substring(0, i) + "...";
        }
        return replace;
    }

    private static boolean hasArgument(String[] strArr, String str) {
        if (strArr == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (str.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccessibilityNodeInfo createNodeInfoFromView(View view) {
        if (view == null) {
            return null;
        }
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
        try {
            view.onInitializeAccessibilityNodeInfo(obtain);
            return obtain;
        } catch (NullPointerException unused) {
            if (obtain != null) {
                obtain.recycle();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Api21Utils {
        private static Field mKeyedTagsField;

        private Api21Utils() {
        }

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mKeyedTags");
                mKeyedTagsField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
        }

        static void writeExtraProps(PrintWriter printWriter, View view) {
            AccessibilityNodeInfo createNodeInfoFromView;
            if (Build.VERSION.SDK_INT >= 21 && (createNodeInfoFromView = EndToEndDumpsysHelper.createNodeInfoFromView(view)) != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (view instanceof TextView) {
                        TextView textView = (TextView) view;
                        jSONObject.put("textColor", textView.getTextColors().getDefaultColor());
                        jSONObject.put("textSize", textView.getTextSize());
                        jSONObject.put(ViewHierarchyConstants.HINT_KEY, EndToEndDumpsysHelper.fixString(textView.getHint(), 100));
                    }
                    JSONObject tags = getTags(view);
                    if (tags != null) {
                        jSONObject.put("keyedTags", tags);
                    }
                    JSONArray jSONArray = new JSONArray();
                    for (AccessibilityNodeInfo.AccessibilityAction accessibilityAction : createNodeInfoFromView.getActionList()) {
                        String str = (String) accessibilityAction.getLabel();
                        if (str != null) {
                            jSONArray.put(EndToEndDumpsysHelper.fixString(str, 50));
                        }
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("actions", jSONArray);
                    }
                    String fixString = EndToEndDumpsysHelper.fixString(createNodeInfoFromView.getContentDescription(), 50);
                    if (fixString != null && fixString.length() > 0) {
                        jSONObject.put("content-description", fixString);
                    }
                    jSONObject.put("accessibility-focused", createNodeInfoFromView.isAccessibilityFocused()).put("checkable", createNodeInfoFromView.isCheckable()).put("checked", createNodeInfoFromView.isChecked()).put("class-name", EndToEndDumpsysHelper.fixString(createNodeInfoFromView.getClassName(), 50)).put("clickable", createNodeInfoFromView.isClickable()).put("content-invalid", createNodeInfoFromView.isContentInvalid()).put("dismissable", createNodeInfoFromView.isDismissable()).put("editable", createNodeInfoFromView.isEditable()).put("enabled", createNodeInfoFromView.isEnabled()).put("focusable", createNodeInfoFromView.isFocusable()).put("focused", createNodeInfoFromView.isFocused()).put("long-clickable", createNodeInfoFromView.isLongClickable()).put("multiline", createNodeInfoFromView.isMultiLine()).put("password", createNodeInfoFromView.isPassword()).put("scrollable", createNodeInfoFromView.isScrollable()).put("selected", createNodeInfoFromView.isSelected()).put("visible-to-user", createNodeInfoFromView.isVisibleToUser());
                    if (Build.VERSION.SDK_INT >= 24) {
                        Api24Utils.addExtraProps(jSONObject, createNodeInfoFromView);
                    }
                } catch (Exception e) {
                    try {
                        jSONObject.put("DUMP-ERROR", EndToEndDumpsysHelper.fixString(e.getMessage(), 50));
                    } catch (JSONException unused) {
                    }
                }
                printWriter.append(" props=\"").append((CharSequence) jSONObject.toString()).append("\"");
            }
        }

        private static JSONObject getTags(View view) {
            try {
                if (mKeyedTagsField == null) {
                    Field declaredField = View.class.getDeclaredField("mKeyedTags");
                    mKeyedTagsField = declaredField;
                    declaredField.setAccessible(true);
                }
                SparseArray sparseArray = (SparseArray) mKeyedTagsField.get(view);
                if (sparseArray == null || sparseArray.size() <= 0) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    int size = sparseArray.size();
                    for (int i = 0; i < size; i++) {
                        try {
                            jSONObject.put(ResourcesUtil.getIdStringQuietly(view.getContext(), view.getResources(), sparseArray.keyAt(i)), sparseArray.valueAt(i));
                        } catch (JSONException unused) {
                        }
                    }
                } catch (Exception unused2) {
                }
                return jSONObject;
            } catch (Exception unused3) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Api24Utils {
        private Api24Utils() {
        }

        static void addExtraProps(JSONObject jSONObject, AccessibilityNodeInfo accessibilityNodeInfo) throws JSONException {
            if (Build.VERSION.SDK_INT < 24) {
                return;
            }
            jSONObject.put("context-clickable", accessibilityNodeInfo.isContextClickable()).put("drawing-order", accessibilityNodeInfo.getDrawingOrder()).put("important-for-accessibility", accessibilityNodeInfo.isImportantForAccessibility());
        }
    }
}
