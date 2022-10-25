package com.facebook.appevents.suggestedevents;

import android.util.Patterns;
import androidx.exifinterface.media.ExifInterface;
import com.applovin.sdk.AppLovinEventParameters;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class FeatureExtractor {
    private static final int NUM_OF_FEATURES = 30;
    private static final String REGEX_ADD_TO_CART_BUTTON_TEXT = "(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart";
    private static final String REGEX_ADD_TO_CART_PAGE_TITLE = "(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart|shop|buy";
    private static final String REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD = "(?i)(confirm.*password)|(password.*(confirmation|confirm)|confirmation)";
    private static final String REGEX_CR_HAS_LOG_IN_KEYWORDS = "(?i)(sign in)|login|signIn";
    private static final String REGEX_CR_HAS_SIGN_ON_KEYWORDS = "(?i)(sign.*(up|now)|registration|register|(create|apply).*(profile|account)|open.*account|account.*(open|creation|application)|enroll|join.*now)";
    private static final String REGEX_CR_PASSWORD_FIELD = "password";
    private static Map<String, String> eventInfo = null;
    private static boolean initialized = false;
    private static Map<String, String> languageInfo;
    private static JSONObject rules;
    private static Map<String, String> textTypeInfo;

    FeatureExtractor() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void initialize(File file) {
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return;
        }
        try {
            try {
                rules = new JSONObject();
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                fileInputStream.close();
                rules = new JSONObject(new String(bArr, "UTF-8"));
                HashMap hashMap = new HashMap();
                languageInfo = hashMap;
                hashMap.put(ViewHierarchyConstants.ENGLISH, "1");
                languageInfo.put(ViewHierarchyConstants.GERMAN, ExifInterface.GPS_MEASUREMENT_2D);
                languageInfo.put(ViewHierarchyConstants.SPANISH, "3");
                languageInfo.put(ViewHierarchyConstants.JAPANESE, "4");
                HashMap hashMap2 = new HashMap();
                eventInfo = hashMap2;
                hashMap2.put(ViewHierarchyConstants.VIEW_CONTENT, "0");
                eventInfo.put(ViewHierarchyConstants.SEARCH, "1");
                eventInfo.put(ViewHierarchyConstants.ADD_TO_CART, ExifInterface.GPS_MEASUREMENT_2D);
                eventInfo.put(ViewHierarchyConstants.ADD_TO_WISHLIST, "3");
                eventInfo.put(ViewHierarchyConstants.INITIATE_CHECKOUT, "4");
                eventInfo.put(ViewHierarchyConstants.ADD_PAYMENT_INFO, "5");
                eventInfo.put(ViewHierarchyConstants.PURCHASE, "6");
                eventInfo.put(ViewHierarchyConstants.LEAD, "7");
                eventInfo.put(ViewHierarchyConstants.COMPLETE_REGISTRATION, "8");
                HashMap hashMap3 = new HashMap();
                textTypeInfo = hashMap3;
                hashMap3.put(ViewHierarchyConstants.BUTTON_TEXT, "1");
                textTypeInfo.put(ViewHierarchyConstants.PAGE_TITLE, ExifInterface.GPS_MEASUREMENT_2D);
                textTypeInfo.put(ViewHierarchyConstants.RESOLVED_DOCUMENT_LINK, "3");
                textTypeInfo.put(ViewHierarchyConstants.BUTTON_ID, "4");
                initialized = true;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, FeatureExtractor.class);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isInitialized() {
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return false;
        }
        try {
            return initialized;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FeatureExtractor.class);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getTextFeature(String str, String str2, String str3) {
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return null;
        }
        try {
            return (str3 + " | " + str2 + ", " + str).toLowerCase();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FeatureExtractor.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float[] getDenseFeatures(JSONObject jSONObject, String str) {
        String lowerCase;
        JSONObject jSONObject2;
        String optString;
        JSONArray jSONArray;
        JSONObject interactedNode;
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return null;
        }
        try {
            if (initialized) {
                float[] fArr = new float[30];
                Arrays.fill(fArr, 0.0f);
                try {
                    lowerCase = str.toLowerCase();
                    jSONObject2 = new JSONObject(jSONObject.optJSONObject(ViewHierarchyConstants.VIEW_KEY).toString());
                    optString = jSONObject.optString(ViewHierarchyConstants.SCREEN_NAME_KEY);
                    jSONArray = new JSONArray();
                    pruneTree(jSONObject2, jSONArray);
                    sum(fArr, parseFeatures(jSONObject2));
                    interactedNode = getInteractedNode(jSONObject2);
                } catch (JSONException unused) {
                }
                if (interactedNode == null) {
                    return null;
                }
                sum(fArr, nonparseFeatures(interactedNode, jSONArray, optString, jSONObject2.toString(), lowerCase));
                return fArr;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FeatureExtractor.class);
            return null;
        }
    }

    private static float[] parseFeatures(JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return null;
        }
        try {
            float[] fArr = new float[30];
            Arrays.fill(fArr, 0.0f);
            String lowerCase = jSONObject.optString("text").toLowerCase();
            String lowerCase2 = jSONObject.optString(ViewHierarchyConstants.HINT_KEY).toLowerCase();
            String lowerCase3 = jSONObject.optString(ViewHierarchyConstants.CLASS_NAME_KEY).toLowerCase();
            int optInt = jSONObject.optInt(ViewHierarchyConstants.INPUT_TYPE_KEY, -1);
            String[] strArr = {lowerCase, lowerCase2};
            if (matchIndicators(new String[]{"$", AppLovinEventParameters.REVENUE_AMOUNT, FirebaseAnalytics.Param.PRICE, "total"}, strArr)) {
                fArr[0] = (float) (fArr[0] + 1.0d);
            }
            if (matchIndicators(new String[]{"password", "pwd"}, strArr)) {
                fArr[1] = (float) (fArr[1] + 1.0d);
            }
            if (matchIndicators(new String[]{"tel", "phone"}, strArr)) {
                fArr[2] = (float) (fArr[2] + 1.0d);
            }
            if (matchIndicators(new String[]{"search"}, strArr)) {
                fArr[4] = (float) (fArr[4] + 1.0d);
            }
            if (optInt >= 0) {
                fArr[5] = (float) (fArr[5] + 1.0d);
            }
            if (optInt == 3 || optInt == 2) {
                fArr[6] = (float) (fArr[6] + 1.0d);
            }
            if (optInt == 32 || Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                fArr[7] = (float) (fArr[7] + 1.0d);
            }
            if (lowerCase3.contains("checkbox")) {
                fArr[8] = (float) (fArr[8] + 1.0d);
            }
            if (matchIndicators(new String[]{"complete", "confirm", "done", "submit"}, new String[]{lowerCase})) {
                fArr[10] = (float) (fArr[10] + 1.0d);
            }
            if (lowerCase3.contains("radio") && lowerCase3.contains("button")) {
                fArr[12] = (float) (fArr[12] + 1.0d);
            }
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    sum(fArr, parseFeatures(optJSONArray.getJSONObject(i)));
                }
            } catch (JSONException unused) {
            }
            return fArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FeatureExtractor.class);
            return null;
        }
    }

    private static float[] nonparseFeatures(JSONObject jSONObject, JSONArray jSONArray, String str, String str2, String str3) {
        int length;
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return null;
        }
        try {
            float[] fArr = new float[30];
            Arrays.fill(fArr, 0.0f);
            fArr[3] = jSONArray.length() > 1 ? length - 1 : 0;
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    if (isButton(jSONArray.getJSONObject(i))) {
                        fArr[9] = fArr[9] + 1.0f;
                    }
                } catch (JSONException unused) {
                }
            }
            fArr[13] = -1.0f;
            fArr[14] = -1.0f;
            String str4 = str + '|' + str3;
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            updateHintAndTextRecursively(jSONObject, sb2, sb);
            String sb3 = sb.toString();
            String sb4 = sb2.toString();
            fArr[15] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.COMPLETE_REGISTRATION, ViewHierarchyConstants.BUTTON_TEXT, sb4) ? 1.0f : 0.0f;
            fArr[16] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.COMPLETE_REGISTRATION, ViewHierarchyConstants.PAGE_TITLE, str4) ? 1.0f : 0.0f;
            fArr[17] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.COMPLETE_REGISTRATION, ViewHierarchyConstants.BUTTON_ID, sb3) ? 1.0f : 0.0f;
            fArr[18] = str2.contains("password") ? 1.0f : 0.0f;
            fArr[19] = regexMatched(REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD, str2) ? 1.0f : 0.0f;
            fArr[20] = regexMatched(REGEX_CR_HAS_LOG_IN_KEYWORDS, str2) ? 1.0f : 0.0f;
            fArr[21] = regexMatched(REGEX_CR_HAS_SIGN_ON_KEYWORDS, str2) ? 1.0f : 0.0f;
            fArr[22] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.PURCHASE, ViewHierarchyConstants.BUTTON_TEXT, sb4) ? 1.0f : 0.0f;
            fArr[24] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.PURCHASE, ViewHierarchyConstants.PAGE_TITLE, str4) ? 1.0f : 0.0f;
            fArr[25] = regexMatched(REGEX_ADD_TO_CART_BUTTON_TEXT, sb4) ? 1.0f : 0.0f;
            fArr[27] = regexMatched(REGEX_ADD_TO_CART_PAGE_TITLE, str4) ? 1.0f : 0.0f;
            fArr[28] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.LEAD, ViewHierarchyConstants.BUTTON_TEXT, sb4) ? 1.0f : 0.0f;
            fArr[29] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.LEAD, ViewHierarchyConstants.PAGE_TITLE, str4) ? 1.0f : 0.0f;
            return fArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FeatureExtractor.class);
            return null;
        }
    }

    private static boolean regexMatched(String str, String str2, String str3, String str4) {
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return false;
        }
        try {
            return regexMatched(rules.optJSONObject("rulesForLanguage").optJSONObject(languageInfo.get(str)).optJSONObject("rulesForEvent").optJSONObject(eventInfo.get(str2)).optJSONObject("positiveRules").optString(textTypeInfo.get(str3)), str4);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FeatureExtractor.class);
            return false;
        }
    }

    private static boolean regexMatched(String str, String str2) {
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return false;
        }
        try {
            return Pattern.compile(str).matcher(str2).find();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FeatureExtractor.class);
            return false;
        }
    }

    private static boolean matchIndicators(String[] strArr, String[] strArr2) {
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return false;
        }
        try {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (str2.contains(str)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FeatureExtractor.class);
            return false;
        }
    }

    private static boolean pruneTree(JSONObject jSONObject, JSONArray jSONArray) {
        boolean z;
        boolean z2;
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return false;
        }
        try {
            if (jSONObject.optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
                return true;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
            int i = 0;
            while (true) {
                if (i >= optJSONArray.length()) {
                    z = false;
                    z2 = false;
                    break;
                } else if (optJSONArray.getJSONObject(i).optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
                    z = true;
                    z2 = true;
                    break;
                } else {
                    i++;
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (z) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    jSONArray.put(optJSONArray.getJSONObject(i2));
                }
            } else {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    if (pruneTree(jSONObject2, jSONArray)) {
                        jSONArray2.put(jSONObject2);
                        z2 = true;
                    }
                }
                jSONObject.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, jSONArray2);
            }
            return z2;
        } catch (JSONException unused) {
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FeatureExtractor.class);
            return false;
        }
    }

    private static void sum(float[] fArr, float[] fArr2) {
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return;
        }
        for (int i = 0; i < fArr.length; i++) {
            try {
                fArr[i] = fArr[i] + fArr2[i];
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, FeatureExtractor.class);
                return;
            }
        }
    }

    private static boolean isButton(JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return false;
        }
        try {
            return (jSONObject.optInt(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY) & 32) > 0;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FeatureExtractor.class);
            return false;
        }
    }

    private static void updateHintAndTextRecursively(JSONObject jSONObject, StringBuilder sb, StringBuilder sb2) {
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return;
        }
        try {
            String lowerCase = jSONObject.optString("text", "").toLowerCase();
            String lowerCase2 = jSONObject.optString(ViewHierarchyConstants.HINT_KEY, "").toLowerCase();
            if (!lowerCase.isEmpty()) {
                sb.append(lowerCase);
                sb.append(" ");
            }
            if (!lowerCase2.isEmpty()) {
                sb2.append(lowerCase2);
                sb2.append(" ");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
            if (optJSONArray == null) {
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    updateHintAndTextRecursively(optJSONArray.getJSONObject(i), sb, sb2);
                } catch (JSONException unused) {
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FeatureExtractor.class);
        }
    }

    private static JSONObject getInteractedNode(JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return null;
        }
        try {
        } catch (JSONException unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FeatureExtractor.class);
        }
        if (jSONObject.optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
            return jSONObject;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
        if (optJSONArray == null) {
            return null;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject interactedNode = getInteractedNode(optJSONArray.getJSONObject(i));
            if (interactedNode != null) {
                return interactedNode;
            }
        }
        return null;
    }
}
