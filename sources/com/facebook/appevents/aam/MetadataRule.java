package com.facebook.appevents.aam;

import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class MetadataRule {
    private static final String FIELD_K = "k";
    private static final String FIELD_K_DELIMITER = ",";
    private static final String FIELD_V = "v";
    private static final String TAG = "com.facebook.appevents.aam.MetadataRule";
    private static final Set<MetadataRule> rules = new CopyOnWriteArraySet();
    private List<String> keyRules;
    private String name;
    private String valRule;

    private MetadataRule(String str, List<String> list, String str2) {
        this.name = str;
        this.keyRules = list;
        this.valRule = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set<MetadataRule> getRules() {
        if (CrashShieldHandler.isObjectCrashing(MetadataRule.class)) {
            return null;
        }
        try {
            return new HashSet(rules);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataRule.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.name;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> getKeyRules() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return new ArrayList(this.keyRules);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getValRule() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.valRule;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void updateRules(String str) {
        if (CrashShieldHandler.isObjectCrashing(MetadataRule.class)) {
            return;
        }
        try {
            rules.clear();
            constructRules(new JSONObject(str));
        } catch (JSONException unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataRule.class);
        }
    }

    private static void constructRules(JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(MetadataRule.class)) {
            return;
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString(FIELD_K);
                    String optString2 = optJSONObject.optString(FIELD_V);
                    if (!optString.isEmpty()) {
                        rules.add(new MetadataRule(next, Arrays.asList(optString.split(FIELD_K_DELIMITER)), optString2));
                    }
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataRule.class);
        }
    }

    public static Set<String> getEnabledRuleNames() {
        if (CrashShieldHandler.isObjectCrashing(MetadataRule.class)) {
            return null;
        }
        try {
            HashSet hashSet = new HashSet();
            for (MetadataRule metadataRule : rules) {
                hashSet.add(metadataRule.getName());
            }
            return hashSet;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataRule.class);
            return null;
        }
    }
}
