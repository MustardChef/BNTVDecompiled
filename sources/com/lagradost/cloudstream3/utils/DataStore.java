package com.lagradost.cloudstream3.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.exifinterface.media.ExifInterface;
import androidx.preference.PreferenceManager;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.module.kotlin.KotlinModule;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DataStore.kt */
@Metadata(m108d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u00020\u0010*\u00020\u000e2\u0006\u0010\n\u001a\u00020\bJ\u001a\u0010\u000f\u001a\u00020\u0010*\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\n\u0010\u0011\u001a\u00020\f*\u00020\u000eJ(\u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\n\b\u0000\u0010\u0013\u0018\u0001*\u00020\u0001*\u00020\u000e2\u0006\u0010\n\u001a\u00020\bH\u0086\b¢\u0006\u0002\u0010\u0014J2\u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\n\b\u0000\u0010\u0013\u0018\u0001*\u00020\u0001*\u00020\u000e2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u0001H\u0013H\u0086\b¢\u0006\u0002\u0010\u0016J0\u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\n\b\u0000\u0010\u0013\u0018\u0001*\u00020\u0001*\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0086\b¢\u0006\u0002\u0010\u0017J:\u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\n\b\u0000\u0010\u0013\u0018\u0001*\u00020\u0001*\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u0001H\u0013H\u0086\b¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a*\u00020\u000e2\u0006\u0010\t\u001a\u00020\bJ\n\u0010\u001b\u001a\u00020\f*\u00020\u000eJ\u0012\u0010\u001c\u001a\u00020\u001d*\u00020\u000e2\u0006\u0010\n\u001a\u00020\bJ\u001a\u0010\u001c\u001a\u00020\u001d*\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u0012\u0010\u001e\u001a\u00020\u001f*\u00020\u000e2\u0006\u0010\t\u001a\u00020\bJ%\u0010 \u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0013*\u00020\u000e2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010!\u001a\u0002H\u0013¢\u0006\u0002\u0010\"J-\u0010 \u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0013*\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010!\u001a\u0002H\u0013¢\u0006\u0002\u0010#J/\u0010$\u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0013*\u00020\u000e2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010!\u001a\u0002H\u00132\b\b\u0002\u0010%\u001a\u00020\u0010¢\u0006\u0002\u0010&J\u001e\u0010'\u001a\u0002H\u0013\"\n\b\u0000\u0010\u0013\u0018\u0001*\u00020\u0001*\u00020\bH\u0086\b¢\u0006\u0002\u0010(R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006)"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/DataStore;", "", "()V", "mapper", "Lcom/fasterxml/jackson/databind/json/JsonMapper;", "getMapper", "()Lcom/fasterxml/jackson/databind/json/JsonMapper;", "getFolderName", "", "folder", "path", "getPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "containsKey", "", "getDefaultSharedPrefs", "getKey", ExifInterface.GPS_DIRECTION_TRUE, "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;", "defVal", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getKeys", "", "getSharedPrefs", "removeKey", "", "removeKeys", "", "setKey", "value", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;)V", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "setKeyRaw", "isEditingAppSettings", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;Z)V", "toKotlinObject", "(Ljava/lang/String;)Ljava/lang/Object;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class DataStore {
    public static final DataStore INSTANCE = new DataStore();
    private static final JsonMapper mapper;

    private DataStore() {
    }

    static {
        JsonMapper build = JsonMapper.builder().addModule(new KotlinModule(0, false, false, false, null, false, 63, null)).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();
        Intrinsics.checkNotNullExpressionValue(build, "builder().addModule(Kotl…ROPERTIES, false).build()");
        mapper = build;
    }

    public final JsonMapper getMapper() {
        return mapper;
    }

    private final SharedPreferences getPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DataStoreKt.PREFERENCES_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        return sharedPreferences;
    }

    public final SharedPreferences getSharedPrefs(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return getPreferences(context);
    }

    public final String getFolderName(String folder, String path) {
        Intrinsics.checkNotNullParameter(folder, "folder");
        Intrinsics.checkNotNullParameter(path, "path");
        return folder + JsonPointer.SEPARATOR + path;
    }

    public static /* synthetic */ void setKeyRaw$default(DataStore dataStore, Context context, String str, Object obj, boolean z, int i, Object obj2) {
        if ((i & 4) != 0) {
            z = false;
        }
        dataStore.setKeyRaw(context, str, obj, z);
    }

    public final <T> void setKeyRaw(Context context, String path, T t, boolean z) {
        SharedPreferences.Editor edit;
        String str;
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            if (z) {
                edit = getDefaultSharedPrefs(context).edit();
                str = "getDefaultSharedPrefs().edit()";
            } else {
                edit = getSharedPrefs(context).edit();
                str = "getSharedPrefs().edit()";
            }
            Intrinsics.checkNotNullExpressionValue(edit, str);
            if (t instanceof Boolean) {
                edit.putBoolean(path, ((Boolean) t).booleanValue());
            } else if (t instanceof Integer) {
                edit.putInt(path, ((Number) t).intValue());
            } else if (t instanceof String) {
                edit.putString(path, (String) t);
            } else if (t instanceof Float) {
                edit.putFloat(path, ((Number) t).floatValue());
            } else if (t instanceof Long) {
                edit.putLong(path, ((Number) t).longValue());
            } else {
                if (Intrinsics.areEqual(t, Boolean.valueOf((t instanceof Set ? (Set) t : null) != null))) {
                    if (t == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
                    }
                    edit.putStringSet(path, (Set) t);
                }
            }
            edit.apply();
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }

    public final SharedPreferences getDefaultSharedPrefs(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(this)");
        return defaultSharedPreferences;
    }

    public final List<String> getKeys(Context context, String folder) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(folder, "folder");
        ArrayList arrayList = new ArrayList();
        for (Object obj : getSharedPrefs(context).getAll().keySet()) {
            String it = (String) obj;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (StringsKt.startsWith$default(it, folder, false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final void removeKey(Context context, String folder, String path) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(folder, "folder");
        Intrinsics.checkNotNullParameter(path, "path");
        removeKey(context, getFolderName(folder, path));
    }

    public final boolean containsKey(Context context, String folder, String path) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(folder, "folder");
        Intrinsics.checkNotNullParameter(path, "path");
        return containsKey(context, getFolderName(folder, path));
    }

    public final boolean containsKey(Context context, String path) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        return getSharedPrefs(context).contains(path);
    }

    public final void removeKey(Context context, String path) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            SharedPreferences sharedPrefs = getSharedPrefs(context);
            if (sharedPrefs.contains(path)) {
                SharedPreferences.Editor edit = sharedPrefs.edit();
                Intrinsics.checkNotNullExpressionValue(edit, "prefs.edit()");
                edit.remove(path);
                edit.apply();
            }
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }

    public final int removeKeys(Context context, String folder) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(folder, "folder");
        List<String> keys = getKeys(context, folder);
        for (String str : keys) {
            INSTANCE.removeKey(context, str);
        }
        return keys.size();
    }

    public final <T> void setKey(Context context, String path, T t) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            SharedPreferences.Editor edit = getSharedPrefs(context).edit();
            Intrinsics.checkNotNullExpressionValue(edit, "getSharedPrefs().edit()");
            edit.putString(path, mapper.writeValueAsString(t));
            edit.apply();
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }

    public final <T> void setKey(Context context, String folder, String path, T t) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(folder, "folder");
        Intrinsics.checkNotNullParameter(path, "path");
        setKey(context, getFolderName(folder, path), t);
    }

    public final /* synthetic */ <T> T toKotlinObject(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        JsonMapper mapper2 = getMapper();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        T t = (T) mapper2.readValue(str, Object.class);
        Intrinsics.checkNotNullExpressionValue(t, "mapper.readValue(this, T::class.java)");
        return t;
    }

    public final /* synthetic */ <T> T getKey(Context context, String path, T t) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            String string = getSharedPrefs(context).getString(path, null);
            if (string == null) {
                return t;
            }
            JsonMapper mapper2 = getMapper();
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            T t2 = (T) mapper2.readValue(string, Object.class);
            Intrinsics.checkNotNullExpressionValue(t2, "mapper.readValue(this, T::class.java)");
            return t2;
        } catch (Exception unused) {
            return null;
        }
    }

    public final /* synthetic */ <T> T getKey(Context context, String folder, String path) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(folder, "folder");
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            String string = getSharedPrefs(context).getString(getFolderName(folder, path), null);
            if (string == null) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
            JsonMapper mapper2 = getMapper();
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            T t = (T) mapper2.readValue(string, Object.class);
            Intrinsics.checkNotNullExpressionValue(t, "mapper.readValue(this, T::class.java)");
            return t;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <T> T getKey(Context context, String folder, String path, T t) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(folder, "folder");
        Intrinsics.checkNotNullParameter(path, "path");
        String folderName = getFolderName(folder, path);
        T t2 = null;
        try {
            String string = getSharedPrefs(context).getString(folderName, null);
            if (string == null) {
                t2 = t;
            } else {
                Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                JsonMapper mapper2 = getMapper();
                Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
                Object readValue = mapper2.readValue(string, Object.class);
                Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                t2 = readValue;
            }
        } catch (Exception unused) {
        }
        return t2 == null ? t : t2;
    }

    public final /* synthetic */ <T> T getKey(Context context, String path) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            String string = getSharedPrefs(context).getString(path, null);
            if (string == null) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
            JsonMapper mapper2 = getMapper();
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            T t = (T) mapper2.readValue(string, Object.class);
            Intrinsics.checkNotNullExpressionValue(t, "mapper.readValue(this, T::class.java)");
            return t;
        } catch (Exception unused) {
            return null;
        }
    }
}
