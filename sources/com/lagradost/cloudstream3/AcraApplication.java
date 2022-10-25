package com.lagradost.cloudstream3;

import android.app.Application;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.blankj.utilcode.util.Utils;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.DataStore;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ktx.ExtensionsKt;

/* compiled from: AcraApplication.kt */
@Metadata(m108d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\t"}, m107d2 = {"Lcom/lagradost/cloudstream3/AcraApplication;", "Landroid/app/Application;", "()V", "attachBaseContext", "", TtmlNode.RUBY_BASE, "Landroid/content/Context;", "onCreate", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public class AcraApplication extends Application {
    public static final Companion Companion = new Companion(null);
    private static WeakReference<Context> _context;

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        Companion.setContext(context);
        ExtensionsKt.initAcra(this, AcraApplication$attachBaseContext$1.INSTANCE);
    }

    /* compiled from: AcraApplication.kt */
    @Metadata(m108d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\f\u001a\u0004\u0018\u0001H\r\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0086\b¢\u0006\u0002\u0010\u0010J.\u0010\f\u001a\u0004\u0018\u0001H\r\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u0001H\rH\u0086\b¢\u0006\u0002\u0010\u0012J,\u0010\f\u001a\u0004\u0018\u0001H\r\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086\b¢\u0006\u0002\u0010\u0014J6\u0010\f\u001a\u0004\u0018\u0001H\r\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u0001H\rH\u0086\b¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00172\u0006\u0010\u0013\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fJ\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0002\u0010\u001eJ!\u0010\u001f\u001a\u00020\u0019\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u0002H\r¢\u0006\u0002\u0010 J)\u0010\u001f\u001a\u00020\u0019\"\u0004\b\u0000\u0010\r2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u0002H\r¢\u0006\u0002\u0010!R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00058F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\""}, m107d2 = {"Lcom/lagradost/cloudstream3/AcraApplication$Companion;", "", "()V", "_context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "value", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getKey", ExifInterface.GPS_DIRECTION_TRUE, "path", "", "(Ljava/lang/String;)Ljava/lang/Object;", "defVal", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "folder", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getKeys", "", "openBrowser", "", "url", "removeKey", "removeKeys", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "setKey", "(Ljava/lang/String;Ljava/lang/Object;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Context getContext() {
            WeakReference weakReference = AcraApplication._context;
            if (weakReference != null) {
                return (Context) weakReference.get();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setContext(Context context) {
            AcraApplication._context = new WeakReference(context);
        }

        public final Integer removeKeys(String folder) {
            Intrinsics.checkNotNullParameter(folder, "folder");
            Context context = getContext();
            if (context != null) {
                return Integer.valueOf(DataStore.INSTANCE.removeKeys(context, folder));
            }
            return null;
        }

        public final <T> void setKey(String path, T t) {
            Intrinsics.checkNotNullParameter(path, "path");
            Context context = getContext();
            if (context != null) {
                DataStore.INSTANCE.setKey(context, path, t);
            }
        }

        public final <T> void setKey(String folder, String path, T t) {
            Intrinsics.checkNotNullParameter(folder, "folder");
            Intrinsics.checkNotNullParameter(path, "path");
            Context context = getContext();
            if (context != null) {
                DataStore.INSTANCE.setKey(context, folder, path, t);
            }
        }

        public final /* synthetic */ <T> T getKey(String path, T t) {
            Intrinsics.checkNotNullParameter(path, "path");
            Context context = getContext();
            if (context != null) {
                DataStore dataStore = DataStore.INSTANCE;
                try {
                    String string = dataStore.getSharedPrefs(context).getString(path, null);
                    if (string == null) {
                        return t;
                    }
                    Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                    JsonMapper mapper = dataStore.getMapper();
                    Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
                    T t2 = (T) mapper.readValue(string, Object.class);
                    Intrinsics.checkNotNullExpressionValue(t2, "mapper.readValue(this, T::class.java)");
                    return t2;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        public final /* synthetic */ <T> T getKey(String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            Context context = getContext();
            if (context != null) {
                DataStore dataStore = DataStore.INSTANCE;
                try {
                    String string = dataStore.getSharedPrefs(context).getString(path, null);
                    if (string == null) {
                        return null;
                    }
                    Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                    JsonMapper mapper = dataStore.getMapper();
                    Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
                    T t = (T) mapper.readValue(string, Object.class);
                    Intrinsics.checkNotNullExpressionValue(t, "mapper.readValue(this, T::class.java)");
                    return t;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }

        public final /* synthetic */ <T> T getKey(String folder, String path) {
            Intrinsics.checkNotNullParameter(folder, "folder");
            Intrinsics.checkNotNullParameter(path, "path");
            Context context = getContext();
            if (context != null) {
                DataStore dataStore = DataStore.INSTANCE;
                try {
                    String string = dataStore.getSharedPrefs(context).getString(dataStore.getFolderName(folder, path), null);
                    if (string == null) {
                        return null;
                    }
                    Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                    JsonMapper mapper = dataStore.getMapper();
                    Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
                    T t = (T) mapper.readValue(string, Object.class);
                    Intrinsics.checkNotNullExpressionValue(t, "mapper.readValue(this, T::class.java)");
                    return t;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final /* synthetic */ <T> T getKey(String folder, String path, T t) {
            Intrinsics.checkNotNullParameter(folder, "folder");
            Intrinsics.checkNotNullParameter(path, "path");
            Context context = getContext();
            T t2 = null;
            if (context != null) {
                DataStore dataStore = DataStore.INSTANCE;
                try {
                    String string = dataStore.getSharedPrefs(context).getString(dataStore.getFolderName(folder, path), null);
                    if (string == null) {
                        t2 = t;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                        JsonMapper mapper = dataStore.getMapper();
                        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
                        Object readValue = mapper.readValue(string, Object.class);
                        Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                        t2 = readValue;
                    }
                } catch (Exception unused) {
                }
                if (t2 == null) {
                    return t;
                }
            }
            return t2;
        }

        public final List<String> getKeys(String folder) {
            Intrinsics.checkNotNullParameter(folder, "folder");
            Context context = getContext();
            if (context != null) {
                return DataStore.INSTANCE.getKeys(context, folder);
            }
            return null;
        }

        public final void removeKey(String folder, String path) {
            Intrinsics.checkNotNullParameter(folder, "folder");
            Intrinsics.checkNotNullParameter(path, "path");
            Context context = getContext();
            if (context != null) {
                DataStore.INSTANCE.removeKey(context, folder, path);
            }
        }

        public final void removeKey(String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            Context context = getContext();
            if (context != null) {
                DataStore.INSTANCE.removeKey(context, path);
            }
        }

        public final void openBrowser(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            Context context = getContext();
            if (context != null) {
                AppUtils.INSTANCE.openBrowser(context, url);
            }
        }
    }
}
