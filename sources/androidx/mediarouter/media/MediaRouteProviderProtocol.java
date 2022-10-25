package androidx.mediarouter.media;

import android.os.Messenger;

/* loaded from: classes.dex */
abstract class MediaRouteProviderProtocol {
    public static final String CLIENT_DATA_MEMBER_ROUTE_ID = "memberRouteId";
    public static final String CLIENT_DATA_MEMBER_ROUTE_IDS = "memberRouteIds";
    public static final String CLIENT_DATA_ROUTE_ID = "routeId";
    public static final String CLIENT_DATA_ROUTE_LIBRARY_GROUP = "routeGroupId";
    public static final String CLIENT_DATA_UNSELECT_REASON = "unselectReason";
    public static final String CLIENT_DATA_VOLUME = "volume";
    public static final int CLIENT_MSG_ADD_MEMBER_ROUTE = 12;
    public static final int CLIENT_MSG_CREATE_DYNAMIC_GROUP_ROUTE_CONTROLLER = 11;
    public static final int CLIENT_MSG_CREATE_ROUTE_CONTROLLER = 3;
    public static final int CLIENT_MSG_REGISTER = 1;
    public static final int CLIENT_MSG_RELEASE_ROUTE_CONTROLLER = 4;
    public static final int CLIENT_MSG_REMOVE_MEMBER_ROUTE = 13;
    public static final int CLIENT_MSG_ROUTE_CONTROL_REQUEST = 9;
    public static final int CLIENT_MSG_SELECT_ROUTE = 5;
    public static final int CLIENT_MSG_SET_DISCOVERY_REQUEST = 10;
    public static final int CLIENT_MSG_SET_ROUTE_VOLUME = 7;
    public static final int CLIENT_MSG_UNREGISTER = 2;
    public static final int CLIENT_MSG_UNSELECT_ROUTE = 6;
    public static final int CLIENT_MSG_UPDATE_MEMBER_ROUTES = 14;
    public static final int CLIENT_MSG_UPDATE_ROUTE_VOLUME = 8;
    public static final int CLIENT_VERSION_1 = 1;
    public static final int CLIENT_VERSION_2 = 2;
    public static final int CLIENT_VERSION_3 = 3;
    public static final int CLIENT_VERSION_4 = 4;
    public static final int CLIENT_VERSION_CURRENT = 4;
    static final int CLIENT_VERSION_START = 1;
    public static final String DATA_KEY_DYNAMIC_ROUTE_DESCRIPTORS = "dynamicRoutes";
    public static final String DATA_KEY_GROUPABLE_SECION_TITLE = "groupableTitle";
    public static final String DATA_KEY_GROUP_ROUTE_DESCRIPTOR = "groupRoute";
    public static final String DATA_KEY_TRANSFERABLE_SECTION_TITLE = "transferableTitle";
    public static final String SERVICE_DATA_ERROR = "error";
    public static final String SERVICE_INTERFACE = "android.media.MediaRouteProviderService";
    public static final int SERVICE_MSG_CONTROLLER_RELEASED = 8;
    public static final int SERVICE_MSG_CONTROL_REQUEST_FAILED = 4;
    public static final int SERVICE_MSG_CONTROL_REQUEST_SUCCEEDED = 3;
    public static final int SERVICE_MSG_DESCRIPTOR_CHANGED = 5;
    public static final int SERVICE_MSG_DYNAMIC_ROUTE_CREATED = 6;
    public static final int SERVICE_MSG_DYNAMIC_ROUTE_DESCRIPTORS_CHANGED = 7;
    public static final int SERVICE_MSG_GENERIC_FAILURE = 0;
    public static final int SERVICE_MSG_GENERIC_SUCCESS = 1;
    public static final int SERVICE_MSG_REGISTERED = 2;
    public static final int SERVICE_VERSION_1 = 1;
    public static final int SERVICE_VERSION_2 = 2;
    public static final int SERVICE_VERSION_3 = 3;
    public static final int SERVICE_VERSION_CURRENT = 3;

    public static boolean isValidRemoteMessenger(Messenger messenger) {
        if (messenger != null) {
            try {
                return messenger.getBinder() != null;
            } catch (NullPointerException unused) {
                return false;
            }
        }
        return false;
    }

    private MediaRouteProviderProtocol() {
    }
}
