package com.applovin.impl.sdk.p029c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.p031e.C1642y;
import com.applovin.impl.sdk.utils.Utils;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.c.e */
/* loaded from: classes.dex */
public final class C1571e {

    /* renamed from: a */
    private static C1662k f1957a;

    /* renamed from: b */
    private static SharedPreferences f1958b;

    /* renamed from: c */
    private final SharedPreferences f1959c;

    public C1571e(C1662k c1662k) {
        this.f1959c = c1662k.m6677J().getSharedPreferences("com.applovin.sdk.preferences." + c1662k.m6590x(), 0);
        if (c1662k.m6611e()) {
            return;
        }
        f1957a = c1662k;
    }

    /* renamed from: a */
    private static SharedPreferences m6990a(Context context) {
        if (f1958b == null) {
            f1958b = context.getSharedPreferences("com.applovin.sdk.shared", 0);
        }
        return f1958b;
    }

    /* renamed from: a */
    public static <T> T m6979a(String str, T t, Class cls, SharedPreferences sharedPreferences) {
        Object string;
        long j;
        int i;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (sharedPreferences.contains(str)) {
                if (Boolean.class.equals(cls)) {
                    string = Boolean.valueOf(t != null ? sharedPreferences.getBoolean(str, ((Boolean) t).booleanValue()) : sharedPreferences.getBoolean(str, false));
                } else if (Float.class.equals(cls)) {
                    string = Float.valueOf(t != null ? sharedPreferences.getFloat(str, ((Float) t).floatValue()) : sharedPreferences.getFloat(str, 0.0f));
                } else if (Integer.class.equals(cls)) {
                    if (t != null) {
                        i = sharedPreferences.getInt(str, t.getClass().equals(Long.class) ? ((Long) t).intValue() : ((Integer) t).intValue());
                    } else {
                        i = sharedPreferences.getInt(str, 0);
                    }
                    string = Integer.valueOf(i);
                } else if (Long.class.equals(cls)) {
                    if (t != null) {
                        j = sharedPreferences.getLong(str, t.getClass().equals(Integer.class) ? ((Integer) t).longValue() : ((Long) t).longValue());
                    } else {
                        j = sharedPreferences.getLong(str, 0L);
                    }
                    string = Long.valueOf(j);
                } else if (Double.class.equals(cls)) {
                    string = Double.valueOf(t != null ? Double.longBitsToDouble(sharedPreferences.getLong(str, Double.doubleToRawLongBits(((Double) t).doubleValue()))) : Double.longBitsToDouble(sharedPreferences.getLong(str, 0L)));
                } else {
                    string = String.class.equals(cls) ? sharedPreferences.getString(str, (String) t) : Set.class.isAssignableFrom(cls) ? sharedPreferences.getStringSet(str, (Set) t) : t;
                }
                return string != null ? (T) cls.cast(string) : t;
            }
            return t;
        } catch (Throwable th) {
            try {
                C1710r.m6316c("SharedPreferencesManager", "Error getting value for key: " + str, th);
                return t;
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        }
    }

    /* renamed from: a */
    private static void m6989a(final SharedPreferences.Editor editor) {
        try {
            C1662k c1662k = f1957a;
            if (c1662k != null && ((Boolean) c1662k.m6656a(C1568b.f1873eJ)).booleanValue()) {
                if (!Utils.isMainThread()) {
                    editor.commit();
                } else if (f1957a.m6670Q() != null) {
                    f1957a.m6670Q().m6793a(new C1642y(f1957a, new Runnable() { // from class: com.applovin.impl.sdk.c.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            editor.commit();
                        }
                    }), C1620o.EnumC1622a.BACKGROUND);
                }
            }
            editor.apply();
        } catch (Throwable th) {
            C1710r.m6316c("SharedPreferencesManager", "Unable to apply changes", th);
        }
    }

    /* renamed from: a */
    public static <T> void m6986a(C1570d<T> c1570d, Context context) {
        m6989a(m6990a(context).edit().remove(c1570d.m6992a()));
    }

    /* renamed from: a */
    public static <T> void m6984a(C1570d<T> c1570d, T t, Context context) {
        m6980a(c1570d.m6992a(), t, m6990a(context), (SharedPreferences.Editor) null);
    }

    /* renamed from: a */
    public static <T> void m6980a(String str, T t, SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
        long doubleToRawLongBits;
        boolean z = true;
        boolean z2 = editor != null;
        if (!z2) {
            editor = sharedPreferences.edit();
        }
        if (t == null) {
            editor.remove(str);
        } else if (t instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) t).booleanValue());
        } else if (t instanceof Float) {
            editor.putFloat(str, ((Float) t).floatValue());
        } else if (t instanceof Integer) {
            editor.putInt(str, ((Integer) t).intValue());
        } else {
            if (t instanceof Long) {
                doubleToRawLongBits = ((Long) t).longValue();
            } else if (t instanceof Double) {
                doubleToRawLongBits = Double.doubleToRawLongBits(((Double) t).doubleValue());
            } else if (t instanceof String) {
                editor.putString(str, (String) t);
            } else if (t instanceof Set) {
                editor.putStringSet(str, (Set) t);
            } else {
                C1710r.m6310i("SharedPreferencesManager", "Unable to put default value of invalid type: " + t);
                z = false;
            }
            editor.putLong(str, doubleToRawLongBits);
        }
        if (!z || z2) {
            return;
        }
        m6989a(editor);
    }

    /* renamed from: b */
    public static <T> T m6977b(C1570d<T> c1570d, T t, Context context) {
        return (T) m6979a(c1570d.m6992a(), t, c1570d.m6991b(), m6990a(context));
    }

    /* renamed from: a */
    public void m6988a(SharedPreferences sharedPreferences) {
        m6989a(sharedPreferences.edit().clear());
    }

    /* renamed from: a */
    public <T> void m6987a(C1570d<T> c1570d) {
        m6989a(this.f1959c.edit().remove(c1570d.m6992a()));
    }

    /* renamed from: a */
    public <T> void m6985a(C1570d<T> c1570d, T t) {
        m6983a((C1570d<C1570d<T>>) c1570d, (C1570d<T>) t, this.f1959c);
    }

    /* renamed from: a */
    public <T> void m6983a(C1570d<T> c1570d, T t, SharedPreferences sharedPreferences) {
        m6981a(c1570d.m6992a(), (String) t, sharedPreferences);
    }

    /* renamed from: a */
    public <T> void m6982a(String str, T t, SharedPreferences.Editor editor) {
        m6980a(str, t, (SharedPreferences) null, editor);
    }

    /* renamed from: a */
    public <T> void m6981a(String str, T t, SharedPreferences sharedPreferences) {
        m6980a(str, t, sharedPreferences, (SharedPreferences.Editor) null);
    }

    /* renamed from: b */
    public <T> T m6978b(C1570d<T> c1570d, T t) {
        return (T) m6976b((C1570d<C1570d<T>>) c1570d, (C1570d<T>) t, this.f1959c);
    }

    /* renamed from: b */
    public <T> T m6976b(C1570d<T> c1570d, T t, SharedPreferences sharedPreferences) {
        return (T) m6979a(c1570d.m6992a(), t, c1570d.m6991b(), sharedPreferences);
    }
}
