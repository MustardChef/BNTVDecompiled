package com.facebook.appevents;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Patterns;
import com.facebook.FacebookSdk;
import com.facebook.appevents.aam.MetadataRule;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class UserDataStore {
    public static final String CITY = "ct";
    public static final String COUNTRY = "country";
    private static final String DATA_SEPARATOR = ",";
    public static final String DATE_OF_BIRTH = "db";
    public static final String EMAIL = "em";
    public static final String FIRST_NAME = "fn";
    public static final String GENDER = "ge";
    private static final String INTERNAL_USER_DATA_KEY = "com.facebook.appevents.UserDataStore.internalUserData";
    public static final String LAST_NAME = "ln";
    private static final int MAX_NUM = 5;
    public static final String PHONE = "ph";
    public static final String STATE = "st";
    private static final String TAG = "UserDataStore";
    private static final String USER_DATA_KEY = "com.facebook.appevents.UserDataStore.userData";
    public static final String ZIP = "zp";
    private static SharedPreferences sharedPreferences;
    private static AtomicBoolean initialized = new AtomicBoolean(false);
    private static final ConcurrentHashMap<String, String> externalHashedUserData = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> internalHashedUserData = new ConcurrentHashMap<>();

    static /* synthetic */ AtomicBoolean access$000() {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return null;
        }
        try {
            return initialized;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
            return null;
        }
    }

    static /* synthetic */ void access$100() {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            initAndWait();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    static /* synthetic */ SharedPreferences access$200() {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return null;
        }
        try {
            return sharedPreferences;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
            return null;
        }
    }

    static /* synthetic */ String access$300() {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
            return null;
        }
    }

    static /* synthetic */ void access$400(Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            updateHashUserData(bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    static /* synthetic */ ConcurrentHashMap access$500() {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return null;
        }
        try {
            return externalHashedUserData;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
            return null;
        }
    }

    static /* synthetic */ void access$600(String str, String str2) {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            writeDataIntoCache(str, str2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    static /* synthetic */ ConcurrentHashMap access$700() {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return null;
        }
        try {
            return internalHashedUserData;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void initStore() {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            if (initialized.get()) {
                return;
            }
            initAndWait();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    private static void writeDataIntoCache(final String str, final String str2) {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.appevents.UserDataStore.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        if (!UserDataStore.access$000().get()) {
                            UserDataStore.access$100();
                        }
                        UserDataStore.access$200().edit().putString(str, str2).apply();
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setUserDataAndHash(final Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            InternalAppEventsLogger.getAnalyticsExecutor().execute(new Runnable() { // from class: com.facebook.appevents.UserDataStore.2
                @Override // java.lang.Runnable
                public void run() {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        if (!UserDataStore.access$000().get()) {
                            Log.w(UserDataStore.access$300(), "initStore should have been called before calling setUserData");
                            UserDataStore.access$100();
                        }
                        UserDataStore.access$400(bundle);
                        UserDataStore.access$600(UserDataStore.USER_DATA_KEY, Utility.mapToJsonStr(UserDataStore.access$500()));
                        UserDataStore.access$600(UserDataStore.INTERNAL_USER_DATA_KEY, Utility.mapToJsonStr(UserDataStore.access$700()));
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setUserDataAndHash(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                bundle.putString(EMAIL, str);
            }
            if (str2 != null) {
                bundle.putString(FIRST_NAME, str2);
            }
            if (str3 != null) {
                bundle.putString(LAST_NAME, str3);
            }
            if (str4 != null) {
                bundle.putString(PHONE, str4);
            }
            if (str5 != null) {
                bundle.putString(DATE_OF_BIRTH, str5);
            }
            if (str6 != null) {
                bundle.putString(GENDER, str6);
            }
            if (str7 != null) {
                bundle.putString(CITY, str7);
            }
            if (str8 != null) {
                bundle.putString(STATE, str8);
            }
            if (str9 != null) {
                bundle.putString(ZIP, str9);
            }
            if (str10 != null) {
                bundle.putString(COUNTRY, str10);
            }
            setUserDataAndHash(bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void clear() {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            InternalAppEventsLogger.getAnalyticsExecutor().execute(new Runnable() { // from class: com.facebook.appevents.UserDataStore.3
                @Override // java.lang.Runnable
                public void run() {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        if (!UserDataStore.access$000().get()) {
                            Log.w(UserDataStore.access$300(), "initStore should have been called before calling setUserData");
                            UserDataStore.access$100();
                        }
                        UserDataStore.access$500().clear();
                        UserDataStore.access$200().edit().putString(UserDataStore.USER_DATA_KEY, null).apply();
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getHashedUserData() {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return null;
        }
        try {
            if (!initialized.get()) {
                Log.w(TAG, "initStore should have been called before calling setUserID");
                initAndWait();
            }
            return Utility.mapToJsonStr(externalHashedUserData);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
            return null;
        }
    }

    public static String getAllHashedUserData() {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return null;
        }
        try {
            if (!initialized.get()) {
                initAndWait();
            }
            HashMap hashMap = new HashMap();
            hashMap.putAll(externalHashedUserData);
            hashMap.putAll(getEnabledInternalUserData());
            return Utility.mapToJsonStr(hashMap);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
            return null;
        }
    }

    private static Map<String, String> getEnabledInternalUserData() {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            Set<String> enabledRuleNames = MetadataRule.getEnabledRuleNames();
            for (String str : internalHashedUserData.keySet()) {
                if (enabledRuleNames.contains(str)) {
                    hashMap.put(str, internalHashedUserData.get(str));
                }
            }
            return hashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
            return null;
        }
    }

    private static synchronized void initAndWait() {
        synchronized (UserDataStore.class) {
            if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
                return;
            }
            if (initialized.get()) {
                return;
            }
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
            sharedPreferences = defaultSharedPreferences;
            String string = defaultSharedPreferences.getString(USER_DATA_KEY, "");
            String string2 = sharedPreferences.getString(INTERNAL_USER_DATA_KEY, "");
            externalHashedUserData.putAll(Utility.JsonStrToMap(string));
            internalHashedUserData.putAll(Utility.JsonStrToMap(string2));
            initialized.set(true);
        }
    }

    private static void updateHashUserData(Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class) || bundle == null) {
            return;
        }
        try {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null) {
                    String obj2 = obj.toString();
                    if (maybeSHA256Hashed(obj2)) {
                        externalHashedUserData.put(str, obj2.toLowerCase());
                    } else {
                        String sha256hash = Utility.sha256hash(normalizeData(str, obj2));
                        if (sha256hash != null) {
                            externalHashedUserData.put(str, sha256hash);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setInternalUd(Map<String, String> map) {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            if (!initialized.get()) {
                initAndWait();
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String sha256hash = Utility.sha256hash(normalizeData(key, map.get(key).trim()));
                ConcurrentHashMap<String, String> concurrentHashMap = internalHashedUserData;
                if (concurrentHashMap.containsKey(key)) {
                    String str = concurrentHashMap.get(key);
                    String[] split = str != null ? str.split(DATA_SEPARATOR) : new String[0];
                    HashSet hashSet = new HashSet(Arrays.asList(split));
                    if (hashSet.contains(sha256hash)) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    if (split.length == 0) {
                        sb.append(sha256hash);
                    } else if (split.length < 5) {
                        sb.append(str);
                        sb.append(DATA_SEPARATOR);
                        sb.append(sha256hash);
                    } else {
                        for (int i = 1; i < 5; i++) {
                            sb.append(split[i]);
                            sb.append(DATA_SEPARATOR);
                        }
                        sb.append(sha256hash);
                        hashSet.remove(split[0]);
                    }
                    internalHashedUserData.put(key, sb.toString());
                } else {
                    concurrentHashMap.put(key, sha256hash);
                }
            }
            writeDataIntoCache(INTERNAL_USER_DATA_KEY, Utility.mapToJsonStr(internalHashedUserData));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    private static String normalizeData(String str, String str2) {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return null;
        }
        try {
            String lowerCase = str2.trim().toLowerCase();
            if (EMAIL.equals(str)) {
                if (Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                    return lowerCase;
                }
                Log.e(TAG, "Setting email failure: this is not a valid email address");
                return "";
            } else if (PHONE.equals(str)) {
                return lowerCase.replaceAll("[^0-9]", "");
            } else {
                if (GENDER.equals(str)) {
                    String substring = lowerCase.length() > 0 ? lowerCase.substring(0, 1) : "";
                    if (!"f".equals(substring) && !"m".equals(substring)) {
                        Log.e(TAG, "Setting gender failure: the supported value for gender is f or m");
                        return "";
                    }
                    return substring;
                }
                return lowerCase;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
            return null;
        }
    }

    private static boolean maybeSHA256Hashed(String str) {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return false;
        }
        try {
            return str.matches("[A-Fa-f0-9]{64}");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
            return false;
        }
    }
}
