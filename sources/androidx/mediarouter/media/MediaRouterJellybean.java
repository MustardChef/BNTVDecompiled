package androidx.mediarouter.media;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaRouter;
import android.media.RemoteControlClient;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class MediaRouterJellybean {
    public static final int ALL_ROUTE_TYPES = 8388611;
    public static final int DEVICE_OUT_BLUETOOTH = 896;
    public static final int ROUTE_TYPE_LIVE_AUDIO = 1;
    public static final int ROUTE_TYPE_LIVE_VIDEO = 2;
    public static final int ROUTE_TYPE_USER = 8388608;
    private static final String TAG = "MediaRouterJellybean";

    /* loaded from: classes.dex */
    public interface Callback {
        void onRouteAdded(Object obj);

        void onRouteChanged(Object obj);

        void onRouteGrouped(Object obj, Object obj2, int i);

        void onRouteRemoved(Object obj);

        void onRouteSelected(int i, Object obj);

        void onRouteUngrouped(Object obj, Object obj2);

        void onRouteUnselected(int i, Object obj);

        void onRouteVolumeChanged(Object obj);
    }

    /* loaded from: classes.dex */
    public interface VolumeCallback {
        void onVolumeSetRequest(Object obj, int i);

        void onVolumeUpdateRequest(Object obj, int i);
    }

    public static Object getMediaRouter(Context context) {
        return context.getSystemService("media_router");
    }

    public static List getRoutes(Object obj) {
        android.media.MediaRouter mediaRouter = (android.media.MediaRouter) obj;
        int routeCount = mediaRouter.getRouteCount();
        ArrayList arrayList = new ArrayList(routeCount);
        for (int i = 0; i < routeCount; i++) {
            arrayList.add(mediaRouter.getRouteAt(i));
        }
        return arrayList;
    }

    public static List getCategories(Object obj) {
        android.media.MediaRouter mediaRouter = (android.media.MediaRouter) obj;
        int categoryCount = mediaRouter.getCategoryCount();
        ArrayList arrayList = new ArrayList(categoryCount);
        for (int i = 0; i < categoryCount; i++) {
            arrayList.add(mediaRouter.getCategoryAt(i));
        }
        return arrayList;
    }

    public static Object getSelectedRoute(Object obj, int i) {
        return ((android.media.MediaRouter) obj).getSelectedRoute(i);
    }

    public static void selectRoute(Object obj, int i, Object obj2) {
        ((android.media.MediaRouter) obj).selectRoute(i, (MediaRouter.RouteInfo) obj2);
    }

    public static void addCallback(Object obj, int i, Object obj2) {
        ((android.media.MediaRouter) obj).addCallback(i, (MediaRouter.Callback) obj2);
    }

    public static void removeCallback(Object obj, Object obj2) {
        ((android.media.MediaRouter) obj).removeCallback((MediaRouter.Callback) obj2);
    }

    public static Object createRouteCategory(Object obj, String str, boolean z) {
        return ((android.media.MediaRouter) obj).createRouteCategory(str, z);
    }

    public static Object createUserRoute(Object obj, Object obj2) {
        return ((android.media.MediaRouter) obj).createUserRoute((MediaRouter.RouteCategory) obj2);
    }

    public static void addUserRoute(Object obj, Object obj2) {
        ((android.media.MediaRouter) obj).addUserRoute((MediaRouter.UserRouteInfo) obj2);
    }

    public static void removeUserRoute(Object obj, Object obj2) {
        ((android.media.MediaRouter) obj).removeUserRoute((MediaRouter.UserRouteInfo) obj2);
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }

    public static Object createVolumeCallback(VolumeCallback volumeCallback) {
        return new VolumeCallbackProxy(volumeCallback);
    }

    /* loaded from: classes.dex */
    public static final class RouteInfo {
        public static CharSequence getName(Object obj, Context context) {
            return ((MediaRouter.RouteInfo) obj).getName(context);
        }

        public static CharSequence getStatus(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getStatus();
        }

        public static int getSupportedTypes(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getSupportedTypes();
        }

        public static Object getCategory(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getCategory();
        }

        public static Drawable getIconDrawable(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getIconDrawable();
        }

        public static int getPlaybackType(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getPlaybackType();
        }

        public static int getPlaybackStream(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getPlaybackStream();
        }

        public static int getVolume(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getVolume();
        }

        public static int getVolumeMax(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getVolumeMax();
        }

        public static int getVolumeHandling(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getVolumeHandling();
        }

        public static Object getTag(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getTag();
        }

        public static void setTag(Object obj, Object obj2) {
            ((MediaRouter.RouteInfo) obj).setTag(obj2);
        }

        public static void requestSetVolume(Object obj, int i) {
            ((MediaRouter.RouteInfo) obj).requestSetVolume(i);
        }

        public static void requestUpdateVolume(Object obj, int i) {
            ((MediaRouter.RouteInfo) obj).requestUpdateVolume(i);
        }

        public static Object getGroup(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getGroup();
        }

        public static boolean isGroup(Object obj) {
            return obj instanceof MediaRouter.RouteGroup;
        }

        private RouteInfo() {
        }
    }

    /* loaded from: classes.dex */
    public static final class RouteGroup {
        public static List getGroupedRoutes(Object obj) {
            MediaRouter.RouteGroup routeGroup = (MediaRouter.RouteGroup) obj;
            int routeCount = routeGroup.getRouteCount();
            ArrayList arrayList = new ArrayList(routeCount);
            for (int i = 0; i < routeCount; i++) {
                arrayList.add(routeGroup.getRouteAt(i));
            }
            return arrayList;
        }

        private RouteGroup() {
        }
    }

    /* loaded from: classes.dex */
    public static final class UserRouteInfo {
        public static void setName(Object obj, CharSequence charSequence) {
            ((MediaRouter.UserRouteInfo) obj).setName(charSequence);
        }

        public static void setStatus(Object obj, CharSequence charSequence) {
            ((MediaRouter.UserRouteInfo) obj).setStatus(charSequence);
        }

        public static void setIconDrawable(Object obj, Drawable drawable) {
            ((MediaRouter.UserRouteInfo) obj).setIconDrawable(drawable);
        }

        public static void setPlaybackType(Object obj, int i) {
            ((MediaRouter.UserRouteInfo) obj).setPlaybackType(i);
        }

        public static void setPlaybackStream(Object obj, int i) {
            ((MediaRouter.UserRouteInfo) obj).setPlaybackStream(i);
        }

        public static void setVolume(Object obj, int i) {
            ((MediaRouter.UserRouteInfo) obj).setVolume(i);
        }

        public static void setVolumeMax(Object obj, int i) {
            ((MediaRouter.UserRouteInfo) obj).setVolumeMax(i);
        }

        public static void setVolumeHandling(Object obj, int i) {
            ((MediaRouter.UserRouteInfo) obj).setVolumeHandling(i);
        }

        public static void setVolumeCallback(Object obj, Object obj2) {
            ((MediaRouter.UserRouteInfo) obj).setVolumeCallback((MediaRouter.VolumeCallback) obj2);
        }

        public static void setRemoteControlClient(Object obj, Object obj2) {
            ((MediaRouter.UserRouteInfo) obj).setRemoteControlClient((RemoteControlClient) obj2);
        }

        private UserRouteInfo() {
        }
    }

    /* loaded from: classes.dex */
    public static final class RouteCategory {
        public static CharSequence getName(Object obj, Context context) {
            return ((MediaRouter.RouteCategory) obj).getName(context);
        }

        public static List getRoutes(Object obj) {
            ArrayList arrayList = new ArrayList();
            ((MediaRouter.RouteCategory) obj).getRoutes(arrayList);
            return arrayList;
        }

        public static int getSupportedTypes(Object obj) {
            return ((MediaRouter.RouteCategory) obj).getSupportedTypes();
        }

        public static boolean isGroupable(Object obj) {
            return ((MediaRouter.RouteCategory) obj).isGroupable();
        }

        private RouteCategory() {
        }
    }

    /* loaded from: classes.dex */
    public static final class SelectRouteWorkaround {
        private Method mSelectRouteIntMethod;

        public SelectRouteWorkaround() {
            if (Build.VERSION.SDK_INT < 16 || Build.VERSION.SDK_INT > 17) {
                throw new UnsupportedOperationException();
            }
            try {
                this.mSelectRouteIntMethod = android.media.MediaRouter.class.getMethod("selectRouteInt", Integer.TYPE, MediaRouter.RouteInfo.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        public void selectRoute(Object obj, int i, Object obj2) {
            android.media.MediaRouter mediaRouter = (android.media.MediaRouter) obj;
            MediaRouter.RouteInfo routeInfo = (MediaRouter.RouteInfo) obj2;
            if ((routeInfo.getSupportedTypes() & 8388608) == 0) {
                Method method = this.mSelectRouteIntMethod;
                if (method != null) {
                    try {
                        method.invoke(mediaRouter, Integer.valueOf(i), routeInfo);
                        return;
                    } catch (IllegalAccessException e) {
                        Log.w(MediaRouterJellybean.TAG, "Cannot programmatically select non-user route.  Media routing may not work.", e);
                    } catch (InvocationTargetException e2) {
                        Log.w(MediaRouterJellybean.TAG, "Cannot programmatically select non-user route.  Media routing may not work.", e2);
                    }
                } else {
                    Log.w(MediaRouterJellybean.TAG, "Cannot programmatically select non-user route because the platform is missing the selectRouteInt() method.  Media routing may not work.");
                }
            }
            mediaRouter.selectRoute(i, routeInfo);
        }
    }

    /* loaded from: classes.dex */
    public static final class GetDefaultRouteWorkaround {
        private Method mGetSystemAudioRouteMethod;

        public GetDefaultRouteWorkaround() {
            if (Build.VERSION.SDK_INT < 16 || Build.VERSION.SDK_INT > 17) {
                throw new UnsupportedOperationException();
            }
            try {
                this.mGetSystemAudioRouteMethod = android.media.MediaRouter.class.getMethod("getSystemAudioRoute", new Class[0]);
            } catch (NoSuchMethodException unused) {
            }
        }

        public Object getDefaultRoute(Object obj) {
            android.media.MediaRouter mediaRouter = (android.media.MediaRouter) obj;
            Method method = this.mGetSystemAudioRouteMethod;
            if (method != null) {
                try {
                    return method.invoke(mediaRouter, new Object[0]);
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
            return mediaRouter.getRouteAt(0);
        }
    }

    /* loaded from: classes.dex */
    static class CallbackProxy<T extends Callback> extends MediaRouter.Callback {
        protected final T mCallback;

        public CallbackProxy(T t) {
            this.mCallback = t;
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteSelected(android.media.MediaRouter mediaRouter, int i, MediaRouter.RouteInfo routeInfo) {
            this.mCallback.onRouteSelected(i, routeInfo);
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteUnselected(android.media.MediaRouter mediaRouter, int i, MediaRouter.RouteInfo routeInfo) {
            this.mCallback.onRouteUnselected(i, routeInfo);
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteAdded(android.media.MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            this.mCallback.onRouteAdded(routeInfo);
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteRemoved(android.media.MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            this.mCallback.onRouteRemoved(routeInfo);
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteChanged(android.media.MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            this.mCallback.onRouteChanged(routeInfo);
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteGrouped(android.media.MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, MediaRouter.RouteGroup routeGroup, int i) {
            this.mCallback.onRouteGrouped(routeInfo, routeGroup, i);
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteUngrouped(android.media.MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, MediaRouter.RouteGroup routeGroup) {
            this.mCallback.onRouteUngrouped(routeInfo, routeGroup);
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteVolumeChanged(android.media.MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            this.mCallback.onRouteVolumeChanged(routeInfo);
        }
    }

    /* loaded from: classes.dex */
    static class VolumeCallbackProxy<T extends VolumeCallback> extends MediaRouter.VolumeCallback {
        protected final T mCallback;

        public VolumeCallbackProxy(T t) {
            this.mCallback = t;
        }

        @Override // android.media.MediaRouter.VolumeCallback
        public void onVolumeSetRequest(MediaRouter.RouteInfo routeInfo, int i) {
            this.mCallback.onVolumeSetRequest(routeInfo, i);
        }

        @Override // android.media.MediaRouter.VolumeCallback
        public void onVolumeUpdateRequest(MediaRouter.RouteInfo routeInfo, int i) {
            this.mCallback.onVolumeUpdateRequest(routeInfo, i);
        }
    }

    private MediaRouterJellybean() {
    }
}
