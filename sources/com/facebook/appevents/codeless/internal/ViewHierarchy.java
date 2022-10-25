package com.facebook.appevents.codeless.internal;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ViewHierarchy {
    private static final String CLASS_RCTROOTVIEW = "com.facebook.react.ReactRootView";
    private static final String CLASS_RCTTEXTVIEW = "com.facebook.react.views.view.ReactTextView";
    private static final String CLASS_RCTVIEWGROUP = "com.facebook.react.views.view.ReactViewGroup";
    private static final String CLASS_TOUCHTARGETHELPER = "com.facebook.react.uimanager.TouchTargetHelper";
    private static final int ICON_MAX_EDGE_LENGTH = 44;
    private static final String METHOD_FIND_TOUCHTARGET_VIEW = "findTouchTargetView";
    private static final String TAG = "com.facebook.appevents.codeless.internal.ViewHierarchy";
    private static WeakReference<View> RCTRootViewReference = new WeakReference<>(null);
    private static Method methodFindTouchTargetView = null;

    public static ViewGroup getParentOfView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class) || view == null) {
            return null;
        }
        try {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                return (ViewGroup) parent;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    public static List<View> getChildrenOfView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    arrayList.add(viewGroup.getChildAt(i));
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    public static void updateBasicInfoOfView(View view, JSONObject jSONObject) {
        try {
            if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
                return;
            }
            try {
                String textOfView = getTextOfView(view);
                String hintOfView = getHintOfView(view);
                Object tag = view.getTag();
                CharSequence contentDescription = view.getContentDescription();
                jSONObject.put(ViewHierarchyConstants.CLASS_NAME_KEY, view.getClass().getCanonicalName());
                jSONObject.put(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY, getClassTypeBitmask(view));
                jSONObject.put("id", view.getId());
                if (!SensitiveUserDataUtils.isSensitiveUserData(view)) {
                    jSONObject.put("text", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(textOfView), ""));
                } else {
                    jSONObject.put("text", "");
                    jSONObject.put(ViewHierarchyConstants.IS_USER_INPUT_KEY, true);
                }
                jSONObject.put(ViewHierarchyConstants.HINT_KEY, Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(hintOfView), ""));
                if (tag != null) {
                    jSONObject.put(ViewHierarchyConstants.TAG_KEY, Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(tag.toString()), ""));
                }
                if (contentDescription != null) {
                    jSONObject.put("description", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(contentDescription.toString()), ""));
                }
                jSONObject.put("dimension", getDimensionOfView(view));
            } catch (JSONException e) {
                Utility.logd(TAG, e);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
        }
    }

    public static void updateAppearanceOfView(View view, JSONObject jSONObject, float f) {
        Bitmap bitmap;
        TextView textView;
        Typeface typeface;
        try {
            if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                if ((view instanceof TextView) && (typeface = (textView = (TextView) view).getTypeface()) != null) {
                    jSONObject2.put(ViewHierarchyConstants.TEXT_SIZE, textView.getTextSize());
                    jSONObject2.put(ViewHierarchyConstants.TEXT_IS_BOLD, typeface.isBold());
                    jSONObject2.put(ViewHierarchyConstants.TEXT_IS_ITALIC, typeface.isItalic());
                    jSONObject.put(ViewHierarchyConstants.TEXT_STYLE, jSONObject2);
                }
                if (view instanceof ImageView) {
                    Drawable drawable = ((ImageView) view).getDrawable();
                    if (!(drawable instanceof BitmapDrawable) || view.getHeight() / f > 44.0f || view.getWidth() / f > 44.0f || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null) {
                        return;
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    jSONObject.put(ViewHierarchyConstants.ICON_BITMAP, Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
                }
            } catch (JSONException e) {
                Utility.logd(TAG, e);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
        }
    }

    public static JSONObject getDictionaryOfView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            if (view.getClass().getName().equals(CLASS_RCTROOTVIEW)) {
                RCTRootViewReference = new WeakReference<>(view);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                updateBasicInfoOfView(view, jSONObject);
                JSONArray jSONArray = new JSONArray();
                List<View> childrenOfView = getChildrenOfView(view);
                for (int i = 0; i < childrenOfView.size(); i++) {
                    jSONArray.put(getDictionaryOfView(childrenOfView.get(i)));
                }
                jSONObject.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, jSONArray);
            } catch (JSONException e) {
                Log.e(TAG, "Failed to create JSONObject for view.", e);
            }
            return jSONObject;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    public static int getClassTypeBitmask(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return 0;
        }
        try {
            int i = view instanceof ImageView ? 2 : 0;
            if (view.isClickable()) {
                i |= 32;
            }
            if (isAdapterViewItem(view)) {
                i |= 512;
            }
            if (view instanceof TextView) {
                int i2 = i | 1024 | 1;
                if (view instanceof Button) {
                    i2 |= 4;
                    if (view instanceof Switch) {
                        i2 |= 8192;
                    } else if (view instanceof CheckBox) {
                        i2 |= 32768;
                    }
                }
                return view instanceof EditText ? i2 | 2048 : i2;
            }
            if (!(view instanceof Spinner) && !(view instanceof DatePicker)) {
                return view instanceof RatingBar ? i | 65536 : view instanceof RadioGroup ? i | 16384 : ((view instanceof ViewGroup) && isRCTButton(view, RCTRootViewReference.get())) ? i | 64 : i;
            }
            return i | 4096;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return 0;
        }
    }

    private static boolean isAdapterViewItem(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return false;
        }
        try {
            ViewParent parent = view.getParent();
            if (parent instanceof AdapterView) {
                return true;
            }
            Class<?> existingClass = getExistingClass("android.support.v4.view.NestedScrollingChild");
            if (existingClass == null || !existingClass.isInstance(parent)) {
                Class<?> existingClass2 = getExistingClass("androidx.core.view.NestedScrollingChild");
                if (existingClass2 != null) {
                    if (existingClass2.isInstance(parent)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00dd A[Catch: all -> 0x00e2, TRY_LEAVE, TryCatch #0 {all -> 0x00e2, blocks: (B:5:0x000a, B:7:0x000e, B:9:0x0019, B:43:0x00dd, B:14:0x0029, B:16:0x002d, B:18:0x0036, B:20:0x003e, B:21:0x0043, B:23:0x004a, B:24:0x0074, B:26:0x0078, B:27:0x009f, B:29:0x00a3, B:31:0x00af, B:33:0x00b9, B:35:0x00bd, B:36:0x00c5, B:37:0x00c8, B:39:0x00cc), top: B:48:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getTextOfView(android.view.View r9) {
        /*
            java.lang.Class<com.facebook.appevents.codeless.internal.ViewHierarchy> r0 = com.facebook.appevents.codeless.internal.ViewHierarchy.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto La
            return r2
        La:
            boolean r1 = r9 instanceof android.widget.TextView     // Catch: java.lang.Throwable -> Le2
            if (r1 == 0) goto L29
            r1 = r9
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch: java.lang.Throwable -> Le2
            java.lang.CharSequence r1 = r1.getText()     // Catch: java.lang.Throwable -> Le2
            boolean r3 = r9 instanceof android.widget.Switch     // Catch: java.lang.Throwable -> Le2
            if (r3 == 0) goto Ld8
            android.widget.Switch r9 = (android.widget.Switch) r9     // Catch: java.lang.Throwable -> Le2
            boolean r9 = r9.isChecked()     // Catch: java.lang.Throwable -> Le2
            if (r9 == 0) goto L24
            java.lang.String r9 = "1"
            goto L26
        L24:
            java.lang.String r9 = "0"
        L26:
            r1 = r9
            goto Ld8
        L29:
            boolean r1 = r9 instanceof android.widget.Spinner     // Catch: java.lang.Throwable -> Le2
            if (r1 == 0) goto L43
            r1 = r9
            android.widget.Spinner r1 = (android.widget.Spinner) r1     // Catch: java.lang.Throwable -> Le2
            int r1 = r1.getCount()     // Catch: java.lang.Throwable -> Le2
            if (r1 <= 0) goto Ld7
            android.widget.Spinner r9 = (android.widget.Spinner) r9     // Catch: java.lang.Throwable -> Le2
            java.lang.Object r9 = r9.getSelectedItem()     // Catch: java.lang.Throwable -> Le2
            if (r9 == 0) goto Ld7
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Le2
            goto L26
        L43:
            boolean r1 = r9 instanceof android.widget.DatePicker     // Catch: java.lang.Throwable -> Le2
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L74
            android.widget.DatePicker r9 = (android.widget.DatePicker) r9     // Catch: java.lang.Throwable -> Le2
            int r1 = r9.getYear()     // Catch: java.lang.Throwable -> Le2
            int r6 = r9.getMonth()     // Catch: java.lang.Throwable -> Le2
            int r9 = r9.getDayOfMonth()     // Catch: java.lang.Throwable -> Le2
            java.lang.String r7 = "%04d-%02d-%02d"
            r8 = 3
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch: java.lang.Throwable -> Le2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> Le2
            r8[r5] = r1     // Catch: java.lang.Throwable -> Le2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> Le2
            r8[r4] = r1     // Catch: java.lang.Throwable -> Le2
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> Le2
            r8[r3] = r9     // Catch: java.lang.Throwable -> Le2
            java.lang.String r1 = java.lang.String.format(r7, r8)     // Catch: java.lang.Throwable -> Le2
            goto Ld8
        L74:
            boolean r1 = r9 instanceof android.widget.TimePicker     // Catch: java.lang.Throwable -> Le2
            if (r1 == 0) goto L9f
            android.widget.TimePicker r9 = (android.widget.TimePicker) r9     // Catch: java.lang.Throwable -> Le2
            java.lang.Integer r1 = r9.getCurrentHour()     // Catch: java.lang.Throwable -> Le2
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> Le2
            java.lang.Integer r9 = r9.getCurrentMinute()     // Catch: java.lang.Throwable -> Le2
            int r9 = r9.intValue()     // Catch: java.lang.Throwable -> Le2
            java.lang.String r6 = "%02d:%02d"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> Le2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> Le2
            r3[r5] = r1     // Catch: java.lang.Throwable -> Le2
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> Le2
            r3[r4] = r9     // Catch: java.lang.Throwable -> Le2
            java.lang.String r1 = java.lang.String.format(r6, r3)     // Catch: java.lang.Throwable -> Le2
            goto Ld8
        L9f:
            boolean r1 = r9 instanceof android.widget.RadioGroup     // Catch: java.lang.Throwable -> Le2
            if (r1 == 0) goto Lc8
            android.widget.RadioGroup r9 = (android.widget.RadioGroup) r9     // Catch: java.lang.Throwable -> Le2
            int r1 = r9.getCheckedRadioButtonId()     // Catch: java.lang.Throwable -> Le2
            int r3 = r9.getChildCount()     // Catch: java.lang.Throwable -> Le2
        Lad:
            if (r5 >= r3) goto Ld7
            android.view.View r4 = r9.getChildAt(r5)     // Catch: java.lang.Throwable -> Le2
            int r6 = r4.getId()     // Catch: java.lang.Throwable -> Le2
            if (r6 != r1) goto Lc5
            boolean r6 = r4 instanceof android.widget.RadioButton     // Catch: java.lang.Throwable -> Le2
            if (r6 == 0) goto Lc5
            android.widget.RadioButton r4 = (android.widget.RadioButton) r4     // Catch: java.lang.Throwable -> Le2
            java.lang.CharSequence r9 = r4.getText()     // Catch: java.lang.Throwable -> Le2
            goto L26
        Lc5:
            int r5 = r5 + 1
            goto Lad
        Lc8:
            boolean r1 = r9 instanceof android.widget.RatingBar     // Catch: java.lang.Throwable -> Le2
            if (r1 == 0) goto Ld7
            android.widget.RatingBar r9 = (android.widget.RatingBar) r9     // Catch: java.lang.Throwable -> Le2
            float r9 = r9.getRating()     // Catch: java.lang.Throwable -> Le2
            java.lang.String r1 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> Le2
            goto Ld8
        Ld7:
            r1 = r2
        Ld8:
            if (r1 != 0) goto Ldd
            java.lang.String r9 = ""
            goto Le1
        Ldd:
            java.lang.String r9 = r1.toString()     // Catch: java.lang.Throwable -> Le2
        Le1:
            return r9
        Le2:
            r9 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r9, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.internal.ViewHierarchy.getTextOfView(android.view.View):java.lang.String");
    }

    public static String getHintOfView(View view) {
        CharSequence hint;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            if (view instanceof EditText) {
                hint = ((EditText) view).getHint();
            } else {
                hint = view instanceof TextView ? ((TextView) view).getHint() : null;
            }
            return hint == null ? "" : hint.toString();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    private static JSONObject getDimensionOfView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, view.getTop());
                jSONObject.put("left", view.getLeft());
                jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, view.getWidth());
                jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, view.getHeight());
                jSONObject.put(ViewHierarchyConstants.DIMENSION_SCROLL_X_KEY, view.getScrollX());
                jSONObject.put(ViewHierarchyConstants.DIMENSION_SCROLL_Y_KEY, view.getScrollY());
                jSONObject.put("visibility", view.getVisibility());
            } catch (JSONException e) {
                Log.e(TAG, "Failed to create JSONObject for dimension.", e);
            }
            return jSONObject;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    public static View.OnClickListener getExistingOnClickListener(View view) {
        Field declaredField;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener")) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            return (View.OnClickListener) declaredField.get(obj);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    public static void setOnClickListener(View view, View.OnClickListener onClickListener) {
        Field field;
        Field field2;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return;
        }
        Object obj = null;
        try {
            try {
                field = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
                try {
                    field2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
                } catch (ClassNotFoundException | NoSuchFieldException unused) {
                    field2 = null;
                    if (field != null) {
                    }
                    view.setOnClickListener(onClickListener);
                    return;
                }
            } catch (Exception unused2) {
                return;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
                return;
            }
        } catch (ClassNotFoundException | NoSuchFieldException unused3) {
            field = null;
        }
        if (field != null || field2 == null) {
            view.setOnClickListener(onClickListener);
            return;
        }
        field.setAccessible(true);
        field2.setAccessible(true);
        try {
            field.setAccessible(true);
            obj = field.get(view);
        } catch (IllegalAccessException unused4) {
        }
        if (obj == null) {
            view.setOnClickListener(onClickListener);
        } else {
            field2.set(obj, onClickListener);
        }
    }

    public static View.OnTouchListener getExistingOnTouchListener(View view) {
        Field declaredField;
        try {
            if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
                return null;
            }
            try {
                Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
                if (declaredField2 != null) {
                    declaredField2.setAccessible(true);
                }
                Object obj = declaredField2.get(view);
                if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener")) == null) {
                    return null;
                }
                declaredField.setAccessible(true);
                return (View.OnTouchListener) declaredField.get(obj);
            } catch (ClassNotFoundException e) {
                Utility.logd(TAG, e);
                return null;
            } catch (IllegalAccessException e2) {
                Utility.logd(TAG, e2);
                return null;
            } catch (NoSuchFieldException e3) {
                Utility.logd(TAG, e3);
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    public static View getTouchReactView(float[] fArr, View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            initTouchTargetHelperMethods();
            Method method = methodFindTouchTargetView;
            if (method != null && view != null) {
                try {
                    View view2 = (View) method.invoke(null, fArr, view);
                    if (view2 != null && view2.getId() > 0) {
                        View view3 = (View) view2.getParent();
                        if (view3 != null) {
                            return view3;
                        }
                        return null;
                    }
                } catch (IllegalAccessException e) {
                    Utility.logd(TAG, e);
                } catch (InvocationTargetException e2) {
                    Utility.logd(TAG, e2);
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    public static boolean isRCTButton(View view, View view2) {
        View touchReactView;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return false;
        }
        try {
            if (!view.getClass().getName().equals(CLASS_RCTVIEWGROUP) || (touchReactView = getTouchReactView(getViewLocationOnScreen(view), view2)) == null) {
                return false;
            }
            return touchReactView.getId() == view.getId();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return false;
        }
    }

    public static boolean isRCTRootView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return false;
        }
        try {
            return view.getClass().getName().equals(CLASS_RCTROOTVIEW);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return false;
        }
    }

    public static boolean isRCTTextView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return false;
        }
        try {
            return view.getClass().getName().equals(CLASS_RCTTEXTVIEW);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return false;
        }
    }

    public static boolean isRCTViewGroup(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return false;
        }
        try {
            return view.getClass().getName().equals(CLASS_RCTVIEWGROUP);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return false;
        }
    }

    public static View findRCTRootView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        while (view != null) {
            try {
                if (!isRCTRootView(view)) {
                    ViewParent parent = view.getParent();
                    if (!(parent instanceof View)) {
                        break;
                    }
                    view = (View) parent;
                } else {
                    return view;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            }
        }
        return null;
    }

    private static float[] getViewLocationOnScreen(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            return new float[]{iArr[0], iArr[1]};
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    private static void initTouchTargetHelperMethods() {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return;
        }
        try {
            if (methodFindTouchTargetView != null) {
                return;
            }
            try {
                Method declaredMethod = Class.forName(CLASS_TOUCHTARGETHELPER).getDeclaredMethod(METHOD_FIND_TOUCHTARGET_VIEW, float[].class, ViewGroup.class);
                methodFindTouchTargetView = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (ClassNotFoundException e) {
                Utility.logd(TAG, e);
            } catch (NoSuchMethodException e2) {
                Utility.logd(TAG, e2);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
        }
    }

    private static Class<?> getExistingClass(String str) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }
}
