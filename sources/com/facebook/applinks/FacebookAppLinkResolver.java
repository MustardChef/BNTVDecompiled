package com.facebook.applinks;

import android.net.Uri;
import android.os.Bundle;
import bolts.AppLink;
import bolts.AppLinkResolver;
import bolts.Continuation;
import bolts.Task;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class FacebookAppLinkResolver implements AppLinkResolver {
    private static final String APP_LINK_ANDROID_TARGET_KEY = "android";
    private static final String APP_LINK_KEY = "app_links";
    private static final String APP_LINK_TARGET_APP_NAME_KEY = "app_name";
    private static final String APP_LINK_TARGET_CLASS_KEY = "class";
    private static final String APP_LINK_TARGET_PACKAGE_KEY = "package";
    private static final String APP_LINK_TARGET_SHOULD_FALLBACK_KEY = "should_fallback";
    private static final String APP_LINK_TARGET_URL_KEY = "url";
    private static final String APP_LINK_WEB_TARGET_KEY = "web";
    private final HashMap<Uri, AppLink> cachedAppLinks = new HashMap<>();

    static /* synthetic */ AppLink.Target access$000(JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(FacebookAppLinkResolver.class)) {
            return null;
        }
        try {
            return getAndroidTargetFromJson(jSONObject);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookAppLinkResolver.class);
            return null;
        }
    }

    static /* synthetic */ Uri access$100(Uri uri, JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(FacebookAppLinkResolver.class)) {
            return null;
        }
        try {
            return getWebFallbackUriFromJson(uri, jSONObject);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookAppLinkResolver.class);
            return null;
        }
    }

    static /* synthetic */ HashMap access$200(FacebookAppLinkResolver facebookAppLinkResolver) {
        if (CrashShieldHandler.isObjectCrashing(FacebookAppLinkResolver.class)) {
            return null;
        }
        try {
            return facebookAppLinkResolver.cachedAppLinks;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookAppLinkResolver.class);
            return null;
        }
    }

    @Override // bolts.AppLinkResolver
    public Task<AppLink> getAppLinkFromUrlInBackground(final Uri uri) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(uri);
            return getAppLinkFromUrlsInBackground(arrayList).onSuccess(new Continuation<Map<Uri, AppLink>, AppLink>() { // from class: com.facebook.applinks.FacebookAppLinkResolver.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // bolts.Continuation
                public AppLink then(Task<Map<Uri, AppLink>> task) throws Exception {
                    return task.getResult().get(uri);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public Task<Map<Uri, AppLink>> getAppLinkFromUrlsInBackground(List<Uri> list) {
        AppLink appLink;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            final HashMap hashMap = new HashMap();
            final HashSet hashSet = new HashSet();
            StringBuilder sb = new StringBuilder();
            for (Uri uri : list) {
                synchronized (this.cachedAppLinks) {
                    appLink = this.cachedAppLinks.get(uri);
                }
                if (appLink != null) {
                    hashMap.put(uri, appLink);
                } else {
                    if (!hashSet.isEmpty()) {
                        sb.append(',');
                    }
                    sb.append(uri.toString());
                    hashSet.add(uri);
                }
            }
            if (hashSet.isEmpty()) {
                return Task.forResult(hashMap);
            }
            final Task.TaskCompletionSource create = Task.create();
            Bundle bundle = new Bundle();
            bundle.putString("ids", sb.toString());
            bundle.putString("fields", String.format("%s.fields(%s,%s)", APP_LINK_KEY, "android", "web"));
            new GraphRequest(AccessToken.getCurrentAccessToken(), "", bundle, null, new GraphRequest.Callback() { // from class: com.facebook.applinks.FacebookAppLinkResolver.2
                /* JADX WARN: Removed duplicated region for block: B:16:0x0031 A[Catch: all -> 0x009d, TRY_LEAVE, TryCatch #2 {all -> 0x009d, blocks: (B:5:0x0007, B:7:0x000d, B:9:0x0017, B:11:0x001d, B:13:0x0025, B:14:0x002b, B:16:0x0031, B:19:0x0042, B:21:0x0062, B:23:0x006c, B:24:0x006f, B:25:0x0072, B:26:0x0086, B:32:0x0094, B:33:0x0095), top: B:43:0x0007 }] */
                @Override // com.facebook.GraphRequest.Callback
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onCompleted(com.facebook.GraphResponse r9) {
                    /*
                        r8 = this;
                        boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r8)
                        if (r0 == 0) goto L7
                        return
                    L7:
                        com.facebook.FacebookRequestError r0 = r9.getError()     // Catch: java.lang.Throwable -> L9d
                        if (r0 == 0) goto L17
                        bolts.Task$TaskCompletionSource r9 = r2     // Catch: java.lang.Throwable -> L9d
                        com.facebook.FacebookException r0 = r0.getException()     // Catch: java.lang.Throwable -> L9d
                        r9.setError(r0)     // Catch: java.lang.Throwable -> L9d
                        return
                    L17:
                        org.json.JSONObject r9 = r9.getJSONObject()     // Catch: java.lang.Throwable -> L9d
                        if (r9 != 0) goto L25
                        bolts.Task$TaskCompletionSource r9 = r2     // Catch: java.lang.Throwable -> L9d
                        java.util.Map r0 = r3     // Catch: java.lang.Throwable -> L9d
                        r9.setResult(r0)     // Catch: java.lang.Throwable -> L9d
                        return
                    L25:
                        java.util.HashSet r0 = r4     // Catch: java.lang.Throwable -> L9d
                        java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L9d
                    L2b:
                        boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L9d
                        if (r1 == 0) goto L95
                        java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L9d
                        android.net.Uri r1 = (android.net.Uri) r1     // Catch: java.lang.Throwable -> L9d
                        java.lang.String r2 = r1.toString()     // Catch: java.lang.Throwable -> L9d
                        boolean r2 = r9.has(r2)     // Catch: java.lang.Throwable -> L9d
                        if (r2 != 0) goto L42
                        goto L2b
                    L42:
                        java.lang.String r2 = r1.toString()     // Catch: org.json.JSONException -> L2b java.lang.Throwable -> L9d
                        org.json.JSONObject r2 = r9.getJSONObject(r2)     // Catch: org.json.JSONException -> L2b java.lang.Throwable -> L9d
                        java.lang.String r3 = "app_links"
                        org.json.JSONObject r2 = r2.getJSONObject(r3)     // Catch: org.json.JSONException -> L2b java.lang.Throwable -> L9d
                        java.lang.String r3 = "android"
                        org.json.JSONArray r3 = r2.getJSONArray(r3)     // Catch: org.json.JSONException -> L2b java.lang.Throwable -> L9d
                        int r4 = r3.length()     // Catch: org.json.JSONException -> L2b java.lang.Throwable -> L9d
                        java.util.ArrayList r5 = new java.util.ArrayList     // Catch: org.json.JSONException -> L2b java.lang.Throwable -> L9d
                        r5.<init>(r4)     // Catch: org.json.JSONException -> L2b java.lang.Throwable -> L9d
                        r6 = 0
                    L60:
                        if (r6 >= r4) goto L72
                        org.json.JSONObject r7 = r3.getJSONObject(r6)     // Catch: org.json.JSONException -> L2b java.lang.Throwable -> L9d
                        bolts.AppLink$Target r7 = com.facebook.applinks.FacebookAppLinkResolver.access$000(r7)     // Catch: org.json.JSONException -> L2b java.lang.Throwable -> L9d
                        if (r7 == 0) goto L6f
                        r5.add(r7)     // Catch: org.json.JSONException -> L2b java.lang.Throwable -> L9d
                    L6f:
                        int r6 = r6 + 1
                        goto L60
                    L72:
                        android.net.Uri r2 = com.facebook.applinks.FacebookAppLinkResolver.access$100(r1, r2)     // Catch: org.json.JSONException -> L2b java.lang.Throwable -> L9d
                        bolts.AppLink r3 = new bolts.AppLink     // Catch: org.json.JSONException -> L2b java.lang.Throwable -> L9d
                        r3.<init>(r1, r5, r2)     // Catch: org.json.JSONException -> L2b java.lang.Throwable -> L9d
                        java.util.Map r2 = r3     // Catch: org.json.JSONException -> L2b java.lang.Throwable -> L9d
                        r2.put(r1, r3)     // Catch: org.json.JSONException -> L2b java.lang.Throwable -> L9d
                        com.facebook.applinks.FacebookAppLinkResolver r2 = com.facebook.applinks.FacebookAppLinkResolver.this     // Catch: org.json.JSONException -> L2b java.lang.Throwable -> L9d
                        java.util.HashMap r2 = com.facebook.applinks.FacebookAppLinkResolver.access$200(r2)     // Catch: org.json.JSONException -> L2b java.lang.Throwable -> L9d
                        monitor-enter(r2)     // Catch: org.json.JSONException -> L2b java.lang.Throwable -> L9d
                        com.facebook.applinks.FacebookAppLinkResolver r4 = com.facebook.applinks.FacebookAppLinkResolver.this     // Catch: java.lang.Throwable -> L92
                        java.util.HashMap r4 = com.facebook.applinks.FacebookAppLinkResolver.access$200(r4)     // Catch: java.lang.Throwable -> L92
                        r4.put(r1, r3)     // Catch: java.lang.Throwable -> L92
                        monitor-exit(r2)     // Catch: java.lang.Throwable -> L92
                        goto L2b
                    L92:
                        r1 = move-exception
                        monitor-exit(r2)     // Catch: java.lang.Throwable -> L92
                        throw r1     // Catch: org.json.JSONException -> L2b java.lang.Throwable -> L9d
                    L95:
                        bolts.Task$TaskCompletionSource r9 = r2     // Catch: java.lang.Throwable -> L9d
                        java.util.Map r0 = r3     // Catch: java.lang.Throwable -> L9d
                        r9.setResult(r0)     // Catch: java.lang.Throwable -> L9d
                        return
                    L9d:
                        r9 = move-exception
                        com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r9, r8)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.applinks.FacebookAppLinkResolver.C20172.onCompleted(com.facebook.GraphResponse):void");
                }
            }).executeAsync();
            return create.getTask();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private static AppLink.Target getAndroidTargetFromJson(JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(FacebookAppLinkResolver.class)) {
            return null;
        }
        try {
            String tryGetStringFromJson = tryGetStringFromJson(jSONObject, APP_LINK_TARGET_PACKAGE_KEY, null);
            if (tryGetStringFromJson == null) {
                return null;
            }
            String tryGetStringFromJson2 = tryGetStringFromJson(jSONObject, APP_LINK_TARGET_CLASS_KEY, null);
            String tryGetStringFromJson3 = tryGetStringFromJson(jSONObject, "app_name", null);
            String tryGetStringFromJson4 = tryGetStringFromJson(jSONObject, "url", null);
            return new AppLink.Target(tryGetStringFromJson, tryGetStringFromJson2, tryGetStringFromJson4 != null ? Uri.parse(tryGetStringFromJson4) : null, tryGetStringFromJson3);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookAppLinkResolver.class);
            return null;
        }
    }

    private static Uri getWebFallbackUriFromJson(Uri uri, JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(FacebookAppLinkResolver.class)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("web");
            if (tryGetBooleanFromJson(jSONObject2, APP_LINK_TARGET_SHOULD_FALLBACK_KEY, true)) {
                String tryGetStringFromJson = tryGetStringFromJson(jSONObject2, "url", null);
                Uri parse = tryGetStringFromJson != null ? Uri.parse(tryGetStringFromJson) : null;
                return parse != null ? parse : uri;
            }
            return null;
        } catch (JSONException unused) {
            return uri;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookAppLinkResolver.class);
            return null;
        }
    }

    private static String tryGetStringFromJson(JSONObject jSONObject, String str, String str2) {
        if (CrashShieldHandler.isObjectCrashing(FacebookAppLinkResolver.class)) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return str2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookAppLinkResolver.class);
            return null;
        }
    }

    private static boolean tryGetBooleanFromJson(JSONObject jSONObject, String str, boolean z) {
        if (CrashShieldHandler.isObjectCrashing(FacebookAppLinkResolver.class)) {
            return false;
        }
        try {
            return jSONObject.getBoolean(str);
        } catch (JSONException unused) {
            return z;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookAppLinkResolver.class);
            return false;
        }
    }
}
