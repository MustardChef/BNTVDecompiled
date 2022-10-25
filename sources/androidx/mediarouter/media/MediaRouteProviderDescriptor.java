package androidx.mediarouter.media;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class MediaRouteProviderDescriptor {
    private static final String KEY_ROUTES = "routes";
    private static final String KEY_SUPPORTS_DYNAMIC_GROUP_ROUTE = "supportsDynamicGroupRoute";
    Bundle mBundle;
    final List<MediaRouteDescriptor> mRoutes;
    final boolean mSupportsDynamicGroupRoute;

    MediaRouteProviderDescriptor(List<MediaRouteDescriptor> list, boolean z) {
        this.mRoutes = list == null ? Collections.emptyList() : list;
        this.mSupportsDynamicGroupRoute = z;
    }

    public List<MediaRouteDescriptor> getRoutes() {
        return this.mRoutes;
    }

    public boolean isValid() {
        int size = getRoutes().size();
        for (int i = 0; i < size; i++) {
            MediaRouteDescriptor mediaRouteDescriptor = this.mRoutes.get(i);
            if (mediaRouteDescriptor == null || !mediaRouteDescriptor.isValid()) {
                return false;
            }
        }
        return true;
    }

    public boolean supportsDynamicGroupRoute() {
        return this.mSupportsDynamicGroupRoute;
    }

    public String toString() {
        return "MediaRouteProviderDescriptor{ routes=" + Arrays.toString(getRoutes().toArray()) + ", isValid=" + isValid() + " }";
    }

    public Bundle asBundle() {
        Bundle bundle = this.mBundle;
        if (bundle != null) {
            return bundle;
        }
        this.mBundle = new Bundle();
        List<MediaRouteDescriptor> list = this.mRoutes;
        if (list != null && !list.isEmpty()) {
            int size = this.mRoutes.size();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                arrayList.add(this.mRoutes.get(i).asBundle());
            }
            this.mBundle.putParcelableArrayList(KEY_ROUTES, arrayList);
        }
        this.mBundle.putBoolean(KEY_SUPPORTS_DYNAMIC_GROUP_ROUTE, this.mSupportsDynamicGroupRoute);
        return this.mBundle;
    }

    public static MediaRouteProviderDescriptor fromBundle(Bundle bundle) {
        ArrayList arrayList = null;
        if (bundle == null) {
            return null;
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(KEY_ROUTES);
        if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
            int size = parcelableArrayList.size();
            ArrayList arrayList2 = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                arrayList2.add(MediaRouteDescriptor.fromBundle((Bundle) parcelableArrayList.get(i)));
            }
            arrayList = arrayList2;
        }
        return new MediaRouteProviderDescriptor(arrayList, bundle.getBoolean(KEY_SUPPORTS_DYNAMIC_GROUP_ROUTE, false));
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private List<MediaRouteDescriptor> mRoutes;
        private boolean mSupportsDynamicGroupRoute;

        public Builder() {
            this.mSupportsDynamicGroupRoute = false;
        }

        public Builder(MediaRouteProviderDescriptor mediaRouteProviderDescriptor) {
            this.mSupportsDynamicGroupRoute = false;
            if (mediaRouteProviderDescriptor == null) {
                throw new IllegalArgumentException("descriptor must not be null");
            }
            this.mRoutes = mediaRouteProviderDescriptor.mRoutes;
            this.mSupportsDynamicGroupRoute = mediaRouteProviderDescriptor.mSupportsDynamicGroupRoute;
        }

        public Builder addRoute(MediaRouteDescriptor mediaRouteDescriptor) {
            if (mediaRouteDescriptor == null) {
                throw new IllegalArgumentException("route must not be null");
            }
            List<MediaRouteDescriptor> list = this.mRoutes;
            if (list == null) {
                this.mRoutes = new ArrayList();
            } else if (list.contains(mediaRouteDescriptor)) {
                throw new IllegalArgumentException("route descriptor already added");
            }
            this.mRoutes.add(mediaRouteDescriptor);
            return this;
        }

        public Builder addRoutes(Collection<MediaRouteDescriptor> collection) {
            if (collection == null) {
                throw new IllegalArgumentException("routes must not be null");
            }
            if (!collection.isEmpty()) {
                for (MediaRouteDescriptor mediaRouteDescriptor : collection) {
                    addRoute(mediaRouteDescriptor);
                }
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder setRoutes(Collection<MediaRouteDescriptor> collection) {
            if (collection == null || collection.isEmpty()) {
                this.mRoutes = null;
            } else {
                this.mRoutes = new ArrayList(collection);
            }
            return this;
        }

        public Builder setSupportsDynamicGroupRoute(boolean z) {
            this.mSupportsDynamicGroupRoute = z;
            return this;
        }

        public MediaRouteProviderDescriptor build() {
            return new MediaRouteProviderDescriptor(this.mRoutes, this.mSupportsDynamicGroupRoute);
        }
    }
}
