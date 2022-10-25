package com.facebook.internal;

import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppGateKeepersManager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class FeatureManager {
    private static final String FEATURE_MANAGER_STORE = "com.facebook.internal.FEATURE_MANAGER";
    private static final Map<Feature, String[]> featureMapping = new HashMap();

    /* loaded from: classes.dex */
    public interface Callback {
        void onCompleted(boolean z);
    }

    public static void checkFeature(final Feature feature, final Callback callback) {
        FetchedAppGateKeepersManager.loadAppGateKeepersAsync(new FetchedAppGateKeepersManager.Callback() { // from class: com.facebook.internal.FeatureManager.1
            @Override // com.facebook.internal.FetchedAppGateKeepersManager.Callback
            public void onCompleted() {
                Callback.this.onCompleted(FeatureManager.isEnabled(feature));
            }
        });
    }

    public static boolean isEnabled(Feature feature) {
        if (Feature.Unknown == feature) {
            return false;
        }
        if (Feature.Core == feature) {
            return true;
        }
        String string = FacebookSdk.getApplicationContext().getSharedPreferences(FEATURE_MANAGER_STORE, 0).getString(feature.toKey(), null);
        if (string == null || !string.equals(FacebookSdk.getSdkVersion())) {
            Feature parent = feature.getParent();
            if (parent == feature) {
                return getGKStatus(feature);
            }
            return isEnabled(parent) && getGKStatus(feature);
        }
        return false;
    }

    public static void disableFeature(Feature feature) {
        FacebookSdk.getApplicationContext().getSharedPreferences(FEATURE_MANAGER_STORE, 0).edit().putString(feature.toKey(), FacebookSdk.getSdkVersion()).apply();
    }

    public static Feature getFeature(String str) {
        initializeFeatureMapping();
        for (Map.Entry<Feature, String[]> entry : featureMapping.entrySet()) {
            for (String str2 : entry.getValue()) {
                if (str.startsWith(str2)) {
                    return entry.getKey();
                }
            }
        }
        return Feature.Unknown;
    }

    private static synchronized void initializeFeatureMapping() {
        synchronized (FeatureManager.class) {
            Map<Feature, String[]> map = featureMapping;
            if (map.isEmpty()) {
                map.put(Feature.AAM, new String[]{"com.facebook.appevents.aam."});
                map.put(Feature.CodelessEvents, new String[]{"com.facebook.appevents.codeless."});
                map.put(Feature.ErrorReport, new String[]{"com.facebook.internal.instrument.errorreport."});
                map.put(Feature.PrivacyProtection, new String[]{"com.facebook.appevents.ml."});
                map.put(Feature.SuggestedEvents, new String[]{"com.facebook.appevents.suggestedevents."});
                map.put(Feature.RestrictiveDataFiltering, new String[]{"com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager"});
                map.put(Feature.IntelligentIntegrity, new String[]{"com.facebook.appevents.integrity.IntegrityManager"});
                map.put(Feature.EventDeactivation, new String[]{"com.facebook.appevents.eventdeactivation."});
                map.put(Feature.OnDeviceEventProcessing, new String[]{"com.facebook.appevents.ondeviceprocessing."});
                map.put(Feature.Monitoring, new String[]{"com.facebook.internal.logging.monitor"});
            }
        }
    }

    private static boolean getGKStatus(Feature feature) {
        return FetchedAppGateKeepersManager.getGateKeeperForKey(feature.toKey(), FacebookSdk.getApplicationId(), defaultStatus(feature));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.facebook.internal.FeatureManager$2 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C20692 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$internal$FeatureManager$Feature;

        static {
            int[] iArr = new int[Feature.values().length];
            $SwitchMap$com$facebook$internal$FeatureManager$Feature = iArr;
            try {
                iArr[Feature.RestrictiveDataFiltering.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.Instrument.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.CrashReport.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.CrashShield.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.ThreadCheck.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.ErrorReport.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.AAM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.PrivacyProtection.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.SuggestedEvents.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.IntelligentIntegrity.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.ModelRequest.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.EventDeactivation.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.OnDeviceEventProcessing.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.OnDevicePostInstallEventProcessing.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.ChromeCustomTabsPrefetching.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.Monitoring.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.IgnoreAppSwitchToLoggedOut.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.Core.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.AppEvents.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.CodelessEvents.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.Login.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.Share.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$facebook$internal$FeatureManager$Feature[Feature.Places.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
        }
    }

    private static boolean defaultStatus(Feature feature) {
        switch (C20692.$SwitchMap$com$facebook$internal$FeatureManager$Feature[feature.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                return false;
            default:
                return true;
        }
    }

    /* loaded from: classes.dex */
    public enum Feature {
        Unknown(-1),
        Core(0),
        AppEvents(65536),
        CodelessEvents(65792),
        RestrictiveDataFiltering(66048),
        AAM(66304),
        PrivacyProtection(66560),
        SuggestedEvents(66561),
        IntelligentIntegrity(66562),
        ModelRequest(66563),
        EventDeactivation(66816),
        OnDeviceEventProcessing(67072),
        OnDevicePostInstallEventProcessing(67073),
        Instrument(131072),
        CrashReport(131328),
        CrashShield(131329),
        ThreadCheck(131330),
        ErrorReport(131584),
        Monitoring(196608),
        Login(16777216),
        ChromeCustomTabsPrefetching(16842752),
        IgnoreAppSwitchToLoggedOut(16908288),
        Share(33554432),
        Places(50331648);
        
        private final int code;

        Feature(int i) {
            this.code = i;
        }

        @Override // java.lang.Enum
        public String toString() {
            switch (C20692.$SwitchMap$com$facebook$internal$FeatureManager$Feature[ordinal()]) {
                case 1:
                    return "RestrictiveDataFiltering";
                case 2:
                    return "Instrument";
                case 3:
                    return "CrashReport";
                case 4:
                    return "CrashShield";
                case 5:
                    return "ThreadCheck";
                case 6:
                    return "ErrorReport";
                case 7:
                    return "AAM";
                case 8:
                    return "PrivacyProtection";
                case 9:
                    return "SuggestedEvents";
                case 10:
                    return "IntelligentIntegrity";
                case 11:
                    return "ModelRequest";
                case 12:
                    return "EventDeactivation";
                case 13:
                    return "OnDeviceEventProcessing";
                case 14:
                    return "OnDevicePostInstallEventProcessing";
                case 15:
                    return "ChromeCustomTabsPrefetching";
                case 16:
                    return "Monitoring";
                case 17:
                    return "IgnoreAppSwitchToLoggedOut";
                case 18:
                    return "CoreKit";
                case 19:
                    return "AppEvents";
                case 20:
                    return "CodelessEvents";
                case 21:
                    return "LoginKit";
                case 22:
                    return "ShareKit";
                case 23:
                    return "PlacesKit";
                default:
                    return "unknown";
            }
        }

        static Feature fromInt(int i) {
            Feature[] values;
            for (Feature feature : values()) {
                if (feature.code == i) {
                    return feature;
                }
            }
            return Unknown;
        }

        String toKey() {
            return "FBSDKFeature" + toString();
        }

        public Feature getParent() {
            int i = this.code;
            if ((i & 255) > 0) {
                return fromInt(i & InputDeviceCompat.SOURCE_ANY);
            }
            if ((65280 & i) > 0) {
                return fromInt(i & SupportMenu.CATEGORY_MASK);
            }
            if ((16711680 & i) > 0) {
                return fromInt(i & ViewCompat.MEASURED_STATE_MASK);
            }
            return fromInt(0);
        }
    }
}
