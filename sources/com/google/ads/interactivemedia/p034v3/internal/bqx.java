package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bqx */
/* loaded from: classes2.dex */
public enum bqx implements bnf {
    ST_NOT_SPECIFIED(0),
    ST_NOT_REQUIRED(999),
    ST_PSEUDONYMOUS_ID(1000),
    ST_ZWIEBACK_ID(1001),
    ST_PREF_ID(1002),
    ST_BISCOTTI_ID(1003),
    ST_ANALYTICS_ID(1004),
    ST_MANDELBREAD_ID(1005),
    ST_ANDROID_LOGGING_ID2(1006),
    ST_ACSA_ID(1007),
    ST_HERREVAD_ID(1008),
    ST_YOUTUBE_VISITOR_ID(1009),
    ST_IDENTIFYING_ID(1100),
    ST_EMAIL_ID(1102),
    ST_NAME(1103),
    ST_PHONE_NUMBER(1104),
    ST_GAIA_ID(1105),
    ST_USERNAME(1106),
    ST_GSERVICES_ANDROID_ID(1107),
    ST_ARES_ID(1108),
    ST_MEDICAL_RECORD_NUMBER(1109),
    ST_PAYMENTS_RISK_DATA(1110),
    ST_CLOUD_PROJECT_ID(1111),
    ST_CLOUD_PRINCIPAL_ID(1112),
    ST_SPII_ID(1200),
    ST_GOVERNMENT_ID_NUMBER(1201),
    ST_HEALTHCARE_INFO(1203),
    ST_SENSITIVE_BACKGROUND_INFO(1204),
    ST_RACE_ETHNICITY(1205),
    ST_POLITICAL_BELIEFS(1206),
    ST_RELIGIOUS_BELIEFS(1207),
    ST_GENDER_IDENTITY(1208),
    ST_CARDHOLDER_DATA(1202),
    ST_CHD_PAN(1211),
    ST_CHD_INFO(1212),
    ST_PAYMENTS_INFO(1220),
    ST_CRITICAL_PAYMENT_INFO(1221),
    ST_PAYMENT_ID(1222),
    ST_LIMITED_USE_PAYMENTS_INFO(1223),
    ST_PAYMENTS_INFERRED_REAL_IDENTITY(1224),
    ST_PAYMENTS_TRANSACTION_INFO(1240),
    ST_NETWORK_ENDPOINT(1300),
    ST_IP_ADDRESS(1301),
    ST_HARDWARE_ID(1400),
    ST_ANDROID_LOGGING_ID(1401),
    ST_SOFTWARE_ID(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED),
    ST_USER_AGENT(1501),
    ST_ANONYMOUS_DATA(1600),
    ST_DEMOGRAPHIC_INFO(1601),
    ST_LOCATION(1700),
    ST_PRECISE_LOCATION(1701),
    ST_COARSE_LOCATION(1702),
    ST_GOOGLE_RELATIONSHIP_ID(1800),
    ST_CUSTOMER_ID(1801),
    ST_PARTNER_ID(1802),
    ST_PUBLISHER_ID(1803),
    ST_RTB_CUSTOMER_DATA(1804),
    ST_CLOUD_PROJECT_NUMBER(1805),
    ST_USER_CONTENT(1900),
    ST_USER_QUERY(1901),
    ST_AUDIO(1902),
    ST_MUSIC(1903),
    ST_THIRD_PARTY_DATA(2000),
    ST_TIMESTAMP(2100),
    ST_SENSITIVE_TIMESTAMP(RemoteMediaPlayer.STATUS_CANCELED),
    ST_SESSION_ID(2300),
    ST_EXPERIMENT_ID(2301),
    ST_PERSONAL_DATA(2400),
    ST_CREDIT_INFO(2401),
    ST_EMAIL_CONTENT(2402),
    ST_CALENDAR_CONTENT(2403),
    ST_CONTACT_CONTENT(2404),
    ST_USER_MESSAGE(2405),
    ST_BODY_SENSOR_DATA(2406),
    ST_VOICE(2407),
    ST_AVOCADO_ID(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS),
    ST_SECURITY_MATERIAL(2600),
    ST_SECURITY_KEY(2601),
    ST_ACCOUNT_CREDENTIAL(2602),
    ST_PAYMENTS_PCI_SAD(2603),
    ST_CONTENT_DEPENDENT(9900),
    ST_DEBUG_INFO(9901),
    ST_KEY_VALUE_PAIR(9902),
    ST_KEY(9903),
    ST_VALUE(9904),
    ST_REFERER_URL(9905);
    

    /* renamed from: aI */
    private static final bng f6755aI = new bqv(0);

    /* renamed from: aK */
    private final int f6808aK;

    bqx(int i) {
        this.f6808aK = i;
    }

    /* renamed from: a */
    public static bng m2741a() {
        return f6755aI;
    }

    /* renamed from: b */
    public static bnh m2740b() {
        return bqw.f6717a;
    }

    /* renamed from: c */
    public static bqx m2739c(int i) {
        if (i != 0) {
            if (i != 1211) {
                if (i != 1212) {
                    if (i != 1300) {
                        if (i != 1301) {
                            if (i != 1400) {
                                if (i != 1401) {
                                    if (i != 1500) {
                                        if (i != 1501) {
                                            if (i != 1600) {
                                                if (i != 1601) {
                                                    switch (i) {
                                                        case 0:
                                                            break;
                                                        case 999:
                                                            return ST_NOT_REQUIRED;
                                                        case 1000:
                                                            return ST_PSEUDONYMOUS_ID;
                                                        case 1001:
                                                            return ST_ZWIEBACK_ID;
                                                        case 1002:
                                                            return ST_PREF_ID;
                                                        case 1003:
                                                            return ST_BISCOTTI_ID;
                                                        case 1004:
                                                            return ST_ANALYTICS_ID;
                                                        case 1005:
                                                            return ST_MANDELBREAD_ID;
                                                        case 1006:
                                                            return ST_ANDROID_LOGGING_ID2;
                                                        case 1007:
                                                            return ST_ACSA_ID;
                                                        case 1008:
                                                            return ST_HERREVAD_ID;
                                                        case 1009:
                                                            return ST_YOUTUBE_VISITOR_ID;
                                                        case 1100:
                                                            return ST_IDENTIFYING_ID;
                                                        case 1240:
                                                            return ST_PAYMENTS_TRANSACTION_INFO;
                                                        case 1800:
                                                            return ST_GOOGLE_RELATIONSHIP_ID;
                                                        case 1801:
                                                            return ST_CUSTOMER_ID;
                                                        case 1802:
                                                            return ST_PARTNER_ID;
                                                        case 1803:
                                                            return ST_PUBLISHER_ID;
                                                        case 1804:
                                                            return ST_RTB_CUSTOMER_DATA;
                                                        case 1805:
                                                            return ST_CLOUD_PROJECT_NUMBER;
                                                        case 1900:
                                                            return ST_USER_CONTENT;
                                                        case 1901:
                                                            return ST_USER_QUERY;
                                                        case 1902:
                                                            return ST_AUDIO;
                                                        case 1903:
                                                            return ST_MUSIC;
                                                        case 2000:
                                                            return ST_THIRD_PARTY_DATA;
                                                        case 2100:
                                                            return ST_TIMESTAMP;
                                                        case RemoteMediaPlayer.STATUS_CANCELED /* 2101 */:
                                                            return ST_SENSITIVE_TIMESTAMP;
                                                        case 2300:
                                                            return ST_SESSION_ID;
                                                        case 2301:
                                                            return ST_EXPERIMENT_ID;
                                                        case 2400:
                                                            return ST_PERSONAL_DATA;
                                                        case 2401:
                                                            return ST_CREDIT_INFO;
                                                        case 2402:
                                                            return ST_EMAIL_CONTENT;
                                                        case 2403:
                                                            return ST_CALENDAR_CONTENT;
                                                        case 2404:
                                                            return ST_CONTACT_CONTENT;
                                                        case 2405:
                                                            return ST_USER_MESSAGE;
                                                        case 2406:
                                                            return ST_BODY_SENSOR_DATA;
                                                        case 2407:
                                                            return ST_VOICE;
                                                        case DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS /* 2500 */:
                                                            return ST_AVOCADO_ID;
                                                        case 2600:
                                                            return ST_SECURITY_MATERIAL;
                                                        case 2601:
                                                            return ST_SECURITY_KEY;
                                                        case 2602:
                                                            return ST_ACCOUNT_CREDENTIAL;
                                                        case 2603:
                                                            return ST_PAYMENTS_PCI_SAD;
                                                        case 9900:
                                                            return ST_CONTENT_DEPENDENT;
                                                        case 9901:
                                                            return ST_DEBUG_INFO;
                                                        case 9902:
                                                            return ST_KEY_VALUE_PAIR;
                                                        case 9903:
                                                            return ST_KEY;
                                                        case 9904:
                                                            return ST_VALUE;
                                                        case 9905:
                                                            return ST_REFERER_URL;
                                                        default:
                                                            switch (i) {
                                                                case 1102:
                                                                    return ST_EMAIL_ID;
                                                                case 1103:
                                                                    return ST_NAME;
                                                                case 1104:
                                                                    return ST_PHONE_NUMBER;
                                                                case 1105:
                                                                    return ST_GAIA_ID;
                                                                case 1106:
                                                                    return ST_USERNAME;
                                                                case 1107:
                                                                    return ST_GSERVICES_ANDROID_ID;
                                                                case 1108:
                                                                    return ST_ARES_ID;
                                                                case 1109:
                                                                    return ST_MEDICAL_RECORD_NUMBER;
                                                                case 1110:
                                                                    return ST_PAYMENTS_RISK_DATA;
                                                                case 1111:
                                                                    return ST_CLOUD_PROJECT_ID;
                                                                case 1112:
                                                                    return ST_CLOUD_PRINCIPAL_ID;
                                                                default:
                                                                    switch (i) {
                                                                        case 1200:
                                                                            return ST_SPII_ID;
                                                                        case 1201:
                                                                            return ST_GOVERNMENT_ID_NUMBER;
                                                                        case 1202:
                                                                            return ST_CARDHOLDER_DATA;
                                                                        case 1203:
                                                                            return ST_HEALTHCARE_INFO;
                                                                        case 1204:
                                                                            return ST_SENSITIVE_BACKGROUND_INFO;
                                                                        case 1205:
                                                                            return ST_RACE_ETHNICITY;
                                                                        case 1206:
                                                                            return ST_POLITICAL_BELIEFS;
                                                                        case 1207:
                                                                            return ST_RELIGIOUS_BELIEFS;
                                                                        case 1208:
                                                                            return ST_GENDER_IDENTITY;
                                                                        default:
                                                                            switch (i) {
                                                                                case 1220:
                                                                                    return ST_PAYMENTS_INFO;
                                                                                case 1221:
                                                                                    return ST_CRITICAL_PAYMENT_INFO;
                                                                                case 1222:
                                                                                    return ST_PAYMENT_ID;
                                                                                case 1223:
                                                                                    return ST_LIMITED_USE_PAYMENTS_INFO;
                                                                                case 1224:
                                                                                    return ST_PAYMENTS_INFERRED_REAL_IDENTITY;
                                                                                default:
                                                                                    switch (i) {
                                                                                        case 1700:
                                                                                            return ST_LOCATION;
                                                                                        case 1701:
                                                                                            return ST_PRECISE_LOCATION;
                                                                                        case 1702:
                                                                                            return ST_COARSE_LOCATION;
                                                                                        default:
                                                                                            return null;
                                                                                    }
                                                                            }
                                                                    }
                                                            }
                                                    }
                                                } else {
                                                    return ST_DEMOGRAPHIC_INFO;
                                                }
                                            } else {
                                                return ST_ANONYMOUS_DATA;
                                            }
                                        } else {
                                            return ST_USER_AGENT;
                                        }
                                    } else {
                                        return ST_SOFTWARE_ID;
                                    }
                                } else {
                                    return ST_ANDROID_LOGGING_ID;
                                }
                            } else {
                                return ST_HARDWARE_ID;
                            }
                        } else {
                            return ST_IP_ADDRESS;
                        }
                    } else {
                        return ST_NETWORK_ENDPOINT;
                    }
                } else {
                    return ST_CHD_INFO;
                }
            } else {
                return ST_CHD_PAN;
            }
        }
        return ST_NOT_SPECIFIED;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bnf
    public final int getNumber() {
        return this.f6808aK;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f6808aK);
    }
}
